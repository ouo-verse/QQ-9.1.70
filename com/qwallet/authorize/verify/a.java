package com.qwallet.authorize.verify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.qwallet.authorize.AuthorizePhoneData;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.mini.servlet.MiniAppAddPhoneNumberServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.pb.QWalletAuthorize$AddReq;
import com.tencent.mobileqq.qwallet.pb.QWalletAuthorize$AddRsp;
import com.tencent.mobileqq.qwallet.pb.QWalletAuthorize$PhoneNo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.gateway.QWalletGatewayServlet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pl2.o;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B!\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/qwallet/authorize/verify/a;", "Lcom/qwallet/authorize/verify/AuthorizeBaseVerifyVC;", "", "code", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "phoneStr", "verifyCode", "", MiniAppAddPhoneNumberServlet.KEY_IS_SAVE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "t", "u", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "arguments", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "fragment", "<init>", "(Landroid/view/View;Landroid/os/Bundle;Lcom/tencent/mobileqq/base/QWalletBaseFragment;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class a extends AuthorizeBaseVerifyVC {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/qwallet/authorize/verify/a$b", "Lpl2/o;", "Lcom/tencent/mobileqq/qwallet/pb/QWalletAuthorize$AddRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes3.dex */
    public static final class b implements o<QWalletAuthorize$AddRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f41468a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f41469b;

        b(boolean z16, a aVar) {
            this.f41468a = z16;
            this.f41469b = aVar;
        }

        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull QWalletAuthorize$AddRsp rsp) {
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            QQToast.makeText(MobileQQ.sMobileQQ, 2, "\u6dfb\u52a0\u6210\u529f", 0).show();
            if (this.f41468a) {
                FragmentActivity activity = this.f41469b.getFragment().getActivity();
                if (activity != null) {
                    Intent intent = new Intent();
                    intent.putExtra("extra_key_update_phone_list", true);
                    Unit unit = Unit.INSTANCE;
                    activity.setResult(-1, intent);
                }
                this.f41469b.getFragment().finish();
            }
            QWalletAuthorize$PhoneNo qWalletAuthorize$PhoneNo = rsp.phone.get();
            String str = qWalletAuthorize$PhoneNo.mask_no.get();
            Intrinsics.checkNotNullExpressionValue(str, "phoneNo.mask_no.get()");
            String str2 = qWalletAuthorize$PhoneNo.f278700no.get();
            Intrinsics.checkNotNullExpressionValue(str2, "phoneNo.no.get()");
            String str3 = qWalletAuthorize$PhoneNo.token.get();
            Intrinsics.checkNotNullExpressionValue(str3, "phoneNo.token.get()");
            int i3 = qWalletAuthorize$PhoneNo.source.get();
            String str4 = qWalletAuthorize$PhoneNo.source_tag.get();
            Intrinsics.checkNotNullExpressionValue(str4, "phoneNo.source_tag.get()");
            AuthorizePhoneData authorizePhoneData = new AuthorizePhoneData(str, str2, str3, i3, str4, qWalletAuthorize$PhoneNo.carrier_type.get(), qWalletAuthorize$PhoneNo.state.get(), true);
            FragmentActivity activity2 = this.f41469b.getFragment().getActivity();
            if (activity2 != null) {
                Intent intent2 = new Intent();
                intent2.putExtra("extra_key_snap_phone_data", authorizePhoneData);
                Unit unit2 = Unit.INSTANCE;
                activity2.setResult(-1, intent2);
            }
            this.f41469b.getFragment().finish();
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.d(QPublicBaseFragment.TAG, 1, "requestAddPhone onFail errCode=" + errCode + " errMsg=" + errMsg);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull View view, @Nullable Bundle bundle, @NotNull QWalletBaseFragment fragment) {
        super(view, bundle, fragment);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
    }

    private final void A(String phoneStr, String verifyCode, boolean isSave) {
        QWalletAuthorize$AddReq qWalletAuthorize$AddReq = new QWalletAuthorize$AddReq();
        qWalletAuthorize$AddReq.appid.set(getAppId());
        qWalletAuthorize$AddReq.openid.set(getOpenId());
        qWalletAuthorize$AddReq.access_token.set(getAccessToken());
        qWalletAuthorize$AddReq.phone_no.set(phoneStr);
        qWalletAuthorize$AddReq.verify_code.set(verifyCode);
        qWalletAuthorize$AddReq.action.set(isSave ? 1 : 0);
        b bVar = new b(isSave, this);
        QWalletGatewayServlet qWalletGatewayServlet = QWalletGatewayServlet.INSTANCE;
        Object newInstance = QWalletAuthorize$AddRsp.class.newInstance();
        Intrinsics.checkNotNullExpressionValue(newInstance, "Rsp::class.java.newInstance()");
        qWalletGatewayServlet.sendRequest("trpc.qwallet.phonesdk.PhoneSDK", "AddPhone", qWalletAuthorize$AddReq, (MessageMicro) newInstance, false, false, false, null, bVar);
    }

    private final void z(String code) {
        String obj = getPhoneInputText().getText().toString();
        if (getLastPhoneNum() != null && Intrinsics.areEqual(getLastPhoneNum(), obj)) {
            A(obj, code, getSaveSwitch().isChecked());
        } else {
            QQToast.makeText(getFragment().getContext(), "\u53f7\u7801\u53d1\u751f\u53d8\u5316\uff0c\u8bf7\u4ece\u65b0\u83b7\u53d6\u9a8c\u8bc1\u7801", 0).show();
        }
    }

    @Override // com.qwallet.authorize.verify.AuthorizeBaseVerifyVC
    public void t() {
        String obj = getPhoneInputText().getText().toString();
        if (!r(obj)) {
            QQToast.makeText(getFragment().getContext(), "\u7535\u8bdd\u53f7\u7801\u9519\u8bef", 0).show();
            return;
        }
        x(obj);
        getSmsInputText().requestFocus();
        AuthorizeBaseVerifyVC.w(this, 0, obj, null, null, 12, null);
    }

    @Override // com.qwallet.authorize.verify.AuthorizeBaseVerifyVC
    public void u(@NotNull String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        z(code);
    }
}
