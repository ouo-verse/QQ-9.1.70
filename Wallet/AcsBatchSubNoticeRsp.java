package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AcsBatchSubNoticeRsp extends JceStruct {
    static ArrayList<AcsMsg> cache_msgs = new ArrayList<>();
    static ArrayList<String> cache_retry_msgs;
    public String err_str;
    public ArrayList<AcsMsg> msgs;
    public int ret_code;
    public ArrayList<String> retry_msgs;
    public int succeed_count;

    static {
        cache_msgs.add(new AcsMsg());
        ArrayList<String> arrayList = new ArrayList<>();
        cache_retry_msgs = arrayList;
        arrayList.add("");
    }

    public AcsBatchSubNoticeRsp() {
        this.ret_code = 0;
        this.err_str = "";
        this.succeed_count = 0;
        this.msgs = null;
        this.retry_msgs = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.ret_code = jceInputStream.read(this.ret_code, 0, false);
        this.err_str = jceInputStream.readString(1, false);
        this.succeed_count = jceInputStream.read(this.succeed_count, 2, false);
        this.msgs = (ArrayList) jceInputStream.read((JceInputStream) cache_msgs, 3, false);
        this.retry_msgs = (ArrayList) jceInputStream.read((JceInputStream) cache_retry_msgs, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.ret_code, 0);
        String str = this.err_str;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.succeed_count, 2);
        ArrayList<AcsMsg> arrayList = this.msgs;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        ArrayList<String> arrayList2 = this.retry_msgs;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 4);
        }
    }

    public AcsBatchSubNoticeRsp(int i3, String str, int i16, ArrayList<AcsMsg> arrayList, ArrayList<String> arrayList2) {
        this.ret_code = i3;
        this.err_str = str;
        this.succeed_count = i16;
        this.msgs = arrayList;
        this.retry_msgs = arrayList2;
    }
}
