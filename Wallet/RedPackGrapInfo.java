package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class RedPackGrapInfo extends JceStruct {
    static ArrayList<Long> cache_vecGrapUin = new ArrayList<>();
    public String hbIdiomLastPY;
    public int iConfType;
    public int iEffectsId;
    public int iEnvelopeId;
    public int iMsgType;
    public int iRedChannel;
    public int iRedType;
    public int iResourceType;
    public int iSkinId;
    public int iSongFlag;
    public int iSongId;
    public int iSoundRecordDuration;
    public int iSpecialPopId;
    public int iSubjectId;
    public long lCreateTime;
    public long lUin;
    public String sAuthKey;
    public String sBiilNo;
    public String sContent;
    public String sIndex;
    public String sName;
    public String sReserve;
    public String sTitle;
    public int seq;
    public ArrayList<Long> vecGrapUin;

    static {
        cache_vecGrapUin.add(0L);
    }

    public RedPackGrapInfo() {
        this.lUin = 0L;
        this.sTitle = "";
        this.iRedType = 0;
        this.sBiilNo = "";
        this.sAuthKey = "";
        this.iMsgType = 0;
        this.iEnvelopeId = 0;
        this.sName = "";
        this.iRedChannel = 0;
        this.vecGrapUin = null;
        this.sContent = "";
        this.iSoundRecordDuration = 0;
        this.iResourceType = 0;
        this.iSkinId = 0;
        this.iEffectsId = 0;
        this.iSpecialPopId = 0;
        this.iConfType = 0;
        this.iSubjectId = 0;
        this.lCreateTime = 0L;
        this.sIndex = "";
        this.iSongId = 0;
        this.iSongFlag = 0;
        this.sReserve = "";
        this.seq = 0;
        this.hbIdiomLastPY = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.lUin = jceInputStream.read(this.lUin, 0, false);
        this.sTitle = jceInputStream.readString(1, false);
        this.iRedType = jceInputStream.read(this.iRedType, 2, false);
        this.sBiilNo = jceInputStream.readString(3, false);
        this.sAuthKey = jceInputStream.readString(4, false);
        this.iMsgType = jceInputStream.read(this.iMsgType, 5, false);
        this.iEnvelopeId = jceInputStream.read(this.iEnvelopeId, 6, false);
        this.sName = jceInputStream.readString(7, false);
        this.iRedChannel = jceInputStream.read(this.iRedChannel, 8, false);
        this.vecGrapUin = (ArrayList) jceInputStream.read((JceInputStream) cache_vecGrapUin, 9, false);
        this.sContent = jceInputStream.readString(10, false);
        this.iSoundRecordDuration = jceInputStream.read(this.iSoundRecordDuration, 11, false);
        this.iResourceType = jceInputStream.read(this.iResourceType, 12, false);
        this.iSkinId = jceInputStream.read(this.iSkinId, 13, false);
        this.iEffectsId = jceInputStream.read(this.iEffectsId, 14, false);
        this.iSpecialPopId = jceInputStream.read(this.iSpecialPopId, 15, false);
        this.iConfType = jceInputStream.read(this.iConfType, 16, false);
        this.iSubjectId = jceInputStream.read(this.iSubjectId, 17, false);
        this.lCreateTime = jceInputStream.read(this.lCreateTime, 18, false);
        this.sIndex = jceInputStream.readString(19, false);
        this.iSongId = jceInputStream.read(this.iSongId, 20, false);
        this.iSongFlag = jceInputStream.read(this.iSongFlag, 21, false);
        this.sReserve = jceInputStream.readString(22, false);
        this.seq = jceInputStream.read(this.seq, 23, false);
        this.hbIdiomLastPY = jceInputStream.readString(24, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.lUin, 0);
        String str = this.sTitle;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.iRedType, 2);
        String str2 = this.sBiilNo;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.sAuthKey;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        jceOutputStream.write(this.iMsgType, 5);
        jceOutputStream.write(this.iEnvelopeId, 6);
        String str4 = this.sName;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
        jceOutputStream.write(this.iRedChannel, 8);
        ArrayList<Long> arrayList = this.vecGrapUin;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 9);
        }
        String str5 = this.sContent;
        if (str5 != null) {
            jceOutputStream.write(str5, 10);
        }
        jceOutputStream.write(this.iSoundRecordDuration, 11);
        jceOutputStream.write(this.iResourceType, 12);
        jceOutputStream.write(this.iSkinId, 13);
        jceOutputStream.write(this.iEffectsId, 14);
        jceOutputStream.write(this.iSpecialPopId, 15);
        jceOutputStream.write(this.iConfType, 16);
        jceOutputStream.write(this.iSubjectId, 17);
        jceOutputStream.write(this.lCreateTime, 18);
        String str6 = this.sIndex;
        if (str6 != null) {
            jceOutputStream.write(str6, 19);
        }
        jceOutputStream.write(this.iSongId, 20);
        jceOutputStream.write(this.iSongFlag, 21);
        String str7 = this.sReserve;
        if (str7 != null) {
            jceOutputStream.write(str7, 22);
        }
        jceOutputStream.write(this.seq, 23);
        String str8 = this.hbIdiomLastPY;
        if (str8 != null) {
            jceOutputStream.write(str8, 24);
        }
    }

    public RedPackGrapInfo(long j3, String str, int i3, String str2, String str3, int i16, int i17, String str4, int i18, ArrayList<Long> arrayList, String str5, int i19, int i26, int i27, int i28, int i29, int i36, int i37, long j16, String str6, int i38, int i39, String str7, int i46, String str8) {
        this.lUin = j3;
        this.sTitle = str;
        this.iRedType = i3;
        this.sBiilNo = str2;
        this.sAuthKey = str3;
        this.iMsgType = i16;
        this.iEnvelopeId = i17;
        this.sName = str4;
        this.iRedChannel = i18;
        this.vecGrapUin = arrayList;
        this.sContent = str5;
        this.iSoundRecordDuration = i19;
        this.iResourceType = i26;
        this.iSkinId = i27;
        this.iEffectsId = i28;
        this.iSpecialPopId = i29;
        this.iConfType = i36;
        this.iSubjectId = i37;
        this.lCreateTime = j16;
        this.sIndex = str6;
        this.iSongId = i38;
        this.iSongFlag = i39;
        this.sReserve = str7;
        this.seq = i46;
        this.hbIdiomLastPY = str8;
    }
}
