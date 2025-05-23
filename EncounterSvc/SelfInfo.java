package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SelfInfo extends JceStruct {
    public int NearRanking;
    public byte cAge;
    public byte cSex;
    public int charm;
    public int charm_level;
    public byte god_flag;
    public int iVoteIncrement;
    public int iVoteNum;
    public String strBirthDay;
    public String strNick;

    public SelfInfo() {
        this.cSex = (byte) 0;
        this.cAge = (byte) 0;
        this.strBirthDay = "";
        this.strNick = "";
        this.iVoteNum = 0;
        this.iVoteIncrement = -1;
        this.charm = 0;
        this.charm_level = 0;
        this.NearRanking = 0;
        this.god_flag = (byte) 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cSex = jceInputStream.read(this.cSex, 0, false);
        this.cAge = jceInputStream.read(this.cAge, 1, false);
        this.strBirthDay = jceInputStream.readString(2, false);
        this.strNick = jceInputStream.readString(3, false);
        this.iVoteNum = jceInputStream.read(this.iVoteNum, 4, false);
        this.iVoteIncrement = jceInputStream.read(this.iVoteIncrement, 5, false);
        this.charm = jceInputStream.read(this.charm, 6, false);
        this.charm_level = jceInputStream.read(this.charm_level, 7, false);
        this.NearRanking = jceInputStream.read(this.NearRanking, 8, false);
        this.god_flag = jceInputStream.read(this.god_flag, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cSex, 0);
        jceOutputStream.write(this.cAge, 1);
        String str = this.strBirthDay;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.strNick;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.iVoteNum, 4);
        jceOutputStream.write(this.iVoteIncrement, 5);
        jceOutputStream.write(this.charm, 6);
        jceOutputStream.write(this.charm_level, 7);
        jceOutputStream.write(this.NearRanking, 8);
        jceOutputStream.write(this.god_flag, 9);
    }

    public SelfInfo(byte b16, byte b17, String str, String str2, int i3, int i16, int i17, int i18, int i19, byte b18) {
        this.cSex = b16;
        this.cAge = b17;
        this.strBirthDay = str;
        this.strNick = str2;
        this.iVoteNum = i3;
        this.iVoteIncrement = i16;
        this.charm = i17;
        this.charm_level = i18;
        this.NearRanking = i19;
        this.god_flag = b18;
    }
}
