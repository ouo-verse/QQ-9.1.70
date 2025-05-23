package com.tencent.guild.aio.panel.photo;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public /* synthetic */ class GuildPhotoPanelVM$queryMediaTask$1$1 extends FunctionReferenceImpl implements Function1<List<? extends com.tencent.guild.api.media.album.e>, Unit> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuildPhotoPanelVM$queryMediaTask$1$1(Object obj) {
        super(1, obj, GuildPhotoPanelVM.class, "setLocalMediaList", "setLocalMediaList(Ljava/util/List;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.guild.api.media.album.e> list) {
        invoke2(list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull List<? extends com.tencent.guild.api.media.album.e> p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        ((GuildPhotoPanelVM) this.receiver).y(p06);
    }
}
