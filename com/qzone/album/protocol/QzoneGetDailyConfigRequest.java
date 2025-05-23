package com.qzone.album.protocol;

import NS_MOBILE_PHOTO.daily_recommend_status;
import NS_MOBILE_PHOTO.get_daily_config_req;
import NS_MOBILE_PHOTO.get_daily_config_rsp;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneGetDailyConfigRequest extends AbsCompatRequest {
    private static final String CMD = "asy_photo.GetDailyConfig";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f43991a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f43992b = false;
    }

    public QzoneGetDailyConfigRequest(long j3, int i3, daily_recommend_status daily_recommend_statusVar, boolean z16) {
        super(CMD);
        this.req = new get_daily_config_req(j3, i3, daily_recommend_statusVar, z16);
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.album.protocol.AbsCompatRequest
    public Object onJceRespParse(JceStruct jceStruct) throws Exception {
        a aVar = new a();
        if (jceStruct instanceof get_daily_config_rsp) {
            get_daily_config_rsp get_daily_config_rspVar = (get_daily_config_rsp) jceStruct;
            daily_recommend_status daily_recommend_statusVar = get_daily_config_rspVar.recommend_status;
            if (daily_recommend_statusVar != null) {
                aVar.f43991a = daily_recommend_statusVar.recommend_on;
            }
            aVar.f43992b = get_daily_config_rspVar.remind_upload_on;
        }
        return aVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return "GetDailyConfig";
    }
}
