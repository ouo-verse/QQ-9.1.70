package IMMsgBodyPack;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MsgType0x210SubMsgType0x24 extends JceStruct {
    static ArrayList<PluginNum> cache_vPluginNumList;
    public ArrayList<PluginNum> vPluginNumList;

    public MsgType0x210SubMsgType0x24() {
        this.vPluginNumList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_vPluginNumList == null) {
            cache_vPluginNumList = new ArrayList<>();
            cache_vPluginNumList.add(new PluginNum());
        }
        this.vPluginNumList = (ArrayList) jceInputStream.read((JceInputStream) cache_vPluginNumList, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<PluginNum> arrayList = this.vPluginNumList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
    }

    public MsgType0x210SubMsgType0x24(ArrayList<PluginNum> arrayList) {
        this.vPluginNumList = arrayList;
    }
}
