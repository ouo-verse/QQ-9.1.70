package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SetFontBubbleRsp extends JceStruct {
    public BubbleRsp stBubbleRsp;
    public FontRsp stFontRsp;
    public CommonRsp stRet;
    static CommonRsp cache_stRet = new CommonRsp();
    static FontRsp cache_stFontRsp = new FontRsp();
    static BubbleRsp cache_stBubbleRsp = new BubbleRsp();

    public SetFontBubbleRsp() {
        this.stRet = null;
        this.stFontRsp = null;
        this.stBubbleRsp = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stRet = (CommonRsp) jceInputStream.read((JceStruct) cache_stRet, 0, false);
        this.stFontRsp = (FontRsp) jceInputStream.read((JceStruct) cache_stFontRsp, 1, false);
        this.stBubbleRsp = (BubbleRsp) jceInputStream.read((JceStruct) cache_stBubbleRsp, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        CommonRsp commonRsp = this.stRet;
        if (commonRsp != null) {
            jceOutputStream.write((JceStruct) commonRsp, 0);
        }
        FontRsp fontRsp = this.stFontRsp;
        if (fontRsp != null) {
            jceOutputStream.write((JceStruct) fontRsp, 1);
        }
        BubbleRsp bubbleRsp = this.stBubbleRsp;
        if (bubbleRsp != null) {
            jceOutputStream.write((JceStruct) bubbleRsp, 2);
        }
    }

    public SetFontBubbleRsp(CommonRsp commonRsp, FontRsp fontRsp, BubbleRsp bubbleRsp) {
        this.stRet = commonRsp;
        this.stFontRsp = fontRsp;
        this.stBubbleRsp = bubbleRsp;
    }
}
