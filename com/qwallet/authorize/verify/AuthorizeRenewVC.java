package com.qwallet.authorize.verify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.qwallet.authorize.AuthorizePhoneData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/qwallet/authorize/verify/AuthorizeRenewVC;", "Lcom/qwallet/authorize/verify/AuthorizeBaseVerifyVC;", "", "code", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "t", "u", "Lcom/qwallet/authorize/AuthorizePhoneData;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/qwallet/authorize/AuthorizePhoneData;", "phoneData", "r", "Ljava/lang/String;", "sessionId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "arguments", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "fragment", "<init>", "(Landroid/view/View;Landroid/os/Bundle;Lcom/tencent/mobileqq/base/QWalletBaseFragment;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class AuthorizeRenewVC extends AuthorizeBaseVerifyVC {

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final AuthorizePhoneData phoneData;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String sessionId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthorizeRenewVC(@NotNull View view, @Nullable Bundle bundle, @NotNull QWalletBaseFragment fragment) {
        super(view, bundle, fragment);
        AuthorizePhoneData authorizePhoneData;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (bundle != null) {
            authorizePhoneData = (AuthorizePhoneData) bundle.getParcelable("KEY_VERIFY_PHONE_DATA");
        } else {
            authorizePhoneData = null;
        }
        authorizePhoneData = authorizePhoneData instanceof AuthorizePhoneData ? authorizePhoneData : null;
        this.phoneData = authorizePhoneData;
        if (bundle != null) {
            str = bundle.getString("extra_key_authorize_sessionid");
        } else {
            str = null;
        }
        this.sessionId = str;
        getAuthorizeTitle().setText(fragment.getString(R.string.z_7));
        getPhoneInputText().setClickable(false);
        getPhoneInputText().setFocusable(false);
        getPhoneInputText().setFocusableInTouchMode(false);
        getPhoneInputText().setInputType(2);
        TextView phoneInputText = getPhoneInputText();
        if (authorizePhoneData != null) {
            str2 = authorizePhoneData.getPhoneMask();
        } else {
            str2 = null;
        }
        phoneInputText.setText(str2);
        getPhoneInputText().setTextColor(fragment.getResources().getColorStateList(R.color.qui_common_text_secondary, null));
        getSaveSwitchContainer().setVisibility(8);
    }

    private final void z(String code) {
        if (this.phoneData == null) {
            return;
        }
        com.qwallet.authorize.a.f41406a.c(getAppId(), this.sessionId, code, this.phoneData, new Function1<AuthorizePhoneData, Unit>() { // from class: com.qwallet.authorize.verify.AuthorizeRenewVC$checkMsgCodeFromServer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AuthorizePhoneData authorizePhoneData) {
                invoke2(authorizePhoneData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable AuthorizePhoneData authorizePhoneData) {
                if (authorizePhoneData != null) {
                    QQToast.makeText(MobileQQ.sMobileQQ, 2, "\u9a8c\u8bc1\u6210\u529f", 0).show();
                    FragmentActivity activity = AuthorizeRenewVC.this.getFragment().getActivity();
                    if (activity != null) {
                        Intent intent = new Intent();
                        intent.putExtra("extra_key_snap_phone_data", authorizePhoneData);
                        Unit unit = Unit.INSTANCE;
                        activity.setResult(-1, intent);
                    }
                    AuthorizeRenewVC.this.getFragment().finish();
                }
            }
        });
    }

    @Override // com.qwallet.authorize.verify.AuthorizeBaseVerifyVC
    public void t() {
        String str;
        String obj = getPhoneInputText().getText().toString();
        if (!r(obj)) {
            QQToast.makeText(getFragment().getContext(), "\u7535\u8bdd\u53f7\u7801\u9519\u8bef", 0).show();
            return;
        }
        x(obj);
        getSmsInputText().requestFocus();
        AuthorizePhoneData authorizePhoneData = this.phoneData;
        if (authorizePhoneData != null) {
            str = authorizePhoneData.getToken();
        } else {
            str = null;
        }
        AuthorizeBaseVerifyVC.w(this, 1, null, obj, str, 2, null);
    }

    @Override // com.qwallet.authorize.verify.AuthorizeBaseVerifyVC
    public void u(@NotNull String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        z(code);
    }
}
