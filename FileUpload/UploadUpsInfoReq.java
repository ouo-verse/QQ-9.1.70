package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UploadUpsInfoReq extends JceStruct {
    static Map<String, byte[]> cache_mapExt;
    static byte[] cache_vBusiNessData;
    public byte bNotifyWns;
    public int iAppid;
    public int iBatUploadNum;
    public long iBatchId;
    public int iCurUpload;
    public int iKeppRaw;
    public long iPicHight;
    public long iPicWidth;
    public int iType;
    public Map<String, byte[]> mapExt;
    public String sBusinessId;
    public String sFileId;
    public String sWnsCmd;
    public byte[] vBusiNessData;

    static {
        cache_vBusiNessData = r1;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        cache_mapExt = hashMap;
        hashMap.put("", new byte[]{0});
    }

    public UploadUpsInfoReq() {
        this.sBusinessId = "";
        this.sFileId = "";
        this.iType = 0;
        this.vBusiNessData = null;
        this.iKeppRaw = 0;
        this.iAppid = 0;
        this.bNotifyWns = (byte) 0;
        this.iBatUploadNum = 0;
        this.iCurUpload = 0;
        this.iBatchId = 0L;
        this.sWnsCmd = "";
        this.iPicWidth = 0L;
        this.iPicHight = 0L;
        this.mapExt = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sBusinessId = jceInputStream.readString(0, true);
        this.sFileId = jceInputStream.readString(1, false);
        this.iType = jceInputStream.read(this.iType, 2, true);
        this.vBusiNessData = jceInputStream.read(cache_vBusiNessData, 3, false);
        this.iKeppRaw = jceInputStream.read(this.iKeppRaw, 4, false);
        this.iAppid = jceInputStream.read(this.iAppid, 5, false);
        this.bNotifyWns = jceInputStream.read(this.bNotifyWns, 6, false);
        this.iBatUploadNum = jceInputStream.read(this.iBatUploadNum, 7, false);
        this.iCurUpload = jceInputStream.read(this.iCurUpload, 8, false);
        this.iBatchId = jceInputStream.read(this.iBatchId, 9, false);
        this.sWnsCmd = jceInputStream.readString(10, false);
        this.iPicWidth = jceInputStream.read(this.iPicWidth, 11, false);
        this.iPicHight = jceInputStream.read(this.iPicHight, 12, false);
        this.mapExt = (Map) jceInputStream.read((JceInputStream) cache_mapExt, 13, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.sBusinessId, 0);
        String str = this.sFileId;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.iType, 2);
        byte[] bArr = this.vBusiNessData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 3);
        }
        jceOutputStream.write(this.iKeppRaw, 4);
        jceOutputStream.write(this.iAppid, 5);
        jceOutputStream.write(this.bNotifyWns, 6);
        jceOutputStream.write(this.iBatUploadNum, 7);
        jceOutputStream.write(this.iCurUpload, 8);
        jceOutputStream.write(this.iBatchId, 9);
        String str2 = this.sWnsCmd;
        if (str2 != null) {
            jceOutputStream.write(str2, 10);
        }
        jceOutputStream.write(this.iPicWidth, 11);
        jceOutputStream.write(this.iPicHight, 12);
        Map<String, byte[]> map = this.mapExt;
        if (map != null) {
            jceOutputStream.write((Map) map, 13);
        }
    }

    public UploadUpsInfoReq(String str, String str2, int i3, byte[] bArr, int i16, int i17, byte b16, int i18, int i19, long j3, String str3, long j16, long j17, Map<String, byte[]> map) {
        this.sBusinessId = str;
        this.sFileId = str2;
        this.iType = i3;
        this.vBusiNessData = bArr;
        this.iKeppRaw = i16;
        this.iAppid = i17;
        this.bNotifyWns = b16;
        this.iBatUploadNum = i18;
        this.iCurUpload = i19;
        this.iBatchId = j3;
        this.sWnsCmd = str3;
        this.iPicWidth = j16;
        this.iPicHight = j17;
        this.mapExt = map;
    }
}
