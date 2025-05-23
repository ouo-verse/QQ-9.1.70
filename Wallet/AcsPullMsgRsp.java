package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class AcsPullMsgRsp extends JceStruct {
    static ArrayList<AcsMsg> cache_msgs = new ArrayList<>();
    public String all_url;
    public String err_str;
    public ArrayList<AcsMsg> msgs;
    public int ret_code;
    public String sub_url;

    static {
        cache_msgs.add(new AcsMsg());
    }

    public AcsPullMsgRsp() {
        this.ret_code = 0;
        this.err_str = "";
        this.msgs = null;
        this.all_url = "";
        this.sub_url = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret_code = jceInputStream.read(this.ret_code, 0, false);
        this.err_str = jceInputStream.readString(1, false);
        this.msgs = (ArrayList) jceInputStream.read((JceInputStream) cache_msgs, 2, false);
        this.all_url = jceInputStream.readString(3, false);
        this.sub_url = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret_code, 0);
        String str = this.err_str;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<AcsMsg> arrayList = this.msgs;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        String str2 = this.all_url;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.sub_url;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
    }

    public AcsPullMsgRsp(int i3, String str, ArrayList<AcsMsg> arrayList, String str2, String str3) {
        this.ret_code = i3;
        this.err_str = str;
        this.msgs = arrayList;
        this.all_url = str2;
        this.sub_url = str3;
    }
}
