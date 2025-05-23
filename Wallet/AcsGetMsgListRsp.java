package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AcsGetMsgListRsp extends JceStruct {
    static ArrayList<AcsMsg> cache_data_list = new ArrayList<>();
    public ArrayList<AcsMsg> data_list;
    public String err_str;
    public int ret_code;
    public int total;

    static {
        cache_data_list.add(new AcsMsg());
    }

    public AcsGetMsgListRsp() {
        this.ret_code = 0;
        this.err_str = "";
        this.data_list = null;
        this.total = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret_code = jceInputStream.read(this.ret_code, 0, false);
        this.err_str = jceInputStream.readString(1, false);
        this.data_list = (ArrayList) jceInputStream.read((JceInputStream) cache_data_list, 2, false);
        this.total = jceInputStream.read(this.total, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret_code, 0);
        String str = this.err_str;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<AcsMsg> arrayList = this.data_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.total, 3);
    }

    public AcsGetMsgListRsp(int i3, String str, ArrayList<AcsMsg> arrayList, int i16) {
        this.ret_code = i3;
        this.err_str = str;
        this.data_list = arrayList;
        this.total = i16;
    }
}
