package com.qzone.module.personalitycomponent.coverWidget;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.qzone.module.personalitycomponent.entity.a;
import com.qzone.proxy.personalitycomponent.adapter.PLog;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityEnv;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityResources;
import com.qzone.proxy.personalitycomponent.model.WidgetVisitorsData;
import com.qzone.util.ab;
import com.qzone.widget.AvatarImageView;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasQzoneYellowThread;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes39.dex */
public class j extends com.qzone.module.personalitycomponent.coverWidget.b {
    private Bitmap A;
    private Bitmap B;
    private Bitmap C;
    private Bitmap D;
    private Drawable E;
    private NinePatch F;
    private String G;
    private Drawable H;
    private boolean I;
    private AnimatorSet J;
    private final ValueAnimator[] K;
    private ValueAnimator L;
    private final PointF[] M;
    private PointF N;
    private ValueAnimator O;
    private PointF P;
    private Bitmap[] Q;
    private a.C0415a[] R;
    private ValueAnimator[] S;
    private AnimatorSet T;
    private Matrix U;
    boolean V;
    private final ArrayList<WidgetVisitorsData.WidgetVistor> W;
    private int X;
    private Drawable Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private long f48961a0;

    /* renamed from: b0, reason: collision with root package name */
    private float f48962b0;

    /* renamed from: c0, reason: collision with root package name */
    private float f48963c0;

    /* renamed from: d0, reason: collision with root package name */
    private float f48964d0;

    /* renamed from: e0, reason: collision with root package name */
    private float f48965e0;

    /* renamed from: f0, reason: collision with root package name */
    private float f48966f0;

    /* renamed from: g0, reason: collision with root package name */
    private float f48967g0;

    /* renamed from: h, reason: collision with root package name */
    private WidgetVisitorsData f48968h;

    /* renamed from: h0, reason: collision with root package name */
    private float f48969h0;

    /* renamed from: i, reason: collision with root package name */
    private int f48970i;

    /* renamed from: i0, reason: collision with root package name */
    private float f48971i0;

    /* renamed from: j, reason: collision with root package name */
    private int f48972j;

    /* renamed from: j0, reason: collision with root package name */
    private float f48973j0;

    /* renamed from: k, reason: collision with root package name */
    private int f48974k;

    /* renamed from: k0, reason: collision with root package name */
    private float f48975k0;

    /* renamed from: l, reason: collision with root package name */
    private int f48976l;

    /* renamed from: l0, reason: collision with root package name */
    private final ImageLoader.ImageLoadListener f48977l0;

    /* renamed from: m, reason: collision with root package name */
    private int f48978m;

    /* renamed from: m0, reason: collision with root package name */
    private final View.OnClickListener f48979m0;

    /* renamed from: n, reason: collision with root package name */
    private int f48980n;

    /* renamed from: o, reason: collision with root package name */
    private int f48981o;

    /* renamed from: p, reason: collision with root package name */
    private int f48982p;

    /* renamed from: q, reason: collision with root package name */
    private int f48983q;

    /* renamed from: r, reason: collision with root package name */
    private int f48984r;

    /* renamed from: s, reason: collision with root package name */
    private int f48985s;

    /* renamed from: t, reason: collision with root package name */
    private int f48986t;

    /* renamed from: u, reason: collision with root package name */
    private int f48987u;

    /* renamed from: v, reason: collision with root package name */
    private int f48988v;

    /* renamed from: w, reason: collision with root package name */
    private int f48989w;

    /* renamed from: x, reason: collision with root package name */
    private int f48990x;

    /* renamed from: y, reason: collision with root package name */
    private int f48991y;

