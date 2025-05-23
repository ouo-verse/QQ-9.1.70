package com.tencent.mobileqq.guild.feed.publish.result;

import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.guild.feed.publish.result.AbsResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0013B\u001d\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/result/ThirdContentResult;", "Lcom/tencent/mobileqq/guild/feed/publish/result/AbsResult;", "Lcom/tencent/mobileqq/guild/feed/publish/result/AbsResult$Type;", "b", "", "a", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "getJsonFeed", "()Lorg/json/JSONObject;", "jsonFeed", "", "c", "Ljava/util/List;", "getTaskIds", "()Ljava/util/List;", "taskIds", "<init>", "(Lorg/json/JSONObject;Ljava/util/List;)V", "ThirdData", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ThirdContentResult extends AbsResult {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final JSONObject jsonFeed;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> taskIds;

    /* compiled from: P */
    @Keep
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/result/ThirdContentResult$ThirdData;", "", "feedJson", "", "(Ljava/lang/String;)V", "getFeedJson", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final /* data */ class ThirdData {

        @SerializedName("feedJson")
        @NotNull
        private final String feedJson;

        public ThirdData(@NotNull String feedJson) {
            Intrinsics.checkNotNullParameter(feedJson, "feedJson");
            this.feedJson = feedJson;
        }

        public static /* synthetic */ ThirdData copy$default(ThirdData thirdData, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = thirdData.feedJson;
            }
            return thirdData.copy(str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getFeedJson() {
            return this.feedJson;
        }

        @NotNull
        public final ThirdData copy(@NotNull String feedJson) {
            Intrinsics.checkNotNullParameter(feedJson, "feedJson");
            return new ThirdData(feedJson);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof ThirdData) && Intrinsics.areEqual(this.feedJson, ((ThirdData) other).feedJson)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getFeedJson() {
            return this.feedJson;
        }

        public int hashCode() {
            return this.feedJson.hashCode();
        }

        @NotNull
        public String toString() {
            return "ThirdData(feedJson=" + this.feedJson + ")";
        }
    }

    public ThirdContentResult(@NotNull JSONObject jsonFeed, @NotNull List<String> taskIds) {
        Intrinsics.checkNotNullParameter(jsonFeed, "jsonFeed");
        Intrinsics.checkNotNullParameter(taskIds, "taskIds");
        this.jsonFeed = jsonFeed;
        this.taskIds = taskIds;
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    @NotNull
    protected String a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("taskIds", this.taskIds);
        jSONObject.put("jsonFeed", this.jsonFeed);
        Gson gson = this.f223160a;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
        String json = gson.toJson(new ThirdData(jSONObject2));
        Intrinsics.checkNotNullExpressionValue(json, "mGson.toJson(ThirdData(jsonObject.toString()))");
        return json;
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    @NotNull
    protected AbsResult.Type b() {
        return AbsResult.Type.THIRD_CONTENT;
    }

    @Override // com.tencent.mobileqq.guild.feed.publish.result.AbsResult
    public /* bridge */ /* synthetic */ String c() {
        return super.c();
    }
}
