package com.tencent.now.app.music.model.data;

import android.text.TextUtils;
import com.tencent.component.core.log.LogUtil;
import java.io.Serializable;
import java.net.URLDecoder;
import oq4.b;
import oq4.c;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MusicItem implements Serializable {
    private static final long serialVersionUID = 2726803027799034511L;
    public String accompanyUrl;
    public String callback;
    public String mId;
    public String originalUrl;
    public String singerName;
    public String songId;
    public String songLyric;
    public String songName;

    public static MusicItem parse(String str, String str2) {
        MusicItem parse = parse(str);
        parse.callback = str2;
        return parse;
    }

    public static MusicItem parseGetMusicInfoRsp(b bVar) {
        MusicItem musicItem = new MusicItem();
        c cVar = bVar.f423388a;
        if (cVar != null) {
            musicItem.songName = cVar.f423389a;
            musicItem.songId = String.valueOf(cVar.f423390b);
            c cVar2 = bVar.f423388a;
            musicItem.mId = cVar2.f423391c;
            musicItem.singerName = cVar2.f423392d;
            musicItem.originalUrl = cVar2.f423393e;
            musicItem.accompanyUrl = cVar2.f423394f;
            musicItem.songLyric = cVar2.f423395g;
        }
        return musicItem;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        MusicItem musicItem = (MusicItem) obj;
        if (TextUtils.isEmpty(musicItem.songId) || !musicItem.songId.equals(this.songId)) {
            return false;
        }
        return true;
    }

    public int getFactor() {
        if (!TextUtils.isEmpty(this.originalUrl) && this.originalUrl.startsWith("http")) {
            if (TextUtils.isEmpty(this.accompanyUrl) || !this.accompanyUrl.startsWith("http")) {
                return 1;
            }
            return 2;
        }
        if (!TextUtils.isEmpty(this.accompanyUrl)) {
            this.accompanyUrl.startsWith("http");
        }
        return 1;
    }

    public int getIntSongId() {
        if (!TextUtils.isEmpty(this.songId) && TextUtils.isDigitsOnly(this.songId)) {
            return Integer.parseInt(this.songId);
        }
        return 0;
    }

    public int getSingFlag() {
        if (!TextUtils.isEmpty(this.originalUrl) && this.originalUrl.startsWith("http")) {
            if (!TextUtils.isEmpty(this.accompanyUrl) && this.accompanyUrl.startsWith("http")) {
                return 2;
            }
            return 1;
        }
        if (!TextUtils.isEmpty(this.accompanyUrl) && this.accompanyUrl.startsWith("http")) {
            return 0;
        }
        return -1;
    }

    public boolean isEmpty() {
        if (TextUtils.isEmpty(this.songId)) {
            return true;
        }
        return false;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("singer_name", this.singerName);
            jSONObject.put("song_id", this.songId);
            jSONObject.put("song_name", this.songName);
            jSONObject.put("mid ", this.mId);
        } catch (JSONException e16) {
            LogUtil.e("MusicItem", "toJson error:" + e16, new Object[0]);
        }
        return jSONObject;
    }

    public String toString() {
        return "MusicItem{songName='" + this.songName + "', songId='" + this.songId + "'}";
    }

    public static MusicItem parse(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(URLDecoder.decode(str, "UTF-8"));
        } catch (Exception e16) {
            LogUtil.e("MusicItem", "parse1 error:" + e16, new Object[0]);
            jSONObject = null;
        }
        return parse(jSONObject);
    }

    public static MusicItem parse(JSONObject jSONObject) {
        MusicItem musicItem = new MusicItem();
        if (jSONObject == null) {
            return musicItem;
        }
        try {
            if (jSONObject.has("singer_name")) {
                musicItem.singerName = jSONObject.getString("singer_name");
            }
            if (jSONObject.has("song_name")) {
                musicItem.songName = jSONObject.getString("song_name");
            }
            if (jSONObject.has("song_id")) {
                musicItem.songId = String.valueOf(jSONObject.getLong("song_id"));
            }
            if (jSONObject.has("mid")) {
                musicItem.mId = jSONObject.getString("mid");
            }
            if (jSONObject.has("play_url")) {
                musicItem.originalUrl = jSONObject.getString("play_url");
            }
            if (jSONObject.has("song_lyric")) {
                musicItem.songLyric = jSONObject.getString("song_lyric");
            }
            if (jSONObject.has("accompany_url")) {
                musicItem.accompanyUrl = jSONObject.getString("accompany_url");
            }
        } catch (Exception e16) {
            LogUtil.e("MusicItem", "parse2 error:" + e16, new Object[0]);
        }
        return musicItem;
    }
}
