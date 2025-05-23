package com.tencent.mobileqq.guild.homev2.parts;

import com.tencent.mobileqq.guild.home.navigator.NavigatorData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes13.dex */
public /* synthetic */ class GuildNavigatorPart$eventHandler$1 extends FunctionReferenceImpl implements Function1<NavigatorData, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildNavigatorPart$eventHandler$1(Object obj) {
        super(1, obj, GuildNavigatorPart.class, "handleNavigatorIconClick", "handleNavigatorIconClick(Lcom/tencent/mobileqq/guild/home/navigator/NavigatorData;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(NavigatorData navigatorData) {
        invoke2(navigatorData);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull NavigatorData p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((GuildNavigatorPart) this.receiver).V9(p06);
    }
}
