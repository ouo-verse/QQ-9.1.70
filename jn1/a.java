package jn1;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.data.MessageForQCircleFeed;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a {

    @SerializedName("imageCount")
    private int mImageCount;

    @SerializedName("isPublishEnabled")
    private boolean mIsPublishEnabled;

    @SerializedName("maxMediaCount")
    private int mMaxMediaCount;

    @SerializedName("maxVideoCount")
    private int mMaxVideoCount;

    @SerializedName("maxVideoDuration")
    private int mMaxVideoDuration;

    @SerializedName(MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_VIDEO_COUNT)
    private int mVideoCount;

    public int a() {
        return this.mImageCount;
    }

    public int b() {
        return this.mMaxMediaCount;
    }

    public int c() {
        return this.mMaxVideoCount;
    }

    public int d() {
        return this.mMaxVideoDuration;
    }

    public int e() {
        return this.mVideoCount;
    }

    public boolean f() {
        return this.mIsPublishEnabled;
    }

    public String toString() {
        return "GuildEditorExtInfo{mImageCount=" + this.mImageCount + ", mVideoCount=" + this.mVideoCount + ", mMaxMediaCount=" + this.mMaxMediaCount + ", mMaxVideoCount=" + this.mMaxVideoCount + ", mMaxVideoDuration=" + this.mMaxVideoDuration + ", mIsPublishEnabled=" + this.mIsPublishEnabled + '}';
    }
}
