package com.tencent.mobileqq.leba.business.plugins;

import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.gamecenter.api.IGameMallLebaApi;
import com.tencent.mobileqq.leba.entity.BaseLebaPluginItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@KeepClassConstructor
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0011\u001a\u00020\u000f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/LebaPluginGameMall;", "Lcom/tencent/mobileqq/leba/entity/BaseLebaPluginItem;", "", "tabChange", "", "style", "", "I", "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/leba/entity/f;", CacheTable.TABLE_NAME, "H", "", "()J", "resId", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LebaPluginGameMall extends BaseLebaPluginItem {
    static IPatchRedirector $redirector_;

    public LebaPluginGameMall() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
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
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ssConstant.MAIN\n        )");
        ((IGameMallLebaApi) QRoute.api(IGameMallLebaApi.class)).reportLebaItemClick(((IRedTouchManager) runtimeService).getAppInfoByPath(String.valueOf(item.f240505b.uiResId)), QQTheme.isNowSimpleUI());
        super.H(v3, item, reportInfo);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void I(boolean tabChange, int style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(tabChange), Integer.valueOf(style));
        } else {
            ((IGameMallLebaApi) QRoute.api(IGameMallLebaApi.class)).reportLebaItemExpose(n(), QQTheme.isNowSimpleUI());
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public long v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return 4046L;
    }
}
