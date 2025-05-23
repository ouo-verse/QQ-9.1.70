package com.tencent.open.business.cgireport;

import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.open.base.f;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.open.business.base.OpenConfig;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Random;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ReportManager {

    /* renamed from: h, reason: collision with root package name */
    protected static final String f341063h = "com.tencent.open.business.cgireport.ReportManager";

    /* renamed from: i, reason: collision with root package name */
    protected static ReportManager f341064i;

    /* renamed from: a, reason: collision with root package name */
    protected long f341065a = 0;

    /* renamed from: b, reason: collision with root package name */
    protected int f341066b = 3;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f341067c = false;

    /* renamed from: f, reason: collision with root package name */
    protected volatile ArrayList<c> f341070f = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    protected volatile ArrayList<c> f341071g = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    protected b f341069e = new b();

    /* renamed from: d, reason: collision with root package name */
    protected Random f341068d = new Random();

    public static synchronized ReportManager h() {
        ReportManager reportManager;
        synchronized (ReportManager.class) {
            if (f341064i == null) {
                f341064i = new ReportManager();
            }
            reportManager = f341064i;
        }
        return reportManager;
    }

    protected boolean a(String str) {
        int j3 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).j("Common_CGIReportMaxcount");
        f.a("OpenConfig_agent", "config 6:Common_CGIReportMaxcount     config_value:" + j3);
        if (j3 == 0) {
            j3 = 20;
        }
        f.a("OpenConfig_agent", "config 6:Common_CGIReportMaxcount     result_value:" + j3);
        if (this.f341069e.i(str) >= j3) {
            f.e("cgi_report_debug", "ReportManager availableForCount = ture");
            return true;
        }
        f.e("cgi_report_debug", "ReportManager availableForCount = false");
        return false;
    }

    protected boolean b(int i3) {
        if (this.f341068d.nextInt(100) < d(i3)) {
            f.e("cgi_report_debug", "ReportManager availableForFrequency = ture");
            return true;
        }
        f.e("cgi_report_debug", "ReportManager availableForFrequency = false");
        return false;
    }

    protected boolean c() {
        long k3 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).k("Common_CGIReportTimeinterval");
        f.a("OpenConfig_agent", "config 5:Common_CGIReportTimeinterval     config_value:" + k3);
        if (k3 == 0) {
            k3 = 1200;
        }
        f.a("OpenConfig_agent", "config 5:Common_CGIReportTimeinterval     result_value:" + k3);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long j3 = this.f341065a;
        if (j3 != 0 && j3 + k3 > currentTimeMillis) {
            f.e("cgi_report_debug", "ReportManager availableForTime = false");
            return false;
        }
        this.f341065a = currentTimeMillis;
        f.e("cgi_report_debug", "ReportManager availableForTime = ture");
        return true;
    }

    protected int d(int i3) {
        int j3;
        if (i3 == 0) {
            j3 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).j("Common_CGIReportFrequencySuccess");
            f.a("OpenConfig_agent", "config 4:Common_CGIReportFrequencySuccess     config_value:" + j3);
            if (j3 == 0) {
                j3 = 10;
            }
            f.a("OpenConfig_agent", "config 4:Common_CGIReportFrequencySuccess     result_value:" + j3);
        } else {
            j3 = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).j("Common_CGIReportFrequencyFailed");
            f.a("OpenConfig_agent", "config 4:Common_CGIReportFrequencyFailed     config_value:" + j3);
            if (j3 == 0) {
                j3 = 100;
            }
            f.a("OpenConfig_agent", "config 4:Common_CGIReportFrequencyFailed     result_value:" + j3);
        }
        return j3;
    }

    protected void e(String str, boolean z16) {
        f.e("cgi_report_debug", "ReportManager doUpload start");
        Bundle i3 = i(str, z16);
        if (i3 == null) {
            return;
        }
        this.f341067c = true;
        f("https://wspeed.qq.com/w.cgi", "POST", i3);
    }

    protected void f(final String str, String str2, final Bundle bundle) {
        ThreadManagerV2.executeOnNetWorkThread(new Runnable() { // from class: com.tencent.open.business.cgireport.ReportManager.1
            /* JADX WARN: Removed duplicated region for block: B:14:0x0117  */
            /* JADX WARN: Removed duplicated region for block: B:17:0x011e  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                f.e("cgi_report_debug", "ReportManager doUploadItems Thread start, url = " + str);
                f.e("cgi_report_debug", "report bundle=" + bundle);
                ReportManager.this.f341066b = OpenConfig.i(com.tencent.open.adapter.a.f().e(), null).j("Common_HttpRetryCount");
                ReportManager reportManager = ReportManager.this;
                int i3 = reportManager.f341066b;
                if (i3 == 0) {
                    i3 = 3;
                }
                reportManager.f341066b = i3;
                int i16 = 0;
                boolean z16 = false;
                do {
                    i16++;
                    f.e("cgi_report_debug", "ReportManager doUploadItems Thread request count = " + i16);
                    try {
                        HttpClient f16 = HttpBaseUtil.f(null, str);
                        HttpPost httpPost = new HttpPost(MsfSdkUtils.insertMtype("yingyongbao", str));
                        httpPost.addHeader("Accept-Encoding", "gzip");
                        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
                        httpPost.setEntity(new ByteArrayEntity(HttpBaseUtil.d(bundle).getBytes()));
                        if (f16.execute(httpPost).getStatusLine().getStatusCode() != 200) {
                            f.c("cgi_report_debug", "ReportManager doUploadItems : HttpStatuscode != 200");
                            break;
                        }
                        try {
                            f.e("cgi_report_debug", "ReportManager doUploadItems Thread success");
                        } catch (NoClassDefFoundError e16) {
                            e = e16;
                            z16 = true;
                            f.d(ReportManager.f341063h, "ReportManager doUploadItems noClassDefFoundError", e);
                            ReportManager.this.f341067c = false;
                            f.e("cgi_report_debug", "ReportManager doUploadItems Thread end, url = " + str);
                            if (z16) {
                            }
                        } catch (OutOfMemoryError unused) {
                        } catch (SocketTimeoutException e17) {
                            e = e17;
                            z16 = true;
                            f.d(ReportManager.f341063h, "doUploadItems>>>", e);
                        } catch (ConnectTimeoutException e18) {
                            e = e18;
                            z16 = true;
                            f.d(ReportManager.f341063h, "ReportManager doUploadItems : ConnectTimeoutException", e);
                        } catch (Exception e19) {
                            e = e19;
                            z16 = true;
                            f.d("cgi_report_debug", "ReportManager doUploadItems : Exception", e);
                            ReportManager.this.f341067c = false;
                            f.e("cgi_report_debug", "ReportManager doUploadItems Thread end, url = " + str);
                            if (z16) {
                            }
                        }
                        z16 = true;
                        break;
                    } catch (NoClassDefFoundError e26) {
                        e = e26;
                    } catch (SocketTimeoutException e27) {
                        e = e27;
                    } catch (ConnectTimeoutException e28) {
                        e = e28;
                    } catch (Exception e29) {
                        e = e29;
                    } catch (OutOfMemoryError unused2) {
                    }
                } while (i16 < ReportManager.this.f341066b);
                ReportManager.this.f341067c = false;
                f.e("cgi_report_debug", "ReportManager doUploadItems Thread end, url = " + str);
                if (z16) {
                    f.e("cgi_report_debug", "ReportManager doUploadItems Thread request success");
                    return;
                }
                f.c("cgi_report_debug", "ReportManager doUploadItems Thread request failed");
                ReportManager reportManager2 = ReportManager.this;
                reportManager2.f341069e.b(reportManager2.f341070f);
            }
        });
    }

    protected String g() {
        return AppNetConnInfo.getCurrentAPN();
    }

    protected synchronized Bundle i(String str, boolean z16) {
        f.e("cgi_report_debug", "ReportManager prepareData start");
        this.f341070f = this.f341069e.g(str);
        this.f341069e.c(str);
        if (this.f341070f.size() <= 0) {
            f.e("cgi_report_debug", "ReportManager prepareData end  newItems == null");
            return null;
        }
        this.f341071g = this.f341069e.h(str);
        this.f341069e.d(str);
        Bundle bundle = new Bundle();
        try {
            bundle.putString("appid", str);
            bundle.putString("releaseversion", a.f341074a);
            bundle.putString("device", Build.DEVICE);
            bundle.putString("qua", a.f341075b);
            bundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
            for (int i3 = 0; i3 < this.f341070f.size(); i3++) {
                bundle.putString(i3 + "_1", this.f341070f.get(i3).f341080a);
                bundle.putString(i3 + "_2", this.f341070f.get(i3).f341081b);
                bundle.putString(i3 + "_3", this.f341070f.get(i3).f341082c);
                bundle.putString(i3 + "_4", this.f341070f.get(i3).f341083d);
                bundle.putString(i3 + "_5", this.f341070f.get(i3).f341084e);
                bundle.putString(i3 + "_6", this.f341070f.get(i3).f341085f);
                bundle.putString(i3 + "_7", this.f341070f.get(i3).f341086g);
                bundle.putString(i3 + "_8", this.f341070f.get(i3).f341089j);
                bundle.putString(i3 + "_9", this.f341070f.get(i3).f341087h);
                bundle.putString(i3 + "_10", MobileInfoUtil.getDeviceinfoForCgiReport(z16) + ContainerUtils.FIELD_DELIMITER + this.f341070f.get(i3).f341088i);
            }
            for (int size = this.f341070f.size(); size < this.f341071g.size() + this.f341070f.size(); size++) {
                int size2 = size - this.f341070f.size();
                bundle.putString(size + "_1", this.f341071g.get(size2).f341080a);
                bundle.putString(size + "_2", this.f341071g.get(size2).f341081b);
                bundle.putString(size + "_3", this.f341071g.get(size2).f341082c);
                bundle.putString(size + "_4", this.f341071g.get(size2).f341083d);
                bundle.putString(size + "_5", this.f341071g.get(size2).f341084e);
                bundle.putString(size + "_6", this.f341071g.get(size2).f341085f);
                bundle.putString(size + "_7", this.f341071g.get(size2).f341086g);
                bundle.putString(size + "_8", this.f341071g.get(size2).f341089j);
                bundle.putString(size + "_9", this.f341071g.get(size2).f341087h);
                bundle.putString(size + "_10", MobileInfoUtil.getDeviceinfoForCgiReport(z16) + ContainerUtils.FIELD_DELIMITER + this.f341070f.get(size2).f341088i);
            }
            f.e("cgi_report_debug", "ReportManager prepareData end");
            return bundle;
        } catch (Exception e16) {
            f.b(f341063h, "prepareData>>>", e16);
            return null;
        }
    }

    public void j(String str, long j3, long j16, long j17, int i3, long j18, String str2, String str3) {
        k(str, j3, j16, j17, i3, j18, str2, str3, false);
    }

    public void k(String str, long j3, long j16, long j17, int i3, long j18, String str2, String str3, boolean z16) {
        if (b(i3)) {
            l(str, j3, j16, j17, i3, j18, str2, str3);
            if (this.f341067c) {
                return;
            }
            if (c() || a(str2)) {
                e(str2, z16);
            }
        }
    }

    protected void l(String str, long j3, long j16, long j17, int i3, long j18, String str2, String str3) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - j3;
        f.e("cgi_report_debug", "ReportManager updateDB url=" + str + ",resultCode=" + i3 + ",timeCost=" + elapsedRealtime + ",reqSize=" + j16 + ",rspSize=" + j17);
        int i16 = 100;
        int d16 = 100 / d(i3);
        if (d16 <= 0) {
            i16 = 1;
        } else if (d16 <= 100) {
            i16 = d16;
        }
        String g16 = g();
        this.f341069e.a(g16, i16 + "", str, i3 + "", elapsedRealtime + "", j16 + "", j17 + "", j18 + "", str3, str2);
    }
}
