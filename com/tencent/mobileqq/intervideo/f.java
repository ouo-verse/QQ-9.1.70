package com.tencent.mobileqq.intervideo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.core.common.ILoggerFactory;
import com.tencent.shadow.core.common.Logger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f implements ILoggerFactory {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static f f238158b;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentMap<String, Logger> f238159a;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Logger {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f238160a;

        a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this, (Object) str);
            } else {
                this.f238160a = str;
            }
        }

        private void a(int i3, String str, Throwable th5) {
            String valueOf = String.valueOf(this.f238160a);
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4 || i3 == 5) {
                            if (th5 == null) {
                                QLog.d(valueOf, 4, str);
                                return;
                            } else {
                                QLog.d(valueOf, 4, str, th5);
                                return;
                            }
                        }
                        return;
                    }
                    if (th5 == null) {
                        QLog.i(valueOf, 2, str);
                        return;
                    } else {
                        QLog.i(valueOf, 2, str, th5);
                        return;
                    }
                }
                if (th5 == null) {
                    QLog.w(valueOf, 1, str);
                    return;
                } else {
                    QLog.w(valueOf, 1, str, th5);
                    return;
                }
            }
            if (th5 == null) {
                QLog.e(valueOf, 1, str);
            } else {
                QLog.e(valueOf, 1, str, th5);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void debug(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                a(4, str, null);
            } else {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void error(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
                a(1, str, null);
            } else {
                iPatchRedirector.redirect((short) 28, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public String getName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.f238160a;
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void info(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
                a(3, str, null);
            } else {
                iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public boolean isDebugEnabled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
            }
            return QLog.isDevelopLevel();
        }

        @Override // com.tencent.shadow.core.common.Logger
        public boolean isErrorEnabled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
                return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
            }
            if (QLog.getUIN_REPORTLOG_LEVEL() >= 1) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.shadow.core.common.Logger
        public boolean isInfoEnabled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
            }
            return QLog.isColorLevel();
        }

        @Override // com.tencent.shadow.core.common.Logger
        public boolean isTraceEnabled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return QLog.isDevelopLevel();
        }

        @Override // com.tencent.shadow.core.common.Logger
        public boolean isWarnEnabled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
            }
            if (QLog.getUIN_REPORTLOG_LEVEL() >= 1) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void trace(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                a(5, str, null);
            } else {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void warn(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
                a(2, str, null);
            } else {
                iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void debug(String str, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
                a(4, h.i(str, obj).a(), null);
            } else {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, obj);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void error(String str, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 29)) {
                a(1, h.i(str, obj).a(), null);
            } else {
                iPatchRedirector.redirect((short) 29, (Object) this, (Object) str, obj);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void info(String str, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
                a(3, h.i(str, obj).a(), null);
            } else {
                iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, obj);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void trace(String str, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                a(5, h.i(str, obj).a(), null);
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, obj);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void warn(String str, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
                a(2, h.i(str, obj).a(), null);
            } else {
                iPatchRedirector.redirect((short) 23, (Object) this, (Object) str, obj);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void debug(String str, Object obj, Object obj2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
                a(4, h.j(str, obj, obj2).a(), null);
            } else {
                iPatchRedirector.redirect((short) 12, this, str, obj, obj2);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void error(String str, Object obj, Object obj2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 30)) {
                a(1, h.j(str, obj, obj2).a(), null);
            } else {
                iPatchRedirector.redirect((short) 30, this, str, obj, obj2);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void info(String str, Object obj, Object obj2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
                a(3, h.j(str, obj, obj2).a(), null);
            } else {
                iPatchRedirector.redirect((short) 18, this, str, obj, obj2);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void trace(String str, Object obj, Object obj2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                a(5, h.j(str, obj, obj2).a(), null);
            } else {
                iPatchRedirector.redirect((short) 6, this, str, obj, obj2);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void warn(String str, Object obj, Object obj2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) {
                a(2, h.j(str, obj, obj2).a(), null);
            } else {
                iPatchRedirector.redirect((short) 24, this, str, obj, obj2);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void debug(String str, Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
                a(4, h.a(str, objArr).a(), null);
            } else {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) objArr);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void error(String str, Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 31)) {
                a(1, h.a(str, objArr).a(), null);
            } else {
                iPatchRedirector.redirect((short) 31, (Object) this, (Object) str, (Object) objArr);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void info(String str, Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
                a(3, h.a(str, objArr).a(), null);
            } else {
                iPatchRedirector.redirect((short) 19, (Object) this, (Object) str, (Object) objArr);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void trace(String str, Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                a(5, h.a(str, objArr).a(), null);
            } else {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) objArr);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void warn(String str, Object... objArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 25)) {
                a(2, h.a(str, objArr).a(), null);
            } else {
                iPatchRedirector.redirect((short) 25, (Object) this, (Object) str, (Object) objArr);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void debug(String str, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
                a(4, str, th5);
            } else {
                iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) th5);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void error(String str, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 32)) {
                a(1, str, th5);
            } else {
                iPatchRedirector.redirect((short) 32, (Object) this, (Object) str, (Object) th5);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void info(String str, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
                a(3, str, th5);
            } else {
                iPatchRedirector.redirect((short) 20, (Object) this, (Object) str, (Object) th5);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void trace(String str, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                a(5, str, th5);
            } else {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) th5);
            }
        }

        @Override // com.tencent.shadow.core.common.Logger
        public void warn(String str, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) {
                a(2, str, th5);
            } else {
                iPatchRedirector.redirect((short) 26, (Object) this, (Object) str, (Object) th5);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24298);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f238158b = new f();
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f238159a = new ConcurrentHashMap();
        }
    }

    public static ILoggerFactory a() {
        return f238158b;
    }

    @Override // com.tencent.shadow.core.common.ILoggerFactory
    public Logger getLogger(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Logger) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        Logger logger = this.f238159a.get(str);
        if (logger != null) {
            return logger;
        }
        a aVar = new a(str);
        Logger putIfAbsent = this.f238159a.putIfAbsent(str, aVar);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        return aVar;
    }
}
