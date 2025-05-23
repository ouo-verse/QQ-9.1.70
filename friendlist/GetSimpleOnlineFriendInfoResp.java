package friendlist;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class GetSimpleOnlineFriendInfoResp extends JceStruct {
    static int cache_result;
    static ArrayList<SimpleOnlineFriendInfo> cache_vecFriendInfo;
    public byte cShowPcIcon;
    public short errorCode;
    public byte intervalTimeMin;
    public int result;
    public short shClickInterval;
    public long uin;
    public ArrayList<SimpleOnlineFriendInfo> vecFriendInfo;

    public GetSimpleOnlineFriendInfoResp() {
        this.uin = 0L;
        this.vecFriendInfo = null;
        this.result = 0;
        this.errorCode = (short) 0;
        this.intervalTimeMin = (byte) 0;
        this.cShowPcIcon = (byte) 0;
        this.shClickInterval = (short) 30;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        if (cache_vecFriendInfo == null) {
            cache_vecFriendInfo = new ArrayList<>();
            cache_vecFriendInfo.add(new SimpleOnlineFriendInfo());
        }
        this.vecFriendInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vecFriendInfo, 1, true);
        this.result = jceInputStream.read(this.result, 2, true);
        this.errorCode = jceInputStream.read(this.errorCode, 3, false);
        this.intervalTimeMin = jceInputStream.read(this.intervalTimeMin, 4, false);
        this.cShowPcIcon = jceInputStream.read(this.cShowPcIcon, 5, false);
        this.shClickInterval = jceInputStream.read(this.shClickInterval, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write((Collection) this.vecFriendInfo, 1);
        jceOutputStream.write(this.result, 2);
        jceOutputStream.write(this.errorCode, 3);
        jceOutputStream.write(this.intervalTimeMin, 4);
        jceOutputStream.write(this.cShowPcIcon, 5);
        jceOutputStream.write(this.shClickInterval, 6);
    }

    public GetSimpleOnlineFriendInfoResp(long j3, ArrayList<SimpleOnlineFriendInfo> arrayList, int i3, short s16, byte b16, byte b17, short s17) {
        this.uin = j3;
        this.vecFriendInfo = arrayList;
        this.result = i3;
        this.errorCode = s16;
        this.intervalTimeMin = b16;
        this.cShowPcIcon = b17;
        this.shClickInterval = s17;
    }
}
