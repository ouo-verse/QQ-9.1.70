package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdOpenAppItem extends JceStruct {
    public String appName;
    public AdDownloadItem downloadItem;
    public int openFailedAction;
    public PackageAction packageAction;
    public String packageName;
    static PackageAction cache_packageAction = new PackageAction();
    static int cache_openFailedAction = 0;
    static AdDownloadItem cache_downloadItem = new AdDownloadItem();

    public AdOpenAppItem() {
        this.packageAction = null;
        this.openFailedAction = 0;
        this.downloadItem = null;
        this.appName = "";
        this.packageName = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.packageAction = (PackageAction) jceInputStream.read((JceStruct) cache_packageAction, 0, false);
        this.openFailedAction = jceInputStream.read(this.openFailedAction, 1, false);
        this.downloadItem = (AdDownloadItem) jceInputStream.read((JceStruct) cache_downloadItem, 2, false);
        this.appName = jceInputStream.readString(3, false);
        this.packageName = jceInputStream.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        PackageAction packageAction = this.packageAction;
        if (packageAction != null) {
            jceOutputStream.write((JceStruct) packageAction, 0);
        }
        jceOutputStream.write(this.openFailedAction, 1);
        AdDownloadItem adDownloadItem = this.downloadItem;
        if (adDownloadItem != null) {
            jceOutputStream.write((JceStruct) adDownloadItem, 2);
        }
        String str = this.appName;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.packageName;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
    }

    public AdOpenAppItem(PackageAction packageAction, int i3, AdDownloadItem adDownloadItem, String str, String str2) {
        this.packageAction = packageAction;
        this.openFailedAction = i3;
        this.downloadItem = adDownloadItem;
        this.appName = str;
        this.packageName = str2;
    }
}
