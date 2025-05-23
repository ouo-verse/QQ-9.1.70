package com.tencent.guild.aio.usecase.channel.title;

import com.tencent.aio.data.AIOContact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/guild/aio/usecase/channel/title/a;", "Lol3/a;", "Lcom/tencent/aio/data/AIOContact;", "a", "Lcom/tencent/aio/data/AIOContact;", "()Lcom/tencent/aio/data/AIOContact;", "contact", "<init>", "(Lcom/tencent/aio/data/AIOContact;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a implements ol3.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOContact contact;

    public a(@NotNull AIOContact contact) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        this.contact = contact;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final AIOContact getContact() {
        return this.contact;
    }
}
