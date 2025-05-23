package QC;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SetFontBubbleReq extends JceStruct {
    public BubbleReq stBubbleReq;
    public FontReq stFontReq;
    public LoginInfo stLogin;
    static LoginInfo cache_stLogin = new LoginInfo();
    static FontReq cache_stFontReq = new FontReq();
    static BubbleReq cache_stBubbleReq = new BubbleReq();

    public SetFontBubbleReq() {
        this.stLogin = null;
        this.stFontReq = null;
        this.stBubbleReq = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stLogin = (LoginInfo) jceInputStream.read((JceStruct) cache_stLogin, 0, true);
        this.stFontReq = (FontReq) jceInputStream.read((JceStruct) cache_stFontReq, 1, false);
        this.stBubbleReq = (BubbleReq) jceInputStream.read((JceStruct) cache_stBubbleReq, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.stLogin, 0);
        FontReq fontReq = this.stFontReq;
        if (fontReq != null) {
            jceOutputStream.write((JceStruct) fontReq, 1);
        }
        BubbleReq bubbleReq = this.stBubbleReq;
        if (bubbleReq != null) {
            jceOutputStream.write((JceStruct) bubbleReq, 2);
        }
    }

    public SetFontBubbleReq(LoginInfo loginInfo, FontReq fontReq, BubbleReq bubbleReq) {
        this.stLogin = loginInfo;
        this.stFontReq = fontReq;
        this.stBubbleReq = bubbleReq;
    }
}
