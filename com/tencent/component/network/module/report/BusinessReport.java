package com.tencent.component.network.module.report;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.component.network.Global;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.http.HttpUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BusinessReport {
    private static final int APP_OP_COUNT = 12;
    private static final int MAX_COUNT = 10;
    private static final int MAX_TIME = 600000;
    private static final int RADOM_PERCENT = 5;

    /* renamed from: r, reason: collision with root package name */
    private static Random f99903r = new Random();
    private static final Object[] locks = new Object[12];
    private static final Object init_lock = new Object();
    private static volatile boolean inited = false;
    private static long startTime = SystemClock.uptimeMillis();
    private static SparseArray<ArrayList<ReportObj>> appReportLists = new SparseArray<>(12);
    private static final String TAG = "BusinessReport";
    private static CommonTaskThread mTaskThread = new CommonTaskThread(TAG);

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class ReportRunnable implements Runnable {
        private static final int MAX_TRY_COUNT = 0;
        int appid;
        String body;
        ArrayList<ReportObj> listToSend;

        /* renamed from: op, reason: collision with root package name */
        int f99904op;
        String url;
        boolean inited = false;
        boolean successed = false;
        int tryCount = 0;

        public ReportRunnable(ArrayList<ReportObj> arrayList, int i3, int i16) {
            this.listToSend = arrayList;
            this.appid = i3;
            this.f99904op = i16;
        }

        private void init() {
            if (this.inited) {
                return;
            }
            if (this.listToSend.isEmpty()) {
                QDLog.e(BusinessReport.TAG, "listToSend is empty.");
                return;
            }
            ArrayList<ReportObj> arrayList = this.listToSend;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("count", arrayList.size());
                JSONArray jSONArray = new JSONArray();
                Iterator<ReportObj> it = arrayList.iterator();
                while (it.hasNext()) {
                    jSONArray.mo162put(it.next().toJSON());
                }
                jSONObject.put("data", jSONArray);
            } catch (JSONException e16) {
                QDLog.e(BusinessReport.TAG, "JSONException when uploadReport.", e16);
                jSONObject = null;
            }
            this.url = ReportObj.getReportUrl(this.appid, this.f99904op);
            if (QDLog.isInfoEnable()) {
                QDLog.i(BusinessReport.TAG, "url : " + this.url);
            }
            if (jSONObject != null) {
                this.body = jSONObject.toString();
            }
            if (QDLog.isInfoEnable()) {
                QDLog.i(BusinessReport.TAG, "json : " + this.body);
            }
            this.inited = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            init();
            if (!TextUtils.isEmpty(this.url) && !TextUtils.isEmpty(this.body)) {
                if (QDLog.isInfoEnable()) {
                    QDLog.i(BusinessReport.TAG, "start report thread.");
                }
                try {
                    HttpResponse executeHttpPost = HttpUtil.executeHttpPost(Global.getContext(), this.url, new StringEntity(this.body));
                    if (executeHttpPost.getStatusLine() != null) {
                        if (executeHttpPost.getStatusLine().getStatusCode() == 200) {
                            this.listToSend.clear();
                            this.successed = true;
                            if (QDLog.isInfoEnable()) {
                                QDLog.i(BusinessReport.TAG, "report success.");
                            }
                        } else {
                            this.tryCount++;
                            QDLog.e(BusinessReport.TAG, "HttpStatus error when report : " + executeHttpPost.getStatusLine().getStatusCode());
                        }
                    }
                } catch (UnsupportedEncodingException e16) {
                    this.tryCount++;
                    QDLog.w(BusinessReport.TAG, "exception when report", e16);
                } catch (IOException e17) {
                    this.tryCount++;
                    QDLog.w(BusinessReport.TAG, "exception when report", e17);
                } catch (Error e18) {
                    this.tryCount++;
                    QDLog.w(BusinessReport.TAG, "error when report", e18);
                } catch (IllegalArgumentException e19) {
                    this.tryCount++;
                    QDLog.w(BusinessReport.TAG, "exception when report", e19);
                } catch (ClientProtocolException e26) {
                    this.tryCount++;
                    QDLog.w(BusinessReport.TAG, "exception when report", e26);
                } catch (Exception e27) {
                    this.tryCount++;
                    QDLog.w(BusinessReport.TAG, "exception when report", e27);
                }
                if (!this.successed && this.tryCount <= 0) {
                    BusinessReport.mTaskThread.postDelay(this, 60000L);
                }
            }
        }
    }

    static /* synthetic */ int access$000() {
        return getReportPercent();
    }

    private static ArrayList<ReportObj> createRamdomArrayList() {
        return new ArrayList<ReportObj>() { // from class: com.tencent.component.network.module.report.BusinessReport.1
            private final boolean isFailed(ReportObj reportObj) {
                if (reportObj.retCode != 0) {
                    return true;
                }
                return false;
            }

            @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public boolean add(ReportObj reportObj) {
                if (isFailed(reportObj)) {
                    QDLog.w(BusinessReport.TAG, "download a img fail. need report retCode=" + reportObj.retCode);
                    return super.add((AnonymousClass1) reportObj);
                }
                if (reportObj != null && (reportObj instanceof ReportHandler.DownloadReportObject) && ((ReportHandler.DownloadReportObject) reportObj).needForceReport()) {
                    return super.add((AnonymousClass1) reportObj);
                }
                if (BusinessReport.access$000() > 0 && BusinessReport.f99903r.nextInt(Math.round(100 / r0)) == 0) {
                    return super.add((AnonymousClass1) reportObj);
                }
                return false;
            }
        };
    }

    private static int getReportPercent() {
        int reportPercent = Config.getReportPercent();
        if (reportPercent < 0) {
            return 5;
        }
        if (reportPercent > 100) {
            return 100;
        }
        return reportPercent;
    }

    public static void init() {
        if (inited) {
            return;
        }
        synchronized (init_lock) {
            if (inited) {
                return;
            }
            inited = true;
            int i3 = 0;
            for (int i16 = 0; i16 < 12; i16++) {
                if (i16 != 1 && i16 != 11) {
                    appReportLists.append(i16, new ArrayList<>());
                }
                appReportLists.append(i16, createRamdomArrayList());
            }
            while (true) {
                Object[] objArr = locks;
                if (i3 < objArr.length) {
                    objArr[i3] = new Object();
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    public static void uploadReport(ReportObj reportObj, int i3, int i16) {
        if ((i3 < 0 || i3 > 9) && i3 % 2 != 0) {
            return;
        }
        if (i16 != 0 && i16 != 1) {
            return;
        }
        int i17 = i3 + i16;
        long uptimeMillis = SystemClock.uptimeMillis() - startTime;
        ArrayList<ReportObj> arrayList = appReportLists.get(i17);
        synchronized (locks[i17]) {
            arrayList.add(reportObj);
        }
        if (i17 != 1) {
            if (i17 != 5) {
                if (i17 != 7 && i17 != 11) {
                    return;
                }
            } else {
                uploadReportImmediately(i3, i16);
                return;
            }
        }
        if (arrayList.size() >= 10 || uptimeMillis >= 600000) {
            uploadReportImmediately(i3, i16);
        }
    }

    public static void uploadReportImmediately(int i3, int i16) {
        ArrayList arrayList;
        if ((i3 < 0 || i3 > 11) && i3 % 2 != 0) {
            return;
        }
        if ((i16 != 0 && i16 != 1) || !NetworkManager.isNetworkAvailable()) {
            return;
        }
        int i17 = i3 + i16;
        ArrayList<ReportObj> arrayList2 = appReportLists.get(i17);
        if (arrayList2.isEmpty()) {
            return;
        }
        synchronized (locks[i17]) {
            arrayList = new ArrayList(arrayList2);
            if (i17 != 1 && i17 != 11) {
                appReportLists.setValueAt(i17, new ArrayList<>());
                arrayList2.clear();
                startTime = SystemClock.uptimeMillis();
            }
            appReportLists.setValueAt(i17, createRamdomArrayList());
            arrayList2.clear();
            startTime = SystemClock.uptimeMillis();
        }
        mTaskThread.post(new ReportRunnable(arrayList, i3, i16));
    }
}
