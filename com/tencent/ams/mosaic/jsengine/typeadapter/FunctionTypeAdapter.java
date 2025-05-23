package com.tencent.ams.mosaic.jsengine.typeadapter;

import com.tencent.ams.hippo.quickjs.android.JSContext;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSValue;
import com.tencent.ams.hippo.quickjs.android.TypeAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FunctionTypeAdapter extends TypeAdapter<JSFunction> {
    static IPatchRedirector $redirector_;

    public FunctionTypeAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
    public JSValue toJSValue(JSContext jSContext, JSFunction jSFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? jSFunction : (JSValue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSContext, (Object) jSFunction);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
    public JSFunction fromJSValue(JSContext jSContext, JSValue jSValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? (JSFunction) jSValue.cast(JSFunction.class) : (JSFunction) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSContext, (Object) jSValue);
    }
}
