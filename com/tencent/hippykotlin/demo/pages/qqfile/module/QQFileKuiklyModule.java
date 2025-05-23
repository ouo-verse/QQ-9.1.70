package com.tencent.hippykotlin.demo.pages.qqfile.module;

import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.qqfile.model.KTFileInfo;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFileKuiklyModule extends Module {
    public static final Companion Companion = new Companion();

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public final QQFileKuiklyModule getInstance() {
            return (QQFileKuiklyModule) c.f117352a.g().acquireModule("QQFileKuiklyModule");
        }
    }

    public final e createParamsWithFileInfo(KTFileInfo kTFileInfo) {
        e eVar = new e();
        eVar.v(WadlProxyConsts.PARAM_FILENAME, kTFileInfo.fileName);
        eVar.t(PhotoCategorySinglePicInfo.UPLOAD_TIME, kTFileInfo.uploadTime);
        eVar.t("lifeTime", kTFileInfo.lifeTime);
        eVar.u("fileSize", kTFileInfo.fileSize);
        eVar.v("uuid", kTFileInfo.uuid);
        eVar.v("fileIdCrc", kTFileInfo.fileIdCrc);
        eVar.t(TagName.FILE_TYPE, kTFileInfo.absFileType);
        eVar.u("peerUin", kTFileInfo.peerUin);
        eVar.u("ownerUin", kTFileInfo.ownerUin);
        eVar.v("md5", kTFileInfo.md5);
        eVar.v("md5_10m", kTFileInfo.tenMBMd5);
        eVar.v(WidgetCacheLunarData.SHA, kTFileInfo.sha);
        eVar.v("sha_3", kTFileInfo.sha3);
        return eVar;
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "QQFileKuiklyModule";
    }
}
