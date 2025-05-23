package com.tencent.biz.qqcircle.comment;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.comment.widget.QFSCommentAreaCommentView;
import com.tencent.biz.qqcircle.comment.widget.QFSCommentAreaTabLikeView;
import com.tencent.biz.qqcircle.comment.widget.QFSCommentAreaTabPushView;
import cooperation.qqcircle.report.QCircleReportBean;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends RecyclerView.Adapter<a> {
    private QFSCommentAreaTabLikeView C;
    private QFSCommentAreaTabPushView D;
    private QFSCommentAreaCommentView E;
    private QCircleReportBean F;

    /* renamed from: m, reason: collision with root package name */
    private int f83534m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.ViewHolder {
        public a(@NonNull View view) {
            super(view);
        }
    }

    public e(QCircleReportBean qCircleReportBean) {
        this.F = qCircleReportBean;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.f83534m;
    }

    public View i0(int i3) {
        if (i3 == 0) {
            return this.E;
        }
        if (i3 == 1) {
            return this.C;
        }
        if (i3 == 2) {
            return this.D;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -1);
        if (i3 == 1) {
            QFSCommentAreaTabLikeView qFSCommentAreaTabLikeView = new QFSCommentAreaTabLikeView(viewGroup.getContext());
            this.C = qFSCommentAreaTabLikeView;
            qFSCommentAreaTabLikeView.setLayoutParams(layoutParams);
            return new a(this.C);
        }
        if (i3 == 2) {
            QFSCommentAreaTabPushView qFSCommentAreaTabPushView = new QFSCommentAreaTabPushView(viewGroup.getContext());
            this.D = qFSCommentAreaTabPushView;
            qFSCommentAreaTabPushView.setLayoutParams(layoutParams);
            return new a(this.D);
        }
        QFSCommentAreaCommentView qFSCommentAreaCommentView = new QFSCommentAreaCommentView(viewGroup.getContext(), this.F);
        this.E = qFSCommentAreaCommentView;
        qFSCommentAreaCommentView.setLayoutParams(layoutParams);
        return new a(this.E);
    }

    public void l0(int i3) {
        this.f83534m = i3;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull a aVar, int i3) {
    }
}
