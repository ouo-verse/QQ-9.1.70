package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes22.dex */
public final class AdOpenMiniProgramItem extends JceStruct {
    static AdUrlItem cache_urlItem = new AdUrlItem();
    public String adTraceData;
    public String appName;
    public boolean disableDialog;
    public String token;
    public AdUrlItem urlItem;
    public String wxaAppId;

    public AdOpenMiniProgramItem() {
        this.urlItem = null;
        this.appName = "";
        this.disableDialog = false;
        this.token = "";
        this.adTraceData = "";
        this.wxaAppId = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.urlItem = (AdUrlItem) jceInputStream.read((JceStruct) cache_urlItem, 0, false);
        this.appName = jceInputStream.readString(1, false);
        this.disableDialog = jceInputStream.read(this.disableDialog, 2, false);
        this.token = jceInputStream.readString(3, false);
        this.adTraceData = jceInputStream.readString(4, false);
        this.wxaAppId = jceInputStream.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        AdUrlItem adUrlItem = this.urlItem;
        if (adUrlItem != null) {
            jceOutputStream.write((JceStruct) adUrlItem, 0);
        }
        String str = this.appName;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        jceOutputStream.write(this.disableDialog, 2);
        String str2 = this.token;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.adTraceData;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        String str4 = this.wxaAppId;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
    }

    public AdOpenMiniProgramItem(AdUrlItem adUrlItem, String str, boolean z16, String str2, String str3, String str4) {
        this.urlItem = adUrlItem;
        this.appName = str;
        this.disableDialog = z16;
        this.token = str2;
        this.adTraceData = str3;
        this.wxaAppId = str4;
    }
}
