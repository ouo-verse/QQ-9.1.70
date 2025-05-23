package com.tenpay.sdk.net.core.actions;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.net.core.request.ContextAbility;
import com.tenpay.sdk.net.core.result.NetResult;
import java.security.cert.CertificateException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tenpay/sdk/net/core/actions/CertUpgradeAction;", "Lcom/tenpay/sdk/net/core/actions/IByPassAction;", "Lcom/tenpay/sdk/net/core/result/NetResult;", "()V", "onBeforeCallback", "", "url", "", "result", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class CertUpgradeAction implements IByPassAction<NetResult> {

    @NotNull
    public static final String TAG = "QWalletHttp-CertUpgradeAction";

    @Override // com.tenpay.sdk.net.core.actions.IByPassAction
    public void onBeforeCallback(@NotNull String url, @NotNull NetResult result) {
        ContextAbility contextAbility;
        Context context;
        Activity activity;
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.getThrowable() instanceof CertificateException) {
            QLog.w(TAG, 1, "hint CertificateException dialog");
            Object request = result.getRequest();
            Activity activity2 = null;
            if (request instanceof ContextAbility) {
                contextAbility = (ContextAbility) request;
            } else {
                contextAbility = null;
            }
            if (contextAbility != null && (context = contextAbility.getContext()) != null) {
                boolean z18 = context instanceof Activity;
                if (z18) {
                    activity = (Activity) context;
                } else {
                    activity = null;
                }
                if (activity != null && activity.isFinishing()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    if (z18) {
                        activity2 = (Activity) context;
                    }
                    if (activity2 != null && activity2.isDestroyed()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        QQToast.makeText(context, "\u8bc1\u4e66\u5f02\u5e38\uff0c\u8bf7\u5347\u7ea7QQ\u7248\u672c\uff01", 0).show();
                        return;
                    }
                }
                QLog.w(TAG, 1, "context is finishing or isDestroyed");
            }
        }
    }
}
