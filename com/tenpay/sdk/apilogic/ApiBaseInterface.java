package com.tenpay.sdk.apilogic;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tenpay.QwLog;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class ApiBaseInterface {
    private static final String TAG = "ApiBaseInterface";
    protected ResultReceiver callback;

    @Deprecated
    private Context mContext;
    private WeakReference<Context> mContextRef;
    private final boolean mIsStrongRef;
    protected Bundle params;
    protected String uin;

    /* JADX INFO: Access modifiers changed from: protected */
    public ApiBaseInterface(Context context, String str, Bundle bundle, ResultReceiver resultReceiver) {
        boolean isSwitchOn = ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).isSwitchOn(IQWalletUnitedConfigApi.QWALLET_APIGOTOVIEW_CONTEXT, false);
        this.mIsStrongRef = isSwitchOn;
        if (isSwitchOn) {
            this.mContext = context;
        } else {
            this.mContextRef = new WeakReference<>(context);
        }
        this.uin = str;
        this.callback = resultReceiver;
        if (resultReceiver == null) {
            this.callback = new ResultReceiver(new Handler()) { // from class: com.tenpay.sdk.apilogic.ApiBaseInterface.1
                @Override // android.os.ResultReceiver
                protected void onReceiveResult(int i3, Bundle bundle2) {
                    QwLog.i("error, no callback set...");
                }
            };
        }
        this.params = bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public Context getContext() {
        if (this.mIsStrongRef) {
            return this.mContext;
        }
        return this.mContextRef.get();
    }
}
