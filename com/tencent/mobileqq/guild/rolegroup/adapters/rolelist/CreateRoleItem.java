package com.tencent.mobileqq.guild.rolegroup.adapters.rolelist;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/a;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "text", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class CreateRoleItem extends r {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateRoleItem(@NotNull String text) {
        super(3, null, 2, null);
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof CreateRoleItem) && Intrinsics.areEqual(this.text, ((CreateRoleItem) other).text)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.text.hashCode();
    }

    @NotNull
    public String toString() {
        return "CreateRoleItem(text=" + this.text + ")";
    }
}
