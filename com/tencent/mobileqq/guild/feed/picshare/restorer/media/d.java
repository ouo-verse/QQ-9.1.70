package com.tencent.mobileqq.guild.feed.picshare.restorer.media;

import en1.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/picshare/restorer/media/d;", "Len1/a;", "Lorg/json/JSONObject;", "jsonObject", "Len1/a$a;", "result", "", "a", "Lcom/tencent/mobileqq/guild/feed/picshare/restorer/media/c;", "Lcom/tencent/mobileqq/guild/feed/picshare/restorer/media/c;", "mImageProcessor", "Lcom/tencent/mobileqq/guild/feed/picshare/restorer/media/e;", "b", "Lcom/tencent/mobileqq/guild/feed/picshare/restorer/media/e;", "mVideoProcessor", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d implements en1.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mImageProcessor = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e mVideoProcessor = new e();

    @Override // en1.a
    public void a(@NotNull JSONObject jsonObject, @NotNull a.C10251a result) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(result, "result");
        if (jsonObject.has("images")) {
            JSONArray jSONArray = jsonObject.getJSONArray("images");
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                c cVar = this.mImageProcessor;
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "imageJsonArray.getJSONObject(index)");
                cVar.a(jSONObject, result);
            }
        }
        if (jsonObject.has("videos")) {
            JSONArray jSONArray2 = jsonObject.getJSONArray("videos");
            int length2 = jSONArray2.length();
            for (int i16 = 0; i16 < length2; i16++) {
                e eVar = this.mVideoProcessor;
                JSONObject jSONObject2 = jSONArray2.getJSONObject(i16);
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "videoJsonArray.getJSONObject(index)");
                eVar.a(jSONObject2, result);
            }
        }
    }
}
