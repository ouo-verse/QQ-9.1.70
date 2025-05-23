package com.tencent.richframework.argus.page.converter;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.richframework.argus.page.PageInfoPO;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0007R\u001c\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/richframework/argus/page/converter/PageInfoTypeConverter;", "", "", "value", "Lcom/tencent/richframework/argus/page/PageInfoPO;", "fromString", "pageInfo", "pageInfoToString", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "gson", "Lcom/google/gson/Gson;", "<init>", "()V", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class PageInfoTypeConverter {

    @NotNull
    public static final PageInfoTypeConverter INSTANCE = new PageInfoTypeConverter();
    private static final Gson gson = new GsonBuilder().create();

    PageInfoTypeConverter() {
    }

    @TypeConverter
    @NotNull
    public final PageInfoPO fromString(@Nullable String value) {
        Object fromJson = gson.fromJson(value, (Class<Object>) PageInfoPO.class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(value, PageInfoPO::class.java)");
        return (PageInfoPO) fromJson;
    }

    @TypeConverter
    @NotNull
    public final String pageInfoToString(@Nullable PageInfoPO pageInfo) {
        String json = gson.toJson(pageInfo);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(pageInfo)");
        return json;
    }
}
