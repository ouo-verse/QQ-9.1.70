package com.qzone.reborn.feedpro.banner.topbanner.item;

import android.os.Handler;
import android.view.animation.Animation;
import com.tencent.richframework.thread.RFWThreadManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "anim", "Landroid/view/animation/Animation;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class FeedProTopMsgBanner$loadAnimation$showAnim$1$1 extends Lambda implements Function1<Animation, Unit> {
    final /* synthetic */ Animation $hideAnim;
    final /* synthetic */ FeedProTopMsgBanner this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedProTopMsgBanner$loadAnimation$showAnim$1$1(FeedProTopMsgBanner feedProTopMsgBanner, Animation animation) {
        super(1);
        this.this$0 = feedProTopMsgBanner;
        this.$hideAnim = animation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(FeedProTopMsgBanner this$0, Animation animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.startAnimation(animation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Animation animation) {
        invoke2(animation);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Animation anim) {
        Runnable runnable;
        Intrinsics.checkNotNullParameter(anim, "anim");
        final FeedProTopMsgBanner feedProTopMsgBanner = this.this$0;
        final Animation animation = this.$hideAnim;
        feedProTopMsgBanner.hideAnimationRunnable = new Runnable() { // from class: com.qzone.reborn.feedpro.banner.topbanner.item.a
            @Override // java.lang.Runnable
            public final void run() {
                FeedProTopMsgBanner$loadAnimation$showAnim$1$1.b(FeedProTopMsgBanner.this, animation);
            }
        };
        Handler uIHandler = RFWThreadManager.getUIHandler();
        runnable = this.this$0.hideAnimationRunnable;
        Intrinsics.checkNotNull(runnable);
        uIHandler.postDelayed(runnable, 5000L);
    }
}
