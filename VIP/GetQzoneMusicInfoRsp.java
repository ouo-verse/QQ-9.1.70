package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetQzoneMusicInfoRsp extends JceStruct {
    static CommRsp cache_errInfo = new CommRsp();
    static Map<String, MusicInfo> cache_mMusicList = new HashMap();
    public CommRsp errInfo;
    public Map<String, MusicInfo> mMusicList;

    static {
        cache_mMusicList.put("", new MusicInfo());
    }

    public GetQzoneMusicInfoRsp() {
        this.errInfo = null;
        this.mMusicList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.errInfo = (CommRsp) jceInputStream.read((JceStruct) cache_errInfo, 0, false);
        this.mMusicList = (Map) jceInputStream.read((JceInputStream) cache_mMusicList, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CommRsp commRsp = this.errInfo;
        if (commRsp != null) {
            jceOutputStream.write((JceStruct) commRsp, 0);
        }
        Map<String, MusicInfo> map = this.mMusicList;
        if (map != null) {
            jceOutputStream.write((Map) map, 1);
        }
    }

    public GetQzoneMusicInfoRsp(CommRsp commRsp, Map<String, MusicInfo> map) {
        this.errInfo = commRsp;
        this.mMusicList = map;
    }
}
