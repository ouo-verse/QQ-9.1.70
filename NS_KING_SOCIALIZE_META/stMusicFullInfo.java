package NS_KING_SOCIALIZE_META;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stMusicFullInfo extends JceStruct {
    public stAlbumInfo albumInfo;
    public stConfInfo confInfo;
    public stLyricInfo foreignlyric;
    public stLyricInfo lyricInfo;
    public stSingerInfo singerInfo;
    public stSongInfo songInfo;
    public stLyricInfo subtitleInfo;
    static stAlbumInfo cache_albumInfo = new stAlbumInfo();
    static stSingerInfo cache_singerInfo = new stSingerInfo();
    static stSongInfo cache_songInfo = new stSongInfo();
    static stLyricInfo cache_lyricInfo = new stLyricInfo();
    static stConfInfo cache_confInfo = new stConfInfo();
    static stLyricInfo cache_subtitleInfo = new stLyricInfo();
    static stLyricInfo cache_foreignlyric = new stLyricInfo();

    public stMusicFullInfo() {
        this.albumInfo = null;
        this.singerInfo = null;
        this.songInfo = null;
        this.lyricInfo = null;
        this.confInfo = null;
        this.subtitleInfo = null;
        this.foreignlyric = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.albumInfo = (stAlbumInfo) jceInputStream.read((JceStruct) cache_albumInfo, 0, false);
        this.singerInfo = (stSingerInfo) jceInputStream.read((JceStruct) cache_singerInfo, 1, false);
        this.songInfo = (stSongInfo) jceInputStream.read((JceStruct) cache_songInfo, 2, false);
        this.lyricInfo = (stLyricInfo) jceInputStream.read((JceStruct) cache_lyricInfo, 3, false);
        this.confInfo = (stConfInfo) jceInputStream.read((JceStruct) cache_confInfo, 4, false);
        this.subtitleInfo = (stLyricInfo) jceInputStream.read((JceStruct) cache_subtitleInfo, 5, false);
        this.foreignlyric = (stLyricInfo) jceInputStream.read((JceStruct) cache_foreignlyric, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stAlbumInfo stalbuminfo = this.albumInfo;
        if (stalbuminfo != null) {
            jceOutputStream.write((JceStruct) stalbuminfo, 0);
        }
        stSingerInfo stsingerinfo = this.singerInfo;
        if (stsingerinfo != null) {
            jceOutputStream.write((JceStruct) stsingerinfo, 1);
        }
        stSongInfo stsonginfo = this.songInfo;
        if (stsonginfo != null) {
            jceOutputStream.write((JceStruct) stsonginfo, 2);
        }
        stLyricInfo stlyricinfo = this.lyricInfo;
        if (stlyricinfo != null) {
            jceOutputStream.write((JceStruct) stlyricinfo, 3);
        }
        stConfInfo stconfinfo = this.confInfo;
        if (stconfinfo != null) {
            jceOutputStream.write((JceStruct) stconfinfo, 4);
        }
        stLyricInfo stlyricinfo2 = this.subtitleInfo;
        if (stlyricinfo2 != null) {
            jceOutputStream.write((JceStruct) stlyricinfo2, 5);
        }
        stLyricInfo stlyricinfo3 = this.foreignlyric;
        if (stlyricinfo3 != null) {
            jceOutputStream.write((JceStruct) stlyricinfo3, 6);
        }
    }

    public stMusicFullInfo(stAlbumInfo stalbuminfo, stSingerInfo stsingerinfo, stSongInfo stsonginfo, stLyricInfo stlyricinfo, stConfInfo stconfinfo, stLyricInfo stlyricinfo2, stLyricInfo stlyricinfo3) {
        this.albumInfo = stalbuminfo;
        this.singerInfo = stsingerinfo;
        this.songInfo = stsonginfo;
        this.lyricInfo = stlyricinfo;
        this.confInfo = stconfinfo;
        this.subtitleInfo = stlyricinfo2;
        this.foreignlyric = stlyricinfo3;
    }
}
