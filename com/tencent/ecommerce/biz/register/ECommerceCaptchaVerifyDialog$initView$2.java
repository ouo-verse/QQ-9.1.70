package com.tencent.ecommerce.biz.register;

import androidx.fragment.app.FragmentActivity;
import com.tencent.ecommerce.base.ui.ECBaseDialogFragment;
import com.tencent.ecommerce.biz.register.ECommerceCaptchaVerifyDialog;
import com.tencent.ecommerce.biz.register.bridge.IECommerceBridgeListener;
import com.tencent.ecommerce.repo.register.ECaptcha;
import com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/register/ECommerceCaptchaVerifyDialog$initView$2", "Lcom/tencent/ecommerce/biz/register/bridge/IECommerceBridgeListener;", "onPageClose", "", "onPageReady", "onVerified", "data", "", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECommerceCaptchaVerifyDialog$initView$2 implements IECommerceBridgeListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ECommerceCaptchaVerifyDialog f103960a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECommerceCaptchaVerifyDialog$initView$2(ECommerceCaptchaVerifyDialog eCommerceCaptchaVerifyDialog) {
        this.f103960a = eCommerceCaptchaVerifyDialog;
    }

    @Override // com.tencent.ecommerce.biz.register.bridge.IECommerceBridgeListener
    public void onPageClose() {
        ECBaseDialogFragment.th(this.f103960a, ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult.Cancel.f103956d, 0, 2, null);
        this.f103960a.dismiss();
    }

    @Override // com.tencent.ecommerce.biz.register.bridge.IECommerceBridgeListener
    public void onPageReady() {
        long j3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("costTime ");
        long currentTimeMillis = System.currentTimeMillis();
        j3 = this.f103960a.startTime;
        sb5.append(currentTimeMillis - j3);
        cg0.a.b("ECommerceCaptchaVerifyDialog", sb5.toString());
        FragmentActivity activity = this.f103960a.getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.ecommerce.biz.register.ECommerceCaptchaVerifyDialog$initView$2$onPageReady$1
                @Override // java.lang.Runnable
                public final void run() {
                    ECommerceCaptchaVerifyDialog.xh(ECommerceCaptchaVerifyDialog$initView$2.this.f103960a).setVisibility(0);
                    ECommerceCaptchaVerifyDialog$initView$2.this.f103960a.sh(ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult.PageReady.f103957d, 1);
                }
            });
        }
    }

    @Override // com.tencent.ecommerce.biz.register.bridge.IECommerceBridgeListener
    public void onVerified(String data) {
        JSONObject jSONObject = new JSONObject(data);
        ECaptcha eCaptcha = new ECaptcha(null, null, 0, null, 15, null);
        eCaptcha.j(jSONObject.optString(MQPSecJsPlugin.KEY_RANDSTR));
        eCaptcha.k(jSONObject.optString("ticket"));
        eCaptcha.f(jSONObject.optInt("errorCode", 0));
        eCaptcha.g(jSONObject.optString("errorMessage"));
        ECBaseDialogFragment.th(this.f103960a, new ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult.Verified(eCaptcha), 0, 2, null);
        this.f103960a.dismiss();
    }
}