    /* renamed from: z, reason: collision with root package name */
    private Paint f48992z;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            EventCollector.getInstance().onViewClickedBefore(view);
            HashMap hashMap = new HashMap();
            hashMap.put("pendant_type", 2);
            fo.c.e("em_qz_pendant", "pg_bas_social_updates", view, hashMap);
            if (!j.this.i0()) {
                if (k.e().g()) {
                    str = "1";
                } else {
                    str = "0";
                }
                PersonalityEnv.report("302", "7", "401", str);
            } else {
                PersonalityEnv.report("302", "7", PersonalityConfig.RESERVES_COVER_CLICK_WIDGET_VISITOR_WITH_NANE_PLATGE);
            }
            cooperation.vip.c.c(408);
            j jVar = j.this;
            if (jVar.f48932d != null) {
                jVar.N();
                if (j.this.f48968h != null && j.this.f48968h.needRedPacket != 0) {
                    PersonalityEnv.report("302", PersonalityConfig.SUB_ACTION_TYPE_ACTIVE_FEEDS_REDPOCKET_DECORATE_CLICK, "", true);
                } else {
                    PersonalityEnv.JumpToVistorFromUserHome(j.this.f48932d, "QzFeedVistorPendant");
                    k.e().b();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        private final int f48995d;

        public c(int i3) {
            this.f48995d = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            j.this.R[this.f48995d] = (a.C0415a) valueAnimator.getAnimatedValue();
            j.this.r0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class e implements IPicLoadStateListener {

        /* renamed from: d, reason: collision with root package name */
        private final int f48999d;

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<j> f49000e;

        public e(j jVar, int i3) {
            this.f49000e = new WeakReference<>(jVar);
            this.f48999d = i3;
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            int i3;
            if (loadState == LoadState.STATE_SUCCESS) {
                j jVar = this.f49000e.get();
                Bitmap resultBitMap = option.getResultBitMap();
                if (resultBitMap == null || jVar == null) {
                    return;
                }
                ArrayList arrayList = jVar.W;
                int i16 = this.f48999d;
                if (i16 < 0 || i16 >= arrayList.size()) {
                    return;
                }
                if (option.getUrl().contains(((WidgetVisitorsData.WidgetVistor) arrayList.get(this.f48999d)).uin + "")) {
                    Bitmap[] bitmapArr = jVar.Q;
                    if (bitmapArr != null && (i3 = this.f48999d) < bitmapArr.length) {
                        bitmapArr[i3] = resultBitMap;
                    }
                    if (jVar.g0()) {
                        jVar.t();
                    }
                }
            }
        }
    }

    public j(Context context, Handler handler) {
        super(context, handler);
        int i3 = 0;
        this.I = false;
        this.K = new ValueAnimator[3];
        this.M = new PointF[3];
        this.N = new PointF(0.0f, 0.0f);
        this.P = new PointF(0.0f, 0.0f);
        this.V = false;
        this.W = new ArrayList<>();
        this.Z = false;
        this.f48961a0 = 0L;
        this.f48977l0 = new a();
        this.f48979m0 = new b();
        this.f48929a = 4;
        this.f48932d = context;
        if (context != null) {
            this.f48970i = PersonalityEnv.dpToPx(38.0f);
            this.f48972j = PersonalityEnv.dpToPx(38.0f);
            this.f48974k = PersonalityEnv.dpToPx(5.0f);
            this.f48976l = PersonalityEnv.dpToPx(5.0f);
            this.f48978m = PersonalityEnv.dpToPx(9.0f);
            this.f48980n = PersonalityEnv.dpToPx(9.0f);
            this.f48981o = PersonalityEnv.dpToPx(2.0f);
            this.f48982p = PersonalityEnv.dpToPx(5.0f);
            this.f48983q = PersonalityEnv.dpToPx(7.0f);
            this.f48984r = PersonalityEnv.dpToPx(4.0f);
            this.f48986t = PersonalityEnv.dpToPx(2.0f);
            this.f48985s = PersonalityEnv.dpToPx(32.0f);
            this.f48987u = PersonalityEnv.dpToPx(60.0f);
            this.f48988v = PersonalityEnv.dpToPx(13.0f);
            this.f48989w = ViewUtils.dip2px(37.0f);
            Paint paint = new Paint();
            this.f48992z = paint;
            paint.setAntiAlias(true);
            this.f48992z.setShadowLayer(6.0f, 0.0f, 0.0f, Color.parseColor("#59000000"));
        }
        while (true) {
            PointF[] pointFArr = this.M;
            if (i3 >= pointFArr.length) {
                return;
            }
            pointFArr[i3] = new PointF(-100.0f, -100.0f);
            i3++;
        }
    }

    private void O() {
        int size = this.W.size();
        if (size > 0 && this.T == null) {
            for (int i3 = 0; i3 < 5; i3++) {
                a.C0415a[] Y = Y(X(i3), size);
                a.C0415a c0415a = this.R[i3];
                if (c0415a != null) {
                    c0415a.f49031f = X(i3);
                    this.S[i3] = ValueAnimator.ofObject(new com.qzone.module.personalitycomponent.entity.a(this.R[i3]), Y);
                    this.S[i3].addUpdateListener(new c(i3));
                    this.S[i3].setDuration(size * 320);
                }
            }
            AnimatorSet animatorSet = new AnimatorSet();
            this.T = animatorSet;
            animatorSet.playTogether(this.S);
            this.T.start();
        }
    }

    private void P(final int i3, Object... objArr) {
        ValueAnimator[] valueAnimatorArr = this.K;
        if (valueAnimatorArr[i3] == null) {
            valueAnimatorArr[i3] = ValueAnimator.ofObject(new com.qzone.module.personalitycomponent.entity.b(), objArr);
            this.K[i3].addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qzone.module.personalitycomponent.coverWidget.i
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    j.this.j0(i3, valueAnimator);
                }
            });
            this.K[i3].setStartDelay(i3 * 80);
            this.K[i3].setDuration(500L);
        }
    }

