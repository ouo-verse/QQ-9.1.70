package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QzmallCustomBubbleSkin extends JceStruct {
    public int iItemId;
    public long lHeadBgColor;
    public long lTextColor;
    public long lUin;
    public String strBubbleZipUrl;
    public String strFeedsPicUrl;

    public QzmallCustomBubbleSkin() {
        this.iItemId = -1;
        this.strBubbleZipUrl = "";
        this.lUin = 0L;
        this.lHeadBgColor = 0L;
        this.lTextColor = 0L;
        this.strFeedsPicUrl = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iItemId = jceInputStream.read(this.iItemId, 0, false);
        this.strBubbleZipUrl = jceInputStream.readString(1, false);
        this.lUin = jceInputStream.read(this.lUin, 2, false);
        this.lHeadBgColor = jceInputStream.read(this.lHeadBgColor, 3, false);
        this.lTextColor = jceInputStream.read(this.lTextColor, 4, false);
        this.strFeedsPicUrl = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iItemId, 0);
        String str = this.strBubbleZipUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.lUin, 2);
        jceOutputStream.write(this.lHeadBgColor, 3);
        jceOutputStream.write(this.lTextColor, 4);
        String str2 = this.strFeedsPicUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
    }

    public QzmallCustomBubbleSkin(int i3, String str, long j3, long j16, long j17, String str2) {
        this.iItemId = i3;
        this.strBubbleZipUrl = str;
        this.lUin = j3;
        this.lHeadBgColor = j16;
        this.lTextColor = j17;
        this.strFeedsPicUrl = str2;
    }
}
