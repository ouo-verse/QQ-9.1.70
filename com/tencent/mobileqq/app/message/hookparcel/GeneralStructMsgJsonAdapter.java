package com.tencent.mobileqq.app.message.hookparcel;

import android.util.Base64;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.i;
import java.lang.reflect.Type;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GeneralStructMsgJsonAdapter<T extends AbsStructMsg> implements JsonSerializer<T>, JsonDeserializer<T> {
    static IPatchRedirector $redirector_;

    public GeneralStructMsgJsonAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.google.gson.JsonDeserializer
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, this, jsonElement, type, jsonDeserializationContext);
        }
        return (T) i.d(Base64.decode(jsonElement.getAsString(), 3));
    }

    @Override // com.google.gson.JsonSerializer
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public JsonElement serialize(T t16, Type type, JsonSerializationContext jsonSerializationContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (JsonElement) iPatchRedirector.redirect((short) 3, this, t16, type, jsonSerializationContext);
        }
        return new JsonPrimitive(Base64.encodeToString(t16.getBytes(), 3));
    }
}
