package com.tencent.guild.aio.component.combinestyle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/am;", "Lcom/tencent/guild/aio/component/combinestyle/aj;", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "combineStyleAioItem", "", "a", "I", "getColor", "()I", "color", "<init>", "(I)V", "aio-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class am implements aj {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int color;

    public am(int i3) {
        this.color = i3;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.aj
    public int a(@NotNull aa combineStyleAioItem) {
        Intrinsics.checkNotNullParameter(combineStyleAioItem, "combineStyleAioItem");
        return this.color;
    }
}
