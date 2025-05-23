package com.tencent.mobileqq.guild;

import android.content.Intent;
import com.tencent.mobileqq.guild.share.w;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
final class GuildShareActionSheetV2$showShareActionSheetInNewPanel$1$prepareForwardData$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ com.tencent.mobileqq.sharepanel.m $callback;
    final /* synthetic */ GuildShareActionSheetV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildShareActionSheetV2$showShareActionSheetInNewPanel$1$prepareForwardData$1(GuildShareActionSheetV2 guildShareActionSheetV2, com.tencent.mobileqq.sharepanel.m mVar) {
        super(0);
        this.this$0 = guildShareActionSheetV2;
        this.$callback = mVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.tencent.mobileqq.sharepanel.m callback, Intent intent) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.a(intent);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        w wVar = this.this$0.executor;
        final com.tencent.mobileqq.sharepanel.m mVar = this.$callback;
        wVar.r(new com.tencent.mobileqq.guild.share.util.g() { // from class: com.tencent.mobileqq.guild.m
            @Override // com.tencent.mobileqq.guild.share.util.g
            public final void a(Intent intent) {
                GuildShareActionSheetV2$showShareActionSheetInNewPanel$1$prepareForwardData$1.b(com.tencent.mobileqq.sharepanel.m.this, intent);
            }
        });
    }
}
