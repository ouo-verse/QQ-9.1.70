package com.qzone.personalize.music.request;

import NS_MOBILE_MUSIC.GetMusicListReq;
import NS_MOBILE_MUSIC.MusicID;
import com.qzone.common.protocol.request.QZoneRequest;
import com.tencent.mobileqq.music.SongInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneGetMusicListRequest extends QZoneRequest {
    public static final String CMD_STRING = "getMusicList";

    public QzoneGetMusicListRequest(ArrayList<SongInfo> arrayList) {
        super(CMD_STRING);
        GetMusicListReq getMusicListReq = new GetMusicListReq();
        getMusicListReq.music_id = new ArrayList<>();
        Iterator<SongInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            SongInfo next = it.next();
            if (next != null) {
                MusicID musicID = new MusicID();
                musicID.song_id = next.f251867d;
                musicID.type = next.I;
                getMusicListReq.music_id.add(musicID);
            }
        }
        this.req = getMusicListReq;
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
