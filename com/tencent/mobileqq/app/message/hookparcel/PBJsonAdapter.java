package com.tencent.mobileqq.app.message.hookparcel;

import android.util.Base64;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Type;

/* loaded from: classes11.dex */
public class PBJsonAdapter implements JsonSerializer<MessageMicro>, JsonDeserializer<MessageMicro> {
    static IPatchRedirector $redirector_;
    private Class<? extends MessageMicro<?>> realType;

    public PBJsonAdapter(Class<? extends MessageMicro<?>> cls) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cls);
        } else {
            this.realType = cls;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public MessageMicro deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageMicro) iPatchRedirector.redirect((short) 2, this, jsonElement, type, jsonDeserializationContext);
        }
        try {
            MessageMicro<?> newInstance = this.realType.newInstance();
            newInstance.mergeFrom(Base64.decode(jsonElement.getAsString(), 3));
            return newInstance;
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            return null;
        } catch (IllegalAccessException e17) {
            e17.printStackTrace();
            return null;
        } catch (InstantiationException e18) {
            e18.printStackTrace();
            return null;
        }
    }

    @Override // com.google.gson.JsonSerializer
    public JsonElement serialize(MessageMicro messageMicro, Type type, JsonSerializationContext jsonSerializationContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new JsonPrimitive(Base64.encodeToString(messageMicro.toByteArray(), 3)) : (JsonElement) iPatchRedirector.redirect((short) 3, this, messageMicro, type, jsonSerializationContext);
    }
}
