package com.hihonor.push.sdk;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.common.data.ApiException;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class f1<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public n0<TResult> f36379a;

    /* renamed from: b, reason: collision with root package name */
    public final String f36380b;

    /* renamed from: c, reason: collision with root package name */
    public final IMessageEntity f36381c;

    /* renamed from: d, reason: collision with root package name */
    public final w f36382d;

    /* renamed from: e, reason: collision with root package name */
    public RequestHeader f36383e;

    public f1(String str, IMessageEntity iMessageEntity) {
        this.f36380b = str;
        this.f36381c = iMessageEntity;
        this.f36382d = w.a(str);
    }

    public abstract void a(ApiException apiException, Object obj);

    public final void b(ApiException apiException, Object obj) {
        if (this.f36379a != null) {
            a(apiException, obj);
        }
    }
}
