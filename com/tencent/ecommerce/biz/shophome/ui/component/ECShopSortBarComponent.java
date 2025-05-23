package com.tencent.ecommerce.biz.shophome.ui.component;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.shophome.model.ECOrderByTabInfo;
import com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent;
import com.tencent.ecommerce.biz.shophome.util.ECShopReportParams;
import com.tencent.ecommerce.biz.util.u;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001&B3\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001d\u0012\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u0004\u0018\u00010\u0006J\u0014\u0010\r\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bJ\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0006R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00198\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001eR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopSortBarComponent;", "Lcom/tencent/ecommerce/biz/shophome/ui/component/IECShopHomeComponent;", "", "e", "Landroid/view/View;", "orderByTabItemView", "Lcom/tencent/ecommerce/biz/shophome/model/a;", "orderByTabInfo", "g", "getComponentView", "d", "", "orderByTabInfoList", "i", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopSortBarComponent$IOrderByTabItemSelectedListener;", "listener", "f", "selectedOrderByTabInfo", h.F, "Landroid/widget/LinearLayout;", "a", "Landroid/widget/LinearLayout;", "componentView", "b", "Lcom/tencent/ecommerce/biz/shophome/model/a;", "Landroid/content/Context;", "c", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "arguments", "Ljava/util/List;", "orderByInfoList", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopSortBarComponent$IOrderByTabItemSelectedListener;", "orderByTabItemSelectedListener", "<init>", "(Landroid/content/Context;Landroid/os/Bundle;Ljava/util/List;Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopSortBarComponent$IOrderByTabItemSelectedListener;)V", "IOrderByTabItemSelectedListener", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopSortBarComponent implements IECShopHomeComponent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final LinearLayout componentView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ECOrderByTabInfo selectedOrderByTabInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final Bundle arguments;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<ECOrderByTabInfo> orderByInfoList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private IOrderByTabItemSelectedListener orderByTabItemSelectedListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopSortBarComponent$IOrderByTabItemSelectedListener;", "", "Lcom/tencent/ecommerce/biz/shophome/model/a;", "orderByTabInfo", "", "onOrderByTabItemSelected", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public interface IOrderByTabItemSelectedListener {
        void onOrderByTabItemSelected(ECOrderByTabInfo orderByTabInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ECOrderByTabInfo f104310e;

        a(ECOrderByTabInfo eCOrderByTabInfo) {
            this.f104310e = eCOrderByTabInfo;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            String str;
            IOrderByTabItemSelectedListener iOrderByTabItemSelectedListener;
            ECOrderByTabInfo eCOrderByTabInfo;
            EventCollector.getInstance().onViewClickedBefore(view);
            ECOrderByTabInfo eCOrderByTabInfo2 = ECShopSortBarComponent.this.selectedOrderByTabInfo;
            ECOrderByTabInfo eCOrderByTabInfo3 = this.f104310e;
            if (eCOrderByTabInfo2 != eCOrderByTabInfo3) {
                ECShopSortBarComponent.this.selectedOrderByTabInfo = eCOrderByTabInfo3;
            } else if (eCOrderByTabInfo3.getOrderByValue() == 1) {
                this.f104310e.b(2);
            } else if (this.f104310e.getOrderByValue() == 2 || this.f104310e.getOrderByValue() == 0) {
                this.f104310e.b(1);
            }
            ECOrderByTabInfo eCOrderByTabInfo4 = ECShopSortBarComponent.this.selectedOrderByTabInfo;
            if (eCOrderByTabInfo4 != null && eCOrderByTabInfo4.getOrderByValue() == 0 && (eCOrderByTabInfo = ECShopSortBarComponent.this.selectedOrderByTabInfo) != null) {
                eCOrderByTabInfo.b(1);
            }
            ECOrderByTabInfo eCOrderByTabInfo5 = ECShopSortBarComponent.this.selectedOrderByTabInfo;
            if (eCOrderByTabInfo5 != null && (iOrderByTabItemSelectedListener = ECShopSortBarComponent.this.orderByTabItemSelectedListener) != null) {
                iOrderByTabItemSelectedListener.onOrderByTabItemSelected(eCOrderByTabInfo5);
            }
            com.tencent.ecommerce.biz.shophome.util.a aVar = com.tencent.ecommerce.biz.shophome.util.a.f104379a;
            ECShopReportParams c16 = aVar.c(ECShopSortBarComponent.this.arguments);
            String str2 = c16.role;
            String str3 = c16.shopId;
            String str4 = c16.source;
            ECOrderByTabInfo eCOrderByTabInfo6 = ECShopSortBarComponent.this.selectedOrderByTabInfo;
            if (eCOrderByTabInfo6 == null || (str = eCOrderByTabInfo6.orderByKey) == null) {
                str = "";
            }
            String str5 = str;
            ECOrderByTabInfo eCOrderByTabInfo7 = ECShopSortBarComponent.this.selectedOrderByTabInfo;
            aVar.u(str2, str3, str4, str5, eCOrderByTabInfo7 != null ? eCOrderByTabInfo7.getOrderByValue() : 0);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECShopSortBarComponent(Context context, Bundle bundle, List<ECOrderByTabInfo> list, IOrderByTabItemSelectedListener iOrderByTabItemSelectedListener) {
        this.context = context;
        this.arguments = bundle;
        this.orderByInfoList = list;
        this.orderByTabItemSelectedListener = iOrderByTabItemSelectedListener;
        this.componentView = new LinearLayout(context);
        e();
    }

    private final void e() {
        if (!this.orderByInfoList.isEmpty()) {
            this.selectedOrderByTabInfo = this.orderByInfoList.get(0);
        }
        if (this.componentView.getLayoutParams() == null) {
            this.componentView.setLayoutParams(new ViewGroup.LayoutParams(-1, com.tencent.ecommerce.biz.util.e.c(36.0f)));
        } else {
            this.componentView.getLayoutParams().height = com.tencent.ecommerce.biz.util.e.c(36.0f);
        }
        this.componentView.setOrientation(0);
        this.componentView.setGravity(16);
        this.componentView.setBackground(ECSkin.INSTANCE.getDrawable(R.drawable.bu8));
        this.componentView.removeAllViews();
        int i3 = 0;
        for (ECOrderByTabInfo eCOrderByTabInfo : this.orderByInfoList) {
            View inflate = View.inflate(this.context, R.layout.cug, null);
            TextView textView = (TextView) inflate.findViewById(R.id.oee);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.o1y);
            textView.setText(eCOrderByTabInfo.orderByName);
            ECOrderByTabInfo eCOrderByTabInfo2 = this.selectedOrderByTabInfo;
            if (Intrinsics.areEqual(eCOrderByTabInfo2 != null ? eCOrderByTabInfo2.orderByKey : null, eCOrderByTabInfo.orderByKey)) {
                textView.setTextColor(ECSkin.INSTANCE.getColor(R.color.f6952y));
                ECOrderByTabInfo eCOrderByTabInfo3 = this.selectedOrderByTabInfo;
                if (eCOrderByTabInfo3 != null && eCOrderByTabInfo3.getOrderByValue() == -1) {
                    imageView.setVisibility(8);
                } else {
                    if (eCOrderByTabInfo.getOrderByValue() == 1) {
                        imageView.setImageResource(R.drawable.f159681bk4);
                    } else {
                        imageView.setImageResource(R.drawable.bk6);
                    }
                    imageView.setVisibility(0);
                }
                u.a(textView, R.string.wkd);
            } else {
                textView.setTextColor(ECSkin.INSTANCE.getColor(R.color.f6962z));
                if (eCOrderByTabInfo.getOrderByValue() == -1) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setImageResource(R.drawable.bk5);
                    imageView.setVisibility(0);
                }
                u.a(textView, R.string.wke);
            }
            g(inflate, eCOrderByTabInfo);
            if (i3 != 0 && i3 != this.orderByInfoList.size() - 1) {
                this.componentView.addView(inflate, new LinearLayout.LayoutParams(-2, -2, 1.0f));
            } else {
                this.componentView.addView(inflate);
            }
            i3++;
        }
    }

    private final void g(View orderByTabItemView, ECOrderByTabInfo orderByTabInfo) {
        orderByTabItemView.setOnClickListener(new a(orderByTabInfo));
    }

    /* renamed from: d, reason: from getter */
    public final ECOrderByTabInfo getSelectedOrderByTabInfo() {
        return this.selectedOrderByTabInfo;
    }

    public final void f(IOrderByTabItemSelectedListener listener) {
        this.orderByTabItemSelectedListener = listener;
    }

    @Override // com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent
    public View getComponentView() {
        return this.componentView;
    }

    public final void h(ECOrderByTabInfo selectedOrderByTabInfo) {
        this.selectedOrderByTabInfo = selectedOrderByTabInfo;
        int childCount = this.componentView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = this.componentView.getChildAt(i3);
            TextView textView = (TextView) childAt.findViewById(R.id.oee);
            ImageView imageView = (ImageView) childAt.findViewById(R.id.o1y);
            if (Intrinsics.areEqual(textView.getText(), selectedOrderByTabInfo.orderByName)) {
                textView.setTextColor(ECSkin.INSTANCE.getColor(R.color.f156568kd));
                if (imageView.getVisibility() == 0) {
                    if (selectedOrderByTabInfo.getOrderByValue() == 1) {
                        imageView.setImageResource(R.drawable.env);
                    } else {
                        imageView.setImageResource(R.drawable.enu);
                    }
                }
                u.a(textView, R.string.wkd);
            } else {
                textView.setTextColor(ECSkin.INSTANCE.getColor(R.color.f156569ky));
                if (imageView.getVisibility() == 0) {
                    imageView.setImageResource(R.drawable.ent);
                }
                u.a(textView, R.string.wke);
            }
        }
    }

    public final void i(List<ECOrderByTabInfo> orderByTabInfoList) {
        this.orderByInfoList = orderByTabInfoList;
        e();
    }

    @Override // com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent
    public void setComponentViewVisibility(int i3) {
        IECShopHomeComponent.a.a(this, i3);
    }

    public /* synthetic */ ECShopSortBarComponent(Context context, Bundle bundle, List list, IOrderByTabItemSelectedListener iOrderByTabItemSelectedListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, bundle, list, (i3 & 8) != 0 ? null : iOrderByTabItemSelectedListener);
    }
}
