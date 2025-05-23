package d22;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f\u00a8\u0006\u0013"}, d2 = {"Ld22/h;", "Lg32/b;", "", "c", "J", "getUid", "()J", "uid", "", "d", "Ljava/lang/String;", "getNickName", "()Ljava/lang/String;", "nickName", "e", "getHeadUrl", "headUrl", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class h extends g32.b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final long uid;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String nickName;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String headUrl;

    public h(long j3, @NotNull String nickName, @NotNull String headUrl) {
        Intrinsics.checkNotNullParameter(nickName, "nickName");
        Intrinsics.checkNotNullParameter(headUrl, "headUrl");
        this.uid = j3;
        this.nickName = nickName;
        this.headUrl = headUrl;
    }
}
