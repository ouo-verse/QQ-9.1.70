package com.tencent.biz.qqcircle.widgets.search;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.utils.ah;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.immersive.utils.r;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.qqcircle.widgets.QFSFollowView;
import com.tencent.biz.qqcircle.widgets.RoundFrameLayout;
import com.tencent.biz.qqcircle.widgets.aa;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudRead$StRecReason;
import feedcloud.FeedCloudRead$StRecReasonInfo;
import java.util.HashMap;
import qqcircle.QQCircleBase$StUserBusiData;
import ua0.i;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSSearchUserResultItemView extends QCircleBaseWidgetView<FeedCloudMeta$StUser> implements View.OnClickListener {
    private TextView C;
    private RoundFrameLayout D;
    protected FeedCloudMeta$StUser E;
    private FeedCloudRead$StRecReasonInfo F;
    protected Size G;
    private String H;

    /* renamed from: d, reason: collision with root package name */
    private QCircleAvatarView f93878d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f93879e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f93880f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f93881h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f93882i;

    /* renamed from: m, reason: collision with root package name */
    private QFSFollowView f93883m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements QFSFollowView.c {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.c
        public void O(boolean z16, FeedCloudMeta$StUser feedCloudMeta$StUser) {
            if (z16 && QFSSearchUserResultItemView.this.f93883m.getTag(R.id.f88074w3) != null) {
                QQToast.makeText(QFSSearchUserResultItemView.this.getContext(), -1, "\u5173\u6ce8\u6210\u529f", 0).show();
                QFSSearchUserResultItemView.this.f93883m.setTag(R.id.f88074w3, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements QFSFollowView.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StUser f93885a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f93886b;

        b(FeedCloudMeta$StUser feedCloudMeta$StUser, int i3) {
            this.f93885a = feedCloudMeta$StUser;
            this.f93886b = i3;
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void a() {
            if (this.f93885a == null) {
                return;
            }
            VideoReport.setElementId(QFSSearchUserResultItemView.this.f93883m, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_BUTTON);
            HashMap hashMap = new HashMap();
            hashMap.put("xsj_action_type", "cancel");
            hashMap.put("xsj_target_qq", this.f93885a.f398463id.get());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.f93885a.f398463id.get());
            hashMap.put("xsj_item_index", Integer.valueOf(this.f93886b));
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOLLOW_STATUS, i.l(this.f93885a.followState.get()));
            i.h(QFSSearchUserResultItemView.this.f93883m, QCircleDaTongConstant.EventId.EV_XSJ_FOLLOW, hashMap);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public /* synthetic */ void b() {
            aa.a(this);
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void c(int i3) {
            if (this.f93885a == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOLLOW_STATUS, i.l(this.f93885a.followState.get()));
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.f93885a.f398463id.get());
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_NAME, this.f93885a.nick.get());
            hashMap.put("xsj_item_index", Integer.valueOf(this.f93886b));
            hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, QFSSearchUserResultItemView.this.H);
            i.k(QFSSearchUserResultItemView.this.f93883m, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_BUTTON, hashMap, this.f93885a.hashCode());
        }

        @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView.d
        public void onClick(int i3) {
            if (this.f93885a == null) {
                return;
            }
            if (i3 == 0 || i3 == 2) {
                VideoReport.setElementId(QFSSearchUserResultItemView.this.f93883m, QCircleDaTongConstant.ElementId.EM_XSJ_FOLLOW_BUTTON);
                HashMap hashMap = new HashMap();
                hashMap.put("xsj_action_type", "follow");
                hashMap.put("xsj_target_qq", this.f93885a.f398463id.get());
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.f93885a.f398463id.get());
                hashMap.put("xsj_item_index", Integer.valueOf(this.f93886b));
                hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FOLLOW_STATUS, i.l(this.f93885a.followState.get()));
                i.h(QFSSearchUserResultItemView.this.f93883m, QCircleDaTongConstant.EventId.EV_XSJ_FOLLOW, hashMap);
            }
        }
    }

    public QFSSearchUserResultItemView(@NonNull Context context) {
        super(context);
        initView();
    }

    private void n0(FeedCloudRead$StRecReasonInfo feedCloudRead$StRecReasonInfo) {
        if (this.D != null && this.C != null) {
            if (feedCloudRead$StRecReasonInfo != null && this.E != null && TextUtils.equals(feedCloudRead$StRecReasonInfo.uid.get(), this.E.f398463id.get())) {
                FeedCloudRead$StRecReason feedCloudRead$StRecReason = feedCloudRead$StRecReasonInfo.reason.get();
                String str = feedCloudRead$StRecReason.text.get();
                String str2 = feedCloudRead$StRecReason.textColor.get();
                String str3 = feedCloudRead$StRecReason.bgColor.get();
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                    try {
                        int parseColor = Color.parseColor(str2);
                        int parseColor2 = Color.parseColor(str3);
                        this.C.setTextColor(parseColor);
                        this.C.setBackgroundColor(parseColor2);
                        this.C.setText(str);
                        this.D.setRadius(ImmersiveUtils.dpToPx(3.0f));
                        this.D.setVisibility(0);
                        this.f93879e.setMaxWidth((int) p0(str));
                        return;
                    } catch (IllegalArgumentException e16) {
                        QLog.w("QFSSearchUserResultItemView", 1, e16.getMessage(), e16);
                        return;
                    }
                }
                this.D.setVisibility(8);
                return;
            }
            this.D.setVisibility(8);
        }
    }

    private void o0(FeedCloudMeta$StUser feedCloudMeta$StUser, int i3) {
        this.f93883m.setItemReportListener(new b(feedCloudMeta$StUser, i3));
    }

    private double p0(String str) {
        return (bz.j() - ImmersiveUtils.dpToPx(175.0f)) - Math.ceil(this.C.getPaint().measureText(str));
    }

    private void r0() {
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.E;
        if (feedCloudMeta$StUser == null) {
            return;
        }
        if (feedCloudMeta$StUser.isUserInLivingStatus.get()) {
            ah.f(getContext(), this.E.jumpUrl.get());
        } else {
            s0();
        }
    }

    private void s0() {
        if (this.E == null) {
            return;
        }
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUser(this.E);
        QCircleReportBean reportBean = getReportBean();
        if (reportBean != null) {
            qCircleInitBean.setFromReportBean(reportBean.m466clone());
        } else {
            QLog.e("QFSSearchUserResultItemView", 1, "[jumpPersonDetailPage] report bean is null");
        }
        qCircleInitBean.setClientFromType(9);
        c.d0(getContext(), qCircleInitBean);
    }

    private void u0(int i3, QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData) {
        String str;
        if (this.E == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("xsj_item_index", Integer.valueOf(i3));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_NAME, this.E.nick.get());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, this.E.f398463id.get());
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_FANS_NUM, Long.valueOf(qQCircleBase$StUserBusiData.fansNum.get()));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_WORKS_NUM, Integer.valueOf(qQCircleBase$StUserBusiData.feedNum.get()));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, this.H);
        FeedCloudRead$StRecReasonInfo feedCloudRead$StRecReasonInfo = this.F;
        if (feedCloudRead$StRecReasonInfo == null) {
            str = "";
        } else {
            str = feedCloudRead$StRecReasonInfo.reason.text.get();
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_SUG_ICON_NAME, str);
        i.k(this, q0(), hashMap, this.E.hashCode());
        i.k(this.f93878d, "em_xsj_author_avatar", hashMap, this.E.hashCode());
        o0(this.E, i3);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gsl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSSearchUserResultItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initView() {
        this.f93878d = (QCircleAvatarView) findViewById(R.id.f56892lu);
        this.f93879e = (TextView) findViewById(R.id.f56962m1);
        this.f93880f = (ImageView) findViewById(R.id.f42221j7);
        this.f93881h = (TextView) findViewById(R.id.f372016m);
        this.f93882i = (TextView) findViewById(R.id.f41611hj);
        this.f93883m = (QFSFollowView) findViewById(R.id.f42091iu);
        this.C = (TextView) findViewById(R.id.f54322ew);
        RoundFrameLayout roundFrameLayout = (RoundFrameLayout) findViewById(R.id.f54332ex);
        this.D = roundFrameLayout;
        if (roundFrameLayout != null) {
            roundFrameLayout.setVisibility(8);
        }
        this.f93878d.setOnClickListener(this);
        setOnClickListener(this);
        this.f93883m.setFollowStateChangeListener(new a());
        this.G = n.a(getContext(), R.dimen.d5h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudMeta$StUser feedCloudMeta$StUser, int i3) {
        int i16;
        this.E = feedCloudMeta$StUser;
        if (feedCloudMeta$StUser == null) {
            return;
        }
        boolean z16 = feedCloudMeta$StUser.isUserInLivingStatus.get();
        this.f93878d.setShowAuthIcon(!z16);
        this.f93878d.setUser(feedCloudMeta$StUser, this.G);
        this.f93878d.setLivingStatus(z16);
        this.f93879e.setText(feedCloudMeta$StUser.nick.get());
        TextView textView = this.f93879e;
        if (feedCloudMeta$StUser.frdState.get() == 0) {
            i16 = 14;
        } else {
            i16 = 10;
        }
        textView.setMaxEms(i16);
        this.f93880f.setVisibility(8);
        QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData = new QQCircleBase$StUserBusiData();
        try {
            qQCircleBase$StUserBusiData.mergeFrom(feedCloudMeta$StUser.busiData.get().toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        this.f93881h.setText(getContext().getString(R.string.f19011418, r.f(qQCircleBase$StUserBusiData.fansNum.get())));
        this.f93882i.setVisibility(8);
        this.f93883m.setUserData(feedCloudMeta$StUser);
        n0(this.F);
        u0(i3, qQCircleBase$StUserBusiData);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f56892lu) {
            r0();
        } else {
            s0();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    protected String q0() {
        return QCircleDaTongConstant.ElementId.EM_XSJ_USER_ITEM;
    }

    public void setRecReasonInfo(FeedCloudRead$StRecReasonInfo feedCloudRead$StRecReasonInfo) {
        this.F = feedCloudRead$StRecReasonInfo;
    }

    public void setTransferInfo(String str) {
        this.H = str;
    }

    public QFSSearchUserResultItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }

    public QFSSearchUserResultItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        initView();
    }
}
