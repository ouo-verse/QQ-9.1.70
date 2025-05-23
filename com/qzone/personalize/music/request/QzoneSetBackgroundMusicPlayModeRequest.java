package com.qzone.personalize.music.request;

import NS_MOBILE_MUSIC.bg_music_setting_req;
import com.qzone.common.protocol.request.QZoneRequest;

/* loaded from: classes39.dex */
public class QzoneSetBackgroundMusicPlayModeRequest extends QZoneRequest {
    private static String CMD_STRING = "setBgMusicFlag";
    public static final String PLAY_MODE_AUTO_WIFI = "wifi";
    public static final String PLAY_MODE_LOOP = "loop";
    public static final String PLAY_MODE_RANDOM = "random";

    public QzoneSetBackgroundMusicPlayModeRequest(long j3, String str, int i3) {
        super(CMD_STRING);
        bg_music_setting_req bg_music_setting_reqVar = new bg_music_setting_req();
        bg_music_setting_reqVar.uin = j3;
        if (str.equals(PLAY_MODE_RANDOM)) {
            bg_music_setting_reqVar.setting_type = 0;
        } else if ("loop".equals(str)) {
            bg_music_setting_reqVar.setting_type = 2;
        } else {
            bg_music_setting_reqVar.setting_type = 1;
        }
        bg_music_setting_reqVar.setting_value = i3;
        this.req = bg_music_setting_reqVar;
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest
    public String getReportEventName() {
        return getCmdString();
    }

    @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
    public String uniKey() {
        return CMD_STRING;
    }
}
