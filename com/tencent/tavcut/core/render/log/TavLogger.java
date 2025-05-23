package com.tencent.tavcut.core.render.log;

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
import rd4.a;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007J\u001c\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007J&\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u0006\u0010\u000f\u001a\u00020\u0006J\u001c\u0010\u0010\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007J\b\u0010\u0011\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007J\u001c\u0010\u0014\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007J\u001c\u0010\u0015\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/tavcut/core/render/log/TavLogger;", "", "()V", "iLogProxy", "Lcom/tencent/tavcut/core/render/log/ILogProxy;", "level", "", "d", "", "tag", "", "message", "e", "t", "", "getLevel", "i", "proxyTavLog", "setLevel", "setProxy", "v", "w", "DefaultLogProxy", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final class TavLogger {
    public static final TavLogger INSTANCE;
    private static ILogProxy iLogProxy;
    private static int level;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J&\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/tavcut/core/render/log/TavLogger$DefaultLogProxy;", "Lcom/tencent/tavcut/core/render/log/ILogProxy;", "()V", "d", "", "tag", "", "message", "e", "t", "", "i", "v", "w", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    private static final class DefaultLogProxy implements ILogProxy {
        @Override // com.tencent.tavcut.core.render.log.ILogProxy
        public void d(@Nullable String tag, @Nullable String message) {
            Log.d(tag, message);
        }

        @Override // com.tencent.tavcut.core.render.log.ILogProxy
        public void e(@Nullable String tag, @Nullable String message) {
            Log.e(tag, message);
        }

        @Override // com.tencent.tavcut.core.render.log.ILogProxy
        public void i(@Nullable String tag, @Nullable String message) {
            Log.i(tag, message);
        }

        @Override // com.tencent.tavcut.core.render.log.ILogProxy
        public void v(@Nullable String tag, @Nullable String message) {
            Log.v(tag, message);
        }

        @Override // com.tencent.tavcut.core.render.log.ILogProxy
        public void w(@Nullable String tag, @Nullable String message) {
            Log.w(tag, message);
        }

        @Override // com.tencent.tavcut.core.render.log.ILogProxy
        public void e(@Nullable String tag, @Nullable String message, @Nullable Throwable t16) {
            Log.e(tag, message, t16);
        }
    }

    static {
        TavLogger tavLogger = new TavLogger();
        INSTANCE = tavLogger;
        iLogProxy = new DefaultLogProxy();
        level = 6;
        if (!a.f431127a) {
            level = Integer.MAX_VALUE;
        }
        tavLogger.proxyTavLog();
    }

    TavLogger() {
    }

    @JvmStatic
    public static final void d(@Nullable String tag, @Nullable String message) {
        if (level > 3) {
            return;
        }
        iLogProxy.d(tag, message);
    }

    @JvmStatic
    public static final void e(@Nullable String tag, @Nullable String message) {
        if (level > 6) {
            return;
        }
        iLogProxy.e(tag, message);
    }

    @JvmStatic
    public static final void i(@Nullable String tag, @Nullable String message) {
        if (level > 4) {
            return;
        }
        iLogProxy.i(tag, message);
    }

    private final void proxyTavLog() {
        Logger.setLogProxy(new ILog() { // from class: com.tencent.tavcut.core.render.log.TavLogger$proxyTavLog$1
            @Override // com.tencent.tav.decoder.logger.ILog
            public void d(@Nullable String tag, @Nullable String message) {
                TavLogger.d(tag, message);
            }

            @Override // com.tencent.tav.decoder.logger.ILog
            public void e(@Nullable String tag, @Nullable String message) {
                TavLogger.e(tag, message);
            }

            @Override // com.tencent.tav.decoder.logger.ILog
            public void i(@Nullable String tag, @Nullable String message) {
                TavLogger.i(tag, message);
            }

            @Override // com.tencent.tav.decoder.logger.ILog
            public void v(@Nullable String tag, @Nullable String message) {
                TavLogger.v(tag, message);
            }

            @Override // com.tencent.tav.decoder.logger.ILog
            public void w(@Nullable String tag, @Nullable String message) {
                TavLogger.w(tag, message);
            }

            @Override // com.tencent.tav.decoder.logger.ILog
            public void e(@Nullable String tag, @Nullable String message, @Nullable Throwable t16) {
                TavLogger.e(tag, message, t16);
            }
        });
        Logger.setLevel(level);
    }

    @JvmStatic
    public static final void setLevel(int level2) {
        level = level2;
        Logger.setLevel(level2);
    }

    @JvmStatic
    public static final void setProxy(@NotNull final ILogProxy iLogProxy2) {
        Intrinsics.checkParameterIsNotNull(iLogProxy2, "iLogProxy");
        iLogProxy = iLogProxy2;
        LightLogUtil.setLightLogger(new ILightLogger() { // from class: com.tencent.tavcut.core.render.log.TavLogger$setProxy$1
            @Override // org.light.utils.ILightLogger
            public void d(@Nullable String p06, @Nullable String p16) {
                ILogProxy.this.d(p06, p16);
            }

            @Override // org.light.utils.ILightLogger
            public void e(@Nullable String p06, @Nullable String p16) {
                ILogProxy.this.e(p06, p16);
            }

            @Override // org.light.utils.ILightLogger
            public void i(@Nullable String p06, @Nullable String p16) {
                ILogProxy.this.i(p06, p16);
            }

            @Override // org.light.utils.ILightLogger
            public void log(int p06, @Nullable String p16, @Nullable String p26) {
                if (p06 == 4) {
                    TavLogger.i(p16, p26);
                    return;
                }
                if (p06 == 5) {
                    TavLogger.w(p16, p26);
                    return;
                }
                if (p06 == 6) {
                    TavLogger.e(p16, p26);
                } else if (p06 != 7) {
                    TavLogger.d(p16, p26);
                } else {
                    TavLogger.e(p16, p26);
                }
            }

            @Override // org.light.utils.ILightLogger
            public void v(@Nullable String p06, @Nullable String p16) {
                ILogProxy.this.v(p06, p16);
            }

            @Override // org.light.utils.ILightLogger
            public void w(@Nullable String p06, @Nullable String p16) {
                ILogProxy.this.w(p06, p16);
            }

            @Override // org.light.utils.ILightLogger
            public void d(@Nullable String p06, @Nullable String p16, @Nullable Throwable p26) {
                ILogProxy.this.d(p06, p16);
            }

            @Override // org.light.utils.ILightLogger
            public void e(@Nullable String p06, @Nullable String p16, @Nullable Throwable p26) {
                ILogProxy.this.e(p06, p16, p26);
            }

            @Override // org.light.utils.ILightLogger
            public void i(@Nullable String p06, @Nullable String p16, @Nullable Throwable p26) {
                ILogProxy.this.i(p06, p16);
            }

            @Override // org.light.utils.ILightLogger
            public void v(@Nullable String p06, @Nullable String p16, @Nullable Throwable p26) {
                ILogProxy.this.v(p06, p16);
            }

            @Override // org.light.utils.ILightLogger
            public void w(@Nullable String p06, @Nullable String p16, @Nullable Throwable p26) {
                ILogProxy.this.w(p06, p16);
            }

            @Override // org.light.utils.ILightLogger
            public void log(int p06, @Nullable String p16, @Nullable String p26, @Nullable Throwable p36) {
                if (p06 == 4) {
                    TavLogger.i(p16, p26);
                    return;
                }
                if (p06 == 5) {
                    TavLogger.w(p16, p26);
                    return;
                }
                if (p06 == 6) {
                    TavLogger.e(p16, p26, p36);
                } else if (p06 != 7) {
                    TavLogger.d(p16, p26);
                } else {
                    TavLogger.e(p16, p26, p36);
                }
            }
        });
    }

    @JvmStatic
    public static final void v(@Nullable String tag, @Nullable String message) {
        if (level > 2) {
            return;
        }
        iLogProxy.v(tag, message);
    }

    @JvmStatic
    public static final void w(@Nullable String tag, @Nullable String message) {
        if (level > 5) {
            return;
        }
        iLogProxy.w(tag, message);
    }

    public final int getLevel() {
        return level;
    }

    @JvmStatic
    public static final void e(@Nullable String tag, @Nullable String message, @Nullable Throwable t16) {
        if (level > 6) {
            return;
        }
        iLogProxy.e(tag, message, t16);
    }
}
