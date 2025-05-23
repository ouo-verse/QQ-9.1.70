package com.tencent.ams.mosaic.jsengine.typeadapter;

import com.tencent.ams.hippo.quickjs.android.JSContext;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.hippo.quickjs.android.JSValue;
import com.tencent.ams.hippo.quickjs.android.TypeAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ObjectTypeAdapter extends TypeAdapter<JSObject> {
    static IPatchRedirector $redirector_;

    public ObjectTypeAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
    public JSValue toJSValue(JSContext jSContext, JSObject jSObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? jSObject : (JSValue) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSContext, (Object) jSObject);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.ams.hippo.quickjs.android.TypeAdapter
    public JSObject fromJSValue(JSContext jSContext, JSValue jSValue) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? (JSObject) jSValue.cast(JSObject.class) : (JSObject) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSContext, (Object) jSValue);
    }
}
