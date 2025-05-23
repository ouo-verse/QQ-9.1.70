package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_red_bonus extends JceStruct {
    static ArrayList<s_redbonus_man> cache_payMans = new ArrayList<>();
    public String actionUrl;
    public int isPayed;
    public ArrayList<s_redbonus_man> payMans;
    public long payMenNum;
    public long payMoney;
    public long payNum;
    public long payTotalAccount;

    static {
        cache_payMans.add(new s_redbonus_man());
    }

    public cell_red_bonus() {
        this.payNum = 0L;
        this.payTotalAccount = 0L;
        this.isPayed = 0;
        this.payMoney = 0L;
        this.payMans = null;
        this.actionUrl = "";
        this.payMenNum = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.payNum = jceInputStream.read(this.payNum, 0, false);
        this.payTotalAccount = jceInputStream.read(this.payTotalAccount, 1, false);
        this.isPayed = jceInputStream.read(this.isPayed, 2, false);
        this.payMoney = jceInputStream.read(this.payMoney, 3, false);
        this.payMans = (ArrayList) jceInputStream.read((JceInputStream) cache_payMans, 4, false);
        this.actionUrl = jceInputStream.readString(5, false);
        this.payMenNum = jceInputStream.read(this.payMenNum, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.payNum, 0);
        jceOutputStream.write(this.payTotalAccount, 1);
        jceOutputStream.write(this.isPayed, 2);
        jceOutputStream.write(this.payMoney, 3);
        ArrayList<s_redbonus_man> arrayList = this.payMans;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        String str = this.actionUrl;
        if (str != null) {
            jceOutputStream.write(str, 5);
        }
        jceOutputStream.write(this.payMenNum, 6);
    }

    public cell_red_bonus(long j3, long j16, int i3, long j17, ArrayList<s_redbonus_man> arrayList, String str, long j18) {
        this.payNum = j3;
        this.payTotalAccount = j16;
        this.isPayed = i3;
        this.payMoney = j17;
        this.payMans = arrayList;
        this.actionUrl = str;
        this.payMenNum = j18;
    }
}
