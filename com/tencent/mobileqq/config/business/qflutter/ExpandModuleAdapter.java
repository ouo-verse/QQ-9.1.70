package com.tencent.mobileqq.config.business.qflutter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ&\u0010\t\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/config/business/qflutter/ExpandModuleAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/tencent/mobileqq/config/business/qflutter/ExpandModuleKey;", "Lcom/google/gson/JsonElement;", "p0", "Ljava/lang/reflect/Type;", "p1", "Lcom/google/gson/JsonDeserializationContext;", "p2", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class ExpandModuleAdapter implements JsonDeserializer<ExpandModuleKey> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ExpandModuleKey deserialize(@Nullable JsonElement p06, @Nullable Type p16, @Nullable JsonDeserializationContext p26) {
        String asString;
        String str = "Unknown";
        if (p06 != null) {
            try {
                asString = p06.getAsString();
            } catch (Exception unused) {
            }
        } else {
            asString = null;
        }
        if (asString != null) {
            str = asString;
        }
        return ExpandModuleKey.INSTANCE.a(str);
    }
}
