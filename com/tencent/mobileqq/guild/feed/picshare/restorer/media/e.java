package com.tencent.mobileqq.guild.feed.picshare.restorer.media;

import en1.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/picshare/restorer/media/e;", "Len1/a;", "Lorg/json/JSONObject;", "contentJson", "", "b", "Len1/a$a;", "result", "", "a", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e implements en1.a {
    private final String b(JSONObject contentJson) {
        JSONObject jSONObject = contentJson.getJSONObject("cover");
        JSONArray jSONArray = jSONObject.getJSONArray("vecImageUrl");
        int length = jSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
            if (jSONObject2.getInt("levelType") == 3) {
                String string = jSONObject2.getString("url");
                Intrinsics.checkNotNullExpressionValue(string, "imageUrlJson.getString(\"url\")");
                return string;
            }
        }
        String string2 = jSONObject.getString("picUrl");
        Intrinsics.checkNotNullExpressionValue(string2, "cover.getString(\"picUrl\")");
        return string2;
    }

    @Override // en1.a
    public void a(@NotNull JSONObject contentJson, @NotNull a.C10251a result) {
        Intrinsics.checkNotNullParameter(contentJson, "contentJson");
        Intrinsics.checkNotNullParameter(result, "result");
        String b16 = b(contentJson);
        int i3 = contentJson.getInt("width");
        result.a().add(new a(MediaType.VIDEO, contentJson.getInt("height"), i3, contentJson.getLong("duration"), b16));
    }
}
