package com.tencent.ad.tangram.util;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdExposureListHolder {
    private static final String EXPOSURED_AD = "exposured_ad";
    private static final String IDS = "_ids";
    private static final String TAG = "AdExposureListHolder";
    private static volatile AdExposureListHolder sInstance;
    private volatile boolean initialized;

    @Nullable
    private LinkedList<String> traceIdList = null;

    @Nullable
    private LinkedList<String> traceIdListForAnalysis = null;
    private final Object memoryLock = new Object();
    private final Object fileLock = new Object();

    AdExposureListHolder() {
    }

    private void addCheckedData(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.memoryLock) {
            LinkedList<String> exposuredTraceIdList = getExposuredTraceIdList();
            if (exposuredTraceIdList != null && !exposuredTraceIdList.contains(str)) {
                if (exposuredTraceIdList.size() - 100 >= 0) {
                    for (int i3 = 0; i3 <= exposuredTraceIdList.size() - 100; i3++) {
                        exposuredTraceIdList.removeLast();
                    }
                }
                exposuredTraceIdList.add(str);
            }
        }
    }

    private void addDiskCheckedData(@Nullable final Context context) {
        LinkedList<String> exposuredTraceIdList;
        if (context != null && (exposuredTraceIdList = getExposuredTraceIdList()) != null && exposuredTraceIdList.size() > 0) {
            AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.util.AdExposureListHolder.2
                @Override // java.lang.Runnable
                public void run() {
                    JSONArray jSONArray = new JSONArray();
                    synchronized (AdExposureListHolder.this.memoryLock) {
                        Iterator it = AdExposureListHolder.this.traceIdList.iterator();
                        while (it.hasNext()) {
                            jSONArray.mo162put((String) it.next());
                        }
                    }
                    synchronized (AdExposureListHolder.this.fileLock) {
                        AdFileUtils.write(AdExposureListHolder.this.getFileByProcessName(context, AdProcessManager.getInstance().getCurrentProcessName(context)), jSONArray.toString());
                    }
                }
            }, 5);
        }
    }

    @Nullable
    private LinkedList<String> getExposuredTraceIdList() {
        return this.traceIdList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public File getFileByProcessName(@Nullable Context context, String str) {
        File fileDir;
        if (context == null || TextUtils.isEmpty(str) || (fileDir = getFileDir(context)) == null) {
            return null;
        }
        return new File(fileDir.getAbsolutePath() + File.separator + str + IDS);
    }

    @Nullable
    private File getFileDir(@Nullable Context context) {
        if (context == null) {
            return null;
        }
        return context.getDir(EXPOSURED_AD, 0);
    }

    public static AdExposureListHolder getInstance() {
        if (sInstance == null) {
            synchronized (AdExposureListHolder.class) {
                if (sInstance == null) {
                    sInstance = new AdExposureListHolder();
                }
            }
        }
        return sInstance;
    }

    public void addTraceIdForAnalysis(String str) {
        LinkedList<String> linkedList;
        if (!TextUtils.isEmpty(str) && (linkedList = this.traceIdListForAnalysis) != null && !linkedList.contains(str)) {
            if (this.traceIdListForAnalysis.size() >= 100) {
                this.traceIdListForAnalysis.removeLast();
            }
            this.traceIdListForAnalysis.add(str);
        }
    }

    public boolean containsTraceIdForAnalysis(String str) {
        LinkedList<String> linkedList;
        if (!TextUtils.isEmpty(str) && (linkedList = this.traceIdListForAnalysis) != null && linkedList.contains(str)) {
            return true;
        }
        return false;
    }

    public boolean inCheckedList(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        synchronized (this.memoryLock) {
            LinkedList<String> exposuredTraceIdList = getExposuredTraceIdList();
            if (exposuredTraceIdList != null) {
                Iterator<String> it = exposuredTraceIdList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!TextUtils.isEmpty(next) && str.equals(next)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public void init(@Nullable final Context context) {
        if (this.initialized) {
            return;
        }
        synchronized (AdExposureListHolder.class) {
            if (this.initialized) {
                return;
            }
            this.initialized = true;
            if (context == null) {
                return;
            }
            if (this.traceIdList == null) {
                this.traceIdList = new LinkedList<>();
            }
            if (this.traceIdListForAnalysis == null) {
                this.traceIdListForAnalysis = new LinkedList<>();
            }
            AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.ad.tangram.util.AdExposureListHolder.1
                @Override // java.lang.Runnable
                public void run() {
                    File fileByProcessName = AdExposureListHolder.this.getFileByProcessName(context, AdProcessManager.getInstance().getCurrentProcessName(context));
                    if (fileByProcessName != null && fileByProcessName.exists()) {
                        String read = AdFileUtils.read(fileByProcessName);
                        if (!TextUtils.isEmpty(read)) {
                            try {
                                JSONArray jSONArray = new JSONArray(read);
                                if (jSONArray.length() > 0) {
                                    synchronized (AdExposureListHolder.this.memoryLock) {
                                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                            AdExposureListHolder.this.traceIdList.add(jSONArray.get(i3).toString());
                                        }
                                    }
                                }
                                AdLog.i(AdExposureListHolder.TAG, "init from file ids :" + AdExposureListHolder.this.traceIdList.size());
                            } catch (Throwable th5) {
                                th5.printStackTrace();
                            }
                        }
                    }
                }
            }, 5);
        }
    }

    public void putExternalReportData(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            AdLog.i(TAG, "putExternalReportData id :" + str);
            addCheckedData(str);
            addDiskCheckedData(context);
        }
    }
}
