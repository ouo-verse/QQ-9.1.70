package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class Type_1_QQDataTextMsg extends JceStruct {
    static ArrayList<MsgType0x210SubMsgType0x13_MsgItem> cache_msg_item;
    public ArrayList<MsgType0x210SubMsgType0x13_MsgItem> msg_item;

    public Type_1_QQDataTextMsg() {
        this.msg_item = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_msg_item == null) {
            cache_msg_item = new ArrayList<>();
            cache_msg_item.add(new MsgType0x210SubMsgType0x13_MsgItem());
        }
        this.msg_item = (ArrayList) jceInputStream.read((JceInputStream) cache_msg_item, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<MsgType0x210SubMsgType0x13_MsgItem> arrayList = this.msg_item;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public Type_1_QQDataTextMsg(ArrayList<MsgType0x210SubMsgType0x13_MsgItem> arrayList) {
        this.msg_item = arrayList;
    }
}
