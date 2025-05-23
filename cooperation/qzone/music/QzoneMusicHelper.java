package cooperation.qzone.music;

import android.text.TextUtils;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QzoneMusicHelper {
    public static final String NO_NETWORK_MSG = HardCodeUtil.qqStr(R.string.s0h);

    public static SongInfo convertAudioSongInfo(JSONObject jSONObject) {
        SongInfo songInfo = new SongInfo();
        songInfo.f251871i = getString(jSONObject, "name");
        songInfo.F = getString(jSONObject, "singer");
        songInfo.f251867d = getLong(jSONObject, IOnlineStatusService.SONG_ID);
        songInfo.f251870h = getString(jSONObject, "playUrl");
        songInfo.I = getInt(jSONObject, "type");
        songInfo.C = getString(jSONObject, "cover");
        songInfo.G = getLong(jSONObject, "singerId");
        songInfo.E = getString(jSONObject, "album");
        songInfo.D = getString(jSONObject, "detailUrl");
        String string = getString(jSONObject, "showId");
        songInfo.f251872m = string;
        if (songInfo.f251867d == 0) {
            songInfo.f251867d = getFMID(string);
        }
        return songInfo;
    }

    public static SongInfo convertFMBgMusic(JSONObject jSONObject) {
        SongInfo songInfo = new SongInfo();
        String string = getString(jSONObject, "showID");
        songInfo.f251871i = getString(jSONObject, "showName");
        songInfo.F = "";
        songInfo.f251867d = getFMID(string);
        songInfo.f251870h = getString(jSONObject, "showAudioUrl");
        songInfo.I = 8;
        songInfo.C = "";
        songInfo.G = 0L;
        songInfo.E = "";
        songInfo.D = "";
        songInfo.f251872m = string;
        return songInfo;
    }

    public static SongInfo convertSongInfo(JSONObject jSONObject) {
        SongInfo songInfo = new SongInfo();
        songInfo.f251871i = getString(jSONObject, "name");
        songInfo.F = getString(jSONObject, "singer");
        songInfo.f251867d = getLong(jSONObject, IOnlineStatusService.SONG_ID);
        songInfo.f251870h = getString(jSONObject, "playUrl");
        songInfo.I = getInt(jSONObject, "type");
        songInfo.C = getString(jSONObject, "cover");
        songInfo.G = getLong(jSONObject, "singerId");
        songInfo.E = getString(jSONObject, "album");
        songInfo.f251869f = getLong(jSONObject, "uin");
        if (TextUtils.isEmpty(songInfo.E)) {
            songInfo.E = getString(jSONObject, "songMid");
        }
        if (TextUtils.isEmpty(songInfo.E)) {
            songInfo.E = getString(jSONObject, "musicMId");
        }
        if (!TextUtils.isEmpty(songInfo.E) && songInfo.f251867d == 0) {
            songInfo.f251867d = getSongIDWithMid(songInfo.E);
        }
        if (songInfo.I == 0 && getInt(jSONObject, "voiceType") == 3) {
            songInfo.I = 11;
        }
        songInfo.D = getString(jSONObject, "detailUrl");
        return songInfo;
    }

    private static int getInt(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getInt(str);
        } catch (Exception e16) {
            QLog.e("QzoneWebMusicJsPlugin", 2, "getInt " + e16.getMessage());
            return 0;
        }
    }

    private static long getLong(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getLong(str);
        } catch (Exception e16) {
            QLog.e("QzoneWebMusicJsPlugin", 2, "getLong " + e16.getMessage());
            return 0L;
        }
    }

    public static long getSongIDWithMid(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        long hashCode = str.hashCode();
        return hashCode <= 0 ? hashCode * (-1) : hashCode;
    }

    private static String getString(JSONObject jSONObject, String str) {
        try {
            return jSONObject.getString(str);
        } catch (Exception e16) {
            QLog.e("QzoneWebMusicJsPlugin", 2, "getString " + e16.getMessage());
            return null;
        }
    }

    public static long getFMID(String str) {
        if (str == null || str.length() <= 0) {
            return 0L;
        }
        long hashCode = str.hashCode();
        return hashCode >= 0 ? ((hashCode * (-1)) - 1) + WebViewConstants.WV.ENABLE_WEBAIO_SWITCH : hashCode;
    }
}
