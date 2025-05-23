package com.tencent.ecommerce.biz.shophome.ui.component;

import android.view.View;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/component/IECShopHomeComponent;", "", "getComponentView", "Landroid/view/View;", "setComponentViewVisibility", "", "visibility", "", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public interface IECShopHomeComponent {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a {
        public static void a(IECShopHomeComponent iECShopHomeComponent, int i3) {
            iECShopHomeComponent.getComponentView().setVisibility(i3);
        }
    }

    View getComponentView();

    void setComponentViewVisibility(int visibility);
}
