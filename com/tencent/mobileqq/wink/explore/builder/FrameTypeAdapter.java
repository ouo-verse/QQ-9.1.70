package com.tencent.mobileqq.wink.explore.builder;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.tencent.ark.ark;
import java.lang.reflect.Type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u73.Frame;
import w53.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ&\u0010\t\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/explore/builder/FrameTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lu73/c;", "Lcom/google/gson/JsonElement;", ark.ARKMETADATA_JSON, "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class FrameTypeAdapter implements JsonDeserializer<Frame> {
    @Override // com.google.gson.JsonDeserializer
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Frame deserialize(@Nullable JsonElement json, @Nullable Type typeOfT, @Nullable JsonDeserializationContext context) {
        String str;
        float f16;
        float f17;
        float f18;
        if (json != null) {
            str = json.getAsString();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        Matcher matcher = Pattern.compile("\\{\\{([\\d\\.]+),\\s*([\\d\\.]+)\\},\\s*\\{([\\d\\.]+),\\s*([\\d\\.]+)\\}\\}").matcher(str);
        float f19 = 0.0f;
        if (matcher.find()) {
            String group = matcher.group(1);
            if (group != null) {
                f16 = Float.parseFloat(group);
            } else {
                f16 = 0.0f;
            }
            String group2 = matcher.group(2);
            if (group2 != null) {
                f17 = Float.parseFloat(group2);
            } else {
                f17 = 0.0f;
            }
            String group3 = matcher.group(3);
            if (group3 != null) {
                f18 = Float.parseFloat(group3);
            } else {
                f18 = 0.0f;
            }
            String group4 = matcher.group(4);
            if (group4 != null) {
                f19 = Float.parseFloat(group4);
            }
            return new Frame(f16, f17, f18, f19);
        }
        b.f("FrameTypeAdapter", "Invalid frame format: " + str);
        return new Frame(0.0f, 0.0f, 0.0f, 0.0f);
    }
}
