package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class SongRedPackMatchReq extends JceStruct {
    public long appid;
    public String billno;
    public C2CVoiceInfo c2cRecordMixVoiceInfo;
    public C2CVoiceInfo c2cRecordVoiceInfo;
    public int earphoneStatus;
    public int fromType;
    public GroupVoiceInfo gVoiceMixRecordInfo;
    public GroupVoiceInfo gVoiceRecordInfo;
    public long grabUin;
    public long makeUin;
    public int platform;
    public String qqVersion;
    public String sKey;
    public int songId;
    public int songType;
    static GroupVoiceInfo cache_gVoiceRecordInfo = new GroupVoiceInfo();
    static GroupVoiceInfo cache_gVoiceMixRecordInfo = new GroupVoiceInfo();
    static C2CVoiceInfo cache_c2cRecordVoiceInfo = new C2CVoiceInfo();
    static C2CVoiceInfo cache_c2cRecordMixVoiceInfo = new C2CVoiceInfo();

    public SongRedPackMatchReq(long j3, String str, int i3, int i16, int i17, long j16, String str2, long j17, int i18, int i19, String str3, GroupVoiceInfo groupVoiceInfo, GroupVoiceInfo groupVoiceInfo2, C2CVoiceInfo c2CVoiceInfo, C2CVoiceInfo c2CVoiceInfo2) {
        this.grabUin = j3;
        this.billno = str;
        this.songId = i3;
        this.songType = i16;
        this.earphoneStatus = i17;
        this.makeUin = j16;
        this.sKey = str2;
        this.appid = j17;
        this.fromType = i18;
        this.platform = i19;
        this.qqVersion = str3;
        this.gVoiceRecordInfo = groupVoiceInfo;
        this.gVoiceMixRecordInfo = groupVoiceInfo2;
        this.c2cRecordVoiceInfo = c2CVoiceInfo;
        this.c2cRecordMixVoiceInfo = c2CVoiceInfo2;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.grabUin = jceInputStream.read(this.grabUin, 0, false);
        this.billno = jceInputStream.readString(1, false);
        this.songId = jceInputStream.read(this.songId, 2, false);
        this.songType = jceInputStream.read(this.songType, 3, false);
        this.earphoneStatus = jceInputStream.read(this.earphoneStatus, 4, false);
        this.makeUin = jceInputStream.read(this.makeUin, 5, false);
        this.sKey = jceInputStream.readString(6, false);
        this.appid = jceInputStream.read(this.appid, 7, false);
        this.fromType = jceInputStream.read(this.fromType, 8, false);
        this.platform = jceInputStream.read(this.platform, 9, false);
        this.qqVersion = jceInputStream.readString(10, false);
        this.gVoiceRecordInfo = (GroupVoiceInfo) jceInputStream.read((JceStruct) cache_gVoiceRecordInfo, 11, false);
        this.gVoiceMixRecordInfo = (GroupVoiceInfo) jceInputStream.read((JceStruct) cache_gVoiceMixRecordInfo, 12, false);
        this.c2cRecordVoiceInfo = (C2CVoiceInfo) jceInputStream.read((JceStruct) cache_c2cRecordVoiceInfo, 13, false);
        this.c2cRecordMixVoiceInfo = (C2CVoiceInfo) jceInputStream.read((JceStruct) cache_c2cRecordMixVoiceInfo, 14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "SongRedPackMatchReq{grabUin=" + this.grabUin + ", billno='" + this.billno + "', songId=" + this.songId + ", songType=" + this.songType + ", earphoneStatus=" + this.earphoneStatus + ", makeUin=" + this.makeUin + ", sKey='" + this.sKey + "'}";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.grabUin, 0);
        String str = this.billno;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.songId, 2);
        jceOutputStream.write(this.songType, 3);
        jceOutputStream.write(this.earphoneStatus, 4);
        jceOutputStream.write(this.makeUin, 5);
        String str2 = this.sKey;
        if (str2 != null) {
            jceOutputStream.write(str2, 6);
        }
        jceOutputStream.write(this.appid, 7);
        jceOutputStream.write(this.fromType, 8);
        jceOutputStream.write(this.platform, 9);
        String str3 = this.qqVersion;
        if (str3 != null) {
            jceOutputStream.write(str3, 10);
        }
        GroupVoiceInfo groupVoiceInfo = this.gVoiceRecordInfo;
        if (groupVoiceInfo != null) {
            jceOutputStream.write((JceStruct) groupVoiceInfo, 11);
        }
        GroupVoiceInfo groupVoiceInfo2 = this.gVoiceMixRecordInfo;
        if (groupVoiceInfo2 != null) {
            jceOutputStream.write((JceStruct) groupVoiceInfo2, 12);
        }
        C2CVoiceInfo c2CVoiceInfo = this.c2cRecordVoiceInfo;
        if (c2CVoiceInfo != null) {
            jceOutputStream.write((JceStruct) c2CVoiceInfo, 13);
        }
        C2CVoiceInfo c2CVoiceInfo2 = this.c2cRecordMixVoiceInfo;
        if (c2CVoiceInfo2 != null) {
            jceOutputStream.write((JceStruct) c2CVoiceInfo2, 14);
        }
    }
}
