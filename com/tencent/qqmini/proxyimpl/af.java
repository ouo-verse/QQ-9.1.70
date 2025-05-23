package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoByIdEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoByLinkEntity;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import common.config.service.QzoneConfig;
import java.util.List;

/* compiled from: P */
@ProxyService(proxy = MiniAppCacheProxy.class)
/* loaded from: classes34.dex */
public class af implements MiniAppCacheProxy {
    private MiniAppEntityManager a() {
        return MiniAppEntityManager.get();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy
    public boolean deleteCacheByTimeStamp(long j3) {
        MiniAppEntityManager a16 = a();
        if (a16 == null) {
            return true;
        }
        a16.checkDB();
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy
    public boolean enableMiniAppCache() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy
    public long getDeleteIntervalTime() {
        return QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.MINI_APP_APPINFOENTITY_DELEATE_INTERVAL_TIME, 172800000L);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy
    public byte[] getIdInfo(String str, String str2) {
        List<? extends Entity> queryEntity;
        MiniAppInfoByIdEntity miniAppInfoByIdEntity;
        MiniAppEntityManager a16 = a();
        if (a16 == null || (queryEntity = a16.queryEntity(MiniAppInfoByIdEntity.class, false, "appId=? and entryPath=? ", new String[]{str, str2}, null, null, null, null)) == null || queryEntity.size() != 1 || (miniAppInfoByIdEntity = (MiniAppInfoByIdEntity) queryEntity.get(0)) == null) {
            return null;
        }
        return miniAppInfoByIdEntity.appInfo;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy
    public MiniAppCacheProxy.LinkData getLinkInfo(String str, int i3) {
        List<? extends Entity> queryEntity;
        MiniAppInfoByLinkEntity miniAppInfoByLinkEntity;
        MiniAppEntityManager a16 = a();
        if (a16 == null || (queryEntity = a16.queryEntity(MiniAppInfoByLinkEntity.class, false, "link=? and linkType=? ", new String[]{str, String.valueOf(i3)}, null, null, null, null)) == null || queryEntity.size() != 1 || (miniAppInfoByLinkEntity = (MiniAppInfoByLinkEntity) queryEntity.get(0)) == null) {
            return null;
        }
        MiniAppCacheProxy.LinkData linkData = new MiniAppCacheProxy.LinkData();
        linkData.setAppInfo(miniAppInfoByLinkEntity.appInfo);
        linkData.setShareTicket(miniAppInfoByLinkEntity.shareTicket);
        return linkData;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy
    public boolean saveIdInfo(String str, String str2, byte[] bArr, long j3) {
        MiniAppInfoByIdEntity miniAppInfoByIdEntity = new MiniAppInfoByIdEntity();
        miniAppInfoByIdEntity.appId = str;
        miniAppInfoByIdEntity.entryPath = str2;
        miniAppInfoByIdEntity.appInfo = bArr;
        miniAppInfoByIdEntity.timeStamp = j3;
        MiniAppEntityManager a16 = a();
        if (a16 == null || !a16.insertOrReplaceEntity(miniAppInfoByIdEntity)) {
            return false;
        }
        QLog.d("MiniAppCacheProxyImpl", 1, "saveIdInfo ok." + miniAppInfoByIdEntity.appId);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy
    public boolean saveLinkInfo(String str, int i3, String str2, byte[] bArr, long j3) {
        MiniAppInfoByLinkEntity miniAppInfoByLinkEntity = new MiniAppInfoByLinkEntity();
        miniAppInfoByLinkEntity.link = str;
        miniAppInfoByLinkEntity.linkType = i3;
        miniAppInfoByLinkEntity.shareTicket = str2;
        miniAppInfoByLinkEntity.appInfo = bArr;
        miniAppInfoByLinkEntity.timeStamp = j3;
        MiniAppEntityManager a16 = a();
        if (a16 == null || !a16.insertOrReplaceEntity(miniAppInfoByLinkEntity)) {
            return false;
        }
        QLog.d("MiniAppCacheProxyImpl", 1, "saveLinkInfo ok." + miniAppInfoByLinkEntity.link + " linkType:" + i3);
        return true;
    }
}
