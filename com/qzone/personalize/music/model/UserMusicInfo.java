package com.qzone.personalize.music.model;

import NS_MOBILE_MUSIC.MusicInfo;
import NS_NEXTRADIO_QZONEBGMUSIC.BGMusicForQzone;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.music.IQzoneMusicHelper;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class UserMusicInfo implements SmartParcelable {

    @NeedParcel
    public String qusicMid = "";

    @NeedParcel
    public long qusicId = 0;

    @NeedParcel
    public String songName = "";

    @NeedParcel
    public int singerId = 0;

    @NeedParcel
    public String singerName = "";

    @NeedParcel
    public boolean expire = true;

    @NeedParcel
    public String songUrl = "";

    @NeedParcel
    public int type = 0;

    @NeedParcel
    public String showId = "";

    @NeedParcel
    public String coverUrl = "";

    public static UserMusicInfo createFrom(MusicInfo musicInfo) {
        if (musicInfo == null) {
            return null;
        }
        UserMusicInfo userMusicInfo = new UserMusicInfo();
        userMusicInfo.qusicMid = musicInfo.xqusic_mid;
        userMusicInfo.qusicId = musicInfo.xqusic_id;
        userMusicInfo.songName = musicInfo.xsong_name;
        userMusicInfo.singerId = musicInfo.xsinger_id;
        userMusicInfo.singerName = musicInfo.xsinger_name;
        userMusicInfo.expire = musicInfo.xexpire;
        userMusicInfo.songUrl = musicInfo.xsong_url;
        userMusicInfo.type = musicInfo.type;
        userMusicInfo.coverUrl = musicInfo.xalbumpic_url;
        return userMusicInfo;
    }

    public final SongInfo toQusicInfo() {
        SongInfo songInfo = new SongInfo();
        songInfo.f251867d = this.qusicId;
        songInfo.f251871i = this.songName;
        songInfo.G = this.singerId;
        songInfo.F = this.singerName;
        songInfo.E = this.qusicMid;
        int i3 = this.type;
        songInfo.I = i3;
        String str = this.songUrl;
        songInfo.f251870h = str;
        if (i3 == 5) {
            songInfo.f251870h = str;
        }
        if (i3 == 8) {
            songInfo.f251872m = this.showId;
        }
        songInfo.C = this.coverUrl;
        return songInfo;
    }

    public static final List<SongInfo> toQusicInfoList(List<UserMusicInfo> list) {
        ArrayList arrayList = null;
        if (list != null && list.size() != 0) {
            for (UserMusicInfo userMusicInfo : list) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(userMusicInfo.toQusicInfo());
            }
        }
        return arrayList;
    }

    public static UserMusicInfo createFrom(BGMusicForQzone bGMusicForQzone) {
        if (bGMusicForQzone == null) {
            return null;
        }
        UserMusicInfo userMusicInfo = new UserMusicInfo();
        userMusicInfo.qusicMid = "";
        userMusicInfo.qusicId = ((IQzoneMusicHelper) QRoute.api(IQzoneMusicHelper.class)).getFMID(bGMusicForQzone.showID);
        userMusicInfo.songName = bGMusicForQzone.showName;
        userMusicInfo.expire = false;
        userMusicInfo.songUrl = bGMusicForQzone.showAudioUrl;
        userMusicInfo.type = 8;
        userMusicInfo.showId = bGMusicForQzone.showID;
        QZLog.i("UserMusicInfo", "BGMusicForQzone showId=" + bGMusicForQzone.showID + ", hash id=" + userMusicInfo.qusicId);
        return userMusicInfo;
    }
}
