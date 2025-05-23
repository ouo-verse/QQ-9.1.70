package com.tenpay.sdk.apilogic;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.QWalletFakeUrl;
import com.tenpay.sdk.basebl.UserInfo;
import com.tenpay.sdk.fakeurl.FakeInfo;
import com.tenpay.sdk.fakeurl.FakeUrlDialogBuilder;
import com.tenpay.sdk.fakeurl.FakeUrlHandler;
import com.tenpay.sdk.fakeurl.utils.FakeUrlUtils;
import com.tenpay.sdk.helper.PayHelper;
import com.tenpay.sdk.paynet.Net;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ApiNetListener extends Net.NetDlgAdapter {
    protected Context context;
    protected boolean errorToast;
    protected boolean showLoading;
    protected UserInfo userInfo;

    public ApiNetListener(Context context, ResultReceiver resultReceiver, UserInfo userInfo, boolean z16, boolean z17) {
        super(context, z17, resultReceiver);
        this.context = context;
        this.userInfo = userInfo;
        this.errorToast = z16;
        this.showLoading = z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onBlError$0(int i3, FakeInfo fakeInfo, FakeUrlDialogBuilder.BtnIndex btnIndex, Uri uri) {
        this.callback.send(i3, PayHelper.createResultForError(""));
        return false;
    }

    private boolean needShowDialog(Context context, final int i3, final String str) {
        boolean z16;
        if ((i3 == 156225006 || i3 == 156225007) && !TextUtils.isEmpty(str)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        QUIProxy.createCustomDialog(context, 230, null, str, "\u6211\u77e5\u9053\u4e86", null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.apilogic.ApiNetListener.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i16) {
                ((Net.NetAdapter) ApiNetListener.this).callback.send(i3, PayHelper.createResultForError(str));
            }
        });
        return true;
    }

    @Override // com.tenpay.sdk.paynet.Net.NetDlgAdapter, com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        super.onBlError(str, jSONObject);
        dismissLoading();
        final int optInt = jSONObject.optInt("retcode");
        String optString = jSONObject.optString("retmsg");
        try {
            if (QWalletFakeUrl.ignoredFakeUrl(jSONObject)) {
                this.callback.send(optInt, PayHelper.createResultForError(""));
                return;
            }
            if (needShowDialog(this.context, optInt, optString)) {
                QLog.e("ApiNetListener", 1, "need show dialog");
                return;
            }
            if (FakeUrlUtils.isUseNewFakeUrl() && new FakeUrlHandler(this.context).handle(str, jSONObject, new FakeUrlDialogBuilder.OnClickButtonListener() { // from class: com.tenpay.sdk.apilogic.b
                @Override // com.tenpay.sdk.fakeurl.FakeUrlDialogBuilder.OnClickButtonListener
                public final boolean onClickButton(FakeInfo fakeInfo, FakeUrlDialogBuilder.BtnIndex btnIndex, Uri uri) {
                    boolean lambda$onBlError$0;
                    lambda$onBlError$0 = ApiNetListener.this.lambda$onBlError$0(optInt, fakeInfo, btnIndex, uri);
                    return lambda$onBlError$0;
                }
            })) {
                QLog.e("ApiNetListener", 1, "fake dialog intercepted.");
                return;
            }
            if (this.errorToast) {
                QQToast.makeText(this.context, optString, 0).show();
            }
            this.callback.send(optInt, PayHelper.createResultForError(optString));
        } catch (Exception unused) {
            this.callback.send(optInt, PayHelper.createResultForError(optString));
        }
    }

    @Override // com.tenpay.sdk.paynet.Net.NetDlgAdapter, com.tenpay.sdk.paynet.Net.NetAdapter, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        super.onSuccess(str, jSONObject);
        dismissLoading();
        try {
            Bundle bundle = new Bundle();
            bundle.putString("retdata", jSONObject.toString());
            this.callback.send(0, bundle);
        } catch (Exception e16) {
            this.callback.send(-104, PayHelper.createResultForError(e16.getMessage()));
        }
    }
}
