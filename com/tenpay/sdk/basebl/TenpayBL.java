package com.tenpay.sdk.basebl;

import android.content.Context;
import com.tenpay.sdk.net.NetSender;
import com.tenpay.sdk.paynet.Net;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TenpayBL {
    protected Net.NetListener mBLListener;

    public void doTask(Context context, String str, Map<String, String> map, String str2, String str3, String str4, boolean z16) {
        NetSender.with(context, str, map, str4).encrypt(z16).comeFrom(str3).tokenID(str2).request(this.mBLListener);
    }

    public void setNetListener(Net.NetListener netListener) {
        this.mBLListener = netListener;
    }
}
