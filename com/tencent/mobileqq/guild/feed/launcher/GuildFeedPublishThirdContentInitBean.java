package com.tencent.mobileqq.guild.feed.launcher;

import android.text.TextUtils;
import com.tencent.biz.richframework.util.RFWMimeUtil;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.c;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0003B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u0004\u0018\u00010\tJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedPublishThirdContentInitBean;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedPublishInitBean;", "", "a", "Lorg/json/JSONObject;", "video", "c", "image", "b", "", "getJsonFeed", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "getMediaInfoList", "jsonFeedContent", "Ljava/lang/String;", "getJsonFeedContent", "()Ljava/lang/String;", "Ljava/util/ArrayList;", "mediaInfo", "Ljava/util/ArrayList;", "getMediaInfo", "()Ljava/util/ArrayList;", "setMediaInfo", "(Ljava/util/ArrayList;)V", "<init>", "(Ljava/lang/String;)V", "Companion", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedPublishThirdContentInitBean extends GuildFeedPublishInitBean {

    @NotNull
    public static final String TAG = "GuildFeedPublishThirdContentInitBean";

    @Nullable
    private final String jsonFeedContent;

    @NotNull
    private ArrayList<LocalMediaInfo> mediaInfo = new ArrayList<>();

    public GuildFeedPublishThirdContentInitBean(@Nullable String str) {
        this.jsonFeedContent = str;
    }

    private final void a() {
        if (TextUtils.isEmpty(this.jsonFeedContent)) {
            return;
        }
        String str = this.jsonFeedContent;
        Intrinsics.checkNotNull(str);
        JSONObject jSONObject = new JSONObject(str);
        c.C7754c c7754c = c.C7754c.f220907a;
        JSONArray optJSONArray = jSONObject.optJSONArray("images");
        if (optJSONArray != null) {
            Intrinsics.checkNotNullExpressionValue(optJSONArray, "optJSONArray(IMAGES)");
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "[parseContent]: images.size=" + optJSONArray.length());
            }
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "images.getJSONObject(index)");
                b(jSONObject2);
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("videos");
        if (optJSONArray2 != null) {
            Intrinsics.checkNotNullExpressionValue(optJSONArray2, "optJSONArray(VIDEOS)");
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "[parseContent]: videos.size=" + optJSONArray2.length());
            }
            int length2 = optJSONArray2.length();
            for (int i16 = 0; i16 < length2; i16++) {
                JSONObject jSONObject3 = optJSONArray2.getJSONObject(i16);
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "videos.getJSONObject(index)");
                c(jSONObject3);
            }
        }
    }

    private final void b(JSONObject image) {
        c.d dVar = c.d.f220908a;
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.path = image.optString("picUrl");
        localMediaInfo.mediaWidth = image.optInt("width");
        localMediaInfo.mediaHeight = image.optInt("height");
        localMediaInfo.position = Integer.valueOf(image.optInt("display_index"));
        int i3 = AlbumThumbDownloader.THUMB_WIDHT;
        localMediaInfo.thumbWidth = i3;
        localMediaInfo.thumbHeight = i3;
        localMediaInfo.mMimeType = RFWMimeUtil.getMimeByMimeTool(localMediaInfo.path);
        localMediaInfo.isRwa = true;
        this.mediaInfo.add(localMediaInfo);
    }

    private final void c(JSONObject video) {
        Unit unit;
        c.h hVar = c.h.f220912a;
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.path = video.optString("playUrl");
        localMediaInfo.mediaWidth = video.optInt("width");
        localMediaInfo.mediaHeight = video.optInt("height");
        localMediaInfo.mDuration = video.optInt("duration");
        String mimeByMimeTool = RFWMimeUtil.getMimeByMimeTool(localMediaInfo.path);
        localMediaInfo.videoMimeType = mimeByMimeTool;
        localMediaInfo.mMimeType = mimeByMimeTool;
        localMediaInfo.position = Integer.valueOf(video.optInt("display_index"));
        JSONObject optJSONObject = video.optJSONObject("cover");
        if (optJSONObject != null) {
            Intrinsics.checkNotNullExpressionValue(optJSONObject, "optJSONObject(COVER)");
            c.d dVar = c.d.f220908a;
            localMediaInfo.thumbnailPath = optJSONObject.optString("picUrl");
            localMediaInfo.thumbWidth = optJSONObject.optInt("width");
            localMediaInfo.thumbHeight = optJSONObject.optInt("height");
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.w(TAG, 1, "[parseVideo], no cover found " + video);
        }
        this.mediaInfo.add(localMediaInfo);
    }

    @Nullable
    /* renamed from: getJsonFeed, reason: from getter */
    public final String getJsonFeedContent() {
        return this.jsonFeedContent;
    }

    @Nullable
    public final String getJsonFeedContent() {
        return this.jsonFeedContent;
    }

    @NotNull
    public final ArrayList<LocalMediaInfo> getMediaInfo() {
        return this.mediaInfo;
    }

    @NotNull
    public final List<LocalMediaInfo> getMediaInfoList() {
        if (this.mediaInfo.isEmpty()) {
            a();
        }
        return this.mediaInfo;
    }

    public final void setMediaInfo(@NotNull ArrayList<LocalMediaInfo> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.mediaInfo = arrayList;
    }
}
