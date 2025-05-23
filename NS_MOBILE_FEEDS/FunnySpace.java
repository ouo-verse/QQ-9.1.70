package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FunnySpace extends JceStruct {
    static ArrayList<FunnySpaceAction> cache_Actions = new ArrayList<>();
    public ArrayList<FunnySpaceAction> Actions;
    public long TotalCount;
    public String host_message;
    public boolean is_block;
    public boolean is_show;
    public boolean is_show_cmshowar;
    public long uFirePowerCount;
    public long uFirePowerLevel;

    static {
        cache_Actions.add(new FunnySpaceAction());
    }

    public FunnySpace() {
        this.Actions = null;
        this.is_block = false;
        this.is_show = false;
        this.TotalCount = 0L;
        this.is_show_cmshowar = true;
        this.uFirePowerCount = 0L;
        this.host_message = "";
        this.uFirePowerLevel = 0L;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Actions = (ArrayList) jceInputStream.read((JceInputStream) cache_Actions, 0, false);
        this.is_block = jceInputStream.read(this.is_block, 1, false);
        this.is_show = jceInputStream.read(this.is_show, 2, false);
        this.TotalCount = jceInputStream.read(this.TotalCount, 3, false);
        this.is_show_cmshowar = jceInputStream.read(this.is_show_cmshowar, 4, false);
        this.uFirePowerCount = jceInputStream.read(this.uFirePowerCount, 5, false);
        this.host_message = jceInputStream.readString(6, false);
        this.uFirePowerLevel = jceInputStream.read(this.uFirePowerLevel, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<FunnySpaceAction> arrayList = this.Actions;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        jceOutputStream.write(this.is_block, 1);
        jceOutputStream.write(this.is_show, 2);
        jceOutputStream.write(this.TotalCount, 3);
        jceOutputStream.write(this.is_show_cmshowar, 4);
        jceOutputStream.write(this.uFirePowerCount, 5);
        String str = this.host_message;
        if (str != null) {
            jceOutputStream.write(str, 6);
        }
        jceOutputStream.write(this.uFirePowerLevel, 7);
    }

    public FunnySpace(ArrayList<FunnySpaceAction> arrayList, boolean z16, boolean z17, long j3, boolean z18, long j16, String str, long j17) {
        this.Actions = arrayList;
        this.is_block = z16;
        this.is_show = z17;
        this.TotalCount = j3;
        this.is_show_cmshowar = z18;
        this.uFirePowerCount = j16;
        this.host_message = str;
        this.uFirePowerLevel = j17;
    }
}
