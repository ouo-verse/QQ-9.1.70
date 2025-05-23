package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class s_yytag extends JceStruct {
    static ArrayList<Integer> cache_beginEndSeconds = new ArrayList<>();
    public int actiontype;
    public String actionurl;
    public ArrayList<Integer> beginEndSeconds;
    public String content;
    public int displaytype;
    public String logo;
    public int scene;

    static {
        cache_beginEndSeconds.add(0);
    }

    public s_yytag() {
        this.logo = "";
        this.content = "";
        this.actiontype = 0;
        this.actionurl = "";
        this.scene = 0;
        this.displaytype = 0;
        this.beginEndSeconds = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.logo = jceInputStream.readString(0, false);
        this.content = jceInputStream.readString(1, false);
        this.actiontype = jceInputStream.read(this.actiontype, 2, false);
        this.actionurl = jceInputStream.readString(3, false);
        this.scene = jceInputStream.read(this.scene, 4, false);
        this.displaytype = jceInputStream.read(this.displaytype, 5, false);
        this.beginEndSeconds = (ArrayList) jceInputStream.read((JceInputStream) cache_beginEndSeconds, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.logo;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.content;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        jceOutputStream.write(this.actiontype, 2);
        String str3 = this.actionurl;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.scene, 4);
        jceOutputStream.write(this.displaytype, 5);
        ArrayList<Integer> arrayList = this.beginEndSeconds;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 6);
        }
    }

    public s_yytag(String str, String str2, int i3, String str3, int i16, int i17, ArrayList<Integer> arrayList) {
        this.logo = str;
        this.content = str2;
        this.actiontype = i3;
        this.actionurl = str3;
        this.scene = i16;
        this.displaytype = i17;
        this.beginEndSeconds = arrayList;
    }
}
