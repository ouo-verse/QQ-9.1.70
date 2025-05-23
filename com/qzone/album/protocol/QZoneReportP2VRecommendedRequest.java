package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.RecommendPhotos;
import NS_MOBILE_PHOTO.ReportRecommendedPhotosReq;
import NS_MOBILE_PHOTO.ReportRecommendedPhotosRsp;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes39.dex */
public class QZoneReportP2VRecommendedRequest extends AbsCompatRequest<a> {
    private static final String FIELD_CMD = "asy_photo.ReportRecommendedPhotos";

    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public ReportRecommendedPhotosRsp f43976a;
    }

    public QZoneReportP2VRecommendedRequest(long j3, RecommendPhotos recommendPhotos) {
        super(FIELD_CMD);
        this.req = new ReportRecommendedPhotosReq(j3, recommendPhotos);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return FIELD_CMD;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        if (!(jceStruct instanceof ReportRecommendedPhotosRsp)) {
            return null;
        }
        a aVar = new a();
        aVar.f43976a = (ReportRecommendedPhotosRsp) jceStruct;
        return aVar;
    }
}
