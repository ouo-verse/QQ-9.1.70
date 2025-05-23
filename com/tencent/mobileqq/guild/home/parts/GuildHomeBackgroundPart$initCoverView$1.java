package com.tencent.mobileqq.guild.home.parts;

import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.home.views.GuildHomeCoverBelowList;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
final class GuildHomeBackgroundPart$initCoverView$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ GuildHomeBackgroundPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeBackgroundPart$initCoverView$1(GuildHomeBackgroundPart guildHomeBackgroundPart) {
        super(1);
        this.this$0 = guildHomeBackgroundPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildHomeBackgroundPart this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.NewHome.GuildHomeBackgroundPart", 1, "updateCoverUrl: " + str + ", set to invisible!");
        }
        this$0.J9().setVisibility(8);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final String it) {
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("Guild.NewHome.GuildHomeBackgroundPart", 1, "updateCoverUrl: " + it);
        }
        GuildHomeCoverBelowList J9 = this.this$0.J9();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        J9.j(it);
        if (this.this$0.B9() == GuildFacadeType.GameCenter) {
            this.this$0.J9().setVisibility(8);
            GuildHomeCoverBelowList J92 = this.this$0.J9();
            final GuildHomeBackgroundPart guildHomeBackgroundPart = this.this$0;
            J92.post(new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.f
                @Override // java.lang.Runnable
                public final void run() {
                    GuildHomeBackgroundPart$initCoverView$1.b(GuildHomeBackgroundPart.this, it);
                }
            });
        }
    }
}
