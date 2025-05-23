package c43;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qqgift.mvvm.business.anim.b;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.vasgift.mvvm.business.anim.DoubleBannerGiftAnimationEngineImpl;
import com.tencent.mobileqq.vasgift.mvvm.business.anim.SingleBannerGiftAnimationEngineImpl;
import com.tencent.mobileqq.vasgift.mvvm.business.view.QQGiftPanelViewImpl;
import mqq.util.WeakReference;
import nh2.c;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements ph2.a {

    /* renamed from: a, reason: collision with root package name */
    private c f30273a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<sh2.c> f30274b;

    @Override // ph2.a
    public b A(Context context, int i3) {
        if (i3 == 1) {
            return new DoubleBannerGiftAnimationEngineImpl(context, this.f30273a);
        }
        return new SingleBannerGiftAnimationEngineImpl(context, this.f30273a);
    }

    @Override // nh2.a
    public void N(c cVar) {
        this.f30273a = cVar;
    }

    @Override // ph2.a
    public nh2.b O() {
        sh2.c cVar;
        WeakReference<sh2.c> weakReference = this.f30274b;
        if (weakReference != null && (cVar = weakReference.get()) != null) {
            return cVar.n();
        }
        return null;
    }

    @Override // nh2.a
    public void destroy() {
        this.f30274b = null;
    }

    @Override // ph2.a
    public sh2.c l(FragmentActivity fragmentActivity, int i3) {
        QQGiftPanelViewImpl qQGiftPanelViewImpl;
        long currentTimeMillis = System.currentTimeMillis();
        String str = "";
        if (this.f30273a != null) {
            qQGiftPanelViewImpl = new QQGiftPanelViewImpl(fragmentActivity, this.f30273a);
            qQGiftPanelViewImpl.setPanelStyle(new com.tencent.mobileqq.qqgift.mvvm.business.data.b(true));
            this.f30274b = new WeakReference<>(qQGiftPanelViewImpl);
            com.tencent.mobileqq.qqgift.sdk.config.a sDKConfig = this.f30273a.getSDKConfig();
            if (sDKConfig != null) {
                str = String.valueOf(sDKConfig.f264972a);
            }
        } else {
            qQGiftPanelViewImpl = null;
        }
        VasPerfReportUtils.report(VasPerfReportUtils.WHILE_CREATE_PANEL, VasPerfReportUtils.WITHIN_SDK, str, "", System.currentTimeMillis() - currentTimeMillis);
        return qQGiftPanelViewImpl;
    }

    @Override // ph2.a
    public sh2.c p(FragmentActivity fragmentActivity) {
        return l(fragmentActivity, 1);
    }
}
