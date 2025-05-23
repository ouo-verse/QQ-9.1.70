package com.tencent.mobileqq.guild.media.widget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.GuildMediaUtils;
import com.tencent.mobileqq.guild.media.config.MediaGuidanceConfig;
import com.tencent.mobileqq.guild.media.presenter.MediaChannelFragmentBottomBarPresenter;
import com.tencent.mobileqq.guild.media.widget.GuildMediaChannelFragmentBottomBar$setMoreIv$1;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.StringUtil;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.widget.GuildMediaChannelFragmentBottomBar$setMoreIv$1", f = "GuildMediaChannelFragmentBottomBar.kt", i = {0}, l = {131}, m = "invokeSuspend", n = {DownloadInfo.spKey_Config}, s = {"L$0"})
/* loaded from: classes14.dex */
public final class GuildMediaChannelFragmentBottomBar$setMoreIv$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ GuildMediaChannelFragmentBottomBar this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.guild.media.widget.GuildMediaChannelFragmentBottomBar$setMoreIv$1$2, reason: invalid class name */
    /* loaded from: classes14.dex */
    public static final class AnonymousClass2 extends Lambda implements Function1<View, Unit> {
        final /* synthetic */ MediaGuidanceConfig.NavConfigData $config;
        final /* synthetic */ GuildMediaChannelFragmentBottomBar this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MediaGuidanceConfig.NavConfigData navConfigData, GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar) {
            super(1);
            this.$config = navConfigData;
            this.this$0 = guildMediaChannelFragmentBottomBar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(GuildMediaChannelFragmentBottomBar this$0) {
            ImageView imageView;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            imageView = this$0.mMoreIv;
            imageView.setImageResource(R.drawable.guild_media_bottom_more_press);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull View it) {
            MediaChannelFragmentBottomBarPresenter mediaChannelFragmentBottomBarPresenter;
            MediaChannelFragmentBottomBarPresenter mediaChannelFragmentBottomBarPresenter2;
            Intrinsics.checkNotNullParameter(it, "it");
            com.tencent.mobileqq.guild.media.core.p.f228716a.e();
            MediaChannelFragmentBottomBarPresenter mediaChannelFragmentBottomBarPresenter3 = null;
            if (bw.j0(this.$config.getDataVersion())) {
                mediaChannelFragmentBottomBarPresenter2 = this.this$0.mBottomBtnPresenter;
                if (mediaChannelFragmentBottomBarPresenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomBtnPresenter");
                } else {
                    mediaChannelFragmentBottomBarPresenter3 = mediaChannelFragmentBottomBarPresenter2;
                }
                mediaChannelFragmentBottomBarPresenter3.E(String.valueOf(this.$config.getOpenIndex()));
                bw.X1(this.$config.getDataVersion());
            } else {
                mediaChannelFragmentBottomBarPresenter = this.this$0.mBottomBtnPresenter;
                if (mediaChannelFragmentBottomBarPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mBottomBtnPresenter");
                } else {
                    mediaChannelFragmentBottomBarPresenter3 = mediaChannelFragmentBottomBarPresenter;
                }
                mediaChannelFragmentBottomBarPresenter3.E("");
            }
            final GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar = this.this$0;
            guildMediaChannelFragmentBottomBar.post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.i
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMediaChannelFragmentBottomBar$setMoreIv$1.AnonymousClass2.b(GuildMediaChannelFragmentBottomBar.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaChannelFragmentBottomBar$setMoreIv$1(GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar, Continuation<? super GuildMediaChannelFragmentBottomBar$setMoreIv$1> continuation) {
        super(2, continuation);
        this.this$0 = guildMediaChannelFragmentBottomBar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildMediaChannelFragmentBottomBar$setMoreIv$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        IGProGuildInfo iGProGuildInfo;
        IGProChannelInfo iGProChannelInfo;
        MediaGuidanceConfig.NavConfigData navConfigData;
        ImageView mMoreIv;
        ImageView imageView;
        ImageView mMoreIv2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                navConfigData = (MediaGuidanceConfig.NavConfigData) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            MediaGuidanceConfig.NavConfigData updateConfigData = MediaGuidanceConfig.INSTANCE.a().getUpdateConfigData();
            GuildMediaUtils guildMediaUtils = GuildMediaUtils.f227771a;
            iGProGuildInfo = this.this$0.mGuildInfo;
            IGProChannelInfo iGProChannelInfo2 = null;
            if (iGProGuildInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildInfo");
                iGProGuildInfo = null;
            }
            String guildID = iGProGuildInfo.getGuildID();
            Intrinsics.checkNotNullExpressionValue(guildID, "mGuildInfo.guildID");
            iGProChannelInfo = this.this$0.mChannelInfo;
            if (iGProChannelInfo == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mChannelInfo");
            } else {
                iGProChannelInfo2 = iGProChannelInfo;
            }
            String channelUin = iGProChannelInfo2.getChannelUin();
            Intrinsics.checkNotNullExpressionValue(channelUin, "mChannelInfo.channelUin");
            this.L$0 = updateConfigData;
            this.label = 1;
            Object p16 = guildMediaUtils.p(guildID, channelUin, 102, this);
            if (p16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            navConfigData = updateConfigData;
            obj = p16;
        }
        if (!((Boolean) obj).booleanValue() || !bw.j0(navConfigData.getDataVersion()) || StringUtil.isEmpty(navConfigData.getIconUrl()) || NetConnInfoCenter.getServerTimeMillis() <= navConfigData.getEffectiveTime()) {
            mMoreIv = this.this$0.mMoreIv;
            Intrinsics.checkNotNullExpressionValue(mMoreIv, "mMoreIv");
            final GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar = this.this$0;
            jt1.b.b(mMoreIv, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildMediaChannelFragmentBottomBar$setMoreIv$1.3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View it) {
                    MediaChannelFragmentBottomBarPresenter mediaChannelFragmentBottomBarPresenter;
                    Intrinsics.checkNotNullParameter(it, "it");
                    com.tencent.mobileqq.guild.media.core.p.f228716a.e();
                    mediaChannelFragmentBottomBarPresenter = GuildMediaChannelFragmentBottomBar.this.mBottomBtnPresenter;
                    if (mediaChannelFragmentBottomBarPresenter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mBottomBtnPresenter");
                        mediaChannelFragmentBottomBarPresenter = null;
                    }
                    mediaChannelFragmentBottomBarPresenter.E("");
                }
            });
            this.this$0.moreIconType = QCircleDaTongConstant.ElementParamValue.PLUS;
        } else {
            com.tencent.mobileqq.guild.picload.e.a().f(new Option().setUrl(navConfigData.getIconUrl()), new a(this.this$0));
            mMoreIv2 = this.this$0.mMoreIv;
            Intrinsics.checkNotNullExpressionValue(mMoreIv2, "mMoreIv");
            jt1.b.b(mMoreIv2, new AnonymousClass2(navConfigData, this.this$0));
            this.this$0.moreIconType = "new_alert";
        }
        imageView = this.this$0.mMoreIv;
        imageView.setVisibility(0);
        this.this$0.p();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildMediaChannelFragmentBottomBar$setMoreIv$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/widget/GuildMediaChannelFragmentBottomBar$setMoreIv$1$a", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends GuildPicStateListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildMediaChannelFragmentBottomBar f229651e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar) {
            super(true);
            this.f229651e = guildMediaChannelFragmentBottomBar;
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(@NotNull LoadState state, @NotNull Option option) {
            ImageView imageView;
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            if (state == LoadState.STATE_SUCCESS && option.getResultBitMap() != null) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f229651e.getContext(), R.anim.f154587nv);
                loadAnimation.setAnimationListener(new AnimationAnimationListenerC7842a(this.f229651e, option));
                imageView = this.f229651e.mMoreIv;
                imageView.startAnimation(loadAnimation);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/widget/GuildMediaChannelFragmentBottomBar$setMoreIv$1$a$a", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.media.widget.GuildMediaChannelFragmentBottomBar$setMoreIv$1$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class AnimationAnimationListenerC7842a implements Animation.AnimationListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ GuildMediaChannelFragmentBottomBar f229652d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Option f229653e;

            AnimationAnimationListenerC7842a(GuildMediaChannelFragmentBottomBar guildMediaChannelFragmentBottomBar, Option option) {
                this.f229652d = guildMediaChannelFragmentBottomBar;
                this.f229653e = option;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(@Nullable Animation animation) {
                ImageView imageView;
                ImageView imageView2;
                imageView = this.f229652d.mMoreIv;
                imageView.setImageBitmap(this.f229653e.getResultBitMap());
                imageView2 = this.f229652d.mMoreIv;
                imageView2.startAnimation(AnimationUtils.loadAnimation(this.f229652d.getContext(), R.anim.f154590ny));
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(@Nullable Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(@Nullable Animation animation) {
            }
        }
    }
}
