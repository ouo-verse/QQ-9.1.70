package com.tencent.mobileqq.guild.home.parts;

import android.os.SystemClock;
import com.tencent.mobileqq.guild.util.TraceUtils;
import kotlin.Function0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lef1/a;", "", "kotlin.jvm.PlatformType", "it", "", "invoke", "(Lef1/a;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes13.dex */
final class GuildHomeRefreshLoadingPart$onInitView$2 extends Lambda implements Function1<ef1.a<Boolean>, Unit> {
    final /* synthetic */ GuildHomeRefreshLoadingPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeRefreshLoadingPart$onInitView$2(GuildHomeRefreshLoadingPart guildHomeRefreshLoadingPart) {
        super(1);
        this.this$0 = guildHomeRefreshLoadingPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildHomeRefreshLoadingPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.S9();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ef1.a<Boolean> aVar) {
        invoke2(aVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ef1.a<Boolean> aVar) {
        long j3;
        if (Intrinsics.areEqual(aVar.b(this.this$0), Boolean.TRUE)) {
            TraceUtils.n("Guild.HomePage.Fragment.FeedsFinishRefresh");
            long uptimeMillis = SystemClock.uptimeMillis();
            j3 = this.this$0.refreshTimeStamp;
            long j16 = uptimeMillis - j3;
            if (j16 > 3000) {
                this.this$0.S9();
                return;
            }
            int i3 = (int) j16;
            final GuildHomeRefreshLoadingPart guildHomeRefreshLoadingPart = this.this$0;
            Function0.b(i3, new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.bj
                @Override // java.lang.Runnable
                public final void run() {
                    GuildHomeRefreshLoadingPart$onInitView$2.b(GuildHomeRefreshLoadingPart.this);
                }
            });
        }
    }
}
