package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QzmallCustomNavi extends JceStruct {
    public int iItemId;
    public long lArrowColor;
    public long lBtnTextColor;
    public long lProfileCrossBarBgColor;
    public long lProfileCrossBarSeparatorColor;
    public long lProfileDescTextColor;
    public long lSeparatorColor;
    public String strActiveFeedNaviUrl;
    public String strProfileNaviUrl;

    public QzmallCustomNavi() {
        this.iItemId = -1;
        this.strActiveFeedNaviUrl = "";
        this.strProfileNaviUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iItemId = jceInputStream.read(this.iItemId, 0, true);
        this.strActiveFeedNaviUrl = jceInputStream.readString(1, false);
        this.strProfileNaviUrl = jceInputStream.readString(2, false);
        this.lSeparatorColor = jceInputStream.read(this.lSeparatorColor, 3, false);
        this.lBtnTextColor = jceInputStream.read(this.lBtnTextColor, 4, false);
        this.lProfileDescTextColor = jceInputStream.read(this.lProfileDescTextColor, 5, false);
        this.lProfileCrossBarBgColor = jceInputStream.read(this.lProfileCrossBarBgColor, 6, false);
        this.lProfileCrossBarSeparatorColor = jceInputStream.read(this.lProfileCrossBarSeparatorColor, 7, false);
        this.lArrowColor = jceInputStream.read(this.lArrowColor, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iItemId, 0);
        String str = this.strActiveFeedNaviUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strProfileNaviUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.lSeparatorColor, 3);
        jceOutputStream.write(this.lBtnTextColor, 4);
        jceOutputStream.write(this.lProfileDescTextColor, 5);
        jceOutputStream.write(this.lProfileCrossBarBgColor, 6);
        jceOutputStream.write(this.lProfileCrossBarSeparatorColor, 7);
        jceOutputStream.write(this.lArrowColor, 8);
    }

    public QzmallCustomNavi(int i3, String str, String str2, long j3, long j16, long j17, long j18, long j19, long j26) {
        this.iItemId = i3;
        this.strActiveFeedNaviUrl = str;
        this.strProfileNaviUrl = str2;
        this.lSeparatorColor = j3;
        this.lBtnTextColor = j16;
        this.lProfileDescTextColor = j17;
        this.lProfileCrossBarBgColor = j18;
        this.lProfileCrossBarSeparatorColor = j19;
        this.lArrowColor = j26;
    }
}
