package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdDownloadItem extends JceStruct {
    public AdAndroidMarketInfo androidMarketInfo;
    public String appIconUrl;
    public String appName;
    public boolean autoDownload;
    public boolean autoInstall;
    public String channelId;
    public String company_name;
    public int downloadActionType;
    public int downloadType;
    public String packageName;
    public String permission_list_url;
    public String privacy_policy_url;
    public RemindInstallItem remindInstallItem;
    public AdUrlItem urlItem;
    public int versionCode;
    static AdUrlItem cache_urlItem = new AdUrlItem();
    static RemindInstallItem cache_remindInstallItem = new RemindInstallItem();
    static AdAndroidMarketInfo cache_androidMarketInfo = new AdAndroidMarketInfo();

    public AdDownloadItem() {
        this.urlItem = null;
        this.packageName = "";
        this.appIconUrl = "";
        this.appName = "";
        this.downloadType = 0;
        this.versionCode = 0;
        this.channelId = "";
        this.autoDownload = false;
        this.autoInstall = false;
        this.downloadActionType = 0;
        this.remindInstallItem = null;
        this.company_name = "";
        this.permission_list_url = "";
        this.privacy_policy_url = "";
        this.androidMarketInfo = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.urlItem = (AdUrlItem) jceInputStream.read((JceStruct) cache_urlItem, 0, false);
        this.packageName = jceInputStream.readString(1, false);
        this.appIconUrl = jceInputStream.readString(2, false);
        this.appName = jceInputStream.readString(3, false);
        this.downloadType = jceInputStream.read(this.downloadType, 4, false);
        this.versionCode = jceInputStream.read(this.versionCode, 5, false);
        this.channelId = jceInputStream.readString(6, false);
        this.autoDownload = jceInputStream.read(this.autoDownload, 7, false);
        this.autoInstall = jceInputStream.read(this.autoInstall, 8, false);
        this.downloadActionType = jceInputStream.read(this.downloadActionType, 9, false);
        this.remindInstallItem = (RemindInstallItem) jceInputStream.read((JceStruct) cache_remindInstallItem, 10, false);
        this.company_name = jceInputStream.readString(11, false);
        this.permission_list_url = jceInputStream.readString(12, false);
        this.privacy_policy_url = jceInputStream.readString(13, false);
        this.androidMarketInfo = (AdAndroidMarketInfo) jceInputStream.read((JceStruct) cache_androidMarketInfo, 14, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        AdUrlItem adUrlItem = this.urlItem;
        if (adUrlItem != null) {
            jceOutputStream.write((JceStruct) adUrlItem, 0);
        }
        String str = this.packageName;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.appIconUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        String str3 = this.appName;
        if (str3 != null) {
            jceOutputStream.write(str3, 3);
        }
        jceOutputStream.write(this.downloadType, 4);
        jceOutputStream.write(this.versionCode, 5);
        String str4 = this.channelId;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
        jceOutputStream.write(this.autoDownload, 7);
        jceOutputStream.write(this.autoInstall, 8);
        jceOutputStream.write(this.downloadActionType, 9);
        RemindInstallItem remindInstallItem = this.remindInstallItem;
        if (remindInstallItem != null) {
            jceOutputStream.write((JceStruct) remindInstallItem, 10);
        }
        String str5 = this.company_name;
        if (str5 != null) {
            jceOutputStream.write(str5, 11);
        }
        String str6 = this.permission_list_url;
        if (str6 != null) {
            jceOutputStream.write(str6, 12);
        }
        String str7 = this.privacy_policy_url;
        if (str7 != null) {
            jceOutputStream.write(str7, 13);
        }
        AdAndroidMarketInfo adAndroidMarketInfo = this.androidMarketInfo;
        if (adAndroidMarketInfo != null) {
            jceOutputStream.write((JceStruct) adAndroidMarketInfo, 14);
        }
    }

    public AdDownloadItem(AdUrlItem adUrlItem, String str, String str2, String str3, int i3, int i16, String str4, boolean z16, boolean z17, int i17, RemindInstallItem remindInstallItem, String str5, String str6, String str7, AdAndroidMarketInfo adAndroidMarketInfo) {
        this.urlItem = adUrlItem;
        this.packageName = str;
        this.appIconUrl = str2;
        this.appName = str3;
        this.downloadType = i3;
        this.versionCode = i16;
        this.channelId = str4;
        this.autoDownload = z16;
        this.autoInstall = z17;
        this.downloadActionType = i17;
        this.remindInstallItem = remindInstallItem;
        this.company_name = str5;
        this.permission_list_url = str6;
        this.privacy_policy_url = str7;
        this.androidMarketInfo = adAndroidMarketInfo;
    }
}
