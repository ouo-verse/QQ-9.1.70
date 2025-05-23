package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.model.SimpleSku;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitLauncherFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/os/Bundle;", "", "Lh", "Mh", "", "getContentLayoutId", "", "getBusinessDescription", Constants.FILE_INSTANCE_STATE, "", "onCreate", "<init>", "()V", "P", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECOrderSubmitLauncherFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J@\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0004H\u0007R\u0014\u0010\r\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitLauncherFragment$a;", "", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/model/SimpleSku;", "params", "", GetAdInfoRequest.SOURCE_FROM, WadlProxyConsts.CHANNEL, "", "contentId", "", "isFloatMode", "floatModeMarginTopDp", "a", "PARAM_BUY_ALL", "Ljava/lang/String;", "PARAM_CONTENT_ID", "PARAM_FLOAT_MODE", "PARAM_GROUP_ID", "PARAM_SKU_COUNT", "PARAM_SKU_ID", "PARAM_SOURCE_FROM", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitLauncherFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        public final String a(SimpleSku params, int sourceFrom, int channel, String contentId, boolean isFloatMode, int floatModeMarginTopDp) {
            Uri.Builder appendQueryParameter = Uri.parse("mqqapi://ecommerce/open").buildUpon().appendQueryParameter("target", "22").appendQueryParameter(WadlProxyConsts.CHANNEL, String.valueOf(channel)).appendQueryParameter("sku_id", params.skuId).appendQueryParameter("sku_num", String.valueOf(params.getQuantity())).appendQueryParameter("source_from", String.valueOf(sourceFrom));
            if (contentId != null) {
                appendQueryParameter.appendQueryParameter("content_id", contentId);
            }
            if (isFloatMode) {
                appendQueryParameter.appendQueryParameter("half", "1");
                appendQueryParameter.appendQueryParameter("is_trans_activity", "1");
                appendQueryParameter.appendQueryParameter(LayoutAttrDefine.MARGIN_TOP, String.valueOf(floatModeMarginTopDp));
            }
            return appendQueryParameter.build().toString();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ String b(Companion companion, SimpleSku simpleSku, int i3, int i16, String str, boolean z16, int i17, int i18, Object obj) {
            if ((i18 & 8) != 0) {
                str = null;
            }
            String str2 = str;
            if ((i18 & 16) != 0) {
                z16 = false;
            }
            boolean z17 = z16;
            if ((i18 & 32) != 0) {
                i17 = 224;
            }
            return companion.a(simpleSku, i3, i16, str2, z17, i17);
        }
    }

    private final boolean Lh(Bundle bundle) {
        if (bundle.containsKey("half")) {
            return Intrinsics.areEqual(bundle.getString("half"), "1");
        }
        Map<Object, Object> extUserDataMap = com.tencent.ecommerce.base.ktx.a.a(bundle, "ext_userdata").getExtUserDataMap();
        if (extUserDataMap.containsKey("half")) {
            return Intrinsics.areEqual(extUserDataMap.get("half"), "1");
        }
        return false;
    }

    private final boolean Mh(Bundle bundle) {
        if (bundle.containsKey("is_from_live")) {
            return Intrinsics.areEqual(bundle.getString("is_from_live"), "1");
        }
        Map<Object, Object> extUserDataMap = com.tencent.ecommerce.base.ktx.a.a(bundle, "ext_userdata").getExtUserDataMap();
        if (extUserDataMap.containsKey("is_from_live")) {
            return Intrinsics.areEqual(extUserDataMap.get("is_from_live"), "1");
        }
        return false;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECOrderSubmitLauncherFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cq5;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments == null) {
            finish();
            return;
        }
        boolean Lh = Lh(arguments);
        boolean Mh = Mh(arguments);
        if (Lh && Mh) {
            cg0.a.b("ECOrderSubmitLauncherFragment", "launch ECOrderSubmitDialogFragment");
            arguments.putString("is_trans_activity", "1");
            yi0.a.q(requireContext(), ECOrderSubmitDialogFragment.class, arguments, 0, null, 24, null);
        } else {
            cg0.a.b("ECOrderSubmitLauncherFragment", "launch ECOrderSubmitFragment");
            yi0.a.q(requireContext(), ECOrderSubmitFragment.class, arguments, 0, null, 24, null);
        }
        finish();
    }
}
