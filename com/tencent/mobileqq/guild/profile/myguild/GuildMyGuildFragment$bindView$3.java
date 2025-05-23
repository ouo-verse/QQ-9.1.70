package com.tencent.mobileqq.guild.profile.myguild;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public /* synthetic */ class GuildMyGuildFragment$bindView$3 extends FunctionReferenceImpl implements Function2<String, View, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildMyGuildFragment$bindView$3(Object obj) {
        super(2, obj, GuildMyGuildFragment.class, "jumpToGuild", "jumpToGuild(Ljava/lang/String;Landroid/view/View;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, View view) {
        invoke2(str, view);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull String p06, @NotNull View p16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        Intrinsics.checkNotNullParameter(p16, "p1");
        ((GuildMyGuildFragment) this.receiver).Th(p06, p16);
    }
}
