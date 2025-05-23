package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdH5UrlItem extends JceStruct {
    static int cache_actionJumpType;
    static Map<String, String> cache_dstLinkUrlAppendParams;
    public int actionJumpType;
    public String adxSplashH5Url;
    public Map<String, String> dstLinkUrlAppendParams;
    public int h5UrlValid;
    public String url;
    public int webviewType;
    public String xjWechatCanvasInfo;

    static {
        HashMap hashMap = new HashMap();
        cache_dstLinkUrlAppendParams = hashMap;
        hashMap.put("", "");
        cache_actionJumpType = 0;
    }

    public AdH5UrlItem() {
        this.webviewType = 1;
        this.adxSplashH5Url = "";
        this.h5UrlValid = 0;
        this.dstLinkUrlAppendParams = null;
        this.actionJumpType = 0;
        this.url = "";
        this.xjWechatCanvasInfo = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.webviewType = jceInputStream.read(this.webviewType, 0, false);
        this.adxSplashH5Url = jceInputStream.readString(1, false);
        this.h5UrlValid = jceInputStream.read(this.h5UrlValid, 2, false);
        this.dstLinkUrlAppendParams = (Map) jceInputStream.read((JceInputStream) cache_dstLinkUrlAppendParams, 3, false);
        this.actionJumpType = jceInputStream.read(this.actionJumpType, 4, false);
        this.url = jceInputStream.readString(5, false);
        this.xjWechatCanvasInfo = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.webviewType, 0);
        String str = this.adxSplashH5Url;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.h5UrlValid, 2);
        Map<String, String> map = this.dstLinkUrlAppendParams;
        if (map != null) {
            jceOutputStream.write((Map) map, 3);
        }
        jceOutputStream.write(this.actionJumpType, 4);
        String str2 = this.url;
        if (str2 != null) {
            jceOutputStream.write(str2, 5);
        }
        String str3 = this.xjWechatCanvasInfo;
        if (str3 != null) {
            jceOutputStream.write(str3, 6);
        }
    }

    public AdH5UrlItem(int i3, String str, int i16, Map<String, String> map, int i17, String str2, String str3) {
        this.webviewType = i3;
        this.adxSplashH5Url = str;
        this.h5UrlValid = i16;
        this.dstLinkUrlAppendParams = map;
        this.actionJumpType = i17;
        this.url = str2;
        this.xjWechatCanvasInfo = str3;
    }
}
