package cm1;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mvi.base.route.k;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2 = {"Lcm1/a;", "Lcom/tencent/mvi/base/route/k;", "<init>", "()V", "a", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public class a implements k {

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u000bj\u0002`\f0\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R'\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u000bj\u0002`\f0\n8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcm1/a$a;", "Lcm1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorLocalMediaModel;", "a", "Ljava/util/Map;", "()Ljava/util/Map;", "taskMap", "<init>", "(Ljava/util/Map;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: cm1.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class FetchMediasUploadTaskMsgResult extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Map<String, LocalMediaInfo> taskMap;

        /* JADX WARN: Multi-variable type inference failed */
        public FetchMediasUploadTaskMsgResult(@NotNull Map<String, ? extends LocalMediaInfo> taskMap) {
            Intrinsics.checkNotNullParameter(taskMap, "taskMap");
            this.taskMap = taskMap;
        }

        @NotNull
        public final Map<String, LocalMediaInfo> a() {
            return this.taskMap;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof FetchMediasUploadTaskMsgResult) && Intrinsics.areEqual(this.taskMap, ((FetchMediasUploadTaskMsgResult) other).taskMap)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.taskMap.hashCode();
        }

        @NotNull
        public String toString() {
            return "FetchMediasUploadTaskMsgResult(taskMap=" + this.taskMap + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcm1/a$b;", "Lcm1/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "feedJson", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "feedJSONObject", "<init>", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: cm1.a$b, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class MakeJsonMsgResult extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String feedJson;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final JSONObject feedJSONObject;

        public MakeJsonMsgResult(@NotNull String feedJson, @NotNull JSONObject feedJSONObject) {
            Intrinsics.checkNotNullParameter(feedJson, "feedJson");
            Intrinsics.checkNotNullParameter(feedJSONObject, "feedJSONObject");
            this.feedJson = feedJson;
            this.feedJSONObject = feedJSONObject;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final JSONObject getFeedJSONObject() {
            return this.feedJSONObject;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getFeedJson() {
            return this.feedJson;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MakeJsonMsgResult)) {
                return false;
            }
            MakeJsonMsgResult makeJsonMsgResult = (MakeJsonMsgResult) other;
            if (Intrinsics.areEqual(this.feedJson, makeJsonMsgResult.feedJson) && Intrinsics.areEqual(this.feedJSONObject, makeJsonMsgResult.feedJSONObject)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.feedJson.hashCode() * 31) + this.feedJSONObject.hashCode();
        }

        @NotNull
        public String toString() {
            return "MakeJsonMsgResult(feedJson=" + this.feedJson + ", feedJSONObject=" + this.feedJSONObject + ")";
        }
    }
}
