package f12;

import com.tencent.qphone.base.BaseConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006J\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0006R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001bR$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\"\u00a8\u0006&"}, d2 = {"Lf12/f;", "", "Lf12/f$a;", "c", "", "i", "", "isGuildTab", tl.h.F, "isBackground", "d", "", "scene", BaseConstants.BROADCAST_USERSYNC_ENTER, "e", "g", "f", "j", "b", "condition", "a", "Ljava/util/Stack;", "Ljava/util/Stack;", "sceneStack", "Ljava/lang/String;", "baseScene", "mediaScene", "Z", "backGround", "hasEnterMainFrame", "inGuildTab", "Ljava/util/ArrayList;", "Lf12/n;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "collectors", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f397616a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Stack<String> sceneStack = new Stack<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String baseScene = "null";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String scene = "null";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String mediaScene = "null";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean backGround;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private static boolean hasEnterMainFrame;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean inGuildTab;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<n> collectors;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0012\u001a\u0004\b\u0003\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0012\u001a\u0004\b\r\u0010\u0013\"\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lf12/f$a;", "", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "baseScene", "e", "j", "scene", "c", "d", "i", "mediaScene", "", "Z", "()Z", "f", "(Z)V", "backGround", tl.h.F, "inGuildTab", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String baseScene = "null";

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String scene = "null";

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String mediaScene = "null";

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean backGround;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean inGuildTab;

        /* renamed from: a, reason: from getter */
        public final boolean getBackGround() {
            return this.backGround;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getBaseScene() {
            return this.baseScene;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getInGuildTab() {
            return this.inGuildTab;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getMediaScene() {
            return this.mediaScene;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getScene() {
            return this.scene;
        }

        public final void f(boolean z16) {
            this.backGround = z16;
        }

        public final void g(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.baseScene = str;
        }

        public final void h(boolean z16) {
            this.inGuildTab = z16;
        }

        public final void i(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.mediaScene = str;
        }

        public final void j(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.scene = str;
        }
    }

    static {
        ArrayList<n> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(b.f397591a, m.f397667a, i.f397630a);
        collectors = arrayListOf;
    }

    f() {
    }

    private final a c() {
        a aVar = new a();
        aVar.j(scene);
        aVar.g(baseScene);
        aVar.i(mediaScene);
        aVar.f(backGround);
        aVar.h(inGuildTab);
        return aVar;
    }

    private final void i() {
        if (!q.h()) {
            return;
        }
        a c16 = c();
        Iterator<T> it = collectors.iterator();
        while (it.hasNext()) {
            ((n) it.next()).a(c16);
        }
    }

    @NotNull
    public final String a(boolean condition) {
        if (condition) {
            return "1";
        }
        return "0";
    }

    public final void b() {
        if (!q.h()) {
            return;
        }
        Iterator<T> it = collectors.iterator();
        while (it.hasNext()) {
            ((n) it.next()).destroy();
        }
    }

    public final void d(boolean isBackground) {
        if (backGround != isBackground) {
            backGround = isBackground;
            i();
        }
    }

    public final void e(@NotNull String scene2, boolean enter) {
        Intrinsics.checkNotNullParameter(scene2, "scene");
        String str = baseScene;
        switch (str.hashCode()) {
            case -2015078605:
                if (str.equals("guild_main_frame") && enter && Intrinsics.areEqual(scene2, "standalone_main_frame")) {
                    baseScene = "multi_main_frame";
                    i();
                    return;
                }
                return;
            case -900650079:
                if (str.equals("standalone_main_frame") && !enter && Intrinsics.areEqual(scene2, "standalone_main_frame")) {
                    baseScene = "null";
                    i();
                    return;
                }
                return;
            case 3392903:
                if (str.equals("null")) {
                    if (!hasEnterMainFrame && Intrinsics.areEqual(scene2, "guild_main_frame")) {
                        hasEnterMainFrame = true;
                    }
                    baseScene = scene2;
                    i();
                    return;
                }
                return;
            case 293164589:
                if (str.equals("multi_main_frame") && !enter && Intrinsics.areEqual(scene2, "standalone_main_frame")) {
                    baseScene = "guild_main_frame";
                    i();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void f(@NotNull String scene2, boolean enter) {
        Intrinsics.checkNotNullParameter(scene2, "scene");
        if (enter) {
            mediaScene = scene2;
            i();
        } else if (Intrinsics.areEqual(mediaScene, scene2)) {
            mediaScene = "null";
            i();
        }
    }

    public final void g(@NotNull String scene2, boolean enter) {
        Intrinsics.checkNotNullParameter(scene2, "scene");
        if (enter) {
            scene = scene2;
            i();
        } else if (Intrinsics.areEqual(scene, scene2)) {
            scene = "null";
            i();
        }
    }

    public final void h(boolean isGuildTab) {
        if (inGuildTab != isGuildTab) {
            inGuildTab = isGuildTab;
            i();
        }
    }

    public final void j() {
        if (!q.h()) {
            return;
        }
        d.f397604d.f();
    }
}
