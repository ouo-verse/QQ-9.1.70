package com.tencent.videocut.utils;

import android.os.SystemProperties;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0086\u0002R\u001c\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\bR\u0018\u0010\f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/videocut/utils/q;", "", "", "b", "", "key", "a", "Ljava/lang/Class;", "Ljava/lang/Class;", "mClassType", "Ljava/lang/reflect/Method;", "Ljava/lang/reflect/Method;", "mGetMethod", "c", "mGetIntMethod", "<init>", "()V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class q {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static Class<?> mClassType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Method mGetMethod;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static Method mGetIntMethod;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final q f384265d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9566);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f384265d = new q();
        }
    }

    q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    private final void b() {
        Method method;
        try {
            if (mClassType == null) {
                mClassType = SystemProperties.class;
                mGetMethod = SystemProperties.class.getDeclaredMethod("get", String.class);
                Class<?> cls = mClassType;
                if (cls != null) {
                    method = cls.getDeclaredMethod("getInt", String.class, Integer.TYPE);
                } else {
                    method = null;
                }
                mGetIntMethod = method;
            }
        } catch (Exception unused) {
        }
    }

    @Nullable
    public final String a(@Nullable String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this, (Object) key);
        }
        b();
        try {
            Method method = mGetMethod;
            Intrinsics.checkNotNull(method);
            Object invoke = method.invoke(mClassType, key);
            if (invoke != null) {
                return (String) invoke;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception unused) {
            return null;
        }
    }
}
