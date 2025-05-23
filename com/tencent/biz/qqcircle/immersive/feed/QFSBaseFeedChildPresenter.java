package com.tencent.biz.qqcircle.immersive.feed;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Size;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.events.QFSSeekEvent;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.biz.richframework.part.TagData;
import com.tencent.biz.richframework.part.utils.RFWViewUtils;
import com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.biz.richframework.video.rfw.view.RFWVideoView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.common.EventAgingType;
import com.tencent.qqlive.module.videoreport.common.EventData;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.tvkplayer.view.TVKPlayerVideoView;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.player.MediaInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.QCircleReportBean;
import cooperation.qqcircle.report.QCircleReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class QFSBaseFeedChildPresenter<T> implements IRFWLayerItemViewScrollerStatus, SimpleEventReceiver {
    protected View C;
    protected QCircleExtraTypeInfo D;
    protected e30.b E;
    private Handler F;
    protected ViewGroup G;
    private final boolean H = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fix_multi_window_video_scale", true);

    /* renamed from: d, reason: collision with root package name */
    private t40.a f85014d;

    /* renamed from: e, reason: collision with root package name */
    protected int f85015e;

    /* renamed from: f, reason: collision with root package name */
    protected View f85016f;

    /* renamed from: h, reason: collision with root package name */
    protected T f85017h;

    /* renamed from: i, reason: collision with root package name */
    protected int f85018i;

    /* renamed from: m, reason: collision with root package name */
    protected cm f85019m;

    private Object B0() {
        View view = this.C;
        if (!(view instanceof QCircleBaseWidgetView)) {
            Object closestViewTagData = RFWViewUtils.getClosestViewTagData(TagData.TAG_DATA_ID, view);
            if (closestViewTagData instanceof QCircleReportBean) {
                return closestViewTagData;
            }
            return null;
        }
        return ((QCircleBaseWidgetView) view).getReportBean();
    }

    private boolean F0() {
        return TextUtils.equals(r0(), QCircleDaTongConstant.PageId.PG_XSJ_FULL_SCREEN_PAGE);
    }

    private void T(ImageView imageView, QFSVideoView qFSVideoView, int i3, int i16) {
        if (qFSVideoView != null && imageView != null) {
            QLog.d("QFSBaseFeedChildPresenter", 1, "isShowInPadFunctionZone = true");
            Y0(imageView, i3, i16);
            Y0(qFSVideoView, i3, i16);
            Z0(qFSVideoView, 0);
        }
    }

    private void U(ImageView imageView, QFSVideoView qFSVideoView, int i3, int i16) {
        if (qFSVideoView != null && imageView != null) {
            if (!TransitionHelper.shouldVideoYFullScreen(i3, i16) && (!TransitionHelper.isFolderScreenOpenMode(imageView.getContext()) || I0())) {
                if (TransitionHelper.shouldFullScreen(i3, i16)) {
                    Y0(imageView, -1, -1);
                    Y0(qFSVideoView, -1, -1);
                    b1(qFSVideoView, 2, i3, i16);
                    return;
                } else {
                    Y0(imageView, i3, i16);
                    Y0(qFSVideoView, i3, i16);
                    b1(qFSVideoView, 2, i3, i16);
                    return;
                }
            }
            TransitionHelper.setSizeWhenYFullScreen(l0(), imageView, i3, i16);
            Y0(qFSVideoView, -1, -1);
            b1(qFSVideoView, 0, i3, i16);
        }
    }

    private boolean Y() {
        boolean z16;
        if (m0() == null) {
            return false;
        }
        int screenWidth = DisplayUtil.getScreenWidth();
        int screenHeight = DisplayUtil.getScreenHeight();
        int instantScreenWidth = DisplayUtil.getInstantScreenWidth(m0());
        int instantScreenHeight = DisplayUtil.getInstantScreenHeight(m0());
        if (screenWidth <= 0 || screenHeight <= 0 || instantScreenHeight <= 0 || instantScreenWidth <= 0) {
            return true;
        }
        if (m0().getResources().getConfiguration().orientation == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (screenHeight >= screenWidth && instantScreenHeight >= instantScreenWidth) {
                return false;
            }
            return true;
        }
        if (screenHeight <= screenWidth && instantScreenHeight <= instantScreenWidth) {
            return false;
        }
        return true;
    }

    private boolean Z() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_fix_orientation_error", true) || com.tencent.biz.qqcircle.utils.bz.r()) {
            return true;
        }
        return false;
    }

    private void Z0(QFSVideoView qFSVideoView, int i3) {
        if (qFSVideoView != null && qFSVideoView.getQCirclePlayer() != null && qFSVideoView.getQCirclePlayer().getVideoView() != null) {
            T t16 = this.f85017h;
            if (t16 instanceof FeedCloudMeta$StFeed) {
                FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) t16;
                View videoView = qFSVideoView.getQCirclePlayer().getVideoView();
                if (videoView instanceof ISPlayerVideoView) {
                    ((ISPlayerVideoView) qFSVideoView.getQCirclePlayer().getVideoView()).setFixedSize(feedCloudMeta$StFeed.video.width.get(), feedCloudMeta$StFeed.video.height.get());
                    ((ISPlayerVideoView) qFSVideoView.getQCirclePlayer().getVideoView()).setXYaxis(i3);
                } else if (videoView instanceof TVKPlayerVideoView) {
                    ((TVKPlayerVideoView) qFSVideoView.getQCirclePlayer().getVideoView()).setFixedSize(feedCloudMeta$StFeed.video.width.get(), feedCloudMeta$StFeed.video.height.get());
                    ((TVKPlayerVideoView) qFSVideoView.getQCirclePlayer().getVideoView()).setXYaxis(i3);
                }
                qFSVideoView.requestLayout();
            }
        }
    }

    private void a0(QFSSeekEvent qFSSeekEvent) {
        T t16 = this.f85017h;
        if (!(t16 instanceof FeedCloudMeta$StFeed) || !((FeedCloudMeta$StFeed) t16).f398449id.get().equals(qFSSeekEvent.mFeedId)) {
            return;
        }
        c1(qFSSeekEvent.mIsOnSeek);
    }

    private void a1(QFSVideoView qFSVideoView, int i3, int i16, int i17) {
        if (qFSVideoView != null && qFSVideoView.getQCirclePlayer() != null && qFSVideoView.getQCirclePlayer().getVideoView() != null) {
            KeyEvent.Callback videoView = qFSVideoView.getQCirclePlayer().getVideoView();
            if (videoView instanceof ISPlayerVideoView) {
                ((ISPlayerVideoView) videoView).setFixedSize(i16, i17);
                ((ISPlayerVideoView) qFSVideoView.getQCirclePlayer().getVideoView()).setXYaxis(i3);
            } else if (videoView instanceof TVKPlayerVideoView) {
                TVKPlayerVideoView tVKPlayerVideoView = (TVKPlayerVideoView) videoView;
                tVKPlayerVideoView.setFixedSize(i16, i17);
                tVKPlayerVideoView.setXYaxis(i3);
            }
            qFSVideoView.requestLayout();
        }
    }

    private void b1(QFSVideoView qFSVideoView, int i3, int i16, int i17) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_re_size_player_view", true)) {
            a1(qFSVideoView, i3, i16, i17);
        } else {
            Z0(qFSVideoView, i3);
        }
    }

    private boolean k0() {
        if (uq3.c.e() && !com.tencent.biz.qqcircle.helpers.i.f84624a.a(String.valueOf(m0().hashCode())) && !QCirclePanelStateEvent.isSpecifiedPanelShowing(24) && !QCirclePanelStateEvent.isSpecifiedPanelShowing(26) && !QCirclePanelStateEvent.isSpecifiedPanelShowing(28) && !QCirclePanelStateEvent.isSpecifiedPanelShowing(39) && !QCirclePanelStateEvent.isSpecifiedPanelShowing(29) && !QCirclePanelStateEvent.isSpecifiedPanelShowing(40)) {
            return true;
        }
        return false;
    }

    private int l0() {
        View findViewById = ((Activity) this.f85016f.getContext()).findViewById(R.id.f73923uv);
        if (findViewById != null) {
            return findViewById.getHeight() - ImmersiveUtils.dpToPx(56.0f);
        }
        return 0;
    }

    private int z0() {
        if (Z()) {
            return DisplayUtil.getScreenWidth();
        }
        if (F0()) {
            return Math.max(DisplayUtil.getScreenWidth(), DisplayUtil.getScreenHeight());
        }
        return Math.min(DisplayUtil.getScreenWidth(), DisplayUtil.getScreenHeight());
    }

    public <VM extends BaseViewModel> VM A0(Class<VM> cls) {
        View view = this.C;
        if (view instanceof QCircleBaseWidgetView) {
            return (VM) ((QCircleBaseWidgetView) view).getViewModel(cls);
        }
        return null;
    }

    public boolean D0(e40.p pVar) {
        return false;
    }

    public boolean E0() {
        if (s0() == null || s0().getFeedPosition() != this.f85018i || !s0().isContainerOnScreen()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean G0() {
        if (!(this.C.getContext() instanceof Activity) || !this.H || !com.tencent.biz.qqcircle.utils.bz.n((Activity) this.C.getContext())) {
            return false;
        }
        return true;
    }

    public boolean H0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean I0() {
        T t16 = this.f85017h;
        if (!(t16 instanceof FeedCloudMeta$StFeed)) {
            return false;
        }
        return com.tencent.biz.qqcircle.immersive.utils.r.I0((FeedCloudMeta$StFeed) t16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean J0() {
        HashMap<String, String> hashMap;
        boolean z16;
        boolean z17;
        boolean isOnThirdTab = ASInject.g().getAsEngineDelegate().isOnThirdTab(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE);
        String str = "QFSBaseFeedChildPresenter";
        if (s0() == null) {
            RFWLog.d("QFSBaseFeedChildPresenter", RFWLog.USR, "isFeedOnScreen:" + E0() + " isOnThirdTab:" + isOnThirdTab + " pageId:" + y0() + "| ioc is null |" + hashCode());
            return false;
        }
        if (s0().getInitBean() != null) {
            hashMap = s0().getInitBean().getSchemeAttrs();
        } else {
            hashMap = null;
        }
        if (hashMap != null && String.valueOf(11).equals(hashMap.get("key_jump_from"))) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean a16 = com.tencent.biz.qqcircle.utils.ae.a(s0().getInitBean());
        boolean isTopActivityInQCircle = QCirclePluginUtil.isTopActivityInQCircle((Activity) m0());
        String str2 = "isFeedOnScreen:" + E0() + " isOnThirdTab:" + isOnThirdTab + " pageId:" + y0() + "| isFromBottom" + z16 + "| isShowSplash:" + a16 + "| isQCircleTopActivity:" + isTopActivityInQCircle + hashCode();
        if (isTopActivityInQCircle && E0() && !a16) {
            if (z16) {
                if (!TextUtils.isEmpty(w0())) {
                    str = w0();
                }
                int i3 = RFWLog.USR;
                Object[] objArr = new Object[1];
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str2);
                sb5.append(" |result:");
                if (isOnThirdTab && QCirclePluginUtil.isTabMode()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                sb5.append(z17);
                objArr[0] = sb5.toString();
                RFWLog.d(str, i3, objArr);
                if (isOnThirdTab && QCirclePluginUtil.isTabMode()) {
                    return true;
                }
                return false;
            }
            if (!TextUtils.isEmpty(w0())) {
                str = w0();
            }
            RFWLog.d(str, RFWLog.USR, str2 + " |result:true");
            return true;
        }
        if (!TextUtils.isEmpty(w0())) {
            str = w0();
        }
        RFWLog.d(str, RFWLog.USR, str2 + " |result:false");
        return false;
    }

    @CallSuper
    public void K0() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public void L0(T t16, int i3) {
        this.f85017h = t16;
        this.f85018i = i3;
    }

    @CallSuper
    public void M0() {
        x0().removeCallbacksAndMessages(null);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public void N0(@NonNull View view) {
        this.C = view;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O0(QFSVideoView qFSVideoView, ImageView imageView) {
        ISuperPlayer superPlayer;
        MediaInfo mediaInfo;
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_re_size_player_view", true)) {
            return;
        }
        T t16 = this.f85017h;
        if (!(t16 instanceof FeedCloudMeta$StFeed)) {
            return;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) t16;
        int i3 = feedCloudMeta$StFeed.video.width.get();
        int i16 = feedCloudMeta$StFeed.video.height.get();
        if (qFSVideoView == null || (superPlayer = qFSVideoView.getSuperPlayer()) == null || (mediaInfo = superPlayer.getMediaInfo()) == null) {
            return;
        }
        int videoWidth = mediaInfo.getVideoWidth();
        int videoHeight = mediaInfo.getVideoHeight();
        if (videoWidth > 0 && videoHeight > 0 && i3 > 0 && i16 > 0) {
            float f16 = videoWidth / videoHeight;
            float f17 = i3 / i16;
            if (f16 > 1.0f || f17 > 1.0f) {
                if (f16 > 1.0f && f17 > 1.0f) {
                    return;
                }
                QLog.d(w0(), 1, "rate not equal re size Video");
                if (com.tencent.biz.qqcircle.utils.bz.k() && !com.tencent.biz.qqcircle.utils.bz.m()) {
                    T(imageView, qFSVideoView, videoWidth, videoHeight);
                } else {
                    U(imageView, qFSVideoView, videoWidth, videoHeight);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void P0() {
        T t16 = this.f85017h;
        if (!(t16 instanceof FeedCloudMeta$StFeed)) {
            return;
        }
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder(ua0.c.c((FeedCloudMeta$StFeed) t16)).setActionType(2).setSubActionType(10).setPosition(this.f85018i).setPageId(y0()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void R0(int i3, int i16, QCircleExtraTypeInfo qCircleExtraTypeInfo, String str) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (qCircleExtraTypeInfo != null && (feedCloudMeta$StFeed = qCircleExtraTypeInfo.mFeed) != null) {
            QCircleLpReportDc05507.DataBuilder dataBuilder = new QCircleLpReportDc05507.DataBuilder(ua0.c.c(feedCloudMeta$StFeed));
            dataBuilder.setActionType(i3).setSubActionType(i16).setToUin(qCircleExtraTypeInfo.mFeed.poster.f398463id.get()).setPosition(qCircleExtraTypeInfo.mDataPosition).setPlayScene(qCircleExtraTypeInfo.mPlayScene).setExt1(str).setPageId(y0()).setExt10(ua0.c.f(m0())).setfpageid(Integer.valueOf(t0()).intValue()).setFirstFeedId(w20.a.j().h());
            QCircleLpReportDc05507.report(dataBuilder);
        } else {
            QLog.e("QCircleReportHelper_QFSBaseFeedChildPresenter", 1, "extraTypeInfo is null or lost feed,actionType:" + i3 + ",subActionType:" + i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, Object> S(Map<String, Object> map) {
        QCircleReportBean reportBean = getReportBean();
        if (reportBean != null && reportBean.getFromElement() != null) {
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_LAYER_PAGE_REF_EID, reportBean.getFromElement());
        }
        return map;
    }

    public void S0() {
        View view = this.C;
        if (view != null && (view.getParent() instanceof RecyclerView) && ((RecyclerView) this.C.getParent()).getAdapter().getNUM_BACKGOURND_ICON() > this.f85018i) {
            ((RecyclerView) this.C.getParent()).smoothScrollToPosition(this.f85018i + 1);
            P0();
        }
    }

    public void T0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
        cm cmVar = this.f85019m;
        if (cmVar == null) {
            return;
        }
        cmVar.b(hVar);
    }

    public void U0(QCircleExtraTypeInfo qCircleExtraTypeInfo) {
        this.D = qCircleExtraTypeInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V(QFSVideoView qFSVideoView, ImageView imageView) {
        T t16 = this.f85017h;
        if (!(t16 instanceof FeedCloudMeta$StFeed)) {
            return;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) t16;
        int i3 = feedCloudMeta$StFeed.video.width.get();
        int i16 = feedCloudMeta$StFeed.video.height.get();
        if (G0()) {
            T(imageView, qFSVideoView, i3, i16);
        } else if (com.tencent.biz.qqcircle.utils.bz.k() && !com.tencent.biz.qqcircle.utils.bz.m()) {
            T(imageView, qFSVideoView, i3, i16);
        } else {
            U(imageView, qFSVideoView, i3, i16);
        }
    }

    public void V0(e30.b bVar) {
        this.E = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W(QFSVideoView qFSVideoView, ImageView imageView) {
        if (!k0() && qFSVideoView != null && (qFSVideoView.getLayoutParams() instanceof FrameLayout.LayoutParams) && (((FrameLayout.LayoutParams) qFSVideoView.getLayoutParams()).gravity & 48) == 48) {
            RFWLog.d("QFSBaseFeedChildPresenter", RFWLog.USR, "adjustView, but view is in other layout mode");
        } else {
            V(qFSVideoView, imageView);
        }
    }

    public void W0(cm cmVar) {
        this.f85019m = cmVar;
    }

    public boolean X() {
        return false;
    }

    public void X0(ViewGroup viewGroup) {
        this.G = viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y0(View view, int i3, int i16) {
        int width;
        int height;
        if (i16 != 0 && i3 != 0 && view != null) {
            if (Y()) {
                QLog.d("QFSBaseFeedChildPresenter", 1, "adjust video size, screen size error. ");
                DisplayUtil.init(m0());
            }
            int z06 = z0();
            int i17 = -1;
            if (i3 == -1 && i16 == -1) {
                z06 = -1;
            } else {
                if (!com.tencent.biz.qqcircle.utils.bz.s(m0()) && !G0()) {
                    if (com.tencent.biz.qqcircle.utils.bz.k()) {
                        Size b16 = com.tencent.biz.qqcircle.utils.bz.b(i3, i16);
                        width = b16.getWidth();
                        height = b16.getHeight();
                    } else {
                        i17 = (int) ((z06 / i3) * i16);
                    }
                } else {
                    Size a16 = com.tencent.biz.qqcircle.utils.bz.a(i3, i16);
                    width = a16.getWidth();
                    height = a16.getHeight();
                }
                int i18 = width;
                i17 = height;
                z06 = i18;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(z06, i17);
            }
            layoutParams.width = z06;
            layoutParams.height = i17;
            layoutParams.gravity = 17;
            view.setLayoutParams(layoutParams);
            T0(new com.tencent.biz.qqcircle.immersive.feed.event.aq(view.getId(), z06, i17));
            RFWLog.d("QFSBaseFeedChildPresenter", RFWLog.USR, "fs_lifecycle setSize origin:", Integer.valueOf(i3), "|", Integer.valueOf(i16), " , target:", Integer.valueOf(z06), "|", Integer.valueOf(i17), " , hashCode" + hashCode(), " , view.hashCode", Integer.valueOf(view.hashCode()), " , pageId:" + y0());
            return;
        }
        RFWLog.d("QFSBaseFeedChildPresenter", RFWLog.USR, "setSize origin size zero");
    }

    public void d1(int i3) {
        this.f85015e = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e1(QFSVideoView qFSVideoView) {
        boolean z16;
        boolean z17;
        String str = "QFSBaseFeedChildPresenter";
        if (!uq3.c.c5()) {
            if (!TextUtils.isEmpty(w0())) {
                str = w0();
            }
            RFWLog.d(str, RFWLog.USR, hashCode() + " shouldNotPlayJudgeSameVideo wns:false");
            return false;
        }
        if ((this.f85017h instanceof FeedCloudMeta$StFeed) && qFSVideoView != null) {
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_interceptor_repeat_selected", true);
            if (qFSVideoView.getQCirclePlayer() != null && qFSVideoView.getQCirclePlayer().getRealPlayer() != null) {
                boolean d16 = com.tencent.biz.qqcircle.utils.bi.d(m0(), (FeedCloudMeta$StFeed) this.f85017h);
                if (qFSVideoView.getQCirclePlayer().getRealPlayer().getCurrentPlayerState() == 7) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (qFSVideoView.getQCirclePlayer().getRealPlayer().getCurrentPlayerState() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!TextUtils.isEmpty(w0())) {
                    str = w0();
                }
                RFWLog.d(str, RFWLog.USR, "autoScroll:" + d16 + " | isPlayerComplete:" + z16 + " | isIdle:" + z17 + " |interceptorSwitch: " + isSwitchOn);
                if (isSwitchOn) {
                    if (d16 && z16) {
                        return true;
                    }
                    return false;
                }
                if ((d16 && z16) || z17) {
                    return true;
                }
                return false;
            }
            if (qFSVideoView.hasLoadOptions() && isSwitchOn) {
                if (!TextUtils.isEmpty(w0())) {
                    str = w0();
                }
                RFWLog.d(str, RFWLog.USR, hashCode() + " shouldNotPlayJudgeSameVideo has loadOptions");
                return false;
            }
            if (!TextUtils.isEmpty(w0())) {
                str = w0();
            }
            RFWLog.d(str, RFWLog.USR, hashCode() + " no player");
            return true;
        }
        if (!TextUtils.isEmpty(w0())) {
            str = w0();
        }
        RFWLog.d(str, RFWLog.USR, hashCode() + " shouldNotPlayJudgeSameVideo error params");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f0(View view, String str) {
        g0(view, str, null);
    }

    public boolean f1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g0(final View view, final String str, final Map<String, Object> map) {
        e30.b bVar = this.E;
        if (bVar != null && bVar.g() != null && view != null && !TextUtils.isEmpty(str)) {
            QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter.1
                @Override // java.lang.Runnable
                public void run() {
                    View view2 = view;
                    if (view2 == null) {
                        return;
                    }
                    VideoReport.setElementId(view2, str);
                    Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                    buildElementParams.putAll(ua0.c.d(QFSBaseFeedChildPresenter.this.E));
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(QFSBaseFeedChildPresenter.this.f85018i + 1));
                    buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_QQLIVE, Boolean.valueOf(com.tencent.biz.qqcircle.immersive.utils.r.p0(QFSBaseFeedChildPresenter.this.E.g())));
                    buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
                    Map<? extends String, ? extends Object> map2 = map;
                    if (map2 != null) {
                        buildElementParams.putAll(map2);
                    }
                    VideoReport.setElementReuseIdentifier(view, str + QFSBaseFeedChildPresenter.this.E.g().f398449id.get());
                    VideoReport.setElementParams(view, buildElementParams);
                    VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
                    com.tencent.biz.qqcircle.helpers.k.f84627a.c(QFSBaseFeedChildPresenter.this.r0());
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QFSSeekEvent.class);
        return arrayList;
    }

    public QCircleReportBean getReportBean() {
        Object B0 = B0();
        if (!(B0 instanceof QCircleReportBean)) {
            if (!RFWApplication.isDebug()) {
                QLog.e("QFSBaseFeedChildPresenter", 1, "getReportBean but FSReportBean is null");
                return new QCircleReportBean();
            }
            QLog.e("QFSBaseFeedChildPresenter", 1, "getReportBean but FSReportBean is null , debug");
            throw new RuntimeException("getReportBean but FSReportBean is null");
        }
        return (QCircleReportBean) B0;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public /* synthetic */ RFWVideoView getVideoView() {
        return com.tencent.biz.richframework.video.rfw.drive.a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i0(View view, String str, Map<String, Object> map) {
        if (this.E != null && (this.f85017h instanceof FeedCloudMeta$StFeed) && view != null && !TextUtils.isEmpty(str)) {
            if (map == null) {
                map = new HashMap<>();
            }
            if (str.equals(QCircleDaTongConstant.EventId.EV_XSJ_LIKE_WORK)) {
                map.put(QCircleDaTongConstant.ElementParamKey.XSJ_IS_SHOW_AD, Integer.valueOf(com.tencent.biz.qqcircle.immersive.utils.ad.a.h((ViewGroup) this.C.findViewById(R.id.f40181do))));
                j0(view, str, map);
                return;
            }
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = (FeedCloudMeta$StFeed) this.f85017h;
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.d(this.E));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85018i + 1));
            buildElementParams.put("xsj_target_qq", feedCloudMeta$StFeed.poster.f398463id.get());
            buildElementParams.putAll(map);
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            VideoReport.reportEvent(str, view, buildElementParams);
            return;
        }
        QLog.d("QFSBaseFeedChildPresenter", 1, "dtReportCustomReport : mFeedBlockData, mData, view or eventId is null. ");
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public /* synthetic */ boolean isFloatingView() {
        return com.tencent.biz.richframework.video.rfw.drive.a.b(this);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public /* synthetic */ boolean isVideoType() {
        return com.tencent.biz.richframework.video.rfw.drive.a.c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j0(View view, String str, Map<String, Object> map) {
        if (this.E != null && (this.f85017h instanceof FeedCloudMeta$StFeed) && view != null && !TextUtils.isEmpty(str)) {
            VideoReport.reportEvent(EventData.builder().withParam(QCircleDaTongConstant.ElementParamKey.XSJ_FEED_INDEX, Integer.valueOf(this.f85018i + 1)).withParam("xsj_target_qq", ((FeedCloudMeta$StFeed) this.f85017h).poster.f398463id.get()).withParam("xsj_session_id", QCircleNativeSessionManager.g().getSession()).withParam(DTParamKey.REPORT_KEY_APPKEY, "00000QG6YX3X0LZH").withParams(ua0.c.d(this.E)).withParams(map).withId(str).withSource(view).withType(EventAgingType.IMMEDIATE).build());
        } else {
            QLog.d("QFSBaseFeedChildPresenter", 1, "dtReportCustomReport : mFeedBlockData, mData, view or eventId is null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context m0() {
        View view = this.C;
        if (view != null) {
            return view.getContext();
        }
        return null;
    }

    public T n0() {
        return this.f85017h;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    @CallSuper
    public void onDestroy() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public /* synthetic */ void onLoadFeedExport(int i3, int i16) {
        com.tencent.biz.richframework.video.rfw.drive.b.c(this, i3, i16);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public /* synthetic */ void onPageScrolledIdle(int i3) {
        com.tencent.biz.richframework.video.rfw.drive.b.d(this, i3);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPosUpdate(int i3) {
        this.f85018i = i3;
        QCircleExtraTypeInfo qCircleExtraTypeInfo = this.D;
        if (qCircleExtraTypeInfo != null) {
            qCircleExtraTypeInfo.mDataPosition = i3;
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSSeekEvent) {
            a0((QFSSeekEvent) simpleBaseEvent);
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public /* synthetic */ void onStart(RFWFeedSelectInfo rFWFeedSelectInfo) {
        com.tencent.biz.richframework.video.rfw.drive.b.h(this, rFWFeedSelectInfo);
    }

    public String q0() {
        return getReportBean().getDtCustomPagId();
    }

    public QCircleExtraTypeInfo r() {
        return this.D;
    }

    public String r0() {
        return getReportBean().getDtPageId();
    }

    public t40.a s0() {
        if (this.f85014d == null) {
            this.f85014d = (t40.a) u0(t40.a.class);
        }
        return this.f85014d;
    }

    public String t0() {
        return String.valueOf(getReportBean().getFromPageId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T u0(Class<T> cls) {
        return (T) RFWIocAbilityProvider.g().getIocInterface(cls, this.C, this.G);
    }

    public String v0() {
        int i3;
        Fragment hostFragment = s0().getHostFragment();
        if (hostFragment != null) {
            i3 = hostFragment.hashCode();
        } else {
            i3 = 0;
        }
        if (this.C == null) {
            return "";
        }
        return this.C.getContext().hashCode() + "_" + i3 + "_" + this.C.hashCode();
    }

    public abstract String w0();

    public Handler x0() {
        if (this.F == null) {
            this.F = new Handler(Looper.getMainLooper());
        }
        return this.F;
    }

    public int y0() {
        return getReportBean().getPageId();
    }

    public void Q0() {
    }

    public void C0(com.tencent.biz.qqcircle.immersive.feed.event.h hVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c1(boolean z16) {
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStop(RFWFeedSelectInfo rFWFeedSelectInfo) {
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderAttachedToWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerItemViewScrollerStatus
    public void onViewHolderDetachedFromWindow(@NonNull RecyclerView.ViewHolder viewHolder) {
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedPageScrolled(int i3, float f16, int i16) {
    }
}
