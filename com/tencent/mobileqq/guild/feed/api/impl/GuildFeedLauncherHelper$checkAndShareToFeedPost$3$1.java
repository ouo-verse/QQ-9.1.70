package com.tencent.mobileqq.guild.feed.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildFeedLauncherHelper$checkAndShareToFeedPost$3$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ GuildFeedLauncherHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedLauncherHelper$checkAndShareToFeedPost$3$1(GuildFeedLauncherHelper guildFeedLauncherHelper) {
        super(1);
        this.this$0 = guildFeedLauncherHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildFeedLauncherHelper this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
        invoke2(th5);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable Throwable th5) {
        this.this$0.launchJob = null;
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final GuildFeedLauncherHelper guildFeedLauncherHelper = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.api.impl.o
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedLauncherHelper$checkAndShareToFeedPost$3$1.b(GuildFeedLauncherHelper.this);
            }
        });
    }
}
