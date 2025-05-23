package com.tencent.mobileqq.wifiphoto.banner;

import android.content.Intent;
import android.os.Message;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.d;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.wifiphoto.api.IExportFileService;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@KeepClassConstructor
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wifiphoto/banner/ExportFileBannerProcessor;", "Lcom/tencent/mobileqq/banner/processor/BaseBannerProcessor;", "Lcom/tencent/mobileqq/banner/a;", "banner", "Landroid/view/View;", "initBanner", "Landroid/os/Message;", "msg", "", "updateBanner", "onAccountChanged", "", "getId", "Lcom/tencent/mobileqq/app/QBaseActivity;", PM.BASE, "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;)V", "wifiphoto_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ExportFileBannerProcessor extends BaseBannerProcessor {
    static IPatchRedirector $redirector_;

    public ExportFileBannerProcessor(@NotNull QBaseActivity base) {
        Intrinsics.checkNotNullParameter(base, "base");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) base);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(QBaseActivity activity, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(activity, "$activity");
        Intrinsics.checkNotNullParameter(v3, "v");
        HashMap hashMap = new HashMap();
        hashMap.put("smallbar_service_type", "mob_acces_com");
        String currentUid = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUid();
        Intrinsics.checkNotNullExpressionValue(currentUid, "sMobileQQ.peekAppRuntime().currentUid");
        hashMap.put("uid", currentUid);
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "sMobileQQ.peekAppRuntime().currentUin");
        hashMap.put("home_uin", currentUin);
        hashMap.put("msglist_type", 0);
        hashMap.put("click_pos", 1);
        Unit unit = Unit.INSTANCE;
        com.tencent.mobileqq.wifiphoto.data.a.j("em_bas_msglist_small_bar", "pg_bas_msglist", hashMap);
        ((IExportFileService) QRoute.api(IExportFileService.class)).enterExportFile(activity, new Intent());
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return d.f200257j;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    @Nullable
    public View initBanner(@Nullable com.tencent.mobileqq.banner.a banner) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) banner);
        }
        final QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("smallbar_service_type", "mob_acces_com");
        String currentUid = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUid();
        Intrinsics.checkNotNullExpressionValue(currentUid, "sMobileQQ.peekAppRuntime().currentUid");
        hashMap.put("uid", currentUid);
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "sMobileQQ.peekAppRuntime().currentUin");
        hashMap.put("home_uin", currentUin);
        hashMap.put("msglist_type", 0);
        hashMap.put("click_pos", 1);
        Unit unit = Unit.INSTANCE;
        com.tencent.mobileqq.wifiphoto.data.a.k("em_bas_msglist_small_bar", "pg_bas_msglist", hashMap);
        return QUINoticeBarManager.INSTANCE.a().h(baseActivity).c(new View.OnClickListener() { // from class: com.tencent.mobileqq.wifiphoto.banner.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExportFileBannerProcessor.f(QBaseActivity.this, view);
            }
        }).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            BannerManager.l().K(d.f200257j, 0);
        }
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(@NotNull com.tencent.mobileqq.banner.a banner, @Nullable Message msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) banner, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(banner, "banner");
        com.tencent.biz.qui.noticebar.d d16 = QUINoticeBarManager.INSTANCE.a().d(banner.f200243c);
        if (d16 == null) {
            return;
        }
        if (msg2 != null) {
            d16.e(msg2.what);
        }
        d16.setIcon(R.drawable.qui_folder_icon_secondary);
    }
}
