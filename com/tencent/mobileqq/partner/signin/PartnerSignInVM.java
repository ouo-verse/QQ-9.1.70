package com.tencent.mobileqq.partner.signin;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\f8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/partner/signin/PartnerSignInVM;", "Landroidx/lifecycle/ViewModel;", "", "uin", "", "markId", "", "N1", "Lcom/tencent/mobileqq/partner/signin/b;", "signInData", "P1", "O1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "M1", "()Landroidx/lifecycle/MutableLiveData;", "todayLiveData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "L1", "signInLiveData", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class PartnerSignInVM extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<b> todayLiveData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<b> signInLiveData = new MutableLiveData<>();

    public final MutableLiveData<b> L1() {
        return this.signInLiveData;
    }

    public final MutableLiveData<b> M1() {
        return this.todayLiveData;
    }

    public final void N1(String uin, final long markId) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        BusinessHandler businessHandler = appInterface.getBusinessHandler(PartnerSignInHandler.class.getName());
        PartnerSignInHandler partnerSignInHandler = businessHandler instanceof PartnerSignInHandler ? (PartnerSignInHandler) businessHandler : null;
        if (partnerSignInHandler != null) {
            partnerSignInHandler.H2(uin, markId, new Function1<k, Unit>() { // from class: com.tencent.mobileqq.partner.signin.PartnerSignInVM$queryTodaySignIn$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(k kVar) {
                    invoke2(kVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(k signInResult) {
                    Intrinsics.checkNotNullParameter(signInResult, "signInResult");
                    b a16 = c.a(signInResult.getDetail(), signInResult.getErrCode(), markId);
                    QLog.d("PartnerSignInVM", 1, "queryTodaySignIn result markId=" + markId + " signInData=" + a16);
                    this.M1().postValue(a16);
                }
            });
        }
    }

    public final void O1(String uin, final long markId) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        BusinessHandler businessHandler = appInterface.getBusinessHandler(PartnerSignInHandler.class.getName());
        PartnerSignInHandler partnerSignInHandler = businessHandler instanceof PartnerSignInHandler ? (PartnerSignInHandler) businessHandler : null;
        if (partnerSignInHandler != null) {
            partnerSignInHandler.I2(uin, markId, "aio", new Function1<k, Unit>() { // from class: com.tencent.mobileqq.partner.signin.PartnerSignInVM$signIn$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(k kVar) {
                    invoke2(kVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(k signInResult) {
                    Intrinsics.checkNotNullParameter(signInResult, "signInResult");
                    b a16 = c.a(signInResult.getDetail(), signInResult.getErrCode(), markId);
                    QLog.d("PartnerSignInVM", 1, "signIn result markId=" + markId + " signInData=" + a16);
                    this.L1().postValue(a16);
                }
            });
        }
    }

    public final void P1(b signInData) {
        Intrinsics.checkNotNullParameter(signInData, "signInData");
        QLog.d("PartnerSignInVM", 1, "business result markId=" + signInData.f() + " signInData=" + signInData);
        this.todayLiveData.postValue(signInData);
    }
}
