package com.tencent.mobileqq.qroute.route;

import android.content.Context;
import android.net.Uri;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class URIRequest {
    static IPatchRedirector $redirector_;
    protected final Context context;
    protected final HashMap<String, Object> fields;
    protected final Uri uri;

    public URIRequest(Context context, Uri uri, Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, uri, map);
            return;
        }
        this.context = context;
        this.uri = uri;
        HashMap<String, Object> hashMap = new HashMap<>();
        this.fields = hashMap;
        if (map != null) {
            hashMap.putAll(map);
        }
    }

    public Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    public <T> T getField(Class<T> cls, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? (T) getField(cls, str, null) : (T) iPatchRedirector.redirect((short) 5, (Object) this, (Object) cls, (Object) str);
    }

    public HashMap<String, Object> getFields() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (HashMap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.fields;
    }

    public Uri getURI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Uri) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.uri;
    }

    public boolean hasField(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        return this.fields.containsKey(str);
    }

    public <T> URIRequest putField(String str, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (URIRequest) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) t16);
        }
        if (str == null) {
            k.c("put field for empty key");
            return this;
        }
        this.fields.put(str, t16);
        return this;
    }

    public <T> T getField(Class<T> cls, String str, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (T) iPatchRedirector.redirect((short) 6, this, cls, str, t16);
        }
        Object obj = this.fields.get(str);
        if (obj == null) {
            return t16;
        }
        try {
            return cls.cast(obj);
        } catch (ClassCastException e16) {
            k.c(e16.toString());
            return t16;
        }
    }
}
