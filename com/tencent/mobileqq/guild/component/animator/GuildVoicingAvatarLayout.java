package com.tencent.mobileqq.guild.component.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.ViewCompat;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildVoicingAvatarLayout extends LinearLayout implements Handler.Callback {
    protected int C;
    private int D;
    private final List<View> E;
    private int F;
    private int G;
    private boolean H;
    private int I;
    private boolean J;
    private ValueAnimator K;
    protected boolean L;
    private final Runnable M;
    private final d N;
    private d P;

    /* renamed from: d, reason: collision with root package name */
    private String f215562d;

    /* renamed from: e, reason: collision with root package name */
    private int f215563e;

    /* renamed from: f, reason: collision with root package name */
    private int f215564f;

    /* renamed from: h, reason: collision with root package name */
    private int f215565h;

    /* renamed from: i, reason: collision with root package name */
    private int f215566i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f215567m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QLog.d("GuildVoicingAvatarLayout", 2, "Loop -- onAnimationEnd");
            int i3 = GuildVoicingAvatarLayout.this.F + GuildVoicingAvatarLayout.this.G;
            ViewCompat.setTranslationZ(GuildVoicingAvatarLayout.this.p(i3), 0.0f);
            GuildVoicingAvatarLayout guildVoicingAvatarLayout = GuildVoicingAvatarLayout.this;
            View childAt = guildVoicingAvatarLayout.getChildAt(guildVoicingAvatarLayout.F);
            childAt.setVisibility(8);
            GuildVoicingAvatarLayout guildVoicingAvatarLayout2 = GuildVoicingAvatarLayout.this;
            guildVoicingAvatarLayout2.removeViewAt(guildVoicingAvatarLayout2.F);
            GuildVoicingAvatarLayout.this.E.remove(childAt);
            GuildVoicingAvatarLayout.this.addView(childAt, i3);
            GuildVoicingAvatarLayout.this.E.add(i3, childAt);
            for (int i16 = GuildVoicingAvatarLayout.this.F; i16 <= i3; i16++) {
                GuildVoicingAvatarLayout.this.p(i16).setTranslationX(0.0f);
            }
            GuildVoicingAvatarLayout.this.H = false;
            if (GuildVoicingAvatarLayout.this.J) {
                QLog.d("GuildVoicingAvatarLayout", 2, "Loop -- should update");
                GuildVoicingAvatarLayout guildVoicingAvatarLayout3 = GuildVoicingAvatarLayout.this;
                guildVoicingAvatarLayout3.t(guildVoicingAvatarLayout3.P.f215574d, GuildVoicingAvatarLayout.this.P.f215575e);
                GuildVoicingAvatarLayout.this.B();
                return;
            }
            QLog.d("GuildVoicingAvatarLayout", 2, "Loop -- next loop");
            if (!GuildVoicingAvatarLayout.this.P.f215573c.isEmpty()) {
                GuildVoicingAvatarLayout guildVoicingAvatarLayout4 = GuildVoicingAvatarLayout.this;
                guildVoicingAvatarLayout4.I = (guildVoicingAvatarLayout4.I + 1) % GuildVoicingAvatarLayout.this.P.f215573c.size();
                GuildVoicingAvatarLayout.this.B();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            QLog.d("GuildVoicingAvatarLayout " + GuildVoicingAvatarLayout.this.f215562d, 2, "Loop -- onAnimationStart, loopIndex=" + GuildVoicingAvatarLayout.this.I);
            GuildVoicingAvatarLayout.this.H = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static abstract class c<T extends e, D> extends d<View, D> {

        /* renamed from: f, reason: collision with root package name */
        private static final int f215570f = 2131370542;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout.d
        public final void f(View view, D d16) {
            e eVar = (e) view.getTag(f215570f);
            if (eVar != null) {
                k(eVar, d16);
                return;
            }
            throw new IllegalStateException("no ViewHolder in " + view);
        }

        @Override // com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout.d
        public final View g(View view) {
            T l3 = l((ViewGroup) view);
            l3.a().setTag(f215570f, l3);
            return l3.a();
        }

        public abstract void k(T t16, D d16);

        public abstract T l(ViewGroup viewGroup);
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private final View f215576a;

        public e(View view) {
            this.f215576a = view;
        }

        public View a() {
            return this.f215576a;
        }
    }

    public GuildVoicingAvatarLayout(Context context) {
        super(context);
        this.f215562d = "";
        this.E = new ArrayList();
        this.L = true;
        this.M = new Runnable() { // from class: com.tencent.mobileqq.guild.component.animator.h
            @Override // java.lang.Runnable
            public final void run() {
                GuildVoicingAvatarLayout.this.r();
            }
        };
        a aVar = new a();
        this.N = aVar;
        this.P = aVar;
    }

    private boolean A() {
        if (this.G <= 1) {
            return false;
        }
        if (this.f215567m) {
            if (this.P.f215573c.size() < this.f215565h - this.F) {
                return false;
            }
            return true;
        }
        if (this.P.f215573c.size() <= this.G) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        boolean A = A();
        QLog.d("GuildVoicingAvatarLayout", 2, "startLoopAnimationIfNeed: shouldLoop = " + A);
        if (A) {
            z();
            postDelayed(this.M, this.f215563e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void r() {
        if (this.K == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.K = ofFloat;
            ofFloat.setDuration(this.f215564f);
            this.K.setInterpolator(new AccelerateDecelerateInterpolator());
            this.K.addListener(new b());
            this.K.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.component.animator.i
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    GuildVoicingAvatarLayout.this.s(valueAnimator);
                }
            });
        }
        this.K.start();
    }

    private void D() {
        removeCallbacks(this.M);
        ValueAnimator valueAnimator = this.K;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View p(int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        for (int size = this.E.size(); size <= i3; size++) {
            View g16 = this.P.g(this);
            ViewGroup.LayoutParams layoutParams = g16.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            } else if (layoutParams instanceof ViewGroup.LayoutParams) {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
            } else {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            }
            marginLayoutParams.rightMargin = this.f215566i;
            this.E.add(g16);
            addView(g16, marginLayoutParams);
        }
        return this.E.get(i3);
    }

    private void q() {
        int i3;
        for (int i16 = 0; i16 < this.F; i16++) {
            View p16 = p(i16);
            d dVar = this.P;
            dVar.f(p16, dVar.f215572b.get(i16));
            p16.setVisibility(0);
            if (this.L) {
                this.P.h(p16);
            } else {
                this.P.i(p16);
            }
        }
        int i17 = 0;
        while (true) {
            i3 = this.G;
            if (i17 >= i3) {
                break;
            }
            int size = (this.I + i17) % this.P.f215573c.size();
            View p17 = p(this.F + i17);
            d dVar2 = this.P;
            dVar2.f(p17, dVar2.f215573c.get(size));
            this.P.i(p17);
            p17.setVisibility(0);
            i17++;
        }
        for (int i18 = this.F + i3; i18 < this.E.size(); i18++) {
            View p18 = p(i18);
            this.P.i(p18);
            p18.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View p16 = p(this.F);
        float f16 = 1.0f - floatValue;
        p16.setScaleX(f16);
        p16.setScaleY(f16);
        p16.setAlpha(f16);
        int i3 = this.F;
        while (true) {
            i3++;
            int i16 = this.F;
            int i17 = this.G;
            if (i3 < i16 + i17) {
                p(i3).setTranslationX((-this.D) * floatValue);
            } else {
                View p17 = p(i16 + i17);
                p17.setVisibility(0);
                p17.setScaleX(floatValue);
                p17.setScaleY(floatValue);
                p17.setAlpha(floatValue);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(List list, List list2) {
        this.J = false;
        u(list, list2);
        q();
        w(this.F + this.G);
    }

    private void u(List list, List list2) {
        if (list != null && !list.isEmpty()) {
            this.F = Math.min(list.size(), this.f215565h);
            this.P.f215572b.clear();
            for (int i3 = 0; i3 < this.F; i3++) {
                this.P.f215572b.add(list.get(i3));
            }
        } else {
            this.F = 0;
            this.P.f215572b.clear();
        }
        int i16 = this.f215565h - this.F;
        if (list2 != null && !list2.isEmpty() && i16 > 0) {
            this.P.f215573c.clear();
            this.P.f215573c.addAll(list2);
            this.G = Math.min(i16, list2.size());
        } else {
            this.G = 0;
            this.P.f215573c.clear();
        }
        if (this.P.f215572b.size() + this.P.f215573c.size() <= this.f215565h) {
            this.I = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        d dVar = this.P;
        if (dVar != null && dVar != this.N) {
            if (!this.H) {
                D();
                t(this.P.f215574d, this.P.f215575e);
                B();
                return;
            }
            this.J = true;
        }
    }

    private void w(int i3) {
        Iterator<View> it = this.E.iterator();
        while (it.hasNext()) {
            ((LinearLayout.LayoutParams) it.next().getLayoutParams()).rightMargin = this.f215566i;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        int i16 = this.C * i3;
        int i17 = this.f215566i;
        int i18 = i16 + ((i3 - 1) * i17);
        layoutParams.width = i18;
        layoutParams.width = i18 + Math.max(0, i17);
        setLayoutParams(layoutParams);
    }

    private void z() {
        int size = (this.I + this.G) % this.P.f215573c.size();
        View p16 = p(this.F + this.G);
        d dVar = this.P;
        dVar.f(p16, dVar.f215573c.get(size));
        ViewCompat.setTranslationZ(p16, -1.0f);
        p16.setTranslationX(-this.D);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what == 1) {
            r();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.L) {
            y(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.L) {
            y(false);
        }
    }

    public void setAdapter(@NonNull d dVar) {
        dVar.f215571a = this;
        this.P = dVar;
        t(dVar.f215574d, dVar.f215575e);
    }

    public void setAnimateEnable(boolean z16) {
        if (z16 == this.L) {
            return;
        }
        this.L = z16;
        y(z16);
    }

    public void setAvatarSize(int i3) {
        this.C = i3;
        this.D = this.f215566i + i3;
        t(this.P.f215574d, this.P.f215575e);
    }

    public void setAvatarSizeAndHorizontalSpacing(int i3, int i16) {
        this.C = i3;
        this.f215566i = i16;
        this.D = i16 + i3;
        t(this.P.f215574d, this.P.f215575e);
    }

    public void setCurrentScene(String str) {
        this.f215562d = str;
    }

    public void setHorizontalSpacing(int i3) {
        this.f215566i = i3;
        this.D = i3 + this.C;
        t(this.P.f215574d, this.P.f215575e);
    }

    public void setLoopAnimationDuration(int i3) {
        this.f215563e = i3;
    }

    public void setLoopDelayMs(int i3) {
        this.f215564f = i3;
    }

    public void setLoopWhenAudiencePositionEqualsAudienceCount(boolean z16) {
        boolean A = A();
        this.f215567m = z16;
        if (A == A()) {
            return;
        }
        if (A()) {
            B();
        } else {
            D();
        }
    }

    public void setMaxAvatarCount(int i3) {
        this.f215565h = i3;
    }

    @UiThread
    public void x() {
        QLog.d("GuildVoicingAvatarLayout", 2, "resetStatus: tag=" + getTag());
        D();
        for (int i3 = 0; i3 < this.E.size(); i3++) {
            View p16 = p(i3);
            this.P.i(p16);
            p16.setTranslationX(0.0f);
            p16.setAlpha(1.0f);
            p16.setScaleX(1.0f);
            p16.setScaleY(1.0f);
        }
        this.P.f215572b.clear();
        this.P.f215573c.clear();
        this.F = 0;
        this.G = 0;
        this.J = false;
        this.H = false;
        this.I = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y(boolean z16) {
        if (this.P == null) {
            return;
        }
        for (int i3 = 0; i3 < this.P.f215572b.size(); i3++) {
            View p16 = p(i3);
            if (z16) {
                this.P.h(p16);
            } else {
                this.P.i(p16);
            }
        }
        if (z16) {
            v();
        } else {
            x();
        }
    }

    public GuildVoicingAvatarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f215562d = "";
        this.E = new ArrayList();
        this.L = true;
        this.M = new Runnable() { // from class: com.tencent.mobileqq.guild.component.animator.h
            @Override // java.lang.Runnable
            public final void run() {
                GuildVoicingAvatarLayout.this.r();
            }
        };
        a aVar = new a();
        this.N = aVar;
        this.P = aVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.guild.component.b.f215703m1);
        this.f215565h = obtainStyledAttributes.getInteger(com.tencent.mobileqq.guild.component.b.f215736r1, 8);
        this.f215563e = obtainStyledAttributes.getInteger(com.tencent.mobileqq.guild.component.b.f215715o1, 500);
        this.f215564f = obtainStyledAttributes.getInteger(com.tencent.mobileqq.guild.component.b.f215722p1, ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID);
        this.C = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.guild.component.b.f215743s1, kotlin.g.c(this, 22.0f));
        this.f215566i = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.guild.component.b.f215709n1, kotlin.g.c(this, 2.0f));
        this.f215567m = obtainStyledAttributes.getBoolean(com.tencent.mobileqq.guild.component.b.f215729q1, false);
        obtainStyledAttributes.recycle();
        this.D = this.f215566i + this.C;
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static abstract class d<T extends View, D> {

        /* renamed from: a, reason: collision with root package name */
        private GuildVoicingAvatarLayout f215571a;

        /* renamed from: b, reason: collision with root package name */
        private final List<D> f215572b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        private final List<D> f215573c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        private List<D> f215574d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        private List<D> f215575e = new ArrayList();

        public abstract void f(T t16, D d16);

        public abstract T g(View view);

        public void j(@NonNull List<D> list, @NonNull List<D> list2) {
            if (QLog.isColorLevel() || QLog.isDebugVersion() || QLog.isDevelopLevel()) {
                QLog.d("GuildVoicingAvatarLayout", 1, "setData: voicingAvatarsSize=" + list.size() + ", audienceAvatarsSize=" + list2.size());
            }
            this.f215574d.clear();
            this.f215574d.addAll(list);
            this.f215575e.clear();
            this.f215575e.addAll(list2);
            GuildVoicingAvatarLayout guildVoicingAvatarLayout = this.f215571a;
            if (guildVoicingAvatarLayout != null) {
                if (guildVoicingAvatarLayout.L) {
                    guildVoicingAvatarLayout.v();
                } else {
                    guildVoicingAvatarLayout.x();
                    this.f215571a.t(this.f215574d, this.f215575e);
                }
            }
        }

        public void h(T t16) {
        }

        public void i(T t16) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends d {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout.d
        public View g(View view) {
            throw new IllegalStateException("should never be invoked!!!");
        }

        @Override // com.tencent.mobileqq.guild.component.animator.GuildVoicingAvatarLayout.d
        public void f(View view, @Nullable Object obj) {
        }
    }
}
