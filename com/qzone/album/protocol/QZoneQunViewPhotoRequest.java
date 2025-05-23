package com.qzone.album.protocol;

import NS_MOBILE_QUN.qun_get_photo_list_ex_req;
import NS_MOBILE_QUN.qun_get_photo_list_ex_rsp;
import com.qq.taf.jce.JceStruct;
import java.util.Map;

/* loaded from: classes39.dex */
public class QZoneQunViewPhotoRequest extends AbsCompatRequest<a> {
    private static final String FIELD_CMD = "qunGetPhotoListEx";

    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public qun_get_photo_list_ex_rsp f43975a;
    }

    public QZoneQunViewPhotoRequest(String str, long j3, String str2, String str3, int i3, int i16, String str4, int i17, int i18, int i19, String str5, Map<Integer, String> map) {
        super(FIELD_CMD);
        qun_get_photo_list_ex_req qun_get_photo_list_ex_reqVar = new qun_get_photo_list_ex_req();
        qun_get_photo_list_ex_reqVar.qunid = str;
        qun_get_photo_list_ex_reqVar.uin = j3;
        qun_get_photo_list_ex_reqVar.albumid = str2;
        qun_get_photo_list_ex_reqVar.curlloc = str3;
        qun_get_photo_list_ex_reqVar.left = i3;
        qun_get_photo_list_ex_reqVar.right = i16;
        qun_get_photo_list_ex_reqVar.password = str4;
        qun_get_photo_list_ex_reqVar.sort = i17;
        qun_get_photo_list_ex_reqVar.get_comment = i18;
        qun_get_photo_list_ex_reqVar.type = i19;
        qun_get_photo_list_ex_reqVar.url = str5;
        qun_get_photo_list_ex_reqVar.busi_param = map;
        qun_get_photo_list_ex_reqVar.batch_id = System.currentTimeMillis() / 1000;
        qun_get_photo_list_ex_reqVar.get_poi = 1;
        qun_get_photo_list_ex_reqVar.get_pfinfo = 1;
        this.req = qun_get_photo_list_ex_reqVar;
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
        if (!(jceStruct instanceof qun_get_photo_list_ex_rsp)) {
            return null;
        }
        a aVar = new a();
        aVar.f43975a = (qun_get_photo_list_ex_rsp) jceStruct;
        return aVar;
    }
}
