package com.tencent.mobileqq.guild.feed.part;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.guild.feed.api.AnimationParams;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 /2\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ\u0014\u0010\u0012\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\"R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\"R\u0016\u0010%\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\"R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\"R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010(R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010(R\u0016\u0010,\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010+\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/part/GuildOldGalleryAnimHelper;", "", "", "g", "", "j", "", "e", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "f", "Lcom/tencent/mobileqq/guild/feed/api/AnimationParams;", "source", "k", "Lkotlin/Function0;", "onAnimEnd", "i", "Ljava/lang/Runnable;", tl.h.F, "", "a", "I", "imageId", "Landroid/widget/ImageView;", "b", "Landroid/widget/ImageView;", "targetView", "c", "Landroid/app/Activity;", "d", "Landroid/view/View;", "", UserInfo.SEX_FEMALE, "startScaleX", "startScaleY", "startTranslationX", "startTranslationY", "Landroid/graphics/Rect;", "Landroid/graphics/Rect;", "startClipBounds", "endClipBounds", "Z", "closeAnimEnable", "<init>", "(I)V", "l", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildOldGalleryAnimHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int imageId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView targetView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Activity activity;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View rootView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float startTranslationX;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float startTranslationY;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean closeAnimEnable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float startScaleX = 1.0f;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float startScaleY = 1.0f;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Rect startClipBounds = new Rect();

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Rect endClipBounds = new Rect();

    public GuildOldGalleryAnimHelper(int i3) {
        this.imageId = i3;
    }

    private final long e() {
        return 200L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        Activity activity = this.activity;
        if (activity != null) {
            activity.getWindow().getDecorView().setSystemUiVisibility(activity.getWindow().getDecorView().getSystemUiVisibility() & (-8193));
        }
    }

    private final boolean j() {
        ImageView imageView = this.targetView;
        if (imageView == null || imageView.getMeasuredHeight() == 0 || imageView.getMeasuredWidth() == 0 || imageView.getDrawable() == null) {
            return true;
        }
        return false;
    }

    public final void f(@NotNull Activity activity, @NotNull final View rootView) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.activity = activity;
        this.rootView = rootView;
        final AnimationParams animationParams = (AnimationParams) activity.getIntent().getParcelableExtra("feed_detail_animation_params");
        if (animationParams == null) {
            return;
        }
        rootView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.tencent.mobileqq.guild.feed.part.GuildOldGalleryAnimHelper$onInitView$1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                int i3;
                rootView.getViewTreeObserver().removeOnPreDrawListener(this);
                View view = rootView;
                i3 = this.imageId;
                ImageView imageView = (ImageView) view.findViewById(i3);
                if (imageView == null) {
                    this.g();
                    QLog.e("FeedGalleryAnimPart", 1, "imageView is null");
                    return false;
                }
                Logger logger = Logger.f235387a;
                AnimationParams animationParams2 = animationParams;
                Logger.b bVar = new Logger.b();
                String str = "source " + animationParams2.getWidthSource() + " " + animationParams2.getHeightSource() + " target " + imageView.getWidth() + " " + imageView.getHeight();
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("FeedGalleryAnimPart", 1, (String) it.next(), null);
                }
                this.targetView = imageView;
                this.k(animationParams);
                final GuildOldGalleryAnimHelper guildOldGalleryAnimHelper = this;
                guildOldGalleryAnimHelper.i(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.part.GuildOldGalleryAnimHelper$onInitView$1$onPreDraw$2
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
                        GuildOldGalleryAnimHelper.this.g();
                    }
                });
                return false;
            }
        });
    }

    public final void h(@NotNull final Runnable onAnimEnd) {
        Intrinsics.checkNotNullParameter(onAnimEnd, "onAnimEnd");
        if (!Intrinsics.areEqual(this.endClipBounds, this.startClipBounds) && this.closeAnimEnable) {
            tl1.c.f(this.rootView, 0L, TuplesKt.to(Float.valueOf(1.0f), Float.valueOf(this.startScaleX)), TuplesKt.to(Float.valueOf(1.0f), Float.valueOf(this.startScaleY)), TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(this.startTranslationX)), TuplesKt.to(Float.valueOf(0.0f), Float.valueOf(this.startTranslationY)), TuplesKt.to(this.endClipBounds, this.startClipBounds), TuplesKt.to(Float.valueOf(1.0f), Float.valueOf(0.0f)), 133L, null, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.part.GuildOldGalleryAnimHelper$startCloseAnim$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    onAnimEnd.run();
                }
            }, 257, null);
        } else {
            onAnimEnd.run();
        }
    }

    public final void i(@NotNull final Function0<Unit> onAnimEnd) {
        Intrinsics.checkNotNullParameter(onAnimEnd, "onAnimEnd");
        long e16 = e();
        QLog.i("FeedGalleryAnimPart", 1, "startOpenAnim startScaleX=" + this.startScaleX + " startScaleY=" + this.startScaleY + " startTranslationX=" + this.startTranslationX + " startTranslationY=" + this.startTranslationY + " animDuration=" + e16);
        View view = this.rootView;
        long e17 = e();
        Float valueOf = Float.valueOf(this.startScaleX);
        Float valueOf2 = Float.valueOf(1.0f);
        Pair pair = TuplesKt.to(valueOf, valueOf2);
        Pair pair2 = TuplesKt.to(Float.valueOf(this.startScaleY), valueOf2);
        Float valueOf3 = Float.valueOf(this.startTranslationX);
        Float valueOf4 = Float.valueOf(0.0f);
        tl1.c.f(view, e17, pair, pair2, TuplesKt.to(valueOf3, valueOf4), TuplesKt.to(Float.valueOf(this.startTranslationY), valueOf4), TuplesKt.to(this.startClipBounds, this.endClipBounds), TuplesKt.to(valueOf4, valueOf2), 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.part.GuildOldGalleryAnimHelper$startOpenAnim$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.part.GuildOldGalleryAnimHelper$startOpenAnim$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                GuildOldGalleryAnimHelper.this.closeAnimEnable = true;
                onAnimEnd.invoke();
            }
        }, 128, null);
    }

    public final void k(@NotNull AnimationParams source) {
        View view;
        boolean z16;
        boolean z17;
        float coerceAtLeast;
        Intrinsics.checkNotNullParameter(source, "source");
        ImageView imageView = this.targetView;
        if (imageView == null || (view = this.rootView) == null) {
            return;
        }
        QLog.i("FeedGalleryAnimPart", 1, "initAnimationParamsV2 sourceScreenX=" + source.getScreenX() + " sourceScreenY=" + source.getScreenY() + " sourceWidth=" + source.getWidthSource() + " sourHeight=" + source.getHeightSource());
        RectF a16 = b.f222545a.a(imageView);
        float f16 = a16.left;
        float f17 = a16.top;
        Number valueOf = Float.valueOf(a16.width());
        if (valueOf.floatValue() > 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        Number number = null;
        if (!z16) {
            valueOf = null;
        }
        if (valueOf == null) {
            valueOf = Integer.valueOf(view.getWidth());
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
            number = Integer.valueOf(view.getHeight());
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
        float f29 = f28 + floatValue2;
        this.startClipBounds = new Rect((int) f27, (int) f29, (int) ((source.getWidthSource() / coerceAtLeast) + f27), (int) (f29 + (source.getHeightSource() / coerceAtLeast)));
        this.endClipBounds = new Rect(0, 0, view.getWidth(), view.getHeight());
        if (j()) {
            QLog.e("FeedGalleryAnimPart", 1, "targetViewEmpty");
            this.startTranslationX = source.getScreenX();
            this.startTranslationY = source.getScreenY();
            this.startClipBounds.set((int) source.getScreenX(), (int) source.getScreenY(), (int) (source.getScreenX() + source.getWidthSource()), (int) (source.getScreenY() + source.getHeightSource()));
        }
        this.startTranslationX = (source.getScreenX() - (f26 * coerceAtLeast)) - (f19 * coerceAtLeast);
        float screenY = (source.getScreenY() - f28) - (floatValue2 * coerceAtLeast);
        this.startTranslationY = screenY;
        QLog.i("FeedGalleryAnimPart", 1, "initAnimationParamsV2 startTranslationX=" + this.startTranslationX + " startTranslationY=" + screenY);
        view.setPivotX(0.0f);
        view.setPivotY(f17);
    }
}
