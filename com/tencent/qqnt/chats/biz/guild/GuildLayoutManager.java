package com.tencent.qqnt.chats.biz.guild;

import android.os.Handler;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.impl.s;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.chats.api.IGuildLayoutHelper;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0001L\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0005R#*/4B\t\b\u0002\u00a2\u0006\u0004\bQ\u0010(J\u001e\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0007J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J\b\u0010\f\u001a\u00020\u000bH\u0007J\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\u000bJ\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u000bJ\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u000bR<\u0010)\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 0\u001fj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0 `\"8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b#\u0010$\u0012\u0004\b'\u0010(\u001a\u0004\b%\u0010&R\u001d\u0010.\u001a\u0004\u0018\u00010!8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u001d\u00102\u001a\u0004\u0018\u00010\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u0010+\u001a\u0004\b0\u00101R\"\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030\u00040\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\"\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070\u00040\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u00105R\"\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002090\u00040\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00105R\u0018\u0010<\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010;R\u0016\u0010>\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010=R\u0016\u0010@\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010?R\u0016\u0010C\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010D\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010BR\u0017\u0010G\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b%\u0010E\u001a\u0004\bA\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010N\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010MR\u0011\u0010P\u001a\u00020\u001b8F\u00a2\u0006\u0006\u001a\u0004\bI\u0010O\u00a8\u0006S"}, d2 = {"Lcom/tencent/qqnt/chats/biz/guild/GuildLayoutManager;", "", "T", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lmqq/util/WeakReference;", "", "f", "", "g", "", "j", "", "o", "", "i", "p", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", ReportConstant.COSTREPORT_PREFIX, "progress", "v", "Lcom/tencent/qqnt/chats/biz/guild/GuildLayoutManager$b;", "state", "u", NodeProps.VISIBLE, HippyTKDListViewAdapter.X, "", "status", "t", "y", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/chats/biz/guild/h;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ljava/util/ArrayList;", "getInjectClz$annotations", "()V", "injectClz", "c", "Lkotlin/Lazy;", "l", "()Lcom/tencent/qqnt/chats/biz/guild/h;", "guildLayoutInject", "d", "getPerfLevel", "()Ljava/lang/Integer;", "perfLevel", "Lcom/tencent/qqnt/chats/biz/guild/GuildLayoutManager$d;", "e", "Ljava/util/concurrent/CopyOnWriteArrayList;", "progressAwares", "Lcom/tencent/qqnt/chats/biz/guild/GuildLayoutManager$e;", "visibleAwares", "Lcom/tencent/qqnt/chats/biz/guild/GuildLayoutManager$a;", "animationAwares", "Ljava/lang/String;", "mCurGuildId", "Lcom/tencent/qqnt/chats/biz/guild/GuildLayoutManager$b;", "mCurGuildState", UserInfo.SEX_FEMALE, "curProgress", "k", "Z", "isOpenState", "needShowBanner", "I", "()I", "GUILD_AVATAR_CORNER", "Landroid/os/Handler;", DomainData.DOMAIN_NAME, "Landroid/os/Handler;", "handler", "com/tencent/qqnt/chats/biz/guild/GuildLayoutManager$cleanWeakReferences$1", "Lcom/tencent/qqnt/chats/biz/guild/GuildLayoutManager$cleanWeakReferences$1;", "cleanWeakReferences", "()J", "latestSubscribeGuildId", "<init>", "a", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class GuildLayoutManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildLayoutManager f354256a = new GuildLayoutManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/inject_GuildLayoutInject.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<h>> injectClz;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy guildLayoutInject;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy perfLevel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CopyOnWriteArrayList<WeakReference<d>> progressAwares;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CopyOnWriteArrayList<WeakReference<e>> visibleAwares;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CopyOnWriteArrayList<WeakReference<a>> animationAwares;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String mCurGuildId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static GuildState mCurGuildState;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private static float curProgress;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private static boolean isOpenState;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static boolean needShowBanner;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private static final int GUILD_AVATAR_CORNER;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Handler handler;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final GuildLayoutManager$cleanWeakReferences$1 cleanWeakReferences;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/chats/biz/guild/GuildLayoutManager$a;", "", "", "status", "", "a", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public interface a {
        void a(long status);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/chats/biz/guild/GuildLayoutManager$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "displayGuildId", "Z", "()Z", "displayDiscovery", "<init>", "(Ljava/lang/String;Z)V", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.biz.guild.GuildLayoutManager$b, reason: from toString */
    /* loaded from: classes24.dex */
    public static final /* data */ class GuildState {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String displayGuildId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean displayDiscovery;

        public GuildState(@NotNull String displayGuildId, boolean z16) {
            Intrinsics.checkNotNullParameter(displayGuildId, "displayGuildId");
            this.displayGuildId = displayGuildId;
            this.displayDiscovery = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getDisplayDiscovery() {
            return this.displayDiscovery;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getDisplayGuildId() {
            return this.displayGuildId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildState)) {
                return false;
            }
            GuildState guildState = (GuildState) other;
            if (Intrinsics.areEqual(this.displayGuildId, guildState.displayGuildId) && this.displayDiscovery == guildState.displayDiscovery) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.displayGuildId.hashCode() * 31;
            boolean z16 = this.displayDiscovery;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "GuildState(displayGuildId=" + this.displayGuildId + ", displayDiscovery=" + this.displayDiscovery + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/chats/biz/guild/GuildLayoutManager$c;", "", "", "guildId", "", "onResult", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public interface c {
        void onResult(@Nullable String guildId);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/chats/biz/guild/GuildLayoutManager$d;", "", "", "progress", "", "J", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public interface d {
        void J(float progress);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqnt/chats/biz/guild/GuildLayoutManager$e;", "", "", NodeProps.VISIBLE, "", "onVisibleChanged", "chats_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public interface e {
        void onVisibleChanged(boolean visible);
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [com.tencent.qqnt.chats.biz.guild.GuildLayoutManager$cleanWeakReferences$1] */
    static {
        Lazy lazy;
        Lazy lazy2;
        ArrayList<Class<h>> arrayList = new ArrayList<>();
        injectClz = arrayList;
        arrayList.add(s.class);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<h>() { // from class: com.tencent.qqnt.chats.biz.guild.GuildLayoutManager$guildLayoutInject$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
            /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final h invoke() {
                Object firstOrNull;
                Object obj;
                Constructor<?>[] constructors;
                Object first;
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) GuildLayoutManager.m());
                Class cls = (Class) firstOrNull;
                if (cls != null && (constructors = cls.getConstructors()) != null) {
                    first = ArraysKt___ArraysKt.first(constructors);
                    Constructor constructor = (Constructor) first;
                    if (constructor != null) {
                        obj = constructor.newInstance(new Object[0]);
                        if (obj instanceof h) {
                            return null;
                        }
                        return (h) obj;
                    }
                }
                obj = null;
                if (obj instanceof h) {
                }
            }
        });
        guildLayoutInject = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.qqnt.chats.biz.guild.GuildLayoutManager$perfLevel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Integer invoke() {
                h l3 = GuildLayoutManager.f354256a.l();
                if (l3 == null) {
                    return null;
                }
                BaseApplication context = BaseApplication.context;
                Intrinsics.checkNotNullExpressionValue(context, "context");
                return Integer.valueOf(l3.a(context));
            }
        });
        perfLevel = lazy2;
        progressAwares = new CopyOnWriteArrayList<>();
        visibleAwares = new CopyOnWriteArrayList<>();
        animationAwares = new CopyOnWriteArrayList<>();
        mCurGuildId = "";
        mCurGuildState = new GuildState("", false);
        isOpenState = true;
        needShowBanner = true;
        GUILD_AVATAR_CORNER = com.tencent.qqnt.base.utils.c.f353052a.a(26.0f);
        handler = new Handler(ThreadManagerV2.getSubThreadLooper());
        cleanWeakReferences = new Runnable() { // from class: com.tencent.qqnt.chats.biz.guild.GuildLayoutManager$cleanWeakReferences$1
            @Override // java.lang.Runnable
            public void run() {
                CopyOnWriteArrayList copyOnWriteArrayList;
                CopyOnWriteArrayList copyOnWriteArrayList2;
                CopyOnWriteArrayList copyOnWriteArrayList3;
                GuildLayoutManager guildLayoutManager = GuildLayoutManager.f354256a;
                copyOnWriteArrayList = GuildLayoutManager.progressAwares;
                guildLayoutManager.f(copyOnWriteArrayList);
                copyOnWriteArrayList2 = GuildLayoutManager.visibleAwares;
                guildLayoutManager.f(copyOnWriteArrayList2);
                copyOnWriteArrayList3 = GuildLayoutManager.animationAwares;
                guildLayoutManager.f(copyOnWriteArrayList3);
            }
        };
    }

    GuildLayoutManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> void f(CopyOnWriteArrayList<WeakReference<T>> copyOnWriteArrayList) {
        Set set;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        for (T t16 : copyOnWriteArrayList) {
            if (((WeakReference) t16).get() == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(t16);
            }
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList);
        copyOnWriteArrayList.removeAll(set);
    }

    @JvmStatic
    public static final int g() {
        return BaseApplication.context.getResources().getDimensionPixelSize(R.dimen.f158989ci4);
    }

    @JvmStatic
    @Nullable
    public static final String j() {
        return mCurGuildId;
    }

    @NotNull
    public static final ArrayList<Class<h>> m() {
        return injectClz;
    }

    @JvmStatic
    public static final boolean o() {
        return needShowBanner;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w() {
        ((IGuildLayoutHelper) QRoute.api(IGuildLayoutHelper.class)).setGuildDisplayStatus(1L, j());
    }

    public final float h() {
        return curProgress / 100.0f;
    }

    public final float i() {
        return curProgress;
    }

    public final int k() {
        return GUILD_AVATAR_CORNER;
    }

    @Nullable
    public final h l() {
        return (h) guildLayoutInject.getValue();
    }

    public final long n() {
        h l3 = l();
        if (l3 != null) {
            return l3.b();
        }
        return 0L;
    }

    public final float p() {
        float f16 = curProgress;
        if (f16 < 30.0f) {
            return 0.0f;
        }
        return (f16 - 30.0f) / 70.0f;
    }

    public final boolean q() {
        boolean z16;
        if (curProgress == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        return !z16;
    }

    public final boolean r() {
        if (curProgress == 100.0f) {
            return true;
        }
        return false;
    }

    public final boolean s() {
        boolean z16;
        boolean z17;
        float f16 = curProgress;
        if (f16 == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (isOpenState) {
                return true;
            }
            if (f16 == 100.0f) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                return true;
            }
        }
        return false;
    }

    public final void t(long status) {
        CopyOnWriteArrayList<WeakReference<a>> copyOnWriteArrayList = animationAwares;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            a aVar = (a) ((WeakReference) it.next()).get();
            if (aVar != null) {
                arrayList.add(aVar);
            }
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            ((a) it5.next()).a(status);
        }
    }

    public final void u(@NotNull GuildState state) {
        boolean z16;
        Intrinsics.checkNotNullParameter(state, "state");
        mCurGuildId = state.getDisplayGuildId();
        mCurGuildState = state;
        if (state.getDisplayGuildId().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !state.getDisplayDiscovery()) {
            t(0L);
        } else {
            t(1L);
        }
    }

    public final void v(float progress) {
        boolean z16;
        curProgress = progress;
        boolean z17 = false;
        if (progress == 100.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            isOpenState = false;
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.qqnt.chats.biz.guild.d
                @Override // java.lang.Runnable
                public final void run() {
                    GuildLayoutManager.w();
                }
            }, 100L);
        } else {
            if (progress == 0.0f) {
                z17 = true;
            }
            if (z17) {
                isOpenState = true;
                ((IGuildLayoutHelper) QRoute.api(IGuildLayoutHelper.class)).setGuildDisplayStatus(0L, j());
            } else {
                ((IGuildLayoutHelper) QRoute.api(IGuildLayoutHelper.class)).setGuildDisplayStatus(0L, j());
            }
        }
        CopyOnWriteArrayList<WeakReference<d>> copyOnWriteArrayList = progressAwares;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            d dVar = (d) ((WeakReference) it.next()).get();
            if (dVar != null) {
                arrayList.add(dVar);
            }
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            ((d) it5.next()).J(progress);
        }
    }

    public final void x(boolean visible) {
        CopyOnWriteArrayList<WeakReference<e>> copyOnWriteArrayList = visibleAwares;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            e eVar = (e) ((WeakReference) it.next()).get();
            if (eVar != null) {
                arrayList.add(eVar);
            }
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            ((e) it5.next()).onVisibleChanged(visible);
        }
    }

    public final boolean y() {
        boolean z16;
        if (mCurGuildState.getDisplayGuildId().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || mCurGuildState.getDisplayDiscovery()) {
            return true;
        }
        return false;
    }
}
