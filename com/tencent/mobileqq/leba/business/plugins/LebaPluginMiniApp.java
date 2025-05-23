package com.tencent.mobileqq.leba.business.plugins;

import android.app.Activity;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.leba.entity.BaseLebaPluginItem;
import com.tencent.mobileqq.leba.entity.DefaultClickProcessor;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.minigamecenter.api.IMiniGameCenterHippyApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@KeepClassConstructor
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginMiniApp;", "Lcom/tencent/mobileqq/leba/entity/BaseLebaPluginItem;", "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor;", "k", "", "v", "()J", "resId", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaPluginMiniApp extends BaseLebaPluginItem {
    static IPatchRedirector $redirector_;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/leba/business/plugins/LebaPluginMiniApp$a", "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor$a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "g", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a extends DefaultClickProcessor {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.leba.entity.DefaultClickProcessor
        public void g(@NotNull Activity activity, @NotNull DefaultClickProcessor.a item) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) item);
                return;
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(item, "item");
            QRouteApi api = QRoute.api(IMiniAppService.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IMiniAppService::class.java)");
            IMiniAppService iMiniAppService = (IMiniAppService) api;
            if (item.k() == 2) {
                BusinessInfoCheckUpdate.AppInfo a16 = item.a();
                if (a16 != null) {
                    ((IMiniGameCenterHippyApi) QRoute.api(IMiniGameCenterHippyApi.class)).setAppInfoBuffer(a16.buffer.get());
                    ((IMiniGameCenterHippyApi) QRoute.api(IMiniGameCenterHippyApi.class)).setAppInfoTraceInfo(a16.extend.get());
                } else {
                    QLog.e("Leba.DefaultClickProcessor", 1, "jumpByActionParam miniApp url. appInfo is null");
                }
                iMiniAppService.reportMiniGameCenterDC00087("1", "969", "9044", "904401", "209626", "20", "active");
                iMiniAppService.launchMiniGameCenter(activity, "active");
                return;
            }
            super.g(activity, item);
        }
    }

    public LebaPluginMiniApp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    @NotNull
    public DefaultClickProcessor k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (DefaultClickProcessor) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public long v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return 8059L;
    }
}
