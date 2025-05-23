package AccostSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RichMsg extends JceStruct {
    static ArrayList<MsgItem> cache_VecMsg;
    static UserInfo cache_stSender;
    public ArrayList<MsgItem> VecMsg;
    public int iActionID;
    public String sAction;
    public UserInfo stSender;

    public RichMsg() {
        this.VecMsg = null;
        this.sAction = "";
        this.stSender = null;
        this.iActionID = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_VecMsg == null) {
            cache_VecMsg = new ArrayList<>();
            cache_VecMsg.add(new MsgItem());
        }
        this.VecMsg = (ArrayList) jceInputStream.read((JceInputStream) cache_VecMsg, 0, true);
        this.sAction = jceInputStream.readString(1, false);
        if (cache_stSender == null) {
            cache_stSender = new UserInfo();
        }
        this.stSender = (UserInfo) jceInputStream.read((JceStruct) cache_stSender, 2, false);
        this.iActionID = jceInputStream.read(this.iActionID, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.VecMsg, 0);
        String str = this.sAction;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        UserInfo userInfo = this.stSender;
        if (userInfo != null) {
            jceOutputStream.write((JceStruct) userInfo, 2);
        }
        jceOutputStream.write(this.iActionID, 3);
    }

    public RichMsg(ArrayList<MsgItem> arrayList, String str, UserInfo userInfo, int i3) {
        this.VecMsg = arrayList;
        this.sAction = str;
        this.stSender = userInfo;
        this.iActionID = i3;
    }
}
