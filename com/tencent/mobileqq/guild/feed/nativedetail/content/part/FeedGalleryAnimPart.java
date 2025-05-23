package com.tencent.mobileqq.guild.feed.nativedetail.content.part;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.api.AnimationParams;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010!\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001cR\u0016\u0010#\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001cR\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/FeedGalleryAnimPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/mobileqq/guild/feed/api/AnimationParams;", "source", "", "F9", "", "J9", "H9", "I9", "", "E9", "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onBackEvent", "", "getLogTag", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "mTargetView", "e", "Z", "needFinishAnim", "", "f", UserInfo.SEX_FEMALE, "startScaleX", tl.h.F, "startScaleY", "i", "startTranslationX", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "startTranslationY", "Landroid/graphics/Rect;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/graphics/Rect;", "startClipBounds", "D", "endClipBounds", "", "E", "I", NodeProps.MARGIN_BOTTOM, "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedGalleryAnimPart extends Part {

    /* renamed from: E, reason: from kotlin metadata */
    private int marginBottom;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView mTargetView;

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

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/content/part/FeedGalleryAnimPart$b", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f221300d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ FeedGalleryAnimPart f221301e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AnimationParams f221302f;

        b(View view, FeedGalleryAnimPart feedGalleryAnimPart, AnimationParams animationParams) {
            this.f221300d = view;
            this.f221301e = feedGalleryAnimPart;
            this.f221302f = animationParams;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f221300d.getViewTreeObserver().removeOnPreDrawListener(this);
            FeedGalleryAnimPart feedGalleryAnimPart = this.f221301e;
            ImageView imageView = (ImageView) this.f221300d.findViewById(R.id.wcn);
            if (imageView != null) {
                feedGalleryAnimPart.mTargetView = imageView;
                float widthSource = this.f221302f.getWidthSource();
                float heightSource = this.f221302f.getHeightSource();
                ImageView imageView2 = this.f221301e.mTargetView;
                ImageView imageView3 = null;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTargetView");
                    imageView2 = null;
                }
                int width = imageView2.getWidth();
                ImageView imageView4 = this.f221301e.mTargetView;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTargetView");
                } else {
                    imageView3 = imageView4;
                }
                Log.e("FeedGalleryAnimPart", "source " + widthSource + " " + heightSource + " target " + width + " " + imageView3.getHeight());
                this.f221301e.F9(this.f221302f);
                this.f221301e.H9();
                return false;
            }
            return true;
        }
    }

    private final long E9() {
        return 200L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9(AnimationParams source) {
        boolean z16;
        boolean z17;
        float coerceAtLeast;
        QLog.i("FeedGalleryAnimPart", 1, "initAnimationParamsV2 sourceScreenX=" + source.getScreenX() + " sourceScreenY=" + source.getScreenY() + " sourceWidth=" + source.getWidthSource() + " sourHeight=" + source.getHeightSource());
        com.tencent.mobileqq.guild.feed.part.b bVar = com.tencent.mobileqq.guild.feed.part.b.f222545a;
        ImageView imageView = this.mTargetView;
        Number number = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTargetView");
            imageView = null;
        }
        RectF a16 = bVar.a(imageView);
        float f16 = a16.left;
        float f17 = a16.top;
        Number valueOf = Float.valueOf(a16.width());
        if (valueOf.floatValue() > 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            valueOf = null;
        }
        if (valueOf == null) {
            valueOf = Integer.valueOf(getPartRootView().getWidth());
        }
        Float valueOf2 = Float.valueOf(a16.height());
        if (valueOf2.floatValue() > 0.0f) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            number = valueOf2;
        }
        if (number == null) {
            number = Integer.valueOf(getPartRootView().getHeight());
        }
        QLog.i("FeedGalleryAnimPart", 1, "initAnimationParamsV2 targetScreenX=" + f16 + " targetScreenY=" + f17 + " targetDrawableWidth=" + valueOf + " targetDrawableHeight=" + number);
        float widthSource = source.getWidthSource() / valueOf.floatValue();
        float heightSource = source.getHeightSource() / number.floatValue();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(widthSource, heightSource);
        this.startScaleX = coerceAtLeast;
        this.startScaleY = coerceAtLeast;
        QLog.i("FeedGalleryAnimPart", 1, "initAnimationParamsV2 scaleW=" + widthSource + " scaleH=" + heightSource);
        float floatValue = valueOf.floatValue() - (source.getWidthSource() / coerceAtLeast);
        float f18 = (float) 2;
        float f19 = floatValue / f18;
        float floatValue2 = (number.floatValue() - (source.getHeightSource() / coerceAtLeast)) / f18;
        QLog.i("FeedGalleryAnimPart", 1, "initAnimationParamsV2 horizontalPadding=" + f19 + " verticalPadding=" + floatValue2);
        float f26 = (float) ((int) f16);
        float f27 = f26 + f19;
        float f28 = (float) ((int) f17);
        float f29 = (f28 + floatValue2) - ((float) this.marginBottom);
        this.startClipBounds = new Rect((int) f27, (int) f29, (int) ((source.getWidthSource() / coerceAtLeast) + f27), (int) ((source.getHeightSource() / coerceAtLeast) + f29));
        this.endClipBounds = new Rect(0, 0, getPartRootView().getWidth(), getPartRootView().getHeight());
        if (J9()) {
            QLog.e("FeedGalleryAnimPart", 1, "targetViewEmpty");
            this.startTranslationX = source.getScreenX();
            this.startTranslationY = source.getScreenY();
            this.startClipBounds.set((int) source.getScreenX(), (int) source.getScreenY(), (int) (source.getScreenX() + source.getWidthSource()), (int) (source.getScreenY() + source.getHeightSource()));
        }
        this.startTranslationX = (source.getScreenX() - (f26 * coerceAtLeast)) - (f19 * coerceAtLeast);
        float screenY = (source.getScreenY() - f28) - (floatValue2 * coerceAtLeast);
        this.startTranslationY = screenY;
        QLog.i("FeedGalleryAnimPart", 1, "initAnimationParamsV2 startTranslationX=" + this.startTranslationX + " startTranslationY=" + screenY);
        View partRootView = getPartRootView();
        partRootView.setPivotX(0.0f);
        partRootView.setPivotY(f17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9() {
        Activity activity = getActivity();
        if (activity != null) {
            activity.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility() & (-8193));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9() {
        Rect rect = this.startClipBounds;
        QLog.i("FeedGalleryAnimPart", 1, "startOpenAnim startClipBounds=" + rect + " width=" + rect.width() + " height=" + this.startClipBounds.height());
        long E9 = E9();
        QLog.i("FeedGalleryAnimPart", 1, "startOpenAnim startScaleX=" + this.startScaleX + " startScaleY=" + this.startScaleY + " startTranslationX=" + this.startTranslationX + " startTranslationY=" + this.startTranslationY + " animDuration=" + E9);
        View partRootView = getPartRootView();
        long E92 = E9();
        Float valueOf = Float.valueOf(this.startScaleX);
        Float valueOf2 = Float.valueOf(1.0f);
        Pair pair = TuplesKt.to(valueOf, valueOf2);
        Pair pair2 = TuplesKt.to(Float.valueOf(this.startScaleY), valueOf2);
        Float valueOf3 = Float.valueOf(this.startTranslationX);
        Float valueOf4 = Float.valueOf(0.0f);
        tl1.c.f(partRootView, E92, pair, pair2, TuplesKt.to(valueOf3, valueOf4), TuplesKt.to(Float.valueOf(this.startTranslationY), valueOf4), TuplesKt.to(this.startClipBounds, this.endClipBounds), TuplesKt.to(valueOf4, valueOf2), 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.FeedGalleryAnimPart$startOpenAnim$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.FeedGalleryAnimPart$startOpenAnim$2
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
                FeedGalleryAnimPart.this.broadcastMessage("message_on_gallery_open_anim_end_event", Boolean.FALSE);
                FeedGalleryAnimPart.this.needFinishAnim = true;
                FeedGalleryAnimPart.this.G9();
            }
        }, 128, null);
    }

    private final void I9() {
        this.needFinishAnim = false;
        View partRootView = getPartRootView();
        Float valueOf = Float.valueOf(1.0f);
        Pair pair = TuplesKt.to(valueOf, Float.valueOf(this.startScaleX));
        Pair pair2 = TuplesKt.to(valueOf, Float.valueOf(this.startScaleY));
        Float valueOf2 = Float.valueOf(0.0f);
        tl1.c.f(partRootView, 0L, pair, pair2, TuplesKt.to(valueOf2, Float.valueOf(this.startTranslationX)), TuplesKt.to(valueOf2, Float.valueOf(this.startTranslationY)), TuplesKt.to(this.endClipBounds, this.startClipBounds), TuplesKt.to(valueOf, valueOf2), 133L, null, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.FeedGalleryAnimPart$startReverseAnim$1
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
                Activity activity = FeedGalleryAnimPart.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
                Activity activity2 = FeedGalleryAnimPart.this.getActivity();
                if (activity2 != null) {
                    activity2.overridePendingTransition(0, 0);
                }
            }
        }, 257, null);
    }

    private final boolean J9() {
        if (this.mTargetView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTargetView");
        }
        ImageView imageView = this.mTargetView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTargetView");
            imageView = null;
        }
        if (imageView.getMeasuredHeight() != 0) {
            ImageView imageView3 = this.mTargetView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTargetView");
                imageView3 = null;
            }
            if (imageView3.getMeasuredWidth() != 0) {
                ImageView imageView4 = this.mTargetView;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTargetView");
                } else {
                    imageView2 = imageView4;
                }
                if (imageView2.getDrawable() != null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "FeedGalleryAnimPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        boolean z16 = this.needFinishAnim;
        if (z16) {
            I9();
        }
        return z16;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        AnimationParams animationParams = (AnimationParams) getActivity().getIntent().getParcelableExtra("feed_detail_animation_params");
        if (animationParams == null) {
            broadcastMessage("message_on_gallery_open_anim_end_event", Boolean.FALSE);
        } else {
            rootView.getViewTreeObserver().addOnPreDrawListener(new b(rootView, this, animationParams));
        }
    }
}
