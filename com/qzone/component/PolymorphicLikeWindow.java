package com.qzone.component;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.qzone.component.PolymorphicLikeCellLayout;
import com.qzone.component.StickerBubbleAnimationView;
import com.qzone.module.feedcomponent.ui.FeedView;
import com.qzone.module.feedcomponent.ui.NormalAbsFeedView;
import com.qzone.module.feedcomponent.ui.common.SuperLikeView;
import com.qzone.module.feedcomponent.util.AlarmTask;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PolymorphicPraiseData;
import com.qzone.proxy.feedcomponent.model.PolymorphicPraiseEmotionData;
import com.qzone.proxy.feedcomponent.ui.j;
import com.qzone.util.ToastUtil;
import com.qzone.util.ap;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.FrameAnimView;
import com.qzone.widget.util.ZipLoadBitmapGenerator;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes39.dex */
public class PolymorphicLikeWindow extends PopupWindow {
    public static final String K = l.a(R.string.pak);
    private static final String L = l.a(R.string.pam);
    private static final String M = l.a(R.string.pal);
    private static final String N = l.a(R.string.pan);
    private static final int O;
    private static final int P;
    private static final int Q;
    private static final int R;
    public static final int S;
    private boolean A;
    private boolean B;
    private long C;
    private BusinessFeedData D;
    private int E;
    private final ap F;
    private int G;
    private int H;
    private PolymorphicPraiseEmotionData I;
    private AlarmTask.OnAlarmListener J;

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<Context> f46230a;

    /* renamed from: b, reason: collision with root package name */
    private ViewGroup f46231b;

    /* renamed from: c, reason: collision with root package name */
    private View f46232c;

    /* renamed from: d, reason: collision with root package name */
    private View f46233d;

    /* renamed from: e, reason: collision with root package name */
    private PolymorphicLikeCellLayout f46234e;

    /* renamed from: f, reason: collision with root package name */
    private AsyncImageView f46235f;

    /* renamed from: g, reason: collision with root package name */
    private View f46236g;

    /* renamed from: h, reason: collision with root package name */
    private AsyncImageView f46237h;

    /* renamed from: i, reason: collision with root package name */
    private OnItemSelectListener f46238i;

    /* renamed from: j, reason: collision with root package name */
    private int f46239j;

    /* renamed from: k, reason: collision with root package name */
    private int f46240k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f46241l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f46242m;

    /* renamed from: n, reason: collision with root package name */
    private AlarmTask f46243n;

    /* renamed from: o, reason: collision with root package name */
    private final PokeLikeWizard f46244o;

    /* renamed from: p, reason: collision with root package name */
    private final List<PolymorphicPraiseEmotionData> f46245p;

    /* renamed from: q, reason: collision with root package name */
    private final List<i> f46246q;

    /* renamed from: r, reason: collision with root package name */
    private final List<ZipLoadBitmapGenerator> f46247r;

    /* renamed from: s, reason: collision with root package name */
    private final StickerBubbleAnimationView f46248s;

    /* renamed from: t, reason: collision with root package name */
    private int f46249t;

    /* renamed from: u, reason: collision with root package name */
    private View f46250u;

    /* renamed from: v, reason: collision with root package name */
    private TextView f46251v;

    /* renamed from: w, reason: collision with root package name */
    private Animator f46252w;

    /* renamed from: x, reason: collision with root package name */
    private Animator f46253x;

    /* renamed from: y, reason: collision with root package name */
    private ValueAnimator f46254y;

    /* renamed from: z, reason: collision with root package name */
    private final boolean f46255z;

    /* loaded from: classes39.dex */
    public interface OnItemSelectListener {
        void onSelect(int i3, int i16, PolymorphicPraiseEmotionData polymorphicPraiseEmotionData);
    }

    /* loaded from: classes39.dex */
    class a implements StickerBubbleAnimationView.StickerBubbleAnimationCallback {
        a() {
        }

        @Override // com.qzone.component.StickerBubbleAnimationView.StickerBubbleAnimationCallback
        public void onAnimationEnd() {
            PolymorphicLikeWindow.this.Z();
        }

