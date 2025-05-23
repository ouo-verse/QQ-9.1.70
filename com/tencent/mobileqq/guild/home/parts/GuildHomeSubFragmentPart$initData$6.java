package com.tencent.mobileqq.guild.home.parts;

import com.tencent.mobileqq.guild.home.views.GuildHomeSubFragmentContentLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public final class GuildHomeSubFragmentPart$initData$6 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ GuildHomeSubFragmentPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeSubFragmentPart$initData$6(GuildHomeSubFragmentPart guildHomeSubFragmentPart) {
        super(1);
        this.this$0 = guildHomeSubFragmentPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildHomeSubFragmentPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ma();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke2(num);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Integer num) {
        GuildHomeSubFragmentContentLayout guildHomeSubFragmentContentLayout = this.this$0.contentLayout;
        if (guildHomeSubFragmentContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeSubFragmentContentLayout = null;
        }
        final GuildHomeSubFragmentPart guildHomeSubFragmentPart = this.this$0;
        guildHomeSubFragmentContentLayout.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.cb
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeSubFragmentPart$initData$6.b(GuildHomeSubFragmentPart.this);
            }
        }, 100L);
    }
}
