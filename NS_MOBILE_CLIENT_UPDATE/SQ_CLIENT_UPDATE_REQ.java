package NS_MOBILE_CLIENT_UPDATE;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class SQ_CLIENT_UPDATE_REQ extends JceStruct {
    static int cache_triggerType;
    static ArrayList<UPDATE_INFO> cache_vModule;
    static ArrayList<UPDATE_INFO> cache_vPlugin = new ArrayList<>();
    public int apiLevel;
    public String qua;
    public int triggerType;
    public ArrayList<UPDATE_INFO> vModule;
    public ArrayList<UPDATE_INFO> vPlugin;
    public String version;

    static {
        cache_vPlugin.add(new UPDATE_INFO());
        cache_vModule = new ArrayList<>();
        cache_vModule.add(new UPDATE_INFO());
    }

    public SQ_CLIENT_UPDATE_REQ() {
        this.qua = "";
        this.version = "";
        this.apiLevel = 0;
        this.triggerType = 0;
        this.vPlugin = null;
        this.vModule = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.qua = jceInputStream.readString(0, false);
        this.version = jceInputStream.readString(1, false);
        this.apiLevel = jceInputStream.read(this.apiLevel, 2, false);
        this.triggerType = jceInputStream.read(this.triggerType, 3, false);
        this.vPlugin = (ArrayList) jceInputStream.read((JceInputStream) cache_vPlugin, 4, false);
        this.vModule = (ArrayList) jceInputStream.read((JceInputStream) cache_vModule, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.qua;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.version;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.apiLevel, 2);
        jceOutputStream.write(this.triggerType, 3);
        ArrayList<UPDATE_INFO> arrayList = this.vPlugin;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        ArrayList<UPDATE_INFO> arrayList2 = this.vModule;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 5);
        }
    }

    public SQ_CLIENT_UPDATE_REQ(String str, String str2, int i3, int i16, ArrayList<UPDATE_INFO> arrayList, ArrayList<UPDATE_INFO> arrayList2) {
        this.qua = str;
        this.version = str2;
        this.apiLevel = i3;
        this.triggerType = i16;
        this.vPlugin = arrayList;
        this.vModule = arrayList2;
    }
}
