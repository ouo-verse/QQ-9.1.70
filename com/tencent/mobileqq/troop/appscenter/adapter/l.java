package com.tencent.mobileqq.troop.appscenter.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0017\u0010\u0018J&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0014J.\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0006H\u0014R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/troop/appscenter/adapter/l;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsListItemAdapterDelegate;", "Lcom/tencent/mobileqq/troop/appscenter/data/d;", "Lcom/tencent/mobileqq/troop/appscenter/data/a;", "Lcom/tencent/mobileqq/troop/appscenter/adapter/m;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "c", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "e", "holder", "", "payloads", "", "d", "Lds2/a;", "Lds2/a;", "delegateListener", "<init>", "(Lds2/a;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class l extends AbsListItemAdapterDelegate<com.tencent.mobileqq.troop.appscenter.data.d, com.tencent.mobileqq.troop.appscenter.data.a, m> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ds2.a delegateListener;

    public l(@NotNull ds2.a delegateListener) {
        Intrinsics.checkNotNullParameter(delegateListener, "delegateListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) delegateListener);
        } else {
            this.delegateListener = delegateListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(FrameLayout container, l this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(container, "$container");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        container.setVisibility(8);
        this$0.delegateListener.b();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull com.tencent.mobileqq.troop.appscenter.data.a item, @NotNull List<com.tencent.mobileqq.troop.appscenter.data.a> items, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, item, items, Integer.valueOf(position))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof com.tencent.mobileqq.troop.appscenter.data.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NotNull com.tencent.mobileqq.troop.appscenter.data.d item, @NotNull m holder, int position, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, item, holder, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        holder.itemView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public m onCreateViewHolder(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (m) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        final FrameLayout frameLayout = new FrameLayout(parent.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ViewUtils.getScreenHeight());
        layoutParams.gravity = 17;
        frameLayout.setLayoutParams(layoutParams);
        QUIEmptyState.Builder backgroundColorType = new QUIEmptyState.Builder(parent.getContext()).setImageType(5).setHalfScreenState(false).setBackgroundColorType(0);
        String string = parent.getContext().getString(R.string.f235987d5);
        Intrinsics.checkNotNullExpressionValue(string, "parent.context.getString\u2026eam_up_detail_load_error)");
        backgroundColorType.setTitle(string);
        String string2 = parent.getContext().getString(R.string.f236007d7);
        Intrinsics.checkNotNullExpressionValue(string2, "parent.context.getString\u2026team_up_detail_net_error)");
        backgroundColorType.setDesc(string2);
        String string3 = parent.getContext().getString(R.string.f236047da);
        Intrinsics.checkNotNullExpressionValue(string3, "parent.context.getString\u2026oop_team_up_detail_retry)");
        backgroundColorType.setButton(string3, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.appscenter.adapter.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.f(frameLayout, this, view);
            }
        });
        frameLayout.addView(backgroundColorType.build());
        return new m(frameLayout);
    }
}
