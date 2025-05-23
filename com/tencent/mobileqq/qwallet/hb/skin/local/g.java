package com.tencent.mobileqq.qwallet.hb.skin.local;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.mtt.hippy.dom.node.TextNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0007R\u001c\u0010\u000b\u001a\n \t*\u0004\u0018\u00010\b0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/skin/local/g;", "", "", "value", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$Tail;", "b", TextNode.MODE_TAIL, "a", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "Lcom/google/gson/Gson;", "gson", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Gson gson = new GsonBuilder().create();

    @TypeConverter
    @NotNull
    public final String a(@NotNull HbSkinData.Tail tail) {
        Intrinsics.checkNotNullParameter(tail, "tail");
        String json = this.gson.toJson(tail);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(tail)");
        return json;
    }

    @TypeConverter
    @NotNull
    public final HbSkinData.Tail b(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Object fromJson = this.gson.fromJson(value, (Class<Object>) HbSkinData.Tail.class);
        Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(value, HbSkinData.Tail::class.java)");
        return (HbSkinData.Tail) fromJson;
    }
}
