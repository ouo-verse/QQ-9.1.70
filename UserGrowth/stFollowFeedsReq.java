package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stFollowFeedsReq extends JceStruct {
    public String attatch_info;
    public boolean is_first;
    public boolean is_refresh;
    public String push_info;
    public int scene;

    public stFollowFeedsReq() {
        this.attatch_info = "";
        this.is_refresh = true;
        this.is_first = true;
        this.push_info = "";
        this.scene = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.attatch_info = jceInputStream.readString(0, false);
        this.is_refresh = jceInputStream.read(this.is_refresh, 1, false);
        this.is_first = jceInputStream.read(this.is_first, 2, false);
        this.push_info = jceInputStream.readString(3, false);
        this.scene = jceInputStream.read(this.scene, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "stFollowFeedsReq{attatch_info='" + this.attatch_info + "', is_refresh=" + this.is_refresh + ", is_first=" + this.is_first + ", push_info='" + this.push_info + "', scene=" + this.scene + '}';
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.attatch_info;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.is_refresh, 1);
        jceOutputStream.write(this.is_first, 2);
        String str2 = this.push_info;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        jceOutputStream.write(this.scene, 4);
    }

    public stFollowFeedsReq(String str, boolean z16, boolean z17, String str2, int i3) {
        this.attatch_info = str;
        this.is_refresh = z16;
        this.is_first = z17;
        this.push_info = str2;
        this.scene = i3;
    }
}
