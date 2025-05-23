package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdCustomActionButtonInfo extends JceStruct {
    public String bgColor;
    public String bgColorPress;
    public String hightlightBgColor;
    public String iconUrl;
    public boolean shouldShow;
    public String title;
    public String uninstalIconUrl;
    public String uninstallTitle;

    public AdCustomActionButtonInfo() {
        this.title = "";
        this.uninstallTitle = "";
        this.bgColor = "";
        this.hightlightBgColor = "";
        this.shouldShow = true;
        this.iconUrl = "";
        this.uninstalIconUrl = "";
        this.bgColorPress = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.title = jceInputStream.readString(1, false);
        this.uninstallTitle = jceInputStream.readString(2, false);
        this.bgColor = jceInputStream.readString(3, false);
        this.hightlightBgColor = jceInputStream.readString(4, false);
        this.shouldShow = jceInputStream.read(this.shouldShow, 5, false);
        this.iconUrl = jceInputStream.readString(6, false);
        this.uninstalIconUrl = jceInputStream.readString(7, false);
        this.bgColorPress = jceInputStream.readString(8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.uninstallTitle;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.bgColor;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        String str4 = this.hightlightBgColor;
        if (str4 != null) {
            jceOutputStream.write(str4, 4);
        }
        jceOutputStream.write(this.shouldShow, 5);
        String str5 = this.iconUrl;
        if (str5 != null) {
            jceOutputStream.write(str5, 6);
        }
        String str6 = this.uninstalIconUrl;
        if (str6 != null) {
            jceOutputStream.write(str6, 7);
        }
        String str7 = this.bgColorPress;
        if (str7 != null) {
            jceOutputStream.write(str7, 8);
        }
    }

    public AdCustomActionButtonInfo(String str, String str2, String str3, String str4, boolean z16, String str5, String str6, String str7) {
        this.title = str;
        this.uninstallTitle = str2;
        this.bgColor = str3;
        this.hightlightBgColor = str4;
        this.shouldShow = z16;
        this.iconUrl = str5;
        this.uninstalIconUrl = str6;
        this.bgColorPress = str7;
    }
}
