package org.apache.httpcore;

import java.io.IOException;

/* compiled from: P */
/* loaded from: classes29.dex */
public class NoHttpResponseException extends IOException {
    private static final long serialVersionUID = -7658940387386078766L;

    public NoHttpResponseException(String str) {
        super(HttpException.clean(str));
    }
}
