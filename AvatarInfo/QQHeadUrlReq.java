package AvatarInfo;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QQHeadUrlReq extends JceStruct {
    static ArrayList<DestQQHeadInfo> cache_destUserInfo;
    public ArrayList<DestQQHeadInfo> destUserInfo;
    public byte dstUsrType;
    public long myUin;

    public QQHeadUrlReq() {
        this.myUin = 0L;
        this.destUserInfo = null;
        this.dstUsrType = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.myUin = jceInputStream.read(this.myUin, 0, true);
        if (cache_destUserInfo == null) {
            cache_destUserInfo = new ArrayList<>();
            cache_destUserInfo.add(new DestQQHeadInfo());
        }
        this.destUserInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_destUserInfo, 1, true);
        this.dstUsrType = jceInputStream.read(this.dstUsrType, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.myUin, 0);
        jceOutputStream.write((Collection) this.destUserInfo, 1);
        jceOutputStream.write(this.dstUsrType, 2);
    }

    public QQHeadUrlReq(long j3, ArrayList<DestQQHeadInfo> arrayList, byte b16) {
        this.myUin = j3;
        this.destUserInfo = arrayList;
        this.dstUsrType = b16;
    }
}
