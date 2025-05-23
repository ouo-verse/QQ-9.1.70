package ap0;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\rR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\rR\u0016\u0010\u001e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\rR\u0016\u0010 \u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\r\u00a8\u0006#"}, d2 = {"Lap0/f;", "", "Lzo0/a;", "a", "", "factoryName", "b", "Lzo0/a;", "guildRobotAtHelper", "c", "articleGuildRobotAtHelper", "", "d", "Z", "isAtListeningBlocked", "", "e", "I", "firstSpanEnd", "f", "robotFunctionPanelBlockTime", "g", "isSlashListeningBlocked", "Lap0/b;", h.F, "Lap0/b;", "guildSlashHelper", "i", "isSlashPanelOpenFromBtn", "j", "isSlashPanelOpenFromAdd", "k", "needFetchNewData", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public static zo0.a guildRobotAtHelper;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public static zo0.a articleGuildRobotAtHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static boolean isAtListeningBlocked;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static int robotFunctionPanelBlockTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static boolean isSlashListeningBlocked;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @Nullable
    public static b guildSlashHelper;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static boolean isSlashPanelOpenFromBtn;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static boolean isSlashPanelOpenFromAdd;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static boolean needFetchNewData;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f26660a = new f();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static int firstSpanEnd = -1;

    f() {
    }

    @JvmStatic
    @Nullable
    public static final zo0.a a() {
        return b("default");
    }

    @JvmStatic
    @Nullable
    public static final zo0.a b(@NotNull String factoryName) {
        zo0.a aVar;
        Intrinsics.checkNotNullParameter(factoryName, "factoryName");
        if (TextUtils.equals(factoryName, hn0.a.class.getName())) {
            return articleGuildRobotAtHelper;
        }
        if (TextUtils.equals(factoryName, "default") && (aVar = articleGuildRobotAtHelper) != null) {
            return aVar;
        }
        return guildRobotAtHelper;
    }
}
