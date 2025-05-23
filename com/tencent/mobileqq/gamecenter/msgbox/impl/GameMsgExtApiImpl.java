package com.tencent.mobileqq.gamecenter.msgbox.impl;

import android.os.Bundle;
import android.view.View;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.msgbox.ApplyPartnerMsgBoxFragment;
import com.tencent.mobileqq.gamecenter.msgbox.IGameMsgExtApi;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pad.b;
import com.tencent.mobileqq.pad.i;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qzone.QZoneShareManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/msgbox/impl/GameMsgExtApiImpl;", "Lcom/tencent/mobileqq/gamecenter/msgbox/IGameMsgExtApi;", "()V", "clickApplyPartnerBox", "", "view", "Landroid/view/View;", "unreadCount", "", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class GameMsgExtApiImpl implements IGameMsgExtApi {
    @Override // com.tencent.mobileqq.gamecenter.msgbox.IGameMsgExtApi
    public void clickApplyPartnerBox(View view, long unreadCount) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        if (AppSetting.t(view.getContext())) {
            i.e(view.getContext(), new Bundle(), ApplyPartnerMsgBoxFragment.class, new b().e(false).g(true).h(LaunchMode.standard).a());
        } else {
            PublicFragmentActivity.start(view.getContext(), ApplyPartnerMsgBoxFragment.class);
        }
        if (unreadCount > 0) {
            str = "0";
        } else {
            str = "1";
        }
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(QZoneShareManager.GLORY_OF_KINGS, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9402", "92050", "928867", "", "", "20", str);
    }
}
