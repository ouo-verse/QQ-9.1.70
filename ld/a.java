package ld;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0005\"\u0004\b\t\u0010\u0007R\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0015\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0018"}, d2 = {"Lld/a;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "uin", "b", "getNickname", "nickname", "", "I", "getYellowVipType", "()I", "e", "(I)V", "yellowVipType", "d", "getYellowVipLevel", "yellowVipLevel", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String uin = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String nickname = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int yellowVipType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int yellowVipLevel;

    /* renamed from: a, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nickname = str;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uin = str;
    }

    public final void d(int i3) {
        this.yellowVipLevel = i3;
    }

    public final void e(int i3) {
        this.yellowVipType = i3;
    }
}
