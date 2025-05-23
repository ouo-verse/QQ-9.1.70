package SummaryCard;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* compiled from: P */
/* loaded from: classes.dex */
public final class TMedalWallInfo extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public int iMedalCount;
    public int iNewCount;
    public int iOpenFlag;
    public int iUpgradeCount;
    public String strPromptParams;

    public TMedalWallInfo() {
        this.iOpenFlag = 0;
        this.iMedalCount = 0;
        this.iNewCount = 0;
        this.iUpgradeCount = 0;
        this.strPromptParams = "";
    }

    public String className() {
        return "SummaryCard.TMedalWallInfo";
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
        jceDisplayer.display(this.iOpenFlag, "iOpenFlag");
        jceDisplayer.display(this.iMedalCount, "iMedalCount");
        jceDisplayer.display(this.iNewCount, "iNewCount");
        jceDisplayer.display(this.iUpgradeCount, "iUpgradeCount");
        jceDisplayer.display(this.strPromptParams, "strPromptParams");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.iOpenFlag, true);
        jceDisplayer.displaySimple(this.iMedalCount, true);
        jceDisplayer.displaySimple(this.iNewCount, true);
        jceDisplayer.displaySimple(this.iUpgradeCount, true);
        jceDisplayer.displaySimple(this.strPromptParams, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        TMedalWallInfo tMedalWallInfo = (TMedalWallInfo) obj;
        if (!JceUtil.equals(this.iOpenFlag, tMedalWallInfo.iOpenFlag) || !JceUtil.equals(this.iMedalCount, tMedalWallInfo.iMedalCount) || !JceUtil.equals(this.iNewCount, tMedalWallInfo.iNewCount) || !JceUtil.equals(this.iUpgradeCount, tMedalWallInfo.iUpgradeCount) || !JceUtil.equals(this.strPromptParams, tMedalWallInfo.strPromptParams)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "SummaryCard.TMedalWallInfo";
    }

    public int getIMedalCount() {
        return this.iMedalCount;
    }

    public int getINewCount() {
        return this.iNewCount;
    }

    public int getIOpenFlag() {
        return this.iOpenFlag;
    }

    public int getIUpgradeCount() {
        return this.iUpgradeCount;
    }

    public String getStrPromptParams() {
        return this.strPromptParams;
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
        this.iOpenFlag = jceInputStream.read(this.iOpenFlag, 0, false);
        this.iMedalCount = jceInputStream.read(this.iMedalCount, 1, false);
        this.iNewCount = jceInputStream.read(this.iNewCount, 2, false);
        this.iUpgradeCount = jceInputStream.read(this.iUpgradeCount, 3, false);
        this.strPromptParams = jceInputStream.readString(4, false);
    }

    public void setIMedalCount(int i3) {
        this.iMedalCount = i3;
    }

    public void setINewCount(int i3) {
        this.iNewCount = i3;
    }

    public void setIOpenFlag(int i3) {
        this.iOpenFlag = i3;
    }

    public void setIUpgradeCount(int i3) {
        this.iUpgradeCount = i3;
    }

    public void setStrPromptParams(String str) {
        this.strPromptParams = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iOpenFlag, 0);
        jceOutputStream.write(this.iMedalCount, 1);
        jceOutputStream.write(this.iNewCount, 2);
        jceOutputStream.write(this.iUpgradeCount, 3);
        String str = this.strPromptParams;
        if (str != null) {
            jceOutputStream.write(str, 4);
        }
    }

    public TMedalWallInfo(int i3, int i16, int i17, int i18, String str) {
        this.iOpenFlag = i3;
        this.iMedalCount = i16;
        this.iNewCount = i17;
        this.iUpgradeCount = i18;
        this.strPromptParams = str;
    }
}
