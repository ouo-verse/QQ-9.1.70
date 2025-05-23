package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_userinfo extends JceStruct {
    static ArrayList<String> cache_luckyMoneyPics;
    static s_user cache_user = new s_user();
    public String action_desc;
    public int actiontype;
    public ArrayList<String> luckyMoneyPics;
    public s_user user;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_luckyMoneyPics = arrayList;
        arrayList.add("");
    }

    public cell_userinfo() {
        this.action_desc = "";
        this.actiontype = 5;
        this.luckyMoneyPics = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.user = (s_user) jceInputStream.read((JceStruct) cache_user, 0, false);
        this.action_desc = jceInputStream.readString(1, false);
        this.actiontype = jceInputStream.read(this.actiontype, 2, false);
        this.luckyMoneyPics = (ArrayList) jceInputStream.read((JceInputStream) cache_luckyMoneyPics, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        s_user s_userVar = this.user;
        if (s_userVar != null) {
            jceOutputStream.write((JceStruct) s_userVar, 0);
        }
        String str = this.action_desc;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.actiontype, 2);
        ArrayList<String> arrayList = this.luckyMoneyPics;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
    }

    public cell_userinfo(s_user s_userVar, String str, int i3) {
        this.user = s_userVar;
        this.action_desc = str;
        this.actiontype = i3;
        this.luckyMoneyPics = null;
    }
}
