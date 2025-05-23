package com.tencent.ams.hippo.quickjs.android;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Type;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class TypeAdapter<T> {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface Factory {
        @Nullable
        TypeAdapter<?> create(QuickJS quickJS, Type type);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class NullableTypeAdapter<T> extends TypeAdapter<T> {
        static IPatchRedirector $redirector_;
        private final TypeAdapter<T> delegate;

        NullableTypeAdapter(TypeAdapter<T> typeAdapter) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) typeAdapter);
            } else {
                this.delegate = typeAdapter;
            }
        }

        @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
        public T fromJSValue(JSContext jSContext, JSValue jSValue) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (T) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSContext, (Object) jSValue);
            }
            if (!(jSValue instanceof JSNull) && !(jSValue instanceof JSUndefined)) {
                return this.delegate.fromJSValue(jSContext, jSValue);
            }
            return null;
        }

        @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
        public JSValue toJSValue(JSContext jSContext, T t16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (JSValue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSContext, (Object) t16);
            }
            if (t16 == null) {
                return jSContext.createJSNull();
            }
            return this.delegate.toJSValue(jSContext, t16);
        }
    }

    public TypeAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract T fromJSValue(JSContext jSContext, JSValue jSValue);

    public final TypeAdapter<T> nullable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TypeAdapter) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new NullableTypeAdapter(this);
    }

    public abstract JSValue toJSValue(JSContext jSContext, T t16);
}
