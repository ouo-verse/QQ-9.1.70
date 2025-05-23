package com.tencent.mobileqq.editor.database;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import hd0.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class PublishVideoEntry extends Entity {
    static IPatchRedirector $redirector_ = null;
    public static final String ENTRY_KEY_BACKGROUND_VOLUME = "backgroundVolume";
    public static final String ENTRY_KEY_IS_MIX_ORIGINAL = "isMixOriginal";
    public static final String ENTRY_KEY_ORIGINAL_RECORD_VOLUME = "originalRecordVolume";
    public static final String ENTRY_KEY_SUBTITLE = "subtitleData";
    public static int VIDEO_PROCESS_STATE_COMPOSITE_FAILED;
    public static int VIDEO_PROCESS_STATE_COMPOSITE_SUC;
    public static int VIDEO_PROCESS_STATE_UPLOAD_SUC;
    public String atDoodlePath;
    public String atJsonData;
    public int backgroundMusicDuration;
    public int backgroundMusicOffset;
    public String backgroundMusicPath;
    public int businessId;
    public long createTime;
    public String doodlePath;
    public String doodleRawPath;

    @notColumn
    private JSONObject extraJson;
    public String extraJsonString;

    @unique
    public String fakeVid;

    @Deprecated
    public int fragmentGroupId;
    public String fragments;
    public String gpsFilterDescription;
    public boolean hasFragments;

    @notColumn
    public int hwBitrateMode;
    public boolean hwEncodeRecordVideo;

    @notColumn
    public boolean isCancel;

    @notColumn
    public boolean isEdited;
    public boolean isLocalPublish;

    @notColumn
    public boolean isMixOriginal;
    public boolean isMuteRecordVoice;

    @notColumn
    public boolean isNeedHighProfile;
    public boolean isPicture;
    public String localCreateCity;
    public String mAudioFilePath;
    public String mIFrameVideoPath;
    public String mLocalDate;
    public String mLocalRawPicPath;
    public String mLocalRawVideoDir;
    public byte[] mMosaicMask;
    public int mMosaicSize;

    @notColumn
    public String manualSavedPath;
    public String mbgmAudioFilePath;
    public String miniThumbPath;
    public String mosaicPath;
    public String multiFragmentGroupId;
    public String name;
    public int publishFrom;
    public int publishState;
    public byte[] readerConfBytes;
    public int recordFrames;
    public double recordTime;
    public int saveMode;
    public byte[] spreadGroupBytes;
    public byte[] tagInfoBytes;
    public String thumbPath;
    public long timeZoneOffset;

    @notColumn
    public boolean useSrcFile;
    public String videoAddress;
    public String videoCreateAddress;
    public long videoCreateTime;
    public String videoDoodleDescription;
    public long videoDuration;
    public int videoHeight;
    public String videoLabel;
    public int videoLatitude;
    public String videoLocationDescription;
    public int videoLongitude;
    public int videoMaxrate;
    public int videoMinrate;
    public boolean videoNeedRotate;
    public int videoProcessState;
    public int videoRangeEnd;
    public int videoRangeStart;
    public String videoUploadGroupTempDir;
    public String videoUploadTempDir;
    public int videoWidth;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42299);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        VIDEO_PROCESS_STATE_COMPOSITE_FAILED = -1;
        VIDEO_PROCESS_STATE_COMPOSITE_SUC = 1;
        VIDEO_PROCESS_STATE_UPLOAD_SUC = 2;
    }

    public PublishVideoEntry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.hwBitrateMode = -1;
            this.isCancel = false;
        }
    }

    @NonNull
    private synchronized JSONObject getExtraJson() {
        try {
            if (this.extraJson == null) {
                if (this.extraJsonString != null) {
                    this.extraJson = new JSONObject(this.extraJsonString);
                } else {
                    this.extraJson = new JSONObject();
                }
            }
        } catch (JSONException e16) {
            c.h("PublishVideoEntry", "getExtraJson error", e16);
            this.extraJson = new JSONObject();
        }
        return this.extraJson;
    }

    public static String getGroupIdNoArgs() {
        return "multiFragmentGroupId=?";
    }

    public static String getVidSelectionNoArgs() {
        return "fakeVid=?";
    }

    public void copy(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, obj);
            return;
        }
        if (obj == null) {
            return;
        }
        PublishVideoEntry publishVideoEntry = (PublishVideoEntry) obj;
        this.fakeVid = publishVideoEntry.fakeVid;
        this.createTime = publishVideoEntry.createTime;
        this.mLocalDate = publishVideoEntry.mLocalDate;
        this.timeZoneOffset = publishVideoEntry.timeZoneOffset;
        this.businessId = publishVideoEntry.businessId;
        this.name = publishVideoEntry.name;
        this.mLocalRawVideoDir = publishVideoEntry.mLocalRawVideoDir;
        this.mLocalRawPicPath = publishVideoEntry.mLocalRawPicPath;
        this.mMosaicMask = publishVideoEntry.mMosaicMask;
        this.mMosaicSize = publishVideoEntry.mMosaicSize;
        this.backgroundMusicPath = publishVideoEntry.backgroundMusicPath;
        this.backgroundMusicOffset = publishVideoEntry.backgroundMusicOffset;
        this.backgroundMusicDuration = publishVideoEntry.backgroundMusicDuration;
        this.isMuteRecordVoice = publishVideoEntry.isMuteRecordVoice;
        this.recordTime = publishVideoEntry.recordTime;
        this.recordFrames = publishVideoEntry.recordFrames;
        this.saveMode = publishVideoEntry.saveMode;
        this.isPicture = publishVideoEntry.isPicture;
        this.isLocalPublish = publishVideoEntry.isLocalPublish;
        this.publishFrom = publishVideoEntry.publishFrom;
        this.videoCreateTime = publishVideoEntry.videoCreateTime;
        this.fragmentGroupId = publishVideoEntry.fragmentGroupId;
        this.multiFragmentGroupId = publishVideoEntry.multiFragmentGroupId;
        this.videoRangeStart = publishVideoEntry.videoRangeStart;
        this.videoRangeEnd = publishVideoEntry.videoRangeEnd;
        this.videoCreateAddress = publishVideoEntry.videoCreateAddress;
        this.tagInfoBytes = publishVideoEntry.tagInfoBytes;
        this.videoUploadTempDir = publishVideoEntry.videoUploadTempDir;
        this.videoUploadGroupTempDir = publishVideoEntry.videoUploadGroupTempDir;
        this.publishState = publishVideoEntry.publishState;
        this.thumbPath = publishVideoEntry.thumbPath;
        this.doodlePath = publishVideoEntry.doodlePath;
        this.doodleRawPath = publishVideoEntry.doodleRawPath;
        this.videoLabel = publishVideoEntry.videoLabel;
        this.videoDoodleDescription = publishVideoEntry.videoDoodleDescription;
        this.videoLocationDescription = publishVideoEntry.videoLocationDescription;
        this.gpsFilterDescription = publishVideoEntry.gpsFilterDescription;
        this.videoAddress = publishVideoEntry.videoAddress;
        this.videoWidth = publishVideoEntry.videoWidth;
        this.videoHeight = publishVideoEntry.videoHeight;
        this.videoDuration = publishVideoEntry.videoDuration;
        this.videoMaxrate = publishVideoEntry.videoMaxrate;
        this.videoMinrate = publishVideoEntry.videoMinrate;
        this.atDoodlePath = publishVideoEntry.atDoodlePath;
        this.atJsonData = publishVideoEntry.atJsonData;
        this.localCreateCity = publishVideoEntry.localCreateCity;
        this.videoLatitude = publishVideoEntry.videoLatitude;
        this.videoLongitude = publishVideoEntry.videoLongitude;
        this.videoNeedRotate = publishVideoEntry.videoNeedRotate;
        this.hwEncodeRecordVideo = publishVideoEntry.hwEncodeRecordVideo;
        this.mAudioFilePath = publishVideoEntry.mAudioFilePath;
        this.mIFrameVideoPath = publishVideoEntry.mIFrameVideoPath;
        this.mosaicPath = publishVideoEntry.mosaicPath;
        this.readerConfBytes = publishVideoEntry.readerConfBytes;
        this.spreadGroupBytes = publishVideoEntry.spreadGroupBytes;
        this.videoProcessState = publishVideoEntry.videoProcessState;
        this.extraJsonString = publishVideoEntry.extraJsonString;
        this.extraJson = publishVideoEntry.extraJson;
        this.manualSavedPath = publishVideoEntry.manualSavedPath;
        this.isEdited = publishVideoEntry.isEdited;
        this.isNeedHighProfile = publishVideoEntry.isNeedHighProfile;
        this.hwBitrateMode = publishVideoEntry.hwBitrateMode;
        this.mbgmAudioFilePath = publishVideoEntry.mbgmAudioFilePath;
    }

    public boolean getBooleanExtra(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        return getExtraJson().optBoolean(str, z16);
    }

    public int getIntExtra(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, i3)).intValue();
        }
        return getExtraJson().optInt(str, i3);
    }

    public JSONArray getJSONArrayExtra(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (JSONArray) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        return getExtraJson().optJSONArray(str);
    }

    public JSONObject getJSONExtra(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (JSONObject) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        return getExtraJson().optJSONObject(str);
    }

    public long getLongExtra(String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, this, str, Long.valueOf(j3))).longValue();
        }
        return getExtraJson().optLong(str, j3);
    }

    public String getStringExtra(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        }
        return getExtraJson().optString(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.postRead();
        this.isNeedHighProfile = getBooleanExtra("isNeedHighProfile", false);
        this.hwBitrateMode = getIntExtra("hwBitrateMode", -1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.prewrite();
        putExtra("isNeedHighProfile", Boolean.valueOf(this.isNeedHighProfile));
        putExtra("hwBitrateMode", Integer.valueOf(this.hwBitrateMode));
    }

    public boolean putExtra(String str, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, obj)).booleanValue();
        }
        try {
            JSONObject extraJson = getExtraJson();
            extraJson.put(str, obj);
            this.extraJsonString = extraJson.toString();
            return true;
        } catch (JSONException e16) {
            c.h("PublishVideoEntry", "putStringExtra error", e16);
            return false;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "PublishVideoEntry{fakeVid='" + this.fakeVid + "', createTime=" + this.createTime + ", mLocalDate='" + this.mLocalDate + "', fragmentGroupId=" + this.fragmentGroupId + ", multiFragmentGroupId='" + this.multiFragmentGroupId + "', timeZoneOffset=" + this.timeZoneOffset + ", mLocalRawVideoDir='" + this.mLocalRawVideoDir + "', mLocalRawPicPath='" + this.mLocalRawPicPath + "', mMosaicSize=" + this.mMosaicSize + ", backgroundMusicPath='" + this.backgroundMusicPath + "', backgroundMusicOffset=" + this.backgroundMusicOffset + ", backgroundMusicDuration=" + this.backgroundMusicDuration + ", isMuteRecordVoice=" + this.isMuteRecordVoice + ", recordTime=" + this.recordTime + ", recordFrames=" + this.recordFrames + ", saveMode=" + this.saveMode + ", isPicture=" + this.isPicture + ", isLocalPublish=" + this.isLocalPublish + ", publishFrom=" + this.publishFrom + ", videoCreateTime=" + this.videoCreateTime + ", hasFragments=" + this.hasFragments + ", fragments='" + this.fragments + "', videoRangeStart=" + this.videoRangeStart + ", videoRangeEnd=" + this.videoRangeEnd + ", videoUploadTempDir='" + this.videoUploadTempDir + "', videoUploadGroupTempDir='" + this.videoUploadGroupTempDir + "', publishState=" + this.publishState + ", thumbPath='" + this.thumbPath + "', doodlePath='" + this.doodlePath + "', doodleRawPath='" + this.doodleRawPath + "', videoWidth=" + this.videoWidth + ", videoHeight=" + this.videoHeight + ", videoDuration=" + this.videoDuration + ", videoMaxrate=" + this.videoMaxrate + ", videoMinrate=" + this.videoMinrate + ", videoNeedRotate=" + this.videoNeedRotate + ", hwEncodeRecordVideo=" + this.hwEncodeRecordVideo + ", mAudioFilePath='" + this.mAudioFilePath + "', mIFrameVideoPath='" + this.mIFrameVideoPath + "', mosaicPath='" + this.mosaicPath + "', videoProcessState=" + this.videoProcessState + ", extraJsonString=" + this.extraJsonString + '}';
    }
}
