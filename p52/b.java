package p52;

import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0003\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0017\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u000f\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010$\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001f\u00a8\u0006'"}, d2 = {"Lp52/b;", "", "", "b", "I", "e", "()I", "setWifiEnableQuicMode", "(I)V", "wifiEnableQuicMode", "c", "f", "setXgEnableQuicMode", "xgEnableQuicMode", "", "d", "Z", "()Z", "setEnablePlainText", "(Z)V", "enablePlainText", "a", "setEnableConnectionMigration", "enableConnectionMigration", "setQuicCongestionType", "quicCongestionType", "", "g", "Ljava/lang/String;", "()Ljava/lang/String;", "setQuicHostListStr", "(Ljava/lang/String;)V", "quicHostListStr", h.F, "getQuicMapHostStr", "setQuicMapHostStr", "quicMapHostStr", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int wifiEnableQuicMode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int xgEnableQuicMode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean enablePlainText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean enableConnectionMigration;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static int quicCongestionType;

    /* renamed from: a, reason: collision with root package name */
    public static final b f425354a = new b();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static String quicHostListStr = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static String quicMapHostStr = "";

    b() {
    }

    public final boolean a() {
        return enableConnectionMigration;
    }

    public final boolean b() {
        return enablePlainText;
    }

    public final int c() {
        return quicCongestionType;
    }

    public final String d() {
        return quicHostListStr;
    }

    public final int e() {
        return wifiEnableQuicMode;
    }

    public final int f() {
        return xgEnableQuicMode;
    }
}
