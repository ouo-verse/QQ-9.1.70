package SummaryCard;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PanSocialInfo extends JceStruct {
    public String strLevelType;
    public long uCharm;
    public long uCharmLevel;
    public long uCharmRank;
    public long uChatflag;
    public long uChatupCount;
    public long uCurLevelCharm;
    public long uNextLevelCharm;

    public PanSocialInfo() {
        this.uCharmRank = 0L;
        this.uChatflag = 0L;
        this.uChatupCount = 0L;
        this.uCharm = 0L;
        this.uCharmLevel = 0L;
        this.uNextLevelCharm = 0L;
        this.uCurLevelCharm = 0L;
        this.strLevelType = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uCharmRank = jceInputStream.read(this.uCharmRank, 0, false);
        this.uChatflag = jceInputStream.read(this.uChatflag, 1, false);
        this.uChatupCount = jceInputStream.read(this.uChatupCount, 2, false);
        this.uCharm = jceInputStream.read(this.uCharm, 3, false);
        this.uCharmLevel = jceInputStream.read(this.uCharmLevel, 4, false);
        this.uNextLevelCharm = jceInputStream.read(this.uNextLevelCharm, 5, false);
        this.uCurLevelCharm = jceInputStream.read(this.uCurLevelCharm, 6, false);
        this.strLevelType = jceInputStream.readString(7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uCharmRank, 0);
        jceOutputStream.write(this.uChatflag, 1);
        jceOutputStream.write(this.uChatupCount, 2);
        jceOutputStream.write(this.uCharm, 3);
        jceOutputStream.write(this.uCharmLevel, 4);
        jceOutputStream.write(this.uNextLevelCharm, 5);
        jceOutputStream.write(this.uCurLevelCharm, 6);
        String str = this.strLevelType;
        if (str != null) {
            jceOutputStream.write(str, 7);
        }
    }

    public PanSocialInfo(long j3, long j16, long j17, long j18, long j19, long j26, long j27, String str) {
        this.uCharmRank = j3;
        this.uChatflag = j16;
        this.uChatupCount = j17;
        this.uCharm = j18;
        this.uCharmLevel = j19;
        this.uNextLevelCharm = j26;
        this.uCurLevelCharm = j27;
        this.strLevelType = str;
    }
}
