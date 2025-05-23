package com.tenpay.sdk.FingerNet;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.QwLog;
import com.tenpay.sdk.basebl.TenpayBL;
import com.tenpay.sdk.paynet.Net;
import java.util.Map;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class FingerNetBase implements Net.NetListener {
    private static final String TAG = "FingerNetBase";
    protected Context mContext;
    protected WeakReference<Net.NetListener> mListenerWeak;
    protected Map<String, String> mRequestMap;

    public FingerNetBase(Context context, Map<String, String> map) {
        this.mRequestMap = null;
        this.mContext = context.getApplicationContext();
        this.mRequestMap = map;
    }

    public void execute() {
        QwLog.i("execute()");
        TenpayBL tenpayBL = new TenpayBL();
        tenpayBL.setNetListener(this);
        String str = this.mRequestMap.get("uin");
        String netUrl = getNetUrl();
        if (TextUtils.isEmpty(netUrl)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("result", true);
                onBlError(netUrl, jSONObject);
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "", e16);
                onBlError(netUrl, jSONObject);
            }
        }
        tenpayBL.doTask(this.mContext, netUrl, this.mRequestMap, null, null, str, true);
    }

    protected abstract String getNetUrl();

    @Override // com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(String str, JSONObject jSONObject) {
        Net.NetListener netListener;
        WeakReference<Net.NetListener> weakReference = this.mListenerWeak;
        if (weakReference != null && (netListener = weakReference.get()) != null) {
            netListener.onBlError(str, jSONObject);
        }
    }

    @Override // com.tenpay.sdk.paynet.Net.NetListener
    public void onError(String str, JSONObject jSONObject) {
        Net.NetListener netListener;
        WeakReference<Net.NetListener> weakReference = this.mListenerWeak;
        if (weakReference != null && (netListener = weakReference.get()) != null) {
            netListener.onError(str, jSONObject);
        }
    }

    @Override // com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(String str, JSONObject jSONObject) {
        Net.NetListener netListener;
        WeakReference<Net.NetListener> weakReference = this.mListenerWeak;
        if (weakReference != null && (netListener = weakReference.get()) != null) {
            netListener.onSuccess(str, jSONObject);
        }
    }

    public FingerNetBase(Context context, Map<String, String> map, WeakReference<Net.NetListener> weakReference) {
        this.mRequestMap = null;
        this.mContext = context.getApplicationContext();
        this.mRequestMap = map;
        this.mListenerWeak = weakReference;
    }

    public FingerNetBase(Context context) {
        this.mRequestMap = null;
        this.mContext = context.getApplicationContext();
    }
}
