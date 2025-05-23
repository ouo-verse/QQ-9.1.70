package com.tencent.mobileqq.guild.aiocombinestyle.imagestrategy;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.guild.aio.component.combinestyle.ag;
import com.tencent.guild.aio.component.combinestyle.ai;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\n\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/aiocombinestyle/imagestrategy/b;", "Lcom/tencent/guild/aio/component/combinestyle/ai;", "", "b", "c", "a", "Ljava/lang/String;", "getTinyId", "()Ljava/lang/String;", "tinyId", "getGuild", "guild", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b implements ai {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tinyId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guild;

    public b(@NotNull String tinyId, @NotNull String guild2) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(guild2, "guild");
        this.tinyId = tinyId;
        this.guild = guild2;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.ah
    public void a(@NotNull Context context, @NotNull ag agVar) {
        ai.a.b(this, context, agVar);
    }

    @Override // com.tencent.guild.aio.component.combinestyle.ai
    @NotNull
    /* renamed from: b, reason: from getter */
    public String getTinyId() {
        return this.tinyId;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.ai
    @NotNull
    /* renamed from: c, reason: from getter */
    public String getGuild() {
        return this.guild;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.ah
    @Nullable
    public Drawable d() {
        return ai.a.a(this);
    }
}
