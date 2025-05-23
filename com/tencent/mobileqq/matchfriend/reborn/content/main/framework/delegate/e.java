package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.delegate;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.reborn.content.main.framework.event.QQStrangerSquareRefreshEvent;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import t72.h;
import u72.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0014J.\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/delegate/e;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsListItemAdapterDelegate;", "Lu72/b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "c", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "onCreateViewHolder", "holder", "", "payloads", "", "d", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class e extends AbsListItemAdapterDelegate<u72.b, u72.b, RecyclerView.ViewHolder> {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(View view) {
        SimpleEventBus.getInstance().dispatchEvent(QQStrangerSquareRefreshEvent.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(u72.b item, List<u72.b> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return Intrinsics.areEqual(item, b.a.f438519a) || Intrinsics.areEqual(item, b.d.f438522a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(u72.b item, RecyclerView.ViewHolder holder, int position, List<Object> payloads) {
        QUIEmptyState.Builder title;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Context context = holder.itemView.getContext();
        if (Intrinsics.areEqual(item, b.d.f438522a)) {
            QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(context).setImageType(5);
            String string = context.getString(R.string.x0e);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026tch_friend_network_error)");
            QUIEmptyState.Builder title2 = imageType.setTitle(string);
            String string2 = context.getString(R.string.x3w);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026qq_stranger_square_retry)");
            title = title2.setButton(string2, new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.main.framework.delegate.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.e(view);
                }
            });
        } else {
            QUIEmptyState.Builder imageType2 = new QUIEmptyState.Builder(holder.itemView.getContext()).setImageType(16);
            String string3 = context.getString(R.string.x3s);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026qq_stranger_square_empty)");
            title = imageType2.setTitle(string3);
        }
        QUIEmptyState build = title.setHalfScreenState(true).setBackgroundColorType(0).build();
        FrameLayout frameLayout = (FrameLayout) holder.itemView.findViewById(R.id.f163165on4);
        if (frameLayout == null) {
            return;
        }
        frameLayout.removeAllViews();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        Unit unit = Unit.INSTANCE;
        frameLayout.addView(build, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        FrameLayout frameLayout = new FrameLayout(parent.getContext());
        frameLayout.setId(R.id.f163165on4);
        return h.a(com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.f.a(frameLayout));
    }
}
