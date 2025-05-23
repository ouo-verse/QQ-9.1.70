package VIP;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class LikeListInfo extends JceStruct {
    static RedTouchInfo cache_stRedInfo;
    static ArrayList<LikeUserInfo> cache_vLikeList = new ArrayList<>();
    public RedTouchInfo stRedInfo;
    public ArrayList<LikeUserInfo> vLikeList;

    static {
        cache_vLikeList.add(new LikeUserInfo());
        cache_stRedInfo = new RedTouchInfo();
    }

    public LikeListInfo() {
        this.vLikeList = null;
        this.stRedInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vLikeList = (ArrayList) jceInputStream.read((JceInputStream) cache_vLikeList, 0, false);
        this.stRedInfo = (RedTouchInfo) jceInputStream.read((JceStruct) cache_stRedInfo, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<LikeUserInfo> arrayList = this.vLikeList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        RedTouchInfo redTouchInfo = this.stRedInfo;
        if (redTouchInfo != null) {
            jceOutputStream.write((JceStruct) redTouchInfo, 1);
        }
    }

    public LikeListInfo(ArrayList<LikeUserInfo> arrayList, RedTouchInfo redTouchInfo) {
        this.vLikeList = arrayList;
        this.stRedInfo = redTouchInfo;
    }
}
