package eh;

import NS_FAMOUS_SHARE.get_famous_share_rsp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u00182\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0003\u0010\u0012R\"\u0010\u0015\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u000e\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Leh/a;", "", "", "a", "J", "getFansCount", "()J", "b", "(J)V", "fansCount", "getVisitorCount", "d", "visitorCount", "", "c", "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "desc", "getNickName", "nickName", "<init>", "()V", "e", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long fansCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long visitorCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String desc = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String nickName = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Leh/a$a;", "", "LNS_FAMOUS_SHARE/get_famous_share_rsp;", "rsp", "Leh/a;", "a", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: eh.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a(get_famous_share_rsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            a aVar = new a();
            aVar.b(rsp.uiFamousFansNum);
            aVar.d(rsp.uiVisitorCount);
            String str = rsp.sFamousDesc;
            Intrinsics.checkNotNullExpressionValue(str, "rsp.sFamousDesc");
            aVar.a(str);
            String str2 = rsp.sNick;
            Intrinsics.checkNotNullExpressionValue(str2, "rsp.sNick");
            aVar.c(str2);
            return aVar;
        }

        Companion() {
        }
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final void b(long j3) {
        this.fansCount = j3;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nickName = str;
    }

    public final void d(long j3) {
        this.visitorCount = j3;
    }
}
