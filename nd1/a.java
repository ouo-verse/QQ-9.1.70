package nd1;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\n\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0010\u001a\u0004\b\f\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lnd1/a;", "", "", "a", "I", "b", "()I", "e", "(I)V", "relation", "d", "addFriendType", "c", "isShield", "f", "", "Ljava/lang/String;", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "uin", "<init>", "()V", "qq-gamecenter-msg-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int relation;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int addFriendType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int isShield;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String uin;

    /* renamed from: a, reason: from getter */
    public final int getAddFriendType() {
        return this.addFriendType;
    }

    /* renamed from: b, reason: from getter */
    public final int getRelation() {
        return this.relation;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public final void d(int i3) {
        this.addFriendType = i3;
    }

    public final void e(int i3) {
        this.relation = i3;
    }

    public final void f(int i3) {
        this.isShield = i3;
    }

    public final void g(@Nullable String str) {
        this.uin = str;
    }
}
