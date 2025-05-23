package com.tencent.local_edit.andserver.error;

import com.tencent.local_edit.andserver.http.HttpMethod;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MethodNotSupportException extends HttpException {
    private List<HttpMethod> mMethods;

    public MethodNotSupportException(HttpMethod httpMethod) {
        super(405, String.format("The request method [%s] is not supported.", httpMethod.value()));
    }

    public List<HttpMethod> getMethods() {
        return this.mMethods;
    }

    public void setMethods(List<HttpMethod> list) {
        this.mMethods = list;
    }

    public MethodNotSupportException(HttpMethod httpMethod, Throwable th5) {
        super(405, String.format("The request method [%s] is not supported.", httpMethod.value()), th5);
    }
}
