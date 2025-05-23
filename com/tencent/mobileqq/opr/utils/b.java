package com.tencent.mobileqq.opr.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.opr.utils.log.OprLogger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.util.ReflectionUtil;
import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/opr/utils/b;", "", "", PushClientConstants.TAG_CLASS_NAME, "fieldName", "a", "<init>", "()V", "opr_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes16.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f257070a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10725);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f257070a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final Object a(@NotNull String className, @NotNull String fieldName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) className, (Object) fieldName);
        }
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        if (TextUtils.isEmpty(className) || TextUtils.isEmpty(fieldName)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(className);
            return cls.getField(fieldName).get(cls);
        } catch (ClassNotFoundException e16) {
            OprLogger.w(ReflectionUtil.TAG, Intrinsics.stringPlus("ClassNotFoundException: ", e16));
            return null;
        } catch (IllegalAccessException e17) {
            OprLogger.w(ReflectionUtil.TAG, Intrinsics.stringPlus("IllegalAccessException: ", e17));
            return null;
        } catch (NoSuchFieldException e18) {
            OprLogger.w(ReflectionUtil.TAG, Intrinsics.stringPlus("NoSuchFieldException: ", e18));
            return null;
        } catch (SecurityException e19) {
            OprLogger.w(ReflectionUtil.TAG, Intrinsics.stringPlus("SecurityException: ", e19));
            return null;
        }
    }
}
