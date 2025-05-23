package ee4;

import android.util.Log;
import com.tencent.tav.decoder.logger.ILog;
import com.tencent.tav.decoder.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.utils.ILightLogger;
import org.light.utils.LightLogUtil;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u001c\u0010\r\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0007J\u001c\u0010\u000e\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0007J\u001c\u0010\u000f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0007J\u001c\u0010\u0010\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0007J\u001c\u0010\u0011\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0007J&\u0010\u0014\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007J\u0006\u0010\u0015\u001a\u00020\u0007R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0016R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lee4/b;", "", "", "f", "Lee4/a;", "iLogProxy", h.F, "", "level", "g", "", "tag", "message", "i", "a", "e", "j", "b", "", "t", "c", "d", "Lee4/a;", "I", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static ee4.a iLogProxy;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int level;

    /* renamed from: c, reason: collision with root package name */
    public static final b f396211c;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\n\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lee4/b$a;", "Lee4/a;", "", "tag", "message", "", "v", "d", "i", "w", "e", "", "t", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    private static final class a implements ee4.a {
        @Override // ee4.a
        public void d(@Nullable String tag, @Nullable String message) {
            Log.d(tag, message);
        }

        @Override // ee4.a
        public void e(@Nullable String tag, @Nullable String message) {
            Log.e(tag, message);
        }

        @Override // ee4.a
        public void i(@Nullable String tag, @Nullable String message) {
            Log.i(tag, message);
        }

        @Override // ee4.a
        public void v(@Nullable String tag, @Nullable String message) {
            Log.v(tag, message);
        }

        @Override // ee4.a
        public void w(@Nullable String tag, @Nullable String message) {
            Log.w(tag, message);
        }

        @Override // ee4.a
        public void e(@Nullable String tag, @Nullable String message, @Nullable Throwable t16) {
            Log.e(tag, message, t16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\t\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\f\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\r"}, d2 = {"ee4/b$b", "Lcom/tencent/tav/decoder/logger/ILog;", "", "tag", "message", "", "i", "w", "v", "e", "", "t", "d", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: ee4.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C10234b implements ILog {
        C10234b() {
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public void d(@Nullable String tag, @Nullable String message) {
            b.a(tag, message);
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public void e(@Nullable String tag, @Nullable String message) {
            b.b(tag, message);
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public void i(@Nullable String tag, @Nullable String message) {
            b.e(tag, message);
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public void v(@Nullable String tag, @Nullable String message) {
            b.i(tag, message);
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public void w(@Nullable String tag, @Nullable String message) {
            b.j(tag, message);
        }

        @Override // com.tencent.tav.decoder.logger.ILog
        public void e(@Nullable String tag, @Nullable String message, @Nullable Throwable t16) {
            b.c(tag, message, t16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J.\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\r\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u000e\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u000e\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u000f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u000f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u0010"}, d2 = {"ee4/b$c", "Lorg/light/utils/ILightLogger;", "", "p0", "", "p1", "p2", "", "log", "", "p3", "e", "w", "i", "d", "v", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class c implements ILightLogger {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ee4.a f396212a;

        c(ee4.a aVar) {
            this.f396212a = aVar;
        }

        @Override // org.light.utils.ILightLogger
        public void d(@Nullable String p06, @Nullable String p16) {
            this.f396212a.d(p06, p16);
        }

        @Override // org.light.utils.ILightLogger
        public void e(@Nullable String p06, @Nullable String p16) {
            this.f396212a.e(p06, p16);
        }

        @Override // org.light.utils.ILightLogger
        public void i(@Nullable String p06, @Nullable String p16) {
            this.f396212a.i(p06, p16);
        }

        @Override // org.light.utils.ILightLogger
        public void log(int p06, @Nullable String p16, @Nullable String p26) {
            if (p06 == 4) {
                b.e(p16, p26);
                return;
            }
            if (p06 == 5) {
                b.j(p16, p26);
                return;
            }
            if (p06 == 6) {
                b.b(p16, p26);
            } else if (p06 != 7) {
                b.a(p16, p26);
            } else {
                b.b(p16, p26);
            }
        }

        @Override // org.light.utils.ILightLogger
        public void v(@Nullable String p06, @Nullable String p16) {
            this.f396212a.v(p06, p16);
        }

        @Override // org.light.utils.ILightLogger
        public void w(@Nullable String p06, @Nullable String p16) {
            this.f396212a.w(p06, p16);
        }

        @Override // org.light.utils.ILightLogger
        public void d(@Nullable String p06, @Nullable String p16, @Nullable Throwable p26) {
            this.f396212a.d(p06, p16);
        }

        @Override // org.light.utils.ILightLogger
        public void e(@Nullable String p06, @Nullable String p16, @Nullable Throwable p26) {
            this.f396212a.e(p06, p16, p26);
        }

        @Override // org.light.utils.ILightLogger
        public void i(@Nullable String p06, @Nullable String p16, @Nullable Throwable p26) {
            this.f396212a.i(p06, p16);
        }

        @Override // org.light.utils.ILightLogger
        public void v(@Nullable String p06, @Nullable String p16, @Nullable Throwable p26) {
            this.f396212a.v(p06, p16);
        }

        @Override // org.light.utils.ILightLogger
        public void w(@Nullable String p06, @Nullable String p16, @Nullable Throwable p26) {
            this.f396212a.w(p06, p16);
        }

        @Override // org.light.utils.ILightLogger
        public void log(int p06, @Nullable String p16, @Nullable String p26, @Nullable Throwable p36) {
            if (p06 == 4) {
                b.e(p16, p26);
                return;
            }
            if (p06 == 5) {
                b.j(p16, p26);
                return;
            }
            if (p06 == 6) {
                b.c(p16, p26, p36);
            } else if (p06 != 7) {
                b.a(p16, p26);
            } else {
                b.c(p16, p26, p36);
            }
        }
    }

    static {
        b bVar = new b();
        f396211c = bVar;
        iLogProxy = new a();
        level = Integer.MAX_VALUE;
        bVar.f();
    }

    b() {
    }

    @JvmStatic
    public static final void a(@Nullable String tag, @Nullable String message) {
        if (level > 3) {
            return;
        }
        iLogProxy.d(tag, message);
    }

    @JvmStatic
    public static final void b(@Nullable String tag, @Nullable String message) {
        if (level > 6) {
            return;
        }
        iLogProxy.e(tag, message);
    }

    @JvmStatic
    public static final void c(@Nullable String tag, @Nullable String message, @Nullable Throwable t16) {
        if (level > 6) {
            return;
        }
        iLogProxy.e(tag, message, t16);
    }

    @JvmStatic
    public static final void e(@Nullable String tag, @Nullable String message) {
        if (level > 4) {
            return;
        }
        iLogProxy.i(tag, message);
    }

    private final void f() {
        Logger.setLogProxy(new C10234b());
        Logger.setLevel(level);
    }

    @JvmStatic
    public static final void g(int level2) {
        level = level2;
        Logger.setLevel(level2);
    }

    @JvmStatic
    public static final void h(@NotNull ee4.a iLogProxy2) {
        Intrinsics.checkParameterIsNotNull(iLogProxy2, "iLogProxy");
        iLogProxy = iLogProxy2;
        LightLogUtil.setLightLogger(new c(iLogProxy2));
    }

    @JvmStatic
    public static final void i(@Nullable String tag, @Nullable String message) {
        if (level > 2) {
            return;
        }
        iLogProxy.v(tag, message);
    }

    @JvmStatic
    public static final void j(@Nullable String tag, @Nullable String message) {
        if (level > 5) {
            return;
        }
        iLogProxy.w(tag, message);
    }

    public final int d() {
        return level;
    }
}
