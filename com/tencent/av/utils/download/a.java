package com.tencent.av.utils.download;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f77096a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, String> f77097b;

    /* renamed from: c, reason: collision with root package name */
    public int f77098c = 3;

    /* renamed from: d, reason: collision with root package name */
    public int f77099d = 5000;

    /* renamed from: e, reason: collision with root package name */
    public int f77100e = 60000;

    /* renamed from: f, reason: collision with root package name */
    public b f77101f;

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("mUrl = ");
        sb5.append(this.f77096a);
        sb5.append(",mConnectionTimeout = ");
        sb5.append(this.f77099d);
        sb5.append(",mSocketTimeout = ");
        sb5.append(this.f77100e);
        if (this.f77101f != null) {
            sb5.append(",mResult.mIsSucc = ");
            sb5.append(this.f77101f.f77107f);
            sb5.append(",mResult.mFileLength = ");
            sb5.append(this.f77101f.f77103b);
            sb5.append(",mResult.mErrCode = ");
            sb5.append(this.f77101f.f77105d);
            sb5.append(",mResult.mErrStr = ");
            sb5.append(this.f77101f.f77106e);
            sb5.append(",mResult.mTryCount = ");
            sb5.append(this.f77101f.f77108g);
            sb5.append(",mResult.mCostTime = ");
            sb5.append(this.f77101f.f77104c);
            sb5.append("ms");
        } else {
            sb5.append(",mResult = null");
        }
        return sb5.toString();
    }
}
