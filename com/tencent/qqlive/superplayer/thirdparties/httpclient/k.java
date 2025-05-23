package com.tencent.qqlive.superplayer.thirdparties.httpclient;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f345466a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, List<String>> f345467b;

    /* renamed from: c, reason: collision with root package name */
    public final IOException f345468c;

    k(byte[] bArr, Map<String, List<String>> map) {
        this.f345466a = bArr;
        this.f345467b = map;
        this.f345468c = null;
    }

    public static k a(IOException iOException) {
        return new k(iOException);
    }

    public static k c(byte[] bArr, Map<String, List<String>> map) {
        return new k(bArr, map);
    }

    public boolean b() {
        if (this.f345468c == null) {
            return true;
        }
        return false;
    }

    k(IOException iOException) {
        this.f345466a = null;
        this.f345467b = null;
        this.f345468c = iOException;
    }
}
