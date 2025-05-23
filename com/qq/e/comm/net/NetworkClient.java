package com.qq.e.comm.net;

import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface NetworkClient {
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = 3;
    public static final int PRIORITY_MID = 2;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface Priority {
    }

    Future<Response> submit(Request request);

    Future<Response> submit(Request request, int i3);

    Future<Response> submit(Request request, int i3, int i16);

    void submit(Request request, int i3, NetworkCallBack networkCallBack);

    void submit(Request request, int i3, NetworkCallBack networkCallBack, int i16);

    void submit(Request request, NetworkCallBack networkCallBack);
}
