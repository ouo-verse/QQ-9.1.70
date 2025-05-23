package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.GetShareAlbumMemberReq;
import NS_MOBILE_PHOTO.GetShareAlbumMemberRsp;
import NS_MOBILE_PHOTO.ShareAlbumMemberData;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.data.model.ShareAlbumMemberCacheData;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneGetShareAlbumMemberDataRequest extends AbsCompatRequest<a> {
    private static final String CMD_STRING = "asy_photo.GetShareAlbumMemberData";
    private static final String TAG = "QZoneGetShareAlbumMemberData";
    private static final String UNI_KEY = "GetShareAlbumMemberData";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f43944a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f43945b = "";

        /* renamed from: c, reason: collision with root package name */
        public Album f43946c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<ShareAlbumMemberData> f43947d;

        /* renamed from: e, reason: collision with root package name */
        public ArrayList<ShareAlbumMemberCacheData> f43948e;
    }

    public QZoneGetShareAlbumMemberDataRequest(long j3, String str) {
        super(CMD_STRING);
        super.setHostUin(this.hostUin);
        GetShareAlbumMemberReq getShareAlbumMemberReq = new GetShareAlbumMemberReq();
        getShareAlbumMemberReq.uin = j3;
        getShareAlbumMemberReq.albumid = str;
        this.req = getShareAlbumMemberReq;
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
        if (!(jceStruct instanceof GetShareAlbumMemberRsp)) {
            return null;
        }
        a aVar = new a();
        GetShareAlbumMemberRsp getShareAlbumMemberRsp = (GetShareAlbumMemberRsp) jceStruct;
        aVar.f43944a = getShareAlbumMemberRsp.ret;
        aVar.f43945b = getShareAlbumMemberRsp.f25028msg;
        aVar.f43946c = getShareAlbumMemberRsp.album;
        aVar.f43947d = getShareAlbumMemberRsp.member_datas;
        aVar.f43948e = new ArrayList<>();
        for (int i3 = 0; i3 < aVar.f43947d.size(); i3++) {
            ShareAlbumMemberCacheData shareAlbumMemberCacheData = new ShareAlbumMemberCacheData();
            shareAlbumMemberCacheData.uin = aVar.f43947d.get(i3).uin;
            shareAlbumMemberCacheData.nick = aVar.f43947d.get(i3).nick;
            shareAlbumMemberCacheData.photo_cnt = aVar.f43947d.get(i3).photo_cnt;
            shareAlbumMemberCacheData.video_cnt = aVar.f43947d.get(i3).video_cnt;
            shareAlbumMemberCacheData.page = aVar.f43947d.get(i3).page;
            aVar.f43948e.add(shareAlbumMemberCacheData);
        }
        return aVar;
    }
}
