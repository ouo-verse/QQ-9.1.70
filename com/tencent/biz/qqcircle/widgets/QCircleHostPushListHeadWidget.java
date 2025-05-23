package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.beans.QFSCommentAreaTabItemInfo;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;

/* loaded from: classes5.dex */
public class QCircleHostPushListHeadWidget extends QCircleBaseWidgetView implements View.OnClickListener, Observer<e30.b> {
    private View C;
    private TextView D;
    private FeedCloudMeta$StFeed E;
    private e30.b F;
    private int G;
    private boolean H;
    private Size I;

    /* renamed from: d, reason: collision with root package name */
    private QCircleAvatarView f93001d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f93002e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f93003f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f93004h;

    /* renamed from: i, reason: collision with root package name */
    private View f93005i;

    /* renamed from: m, reason: collision with root package name */
    private View f93006m;

    public QCircleHostPushListHeadWidget(@NonNull Context context) {
        super(context);
        m0(this);
    }

    private void k0() {
        View view = this.f93006m;
        if (view != null) {
            VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_RECOMMEND_FRIEND);
            VideoReport.setElementExposePolicy(this.f93006m, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(this.f93006m, EndExposurePolicy.REPORT_ALL);
            VideoReport.setElementParams(this.f93006m, l0());
        }
        View view2 = this.C;
        if (view2 != null) {
            VideoReport.setElementId(view2, QCircleDaTongConstant.ElementId.EM_XSJ_CANCEL_RECOMMEND);
            VideoReport.setElementExposePolicy(this.C, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(this.C, EndExposurePolicy.REPORT_ALL);
            VideoReport.setElementParams(this.C, l0());
        }
    }

    private Map<String, Object> l0() {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.E;
        if (feedCloudMeta$StFeed != null) {
            buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
            FeedCloudMeta$StUser feedCloudMeta$StUser = this.E.poster;
            if (feedCloudMeta$StUser != null) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StUser.f398463id.get());
            }
        }
        return buildElementParams;
    }

    private void m0(View view) {
        this.f93001d = (QCircleAvatarView) view.findViewById(R.id.f32150sz);
        this.f93002e = (TextView) view.findViewById(R.id.f32160t0);
        this.f93003f = (TextView) view.findViewById(R.id.f32130sx);
        this.f93004h = (ImageView) view.findViewById(R.id.f32120sw);
        this.f93005i = view.findViewById(R.id.f32140sy);
        this.f93006m = view.findViewById(R.id.f32220t6);
        this.C = view.findViewById(R.id.f32200t4);
        TextView textView = (TextView) view.findViewById(R.id.f32210t5);
        this.D = textView;
        textView.setVisibility(8);
        q0();
        this.f93006m.setOnClickListener(this);
        this.C.setOnClickListener(this);
        this.I = com.tencent.biz.qqcircle.immersive.utils.n.a(getContext(), R.dimen.d4e);
    }

    private boolean n0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null || feedCloudMeta$StFeed.busiData == null) {
            return false;
        }
        QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = new QQCircleFeedBase$StFeedBusiReqData();
        try {
            qQCircleFeedBase$StFeedBusiReqData.mergeFrom(feedCloudMeta$StFeed.busiData.get().toByteArray());
            this.G = qQCircleFeedBase$StFeedBusiReqData.pushList.hasClickCount.get();
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        if (this.G <= 0) {
            return false;
        }
        return true;
    }

    private void p0() {
        QCircleAvatarView qCircleAvatarView = this.f93001d;
        if (qCircleAvatarView != null && this.f93002e != null && this.f93005i != null && this.C != null) {
            qCircleAvatarView.setVisibility(0);
            this.f93002e.setVisibility(0);
            this.f93005i.setVisibility(0);
            this.C.setVisibility(8);
        }
        View view = this.f93006m;
        if (view != null) {
            view.setVisibility(8);
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.E;
        if (feedCloudMeta$StFeed != null) {
            u0(feedCloudMeta$StFeed.poster);
            r0(this.G);
        }
    }

    private void q0() {
        QCircleAvatarView qCircleAvatarView = this.f93001d;
        if (qCircleAvatarView != null && this.f93002e != null && this.f93005i != null && this.C != null) {
            qCircleAvatarView.setVisibility(8);
            this.f93002e.setVisibility(8);
            this.f93005i.setVisibility(8);
            this.C.setVisibility(8);
        }
        View view = this.f93006m;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private void r0(int i3) {
        TextView textView = this.f93003f;
        if (textView != null && this.f93005i != null) {
            if (i3 <= 0) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            this.f93003f.setText(HippyTKDListViewAdapter.X + i3);
        }
    }

    private void u0(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        QCircleAvatarView qCircleAvatarView;
        if (feedCloudMeta$StUser != null && feedCloudMeta$StUser.nick != null && (qCircleAvatarView = this.f93001d) != null && this.f93002e != null) {
            qCircleAvatarView.setUser(feedCloudMeta$StUser, this.I);
            this.f93002e.setText(feedCloudMeta$StUser.nick.get());
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
        if (obj instanceof FeedCloudMeta$StFeed) {
            this.E = (FeedCloudMeta$StFeed) obj;
        } else if (obj instanceof QFSCommentAreaTabItemInfo) {
            this.E = ((QFSCommentAreaTabItemInfo) obj).getStFeed();
        }
        setHostEmptyViewVisibility(8);
        if (n0(this.E)) {
            p0();
        } else {
            q0();
        }
        this.F = new e30.b(this.E);
        w20.a.j().observerGlobalState(this.F, this);
        k0();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g5e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QCircleRecommend_";
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void onChanged(e30.b bVar) {
        if (bVar != null) {
            Object b16 = bVar.b("DITTO_FEED_BUSI_REQ_DATA");
            if (b16 instanceof QQCircleFeedBase$StFeedBusiReqData) {
                s0((QQCircleFeedBase$StFeedBusiReqData) b16);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QCircleToast.u(com.tencent.biz.qqcircle.immersive.personal.utils.k.d(), 0, true);
        EventCollector.getInstance().onViewClicked(view);
    }

    public void s0(QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData) {
        this.H = false;
        if (qQCircleFeedBase$StFeedBusiReqData.pushList.hasClickCount.get() <= 0) {
            q0();
            return;
        }
        p0();
        int i3 = qQCircleFeedBase$StFeedBusiReqData.pushList.totalClickCount.get();
        if (this.f93003f != null && i3 >= 0) {
            r0(qQCircleFeedBase$StFeedBusiReqData.pushList.hasClickCount.get());
        } else {
            QLog.d("QCircleRecommend_", 1, "[updatePushFeedDataText] mFeedPushText should not be null.");
        }
    }

    public void setHostEmptyViewVisibility(int i3) {
        TextView textView = this.D;
        if (textView == null) {
            return;
        }
        textView.setVisibility(i3);
    }

    public void setPushRocketDrawer(Drawable drawable) {
        ImageView imageView = this.f93004h;
        if (imageView != null && drawable != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public void setReportBean(Object obj) {
    }
}
