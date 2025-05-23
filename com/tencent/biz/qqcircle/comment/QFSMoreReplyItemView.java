package com.tencent.biz.qqcircle.comment;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSReplyItemInfo;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.util.LoadingUtil;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSMoreReplyItemView extends QCircleBaseWidgetView<QFSReplyItemInfo> implements View.OnClickListener {
    private int C;
    private int D;
    private com.tencent.biz.qqcircle.widgets.comment.c E;
    private View F;
    private ImageView G;

    /* renamed from: d, reason: collision with root package name */
    private TextView f83236d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f83237e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f83238f;

    /* renamed from: h, reason: collision with root package name */
    private FeedCloudMeta$StFeed f83239h;

    /* renamed from: i, reason: collision with root package name */
    private FeedCloudMeta$StComment f83240i;

    /* renamed from: m, reason: collision with root package name */
    private QFSReplyItemInfo f83241m;

    public QFSMoreReplyItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void initView() {
        this.f83237e = (LinearLayout) findViewById(R.id.ypc);
        this.f83238f = (LinearLayout) findViewById(R.id.yox);
        this.f83236d = (TextView) findViewById(R.id.f109396fp);
        this.F = findViewById(R.id.f166099yp1);
        this.G = (ImageView) findViewById(R.id.y5e);
        this.f83237e.setOnClickListener(this);
        this.f83238f.setOnClickListener(this);
        View findViewById = findViewById(R.id.yhq);
        View findViewById2 = findViewById(R.id.zev);
        int a16 = QFSQUIUtilsKt.a(QFSQUIUtilsKt.d(getContext(), R.color.qui_common_text_secondary), 0.3f);
        findViewById.setBackgroundColor(a16);
        findViewById2.setBackgroundColor(a16);
    }

    private void l0() {
        this.F.setVisibility(8);
    }

    private void m0() {
        this.F.setVisibility(0);
        QLog.d("QFSMoreReplyItemView", 1, UIJsPlugin.EVENT_SHOW_LOADING);
        this.G.setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), 2));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g9s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSMoreReplyItemView";
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(QFSReplyItemInfo qFSReplyItemInfo, int i3) {
        if (this.f83239h != null && this.f83240i != null && qFSReplyItemInfo != null) {
            this.f83241m = qFSReplyItemInfo;
            this.D = i3;
            int i16 = qFSReplyItemInfo.type;
            if (i16 == 6) {
                this.f83237e.setVisibility(0);
                this.f83238f.setVisibility(8);
                this.f83236d.setText(getContext().getResources().getString(R.string.f181893f0, Integer.valueOf(this.f83241m.moreNum)));
                l0();
                return;
            }
            if (i16 == 7) {
                this.f83237e.setVisibility(8);
                this.f83238f.setVisibility(0);
                l0();
            } else if (i16 == 8) {
                this.f83237e.setVisibility(8);
                this.f83238f.setVisibility(8);
                m0();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ypc) {
            if (this.E != null) {
                this.E.onClick(view, 10, this.C, new Object[]{this.f83240i, Integer.valueOf(this.D)});
            }
        } else if (id5 == R.id.yox && this.E != null) {
            this.E.onClick(view, 11, this.C, new Object[]{this.f83240i, Integer.valueOf(this.D)});
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setOnCommentElementClickListener(com.tencent.biz.qqcircle.widgets.comment.c cVar) {
        this.E = cVar;
    }

    public void setPreData(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StComment feedCloudMeta$StComment, int i3) {
        this.f83239h = feedCloudMeta$StFeed;
        this.f83240i = feedCloudMeta$StComment;
        this.C = i3;
    }
}
