package com.qzone.proxy.feedcomponent.model;

import android.os.Bundle;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ShuoshuoVideoInfo implements SmartParcelable {
    public static final String KEY_COMPRESS_DRAFT_MISSION_ID = "KEY_COMPRESS_DRAFT_MISSION_ID";
    public static final String KEY_PUBLISH_PARAMS_TYPE = "KEY_PUBLISH_PARAMS_TYPE";
    public static final String KEY_VIDEO_ORIGINAL_PATH = "VIDEO_ORIGINAL_PATH";
    public static final int PROCESS_TYPE_OLD_QZONE = 0;
    public static final int PROCESS_TYPE_QCIRCLE_PUBLISH = 1;
    public static final int VIDEO_ISNEW_COVER = 106;
    public static final int VIDEO_ISNEW_RECORD = 1;
    public static final int VIDEO_ISNEW_TOPIC = 104;
    public static final int VIDEO_ISNEW_TRIM = 102;
    public static final int VIDEO_TYPE_QZONE_ALBUM_VIDEO = 2;
    public static final int VIDEO_TYPE_RECORD = 0;
    public static final int VIDEO_TYPE_TRIM = 1;

    @NeedParcel
    public Map<String, Object> extraInfo;

    @NeedParcel
    public String fakeVid;

    @NeedParcel
    public String mCoverUrl;

    @NeedParcel
    public String mDesc;

    @NeedParcel
    public String mDescription;

    @NeedParcel
    public long mDuration;

    @NeedParcel
    public long mEndTime;

    @NeedParcel
    public double mEstimateSize;

    @NeedParcel
    public Bundle mExtras;

    @NeedParcel
    public int mFlag;

    @NeedParcel
    public boolean mHasCompressed;

    @NeedParcel
    public int mIsClientCompressed;
    public boolean mIsFakeFeed;

    @NeedParcel
    public int mIsNew;

    @NeedParcel
    public int mIsOriginalVideo;

    @NeedParcel
    public boolean mIsUploadOrigin;

    @NeedParcel
    public boolean mNeedProcess;

    @NeedParcel
    public String mProcessMissionID;

    @NeedParcel
    public long mShootTime;

    @NeedParcel
    public long mSize;

    @NeedParcel
    public long mStartTime;

    @NeedParcel
    public String mTakenTime;

    @NeedParcel
    public String mTitle;

    @NeedParcel
    public long mTotalDuration;

    @NeedParcel
    public int mVideoHeight;

    @NeedParcel
    public String mVideoPath;

    @NeedParcel
    public int mVideoType;

    @NeedParcel
    public int mVideoWidth;

    @NeedParcel
    public boolean needDeleteLocal;

    @NeedParcel
    public String perfKey;

    @NeedParcel
    public String topicId;

    @NeedParcel
    public boolean topicSyncQzone;
    public int videoFrom = -1;

    @NeedParcel
    public int mProcessType = 0;

    public String getEditDraftMissionId() {
        Map<String, Object> map = this.extraInfo;
        if (map != null) {
            Object obj = map.get(KEY_COMPRESS_DRAFT_MISSION_ID);
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return "";
    }

    public String getPublishParamsType() {
        Map<String, Object> map = this.extraInfo;
        if (map != null) {
            Object obj = map.get(KEY_PUBLISH_PARAMS_TYPE);
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return "";
    }

    public String getVideoOriginalPath() {
        Map<String, Object> map = this.extraInfo;
        if (map != null) {
            Object obj = map.get(KEY_VIDEO_ORIGINAL_PATH);
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return "";
    }

    public void setEditDraftMissionId(String str) {
        if (this.extraInfo == null) {
            this.extraInfo = new HashMap();
        }
        this.extraInfo.put(KEY_COMPRESS_DRAFT_MISSION_ID, str);
    }

    public void setPublishParamsType(String str) {
        if (this.extraInfo == null) {
            this.extraInfo = new HashMap();
        }
        this.extraInfo.put(KEY_PUBLISH_PARAMS_TYPE, str);
    }

    public void setVideoOriginalPath(String str) {
        if (this.extraInfo == null) {
            this.extraInfo = new HashMap();
        }
        this.extraInfo.put(KEY_VIDEO_ORIGINAL_PATH, str);
    }
}
