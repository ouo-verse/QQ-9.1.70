package com.qzone.album.protocol;

import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_FEEDS.s_picurl;
import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.GetFiltPhotoListReq;
import NS_MOBILE_PHOTO.GetFiltPhotoListRsp;
import NS_MOBILE_PHOTO.s_outshare;
import com.qq.taf.jce.JceStruct;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.util.e;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes39.dex */
public class QZoneGetFiltPhotoRequest extends AbsCompatRequest<a> {
    private static final String CMD_STRING = "asy_photo.GetFiltPhotoList";
    private static final String TAG = "QZoneGetFiltPhotoRequest";
    private static final String UNI_KEY = "GetFiltPhotoList";

    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public String f43917a = "";

        /* renamed from: b, reason: collision with root package name */
        public Album f43918b = null;

        /* renamed from: c, reason: collision with root package name */
        public PictureUrl f43919c;

        /* renamed from: d, reason: collision with root package name */
        public s_outshare f43920d;

        /* renamed from: e, reason: collision with root package name */
        public ArrayList<s_picdata> f43921e;
    }

    public QZoneGetFiltPhotoRequest(long j3, String str, long j16) {
        super(CMD_STRING);
        super.setHostUin(this.hostUin);
        GetFiltPhotoListReq getFiltPhotoListReq = new GetFiltPhotoListReq();
        getFiltPhotoListReq.uin = j3;
        getFiltPhotoListReq.albumid = str;
        getFiltPhotoListReq.batchid = j16;
        getFiltPhotoListReq.filt_richflag = 3L;
        this.req = getFiltPhotoListReq;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    protected long getHostUin() {
        return this.hostUin;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return UNI_KEY;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        if (!(jceStruct instanceof GetFiltPhotoListRsp)) {
            return null;
        }
        a aVar = new a();
        GetFiltPhotoListRsp getFiltPhotoListRsp = (GetFiltPhotoListRsp) jceStruct;
        aVar.f43917a = getFiltPhotoListRsp.attach_info;
        aVar.f43918b = getFiltPhotoListRsp.albuminfo;
        aVar.f43919c = getCoverUrl(getFiltPhotoListRsp.photolist);
        aVar.f43921e = getFiltPhotoListRsp.photolist;
        aVar.f43920d = getFiltPhotoListRsp.shareinfo;
        return aVar;
    }

    private PictureUrl getCoverUrl(ArrayList<s_picdata> arrayList) {
        s_picdata s_picdataVar;
        Map<Integer, s_picurl> map;
        s_picurl s_picurlVar;
        if (arrayList != null && arrayList.size() > 0 && (s_picdataVar = arrayList.get(0)) != null && (map = s_picdataVar.photourl) != null) {
            if (map.get(11) == null) {
                s_picurlVar = s_picdataVar.photourl.get(3);
            } else {
                s_picurlVar = s_picdataVar.photourl.get(11);
            }
            if (s_picurlVar != null) {
                return e.n(s_picurlVar);
            }
        }
        return null;
    }
}
