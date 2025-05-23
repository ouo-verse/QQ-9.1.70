package com.tencent.guild.aio.component.combinestyle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\r\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/component/combinestyle/an;", "Lcom/tencent/guild/aio/component/combinestyle/aj;", "Lcom/tencent/guild/aio/component/combinestyle/aa;", "combineStyleAioItem", "", "a", "", "Ljava/lang/String;", "getRoleColor", "()Ljava/lang/String;", "roleColor", "b", "getTinyId", "tinyId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "aio-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class an implements aj {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String roleColor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tinyId;

    public an(@Nullable String str, @NotNull String tinyId) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        this.roleColor = str;
        this.tinyId = tinyId;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.aj
    public int a(@NotNull aa combineStyleAioItem) {
        Intrinsics.checkNotNullParameter(combineStyleAioItem, "combineStyleAioItem");
        return combineStyleAioItem.N0(this.roleColor, this.tinyId);
    }
}
