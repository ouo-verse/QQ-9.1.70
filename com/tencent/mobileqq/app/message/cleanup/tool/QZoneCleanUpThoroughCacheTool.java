package com.tencent.mobileqq.app.message.cleanup.tool;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.app.message.filescan.d;
import com.tencent.mobileqq.app.message.messageclean.y;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.utils.IQzoneOfflineCacheHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/app/message/cleanup/tool/QZoneCleanUpThoroughCacheTool;", "Lcom/tencent/mobileqq/app/message/messageclean/y;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getWhiteList", "", HippyReporter.RemoveEngineReason.CLEAR_CACHE, "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class QZoneCleanUpThoroughCacheTool implements y {
    static IPatchRedirector $redirector_;

    public QZoneCleanUpThoroughCacheTool() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public void clearCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            y.a.a(this);
            ((IQzoneOfflineCacheHelper) QRoute.api(IQzoneOfflineCacheHelper.class)).clearQZoneAppCache();
        }
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    public long getClearSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Long) iPatchRedirector.redirect((short) 4, (Object) this)).longValue();
        }
        return y.a.b(this);
    }

    @Override // com.tencent.mobileqq.app.message.messageclean.y
    @NotNull
    public ArrayList<String> getWhiteList() {
        ArrayList<String> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        d dVar = d.f195978a;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(dVar.a() + "/app_lib/QzoneVideoPlugin", dVar.a() + "/app_qzonealbum", dVar.a() + "/app_qzoneupload", dVar.a() + "/files/files/qzoneres", dVar.a() + "/files/files/qzonereszip", dVar.a() + "/files/qzone", dVar.a() + "/files/ShadowPlugin_Misc", dVar.a() + "/pic_tag_sdk", dVar.a() + "/QQ-Qzone-Android", dVar.a() + "/qzoneuploadso", dVar.a() + "/ShadowPlugin_Misc", dVar.d() + "/files/ShadowPlugin_Misc");
        return arrayListOf;
    }
}
