package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdOpenHapAppItem extends JceStruct {
    static int cache_openFailedAction;
    public String appName;
    public String hapAppUrl;
    public int openFailedAction;
    public String packageName;

    public AdOpenHapAppItem() {
        this.hapAppUrl = "";
        this.openFailedAction = 0;
        this.appName = "";
        this.packageName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.hapAppUrl = jceInputStream.readString(0, false);
        this.openFailedAction = jceInputStream.read(this.openFailedAction, 1, false);
        this.appName = jceInputStream.readString(2, false);
        this.packageName = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.hapAppUrl;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        jceOutputStream.write(this.openFailedAction, 1);
        String str2 = this.appName;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.packageName;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
    }

    public AdOpenHapAppItem(String str, int i3, String str2, String str3) {
        this.hapAppUrl = str;
        this.openFailedAction = i3;
        this.appName = str2;
        this.packageName = str3;
    }
}
