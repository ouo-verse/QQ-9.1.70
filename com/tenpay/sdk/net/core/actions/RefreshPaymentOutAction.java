package com.tenpay.sdk.net.core.actions;

import com.tencent.qphone.base.util.BaseApplication;
import com.tenpay.ndk.CertUtil;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.net.core.result.NetResult;
import com.tenpay.sdk.util.QrcodePaySetting;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tenpay/sdk/net/core/actions/RefreshPaymentOutAction;", "Lcom/tenpay/sdk/net/core/actions/IByPassAction;", "Lcom/tenpay/sdk/net/core/result/NetResult;", "()V", "onBeforeCallback", "", "url", "", "result", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class RefreshPaymentOutAction implements IByPassAction<NetResult> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ArrayList<String> PAYMENT_OUT_CARE_CGI;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bR\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tenpay/sdk/net/core/actions/RefreshPaymentOutAction$Companion;", "", "()V", "PAYMENT_OUT_CARE_CGI", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "clearCode", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void clearCode() {
            boolean z16;
            QrcodePaySetting.checkPrepare();
            String string = QrcodePaySetting.getString("qrcode_pay_cid", null);
            if (string != null && string.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                CertUtil.getInstance(BaseApplication.context).clearToken(string);
            }
        }

        Companion() {
        }
    }

    static {
        ArrayList<String> arrayListOf;
        String URI_NONE_CFT_USER_AUTHEN = Cgi.URI_NONE_CFT_USER_AUTHEN;
        Intrinsics.checkNotNullExpressionValue(URI_NONE_CFT_USER_AUTHEN, "URI_NONE_CFT_USER_AUTHEN");
        String URI_QWallet_NEWUSER_DEPOSIT = Cgi.URI_QWallet_NEWUSER_DEPOSIT;
        Intrinsics.checkNotNullExpressionValue(URI_QWallet_NEWUSER_DEPOSIT, "URI_QWallet_NEWUSER_DEPOSIT");
        String URI_CFT_USER_BIND = Cgi.URI_CFT_USER_BIND;
        Intrinsics.checkNotNullExpressionValue(URI_CFT_USER_BIND, "URI_CFT_USER_BIND");
        String URI_UNBIND_BANKCARD = Cgi.URI_UNBIND_BANKCARD;
        Intrinsics.checkNotNullExpressionValue(URI_UNBIND_BANKCARD, "URI_UNBIND_BANKCARD");
        String URI_FAST_EXCUTEPAY = Cgi.URI_FAST_EXCUTEPAY;
        Intrinsics.checkNotNullExpressionValue(URI_FAST_EXCUTEPAY, "URI_FAST_EXCUTEPAY");
        String URI_QWallet_VERIFY_DEPOSIT = Cgi.URI_QWallet_VERIFY_DEPOSIT;
        Intrinsics.checkNotNullExpressionValue(URI_QWallet_VERIFY_DEPOSIT, "URI_QWallet_VERIFY_DEPOSIT");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(URI_NONE_CFT_USER_AUTHEN, URI_QWallet_NEWUSER_DEPOSIT, URI_CFT_USER_BIND, URI_UNBIND_BANKCARD, URI_FAST_EXCUTEPAY, URI_QWallet_VERIFY_DEPOSIT);
        PAYMENT_OUT_CARE_CGI = arrayListOf;
    }

    @Override // com.tenpay.sdk.net.core.actions.IByPassAction
    public void onBeforeCallback(@NotNull String url, @NotNull NetResult result) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(result, "result");
        if (!result.getIsBizSucceed()) {
            return;
        }
        ArrayList<String> arrayList = PAYMENT_OUT_CARE_CGI;
        boolean z16 = false;
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) it.next(), false, 2, (Object) null);
                if (contains$default) {
                    z16 = true;
                    break;
                }
            }
        }
        if (z16) {
            INSTANCE.clearCode();
        }
    }
}
