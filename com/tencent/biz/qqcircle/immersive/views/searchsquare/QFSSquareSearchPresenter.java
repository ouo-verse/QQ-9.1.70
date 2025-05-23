package com.tencent.biz.qqcircle.immersive.views.searchsquare;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.collection.ArrayMap;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.lifecycle.Lifecycle;
import circlesearch.CircleSearchExhibition$SquareBubbleInfo;
import circlesearch.CircleSearchExhibition$SuggestionWord;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QFSSearchBean;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.views.QFSMarqueeTextView;
import com.tencent.biz.qqcircle.immersive.views.search.util.p;
import com.tencent.biz.qqcircle.immersive.views.searchsquare.a;
import com.tencent.biz.qqcircle.immersive.views.searchsquare.event.QFSSquarePageLifecycleChangeEvent;
import com.tencent.biz.qqcircle.immersive.views.searchsquare.event.QFSSquarePageSelectedEvent;
import com.tencent.biz.qqcircle.immersive.views.searchsquare.event.QFSSquareSearchLoadEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ua0.i;

/* loaded from: classes4.dex */
public class QFSSquareSearchPresenter extends QFSBaseFeedChildPresenter<Object> implements View.OnClickListener {
    private MotionLayout I;
    private QFSMarqueeTextView J;
    private View K;
    private Runnable L;
    private Runnable M;
    private com.tencent.biz.qqcircle.immersive.views.searchsquare.a N;
    private long P;
    private int Q = 0;
    private final Map<String, CircleSearchExhibition$SquareBubbleInfo> R = new ArrayMap();
    private FeedCloudMeta$StFeed S;
    private CircleSearchExhibition$SuggestionWord T;
    private boolean U;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class HideRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<QFSSquareSearchPresenter> f91303d;

