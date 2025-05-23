package com.tencent.biz.qqcircle.comment.sticker;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.comment.sticker.c;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends RecyclerView.OnScrollListener {

    /* renamed from: d, reason: collision with root package name */
    private final QFSCommentRecommendStickersView f83940d;

    public d(@NonNull QFSCommentRecommendStickersView qFSCommentRecommendStickersView) {
        this.f83940d = qFSCommentRecommendStickersView;
        qFSCommentRecommendStickersView.addOnScrollListener(this);
    }

    private boolean e(c.C0857c c0857c) {
        Rect rect = new Rect();
        if (c0857c.m() == null) {
            return false;
        }
        return c0857c.m().getGlobalVisibleRect(rect);
    }

    private void f(RecyclerView.ViewHolder viewHolder, boolean z16) {
        if (!(viewHolder instanceof c.C0857c)) {
            return;
        }
        c.C0857c c0857c = (c.C0857c) viewHolder;
        if (z16 && e(c0857c)) {
            c0857c.o();
        } else {
            c0857c.q();
        }
    }

    public void d(boolean z16) {
        LinearLayoutManager linearLayoutManager;
        QFSCommentRecommendStickersView qFSCommentRecommendStickersView = this.f83940d;
        if (qFSCommentRecommendStickersView == null) {
            return;
        }
        if (qFSCommentRecommendStickersView.getLayoutManager() instanceof LinearLayoutManager) {
            linearLayoutManager = (LinearLayoutManager) this.f83940d.getLayoutManager();
        } else {
            linearLayoutManager = null;
        }
        if (linearLayoutManager == null) {
            return;
        }
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        for (int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition(); findFirstVisibleItemPosition <= findLastVisibleItemPosition; findFirstVisibleItemPosition++) {
            f(this.f83940d.findViewHolderForAdapterPosition(findFirstVisibleItemPosition), z16);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
        super.onScrollStateChanged(recyclerView, i3);
        if (i3 == 1) {
            d(false);
            this.f83940d.G();
        } else if (i3 == 0) {
            d(true);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(@NonNull RecyclerView recyclerView, int i3, int i16) {
        super.onScrolled(recyclerView, i3, i16);
    }
}
