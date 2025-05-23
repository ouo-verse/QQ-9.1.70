package com.tencent.ecommerce.biz.pay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import cg0.a;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ark.ark;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.biz.pay.api.IECPayApi;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.dtreport.api.DefaultTVKDataProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/pay/ECEmptyPayFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "", "Mh", "", "getContentLayoutId", "", "getBusinessDescription", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "uh", "", "Eh", "Dh", "<init>", "()V", "P", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECEmptyPayFragment extends ECBaseFragment {

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/biz/pay/ECEmptyPayFragment$b", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$ECPayCallback;", "", "onPayNeedLogin", "Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$b;", "payResult", "onPayResult", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECPayApi.ECPayCallback {
        b() {
        }

        @Override // com.tencent.ecommerce.biz.pay.api.IECPayApi.ECPayCallback
        public void onPayNeedLogin() {
            a.b("ECEmptyPayFragment", "onPayNeedLogin");
        }

        @Override // com.tencent.ecommerce.biz.pay.api.IECPayApi.ECPayCallback
        public void onPayResult(IECPayApi.PayResult payResult) {
            ECEmptyPayFragment eCEmptyPayFragment = ECEmptyPayFragment.this;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", payResult.getCode());
            jSONObject.put(DefaultTVKDataProvider.KEY_PAY_TYPE, payResult.getPayChannel());
            Unit unit = Unit.INSTANCE;
            eCEmptyPayFragment.Mh(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Mh(JSONObject json) {
        Intent intent = new Intent();
        intent.putExtra("payResult", json.toString());
        requireActivity().setResult(-1, intent);
        finish();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Dh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECEmptyPayFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cq7;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onViewCreated(View view, Bundle savedInstanceState) {
        boolean z16;
        boolean isBlank;
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("url_params") : null;
        if (string != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(string);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("errCode", 2);
                    jSONObject.put("errMsg", "url params is null or empty");
                    Unit unit = Unit.INSTANCE;
                    Mh(jSONObject);
                    return;
                }
                IECPayApi.a.a(mi0.a.f416850b, requireActivity(), string, 1, 0, new b(), 8, null);
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int uh() {
        return getResources().getColor(R.color.f7153h);
    }
}
