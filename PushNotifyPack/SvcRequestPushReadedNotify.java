package PushNotifyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class SvcRequestPushReadedNotify extends JceStruct {
    static ArrayList<C2CMsgReadedNotify> cache_vC2CReadedNotify;
    static ArrayList<DisMsgReadedNotify> cache_vDisReadedNotify;
    static ArrayList<GroupMsgReadedNotify> cache_vGroupReadedNotify;
    public byte cNotifyType;
    public ArrayList<C2CMsgReadedNotify> vC2CReadedNotify;
    public ArrayList<DisMsgReadedNotify> vDisReadedNotify;
    public ArrayList<GroupMsgReadedNotify> vGroupReadedNotify;

    public SvcRequestPushReadedNotify() {
        this.cNotifyType = (byte) 0;
        this.vC2CReadedNotify = null;
        this.vGroupReadedNotify = null;
        this.vDisReadedNotify = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.cNotifyType = jceInputStream.read(this.cNotifyType, 0, true);
        if (cache_vC2CReadedNotify == null) {
            cache_vC2CReadedNotify = new ArrayList<>();
            cache_vC2CReadedNotify.add(new C2CMsgReadedNotify());
        }
        this.vC2CReadedNotify = (ArrayList) jceInputStream.read((JceInputStream) cache_vC2CReadedNotify, 1, false);
        if (cache_vGroupReadedNotify == null) {
            cache_vGroupReadedNotify = new ArrayList<>();
            cache_vGroupReadedNotify.add(new GroupMsgReadedNotify());
        }
        this.vGroupReadedNotify = (ArrayList) jceInputStream.read((JceInputStream) cache_vGroupReadedNotify, 2, false);
        if (cache_vDisReadedNotify == null) {
            cache_vDisReadedNotify = new ArrayList<>();
            cache_vDisReadedNotify.add(new DisMsgReadedNotify());
        }
        this.vDisReadedNotify = (ArrayList) jceInputStream.read((JceInputStream) cache_vDisReadedNotify, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.cNotifyType, 0);
        ArrayList<C2CMsgReadedNotify> arrayList = this.vC2CReadedNotify;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        ArrayList<GroupMsgReadedNotify> arrayList2 = this.vGroupReadedNotify;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 2);
        }
        ArrayList<DisMsgReadedNotify> arrayList3 = this.vDisReadedNotify;
        if (arrayList3 != null) {
            jceOutputStream.write((Collection) arrayList3, 3);
        }
    }

    public SvcRequestPushReadedNotify(byte b16, ArrayList<C2CMsgReadedNotify> arrayList, ArrayList<GroupMsgReadedNotify> arrayList2, ArrayList<DisMsgReadedNotify> arrayList3) {
        this.cNotifyType = b16;
        this.vC2CReadedNotify = arrayList;
        this.vGroupReadedNotify = arrayList2;
        this.vDisReadedNotify = arrayList3;
    }
}
