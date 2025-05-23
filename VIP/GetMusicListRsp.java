package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetMusicListRsp extends JceStruct {
    static CommRsp cache_errInfo = new CommRsp();
    static MusicListInfo cache_stMusicList = new MusicListInfo();
    public CommRsp errInfo;
    public long iTotal;
    public boolean isEnd;
    public String sCookie;
    public MusicListInfo stMusicList;

    public GetMusicListRsp() {
        this.errInfo = null;
        this.stMusicList = null;
        this.sCookie = "";
        this.isEnd = true;
        this.iTotal = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.errInfo = (CommRsp) jceInputStream.read((JceStruct) cache_errInfo, 0, false);
        this.stMusicList = (MusicListInfo) jceInputStream.read((JceStruct) cache_stMusicList, 1, false);
        this.sCookie = jceInputStream.readString(2, false);
        this.isEnd = jceInputStream.read(this.isEnd, 3, false);
        this.iTotal = jceInputStream.read(this.iTotal, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CommRsp commRsp = this.errInfo;
        if (commRsp != null) {
            jceOutputStream.write((JceStruct) commRsp, 0);
        }
        MusicListInfo musicListInfo = this.stMusicList;
        if (musicListInfo != null) {
            jceOutputStream.write((JceStruct) musicListInfo, 1);
        }
        String str = this.sCookie;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        jceOutputStream.write(this.isEnd, 3);
        jceOutputStream.write(this.iTotal, 4);
    }

    public GetMusicListRsp(CommRsp commRsp, MusicListInfo musicListInfo, String str, boolean z16, long j3) {
        this.errInfo = commRsp;
        this.stMusicList = musicListInfo;
        this.sCookie = str;
        this.isEnd = z16;
        this.iTotal = j3;
    }
}
