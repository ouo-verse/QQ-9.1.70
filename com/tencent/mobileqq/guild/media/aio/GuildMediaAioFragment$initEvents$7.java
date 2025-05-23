package com.tencent.mobileqq.guild.media.aio;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class GuildMediaAioFragment$initEvents$7 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ GuildMediaAioFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaAioFragment$initEvents$7(GuildMediaAioFragment guildMediaAioFragment) {
        super(1);
        this.this$0 = guildMediaAioFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildMediaAioFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildMediaAioViewModel guildMediaAioViewModel = this$0.aioViewModel;
        if (guildMediaAioViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioViewModel");
            guildMediaAioViewModel = null;
        }
        guildMediaAioViewModel.o2();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean it) {
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (it.booleanValue()) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final GuildMediaAioFragment guildMediaAioFragment = this.this$0;
            uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.media.aio.q
                @Override // java.lang.Runnable
                public final void run() {
                    GuildMediaAioFragment$initEvents$7.b(GuildMediaAioFragment.this);
                }
            }, 1500L);
        }
    }
}