        HideRunnable(QFSSquareSearchPresenter qFSSquareSearchPresenter) {
            this.f91303d = new WeakReference<>(qFSSquareSearchPresenter);
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSSquareSearchPresenter qFSSquareSearchPresenter = this.f91303d.get();
            if (qFSSquareSearchPresenter != null) {
                qFSSquareSearchPresenter.o1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class MarqueeRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<QFSMarqueeTextView> f91304d;

        MarqueeRunnable(QFSMarqueeTextView qFSMarqueeTextView) {
            this.f91304d = new WeakReference<>(qFSMarqueeTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            QFSMarqueeTextView qFSMarqueeTextView = this.f91304d.get();
            if (qFSMarqueeTextView != null) {
                qFSMarqueeTextView.setCanMarquee(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f91305a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            f91305a = iArr;
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f91305a[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c implements a.b {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<QFSSquareSearchPresenter> f91309a;

        /* renamed from: b, reason: collision with root package name */
        private final FeedCloudMeta$StFeed f91310b;

        /* renamed from: c, reason: collision with root package name */
        private final int f91311c;

        c(QFSSquareSearchPresenter qFSSquareSearchPresenter, FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
            this.f91309a = new WeakReference<>(qFSSquareSearchPresenter);
            this.f91310b = feedCloudMeta$StFeed;
            this.f91311c = i3;
        }

        @Override // com.tencent.biz.qqcircle.immersive.views.searchsquare.a.b
        public void a(CircleSearchExhibition$SquareBubbleInfo circleSearchExhibition$SquareBubbleInfo) {
            QFSSquareSearchPresenter qFSSquareSearchPresenter = this.f91309a.get();
            if (qFSSquareSearchPresenter != null) {
                qFSSquareSearchPresenter.t1(this.f91311c, this.f91310b, circleSearchExhibition$SquareBubbleInfo);
            }
        }
    }

    private void m1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        CircleSearchExhibition$SuggestionWord circleSearchExhibition$SuggestionWord;
        this.S = feedCloudMeta$StFeed;
        if (feedCloudMeta$StFeed == null) {
            return;
        }
        CircleSearchExhibition$SquareBubbleInfo circleSearchExhibition$SquareBubbleInfo = this.R.get(feedCloudMeta$StFeed.f398449id.get());
        if (circleSearchExhibition$SquareBubbleInfo != null && !circleSearchExhibition$SquareBubbleInfo.words.isEmpty()) {
            circleSearchExhibition$SuggestionWord = circleSearchExhibition$SquareBubbleInfo.words.get(0);
        } else {
            circleSearchExhibition$SuggestionWord = null;
        }
        if (circleSearchExhibition$SuggestionWord == null) {
            o1();
        } else {
            x1(feedCloudMeta$StFeed.f398449id.get(), circleSearchExhibition$SuggestionWord, (int) circleSearchExhibition$SquareBubbleInfo.duration.get());
        }
    }

    private void n1(QFSSquarePageLifecycleChangeEvent qFSSquarePageLifecycleChangeEvent) {
        int i3 = a.f91305a[qFSSquarePageLifecycleChangeEvent.event.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                o1();
            }
        } else if (!QCirclePluginUtil.isSharePanelOnShow()) {
            o1();
        }
    }

    private void p1(QFSSquareSearchLoadEvent qFSSquareSearchLoadEvent) {
        int i3;
        if (this.N == null) {
            this.N = new com.tencent.biz.qqcircle.immersive.views.searchsquare.a();
        }
        if (!qFSSquareSearchLoadEvent.isLoadMore) {
            i3 = this.Q + 1;
            this.Q = i3;
            this.R.clear();
            this.N.b();
            h60.a.a();
        } else {
            i3 = this.Q;
        }
        u1(qFSSquareSearchLoadEvent.feedList, i3);
    }

    private void q1() {
        if (this.I != null) {
            return;
        }
        View inflate = ((ViewStub) this.C.findViewById(R.id.f46591v0)).inflate();
        this.I = (MotionLayout) inflate.findViewById(R.id.f53712d9);
        this.J = (QFSMarqueeTextView) inflate.findViewById(R.id.f53492cn);
        View findViewById = inflate.findViewById(R.id.f54432f7);
        this.K = findViewById;
        findViewById.setOnClickListener(this);
        inflate.findViewById(R.id.f52552a4).setOnClickListener(this);
        this.I.addTransitionListener(new b());
    }

    private void r1() {
        if (!this.U) {
            return;
        }
        QFSSearchBean qFSSearchBean = new QFSSearchBean();
        qFSSearchBean.setUserSource(7);
        qFSSearchBean.setQuerySource(12);
        qFSSearchBean.setSearchKeyword(this.T.text.get());
        qFSSearchBean.setPageInteract(true);
        com.tencent.biz.qqcircle.launcher.c.A0(m0(), qFSSearchBean);
    }

    private boolean s1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        return "1".equals(p.e(feedCloudMeta$StFeed.recomInfo.recomAttachInfo.get().toStringUtf8()).get("bubble"));
    }

    private void u1(List<FeedCloudMeta$StFeed> list, int i3) {
        if (list != null && !list.isEmpty()) {
            for (FeedCloudMeta$StFeed feedCloudMeta$StFeed : list) {
                if (s1(feedCloudMeta$StFeed)) {
                    this.N.d(feedCloudMeta$StFeed, new c(this, feedCloudMeta$StFeed, i3));
                }
            }
        }
    }

    private void v1() {
        HashMap hashMap = new HashMap();
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : this.T.ext_info.mapInfo.get()) {
            String str = feedCloudCommon$Entry.key.get();
            String str2 = feedCloudCommon$Entry.value.get();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                hashMap.put(str, str2);
            }
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_BUBBLES_CONTENT_TEXT, this.T.text.get());
        i.j(this.K, QCircleDaTongConstant.ElementId.EM_XSJ_HOT_SEARCH_BUBBLES, hashMap);
    }

    private void w1(String str, String str2, int i3) {
        QLog.i("QFSSquareSearchPresenter", 1, "#show");
        this.U = true;
        q1();
        v1();
        this.K.setVisibility(0);
        this.J.setText(str2);
        this.I.setTransitionDuration(500);
        this.I.transitionToEnd();
        if (this.L == null) {
            this.L = new HideRunnable(this);
        }
        this.I.postDelayed(this.L, (i3 * 1000) + 500);
        this.N.a(str, str2);
        this.P = System.currentTimeMillis();
    }

    private void x1(String str, CircleSearchExhibition$SuggestionWord circleSearchExhibition$SuggestionWord, int i3) {
        QLog.i("QFSSquareSearchPresenter", 1, "#tryShow");
        String str2 = circleSearchExhibition$SuggestionWord.text.get();
        if (!this.N.c(str, str2) && !this.U) {
            this.T = circleSearchExhibition$SuggestionWord;
            w1(str, str2, i3);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QFSSquareSearchLoadEvent.class);
        arrayList.add(QFSSquarePageSelectedEvent.class);
        arrayList.add(QFSSquarePageLifecycleChangeEvent.class);
        return arrayList;
    }

    public void o1() {
        if (!this.U) {
            return;
        }
        this.U = false;
        this.J.removeCallbacks(this.M);
        this.I.removeCallbacks(this.L);
        this.I.setTransitionDuration(300);
        this.I.transitionToStart();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f54432f7) {
            r1();
        } else if (id5 == R.id.f52552a4) {
            o1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        try {
            if (simpleBaseEvent instanceof QFSSquareSearchLoadEvent) {
                p1((QFSSquareSearchLoadEvent) simpleBaseEvent);
            } else if (simpleBaseEvent instanceof QFSSquarePageSelectedEvent) {
                m1(((QFSSquarePageSelectedEvent) simpleBaseEvent).feed);
            } else if (simpleBaseEvent instanceof QFSSquarePageLifecycleChangeEvent) {
                n1((QFSSquarePageLifecycleChangeEvent) simpleBaseEvent);
            }
        } catch (Throwable th5) {
            QLog.e("QFSSquareSearchPresenter", 1, th5, new Object[0]);
        }
    }

    void t1(int i3, FeedCloudMeta$StFeed feedCloudMeta$StFeed, CircleSearchExhibition$SquareBubbleInfo circleSearchExhibition$SquareBubbleInfo) {
        if (this.Q == i3) {
            this.R.put(feedCloudMeta$StFeed.f398449id.get(), circleSearchExhibition$SquareBubbleInfo);
            if (this.S != null && feedCloudMeta$StFeed.f398449id.get().equals(this.S.f398449id.get())) {
                m1(this.S);
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSSquareSearchPresenter";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class b implements MotionLayout.TransitionListener {

        /* renamed from: d, reason: collision with root package name */
        private final List<View> f91306d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        private final List<Integer> f91307e;

        b() {
            ArrayList arrayList = new ArrayList();
            this.f91307e = arrayList;
            arrayList.add(Integer.valueOf(R.id.f46671v8));
            arrayList.add(Integer.valueOf(R.id.f502524w));
            arrayList.add(Integer.valueOf(R.id.f46601v1));
        }

        private void a() {
            long currentTimeMillis = (System.currentTimeMillis() - QFSSquareSearchPresenter.this.P) / 1000;
            if (currentTimeMillis <= 0) {
                currentTimeMillis = 1;
            }
            Map<String, ?> elementParams = VideoReport.getElementParams(QFSSquareSearchPresenter.this.K);
            elementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_BUBBLES_EXP_DURATION, String.valueOf(currentTimeMillis));
            VideoReport.setElementParams(QFSSquareSearchPresenter.this.K, elementParams);
        }

        private boolean b(View view) {
            if (view instanceof ViewStub) {
                return false;
            }
            if (this.f91307e.contains(Integer.valueOf(view.getId())) || view.getVisibility() != 0) {
                return false;
            }
            return true;
        }

        private void c() {
            a();
            QFSSquareSearchPresenter.this.K.setVisibility(8);
            VideoReport.traverseExposure();
        }

        private void d() {
            if (QFSSquareSearchPresenter.this.M == null) {
                QFSSquareSearchPresenter qFSSquareSearchPresenter = QFSSquareSearchPresenter.this;
                qFSSquareSearchPresenter.M = new MarqueeRunnable(qFSSquareSearchPresenter.J);
            }
            QFSSquareSearchPresenter.this.J.postDelayed(QFSSquareSearchPresenter.this.M, 1000L);
        }

        private void e() {
            if (!this.f91306d.isEmpty()) {
                return;
            }
            View findViewById = ((QFSBaseFeedChildPresenter) QFSSquareSearchPresenter.this).C.findViewById(R.id.vg5);
            this.f91306d.add(findViewById.findViewById(R.id.f165304vg4));
            this.f91306d.add(findViewById.findViewById(R.id.f46581uz));
            ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(R.id.f55582ia);
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.f45721sn);
            ViewGroup viewGroup3 = (ViewGroup) viewGroup.findViewById(R.id.f52272_c);
            f(viewGroup2);
            f(viewGroup3);
        }

        private void f(ViewGroup viewGroup) {
            if (viewGroup == null) {
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (b(childAt)) {
                    this.f91306d.add(childAt);
                }
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
        public void onTransitionChange(MotionLayout motionLayout, int i3, int i16, float f16) {
            int i17;
            for (View view : this.f91306d) {
                if (view != null) {
                    float f17 = 1.0f - f16;
                    view.setAlpha(f17);
                    if (f17 == 0.0f) {
                        i17 = 4;
                    } else {
                        i17 = 0;
                    }
                    view.setVisibility(i17);
                }
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
        public void onTransitionCompleted(MotionLayout motionLayout, int i3) {
            if (i3 == R.id.f43941nu) {
                d();
            } else {
                c();
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
        public void onTransitionStarted(MotionLayout motionLayout, int i3, int i16) {
            QFSSquareSearchPresenter.this.J.setCanMarquee(false);
            e();
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
        public void onTransitionTrigger(MotionLayout motionLayout, int i3, boolean z16, float f16) {
        }
    }
}
