package com.qzone.publish.business.model;

import FileUpload.UploadPicInfoRsp;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;

/* loaded from: classes39.dex */
public class AlbumPhotoInfo implements SmartParcelable {

    @NeedParcel
    public String networkUrl;

    @NeedParcel
    public String albumid = "";

    @NeedParcel
    public String pictureid = "";

    @NeedParcel
    public String sloc = "";

    @NeedParcel
    public int pictype = 0;

    @NeedParcel
    public int picheight = 0;

    @NeedParcel
    public int picwidth = 0;

    public UploadPicInfoRsp toUploadPicInfoRsp() {
        UploadPicInfoRsp uploadPicInfoRsp = new UploadPicInfoRsp();
        uploadPicInfoRsp.sAlbumID = this.albumid;
        uploadPicInfoRsp.iHeight = this.picheight;
        uploadPicInfoRsp.iWidth = this.picwidth;
        uploadPicInfoRsp.sPhotoID = this.pictureid;
        uploadPicInfoRsp.iPicType = this.pictype;
        uploadPicInfoRsp.sSloc = this.sloc;
        uploadPicInfoRsp.sAdaptUrl_160 = this.pictureid + "_160";
        uploadPicInfoRsp.sAdaptUrl_200 = this.pictureid + "_200";
        uploadPicInfoRsp.sAdaptUrl_400 = this.pictureid + "_400";
        uploadPicInfoRsp.sAdaptUrl_640 = this.pictureid + "_640";
        uploadPicInfoRsp.sAdaptUrl_1000 = this.pictureid + "_1000";
        String str = this.networkUrl;
        uploadPicInfoRsp.sSURL = str;
        uploadPicInfoRsp.sBURL = str;
        return uploadPicInfoRsp;
    }
}
