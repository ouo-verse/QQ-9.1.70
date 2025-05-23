package com.tenpay.sdk.fakeurl.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletFeatureApi;
import com.tenpay.sdk.QWalletFakeUrl;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\b\u0010\t\u001a\u00020\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tenpay/sdk/fakeurl/utils/FakeUrlUtils;", "", "()V", "isConfirmRequest", "", LayoutAttrDefine.CLICK_URI, "Landroid/net/Uri;", "data", "Lorg/json/JSONObject;", "isUseNewFakeUrl", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class FakeUrlUtils {

    @NotNull
    public static final FakeUrlUtils INSTANCE = new FakeUrlUtils();

    FakeUrlUtils() {
    }

    @JvmStatic
    public static final boolean isConfirmRequest(@Nullable Uri uri) {
        if (uri == null) {
            return false;
        }
        return TextUtils.equals(uri.getHost(), QWalletFakeUrl.FAKEURL_COMFIRM_REQUEST);
    }

    @JvmStatic
    public static final boolean isUseNewFakeUrl() {
        return ((IQWalletFeatureApi) QRoute.api(IQWalletFeatureApi.class)).isFeatureSwitch(IQWalletFeatureApi.QWALLET_NEW_FAKE_URL);
    }

    @JvmStatic
    public static final boolean isConfirmRequest(@Nullable JSONObject data) {
        boolean contains$default;
        if (data == null) {
            return false;
        }
        String jSONObject = data.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "data.toString()");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) jSONObject, (CharSequence) QWalletFakeUrl.FAKEURL_COMFIRM_REQUEST, false, 2, (Object) null);
        return contains$default;
    }
}
