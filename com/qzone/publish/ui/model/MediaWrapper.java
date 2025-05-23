package com.qzone.publish.ui.model;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.util.image.ImageInfo;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class MediaWrapper implements SmartParcelable {
    private static final int MEDIA_TYPE_IMAGE = 0;
    private static final int MEDIA_TYPE_VIDEO = 1;

    @NeedParcel
    public String filterId;

    @NeedParcel
    private ImageInfo mImageInfo;

    @NeedParcel
    private boolean mIsVideo2Gif;

    @NeedParcel
    private ShuoshuoVideoInfo mVideoInfo;

    @NeedParcel
    public String materialId;

    @NeedParcel
    public int photoOriginHeight;

    @NeedParcel
    public long photoOriginSize;

    @NeedParcel
    public int photoOriginWidth;

    @NeedParcel
    private int quality;

    @NeedParcel
    public String simulateName;

    @NeedParcel
    public String simulateSchema;

    @NeedParcel
    private int type;

    @NeedParcel
    public long videoEditBitrate;

    @NeedParcel
    public long videoOriginBitrate;

    public MediaWrapper() {
        this.mIsVideo2Gif = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x008a, code lost:
    
        if (r11.isClosed() == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long getVideoShootTime(Context context, String str) {
        long j3;
        long j16 = 0;
        if (TextUtils.isEmpty(str) || context == null) {
            return 0L;
        }
        String[] strArr = {str};
        Cursor cursor = null;
        try {
            cursor = ContactsMonitor.query(context.getContentResolver(), MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"latitude", "longitude", "datetaken", "date_added"}, "_data = ?", strArr, "_id DESC LIMIT 1");
            if (cursor == null) {
                QZLog.i("getVideoShootTime", "MediaStore query error, cursor is null.");
            } else if (cursor.moveToNext()) {
                if (!cursor.isNull(0)) {
                    cursor.getDouble(0);
                }
                if (!cursor.isNull(1)) {
                    cursor.getDouble(1);
                }
                if (!cursor.isNull(2)) {
                    j3 = cursor.getLong(2);
                } else if (!cursor.isNull(3)) {
                    j3 = cursor.getLong(3);
                }
                j16 = j3;
            }
        } catch (Throwable th5) {
            try {
                QZLog.e("getVideoShootTime", th5.toString());
                if (0 != 0) {
                }
            } finally {
                if (0 != 0 && !cursor.isClosed()) {
                    cursor.close();
                }
            }
        }
        return j16;
    }

    public ImageInfo getImageInfo() {
        return this.mImageInfo;
    }

    public int getQuality() {
        return this.quality;
    }

    public ShuoshuoVideoInfo getVideoInfo() {
        return this.mVideoInfo;
    }

    public boolean isImage() {
        return this.type == 0;
    }

    public boolean isVideo() {
        return this.type == 1;
    }

    public boolean isVideo2Gif() {
        ShuoshuoVideoInfo shuoshuoVideoInfo;
        return isVideo() && (shuoshuoVideoInfo = this.mVideoInfo) != null && shuoshuoVideoInfo.mNeedProcess && this.mIsVideo2Gif;
    }

    public void setQuality(int i3) {
        ShuoshuoVideoInfo shuoshuoVideoInfo;
        this.quality = i3;
        if (isVideo() && this.quality == 3 && (shuoshuoVideoInfo = this.mVideoInfo) != null && TextUtils.isEmpty(shuoshuoVideoInfo.mProcessMissionID)) {
            this.mVideoInfo.mNeedProcess = false;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("MediaWrapper{\n");
        stringBuffer.append("materialID='");
        stringBuffer.append(this.materialId);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", filterId='");
        stringBuffer.append(this.filterId);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", materialName='");
        stringBuffer.append(this.simulateName);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append(", scheme='");
        stringBuffer.append(this.simulateSchema);
        stringBuffer.append('\'');
        stringBuffer.append('\n');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public MediaWrapper(ImageInfo imageInfo) {
        this.mIsVideo2Gif = false;
        this.type = 0;
        this.mImageInfo = imageInfo;
    }

    public void setShuoShuoVideoInfo(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        if (shuoshuoVideoInfo == null) {
            return;
        }
        this.mVideoInfo = shuoshuoVideoInfo;
    }

    public static VideoInfo toVideoInfo(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        if (shuoshuoVideoInfo == null) {
            return null;
        }
        VideoInfo videoInfo = new VideoInfo();
        videoInfo.videoUrl = new VideoUrl(shuoshuoVideoInfo.mVideoPath);
        PictureUrl pictureUrl = new PictureUrl();
        pictureUrl.url = shuoshuoVideoInfo.mVideoPath;
        pictureUrl.width = shuoshuoVideoInfo.mVideoWidth;
        pictureUrl.height = shuoshuoVideoInfo.mVideoHeight;
        String str = shuoshuoVideoInfo.mCoverUrl;
        if (str != null) {
            pictureUrl.url = str;
        }
        videoInfo.bigUrl = pictureUrl;
        videoInfo.originUrl = pictureUrl;
        videoInfo.currentUrl = pictureUrl;
        videoInfo.coverUrl = pictureUrl;
        long j3 = shuoshuoVideoInfo.mDuration;
        videoInfo.videoTime = j3;
        videoInfo.validVideoTime = j3;
        videoInfo.showVideoTime = VideoInfo.getShownTimeFromNumeric(j3);
        videoInfo.videoType = 2;
        videoInfo.actionType = 3;
        videoInfo.playType = (byte) 1;
        videoInfo.isFakeFeed = shuoshuoVideoInfo.mIsFakeFeed;
        videoInfo.desc = shuoshuoVideoInfo.mDescription;
        videoInfo.shootTime = shuoshuoVideoInfo.mShootTime;
        videoInfo.perfKey = shuoshuoVideoInfo.perfKey;
        return videoInfo;
    }

    public MediaWrapper(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        this.mIsVideo2Gif = false;
        this.type = 1;
        this.mVideoInfo = shuoshuoVideoInfo;
        int videoCanCompressLimitMs = QZoneHelper.getVideoCanCompressLimitMs();
        this.mVideoInfo.mNeedProcess = shuoshuoVideoInfo.mTotalDuration < ((long) videoCanCompressLimitMs);
    }

    public MediaWrapper(ShuoshuoVideoInfo shuoshuoVideoInfo, boolean z16) {
        this(shuoshuoVideoInfo, z16, false);
    }

    public MediaWrapper(ShuoshuoVideoInfo shuoshuoVideoInfo, boolean z16, boolean z17) {
        this.mIsVideo2Gif = false;
        this.type = 1;
        this.mVideoInfo = shuoshuoVideoInfo;
        shuoshuoVideoInfo.mNeedProcess = z16;
        this.mIsVideo2Gif = z17;
    }
}
