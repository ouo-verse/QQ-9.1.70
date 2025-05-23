package com.tencent.sqshow.zootopia.operation.facead;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.google.android.vending.licensing.util.Base64DecoderException;
import com.tencent.gamematrix.gmcg.sdk.nonage.report.CGNonAgeReport;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.web.RewardType;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import com.tencent.util.URLUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import t74.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0011\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/sqshow/zootopia/operation/facead/p;", "Lcom/tencent/sqshow/zootopia/operation/facead/h;", "", "schemeUrl", "Landroid/content/Context;", "context", "", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "clickedView", "", "r", "Landroid/app/Activity;", "L", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;)V", "M", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class p extends h {

    /* renamed from: L, reason: from kotlin metadata */
    private final Activity activity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/operation/facead/p$b", "Lt74/o$b;", "", "success", "", "b", "profitable", "c", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements o.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f372188a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f372189b;

        b(Context context, String str) {
            this.f372188a = context;
            this.f372189b = str;
        }

        @Override // t74.o.b
        public void a(boolean success) {
            QLog.i("ZplanFaceAdRealNativeHandler", 1, "onReportResult " + success);
            ((ISchemeApi) QRoute.api(ISchemeApi.class)).launchScheme(this.f372188a, this.f372189b);
            QQToastUtil.showQQToastInUiThread(2, this.f372188a.getString(R.string.xkn));
        }

        @Override // t74.o.b
        public void b(boolean success) {
            QLog.i("ZplanFaceAdRealNativeHandler", 1, "onRequestResult " + success);
            if (success) {
                return;
            }
            QQToastUtil.showQQToastInUiThread(0, this.f372188a.getString(R.string.xs_));
        }

        @Override // t74.o.b
        public void c(boolean profitable) {
            QLog.i("ZplanFaceAdRealNativeHandler", 1, "onShowResult " + profitable);
        }
    }

    public p(Activity activity) {
        this.activity = activity;
    }

    private final boolean C(String schemeUrl, Context context) {
        String str;
        String decodeToString;
        Activity activity = this.activity;
        if (activity == null) {
            return false;
        }
        Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(schemeUrl);
        Intrinsics.checkNotNullExpressionValue(argumentsFromURL, "getArgumentsFromURL(schemeUrl)");
        if (!Intrinsics.areEqual(argumentsFromURL.get("is_native_ad"), "1")) {
            return false;
        }
        try {
            String str2 = argumentsFromURL.get(CGNonAgeReport.EVENT_TYPE);
            if (str2 == null) {
                return false;
            }
            int parseInt = Integer.parseInt(str2);
            String str3 = argumentsFromURL.get("popups_id");
            if (str3 == null || (str = argumentsFromURL.get("callback_url")) == null) {
                return false;
            }
            byte[] e16 = o1.a.e(str);
            Intrinsics.checkNotNullExpressionValue(e16, "decodeWebSafe(callbackUrlBase64)");
            decodeToString = StringsKt__StringsJVMKt.decodeToString(e16);
            t74.o oVar = new t74.o();
            oVar.o(new b(context, decodeToString));
            int value = RewardType.SUPER_SHOW_MOB.getValue();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uin", MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin());
            jSONObject.put(CGNonAgeReport.EVENT_TYPE, parseInt);
            jSONObject.put("popups_id", str3);
            Unit unit = Unit.INSTANCE;
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "JSONObject().apply {\n   \u2026sId)\n        }.toString()");
            t74.o.m(oVar, activity, value, jSONObject2, 0, 8, null);
            return true;
        } catch (Base64DecoderException e17) {
            QLog.e("ZplanFaceAdRealNativeHandler", 1, e17.toString());
            return false;
        } catch (NumberFormatException e18) {
            QLog.e("ZplanFaceAdRealNativeHandler", 1, e18.toString());
            return false;
        }
    }

    @Override // com.tencent.sqshow.zootopia.operation.facead.h
    public void r(View clickedView) {
        Intrinsics.checkNotNullParameter(clickedView, "clickedView");
        String m3 = m();
        if (m3 != null) {
            Context context = clickedView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "clickedView.context");
            if (C(m3, context)) {
                return;
            }
            super.r(clickedView);
        }
    }
}
