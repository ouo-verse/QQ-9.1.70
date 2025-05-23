package com.qzone.reborn.message.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedx.widget.comment.QZoneFeedxCommentImageItem;
import com.qzone.reborn.feedx.widget.comment.a;
import com.qzone.reborn.util.r;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/message/adapter/QZonePassiveMessageCommentImageAdapter;", "Lcom/qzone/reborn/feedx/widget/comment/a;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onCreateItemViewHolder", "D", "I", "getRoundRadius", "()I", "m0", "(I)V", "roundRadius", "E", "k0", "l0", "imageSize", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZonePassiveMessageCommentImageAdapter extends a {

    /* renamed from: D, reason: from kotlin metadata */
    private int roundRadius;

    /* renamed from: E, reason: from kotlin metadata */
    private int imageSize;

    public QZonePassiveMessageCommentImageAdapter() {
        r rVar = r.f59560a;
        this.roundRadius = rVar.e(4);
        this.imageSize = rVar.e(64);
    }

    /* renamed from: k0, reason: from getter */
    public final int getImageSize() {
        return this.imageSize;
    }

    public final void l0(int i3) {
        this.imageSize = i3;
    }

    public final void m0(int i3) {
        this.roundRadius = i3;
    }

    @Override // com.qzone.reborn.feedx.widget.comment.a, com.qzone.reborn.base.i
    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        final Context context = parent.getContext();
        QZoneFeedxCommentImageItem qZoneFeedxCommentImageItem = new QZoneFeedxCommentImageItem(context) { // from class: com.qzone.reborn.message.adapter.QZonePassiveMessageCommentImageAdapter$onCreateItemViewHolder$itemView$1
            @Override // com.qzone.reborn.feedx.widget.comment.QZoneFeedxCommentImageItem
            protected int q0() {
                return QZonePassiveMessageCommentImageAdapter.this.getImageSize();
            }
        };
        qZoneFeedxCommentImageItem.setRoundRect(this.roundRadius);
        return new a.C0471a(qZoneFeedxCommentImageItem);
    }
}
