package com.tencent.mobileqq.guild.window;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.util.bv;
import com.tencent.mobileqq.qqfloatingwindow.FloatingScreenParams;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.CommonMMKVUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "surfaceBitmap", "Landroid/graphics/Bitmap;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class GuildFloatWindowAnimKt$animToFloatWindow$1 extends Lambda implements Function1<Bitmap, Unit> {
    final /* synthetic */ Function0<Unit> $finishActivity;
    final /* synthetic */ View $fragView;
    final /* synthetic */ Function0<View> $showLiveFloat;
    final /* synthetic */ View $surfaceWrapper;
    final /* synthetic */ float $windowHeight;
    final /* synthetic */ float $windowWidth;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildFloatWindowAnimKt$animToFloatWindow$1(View view, View view2, float f16, float f17, Function0<? extends View> function0, Function0<Unit> function02) {
        super(1);
        this.$surfaceWrapper = view;
        this.$fragView = view2;
        this.$windowWidth = f16;
        this.$windowHeight = f17;
        this.$showLiveFloat = function0;
        this.$finishActivity = function02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [T, java.lang.Object] */
    public static final void d(View fragView, Function0 showLiveFloat, final ImageView imageViewForFloat, final View surfaceWrapper, RectRevealView rectClipView, int i3, int i16, int i17, int i18, ViewGroup rootView, float f16, Ref.FloatRef deltaX, Ref.FloatRef deltaY, final Function0 finishActivity) {
        Intrinsics.checkNotNullParameter(fragView, "$fragView");
        Intrinsics.checkNotNullParameter(showLiveFloat, "$showLiveFloat");
        Intrinsics.checkNotNullParameter(imageViewForFloat, "$imageViewForFloat");
        Intrinsics.checkNotNullParameter(surfaceWrapper, "$surfaceWrapper");
        Intrinsics.checkNotNullParameter(rectClipView, "$rectClipView");
        Intrinsics.checkNotNullParameter(rootView, "$rootView");
        Intrinsics.checkNotNullParameter(deltaX, "$deltaX");
        Intrinsics.checkNotNullParameter(deltaY, "$deltaY");
        Intrinsics.checkNotNullParameter(finishActivity, "$finishActivity");
        View findViewById = ((ViewGroup) fragView).findViewById(R.id.f909053q);
        if (findViewById != null) {
            ViewParent parent = findViewById.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(findViewById);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = showLiveFloat.invoke();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = 0;
        T t16 = objectRef.element;
        Intrinsics.checkNotNull(t16, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) t16).addView(imageViewForFloat, layoutParams);
        ViewGroup viewGroup = (ViewGroup) surfaceWrapper;
        Object systemService = viewGroup.getRootView().getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ViewGroup.LayoutParams layoutParams2 = viewGroup.getRootView().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
        WindowManager.LayoutParams layoutParams3 = (WindowManager.LayoutParams) layoutParams2;
        layoutParams3.alpha = 0.0f;
        ((WindowManager) systemService).updateViewLayout(viewGroup.getRootView(), layoutParams3);
        rectClipView.d(i3, i16, i17, i18, 300L);
        rootView.animate().scaleXBy(f16 - 1).scaleYBy(f16 - 1.0f).translationXBy(deltaX.element).translationYBy(deltaY.element).setDuration(300L).withEndAction(new Runnable() { // from class: com.tencent.mobileqq.guild.window.h
            @Override // java.lang.Runnable
            public final void run() {
                GuildFloatWindowAnimKt$animToFloatWindow$1.e(Function0.this, objectRef, surfaceWrapper, imageViewForFloat);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void e(Function0 finishActivity, Ref.ObjectRef floatWindowView, View surfaceWrapper, final ImageView imageViewForFloat) {
        Intrinsics.checkNotNullParameter(finishActivity, "$finishActivity");
        Intrinsics.checkNotNullParameter(floatWindowView, "$floatWindowView");
        Intrinsics.checkNotNullParameter(surfaceWrapper, "$surfaceWrapper");
        Intrinsics.checkNotNullParameter(imageViewForFloat, "$imageViewForFloat");
        finishActivity.invoke();
        T t16 = floatWindowView.element;
        Intrinsics.checkNotNull(t16);
        if (((ViewGroup) t16).getRootView().getLayoutParams() instanceof WindowManager.LayoutParams) {
            T t17 = floatWindowView.element;
            Intrinsics.checkNotNull(t17);
            ViewGroup.LayoutParams layoutParams = ((ViewGroup) t17).getRootView().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
            WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) layoutParams;
            layoutParams2.alpha = 1.0f;
            Object systemService = ((ViewGroup) surfaceWrapper).getRootView().getContext().getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            T t18 = floatWindowView.element;
            Intrinsics.checkNotNull(t18);
            ((WindowManager) systemService).updateViewLayout(((ViewGroup) t18).getRootView(), layoutParams2);
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.window.i
            @Override // java.lang.Runnable
            public final void run() {
                GuildFloatWindowAnimKt$animToFloatWindow$1.f(imageViewForFloat);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ImageView imageViewForFloat) {
        Intrinsics.checkNotNullParameter(imageViewForFloat, "$imageViewForFloat");
        imageViewForFloat.setVisibility(8);
        imageViewForFloat.setImageBitmap(null);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
        invoke2(bitmap);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull Bitmap surfaceBitmap) {
        boolean f16;
        Intrinsics.checkNotNullParameter(surfaceBitmap, "surfaceBitmap");
        View view = this.$surfaceWrapper;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        if (((ViewGroup) view).getChildCount() == 0) {
            return;
        }
        Boolean value = GLiveChannelCore.f226698a.t().J().getValue();
        if (value == null) {
            value = Boolean.TRUE;
        }
        boolean booleanValue = value.booleanValue();
        ViewParent parent = this.$fragView.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        final ViewGroup viewGroup = (ViewGroup) parent;
        int[] iArr = {-1, -1};
        ((ViewGroup) this.$surfaceWrapper).getChildAt(0).getLocationInWindow(iArr);
        final float width = (this.$windowWidth * 1.0f) / r5.getWidth();
        SharedPreferences fromSpAdapter = CommonMMKVUtils.fromSpAdapter(FloatingScreenParams.QQFS_SP_NAME);
        int i3 = fromSpAdapter.getInt("qqfs_floating_center_x", Integer.MIN_VALUE);
        int i16 = fromSpAdapter.getInt("qqfs_floating_center_y", Integer.MIN_VALUE);
        com.tencent.mobileqq.guild.safety.j.b("GuildFloatWindowAnim", "centerX: " + i3 + " | centerY: " + i16);
        int height = ((ViewGroup) this.$surfaceWrapper).getHeight();
        ((ViewGroup) this.$surfaceWrapper).getWidth();
        int height2 = viewGroup.getHeight();
        int width2 = viewGroup.getWidth();
        View view2 = this.$fragView;
        Intrinsics.checkNotNull(view2, "null cannot be cast to non-null type com.tencent.mobileqq.guild.window.RectRevealView");
        final RectRevealView rectRevealView = (RectRevealView) view2;
        ImageView imageView = new ImageView(((RectRevealView) this.$fragView).getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(((ViewGroup) this.$surfaceWrapper).getWidth(), ((ViewGroup) this.$surfaceWrapper).getHeight());
        layoutParams.topMargin = iArr[1];
        layoutParams.gravity = 48;
        imageView.setImageBitmap(surfaceBitmap);
        rectRevealView.addView(imageView, layoutParams);
        final ImageView imageView2 = new ImageView(BaseApplication.getContext());
        imageView2.setImageBitmap(surfaceBitmap);
        viewGroup.setPivotX(0.0f);
        viewGroup.setPivotY(0.0f);
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        float f17 = 2;
        floatRef.element = (i3 - (this.$windowWidth / f17)) + ((width2 * 1.0f) / f17);
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        float c16 = (((i16 - (this.$windowHeight / f17)) + (height2 / 2)) - (iArr[1] * width)) + (bv.c(QBaseActivity.sTopActivity) * width);
        floatRef2.element = c16;
        if (booleanValue) {
            floatRef2.element = c16 + 10;
        } else {
            floatRef.element -= iArr[0] * width;
            f16 = GuildFloatWindowAnimKt.f();
            if (f16) {
                floatRef2.element -= 8;
            } else {
                floatRef2.element -= 50;
            }
        }
        final int i17 = iArr[1];
        final int i18 = (height2 - i17) - height;
        final int i19 = iArr[0];
        final View view3 = this.$fragView;
        final Function0<View> function0 = this.$showLiveFloat;
        final View view4 = this.$surfaceWrapper;
        final Function0<Unit> function02 = this.$finishActivity;
        rectRevealView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.window.g
            @Override // java.lang.Runnable
            public final void run() {
                GuildFloatWindowAnimKt$animToFloatWindow$1.d(view3, function0, imageView2, view4, rectRevealView, i19, i17, i19, i18, viewGroup, width, floatRef, floatRef2, function02);
            }
        }, 20L);
    }
}