    private void Q(Canvas canvas) {
        if (this.Q == null || !g0()) {
            return;
        }
        if (this.U == null) {
            this.U = new Matrix();
        }
        int i3 = 2;
        for (int i16 = 0; i16 < 5; i16++) {
            float f16 = this.R[i16].f49026a;
            int i17 = this.f48985s;
            if (f16 > (-i17) / 4 && f16 < i17 / 4) {
                i3 = i16;
            }
        }
        for (int i18 = 0; i18 < 5; i18++) {
            if (i18 != i3) {
                t0(i18, canvas);
            }
        }
        t0(i3, canvas);
        c0();
    }

    private void R(Canvas canvas) {
        int i3 = this.f48985s;
        int i16 = this.f48976l + this.f48980n + this.f48981o;
        if (this.A != null) {
            this.f48969h0 = i3;
            this.f48971i0 = i16;
            Matrix matrix = new Matrix();
            PointF pointF = this.N;
            matrix.postScale(pointF.x, pointF.y);
            matrix.preTranslate((-this.A.getWidth()) / 2, (-this.A.getHeight()) / 2);
            matrix.postTranslate(this.f48969h0 + (this.A.getWidth() / 2), this.f48971i0 + (this.A.getHeight() / 2));
            canvas.drawBitmap(this.A, matrix, this.f48992z);
            d0();
        }
    }

