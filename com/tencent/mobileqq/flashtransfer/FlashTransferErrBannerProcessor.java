package com.tencent.mobileqq.flashtransfer;

import android.os.Message;
import android.view.View;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.flashtransfer.api.IFlashTransferApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

@KeepClassConstructor
/* loaded from: classes12.dex */
public class FlashTransferErrBannerProcessor extends BaseBannerProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static final int f209849e;

    /* renamed from: d, reason: collision with root package name */
    private String f209850d;

    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlashTransferErrBannerProcessor.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                FlashTransferTaskInfoListenerImpl.c().s(false, false, FlashTransferErrBannerProcessor.this.f209850d);
                BannerManager.l().O(FlashTransferErrBannerProcessor.f209849e, 0, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21700);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f209849e = com.tencent.mobileqq.banner.d.D;
        }
    }

    public FlashTransferErrBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
        } else {
            this.f209850d = "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(QBaseActivity qBaseActivity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).jump(qBaseActivity, ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).getDownloadActivityScheme(this.f209850d, 11, 6));
        FlashTransferTaskInfoListenerImpl.c().s(false, false, this.f209850d);
        BannerManager.l().O(f209849e, 0, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return f209849e;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public View initBanner(com.tencent.mobileqq.banner.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
        final QBaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return null;
        }
        return QUINoticeBarManager.l().k(baseActivity).c(new View.OnClickListener() { // from class: com.tencent.mobileqq.flashtransfer.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FlashTransferErrBannerProcessor.this.g(baseActivity, view);
            }
        }).k(new a()).getView();
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        com.tencent.biz.qui.noticebar.f f16;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        if (getBaseActivity() != null && (f16 = QUINoticeBarManager.l().f(aVar.f200243c)) != null && message != null && (obj = message.obj) != null) {
            Object[] objArr = (Object[]) obj;
            String str = (String) objArr[0];
            this.f209850d = (String) objArr[1];
            f16.setMsg(str);
        }
    }
}