        @Override // com.qzone.component.StickerBubbleAnimationView.StickerBubbleAnimationCallback
        public void onSurfaceDestroyed() {
            PolymorphicLikeWindow.this.Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getActionMasked() != 0 || PolymorphicLikeWindow.this.V(view, motionEvent.getX(), motionEvent.getY())) {
                return false;
            }
            if (PolymorphicLikeWindow.this.f46241l) {
                PolymorphicLikeWindow.this.Q();
                return true;
            }
            PolymorphicLikeWindow.this.P();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (PolymorphicLikeWindow.this.isShowing()) {
                PolymorphicLikeWindow.this.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (PolymorphicLikeWindow.this.isShowing()) {
                PolymorphicLikeWindow.this.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class f implements j {
        f() {
        }

        @Override // com.qzone.proxy.feedcomponent.ui.j
        public void a() {
            if (PolymorphicLikeWindow.this.isShowing()) {
                PolymorphicLikeWindow.this.dismiss();
            }
        }
    }

    /* loaded from: classes39.dex */
    class g implements AlarmTask.OnAlarmListener {
        g() {
        }

        @Override // com.qzone.module.feedcomponent.util.AlarmTask.OnAlarmListener
        public void onAlarm(AlarmTask alarmTask) {
            PolymorphicLikeWindow.this.P();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        private final SparseArray<int[]> f46265d = new SparseArray<>();

        /* renamed from: e, reason: collision with root package name */
        private final float f46266e;

        /* renamed from: f, reason: collision with root package name */
        private final float f46267f;

        h(int i3) {
            this.f46266e = PolymorphicLikeWindow.this.f46235f.getScaleY();
            if (i3 == -1) {
                this.f46267f = 1.0f;
            } else {
                this.f46267f = 0.89655f;
            }
            for (int i16 = 0; i16 < PolymorphicLikeWindow.this.f46246q.size(); i16++) {
                int[] iArr = new int[2];
                iArr[0] = ((i) PolymorphicLikeWindow.this.f46246q.get(i16)).f46271c.getWidth();
                if (i3 == -1) {
                    iArr[1] = PolymorphicLikeWindow.O;
                } else if (i3 == i16) {
                    iArr[1] = PolymorphicLikeWindow.P;
                } else {
                    iArr[1] = PolymorphicLikeWindow.Q;
                }
                this.f46265d.put(i16, iArr);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            float f16 = this.f46266e;
            float f17 = this.f46267f;
            if (f16 != f17) {
                PolymorphicLikeWindow.this.f46235f.setScaleY(((f17 - f16) * floatValue) + f16);
            }
            for (int i3 = 0; i3 < PolymorphicLikeWindow.this.f46246q.size(); i3++) {
                i iVar = (i) PolymorphicLikeWindow.this.f46246q.get(i3);
                int[] iArr = this.f46265d.get(i3);
                int i16 = iArr[0];
                if (i16 != iArr[1]) {
                    int i17 = (int) (((r3 - i16) * floatValue) + i16);
                    ViewGroup.LayoutParams layoutParams = iVar.f46271c.getLayoutParams();
                    layoutParams.width = i17;
                    layoutParams.height = i17;
                    iVar.f46271c.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes39.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        private final ViewGroup f46269a;

        /* renamed from: b, reason: collision with root package name */
        private final TextView f46270b;

        /* renamed from: c, reason: collision with root package name */
        private final FrameAnimView f46271c;

        i(Context context, ViewGroup viewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.f169052ce3, viewGroup, false);
            this.f46269a = viewGroup2;
            this.f46270b = (TextView) viewGroup2.findViewById(R.id.m4i);
            this.f46271c = (FrameAnimView) viewGroup2.findViewById(R.id.m4h);
        }
    }

    public PolymorphicLikeWindow(Context context, View view, View view2, StickerBubbleAnimationView stickerBubbleAnimationView, boolean z16) {
        super(context);
        this.f46239j = -1;
        this.f46240k = 0;
        this.f46241l = false;
        this.f46244o = PokeLikeWizard.INSTANCE;
        this.f46245p = new ArrayList(5);
        this.f46246q = new ArrayList(5);
        this.f46247r = new ArrayList(5);
        this.B = true;
        this.F = ap.f59791b;
        this.J = new g();
        this.f46230a = new WeakReference<>(context);
        this.f46233d = view;
        this.f46236g = view2;
        this.f46255z = z16;
        this.f46248s = stickerBubbleAnimationView;
        U();
        this.f46242m = true;
        stickerBubbleAnimationView.setAnimationCallback(new a());
    }

    private void O(Context context, PolymorphicPraiseEmotionData polymorphicPraiseEmotionData) {
        i iVar = new i(context, this.f46234e);
        this.f46245p.add(polymorphicPraiseEmotionData);
        this.f46246q.add(iVar);
        this.f46247r.add(this.f46244o.getPokeLikeAnimItem(polymorphicPraiseEmotionData.strPraiseZip));
        iVar.f46270b.setText(polymorphicPraiseEmotionData.strName);
        this.f46234e.addView(iVar.f46269a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        if (this.f46231b == null) {
            return;
        }
        Animator animator = this.f46253x;
        if (animator == null || !animator.isRunning()) {
            Animator animator2 = this.f46252w;
            if (animator2 != null && animator2.isRunning()) {
                this.f46252w.cancel();
                this.f46252w = null;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(ObjectAnimator.ofFloat(this.f46231b, "translationY", 0.0f, ar.e(32.0f)));
            linkedList.add(ObjectAnimator.ofFloat(this.f46231b, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f));
            if (this.f46248s.getVisibility() == 0) {
                linkedList.add(ObjectAnimator.ofFloat(this.f46248s, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f));
            }
            View view = this.f46250u;
            if (view != null) {
                linkedList.add(ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f));
            }
            TextView textView = this.f46251v;
            if (textView != null) {
                linkedList.add(ObjectAnimator.ofFloat(textView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f));
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.setInterpolator(new PathInterpolator(0.42f, 0.0f, 1.0f, 1.0f));
            animatorSet.addListener(new e());
            animatorSet.playTogether(linkedList);
            animatorSet.start();
            this.f46253x = animatorSet;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        if (this.f46231b == null) {
            return;
        }
        Animator animator = this.f46253x;
        if (animator == null || !animator.isRunning()) {
            Animator animator2 = this.f46252w;
            if (animator2 != null && animator2.isRunning()) {
                this.f46252w.cancel();
                this.f46252w = null;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(ObjectAnimator.ofFloat(this.f46231b, "translationY", ar.e(32.0f)));
            linkedList.add(ObjectAnimator.ofFloat(this.f46231b, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f));
            if (this.f46248s.getVisibility() == 0) {
                linkedList.add(ObjectAnimator.ofFloat(this.f46248s, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f));
            }
            View view = this.f46250u;
            if (view != null) {
                linkedList.add(ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f));
            }
            TextView textView = this.f46251v;
            if (textView != null) {
                linkedList.add(ObjectAnimator.ofFloat(textView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f));
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.setInterpolator(T());
            animatorSet.addListener(new d());
            animatorSet.playTogether(linkedList);
            animatorSet.start();
            this.f46253x = animatorSet;
        }
    }

    private void R() {
        if (this.f46243n == null) {
            this.f46243n = new AlarmTask();
        }
        this.f46243n.cancelAlarm();
        this.f46243n.setAlarmListener(this.J);
        this.f46243n.setTriggerTime(5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TimeInterpolator T() {
        return new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f);
    }

    private void W() {
        if (this.f46231b == null) {
            return;
        }
        Animator animator = this.f46252w;
        if (animator == null || !animator.isRunning()) {
            Animator animator2 = this.f46253x;
            if (animator2 != null && animator2.isRunning()) {
                this.f46253x.cancel();
                this.f46253x = null;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(ObjectAnimator.ofFloat(this.f46231b, "translationY", ar.e(32.0f), 0.0f));
            linkedList.add(ObjectAnimator.ofFloat(this.f46231b, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f));
            View view = this.f46250u;
            if (view != null) {
                linkedList.add(ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f));
            }
            TextView textView = this.f46251v;
            if (textView != null) {
                linkedList.add(ObjectAnimator.ofFloat(textView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f));
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.setInterpolator(new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f));
            animatorSet.playTogether(linkedList);
            animatorSet.start();
            this.f46252w = animatorSet;
        }
    }

    private void X() {
        if (this.f46231b == null) {
            return;
        }
        Animator animator = this.f46252w;
        if (animator == null || !animator.isRunning()) {
            Animator animator2 = this.f46253x;
            if (animator2 != null && animator2.isRunning()) {
                this.f46253x.cancel();
                this.f46253x = null;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(ObjectAnimator.ofFloat(this.f46231b, "translationY", ar.e(32.0f), 0.0f));
            linkedList.add(ObjectAnimator.ofFloat(this.f46231b, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f));
            View view = this.f46250u;
            if (view != null) {
                linkedList.add(ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f));
            }
            TextView textView = this.f46251v;
            if (textView != null) {
                linkedList.add(ObjectAnimator.ofFloat(textView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f));
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(200L);
            animatorSet.setInterpolator(T());
            animatorSet.playTogether(linkedList);
            animatorSet.start();
            this.f46252w = animatorSet;
        }
    }

    private void Y() {
        this.f46245p.clear();
        this.f46250u = null;
        this.f46251v = null;
        ValueAnimator valueAnimator = this.f46254y;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        Iterator<i> it = this.f46246q.iterator();
        while (it.hasNext()) {
            it.next().f46271c.i();
        }
        this.f46246q.clear();
        this.f46244o.recycleAllAnimImg();
        this.f46247r.clear();
        StickerBubbleAnimationView stickerBubbleAnimationView = this.f46248s;
        if (stickerBubbleAnimationView != null) {
            stickerBubbleAnimationView.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        this.f46248s.setVisibility(8);
        this.f46249t = 0;
    }

    private void a0(int i3) {
        Context context;
        WeakReference<Context> weakReference = this.f46230a;
        if (weakReference == null || (context = weakReference.get()) == null) {
            return;
        }
        this.f46232c = LayoutInflater.from(context).inflate(i3, (ViewGroup) null);
    }

    private void b0() {
        View view = this.f46236g;
        if (view instanceof NormalAbsFeedView) {
            ((NormalAbsFeedView) view).setFeedViewPauseListener(new f());
        }
        WeakReference<Context> weakReference = this.f46230a;
        if (weakReference == null) {
            return;
        }
        weakReference.get();
    }

    public void enableTouchDelegate() {
        setTouchDelegate(this.f46234e);
    }

    public ViewGroup getRootView() {
        return this.f46231b;
    }

    public boolean hasFirstFrameLoaded() {
        for (ZipLoadBitmapGenerator zipLoadBitmapGenerator : this.f46247r) {
            if (!zipLoadBitmapGenerator.isDownload()) {
                return false;
            }
            List<String> bitmapIdList = zipLoadBitmapGenerator.getBitmapIdList();
            if (bitmapIdList != null && !bitmapIdList.isEmpty()) {
                zipLoadBitmapGenerator.preLoadImg();
            } else {
                zipLoadBitmapGenerator.reLoad();
                return false;
            }
        }
        return true;
    }

    public boolean hasInitialized() {
        return this.f46242m;
    }

    public void retryShowPolymorphicPanel(final SuperLikeView superLikeView, final boolean z16) {
        QzoneHandlerThreadFactory.getMainHandler().postDelayed(new Runnable() { // from class: com.qzone.component.PolymorphicLikeWindow.8
            @Override // java.lang.Runnable
            public void run() {
                if (PolymorphicLikeWindow.this.f46240k < 4 && !PolymorphicLikeWindow.this.hasFirstFrameLoaded()) {
                    PolymorphicLikeWindow.this.f46240k++;
                    PolymorphicLikeWindow.this.retryShowPolymorphicPanel(superLikeView, z16);
                    w5.b.b("PolymorphicLikeWindow", 1, "[polyPraise].retryShowPolymorphicPanel retry times: " + PolymorphicLikeWindow.this.f46240k);
                    return;
                }
                if (PolymorphicLikeWindow.this.hasFirstFrameLoaded()) {
                    PolymorphicLikeWindow.this.showPolymorphicPanel(superLikeView, z16);
                } else {
                    ToastUtil.s(PolymorphicLikeWindow.K, 3);
                    w5.b.b("PolymorphicLikeWindow", 1, "[polyPraise].retryShowPolymorphicPanel failed!");
                }
            }
        }, 100L);
    }

    public void setFeedData(int i3, BusinessFeedData businessFeedData) {
        this.E = i3;
        this.D = businessFeedData;
        if (businessFeedData != null) {
            this.C = businessFeedData.getUser().uin;
        }
    }

    public void setIsFeed(boolean z16) {
        this.B = z16;
    }

    public void setOnItemClickListener(OnItemSelectListener onItemSelectListener) {
        this.f46238i = onItemSelectListener;
    }

    public void setPolymorphicLikeData(boolean z16, PolymorphicPraiseData polymorphicPraiseData) {
        ArrayList<PolymorphicPraiseEmotionData> arrayList;
        if (!this.f46244o.isGlobalPokeItemDataEmpty()) {
            polymorphicPraiseData = this.f46244o.getGlobalPokeData();
        }
        if (polymorphicPraiseData == null || (arrayList = polymorphicPraiseData.emotionDatas) == null || arrayList.size() == 0 || this.f46230a == null) {
            return;
        }
        Y();
        this.f46241l = z16;
        Context context = this.f46230a.get();
        if (context != null) {
            Iterator<PolymorphicPraiseEmotionData> it = polymorphicPraiseData.emotionDatas.iterator();
            while (it.hasNext()) {
                O(context, it.next());
                if (this.f46245p.size() >= 5) {
                    break;
                }
            }
        }
        this.f46234e.requestLayout();
        this.f46234e.setItemClickListener(new c());
        b0();
    }

    public void setTouchDelegate(OnTouchEventDelegateListener onTouchEventDelegateListener) {
        KeyEvent.Callback callback = this.f46233d;
        if (callback instanceof TouchEventDelegator) {
            ((TouchEventDelegator) callback).setTouchEventDelegateListener(onTouchEventDelegateListener);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(View view, int i3, int i16, int i17) {
        Context context;
        super.showAtLocation(view, i3, i16, i17);
        this.f46244o.report(this.B, 1, 0, 0, this.C);
        if (!this.B || (context = this.f46230a.get()) == null) {
            return;
        }
        this.f46244o.recordGuideAnimShow(context, true);
    }

    public void showPolymorphicPanel(View view, TextView textView, View view2, int i3, int i16, int i17) {
        if (view2 == null) {
            QZLog.w("PolymorphicLikeWindow", "[showPolymorphicPanel] anchor view is null");
            return;
        }
        for (int i18 = 0; i18 < this.f46247r.size(); i18++) {
            try {
                ZipLoadBitmapGenerator zipLoadBitmapGenerator = this.f46247r.get(i18);
                i iVar = this.f46246q.get(i18);
                iVar.f46271c.setAnimImage(zipLoadBitmapGenerator.getBitmapIdList(), zipLoadBitmapGenerator, 25);
                iVar.f46271c.f(true);
            } catch (Exception e16) {
                QZLog.w("PolymorphicLikeWindow", "[showPolymorphicPanel]", e16);
                return;
            }
        }
        this.f46250u = view;
        this.f46251v = textView;
        if (textView != null) {
            textView.setText(L);
            this.f46251v.setVisibility(0);
        }
        showAtLocation(view2, i3, i16, i17);
        update();
        X();
        LpReportInfo_pf00064.allReport(89, 1);
    }

    /* loaded from: classes39.dex */
    class c implements PolymorphicLikeCellLayout.a {
        c() {
        }

        private void g(int i3) {
            if (PolymorphicLikeWindow.this.f46254y != null) {
                PolymorphicLikeWindow.this.f46254y.cancel();
            }
            PolymorphicLikeWindow.this.f46254y = ValueAnimator.ofFloat(0.0f, 1.0f);
            PolymorphicLikeWindow.this.f46254y.setDuration(200L);
            PolymorphicLikeWindow.this.f46254y.setInterpolator(PolymorphicLikeWindow.this.T());
            PolymorphicLikeWindow.this.f46254y.addUpdateListener(new h(i3));
            PolymorphicLikeWindow.this.f46254y.start();
        }

        @Override // com.qzone.component.PolymorphicLikeCellLayout.a
        public void a() {
            if (PolymorphicLikeWindow.this.f46237h.getVisibility() == 0) {
                PolymorphicLikeWindow.this.f46237h.setVisibility(4);
            }
        }

        @Override // com.qzone.component.PolymorphicLikeCellLayout.a
        public void b() {
            PolymorphicLikeWindow.this.A = true;
            if (PolymorphicLikeWindow.this.f46251v != null) {
                PolymorphicLikeWindow.this.f46251v.setText(PolymorphicLikeWindow.M);
            }
        }

        @Override // com.qzone.component.PolymorphicLikeCellLayout.a
        public void c(View view, int i3, boolean z16) {
            Log.i("PolymorphicLikeWindow", "onItemClick: " + i3);
            if (i3 < 0 || PolymorphicLikeWindow.this.f46246q.isEmpty()) {
                return;
            }
            PolymorphicLikeWindow polymorphicLikeWindow = PolymorphicLikeWindow.this;
            polymorphicLikeWindow.addItem(i3, ((i) polymorphicLikeWindow.f46246q.get(i3)).f46271c, !z16);
            if (z16) {
                PolymorphicPraiseEmotionData polymorphicPraiseEmotionData = (PolymorphicPraiseEmotionData) PolymorphicLikeWindow.this.f46245p.get(i3);
                if (PolymorphicLikeWindow.this.B) {
                    PolymorphicLikeWindow.this.G = i3;
                    PolymorphicLikeWindow.this.H = 1;
                    PolymorphicLikeWindow.this.I = polymorphicPraiseEmotionData;
                } else if (PolymorphicLikeWindow.this.f46238i != null) {
                    PolymorphicLikeWindow.this.f46238i.onSelect(i3, 1, polymorphicPraiseEmotionData);
                }
                if (PolymorphicLikeWindow.this.A) {
                    PolymorphicLikeWindow.this.f46244o.report(PolymorphicLikeWindow.this.B, 3, polymorphicPraiseEmotionData.iItemId, 1, PolymorphicLikeWindow.this.C);
                    if (PolymorphicLikeWindow.this.D != null) {
                        PolymorphicLikeWindow.this.F.e(215, 1, PolymorphicLikeWindow.this.E, PolymorphicLikeWindow.this.D);
                        return;
                    }
                    return;
                }
                PolymorphicLikeWindow.this.f46244o.report(PolymorphicLikeWindow.this.B, 2, polymorphicPraiseEmotionData.iItemId, 1, PolymorphicLikeWindow.this.C);
                if (PolymorphicLikeWindow.this.D != null) {
                    PolymorphicLikeWindow.this.F.e(215, 36, PolymorphicLikeWindow.this.E, PolymorphicLikeWindow.this.D);
                }
            }
        }

        @Override // com.qzone.component.PolymorphicLikeCellLayout.a
        public void d() {
            String l3 = PolymorphicLikeWindow.this.f46248s.l();
            int k3 = PolymorphicLikeWindow.this.f46248s.k();
            PolymorphicLikeWindow.this.f46248s.m();
            PolymorphicLikeWindow.this.f46248s.o();
            if (l3 != null) {
                for (int i3 = 0; i3 < PolymorphicLikeWindow.this.f46245p.size(); i3++) {
                    PolymorphicPraiseEmotionData polymorphicPraiseEmotionData = (PolymorphicPraiseEmotionData) PolymorphicLikeWindow.this.f46245p.get(i3);
                    if (polymorphicPraiseEmotionData.strPraiseZip.equals(l3)) {
                        int min = Math.min(1000, k3);
                        PolymorphicLikeWindow.this.f46244o.report(PolymorphicLikeWindow.this.B, 3, polymorphicPraiseEmotionData.iItemId, min, PolymorphicLikeWindow.this.C);
                        if (PolymorphicLikeWindow.this.D != null) {
                            PolymorphicLikeWindow.this.F.e(215, 1, PolymorphicLikeWindow.this.E, PolymorphicLikeWindow.this.D);
                        }
                        if (PolymorphicLikeWindow.this.B) {
                            PolymorphicLikeWindow.this.G = i3;
                            PolymorphicLikeWindow.this.H = min;
                            PolymorphicLikeWindow.this.I = polymorphicPraiseEmotionData;
                            return;
                        } else {
                            if (PolymorphicLikeWindow.this.f46238i != null) {
                                PolymorphicLikeWindow.this.f46238i.onSelect(i3, min, polymorphicPraiseEmotionData);
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }

        @Override // com.qzone.component.PolymorphicLikeCellLayout.a
        public void e() {
            if (PolymorphicLikeWindow.this.f46239j == -1 || PolymorphicLikeWindow.this.f46246q.isEmpty()) {
                return;
            }
            ((i) PolymorphicLikeWindow.this.f46246q.get(PolymorphicLikeWindow.this.f46239j)).f46270b.setVisibility(8);
            PolymorphicLikeWindow.this.f46239j = -1;
            g(PolymorphicLikeWindow.this.f46239j);
            if (PolymorphicLikeWindow.this.A || PolymorphicLikeWindow.this.f46251v == null) {
                return;
            }
            PolymorphicLikeWindow.this.f46251v.setText(PolymorphicLikeWindow.N);
        }

        @Override // com.qzone.component.PolymorphicLikeCellLayout.a
        public void f(int i3) {
            if (i3 < 0 || PolymorphicLikeWindow.this.f46239j == i3 || PolymorphicLikeWindow.this.f46246q.isEmpty()) {
                return;
            }
            if (PolymorphicLikeWindow.this.f46239j != -1) {
                ((i) PolymorphicLikeWindow.this.f46246q.get(PolymorphicLikeWindow.this.f46239j)).f46270b.setVisibility(8);
            }
            ((i) PolymorphicLikeWindow.this.f46246q.get(i3)).f46270b.setVisibility(0);
            PolymorphicLikeWindow.this.f46239j = i3;
            g(PolymorphicLikeWindow.this.f46239j);
            if (!PolymorphicLikeWindow.this.A && PolymorphicLikeWindow.this.f46251v != null) {
                PolymorphicLikeWindow.this.f46251v.setText(PolymorphicLikeWindow.L);
            }
            if (PolymorphicLikeWindow.this.f46243n != null) {
                PolymorphicLikeWindow.this.f46243n.cancelAlarm();
            }
        }
    }

    private int S() {
        int[] iArr = new int[2];
        this.f46248s.getLocationInWindow(iArr);
        return iArr[1];
    }

    public void addItem(int i3, View view, boolean z16) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Point point = new Point((view.getWidth() / 2) + iArr[0], iArr[1] - S());
        String str = this.f46245p.get(i3).strPraiseZip;
        int i16 = this.f46249t;
        this.f46249t = i16 + 1;
        this.f46248s.c(com.qzone.component.f.a(point, str, i16), z16);
        if (this.f46248s.getVisibility() == 8) {
            this.f46248s.setVisibility(0);
        }
        if (z16 && this.f46255z) {
            this.f46248s.p((point.y + view.getHeight()) - O);
        } else {
            this.f46248s.m();
        }
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        OnItemSelectListener onItemSelectListener;
        w5.b.i("PolymorphicLikeWindow", 1, "[polyPraise] dismiss polymorphic window!");
        this.f46244o.report(this.B, 4, 0, 0, this.C);
        View view = this.f46250u;
        if (view != null) {
            view.setAlpha(1.0f);
        }
        TextView textView = this.f46251v;
        if (textView != null) {
            textView.setVisibility(8);
        }
        PolymorphicPraiseEmotionData polymorphicPraiseEmotionData = this.I;
        if (polymorphicPraiseEmotionData != null && (onItemSelectListener = this.f46238i) != null) {
            onItemSelectListener.onSelect(this.G, this.H, polymorphicPraiseEmotionData);
            this.I = null;
        }
        try {
            this.f46242m = false;
            this.f46240k = 0;
            this.f46248s.q();
            Y();
            QzoneHandlerThreadFactory.getMainHandler().postDelayed(new Runnable() { // from class: com.qzone.component.PolymorphicLikeWindow.6
                @Override // java.lang.Runnable
                public void run() {
                    PolymorphicLikeWindow.this.setTouchDelegate(null);
                    PolymorphicLikeWindow.this.f46233d = null;
                    if (PolymorphicLikeWindow.this.f46236g instanceof NormalAbsFeedView) {
                        ((FeedView) PolymorphicLikeWindow.this.f46236g).setFeedViewPauseListener(null);
                        PolymorphicLikeWindow.this.f46236g = null;
                    }
                }
            }, 200L);
            super.dismiss();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    static {
        int e16 = ar.e(48.0f);
        O = e16;
        int e17 = ar.e(72.0f);
        P = e17;
        Q = ((e16 * 5) - e17) / 4;
        R = ar.e(299.0f);
        S = ar.e(120.0f);
    }

    private void U() {
        String str;
        a0(R.layout.buz);
        setContentView(this.f46232c);
        setWidth(R);
        setHeight(S);
        setBackgroundDrawable(new ColorDrawable(0));
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
        setTouchInterceptor(new b());
        this.f46234e = (PolymorphicLikeCellLayout) this.f46232c.findViewById(R.id.hhy);
        this.f46231b = (ViewGroup) this.f46232c.findViewById(R.id.hhz);
        this.f46235f = (AsyncImageView) this.f46232c.findViewById(R.id.f166708m45);
        if (QQTheme.isNowThemeIsNightForQzone()) {
            str = "https://qzonestyle.gtimg.cn/qzone/qzact/act/external/qzone-photo/qq_qzone_android/feed_poly_like_bg_nightmode.png";
        } else {
            str = "https://qzonestyle.gtimg.cn/aoi/sola/20190822213654_8vUtct0VlQ.png";
        }
        this.f46235f.setAsyncImage(str);
        this.f46237h = (AsyncImageView) this.f46232c.findViewById(R.id.m46);
        if (this.f46244o.shouldPopWindowShowGuideImg(this.f46230a.get())) {
            this.f46237h.setAsyncImage("https://qzonestyle.gtimg.cn/aoi/sola/20190822170858_27MiMHYyi1.png");
            this.f46237h.setVisibility(0);
        } else {
            this.f46237h.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean V(View view, float f16, float f17) {
        return f16 > 0.0f && f16 < ((float) view.getWidth()) && f17 > 0.0f && f17 < ((float) view.getHeight());
    }

    public void showPolymorphicPanel(SuperLikeView superLikeView, boolean z16) {
        int height;
        for (int i3 = 0; i3 < this.f46247r.size(); i3++) {
            ZipLoadBitmapGenerator zipLoadBitmapGenerator = this.f46247r.get(i3);
            i iVar = this.f46246q.get(i3);
            iVar.f46271c.setAnimImage(zipLoadBitmapGenerator.getBitmapIdList(), zipLoadBitmapGenerator, 25);
            iVar.f46271c.f(true);
        }
        ViewGroup viewGroup = null;
        while (true) {
            ViewParent parent = viewGroup == null ? superLikeView.getParent() : viewGroup.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
                if (viewGroup.getId() == R.id.ffa) {
                    this.f46250u = viewGroup.findViewById(R.id.ff5);
                    this.f46251v = (TextView) viewGroup.findViewById(R.id.lyf);
                    break;
                }
            } else {
                this.f46250u = null;
                this.f46251v = null;
                break;
            }
        }
        TextView textView = this.f46251v;
        if (textView != null) {
            textView.setText(L);
            this.f46251v.setVisibility(0);
        }
        try {
            if (!com.qzone.adapter.feedcomponent.i.H().g1()) {
                Y();
                this.f46242m = false;
                w5.b.j("PolymorphicLikeWindow", 2, "[polyPraise] showPolymorphicPanel, listView is Scrolling!");
                return;
            }
            int[] iArr = new int[2];
            superLikeView.getHeight();
            View view = this.f46250u;
            if (view == null) {
                superLikeView.getLocationInWindow(iArr);
                height = (iArr[1] - S) - ar.e(10.0f);
            } else {
                view.getLocationInWindow(iArr);
                int i16 = iArr[1];
                int i17 = i16 - S;
                height = i17 < 0 ? i16 + this.f46250u.getHeight() : i17;
            }
            if (this.f46241l) {
                showAtLocation(superLikeView, 0, ar.l() - R, height);
                update();
                X();
            } else {
                showAtLocation(superLikeView, 0, ar.l() - R, height);
                update();
                W();
            }
            if (z16) {
                R();
                LpReportInfo_pf00064.allReport(89, 2);
            } else {
                LpReportInfo_pf00064.allReport(89, 1);
            }
            w5.b.i("PolymorphicLikeWindow", 1, "[polyPraise].showPolymorphicPanel, show polymorphic animation!");
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
