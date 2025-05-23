package com.tencent.mobileqq.guild.home.parts;

import android.util.Log;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeCoverColors;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import kotlin.Function0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "kotlin.jvm.PlatformType", "headerColors", "", "invoke", "(Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes13.dex */
final class GuildHomeLoadingPart$onInitView$3 extends Lambda implements Function1<GuildHomeCoverColors, Unit> {
    final /* synthetic */ GuildHomeLoadingPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeLoadingPart$onInitView$3(GuildHomeLoadingPart guildHomeLoadingPart) {
        super(1);
        this.this$0 = guildHomeLoadingPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final GuildHomeLoadingPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UiThreadUtil.runOnUiThreadWithCheck(new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.be
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeLoadingPart$onInitView$3.d(GuildHomeLoadingPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(GuildHomeLoadingPart this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hasTintColor = true;
        z16 = this$0.hasHeaderList;
        if (z16) {
            this$0.X9("\u5c01\u9762\u4e3b\u8272\u6709\u6570\u636e");
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildHomeCoverColors guildHomeCoverColors) {
        invoke2(guildHomeCoverColors);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildHomeCoverColors guildHomeCoverColors) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.NewHome.GuildHomeLoadingPart", "hasHeaderColor type:" + guildHomeCoverColors.getType());
        }
        if (guildHomeCoverColors.getType() == 0) {
            return;
        }
        final GuildHomeLoadingPart guildHomeLoadingPart = this.this$0;
        Function0.b(20, new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.bd
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeLoadingPart$onInitView$3.c(GuildHomeLoadingPart.this);
            }
        });
    }
}
