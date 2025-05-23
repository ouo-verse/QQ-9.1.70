package com.tencent.ecommerce.biz.orders.sellerorders;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.biz.orders.sellerorders.container.ECSellerOrderTab;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import ki0.b;
import kotlin.Metadata;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/ECAbsSellerOrderFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/content/Context;", "context", "Landroid/view/View;", "Nh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "onResume", "", "P", "Ljava/lang/String;", "Lh", "()Ljava/lang/String;", "setChannel", "(Ljava/lang/String;)V", WadlProxyConsts.CHANNEL, "Lcom/tencent/ecommerce/biz/orders/sellerorders/container/ECSellerOrderTab;", "Mh", "()Lcom/tencent/ecommerce/biz/orders/sellerorders/container/ECSellerOrderTab;", "tabType", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class ECAbsSellerOrderFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private String channel = "";

    /* renamed from: Lh, reason: from getter */
    public final String getChannel() {
        return this.channel;
    }

    public abstract ECSellerOrderTab Mh();

    public abstract View Nh(Context context);

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        Intent intent;
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra(WadlProxyConsts.CHANNEL)) == null) {
            str = "";
        }
        this.channel = str;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        b.f412528a.f(this.channel, Mh());
    }
}
