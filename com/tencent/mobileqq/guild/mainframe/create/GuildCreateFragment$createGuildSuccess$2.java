package com.tencent.mobileqq.guild.mainframe.create;

import android.util.Log;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class GuildCreateFragment$createGuildSuccess$2 extends Lambda implements Function1<IGProGuildInfo, Unit> {
    final /* synthetic */ String $guildId;
    final /* synthetic */ GuildCreateFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildCreateFragment$createGuildSuccess$2(GuildCreateFragment guildCreateFragment, String str) {
        super(1);
        this.this$0 = guildCreateFragment;
        this.$guildId = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildCreateFragment this$0, String guildId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        this$0.Rh(guildId);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
        invoke2(iGProGuildInfo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildCreateFragment", "[createGuildSuccess] fetchGuildInfoAnyway " + iGProGuildInfo);
        }
        final GuildCreateFragment guildCreateFragment = this.this$0;
        final String str = this.$guildId;
        UiThreadUtil.runOnUiThreadWithCheck(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.create.f
            @Override // java.lang.Runnable
            public final void run() {
                GuildCreateFragment$createGuildSuccess$2.b(GuildCreateFragment.this, str);
            }
        });
    }
}
