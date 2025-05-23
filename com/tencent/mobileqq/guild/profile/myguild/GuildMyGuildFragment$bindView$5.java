package com.tencent.mobileqq.guild.profile.myguild;

import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public /* synthetic */ class GuildMyGuildFragment$bindView$5 extends FunctionReferenceImpl implements Function3<String, String, Boolean, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildMyGuildFragment$bindView$5(Object obj) {
        super(3, obj, GuildMyGuildFragment.class, NodeProps.ON_LONG_CLICK, "onLongClick(Ljava/lang/String;Ljava/lang/String;Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String str, String str2, Boolean bool) {
        invoke(str, str2, bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String p06, @NotNull String p16, boolean z16) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        Intrinsics.checkNotNullParameter(p16, "p1");
        ((GuildMyGuildFragment) this.receiver).Uh(p06, p16, z16);
    }
}
