package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class AcsBatchSubNoticeReq extends JceStruct {
    static AcsHead cache_head = new AcsHead();
    static ArrayList<String> cache_msg_id_list;
    public String domain;
    public AcsHead head;
    public ArrayList<String> msg_id_list;
    public long uin;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_msg_id_list = arrayList;
        arrayList.add("");
    }

    public AcsBatchSubNoticeReq() {
        this.head = null;
        this.uin = 0L;
        this.msg_id_list = null;
        this.domain = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.head = (AcsHead) jceInputStream.read((JceStruct) cache_head, 0, false);
        this.uin = jceInputStream.read(this.uin, 1, false);
        this.msg_id_list = (ArrayList) jceInputStream.read((JceInputStream) cache_msg_id_list, 2, false);
        this.domain = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        AcsHead acsHead = this.head;
        if (acsHead != null) {
            jceOutputStream.write((JceStruct) acsHead, 0);
        }
        jceOutputStream.write(this.uin, 1);
        ArrayList<String> arrayList = this.msg_id_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        String str = this.domain;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
    }

    public AcsBatchSubNoticeReq(AcsHead acsHead, long j3, ArrayList<String> arrayList, String str) {
        this.head = acsHead;
        this.uin = j3;
        this.msg_id_list = arrayList;
        this.domain = str;
    }
}
