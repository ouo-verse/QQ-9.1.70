package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;

/* loaded from: classes20.dex */
public class FriendPermissionsSwitch extends FrameLayout implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private View C;
    private View D;
    private boolean E;
    private boolean F;
    private boolean G;
    private boolean H;
    private int I;
    private boolean J;
    RelativeLayout K;
    RelativeLayout L;

    /* renamed from: d, reason: collision with root package name */
    private final Context f315677d;

    /* renamed from: e, reason: collision with root package name */
    private View f315678e;

    /* renamed from: f, reason: collision with root package name */
    private View f315679f;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f315680h;

    /* renamed from: i, reason: collision with root package name */
    private Switch f315681i;

    /* renamed from: m, reason: collision with root package name */
    private Switch f315682m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a extends AccessibilityDelegateCompat {
        a() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setSelected(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FriendPermissionsSwitch friendPermissionsSwitch = FriendPermissionsSwitch.this;
            friendPermissionsSwitch.n(friendPermissionsSwitch.f315681i);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            FriendPermissionsSwitch friendPermissionsSwitch = FriendPermissionsSwitch.this;
            friendPermissionsSwitch.n(friendPermissionsSwitch.f315682m);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class e extends Animation {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f315688d;

        e(View view) {
            this.f315688d = view;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f16, Transformation transformation) {
            if (f16 == 1.0f) {
                this.f315688d.getLayoutParams().height = FriendPermissionsSwitch.this.I;
                this.f315688d.setAlpha(1.0f);
            } else {
                this.f315688d.getLayoutParams().height = (int) (FriendPermissionsSwitch.this.I * f16);
                this.f315688d.setAlpha(f16);
            }
            this.f315688d.requestLayout();
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class g extends Animation {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f315692d;

        g(View view) {
            this.f315692d = view;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f16, Transformation transformation) {
            if (f16 == 1.0f) {
                this.f315692d.getLayoutParams().height = FriendPermissionsSwitch.this.I;
                this.f315692d.setAlpha(1.0f);
            } else {
                this.f315692d.getLayoutParams().height = FriendPermissionsSwitch.this.I - ((int) (FriendPermissionsSwitch.this.I * f16));
                this.f315692d.setAlpha(((1.0f - f16) * 2.0f) / 3.0f);
            }
            this.f315692d.requestLayout();
        }

        @Override // android.view.animation.Animation
        public boolean willChangeBounds() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class h extends AccessibilityDelegateCompat {
        h() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setSelected(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class i extends AccessibilityDelegateCompat {
        i() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setSelected(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class j extends AccessibilityDelegateCompat {
        j() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setSelected(true);
        }
    }

    public FriendPermissionsSwitch(@NonNull Context context) {
        this(context, null);
    }

    private void e() {
        if (QQTheme.isNowThemeIsNight()) {
            findViewById(R.id.ujw).setBackgroundColor(Color.parseColor("#3D3D41"));
            findViewById(R.id.ujx).setBackgroundColor(Color.parseColor("#3D3D41"));
            findViewById(R.id.f68953hf).setBackgroundResource(R.drawable.lez);
            findViewById(R.id.f68903ha).setBackgroundResource(R.drawable.lev);
            findViewById(R.id.f68883h9).setBackgroundResource(R.drawable.let);
            findViewById(R.id.f68933hd).setBackgroundResource(R.drawable.ley);
        }
    }

    private void f(View view, Animation.AnimationListener animationListener) {
        if (view == null) {
            return;
        }
        g gVar = new g(view);
        if (animationListener != null) {
            gVar.setAnimationListener(animationListener);
        }
        gVar.setDuration(300L);
        view.startAnimation(gVar);
    }

    private void g(View view, Animation.AnimationListener animationListener) {
        if (view == null) {
            return;
        }
        e eVar = new e(view);
        if (animationListener != null) {
            eVar.setAnimationListener(animationListener);
        }
        eVar.setDuration(300L);
        view.startAnimation(eVar);
    }

    private void k() {
        r();
        this.f315679f.setVisibility(0);
        this.f315678e.setVisibility(8);
        l(this.f315680h);
    }

    private void l(View view) {
        if (view == null) {
            return;
        }
        f(view, new f(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(Switch r26) {
        if (r26 != null && r26.getVisibility() == 0) {
            r26.setChecked(!r26.isChecked());
        }
    }

    private void p() {
        s();
        this.f315679f.setVisibility(8);
        this.f315678e.setVisibility(0);
        q(this.f315680h);
    }

    private void q(View view) {
        if (view == null) {
            return;
        }
        g(view, new d(view));
    }

    private void r() {
        ViewCompat.setAccessibilityDelegate(this.K, new h());
        ViewCompat.setAccessibilityDelegate(this.L, new i());
    }

    private void s() {
        ViewCompat.setAccessibilityDelegate(this.K, new j());
        ViewCompat.setAccessibilityDelegate(this.L, new a());
    }

    public int h() {
        if (this.H) {
            return 1;
        }
        boolean z16 = this.F;
        if (z16 && this.G) {
            return 2;
        }
        if (z16) {
            return 3;
        }
        if (!this.G) {
            return 2;
        }
        return 4;
    }

    public int i() {
        boolean z16 = this.H;
        boolean z17 = this.F;
        boolean z18 = this.G;
        if (z16) {
            return z16 ? 1 : 0;
        }
        return ((z17 ? 1 : 0) << 1) + ((z18 ? 1 : 0) << 2);
    }

    public void j() {
        findViewById(R.id.f239807w).setVisibility(8);
    }

    public void m() {
        View inflate = LayoutInflater.from(this.f315677d).inflate(R.layout.f168810gx4, (ViewGroup) this, true);
        this.K = (RelativeLayout) inflate.findViewById(R.id.slx);
        this.L = (RelativeLayout) inflate.findViewById(R.id.ttz);
        this.f315678e = inflate.findViewById(R.id.slw);
        this.f315679f = inflate.findViewById(R.id.tty);
        this.K.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.f315680h = (LinearLayout) inflate.findViewById(R.id.f68993hj);
        this.f315681i = (Switch) inflate.findViewById(R.id.f68203fe);
        this.f315682m = (Switch) inflate.findViewById(R.id.f68353ft);
        this.f315681i.setOnCheckedChangeListener(this);
        this.f315682m.setOnCheckedChangeListener(this);
        s();
        this.C = inflate.findViewById(R.id.f68193fd);
        this.D = inflate.findViewById(R.id.f68343fs);
        if (com.tencent.mobileqq.util.ab.a() && AppSetting.f99565y) {
            TextView textView = (TextView) inflate.findViewById(R.id.f239807w);
            if (Build.VERSION.SDK_INT >= 28) {
                textView.setAccessibilityHeading(true);
            } else {
                textView.setContentDescription(HardCodeUtil.qqStr(R.string.f225506lt));
            }
            AccessibilityUtil.n(this.f315681i, false);
            AccessibilityUtil.n(this.f315682m, false);
            AccessibilityUtil.r(this.C, HardCodeUtil.qqStr(R.string.f2192065s), this.f315681i.isChecked());
            AccessibilityUtil.r(this.D, HardCodeUtil.qqStr(R.string.f2192765z), this.f315682m.isChecked());
            this.C.setOnClickListener(new b());
            this.D.setOnClickListener(new c());
        }
    }

    public void o() {
        findViewById(R.id.f239707v).setVisibility(8);
        findViewById(R.id.f68873h8).setVisibility(8);
        findViewById(R.id.ujx).setVisibility(8);
        findViewById(R.id.f68343fs).setVisibility(8);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (compoundButton == this.f315681i) {
            this.F = z16;
        } else if (compoundButton == this.f315682m) {
            this.G = z16;
        }
        if (com.tencent.mobileqq.util.ab.a() && AppSetting.f99565y) {
            AccessibilityUtil.r(this.C, HardCodeUtil.qqStr(R.string.f2192065s), this.f315681i.isChecked());
            AccessibilityUtil.r(this.D, HardCodeUtil.qqStr(R.string.f2192765z), this.f315682m.isChecked());
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.J) {
            this.J = false;
            this.I = this.f315680h.getMeasuredHeight();
        }
        int id5 = view.getId();
        if (id5 == R.id.slx) {
            if (!this.E) {
                this.H = false;
                this.E = true;
                this.F = false;
                this.G = false;
                this.f315681i.setChecked(false);
                this.f315682m.setChecked(false);
                p();
            }
        } else if (id5 == R.id.ttz) {
            this.H = true;
            this.E = false;
            k();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void t() {
        j();
        findViewById(R.id.iew).setBackgroundResource(R.drawable.bg_texture);
        findViewById(R.id.f68953hf).setVisibility(0);
        findViewById(R.id.f68903ha).setVisibility(0);
        findViewById(R.id.f68883h9).setVisibility(0);
        findViewById(R.id.f68933hd).setVisibility(0);
        findViewById(R.id.f68893h_).setPadding(ViewUtils.dpToPx(48.0f), 0, 0, 0);
        findViewById(R.id.f68943he).setPadding(ViewUtils.dpToPx(48.0f), 0, 0, 0);
        findViewById(R.id.f68913hb).setPadding(ViewUtils.dpToPx(48.0f), 0, 0, 0);
        findViewById(R.id.f69013hl).setPadding(ViewUtils.dpToPx(48.0f), 0, 0, 0);
        findViewById(R.id.f239707v).setBackgroundResource(R.drawable.f160055j35);
        findViewById(R.id.f126057nq).setBackgroundResource(R.drawable.f160055j35);
    }

    public FriendPermissionsSwitch(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FriendPermissionsSwitch(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.E = true;
        this.J = true;
        this.f315677d = context;
        m();
        e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class d implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f315686d;

        d(View view) {
            this.f315686d = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f315686d.setVisibility(0);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class f implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f315690d;

        f(View view) {
            this.f315690d = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f315690d.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
