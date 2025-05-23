package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.cluster_identify_face_req;
import NS_MOBILE_PHOTO.cluster_identify_face_rsp;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneCategoryIdentifyReq extends AbsCompatRequest<a> {
    private static final String CMD = "asy_photo.CategoryIdentifySearch";
    private static final String UIN_KEY = "CategoryIdentifySearch";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public j4.a f43900a;
    }

    public QZoneCategoryIdentifyReq(long j3, ArrayList<Float> arrayList) {
        super(CMD);
        cluster_identify_face_req cluster_identify_face_reqVar = new cluster_identify_face_req();
        cluster_identify_face_reqVar.op_uin = j3;
        cluster_identify_face_reqVar.feature = arrayList;
        cluster_identify_face_reqVar.mode = 1;
        cluster_identify_face_reqVar.is_demo = false;
        this.req = cluster_identify_face_reqVar;
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
        a aVar = new a();
        cluster_identify_face_rsp cluster_identify_face_rspVar = (cluster_identify_face_rsp) jceStruct;
        j4.a aVar2 = new j4.a();
        if (cluster_identify_face_rspVar.ret == 0) {
            aVar2.f409230a = cluster_identify_face_rspVar.results;
        }
        aVar.f43900a = aVar2;
        return aVar;
    }
}
