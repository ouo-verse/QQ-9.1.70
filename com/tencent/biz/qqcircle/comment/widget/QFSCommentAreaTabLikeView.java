package com.tencent.biz.qqcircle.comment.widget;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.richframework.data.base.UIStateData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentAreaTabLikeView extends QFSCommentAreaTabBaseView {
    public QFSCommentAreaTabLikeView(@NonNull Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.comment.widget.QFSCommentAreaTabBaseView
    public void o0() {
        super.o0();
        this.f84028e.j0(1);
        this.f84031i.setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f188813xp));
    }

    @Override // com.tencent.biz.qqcircle.comment.widget.QFSCommentAreaTabBaseView
    protected void p0() {
        com.tencent.biz.qqcircle.viewmodels.m mVar = this.C;
        if (mVar == null) {
            return;
        }
        mVar.P1().observe(getQCircleBaseFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.comment.widget.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSCommentAreaTabLikeView.this.n0((UIStateData) obj);
            }
        });
        this.C.Q1().observe(getQCircleBaseFragment(), new Observer() { // from class: com.tencent.biz.qqcircle.comment.widget.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSCommentAreaTabLikeView.this.v0((String) obj);
            }
        });
    }
}
