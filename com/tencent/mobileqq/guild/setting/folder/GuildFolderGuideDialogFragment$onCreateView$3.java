package com.tencent.mobileqq.guild.setting.folder;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.widget.ImageView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.setting.folder.GuildFolderGuideDialogFragment;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.v;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import vp1.av;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "nightTheme", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
final class GuildFolderGuideDialogFragment$onCreateView$3 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ av $binding;
    final /* synthetic */ GuildFolderGuideConfig $config;
    final /* synthetic */ GuildFolderGuideDialogFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFolderGuideDialogFragment$onCreateView$3(GuildFolderGuideConfig guildFolderGuideConfig, av avVar, GuildFolderGuideDialogFragment guildFolderGuideDialogFragment) {
        super(1);
        this.$config = guildFolderGuideConfig;
        this.$binding = avVar;
        this.this$0 = guildFolderGuideDialogFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final GuildFolderGuideDialogFragment this$0, LoadState loadState, Option option) {
        final r01.c cVar;
        Handler handler;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadState.isFinishSuccess()) {
            Animatable animatable = option.getAnimatable();
            if (animatable instanceof r01.c) {
                cVar = (r01.c) animatable;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                this$0.mLibraAnimatable = cVar;
                Logger.f235387a.d().d("GuildFolderGuideDialogFragment", 1, "[onCreateView] load FinishSuccess");
                cVar.stop();
                handler = this$0.mHandler;
                handler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.folder.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildFolderGuideDialogFragment$onCreateView$3.d(r01.c.this, this$0);
                    }
                }, 0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(r01.c this_apply, GuildFolderGuideDialogFragment this$0) {
        Handler handler;
        GuildFolderGuideDialogFragment.IndirectAnimationRunnable indirectAnimationRunnable;
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this_apply.setLoopCount(1);
        handler = this$0.mHandler;
        indirectAnimationRunnable = this$0.mRunnable;
        this_apply.registerAnimationCallback(new GuildFolderGuideDialogFragment.a(handler, indirectAnimationRunnable));
        this_apply.start();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean nightTheme) {
        String guideImageUrl;
        Intrinsics.checkNotNullExpressionValue(nightTheme, "nightTheme");
        if (nightTheme.booleanValue()) {
            guideImageUrl = this.$config.getGuideImageUrlNight();
        } else {
            guideImageUrl = this.$config.getGuideImageUrl();
        }
        String str = guideImageUrl;
        try {
            com.tencent.mobileqq.guild.picload.e a16 = com.tencent.mobileqq.guild.picload.e.a();
            ImageView imageView = this.$binding.f442324f;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.image");
            Option d16 = v.d(str, imageView, null, null, 12, null);
            d16.setLoadingDrawable(new ColorDrawable(0));
            final GuildFolderGuideDialogFragment guildFolderGuideDialogFragment = this.this$0;
            a16.f(d16, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.guild.setting.folder.d
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    GuildFolderGuideDialogFragment$onCreateView$3.c(GuildFolderGuideDialogFragment.this, loadState, option);
                }
            });
            String guideImageShadow = this.$config.getGuideImageShadow();
            ImageView imageView2 = this.$binding.f442325g;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.imageBg");
            v.i(guideImageShadow, imageView2);
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "[showApngImage] get exception! " + e16;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildFolderGuideDialogFragment", 1, (String) it.next(), null);
            }
        }
    }
}
