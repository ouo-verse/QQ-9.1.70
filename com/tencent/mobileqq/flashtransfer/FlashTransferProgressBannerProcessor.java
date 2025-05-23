package com.tencent.mobileqq.flashtransfer;

import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.R;
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
public class FlashTransferProgressBannerProcessor extends BaseBannerProcessor {
    static IPatchRedirector $redirector_;
    public static final int E;
    private String C;
    private final Runnable D;

    /* renamed from: d, reason: collision with root package name */
    private String f209862d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f209863e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.biz.qui.noticebar.d f209864f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f209865h;

    /* renamed from: i, reason: collision with root package name */
    private int f209866i;

    /* renamed from: m, reason: collision with root package name */
    private String f209867m;

    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlashTransferProgressBannerProcessor.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                if (!FlashTransferProgressBannerProcessor.this.f209863e) {
                    FlashTransferTaskInfoListenerImpl.c().s(true, true, FlashTransferProgressBannerProcessor.this.f209862d);
                }
                BannerManager.l().O(FlashTransferProgressBannerProcessor.E, 0, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21983);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            E = com.tencent.mobileqq.banner.d.E;
        }
    }

    public FlashTransferProgressBannerProcessor(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity);
            return;
        }
        this.f209862d = "";
        this.f209863e = false;
        this.f209864f = null;
        this.f209865h = null;
        this.f209866i = 0;
        this.f209867m = "";
        this.C = "";
        this.D = new Runnable() { // from class: com.tencent.mobileqq.flashtransfer.FlashTransferProgressBannerProcessor.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlashTransferProgressBannerProcessor.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    if (FlashTransferProgressBannerProcessor.this.f209864f == null) {
                        return;
                    }
                    FlashTransferProgressBannerProcessor flashTransferProgressBannerProcessor = FlashTransferProgressBannerProcessor.this;
                    FlashTransferProgressBannerProcessor.this.f209864f.setMsg(flashTransferProgressBannerProcessor.p(flashTransferProgressBannerProcessor.f209865h, FlashTransferProgressBannerProcessor.this.n(), FlashTransferProgressBannerProcessor.this.f209867m, FlashTransferProgressBannerProcessor.this.C));
                }
            }
        };
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private TextView m() {
        View view;
        com.tencent.biz.qui.noticebar.d dVar = this.f209864f;
        if (dVar != null && (view = dVar.getView()) != null && (view instanceof ViewGroup)) {
            int i3 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i3 < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(i3);
                    if (childAt instanceof LinearLayout) {
                        int i16 = 0;
                        while (true) {
                            LinearLayout linearLayout = (LinearLayout) childAt;
                            if (i16 < linearLayout.getChildCount()) {
                                View childAt2 = linearLayout.getChildAt(i16);
                                if (childAt2 instanceof TextView) {
                                    TextView textView = (TextView) childAt2;
                                    if (textView.getEllipsize() == TextUtils.TruncateAt.END) {
                                        return textView;
                                    }
                                }
                                i16++;
                            }
                        }
                    }
                    i3++;
                } else {
                    return null;
                }
            }
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int n() {
        int i3 = this.f209866i;
        if (i3 > 0) {
            return i3;
        }
        TextView textView = this.f209865h;
        if (textView != null) {
            this.f209866i = (textView.getWidth() - this.f209865h.getPaddingLeft()) - this.f209865h.getPaddingRight();
        }
        return this.f209866i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(QBaseActivity qBaseActivity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).jump(qBaseActivity, ((IFlashTransferApi) QRoute.api(IFlashTransferApi.class)).getDownloadActivityScheme(this.f209862d, 11, 6));
        if (this.f209863e) {
            FlashTransferTaskInfoListenerImpl.c().s(true, false, this.f209862d);
            BannerManager.l().O(E, 0, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return E;
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
        this.f209864f = QUINoticeBarManager.l().h(baseActivity).setIcon(ie0.a.f().o(baseActivity, R.drawable.qui_fast_folder, R.color.qui_common_icon_secondary, 1000)).c(new View.OnClickListener() { // from class: com.tencent.mobileqq.flashtransfer.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FlashTransferProgressBannerProcessor.this.o(baseActivity, view);
            }
        }).k(new a());
        this.f209865h = m();
        return this.f209864f.getView();
    }

    public String p(TextView textView, int i3, String str, String str2) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, textView, Integer.valueOf(i3), str, str2);
        }
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        } else {
            str3 = " " + str2;
        }
        if (textView != null && i3 != 0) {
            return ((Object) TextUtils.ellipsize(str, textView.getPaint(), i3 - textView.getPaint().measureText(str3), TextUtils.TruncateAt.END)) + str3;
        }
        return str + str3;
    }

    @Override // com.tencent.mobileqq.banner.processor.BaseBannerProcessor, com.tencent.mobileqq.banner.processor.e
    public void updateBanner(com.tencent.mobileqq.banner.a aVar, Message message) {
        com.tencent.biz.qui.noticebar.d d16;
        Object obj;
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) message);
            return;
        }
        if (getBaseActivity() != null && (d16 = QUINoticeBarManager.l().d(aVar.f200243c)) != null && message != null && (obj = message.obj) != null) {
            Object[] objArr = (Object[]) obj;
            String str = (String) objArr[0];
            String str2 = (String) objArr[1];
            this.f209862d = (String) objArr[2];
            this.f209863e = ((Boolean) objArr[3]).booleanValue();
            this.f209867m = str;
            this.C = str2;
            int n3 = n();
            String p16 = p(this.f209865h, n3, this.f209867m, this.C);
            if (n3 == 0 && (textView = this.f209865h) != null) {
                textView.removeCallbacks(this.D);
                this.f209865h.post(this.D);
            }
            d16.setMsg(p16);
        }
    }
}
