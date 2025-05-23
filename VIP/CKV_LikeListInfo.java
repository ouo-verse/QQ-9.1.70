package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CKV_LikeListInfo extends JceStruct {
    static Map<Long, CKV_LikeInfo> cache_mLikeList = new HashMap();
    public long iLstCheckTime;
    public Map<Long, CKV_LikeInfo> mLikeList;

    static {
        cache_mLikeList.put(0L, new CKV_LikeInfo());
    }

    public CKV_LikeListInfo() {
        this.mLikeList = null;
        this.iLstCheckTime = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mLikeList = (Map) jceInputStream.read((JceInputStream) cache_mLikeList, 0, false);
        this.iLstCheckTime = jceInputStream.read(this.iLstCheckTime, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        Map<Long, CKV_LikeInfo> map = this.mLikeList;
        if (map != null) {
            jceOutputStream.write((Map) map, 0);
        }
        jceOutputStream.write(this.iLstCheckTime, 1);
    }

    public CKV_LikeListInfo(Map<Long, CKV_LikeInfo> map, long j3) {
        this.mLikeList = map;
        this.iLstCheckTime = j3;
    }
}
