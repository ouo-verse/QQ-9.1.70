package NS_MOBILE_MATERIAL;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CommentBubble extends JceStruct {
    static int cache_eType;
    static BubbleSource cache_stSource = new BubbleSource();
    public int eType;
    public int iFrameRate;
    public int iItemId;
    public BubbleSource stSource;
    public String strAndBgUrl;
    public String strFrameZip;
    public String strIosBgUrl;
    public String strTextColor;

    public CommentBubble() {
        this.iItemId = -1;
        this.strTextColor = "";
        this.strAndBgUrl = "";
        this.strIosBgUrl = "";
        this.eType = 0;
        this.stSource = null;
        this.strFrameZip = "";
        this.iFrameRate = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iItemId = jceInputStream.read(this.iItemId, 0, false);
        this.strTextColor = jceInputStream.readString(1, false);
        this.strAndBgUrl = jceInputStream.readString(2, false);
        this.strIosBgUrl = jceInputStream.readString(3, false);
        this.eType = jceInputStream.read(this.eType, 4, false);
        this.stSource = (BubbleSource) jceInputStream.read((JceStruct) cache_stSource, 5, false);
        this.strFrameZip = jceInputStream.readString(6, false);
        this.iFrameRate = jceInputStream.read(this.iFrameRate, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iItemId, 0);
        String str = this.strTextColor;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strAndBgUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.strIosBgUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.eType, 4);
        BubbleSource bubbleSource = this.stSource;
        if (bubbleSource != null) {
            jceOutputStream.write((JceStruct) bubbleSource, 5);
        }
        String str4 = this.strFrameZip;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        jceOutputStream.write(this.iFrameRate, 7);
    }

    public CommentBubble(int i3, String str, String str2, String str3, int i16, BubbleSource bubbleSource, String str4, int i17) {
        this.iItemId = i3;
        this.strTextColor = str;
        this.strAndBgUrl = str2;
        this.strIosBgUrl = str3;
        this.eType = i16;
        this.stSource = bubbleSource;
        this.strFrameZip = str4;
        this.iFrameRate = i17;
    }
}
