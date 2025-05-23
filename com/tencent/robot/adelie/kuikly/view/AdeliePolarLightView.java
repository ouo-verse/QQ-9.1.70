package com.tencent.robot.adelie.kuikly.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.UiThread;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.robot.adelie.homepage.create.sound.AdelieTtsPageBkgView;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import i01.b;
import i01.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u0006B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016JI\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072+\u0010\u0012\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\fj\u0004\u0018\u0001`\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/robot/adelie/kuikly/view/AdeliePolarLightView;", "Landroid/widget/FrameLayout;", "Li01/c;", "", "propValue", "", "a", "", "propKey", "b", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/robot/adelie/homepage/create/sound/AdelieTtsPageBkgView;", "d", "Lcom/tencent/robot/adelie/homepage/create/sound/AdelieTtsPageBkgView;", "polarLightView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "e", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdeliePolarLightView extends FrameLayout implements c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AdelieTtsPageBkgView polarLightView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdeliePolarLightView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        AdelieTtsPageBkgView adelieTtsPageBkgView = new AdelieTtsPageBkgView(context, null, 0, 6, null);
        this.polarLightView = adelieTtsPageBkgView;
        adelieTtsPageBkgView.a();
        addView(adelieTtsPageBkgView, new RelativeLayout.LayoutParams(-1, -1));
    }

    private final boolean a(Object propValue) {
        return true;
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
        this.polarLightView.b();
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
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        if (Intrinsics.areEqual(method, QZoneJsConstants.ACTION_START_ANIMATION)) {
            this.polarLightView.g();
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(method, "stopAnimation")) {
            this.polarLightView.h();
            return Unit.INSTANCE;
        }
        return c.a.b(this, method, params, callback);
    }
}
