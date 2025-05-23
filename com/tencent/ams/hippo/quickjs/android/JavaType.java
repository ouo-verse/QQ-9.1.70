package com.tencent.ams.hippo.quickjs.android;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class JavaType<T> {
    static IPatchRedirector $redirector_;

    @NonNull
    public Type type;

    public JavaType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        Type canonicalize = JavaTypes.canonicalize(getClass().getGenericSuperclass());
        if (!(canonicalize instanceof ParameterizedType)) {
            invalidJavaType();
        }
        Type[] actualTypeArguments = ((ParameterizedType) canonicalize).getActualTypeArguments();
        if (actualTypeArguments.length != 1) {
            invalidJavaType();
        }
        this.type = actualTypeArguments[0];
    }

    private void invalidJavaType() {
        throw new IllegalStateException("Invalid JavaType. JavaType must be inherited by a anonymous class");
    }
}
