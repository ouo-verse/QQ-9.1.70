package com.tencent.ams.hippo.quickjs.android;

import androidx.annotation.Nullable;
import com.tencent.ams.hippo.quickjs.android.TypeAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Type;

/* compiled from: P */
/* loaded from: classes3.dex */
class JSValueAdapter {
    static IPatchRedirector $redirector_;
    static final TypeAdapter.Factory FACTORY;
    private static final TypeAdapter<JSValue> JS_VALUE_TYPE_ADAPTER;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14476);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            FACTORY = new TypeAdapter.Factory() { // from class: com.tencent.ams.hippo.quickjs.android.JSValueAdapter.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter.Factory
                @Nullable
                public TypeAdapter<?> create(QuickJS quickJS, Type type) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (TypeAdapter) iPatchRedirector.redirect((short) 2, (Object) this, (Object) quickJS, (Object) type);
                    }
                    if (type == JSValue.class) {
                        return JSValueAdapter.JS_VALUE_TYPE_ADAPTER;
                    }
                    return null;
                }
            };
            JS_VALUE_TYPE_ADAPTER = new TypeAdapter<JSValue>() { // from class: com.tencent.ams.hippo.quickjs.android.JSValueAdapter.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
                public JSValue fromJSValue(JSContext jSContext, JSValue jSValue) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? jSValue : (JSValue) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSContext, (Object) jSValue);
                }

                @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
                public JSValue toJSValue(JSContext jSContext, JSValue jSValue) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (JSValue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSContext, (Object) jSValue);
                    }
                    if (jSValue != null) {
                        return jSValue;
                    }
                    throw new NullPointerException("value == null");
                }
            };
        }
    }

    JSValueAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
