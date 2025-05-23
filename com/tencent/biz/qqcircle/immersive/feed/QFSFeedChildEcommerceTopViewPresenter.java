package com.tencent.biz.qqcircle.immersive.feed;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.events.QCircleEcommerceEvent;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdTopViewPresenter;
import com.tencent.biz.qqcircle.immersive.feed.animwrap.n;
import com.tencent.biz.qqcircle.immersive.feed.event.QFSTabTitleVisibilityEvent;
import com.tencent.biz.qqcircle.immersive.manager.QFSEcommercePreloadManager;
import com.tencent.biz.qqcircle.immersive.manager.QFSEcommerceTopViewManager;
import com.tencent.biz.qqcircle.widgets.QFSEcommerceTopViewFrameLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.order.RFWOrderElementManager;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.gdtad.views.shake.GdtShakeSensor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqecommerce.biz.consumer.api.IQQGoodsViewModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class QFSFeedChildEcommerceTopViewPresenter extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements GdtShakeSensor.OnShakeListener {
    private static final ArrayList<Integer> S;
    private IQQGoodsViewModel I;
    private GdtShakeSensor J;
    private AlphaAnimation K;
    private View L;
    private QFSEcommerceTopViewFrameLayout M;
    private com.tencent.biz.qqcircle.immersive.feed.animwrap.n N;
    private int P;
    private final Runnable Q = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildEcommerceTopViewPresenter.1
        @Override // java.lang.Runnable
        public void run() {
            if (QFSFeedChildEcommerceTopViewPresenter.this.I != null) {
                QFSFeedChildEcommerceTopViewPresenter.this.I.sendTopViewEvent(7, new JSONObject());
            }
        }
    };
    private final Runnable R = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildEcommerceTopViewPresenter.2
        @Override // java.lang.Runnable
        public void run() {
            if (QFSFeedChildEcommerceTopViewPresenter.this.L != null) {
                QFSFeedChildEcommerceTopViewPresenter.this.L.setVisibility(4);
            }
        }
    };

    static {
        ArrayList<Integer> arrayList = new ArrayList<>();
        S = arrayList;
        arrayList.add(Integer.valueOf(R.id.f40261dw));
        arrayList.add(Integer.valueOf(R.id.f40051db));
        arrayList.add(Integer.valueOf(R.id.f41471h6));
        arrayList.add(Integer.valueOf(R.id.f34520zd));
    }

    private JSONObject j1(int[] iArr, int[] iArr2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("goods_card_width", iArr2[0]);
            jSONObject.put("goods_card_height", iArr2[1]);
            jSONObject.put("location_x", iArr[0]);
            jSONObject.put("location_y", iArr[1]);
        } catch (JSONException unused) {
            QLog.d("QFSFeedChildEcommerceTopViewPresenter", 1, "[getGoodsCardLocation] json put error!");
        }
        return jSONObject;
    }

    private com.tencent.biz.qqcircle.immersive.feed.animwrap.n k1() {
        if (this.N == null) {
            this.N = new n.d().e(333).f(this.C.getId()).g(S).a();
        }
        return this.N;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l1() {
        RFWThreadManager.getUIHandler().post(this.Q);
    }

    private void o1() {
        QFSEcommerceTopViewFrameLayout qFSEcommerceTopViewFrameLayout = this.M;
        if (qFSEcommerceTopViewFrameLayout != null) {
            qFSEcommerceTopViewFrameLayout.removeAllViews();
        }
    }

    private void p1(int i3) {
        boolean z16 = true;
        if (i3 != 1 && i3 != 2) {
            z16 = false;
        }
        T0(new com.tencent.biz.qqcircle.immersive.feed.event.r(2, z16));
        this.P = i3;
    }

    private void q1(boolean z16, boolean z17) {
        QLog.d("QFSFeedChildEcommerceTopViewPresenter", 1, "showContent needAnimation = " + z16 + " immediateHideView = " + z17);
        RFWThreadManager.getUIHandler().removeCallbacks(this.Q);
        RFWThreadManager.getUIHandler().removeCallbacks(this.R);
        p1(3);
        k1().j(z16);
        SimpleEventBus.getInstance().dispatchEvent(new QFSTabTitleVisibilityEvent(0, z16, 333));
        QFSEcommerceTopViewFrameLayout qFSEcommerceTopViewFrameLayout = this.M;
        if (qFSEcommerceTopViewFrameLayout != null) {
            qFSEcommerceTopViewFrameLayout.setEnableOperate(false);
        }
        if (z17) {
            RFWThreadManager.getUIHandler().postDelayed(this.R, 20L);
            IQQGoodsViewModel iQQGoodsViewModel = this.I;
            if (iQQGoodsViewModel != null) {
                iQQGoodsViewModel.onWrapperViewDisappear();
            }
            s1();
            return;
        }
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        View findViewWithTag = this.C.findViewWithTag("goods_card_layout");
        if (findViewWithTag != null) {
            findViewWithTag.getLocationInWindow(iArr);
            iArr2[0] = findViewWithTag.getWidth();
            iArr2[1] = findViewWithTag.getHeight();
            n1(findViewWithTag);
        }
        IQQGoodsViewModel iQQGoodsViewModel2 = this.I;
        if (iQQGoodsViewModel2 != null) {
            iQQGoodsViewModel2.sendTopViewEvent(8, j1(iArr, iArr2));
        }
    }

    private void r1() {
        GdtShakeSensor gdtShakeSensor = this.J;
        if (gdtShakeSensor != null) {
            gdtShakeSensor.register(m0());
        }
    }

    private void s1() {
        GdtShakeSensor gdtShakeSensor = this.J;
        if (gdtShakeSensor != null) {
            gdtShakeSensor.unregister(m0());
            this.J = null;
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public boolean D0(e40.p pVar) {
        int i3 = this.P;
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @SuppressLint({"ClickableViewAccessibility"})
    public void N0(@NonNull View view) {
        super.N0(view);
        QLog.d("QFSFeedChildEcommerceTopViewPresenter", 1, "onInitView rootView=" + view + " hashcode " + hashCode());
        View inflate = ((ViewStub) view.findViewById(R.id.f40251dv)).inflate();
        this.L = inflate;
        QFSEcommerceTopViewFrameLayout qFSEcommerceTopViewFrameLayout = (QFSEcommerceTopViewFrameLayout) inflate.findViewById(R.id.f40241du);
        this.M = qFSEcommerceTopViewFrameLayout;
        qFSEcommerceTopViewFrameLayout.setEnableOperate(true);
        this.M.setOnSwipeListener(new QFSEcommerceTopViewFrameLayout.a() { // from class: com.tencent.biz.qqcircle.immersive.feed.ae
            @Override // com.tencent.biz.qqcircle.widgets.QFSEcommerceTopViewFrameLayout.a
            public final void a() {
                QFSFeedChildEcommerceTopViewPresenter.this.l1();
            }
        });
        this.L.setVisibility(8);
        p1(0);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        if (eventClass == null) {
            eventClass = new ArrayList<>();
        }
        eventClass.add(QCircleEcommerceEvent.class);
        return eventClass;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: m1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        String str;
        T t16 = this.f85017h;
        if (t16 == 0) {
            str = null;
        } else {
            str = ((FeedCloudMeta$StFeed) t16).f398449id.get();
        }
        if (feedCloudMeta$StFeed == null || !feedCloudMeta$StFeed.f398449id.get().equals(str)) {
            p1(0);
        }
        super.L0(feedCloudMeta$StFeed, i3);
        QLog.d("QFSFeedChildEcommerceTopViewPresenter", 1, "onBindData id = " + str + " position=" + this.f85018i + " " + hashCode());
        o1();
        s1();
    }

    protected void n1(View view) {
        if (view != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            this.K = alphaAnimation;
            alphaAnimation.setDuration(333L);
            view.startAnimation(this.K);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        super.onDestroy();
        IQQGoodsViewModel iQQGoodsViewModel = this.I;
        if (iQQGoodsViewModel != null) {
            iQQGoodsViewModel.onWrapperViewDisappear();
            this.I = null;
        }
        QFSEcommercePreloadManager.j().q((FeedCloudMeta$StFeed) this.f85017h);
        s1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        boolean z16;
        super.onFeedSelected(rFWFeedSelectInfo);
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.getPosition() == this.f85018i) {
            boolean k3 = QFSEcommercePreloadManager.j().k((FeedCloudMeta$StFeed) this.f85017h);
            boolean f16 = QFSEcommerceTopViewManager.b().f((FeedCloudMeta$StFeed) this.f85017h);
            boolean e16 = QFSEcommerceTopViewManager.b().e((FeedCloudMeta$StFeed) this.f85017h);
            boolean d16 = QFSEcommerceTopViewManager.b().d((FeedCloudMeta$StFeed) this.f85017h);
            QLog.d("QFSFeedChildEcommerceTopViewPresenter", 1, "onFeedSelected id = " + ((FeedCloudMeta$StFeed) this.f85017h).f398449id.get() + " position=" + this.f85018i + " isTopViewFeed " + e16 + " hasShowed " + d16 + " isVerticalVideo " + f16 + " isGoodsDataPreloadSuccess " + k3 + " state " + this.P + " hashcode " + hashCode());
            if (e16 && this.f85018i == 0 && k3) {
                z16 = true;
            } else {
                z16 = false;
            }
            QFSEcommerceTopViewManager.b().h((FeedCloudMeta$StFeed) this.f85017h);
            if (!z16) {
                if (s0().isContainerOnScreen()) {
                    q1(false, true);
                    return;
                }
                return;
            }
            if (!d16 && this.P == 0) {
                z70.b x16 = QFSFeedChildAdTopViewPresenter.x1(m0());
                if (x16 != null) {
                    x16.l(RFWOrderElementManager.OrderMode.ROB_MODE);
                }
                p1(1);
                this.L.setVisibility(0);
                k1().d(this.C.findViewById(R.id.f41541hc), false);
                SimpleEventBus.getInstance().dispatchEvent(new QFSTabTitleVisibilityEvent(4, false, 0));
                IQQGoodsViewModel i3 = QFSEcommercePreloadManager.j().i(m0(), (FeedCloudMeta$StFeed) this.f85017h, 8, y0());
                this.I = i3;
                i3.setWrapperView(this.M, null);
                this.I.onWrapperViewAppear(false);
                this.I.sendTopViewEvent(1, new JSONObject());
                GdtShakeSensor gdtShakeSensor = new GdtShakeSensor();
                this.J = gdtShakeSensor;
                gdtShakeSensor.setShakeListener(new WeakReference<>(this));
                r1();
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onFeedUnSelected(rFWFeedSelectInfo);
        QFSEcommerceTopViewFrameLayout qFSEcommerceTopViewFrameLayout = this.M;
        if (qFSEcommerceTopViewFrameLayout != null) {
            qFSEcommerceTopViewFrameLayout.setEnableOperate(false);
        }
        z70.b x16 = QFSFeedChildAdTopViewPresenter.x1(m0());
        if (x16 != null) {
            x16.m();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        super.onPaused(rFWFeedSelectInfo);
        z70.b x16 = QFSFeedChildAdTopViewPresenter.x1(m0());
        if (x16 != null) {
            x16.m();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        JSONObject params;
        super.onReceiveEvent(simpleBaseEvent);
        if ((simpleBaseEvent instanceof QCircleEcommerceEvent) && (params = ((QCircleEcommerceEvent) simpleBaseEvent).getParams()) != null && params.length() > 0) {
            q1(params.optBoolean("showContentNeedAnimation", false), params.optBoolean("immediateHideContent", true));
        }
    }

    @Override // com.tencent.gdtad.views.shake.GdtShakeSensor.OnShakeListener
    public void onShakeComplete() {
        QLog.d("QFSFeedChildEcommerceTopViewPresenter", 1, "[onShakeComplete]");
        IQQGoodsViewModel iQQGoodsViewModel = this.I;
        if (iQQGoodsViewModel != null) {
            iQQGoodsViewModel.sendTopViewEvent(5, new JSONObject());
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSFeedChildEcommerceTopViewPresenter";
    }
}
