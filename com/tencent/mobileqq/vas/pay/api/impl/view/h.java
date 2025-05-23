package com.tencent.mobileqq.vas.pay.api.impl.view;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.pay.api.impl.VasNativePayManagerImpl;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J$\u0010\r\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/vas/pay/api/impl/view/h;", "Landroid/widget/BaseAdapter;", "", "getCount", "position", "", "getItem", "", "getItemId", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/widget/AdapterView$OnItemClickListener;", "e", "Landroid/widget/AdapterView$OnItemClickListener;", "getOnItemClickListener", "()Landroid/widget/AdapterView$OnItemClickListener;", "onItemClickListener", "", "f", "Z", "getMIsNightMode", "()Z", "mIsNightMode", "<init>", "(Landroid/content/Context;Landroid/widget/AdapterView$OnItemClickListener;Z)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class h extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AdapterView.OnItemClickListener onItemClickListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean mIsNightMode;

    public h(@NotNull Context context, @NotNull AdapterView.OnItemClickListener onItemClickListener, boolean z16) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        this.context = context;
        this.onItemClickListener = onItemClickListener;
        this.mIsNightMode = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(h this$0, j this_apply, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        this$0.onItemClickListener.onItemClick(null, this_apply.getKeyView(), i3, this_apply.getKeyView().getId());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return 9;
    }

    @Override // android.widget.Adapter
    @NotNull
    public Object getItem(int position) {
        return Unit.INSTANCE;
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    @NotNull
    public View getView(final int position, @Nullable View convertView, @Nullable ViewGroup parent) {
        View keyView;
        if (convertView != null) {
            keyView = convertView;
        } else {
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.f168961hh4, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026tem_digit_keyboard, null)");
            final j jVar = new j(inflate);
            jVar.getBtn().setText(i.a(position));
            jVar.getBtn().setTypeface(Typeface.createFromAsset(jVar.getBtn().getResources().getAssets(), VasNativePayManagerImpl.DINALTERNATE_BOLD_FONT_PATH));
            jVar.getBtn().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.pay.api.impl.view.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h.b(h.this, jVar, position, view);
                }
            });
            if (this.mIsNightMode) {
                jVar.getBtn().setBackgroundResource(R.drawable.l_u);
                jVar.getBtn().setTextColor(-1);
            } else {
                jVar.getBtn().setBackgroundResource(R.drawable.l_v);
                jVar.getBtn().setTextColor(-16777216);
            }
            keyView = jVar.getKeyView();
        }
        EventCollector.getInstance().onListGetView(position, convertView, parent, getItemId(position));
        return keyView;
    }
}
