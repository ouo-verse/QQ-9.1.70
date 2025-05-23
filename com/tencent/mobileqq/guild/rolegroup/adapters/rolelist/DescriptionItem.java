package com.tencent.mobileqq.guild.rolegroup.adapters.rolelist;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/d;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "c", "Ljava/util/List;", "()Ljava/util/List;", "text", "<init>", "(Ljava/util/List;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.d, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class DescriptionItem extends r {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DescriptionItem(@NotNull List<String> text) {
        super(4, null, 2, null);
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
    }

    @NotNull
    public final List<String> c() {
        return this.text;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof DescriptionItem) && Intrinsics.areEqual(this.text, ((DescriptionItem) other).text)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.text.hashCode();
    }

    @NotNull
    public String toString() {
        return "DescriptionItem(text=" + this.text + ")";
    }
}
