package e40;

import android.net.Uri;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0004\n\f\u0013\u0019B+\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\n\u0010\u0010R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Le40/k;", "", "", "toString", "", "hashCode", "other", "", "equals", "Le40/k$b;", "a", "Le40/k$b;", "b", "()Le40/k$b;", QCircleScheme.AttrDetail.FEED_INFO, "Ljava/lang/String;", "()Ljava/lang/String;", QQWinkConstants.COVER_PATH, "Le40/k$c;", "c", "Le40/k$c;", "()Le40/k$c;", "positionInfo", "<init>", "(Le40/k$b;Ljava/lang/String;Le40/k$c;)V", "d", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: e40.k, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class QFSSchemaTransitionInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final FeedInfo feedInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String coverPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final PositionInfo positionInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 *2\u00020\u0001:\u0001\tBq\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0004\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010 \u0012\u0006\u0010&\u001a\u00020\u0004\u0012\u0006\u0010'\u001a\u00020\u0004\u00a2\u0006\u0004\b(\u0010)J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000f\u001a\u0004\b\u001a\u0010\u0011R\u0017\u0010\u001c\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011R\u0017\u0010\u001f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u000f\u001a\u0004\b\u001e\u0010\u0011R\u0019\u0010$\u001a\u0004\u0018\u00010 8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010&\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u000f\u001a\u0004\b%\u0010\u0011R\u0017\u0010'\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u000f\u001a\u0004\b\u0019\u0010\u0011\u00a8\u0006+"}, d2 = {"Le40/k$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "uin", "b", "I", "d", "()I", "feedType", "c", tl.h.F, "nickName", "avatar", "e", "content", "f", "g", "likeNum", "fuelNum", "commentNum", "i", "shareNum", "Le40/k$d;", "Le40/k$d;", "k", "()Le40/k$d;", QCircleScheme.AttrDetail.VIDEO_INFO, "l", "width", "height", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILe40/k$d;II)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: e40.k$b, reason: from toString */
    /* loaded from: classes4.dex */
    public static final /* data */ class FeedInfo {

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String uin;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int feedType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String nickName;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String avatar;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String content;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int likeNum;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final int fuelNum;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final int commentNum;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        private final int shareNum;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final VideoInfo videoInfo;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
        private final int width;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
        private final int height;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Le40/k$b$a;", "", "", "jsonStr", "Le40/k$b;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: e40.k$b$a, reason: from kotlin metadata */
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @Nullable
            public final FeedInfo a(@Nullable String jsonStr) {
                if (jsonStr == null) {
                    QLog.e("QFSSchemaTransitionInfo.FeedInfo", 1, "parseFromJSONStr error, jsonStr = null");
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(jsonStr);
                    String optString = jSONObject.optString("uin");
                    Intrinsics.checkNotNullExpressionValue(optString, "optString(UIN)");
                    int optInt = jSONObject.optInt("type");
                    String optString2 = jSONObject.optString("nick");
                    Intrinsics.checkNotNullExpressionValue(optString2, "optString(NICK)");
                    String optString3 = jSONObject.optString("avatar");
                    Intrinsics.checkNotNullExpressionValue(optString3, "optString(AVATAR)");
                    String optString4 = jSONObject.optString("content");
                    Intrinsics.checkNotNullExpressionValue(optString4, "optString(CONTENT)");
                    return new FeedInfo(optString, optInt, optString2, optString3, optString4, jSONObject.optInt("likeNum"), jSONObject.optInt("fuelNum"), jSONObject.optInt("commentNum"), jSONObject.optInt("shareNum"), VideoInfo.INSTANCE.a(jSONObject.optJSONObject(QCircleScheme.AttrDetail.VIDEO_INFO)), jSONObject.optInt("width"), jSONObject.optInt("height"));
                } catch (JSONException e16) {
                    QLog.e("QFSSchemaTransitionInfo.FeedInfo", 1, "parseFromJSONStr error, jsonStr = " + jsonStr, e16);
                    return null;
                }
            }

            Companion() {
            }
        }

        public FeedInfo(@NotNull String uin, int i3, @NotNull String nickName, @NotNull String avatar, @NotNull String content, int i16, int i17, int i18, int i19, @Nullable VideoInfo videoInfo, int i26, int i27) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            Intrinsics.checkNotNullParameter(avatar, "avatar");
            Intrinsics.checkNotNullParameter(content, "content");
            this.uin = uin;
            this.feedType = i3;
            this.nickName = nickName;
            this.avatar = avatar;
            this.content = content;
            this.likeNum = i16;
            this.fuelNum = i17;
            this.commentNum = i18;
            this.shareNum = i19;
            this.videoInfo = videoInfo;
            this.width = i26;
            this.height = i27;
        }

        @JvmStatic
        @Nullable
        public static final FeedInfo m(@Nullable String str) {
            return INSTANCE.a(str);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getAvatar() {
            return this.avatar;
        }

        /* renamed from: b, reason: from getter */
        public final int getCommentNum() {
            return this.commentNum;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: d, reason: from getter */
        public final int getFeedType() {
            return this.feedType;
        }

        /* renamed from: e, reason: from getter */
        public final int getFuelNum() {
            return this.fuelNum;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FeedInfo)) {
                return false;
            }
            FeedInfo feedInfo = (FeedInfo) other;
            if (Intrinsics.areEqual(this.uin, feedInfo.uin) && this.feedType == feedInfo.feedType && Intrinsics.areEqual(this.nickName, feedInfo.nickName) && Intrinsics.areEqual(this.avatar, feedInfo.avatar) && Intrinsics.areEqual(this.content, feedInfo.content) && this.likeNum == feedInfo.likeNum && this.fuelNum == feedInfo.fuelNum && this.commentNum == feedInfo.commentNum && this.shareNum == feedInfo.shareNum && Intrinsics.areEqual(this.videoInfo, feedInfo.videoInfo) && this.width == feedInfo.width && this.height == feedInfo.height) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* renamed from: g, reason: from getter */
        public final int getLikeNum() {
            return this.likeNum;
        }

        @NotNull
        /* renamed from: h, reason: from getter */
        public final String getNickName() {
            return this.nickName;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((((((((((((((((this.uin.hashCode() * 31) + this.feedType) * 31) + this.nickName.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.content.hashCode()) * 31) + this.likeNum) * 31) + this.fuelNum) * 31) + this.commentNum) * 31) + this.shareNum) * 31;
            VideoInfo videoInfo = this.videoInfo;
            if (videoInfo == null) {
                hashCode = 0;
            } else {
                hashCode = videoInfo.hashCode();
            }
            return ((((hashCode2 + hashCode) * 31) + this.width) * 31) + this.height;
        }

        /* renamed from: i, reason: from getter */
        public final int getShareNum() {
            return this.shareNum;
        }

        @NotNull
        /* renamed from: j, reason: from getter */
        public final String getUin() {
            return this.uin;
        }

        @Nullable
        /* renamed from: k, reason: from getter */
        public final VideoInfo getVideoInfo() {
            return this.videoInfo;
        }

        /* renamed from: l, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        @NotNull
        public String toString() {
            return "FeedInfo(uin=" + this.uin + ", feedType=" + this.feedType + ", nickName=" + this.nickName + ", avatar=" + this.avatar + ", content=" + this.content + ", likeNum=" + this.likeNum + ", fuelNum=" + this.fuelNum + ", commentNum=" + this.commentNum + ", shareNum=" + this.shareNum + ", videoInfo=" + this.videoInfo + ", width=" + this.width + ", height=" + this.height + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\tB'\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0016"}, d2 = {"Le40/k$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "visibleRectLeft", "c", "visibleRectRight", "d", "visibleRectTop", "visibleRectBottom", "<init>", "(IIII)V", "e", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: e40.k$c, reason: from toString */
    /* loaded from: classes4.dex */
    public static final /* data */ class PositionInfo {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int visibleRectLeft;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int visibleRectRight;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int visibleRectTop;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int visibleRectBottom;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Le40/k$c$a;", "", "", "jsonStr", "Le40/k$c;", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: e40.k$c$a, reason: from kotlin metadata */
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @Nullable
            public final PositionInfo a(@Nullable String jsonStr) {
                if (jsonStr == null) {
                    QLog.e("QFSSchemaTransitionInfo.PositionInfo", 1, "parseFromJSONStr error, jsonStr = null");
                    return null;
                }
                try {
                    JSONObject optJSONObject = new JSONObject(jsonStr).optJSONObject("visibleRect");
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                    }
                    return new PositionInfo(optJSONObject.optInt("left"), optJSONObject.optInt("right"), optJSONObject.optInt("top"), optJSONObject.optInt("bottom"));
                } catch (JSONException e16) {
                    QLog.e("QFSSchemaTransitionInfo.PositionInfo", 1, "parseFromJSONStr error, jsonStr = " + jsonStr, e16);
                    return null;
                }
            }

            Companion() {
            }
        }

        public PositionInfo(int i3, int i16, int i17, int i18) {
            this.visibleRectLeft = i3;
            this.visibleRectRight = i16;
            this.visibleRectTop = i17;
            this.visibleRectBottom = i18;
        }

        @JvmStatic
        @Nullable
        public static final PositionInfo e(@Nullable String str) {
            return INSTANCE.a(str);
        }

        /* renamed from: a, reason: from getter */
        public final int getVisibleRectBottom() {
            return this.visibleRectBottom;
        }

        /* renamed from: b, reason: from getter */
        public final int getVisibleRectLeft() {
            return this.visibleRectLeft;
        }

        /* renamed from: c, reason: from getter */
        public final int getVisibleRectRight() {
            return this.visibleRectRight;
        }

        /* renamed from: d, reason: from getter */
        public final int getVisibleRectTop() {
            return this.visibleRectTop;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PositionInfo)) {
                return false;
            }
            PositionInfo positionInfo = (PositionInfo) other;
            if (this.visibleRectLeft == positionInfo.visibleRectLeft && this.visibleRectRight == positionInfo.visibleRectRight && this.visibleRectTop == positionInfo.visibleRectTop && this.visibleRectBottom == positionInfo.visibleRectBottom) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.visibleRectLeft * 31) + this.visibleRectRight) * 31) + this.visibleRectTop) * 31) + this.visibleRectBottom;
        }

        @NotNull
        public String toString() {
            return "PositionInfo(visibleRectLeft=" + this.visibleRectLeft + ", visibleRectRight=" + this.visibleRectRight + ", visibleRectTop=" + this.visibleRectTop + ", visibleRectBottom=" + this.visibleRectBottom + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\tB+\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\t\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Le40/k$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "id", "c", "playUrl", "", "J", "()J", "duration", "d", "Z", "()Z", "isQUICVideo", "<init>", "(Ljava/lang/String;Ljava/lang/String;JZ)V", "e", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: e40.k$d, reason: from toString */
    /* loaded from: classes4.dex */
    public static final /* data */ class VideoInfo {

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String playUrl;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final long duration;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isQUICVideo;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Le40/k$d$a;", "", "Lorg/json/JSONObject;", "jsonObject", "Le40/k$d;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: e40.k$d$a, reason: from kotlin metadata */
        /* loaded from: classes4.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @Nullable
            public final VideoInfo a(@Nullable JSONObject jsonObject) {
                if (jsonObject == null) {
                    QLog.e("QFSSchemaTransitionInfo.VideoInfo", 1, "parseFromJSONStr, jsonObject = null");
                    return null;
                }
                String optString = jsonObject.optString("fileId");
                Intrinsics.checkNotNullExpressionValue(optString, "optString(VIDEO_ID)");
                String decode = Uri.decode(jsonObject.optString("playUrl"));
                Intrinsics.checkNotNullExpressionValue(decode, "decode(optString(PLAY_URL))");
                return new VideoInfo(optString, decode, jsonObject.optLong("duration"), jsonObject.optBoolean("isQUIC"));
            }

            Companion() {
            }
        }

        public VideoInfo(@NotNull String id5, @NotNull String playUrl, long j3, boolean z16) {
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(playUrl, "playUrl");
            this.id = id5;
            this.playUrl = playUrl;
            this.duration = j3;
            this.isQUICVideo = z16;
        }

        /* renamed from: a, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getId() {
            return this.id;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final String getPlayUrl() {
            return this.playUrl;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getIsQUICVideo() {
            return this.isQUICVideo;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideoInfo)) {
                return false;
            }
            VideoInfo videoInfo = (VideoInfo) other;
            if (Intrinsics.areEqual(this.id, videoInfo.id) && Intrinsics.areEqual(this.playUrl, videoInfo.playUrl) && this.duration == videoInfo.duration && this.isQUICVideo == videoInfo.isQUICVideo) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((((this.id.hashCode() * 31) + this.playUrl.hashCode()) * 31) + androidx.fragment.app.a.a(this.duration)) * 31;
            boolean z16 = this.isQUICVideo;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "VideoInfo(id=" + this.id + ", playUrl=" + this.playUrl + ", duration=" + this.duration + ", isQUICVideo=" + this.isQUICVideo + ")";
        }
    }

    public QFSSchemaTransitionInfo() {
        this(null, null, null, 7, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getCoverPath() {
        return this.coverPath;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final FeedInfo getFeedInfo() {
        return this.feedInfo;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final PositionInfo getPositionInfo() {
        return this.positionInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSSchemaTransitionInfo)) {
            return false;
        }
        QFSSchemaTransitionInfo qFSSchemaTransitionInfo = (QFSSchemaTransitionInfo) other;
        if (Intrinsics.areEqual(this.feedInfo, qFSSchemaTransitionInfo.feedInfo) && Intrinsics.areEqual(this.coverPath, qFSSchemaTransitionInfo.coverPath) && Intrinsics.areEqual(this.positionInfo, qFSSchemaTransitionInfo.positionInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        FeedInfo feedInfo = this.feedInfo;
        int i3 = 0;
        if (feedInfo == null) {
            hashCode = 0;
        } else {
            hashCode = feedInfo.hashCode();
        }
        int i16 = hashCode * 31;
        String str = this.coverPath;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        PositionInfo positionInfo = this.positionInfo;
        if (positionInfo != null) {
            i3 = positionInfo.hashCode();
        }
        return i17 + i3;
    }

    @NotNull
    public String toString() {
        return "QFSSchemaTransitionInfo(feedInfo=" + this.feedInfo + ", coverPath=" + this.coverPath + ", positionInfo=" + this.positionInfo + ")";
    }

    public QFSSchemaTransitionInfo(@Nullable FeedInfo feedInfo, @Nullable String str, @Nullable PositionInfo positionInfo) {
        this.feedInfo = feedInfo;
        this.coverPath = str;
        this.positionInfo = positionInfo;
    }

    public /* synthetic */ QFSSchemaTransitionInfo(FeedInfo feedInfo, String str, PositionInfo positionInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : feedInfo, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : positionInfo);
    }
}
