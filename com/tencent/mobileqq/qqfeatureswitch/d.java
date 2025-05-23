package com.tencent.mobileqq.qqfeatureswitch;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.raft.standard.log.IRLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J;\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ\u001c\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J5\u0010\f\u001a\u00020\u00042\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016\u00a2\u0006\u0004\b\f\u0010\u0011J;\u0010\u0012\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\u0012\u0010\rJ\u001c\u0010\u0012\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u0012\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J5\u0010\u0012\u001a\u00020\u00042\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0011J;\u0010\u0013\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\u0013\u0010\rJ\u001c\u0010\u0013\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u0013\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J5\u0010\u0013\u001a\u00020\u00042\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0011J;\u0010\u0014\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\u0014\u0010\rJ\u001c\u0010\u0014\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u0014\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J5\u0010\u0014\u001a\u00020\u00042\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0011J;\u0010\u0015\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\u0015\u0010\rJ\u001c\u0010\u0015\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\u0015\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J5\u0010\u0015\u001a\u00020\u00042\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016\u00a2\u0006\u0004\b\u0015\u0010\u0011JC\u0010\u0018\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u000b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J$\u0010\u0018\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0016J.\u0010\u0018\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J=\u0010\u0018\u001a\u00020\u00042\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016\u00a2\u0006\u0004\b\u0018\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqfeatureswitch/d;", "Lcom/tencent/raft/standard/log/IRLog;", "", "isColorLevel", "", "flushLog", "", "tag", "format", "", "", "args", "v", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "msg", "", "throwable", "([Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "d", "i", "w", "e", "", "logLevel", "log", "(Ljava/lang/String;ILjava/lang/String;[Ljava/lang/Object;)V", "([Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V", "<init>", "()V", "a", "QQFeatureSwitch-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d implements IRLog {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqfeatureswitch/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "QQFeatureSwitch-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqfeatureswitch.d$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32799);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 28)) {
            redirector.redirect((short) 28);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void d(@Nullable String tag, @Nullable String format, @NotNull Object... args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, tag, format, args);
            return;
        }
        Intrinsics.checkNotNullParameter(args, "args");
        if (QLog.isColorLevel()) {
            QLog.d(tag, 2, args);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void e(@Nullable String tag, @Nullable String format, @NotNull Object... args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, tag, format, args);
        } else {
            Intrinsics.checkNotNullParameter(args, "args");
            QLog.e(tag, 1, args);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void flushLog() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            QLog.flushLog();
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void i(@Nullable String tag, @Nullable String format, @NotNull Object... args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, tag, format, args);
            return;
        }
        Intrinsics.checkNotNullParameter(args, "args");
        if (QLog.isColorLevel()) {
            QLog.i(tag, 2, args.toString());
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public boolean isColorLevel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return QLog.isColorLevel();
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void log(@Nullable String[] tag, int logLevel, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 27)) {
            return;
        }
        iPatchRedirector.redirect((short) 27, this, tag, Integer.valueOf(logLevel), msg2, throwable);
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void v(@Nullable String tag, @Nullable String format, @NotNull Object... args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, tag, format, args);
            return;
        }
        Intrinsics.checkNotNullParameter(args, "args");
        if (QLog.isColorLevel()) {
            QLog.d(tag, 2, args);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void w(@Nullable String tag, @Nullable String format, @NotNull Object... args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, tag, format, args);
        } else {
            Intrinsics.checkNotNullParameter(args, "args");
            QLog.w(tag, 1, args.toString());
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void e(@Nullable String tag, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            QLog.e(tag, 1, msg2);
        } else {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) tag, (Object) msg2);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void log(@Nullable String tag, int logLevel, @Nullable String format, @NotNull Object... args) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, tag, Integer.valueOf(logLevel), format, args);
        } else {
            Intrinsics.checkNotNullParameter(args, "args");
            QLog.i(tag, logLevel, args.toString());
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void w(@Nullable String tag, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            QLog.w(tag, 1, msg2);
        } else {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) tag, (Object) msg2);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void d(@Nullable String tag, @Nullable String msg2) {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) tag, (Object) msg2);
            return;
        }
        if (msg2 != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(msg2, "doLoadAllRDeliveryDatasFromDisc it key =", false, 2, null);
            if (startsWith$default) {
                return;
            }
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(msg2, "decodeRDDataFromJson key =", false, 2, null);
            if (startsWith$default2) {
                return;
            }
            startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(msg2, "decodeJsonConfigs op", false, 2, null);
            if (startsWith$default3) {
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(tag, 2, msg2);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void e(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            QLog.e(tag, 1, msg2, throwable);
        } else {
            iPatchRedirector.redirect((short) 22, this, tag, msg2, throwable);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void i(@Nullable String tag, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) tag, (Object) msg2);
        } else if (QLog.isColorLevel()) {
            QLog.i(tag, 2, msg2);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void log(@Nullable String tag, int logLevel, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) {
            QLog.i(tag, logLevel, msg2);
        } else {
            iPatchRedirector.redirect((short) 25, this, tag, Integer.valueOf(logLevel), msg2);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void v(@Nullable String tag, @Nullable String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) tag, (Object) msg2);
        } else if (QLog.isColorLevel()) {
            QLog.d(tag, 2, msg2);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void w(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            QLog.w(tag, 1, msg2, throwable);
        } else {
            iPatchRedirector.redirect((short) 18, this, tag, msg2, throwable);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void e(@Nullable String[] tag, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            QLog.e("ShiplyLogImpl", 1, msg2, throwable);
        } else {
            iPatchRedirector.redirect((short) 23, this, tag, msg2, throwable);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void log(@Nullable String tag, int logLevel, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
            QLog.i(tag, logLevel, msg2, throwable);
        } else {
            iPatchRedirector.redirect((short) 26, this, tag, Integer.valueOf(logLevel), msg2, throwable);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void w(@Nullable String[] tag, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            QLog.w("ShiplyLogImpl", 1, msg2, throwable);
        } else {
            iPatchRedirector.redirect((short) 19, this, tag, msg2, throwable);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void i(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, tag, msg2, throwable);
        } else if (QLog.isColorLevel()) {
            QLog.i(tag, 2, msg2, throwable);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void v(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, tag, msg2, throwable);
        } else if (QLog.isColorLevel()) {
            QLog.d(tag, 2, msg2, throwable);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void i(@Nullable String[] tag, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, tag, msg2, throwable);
        } else if (QLog.isColorLevel()) {
            QLog.i("ShiplyLogImpl", 2, msg2, throwable);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void v(@Nullable String[] tag, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, tag, msg2, throwable);
        } else if (QLog.isColorLevel()) {
            QLog.d("ShiplyLogImpl", 2, msg2, throwable);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void d(@Nullable String tag, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, tag, msg2, throwable);
        } else if (QLog.isColorLevel()) {
            QLog.d(tag, 2, msg2, throwable);
        }
    }

    @Override // com.tencent.raft.standard.log.IRLog
    public void d(@Nullable String[] tag, @Nullable String msg2, @Nullable Throwable throwable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, tag, msg2, throwable);
        } else if (QLog.isColorLevel()) {
            QLog.d("ShiplyLogImpl", 2, msg2, throwable);
        }
    }
}
