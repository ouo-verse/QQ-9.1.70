package dh;

import NS_QMALL_COVER.PassiveFeedsPush;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0016\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0018\u001a\u0004\b\n\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Ldh/e;", "", "", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", h.F, "(Ljava/lang/String;)V", "uin", "b", "f", "nickname", "", "I", "e", "()I", "j", "(I)V", "yellowVipType", "d", "i", "yellowVipLevel", "LNS_QMALL_COVER/PassiveFeedsPush;", "LNS_QMALL_COVER/PassiveFeedsPush;", "()LNS_QMALL_COVER/PassiveFeedsPush;", "g", "(LNS_QMALL_COVER/PassiveFeedsPush;)V", "passiveFeedsPush", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String uin = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private String nickname = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int yellowVipType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int yellowVipLevel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private PassiveFeedsPush passiveFeedsPush;

    /* renamed from: a, reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: b, reason: from getter */
    public final PassiveFeedsPush getPassiveFeedsPush() {
        return this.passiveFeedsPush;
    }

    /* renamed from: c, reason: from getter */
    public final String getUin() {
        return this.uin;
    }

    /* renamed from: d, reason: from getter */
    public final int getYellowVipLevel() {
        return this.yellowVipLevel;
    }

    /* renamed from: e, reason: from getter */
    public final int getYellowVipType() {
        return this.yellowVipType;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nickname = str;
    }

    public final void g(PassiveFeedsPush passiveFeedsPush) {
        this.passiveFeedsPush = passiveFeedsPush;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.uin = str;
    }

    public final void i(int i3) {
        this.yellowVipLevel = i3;
    }

    public final void j(int i3) {
        this.yellowVipType = i3;
    }
}
