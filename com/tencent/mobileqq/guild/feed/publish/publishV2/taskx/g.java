package com.tencent.mobileqq.guild.feed.publish.publishV2.taskx;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u00060\u0006j\u0002`\u00070\f2\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/g;", "", "Lorg/json/JSONObject;", "node", "Lkotlin/Pair;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lcom/tencent/mobileqq/guild/feed/publish/api/QQAlbumMediumModel;", "a", "c", "Lorg/json/JSONArray;", "patternInfoJson", "", "b", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f223138a = new g();

    g() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
    
        r3 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) r2, "guildFeedPublish/localMedia", 0, false, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Pair<String, LocalMediaInfo> a(JSONObject node) {
        String optString;
        int indexOf$default;
        boolean z16;
        boolean z17;
        String optString2 = node.optString("fileId");
        if (optString2 == null || (optString = node.optString("url")) == null || indexOf$default < 0) {
            return null;
        }
        String substring = optString.substring(indexOf$default + 27);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        if (substring.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            substring = null;
        }
        if (substring == null) {
            return null;
        }
        String c16 = com.tencent.mobileqq.guild.util.i.f235563a.c(substring);
        if (c16 != null && c16.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            QLog.e("JsonTransformation", 1, "[parseVideoNode]: " + optString2 + ", localPath=" + substring + ", mimeType is null");
            return null;
        }
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.path = substring;
        localMediaInfo.mediaWidth = node.optInt("width", 0);
        localMediaInfo.mediaHeight = node.optInt("height", 0);
        localMediaInfo.mMimeType = c16;
        return TuplesKt.to(optString2, localMediaInfo);
    }

    private final Pair<String, LocalMediaInfo> c(JSONObject node) {
        String optString;
        boolean z16;
        String optString2 = node.optString("fileId");
        if (optString2 == null || (optString = node.optString("videoId")) == null) {
            return null;
        }
        String c16 = com.tencent.mobileqq.guild.util.i.f235563a.c(optString);
        if (c16 != null && c16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("JsonTransformation", 1, "[parseVideoNode]: " + optString2 + ", videoPath=" + optString + ", mimeType is null");
            return null;
        }
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.path = optString;
        localMediaInfo.mediaWidth = node.optInt("width", 0);
        localMediaInfo.mediaHeight = node.optInt("height", 0);
        localMediaInfo.mMimeType = c16;
        return TuplesKt.to(optString2, localMediaInfo);
    }

    @NotNull
    public final Map<String, LocalMediaInfo> b(@NotNull JSONArray patternInfoJson) {
        JSONArray optJSONArray;
        Pair<String, LocalMediaInfo> c16;
        Intrinsics.checkNotNullParameter(patternInfoJson, "patternInfoJson");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (JSONObject jSONObject : yl1.i.f450608a.a(patternInfoJson)) {
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("data")) != null) {
                yl1.i iVar = yl1.i.f450608a;
                Intrinsics.checkNotNullExpressionValue(optJSONArray, "optJSONArray(\"data\")");
                Sequence<JSONObject> a16 = iVar.a(optJSONArray);
                if (a16 != null) {
                    for (JSONObject jSONObject2 : a16) {
                        if (jSONObject2 != null) {
                            int optInt = jSONObject2.optInt("type");
                            if (optInt != 6) {
                                if (optInt == 7 && (c16 = f223138a.c(jSONObject2)) != null) {
                                    linkedHashMap.put(c16.component1(), c16.component2());
                                }
                            } else {
                                Pair<String, LocalMediaInfo> a17 = f223138a.a(jSONObject2);
                                if (a17 != null) {
                                    linkedHashMap.put(a17.component1(), a17.component2());
                                }
                            }
                        }
                    }
                }
            }
        }
        return linkedHashMap;
    }
}
