package com.qzone.reborn.feedx.widget.comment;

import android.content.Context;
import android.view.View;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.ClickedComment;
import com.qzone.reborn.feedx.widget.QZoneRichTextView;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.ap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class QZoneFeedBaseCommentWidget extends QZoneBaseWidgetView<oh.b> {

    /* renamed from: e, reason: collision with root package name */
    protected BusinessFeedData f55996e;

    /* renamed from: f, reason: collision with root package name */
    private gf.a f55997f;

    /* renamed from: h, reason: collision with root package name */
    protected int f55998h;

    /* renamed from: i, reason: collision with root package name */
    private int f55999i;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneFeedBaseCommentWidget.this.r0();
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
            QZoneFeedBaseCommentWidget.this.s0(view);
            EventCollector.getInstance().onViewLongClicked(view);
            return false;
        }
    }

    public QZoneFeedBaseCommentWidget(Context context) {
        super(context);
    }

    private void o0(ClickedComment clickedComment) {
        if (v0(clickedComment)) {
            ap.f59791b.e(38, 1, this.f55998h, this.f55996e);
        }
    }

    private gf.a p0() {
        if (this.f55997f == null) {
            this.f55997f = (gf.a) getIocInterface(gf.a.class);
        }
        return this.f55997f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        if (this.f55996e != null && getData() != null) {
            ClickedComment clickedComment = new ClickedComment();
            clickedComment.isComment = getData().f422674b == null;
            clickedComment.setComment(getData().f422673a);
            clickedComment.setReply(getData().f422674b);
            if (p0() != null) {
                p0().f6(new com.qzone.reborn.feedx.bean.b(this.f55996e));
                p0().x1(clickedComment);
                p0().c1(this.f55996e, clickedComment, this.f55998h);
            }
            o0(clickedComment);
            return;
        }
        QLog.e(getLogTag(), 1, "handleOnClickItem  params error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(View view) {
        if (getData() != null) {
            p0().H7(view, this.f55996e, getData().f422673a, getData().f422674b, this.dataPosInList);
        }
    }

    private boolean v0(ClickedComment clickedComment) {
        if (getData().f422674b == null || getData().f422674b.user == null || getData().f422674b.user.uin == LoginData.getInstance().getUin()) {
            return (!clickedComment.isComment || getData().f422673a.user == null || getData().f422673a.user.uin == LoginData.getInstance().getUin()) ? false : true;
        }
        return true;
    }

    protected abstract String getLogTag();

    public int q0() {
        return this.f55999i;
    }

    public void setFeedData(BusinessFeedData businessFeedData) {
        this.f55996e = businessFeedData;
    }

    public void setFeedPosition(int i3) {
        this.f55998h = i3;
    }

    public void setPageType(int i3) {
        this.f55999i = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u0(QZoneRichTextView qZoneRichTextView) {
        if (qZoneRichTextView == null) {
            return;
        }
        qZoneRichTextView.setOnClickListener(new a());
        qZoneRichTextView.setOnLongClickListener(new b());
    }
}
