package com.tencent.biz.qqcircle.immersive.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.interesttag.QFSInterestTagItemView;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/adapter/f;", "Lcom/tencent/biz/qqcircle/immersive/adapter/a;", "Lqqcircle/QQCircleDitto$StItemInfo;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateItemViewHolder", "holder", "position", "", "onBindViewHolder", "<init>", "()V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class f extends com.tencent.biz.qqcircle.immersive.adapter.a<QQCircleDitto$StItemInfo> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/adapter/f$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lqqcircle/QQCircleDitto$StItemInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "", com.tencent.luggage.wxa.c8.c.G, "", "l", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    private static final class a extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }

        public final void l(@NotNull QQCircleDitto$StItemInfo userInfo, int pos) {
            Intrinsics.checkNotNullParameter(userInfo, "userInfo");
            View view = this.itemView;
            if (!(view instanceof QFSInterestTagItemView)) {
                return;
            }
            ((QFSInterestTagItemView) view).bindData(userInfo, pos);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        List<E> list = this.mDataList;
        if (list != 0 && position <= list.size() && this.mDataList.get(position) != null && (holder instanceof a)) {
            Object obj = this.mDataList.get(position);
            Intrinsics.checkNotNullExpressionValue(obj, "mDataList[position]");
            ((a) holder).l((QQCircleDitto$StItemInfo) obj, position);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.adapter.a
    @NotNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return new a(new QFSInterestTagItemView(context));
    }
}
