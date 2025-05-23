package com.tenpay.sdk.paynet;

import com.tenpay.sdk.paynet.Net;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface NetSenderDelegate {
    NetSenderDelegate comeFrom(String str);

    NetSenderDelegate encrypt(boolean z16);

    void request(Net.NetListener netListener);

    NetSenderDelegate tokenID(String str);
}
