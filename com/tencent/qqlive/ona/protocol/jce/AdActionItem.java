package com.tencent.qqlive.ona.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class AdActionItem extends JceStruct {
    public AdDownloadItem adDownload;
    public AdH5UrlItem adH5UrlItem;
    public AdOpenAppItem adOpenApp;
    public AdOpenCanvasItem adOpenCanvasItem;
    public AdOpenHapAppItem adOpenHapApp;
    public AdOpenMiniProgramItem adOpenMiniGame;
    public AdOpenMiniProgramItem adOpenMiniProgram;
    public AdOpenWXNativePageItem adOpenWXNativePage;
    public AdUrlItem adUrl;
    public int parseType;
    static AdUrlItem cache_adUrl = new AdUrlItem();
    static AdDownloadItem cache_adDownload = new AdDownloadItem();
    static AdOpenAppItem cache_adOpenApp = new AdOpenAppItem();
    static AdOpenMiniProgramItem cache_adOpenMiniProgram = new AdOpenMiniProgramItem();
    static AdOpenCanvasItem cache_adOpenCanvasItem = new AdOpenCanvasItem();
    static AdH5UrlItem cache_adH5UrlItem = new AdH5UrlItem();
    static AdOpenMiniProgramItem cache_adOpenMiniGame = new AdOpenMiniProgramItem();
    static AdOpenWXNativePageItem cache_adOpenWXNativePage = new AdOpenWXNativePageItem();
    static AdOpenHapAppItem cache_adOpenHapApp = new AdOpenHapAppItem();

    public AdActionItem() {
        this.adUrl = null;
        this.adDownload = null;
        this.adOpenApp = null;
        this.adOpenMiniProgram = null;
        this.adOpenCanvasItem = null;
        this.parseType = 0;
        this.adH5UrlItem = null;
        this.adOpenMiniGame = null;
        this.adOpenWXNativePage = null;
        this.adOpenHapApp = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.adUrl = (AdUrlItem) jceInputStream.read((JceStruct) cache_adUrl, 0, false);
        this.adDownload = (AdDownloadItem) jceInputStream.read((JceStruct) cache_adDownload, 1, false);
        this.adOpenApp = (AdOpenAppItem) jceInputStream.read((JceStruct) cache_adOpenApp, 2, false);
        this.adOpenMiniProgram = (AdOpenMiniProgramItem) jceInputStream.read((JceStruct) cache_adOpenMiniProgram, 3, false);
        this.adOpenCanvasItem = (AdOpenCanvasItem) jceInputStream.read((JceStruct) cache_adOpenCanvasItem, 4, false);
        this.parseType = jceInputStream.read(this.parseType, 5, false);
        this.adH5UrlItem = (AdH5UrlItem) jceInputStream.read((JceStruct) cache_adH5UrlItem, 6, false);
        this.adOpenMiniGame = (AdOpenMiniProgramItem) jceInputStream.read((JceStruct) cache_adOpenMiniGame, 7, false);
        this.adOpenWXNativePage = (AdOpenWXNativePageItem) jceInputStream.read((JceStruct) cache_adOpenWXNativePage, 8, false);
        this.adOpenHapApp = (AdOpenHapAppItem) jceInputStream.read((JceStruct) cache_adOpenHapApp, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        AdUrlItem adUrlItem = this.adUrl;
        if (adUrlItem != null) {
            jceOutputStream.write((JceStruct) adUrlItem, 0);
        }
        AdDownloadItem adDownloadItem = this.adDownload;
        if (adDownloadItem != null) {
            jceOutputStream.write((JceStruct) adDownloadItem, 1);
        }
        AdOpenAppItem adOpenAppItem = this.adOpenApp;
        if (adOpenAppItem != null) {
            jceOutputStream.write((JceStruct) adOpenAppItem, 2);
        }
        AdOpenMiniProgramItem adOpenMiniProgramItem = this.adOpenMiniProgram;
        if (adOpenMiniProgramItem != null) {
            jceOutputStream.write((JceStruct) adOpenMiniProgramItem, 3);
        }
        AdOpenCanvasItem adOpenCanvasItem = this.adOpenCanvasItem;
        if (adOpenCanvasItem != null) {
            jceOutputStream.write((JceStruct) adOpenCanvasItem, 4);
        }
        jceOutputStream.write(this.parseType, 5);
        AdH5UrlItem adH5UrlItem = this.adH5UrlItem;
        if (adH5UrlItem != null) {
            jceOutputStream.write((JceStruct) adH5UrlItem, 6);
        }
        AdOpenMiniProgramItem adOpenMiniProgramItem2 = this.adOpenMiniGame;
        if (adOpenMiniProgramItem2 != null) {
            jceOutputStream.write((JceStruct) adOpenMiniProgramItem2, 7);
        }
        AdOpenWXNativePageItem adOpenWXNativePageItem = this.adOpenWXNativePage;
        if (adOpenWXNativePageItem != null) {
            jceOutputStream.write((JceStruct) adOpenWXNativePageItem, 8);
        }
        AdOpenHapAppItem adOpenHapAppItem = this.adOpenHapApp;
        if (adOpenHapAppItem != null) {
            jceOutputStream.write((JceStruct) adOpenHapAppItem, 9);
        }
    }

    public AdActionItem(AdUrlItem adUrlItem, AdDownloadItem adDownloadItem, AdOpenAppItem adOpenAppItem, AdOpenMiniProgramItem adOpenMiniProgramItem, AdOpenCanvasItem adOpenCanvasItem, int i3, AdH5UrlItem adH5UrlItem, AdOpenMiniProgramItem adOpenMiniProgramItem2, AdOpenWXNativePageItem adOpenWXNativePageItem, AdOpenHapAppItem adOpenHapAppItem) {
        this.adUrl = adUrlItem;
        this.adDownload = adDownloadItem;
        this.adOpenApp = adOpenAppItem;
        this.adOpenMiniProgram = adOpenMiniProgramItem;
        this.adOpenCanvasItem = adOpenCanvasItem;
        this.parseType = i3;
        this.adH5UrlItem = adH5UrlItem;
        this.adOpenMiniGame = adOpenMiniProgramItem2;
        this.adOpenWXNativePage = adOpenWXNativePageItem;
        this.adOpenHapApp = adOpenHapAppItem;
    }
}
