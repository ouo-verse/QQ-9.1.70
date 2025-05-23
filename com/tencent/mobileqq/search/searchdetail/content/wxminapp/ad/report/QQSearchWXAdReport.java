package com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.JsonObject;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.a;
import com.tencent.mobileqq.search.util.n;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService;
import com.tencent.qqnt.kernel.nativeinterface.IWxSearchReportCallback;
import com.tencent.qqnt.kernel.nativeinterface.UfsWxaSearchCommParams;
import com.tencent.qqnt.kernel.nativeinterface.UfsWxaSearchReportReq;
import com.tencent.qqnt.kernel.nativeinterface.UfsWxaSearchReportResp;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class QQSearchWXAdReport {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements IWxSearchReportCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f284365a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ UfsWxaSearchReportReq f284366b;

        a(c cVar, UfsWxaSearchReportReq ufsWxaSearchReportReq) {
            this.f284365a = cVar;
            this.f284366b = ufsWxaSearchReportReq;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IWxSearchReportCallback
        public void onResult(int i3, String str, UfsWxaSearchReportResp ufsWxaSearchReportResp) {
            String str2;
            long j3;
            String str3;
            String str4;
            int i16;
            UfsWxaSearchCommParams ufsWxaSearchCommParams;
            np2.a aVar;
            np2.a aVar2;
            np2.a aVar3;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[reportImpl] end, posId:");
            c cVar = this.f284365a;
            String str5 = null;
            if (cVar != null && (aVar3 = cVar.f284371b) != null) {
                str2 = aVar3.d();
            } else {
                str2 = null;
            }
            sb5.append(str2);
            sb5.append(" aid:");
            c cVar2 = this.f284365a;
            if (cVar2 != null && (aVar2 = cVar2.f284371b) != null) {
                j3 = aVar2.b();
            } else {
                j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
            }
            sb5.append(j3);
            sb5.append(" traceId:");
            c cVar3 = this.f284365a;
            if (cVar3 != null && (aVar = cVar3.f284371b) != null) {
                str3 = aVar.f();
            } else {
                str3 = null;
            }
            sb5.append(str3);
            sb5.append(" req.commParams.requestId:");
            UfsWxaSearchReportReq ufsWxaSearchReportReq = this.f284366b;
            if (ufsWxaSearchReportReq != null && (ufsWxaSearchCommParams = ufsWxaSearchReportReq.commParams) != null) {
                str4 = ufsWxaSearchCommParams.requestId;
            } else {
                str4 = null;
            }
            sb5.append(str4);
            sb5.append(" req.reqActionType:");
            UfsWxaSearchReportReq ufsWxaSearchReportReq2 = this.f284366b;
            if (ufsWxaSearchReportReq2 != null) {
                i16 = ufsWxaSearchReportReq2.reqActionType;
            } else {
                i16 = Integer.MIN_VALUE;
            }
            sb5.append(i16);
            sb5.append(" has req.wxFuncToken:");
            UfsWxaSearchReportReq ufsWxaSearchReportReq3 = this.f284366b;
            if (ufsWxaSearchReportReq3 != null) {
                str5 = ufsWxaSearchReportReq3.wxFuncToken;
            }
            sb5.append(!TextUtils.isEmpty(str5));
            sb5.append(" errCode:");
            sb5.append(i3);
            sb5.append(" errMsg:");
            sb5.append(str);
            sb5.append(" rsp:");
            sb5.append(ufsWxaSearchReportResp);
            sb5.append(" ");
            QLog.i("QQSearchWXAdReport", 1, sb5.toString());
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class b extends c {

        /* renamed from: d, reason: collision with root package name */
        public a.C8543a f284367d;

        /* renamed from: e, reason: collision with root package name */
        public np2.b f284368e;

        /* renamed from: f, reason: collision with root package name */
        public String f284369f;

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.QQSearchWXAdReport.c
        protected a.b a() {
            return this.f284367d;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.QQSearchWXAdReport.c
        protected int b() {
            return 0;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.QQSearchWXAdReport.c
        public String c() {
            String str;
            boolean z16;
            np2.a aVar = this.f284371b;
            if (aVar != null) {
                str = aVar.g();
            } else {
                str = null;
            }
            np2.b bVar = this.f284368e;
            if (bVar != null && bVar.b()) {
                Uri b16 = op2.b.b(str);
                boolean z17 = true;
                if (b16 == null) {
                    QLog.e("QQSearchWXAdReport", 1, "[ClickParams][getReportLink] error, uri is null");
                    return str;
                }
                Uri.Builder buildUpon = b16.buildUpon();
                if (buildUpon == null) {
                    QLog.e("QQSearchWXAdReport", 1, "[ClickParams][getReportLink] error, builder is null");
                    return str;
                }
                if (op2.b.a(b16, "comp_id") != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    buildUpon.appendQueryParameter("comp_id", this.f284368e.f420657a);
                }
                if (op2.b.a(b16, "comp_type") == null) {
                    z17 = false;
                }
                if (!z17) {
                    buildUpon.appendQueryParameter("comp_type", String.valueOf(this.f284368e.f420658b));
                }
                if (!z16 || !z17) {
                    return buildUpon.toString();
                }
                return str;
            }
            return str;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.QQSearchWXAdReport.c
        protected int d() {
            return 2;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.QQSearchWXAdReport.c
        public /* bridge */ /* synthetic */ String e() {
            return super.e();
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.QQSearchWXAdReport.c
        protected JsonObject f() {
            JsonObject f16 = super.f();
            if (f16 == null) {
                f16 = new JsonObject();
            }
            if (!f16.has("clickid")) {
                f16.addProperty("clickid", this.f284369f);
            }
            return f16;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.QQSearchWXAdReport.c
        public boolean g() {
            boolean z16;
            boolean z17 = true;
            if (super.g() && this.f284367d != null && !TextUtils.isEmpty(this.f284369f)) {
                z16 = true;
            } else {
                z16 = false;
            }
            np2.b bVar = this.f284368e;
            if (bVar != null) {
                if (!z16 || !bVar.a()) {
                    z17 = false;
                }
                return z17;
            }
            return z16;
        }

        @NonNull
        public String toString() {
            return "QQSearchWXAdReport.ClickParams(query=" + this.f284370a + ", ad=" + this.f284371b + ",boxPos=" + this.f284372c + ",antiCheatParams=" + a() + ",componentInfo=" + this.f284368e + ",clickId=" + this.f284369f + ",)";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public String f284370a;

        /* renamed from: b, reason: collision with root package name */
        public np2.a f284371b;

        /* renamed from: c, reason: collision with root package name */
        public int f284372c = Integer.MIN_VALUE;

        c() {
        }

        protected abstract a.b a();

        protected abstract int b();

        protected abstract String c();

        protected abstract int d();

        public String e() {
            JsonObject f16 = f();
            if (!f16.isJsonNull() && f16.size() > 0) {
                return f16.toString();
            }
            return null;
        }

        protected JsonObject f() {
            JsonObject jsonObject;
            np2.a aVar = this.f284371b;
            JsonObject jsonObject2 = null;
            if (aVar != null) {
                jsonObject = aVar.e();
            } else {
                jsonObject = null;
            }
            a.b a16 = a();
            if (a16 != null) {
                jsonObject2 = a16.a();
            }
            JsonObject b16 = op2.a.b(jsonObject, jsonObject2);
            if (b16 == null) {
                b16 = new JsonObject();
            }
            if (!b16.has("boxpos")) {
                b16.addProperty("boxpos", Integer.valueOf(this.f284372c));
            }
            return b16;
        }

        public boolean g() {
            np2.a aVar;
            if (!TextUtils.isEmpty(this.f284370a) && (aVar = this.f284371b) != null && aVar.j() && this.f284372c != Integer.MIN_VALUE) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class d extends c {

        /* renamed from: d, reason: collision with root package name */
        public a.c f284373d;

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.QQSearchWXAdReport.c
        protected a.b a() {
            return this.f284373d;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.QQSearchWXAdReport.c
        protected int b() {
            return 2;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.QQSearchWXAdReport.c
        protected String c() {
            np2.a aVar = this.f284371b;
            if (aVar != null) {
                return aVar.h();
            }
            return null;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.QQSearchWXAdReport.c
        protected int d() {
            return 1;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.QQSearchWXAdReport.c
        public /* bridge */ /* synthetic */ String e() {
            return super.e();
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.QQSearchWXAdReport.c
        public boolean g() {
            if (super.g() && this.f284373d != null) {
                return true;
            }
            return false;
        }

        @NonNull
        public String toString() {
            return "QQSearchWXAdReport.ImpressionParams(query=" + this.f284370a + ", ad=" + this.f284371b + ",boxPos=" + this.f284372c + ",antiCheatParams=" + a() + ",)";
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static final class e extends c {

        /* renamed from: d, reason: collision with root package name */
        public a.d f284374d;

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.QQSearchWXAdReport.c
        protected a.b a() {
            return this.f284374d;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.QQSearchWXAdReport.c
        protected int b() {
            return 1;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.QQSearchWXAdReport.c
        protected String c() {
            np2.a aVar = this.f284371b;
            if (aVar != null) {
                return aVar.i();
            }
            return null;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.QQSearchWXAdReport.c
        protected int d() {
            return 1;
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.QQSearchWXAdReport.c
        public /* bridge */ /* synthetic */ String e() {
            return super.e();
        }

        @Override // com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.QQSearchWXAdReport.c
        public boolean g() {
            if (super.g() && this.f284374d != null) {
                return true;
            }
            return false;
        }

        @NonNull
        public String toString() {
            return "QQSearchWXAdReport.OriginalImpressionParams(query=" + this.f284370a + ", ad=" + this.f284371b + ",boxPos=" + this.f284372c + ",antiCheatParams=" + a() + ",)";
        }
    }

    private static IWxSearchReportCallback b(c cVar, UfsWxaSearchReportReq ufsWxaSearchReportReq) {
        return new a(cVar, ufsWxaSearchReportReq);
    }

    private static void c(final Context context, final c cVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.QQSearchWXAdReport.1
            @Override // java.lang.Runnable
            public void run() {
                QQSearchWXAdReport.g(context, cVar);
            }
        }, 128, null, true);
    }

    public static void d(Context context, b bVar) {
        String str;
        long j3;
        np2.a aVar;
        np2.a aVar2;
        np2.a aVar3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[reportForClick] posId:");
        String str2 = null;
        if (bVar != null && (aVar3 = bVar.f284371b) != null) {
            str = aVar3.d();
        } else {
            str = null;
        }
        sb5.append(str);
        sb5.append(" aid:");
        if (bVar != null && (aVar2 = bVar.f284371b) != null) {
            j3 = aVar2.b();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        sb5.append(j3);
        sb5.append(" traceId:");
        if (bVar != null && (aVar = bVar.f284371b) != null) {
            str2 = aVar.f();
        }
        sb5.append(str2);
        sb5.append(" params:");
        sb5.append(bVar);
        sb5.append(" ");
        QLog.i("QQSearchWXAdReport", 1, sb5.toString());
        c(context, bVar);
    }

    public static void e(Context context, d dVar) {
        String str;
        long j3;
        np2.a aVar;
        np2.a aVar2;
        np2.a aVar3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[reportForImpression] posId:");
        String str2 = null;
        if (dVar != null && (aVar3 = dVar.f284371b) != null) {
            str = aVar3.d();
        } else {
            str = null;
        }
        sb5.append(str);
        sb5.append(" aid:");
        if (dVar != null && (aVar2 = dVar.f284371b) != null) {
            j3 = aVar2.b();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        sb5.append(j3);
        sb5.append(" traceId:");
        if (dVar != null && (aVar = dVar.f284371b) != null) {
            str2 = aVar.f();
        }
        sb5.append(str2);
        sb5.append(" params:");
        sb5.append(dVar);
        sb5.append(" ");
        QLog.i("QQSearchWXAdReport", 1, sb5.toString());
        c(context, dVar);
    }

    public static void f(Context context, e eVar) {
        String str;
        long j3;
        np2.a aVar;
        np2.a aVar2;
        np2.a aVar3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[reportForOriginalImpression] posId:");
        String str2 = null;
        if (eVar != null && (aVar3 = eVar.f284371b) != null) {
            str = aVar3.d();
        } else {
            str = null;
        }
        sb5.append(str);
        sb5.append(" aid:");
        if (eVar != null && (aVar2 = eVar.f284371b) != null) {
            j3 = aVar2.b();
        } else {
            j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        sb5.append(j3);
        sb5.append(" traceId:");
        if (eVar != null && (aVar = eVar.f284371b) != null) {
            str2 = aVar.f();
        }
        sb5.append(str2);
        sb5.append(" params:");
        sb5.append(eVar);
        sb5.append(" ");
        QLog.i("QQSearchWXAdReport", 1, sb5.toString());
        c(context, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(Context context, c cVar) {
        String str;
        np2.a aVar;
        np2.a aVar2;
        np2.a aVar3;
        String str2;
        com.tencent.mobileqq.wxmini.api.data.d dVar;
        String str3;
        long j3 = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        String str4 = null;
        if (cVar != null && cVar.g()) {
            com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.b bVar = new com.tencent.mobileqq.search.searchdetail.content.wxminapp.ad.report.b();
            bVar.reportType = cVar.d();
            bVar.exposureType = cVar.b();
            bVar.reportLink = cVar.c();
            bVar.posId = cVar.f284371b.d();
            bVar.advertGroupId = cVar.f284371b.c();
            if (cVar.f284371b.b() != WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
                str2 = String.valueOf(cVar.f284371b.b());
            } else {
                str2 = null;
            }
            bVar.aid = str2;
            bVar.traceId = cVar.f284371b.f();
            bVar.searchAdExtraData = cVar.e();
            bVar.query = op2.b.c(cVar.f284370a, "UTF-8", null);
            bVar.clientTimestamp = System.currentTimeMillis();
            String bVar2 = bVar.toString();
            if (bVar.a() && !TextUtils.isEmpty(bVar2)) {
                try {
                    dVar = ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).getBindingWeChatUserInfo();
                } catch (Throwable th5) {
                    QLog.e("QQSearchWXAdReport", 1, "[reportImpl] getBindingWeChatUserInfo error, params:" + cVar, th5);
                    dVar = null;
                }
                IKernelUnifySearchService c16 = n.c();
                if (c16 == null) {
                    QLog.e("QQSearchWXAdReport", 1, "[reportImpl] error, service is null,reqJson:" + bVar2 + " params:" + cVar);
                    return;
                }
                UfsWxaSearchReportReq ufsWxaSearchReportReq = new UfsWxaSearchReportReq();
                UfsWxaSearchCommParams ufsWxaSearchCommParams = ufsWxaSearchReportReq.commParams;
                if (ufsWxaSearchCommParams != null) {
                    try {
                        ufsWxaSearchCommParams.requestId = UUID.randomUUID().toString();
                    } catch (Throwable th6) {
                        QLog.e("QQSearchWXAdReport", 1, "[reportImpl]", th6);
                    }
                }
                ufsWxaSearchReportReq.reqActionType = 3;
                if (dVar != null) {
                    str3 = dVar.h();
                } else {
                    str3 = null;
                }
                ufsWxaSearchReportReq.wxFuncToken = str3;
                ufsWxaSearchReportReq.reqJson = bVar2;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[reportImpl] start, posId:");
                sb5.append(cVar.f284371b.d());
                sb5.append(" aid:");
                sb5.append(cVar.f284371b.b());
                sb5.append(" traceId:");
                sb5.append(cVar.f284371b.f());
                sb5.append(" req.commParams.requestId:");
                UfsWxaSearchCommParams ufsWxaSearchCommParams2 = ufsWxaSearchReportReq.commParams;
                if (ufsWxaSearchCommParams2 != null) {
                    str4 = ufsWxaSearchCommParams2.requestId;
                }
                sb5.append(str4);
                sb5.append(" req.reqActionType:");
                sb5.append(ufsWxaSearchReportReq.reqActionType);
                sb5.append(" has req.wxFuncToken:");
                sb5.append(!TextUtils.isEmpty(ufsWxaSearchReportReq.wxFuncToken));
                QLog.i("QQSearchWXAdReport", 1, sb5.toString());
                c16.wxSearchReport(ufsWxaSearchReportReq, b(cVar, ufsWxaSearchReportReq));
                return;
            }
            QLog.e("QQSearchWXAdReport", 1, "[reportImpl] error, reportParams not valid, posId:" + cVar.f284371b.d() + " aid:" + cVar.f284371b.b() + " traceId:" + cVar.f284371b.f() + " requestJson:" + bVar2 + " ");
            return;
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("[reportImpl] error, params not valid, posId:");
        if (cVar != null && (aVar3 = cVar.f284371b) != null) {
            str = aVar3.d();
        } else {
            str = null;
        }
        sb6.append(str);
        sb6.append(" aid:");
        if (cVar != null && (aVar2 = cVar.f284371b) != null) {
            j3 = aVar2.b();
        }
        sb6.append(j3);
        sb6.append(" traceId:");
        if (cVar != null && (aVar = cVar.f284371b) != null) {
            str4 = aVar.f();
        }
        sb6.append(str4);
        sb6.append(" params:");
        sb6.append(cVar);
        sb6.append(" ");
        QLog.e("QQSearchWXAdReport", 1, sb6.toString());
    }
}
