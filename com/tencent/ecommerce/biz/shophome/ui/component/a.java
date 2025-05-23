package com.tencent.ecommerce.biz.shophome.ui.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ecommerce.base.ktx.ImageViewKt;
import com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/component/a;", "Lcom/tencent/ecommerce/biz/shophome/ui/component/IECShopHomeComponent;", "Landroid/view/View;", "getComponentView", "Lorg/json/JSONObject;", "abnormal", "", "a", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "abnormalIconView", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "abnormalDescView", "c", "Landroid/view/View;", "componentView", "Landroid/content/Context;", "d", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a implements IECShopHomeComponent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ImageView abnormalIconView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private TextView abnormalDescView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private View componentView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    public a(Context context) {
        this.context = context;
        View inflate = View.inflate(context, R.layout.cu_, null);
        this.componentView = inflate;
        this.abnormalIconView = (ImageView) inflate.findViewById(R.id.np6);
        this.abnormalDescView = (TextView) this.componentView.findViewById(R.id.np5);
    }

    public final void a(JSONObject abnormal) {
        String optString = abnormal.optString("pic_url");
        String optString2 = abnormal.optString("description");
        if (!TextUtils.isEmpty(optString2)) {
            this.abnormalDescView.setText(optString2);
        }
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        ImageViewKt.b(this.abnormalIconView, optString, com.tencent.ecommerce.biz.util.e.c(188.0f), com.tencent.ecommerce.biz.util.e.c(120.0f), 0, 8, null);
    }

    @Override // com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent
    public View getComponentView() {
        return this.componentView;
    }

    @Override // com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent
    public void setComponentViewVisibility(int i3) {
        IECShopHomeComponent.a.a(this, i3);
    }
}
