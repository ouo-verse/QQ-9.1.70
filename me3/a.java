package me3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0001\u0007B%\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0007\u0010\n\"\u0004\b\u0014\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lme3/a;", "", "", "toString", "", "b", "", "a", "I", "getId", "()I", "setId", "(I)V", "id", "Ljava/lang/String;", "getUin", "()Ljava/lang/String;", "setUin", "(Ljava/lang/String;)V", "uin", "c", "status", "<init>", "(ILjava/lang/String;I)V", "d", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String uin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private volatile int status;

    public a(int i3, @NotNull String uin, int i16) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.id = i3;
        this.uin = uin;
        this.status = i16;
    }

    /* renamed from: a, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    public final void b() {
        this.id = 0;
        this.status = 0;
    }

    public final void c(int i3) {
        this.status = i3;
    }

    @NotNull
    public String toString() {
        return "status=" + this.status;
    }
}
