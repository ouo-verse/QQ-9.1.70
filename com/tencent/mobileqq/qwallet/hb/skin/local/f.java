package com.tencent.mobileqq.qwallet.hb.skin.local;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J \u0010\t\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0007R\u001c\u0010\r\u001a\n \u000b*\u0004\u0018\u00010\n0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/skin/local/f;", "", "", "value", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$StoryRes;", "Lkotlin/collections/ArrayList;", "b", "storyResList", "a", "Lcom/google/gson/Gson;", "kotlin.jvm.PlatformType", "Lcom/google/gson/Gson;", "gson", "<init>", "()V", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Gson gson = new GsonBuilder().create();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/qwallet/hb/skin/local/f$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData$StoryRes;", "Lkotlin/collections/ArrayList;", "qqpay-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends TypeToken<ArrayList<HbSkinData.StoryRes>> {
        a() {
        }
    }

    @TypeConverter
    @NotNull
    public final String a(@NotNull ArrayList<HbSkinData.StoryRes> storyResList) {
        Intrinsics.checkNotNullParameter(storyResList, "storyResList");
        String json = this.gson.toJson(storyResList);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(storyResList)");
        return json;
    }

    @TypeConverter
    @NotNull
    public final ArrayList<HbSkinData.StoryRes> b(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        Object fromJson = this.gson.fromJson(value, new a().getType());
        Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(value, type)");
        return (ArrayList) fromJson;
    }
}
