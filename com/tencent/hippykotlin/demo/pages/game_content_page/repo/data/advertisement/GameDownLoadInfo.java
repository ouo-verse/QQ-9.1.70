package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GameDownLoadInfo implements ISSOReqModel, ISSORspModel<GameDownLoadInfo> {
    public final String adtag;
    public final String androidDownloadUrl;
    public final String androidPkgSize;
    public final String iosDownloadUrl;
    public final String iosPkgSize;
    public final String pkgName;

    public GameDownLoadInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        this.pkgName = str;
        this.iosDownloadUrl = str2;
        this.androidDownloadUrl = str3;
        this.iosPkgSize = str4;
        this.androidPkgSize = str5;
        this.adtag = str6;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("pkg_name", this.pkgName);
        eVar.v("ios_download_url", this.iosDownloadUrl);
        eVar.v("android_download_url", this.androidDownloadUrl);
        eVar.v("ios_pkg_size", this.iosPkgSize);
        eVar.v("android_pkg_size", this.androidPkgSize);
        eVar.v("ad_tag", this.adtag);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final GameDownLoadInfo decode(e eVar) {
        return new GameDownLoadInfo(eVar.q("pkg_name", ""), eVar.q("ios_download_url", ""), eVar.q("android_download_url", ""), eVar.q("ios_pkg_size", ""), eVar.q("android_pkg_size", ""), eVar.q("ad_tag", ""));
    }
}
