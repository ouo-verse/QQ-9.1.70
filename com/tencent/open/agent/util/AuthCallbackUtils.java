package com.tencent.open.agent.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.QzoneIPCModule;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u000f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\"\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002R\u001b\u0010\u0015\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/open/agent/util/AuthCallbackUtils;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "resultIntent", "", "a", "", "e", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_SECOND, "b", "resultData", "d", "Lkotlin/Lazy;", "c", "()Z", "newCallbackSwitch", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class AuthCallbackUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AuthCallbackUtils f340590a = new AuthCallbackUtils();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy newCallbackSwitch;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.open.agent.util.AuthCallbackUtils$newCallbackSwitch$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("opensdk_auth_new_callback_api_switch", true);
                t.b("AuthCallbackUtils", "newCallbackSwitch: " + isSwitchOn);
                return Boolean.valueOf(isSwitchOn);
            }
        });
        newCallbackSwitch = lazy;
    }

    AuthCallbackUtils() {
    }

    @JvmStatic
    public static final void a(@NotNull Activity activity, int resultCode, @Nullable Intent resultIntent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AuthCallbackUtils authCallbackUtils = f340590a;
        boolean e16 = authCallbackUtils.e(activity);
        t.f("AuthCallbackUtils", "backToThirdAppAndFinish useNewCallback = " + e16);
        if (e16) {
            authCallbackUtils.d(activity, resultCode, resultIntent);
            Intent intent = new Intent();
            intent.putExtra("key_auth_ignore_on_activity_result", true);
            activity.setResult(-1, intent);
            return;
        }
        activity.setResult(resultCode, resultIntent);
    }

    private final boolean b(String first, String second) {
        boolean z16;
        List split$default;
        List split$default2;
        Integer intOrNull;
        int i3;
        Integer intOrNull2;
        int i16;
        if (first != null && first.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) first, new String[]{"."}, false, 0, 6, (Object) null);
        if (split$default.size() < 3) {
            return false;
        }
        split$default2 = StringsKt__StringsKt.split$default((CharSequence) second, new String[]{"."}, false, 0, 6, (Object) null);
        if (split$default2.size() < 3) {
            return false;
        }
        for (int i17 = 0; i17 < 3; i17++) {
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull((String) split$default.get(i17));
            if (intOrNull != null) {
                i3 = intOrNull.intValue();
            } else {
                i3 = 0;
            }
            intOrNull2 = StringsKt__StringNumberConversionsKt.toIntOrNull((String) split$default2.get(i17));
            if (intOrNull2 != null) {
                i16 = intOrNull2.intValue();
            } else {
                i16 = 0;
            }
            if (i3 != i16) {
                if (i3 > i16) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    private final boolean c() {
        return ((Boolean) newCallbackSwitch.getValue()).booleanValue();
    }

    private final boolean d(Activity activity, int resultCode, Intent resultData) {
        boolean z16;
        Long longOrNull;
        String format;
        Bundle bundle;
        t.f("AuthCallbackUtils", "sdk_share:sdk callback= " + resultCode);
        Intent intent = activity.getIntent();
        if (intent == null) {
            t.e("AuthCallbackUtils", "launchThirdAppAuthAct activity getIntent is null");
            return false;
        }
        String B = g.B(activity);
        if (B != null && B.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            t.e("AuthCallbackUtils", "launchThirdAppAuthAct pkgName is null");
            return false;
        }
        Bundle d16 = c.d(intent, "key_params");
        if (d16 == null) {
            t.e("AuthCallbackUtils", "launchThirdAppAuthAct paramsBundle is null");
            return false;
        }
        String string = d16.getString(CommonConstant.ReqAccessTokenParam.CLIENT_ID, "");
        Intrinsics.checkNotNullExpressionValue(string, "extraBundle.getString(Co\u2026ants.PARAM_CLIENT_ID, \"\")");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(string);
        if (longOrNull != null && longOrNull.longValue() > 0) {
            Intent intent2 = new Intent();
            if (resultCode == -1) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                format = String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", Arrays.copyOf(new Object[]{longOrNull, "action_auth"}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            } else {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                format = String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", Arrays.copyOf(new Object[]{longOrNull, "action_auth"}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            }
            intent2.setData(Uri.parse(format));
            intent2.putExtra("key_auth_result_code", resultCode);
            if (resultData != null) {
                bundle = resultData.getExtras();
            } else {
                bundle = null;
            }
            intent2.putExtra("key_auth_result_data", bundle);
            intent2.setFlags(603979776);
            String o16 = c.o(c.i(c.d(activity.getIntent(), "key_params"), "key_callback_act_name"));
            t.f("AuthCallbackUtils", "launchThirdAppAuthAct callbackActName: " + o16);
            if (TextUtils.isEmpty(o16)) {
                intent2.setPackage(B);
            } else {
                intent2.setClassName(B, o16);
            }
            try {
                t.f("AuthCallbackUtils", "startActivity");
                activity.startActivity(intent2);
                t.f("AuthCallbackUtils", "startActivity finish");
                return true;
            } catch (Exception e16) {
                t.a("AuthCallbackUtils", "startSdkCallback exception", e16);
                return false;
            }
        }
        t.e("AuthCallbackUtils", "launchThirdAppAuthAct appId error: " + longOrNull);
        return false;
    }

    private final boolean e(Activity activity) {
        if (!c()) {
            return false;
        }
        Bundle d16 = c.d(activity.getIntent(), "key_params");
        boolean z16 = true;
        if (c.f(d16, "key_callback_type", 0) != 1) {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        return b(c.i(d16, "sdkv"), "3.5.16");
    }
}
