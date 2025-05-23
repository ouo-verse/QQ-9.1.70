package com.tencent.mobileqq.qqlive.config;

import android.content.Context;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0016\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000f\u0010\u000f\u001a\u00020\u000eH\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/qqlive/config/c;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqlive/config/QQLiveEntrance;", QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, "", "checkProcess", "", "e", "", "a", "b", "d", "Lcom/tencent/mobileqq/qqlive/config/b;", "c", "()Lcom/tencent/mobileqq/qqlive/config/b;", "<init>", "()V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f271178a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ErrorCode.SRERR_GET_RES_FAILED);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f271178a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String a() {
        int indexOf$default;
        String value = ct3.a.l("qqlive_key_business_config", null);
        Intrinsics.checkNotNullExpressionValue(value, "value");
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) value, "-", 0, false, 6, (Object) null);
        if (indexOf$default > -1) {
            String substring = value.substring(indexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        return "";
    }

    private final String b() {
        return ht3.a.d("live_new_appid_config", "");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x004f, code lost:
    
        if (r0 == true) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void e(Context context, QQLiveEntrance entrance, boolean checkProcess) {
        boolean startsWith$default;
        boolean z16 = true;
        if (MobileQQ.sProcessId != 1) {
            if (checkProcess) {
                AegisLogger.INSTANCE.e("Login|QQLiveBizConfigRepo", "initConfigInMainProcess", "called in non-main process, entrance=" + entrance);
                return;
            }
            return;
        }
        String l3 = ct3.a.l("qqlive_key_business_config", null);
        String str = context.getApplicationContext().hashCode() + "-";
        if (l3 != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(l3, str, false, 2, null);
        }
        z16 = false;
        if (z16) {
            return;
        }
        String str2 = str + b();
        ct3.a.t("qqlive_key_business_config", str2);
        AegisLogger.INSTANCE.i("Login|QQLiveBizConfigRepo", "initConfigInMainProcess", "entrance=" + entrance + ", config=" + str2);
    }

    @NotNull
    public final b c() {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        b bVar = new b(IQQLiveAnchorPrepareWrapper.QQLIVE_BIZID, "0", "7fb756e068374416930f7d252785dd30", "46", "101490787", 406, 17106, "1400368383", "1400515529");
        try {
            MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
            Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
            e(sMobileQQ, QQLiveEntrance.OTHERS, false);
            String a16 = a();
            isBlank = StringsKt__StringsJVMKt.isBlank(a16);
            if (isBlank) {
                AegisLogger.INSTANCE.i("Login|QQLiveBizConfigRepo", "getQQLiveBusinessConfig", "remoteConfig is blank, use default");
            } else {
                AegisLogger.INSTANCE.i("Login|QQLiveBizConfigRepo", "getQQLiveBusinessConfig", "remoteConfig=" + a16);
                JSONObject jSONObject = new JSONObject(a16);
                String optString = jSONObject.optString(QQLiveReportConstants.AttaColumn.LIVE_APPID, "0");
                Intrinsics.checkNotNullExpressionValue(optString, "configJson.optString(\"live_appid\", DEFAULT_APP_ID)");
                String optString2 = jSONObject.optString("open_appid", "101490787");
                Intrinsics.checkNotNullExpressionValue(optString2, "configJson.optString(\"op\u2026EFAULT_LOGIN_AUTH_APP_ID)");
                int optInt = jSONObject.optInt("main_client_type", 406);
                int optInt2 = jSONObject.optInt("event_client_type", 17106);
                String optString3 = jSONObject.optString("trtc_appid", "1400515529");
                Intrinsics.checkNotNullExpressionValue(optString3, "configJson.optString(\"tr\u2026 DEFAULT_TRTC_SDK_APP_ID)");
                bVar = b.b(bVar, null, optString, null, null, optString2, optInt, optInt2, null, optString3, 141, null);
            }
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Login|QQLiveBizConfigRepo", "getQQLiveBusinessConfig", "getQQLiveBusinessConfig exception", e16);
        }
        b bVar2 = bVar;
        AegisLogger.INSTANCE.i("Login|QQLiveBizConfigRepo", "getQQLiveBusinessConfig", "config=" + bVar2);
        return bVar2;
    }

    public final void d(@NotNull Context context, @NotNull QQLiveEntrance entrance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) entrance);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(entrance, "entrance");
        e(context, entrance, true);
    }
}
