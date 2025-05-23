package KQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class PluginInfo extends JceStruct {
    public long Count;
    public boolean Flag;
    public long Id;
    public String PicUrl;
    public boolean RedPoint;
    public boolean Tab;
    public String Text;

    public PluginInfo() {
        this.Id = 0L;
        this.Count = 0L;
        this.Flag = false;
        this.Text = "";
        this.PicUrl = "";
        this.RedPoint = false;
        this.Tab = true;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.Id = jceInputStream.read(this.Id, 0, true);
        this.Count = jceInputStream.read(this.Count, 1, true);
        this.Flag = jceInputStream.read(this.Flag, 2, true);
        this.Text = jceInputStream.readString(3, false);
        this.PicUrl = jceInputStream.readString(4, false);
        this.RedPoint = jceInputStream.read(this.RedPoint, 5, false);
        this.Tab = jceInputStream.read(this.Tab, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "id=" + this.Id + ",count=" + this.Count + ",flag=" + this.Flag + ",text=" + this.Text + ",picurl=" + this.PicUrl + ",redpoint=" + this.RedPoint + ",tab=" + this.Tab;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.Id, 0);
        jceOutputStream.write(this.Count, 1);
        jceOutputStream.write(this.Flag, 2);
        String str = this.Text;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.PicUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        jceOutputStream.write(this.RedPoint, 5);
        jceOutputStream.write(this.Tab, 6);
    }

    public PluginInfo(long j3, long j16, boolean z16, String str, String str2, boolean z17, boolean z18) {
        this.Id = j3;
        this.Count = j16;
        this.Flag = z16;
        this.Text = str;
        this.PicUrl = str2;
        this.RedPoint = z17;
        this.Tab = z18;
    }
}
