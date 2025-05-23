package com.qzone.reborn.feedx.widget.comment;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.reborn.base.i;
import com.qzone.reborn.feedx.widget.comment.QZoneFeedxCommentImageItem;
import com.qzone.reborn.feedx.widget.comment.a;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class a extends i<PictureItem> {
    private QZoneFeedxCommentImageItem.d C;

    /* renamed from: m, reason: collision with root package name */
    private Comment f56015m;

    public void i0(Comment comment) {
        this.f56015m = comment;
    }

    public void j0(QZoneFeedxCommentImageItem.d dVar) {
        this.C = dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof C0471a) {
            ((C0471a) viewHolder).n((ArrayList) getDataList(), i3, this.f56015m, this.C);
        }
    }

    @Override // com.qzone.reborn.base.i
    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup viewGroup, int i3) {
        return new C0471a(new QZoneFeedxCommentImageItem(viewGroup.getContext()));
    }

    /* compiled from: P */
    /* renamed from: com.qzone.reborn.feedx.widget.comment.a$a, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    protected static class C0471a extends RecyclerView.ViewHolder {
        public C0471a(View view) {
            super(view);
        }

        public void n(ArrayList<PictureItem> arrayList, int i3, Comment comment, final QZoneFeedxCommentImageItem.d dVar) {
            View view = this.itemView;
            if (view instanceof QZoneFeedxCommentImageItem) {
                ((QZoneFeedxCommentImageItem) view).setCommentData(comment);
                ((QZoneFeedxCommentImageItem) this.itemView).setPicList(arrayList);
                ((QZoneFeedxCommentImageItem) this.itemView).setData(arrayList.get(i3), i3);
                ((QZoneFeedxCommentImageItem) this.itemView).setOnImageLongClickListener(new QZoneFeedxCommentImageItem.d() { // from class: oh.g
                    @Override // com.qzone.reborn.feedx.widget.comment.QZoneFeedxCommentImageItem.d
                    public final void a(View view2, int i16) {
                        a.C0471a.m(QZoneFeedxCommentImageItem.d.this, view2, i16);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void m(QZoneFeedxCommentImageItem.d dVar, View view, int i3) {
            if (dVar != null) {
                dVar.a(view, i3);
            }
        }
    }
}
