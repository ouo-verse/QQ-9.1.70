package com.tenpay.idverify.hint;

import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.google.gson.GsonBuilder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.browser.BrowserPlugin;
import com.tenpay.idverify.IdVerifyCommonHintVC;
import com.tenpay.idverify.hint.IdVerifyHintFragment;
import com.tenpay.idverify.model.IdVerifyStateBean;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.util.WalletGateData;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001c\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0002\u00a8\u0006\u0014"}, d2 = {"Lcom/tenpay/idverify/hint/IdVerifyWaitingGuardianProcessor;", "Lcom/tenpay/idverify/hint/IdVerifyStateProcessor;", "Lcom/tenpay/idverify/hint/IdVerifyHintFragment$ICgiAbility;", "fragment", "Lcom/tenpay/idverify/hint/IdVerifyHintFragment;", "stateBean", "Lcom/tenpay/idverify/model/IdVerifyStateBean;", "(Lcom/tenpay/idverify/hint/IdVerifyHintFragment;Lcom/tenpay/idverify/model/IdVerifyStateBean;)V", "onBlError", "", BrowserPlugin.KEY_REQUEST_URL, "", "data", "Lorg/json/JSONObject;", "onSuccess", "sendCloseRealNameRequest", "setVCData", "vc", "Lcom/tenpay/idverify/IdVerifyCommonHintVC;", "showConfirmBreakDialog", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class IdVerifyWaitingGuardianProcessor extends IdVerifyStateProcessor implements IdVerifyHintFragment.ICgiAbility {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IdVerifyWaitingGuardianProcessor(@NotNull IdVerifyHintFragment fragment, @NotNull IdVerifyStateBean stateBean) {
        super(fragment, stateBean);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(stateBean, "stateBean");
    }

    private final void sendCloseRealNameRequest() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("uin", getFragment().getCurrentUin());
        String listId = getListId();
        if (listId != null) {
            linkedHashMap.put("list_id", listId);
        }
        getFragment().httpRequest(Cgi.URI_MINORREG_CLOSE, linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setVCData$lambda$0(IdVerifyWaitingGuardianProcessor this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getFragment().exitCurrentProcess();
        WalletGateData.getInstance().clear();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setVCData$lambda$1(IdVerifyWaitingGuardianProcessor this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showConfirmBreakDialog();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void showConfirmBreakDialog() {
        QQCustomDialog createCustomDialogUrlWithoutAutoLink = DialogUtil.createCustomDialogUrlWithoutAutoLink(getFragment().getContext(), 230, R.layout.f167856jn, getFragment().getResources().getString(R.string.f2184863u), (CharSequence) null, getFragment().getResources().getString(R.string.cancel), getFragment().getResources().getString(R.string.f2184763t), new DialogInterface.OnClickListener() { // from class: com.tenpay.idverify.hint.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                IdVerifyWaitingGuardianProcessor.showConfirmBreakDialog$lambda$2(IdVerifyWaitingGuardianProcessor.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tenpay.idverify.hint.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                IdVerifyWaitingGuardianProcessor.showConfirmBreakDialog$lambda$3(dialogInterface, i3);
            }
        });
        createCustomDialogUrlWithoutAutoLink.adjustTitle();
        createCustomDialogUrlWithoutAutoLink.setTitleMutiLine();
        createCustomDialogUrlWithoutAutoLink.setCancelable(false);
        createCustomDialogUrlWithoutAutoLink.setCanceledOnTouchOutside(false);
        TextView btnight = createCustomDialogUrlWithoutAutoLink.getBtnight();
        if (btnight != null) {
            btnight.setTextColor(getFragment().getResources().getColor(R.color.bf9));
        }
        createCustomDialogUrlWithoutAutoLink.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConfirmBreakDialog$lambda$2(IdVerifyWaitingGuardianProcessor this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendCloseRealNameRequest();
    }

    @Override // com.tenpay.idverify.hint.IdVerifyHintFragment.ICgiAbility
    public void onSuccess(@Nullable String requestUrl, @Nullable JSONObject data) {
        IdVerifyHintModule.startStateBeanHint$default(getFragment(), (IdVerifyStateBean) new GsonBuilder().create().fromJson(String.valueOf(data), IdVerifyStateBean.class), 0, 4, null);
        getFragment().finish();
    }

    @Override // com.tenpay.idverify.hint.IdVerifyStateProcessor, com.tenpay.idverify.hint.IdVerifyHintFragment.IdVerifyHintProcessor
    public void setVCData(@NotNull IdVerifyCommonHintVC vc5) {
        Intrinsics.checkNotNullParameter(vc5, "vc");
        super.setVCData(vc5);
        vc5.setConfirmButton(vc5.resources().getString(R.string.f2187964o), new View.OnClickListener() { // from class: com.tenpay.idverify.hint.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IdVerifyWaitingGuardianProcessor.setVCData$lambda$0(IdVerifyWaitingGuardianProcessor.this, view);
            }
        });
        vc5.setTextLink(vc5.resources().getString(R.string.f2188464t), new View.OnClickListener() { // from class: com.tenpay.idverify.hint.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                IdVerifyWaitingGuardianProcessor.setVCData$lambda$1(IdVerifyWaitingGuardianProcessor.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConfirmBreakDialog$lambda$3(DialogInterface dialogInterface, int i3) {
    }

    @Override // com.tenpay.idverify.hint.IdVerifyHintFragment.ICgiAbility
    public void onBlError(@Nullable String requestUrl, @Nullable JSONObject data) {
    }
}
