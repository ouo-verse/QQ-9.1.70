package com.qzone.reborn.feedx.presenter.detailcomment;

import android.content.Context;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.reborn.feedx.util.QZoneFeedxViewUtils;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.ap;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import gf.d;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class QZoneFeedDetailBaseCommentWidget extends QZoneBaseWidgetView<pg.a> {

    /* renamed from: e, reason: collision with root package name */
    protected BusinessFeedData f55603e;

    /* renamed from: f, reason: collision with root package name */
    private gf.a f55604f;

    /* renamed from: h, reason: collision with root package name */
    private d f55605h;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneFeedDetailBaseCommentWidget.this.s0();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class b implements View.OnLongClickListener {
        b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            QZoneFeedDetailBaseCommentWidget.this.u0(view);
            EventCollector.getInstance().onViewLongClicked(view);
            return false;
        }
    }

    public QZoneFeedDetailBaseCommentWidget(Context context) {
        super(context);
    }

    private void o0() {
        if (w0()) {
            return;
        }
        ap.f59791b.e(38, 1, 0, this.f55603e);
    }

    private gf.a q0() {
        if (this.f55604f == null) {
            this.f55604f = (gf.a) getIocInterface(gf.a.class);
        }
        return this.f55604f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(View view) {
        int i3;
        if (getData() == null || q0() == null) {
            return;
        }
        if (getData().f426123a == 102) {
            i3 = getData().f426128f;
        } else {
            i3 = getData().f426127e;
        }
        q0().H7(view, this.f55603e, getData().f426125c, getData().f426126d, i3);
    }

    protected abstract String getLogTag();

    /* JADX INFO: Access modifiers changed from: protected */
    public d r0() {
        if (this.f55605h == null) {
            this.f55605h = (d) getIocInterface(d.class);
        }
        return this.f55605h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s0() {
        if (this.f55603e != null && getData() != null) {
            ClickedComment clickedComment = new ClickedComment();
            clickedComment.isComment = getData().f426126d == null;
            clickedComment.setComment(getData().f426125c);
            clickedComment.setReply(getData().f426126d);
            if (q0() != null) {
                q0().x1(clickedComment);
                q0().c1(this.f55603e, clickedComment, -1);
            }
            o0();
            return;
        }
        QLog.e(getLogTag(), 1, "handleOnClickItem  params error");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean w0() {
        if (getData() == null) {
            return false;
        }
        if (getData().f426126d == null || getData().f426126d.user == null || getData().f426126d.user.uin != LoginData.getInstance().getUin()) {
            return getData().f426126d == null && getData().f426125c != null && getData().f426125c.user != null && getData().f426125c.user.uin == LoginData.getInstance().getUin();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p0(View view) {
        int dpToPx = ImmersiveUtils.dpToPx(10.0f);
        QZoneFeedxViewUtils.a(view, dpToPx, dpToPx, dpToPx, dpToPx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(pg.a aVar, int i3) {
        if (aVar == null) {
            return;
        }
        this.f55603e = aVar.f426124b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v0(QZoneRichTextView qZoneRichTextView) {
        if (qZoneRichTextView == null) {
            return;
        }
        qZoneRichTextView.setOnClickListener(new a());
        qZoneRichTextView.setOnLongClickListener(new b());
    }
}
