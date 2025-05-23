package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SlaveMasterMsg extends JceStruct {
    static ArrayList<MarketFaceInfo> cache_vMarketFace;
    static byte[] cache_vOrigMsg;
    static byte[] cache_vReserved;
    public long lFromUin;
    public long lToUin;
    public long uCmd;
    public long uFromInstId;
    public long uLastChangeTime;
    public long uMsgType;
    public long uSeq;
    public long uSuperQQBubbleId;
    public long uToInstId;
    public ArrayList<MarketFaceInfo> vMarketFace;
    public byte[] vOrigMsg;
    public byte[] vReserved;
    public short wFromApp;
    public short wToApp;

    public SlaveMasterMsg() {
        this.uMsgType = 0L;
        this.uCmd = 0L;
        this.uSeq = 0L;
        this.lFromUin = 0L;
        this.wFromApp = (short) 0;
        this.uFromInstId = 0L;
        this.lToUin = 0L;
        this.wToApp = (short) 0;
        this.uToInstId = 0L;
        this.vOrigMsg = null;
        this.uLastChangeTime = 0L;
        this.vReserved = null;
        this.vMarketFace = null;
        this.uSuperQQBubbleId = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uMsgType = jceInputStream.read(this.uMsgType, 0, false);
        this.uCmd = jceInputStream.read(this.uCmd, 1, false);
        this.uSeq = jceInputStream.read(this.uSeq, 2, false);
        this.lFromUin = jceInputStream.read(this.lFromUin, 3, false);
        this.wFromApp = jceInputStream.read(this.wFromApp, 4, false);
        this.uFromInstId = jceInputStream.read(this.uFromInstId, 5, false);
        this.lToUin = jceInputStream.read(this.lToUin, 6, false);
        this.wToApp = jceInputStream.read(this.wToApp, 7, false);
        this.uToInstId = jceInputStream.read(this.uToInstId, 8, false);
        if (cache_vOrigMsg == null) {
            cache_vOrigMsg = r0;
            byte[] bArr = {0};
        }
        this.vOrigMsg = jceInputStream.read(cache_vOrigMsg, 9, false);
        this.uLastChangeTime = jceInputStream.read(this.uLastChangeTime, 10, false);
        if (cache_vReserved == null) {
            cache_vReserved = r0;
            byte[] bArr2 = {0};
        }
        this.vReserved = jceInputStream.read(cache_vReserved, 11, false);
        if (cache_vMarketFace == null) {
            cache_vMarketFace = new ArrayList<>();
            cache_vMarketFace.add(new MarketFaceInfo());
        }
        this.vMarketFace = (ArrayList) jceInputStream.read((JceInputStream) cache_vMarketFace, 12, false);
        this.uSuperQQBubbleId = jceInputStream.read(this.uSuperQQBubbleId, 13, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uMsgType, 0);
        jceOutputStream.write(this.uCmd, 1);
        jceOutputStream.write(this.uSeq, 2);
        jceOutputStream.write(this.lFromUin, 3);
        jceOutputStream.write(this.wFromApp, 4);
        jceOutputStream.write(this.uFromInstId, 5);
        jceOutputStream.write(this.lToUin, 6);
        jceOutputStream.write(this.wToApp, 7);
        jceOutputStream.write(this.uToInstId, 8);
        byte[] bArr = this.vOrigMsg;
        if (bArr != null) {
            jceOutputStream.write(bArr, 9);
        }
        jceOutputStream.write(this.uLastChangeTime, 10);
        byte[] bArr2 = this.vReserved;
        if (bArr2 != null) {
            jceOutputStream.write(bArr2, 11);
        }
        ArrayList<MarketFaceInfo> arrayList = this.vMarketFace;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 12);
        }
        jceOutputStream.write(this.uSuperQQBubbleId, 13);
    }

    public SlaveMasterMsg(long j3, long j16, long j17, long j18, short s16, long j19, long j26, short s17, long j27, byte[] bArr, long j28, byte[] bArr2, ArrayList<MarketFaceInfo> arrayList, long j29) {
        this.uMsgType = j3;
        this.uCmd = j16;
        this.uSeq = j17;
        this.lFromUin = j18;
        this.wFromApp = s16;
        this.uFromInstId = j19;
        this.lToUin = j26;
        this.wToApp = s17;
        this.uToInstId = j27;
        this.vOrigMsg = bArr;
        this.uLastChangeTime = j28;
        this.vReserved = bArr2;
        this.vMarketFace = arrayList;
        this.uSuperQQBubbleId = j29;
    }
}
