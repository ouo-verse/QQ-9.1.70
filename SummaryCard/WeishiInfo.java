package SummaryCard;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class WeishiInfo extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static ArrayList<WeishiFeed> cache_vecWeishiFeeds = new ArrayList<>();
    public String strSchema;
    public ArrayList<WeishiFeed> vecWeishiFeeds;

    static {
        cache_vecWeishiFeeds.add(new WeishiFeed());
    }

    public WeishiInfo() {
        this.vecWeishiFeeds = null;
        this.strSchema = "";
    }

    public String className() {
        return "SummaryCard.WeishiInfo";
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
        jceDisplayer.display((Collection) this.vecWeishiFeeds, "vecWeishiFeeds");
        jceDisplayer.display(this.strSchema, "strSchema");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple((Collection) this.vecWeishiFeeds, true);
        jceDisplayer.displaySimple(this.strSchema, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        WeishiInfo weishiInfo = (WeishiInfo) obj;
        if (!JceUtil.equals(this.vecWeishiFeeds, weishiInfo.vecWeishiFeeds) || !JceUtil.equals(this.strSchema, weishiInfo.strSchema)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "SummaryCard.WeishiInfo";
    }

    public String getStrSchema() {
        return this.strSchema;
    }

    public ArrayList<WeishiFeed> getVecWeishiFeeds() {
        return this.vecWeishiFeeds;
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
        this.vecWeishiFeeds = (ArrayList) jceInputStream.read((JceInputStream) cache_vecWeishiFeeds, 0, false);
        this.strSchema = jceInputStream.readString(1, false);
    }

    public void setStrSchema(String str) {
        this.strSchema = str;
    }

    public void setVecWeishiFeeds(ArrayList<WeishiFeed> arrayList) {
        this.vecWeishiFeeds = arrayList;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        ArrayList<WeishiFeed> arrayList = this.vecWeishiFeeds;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 0);
        }
        String str = this.strSchema;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    public WeishiInfo(ArrayList<WeishiFeed> arrayList, String str) {
        this.vecWeishiFeeds = arrayList;
        this.strSchema = str;
    }
}
