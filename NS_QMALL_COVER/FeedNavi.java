package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class FeedNavi extends JceStruct {
    public int iItemId;
    public String strFeedNaviUrl;
    public String strTextColor;

    public FeedNavi() {
        this.iItemId = -1;
        this.strFeedNaviUrl = "";
        this.strTextColor = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iItemId = jceInputStream.read(this.iItemId, 0, false);
        this.strFeedNaviUrl = jceInputStream.readString(1, false);
        this.strTextColor = jceInputStream.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iItemId, 0);
        String str = this.strFeedNaviUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strTextColor;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
    }

    public FeedNavi(int i3, String str, String str2) {
        this.iItemId = i3;
        this.strFeedNaviUrl = str;
        this.strTextColor = str2;
    }
}
