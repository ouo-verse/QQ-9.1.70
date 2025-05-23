package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.GetPicContInfoReq;
import NS_MOBILE_PHOTO.GetPicContInfoRsp;
import NS_MOBILE_PHOTO.PicContInfo;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.data.model.PicContInfoCacheData;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes39.dex */
public class QzoneGetPicContInfoRequest extends AbsCompatRequest<a> {
    private static final String FIELD_CMD = "asy_photo.GetPicContInfo";
    private static final String TAG = "QzoneGetPicContInfoRequest";
    private static final String UIN_KEY = "GetPicContInfo";

    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public Map<String, PicContInfo> f43994a;

        /* renamed from: b, reason: collision with root package name */
        public HashMap<String, PicContInfoCacheData> f43995b;
    }

    public QzoneGetPicContInfoRequest(long j3, ArrayList<String> arrayList) {
        super(FIELD_CMD);
        super.setHostUin(j3);
        GetPicContInfoReq getPicContInfoReq = new GetPicContInfoReq();
        getPicContInfoReq.pic_url = arrayList;
        getPicContInfoReq.uin = j3;
        this.req = getPicContInfoReq;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return UIN_KEY;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        if (QZLog.isColorLevel()) {
            QZLog.d(TAG, 4, "QzoneGetPicContInfoRequest onJceRespParse");
        }
        if (!(jceStruct instanceof GetPicContInfoRsp)) {
            QZLog.e(TAG, "response is not instanceof GetPicContInfoRsp");
            return null;
        }
        a aVar = new a();
        aVar.f43994a = ((GetPicContInfoRsp) jceStruct).pic_info;
        return aVar;
    }
}
