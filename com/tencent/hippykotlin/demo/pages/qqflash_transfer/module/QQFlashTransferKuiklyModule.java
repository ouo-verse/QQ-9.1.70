package com.tencent.hippykotlin.demo.pages.qqflash_transfer.module;

import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.List;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import ws3.ab;
import ws3.br;
import ws3.eg;
import ws3.eq;
import ws3.es;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFlashTransferKuiklyModule extends Module {
    public static final Companion Companion = new Companion();

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public final QQFlashTransferKuiklyModule getInstance() {
            return (QQFlashTransferKuiklyModule) c.f117352a.g().acquireModule("QQFlashTransferKuiklyModule");
        }
    }

    public final e createParamsWithFileInfo(ab abVar) {
        List<eq> list;
        Object firstOrNull;
        String str;
        e eVar = new e();
        eVar.v("fileSetId", abVar.f446150a);
        eVar.v("fileId", abVar.f446151b);
        eVar.v(WadlProxyConsts.PARAM_FILENAME, abVar.f446160k);
        eVar.v("fileSize", ULong.m642boximpl(abVar.f446164o));
        eVar.t(TagName.FILE_TYPE, abVar.f446159j);
        eVar.v("saveFilePath", abVar.f446172w);
        eVar.v("uuid", abVar.f446167r.f446324a);
        eVar.v("srvFileId", abVar.f446168s);
        eVar.v("compressedFileFolderId", abVar.f446152c);
        eVar.w("isDir", abVar.f446155f);
        eg egVar = abVar.f446166q;
        if (egVar != null && (list = egVar.f446333b) != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            eq eqVar = (eq) firstOrNull;
            if (eqVar != null && (str = eqVar.f446358b) != null) {
                eVar.v("thumbnailUrl", str);
            }
        }
        eg egVar2 = abVar.f446166q;
        eVar.v("thumbnailLocalPath", egVar2 != null ? egVar2.f446334c : null);
        return eVar;
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "QQFlashTransferKuiklyModule";
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0023, code lost:
    
        if (r9 != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void shareFileSet(br brVar, Function1<? super e, Unit> function1) {
        String str;
        Object firstOrNull;
        e eVar = new e();
        eVar.v("fileSetId", brVar.f446187a);
        eVar.v("fileSetName", brVar.f446188b);
        List<es> list = brVar.f446192f;
        if (list != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            es esVar = (es) firstOrNull;
            if (esVar != null) {
                str = esVar.f446362b;
            }
        }
        str = "";
        eVar.v("uploaderName", str);
        toNative(true, "shareFileSet", eVar.toString(), function1, false);
    }
}
