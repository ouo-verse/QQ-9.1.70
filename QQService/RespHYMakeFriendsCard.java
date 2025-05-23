package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespHYMakeFriendsCard extends JceStruct {
    static RespHead cache_stHeader;
    static MakeFriendsCard cache_stMakeFriendsCard;
    static ArrayList<FaceInfo> cache_vFaceInfo;
    public byte bFavorited;
    public byte bQzoneInfo;
    public byte bShareLBS;
    public byte bVoted;
    public byte bWeiboInfo;
    public byte cSqqLevel;
    public int iLat;
    public int iLon;
    public int nSameFriendsNum;
    public RespHead stHeader;
    public MakeFriendsCard stMakeFriendsCard;
    public String strAddress;
    public String strCompany;
    public String strCustomTelNumber;
    public String strSchool;
    public ArrayList<FaceInfo> vFaceInfo;

    public RespHYMakeFriendsCard() {
        this.stHeader = null;
        this.stMakeFriendsCard = null;
        this.bWeiboInfo = (byte) 0;
        this.bQzoneInfo = (byte) 0;
        this.nSameFriendsNum = 0;
        this.strCompany = "";
        this.strSchool = "";
        this.iLat = 900000000;
        this.iLon = 900000000;
        this.strAddress = "";
        this.strCustomTelNumber = "";
        this.vFaceInfo = null;
        this.bVoted = (byte) 0;
        this.bFavorited = (byte) 0;
        this.bShareLBS = (byte) 0;
        this.cSqqLevel = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_stHeader == null) {
            cache_stHeader = new RespHead();
        }
        this.stHeader = (RespHead) jceInputStream.read((JceStruct) cache_stHeader, 0, true);
        if (cache_stMakeFriendsCard == null) {
            cache_stMakeFriendsCard = new MakeFriendsCard();
        }
        this.stMakeFriendsCard = (MakeFriendsCard) jceInputStream.read((JceStruct) cache_stMakeFriendsCard, 1, true);
        this.bWeiboInfo = jceInputStream.read(this.bWeiboInfo, 2, true);
        this.bQzoneInfo = jceInputStream.read(this.bQzoneInfo, 3, true);
        this.nSameFriendsNum = jceInputStream.read(this.nSameFriendsNum, 4, true);
        this.strCompany = jceInputStream.readString(5, true);
        this.strSchool = jceInputStream.readString(6, true);
        this.iLat = jceInputStream.read(this.iLat, 7, false);
        this.iLon = jceInputStream.read(this.iLon, 8, false);
        this.strAddress = jceInputStream.readString(9, false);
        this.strCustomTelNumber = jceInputStream.readString(10, false);
        if (cache_vFaceInfo == null) {
            cache_vFaceInfo = new ArrayList<>();
            cache_vFaceInfo.add(new FaceInfo());
        }
        this.vFaceInfo = (ArrayList) jceInputStream.read((JceInputStream) cache_vFaceInfo, 11, false);
        this.bVoted = jceInputStream.read(this.bVoted, 12, false);
        this.bFavorited = jceInputStream.read(this.bFavorited, 13, false);
        this.bShareLBS = jceInputStream.read(this.bShareLBS, 14, false);
        this.cSqqLevel = jceInputStream.read(this.cSqqLevel, 15, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stHeader, 0);
        jceOutputStream.write((JceStruct) this.stMakeFriendsCard, 1);
        jceOutputStream.write(this.bWeiboInfo, 2);
        jceOutputStream.write(this.bQzoneInfo, 3);
        jceOutputStream.write(this.nSameFriendsNum, 4);
        jceOutputStream.write(this.strCompany, 5);
        jceOutputStream.write(this.strSchool, 6);
        jceOutputStream.write(this.iLat, 7);
        jceOutputStream.write(this.iLon, 8);
        String str = this.strAddress;
        if (str != null) {
            jceOutputStream.write(str, 9);
        }
        String str2 = this.strCustomTelNumber;
        if (str2 != null) {
            jceOutputStream.write(str2, 10);
        }
        ArrayList<FaceInfo> arrayList = this.vFaceInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 11);
        }
        jceOutputStream.write(this.bVoted, 12);
        jceOutputStream.write(this.bFavorited, 13);
        jceOutputStream.write(this.bShareLBS, 14);
        jceOutputStream.write(this.cSqqLevel, 15);
    }

    public RespHYMakeFriendsCard(RespHead respHead, MakeFriendsCard makeFriendsCard, byte b16, byte b17, int i3, String str, String str2, int i16, int i17, String str3, String str4, ArrayList<FaceInfo> arrayList, byte b18, byte b19, byte b26, byte b27) {
        this.stHeader = respHead;
        this.stMakeFriendsCard = makeFriendsCard;
        this.bWeiboInfo = b16;
        this.bQzoneInfo = b17;
        this.nSameFriendsNum = i3;
        this.strCompany = str;
        this.strSchool = str2;
        this.iLat = i16;
        this.iLon = i17;
        this.strAddress = str3;
        this.strCustomTelNumber = str4;
        this.vFaceInfo = arrayList;
        this.bVoted = b18;
        this.bFavorited = b19;
        this.bShareLBS = b26;
        this.cSqqLevel = b27;
    }
}
