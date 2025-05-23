package com.tencent.now.pkgame.pkgame.animation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.mobileqq.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AnimationView extends ConstraintLayout implements lo3.a {
    private e C;
    private a D;
    private Runnable E;

    /* renamed from: d, reason: collision with root package name */
    private LifecycleOwner f338947d;

    /* renamed from: e, reason: collision with root package name */
    private ViewModelProvider f338948e;

    /* renamed from: f, reason: collision with root package name */
    private View f338949f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f338950h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f338951i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f338952m;

    public AnimationView(@NonNull Context context, ViewModelProvider viewModelProvider, LifecycleOwner lifecycleOwner, FrameLayout.LayoutParams layoutParams) {
        super(context);
        this.D = new a();
        this.E = new Runnable() { // from class: com.tencent.now.pkgame.pkgame.animation.AnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AnimationView.this.J().Q1(new jo3.b());
            }
        };
        this.f338948e = viewModelProvider;
        this.f338947d = lifecycleOwner;
        B0(layoutParams);
        F0();
    }

    private void B0(FrameLayout.LayoutParams layoutParams) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.har, this);
        this.f338949f = inflate.findViewById(R.id.yme);
        this.f338950h = (ImageView) inflate.findViewById(R.id.f25410ar);
        this.f338951i = (ImageView) inflate.findViewById(R.id.f99825qu);
        this.f338952m = (ImageView) inflate.findViewById(R.id.t_l);
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f338949f.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = layoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = layoutParams.height;
        this.f338949f.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit C0(Boolean bool) {
        if (bool.booleanValue()) {
            E0();
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit D0(Boolean bool) {
        if (bool.booleanValue()) {
            this.f338951i.setVisibility(0);
            this.f338952m.setVisibility(0);
            this.D.d(this.f338951i, this.f338952m);
            return null;
        }
        this.f338951i.setVisibility(8);
        this.f338952m.setVisibility(8);
        return null;
    }

    private void E0() {
        a.a("https://nowpic.gtimg.com/feeds_pic/ajNVdqHZLLBkE0DpdMDvrCA31vaY71vGNk5MwkmyrIE2TjkJfeTWfQ/", this.f338950h);
        ThreadCenter.postDefaultUITask(this.E, 2000L);
    }

    public void F0() {
        e eVar = (e) this.f338948e.get(e.class);
        this.C = eVar;
        eVar.U1().observe(this.f338947d, new mo3.b(new Function1() { // from class: com.tencent.now.pkgame.pkgame.animation.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit C0;
                C0 = AnimationView.this.C0((Boolean) obj);
                return C0;
            }
        }));
        this.C.T1().observe(this.f338947d, new mo3.b(new Function1() { // from class: com.tencent.now.pkgame.pkgame.animation.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit D0;
                D0 = AnimationView.this.D0((Boolean) obj);
                return D0;
            }
        }));
    }

    @Override // lo3.a
    public mo3.d J() {
        return this.C;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ThreadCenter.removeDefaultUITask(this.E);
    }
}
