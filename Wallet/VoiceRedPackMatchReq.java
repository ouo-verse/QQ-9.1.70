package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class VoiceRedPackMatchReq extends JceStruct {
    public long appid;
    public String billno;
    public C2CVoiceInfo c2cVoiceInfo;
    public int fromType;
    public long grabUin;
    public GroupVoiceInfo groupVoiceInfo;
    public long makeUin;
    public int platform;
    public String qqVersion;
    public String sKey;
    public VoiceMatchStatus voiceMatchStatus;
    public String voiceText;
    static GroupVoiceInfo cache_groupVoiceInfo = new GroupVoiceInfo();
    static C2CVoiceInfo cache_c2cVoiceInfo = new C2CVoiceInfo();
    static VoiceMatchStatus cache_voiceMatchStatus = new VoiceMatchStatus();

    public VoiceRedPackMatchReq() {
        this.grabUin = 0L;
        this.billno = "";
        this.voiceText = "";
        this.makeUin = 0L;
        this.sKey = "";
        this.appid = 0L;
        this.fromType = 0;
        this.groupVoiceInfo = null;
        this.platform = 0;
        this.c2cVoiceInfo = null;
        this.qqVersion = "";
        this.voiceMatchStatus = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.grabUin = jceInputStream.read(this.grabUin, 0, false);
        this.billno = jceInputStream.readString(1, false);
        this.voiceText = jceInputStream.readString(2, false);
        this.makeUin = jceInputStream.read(this.makeUin, 3, false);
        this.sKey = jceInputStream.readString(4, false);
        this.appid = jceInputStream.read(this.appid, 5, false);
        this.fromType = jceInputStream.read(this.fromType, 6, false);
        this.groupVoiceInfo = (GroupVoiceInfo) jceInputStream.read((JceStruct) cache_groupVoiceInfo, 7, false);
        this.platform = jceInputStream.read(this.platform, 8, false);
        this.c2cVoiceInfo = (C2CVoiceInfo) jceInputStream.read((JceStruct) cache_c2cVoiceInfo, 9, false);
        this.qqVersion = jceInputStream.readString(10, false);
        this.voiceMatchStatus = (VoiceMatchStatus) jceInputStream.read((JceStruct) cache_voiceMatchStatus, 11, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.grabUin, 0);
        String str = this.billno;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.voiceText;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.makeUin, 3);
        String str3 = this.sKey;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        jceOutputStream.write(this.appid, 5);
        jceOutputStream.write(this.fromType, 6);
        GroupVoiceInfo groupVoiceInfo = this.groupVoiceInfo;
        if (groupVoiceInfo != null) {
            jceOutputStream.write((JceStruct) groupVoiceInfo, 7);
        }
        jceOutputStream.write(this.platform, 8);
        C2CVoiceInfo c2CVoiceInfo = this.c2cVoiceInfo;
        if (c2CVoiceInfo != null) {
            jceOutputStream.write((JceStruct) c2CVoiceInfo, 9);
        }
        String str4 = this.qqVersion;
        if (str4 != null) {
            jceOutputStream.write(str4, 10);
        }
        VoiceMatchStatus voiceMatchStatus = this.voiceMatchStatus;
        if (voiceMatchStatus != null) {
            jceOutputStream.write((JceStruct) voiceMatchStatus, 11);
        }
    }

    public VoiceRedPackMatchReq(long j3, String str, String str2, long j16, String str3, long j17, int i3, GroupVoiceInfo groupVoiceInfo, int i16, C2CVoiceInfo c2CVoiceInfo, String str4, VoiceMatchStatus voiceMatchStatus) {
        this.grabUin = j3;
        this.billno = str;
        this.voiceText = str2;
        this.makeUin = j16;
        this.sKey = str3;
        this.appid = j17;
        this.fromType = i3;
        this.groupVoiceInfo = groupVoiceInfo;
        this.platform = i16;
        this.c2cVoiceInfo = c2CVoiceInfo;
        this.qqVersion = str4;
        this.voiceMatchStatus = voiceMatchStatus;
    }
}
