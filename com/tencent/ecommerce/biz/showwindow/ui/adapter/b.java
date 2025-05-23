package com.tencent.ecommerce.biz.showwindow.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import ck0.Category;
import com.tencent.ecommerce.biz.showwindow.viewmodel.ECShowWindowViewModel;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ$\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/ui/adapter/b;", "Lcom/tencent/ecommerce/biz/common/a;", "Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECShowWindowViewModel;", "", "position", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "Landroid/content/Context;", "context", "viewModel", "<init>", "(Landroid/content/Context;Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECShowWindowViewModel;)V", h.F, "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b extends com.tencent.ecommerce.biz.common.a<ECShowWindowViewModel> {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.showwindow.ui.adapter.b$b, reason: collision with other inner class name */
    /* loaded from: classes31.dex */
    static final class ViewOnClickListenerC1104b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Category f104753e;

        ViewOnClickListenerC1104b(Category category) {
            this.f104753e = category;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            b.this.c().r3(this.f104753e);
            b.this.c().m3(false);
            ECShowWindowViewModel c16 = b.this.c();
            String value = b.this.c().r2().getValue();
            if (value == null) {
                value = "";
            }
            ECShowWindowViewModel.z2(c16, 1, value, String.valueOf(this.f104753e.id), 0, null, false, false, null, 0, 504, null);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public b(Context context, ECShowWindowViewModel eCShowWindowViewModel) {
        super(context, eCShowWindowViewModel);
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            Object systemService = getContext().getSystemService("layout_inflater");
            if (systemService != null) {
                view = ((LayoutInflater) systemService).inflate(R.layout.cui, parent, false);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
            }
        } else {
            view = convertView;
        }
        TextView textView = view != null ? (TextView) view.findViewById(R.id.od9) : null;
        Category item = getItem(position);
        if (item != null) {
            if (textView != null) {
                textView.setText(item.name);
            }
            long j3 = item.id;
            Category value = c().q2().getValue();
            if (value == null || j3 != value.id) {
                if (textView != null) {
                    textView.setTextColor(getContext().getResources().getColor(R.color.f156572l1));
                }
                if (textView != null) {
                    textView.setBackgroundResource(R.drawable.blk);
                }
            } else {
                if (textView != null) {
                    textView.setTextColor(getContext().getResources().getColor(R.color.f156573l2));
                }
                if (textView != null) {
                    textView.setBackgroundResource(R.drawable.blm);
                }
            }
            if (view != null) {
                view.setOnClickListener(new ViewOnClickListenerC1104b(item));
            }
            Intrinsics.checkNotNull(view);
        } else {
            Intrinsics.checkNotNull(view);
        }
        EventCollector.getInstance().onListGetView(position, convertView, parent, getItemId(position));
        return view;
    }
}
