package com.tencent.mobileqq.leba.business.plugins;

import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.leba.entity.BaseLebaPluginItem;
import com.tencent.mobileqq.leba.entity.DefaultClickProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlivehall.iv.api.hall.IQQIvLiveEntranceApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@KeepClassConstructor
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u000f\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginLive;", "Lcom/tencent/mobileqq/leba/entity/BaseLebaPluginItem;", "", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor;", "k", "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/leba/entity/f;", CacheTable.TABLE_NAME, "H", "", "()J", "resId", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaPluginLive extends BaseLebaPluginItem {
    static IPatchRedirector $redirector_;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/leba/business/plugins/LebaPluginLive$a", "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor;", "Landroid/view/View;", "view", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/leba/entity/f;", CacheTable.TABLE_NAME, "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor$a;", "c", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a extends DefaultClickProcessor {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaPluginLive.this);
            }
        }

        @Override // com.tencent.mobileqq.leba.entity.DefaultClickProcessor
        @NotNull
        public DefaultClickProcessor.a c(@NotNull View view, @NotNull com.tencent.mobileqq.leba.entity.n item, @NotNull com.tencent.mobileqq.leba.entity.f reportInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (DefaultClickProcessor.a) iPatchRedirector.redirect((short) 2, this, view, item, reportInfo);
            }
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
            DefaultClickProcessor.a c16 = super.c(view, item, reportInfo);
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRedTouchManager.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026nt.MAIN\n                )");
            c16.z(((IQQIvLiveEntranceApi) QRoute.api(IQQIvLiveEntranceApi.class)).getLiveHallJumpUrl(item.f240505b.strGotoUrl, ((IRedTouchManager) runtimeService).getAppInfoByPath(String.valueOf(LebaPluginLive.this.v()))));
            return c16;
        }
    }

    public LebaPluginLive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void R() {
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        if (qQAppInterface != null) {
            ((IQQIvLiveEntranceApi) QRoute.api(IQQIvLiveEntranceApi.class)).dealDynamicLiveRedTouch(qQAppInterface.getApplicationContext(), qQAppInterface, n());
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void H(@NotNull View v3, @NotNull com.tencent.mobileqq.leba.entity.n item, @NotNull com.tencent.mobileqq.leba.entity.f reportInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, v3, item, reportInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        super.H(v3, item, reportInfo);
        R();
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
        return 879L;
    }
}
