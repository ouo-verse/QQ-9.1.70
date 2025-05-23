package com.tencent.mobileqq.vas.adv.maskad;

import android.content.Context;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.preload.api.IVasMaskAdvPreloadApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/maskad/MaskAdLoadHelper;", "", "()V", "TAG", "", "checkIsFullScreenDisplay", "", "context", "Landroid/content/Context;", "getCurrentUin", "", "isStartRealTimeLoad", "ad", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "expInfo", "Ltencent/gdt/access$ExpInfo;", "vas-adv-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class MaskAdLoadHelper {

    @NotNull
    public static final MaskAdLoadHelper INSTANCE = new MaskAdLoadHelper();

    @NotNull
    private static final String TAG = "MaskAdLoadHelper";

    MaskAdLoadHelper() {
    }

    public final boolean checkIsFullScreenDisplay(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullExpressionValue(context.getResources().getDisplayMetrics(), "context.resources.displayMetrics");
        if (r2.heightPixels / r2.widthPixels > 1.7777778f) {
            return true;
        }
        return false;
    }

    public final long getCurrentUin() {
        try {
            return MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "get uin failed, error is " + th5);
            return 0L;
        }
    }

    public final boolean isStartRealTimeLoad(@NotNull qq_ad_get.QQAdGetRsp.AdInfo ad5, @Nullable access.ExpInfo expInfo) {
        String str;
        boolean equals$default;
        String str2;
        boolean z16;
        PBStringField pBStringField;
        String str3;
        PBStringField pBStringField2;
        PBStringField pBStringField3;
        Intrinsics.checkNotNullParameter(ad5, "ad");
        if (!((IVasMaskAdvPreloadApi) QRoute.api(IVasMaskAdvPreloadApi.class)).isImageMaskAd(new GdtAd(ad5).getInnerShowType())) {
            return false;
        }
        Float f16 = null;
        if (expInfo != null && (pBStringField3 = expInfo.key) != null) {
            str = pBStringField3.get();
        } else {
            str = null;
        }
        equals$default = StringsKt__StringsJVMKt.equals$default(str, "limitTime", false, 2, null);
        if (!equals$default) {
            return false;
        }
        if (expInfo != null && (pBStringField2 = expInfo.value) != null) {
            str2 = pBStringField2.get();
        } else {
            str2 = null;
        }
        if (str2 != null && str2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        if (expInfo != null && (pBStringField = expInfo.value) != null && (str3 = pBStringField.get()) != null) {
            f16 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(str3);
        }
        if (f16 == null || f16.floatValue() <= 0.0f) {
            return false;
        }
        return true;
    }
}
