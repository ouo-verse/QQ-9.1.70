package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.get_photo_list_ex_req;
import NS_MOBILE_PHOTO.get_photo_list_ex_rsp;
import com.qq.taf.jce.JceStruct;
import java.util.Map;

/* loaded from: classes39.dex */
public class QZoneViewPhotoRequest extends AbsCompatRequest<a> {
    private static final String FIELD_CMD = "getPhotoListEx";

    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public get_photo_list_ex_rsp f43977a;
    }

    public QZoneViewPhotoRequest(long j3, String str, String str2, int i3, int i16, String str3, int i17, int i18, int i19, int i26, int i27, String str4, Map<Integer, String> map, int i28, String str5, long j16, int i29, long j17) {
        super("getPhotoListEx");
        get_photo_list_ex_req get_photo_list_ex_reqVar = new get_photo_list_ex_req();
        get_photo_list_ex_reqVar.appid = i28;
        get_photo_list_ex_reqVar.uin = j3;
        get_photo_list_ex_reqVar.albumid = str;
        get_photo_list_ex_reqVar.curlloc = str2;
        get_photo_list_ex_reqVar.left = i3;
        get_photo_list_ex_reqVar.right = i16;
        get_photo_list_ex_reqVar.password = str3;
        get_photo_list_ex_reqVar.sort = i17;
        get_photo_list_ex_reqVar.get_comment = i18;
        get_photo_list_ex_reqVar.swidth = i19;
        get_photo_list_ex_reqVar.sheight = i26;
        get_photo_list_ex_reqVar.type = i27;
        get_photo_list_ex_reqVar.url = str4;
        get_photo_list_ex_reqVar.busi_param = map;
        get_photo_list_ex_reqVar.curid = str5;
        get_photo_list_ex_reqVar.albumtype = j16;
        get_photo_list_ex_reqVar.get_photo_ex_type = i29;
        get_photo_list_ex_reqVar.sharer = j17;
        this.req = get_photo_list_ex_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "getPhotoListEx";
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        if (!(jceStruct instanceof get_photo_list_ex_rsp)) {
            return null;
        }
        a aVar = new a();
        aVar.f43977a = (get_photo_list_ex_rsp) jceStruct;
        return aVar;
    }
}
