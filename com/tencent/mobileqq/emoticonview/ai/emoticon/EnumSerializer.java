package com.tencent.mobileqq.emoticonview.ai.emoticon;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Type;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/ai/emoticon/EnumSerializer;", "Lcom/google/gson/JsonSerializer;", "", "()V", "serialize", "Lcom/google/gson/JsonElement;", "src", "type", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonSerializationContext;", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class EnumSerializer implements JsonSerializer<Enum<?>> {
    static IPatchRedirector $redirector_;

    public EnumSerializer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.google.gson.JsonSerializer
    @NotNull
    public JsonElement serialize(@Nullable Enum<?> src, @Nullable Type type, @Nullable JsonSerializationContext context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return new JsonPrimitive((Number) (src != null ? Integer.valueOf(src.ordinal()) : null));
        }
        return (JsonElement) iPatchRedirector.redirect((short) 2, this, src, type, context);
    }
}
