package com.tencent.mobileqq.qqlive.api.impl.upload.bitmap;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface UploadCallback {
    public static final int ERR_EMPTY_RSP = -2;
    public static final int ERR_IO = -1;
    public static final int ERR_JSON_ERR = -3;

    void onResponse(int i3, JSONObject jSONObject);
}
