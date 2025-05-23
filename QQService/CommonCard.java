package QQService;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CommonCard extends JceStruct {
    static int cache_eUserIdentityType;
    static byte[] cache_vBackground;
    static ArrayList<TagInfo> cache_vTags;
    public byte bSingle;
    public int eUserIdentityType;
    public int iFaceNum;
    public int iQQLevel;
    public long lFavoriteCount;
    public long lVisitCount;
    public long lVoteCount;
    public int nFaceID;
    public short shAge;
    public short shGender;
    public String strCompany;
    public String strNick;
    public String strSchool;
    public String strSign;
    public int uFaceTimeStamp;
    public byte[] vBackground;
    public ArrayList<TagInfo> vTags;

    public CommonCard() {
        this.strNick = "";
        this.shGender = (short) 0;
        this.shAge = (short) 0;
        this.nFaceID = 0;
        this.strSign = "";
        this.strCompany = "";
        this.strSchool = "";
        this.uFaceTimeStamp = 0;
        this.bSingle = (byte) 0;
        this.lVisitCount = 0L;
        this.lVoteCount = 0L;
        this.vTags = null;
        this.eUserIdentityType = UserIdentityType.UserIdentityType_Nomal.value();
        this.vBackground = null;
        this.iFaceNum = 0;
        this.lFavoriteCount = 0L;
        this.iQQLevel = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.strNick = jceInputStream.readString(0, true);
        this.shGender = jceInputStream.read(this.shGender, 1, true);
        this.shAge = jceInputStream.read(this.shAge, 2, true);
        this.nFaceID = jceInputStream.read(this.nFaceID, 3, true);
        this.strSign = jceInputStream.readString(4, true);
        this.strCompany = jceInputStream.readString(5, true);
        this.strSchool = jceInputStream.readString(6, true);
        this.uFaceTimeStamp = jceInputStream.read(this.uFaceTimeStamp, 7, true);
        this.bSingle = jceInputStream.read(this.bSingle, 8, false);
        this.lVisitCount = jceInputStream.read(this.lVisitCount, 9, false);
        this.lVoteCount = jceInputStream.read(this.lVoteCount, 10, false);
        if (cache_vTags == null) {
            cache_vTags = new ArrayList<>();
            cache_vTags.add(new TagInfo());
        }
        this.vTags = (ArrayList) jceInputStream.read((JceInputStream) cache_vTags, 11, false);
        this.eUserIdentityType = jceInputStream.read(this.eUserIdentityType, 12, false);
        if (cache_vBackground == null) {
            cache_vBackground = r1;
            byte[] bArr = {0};
        }
        this.vBackground = jceInputStream.read(cache_vBackground, 13, false);
        this.iFaceNum = jceInputStream.read(this.iFaceNum, 14, false);
        this.lFavoriteCount = jceInputStream.read(this.lFavoriteCount, 15, false);
        this.iQQLevel = jceInputStream.read(this.iQQLevel, 16, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.strNick, 0);
        jceOutputStream.write(this.shGender, 1);
        jceOutputStream.write(this.shAge, 2);
        jceOutputStream.write(this.nFaceID, 3);
        jceOutputStream.write(this.strSign, 4);
        jceOutputStream.write(this.strCompany, 5);
        jceOutputStream.write(this.strSchool, 6);
        jceOutputStream.write(this.uFaceTimeStamp, 7);
        jceOutputStream.write(this.bSingle, 8);
        jceOutputStream.write(this.lVisitCount, 9);
        jceOutputStream.write(this.lVoteCount, 10);
        ArrayList<TagInfo> arrayList = this.vTags;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 11);
        }
        jceOutputStream.write(this.eUserIdentityType, 12);
        byte[] bArr = this.vBackground;
        if (bArr != null) {
            jceOutputStream.write(bArr, 13);
        }
        jceOutputStream.write(this.iFaceNum, 14);
        jceOutputStream.write(this.lFavoriteCount, 15);
        jceOutputStream.write(this.iQQLevel, 16);
    }

    public CommonCard(String str, short s16, short s17, int i3, String str2, String str3, String str4, int i16, byte b16, long j3, long j16, ArrayList<TagInfo> arrayList, int i17, byte[] bArr, int i18, long j17, int i19) {
        this.strNick = "";
        this.shGender = (short) 0;
        this.shAge = (short) 0;
        this.nFaceID = 0;
        this.strSign = "";
        this.strCompany = "";
        this.strSchool = "";
        this.uFaceTimeStamp = 0;
        this.bSingle = (byte) 0;
        this.lVisitCount = 0L;
        this.lVoteCount = 0L;
        this.vTags = null;
        UserIdentityType.UserIdentityType_Nomal.value();
        this.strNick = str;
        this.shGender = s16;
        this.shAge = s17;
        this.nFaceID = i3;
        this.strSign = str2;
        this.strCompany = str3;
        this.strSchool = str4;
        this.uFaceTimeStamp = i16;
        this.bSingle = b16;
        this.lVisitCount = j3;
        this.lVoteCount = j16;
        this.vTags = arrayList;
        this.eUserIdentityType = i17;
        this.vBackground = bArr;
        this.iFaceNum = i18;
        this.lFavoriteCount = j17;
        this.iQQLevel = i19;
    }
}
