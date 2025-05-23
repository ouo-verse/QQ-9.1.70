package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.imsdk.BuildConfig;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GameInfo implements ISSOReqModel, ISSORspModel<GameInfo> {
    public final GameBasicInfo basic;
    public final GameDownLoadInfo download;
    public final GamePrivilegeInfo privilege;

    public GameInfo(GameBasicInfo gameBasicInfo, GamePrivilegeInfo gamePrivilegeInfo, GameDownLoadInfo gameDownLoadInfo) {
        this.basic = gameBasicInfo;
        this.privilege = gamePrivilegeInfo;
        this.download = gameDownLoadInfo;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        GameBasicInfo gameBasicInfo = this.basic;
        if (gameBasicInfo != null) {
            eVar.v(BuildConfig.FLAVOR, gameBasicInfo.encode());
        }
        GamePrivilegeInfo gamePrivilegeInfo = this.privilege;
        if (gamePrivilegeInfo != null) {
            eVar.v("privilege", gamePrivilegeInfo.encode());
        }
        GameDownLoadInfo gameDownLoadInfo = this.download;
        if (gameDownLoadInfo != null) {
            eVar.v("download", gameDownLoadInfo.encode());
        }
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final GameInfo decode(e eVar) {
        e m3 = eVar.m(BuildConfig.FLAVOR);
        GameBasicInfo gameBasicInfo = m3 != null ? new GameBasicInfo(m3.k("app_id", 0), m3.q("app_name", ""), m3.q("tickets", ""), m3.q("msg", ""), m3.q("cover", ""), m3.q("detail_url", ""), m3.q("channel_id", "")) : null;
        e m16 = eVar.m("privilege");
        GamePrivilegeInfo gamePrivilegeInfo = m16 != null ? new GamePrivilegeInfo(m16.q("developer", ""), m16.q("version", ""), m16.q("private_policies_text", ""), m16.q("private_policies_url", ""), m16.q("app_privileges_text", ""), m16.q("app_privileges_url", ""), m16.q("app_name", "")) : null;
        e m17 = eVar.m("download");
        return new GameInfo(gameBasicInfo, gamePrivilegeInfo, m17 != null ? new GameDownLoadInfo(m17.q("pkg_name", ""), m17.q("ios_download_url", ""), m17.q("android_download_url", ""), m17.q("ios_pkg_size", ""), m17.q("android_pkg_size", ""), m17.q("ad_tag", "")) : null);
    }
}
