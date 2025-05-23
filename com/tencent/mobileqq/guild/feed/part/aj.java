package com.tencent.mobileqq.guild.feed.part;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.event.GuildFeedListFirstLoadingEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedThemeChangeEvent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 &2\u00020\u0001:\u0002'(B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0012\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J(\u0010\u001b\u001a\"\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0019\u0018\u00010\u0018j\u0010\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0019\u0018\u0001`\u001aH\u0016R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/part/aj;", "Lcom/tencent/mobileqq/guild/feed/part/f;", "", "F9", "Lcom/tencent/mobileqq/guild/feed/event/GuildFeedListFirstLoadingEvent;", "event", "C9", "Landroid/view/View;", "mRootView", "D9", "G9", "", "E9", "B9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "simpleBaseEvent", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/widget/RelativeLayout;", tl.h.F, "Landroid/widget/RelativeLayout;", "mContainer", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "mLeftAnimLightView", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class aj extends f {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RelativeLayout mContainer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView mLeftAnimLightView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/part/aj$b;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "", com.tencent.luggage.wxa.c8.c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "getOpacity", "Landroid/graphics/Paint;", "a", "Landroid/graphics/Paint;", "paint", "", "b", "[F", "gradientPositions", "Landroid/graphics/Shader;", "c", "Landroid/graphics/Shader;", "gradientShader", "", "gradientColors", "", "width", "<init>", "([IF)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends Drawable {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Paint paint;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final float[] gradientPositions;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Shader gradientShader;

        public b(@NotNull int[] gradientColors, float f16) {
            Intrinsics.checkNotNullParameter(gradientColors, "gradientColors");
            Paint paint = new Paint(1);
            this.paint = paint;
            float[] fArr = {0.0f, 0.5f, 1.0f};
            this.gradientPositions = fArr;
            paint.setStyle(Paint.Style.FILL);
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, f16, 0.0f, gradientColors, fArr, Shader.TileMode.CLAMP);
            this.gradientShader = linearGradient;
            paint.setShader(linearGradient);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NotNull Canvas canvas) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            canvas.drawPaint(this.paint);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int alpha) {
            this.paint.setAlpha(alpha);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
            this.paint.setColorFilter(colorFilter);
        }
    }

    private final void B9() {
        if (!E9()) {
            return;
        }
        RelativeLayout relativeLayout = this.mContainer;
        ImageView imageView = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            relativeLayout = null;
        }
        if (relativeLayout.getVisibility() != 8) {
            ImageView imageView2 = this.mLeftAnimLightView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLeftAnimLightView");
                imageView2 = null;
            }
            if (imageView2.getVisibility() != 8) {
                QLog.d("GuildFeedLoadingAnimPart", 4, "[doHideLoadingView] stop all animation");
                ImageView imageView3 = this.mLeftAnimLightView;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftAnimLightView");
                    imageView3 = null;
                }
                Animation animation = imageView3.getAnimation();
                if (animation != null) {
                    animation.cancel();
                }
                RelativeLayout relativeLayout2 = this.mContainer;
                if (relativeLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                    relativeLayout2 = null;
                }
                relativeLayout2.setVisibility(8);
                ImageView imageView4 = this.mLeftAnimLightView;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLeftAnimLightView");
                } else {
                    imageView = imageView4;
                }
                imageView.setVisibility(8);
            }
        }
    }

    private final void C9(GuildFeedListFirstLoadingEvent event) {
        Logger.f235387a.d().d("GuildFeedLoadingAnimPart", 1, "handleFeedListFirstLoading: isFinish[" + event.isLoadingFinish() + "]");
        if (!event.isLoadingFinish()) {
            return;
        }
        B9();
    }

    private final void D9(View mRootView) {
        RelativeLayout relativeLayout;
        View findViewById = mRootView.findViewById(R.id.wbp);
        ImageView imageView = null;
        if (findViewById instanceof RelativeLayout) {
            relativeLayout = (RelativeLayout) findViewById;
        } else {
            relativeLayout = null;
        }
        if (relativeLayout == null) {
            return;
        }
        this.mContainer = relativeLayout;
        View findViewById2 = relativeLayout.findViewById(R.id.wox);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContainer.findViewById(\u2026guild_loading_frame_anim)");
        this.mLeftAnimLightView = (ImageView) findViewById2;
        RelativeLayout relativeLayout2 = this.mContainer;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            relativeLayout2 = null;
        }
        relativeLayout2.setVisibility(0);
        ImageView imageView2 = this.mLeftAnimLightView;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftAnimLightView");
        } else {
            imageView = imageView2;
        }
        imageView.setVisibility(0);
        G9();
        F9();
    }

    private final boolean E9() {
        if (this.mContainer != null && this.mLeftAnimLightView != null) {
            return true;
        }
        return false;
    }

    private final void F9() {
        QLog.d("GuildFeedLoadingAnimPart", 1, "showLoadingAnim ");
        Size b16 = com.tencent.mobileqq.guild.feed.util.e.b(getContext());
        float width = b16.getWidth();
        float height = b16.getHeight();
        TranslateAnimation translateAnimation = new TranslateAnimation(width * (-0.6f), width * 0.6f, (-0.6f) * height, height * 0.6f);
        translateAnimation.setDuration(2400L);
        translateAnimation.setRepeatCount(-1);
        translateAnimation.setRepeatMode(1);
        ImageView imageView = this.mLeftAnimLightView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftAnimLightView");
            imageView = null;
        }
        imageView.startAnimation(translateAnimation);
    }

    private final void G9() {
        int color;
        if (QQTheme.isVasTheme()) {
            color = com.tencent.mobileqq.guild.feed.util.au.h(getContext().getResources().getColor(R.color.qui_common_bg_middle_light), 50);
        } else {
            color = getContext().getResources().getColor(R.color.qui_common_fill_light_secondary);
        }
        ImageView imageView = this.mLeftAnimLightView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftAnimLightView");
            imageView = null;
        }
        int[] iArr = {0, color, 0};
        ImageView imageView3 = this.mLeftAnimLightView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLeftAnimLightView");
        } else {
            imageView2 = imageView3;
        }
        imageView.setImageDrawable(new b(iArr, imageView2.getWidth()));
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @Nullable
    public ArrayList<Class<?>> getEventClass() {
        ArrayList<Class<?>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildFeedListFirstLoadingEvent.class, GuildFeedThemeChangeEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        D9(rootView);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.f, com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        initViewModel();
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof GuildFeedListFirstLoadingEvent) {
            C9((GuildFeedListFirstLoadingEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof GuildFeedThemeChangeEvent) {
            G9();
        }
    }
}
