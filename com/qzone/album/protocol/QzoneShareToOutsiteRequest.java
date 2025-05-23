package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.GetAlbumCommShareKeyReq;
import NS_MOBILE_PHOTO.GetAlbumCommShareKeyRsp;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneShareToOutsiteRequest extends AbsCompatRequest<a> {
    private static final String CMD_SHARE_TO_OUTSITE = "QzoneNewService.asy_photo.GetAlbumCommShareKey";
    private static final String UIN_KEY = "GetAlbumCommShareKey";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f43996a;

        /* renamed from: b, reason: collision with root package name */
        public String f43997b;

        /* renamed from: c, reason: collision with root package name */
        public String f43998c;

        /* renamed from: d, reason: collision with root package name */
        public String f43999d;

        /* renamed from: e, reason: collision with root package name */
        public String f44000e;

        /* renamed from: f, reason: collision with root package name */
        public String f44001f;
    }

    public QzoneShareToOutsiteRequest(GetAlbumCommShareKeyReq getAlbumCommShareKeyReq) {
        super(CMD_SHARE_TO_OUTSITE);
        this.req = getAlbumCommShareKeyReq;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return CMD_SHARE_TO_OUTSITE;
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
        if (jceStruct instanceof GetAlbumCommShareKeyRsp) {
            GetAlbumCommShareKeyRsp getAlbumCommShareKeyRsp = (GetAlbumCommShareKeyRsp) jceStruct;
            aVar.f43996a = getAlbumCommShareKeyRsp.ret;
            aVar.f43997b = getAlbumCommShareKeyRsp.f25026msg;
            aVar.f43998c = getAlbumCommShareKeyRsp.outs.get("kShareOutUrl");
            aVar.f43999d = getAlbumCommShareKeyRsp.outs.get("kShareOutLPhoto");
            aVar.f44000e = getAlbumCommShareKeyRsp.outs.get("kShareOutRTitle");
            aVar.f44001f = getAlbumCommShareKeyRsp.outs.get("kShareOutRDesc");
        }
        return aVar;
    }

    public QzoneShareToOutsiteRequest(long j3, int i3, String str, ArrayList<String> arrayList, String str2) {
        super(CMD_SHARE_TO_OUTSITE);
        GetAlbumCommShareKeyReq getAlbumCommShareKeyReq = new GetAlbumCommShareKeyReq();
        getAlbumCommShareKeyReq.uin = j3;
        getAlbumCommShareKeyReq.scene = i3;
        HashMap hashMap = new HashMap();
        hashMap.put("kShareInCategoryid", str);
        StringBuilder sb5 = new StringBuilder();
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            if (i16 != arrayList.size() - 1) {
                sb5.append(arrayList.get(i16) + "|");
            } else {
                sb5.append(arrayList.get(i16));
            }
        }
        hashMap.put("kShareInGroupid", sb5.toString());
        hashMap.put("kShareInLeftUrl", str2);
        getAlbumCommShareKeyReq.ins = hashMap;
        this.req = getAlbumCommShareKeyReq;
    }
}
