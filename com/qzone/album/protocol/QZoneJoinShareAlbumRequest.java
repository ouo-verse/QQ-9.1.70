package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.AllowJoinShareAlbum;
import NS_MOBILE_PHOTO.ApplyJoinShareAlbum;
import NS_MOBILE_PHOTO.JoinShareAlbumReq;
import NS_MOBILE_PHOTO.JoinShareAlbumRsp;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneJoinShareAlbumRequest extends AbsCompatRequest<a> {
    private static final String CMD_STRING = "asy_photo.JoinShareAlbum";
    private static final String TAG = "QZoneJoinShareAlbumRequest";
    private static final String UNI_KEY = "JoinShareAlbum";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f43949a = 0;

        /* renamed from: b, reason: collision with root package name */
        public String f43950b = "";

        /* renamed from: c, reason: collision with root package name */
        public boolean f43951c = false;
    }

    public QZoneJoinShareAlbumRequest(long j3, int i3, ApplyJoinShareAlbum applyJoinShareAlbum, AllowJoinShareAlbum allowJoinShareAlbum) {
        super(CMD_STRING);
        super.setHostUin(this.hostUin);
        JoinShareAlbumReq joinShareAlbumReq = new JoinShareAlbumReq();
        joinShareAlbumReq.op_uin = j3;
        joinShareAlbumReq.mode = i3;
        joinShareAlbumReq.apply_data = applyJoinShareAlbum;
        joinShareAlbumReq.allow_data = allowJoinShareAlbum;
        this.req = joinShareAlbumReq;
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
        if (!(jceStruct instanceof JoinShareAlbumRsp)) {
            return null;
        }
        a aVar = new a();
        JoinShareAlbumRsp joinShareAlbumRsp = (JoinShareAlbumRsp) jceStruct;
        aVar.f43949a = joinShareAlbumRsp.ret;
        aVar.f43950b = joinShareAlbumRsp.f25029msg;
        aVar.f43951c = joinShareAlbumRsp.isAutoJoin;
        return aVar;
    }
}
