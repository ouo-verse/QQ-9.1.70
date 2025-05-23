package com.tenpay.sdk.net.core.actions;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.textpreview.BaseMenuUtil;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tenpay.sdk.net.core.request.ContextAbility;
import com.tenpay.sdk.net.core.result.NetResult;
import com.tenpay.sdk.net.utils.ExceptionUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tenpay/sdk/net/core/actions/LogicErrorAction;", "Lcom/tenpay/sdk/net/core/actions/IKeyLinkAction;", "()V", "clientLogicError", "", "", "onInterceptCallback", "", "url", "result", "Lcom/tenpay/sdk/net/core/result/NetResult;", "callback", "Lkotlin/Function0;", "", "showDialog", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class LogicErrorAction implements IKeyLinkAction {

    @NotNull
    public static final String TAG = "QWalletHttp-LogicErrorAction";

    @NotNull
    private final List<String> clientLogicError;

    public LogicErrorAction() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"-1", "-2001", "-2002", "-2003", "66201001"});
        this.clientLogicError = listOf;
    }

    private static final void onInterceptCallback$lambda$0(LogicErrorAction this$0, NetResult result, Function0 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.showDialog(result, callback);
    }

    private final void showDialog(NetResult result, final Function0<Unit> callback) {
        ContextAbility contextAbility;
        Context context;
        Object request = result.getRequest();
        if (request instanceof ContextAbility) {
            contextAbility = (ContextAbility) request;
        } else {
            contextAbility = null;
        }
        if (contextAbility != null && (context = contextAbility.getContext()) != null) {
            final QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
            qQCustomDialog.setContentView(R.layout.f167856jn);
            qQCustomDialog.setTitle("\u975e\u53d1\u5e03\u7248\u652f\u4ed8Client\u5f02\u5e38");
            qQCustomDialog.setMessageWithoutAutoLink(ExceptionUtils.INSTANCE.getStackTrace(result.getThrowable()));
            qQCustomDialog.setNegativeButton((String) null, (DialogInterface.OnClickListener) null);
            qQCustomDialog.setPositiveButton("\u70b9\u51fb\u590d\u5236\u5806\u6808", new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.net.core.actions.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    LogicErrorAction.showDialog$lambda$2$lambda$1(QQCustomDialog.this, callback, dialogInterface, i3);
                }
            });
            qQCustomDialog.setCanceledOnTouchOutside(true);
            qQCustomDialog.setCancelable(false);
            qQCustomDialog.setCanceledOnTouchOutside(false);
            qQCustomDialog.getMessageTextView().setMaxHeight(x.c(context, 300.0f));
            qQCustomDialog.getMessageTextView().setTextSize(12.0f);
            qQCustomDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDialog$lambda$2$lambda$1(QQCustomDialog this_apply, Function0 callback, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        BaseMenuUtil.copy(this_apply.getMessageTextView().getText().toString(), TAG);
        callback.invoke();
    }

    @Override // com.tenpay.sdk.net.core.actions.IKeyLinkAction
    public boolean onInterceptCallback(@NotNull String url, @NotNull NetResult result, @NotNull Function0<Unit> callback) {
        JSONObject jSONObject;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Object bizResponse = result.getBizResponse();
        String str = null;
        if (bizResponse instanceof JSONObject) {
            jSONObject = (JSONObject) bizResponse;
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            str = jSONObject.optString("retcode");
        }
        if (str == null) {
            str = "-1";
        }
        if (this.clientLogicError.contains(str)) {
            result.getThrowable();
            return false;
        }
        return false;
    }
}
