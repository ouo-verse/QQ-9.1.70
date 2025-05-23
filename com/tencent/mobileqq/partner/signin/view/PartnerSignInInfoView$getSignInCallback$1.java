package com.tencent.mobileqq.partner.signin.view;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.partner.IPartnerApi;
import com.tencent.mobileqq.partner.signin.i;
import com.tencent.mobileqq.partner.signin.j;
import com.tencent.mobileqq.partner.signin.k;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/mobileqq/partner/signin/k;", "signInResult", "", "invoke", "(Lcom/tencent/mobileqq/partner/signin/k;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class PartnerSignInInfoView$getSignInCallback$1 extends Lambda implements Function1<k, Unit> {
    final /* synthetic */ WeakReference<PartnerSignInInfoView> $infoViewRef;
    final /* synthetic */ long $markId;
    final /* synthetic */ String $partnerUin;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PartnerSignInInfoView$getSignInCallback$1(long j3, WeakReference<PartnerSignInInfoView> weakReference, String str) {
        super(1);
        this.$markId = j3;
        this.$infoViewRef = weakReference;
        this.$partnerUin = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void b(com.tencent.mobileqq.partner.signin.b signInData, WeakReference infoViewRef, String partnerUin, long j3) {
        Intrinsics.checkNotNullParameter(signInData, "$signInData");
        Intrinsics.checkNotNullParameter(infoViewRef, "$infoViewRef");
        Intrinsics.checkNotNullParameter(partnerUin, "$partnerUin");
        if (signInData.d() != 0) {
            QQToast.makeText(BaseApplication.context, 1, HardCodeUtil.qqStr(R.string.wyh), 0).show();
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String currentAccountUin = peekAppRuntime != null ? peekAppRuntime.getCurrentAccountUin() : null;
        if (currentAccountUin == null) {
            currentAccountUin = "";
        }
        PartnerSignInInfoView partnerSignInInfoView = (PartnerSignInInfoView) infoViewRef.get();
        if (partnerSignInInfoView != null) {
            partnerSignInInfoView.K0(currentAccountUin, partnerUin, signInData);
        }
        ((IPartnerApi) QRoute.api(IPartnerApi.class)).openPartnerSignInDialog(new i(partnerUin, j3, signInData, "2"));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(k kVar) {
        invoke2(kVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(k signInResult) {
        Intrinsics.checkNotNullParameter(signInResult, "signInResult");
        final com.tencent.mobileqq.partner.signin.b a16 = com.tencent.mobileqq.partner.signin.c.a(signInResult.getDetail(), signInResult.getErrCode(), this.$markId);
        QLog.d("PartnerSignInInfoView", 1, "signIn result markId=" + this.$markId + " signInData=" + a16);
        j jVar = j.f257255a;
        final WeakReference<PartnerSignInInfoView> weakReference = this.$infoViewRef;
        final String str = this.$partnerUin;
        final long j3 = this.$markId;
        jVar.d(new Runnable() { // from class: com.tencent.mobileqq.partner.signin.view.b
            @Override // java.lang.Runnable
            public final void run() {
                PartnerSignInInfoView$getSignInCallback$1.b(com.tencent.mobileqq.partner.signin.b.this, weakReference, str, j3);
            }
        });
    }
}
