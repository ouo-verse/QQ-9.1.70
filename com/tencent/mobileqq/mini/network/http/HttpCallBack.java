package com.tencent.mobileqq.mini.network.http;

import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public abstract class HttpCallBack {
    public abstract void headersReceived(int i3, Map<String, List<String>> map);

    public abstract void httpCallBack(int i3, byte[] bArr, Map<String, List<String>> map);

    public abstract void onProgressUpdate(int i3, int i16, int i17);
}
