package o02;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R0\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00028\u0006@FX\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0007\u0010\b\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u000b\u0010\u0010\u0012\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0007\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lo02/b;", "", "", "guildEnterSource", "", "d", "source", "b", "I", "a", "()I", "c", "(I)V", "getSource$annotations", "()V", "", "Z", "()Z", "setGuildAioType", "(Z)V", "isGuildAioType$annotations", "isGuildAioType", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f421699a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int source = 11;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isGuildAioType;

    b() {
    }

    public static final int a() {
        return source;
    }

    public static final boolean b() {
        return isGuildAioType;
    }

    public static final void c(int i3) {
        source = i3;
        isGuildAioType = false;
        f421699a.d(i3);
        QLog.i("Guild.jump.GuildEnterSource", 1, "setSource(" + i3 + ") isGuildAioType(" + isGuildAioType + ")");
        if (QLog.isDevelopLevel()) {
            QLog.d("Guild.jump.GuildEnterSource", 2, new RuntimeException("BACKTRACE:"), new Object[0]);
        }
    }

    private final void d(int guildEnterSource) {
        if (guildEnterSource != 3 && guildEnterSource != 10) {
            isGuildAioType = false;
        } else {
            isGuildAioType = true;
        }
    }
}
