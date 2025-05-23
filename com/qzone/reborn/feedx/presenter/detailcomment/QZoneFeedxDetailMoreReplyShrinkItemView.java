package com.qzone.reborn.feedx.presenter.detailcomment;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.detail.ui.activity.QzoneCommentDetailActivity;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.reborn.feedx.activity.QzoneFeedxCommentDetailActivity;
import com.qzone.reborn.feedx.presenter.detailcomment.QZoneFeedxDetailMoreReplyShrinkItemView;
import com.qzone.reborn.feedx.viewmodel.h;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.TbsListener;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import pg.a;
import s4.c;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZoneFeedxDetailMoreReplyShrinkItemView extends QZoneBaseWidgetView<a> {

    /* renamed from: h, reason: collision with root package name */
    private static final String f55622h = l.a(R.string.mkx);

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f55623e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f55624f;

    public QZoneFeedxDetailMoreReplyShrinkItemView(Context context) {
        super(context);
    }

    private void p0() {
        if (getContext() == null || getData() == null || getData().f426125c == null) {
            return;
        }
        h hVar = (h) p(h.class);
        Intent intent = new Intent(getContext(), (Class<?>) QzoneFeedxCommentDetailActivity.class);
        if (hVar != null) {
            intent.putExtra("uin", hVar.r2());
            intent.putExtra("appid", hVar.T1());
            intent.putExtra(c.CELLID, hVar.U1());
            intent.putExtra("fromThoseYear", hVar.y2());
            QzoneCommentDetailActivity.f46848w1 = hVar.b2();
        }
        intent.putExtra("position", getData().f426127e);
        intent.putExtra("commentType", getData().f426125c.commentType);
        QzoneCommentDetailActivity.f46847v1 = getData().f426125c;
        getContext().startActivity(intent);
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064(TbsListener.ErrorCode.STATIC_TBS_INSTALL_HAS_INSTALLED_EXCEPTION, 3, 0);
        lpReportInfo_pf00064.reserves2 = o0(hVar != null ? hVar.T1() : 0);
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        p0();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.chb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public void initView(Context context, int i3) {
        super.initView(context, i3);
        this.f55623e = (LinearLayout) findViewById(R.id.mgb);
        this.f55624f = (TextView) findViewById(R.id.njb);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(a aVar, int i3) {
        Comment comment;
        if (aVar != null && (comment = aVar.f426125c) != null && !bl.b(comment.replies)) {
            this.f55623e.setOnClickListener(new View.OnClickListener() { // from class: pg.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZoneFeedxDetailMoreReplyShrinkItemView.this.q0(view);
                }
            });
            this.f55623e.setVisibility(0);
            this.f55624f.setText(aVar.f426125c.replies.size() + f55622h);
            return;
        }
        this.f55623e.setVisibility(8);
    }

    public String o0(int i3) {
        int i16 = 2;
        if (i3 == 2) {
            i16 = 3;
        } else if (i3 != 4) {
            i16 = i3 != 202 ? i3 != 311 ? 0 : 1 : 4;
        }
        return i16 + "";
    }
}
