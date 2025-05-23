package com.tencent.biz.qqcircle.widgets;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.manager.QCircleFolderTabInfoManager;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StNotice;
import java.util.Map;
import qqcircle.QQCircleFeedBase$StNoticeBusiData;
import qqcircle.QQCircleFeedBase$StNoticePicInfo;
import qqcircle.QQCircleFeedBase$StNoticeTxtInfo;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSMessageBoxItemView extends QCircleBaseWidgetView<f30.b> {
    private static final int S = QCircleApplication.getAPP().getResources().getDimensionPixelSize(R.dimen.d2s);
    private static final int T = QCircleApplication.getAPP().getResources().getDimensionPixelSize(R.dimen.d2t);
    private static final int U = QCircleApplication.getAPP().getResources().getDimensionPixelSize(R.dimen.d2v);
    private static final int V = QCircleApplication.getAPP().getResources().getDimensionPixelSize(R.dimen.d2w);
    private static final int W = QCircleApplication.getAPP().getResources().getDimensionPixelSize(R.dimen.d2u);
    private QCircleAsyncTextView C;
    private ImageView D;
    private View E;
    private LinearLayout F;
    private TextView G;
    protected ViewGroup H;
    protected QCircleAsyncTextView I;
    protected QCircleAvatarView J;
    protected Size K;
    private String L;
    private String M;
    private FeedCloudMeta$StNotice N;
    private QQCircleFeedBase$StNoticeBusiData P;
    private String Q;
    private View.OnClickListener R;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f93300d;

    /* renamed from: e, reason: collision with root package name */
    private RoundCorneredFrameLayout f93301e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f93302f;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f93303h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f93304i;

    /* renamed from: m, reason: collision with root package name */
    private QCircleAsyncTextView f93305m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QFSMessageBoxItemView.this.N != null && !TextUtils.isEmpty(QFSMessageBoxItemView.this.N.feed.poster.f398463id.get())) {
                QCircleInitBean qCircleInitBean = new QCircleInitBean();
                qCircleInitBean.setUin(QFSMessageBoxItemView.this.N.feed.poster.f398463id.get());
                qCircleInitBean.setFromReportBean(QFSMessageBoxItemView.this.getReportBean().m466clone());
                if (!TextUtils.isEmpty(QFSMessageBoxItemView.this.N.feed.poster.jumpUrl.get())) {
                    com.tencent.biz.qqcircle.launcher.c.j(view.getContext(), QFSMessageBoxItemView.this.N.feed.poster.jumpUrl.get(), true);
                } else {
                    com.tencent.biz.qqcircle.launcher.c.d0(view.getContext(), qCircleInitBean);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public QFSMessageBoxItemView(@NonNull Context context) {
        this(context, (AttributeSet) null);
        initView();
    }

    private boolean A0() {
        if (x0() != null && !TextUtils.isEmpty(x0().picInfo.picUrl.get())) {
            return true;
        }
        return false;
    }

    private void B0() {
        int i3 = 8;
        if (!Q0()) {
            O0(8);
            return;
        }
        if (this.N == null) {
            return;
        }
        if (this.H == null) {
            ViewStub viewStub = (ViewStub) findViewById(R.id.f1203979f);
            if (viewStub == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) viewStub.inflate();
            this.H = viewGroup;
            QCircleAvatarView qCircleAvatarView = (QCircleAvatarView) viewGroup.findViewById(R.id.f165909du3);
            this.J = qCircleAvatarView;
            qCircleAvatarView.setOnClickListener(u0());
            QCircleAsyncTextView qCircleAsyncTextView = (QCircleAsyncTextView) this.H.findViewById(R.id.mdg);
            this.I = qCircleAsyncTextView;
            qCircleAsyncTextView.setOnClickListener(u0());
            this.E = findViewById(R.id.kmm);
            this.K = com.tencent.biz.qqcircle.immersive.utils.n.a(getContext(), R.dimen.d2q);
        }
        O0(0);
        View view = this.E;
        if (!J0()) {
            i3 = 0;
        }
        view.setVisibility(i3);
        this.I.setText(this.N.feed.poster.nick.get());
        this.J.setUser(this.N.feed.poster, this.K);
    }

    private void C0() {
        int i3;
        if (this.C == null) {
            return;
        }
        final QQCircleFeedBase$StNoticeTxtInfo v06 = v0();
        if (v06 == null) {
            this.C.setVisibility(8);
            QLog.e("QFSMessageBoxItemView", 1, "[initDetailView] error, detailInfo == null!");
            return;
        }
        QCircleAsyncTextView qCircleAsyncTextView = this.C;
        if (I0()) {
            i3 = 10;
        } else {
            i3 = 3;
        }
        qCircleAsyncTextView.setMaxLines(i3);
        String str = v06.content.get();
        if (!TextUtils.isEmpty(str)) {
            this.C.setVisibility(0);
            this.C.setText(str.trim());
            this.C.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.widgets.ak
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSMessageBoxItemView.this.K0(v06, view);
                }
            });
            return;
        }
        this.C.setVisibility(8);
    }

    private void D0() {
        if (this.N == null) {
            QLog.e(getLogTag(), 1, "[initDtReport] mData == null");
            return;
        }
        VideoReport.setElementId(this.f93303h, QCircleDaTongConstant.ElementId.EM_XSJ_MSG);
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_MSG_ID, this.N.feedId.get());
        buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IF_PRIVATE_LETTER, 0);
        com.tencent.biz.qqcircle.helpers.q.r().l(this.N, buildElementParams);
        if (TextUtils.isEmpty(this.M)) {
            buildElementParams.put("xsj_target_qq", this.L);
        }
        VideoReport.setElementParams(this.f93303h, buildElementParams);
        VideoReport.setElementExposePolicy(this.f93303h, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementReuseIdentifier(this.f93303h, String.valueOf(this.N.createTime.get()));
        QCircleAvatarView qCircleAvatarView = this.J;
        if (qCircleAvatarView != null) {
            VideoReport.setElementId(qCircleAvatarView, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_AVATAR);
            Map<String, Object> buildElementParams2 = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams2.put("xsj_target_qq", this.N.feed.poster.f398463id.get());
            VideoReport.setElementParams(this.J, buildElementParams2);
            VideoReport.setElementReuseIdentifier(this.J, String.valueOf(this.N.createTime.get()));
        }
    }

    private void E0() {
        if (this.F == null) {
            return;
        }
        QQCircleFeedBase$StNoticeTxtInfo w06 = w0();
        if (w06 == null) {
            this.F.setVisibility(8);
            QLog.e("QFSMessageBoxItemView", 1, "initMoreInfoView error, getMoreInfo is null!");
            return;
        }
        String str = w06.content.get();
        if (!TextUtils.isEmpty(str)) {
            this.F.setVisibility(0);
            this.G.setText(str.trim());
            this.Q = w06.schemaUrl.get();
            this.F.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.widgets.ai
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSMessageBoxItemView.this.L0(view);
                }
            });
            return;
        }
        this.F.setVisibility(8);
    }

    private void F0() {
        if (this.D == null) {
            return;
        }
        final QQCircleFeedBase$StNoticePicInfo x06 = x0();
        if (x06 == null) {
            this.D.setVisibility(8);
            QLog.e("QFSMessageBoxItemView", 1, "initPicView error, getPicInfo is null!");
        } else {
            if (TextUtils.isEmpty(x06.picInfo.picUrl.get())) {
                this.D.setVisibility(8);
                return;
            }
            this.D.setVisibility(0);
            this.D.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.widgets.al
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSMessageBoxItemView.this.M0(x06, view);
                }
            });
            U0();
        }
    }

    private void G0() {
        FeedCloudMeta$StNotice feedCloudMeta$StNotice;
        if (this.f93304i != null && (feedCloudMeta$StNotice = this.N) != null) {
            if (feedCloudMeta$StNotice.createTime.get() > 0) {
                this.f93304i.setVisibility(0);
                this.f93304i.setText(com.tencent.biz.qqcircle.widgets.comment.b.f(this.N.createTime.get() * 1000));
            } else {
                this.f93304i.setVisibility(8);
            }
        }
    }

    private void H0() {
        int i3;
        if (this.f93305m == null) {
            return;
        }
        if (y0() == null) {
            this.f93305m.setVisibility(8);
            QLog.e("QFSMessageBoxItemView", 1, "initTitleView error, getTitleInfo is null!");
            return;
        }
        String str = y0().content.get();
        if (!TextUtils.isEmpty(str)) {
            this.f93305m.setVisibility(0);
            this.f93305m.setText(str.trim());
            this.f93305m.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.widgets.aj
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSMessageBoxItemView.this.N0(view);
                }
            });
        } else {
            this.f93305m.setVisibility(8);
        }
        if (this.f93305m.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f93305m.getLayoutParams();
            if (J0()) {
                i3 = U;
            } else {
                i3 = V;
            }
            layoutParams.bottomMargin = i3;
            this.f93305m.setLayoutParams(layoutParams);
        }
    }

    private boolean I0() {
        int i3 = this.mViewType;
        if (i3 == 4) {
            if (x0() != null && !TextUtils.isEmpty(x0().picInfo.picUrl.get())) {
                return false;
            }
            return true;
        }
        if (i3 != 1) {
            return false;
        }
        return true;
    }

    private boolean J0() {
        if (this.mViewType == 4 && A0()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0(QQCircleFeedBase$StNoticeTxtInfo qQCircleFeedBase$StNoticeTxtInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        z0(qQCircleFeedBase$StNoticeTxtInfo.schemaUrl.get());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        z0(this.Q);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0(QQCircleFeedBase$StNoticePicInfo qQCircleFeedBase$StNoticePicInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        z0(qQCircleFeedBase$StNoticePicInfo.schemaUrl.get());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        z0(y0().schemaUrl.get());
        EventCollector.getInstance().onViewClicked(view);
    }

    private void O0(int i3) {
        ViewGroup viewGroup = this.H;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(i3);
    }

    private void P0() {
        if (this.f93301e == null) {
            return;
        }
        int a16 = cx.a(8.0f);
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.f93301e;
        if (roundCorneredFrameLayout != null) {
            float f16 = a16;
            roundCorneredFrameLayout.setRadius(f16, f16, f16, f16);
        }
    }

    private boolean Q0() {
        QQCircleFeedBase$StNoticeBusiData qQCircleFeedBase$StNoticeBusiData = this.P;
        if (qQCircleFeedBase$StNoticeBusiData != null && "1".equals(QCirclePluginUtil.getValueFromListEntry(qQCircleFeedBase$StNoticeBusiData.busiInfo.get(), "show_head", "0"))) {
            return true;
        }
        return false;
    }

    private void S0(@NonNull QQCircleFeedBase$StNoticePicInfo qQCircleFeedBase$StNoticePicInfo) {
        int instantScreenWidth = DisplayUtil.getInstantScreenWidth(this.D.getContext()) - (W * 2);
        float f16 = instantScreenWidth;
        int i3 = (int) ((5.0f * f16) / 9.0f);
        int i16 = qQCircleFeedBase$StNoticePicInfo.picInfo.width.get();
        int i17 = qQCircleFeedBase$StNoticePicInfo.picInfo.height.get();
        if (i16 != 0 && i17 != 0) {
            i3 = (int) ((f16 / i16) * i17);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.D.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(instantScreenWidth, i3);
        }
        layoutParams.width = instantScreenWidth;
        layoutParams.height = i3;
        layoutParams.gravity = 17;
        this.D.setLayoutParams(layoutParams);
        QLog.d("QFSMessageBoxItemView", 1, "updateBottomTxtTopPicContent adjustPicSize:" + i16 + "|" + i17 + " , target:" + instantScreenWidth + "|" + i3 + " , hashCode" + hashCode() + " , pageId:" + getPageId());
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(qQCircleFeedBase$StNoticePicInfo.picInfo.picUrl.get()).setTargetView(this.D));
    }

    private void T0(@NonNull QQCircleFeedBase$StNoticePicInfo qQCircleFeedBase$StNoticePicInfo) {
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(qQCircleFeedBase$StNoticePicInfo.picInfo.picUrl.get()).setTargetView(this.D));
    }

    private void U0() {
        QQCircleFeedBase$StNoticePicInfo x06 = x0();
        if (this.D != null && x06 != null) {
            int i3 = this.mViewType;
            if (i3 == 2) {
                T0(x06);
                return;
            } else {
                if (i3 == 4) {
                    S0(x06);
                    return;
                }
                return;
            }
        }
        QLog.d("QFSMessageBoxItemView", 1, "updatePicContent error,no pic view or info");
    }

    private void p0(int i3) {
        float f16;
        LinearLayout linearLayout = this.f93300d;
        if (linearLayout != null && (linearLayout.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f93300d.getLayoutParams();
            if (i3 == 0) {
                f16 = 12.0f;
            } else {
                f16 = 24.0f;
            }
            layoutParams.topMargin = cx.a(f16);
            this.f93300d.setLayoutParams(layoutParams);
        }
    }

    private void q0() {
        LinearLayout linearLayout = this.f93302f;
        if (linearLayout != null && (linearLayout.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f93302f.getLayoutParams();
            layoutParams.topMargin = S;
            if (!Q0() && !J0()) {
                layoutParams.topMargin = T;
            }
            this.f93302f.setLayoutParams(layoutParams);
        }
    }

    private void s0() {
        VideoReport.reportEvent("clck", this.f93303h, null);
    }

    private View.OnClickListener u0() {
        if (this.R == null) {
            this.R = new a();
        }
        return this.R;
    }

    private QQCircleFeedBase$StNoticeTxtInfo v0() {
        int i3 = this.mViewType;
        if (i3 == 2) {
            return this.P.pattonInfo.leftTxtRightPic.txtInfo;
        }
        if (i3 == 4) {
            return this.P.pattonInfo.topPicBottomTxt.txtInfo;
        }
        if (i3 == 1) {
            return this.P.pattonInfo.plainTxt.txtInfo;
        }
        return null;
    }

    private QQCircleFeedBase$StNoticeTxtInfo w0() {
        int i3 = this.mViewType;
        if (i3 == 2) {
            return this.P.pattonInfo.leftTxtRightPic.moreInfo;
        }
        if (i3 == 4) {
            return this.P.pattonInfo.topPicBottomTxt.moreInfo;
        }
        return null;
    }

    private QQCircleFeedBase$StNoticePicInfo x0() {
        QQCircleFeedBase$StNoticeBusiData qQCircleFeedBase$StNoticeBusiData = this.P;
        if (qQCircleFeedBase$StNoticeBusiData == null) {
            return null;
        }
        int i3 = this.mViewType;
        if (i3 == 2) {
            return qQCircleFeedBase$StNoticeBusiData.pattonInfo.leftTxtRightPic.picInfo;
        }
        if (i3 != 4) {
            return null;
        }
        return qQCircleFeedBase$StNoticeBusiData.pattonInfo.topPicBottomTxt.picInfo;
    }

    private QQCircleFeedBase$StNoticeTxtInfo y0() {
        int i3 = this.mViewType;
        if (i3 == 2) {
            return this.P.pattonInfo.leftTxtRightPic.title;
        }
        if (i3 == 4) {
            return this.P.pattonInfo.topPicBottomTxt.title;
        }
        if (i3 == 1) {
            return this.P.pattonInfo.plainTxt.title;
        }
        return null;
    }

    private void z0(String str) {
        if (str.contains(QCircleScheme.Q_CIRCLE_ACTION_OPEN_FOLDER_PAGE) && str.contains("tabtype=8") && !QCircleFolderTabInfoManager.m().l()) {
            QLog.e("QFSMessageBoxItemView", 1, "the community page does not exist");
        } else {
            com.tencent.biz.qqcircle.launcher.c.g(getContext(), str);
            s0();
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        int i3 = this.mViewType;
        if (i3 == 2) {
            return R.layout.ghz;
        }
        if (i3 == 4) {
            return R.layout.f168706gi1;
        }
        if (i3 == 1) {
            return R.layout.f168705gi0;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QFSMessageBoxItemView";
    }

    protected void initView() {
        this.f93300d = (LinearLayout) findViewById(R.id.f46831vn);
        this.f93301e = (RoundCorneredFrameLayout) findViewById(R.id.tof);
        this.f93302f = (LinearLayout) findViewById(R.id.yp9);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.yp6);
        this.f93303h = linearLayout;
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.f93301e;
        int i3 = R.drawable.kng;
        if (roundCorneredFrameLayout != null) {
            Application application = RFWApplication.getApplication();
            if (!QQTheme.isCustomTheme("", false)) {
                i3 = R.drawable.qui_common_bg_middle_light_bg_corner_8;
            }
            roundCorneredFrameLayout.setBackgroundDrawable(application.getDrawable(i3));
        } else if (linearLayout != null) {
            Application application2 = RFWApplication.getApplication();
            if (!QQTheme.isCustomTheme("", false)) {
                i3 = R.drawable.qui_common_bg_middle_light_bg_corner_8;
            }
            linearLayout.setBackgroundDrawable(application2.getDrawable(i3));
        }
        this.f93304i = (TextView) findViewById(R.id.f109336fj);
        this.f93305m = (QCircleAsyncTextView) findViewById(R.id.kbs);
        this.C = (QCircleAsyncTextView) findViewById(R.id.k75);
        ImageView imageView = (ImageView) findViewById(R.id.dwp);
        this.D = imageView;
        if (imageView instanceof QCircleRoundImageView) {
            ((QCircleRoundImageView) imageView).setRoundRect(cx.a(4.0f));
        }
        this.F = (LinearLayout) findViewById(R.id.ypb);
        this.G = (TextView) findViewById(R.id.f109386fo);
        P0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void bindData(f30.b bVar, int i3) {
        if (bVar != null && bVar.d() != null && getLayoutId() != 0) {
            this.N = bVar.d();
            this.P = (QQCircleFeedBase$StNoticeBusiData) bVar.b("EXTRA_NOTICE_BUSI_DATA");
            p0(i3);
            B0();
            G0();
            H0();
            C0();
            F0();
            E0();
            D0();
            q0();
        }
    }

    public void setHostType(String str) {
        this.M = str;
    }

    public void setHostUin(String str) {
        this.L = str;
    }

    public QFSMessageBoxItemView(@NonNull Context context, int i3) {
        super(context, i3);
        initView();
    }

    public QFSMessageBoxItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        initView();
    }
}
