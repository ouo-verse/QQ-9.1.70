package com.tencent.qqlive.module.videoreport.visual.debug;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.utils.ProcessUtils;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import com.tencent.qqlive.module.videoreport.visual.debug.data.PageData;
import com.tencent.qqlive.module.videoreport.visual.debug.data.ViewData;
import com.tencent.qqlive.module.videoreport.visual.debug.report.DebugEventReporter;
import com.tencent.qqlive.module.videoreport.visual.debug.util.ActivityUtil;
import com.tencent.qqlive.module.videoreport.visual.debug.util.ViewTreeScanner;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VisualDebugManager extends DefaultEventListener {
    private static final int DEBUG_INFO_SIZE = 2;
    private static final String DEBUG_INFO_SPLIT = "-";
    private static final int MAXIMUM_SAVED_TIME = 1800000;
    private static final String TAG = "Visual.VisualDebugManager";
    private static final String VISUAL_DEBUG_FILE = "datong/DtVisualDebug";
    private volatile boolean canUseLocalDebugInfo;
    private long localDebugSavedTime;
    private String mAppId;
    private String mDebugId;
    private ViewTreeScanner.ViewScanCallback mScanCallback;
    private boolean mStarted;
    private final boolean onMainProcess;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        private static final VisualDebugManager INSTANCE;

        static {
            VisualDebugManager visualDebugManager = new VisualDebugManager(null);
            INSTANCE = visualDebugManager;
            visualDebugManager.init();
        }

        InstanceHolder() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements ViewTreeScanner.ViewScanCallback {
        a() {
        }

        @Override // com.tencent.qqlive.module.videoreport.visual.debug.util.ViewTreeScanner.ViewScanCallback
        public void onViewScanned(PageData pageData, List<ViewData> list) {
            DebugEventReporter.reportScreenEvent(pageData, list);
        }
    }

    /* synthetic */ VisualDebugManager(a aVar) {
        this();
    }

    private void analysisDebugInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("-");
            if (split.length == 2) {
                this.mDebugId = split[0];
                this.mAppId = split[1];
            }
        }
    }

    private boolean canScan() {
        if (!this.mStarted && !verifyLocal()) {
            return false;
        }
        return true;
    }

    private void closeStream(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    public static VisualDebugManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        EventCollector.getInstance().registerEventListener(this);
    }

    private void loadDebugInfo() {
        BufferedReader bufferedReader;
        Throwable th5;
        Context context = ReportUtils.getContext();
        if (context != null) {
            File file = new File(context.getFilesDir(), VISUAL_DEBUG_FILE);
            if (file.exists()) {
                try {
                    this.localDebugSavedTime = file.lastModified();
                } catch (Throwable th6) {
                    bufferedReader = null;
                    th5 = th6;
                }
                if (!verifyDebugTime()) {
                    closeStream(null);
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        } else {
                            sb5.append(readLine);
                        }
                    } catch (Throwable th7) {
                        th5 = th7;
                        try {
                            th5.printStackTrace();
                        } finally {
                            closeStream(bufferedReader);
                        }
                    }
                }
                analysisDebugInfo(sb5.toString());
            }
        }
    }

    private void saveDebugInfo(String str, String str2) {
        Context context = ReportUtils.getContext();
        if (context != null) {
            Closeable closeable = null;
            try {
                File file = new File(context.getFilesDir(), VISUAL_DEBUG_FILE);
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    if (!parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    try {
                        fileOutputStream.write((str + "-" + str2).getBytes());
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        closeStream(fileOutputStream);
                    } catch (Throwable th5) {
                        th = th5;
                        closeable = fileOutputStream;
                        try {
                            th.printStackTrace();
                        } finally {
                            closeStream(closeable);
                        }
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    private void startViewScan() {
        ViewTreeScanner.getInstance().start(this.mScanCallback);
    }

    private void stopViewScan() {
        ViewTreeScanner.getInstance().stop();
    }

    private boolean verifyDebugInfo() {
        if (!TextUtils.isEmpty(this.mDebugId) && !TextUtils.isEmpty(this.mAppId)) {
            return true;
        }
        return false;
    }

    private boolean verifyDebugTime() {
        if (this.localDebugSavedTime != 0 && System.currentTimeMillis() - this.localDebugSavedTime < 1800000) {
            return true;
        }
        return false;
    }

    private boolean verifyLocal() {
        if (!this.canUseLocalDebugInfo && this.onMainProcess) {
            return false;
        }
        loadDebugInfo();
        this.canUseLocalDebugInfo = verifyDebugInfo();
        this.mStarted = this.canUseLocalDebugInfo;
        return this.canUseLocalDebugInfo;
    }

    public void addVisualDebugParams(Object obj, Map<String, Object> map) {
        int i3;
        if (isStarted()) {
            if (obj instanceof View) {
                i3 = obj.hashCode();
            } else {
                i3 = -1;
            }
            map.put(DTParamKey.REPORT_KEY_VISUAL_UID, Integer.valueOf(i3));
            map.put(DTParamKey.REPORT_KEY_VISUAL_APP_ID, getAppId());
            map.put(DTParamKey.REPORT_KEY_VISUAL_DEBUG_ID, getDebugId());
        }
    }

    public String getAppId() {
        return this.mAppId;
    }

    public String getDebugId() {
        return this.mDebugId;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityPause(Activity activity) {
        super.onActivityPause(activity);
    }

    @Override // com.tencent.qqlive.module.videoreport.collect.DefaultEventListener, com.tencent.qqlive.module.videoreport.collect.IEventListener
    public void onActivityResume(Activity activity) {
        super.onActivityResume(activity);
        ActivityUtil.setTopActivity(activity);
        if (canScan()) {
            stopViewScan();
            startViewScan();
        }
        ActivityUtil.setLastTopActivityRef(activity);
    }

    public synchronized void startVisualDebug(String str, String str2) {
        if (this.mStarted) {
            stopVisualDebug();
        }
        this.mStarted = true;
        this.mAppId = str;
        this.mDebugId = str2;
        saveDebugInfo(str2, str);
        startViewScan();
        Log.i(TAG, "startVisualDebug(), start visual debug success, appId=" + str + ", debugId=" + str2);
    }

    public synchronized void stopVisualDebug() {
        if (!this.mStarted) {
            return;
        }
        this.mStarted = false;
        stopViewScan();
        Log.i(TAG, "stopVisualDebug(), stop visual debug success");
    }

    VisualDebugManager() {
        this.canUseLocalDebugInfo = true;
        this.mScanCallback = new a();
        this.onMainProcess = ProcessUtils.isMainProcess();
    }
}
