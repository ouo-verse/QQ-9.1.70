package SummaryCard;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class WeishiFeed extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public String strCoverUrl;
    public String strDynamicCover;
    public String strVideoUrl;

    public WeishiFeed() {
        this.strVideoUrl = "";
        this.strCoverUrl = "";
        this.strDynamicCover = "";
    }

    public String className() {
        return "SummaryCard.WeishiFeed";
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
        jceDisplayer.display(this.strVideoUrl, "strVideoUrl");
        jceDisplayer.display(this.strCoverUrl, "strCoverUrl");
        jceDisplayer.display(this.strDynamicCover, "strDynamicCover");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.strVideoUrl, true);
        jceDisplayer.displaySimple(this.strCoverUrl, true);
        jceDisplayer.displaySimple(this.strDynamicCover, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        WeishiFeed weishiFeed = (WeishiFeed) obj;
        if (!JceUtil.equals(this.strVideoUrl, weishiFeed.strVideoUrl) || !JceUtil.equals(this.strCoverUrl, weishiFeed.strCoverUrl) || !JceUtil.equals(this.strDynamicCover, weishiFeed.strDynamicCover)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "SummaryCard.WeishiFeed";
    }

    public String getStrCoverUrl() {
        return this.strCoverUrl;
    }

    public String getStrDynamicCover() {
        return this.strDynamicCover;
    }

    public String getStrVideoUrl() {
        return this.strVideoUrl;
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
        this.strVideoUrl = jceInputStream.readString(0, false);
        this.strCoverUrl = jceInputStream.readString(1, false);
        this.strDynamicCover = jceInputStream.readString(2, false);
    }

    public void setStrCoverUrl(String str) {
        this.strCoverUrl = str;
    }

    public void setStrDynamicCover(String str) {
        this.strDynamicCover = str;
    }

    public void setStrVideoUrl(String str) {
        this.strVideoUrl = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.strVideoUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.strCoverUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.strDynamicCover;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
    }

    public WeishiFeed(String str, String str2, String str3) {
        this.strVideoUrl = str;
        this.strCoverUrl = str2;
        this.strDynamicCover = str3;
    }
}
