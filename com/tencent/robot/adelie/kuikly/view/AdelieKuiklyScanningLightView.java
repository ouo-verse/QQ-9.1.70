package com.tencent.robot.adelie.kuikly.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.UiThread;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import i01.b;
import i01.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0006B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/adelie/kuikly/view/AdelieKuiklyScanningLightView;", "Landroid/widget/FrameLayout;", "Li01/c;", "", "propValue", "", "a", "", "propKey", "b", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "d", "Lcom/tencent/mobileqq/guild/component/animator/ScanningLightView;", "scanningLightView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "e", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieKuiklyScanningLightView extends FrameLayout implements c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ScanningLightView scanningLightView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieKuiklyScanningLightView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        ScanningLightView scanningLightView = new ScanningLightView(context, null, 2, null);
        this.scanningLightView = scanningLightView;
        addView(scanningLightView, new RelativeLayout.LayoutParams(-1, -1));
    }

    private final boolean a(Object propValue) {
        Intrinsics.checkNotNull(propValue, "null cannot be cast to non-null type kotlin.String");
        String str = (String) propValue;
        switch (str.hashCode()) {
            case -1980008475:
                if (str.equals("category_other_tab")) {
                    this.scanningLightView.setImageResource(R.drawable.j4f);
                    return true;
                }
                return true;
            case -1511774491:
                if (str.equals("creative_center")) {
                    this.scanningLightView.setImageResource(R.drawable.j3r);
                    return true;
                }
                return true;
            case 338517888:
                if (str.equals("category_home")) {
                    this.scanningLightView.setImageResource(R.drawable.j4e);
                    return true;
                }
                return true;
            case 1227739105:
                if (str.equals("manager_page")) {
                    this.scanningLightView.setImageResource(R.drawable.j4b);
                    return true;
                }
                return true;
            default:
                return true;
        }
    }

    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        if (Intrinsics.areEqual(propKey, "scene")) {
            return a(propValue);
        }
        return c.a.p(this, propKey, propValue);
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        return c.a.a(this, str, obj, function1);
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup viewGroup) {
        c.a.l(this, viewGroup);
    }

    @Override // i01.c
    @NotNull
    public View f() {
        return c.a.r(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // i01.c
    @UiThread
    public void h() {
        c.a.n(this);
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup viewGroup) {
        c.a.i(this, viewGroup);
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String str) {
        return c.a.m(this, str);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull b bVar) {
        c.a.q(this, bVar);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable String str2, @Nullable Function1<Object, Unit> function1) {
        return c.a.b(this, str, str2, function1);
    }
}
