package com.tencent.ttpic.openapi.offlineset.utils;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IResponseListener {
    public static final int STATUS_ERR = 1;
    public static final int STATUS_OK = 0;

    void response(int i3, int i16, String str, Object obj);
}
