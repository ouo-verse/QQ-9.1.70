package com.qzone.album.protocol;

import NS_MOBILE_FEEDS.stFaceItem;
import NS_MOBILE_PHOTO.MarkFaceInPhotoReq;
import NS_MOBILE_PHOTO.MarkFaceInPhotoRsp;
import NS_MOBILE_PHOTO.MarkFaceItemFeed;
import NS_MOBILE_PHOTO.MarkFaceItemMood;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneFaceOperationRequest extends AbsCompatRequest<a> {
    private static final String CMD_STRING = "asy_photo.MarkFaceInPhoto";
    private static final String TAG = "QzoneFaceOperationRequest";
    private static final String UNI_KEY = "MarkFaceInPhoto";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public String f43988a;

        /* renamed from: b, reason: collision with root package name */
        public int f43989b;

        /* renamed from: c, reason: collision with root package name */
        public stFaceItem f43990c;
    }

    public QzoneFaceOperationRequest(long j3, int i3, MarkFaceItemFeed markFaceItemFeed, MarkFaceItemMood markFaceItemMood) {
        super(CMD_STRING);
        MarkFaceInPhotoReq markFaceInPhotoReq = new MarkFaceInPhotoReq();
        markFaceInPhotoReq.owner = j3;
        markFaceInPhotoReq.scene = i3;
        if (i3 != 3 && i3 != 2) {
            markFaceInPhotoReq.mood_face_info = markFaceItemMood;
        } else {
            markFaceInPhotoReq.feed_face_info = markFaceItemFeed;
        }
        this.req = markFaceInPhotoReq;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    public MarkFaceInPhotoRsp getResponse() {
        return (MarkFaceInPhotoRsp) this.rsp;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return UNI_KEY;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        if (!(jceStruct instanceof MarkFaceInPhotoRsp)) {
            return null;
        }
        a aVar = new a();
        MarkFaceInPhotoRsp markFaceInPhotoRsp = (MarkFaceInPhotoRsp) jceStruct;
        aVar.f43988a = markFaceInPhotoRsp.f25030msg;
        aVar.f43989b = markFaceInPhotoRsp.ret;
        aVar.f43990c = markFaceInPhotoRsp.faceitem;
        return aVar;
    }
}
