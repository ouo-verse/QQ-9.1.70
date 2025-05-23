package o50;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizeDetailBean;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QFSLayerFloatShowEvent;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.QFSLayerPageFragment;
import com.tencent.biz.qqcircle.immersive.events.QFSTransitionChangeLocationEvent;
import com.tencent.biz.qqcircle.immersive.events.RFWTransitionAnimEvent;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.biz.qqcircle.immersive.repository.foldertab.j;
import com.tencent.biz.qqcircle.immersive.utils.ad;
import com.tencent.biz.qqcircle.immersive.utils.bb;
import com.tencent.biz.qqcircle.immersive.utils.bi;
import com.tencent.biz.qqcircle.immersive.utils.v;
import com.tencent.biz.qqcircle.immersive.views.QFSRFWDragLayout;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.utils.k;
import com.tencent.biz.richframework.animation.transition.TransitionAnimUtil;
import com.tencent.biz.richframework.animation.transition.TransitionHelper;
import com.tencent.biz.richframework.animation.transition.TransitionInitData;
import com.tencent.biz.richframework.animation.transition.TransitionManager;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.widget.drag.RFWDragLayout;
import com.tencent.util.AppSetting;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qzone.event.QZoneVideoRetryPlayEvent;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import m50.h;
import mqq.util.WeakReference;
import p40.n;
import p40.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public class e extends u implements SimpleEventReceiver {
    private final boolean D;
    private FeedCloudMeta$StFeed E;

    /* renamed from: d, reason: collision with root package name */
    private final h f422090d;

    /* renamed from: e, reason: collision with root package name */
    private QCircleInitBean f422091e;

    /* renamed from: f, reason: collision with root package name */
    private QFSTransitionAnimBean f422092f;

    /* renamed from: h, reason: collision with root package name */
    private TransitionManager f422093h;

    /* renamed from: i, reason: collision with root package name */
    private QFSRFWDragLayout f422094i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f422095m = false;
    private final List<View> C = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b implements RFWDragLayout.DragInterceptDelegate {
        b() {
        }

        @Override // com.tencent.richframework.widget.drag.RFWDragLayout.DragInterceptDelegate
        public boolean needIntercept(MotionEvent motionEvent, float f16, float f17) {
            Object obj;
            Pair S9 = e.this.S9();
            if (S9 != null && S9.first != null && (obj = S9.second) != null) {
                boolean g16 = j.g((FeedCloudMeta$StFeed) obj);
                boolean isAnyPanelShowing = QCirclePanelStateEvent.isAnyPanelShowing();
                if (e.this.f422094i.g()) {
                    if (((Integer) S9.first).intValue() != 0) {
                        return false;
                    }
                    if ((isAnyPanelShowing && !e.this.ba()) || g16 || Math.abs(f16) > Math.abs(f17)) {
                        return false;
                    }
                    return true;
                }
                if (((Integer) S9.first).intValue() != 0 || isAnyPanelShowing || g16 || Math.abs(f16) > f17) {
                    return false;
                }
                return true;
            }
            QLog.e(e.this.getTAG(), 1, "[needIntercept] data is error");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c implements h.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f422098a;

        c(AtomicInteger atomicInteger) {
            this.f422098a = atomicInteger;
        }

        @Override // m50.h.c
        public void a() {
            RFWLog.d("TM-QFSTransitionAnimPart", RFWLog.USR, "onFastPlayFinish");
            e.this.ea(this.f422098a.decrementAndGet());
            t40.f fVar = (t40.f) e.this.getIocInterface(t40.f.class);
            if (fVar != null) {
                fVar.p8(e.this.f422090d.x());
            }
        }

        @Override // m50.h.c
        public void b() {
            e.this.f422093h.dismissCoverView();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class f implements TransitionManager.OnAnimEndListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TransitionManager.OnAnimEndListener f422104a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f422105b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ BitmapDrawable f422106c;

        f(TransitionManager.OnAnimEndListener onAnimEndListener, String str, BitmapDrawable bitmapDrawable) {
            this.f422104a = onAnimEndListener;
            this.f422105b = str;
            this.f422106c = bitmapDrawable;
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionManager.OnAnimEndListener
        public void onAnimCancel() {
            TransitionManager.OnAnimEndListener onAnimEndListener = this.f422104a;
            if (onAnimEndListener != null) {
                onAnimEndListener.onAnimCancel();
            }
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionManager.OnAnimEndListener
        public void onAnimEnd() {
            TransitionManager.OnAnimEndListener onAnimEndListener = this.f422104a;
            if (onAnimEndListener != null) {
                onAnimEndListener.onAnimEnd();
            }
            e.this.Q9(this.f422105b, this.f422106c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class g extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<TransitionManager> f422108d;

        public g(TransitionManager transitionManager) {
            this.f422108d = new WeakReference<>(transitionManager);
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            super.onStateChange(loadState, option);
            if (loadState == LoadState.STATE_SUCCESS) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(option.getResultBitMap());
                TransitionManager transitionManager = this.f422108d.get();
                if (transitionManager != null) {
                    transitionManager.setCoverDrawable(bitmapDrawable);
                    QLog.i("TM-TM-QFSTransitionAnimPart", 1, "handleTransitionChangeLocation  | drawable = " + bitmapDrawable);
                }
            }
        }
    }

    public e(QCircleInitBean qCircleInitBean) {
        this.f422091e = qCircleInitBean;
        if (qCircleInitBean instanceof QCircleLayerBean) {
            this.f422092f = ((QCircleLayerBean) qCircleInitBean).getTransitionAnimBean();
        } else if (qCircleInitBean instanceof QCirclePolymerizeDetailBean) {
            this.f422092f = ((QCirclePolymerizeDetailBean) qCircleInitBean).getTransitionAnimBean();
        }
        this.f422090d = new h(qCircleInitBean);
        this.D = ac0.a.a(qCircleInitBean);
    }

    private void L9(TransitionInitData transitionInitData, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (transitionInitData == null || feedCloudMeta$StFeed == null || feedCloudMeta$StFeed.images.get().size() == 0) {
            return;
        }
        transitionInitData.setEndScaleType(v.a(feedCloudMeta$StFeed.images.get().get(0).width.get(), feedCloudMeta$StFeed.images.get().get(0).height.get()));
        transitionInitData.setImageEndRect(new RectF(0.0f, DisplayUtil.getTopHeight(getContext()), transitionInitData.getLayoutEndRect().width(), transitionInitData.getLayoutEndRect().height() - ImmersiveUtils.dpToPx(56.0f)));
    }

    private void M9(TransitionInitData transitionInitData, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        float f16;
        if (transitionInitData != null && feedCloudMeta$StFeed != null) {
            int i3 = feedCloudMeta$StFeed.video.width.get();
            int i16 = feedCloudMeta$StFeed.video.height.get();
            float f17 = 0.0f;
            if (!TransitionHelper.shouldVideoYFullScreen(i3, i16) && (!TransitionHelper.isFolderScreenOpenMode(getContext()) || feedCloudMeta$StFeed.video.orientation.get() == 2)) {
                if (TransitionHelper.shouldFullScreen(i3, i16)) {
                    transitionInitData.setImageEndRect(new RectF(0.0f, DisplayUtil.getTopHeight(getContext()), transitionInitData.getLayoutEndRect().width(), transitionInitData.getLayoutEndRect().height() - ImmersiveUtils.dpToPx(56.0f)));
                } else {
                    float instantScreenWidth = DisplayUtil.getInstantScreenWidth(getContext());
                    float f18 = (int) ((instantScreenWidth / i3) * i16);
                    if (transitionInitData.getLayoutEndRect().width() > instantScreenWidth) {
                        f16 = (transitionInitData.getLayoutEndRect().width() - instantScreenWidth) / 2.0f;
                    } else {
                        f16 = 0.0f;
                    }
                    float height = (transitionInitData.getLayoutEndRect().height() - DisplayUtil.getTopHeight(getContext())) - ImmersiveUtils.dpToPx(56.0f);
                    if (height > f18) {
                        f17 = (height - f18) / 2.0f;
                    }
                    transitionInitData.setImageEndRect(new RectF(f16, DisplayUtil.getTopHeight(getContext()) + f17, instantScreenWidth + f16, (DisplayUtil.getTopHeight(getContext()) + height) - f17));
                }
            } else {
                float height2 = ((transitionInitData.getLayoutEndRect().height() - DisplayUtil.getTopHeight(getContext())) - ImmersiveUtils.dpToPx(56.0f)) * (i3 / i16);
                if (transitionInitData.getLayoutEndRect().width() > height2) {
                    f17 = (transitionInitData.getLayoutEndRect().width() - height2) / 2.0f;
                }
                transitionInitData.setImageEndRect(new RectF(f17, DisplayUtil.getTopHeight(getContext()), height2 + f17, transitionInitData.getLayoutEndRect().height() - ImmersiveUtils.dpToPx(56.0f)));
            }
            transitionInitData.setEndScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    private void N9(@NonNull TransitionManager transitionManager, BitmapDrawable bitmapDrawable, TransitionManager.OnAnimEndListener onAnimEndListener) {
        QLog.i("TM-TM-QFSTransitionAnimPart", 1, "doRealBackAnim");
        ga();
        gb0.b.G(getActivity());
        String R9 = R9(this.f422091e);
        RFWTransitionAnimEvent rFWTransitionAnimEvent = new RFWTransitionAnimEvent(R9, true);
        rFWTransitionAnimEvent.setAnimCoverDrawable(bitmapDrawable);
        SimpleEventBus.getInstance().dispatchEvent(rFWTransitionAnimEvent);
        transitionManager.startExitAnim(new f(onAnimEndListener, R9, bitmapDrawable));
    }

    private boolean O9() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_layer_drag_close", true);
    }

    public static boolean P9() {
        if (!QCircleDeviceInfoUtils.isLowDevice() && !bz.r()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q9(String str, BitmapDrawable bitmapDrawable) {
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
            activity.overridePendingTransition(0, 0);
        }
        RFWTransitionAnimEvent rFWTransitionAnimEvent = new RFWTransitionAnimEvent(str, false);
        rFWTransitionAnimEvent.setAnimCoverDrawable(bitmapDrawable);
        SimpleEventBus.getInstance().dispatchEvent(rFWTransitionAnimEvent);
    }

    private String R9(QCircleInitBean qCircleInitBean) {
        HashMap<String, String> schemeAttrs;
        if (qCircleInitBean == null || (schemeAttrs = qCircleInitBean.getSchemeAttrs()) == null) {
            return "";
        }
        return schemeAttrs.get(QZoneVideoRetryPlayEvent.CLICK_VIEW_HASH_CODE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Pair<Integer, FeedCloudMeta$StFeed> S9() {
        PartManager partManager;
        o50.b bVar;
        QFSLayerPageFragment E9;
        t40.a aVar;
        e30.b bVar2;
        QFSBaseFragment hostFragment = getHostFragment();
        if (hostFragment == null) {
            partManager = null;
        } else {
            partManager = hostFragment.getPartManager();
        }
        if (partManager == null || (bVar = (o50.b) partManager.getPart(o50.b.class.getName())) == null || (E9 = bVar.E9()) == null || !E9.isResumed() || (aVar = (t40.a) E9.getIocInterface(t40.a.class)) == null) {
            return null;
        }
        int feedPosition = aVar.getFeedPosition();
        List<e30.b> feedList = aVar.getFeedList();
        if (feedList == null || feedList.size() <= feedPosition || feedPosition < 0 || (bVar2 = feedList.get(feedPosition)) == null || bVar2.g() == null) {
            return null;
        }
        return new Pair<>(Integer.valueOf(feedPosition), bVar2.g());
    }

    private void T9(final QFSLayerFloatShowEvent qFSLayerFloatShowEvent) {
        if (this.f422093h == null) {
            Z9();
        }
        QLog.w("TM-QFSTransitionAnimPart", 1, "handleFloatShowEvent:" + qFSLayerFloatShowEvent.getTriggerType());
        bi.p(new bi.a() { // from class: o50.d
            @Override // com.tencent.biz.qqcircle.immersive.utils.bi.a
            public final void a(Pair pair) {
                e.this.ca(qFSLayerFloatShowEvent, pair);
            }
        });
    }

    private void U9(QFSTransitionChangeLocationEvent qFSTransitionChangeLocationEvent) {
        if (this.f422092f != null && this.f422093h != null) {
            if ((this.f422091e instanceof QCircleLayerBean) && qFSTransitionChangeLocationEvent.getPageCode() == ((QCircleLayerBean) this.f422091e).getPageCode()) {
                RectF rectF = new RectF(qFSTransitionChangeLocationEvent.getLeft(), qFSTransitionChangeLocationEvent.getTop(), qFSTransitionChangeLocationEvent.getRight(), qFSTransitionChangeLocationEvent.getBottom());
                this.f422093h.updateStartAnimRect(rectF, rectF, qFSTransitionChangeLocationEvent.getScaleType());
                if (!TextUtils.isEmpty(qFSTransitionChangeLocationEvent.getCoverUrl())) {
                    QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(qFSTransitionChangeLocationEvent.getCoverUrl()).setLifecycleOwner(getPartHost().getLifecycleOwner()), new g(this.f422093h));
                }
                QLog.i("TM-" + getTAG(), 1, "handleTransitionChangeLocation , startRect = " + rectF.toString() + " , eventPath = " + qFSTransitionChangeLocationEvent.getCoverUrl());
                return;
            }
            QLog.w("TM-QFSTransitionAnimPart", 1, "handleTransitionChangeLocation  globalViewModelKey no correct");
        }
    }

    private void V9(View view) {
        if (view != null && (view.getParent() instanceof ViewGroup) && view != getPartRootView()) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt != view && childAt.getId() != R.id.u28 && childAt.getVisibility() == 0) {
                    this.C.add(childAt);
                }
            }
            if (view.getParent() instanceof View) {
                V9((View) view.getParent());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W9() {
        QFSVideoView qFSVideoView;
        java.lang.ref.WeakReference<QFSVideoView> weakReference = QFSVideoView.D;
        if (weakReference != null) {
            qFSVideoView = weakReference.get();
        } else {
            qFSVideoView = null;
        }
        V9(qFSVideoView);
        for (View view : this.C) {
            if (view != null) {
                view.setAlpha(0.0f);
            }
        }
        ia(true);
    }

    private static boolean X9() {
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qcircle_enable_up_drag_action_exit", true)) {
            return false;
        }
        if (AppSetting.isGrayVersion()) {
            return true;
        }
        String a16 = k.a("exp_xsj_change_interactive_message_video_play_experience");
        QLog.d("TM-QFSTransitionAnimPart", 1, "hitUpDragExitExp:" + a16);
        return "exp_xsj_change_interactive_message_video_play_experience_B".equals(a16);
    }

    private void Y9(View view) {
        if (this.f422092f == null) {
            QLog.w(getTAG(), 1, "initDragFrameLayout mAnimBean == null, no open anim");
            return;
        }
        QCircleInitBean qCircleInitBean = this.f422091e;
        if (qCircleInitBean != null && qCircleInitBean.getFeed() != null) {
            this.f422095m = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_folder_drag_layout_background", false);
            this.f422093h = new TransitionManager();
            this.f422094i = (QFSRFWDragLayout) view.findViewById(R.id.sph);
            ia(false);
            if (O9()) {
                QCircleInitBean qCircleInitBean2 = this.f422091e;
                if ((qCircleInitBean2 instanceof QCircleLayerBean) && ((QCircleLayerBean) qCircleInitBean2).isSupportDragExit()) {
                    QLog.d(getTAG(), 1, "initDragFrameLayout: set drag frame layout feature enable, enableBg:" + this.f422095m);
                    this.f422094i.setFeatureEnable(true);
                    this.f422094i.setEnableDragVertical(true);
                    this.f422094i.setEnableDragHorizontal(true);
                    if (X9() && this.f422091e.isEnableUpDragExit()) {
                        this.f422094i.setEnableDragVerticalUpAction(true);
                    }
                    this.f422094i.setOnDragListener(new a());
                    this.f422094i.setDragInterceptDelegate(new b());
                    return;
                }
            }
            QLog.d(getTAG(), 1, "[initDragFrameLayout] enableBg:" + this.f422095m);
            this.f422094i.setFeatureEnable(false);
            return;
        }
        QLog.e(getTAG(), 1, "initDragFrameLayout feed == null");
    }

    private void Z9() {
        if (this.f422094i == null) {
            this.f422094i = (QFSRFWDragLayout) getPartRootView().findViewById(R.id.sph);
            ia(true);
        }
        if (this.f422093h == null) {
            bb.b(getActivity());
            RectF c16 = ad.c(!gb0.b.z(this.E));
            TransitionInitData transitionInitData = new TransitionInitData();
            transitionInitData.setLayoutStartRect(c16);
            transitionInitData.setEnterAnimFadeCoverTimeMs(200);
            transitionInitData.setTransitionDelayTimeMs(0);
            transitionInitData.setTransitionAniDurationMs(200);
            transitionInitData.setFadeAniLayoutNotImg(true);
            transitionInitData.setStartScaleType(ImageView.ScaleType.CENTER_CROP);
            transitionInitData.setBackgroundColor(RFWApplication.getApplication().getResources().getColor(R.color.black));
            transitionInitData.setLayoutEndRect(new RectF(0.0f, 0.0f, DisplayUtil.getInstantScreenWidth(RFWApplication.getApplication()), getRealScreenHeight() - cx.h()));
            M9(transitionInitData, this.E);
            TransitionManager transitionManager = new TransitionManager();
            this.f422093h = transitionManager;
            transitionManager.initCoverViewAndData(this.f422094i, transitionInitData);
        }
    }

    private void aa() {
        QCircleInitBean qCircleInitBean;
        int measuredWidth;
        int measuredHeight;
        if (this.f422094i != null && this.f422092f != null && (qCircleInitBean = this.f422091e) != null && qCircleInitBean.getFeed() != null) {
            TransitionInitData transitionInitData = new TransitionInitData();
            transitionInitData.setCoverDrawable(TransitionAnimUtil.getCoverDrawable());
            transitionInitData.setLayoutStartRect(new RectF(this.f422092f.getLayoutRect().getLeft(), this.f422092f.getLayoutRect().getTop(), this.f422092f.getLayoutRect().getRight(), this.f422092f.getLayoutRect().getBottom()));
            if (this.f422092f.getImageRect() != null) {
                transitionInitData.setImageStartRect(new RectF(this.f422092f.getImageRect().getLeft(), this.f422092f.getImageRect().getTop(), this.f422092f.getImageRect().getRight(), this.f422092f.getImageRect().getBottom()));
            }
            transitionInitData.setEnterAnimFadeCoverTimeMs(this.f422092f.getEnterAnimFadeCoverTimeMs());
            transitionInitData.setExitAnimFadeCoverTimeMs(this.f422092f.getExitAnimFadeCoverTimeMs());
            transitionInitData.setTransitionDelayTimeMs(this.f422092f.getTransitionDelayTimeMs());
            transitionInitData.setTransitionAniDurationMs(this.f422092f.getTransitionDurationMs());
            transitionInitData.setStartScaleType(this.f422092f.getScaleType());
            transitionInitData.setBackgroundColor(getContext().getResources().getColor(R.color.black));
            if (this.f422094i.getMeasuredWidth() == 0) {
                measuredWidth = DisplayUtil.getInstantScreenWidth(getContext());
            } else {
                measuredWidth = this.f422094i.getMeasuredWidth();
            }
            if (this.f422094i.getMeasuredHeight() == 0) {
                measuredHeight = getRealScreenHeight() - cx.h();
            } else {
                measuredHeight = this.f422094i.getMeasuredHeight();
            }
            transitionInitData.setLayoutEndRect(new RectF(0.0f, 0.0f, measuredWidth, measuredHeight));
            if (this.f422091e.getFeed().type.get() == 3) {
                M9(transitionInitData, this.f422091e.getFeed());
            } else {
                L9(transitionInitData, this.f422091e.getFeed());
            }
            AtomicInteger atomicInteger = new AtomicInteger(1);
            float dpToPx = ImmersiveUtils.dpToPx(56.0f);
            float topHeight = DisplayUtil.getTopHeight(getContext());
            if (this.D) {
                atomicInteger.incrementAndGet();
                this.f422090d.v(this.f422094i, topHeight, dpToPx, false);
                this.f422090d.H(getActivity(), this.f422091e.getFeed(), new c(atomicInteger));
            }
            this.f422093h.initCoverViewAndData(this.f422094i, transitionInitData);
            this.f422093h.startEnterAnim(new d(atomicInteger), false);
            return;
        }
        QLog.e(getTAG(), 1, "initStartAnim params error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ba() {
        if (QCirclePanelStateEvent.getShowingPanelCount() == 1 && QCirclePanelStateEvent.isSpecifiedPanelShowing(27)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ca(QFSLayerFloatShowEvent qFSLayerFloatShowEvent, Pair pair) {
        BitmapDrawable bitmapDrawable;
        if (pair != null && pair.second != null) {
            QLog.i("TM-TM-QFSTransitionAnimPart", 1, "handleFloatShowEvent getDisplayTexture succeed");
            bitmapDrawable = new BitmapDrawable((Bitmap) pair.second);
            this.f422093h.setCoverDrawable(bitmapDrawable);
        } else {
            QLog.i("TM-TM-QFSTransitionAnimPart", 1, "handleFloatShowEvent getDisplayTexture error");
            bitmapDrawable = null;
        }
        RectF c16 = ad.c(!gb0.b.z(this.E));
        this.f422093h.updateStartAnimRect(c16, c16, null);
        this.f422093h.getTransitionInitData().setFadeAniLayoutNotImg(false);
        this.f422093h.getTransitionInitData().setExitAnimFadeCoverTimeMs(500);
        this.f422093h.getTransitionInitData().setNeedFadeAniWhenExit(true);
        N9(this.f422093h, bitmapDrawable, new C10884e(qFSLayerFloatShowEvent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void da(Pair pair) {
        BitmapDrawable bitmapDrawable;
        if (pair != null && pair.second != null) {
            QLog.i("TM-TM-QFSTransitionAnimPart", 1, "onBackEvent getDisplayTexture succeed");
            bitmapDrawable = new BitmapDrawable((Bitmap) pair.second);
            this.f422093h.setCoverDrawable(bitmapDrawable);
        } else {
            QLog.i("TM-TM-QFSTransitionAnimPart", 1, "onBackEvent getDisplayTexture error");
            bitmapDrawable = null;
        }
        N9(this.f422093h, bitmapDrawable, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ea(int i3) {
        if (i3 != 0) {
            return;
        }
        RFWLog.d("TM-QFSTransitionAnimPart", RFWLog.USR, "realOnAnimEnd");
        TransitionManager transitionManager = this.f422093h;
        if (transitionManager != null) {
            if (this.D) {
                transitionManager.dismissCoverView();
            } else {
                transitionManager.dismissCoverViewAnim();
            }
        }
        if (getHostFragment() != null) {
            getHostFragment().registerDaTongReportPageId();
        }
        getPartManager().broadcastMessage("qfs_transition_end_and_start_layout", null);
        gb0.b.j(getActivity());
    }

    private void ga() {
        if (getActivity() == null || getActivity().getWindow() == null) {
            return;
        }
        getActivity().getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    private int getRealScreenHeight() {
        boolean isInMultiWindowMode;
        int instantScreenHeight = DisplayUtil.getInstantScreenHeight(getContext()) + DisplayUtil.getTopHeight(getContext());
        if (getActivity() != null && Build.VERSION.SDK_INT >= 24) {
            isInMultiWindowMode = getActivity().isInMultiWindowMode();
            if (isInMultiWindowMode) {
                return instantScreenHeight - DisplayUtil.getTopHeight(getContext());
            }
            return instantScreenHeight;
        }
        return instantScreenHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ha() {
        if (this.C.isEmpty()) {
            QLog.e(getTAG(), 1, "[showHideView] mHideView is empty");
            return;
        }
        for (View view : this.C) {
            if (view != null) {
                view.setAlpha(1.0f);
            }
        }
        ia(false);
        this.C.clear();
    }

    private void ia(boolean z16) {
        QFSRFWDragLayout qFSRFWDragLayout;
        int color;
        if (this.f422095m && (qFSRFWDragLayout = this.f422094i) != null) {
            if (z16) {
                color = 0;
            } else {
                color = QCircleSkinHelper.getInstance().getColor(R.color.cje);
            }
            qFSRFWDragLayout.setBackgroundColor(color);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSTransitionChangeLocationEvent.class);
        arrayList.add(QFSLayerFloatShowEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "TM-QFSTransitionAnimPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Object getMessage(String str, Object obj) {
        boolean z16;
        TransitionManager transitionManager;
        if (TextUtils.equals("qfs_get_layer_transition_anim_drawable", str) && this.f422092f != null && (transitionManager = this.f422093h) != null) {
            return transitionManager.getCoverDrawable();
        }
        if (TextUtils.equals("qfs_is_open_layer_transition_anim", str)) {
            if (this.f422092f != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }
        return super.getMessage(str, obj);
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String str, Object obj) {
        super.handleBroadcastMessage(str, obj);
        if (!"layer_notify_part_update_feed".equals(str) || !(obj instanceof e30.b)) {
            return;
        }
        e30.b bVar = (e30.b) obj;
        if (bVar.g() == null) {
            return;
        }
        this.E = bVar.g();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        boolean P9 = P9();
        boolean d16 = o.d(this.f422091e);
        boolean f16 = o.f(this.f422091e);
        QLog.d("TM-QFSTransitionAnimPart", 1, "init part :" + P9 + "|" + d16 + "|" + f16);
        if (P9 || d16 || f16) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        QFSTransitionAnimBean qFSTransitionAnimBean;
        int i3;
        boolean onBackEvent = super.onBackEvent();
        QFSTransitionAnimBean qFSTransitionAnimBean2 = this.f422092f;
        if (qFSTransitionAnimBean2 != null && qFSTransitionAnimBean2.isDisableBackTransitionWhenPosChanged()) {
            Pair<Integer, FeedCloudMeta$StFeed> S9 = S9();
            QCircleInitBean qCircleInitBean = this.f422091e;
            if (qCircleInitBean != null) {
                i3 = qCircleInitBean.getDataPosInList();
            } else {
                i3 = 0;
            }
            if (S9 != null && i3 != ((Integer) S9.first).intValue()) {
                return onBackEvent;
            }
        }
        if (!onBackEvent && this.f422094i != null && this.f422093h != null && (qFSTransitionAnimBean = this.f422092f) != null && qFSTransitionAnimBean.isBackTransition()) {
            if (this.f422092f.isBackUseVideoFrame()) {
                bi.p(new bi.a() { // from class: o50.c
                    @Override // com.tencent.biz.qqcircle.immersive.utils.bi.a
                    public final void a(Pair pair) {
                        e.this.da(pair);
                    }
                });
            } else {
                N9(this.f422093h, null, null);
            }
            return true;
        }
        return onBackEvent;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        Y9(view);
        aa();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        h hVar = this.f422090d;
        if (hVar != null) {
            hVar.D();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        this.f422090d.F();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSTransitionChangeLocationEvent) {
            U9((QFSTransitionChangeLocationEvent) simpleBaseEvent);
        }
        if (simpleBaseEvent instanceof QFSLayerFloatShowEvent) {
            T9((QFSLayerFloatShowEvent) simpleBaseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class d implements TransitionManager.OnAnimEndListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicInteger f422100a;

        d(AtomicInteger atomicInteger) {
            this.f422100a = atomicInteger;
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionManager.OnAnimEndListener
        public void onAnimEnd() {
            RFWLog.d("TM-QFSTransitionAnimPart", RFWLog.USR, "onAnimEnd");
            e.this.ea(this.f422100a.decrementAndGet());
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionManager.OnAnimEndListener
        public void onAnimCancel() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: o50.e$e, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C10884e implements TransitionManager.OnAnimEndListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QFSLayerFloatShowEvent f422102a;

        C10884e(QFSLayerFloatShowEvent qFSLayerFloatShowEvent) {
            this.f422102a = qFSLayerFloatShowEvent;
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionManager.OnAnimEndListener
        public void onAnimEnd() {
            n.e().q(e.this.getContext(), e.this.E, this.f422102a.getEnterType(), e.this.getPageId(), null);
        }

        @Override // com.tencent.biz.richframework.animation.transition.TransitionManager.OnAnimEndListener
        public void onAnimCancel() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements RFWDragLayout.OnDragListener {
        a() {
        }

        @Override // com.tencent.richframework.widget.drag.RFWDragLayout.OnDragListener
        public void onEndDrag(boolean z16) {
            QLog.d(e.this.getTAG(), 1, "[onEndDrag] isDragToClose=" + z16 + ", activity=" + e.this.getActivity());
            if (!z16 || e.this.getActivity() == null) {
                e.this.ha();
            } else {
                e.this.getActivity().onBackPressed();
            }
        }

        @Override // com.tencent.richframework.widget.drag.RFWDragLayout.OnDragListener
        public void onStartDrag() {
            QLog.d(e.this.getTAG(), 1, "[onStartDrag]");
            e.this.W9();
        }

        @Override // com.tencent.richframework.widget.drag.RFWDragLayout.OnDragListener
        public void onDragging(float f16) {
        }
    }
}
