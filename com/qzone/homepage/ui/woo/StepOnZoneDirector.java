package com.qzone.homepage.ui.woo;

import NS_MOBILE_FEEDS.cnst.COMM_MALL_INSERT_FEED;
import NS_MOBILE_MATERIAL.UgcDecoQualReq;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Observable;
import com.qzone.common.protocol.request.QZoneLikeRequest;
import com.qzone.component.StrokeTextView;
import com.qzone.homepage.business.model.QzoneCustomTrackData;
import com.qzone.proxy.feedcomponent.model.Point;
import com.qzone.publish.outbox.Outbox;
import com.qzone.util.ar;
import com.qzone.util.k;
import com.qzone.util.l;
import com.qzone.util.m;
import com.qzone.widget.AvatarImageView;
import com.qzone.widget.FrameAnimView;
import com.qzone.widget.aa;
import com.qzone.widget.util.PreLoadBitmapGenerator;
import com.qzone.widget.util.c;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import e7.b;
import ho.i;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class StepOnZoneDirector extends aa implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, IQZoneServiceListener {

    /* renamed from: n0, reason: collision with root package name */
    private static final int f47795n0 = ar.d(385.0f);

    /* renamed from: o0, reason: collision with root package name */
    private static final int f47796o0 = ar.d(302.0f);
    private final View C;
    private final ImageView D;
    private final View E;
    private final ImageView F;
    private final View G;
    private final AvatarImageView H;
    private final TextView I;
    private final com.qzone.homepage.ui.woo.a J;
    private final c K;
    private final c L;
    private final c M;
    private final c N;
    private final Map<String, c> P;
    private final ValueAnimator Q;
    private final ObjectAnimator R;
    private final ValueAnimator S;
    private final f T;
    private boolean U;
    private boolean V;
    private e7.b W;
    private int X;
    private long Y;
    private final WeakReference<Activity> Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f47797a0;

    /* renamed from: b0, reason: collision with root package name */
    private final Handler f47798b0;

    /* renamed from: c0, reason: collision with root package name */
    private final PreLoadBitmapGenerator f47799c0;

    /* renamed from: d, reason: collision with root package name */
    private final ScaleShadowMainBtnDirector f47800d;

    /* renamed from: d0, reason: collision with root package name */
    private final Observable f47801d0;

    /* renamed from: e, reason: collision with root package name */
    private final com.qzone.homepage.ui.woo.b f47802e;

    /* renamed from: e0, reason: collision with root package name */
    private long f47803e0;

    /* renamed from: f, reason: collision with root package name */
    private final com.qzone.homepage.ui.woo.b f47804f;

    /* renamed from: f0, reason: collision with root package name */
    private final HitAnimHolder f47805f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f47806g0;

    /* renamed from: h, reason: collision with root package name */
    private final com.qzone.homepage.ui.woo.b f47807h;

    /* renamed from: h0, reason: collision with root package name */
    private ArrayList<d> f47808h0;

    /* renamed from: i, reason: collision with root package name */
    private final View f47809i;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f47810i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f47811j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f47812k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f47813l0;

    /* renamed from: m, reason: collision with root package name */
    private final ImageView f47814m;

    /* renamed from: m0, reason: collision with root package name */
    private int f47815m0;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            StepOnZoneDirector.this.G.setVisibility(8);
            StepOnZoneDirector.this.J.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private int C;
        private float D;
        private float E;
        private boolean F;
        private boolean G;
        private boolean H = false;
        private boolean I = false;
        private long J;

        /* renamed from: d, reason: collision with root package name */
        private e7.a f47842d;

        /* renamed from: e, reason: collision with root package name */
        private ValueAnimator f47843e;

        /* renamed from: f, reason: collision with root package name */
        private View f47844f;

        /* renamed from: h, reason: collision with root package name */
        private View f47845h;

        /* renamed from: i, reason: collision with root package name */
        private ImageView f47846i;

        /* renamed from: m, reason: collision with root package name */
        private int f47847m;

        d(e7.a aVar, ValueAnimator valueAnimator, View view, View view2) {
            this.f47842d = aVar;
            this.f47843e = valueAnimator;
            this.f47844f = view;
            this.f47845h = view2;
            if (StepOnZoneDirector.this.f47806g0) {
                this.f47846i = StepOnZoneDirector.this.f47814m;
                ((RelativeLayout) ((aa) StepOnZoneDirector.this).rootView).removeView(this.f47846i);
                StepOnZoneDirector.this.f47806g0 = false;
                return;
            }
            ImageView imageView = new ImageView(StepOnZoneDirector.this.getContext());
            this.f47846i = imageView;
            imageView.setScaleType(StepOnZoneDirector.this.f47814m.getScaleType());
            this.f47846i.setPivotX(StepOnZoneDirector.this.f47814m.getPivotX());
            this.f47846i.setPivotY(StepOnZoneDirector.this.f47814m.getPivotY());
            this.f47846i.setVisibility(StepOnZoneDirector.this.f47814m.getVisibility());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(StepOnZoneDirector.this.f47814m.getLayoutParams());
            layoutParams.addRule(11);
            layoutParams.addRule(12);
            layoutParams.leftMargin = ar.e(-130.0f);
            layoutParams.rightMargin = ar.e(-80.0f);
            layoutParams.bottomMargin = ar.e(95.0f);
            this.f47846i.setLayoutParams(layoutParams);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g() {
            this.G = !StepOnZoneDirector.this.V;
            ((RelativeLayout) ((aa) StepOnZoneDirector.this).rootView).addView(this.f47846i);
            StepOnZoneDirector.this.f47805f0.e();
            this.f47843e.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void h() {
            if (this.f47843e.isRunning()) {
                this.f47843e.cancel();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            Log.i("StepOnZoneDirector", "onAnimationEnd: " + this.G);
            this.f47846i.setVisibility(8);
            ((RelativeLayout) ((aa) StepOnZoneDirector.this).rootView).removeView(this.f47846i);
            if (!this.H) {
                StepOnZoneDirector.this.f47808h0.remove(this);
            }
            if (this.G) {
                return;
            }
            StepOnZoneDirector.this.m0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            View view;
            String str;
            super.onAnimationStart(animator);
            Log.i("StepOnZoneDirector", "onAnimationStart: ");
            this.J = System.nanoTime();
            if (StepOnZoneDirector.this.V) {
                view = this.f47845h;
            } else {
                view = this.f47844f;
            }
            int[] f16 = f(view);
            this.f47847m = f16[0] - ar.d(153.0f);
            this.C = f16[1] - ar.d(22.0f);
            this.f47846i.setVisibility(0);
            ImageView imageView = this.f47846i;
            e7.a aVar = this.f47842d;
            if (aVar == null) {
                str = "";
            } else {
                str = aVar.f395800e;
            }
            imageView.setImageBitmap(m.c(str));
            this.f47846i.setScaleX(0.0f);
            this.f47846i.setScaleY(0.0f);
            this.f47846i.setRotation(-10.0f);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f47846i.getLayoutParams();
            marginLayoutParams.setMargins(-StepOnZoneDirector.f47796o0, -StepOnZoneDirector.f47795n0, this.f47847m, this.C);
            this.f47846i.setLayoutParams(marginLayoutParams);
            float height = (((aa) StepOnZoneDirector.this).rootView.getHeight() - this.C) / 3.0f;
            this.D = height;
            this.E = height / 5.7f;
            this.F = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float f16;
            float f17;
            if (this.f47842d == null) {
                QZLog.e("StepOnZoneDirector", "onAnimationUpdate: anim model is null");
                return;
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue < 1.0f) {
                this.f47846i.setScaleX(floatValue);
                this.f47846i.setScaleY(floatValue);
                if (floatValue >= 0.3f) {
                    if (floatValue < 0.4f) {
                        f17 = 0.0f;
                    } else if (floatValue < 0.7f) {
                        f17 = ((floatValue - 0.4f) / 0.3f) * (-10.0f);
                    } else {
                        f16 = (1.0f - floatValue) / 0.3f;
                    }
                    this.f47846i.setRotation(f17);
                    return;
                }
                f16 = 1.0f - (floatValue / 0.3f);
                f17 = f16 * (-10.0f);
                this.f47846i.setRotation(f17);
                return;
            }
            List<String> list = this.f47842d.f395798c;
            if (floatValue < 2.0f) {
                long nanoTime = System.nanoTime();
                if (nanoTime - this.J > 50000000) {
                    this.J = nanoTime;
                    int size = (int) ((this.f47842d.f395798c.size() - 1) * (floatValue - 1.0f));
                    Bitmap h16 = StepOnZoneDirector.this.f47799c0.h(list.get(size), size <= list.size() + (-2) ? list.get(size + 1) : null, true);
                    if (h16 != null) {
                        this.f47846i.setImageBitmap(h16);
                    }
                    if (this.G) {
                        if (StepOnZoneDirector.this.f47805f0.l(size)) {
                            StepOnZoneDirector.this.n0();
                            this.I = true;
                        }
                        if (!this.I && StepOnZoneDirector.this.f47805f0.f47825j.size() > 0 && size > ((Integer) StepOnZoneDirector.this.f47805f0.f47825j.get(0)).intValue()) {
                            HitAnimHolder hitAnimHolder = StepOnZoneDirector.this.f47805f0;
                            StepOnZoneDirector stepOnZoneDirector = StepOnZoneDirector.this;
                            long j3 = stepOnZoneDirector.f47803e0 + 1;
                            stepOnZoneDirector.f47803e0 = j3;
                            hitAnimHolder.q(j3);
                            StepOnZoneDirector.this.n0();
                            this.I = true;
                            QZLog.i("StepOnZoneDirector", "heart combo not success, the next heart is helped to generate!");
                        }
                    }
                }
            } else if (!this.F) {
                this.F = true;
                Bitmap h17 = StepOnZoneDirector.this.f47799c0.h(list.get(list.size() - 1), null, false);
                if (h17 != null) {
                    this.f47846i.setImageBitmap(h17);
                }
            }
            float pow = (float) (Math.pow((floatValue - 1.0f) / 3.0f, 3.1d) * 3.0d);
            int i3 = (int) (this.D * pow);
            int i16 = (int) (((this.E * pow) * pow) / 2.0f);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f47846i.getLayoutParams();
            marginLayoutParams.rightMargin = this.f47847m + i16;
            marginLayoutParams.bottomMargin = this.C + i3;
            this.f47846i.setLayoutParams(marginLayoutParams);
        }

        private int[] f(View view) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr);
            ((aa) StepOnZoneDirector.this).rootView.getLocationInWindow(iArr2);
            return new int[]{((iArr2[0] + ((aa) StepOnZoneDirector.this).rootView.getWidth()) - iArr[0]) - view.getWidth(), (iArr2[1] + ((aa) StepOnZoneDirector.this).rootView.getHeight()) - iArr[1]};
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class f extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        private Bitmap f47850d;

        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            StepOnZoneDirector.this.E.setVisibility(8);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            StepOnZoneDirector.this.F.setImageBitmap(this.f47850d);
            StepOnZoneDirector.this.F.setScaleY(1.0f);
            StepOnZoneDirector.this.F.setScaleX(1.0f);
            StepOnZoneDirector.this.E.setVisibility(0);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float sin = (float) (1.0d - (Math.sin(((Float) valueAnimator.getAnimatedValue()).floatValue()) * 0.07d));
            StepOnZoneDirector.this.F.setScaleY(sin);
            StepOnZoneDirector.this.F.setScaleX(sin);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0() {
        if (this.f47797a0) {
            boolean a16 = k.a("woo_need_guide");
            this.f47797a0 = a16;
            if (a16) {
                Activity activity = this.Z.get();
                if (activity != null && !activity.isFinishing()) {
                    QQCustomDialog qQCustomDialog = new QQCustomDialog(activity, R.style.qZoneInputDialog);
                    qQCustomDialog.setContentView(R.layout.f167856jn);
                    qQCustomDialog.setTitle(l.a(R.string.tpw));
                    qQCustomDialog.setMessage(l.a(R.string.tpv));
                    qQCustomDialog.setNegativeButton((String) null, (DialogInterface.OnClickListener) null);
                    qQCustomDialog.setPositiveButton(l.a(R.string.tpy), new b());
                    qQCustomDialog.setCanceledOnTouchOutside(false);
                    qQCustomDialog.show();
                }
                return true;
            }
        }
        return false;
    }

    private void B0() {
        this.f47800d.setVisibility(8);
        this.f47802e.setVisibility(8);
        this.f47804f.setVisibility(8);
        this.f47807h.setVisibility(8);
        this.C.setVisibility(8);
        this.R.cancel();
        this.G.setVisibility(0);
        this.G.setAlpha(1.0f);
        this.H.j(this.W.f395812a);
        this.I.setText(this.W.f395813b);
        this.J.c(Y());
        this.J.e();
        this.X = -1;
        p0(4, 1);
        this.f47798b0.postDelayed(new Runnable() { // from class: com.qzone.homepage.ui.woo.StepOnZoneDirector.2
            @Override // java.lang.Runnable
            public void run() {
                StepOnZoneDirector.this.m0();
            }
        }, 200L);
    }

    private void D0() {
        ArrayList<d> arrayList = this.f47808h0;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (int i3 = 0; i3 < this.f47808h0.size(); i3++) {
            d dVar = this.f47808h0.get(i3);
            if (dVar != null) {
                dVar.H = true;
                dVar.h();
            }
        }
        this.f47808h0.clear();
    }

    private void F0() {
        int i3 = this.f47815m0;
        if (i3 == 1) {
            this.L.x();
            return;
        }
        if (i3 == 2) {
            this.M.x();
            D0();
        } else if (i3 == 3) {
            this.N.x();
        } else {
            if (i3 != 4) {
                return;
            }
            this.K.x();
        }
    }

    private String Y() {
        if (this.W.f395814c.isEmpty()) {
            return "";
        }
        HashSet hashSet = new HashSet();
        StringBuilder sb5 = new StringBuilder(l.a(R.string.tpx));
        for (b.a aVar : this.W.f395814c) {
            if (aVar != null && !TextUtils.isEmpty(aVar.f395815a) && !hashSet.contains(aVar.f395815a)) {
                hashSet.add(aVar.f395815a);
                c cVar = this.P.get(aVar.f395815a);
                if (cVar != null) {
                    sb5.append(cVar.f47840i.f395807l);
                    sb5.append("\u3001");
                }
            }
        }
        return sb5.substring(0, sb5.length() - 1);
    }

    private void a0() {
        C0();
        b0(this.f47815m0);
        this.f47798b0.postDelayed(new Runnable() { // from class: com.qzone.homepage.ui.woo.StepOnZoneDirector.6
            @Override // java.lang.Runnable
            public void run() {
                c cVar;
                int i3 = StepOnZoneDirector.this.f47813l0;
                if (i3 == 1) {
                    cVar = StepOnZoneDirector.this.L;
                    StepOnZoneDirector.this.f47802e.i(true);
                } else if (i3 == 2) {
                    cVar = StepOnZoneDirector.this.M;
                    StepOnZoneDirector.this.f47804f.i(true);
                } else if (i3 != 3) {
                    cVar = i3 != 4 ? null : StepOnZoneDirector.this.N;
                } else {
                    cVar = StepOnZoneDirector.this.N;
                    StepOnZoneDirector.this.f47807h.i(true);
                }
                if (cVar != null) {
                    cVar.u(true);
                }
            }
        }, 50L);
    }

    private void c0() {
        c cVar;
        int i3 = this.f47813l0;
        if (i3 == 1) {
            cVar = this.L;
        } else if (i3 == 2) {
            cVar = this.M;
        } else if (i3 != 3) {
            cVar = i3 != 4 ? null : this.K;
        } else {
            cVar = this.N;
        }
        if (cVar != null) {
            long min = Math.min(999L, this.f47803e0);
            this.f47803e0 = min;
            if (this.f47812k0) {
                min = 1;
            }
            this.f47803e0 = min;
            if (min > 0) {
                cVar.q(!this.f47811j0);
                ScaleShadowMainBtnDirector scaleShadowMainBtnDirector = this.f47800d;
                scaleShadowMainBtnDirector.n(scaleShadowMainBtnDirector.g() + this.f47803e0);
            }
        }
        int i16 = this.f47813l0;
        this.f47810i0 = i16 == 0;
        this.f47815m0 = i16;
        this.f47813l0 = 0;
        this.f47803e0 = 0L;
        this.f47812k0 = false;
    }

    private void d0(MotionEvent motionEvent) {
        if (k0(new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY()))) {
            a0();
        }
    }

    private void e0() {
        int i3 = this.f47813l0;
        if (i3 == 1) {
            this.L.n();
            return;
        }
        if (i3 == 2) {
            this.M.n();
        } else if (i3 == 3) {
            this.N.n();
        } else {
            if (i3 != 4) {
                return;
            }
            this.K.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f0() {
        return this.K.o() || this.L.o() || this.M.o() || this.N.o() || g0();
    }

    private boolean g0() {
        ArrayList<d> arrayList = this.f47808h0;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        Iterator<d> it = this.f47808h0.iterator();
        while (it.hasNext()) {
            if (it.next().f47843e.isRunning()) {
                return true;
            }
        }
        return false;
    }

    private boolean i0(Point point, Rect rect) {
        return rect.contains(point.f50265x, point.f50266y);
    }

    public static boolean j0() {
        return false;
    }

    private boolean k0(Point point) {
        this.f47815m0 = this.f47813l0;
        this.f47811j0 = false;
        if (i0(point, this.f47802e.e())) {
            this.f47813l0 = 1;
        } else if (i0(point, this.f47804f.e())) {
            this.f47813l0 = 2;
        } else if (i0(point, this.f47807h.e())) {
            this.f47813l0 = 3;
        } else {
            this.f47813l0 = 0;
        }
        int i3 = this.f47813l0;
        if (i3 != 0) {
            this.f47811j0 = true;
            this.f47812k0 = true;
        }
        return this.f47815m0 != i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l0() {
        return this.Y == LoginData.getInstance().getUin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        c cVar;
        if (!this.V || this.W == null) {
            return;
        }
        while (this.X < this.W.f395814c.size() - 1) {
            List<b.a> list = this.W.f395814c;
            int i3 = this.X + 1;
            this.X = i3;
            b.a aVar = list.get(i3);
            if (aVar != null && !TextUtils.isEmpty(aVar.f395815a) && (cVar = this.P.get(aVar.f395815a)) != null) {
                if (aVar.f395816b) {
                    cVar.w();
                    return;
                } else {
                    cVar.v();
                    return;
                }
            }
        }
        this.f47798b0.postDelayed(new Runnable() { // from class: com.qzone.homepage.ui.woo.StepOnZoneDirector.3
            @Override // java.lang.Runnable
            public void run() {
                StepOnZoneDirector.this.R.start();
            }
        }, 2500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        if (this.M.f47840i == null || !this.M.C) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 4.0f);
        ofFloat.setDuration(6000L);
        d dVar = new d(this.M.f47840i, ofFloat, this.f47804f.f(), this.G);
        ofFloat.addListener(dVar);
        ofFloat.addUpdateListener(dVar);
        Log.i("StepOnZoneDirector", "new heart create: " + dVar.toString());
        dVar.g();
        this.f47808h0.add(dVar);
    }

    private void r0() {
        if (this.K.f47840i == null) {
            p0(1, 1);
            this.C.setVisibility(8);
            this.f47800d.setVisibility(0);
        } else {
            p0(3, 1);
            this.C.setVisibility(0);
            this.f47800d.setVisibility(8);
            this.D.setImageBitmap(m.c(this.K.f47840i.f395799d));
        }
        this.f47802e.setVisibility(8);
        this.f47804f.setVisibility(8);
        this.f47807h.setVisibility(8);
        this.f47800d.l(1.2f, 255);
        this.f47800d.m(0);
    }

    private void u0(View view, String str) {
        AccessibilityUtil.p(view, str);
    }

    private void y0() {
        this.Q.setDuration(this.f47800d.f() == 0 ? 120L : 100L);
        this.Q.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getAlpha() != 0.0f) {
            if (view == this.H) {
                Activity activity = this.Z.get();
                if (activity != null) {
                    i.z().r(activity, this.W.f395812a);
                }
                p0(4, 2);
            } else {
                this.f47811j0 = false;
                if (view == this.C) {
                    this.f47813l0 = 4;
                    this.K.u(false);
                }
                if (this.f47800d.f() != 2) {
                    if (this.f47800d.isThisRootView(view)) {
                        if (this.f47800d.f() == 1 && this.f47810i0) {
                            y0();
                        }
                        this.f47813l0 = 0;
                    } else if (this.f47802e.isThisRootView(view)) {
                        this.f47813l0 = 1;
                        this.L.u(false);
                    } else if (this.f47804f.isThisRootView(view)) {
                        this.f47813l0 = 2;
                        this.M.u(false);
                    } else if (this.f47807h.isThisRootView(view)) {
                        this.f47813l0 = 3;
                        this.N.u(false);
                    }
                    c0();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        EventCollector.getInstance().onViewLongClickedBefore(view);
        if (view.getAlpha() != 0.0f && this.f47800d.f() != 2) {
            this.f47811j0 = true;
            F0();
            if (view == this.C) {
                this.f47813l0 = 4;
                this.K.u(true);
            }
            if (this.f47802e.isThisRootView(view)) {
                this.f47813l0 = 1;
                this.L.u(true);
            } else if (this.f47804f.isThisRootView(view)) {
                this.f47813l0 = 2;
                this.M.u(true);
            } else if (this.f47807h.isThisRootView(view)) {
                this.f47813l0 = 3;
                this.N.u(true);
            }
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return true;
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask.mType != 61) {
            return;
        }
        QZLog.i("StepOnZoneDirector", "onTaskResponse: " + qZoneTask.succeeded());
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.i("StepOnZoneDirector", "onTouch: " + motionEvent.getAction());
        if (view.getAlpha() == 0.0f) {
            return false;
        }
        if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
            if (motionEvent.getAction() == 0) {
                if (this.f47802e.isThisRootView(view)) {
                    this.L.p();
                } else if (this.f47804f.isThisRootView(view)) {
                    this.M.p();
                } else if (this.f47807h.isThisRootView(view)) {
                    this.N.p();
                } else if (view == this.C) {
                    this.K.p();
                } else if (this.f47800d.isThisRootView(view)) {
                    C0();
                    if (this.f47800d.f() == 0) {
                        y0();
                        p0(1, 2);
                    }
                } else if (view == this.rootView) {
                    if (f0()) {
                        C0();
                        return true;
                    }
                    if (this.Q.isRunning()) {
                        this.Q.cancel();
                    }
                    if (this.f47800d.f() == 1) {
                        y0();
                        return true;
                    }
                }
            } else if (motionEvent.getAction() == 2) {
                if (this.f47800d.f() == 1 && this.f47800d.isThisRootView(view)) {
                    this.rootView.getParent().requestDisallowInterceptTouchEvent(true);
                    this.f47801d0.notify(2, new Object[0]);
                    d0(motionEvent);
                    return true;
                }
            } else if (motionEvent.getAction() == 6) {
                if (this.f47800d.f() == 1) {
                    y0();
                }
                return true;
            }
        } else {
            if (this.f47802e.isThisRootView(view)) {
                this.L.n();
            } else if (this.f47804f.isThisRootView(view)) {
                this.M.n();
            } else if (this.f47807h.isThisRootView(view)) {
                this.N.n();
            } else if (view == this.C) {
                this.K.n();
            } else if (this.f47800d.isThisRootView(view)) {
                e0();
                this.f47801d0.notify(1, new Object[0]);
                if (motionEvent.getAction() == 3 && this.f47813l0 == 0) {
                    y0();
                }
            }
            this.f47805f0.o();
            b0(this.f47813l0);
            c0();
        }
        return false;
    }

    @Override // com.qzone.widget.aa
    public void setAlpha(float f16) {
        this.f47800d.setAlpha(f16);
        this.f47802e.setAlpha(f16);
        this.f47804f.setAlpha(f16);
        this.f47807h.setAlpha(f16);
        this.C.setAlpha(f16);
    }

    public void v0(long j3) {
        this.Y = j3;
    }

    public void x0(long j3) {
        this.f47800d.n(j3);
    }

    public void z0() {
        this.f47798b0.postDelayed(new Runnable() { // from class: com.qzone.homepage.ui.woo.StepOnZoneDirector.5
            @Override // java.lang.Runnable
            public void run() {
                if (StepOnZoneDirector.this.f47800d != null) {
                    StepOnZoneDirector.this.f47800d.o();
                }
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements c.d, c.InterfaceC0506c {
        private boolean C;

        /* renamed from: d, reason: collision with root package name */
        private final FrameAnimView f47836d;

        /* renamed from: e, reason: collision with root package name */
        private final FrameAnimView f47837e;

        /* renamed from: f, reason: collision with root package name */
        private final ImageView f47838f;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f47839h;

        /* renamed from: i, reason: collision with root package name */
        private e7.a f47840i;

        /* renamed from: m, reason: collision with root package name */
        private d f47841m;

        c(int i3, int i16, ImageView imageView, boolean z16) {
            this.f47836d = (FrameAnimView) StepOnZoneDirector.this.findViewById(i3);
            this.f47837e = (FrameAnimView) StepOnZoneDirector.this.findViewById(i16);
            this.f47838f = imageView;
            this.f47839h = z16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n() {
            Log.i("StepOnZoneDirector", "cancelPress: " + this.C);
            this.f47838f.setAlpha(1.0f);
            if (this.C) {
                this.C = false;
                d dVar = this.f47841m;
                if (dVar != null) {
                    dVar.G = false;
                } else {
                    this.f47837e.b();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean o() {
            d dVar;
            return this.f47836d.e() || this.f47837e.e() || ((dVar = this.f47841m) != null && dVar.f47843e.isRunning());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p() {
            Log.i("StepOnZoneDirector", "onPress: ");
            this.f47838f.setAlpha(0.5f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r() {
            x();
            e7.a aVar = this.f47840i;
            if (aVar != null) {
                List<String> list = aVar.f395798c;
                if (list != null && list.size() > 0) {
                    new File(this.f47840i.f395798c.get(0)).getParentFile().deleteOnExit();
                }
                List<String> list2 = this.f47840i.f395797b;
                if (list2 != null && list2.size() > 0) {
                    new File(this.f47840i.f395797b.get(0)).getParentFile().deleteOnExit();
                }
                this.f47840i = null;
            }
            d dVar = this.f47841m;
            if (dVar != null) {
                dVar.G = false;
                this.f47841m.f47843e.cancel();
                this.f47841m = null;
            }
            this.f47837e.setFrameListener(null);
        }

        private void s(FrameAnimView frameAnimView, List<String> list) {
            if (list.isEmpty()) {
                return;
            }
            int[] f16 = m.f(list.get(0));
            if (f16[0] == 0 || f16[1] == 0) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = frameAnimView.getLayoutParams();
            layoutParams.width = ar.d(f16[0] / 2.0f);
            layoutParams.height = ar.d(f16[1] / 2.0f);
            frameAnimView.setLayoutParams(layoutParams);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(e7.a aVar) {
            this.f47840i = aVar;
            if (aVar != null) {
                this.f47838f.setImageBitmap(m.c(aVar.f395799d));
                this.f47836d.setAnimImage(aVar.f395797b, StepOnZoneDirector.this.f47799c0, 20);
                s(this.f47836d, aVar.f395797b);
                if (this.f47840i.f395808m || aVar.f395798c.size() <= 0) {
                    return;
                }
                this.f47837e.setAnimImage(aVar.f395798c, StepOnZoneDirector.this.f47799c0, 20, aVar.f395801f, aVar.f395802g);
                s(this.f47837e, aVar.f395798c);
                this.f47837e.setFrameListener(this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(boolean z16) {
            if (this.f47840i == null || StepOnZoneDirector.this.f0() || StepOnZoneDirector.this.A0()) {
                return;
            }
            this.C = z16;
            if (z16) {
                v();
            } else {
                w();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v() {
            if (this.f47840i != null && StepOnZoneDirector.this.f47809i != null) {
                if (this.f47840i.f395798c.isEmpty()) {
                    QZLog.e("StepOnZoneDirector", "button " + StepOnZoneDirector.this.f47813l0 + "(1 pan 2 heart 3 paint 4 knock) press anim is empty!");
                    w();
                    return;
                }
                e7.a aVar = this.f47840i;
                if (aVar.f395808m) {
                    if (this.f47841m == null) {
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 4.0f);
                        ofFloat.setDuration(6000L);
                        StepOnZoneDirector stepOnZoneDirector = StepOnZoneDirector.this;
                        d dVar = new d(this.f47840i, ofFloat, this.f47838f, stepOnZoneDirector.G);
                        this.f47841m = dVar;
                        ofFloat.addListener(dVar);
                        ofFloat.addUpdateListener(this.f47841m);
                    }
                    this.f47841m.g();
                } else {
                    if (aVar.f395803h.size() > 0) {
                        StepOnZoneDirector.this.T.f47850d = ar.b(StepOnZoneDirector.this.f47809i, StepOnZoneDirector.this.f47809i.getWidth(), StepOnZoneDirector.this.f47809i.getHeight());
                    }
                    this.f47837e.setVisibility(0);
                    this.f47837e.setOnEndListener(this);
                    this.f47837e.f(!StepOnZoneDirector.this.V);
                }
                if (StepOnZoneDirector.this.f47812k0 || ((this.f47837e.getVisibility() != 0 && !this.f47841m.f47843e.isRunning()) || StepOnZoneDirector.this.l0() || StepOnZoneDirector.this.V)) {
                    if (StepOnZoneDirector.this.l0()) {
                        StepOnZoneDirector.this.f47805f0.j(1);
                        return;
                    }
                    return;
                }
                StepOnZoneDirector.this.f47805f0.s(true);
                return;
            }
            QZLog.e("StepOnZoneDirector", "showPressAnim: not init");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w() {
            if (this.f47840i == null) {
                QZLog.e("StepOnZoneDirector", "showTapAnim: not init");
                return;
            }
            this.f47836d.setVisibility(0);
            this.f47836d.setOnEndListener(this);
            this.f47836d.f(false);
            StepOnZoneDirector.this.f47803e0 = 1L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x() {
            Log.i("StepOnZoneDirector", "stopAnim: ");
            this.f47836d.i();
            this.f47837e.i();
            n();
            d dVar = this.f47841m;
            if (dVar != null) {
                dVar.f47843e.cancel();
            }
        }

        @Override // com.qzone.widget.util.c.d
        public void a(int i3) {
            if (this.f47837e.getVisibility() == 0) {
                StepOnZoneDirector.this.f47805f0.l(i3);
            } else {
                StepOnZoneDirector.this.f47805f0.o();
                StepOnZoneDirector.this.f47803e0 = 0L;
            }
            e7.a aVar = this.f47840i;
            if (aVar != null && aVar.f395803h.contains(Integer.valueOf(i3))) {
                StepOnZoneDirector.this.S.start();
            }
        }

        @Override // com.qzone.widget.util.c.InterfaceC0506c
        public void onEnd() {
            Log.i("StepOnZoneDirector", "onEnd: ");
            this.f47836d.setVisibility(8);
            this.f47837e.setVisibility(8);
            if (StepOnZoneDirector.this.T.f47850d != null) {
                StepOnZoneDirector.this.T.f47850d.recycle();
                StepOnZoneDirector.this.T.f47850d = null;
            }
            if (StepOnZoneDirector.this.V) {
                StepOnZoneDirector.this.m0();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q(boolean z16) {
            String str;
            int i3 = StepOnZoneDirector.this.l0() ? 3 : 2;
            if (z16) {
                str = "1";
            } else {
                str = "2";
            }
            StepOnZoneDirector stepOnZoneDirector = StepOnZoneDirector.this;
            stepOnZoneDirector.f47803e0 = stepOnZoneDirector.l0() ? 0L : StepOnZoneDirector.this.f47803e0;
            String valueOf = String.valueOf(StepOnZoneDirector.this.f47803e0);
            QZLog.i("StepOnZoneDirector", "action data report info : isSingleBtn (" + this.f47839h + ") res(" + i3 + ") res2(" + str + ") res6(" + valueOf + ")");
            if (this.f47839h) {
                StepOnZoneDirector.this.q0(3, i3, str, valueOf);
            } else {
                StepOnZoneDirector.this.q0(2, i3, str, valueOf);
            }
            if (this.f47840i == null || StepOnZoneDirector.this.f47803e0 == 0) {
                return;
            }
            StepOnZoneDirector stepOnZoneDirector2 = StepOnZoneDirector.this;
            e7.a aVar = this.f47840i;
            stepOnZoneDirector2.o0(aVar.f395796a, aVar.f395806k, z16, aVar.f395809n, aVar.f395807l, aVar.f395810o);
            MobileReportManager.getInstance().reportAction("qzone_pri", "4", "14", 144, 1, System.currentTimeMillis());
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private static class g extends PreLoadBitmapGenerator {
        g() {
        }

        @Override // com.qzone.widget.util.PreLoadBitmapGenerator
        protected Bitmap i(String str) {
            return StepOnZoneDirector.X(str, 1.0f);
        }
    }

    public void C0() {
        E0(null);
    }

    private byte[] Z(QzoneCustomTrackData qzoneCustomTrackData) {
        int i3;
        if (qzoneCustomTrackData != null && (i3 = qzoneCustomTrackData.iItemId) != -1 && i3 != 0) {
            UgcDecoQualReq ugcDecoQualReq = new UgcDecoQualReq();
            if (ugcDecoQualReq.mapItemId == null) {
                ugcDecoQualReq.mapItemId = new HashMap();
            }
            ugcDecoQualReq.mapItemId.put(Integer.valueOf(qzoneCustomTrackData.iAppId), Integer.valueOf(qzoneCustomTrackData.iItemId));
            return ugcDecoQualReq.toByteArray();
        }
        QZLog.e("StepOnZoneDirector", "getCustomTrackbinary:  \u53d1\u9001\u4e2a\u6027\u8e29\u5931\u8d25");
        return null;
    }

    private void p0(int i3, int i16) {
        LpReportInfo_pf00064.allReport(123, i3, i16, this.Y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(int i3, int i16, String str, String str2) {
        LpReportInfo_pf00064.allReport(123, i3, i16, str, str2, this.Y);
    }

    public void w0(e7.b bVar) {
        if (bVar != null && !bVar.f395814c.isEmpty()) {
            C0();
            this.V = true;
            this.W = bVar;
            if (this.U) {
                B0();
                return;
            }
            return;
        }
        if (this.V && this.U) {
            this.V = false;
            this.W = null;
            C0();
            this.G.setVisibility(8);
            this.J.f();
            r0();
        }
    }

    private void E0(c cVar) {
        this.X = Integer.MAX_VALUE;
        c cVar2 = this.K;
        if (cVar2 != cVar) {
            cVar2.x();
        }
        c cVar3 = this.L;
        if (cVar3 != cVar) {
            cVar3.x();
        }
        c cVar4 = this.M;
        if (cVar4 != cVar) {
            cVar4.x();
        }
        c cVar5 = this.N;
        if (cVar5 != cVar) {
            cVar5.x();
        }
        this.f47800d.p();
        D0();
    }

    public void s0(List<e7.a> list) {
        this.X = Integer.MAX_VALUE;
        this.f47799c0.j();
        List<e7.a> a16 = com.qzone.util.f.a(list);
        this.K.r();
        this.L.r();
        this.M.r();
        this.N.r();
        this.P.clear();
        if (a16.isEmpty()) {
            this.f47800d.l(1.2f, 255);
            setVisibility(8);
            this.U = false;
            return;
        }
        this.U = true;
        if (a16.size() == 1) {
            this.K.t(a16.get(0));
            this.P.put(this.K.f47840i.f395796a, this.K);
        } else {
            this.N.t(a16.get(0));
            this.P.put(this.N.f47840i.f395796a, this.N);
            this.M.t(a16.get(1));
            this.P.put(this.M.f47840i.f395796a, this.M);
            if (a16.size() > 2) {
                this.L.t(a16.get(2));
                this.P.put(this.L.f47840i.f395796a, this.L);
            }
        }
        if (this.V) {
            B0();
        } else {
            r0();
        }
        this.f47805f0.p(a16);
    }

    public StepOnZoneDirector(Activity activity, View view, View view2) {
        super(view);
        this.P = new HashMap();
        f fVar = new f();
        this.T = fVar;
        this.f47797a0 = true;
        this.f47798b0 = new Handler(Looper.getMainLooper());
        this.f47799c0 = new g();
        this.f47801d0 = new Observable("MiniAIO");
        this.f47806g0 = true;
        this.f47808h0 = new ArrayList<>();
        this.f47810i0 = false;
        this.f47811j0 = false;
        this.f47812k0 = false;
        this.f47813l0 = 0;
        this.f47815m0 = 0;
        this.Z = new WeakReference<>(activity);
        this.f47809i = view2;
        ScaleShadowMainBtnDirector scaleShadowMainBtnDirector = new ScaleShadowMainBtnDirector(findViewById(R.id.j2v));
        this.f47800d = scaleShadowMainBtnDirector;
        View findViewById = findViewById(R.id.j2u);
        com.qzone.homepage.ui.woo.b bVar = new com.qzone.homepage.ui.woo.b(findViewById, 1);
        this.f47802e = bVar;
        View findViewById2 = findViewById(R.id.j2s);
        com.qzone.homepage.ui.woo.b bVar2 = new com.qzone.homepage.ui.woo.b(findViewById2, 2);
        this.f47804f = bVar2;
        View findViewById3 = findViewById(R.id.j2t);
        com.qzone.homepage.ui.woo.b bVar3 = new com.qzone.homepage.ui.woo.b(findViewById3, 3);
        this.f47807h = bVar3;
        this.f47814m = (ImageView) findViewById(R.id.j2w);
        View findViewById4 = findViewById(R.id.j37);
        this.C = findViewById4;
        ImageView imageView = (ImageView) findViewById(R.id.f166911j31);
        this.D = imageView;
        this.E = findViewById(R.id.j39);
        this.F = (ImageView) findViewById(R.id.f166912j32);
        u0(findViewById2, "\u7231\u5fc3");
        u0(findViewById, "\u6572\u6253");
        u0(findViewById3, "\u6447\u6643\u5c4f\u5e55");
        this.f47805f0 = new HitAnimHolder(findViewById(R.id.m9q), (StrokeTextView) findViewById(R.id.m9p));
        View findViewById5 = findViewById(R.id.j38);
        this.G = findViewById5;
        AvatarImageView avatarImageView = (AvatarImageView) findViewById(R.id.f166913j33);
        this.H = avatarImageView;
        this.I = (TextView) findViewById(R.id.f166915j35);
        this.J = new com.qzone.homepage.ui.woo.a(findViewById(R.id.f166914j34));
        findViewById5.setVisibility(8);
        this.K = new c(R.id.j2n, R.id.j2m, imageView, true);
        this.L = new c(R.id.j2r, R.id.j2q, bVar.f(), false);
        this.M = new c(R.id.j2l, R.id.j2k, bVar2.f(), false);
        this.N = new c(R.id.j2p, R.id.j2o, bVar3.f(), false);
        scaleShadowMainBtnDirector.setOnClickListener(this);
        scaleShadowMainBtnDirector.setOnTouchListener(this);
        bVar.setOnTouchListener(this);
        bVar.setOnClickListener(this);
        bVar.setOnLongClickListener(this);
        bVar2.setOnTouchListener(this);
        bVar2.setOnClickListener(this);
        bVar2.setOnLongClickListener(this);
        bVar3.setOnTouchListener(this);
        bVar3.setOnClickListener(this);
        bVar3.setOnLongClickListener(this);
        findViewById4.setOnTouchListener(this);
        findViewById4.setOnClickListener(this);
        findViewById4.setOnLongClickListener(this);
        findViewById5.setOnClickListener(this);
        avatarImageView.setOnClickListener(this);
        view.setOnTouchListener(this);
        scaleShadowMainBtnDirector.l(1.2f, 255);
        scaleShadowMainBtnDirector.m(0);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.Q = ofFloat;
        ofFloat.setDuration(100L);
        e eVar = new e();
        ofFloat.addUpdateListener(eVar);
        ofFloat.addListener(eVar);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 3.1415927f);
        this.S = ofFloat2;
        ofFloat2.setDuration(300L);
        ofFloat2.addUpdateListener(fVar);
        ofFloat2.addListener(fVar);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(findViewById5, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        this.R = ofFloat3;
        ofFloat3.setDuration(150L);
        ofFloat3.addListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(String str, String str2, boolean z16, int i3, String str3, String str4) {
        String str5;
        String str6;
        HashMap hashMap;
        byte[] Z;
        if (this.V) {
            return;
        }
        QZLog.i("StepOnZoneDirector", "isTap: " + z16 + " combo: " + this.f47803e0);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("action_id", str);
        if (!z16) {
            str5 = "1";
        } else {
            str5 = "0";
        }
        hashMap2.put("action_type", str5);
        hashMap2.put("funny_tread_count", String.valueOf(this.f47803e0));
        QzoneCustomTrackData g16 = com.qzone.personalize.business.b.n().g(LoginData.getInstance().getUin());
        if (i3 != 1 || (Z = Z(g16)) == null) {
            str6 = str2;
            hashMap = null;
        } else {
            HashMap hashMap3 = new HashMap();
            hashMap3.put(COMM_MALL_INSERT_FEED.value, Z);
            hashMap2.put("action_name", str3);
            hashMap2.put("action_feeds_image", str4);
            hashMap2.put("item_id", g16.iItemId + "");
            hashMap2.put("is_tmall_personalized_interest", "1");
            str6 = "";
            hashMap = hashMap3;
        }
        QZoneLikeRequest qZoneLikeRequest = new QZoneLikeRequest(0, str6, str6, 0, 0, this.Y, (Map<Integer, String>) Collections.singletonMap(180, "FunnyTread"), (Map<Integer, String>) null, hashMap2, hashMap);
        Outbox.C().Q(new b9.a(this, new QZoneTask(qZoneLikeRequest, null, this, 61), qZoneLikeRequest.getRequestCmd()));
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    private class e extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        private boolean f47848d = false;

        e() {
        }

        private void b() {
            StepOnZoneDirector.this.f47800d.l(1.0f, 0);
            StepOnZoneDirector.this.f47802e.j(1.0f, 1.0f, 255);
            StepOnZoneDirector.this.f47804f.j(1.0f, 1.0f, 255);
            StepOnZoneDirector.this.f47807h.j(1.0f, 1.0f, 255);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            Log.i("IconOpenCloseAnim", "onAnimationEnd: ");
            if (this.f47848d) {
                b();
            } else {
                StepOnZoneDirector.this.f47800d.l(1.2f, 255);
                StepOnZoneDirector.this.f47802e.setVisibility(8);
                StepOnZoneDirector.this.f47804f.setVisibility(8);
                StepOnZoneDirector.this.f47807h.setVisibility(8);
            }
            StepOnZoneDirector.this.f47800d.m(this.f47848d ? 1 : 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            Log.i("IconOpenCloseAnim", "onAnimationStart: ");
            boolean z16 = StepOnZoneDirector.this.f47800d.f() == 0;
            this.f47848d = z16;
            if (z16) {
                StepOnZoneDirector.this.f47800d.l(1.2f, 255);
                if (StepOnZoneDirector.this.L.f47840i != null) {
                    StepOnZoneDirector.this.f47802e.j(0.5f, 0.0f, 0);
                    StepOnZoneDirector.this.f47802e.setVisibility(0);
                }
                StepOnZoneDirector.this.f47804f.j(0.5f, 0.0f, 0);
                StepOnZoneDirector.this.f47804f.setVisibility(0);
                StepOnZoneDirector.this.f47807h.j(0.5f, 0.0f, 0);
                StepOnZoneDirector.this.f47807h.setVisibility(0);
            } else {
                b();
            }
            StepOnZoneDirector.this.f47800d.m(2);
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i3 = (int) ((floatValue >= 0.6f ? 1.0f : floatValue / 0.6f) * 255.0f);
            int i16 = 255 - i3;
            float a16 = a(floatValue);
            if (this.f47848d) {
                StepOnZoneDirector.this.f47800d.l(1.2f - (0.2f * a16), i16);
                float f16 = (a16 * 0.5f) + 0.5f;
                StepOnZoneDirector.this.f47802e.j(f16, a16, i3);
                StepOnZoneDirector.this.f47804f.j(f16, a16, i3);
                StepOnZoneDirector.this.f47807h.j(f16, a16, i3);
                return;
            }
            StepOnZoneDirector.this.f47800d.l((a16 * 0.2f) + 1.0f, i3);
            float f17 = 1.0f - (0.5f * floatValue);
            float f18 = 1.0f - floatValue;
            StepOnZoneDirector.this.f47802e.j(f17, f18, i16);
            StepOnZoneDirector.this.f47804f.j(f17, f18, i16);
            StepOnZoneDirector.this.f47807h.j(f17, f18, i16);
        }

        private float a(float f16) {
            return (float) ((Math.cos((f16 + 1.0f) * 3.141592653589793d) / 2.0d) + 0.5d);
        }
    }

    private void b0(int i3) {
        if (i3 == 1) {
            this.f47802e.i(false);
        } else if (i3 == 2) {
            this.f47804f.i(false);
        } else {
            if (i3 != 3) {
                return;
            }
            this.f47807h.i(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap X(String str, float f16) {
        if (f16 > 1.0f) {
            f16 = 1.0f;
        } else if (f16 < 0.1f) {
            f16 = 0.1f;
        }
        Bitmap c16 = m.c(str);
        if (f16 == 1.0f) {
            return c16;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f16, f16);
        Bitmap createBitmap = Bitmap.createBitmap(c16, 0, 0, c16.getWidth(), c16.getHeight(), matrix, true);
        c16.recycle();
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class HitAnimHolder {

        /* renamed from: a, reason: collision with root package name */
        private final View f47816a;

        /* renamed from: b, reason: collision with root package name */
        private final StrokeTextView f47817b;

        /* renamed from: c, reason: collision with root package name */
        private Drawable f47818c;

        /* renamed from: d, reason: collision with root package name */
        private ObjectAnimator f47819d;

        /* renamed from: e, reason: collision with root package name */
        private ValueAnimator f47820e;

        /* renamed from: f, reason: collision with root package name */
        private AnimatorSet f47821f;

        /* renamed from: g, reason: collision with root package name */
        private AnimatorSet f47822g;

        /* renamed from: h, reason: collision with root package name */
        private Typeface f47823h;

        /* renamed from: i, reason: collision with root package name */
        private final ArrayList<Integer> f47824i = new ArrayList<>();

        /* renamed from: j, reason: collision with root package name */
        private final ArrayList<Integer> f47825j = new ArrayList<>();

        /* renamed from: k, reason: collision with root package name */
        private final ArrayList<Integer> f47826k = new ArrayList<>();

        /* renamed from: l, reason: collision with root package name */
        private final ArrayList<Integer> f47827l = new ArrayList<>();

        /* renamed from: m, reason: collision with root package name */
        private final ArrayList<Integer> f47828m = new ArrayList<>();

        HitAnimHolder(View view, StrokeTextView strokeTextView) {
            this.f47816a = view;
            this.f47817b = strokeTextView;
            i();
        }

        private ObjectAnimator f(View view) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(View.SCALE_X, Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.5f, 1.3f), Keyframe.ofFloat(1.0f, 1.0f)), PropertyValuesHolder.ofKeyframe(View.SCALE_Y, Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.5f, 1.3f), Keyframe.ofFloat(1.0f, 1.0f)));
            ofPropertyValuesHolder.setDuration(300L);
            QZLog.i("StepOnZoneDirector", "HitAnimHolder scale anim generate complete");
            return ofPropertyValuesHolder;
        }

        private ObjectAnimator g(View view) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofKeyframe(View.ROTATION, Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.25f, -2.5f), Keyframe.ofFloat(0.5f, 0.0f), Keyframe.ofFloat(0.75f, 2.5f), Keyframe.ofFloat(1.0f, 0.0f)));
            ofPropertyValuesHolder.setDuration(230L);
            ofPropertyValuesHolder.setRepeatMode(1);
            ofPropertyValuesHolder.setRepeatCount(-1);
            QZLog.i("StepOnZoneDirector", "HitAnimHolder shake anim generate complete");
            return ofPropertyValuesHolder;
        }

        private TimeInterpolator h() {
            return new PathInterpolator(0.11f, 0.0f, 0.52f, 1.0f);
        }

        private void i() {
            this.f47816a.bringToFront();
            m(this.f47817b);
            this.f47817b.setTextSize(ar.e(25.0f));
            TextPaint paint = this.f47817b.getPaint();
            paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, 0.4f * paint.getTextSize(), -3646923, -993432, Shader.TileMode.MIRROR));
            this.f47817b.setStrokeWidth(ar.e(10.0f));
            this.f47819d = g(this.f47817b);
            this.f47820e = f(this.f47817b);
        }

        private boolean k() {
            return this.f47816a.getVisibility() == 0;
        }

        private void m(final TextView textView) {
            Typeface typeface = this.f47823h;
            if (typeface == null) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).getHandler().post(new Runnable() { // from class: com.qzone.homepage.ui.woo.StepOnZoneDirector.HitAnimHolder.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AssetManager assets = BaseApplication.getContext().getAssets();
                        HitAnimHolder.this.f47823h = Typeface.createFromAsset(assets, "qzone_feeds_poke_num.ttf");
                        StepOnZoneDirector.this.f47798b0.post(new Runnable() { // from class: com.qzone.homepage.ui.woo.StepOnZoneDirector.HitAnimHolder.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                if (textView == null || HitAnimHolder.this.f47823h == null) {
                                    return;
                                }
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                textView.setTypeface(HitAnimHolder.this.f47823h);
                            }
                        });
                    }
                });
            } else {
                textView.setTypeface(typeface);
            }
        }

        private void r() {
            QZLog.i("StepOnZoneDirector", "HitAnimHolder online comboIndexList is empty or null, use local data (only normal material)");
            n();
            this.f47824i.add(11);
            this.f47824i.add(21);
            this.f47825j.add(3);
            this.f47826k.add(7);
            this.f47826k.add(12);
            this.f47826k.add(20);
            this.f47826k.add(25);
            this.f47827l.add(16);
            this.f47827l.add(25);
        }

        private void t() {
            if (this.f47820e == null) {
                this.f47820e = f(this.f47817b);
            }
            if (this.f47822g == null) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f47822g = animatorSet;
                animatorSet.setInterpolator(h());
                this.f47822g.play(this.f47820e);
                this.f47822g.addListener(new a());
            }
            if (this.f47822g.isRunning()) {
                this.f47822g.end();
            }
            this.f47822g.start();
        }

        private void u() {
            if (this.f47819d == null) {
                this.f47819d = g(this.f47817b);
            }
            if (this.f47821f == null) {
                AnimatorSet animatorSet = new AnimatorSet();
                this.f47821f = animatorSet;
                animatorSet.setInterpolator(h());
                this.f47821f.play(this.f47819d);
            }
            this.f47821f.start();
        }

        public void e() {
            ((RelativeLayout) ((aa) StepOnZoneDirector.this).rootView).bringChildToFront(this.f47816a);
            RelativeLayout relativeLayout = (RelativeLayout) ((aa) StepOnZoneDirector.this).rootView;
            View view = this.f47816a;
            relativeLayout.updateViewLayout(view, view.getLayoutParams());
        }

        public void j(int i3) {
            long j3 = i3;
            StepOnZoneDirector.this.f47803e0 = j3;
            q(j3);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x005c, code lost:
        
            if (r0.contains(java.lang.Integer.valueOf(r7)) != false) goto L30;
         */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean l(int i3) {
            ArrayList<Integer> arrayList;
            boolean z16 = false;
            if (!k() && !StepOnZoneDirector.this.l0()) {
                return false;
            }
            int i16 = StepOnZoneDirector.this.f47813l0;
            if (i16 == 1) {
                arrayList = this.f47824i;
            } else if (i16 == 2) {
                arrayList = this.f47825j;
            } else if (i16 != 3) {
                arrayList = i16 != 4 ? null : this.f47827l;
            } else {
                arrayList = this.f47826k;
            }
            if (arrayList == null) {
                return false;
            }
            if (arrayList.size() == 0) {
                if (this.f47828m.contains(Integer.valueOf(i3))) {
                    this.f47828m.clear();
                    z16 = true;
                    if (z16) {
                        StepOnZoneDirector stepOnZoneDirector = StepOnZoneDirector.this;
                        long j3 = stepOnZoneDirector.f47803e0 + 1;
                        stepOnZoneDirector.f47803e0 = j3;
                        q(j3);
                        QZLog.i("StepOnZoneDirector", "HitAnimHolder Combo + 1 ! current combo: " + StepOnZoneDirector.this.f47803e0 + " current select btn : " + StepOnZoneDirector.this.f47813l0 + " (1 Pan  2 Heart  3 Paint) current Frame Index: " + i3);
                    }
                    return z16;
                }
                this.f47828m.add(Integer.valueOf(i3));
                if (z16) {
                }
                return z16;
            }
        }

        public void n() {
            this.f47824i.clear();
            this.f47825j.clear();
            this.f47826k.clear();
            this.f47827l.clear();
            QZLog.i("StepOnZoneDirector", "HitAnimHolder comboIndexList reset complete");
        }

        public void o() {
            if (k()) {
                s(false);
                q(0L);
                this.f47828m.clear();
                AnimatorSet animatorSet = this.f47821f;
                if (animatorSet != null) {
                    animatorSet.cancel();
                }
                AnimatorSet animatorSet2 = this.f47822g;
                if (animatorSet2 != null) {
                    animatorSet2.cancel();
                }
                if (this.f47818c != null) {
                    ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.f47818c);
                }
                QZLog.i("StepOnZoneDirector", "HitAnimHolder combo end !");
            }
        }

        public void p(List<e7.a> list) {
            if (list != null && list.size() != 0) {
                n();
                if (list.size() == 1) {
                    QZLog.i("StepOnZoneDirector", "HitAnimHolder current mode : knock");
                    if (list.get(0).f395811p != null) {
                        this.f47827l.addAll(list.get(0).f395811p);
                    }
                } else if (list.size() >= 2) {
                    QZLog.i("StepOnZoneDirector", "HitAnimHolder current mode : normal");
                    if (list.get(0).f395811p != null) {
                        this.f47826k.addAll(list.get(0).f395811p);
                    }
                    if (list.get(1).f395811p != null) {
                        this.f47825j.addAll(list.get(1).f395811p);
                    }
                    if (list.size() == 3 && list.get(2).f395811p != null) {
                        this.f47824i.addAll(list.get(2).f395811p);
                    }
                }
                QZLog.i("StepOnZoneDirector", "HitAnimHolder hitIndexs info: (1)knock \uff1a" + this.f47827l.size() + " (2)pan : " + this.f47824i.size() + " (3)heart : " + this.f47825j.size() + " (4)paint : " + this.f47826k.size());
                if (this.f47827l.size() == 0 && this.f47824i.size() == 0 && this.f47826k.size() == 0 && this.f47825j.size() == 0 && list.get(0).f395809n == 0) {
                    r();
                    return;
                }
                return;
            }
            QZLog.e("StepOnZoneDirector", "HitAnimHolder anim models do not have data, hit indexs set failed !");
        }

        public void q(long j3) {
            this.f47817b.setText(HippyTKDListViewAdapter.X + Math.min(j3, 999L));
            if (k()) {
                t();
            }
        }

        public void s(boolean z16) {
            this.f47816a.setVisibility(z16 ? 0 : 8);
            if (z16) {
                j(1);
                u();
                QZLog.i("StepOnZoneDirector", "HitAnimHolder combo start !");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes39.dex */
        public class a extends com.tencent.mobileqq.widget.f {
            a() {
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (HitAnimHolder.this.f47821f != null) {
                    HitAnimHolder.this.f47821f.start();
                }
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (HitAnimHolder.this.f47821f == null || !HitAnimHolder.this.f47821f.isRunning()) {
                    return;
                }
                HitAnimHolder.this.f47821f.end();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        }
    }
}
