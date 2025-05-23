package NS_QMALL_COVER;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

/* loaded from: classes.dex */
public final class EmotionPraise extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public int iItemId;
    public String strEmotion;
    public String strItemSummary;
    public String strName;
    public String strPraiseListPic;
    public String strPraisePic;
    public String strPraiseZip;

    public EmotionPraise() {
        this.iItemId = -1;
        this.strName = "";
        this.strItemSummary = "";
        this.strPraisePic = "";
        this.strPraiseListPic = "";
        this.strPraiseZip = "";
        this.strEmotion = "";
    }

    public String className() {
        return "NS_QMALL_COVER.EmotionPraise";
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
        jceDisplayer.display(this.iItemId, "iItemId");
        jceDisplayer.display(this.strName, "strName");
        jceDisplayer.display(this.strItemSummary, "strItemSummary");
        jceDisplayer.display(this.strPraisePic, "strPraisePic");
        jceDisplayer.display(this.strPraiseListPic, "strPraiseListPic");
        jceDisplayer.display(this.strPraiseZip, "strPraiseZip");
        jceDisplayer.display(this.strEmotion, "strEmotion");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple(this.iItemId, true);
        jceDisplayer.displaySimple(this.strName, true);
        jceDisplayer.displaySimple(this.strItemSummary, true);
        jceDisplayer.displaySimple(this.strPraisePic, true);
        jceDisplayer.displaySimple(this.strPraiseListPic, true);
        jceDisplayer.displaySimple(this.strPraiseZip, true);
        jceDisplayer.displaySimple(this.strEmotion, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        EmotionPraise emotionPraise = (EmotionPraise) obj;
        if (!JceUtil.equals(this.iItemId, emotionPraise.iItemId) || !JceUtil.equals(this.strName, emotionPraise.strName) || !JceUtil.equals(this.strItemSummary, emotionPraise.strItemSummary) || !JceUtil.equals(this.strPraisePic, emotionPraise.strPraisePic) || !JceUtil.equals(this.strPraiseListPic, emotionPraise.strPraiseListPic) || !JceUtil.equals(this.strPraiseZip, emotionPraise.strPraiseZip) || !JceUtil.equals(this.strEmotion, emotionPraise.strEmotion)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "NS_QMALL_COVER.EmotionPraise";
    }

    public int getIItemId() {
        return this.iItemId;
    }

    public String getStrEmotion() {
        return this.strEmotion;
    }

    public String getStrItemSummary() {
        return this.strItemSummary;
    }

    public String getStrName() {
        return this.strName;
    }

    public String getStrPraiseListPic() {
        return this.strPraiseListPic;
    }

    public String getStrPraisePic() {
        return this.strPraisePic;
    }

    public String getStrPraiseZip() {
        return this.strPraiseZip;
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
        this.iItemId = jceInputStream.read(this.iItemId, 0, true);
        this.strName = jceInputStream.readString(1, false);
        this.strItemSummary = jceInputStream.readString(2, false);
        this.strPraisePic = jceInputStream.readString(3, false);
        this.strPraiseListPic = jceInputStream.readString(4, false);
        this.strPraiseZip = jceInputStream.readString(5, false);
        this.strEmotion = jceInputStream.readString(6, false);
    }

    public void setIItemId(int i3) {
        this.iItemId = i3;
    }

    public void setStrEmotion(String str) {
        this.strEmotion = str;
    }

    public void setStrItemSummary(String str) {
        this.strItemSummary = str;
    }

    public void setStrName(String str) {
        this.strName = str;
    }

    public void setStrPraiseListPic(String str) {
        this.strPraiseListPic = str;
    }

    public void setStrPraisePic(String str) {
        this.strPraisePic = str;
    }

    public void setStrPraiseZip(String str) {
        this.strPraiseZip = str;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iItemId, 0);
        String str = this.strName;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strItemSummary;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.strPraisePic;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.strPraiseListPic;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        String str5 = this.strPraiseZip;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        String str6 = this.strEmotion;
        if (str6 != null) {
            jceOutputStream.write(str6, 6);
        }
    }

    public EmotionPraise(int i3, String str, String str2, String str3, String str4, String str5, String str6) {
        this.iItemId = i3;
        this.strName = str;
        this.strItemSummary = str2;
        this.strPraisePic = str3;
        this.strPraiseListPic = str4;
        this.strPraiseZip = str5;
        this.strEmotion = str6;
    }
}
