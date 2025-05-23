package NS_KING_INTERFACE;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stAction extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static stScheme cache_scheme = new stScheme();
    static int cache_type;
    public String argb;
    public String icon;
    public stScheme scheme;
    public String text;
    public int type;

    public stAction() {
        this.type = 0;
        this.scheme = null;
        this.icon = "";
        this.argb = "";
        this.text = "";
    }

    public String className() {
        return "NS_KING_INTERFACE.stAction";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display(this.type, "type");
        jceDisplayer.display((JceStruct) this.scheme, ZPlanPublishSource.FROM_SCHEME);
        jceDisplayer.display(this.icon, "icon");
        jceDisplayer.display(this.argb, "argb");
        jceDisplayer.display(this.text, "text");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.type, true);
        jceDisplayer.displaySimple((JceStruct) this.scheme, true);
        jceDisplayer.displaySimple(this.icon, true);
        jceDisplayer.displaySimple(this.argb, true);
        jceDisplayer.displaySimple(this.text, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        stAction staction = (stAction) obj;
        if (!JceUtil.equals(this.type, staction.type) || !JceUtil.equals(this.scheme, staction.scheme) || !JceUtil.equals(this.icon, staction.icon) || !JceUtil.equals(this.argb, staction.argb) || !JceUtil.equals(this.text, staction.text)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "NS_KING_INTERFACE.stAction";
    }

    public String getArgb() {
        return this.argb;
    }

    public String getIcon() {
        return this.icon;
    }

    public stScheme getScheme() {
        return this.scheme;
    }

    public String getText() {
        return this.text;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.type = jceInputStream.read(this.type, 0, false);
        this.scheme = (stScheme) jceInputStream.read((JceStruct) cache_scheme, 1, false);
        this.icon = jceInputStream.readString(2, false);
        this.argb = jceInputStream.readString(3, false);
        this.text = jceInputStream.readString(4, false);
    }

    public void setArgb(String str) {
        this.argb = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setScheme(stScheme stscheme) {
        this.scheme = stscheme;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setType(int i3) {
        this.type = i3;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.type, 0);
        stScheme stscheme = this.scheme;
        if (stscheme != null) {
            jceOutputStream.write((JceStruct) stscheme, 1);
        }
        String str = this.icon;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.argb;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.text;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
    }

    public stAction(int i3, stScheme stscheme, String str, String str2, String str3) {
        this.type = i3;
        this.scheme = stscheme;
        this.icon = str;
        this.argb = str2;
        this.text = str3;
    }
}
