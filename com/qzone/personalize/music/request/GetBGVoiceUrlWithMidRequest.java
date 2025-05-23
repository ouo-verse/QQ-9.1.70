package com.qzone.personalize.music.request;

import NS_QZONE_BG_MUSIC.tGetMusicInfoReq;
import com.qzone.common.protocol.request.QZoneRequest;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GetBGVoiceUrlWithMidRequest extends QZoneRequest {
    public static final String CMD_STRING = "Qzmall.GetMusicInfo";
    public static final int GET_BG_VOICE_NEED_URL = 1;
    public static final int GET_BG_VOICE_NOT_NEED_URL = 0;
    public static final String UNIKEY_STRING = "GetMusicInfo";

    public GetBGVoiceUrlWithMidRequest(long j3, ArrayList<String> arrayList, int i3) {
        super(CMD_STRING);
        if (arrayList != null) {
            tGetMusicInfoReq tgetmusicinforeq = new tGetMusicInfoReq();
            tgetmusicinforeq.lUin = j3;
            tgetmusicinforeq.vecSongId = arrayList;
            tgetmusicinforeq.iNeedUrl = i3;
            this.req = tgetmusicinforeq;
            return;
        }
        throw new IllegalArgumentException("GetBGVoiceUrlWithMidRequest : vecSongId must not be null");
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String getCmdString() {
        return "QzoneNewService.Qzmall.GetMusicInfo";
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return UNIKEY_STRING;
    }
}
