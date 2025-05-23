package me3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\"\u0010\t\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lme3/b;", "Lme3/a;", "", "e", "Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "path", "", "status", "uin", "id", "<init>", "(ILjava/lang/String;ILjava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class b extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String path;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(int i3, @NotNull String uin, int i16, @NotNull String path) {
        super(i16, uin, i3);
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
    }

    public void d(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.path = str;
    }
}
