package com.tencent.ecommerce.biz.shophome.ui.component;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.R;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/component/e;", "Lcom/tencent/ecommerce/biz/shophome/ui/component/IECShopHomeComponent;", "", "a", "Landroid/view/View;", "getComponentView", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", HippyQQConstants.URL_COMPONENT_NAME, "Landroid/content/Context;", "b", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "c", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class e implements IECShopHomeComponent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout component;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    public e(Context context) {
        this.context = context;
        this.component = new LinearLayout(context);
        a();
    }

    private final void a() {
        this.component.setLayoutParams(new LinearLayout.LayoutParams(-1, com.tencent.ecommerce.biz.util.e.c(8.0f)));
        this.component.setGravity(17);
        this.component.setBackgroundColor(ECSkin.INSTANCE.getColor(R.color.f6471n));
    }

    @Override // com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent
    public View getComponentView() {
        return this.component;
    }

    @Override // com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent
    public void setComponentViewVisibility(int i3) {
        IECShopHomeComponent.a.a(this, i3);
    }
}
