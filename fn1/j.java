package fn1;

import com.tencent.mobileqq.guild.feed.picshare.restorer.media.MediaType;
import en1.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lfn1/j;", "Len1/a;", "Lorg/json/JSONObject;", "contentJson", "Len1/a$a;", "result", "", "a", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j implements en1.a {
    @Override // en1.a
    public void a(@NotNull JSONObject contentJson, @NotNull a.C10251a result) {
        Intrinsics.checkNotNullParameter(contentJson, "contentJson");
        Intrinsics.checkNotNullParameter(result, "result");
        JSONObject jSONObject = contentJson.getJSONObject("url_content");
        int optInt = jSONObject.optInt("type");
        String str = "";
        if (optInt != 0) {
            if (optInt != 1) {
                if (optInt == 3) {
                    String string = jSONObject.getString("displayText");
                    if (string != null) {
                        str = string;
                    }
                    result.getTextContent().append((CharSequence) str);
                    return;
                }
                return;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("third_video_info");
            String coverImageUrl = jSONObject2.getString("cover");
            int i3 = jSONObject2.getInt("duration");
            Intrinsics.checkNotNullExpressionValue(coverImageUrl, "coverImageUrl");
            result.a().add(new com.tencent.mobileqq.guild.feed.picshare.restorer.media.a(MediaType.VIDEO, 200, 400, i3 * 1000, coverImageUrl));
            return;
        }
        String string2 = jSONObject.getString("displayText");
        if (string2 != null) {
            str = string2;
        }
        result.getTextContent().append((CharSequence) str);
    }
}
