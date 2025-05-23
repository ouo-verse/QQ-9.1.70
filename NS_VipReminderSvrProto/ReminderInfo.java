package NS_VipReminderSvrProto;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ReminderInfo extends JceStruct {
    static ArrayList<QbossAdv> cache_vecQbossAdv;
    public int iQbAccount;
    public int iRecoverScore;
    public int iRemindType;
    public String sSVipOverDay;
    public String sVipOverDay;
    public String sYVipOverDay;
    public long uiExpire;
    public long uiSExpire;
    public long uiYExpire;
    public ArrayList<QbossAdv> vecQbossAdv;

    public ReminderInfo() {
        this.sVipOverDay = "";
        this.sYVipOverDay = "";
        this.sSVipOverDay = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iRemindType = jceInputStream.read(this.iRemindType, 0, true);
        this.iQbAccount = jceInputStream.read(this.iQbAccount, 1, true);
        this.iRecoverScore = jceInputStream.read(this.iRecoverScore, 2, false);
        if (cache_vecQbossAdv == null) {
            cache_vecQbossAdv = new ArrayList<>();
            cache_vecQbossAdv.add(new QbossAdv());
        }
        this.vecQbossAdv = (ArrayList) jceInputStream.read((JceInputStream) cache_vecQbossAdv, 3, true);
        this.sVipOverDay = jceInputStream.readString(4, true);
        this.sYVipOverDay = jceInputStream.readString(5, true);
        this.sSVipOverDay = jceInputStream.readString(6, true);
        this.uiExpire = jceInputStream.read(this.uiExpire, 7, true);
        this.uiYExpire = jceInputStream.read(this.uiYExpire, 8, true);
        this.uiSExpire = jceInputStream.read(this.uiSExpire, 9, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iRemindType, 0);
        jceOutputStream.write(this.iQbAccount, 1);
        jceOutputStream.write(this.iRecoverScore, 2);
        jceOutputStream.write((Collection) this.vecQbossAdv, 3);
        jceOutputStream.write(this.sVipOverDay, 4);
        jceOutputStream.write(this.sYVipOverDay, 5);
        jceOutputStream.write(this.sSVipOverDay, 6);
        jceOutputStream.write(this.uiExpire, 7);
        jceOutputStream.write(this.uiYExpire, 8);
        jceOutputStream.write(this.uiSExpire, 9);
    }

    public ReminderInfo(int i3, int i16, int i17, ArrayList<QbossAdv> arrayList, String str, String str2, String str3, long j3, long j16, long j17) {
        this.iRemindType = i3;
        this.iQbAccount = i16;
        this.iRecoverScore = i17;
        this.vecQbossAdv = arrayList;
        this.sVipOverDay = str;
        this.sYVipOverDay = str2;
        this.sSVipOverDay = str3;
        this.uiExpire = j3;
        this.uiYExpire = j16;
        this.uiSExpire = j17;
    }
}
