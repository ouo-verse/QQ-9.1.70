package com.tencent.ecommerce.biz.shophome.ui.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.shophome.model.ECShopTabInfo;
import com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent;
import com.tencent.ecommerce.biz.util.u;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0002\r\u001eB)\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopTabBarComponent;", "Lcom/tencent/ecommerce/biz/shophome/ui/component/IECShopHomeComponent;", "", "c", "Landroid/view/View;", "tabItemView", "Lcom/tencent/ecommerce/biz/shophome/model/d;", "tabInfo", "d", "getComponentView", "selectedTabInfo", "e", "Landroid/widget/LinearLayout;", "a", "Landroid/widget/LinearLayout;", "componentView", "b", "Lcom/tencent/ecommerce/biz/shophome/model/d;", "Landroid/content/Context;", "Landroid/content/Context;", "context", "", "Ljava/util/List;", "tabInfoList", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopTabBarComponent$ITabBarItemSelectedListener;", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopTabBarComponent$ITabBarItemSelectedListener;", "tabBarItemSelectedListener", "<init>", "(Landroid/content/Context;Ljava/util/List;Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopTabBarComponent$ITabBarItemSelectedListener;)V", "f", "ITabBarItemSelectedListener", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopTabBarComponent implements IECShopHomeComponent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout componentView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ECShopTabInfo selectedTabInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final List<ECShopTabInfo> tabInfoList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ITabBarItemSelectedListener tabBarItemSelectedListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopTabBarComponent$ITabBarItemSelectedListener;", "", "Lcom/tencent/ecommerce/biz/shophome/model/d;", "tabInfo", "", "onTabBarItemSelected", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public interface ITabBarItemSelectedListener {
        void onTabBarItemSelected(ECShopTabInfo tabInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ECShopTabInfo f104318e;

        b(ECShopTabInfo eCShopTabInfo) {
            this.f104318e = eCShopTabInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECShopTabBarComponent.this.selectedTabInfo = this.f104318e;
            ITabBarItemSelectedListener iTabBarItemSelectedListener = ECShopTabBarComponent.this.tabBarItemSelectedListener;
            if (iTabBarItemSelectedListener != null) {
                iTabBarItemSelectedListener.onTabBarItemSelected(this.f104318e);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECShopTabBarComponent(Context context, List<ECShopTabInfo> list, ITabBarItemSelectedListener iTabBarItemSelectedListener) {
        this.context = context;
        this.tabInfoList = list;
        this.tabBarItemSelectedListener = iTabBarItemSelectedListener;
        this.componentView = new LinearLayout(context);
        c();
    }

    private final void c() {
        if (!this.tabInfoList.isEmpty()) {
            this.selectedTabInfo = this.tabInfoList.get(0);
        }
        this.componentView.setLayoutParams(new ViewGroup.LayoutParams(-1, com.tencent.ecommerce.biz.util.e.c(44.0f)));
        this.componentView.setOrientation(0);
        this.componentView.setGravity(16);
        this.componentView.setBackgroundColor(ECSkin.INSTANCE.getColor(R.color.f6491p));
        for (ECShopTabInfo eCShopTabInfo : this.tabInfoList) {
            View inflate = View.inflate(this.context, R.layout.cuh, null);
            TextView textView = (TextView) inflate.findViewById(R.id.oeh);
            View findViewById = inflate.findViewById(R.id.f163123of2);
            textView.setText(eCShopTabInfo.tabName);
            ECShopTabInfo eCShopTabInfo2 = this.selectedTabInfo;
            if (Intrinsics.areEqual(eCShopTabInfo2 != null ? eCShopTabInfo2.tabName : null, eCShopTabInfo.tabName)) {
                findViewById.setVisibility(0);
                u.a(textView, R.string.wkd);
            } else {
                findViewById.setVisibility(4);
                u.a(textView, R.string.wke);
            }
            d(inflate, eCShopTabInfo);
            this.componentView.addView(inflate);
        }
    }

    private final void d(View tabItemView, ECShopTabInfo tabInfo) {
        tabItemView.setOnClickListener(new b(tabInfo));
    }

    public final void e(ECShopTabInfo selectedTabInfo) {
        int childCount = this.componentView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.componentView.getChildAt(i3);
            TextView textView = (TextView) childAt.findViewById(R.id.oeh);
            View findViewById = childAt.findViewById(R.id.f163123of2);
            if (Intrinsics.areEqual(textView.getText(), selectedTabInfo.tabName)) {
                findViewById.setVisibility(0);
                u.a(textView, R.string.wkd);
            } else {
                findViewById.setVisibility(4);
                u.a(textView, R.string.wke);
            }
        }
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
