package com.tencent.qqmini.sdk.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.luggage.wxa.ig.q;
import com.tencent.qqmini.miniapp.plugin.EmbeddedVideoJsPlugin;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.CmdProxy;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.MD5Utils;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.plugins.SensorJsPlugin;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniLog {
    private static final int LOG_WRITER_BUFFER_SIZE = 8192;
    public static final int MAX_MINI_LOG_NUM = 5;
    private static final long MAX_MINI_LOG_SIZE = 1048576;
    public static final String MINI_LOG_TAG = "log";
    private static final String TAG = "MiniLog";
    private static final int WRITE_MINI_LOG_MSG = 2;
    private static final int WRITE_NATIVE_LOG_MSG = 1;
    private static volatile WriteHandler mWriteHandler;
    private static LinkedBlockingQueue<MiniItem> miniQueue = new LinkedBlockingQueue<>(256);
    private static LruCache<String, Integer> mLastNumCache = new LruCache<>(5);
    private static long lastCheckLogSizeTime = 0;
    private static final List<String> HIGH_FREQUENCY_EVENT_LOG = Arrays.asList("custom_event_vdSync", "custom_event_responseComponentInfo", "custom_event_vdSyncBatch", EmbeddedVideoJsPlugin.VIDEO_EVENT_TIME_UPDATE, "custom_event_responseComponentObserver", SensorJsPlugin.EVENT_ACCELEROMETER_STATE_CHANGE);
    private static final List<String> HIGH_FREQUENCY_KEY_WORD = Arrays.asList(q.NAME, "yinge.cc/resource/", "Register Page", "cmd_dc_report_log_key_data");

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class MiniItem {
        public String filePath;

        /* renamed from: msg, reason: collision with root package name */
        public String f348358msg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class WriteHandler extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 2 && !MiniLog.miniQueue.isEmpty()) {
                ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.utils.MiniLog.WriteHandler.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniLog.writeMiniLogToFile();
                    }
                });
            }
        }

        WriteHandler(Looper looper) {
            super(looper);
        }
    }

    private static void addMiniLogItem(String str, String str2) {
        MiniItem miniItem = new MiniItem();
        miniItem.f348358msg = str2;
        miniItem.filePath = str;
        initWriteHandler();
        if (miniQueue.offer(miniItem)) {
            mWriteHandler.removeMessages(2);
            mWriteHandler.sendEmptyMessageDelayed(2, 1000L);
        }
    }

    public static void consoleLog(MiniAppInfo miniAppInfo, String str) {
        CmdProxy cmdProxy;
        if (miniAppInfo == null || miniAppInfo.verType == 3 || (cmdProxy = (CmdProxy) AppLoaderFactory.g().getProxyManager().get(CmdProxy.class)) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(IPCConst.KEY_CONSOLE_LOG_MSG, str);
        cmdProxy.handleMiniAppCmd(IPCConst.CMD_CONSOLE_LOG, bundle, null);
    }

    private static Integer getLastLogNum(String str, Integer num, File file) {
        if (num == null) {
            Integer num2 = 1;
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        String name = file2.getName();
                        if (name.contains("log")) {
                            String substring = name.substring(name.lastIndexOf("log") + 1);
                            if (isInteger(substring) && Integer.valueOf(substring).intValue() > num2.intValue()) {
                                num2 = Integer.valueOf(substring);
                            }
                        }
                    }
                }
            } catch (Exception e16) {
                QMLog.e(TAG, str, e16);
            }
            return num2;
        }
        return num;
    }

    public static String getMiniLogFolderPath(String str) {
        return MiniSDKConst.getMiniCacheFilePath() + MD5Utils.toMD5(str) + "/" + LoginManager.getInstance().getAccount() + "/miniprogramLog/";
    }

    private static String getMiniLogPath(String str) {
        String miniLogFolderPath = getMiniLogFolderPath(str);
        Integer num = mLastNumCache.get(str);
        File file = new File(miniLogFolderPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        Integer lastLogNum = getLastLogNum(str, num, file);
        if (System.currentTimeMillis() - lastCheckLogSizeTime > 60000) {
            lastCheckLogSizeTime = System.currentTimeMillis();
            try {
                if (FileUtils.createFile(miniLogFolderPath + "log" + lastLogNum).length() > 1048576) {
                    if (lastLogNum.intValue() < 5) {
                        lastLogNum = Integer.valueOf(lastLogNum.intValue() + 1);
                    } else {
                        new File(miniLogFolderPath + "log1").delete();
                        lastLogNum = 1;
                        for (int i3 = 2; i3 <= 5; i3++) {
                            File file2 = new File(miniLogFolderPath + "log" + i3);
                            if (file2.exists()) {
                                QMLog.i(TAG, "rename from file:log" + i3 + " to file:" + lastLogNum);
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(miniLogFolderPath);
                                sb5.append("log");
                                Integer valueOf = Integer.valueOf(lastLogNum.intValue() + 1);
                                try {
                                    sb5.append(lastLogNum);
                                    file2.renameTo(new File(sb5.toString()));
                                    lastLogNum = valueOf;
                                } catch (Exception e16) {
                                    e = e16;
                                    lastLogNum = valueOf;
                                    e.printStackTrace();
                                    mLastNumCache.put(str, lastLogNum);
                                    return miniLogFolderPath + "log" + lastLogNum;
                                }
                            }
                        }
                    }
                }
            } catch (Exception e17) {
                e = e17;
            }
        }
        mLastNumCache.put(str, lastLogNum);
        return miniLogFolderPath + "log" + lastLogNum;
    }

    private static void initWriteHandler() {
        if (mWriteHandler == null) {
            synchronized (MiniLog.class) {
                if (mWriteHandler == null) {
                    mWriteHandler = new WriteHandler(ThreadManager.getSubThreadHandler().getLooper());
                }
            }
        }
    }

    public static boolean isHighFrequencyEventLog(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return HIGH_FREQUENCY_EVENT_LOG.contains(str);
    }

    private static boolean isInteger(String str) {
        return Pattern.compile("^[-\\+]?[\\d]*$").matcher(str).matches();
    }

    public static boolean isLogStringContainerHighFrequencyEvent(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = HIGH_FREQUENCY_KEY_WORD.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    private static void miniFlushAndClean(Map<String, BufferedWriter> map) {
        for (BufferedWriter bufferedWriter : map.values()) {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.flush();
                    bufferedWriter.close();
                } catch (Exception e16) {
                    QMLog.e(TAG, "miniFlushAndClean: failed", e16);
                }
            }
        }
        map.clear();
    }

    public static void writeMiniLog(String str, String str2) {
        addMiniLogItem(getMiniLogPath(str), str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void writeMiniLogToFile() {
        synchronized (MiniLog.class) {
            HashMap hashMap = new HashMap();
            while (!miniQueue.isEmpty()) {
                try {
                    MiniItem poll = miniQueue.poll();
                    if (poll != null && !TextUtils.isEmpty(poll.filePath)) {
                        String str = poll.filePath;
                        File file = new File(str);
                        if (!file.exists()) {
                            FileUtils.createFile(str);
                        }
                        BufferedWriter bufferedWriter = (BufferedWriter) hashMap.get(str);
                        if (bufferedWriter == null) {
                            bufferedWriter = new BufferedWriter(new MiniLogWriter(file, true), 8192);
                            hashMap.put(str, bufferedWriter);
                        }
                        bufferedWriter.write(poll.f348358msg);
                    }
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }
    }

    public static String getMiniLogFolderPath() {
        return MiniSDKConst.getMiniCacheFilePath();
    }
}
