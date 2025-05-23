package com.qzone.reborn.albumx.qzonex.bean.upload;

import FileUpload.MultiPicInfo;
import FileUpload.PicExtendInfo;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.publish.business.model.a;
import com.qzone.util.image.ImageInfo;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import cooperation.qzone.LbsDataV2;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes37.dex */
public class QZAlbumxUploadVideoTaskParams implements SmartParcelable {

    @NeedParcel
    public long batchId;

    @NeedParcel
    public String clientKey;

    @NeedParcel
    public String content;

    @NeedParcel
    public int curNum;

    @NeedParcel
    public Map<String, byte[]> extras;

    @NeedParcel
    public List<ImageInfo> imageInfos;

    @NeedParcel
    public boolean isSingleVideo;

    @NeedParcel
    public String lbsAddress;

    @NeedParcel
    public Map<String, String> localUrlMap;

    @NeedParcel
    public int maxNum;
    public a.C0436a mediaReportInfo;

    @NeedParcel
    public String originalVideoPath;

    @NeedParcel
    public LbsDataV2.PoiInfo poiInfo;

    @NeedParcel
    public String refer;

    @NeedParcel
    public Map<String, String> shootParams;

    @NeedParcel
    public ShuoshuoVideoInfo shuoshuoVideoInfo;

    @NeedParcel
    public int uploadEntrance;

    @NeedParcel
    public long uploadTime;

    @NeedParcel
    public VideoInfo videoInfo;

    @NeedParcel
    public String waterTemplateId;

    @NeedParcel
    public String watermarkPoiName;

    @NeedParcel
    public int step = 2;

    @NeedParcel
    public String picTitle = "";

    @NeedParcel
    public String albumName = "";

    @NeedParcel
    public String albumId = "";

    @NeedParcel
    public int albumTypeId = 0;

    @NeedParcel
    public int iBitmap = 0;

    @NeedParcel
    public int iUploadType = 0;

    @NeedParcel
    public int iUpPicType = 0;

    @NeedParcel
    public MultiPicInfo multiPicInfo = null;

    @NeedParcel
    public PicExtendInfo stExtendInfo = null;

    @NeedParcel
    public String exifTime = "";

    @NeedParcel
    public String picPath = "";
    public int successCount = 0;
    public int retryCount = 0;
    public int iDistinctUse = 0;
    public int iBusiNessType = 0;
    public byte[] vBusiNessData = null;
    public HashMap<String, String> stExternalMapExt = null;
    public HashMap<String, String> mapExt = null;
    public boolean taskIsRunning = false;
}
