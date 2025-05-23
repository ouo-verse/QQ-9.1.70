package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.NegativeFeedbackReq;
import NS_MOBILE_PHOTO.NegativeFeedbackRsp;
import com.qq.taf.jce.JceStruct;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneNegativeFeedbackRequest extends AbsCompatRequest<a> {
    private static final String FIELD_CMD = "asy_photo.NegativeFeedback";
    private static final String TAG = "QZoneNegativeFeedbackRequest";
    private static final String UIN_KEY = "NegativeFeedback";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public NegativeFeedbackRsp f43957a;
    }

    public QZoneNegativeFeedbackRequest(long j3, String str) {
        super(FIELD_CMD);
        super.setHostUin(j3);
        NegativeFeedbackReq negativeFeedbackReq = new NegativeFeedbackReq();
        negativeFeedbackReq.uin = j3;
        negativeFeedbackReq.albumid = str;
        this.req = negativeFeedbackReq;
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
        return UIN_KEY;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.qzone.album.protocol.AbsCompatRequest
    public a onJceRespParse(JceStruct jceStruct) throws Exception {
        if (QZLog.isDevelopLevel()) {
            QZLog.d(TAG, 4, "QZoneNegativeFeedbackRequest receive success");
        }
        if (!(jceStruct instanceof NegativeFeedbackRsp)) {
            return null;
        }
        a aVar = new a();
        aVar.f43957a = (NegativeFeedbackRsp) jceStruct;
        return aVar;
    }
}
