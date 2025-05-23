package com.qzone.reborn.albumx.qzonex.bean.upload;

import FileUpload.stPoi;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import cooperation.qzone.LbsDataV2;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes37.dex */
public class QZAlbumxUploadPicTaskParams implements SmartParcelable {

    @NeedParcel
    public String albumId;

    @NeedParcel
    public long batchId;

    @NeedParcel
    public String clientKey;

    @NeedParcel
    public int curNum;
    public Map<String, String> extendInfo;

    @NeedParcel
    public HashMap<String, byte[]> externalData;

    @NeedParcel
    public int flowId;
    public boolean isVideoMix;

    @NeedParcel
    public long lastModifyTime;

    @NeedParcel
    public Map<String, String> localUrlMap;

    @NeedParcel
    public int maxNum;
    public String openAppId;

    @NeedParcel
    public int panoramaType;

    @NeedParcel
    public String photoDescription;

    @NeedParcel
    public String photoFilePath;

    @NeedParcel
    public String photoName;

    @NeedParcel
    public Map<String, String> photoTagExtendInfo;

    @NeedParcel
    public int picQuality;

    @NeedParcel
    public LbsDataV2.PoiInfo poiInfo;

    @NeedParcel
    public String refer;
    public Map<String, String> shootParams;

    @NeedParcel
    public stPoi stPoi;
    public int successCount;

    @NeedParcel
    public int target;

    @NeedParcel
    public int uploadEntrance;

    @NeedParcel
    public long uploadTime;

    @NeedParcel
    public String albumName = "";

    @NeedParcel
    public int step = 1;
    public int uploadFinishRetryCount = 0;
}
