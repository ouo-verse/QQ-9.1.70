package FileUpload;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public final class UploadVideoInfoReq extends JceStruct {
    static Map<String, String> cache_extend_info;
    static byte[] cache_vBusiNessData;
    public Map<String, String> extend_info;
    public int height;
    public int iBusiNessType;
    public int iFlag;
    public int iIsFormatF20;
    public int iIsNew;
    public int iIsOriginalVideo;
    public int iPlayTime;
    public long iUploadTime;
    public String sCoverUrl;
    public String sDesc;
    public String sTitle;
    public byte[] vBusiNessData;
    public int width;

    static {
        cache_vBusiNessData = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        cache_extend_info = hashMap;
        hashMap.put("", "");
    }

    public UploadVideoInfoReq() {
        this.sTitle = "";
        this.sDesc = "";
        this.iFlag = 0;
        this.iUploadTime = 0L;
        this.iBusiNessType = 0;
        this.vBusiNessData = null;
        this.iPlayTime = 0;
        this.sCoverUrl = "";
        this.iIsNew = 0;
        this.iIsOriginalVideo = 0;
        this.iIsFormatF20 = 0;
        this.extend_info = null;
        this.height = 0;
        this.width = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sTitle = jceInputStream.readString(0, false);
        this.sDesc = jceInputStream.readString(1, false);
        this.iFlag = jceInputStream.read(this.iFlag, 2, false);
        this.iUploadTime = jceInputStream.read(this.iUploadTime, 3, false);
        this.iBusiNessType = jceInputStream.read(this.iBusiNessType, 4, false);
        this.vBusiNessData = jceInputStream.read(cache_vBusiNessData, 5, false);
        this.iPlayTime = jceInputStream.read(this.iPlayTime, 6, false);
        this.sCoverUrl = jceInputStream.readString(7, false);
        this.iIsNew = jceInputStream.read(this.iIsNew, 8, false);
        this.iIsOriginalVideo = jceInputStream.read(this.iIsOriginalVideo, 9, false);
        this.iIsFormatF20 = jceInputStream.read(this.iIsFormatF20, 10, false);
        this.extend_info = (Map) jceInputStream.read((JceInputStream) cache_extend_info, 11, false);
        this.height = jceInputStream.read(this.height, 12, false);
        this.width = jceInputStream.read(this.width, 13, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.sTitle;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.sDesc;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.iFlag, 2);
        jceOutputStream.write(this.iUploadTime, 3);
        jceOutputStream.write(this.iBusiNessType, 4);
        byte[] bArr = this.vBusiNessData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 5);
        }
        jceOutputStream.write(this.iPlayTime, 6);
        String str3 = this.sCoverUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 7);
        }
        jceOutputStream.write(this.iIsNew, 8);
        jceOutputStream.write(this.iIsOriginalVideo, 9);
        jceOutputStream.write(this.iIsFormatF20, 10);
        Map<String, String> map = this.extend_info;
        if (map != null) {
            jceOutputStream.write((Map) map, 11);
        }
        jceOutputStream.write(this.height, 12);
        jceOutputStream.write(this.width, 13);
    }

    public UploadVideoInfoReq(String str, String str2, int i3, long j3, int i16, byte[] bArr, int i17, String str3, int i18, int i19, int i26, Map<String, String> map, int i27, int i28) {
        this.sTitle = str;
        this.sDesc = str2;
        this.iFlag = i3;
        this.iUploadTime = j3;
        this.iBusiNessType = i16;
        this.vBusiNessData = bArr;
        this.iPlayTime = i17;
        this.sCoverUrl = str3;
        this.iIsNew = i18;
        this.iIsOriginalVideo = i19;
        this.iIsFormatF20 = i26;
        this.extend_info = map;
        this.height = i27;
        this.width = i28;
    }
}
