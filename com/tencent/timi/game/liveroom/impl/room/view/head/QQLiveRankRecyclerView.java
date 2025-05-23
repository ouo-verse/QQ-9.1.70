package com.tencent.timi.game.liveroom.impl.room.view.head;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/head/QQLiveRankRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", BdhLogUtil.LogTag.Tag_Conn, "", "getLeftFadingEdgeStrength", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLiveRankRecyclerView extends RecyclerView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveRankRecyclerView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    public final void C() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        setLayoutManager(linearLayoutManager);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        setAdapter(new z(context));
    }

    @Override // android.view.View
    protected float getLeftFadingEdgeStrength() {
        return 0.0f;
    }
}
