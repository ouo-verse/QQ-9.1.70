package com.tencent.mobileqq.guild.rolegroup.adapters.rolelist;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u001b\b\u0004\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000e\u0082\u0001\b\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", "", "", "a", "I", "b", "()I", "setType", "(I)V", "type", "", "Ljava/lang/String;", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "id", "<init>", "(ILjava/lang/String;)V", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/a;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/d;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/i;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/j;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/m;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/s;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/y;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/ab;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String id;

    public /* synthetic */ r(int i3, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: b, reason: from getter */
    public final int getType() {
        return this.type;
    }

    r(int i3, String str) {
        this.type = i3;
        this.id = str;
    }

    public /* synthetic */ r(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? "" : str, null);
    }
}
