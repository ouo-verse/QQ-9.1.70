package com.qzone.common.logic.clickprocessor;

import android.text.TextUtils;
import android.view.View;
import b6.b;
import cd.c;
import com.qzone.common.logic.presenter.BaseFeedPresenter;
import com.qzone.module.feedcomponent.ui.FeedOperation;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.reborn.comment.bean.CommentReplyParam;
import com.qzone.util.l;
import com.qzone.widget.EditPositionBag;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.mobileqq.R;
import ho.i;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a extends BaseFeedClickProcessor {

    /* compiled from: P */
    /* renamed from: com.qzone.common.logic.clickprocessor.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class C0370a implements CellTextView.OnTextOperater {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CellTextView.OnTextOperater f46078d;

        C0370a(CellTextView.OnTextOperater onTextOperater) {
            this.f46078d = onTextOperater;
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
        public void onCancle() {
            CellTextView.OnTextOperater onTextOperater = this.f46078d;
            if (onTextOperater != null) {
                onTextOperater.onCancle();
            }
        }

        @Override // com.qzone.proxy.feedcomponent.text.CellTextView.OnTextOperater
        public void onCopy() {
            CellTextView.OnTextOperater onTextOperater = this.f46078d;
            if (onTextOperater != null) {
                onTextOperater.onCopy();
            }
        }
    }

    public a(BaseFeedPresenter baseFeedPresenter, b bVar) {
        super(baseFeedPresenter, bVar);
    }

    @Override // com.qzone.common.logic.clickprocessor.BaseFeedClickProcessor
    public void J0(int i3, View view, Object obj, boolean z16, boolean z17, int i16) {
        String str;
        String str2;
        int i17;
        String str3;
        if (obj instanceof FeedOperation.CommentObj) {
            obj = ((FeedOperation.CommentObj) obj).point;
        }
        QZonePullToRefreshListView Q = this.V.Q();
        if (Q == null) {
            return;
        }
        if (view == null) {
            obj = null;
        }
        String str4 = "";
        if (obj == null) {
            i17 = 1;
            str = "";
            str2 = str;
        } else {
            if (obj instanceof ClickedComment) {
                ClickedComment clickedComment = (ClickedComment) obj;
                if (clickedComment.getComment() == null) {
                    str = "";
                    str3 = str;
                } else {
                    str = clickedComment.getComment().commentid;
                    str3 = l.a(R.string.f172215od3) + clickedComment.getComment().user.nickName + ":";
                }
                if (clickedComment.getReply() == null) {
                    str2 = "";
                    str4 = str3;
                } else {
                    str2 = clickedComment.getReply().replyId;
                    str4 = l.a(R.string.f172216od4) + clickedComment.getReply().user.nickName + ":";
                }
                this.V.N0(clickedComment);
            } else if (!(obj instanceof Integer)) {
                str = "";
                str2 = str;
            } else {
                ((Integer) obj).intValue();
                this.V.o0((BusinessFeedData) this.V.F(i3, false), i3, false, new Object[0]);
                return;
            }
            i17 = 0;
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = Y((BusinessFeedData) Q.j0().getItemAtPosition(i3));
        }
        if (TextUtils.isEmpty(str4)) {
            str4 = i0().getString(R.string.glb);
        }
        BusinessFeedData businessFeedData = (BusinessFeedData) this.V.F(i3, false);
        if (businessFeedData == null) {
            return;
        }
        this.V.P0(i3);
        EditPositionBag h16 = EditPositionBag.h(hashCode());
        this.f45949d = h16;
        if (h16 != null) {
            h16.f60222e = new WeakReference<>(Q.j0());
            this.f45949d.f60223f = new WeakReference<>(Q);
            this.f45949d.f60230m = j0();
            this.f45949d.f60228k = Q.h0();
            this.f45949d.d(i3, view, i17);
        }
        i.c().n(c.b(businessFeedData, str).v(i3).y(1208).q(str4).j(false).A(c6.a.e(businessFeedData)).h(new CommentReplyParam(str, null, str2, null)).getParams(), T(), businessFeedData);
    }

    @Override // com.qzone.common.logic.clickprocessor.BaseFeedClickProcessor
    protected void L0(int i3, Object obj, CellTextView.OnTextOperater onTextOperater) {
        com.qzone.widget.util.b.h(this.V.x(), new C0370a(onTextOperater));
    }
}
