package com.tencent.smtt.export.external.interfaces;

import android.net.http.SslCertificate;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface SslError {
    boolean addError(int i3);

    SslCertificate getCertificate();

    int getPrimaryError();

    String getUrl();

    boolean hasError(int i3);
}
