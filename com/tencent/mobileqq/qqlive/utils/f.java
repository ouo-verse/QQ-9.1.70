package com.tencent.mobileqq.qqlive.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.common.api.AegisLogger;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlive/utils/f;", "", "", "b", "", "a", "", "J", "lastGetMemoryTimeStamp", "c", "MIN_INTERVAL_FOR_GET_MEM_INFO", "d", "[J", "lastGetMemory", "<init>", "()V", "qq-live-common-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f273448a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static long lastGetMemoryTimeStamp;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public static long MIN_INTERVAL_FOR_GET_MEM_INFO;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static long[] lastGetMemory;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28276);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f273448a = new f();
            MIN_INTERVAL_FOR_GET_MEM_INFO = 10000L;
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final long[] b() {
        long[] jArr = new long[4];
        try {
            Method method = Class.forName("android.os.Process").getMethod("readProcLines", String.class, String[].class, long[].class);
            String[] strArr = {"MemTotal:", "MemFree:", "Buffers:", "Cached:"};
            long[] jArr2 = {0, 0, 0, 0};
            if (method != null) {
                method.invoke(null, "/proc/meminfo", strArr, jArr2);
                for (int i3 = 0; i3 < 4; i3++) {
                    jArr[i3] = jArr2[i3] / 1024;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return jArr;
    }

    public final double a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Double) iPatchRedirector.redirect((short) 2, (Object) this)).doubleValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = lastGetMemoryTimeStamp;
        if (j3 == 0 || currentTimeMillis - j3 > MIN_INTERVAL_FOR_GET_MEM_INFO) {
            lastGetMemory = b();
            lastGetMemoryTimeStamp = currentTimeMillis;
        }
        long[] jArr = lastGetMemory;
        if (jArr == null) {
            return 0.0d;
        }
        AegisLogger.INSTANCE.i("unknown|MemoryUtil", "MemTotal\uff1a" + jArr[0] + " MemFree:" + jArr[1] + " Buffers:" + jArr[2] + " Cached:" + jArr[3]);
        long j16 = jArr[0];
        if (j16 == 0) {
            return 0.0d;
        }
        return 1 - ((((jArr[1] + jArr[2]) + jArr[3]) * 1.0d) / j16);
    }
}
