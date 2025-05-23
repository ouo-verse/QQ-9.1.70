package com.tencent.videocut.utils.log;

import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\r\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u001c\u0010\u000b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007J&\u0010\f\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/videocut/utils/log/b;", "", "", "tag", "message", "", "e", "d", "a", "", "t", "c", "b", "com/tencent/videocut/utils/log/b$a", "Lcom/tencent/videocut/utils/log/b$a;", "defaultProxy", "", "I", "level", "Lcom/tencent/videocut/utils/log/a;", "Lcom/tencent/videocut/utils/log/a;", "logProxy", "<init>", "()V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final a defaultProxy;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int level;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static com.tencent.videocut.utils.log.a logProxy;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final b f384254d;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0007\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/videocut/utils/log/b$a", "Lcom/tencent/videocut/utils/log/a;", "", "tag", "message", "", "v", "i", "e", "", "t", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a implements com.tencent.videocut.utils.log.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            }
        }

        @Override // com.tencent.videocut.utils.log.a
        public void e(@Nullable String tag, @Nullable String message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                Log.e(tag, message);
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) tag, (Object) message);
            }
        }

        @Override // com.tencent.videocut.utils.log.a
        public void i(@Nullable String tag, @Nullable String message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) tag, (Object) message);
            } else {
                Log.i(tag, message);
            }
        }

        @Override // com.tencent.videocut.utils.log.a
        public void v(@Nullable String tag, @Nullable String message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) tag, (Object) message);
            } else {
                Log.v(tag, message);
            }
        }

        @Override // com.tencent.videocut.utils.log.a
        public void e(@Nullable String tag, @Nullable Throwable t16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                Log.e(tag, "", t16);
            } else {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) tag, (Object) t16);
            }
        }

        @Override // com.tencent.videocut.utils.log.a
        public void e(@Nullable String tag, @Nullable String message, @Nullable Throwable t16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                Log.e(tag, message, t16);
            } else {
                iPatchRedirector.redirect((short) 7, this, tag, message, t16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10224);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f384254d = new b();
        a aVar = new a();
        defaultProxy = aVar;
        level = 2;
        logProxy = aVar;
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@Nullable String tag, @Nullable String message) {
        if (level > 6) {
            return;
        }
        logProxy.e(tag, message);
    }

    @JvmStatic
    public static final void b(@Nullable String tag, @Nullable String message, @Nullable Throwable t16) {
        if (level > 6) {
            return;
        }
        logProxy.e(tag, message, t16);
    }

    @JvmStatic
    public static final void c(@Nullable String tag, @Nullable Throwable t16) {
        if (level > 6) {
            return;
        }
        logProxy.e(tag, t16);
    }

    @JvmStatic
    public static final void d(@Nullable String tag, @Nullable String message) {
        if (level > 4) {
            return;
        }
        logProxy.i(tag, message);
    }

    @JvmStatic
    public static final void e(@Nullable String tag, @Nullable String message) {
        if (level > 2) {
            return;
        }
        logProxy.v(tag, message);
    }
}
