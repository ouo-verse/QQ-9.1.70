package com.tencent.mobileqq.minigame.va.banner;

import android.os.Message;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.a;
import com.tencent.mobileqq.banner.d;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.minigame.api.IMiniGameVABannerService;
import com.tencent.mobileqq.minigame.va.banner.MiniGameVAResourceBanner;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqnt.chats.core.report.DTChatsConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/banner/MiniGameVAResourceBanner;", "Lcom/tencent/mobileqq/banner/processor/BaseBannerProcessor;", "Lcom/tencent/mobileqq/banner/a;", "banner", "Landroid/view/View;", "initBanner", "", "onAccountChanged", "Landroid/os/Message;", "msg", "updateBanner", "", "getId", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "miniAppId", VirtualAppProxy.KEY_GAME_ID, "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;)V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniGameVAResourceBanner extends BaseBannerProcessor {
    private String gameId;
    private String miniAppId;
    private final String type;

    public MiniGameVAResourceBanner(QBaseActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.type = "mini_game_va_resource_banner";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBanner$lambda$1(View view) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IMiniGameVABannerService iMiniGameVABannerService = peekAppRuntime != null ? (IMiniGameVABannerService) peekAppRuntime.getRuntimeService(IMiniGameVABannerService.class, "") : null;
        if (iMiniGameVABannerService != null) {
            iMiniGameVABannerService.onBannerClose();
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        return d.C;
    }

    public final String getType() {
        return this.type;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public View initBanner(a banner) {
        QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return null;
        }
        View view = QUINoticeBarManager.INSTANCE.a().h(baseActivity).c(new View.OnClickListener() { // from class: c92.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MiniGameVAResourceBanner.initBanner$lambda$0(MiniGameVAResourceBanner.this, view2);
            }
        }).k(new View.OnClickListener() { // from class: c92.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MiniGameVAResourceBanner.initBanner$lambda$1(view2);
            }
        }).getView();
        view.setTag(DTChatsConst.f354825a.a(), this.type);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBanner$lambda$0(MiniGameVAResourceBanner this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startAppByAppid(MobileQQ.sMobileQQ, this$0.miniAppId, "", "", 2123, null);
        String str = this$0.gameId;
        if (str == null) {
            str = "";
        }
        MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "929243", "20", str, null);
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(a banner, Message msg2) {
        MiniGameVAResourceBannerInfo miniGameVAResourceBannerInfo;
        com.tencent.biz.qui.noticebar.d d16;
        if (banner == null || msg2 == null || (miniGameVAResourceBannerInfo = (MiniGameVAResourceBannerInfo) msg2.obj) == null || (d16 = QUINoticeBarManager.INSTANCE.a().d(banner.f200243c)) == null) {
            return;
        }
        d16.setMsg(miniGameVAResourceBannerInfo.getBannerStr());
        this.miniAppId = miniGameVAResourceBannerInfo.getMiniGameAppId();
        this.gameId = miniGameVAResourceBannerInfo.getGameId();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onAccountChanged() {
    }
}
