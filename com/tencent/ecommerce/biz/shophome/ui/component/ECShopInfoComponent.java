package com.tencent.ecommerce.biz.shophome.ui.component;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import com.tencent.ecommerce.base.style.service.ECPTSStyleManager;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.register.ECommerceCaptchaVerifyDialog;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent;
import com.tencent.ecommerce.biz.shophome.util.ECShopReportParams;
import com.tencent.ecommerce.repo.register.ECaptcha;
import com.tencent.ecommerce.repo.register.ECaptchaErrorCode;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 -2\u00020\u0001:\u0001\u0012B)\u0012\u0006\u0010 \u001a\u00020\u001a\u0012\b\u0010$\u001a\u0004\u0018\u00010!\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010*\u001a\u00020\u0006\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0006R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u0004\u0018\u00010!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopInfoComponent;", "Lcom/tencent/ecommerce/biz/shophome/ui/component/IECShopHomeComponent;", "Landroid/view/View;", "j", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "i", "", WadlProxyConsts.KEY_JUMP_URL, "", "l", "toastText", "g", "", "k", "getComponentView", "dataJson", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/pts/core/PTSComposer;", "a", "Lcom/tencent/pts/core/PTSComposer;", "ptsComposer", "Lcom/tencent/ecommerce/biz/register/ECommerceCaptchaVerifyDialog;", "b", "Lcom/tencent/ecommerce/biz/register/ECommerceCaptchaVerifyDialog;", "eCommerceCaptchaVerifyDialog", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "c", "Ljava/lang/ref/WeakReference;", "weakReference", "d", "Landroid/app/Activity;", "context", "Landroid/os/Bundle;", "e", "Landroid/os/Bundle;", "arguments", "Landroidx/fragment/app/FragmentManager;", "f", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Ljava/lang/String;", "shopId", "<init>", "(Landroid/app/Activity;Landroid/os/Bundle;Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", h.F, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopInfoComponent implements IECShopHomeComponent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private PTSComposer ptsComposer;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ECommerceCaptchaVerifyDialog eCommerceCaptchaVerifyDialog;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<Activity> weakReference;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Activity context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Bundle arguments;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final FragmentManager fragmentManager;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final String shopId;

    public ECShopInfoComponent(Activity activity, Bundle bundle, FragmentManager fragmentManager, String str) {
        this.context = activity;
        this.arguments = bundle;
        this.fragmentManager = fragmentManager;
        this.shopId = str;
        this.weakReference = new WeakReference<>(activity);
    }

    private final void g(String toastText) {
        ECommerceCaptchaVerifyDialog eCommerceCaptchaVerifyDialog = this.eCommerceCaptchaVerifyDialog;
        if (eCommerceCaptchaVerifyDialog != null) {
            eCommerceCaptchaVerifyDialog.dismiss();
        }
        i.f101155b.d(toastText, ECToastIcon.ICON_ERROR, 0);
    }

    private final IPTSLiteEventListener i() {
        return new ECShopInfoComponent$initPtsLiteEventListener$1(this);
    }

    private final View j() {
        PTSItemView pTSItemView = new PTSItemView(this.context);
        PTSComposer b16 = gh0.d.f402041a.b("shop_home_shop_info", ECPTSStyleManager.e("shop_home_shop_info", this.context), "", i());
        this.ptsComposer = b16;
        if (b16 != null) {
            b16.layoutToView(pTSItemView);
        }
        return pTSItemView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k(String jumpUrl) {
        String str = ECScheme.f104135d.p(Uri.parse(jumpUrl)).get("target");
        if (str == null) {
            str = "";
        }
        return Intrinsics.areEqual(str, String.valueOf(32));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(final String jumpUrl) {
        ECommerceCaptchaVerifyDialog eCommerceCaptchaVerifyDialog = new ECommerceCaptchaVerifyDialog();
        Bundle bundle = new Bundle();
        bundle.putString("appId", "2038319279");
        Unit unit = Unit.INSTANCE;
        eCommerceCaptchaVerifyDialog.setArguments(bundle);
        this.eCommerceCaptchaVerifyDialog = eCommerceCaptchaVerifyDialog;
        eCommerceCaptchaVerifyDialog.uh(this.fragmentManager, new Function1<ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult, Unit>() { // from class: com.tencent.ecommerce.biz.shophome.ui.component.ECShopInfoComponent$qualificationCaptchaVerify$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult captchaVerifyDialogResult) {
                invoke2(captchaVerifyDialogResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult captchaVerifyDialogResult) {
                if (Intrinsics.areEqual(captchaVerifyDialogResult, ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult.Cancel.f103956d)) {
                    ECShopInfoComponent.h(ECShopInfoComponent.this, null, 1, null);
                    cg0.a.b("ECShopInfoComponent", "[qualificationCaptchaVerify] captchaVerifyDialog onCanceled");
                    return;
                }
                if (Intrinsics.areEqual(captchaVerifyDialogResult, ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult.PageReady.f103957d)) {
                    cg0.a.b("ECShopInfoComponent", "[qualificationCaptchaVerify] captchaVerifyDialog PageReady");
                    return;
                }
                if (captchaVerifyDialogResult instanceof ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult.Verified) {
                    ECaptcha eCaptcha = ((ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult.Verified) captchaVerifyDialogResult).captcha;
                    if (eCaptcha.getErrorCode() == ECaptchaErrorCode.DEFAULT.getErrorCode()) {
                        if (!(eCaptcha.getTicket().length() == 0)) {
                            ECScheme.g(jumpUrl, null, 2, null);
                            cg0.a.b("ECShopInfoComponent", "[qualificationCaptchaVerify] captchaVerifyDialog onVerified");
                            return;
                        }
                    }
                    ECShopInfoComponent.h(ECShopInfoComponent.this, null, 1, null);
                    cg0.a.a("ECShopInfoComponent", "qualificationCaptchaVerify", "errorCode " + eCaptcha.getErrorCode() + ", ticket " + eCaptcha.getTicket());
                }
            }
        });
        com.tencent.ecommerce.biz.shophome.util.a aVar = com.tencent.ecommerce.biz.shophome.util.a.f104379a;
        ECShopReportParams c16 = aVar.c(this.arguments);
        aVar.j(c16.role, c16.shopId, c16.source);
    }

    @Override // com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent
    public View getComponentView() {
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, com.tencent.ecommerce.biz.util.e.c(70.0f)));
        linearLayout.setGravity(17);
        linearLayout.addView(j());
        return linearLayout;
    }

    public final void m(String dataJson) {
        PTSComposer pTSComposer = this.ptsComposer;
        if (pTSComposer != null) {
            pTSComposer.setData(dataJson);
        }
    }

    @Override // com.tencent.ecommerce.biz.shophome.ui.component.IECShopHomeComponent
    public void setComponentViewVisibility(int i3) {
        IECShopHomeComponent.a.a(this, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void h(ECShopInfoComponent eCShopInfoComponent, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "\u6821\u9a8c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
        }
        eCShopInfoComponent.g(str);
    }
}
