package cooperation.vip;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class VasC2SReporter {

    /* renamed from: b, reason: collision with root package name */
    private static VasC2SReporter f391014b;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f391015a = new ConcurrentHashMap<>();

    public static void d(final String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.i("VasC2SReporter", 1, "reportUrl is empty");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: cooperation.vip.VasC2SReporter.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        URL url = new URL(str);
                        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                        httpURLConnection.setRequestMethod("GET");
                        httpURLConnection.setConnectTimeout(10000);
                        httpURLConnection.setReadTimeout(10000);
                        boolean z16 = false;
                        httpURLConnection.setUseCaches(false);
                        httpURLConnection.connect();
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            z16 = true;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("VasC2SReporter", 1, "exposure rspCode " + responseCode + "\uff0c request C2S isSuccess:" + z16 + ", url:" + url);
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.w("VasC2SReporter", 2, e16.toString());
                        }
                    }
                }
            }, 128, null, false);
        }
    }

    public static VasC2SReporter f() {
        if (f391014b == null) {
            synchronized (VasC2SReporter.class) {
                if (f391014b == null) {
                    f391014b = new VasC2SReporter();
                }
            }
        }
        return f391014b;
    }

    private void g(TianShuReportData tianShuReportData) {
        String str;
        if (tianShuReportData == null) {
            return;
        }
        for (int i3 = 1; i3 <= 4; i3++) {
            if (this.f391015a.containsKey(tianShuReportData.mItemId + i3 + "_" + tianShuReportData.mActionId)) {
                str = e(tianShuReportData.mItemId + i3 + "_" + tianShuReportData.mActionId);
            } else {
                str = "";
            }
            if (this.f391015a.containsKey(tianShuReportData.mItemId + i3)) {
                str = e(tianShuReportData.mItemId + i3);
            }
            if (!TextUtils.isEmpty(str)) {
                d(str);
            }
        }
    }

    public void a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (QLog.isColorLevel()) {
                    QLog.i("VasC2SReporter", 1, "addSplashExposeUrl, adId is " + str + "exposeUrl is " + str2);
                }
                this.f391015a.put(str, str2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("VasC2SReporter", 1, "adInfo is empty, cancel add");
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("VasC2SReporter", 2, e16.toString());
            }
        }
    }

    public void b(TianShuAccess.AdItem adItem) {
        if (adItem == null) {
            return;
        }
        String valueOf = String.valueOf(adItem.iAdId.get());
        for (TianShuAccess.MapEntry mapEntry : adItem.argList.get()) {
            String str = mapEntry.key.get();
            if (!TextUtils.isEmpty(str) && str.contains("thirdPartyReportURLForExposure")) {
                String str2 = mapEntry.value.get();
                String replace = str.replace("thirdPartyReportURLForExposure", valueOf);
                this.f391015a.put(replace, str2);
                if (QLog.isColorLevel()) {
                    QLog.i("VasC2SReporter", 1, "cacheC2SReportUrl adId:" + valueOf + " key:" + replace + " url:" + str2);
                }
            }
        }
    }

    public void c() {
        this.f391015a.clear();
    }

    public String e(String str) {
        String str2;
        boolean containsKey = this.f391015a.containsKey(str);
        if (!TextUtils.isEmpty(str) && containsKey) {
            str2 = this.f391015a.get(str);
        } else {
            str2 = "";
        }
        if (QLog.isColorLevel()) {
            QLog.i("VasC2SReporter", 1, "getC2SReportUrlFromCache key:" + str + " url:" + str2 + " isContains:" + containsKey);
        }
        return str2;
    }

    public void h(TianShuReportData tianShuReportData) {
        String str;
        if (tianShuReportData == null) {
            return;
        }
        int i3 = tianShuReportData.mActionId;
        if (i3 == 100 || i3 == 101 || i3 == 117 || i3 == 137 || i3 == 139 || i3 == 141 || i3 == 202) {
            if (this.f391015a.containsKey(tianShuReportData.mItemId + "_" + tianShuReportData.mActionId)) {
                str = e(tianShuReportData.mItemId + "_" + tianShuReportData.mActionId);
            } else if (this.f391015a.containsKey(tianShuReportData.mItemId)) {
                str = e(tianShuReportData.mItemId);
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str)) {
                d(str);
            }
            g(tianShuReportData);
        }
    }
}
