package com.tencent.biz.qqcircle.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QFSMessageItemInfo;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSAvatarApertureFeedExposeEvent;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.biz.qqcircle.requests.QCircleUnReadPointRequest;
import com.tencent.biz.qqcircle.requests.QFSMessageNoticeCategoriesRequest;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarListView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StNotice;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudRead$StClearRedPointRsp;
import java.util.ArrayList;
import java.util.Map;
import qqcircle.QQCircleBase$StUserBusiData;
import qqcircle.QQCircleFeedBase$StNoticeBusiData;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSMessageAvatarWrapper implements SimpleEventReceiver {
    private static final int J = cx.a(58.0f);
    private static final int K = (int) QCircleApplication.getAPP().getResources().getDimension(R.dimen.d3c);
    private static final int L = cx.a(23.5f);
    private static final int M = cx.a(-10.5f);
    private View C;
    private ImageView D;
    private Size E;
    private ViewStub F;
    private ViewGroup G;
    private int H;
    private boolean I;

    /* renamed from: d, reason: collision with root package name */
    private int f92614d;

    /* renamed from: e, reason: collision with root package name */
    private QFSMessageItemInfo f92615e;

    /* renamed from: f, reason: collision with root package name */
    private FrameLayout f92616f;

    /* renamed from: h, reason: collision with root package name */
    private QCircleAvatarView f92617h;

    /* renamed from: i, reason: collision with root package name */
    private View f92618i;

    /* renamed from: m, reason: collision with root package name */
    private LottieAnimationView f92619m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StClearRedPointRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QCircleBaseRequest f92620a;

        a(QCircleBaseRequest qCircleBaseRequest) {
            this.f92620a = qCircleBaseRequest;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StClearRedPointRsp feedCloudRead$StClearRedPointRsp) {
            QLog.i(QFSMessageAvatarWrapper.this.h(), 1, "traceId:" + this.f92620a.getTraceId() + " isSuccess:" + z16 + " errorCode" + j3 + " err:" + str);
        }
    }

    public QFSMessageAvatarWrapper(int i3) {
        this.f92614d = i3;
    }

    private void A(QQCircleFeedBase$StNoticeBusiData qQCircleFeedBase$StNoticeBusiData) {
        int i3;
        ImageView imageView = this.D;
        if (imageView == null) {
            QLog.e(h(), 1, "setUnReadInfo view is null");
            return;
        }
        if (m(qQCircleFeedBase$StNoticeBusiData)) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView.setVisibility(i3);
    }

    private void g(View view) {
        int a16 = cx.a(10.0f);
        QCirclePluginUtil.expandViewTouchDelegate(view, a16, a16, a16, a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h() {
        return "QFSMessageAvatarWrapper";
    }

    private void i(QFSAvatarApertureFeedExposeEvent qFSAvatarApertureFeedExposeEvent) {
        QFSMessageItemInfo qFSMessageItemInfo = this.f92615e;
        if (qFSMessageItemInfo != null && this.f92617h != null && this.C != null) {
            FeedCloudMeta$StUser feedCloudMeta$StUser = qFSMessageItemInfo.getStNotice().operation.opUser.get();
            if (!TextUtils.equals(feedCloudMeta$StUser.f398463id.get(), qFSAvatarApertureFeedExposeEvent.getUin())) {
                return;
            }
            com.tencent.biz.qqcircle.helpers.e eVar = com.tencent.biz.qqcircle.helpers.e.f84616a;
            eVar.a(this.C);
            this.f92615e.setApertureExposeFeed(qFSAvatarApertureFeedExposeEvent.getFeed());
            eVar.b(feedCloudMeta$StUser);
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    private void l(Context context) {
        String url = QCircleSkinHelper.getInstance().getUrl("qvideo_newtips_reddot");
        int dimension = (int) context.getResources().getDimension(R.dimen.d2x);
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(url).setRequestWidth(dimension).setRequestHeight(dimension).setTargetView(this.D).setEnableAutoDeleteLocalCache(false));
    }

    private boolean m(QQCircleFeedBase$StNoticeBusiData qQCircleFeedBase$StNoticeBusiData) {
        if (this.f92615e == null) {
            QLog.e(h(), 1, "isShowUnReadRedPoint itemInfo is null");
            return false;
        }
        if (qQCircleFeedBase$StNoticeBusiData == null || !qQCircleFeedBase$StNoticeBusiData.messageBoxRedPointInfo.needShow.get() || this.I) {
            return false;
        }
        return true;
    }

    private boolean n() {
        QFSMessageItemInfo qFSMessageItemInfo = this.f92615e;
        if (qFSMessageItemInfo == null) {
            QLog.e(h(), 1, "isUserHasUpdateContent itemInfo is null");
            return false;
        }
        QQCircleBase$StUserBusiData userBusiData = qFSMessageItemInfo.getUserBusiData();
        if (userBusiData == null || !userBusiData.has_unread_feed.get()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(View.OnClickListener onClickListener, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        QFSMessageItemInfo qFSMessageItemInfo = this.f92615e;
        if (qFSMessageItemInfo == null) {
            QLog.e(h(), 1, "[setAvatarClickListener] onClick, itemInfo is null, return.");
        } else {
            qFSMessageItemInfo.setHasConsumeAperture(true);
            View view2 = this.C;
            if (view2 != null && view2.getVisibility() == 0) {
                com.tencent.biz.qqcircle.helpers.e.f84616a.e(this.C, this.f92615e.getStNotice().operation.opUser, String.valueOf(13));
            } else {
                onClickListener.onClick(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void p(@NonNull QFSMessageItemInfo qFSMessageItemInfo) {
        FeedCloudMeta$StNotice stNotice = qFSMessageItemInfo.getStNotice();
        if (stNotice == null) {
            QLog.e(h(), 1, "setAvatar stNotice is null");
            return;
        }
        QCircleAvatarView qCircleAvatarView = this.f92617h;
        if (qCircleAvatarView == null) {
            QLog.e(h(), 1, "setAvatar view is null");
            return;
        }
        qCircleAvatarView.setShowAuthIcon(true ^ this.I);
        this.f92617h.setUser(stNotice.operation.opUser.get(), this.E);
        this.f92617h.setLivingStatus(this.I);
    }

    private void x(int i3) {
        LottieAnimationView lottieAnimationView = this.f92619m;
        if (lottieAnimationView == null) {
            QLog.e(h(), 1, "setBluePoint view is null");
            return;
        }
        QFSMessageItemInfo qFSMessageItemInfo = this.f92615e;
        if (qFSMessageItemInfo == null) {
            lottieAnimationView.setVisibility(8);
            this.C.setVisibility(8);
            QLog.e(h(), 1, "setBluePoint mItemInfo is null");
            return;
        }
        if (qFSMessageItemInfo.canShowHeadCircle() && !m(this.f92615e.getNoticeBusiData()) && n() && !this.I) {
            SimpleEventBus.getInstance().registerReceiver(this);
            if (!this.f92615e.hasShowApertureAnim()) {
                com.tencent.biz.qqcircle.helpers.e.f84616a.g(this.C, 1.5f);
                this.f92615e.setHasShowApertureAnim(true);
                return;
            } else {
                if (i3 != this.H) {
                    com.tencent.biz.qqcircle.helpers.e eVar = com.tencent.biz.qqcircle.helpers.e.f84616a;
                    if (!eVar.d(this.C)) {
                        eVar.f(this.C, 1.5f);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        e();
        com.tencent.biz.qqcircle.helpers.e.f84616a.a(this.C);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public void B(View.OnClickListener onClickListener) {
        QCircleAvatarListView qCircleAvatarListView;
        ViewStub viewStub = this.F;
        if (viewStub == null) {
            QLog.e(h(), 1, "showAvatarListAndSetClickListener listStub is null");
            return;
        }
        if (this.G == null) {
            this.G = (ViewGroup) viewStub.inflate();
        }
        if (this.f92615e == null) {
            QLog.e(h(), 1, "showAvatarListAndSetClickListener mItemInfo is null");
            return;
        }
        w(8);
        t(0);
        if (this.f92615e.getStNotice().vecUser.get().size() == 2) {
            qCircleAvatarListView = (QCircleAvatarListView) this.G.findViewById(R.id.t1n);
            this.G.findViewById(R.id.t1m).setVisibility(8);
        } else {
            qCircleAvatarListView = (QCircleAvatarListView) this.G.findViewById(R.id.t1m);
            this.G.findViewById(R.id.t1n).setVisibility(8);
        }
        qCircleAvatarListView.setVisibility(0);
        qCircleAvatarListView.setOnClickListener(onClickListener);
        ArrayList arrayList = new ArrayList();
        int min = Math.min(this.f92615e.getStNotice().vecUser.get().size(), 3);
        for (int i3 = 0; i3 < min; i3++) {
            FeedCloudMeta$StUser feedCloudMeta$StUser = this.f92615e.getStNotice().vecUser.get(i3);
            if (!TextUtils.isEmpty(feedCloudMeta$StUser.icon.iconUrl.get())) {
                arrayList.add(feedCloudMeta$StUser.icon.iconUrl.get());
            } else {
                arrayList.add(feedCloudMeta$StUser.f398463id.get());
            }
        }
        qCircleAvatarListView.setData(arrayList);
    }

    public void c() {
        FrameLayout frameLayout = this.f92616f;
        if (frameLayout != null && this.f92617h != null && this.f92619m != null) {
            if (frameLayout.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f92616f.getLayoutParams();
                int i3 = J;
                layoutParams.width = i3;
                layoutParams.height = i3;
                this.f92616f.setLayoutParams(layoutParams);
            }
            if (this.f92617h.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f92617h.getLayoutParams();
                int i16 = K;
                layoutParams2.width = i16;
                layoutParams2.height = i16;
                this.f92617h.setLayoutParams(layoutParams2);
            }
            if (this.f92619m.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f92619m.getLayoutParams();
                layoutParams3.leftMargin = L;
                layoutParams3.topMargin = M;
                this.f92619m.setLayoutParams(layoutParams3);
                return;
            }
            return;
        }
        QLog.e(h(), 1, "adjustAvatarLayout mAvatar view is null");
    }

    public void d(@NonNull QFSMessageItemInfo qFSMessageItemInfo, int i3) {
        this.f92615e = qFSMessageItemInfo;
        if (m(qFSMessageItemInfo.getNoticeBusiData())) {
            QLog.d(h(), 1, "[bindCustomData] show unread red point, isLiving:" + this.I);
        }
        p(qFSMessageItemInfo);
        s(qFSMessageItemInfo);
        A(qFSMessageItemInfo.getNoticeBusiData());
        x(i3);
        this.H = i3;
    }

    public void e() {
        LottieAnimationView lottieAnimationView = this.f92619m;
        if (lottieAnimationView == null) {
            QLog.e(h(), 1, "clearBluePoint view is null");
        } else {
            lottieAnimationView.setVisibility(8);
        }
    }

    public void f() {
        QFSMessageItemInfo qFSMessageItemInfo = this.f92615e;
        if (qFSMessageItemInfo == null) {
            QLog.e(h(), 1, "clearUnReadInfo mItemInfo is null");
            return;
        }
        QQCircleFeedBase$StNoticeBusiData noticeBusiData = qFSMessageItemInfo.getNoticeBusiData();
        if (noticeBusiData == null) {
            QLog.e(h(), 1, "clearUnReadInfo busiData is null");
            return;
        }
        if (!m(noticeBusiData)) {
            return;
        }
        if (this.f92615e.getStNotice() == null) {
            QLog.e(h(), 1, "clearUnReadInfo stNotice is null");
            return;
        }
        QCircleUnReadPointRequest qCircleUnReadPointRequest = new QCircleUnReadPointRequest(this.f92615e.getStNotice().operation.opUser.f398463id.get(), 9);
        VSNetworkHelper.getInstance().sendRequest(qCircleUnReadPointRequest, new a(qCircleUnReadPointRequest));
        QFSMessageNoticeCategoriesRequest qFSMessageNoticeCategoriesRequest = new QFSMessageNoticeCategoriesRequest(null);
        if (BaseRequest.isCacheExist(qFSMessageNoticeCategoriesRequest)) {
            BaseRequest.reMoveCache(qFSMessageNoticeCategoriesRequest);
        }
        noticeBusiData.messageBoxRedPointInfo.needShow.set(false);
        A(noticeBusiData);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        return new ArrayList<Class>() { // from class: com.tencent.biz.qqcircle.utils.QFSMessageAvatarWrapper.2
            {
                add(QFSAvatarApertureFeedExposeEvent.class);
            }
        };
    }

    public void j(Context context, @NonNull View view) {
        this.f92616f = (FrameLayout) view.findViewById(R.id.zfs);
        this.f92618i = view.findViewById(R.id.f47431x_);
        this.f92617h = (QCircleAvatarView) view.findViewById(R.id.f165909du3);
        this.f92619m = (LottieAnimationView) view.findViewById(R.id.f164547t15);
        this.C = view.findViewById(R.id.t1z);
        this.D = (ImageView) view.findViewById(R.id.y_c);
        this.E = com.tencent.biz.qqcircle.immersive.utils.n.a(context, R.dimen.f159391d02);
        this.F = (ViewStub) view.findViewById(R.id.zft);
        l(context);
        g(this.f92617h);
    }

    public void k(FeedCloudMeta$StNotice feedCloudMeta$StNotice, Map<String, Object> map) {
        boolean z16;
        String str;
        VideoReport.setElementId(this.f92617h, QCircleDaTongConstant.ElementId.EM_XSJ_PROFILE_AVATAR);
        LottieAnimationView lottieAnimationView = this.f92619m;
        boolean z17 = true;
        if (lottieAnimationView != null && lottieAnimationView.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        View view = this.C;
        if (view == null || view.getVisibility() != 0) {
            z17 = false;
        }
        if (!z16 && !z17) {
            str = "0";
        } else {
            str = "1";
        }
        map.put(QCircleDaTongConstant.ElementParamKey.XSJ_AVATAR_IF_DIFF, str);
        map.put("xsj_target_qq", feedCloudMeta$StNotice.operation.opUser.f398463id.get());
        VideoReport.setElementParams(this.f92617h, map);
        VideoReport.setElementReuseIdentifier(this.f92617h, feedCloudMeta$StNotice.noticeType.get() + "_" + feedCloudMeta$StNotice.operation.opUser.f398463id.get());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSAvatarApertureFeedExposeEvent) {
            i((QFSAvatarApertureFeedExposeEvent) simpleBaseEvent);
        }
    }

    public void q(final View.OnClickListener onClickListener) {
        if (onClickListener == null) {
            QLog.e(h(), 1, "setAvatarClickListener listener is null");
        } else if (this.f92617h == null) {
            QLog.e(h(), 1, "setAvatarClickListener view is null");
        } else {
            this.f92617h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qqcircle.utils.bw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QFSMessageAvatarWrapper.this.o(onClickListener, view);
                }
            });
        }
    }

    public void r(int i3) {
        FrameLayout frameLayout = this.f92616f;
        if (frameLayout == null) {
            QLog.e(h(), 1, "setAvatarContainerVisibility view is null");
        } else {
            if (frameLayout.getVisibility() == i3) {
                return;
            }
            this.f92616f.setVisibility(i3);
        }
    }

    public void s(QFSMessageItemInfo qFSMessageItemInfo) {
        if (this.f92618i == null) {
            return;
        }
        if (qFSMessageItemInfo != null && qFSMessageItemInfo.canShowAvatarLeftRedPoint()) {
            this.f92618i.setVisibility(0);
        } else {
            this.f92618i.setVisibility(8);
        }
    }

    public void t(int i3) {
        ViewGroup viewGroup = this.G;
        if (viewGroup == null) {
            QLog.e(h(), 1, "setAvatarListVisibility view is null");
        } else {
            if (viewGroup.getVisibility() == i3) {
                return;
            }
            this.G.setVisibility(i3);
        }
    }

    public void u(View.OnLongClickListener onLongClickListener) {
        if (onLongClickListener == null) {
            return;
        }
        QCircleAvatarView qCircleAvatarView = this.f92617h;
        if (qCircleAvatarView == null) {
            QLog.e(h(), 1, "setAvatarLongClickListener view is null");
        } else {
            qCircleAvatarView.setOnLongClickListener(onLongClickListener);
        }
    }

    public void v(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        if (feedCloudMeta$StUser == null) {
            QLog.e(h(), 1, "setAvatarUser user is null");
            return;
        }
        QCircleAvatarView qCircleAvatarView = this.f92617h;
        if (qCircleAvatarView == null) {
            QLog.e(h(), 1, "setAvatarUser view is null");
        } else {
            qCircleAvatarView.setUser(feedCloudMeta$StUser, this.E);
        }
    }

    public void w(int i3) {
        QCircleAvatarView qCircleAvatarView = this.f92617h;
        if (qCircleAvatarView == null) {
            QLog.e(h(), 1, "setAvatarVisibility view is null");
        } else {
            if (qCircleAvatarView.getVisibility() == i3) {
                return;
            }
            this.f92617h.setVisibility(i3);
        }
    }

    public void y(Size size) {
        this.E = size;
    }

    public void z(boolean z16) {
        this.I = z16;
    }
}
