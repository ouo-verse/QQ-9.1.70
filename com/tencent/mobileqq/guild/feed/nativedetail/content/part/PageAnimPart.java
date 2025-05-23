package com.tencent.mobileqq.guild.feed.nativedetail.content.part;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.guild.feed.api.AnimationParams;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.VideoReport;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 )2\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u0016\u0010\u0013\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0016\u0010 \u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0019R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/PageAnimPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/guild/feed/api/AnimationParams;", "source", "", "E9", "F9", "G9", "", "D9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "onBackEvent", "", "getLogTag", "d", "Landroid/view/View;", "mTargetView", "e", "Z", "needFinishAnim", "", "f", UserInfo.SEX_FEMALE, "startScaleX", tl.h.F, "startScaleY", "i", "startTranslationX", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "startTranslationY", "Landroid/graphics/Rect;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/Rect;", "startClipBounds", "D", "endClipBounds", "<init>", "()V", "E", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class PageAnimPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View mTargetView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needFinishAnim;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float startTranslationX;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float startTranslationY;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float startScaleX = 1.0f;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float startScaleY = 1.0f;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private Rect startClipBounds = new Rect();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private Rect endClipBounds = new Rect();

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/part/PageAnimPart$b", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f221315d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ PageAnimPart f221316e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AnimationParams f221317f;

        b(View view, PageAnimPart pageAnimPart, AnimationParams animationParams) {
            this.f221315d = view;
            this.f221316e = pageAnimPart;
            this.f221317f = animationParams;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f221315d.getViewTreeObserver().removeOnPreDrawListener(this);
            PageAnimPart pageAnimPart = this.f221316e;
            View findViewById = this.f221315d.findViewById(R.id.a58);
            if (findViewById == null) {
                findViewById = this.f221315d;
            }
            pageAnimPart.mTargetView = findViewById;
            View view = this.f221316e.mTargetView;
            View view2 = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTargetView");
                view = null;
            }
            float widthSource = this.f221317f.getWidthSource();
            float heightSource = this.f221317f.getHeightSource();
            View view3 = this.f221316e.mTargetView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTargetView");
                view3 = null;
            }
            int width = view3.getWidth();
            View view4 = this.f221316e.mTargetView;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTargetView");
            } else {
                view2 = view4;
            }
            Log.e("AnimPart", "mTargetView=" + view + " source " + widthSource + " " + heightSource + " target " + width + " " + view2.getHeight());
            this.f221316e.E9(this.f221317f);
            this.f221316e.F9();
            return false;
        }
    }

    private final long D9() {
        return 200L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E9(AnimationParams source) {
        boolean z16;
        int width;
        float f16;
        int[] iArr = new int[2];
        View view = this.mTargetView;
        Float f17 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTargetView");
            view = null;
        }
        view.getLocationOnScreen(iArr);
        float f18 = iArr[0];
        boolean z17 = true;
        float f19 = iArr[1];
        Log.i("AnimPart", "initAnimationParams targetScreenX=" + f18 + " targetScreenY=" + f19);
        View view2 = this.mTargetView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTargetView");
            view2 = null;
        }
        Integer valueOf = Integer.valueOf(view2.getWidth());
        if (valueOf.intValue() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            valueOf = null;
        }
        if (valueOf != null) {
            width = valueOf.intValue();
        } else {
            width = getPartRootView().getWidth();
        }
        Float valueOf2 = Float.valueOf(f18);
        if (valueOf2.floatValue() < 0.0f) {
            z17 = false;
        }
        if (z17) {
            f17 = valueOf2;
        }
        if (f17 != null) {
            f16 = f17.floatValue();
        } else {
            f16 = 0.0f;
        }
        float widthSource = source.getWidthSource() / width;
        this.startScaleX = widthSource;
        this.startScaleY = widthSource;
        this.startTranslationX = source.getScreenX() - f16;
        this.startTranslationY = source.getScreenY() - f19;
        this.startClipBounds = new Rect(0, (int) f19, getPartRootView().getWidth(), (int) ((source.getLimitHeight() / this.startScaleY) + f19));
        this.endClipBounds = new Rect(0, 0, getPartRootView().getWidth(), getPartRootView().getHeight());
        View partRootView = getPartRootView();
        partRootView.setPivotX(0.0f);
        partRootView.setPivotY(f19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9() {
        View partRootView = getPartRootView();
        long D9 = D9();
        Float valueOf = Float.valueOf(this.startScaleX);
        Float valueOf2 = Float.valueOf(1.0f);
        Pair pair = TuplesKt.to(valueOf, valueOf2);
        Pair pair2 = TuplesKt.to(Float.valueOf(this.startScaleY), valueOf2);
        Float valueOf3 = Float.valueOf(this.startTranslationX);
        Float valueOf4 = Float.valueOf(0.0f);
        tl1.c.f(partRootView, D9, pair, pair2, TuplesKt.to(valueOf3, valueOf4), TuplesKt.to(Float.valueOf(this.startTranslationY), valueOf4), TuplesKt.to(this.startClipBounds, this.endClipBounds), TuplesKt.to(valueOf4, valueOf2), 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.PageAnimPart$startOpenAnim$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PageAnimPart.this.broadcastMessage("message_on_animation_ing", Boolean.TRUE);
                PageAnimPart.this.needFinishAnim = true;
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.PageAnimPart$startOpenAnim$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                VideoReport.traverseExposure();
                PageAnimPart.this.broadcastMessage("message_on_animation_ing", Boolean.FALSE);
            }
        }, 128, null);
    }

    private final void G9() {
        this.needFinishAnim = false;
        View partRootView = getPartRootView();
        Float valueOf = Float.valueOf(1.0f);
        Pair pair = TuplesKt.to(valueOf, Float.valueOf(this.startScaleX));
        Pair pair2 = TuplesKt.to(valueOf, Float.valueOf(this.startScaleY));
        Float valueOf2 = Float.valueOf(0.0f);
        tl1.c.f(partRootView, 0L, pair, pair2, TuplesKt.to(valueOf2, Float.valueOf(this.startTranslationX)), TuplesKt.to(valueOf2, Float.valueOf(this.startTranslationY)), TuplesKt.to(this.endClipBounds, this.startClipBounds), TuplesKt.to(valueOf, valueOf2), 133L, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.PageAnimPart$startReverseAnim$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PageAnimPart.this.broadcastMessage("message_on_animation_ing", Boolean.TRUE);
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.PageAnimPart$startReverseAnim$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Activity activity = PageAnimPart.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
                Activity activity2 = PageAnimPart.this.getActivity();
                if (activity2 != null) {
                    activity2.overridePendingTransition(0, 0);
                }
            }
        }, 1, null);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    public String getLogTag() {
        return "AnimPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (this.needFinishAnim) {
            G9();
            return true;
        }
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
            return true;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        AnimationParams animationParams;
        Intent intent;
        Intent intent2;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Activity activity = getActivity();
        boolean z16 = false;
        if (activity != null && (intent2 = activity.getIntent()) != null) {
            z16 = intent2.getBooleanExtra("jumpGuildFromLoadingPage", false);
        }
        Activity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            animationParams = (AnimationParams) intent.getParcelableExtra("feed_detail_animation_params");
        } else {
            animationParams = null;
        }
        if (animationParams == null) {
            if (getActivity() instanceof QPublicTransFragmentActivity) {
                broadcastMessage("message_on_animation_ing", Boolean.FALSE);
                return;
            }
            if (z16) {
                getActivity().overridePendingTransition(R.anim.l_, R.anim.l_);
            } else {
                getActivity().overridePendingTransition(R.anim.f154619or, R.anim.f154425m);
            }
            broadcastMessage("message_on_animation_ing", Boolean.FALSE);
            return;
        }
        rootView.getViewTreeObserver().addOnPreDrawListener(new b(rootView, this, animationParams));
    }
}
