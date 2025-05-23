package NS_KING_INTERFACE;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stScheme extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public String appID;
    public String schemeURL;
    public String storeURL;
    public String webURL;

    public stScheme() {
        this.appID = "";
        this.schemeURL = "";
        this.storeURL = "";
        this.webURL = "";
    }

    public String className() {
        return "NS_KING_INTERFACE.stScheme";
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
        jceDisplayer.display(this.appID, "appID");
        jceDisplayer.display(this.schemeURL, "schemeURL");
        jceDisplayer.display(this.storeURL, "storeURL");
        jceDisplayer.display(this.webURL, "webURL");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.appID, true);
        jceDisplayer.displaySimple(this.schemeURL, true);
        jceDisplayer.displaySimple(this.storeURL, true);
        jceDisplayer.displaySimple(this.webURL, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        stScheme stscheme = (stScheme) obj;
        if (!JceUtil.equals(this.appID, stscheme.appID) || !JceUtil.equals(this.schemeURL, stscheme.schemeURL) || !JceUtil.equals(this.storeURL, stscheme.storeURL) || !JceUtil.equals(this.webURL, stscheme.webURL)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "NS_KING_INTERFACE.stScheme";
    }

    public String getAppID() {
        return this.appID;
    }

    public String getSchemeURL() {
        return this.schemeURL;
    }

    public String getStoreURL() {
        return this.storeURL;
    }

    public String getWebURL() {
        return this.webURL;
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
        this.appID = jceInputStream.readString(0, false);
        this.schemeURL = jceInputStream.readString(1, false);
        this.storeURL = jceInputStream.readString(2, false);
        this.webURL = jceInputStream.readString(3, false);
    }

    public void setAppID(String str) {
        this.appID = str;
    }

    public void setSchemeURL(String str) {
        this.schemeURL = str;
    }

    public void setStoreURL(String str) {
        this.storeURL = str;
    }

    public void setWebURL(String str) {
        this.webURL = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.appID;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.schemeURL;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.storeURL;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.webURL;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
    }

    public stScheme(String str, String str2, String str3, String str4) {
        this.appID = str;
        this.schemeURL = str2;
        this.storeURL = str3;
        this.webURL = str4;
    }
}
