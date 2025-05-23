package com.qzone.album.protocol;

import NS_MOBILE_VIDEO.DelVideoSummary;
import NS_MOBILE_VIDEO.batch_del_videos_req;
import NS_MOBILE_VIDEO.batch_del_videos_rsp;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneBatchDeleteVideoRequest extends AbsCompatRequest<a> {
    private static final String CMD = "asy_photo.batchDelVideo";
    private static final String UIN_KEY = "batchDelVideo";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public ArrayList<DelVideoSummary> f43986a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f43987b;
    }

    public QzoneBatchDeleteVideoRequest(long j3, ArrayList<String> arrayList) {
        super(CMD);
        batch_del_videos_req batch_del_videos_reqVar = new batch_del_videos_req();
        batch_del_videos_reqVar.uin = j3;
        batch_del_videos_reqVar.vids = arrayList;
        this.req = batch_del_videos_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString() + "Photo";
    }

    public batch_del_videos_rsp getResp() {
        return (batch_del_videos_rsp) this.rsp;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return UIN_KEY;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        if (!(jceStruct instanceof batch_del_videos_rsp)) {
            return null;
        }
        a aVar = new a();
        batch_del_videos_rsp batch_del_videos_rspVar = (batch_del_videos_rsp) jceStruct;
        ArrayList<DelVideoSummary> arrayList = batch_del_videos_rspVar.summarys;
        aVar.f43987b = batch_del_videos_rspVar.ret == 0;
        aVar.f43986a = arrayList;
        return null;
    }
}
