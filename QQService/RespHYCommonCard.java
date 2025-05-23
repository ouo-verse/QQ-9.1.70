package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespHYCommonCard extends JceStruct {
    static CommonCard cache_stCommonCard;
    static RespHead cache_stHeader;
    static ArrayList<FaceInfo> cache_vFaceInfo;
    static byte[] cache_vQQFaceID;
    public byte bFavorited;
    public byte bQzoneInfo;
    public byte bShareLBS;
    public byte bVoted;
    public byte bWeiboInfo;
    public byte cSqqLevel;
    public CommonCard stCommonCard;
    public RespHead stHeader;
    public String strReMark;
    public ArrayList<FaceInfo> vFaceInfo;
    public byte[] vQQFaceID;

    public RespHYCommonCard() {
        this.stHeader = null;
        this.stCommonCard = null;
        this.strReMark = "";
        this.bWeiboInfo = (byte) 0;
        this.bQzoneInfo = (byte) 0;
        this.vFaceInfo = null;
        this.bVoted = (byte) 0;
        this.bFavorited = (byte) 0;
        this.bShareLBS = (byte) 0;
        this.vQQFaceID = null;
        this.cSqqLevel = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new RespHead();
        }
        this.stHeader = (RespHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        if (cache_stCommonCard == null) {
            cache_stCommonCard = new CommonCard();
        }
        this.stCommonCard = (CommonCard) jceInputStream.read((JceStruct) cache_stCommonCard, 1, true);
        this.strReMark = jceInputStream.readString(2, true);
        this.bWeiboInfo = jceInputStream.read(this.bWeiboInfo, 3, true);
        this.bQzoneInfo = jceInputStream.read(this.bQzoneInfo, 4, true);
        if (cache_vFaceInfo == null) {
            cache_vFaceInfo = new ArrayList<>();
            cache_vFaceInfo.add(new FaceInfo());
        }
        this.vFaceInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vFaceInfo, 5, false);
        this.bVoted = jceInputStream.read(this.bVoted, 6, false);
        this.bFavorited = jceInputStream.read(this.bFavorited, 7, false);
        this.bShareLBS = jceInputStream.read(this.bShareLBS, 8, false);
        if (cache_vQQFaceID == null) {
            cache_vQQFaceID = r0;
            byte[] bArr = {0};
        }
        this.vQQFaceID = jceInputStream.read(cache_vQQFaceID, 9, false);
        this.cSqqLevel = jceInputStream.read(this.cSqqLevel, 10, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write((JceStruct) this.stCommonCard, 1);
        jceOutputStream.write(this.strReMark, 2);
        jceOutputStream.write(this.bWeiboInfo, 3);
        jceOutputStream.write(this.bQzoneInfo, 4);
        ArrayList<FaceInfo> arrayList = this.vFaceInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 5);
        }
        jceOutputStream.write(this.bVoted, 6);
        jceOutputStream.write(this.bFavorited, 7);
        jceOutputStream.write(this.bShareLBS, 8);
        byte[] bArr = this.vQQFaceID;
        if (bArr != null) {
            jceOutputStream.write(bArr, 9);
        }
        jceOutputStream.write(this.cSqqLevel, 10);
    }

    public RespHYCommonCard(RespHead respHead, CommonCard commonCard, String str, byte b16, byte b17, ArrayList<FaceInfo> arrayList, byte b18, byte b19, byte b26, byte[] bArr, byte b27) {
        this.stHeader = respHead;
        this.stCommonCard = commonCard;
        this.strReMark = str;
        this.bWeiboInfo = b16;
        this.bQzoneInfo = b17;
        this.vFaceInfo = arrayList;
        this.bVoted = b18;
        this.bFavorited = b19;
        this.bShareLBS = b26;
        this.vQQFaceID = bArr;
        this.cSqqLevel = b27;
    }
}
