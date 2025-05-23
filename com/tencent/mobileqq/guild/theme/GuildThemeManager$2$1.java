package com.tencent.mobileqq.guild.theme;

import com.tencent.mobileqq.guild.util.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
final class GuildThemeManager$2$1 extends Lambda implements Function1<Boolean, Unit> {
    public static final GuildThemeManager$2$1 INSTANCE = new GuildThemeManager$2$1();

    GuildThemeManager$2$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean it) {
        Logger.f235387a.d().i("Guild.GuildThemeManager", 1, "changed: " + it);
        kotlin.f fVar = kotlin.f.f433786a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        fVar.d(it.booleanValue());
    }
}