    private void S(Canvas canvas, Bitmap bitmap, boolean z16, float f16, float f17, float f18) {
        if (i0()) {
            return;
        }
        Matrix matrix = new Matrix();
        Paint paint = new Paint();
        if (z16) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setAlpha(76);
        }
        matrix.postRotate(f18);
        matrix.preTranslate((-bitmap.getWidth()) / 2, (-bitmap.getHeight()) / 2);
        matrix.postTranslate(f16 + (bitmap.getWidth() / 2), f17 + (bitmap.getHeight() / 2));
        canvas.drawBitmap(bitmap, matrix, paint);
    }

    private void T(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Bitmap bitmap5;
        Bitmap bitmap6;
        PointF[] pointFArr = this.M;
        if (pointFArr == null || pointFArr.length != 3) {
            return;
        }
        PointF pointF = pointFArr[0];
        if (pointF == null || pointFArr[1] == null || pointFArr[2] == null) {
            return;
        }
        int i3 = this.f48985s;
        int i16 = this.f48976l;
        int i17 = this.f48970i;
        int i18 = this.f48978m;
        int i19 = i3 + (i17 > i18 * 3 ? (i17 - (i18 * 3)) / 2 : 0);
        this.f48962b0 = i19;
        float f16 = i16 + 5;
        this.f48963c0 = f16;
        int i26 = this.f48968h.today_visitor;
        if (i26 > 0 && (bitmap6 = this.B) != null) {
            S(canvas, bitmap6, false, pointF.x, pointF.y, -20.0f);
        } else if (i26 <= 0 && (bitmap = this.C) != null) {
            S(canvas, bitmap, true, pointF.x, pointF.y, -20.0f);
        }
        this.f48964d0 = i19 + this.f48978m;
        this.f48965e0 = i16;
        int i27 = this.f48968h.today_visitor;
        if (i27 > 10 && (bitmap5 = this.B) != null) {
            PointF pointF2 = this.M[1];
            S(canvas, bitmap5, false, pointF2.x, pointF2.y, 0.0f);
        } else if (i27 <= 10 && (bitmap2 = this.C) != null) {
            PointF pointF3 = this.M[1];
            S(canvas, bitmap2, true, pointF3.x, pointF3.y, 0.0f);
        }
        this.f48966f0 = r10 + this.f48978m;
        this.f48967g0 = f16;
        int i28 = this.f48968h.today_visitor;
        if (i28 > 20 && (bitmap4 = this.B) != null) {
            PointF pointF4 = this.M[2];
            S(canvas, bitmap4, false, pointF4.x, pointF4.y, 20.0f);
        } else if (i28 <= 20 && (bitmap3 = this.C) != null) {
            PointF pointF5 = this.M[2];
            S(canvas, bitmap3, true, pointF5.x, pointF5.y, 20.0f);
        }
        e0();
    }

    private void V(Canvas canvas, float f16) {
        if (this.A == null) {
            return;
        }
        this.f48992z.setTextSize(this.f48988v);
        this.f48992z.setColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
        int i3 = (int) (this.f48992z.getFontMetrics().descent - this.f48992z.getFontMetrics().ascent);
        int i16 = this.f48976l + this.f48980n + this.f48981o + 0;
        float f17 = i16 + i3;
        canvas.drawText("\u4eca\u65e5\u8bbf\u5ba2", f16, f17, this.f48992z);
        float f18 = i16 + (i3 * 2) + 0;
        canvas.drawText("\u8bbf\u5ba2\u603b\u91cf", f16, f18, this.f48992z);
        float measureText = f16 + this.f48992z.measureText("\u4eca\u65e5\u8bbf\u5ba2") + this.f48984r;
        this.f48992z.setColor(Color.parseColor(TipsElementData.DEFAULT_COLOR));
        canvas.drawText(a0(this.f48991y), measureText, f18, this.f48992z);
        canvas.drawText(a0(this.f48990x), (int) ((measureText + this.f48992z.measureText(a0(this.f48991y))) - this.f48992z.measureText(a0(this.f48990x))), f17, this.f48992z);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private a.C0415a W(int i3) {
        int i16;
        int i17;
        float f16;
        float f17;
        float f18;
        int i18 = i3 % 5;
        if (i18 != 0) {
            if (i18 == 1) {
                i16 = (-this.f48985s) / 2;
            } else {
                if (i18 == 2) {
                    i17 = -this.f48985s;
                } else if (i18 == 3) {
                    i17 = this.f48985s;
                } else if (i18 == 4) {
                    i16 = this.f48985s / 2;
                }
                f16 = i17;
                f17 = f16;
                float f19 = i18 == 0 ? 1.0f : (i18 == 1 || i18 == 4) ? 0.75f : 0.0f;
                float f26 = i18 == 0 ? 1.0f : (i18 == 1 || i18 == 4) ? 0.75f : 0.0f;
                if (i18 == 0) {
                    f18 = 1.0f;
                } else {
                    f18 = (i18 == 1 || i18 == 4) ? 0.5f : 0.0f;
                }
                return new a.C0415a(f17, 0.0f, f19, f26, f18);
            }
            f16 = i16;
            f17 = f16;
            if (i18 == 0) {
            }
            if (i18 == 0) {
            }
            if (i18 == 0) {
            }
            return new a.C0415a(f17, 0.0f, f19, f26, f18);
        }
        f17 = 0.0f;
        if (i18 == 0) {
        }
        if (i18 == 0) {
        }
        if (i18 == 0) {
        }
        return new a.C0415a(f17, 0.0f, f19, f26, f18);
    }

    private int X(int i3) {
        if (i3 == 0) {
            return 0;
        }
        if (i3 < 5) {
            return 5 - i3;
        }
        if (i3 == 5) {
            return 0;
        }
        return 10 - i3;
    }

    private a.C0415a[] Y(int i3, int i16) {
        a.C0415a[] c0415aArr = new a.C0415a[i16];
        for (int i17 = 0; i17 < i16; i17++) {
            c0415aArr[i17] = W(i17 + i3);
        }
        return c0415aArr;
    }

    private int b0() {
        this.f48992z.setTextSize(PersonalityEnv.dpToPx(13.0f));
        return Math.max((int) (((int) this.f48992z.measureText("\u4eca\u65e5\u8bbf\u5ba2")) + this.f48992z.measureText(a0(this.f48990x))), (int) (((int) this.f48992z.measureText("\u8bbf\u5ba2\u603b\u91cf")) + this.f48992z.measureText(a0(this.f48991y))));
    }

    private void c0() {
        if (this.S == null) {
            this.S = new ValueAnimator[5];
        }
        O();
    }

    private void d0() {
        if (this.L == null) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new com.qzone.module.personalitycomponent.entity.b(), new PointF(0.0f, 0.0f), new PointF(1.0f, 1.0f));
            this.L = ofObject;
            ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qzone.module.personalitycomponent.coverWidget.g
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    j.this.k0(valueAnimator);
                }
            });
            this.L.setDuration(500L);
        }
    }

    private void e0() {
        if (this.K.length != 3) {
            return;
        }
        P(0, new PointF(this.f48964d0, this.f48963c0 + PersonalityEnv.dpToPx(18.0f)), new PointF(this.f48962b0 - PersonalityEnv.dpToPx(3.0f), this.f48963c0 - PersonalityEnv.dpToPx(3.0f)), new PointF(this.f48962b0, this.f48963c0));
        P(1, new PointF(this.f48964d0, this.f48965e0 + PersonalityEnv.dpToPx(18.0f)), new PointF(this.f48964d0, this.f48965e0 - PersonalityEnv.dpToPx(3.0f)), new PointF(this.f48964d0, this.f48965e0));
        P(2, new PointF(this.f48964d0, this.f48967g0 + PersonalityEnv.dpToPx(18.0f)), new PointF(this.f48966f0 + PersonalityEnv.dpToPx(3.0f), this.f48967g0 - PersonalityEnv.dpToPx(3.0f)), new PointF(this.f48966f0, this.f48967g0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g0() {
        Bitmap[] bitmapArr = this.Q;
        if (bitmapArr == null) {
            return false;
        }
        for (Bitmap bitmap : bitmapArr) {
            if (bitmap == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i0() {
        int i3;
        WidgetVisitorsData widgetVisitorsData = this.f48968h;
        return widgetVisitorsData != null && (i3 = widgetVisitorsData.namePlateFlag) >= 1 && i3 <= 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(int i3, ValueAnimator valueAnimator) {
        this.M[i3] = (PointF) valueAnimator.getAnimatedValue();
        r0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(ValueAnimator valueAnimator) {
        this.N = (PointF) valueAnimator.getAnimatedValue();
        r0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(ValueAnimator valueAnimator) {
        this.P = (PointF) valueAnimator.getAnimatedValue();
        r0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(LoadState loadState, Option option) {
        if (this.f48932d == null || loadState != LoadState.STATE_SUCCESS) {
            return;
        }
        this.E = new BitmapDrawable(this.f48932d.getResources(), option.getResultBitMap());
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0() {
        ArrayList<WidgetVisitorsData.WidgetVistor> arrayList;
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.extraProcessor = AvatarImageView.F;
        WidgetVisitorsData widgetVisitorsData = this.f48968h;
        if (widgetVisitorsData != null && (arrayList = widgetVisitorsData.deltaList) != null) {
            Iterator<WidgetVisitorsData.WidgetVistor> it = arrayList.iterator();
            while (it.hasNext()) {
                WidgetVisitorsData.WidgetVistor next = it.next();
                if (next != null) {
                    String str = "avatar://" + next.uin;
                    if (VasNormalToggle.VAS_QZONE_NEW_IMAGE_LOADER.isEnable(true)) {
                        com.tencent.mobileqq.qzone.picload.c.a().h(Option.obtain().setUrl(str));
                    } else {
                        ImageLoader.getInstance().loadImageAsync(str, null, obtain);
                    }
                    if (PLog.isColorLevel()) {
                        PLog.d("VisitorWidget", "\u4e0b\u8f7d\u5934\u50cf:" + str);
                    }
                }
            }
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.qzone.module.personalitycomponent.coverWidget.e
            @Override // java.lang.Runnable
            public final void run() {
                j.this.n0();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        Handler handler = this.f48933e;
        if (handler != null) {
            handler.sendEmptyMessage(PersonalityConfig.MSG_REQUEST_DRAW);
        }
    }

    private void s0() {
        if (this.J == null) {
            ValueAnimator[] valueAnimatorArr = this.K;
            if (valueAnimatorArr[0] == null || valueAnimatorArr[1] == null || valueAnimatorArr[2] == null || this.L == null) {
                return;
            }
            AnimatorSet animatorSet = new AnimatorSet();
            this.J = animatorSet;
            ValueAnimator[] valueAnimatorArr2 = this.K;
            animatorSet.playTogether(this.L, valueAnimatorArr2[0], valueAnimatorArr2[1], valueAnimatorArr2[2]);
            this.J.setStartDelay(this.W.size() * 320);
            this.J.start();
        }
    }

    private void t0(int i3, Canvas canvas) {
        Bitmap[] bitmapArr;
        a.C0415a c0415a = this.R[i3];
        if (c0415a == null) {
            return;
        }
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        float f16 = 1.0f - this.N.x;
        if (f16 <= 0.0f) {
            return;
        }
        try {
            this.U.reset();
            this.U.setScale(c0415a.f49028c, c0415a.f49029d);
            this.U.preTranslate((-this.f48970i) / 2, (-this.f48972j) / 2);
            this.U.postTranslate(this.f48969h0 + (this.f48970i / 2) + c0415a.f49026a, this.f48971i0 + (this.f48972j / 2) + c0415a.f49027b);
            paint.setAlpha((int) (c0415a.f49030e * 255.0f * f16));
            int i16 = c0415a.f49033h;
            if (i16 < 0 || (bitmapArr = this.Q) == null || i16 >= bitmapArr.length) {
                return;
            }
            canvas.drawBitmap(bitmapArr[i16], this.U, paint);
        } catch (Exception e16) {
            PLog.d("CoverWidget ", "Exception e = " + e16.getMessage());
        }
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public String b() {
        return this.G;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public View.OnClickListener c() {
        return this.f48979m0;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public int d() {
        int i3;
        if (this.f48968h != null) {
            if (!i0()) {
                return this.f48982p + this.f48972j + 0 + this.f48976l + this.f48981o + this.f48980n;
            }
            i3 = this.f48987u;
        } else {
            if (this.Y == null) {
                return 0;
            }
            i3 = this.f48972j;
        }
        return 0 + i3;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public int e() {
        if (this.f48968h != null && this.f48932d != null && this.f48992z != null) {
            return b0() + this.f48970i + 0 + this.f48974k + 2 + this.f48983q + this.f48984r + this.f48985s;
        }
        if (this.f48932d == null || this.Y == null) {
            return 0;
        }
        return 0 + this.f48970i;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public int g() {
        return this.f48929a;
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public void o() {
        this.Y = PersonalityResources.getDrawable(this.f48932d, PersonalityResources.DrawableID.qzone_widget_visitor_default);
        super.o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void n0() {
        Bitmap bitmapFromResource;
        int i3;
        int i16;
        Bitmap bitmapFromResource2;
        if (this.f48968h == null || this.f48932d == null) {
            return;
        }
        this.Y = null;
        this.G = "\u4eca\u65e5\u8bbf\u5ba2 " + this.f48968h.today_visitor + "  \u603b\u6d4f\u89c8\u91cf " + this.f48968h.total_visitor;
        try {
            boolean i06 = i0();
            if (PLog.isColorLevel()) {
                PLog.d("VisitorWidget", "isNamePlateUser=" + i06);
            }
            this.f48988v = PersonalityEnv.dpToPx(12.0f);
            if (this.A == null || this.I) {
                int i17 = this.f48970i;
                int i18 = this.f48972j;
                WidgetVisitorsData widgetVisitorsData = this.f48968h;
                if (widgetVisitorsData != null && widgetVisitorsData.needRedPacket != 0) {
                    bitmapFromResource = PersonalityResources.getBitmapFromResource(this.f48932d, PersonalityResources.DrawableID.qzone_widget_redpocket, i17, i18);
                    PersonalityEnv.report("302", PersonalityConfig.SUB_ACTION_TYPE_ACTIVE_FEEDS_REDPOCKET_DECORATE_EXPOSED, "", true);
                } else {
                    bitmapFromResource = PersonalityResources.getBitmapFromResource(this.f48932d, PersonalityResources.DrawableID.qzone_widget_visitor_default, i17, i18);
                }
                if (bitmapFromResource != null) {
                    this.A = Bitmap.createScaledBitmap(bitmapFromResource, i17, i18, false);
                }
            }
            if (this.B == null) {
                cooperation.vip.c.c(407);
                int i19 = this.f48978m;
                int i26 = this.f48980n;
                Bitmap bitmapFromResource3 = PersonalityResources.getBitmapFromResource(this.f48932d, PersonalityResources.DrawableID.qzone_widget_visitor_star_bright, i19, i26);
                if (bitmapFromResource3 != null) {
                    this.B = Bitmap.createScaledBitmap(bitmapFromResource3, i19, i26, false);
                }
            }
            if (this.C == null && (bitmapFromResource2 = PersonalityResources.getBitmapFromResource(this.f48932d, PersonalityResources.DrawableID.qzone_widget_visitor_star_gray, (i3 = this.f48978m), (i16 = this.f48980n))) != null) {
                this.C = Bitmap.createScaledBitmap(bitmapFromResource2, i3, i16, false);
            }
            if (!i06) {
                this.H = null;
            } else {
                if (this.H == null) {
                    this.H = PersonalityResources.getDrawable(this.f48932d, PersonalityResources.DrawableID.qzone_widget_vip_namaplate_bg);
                }
                if (this.E == null || this.I) {
                    ImageLoader.Options obtain = ImageLoader.Options.obtain();
                    int i27 = this.f48987u;
                    obtain.clipWidth = i27;
                    obtain.clipHeight = i27;
                    String Z = Z(this.f48968h.namePlateFlag);
                    if (VasNormalToggle.VAS_QZONE_NEW_IMAGE_LOADER.isEnable(true)) {
                        com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(Z), new IPicLoadStateListener() { // from class: com.qzone.module.personalitycomponent.coverWidget.f
                            @Override // com.tencent.libra.listener.IPicLoadStateListener
                            public final void onStateChange(LoadState loadState, Option option) {
                                j.this.m0(loadState, option);
                            }
                        });
                    } else {
                        this.E = ImageLoader.getInstance().loadImage(Z, this.f48977l0, obtain);
                    }
                }
            }
            WidgetVisitorsData widgetVisitorsData2 = this.f48968h;
            this.f48990x = widgetVisitorsData2.today_visitor;
            this.f48991y = widgetVisitorsData2.total_visitor;
            this.Z = false;
            ArrayList<WidgetVisitorsData.WidgetVistor> arrayList = widgetVisitorsData2.deltaList;
            if (arrayList != null && arrayList.size() > 0) {
                if (this.V) {
                    ArrayList<WidgetVisitorsData.WidgetVistor> d16 = k.e().d(this.f48968h.deltaList);
                    if (d16 != null && d16.size() > 0) {
                        this.Z = true;
                        PLog.d("VisitorWidget", "\u6b63\u5728\u64ad\u653e\u52a8\u753b\u4e2d\uff0c\u4f46\u8fd8\u6709\u65b0\u8bbf\u5ba2");
                        k.e().a(d16);
                        p0(d16, false);
                    }
                } else {
                    k.e().b();
                    k.e().a(this.f48968h.deltaList);
                    p0(k.e().f(), true);
                }
                if (this.D == null) {
                    this.D = PersonalityResources.getBitmapFromResource(this.f48932d, PersonalityResources.DrawableID.qzone_widget_vip_number_bg, -1, -1);
                    Bitmap bitmap = this.D;
                    this.F = new NinePatch(bitmap, bitmap.getNinePatchChunk(), null);
                }
                if (this.R == null) {
                    this.R = new a.C0415a[5];
                    int i28 = 0;
                    while (true) {
                        a.C0415a[] c0415aArr = this.R;
                        if (i28 >= c0415aArr.length) {
                            break;
                        }
                        c0415aArr[i28] = W(X(i28));
                        if (this.W.size() <= 0) {
                            this.R[i28].f49033h = -1;
                        } else if (this.W.size() <= 5) {
                            this.R[i28].f49033h = i28;
                        } else if (i28 <= 2) {
                            this.R[i28].f49033h = i28;
                        } else {
                            this.R[i28].f49033h = this.W.size() - (5 - i28);
                        }
                        i28++;
                    }
                }
                this.Q = new Bitmap[this.W.size()];
                for (int i29 = 0; i29 < this.W.size(); i29++) {
                    WidgetVisitorsData.WidgetVistor widgetVistor = this.W.get(i29);
                    if (widgetVistor == null) {
                        return;
                    }
                    String str = "avatar://" + widgetVistor.uin;
                    ImageLoader.Options obtain2 = ImageLoader.Options.obtain();
                    obtain2.extraProcessor = AvatarImageView.F;
                    if (VasNormalToggle.VAS_QZONE_NEW_IMAGE_LOADER.isEnable(true)) {
                        com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(str).setRegionHeight(this.f48989w).setRegionWidth(this.f48989w), new e(this, i29));
                    } else {
                        Drawable loadImage = ImageLoader.getInstance().loadImage(str, new d(this, i29), obtain2);
                        int i36 = this.f48989w;
                        this.Q[i29] = ab.a(loadImage, i36, i36);
                    }
                }
            } else {
                N();
                p0(null, true);
            }
            t();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public void w(Object obj) {
        if (obj != null && (obj instanceof WidgetVisitorsData)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f48961a0 > 3000) {
                this.f48961a0 = currentTimeMillis;
                boolean h06 = h0(obj);
                if (PLog.isColorLevel()) {
                    PLog.d("VisitorWidget", "data change=" + h06 + ",mIsNeedRefresh=" + this.Z);
                }
                if (h06 || this.Z) {
                    this.f48968h = (WidgetVisitorsData) obj;
                }
                VasQzoneYellowThread.INSTANCE.execJob(new Runnable() { // from class: com.qzone.module.personalitycomponent.coverWidget.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        j.this.o0();
                    }
                });
                return;
            }
            PLog.d("VisitorWidget", "\u5237\u65b0\u592a\u9891\u7e41\u4e86\uff0c\u4e0d\u7ee7\u7eed\u3002");
            return;
        }
        if (PLog.isColorLevel()) {
            PLog.d("VisitorWidget", "diff list empty ");
        }
        n0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        this.V = false;
        this.D = null;
        this.W.clear();
        k.e().b();
    }

    private void U(Canvas canvas) {
        Bitmap bitmap;
        if (this.D == null || (bitmap = this.B) == null) {
            return;
        }
        int i3 = 2;
        this.f48973j0 = this.f48964d0 + (bitmap.getHeight() / 2);
        this.f48975k0 = (this.f48971i0 + this.A.getHeight()) - this.D.getHeight();
        int i16 = this.X;
        if (i16 > 999) {
            i16 = 999;
        }
        if (i16 == 0) {
            return;
        }
        if (i16 >= 2) {
            i3 = 3;
        } else if (i16 < 1) {
            i3 = 1;
        }
        String[] strArr = new String[i3];
        int i17 = 0;
        int i18 = 0;
        while (i18 < i3 && i16 >= 0) {
            strArr[(i3 - i18) - 1] = Marker.ANY_NON_NULL_MARKER + i16;
            i18++;
            i16 += -1;
        }
        this.f48992z.setTextSize(PersonalityEnv.dpToPx(7.0f));
        Paint paint = new Paint(this.f48992z);
        paint.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f16 = fontMetrics.bottom;
        float f17 = f16 - fontMetrics.top;
        float f18 = (f17 / 2.0f) - f16;
        float f19 = 0.0f;
        float f26 = 0.0f;
        for (int i19 = 0; i19 < i3; i19++) {
            float measureText = paint.measureText(strArr[i19]);
            if (f26 <= measureText) {
                f26 = measureText;
            }
        }
        int i26 = this.f48986t;
        float f27 = f17 + (i26 * 2);
        float f28 = f26 + (i26 * 4);
        Bitmap createBitmap = Bitmap.createBitmap((int) f28, (int) f27, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        if (this.F != null) {
            this.F.draw(canvas2, new RectF(0.0f, 0.0f, f28, f27));
        }
        while (i17 < i3) {
            PointF pointF = this.P;
            canvas2.drawText(strArr[i17], f28 / 2.0f, (((f27 / 2.0f) + f18) - (i17 * f27)) + (pointF != null ? pointF.y : f19), paint);
            i17++;
            f19 = 0.0f;
        }
        canvas.drawBitmap(createBitmap, this.f48973j0, this.f48975k0, this.f48992z);
        f0((i3 - 1) * f27);
    }

    private void p0(ArrayList<WidgetVisitorsData.WidgetVistor> arrayList, boolean z16) {
        if (z16) {
            this.W.clear();
        }
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        this.X = size;
        if (size > 0) {
            this.G += " \u672a\u8bfb\u6570 " + Math.min(this.X, 999);
        }
        for (int size2 = arrayList.size() - (9 > arrayList.size() ? arrayList.size() : 9); size2 < arrayList.size(); size2++) {
            this.W.add(arrayList.get(size2));
        }
    }

    @Override // com.qzone.module.personalitycomponent.coverWidget.b
    public void l(Canvas canvas) {
        Drawable drawable;
        if (canvas != null && this.f48968h != null && this.f48992z != null && this.f48932d != null) {
            try {
                if (i0()) {
                    int dpToPx = this.f48985s - PersonalityEnv.dpToPx(11.0f);
                    int dpToPx2 = PersonalityEnv.dpToPx(2.0f);
                    Drawable drawable2 = this.E;
                    if (drawable2 != null) {
                        int i3 = this.f48987u;
                        drawable2.setBounds(dpToPx, dpToPx2, i3 + dpToPx, i3 + dpToPx2);
                        this.E.draw(canvas);
                    }
                }
                T(canvas);
                R(canvas);
                if (this.f48968h.needRedPacket == 0) {
                    Q(canvas);
                }
                V(canvas, this.f48985s + this.f48970i + this.f48974k + this.f48983q + 2);
                U(canvas);
                s0();
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        if (canvas == null || this.f48968h != null || (drawable = this.Y) == null) {
            return;
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.Y.getIntrinsicHeight());
        this.Y.draw(canvas);
    }

    private static String Z(int i3) {
        if (i3 == 1) {
            return "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_widget_vip_nameplate_1.png";
        }
        if (i3 == 2) {
            return "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_widget_vip_nameplate_2.png";
        }
        if (i3 == 3) {
            return "https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_widget_vip_nameplate_3.png";
        }
        return "";
    }

    public boolean h0(Object obj) {
        if (obj != null && (obj instanceof WidgetVisitorsData)) {
            WidgetVisitorsData widgetVisitorsData = this.f48968h;
            if (widgetVisitorsData == null) {
                this.I = true;
                return true;
            }
            this.I = ((WidgetVisitorsData) obj).namePlateFlag != widgetVisitorsData.namePlateFlag;
            return !widgetVisitorsData.equals(obj);
        }
        this.I = false;
        return false;
    }

    private static String a0(int i3) {
        if (i3 < 100000) {
            return String.valueOf(i3);
        }
        int i16 = i3 / 1000;
        if (i3 % 1000 >= 500) {
            i16++;
        }
        int i17 = i16 % 10;
        if (i17 == 0) {
            return (i16 / 10) + "\u4e07";
        }
        return (i16 / 10) + "." + i17 + "\u4e07";
    }

    private void f0(float f16) {
        if (f16 == 0.0f) {
            PLog.d("VisitorWidget", "initUnReadAnimation height = 0");
            return;
        }
        if (this.O == null) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new com.qzone.module.personalitycomponent.entity.b(), new PointF(0.0f, 0.0f), new PointF(0.0f, f16));
            this.O = ofObject;
            ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qzone.module.personalitycomponent.coverWidget.h
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    j.this.l0(valueAnimator);
                }
            });
            this.O.setDuration(1000L);
            this.O.start();
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements ImageLoader.ImageLoadListener {
        a() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            j.this.E = drawable;
            j.this.t();
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class d implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        private final int f48997d;

        /* renamed from: e, reason: collision with root package name */
        private final WeakReference<j> f48998e;

        public d(j jVar, int i3) {
            this.f48998e = new WeakReference<>(jVar);
            this.f48997d = i3;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            int i3;
            j jVar = this.f48998e.get();
            if (drawable == null || jVar == null) {
                return;
            }
            ArrayList arrayList = jVar.W;
            int i16 = jVar.f48989w;
            int i17 = this.f48997d;
            if (i17 < 0 || i17 >= arrayList.size()) {
                return;
            }
            if (str.contains(((WidgetVisitorsData.WidgetVistor) arrayList.get(this.f48997d)).uin + "")) {
                Bitmap a16 = ab.a(drawable, i16, i16);
                Bitmap[] bitmapArr = jVar.Q;
                if (bitmapArr != null && (i3 = this.f48997d) < bitmapArr.length) {
                    bitmapArr[i3] = a16;
                }
                if (jVar.g0()) {
                    jVar.t();
                }
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }
}
