package pi4;

import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J$\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006R\"\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\f\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lpi4/a;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "b", "", "a", "e", "c", "d", "", "Z", "isLiveActivityShowing", "()Z", "setLiveActivityShowing", "(Z)V", "isReported", "setReported", "Ljava/lang/String;", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "source", "getAutoOpenUrl", "setAutoOpenUrl", "autoOpenUrl", "", "f", "J", "getStartTime", "()J", "setStartTime", "(J)V", "startTime", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isLiveActivityShowing;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isReported;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String autoOpenUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static long startTime;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f426276a = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String source = "";

    a() {
    }

    private final HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap<>();
        String str = autoOpenUrl;
        if (str == null) {
            str = "";
        }
        hashMap.put("auto_open_url", str);
        hashMap.put("from", source);
        return hashMap;
    }

    public final void a() {
        isLiveActivityShowing = true;
        isReported = true;
    }

    public final void c() {
        if (isLiveActivityShowing && isReported) {
            ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("ev_qqlive_web_shown", b());
        }
    }

    public final void d() {
        if (isLiveActivityShowing && isReported) {
            long currentTimeMillis = System.currentTimeMillis() - startTime;
            HashMap<String, String> b16 = b();
            b16.put("activity_time", String.valueOf(currentTimeMillis));
            ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("ev_qqlive_web_activity_close", b16);
        }
        a();
    }

    public final void e() {
        if (isLiveActivityShowing && isReported) {
            startTime = System.currentTimeMillis();
            ((ug4.a) mm4.b.b(ug4.a.class)).reportEvent("ev_qqlive_web_activity_open", b());
        }
    }
}
