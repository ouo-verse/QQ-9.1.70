package com.tenpay.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.api.IApiBase;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class EnterBase<V extends IApiBase> {
    private static final String TAG = "EnterBase";
    protected V logic;

    protected abstract String enterApi();

    /* JADX INFO: Access modifiers changed from: protected */
    public V getLogic(Context context) {
        V v3 = this.logic;
        if (v3 != null) {
            return v3;
        }
        String enterApi = enterApi();
        if (!TextUtils.isEmpty(enterApi)) {
            try {
                V v16 = (V) new TenpayLoader().getObject(context, enterApi);
                this.logic = v16;
                v16.init(context);
                return this.logic;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "error msg in qqpay-api module: ", e16);
                return null;
            }
        }
        throw new RuntimeException("Error, you must specify the enter api full name!");
    }
}
