package com.tencent.mobileqq.mini.appbrand.utils;

import Wallet.GetMiniAppReq;
import Wallet.GetMiniAppRsp;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.network.http.HttpCallBack;
import com.tencent.mobileqq.mini.network.http.MiniappHttpUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import mqq.observer.BusinessObserver;
import org.apache.http.client.methods.HttpPut;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniLogManager {
    private static final int LEVEL_COMPRESS_LOG = 9;
    private static final int LOG_SAVE_DAY = 1;
    private static final int MSG_COMPRESS_LOG = 4;
    private static String TAG = "MiniLogManager";
    private static final long TIME_ONE_HOUR = 3600000;
    private static final long TIME_ONE_MINUTE = 60000;
    private static long sLastCheckLogTime;
    private static Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 4) {
                return;
            }
            if (MiniLogManager.sLastCheckLogTime <= 0 || SystemClock.elapsedRealtime() - MiniLogManager.sLastCheckLogTime >= 3600000) {
                MiniLogManager.sLastCheckLogTime = SystemClock.elapsedRealtime();
                if (QLog.isColorLevel()) {
                    QLog.d(MiniLogManager.TAG, 1, "clean and compress log");
                }
                MiniLogManager.compressAndDeleteOldLog();
            }
        }
    };
    private static final BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (StringUtil.isEmpty(action)) {
                return;
            }
            if (action.equals(IECScreenReceiver.ACTION_SCREEN_OFF)) {
                MiniLogManager.mHandler.removeMessages(4);
                MiniLogManager.mHandler.sendEmptyMessageDelayed(4, 60000L);
            } else if (action.equals(IECScreenReceiver.ACTION_SCREEN_ON)) {
                MiniLogManager.mHandler.removeMessages(4);
            }
        }
    };
    private static boolean isInited = false;
    private static Comparator<File> fileTimeComparator = new Comparator<File>() { // from class: com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.4
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return file.lastModified() > file2.lastModified() ? 1 : 0;
        }
    };
    private static SimpleDateFormat logFileFormatter = new SimpleDateFormat("yy.MM.dd.HH");
    private static SimpleDateFormat timeFormatter = new SimpleDateFormat("yy-MM-dd HH_mm_ss");

    public static void compressAndDeleteOldLog() {
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.3
            @Override // java.lang.Runnable
            public void run() {
                File[] listFiles;
                try {
                    File file = new File(MiniLog.getMiniLogFolderPath());
                    if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                        for (File file2 : listFiles) {
                            File[] listFiles2 = file2.listFiles();
                            if (listFiles2 != null && listFiles2.length != 0) {
                                for (File file3 : listFiles2) {
                                    File[] listFiles3 = file3.listFiles();
                                    if (listFiles3 != null && listFiles3.length != 0) {
                                        Arrays.sort(listFiles3, MiniLogManager.fileTimeComparator);
                                        long i3 = MiniLogManager.i();
                                        String h16 = MiniLogManager.h();
                                        for (File file4 : listFiles3) {
                                            if (!file4.getName().contains("log")) {
                                                if (i3 <= file4.lastModified() && file4.lastModified() <= System.currentTimeMillis() + 3600000) {
                                                    if (file4.getName().endsWith(".log") && ((file4.lastModified() < System.currentTimeMillis() - 3600000 || file4.getName().contains(h16)) && MiniLogManager.zipLogFile(file4))) {
                                                        file4.delete();
                                                        if (QLog.isColorLevel()) {
                                                            QLog.d(MiniLogManager.TAG, 2, "compress log success " + file4.getName());
                                                        }
                                                    }
                                                }
                                                file4.delete();
                                                if (QLog.isColorLevel()) {
                                                    QLog.d(MiniLogManager.TAG, 2, "del expires log " + file4.getName());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(MiniLogManager.TAG, 2, e16, new Object[0]);
                    }
                }
            }
        });
    }

    public static void compressAndUploadLog(final String str, final int i3) {
        if (StringUtil.isEmpty(str)) {
            return;
        }
        final String miniLogFolderPath = MiniLog.getMiniLogFolderPath(str);
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.5
            @Override // java.lang.Runnable
            public void run() {
                File[] listFiles = new File(miniLogFolderPath).listFiles();
                if (listFiles == null || listFiles.length <= 0) {
                    return;
                }
                long i16 = MiniLogManager.i();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (File file : listFiles) {
                    if (file.length() == 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d(MiniLogManager.TAG, 2, HippyBridge.URI_SCHEME_FILE + file.getName() + " size is 0");
                        }
                        file.delete();
                    } else {
                        String name = file.getName();
                        if (i16 < file.lastModified() && (name.endsWith(".log") || name.endsWith(".log.zip") || name.endsWith(".qlog"))) {
                            arrayList.add(new LogFile(file.getPath()));
                        }
                        if (name.contains("log") && !name.endsWith(".zip")) {
                            arrayList2.add(new LogFile(file.getPath()));
                        }
                    }
                }
                try {
                    String format = MiniLogManager.timeFormatter.format(Long.valueOf(System.currentTimeMillis()));
                    String str2 = miniLogFolderPath + "nativeLog_" + format + ".zip";
                    String str3 = miniLogFolderPath + "miniLog_" + format + ".zip";
                    if (arrayList.size() > 0) {
                        File file2 = new File(str2);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        file2.createNewFile();
                        MiniLogManager.zipFiles(arrayList, str2);
                        MiniLogManager.upload(str, str2, 4, i3);
                    }
                    if (arrayList2.size() > 0) {
                        File file3 = new File(str3);
                        if (file3.exists()) {
                            file3.delete();
                        }
                        file3.createNewFile();
                        MiniLogManager.zipFiles(arrayList2, str3);
                        MiniLogManager.upload(str, str3, 5, i3);
                    }
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.e(MiniLogManager.TAG, 1, "compressAndUploadLog error " + th5);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void doUploadFile(final String str, final String str2) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.7
            @Override // java.lang.Runnable
            public void run() {
                MiniappHttpUtil.httpUpload(HttpPut.METHOD_NAME, str, str2, null, null, null, null, new HttpCallBack() { // from class: com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.7.1
                    @Override // com.tencent.mobileqq.mini.network.http.HttpCallBack
                    public void httpCallBack(int i3, byte[] bArr, Map<String, List<String>> map) {
                        if (i3 == 200) {
                            if (QLog.isDebugVersion()) {
                                QLog.d(MiniLogManager.TAG, 2, "log upload success " + str);
                            }
                        } else if (QLog.isDebugVersion()) {
                            QLog.d(MiniLogManager.TAG, 2, "log upload failed " + str);
                        }
                        new File(str2).delete();
                    }

                    @Override // com.tencent.mobileqq.mini.network.http.HttpCallBack
                    public void headersReceived(int i3, Map<String, List<String>> map) {
                    }

                    @Override // com.tencent.mobileqq.mini.network.http.HttpCallBack
                    public void onProgressUpdate(int i3, int i16, int i17) {
                    }
                });
            }
        }, 128, null, false);
    }

    private static String getLastHourLogSuffix() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis() - 3600000);
        return logFileFormatter.format(calendar.getTime());
    }

    private static long getOneDayAgoTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(6, -1);
        return calendar.getTimeInMillis();
    }

    private static String getZipLogFilePath(File file) {
        String absolutePath = file.getAbsolutePath();
        if (absolutePath.endsWith(".log")) {
            absolutePath = absolutePath.substring(0, absolutePath.indexOf(".log"));
        }
        return absolutePath + ".qlog";
    }

    static /* bridge */ /* synthetic */ String h() {
        return getLastHourLogSuffix();
    }

    static /* bridge */ /* synthetic */ long i() {
        return getOneDayAgoTime();
    }

    public static synchronized void init() {
        synchronized (MiniLogManager.class) {
            if (!isInited) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
                intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
                BaseApplication.getContext().registerReceiver(mReceiver, intentFilter);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "MiniLogManager inited.");
                }
                isInited = true;
            }
        }
    }

    public static void upload(String str, final String str2, final int i3, int i16) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || !new File(str2).exists()) {
            return;
        }
        ((IQWalletApi) QRoute.api(IQWalletApi.class)).servletSendRequest(new GetMiniAppReq(str, i16, i3, "", BaseApplicationImpl.getApplication().getRuntime().getAccount(), "Android|" + ah.t() + "|" + ah.F(), ah.P()), new BusinessObserver() { // from class: com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager.6
            @Override // mqq.observer.BusinessObserver
            public void onReceive(int i17, boolean z16, Bundle bundle) {
                GetMiniAppRsp getMiniAppRsp = (GetMiniAppRsp) bundle.getSerializable("rsp");
                if (getMiniAppRsp != null && !StringUtil.isEmpty(getMiniAppRsp.extra)) {
                    String str3 = getMiniAppRsp.extra;
                    MiniLogManager.doUploadFile(str3, str2);
                    if (QLog.isDebugVersion()) {
                        QLog.d(MiniLogManager.TAG, 4, " action:" + i3 + " logUrl:" + str3 + " filePath:" + str2);
                        return;
                    }
                    return;
                }
                new File(str2).delete();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void zipFiles(ArrayList<LogFile> arrayList, String str) {
        String str2;
        try {
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(str)));
                ZipOutputStream zipOutputStream = new ZipOutputStream(bufferedOutputStream);
                try {
                    Iterator<LogFile> it = arrayList.iterator();
                    boolean z16 = false;
                    while (it.hasNext()) {
                        LogFile next = it.next();
                        if (next.exists()) {
                            zipOutputStream.putNextEntry(new ZipEntry(next.getName() + next.stuffix));
                            zipOutputStream.setLevel(9);
                            long length = next.length();
                            FileInputStream fileInputStream = new FileInputStream(next);
                            try {
                                byte[] bArr = new byte[20480];
                                long j3 = 0;
                                while (true) {
                                    int read = fileInputStream.read(bArr, 0, 20480);
                                    if (read == -1) {
                                        break;
                                    }
                                    zipOutputStream.write(bArr, 0, read);
                                    j3 += read;
                                    if (j3 >= length) {
                                        z16 = true;
                                        break;
                                    }
                                    z16 = true;
                                }
                                fileInputStream.close();
                                zipOutputStream.flush();
                                zipOutputStream.closeEntry();
                            } catch (Throwable th5) {
                                fileInputStream.close();
                                zipOutputStream.flush();
                                zipOutputStream.closeEntry();
                                throw th5;
                            }
                        }
                    }
                    if (z16) {
                        zipOutputStream.close();
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, " zip stream close.");
                    }
                    bufferedOutputStream.close();
                } catch (IOException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, " zip file error " + e16, e16);
                    }
                    bufferedOutputStream.close();
                    if (QLog.isColorLevel()) {
                        str2 = TAG;
                    }
                }
                if (QLog.isColorLevel()) {
                    str2 = TAG;
                    QLog.d(str2, 2, " file out stream close.");
                }
            } catch (Throwable th6) {
                str.close();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, " file out stream close.");
                }
                throw th6;
            }
        } catch (IOException e17) {
            e17.printStackTrace();
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "zip file finish");
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class LogFile extends File {
        public String stuffix;

        public LogFile(File file, String str) {
            super(file, str);
            this.stuffix = "";
        }

        public LogFile(String str) {
            super(str);
            this.stuffix = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0093 A[Catch: all -> 0x008f, TRY_LEAVE, TryCatch #8 {all -> 0x008f, blocks: (B:46:0x008b, B:39:0x0093), top: B:45:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean zipLogFile(File file) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(new File(getZipLogFilePath(file))));
            try {
                ZipOutputStream zipOutputStream = new ZipOutputStream(bufferedOutputStream2);
                zipOutputStream.setLevel(9);
                byte[] bArr = new byte[8192];
                ZipEntry zipEntry = new ZipEntry(file.getName());
                zipEntry.setSize(file.length());
                zipEntry.setTime(file.lastModified());
                zipOutputStream.putNextEntry(zipEntry);
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                while (true) {
                    try {
                        int read = bufferedInputStream.read(bArr, 0, 8192);
                        if (read != -1) {
                            zipOutputStream.write(bArr, 0, read);
                        } else {
                            zipOutputStream.close();
                            try {
                                bufferedOutputStream2.close();
                                bufferedInputStream.close();
                                return true;
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                                return true;
                            }
                        }
                    } catch (Exception e16) {
                        e = e16;
                        bufferedOutputStream = bufferedOutputStream2;
                        try {
                            e.printStackTrace();
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Throwable th6) {
                                    th6.printStackTrace();
                                    return false;
                                }
                            }
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            return false;
                        } catch (Throwable th7) {
                            th = th7;
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Throwable th8) {
                                    th8.printStackTrace();
                                    throw th;
                                }
                            }
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        throw th;
                    }
                }
            } catch (Exception e17) {
                e = e17;
                bufferedInputStream = null;
            } catch (Throwable th10) {
                th = th10;
                bufferedInputStream = null;
            }
        } catch (Exception e18) {
            e = e18;
            bufferedInputStream = null;
        } catch (Throwable th11) {
            th = th11;
            bufferedInputStream = null;
        }
    }
}
