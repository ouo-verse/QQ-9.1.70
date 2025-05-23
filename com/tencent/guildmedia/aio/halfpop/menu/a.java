package com.tencent.guildmedia.aio.halfpop.menu;

import com.tencent.guild.aio.halfpop.menu.x;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guildmedia/aio/halfpop/menu/a;", "Lcom/tencent/guild/aio/halfpop/menu/x;", "", "", "configType", "", "E", "<init>", "()V", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class a extends x {
    public a() {
        super(null, 1, null);
    }

    @Override // com.tencent.guild.aio.halfpop.menu.t
    public void E(@NotNull List<Integer> configType) {
        Intrinsics.checkNotNullParameter(configType, "configType");
        configType.add(6);
        configType.add(7);
        configType.add(23);
        configType.add(24);
    }
}
