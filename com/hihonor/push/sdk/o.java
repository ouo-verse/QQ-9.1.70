package com.hihonor.push.sdk;

import com.hihonor.push.framework.aidl.entity.BooleanResult;
import com.hihonor.push.sdk.common.data.UpMsgType;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class o implements Callable<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f36414a;

    public o(s sVar) {
        this.f36414a = sVar;
    }

    @Override // java.util.concurrent.Callable
    public Boolean call() throws Exception {
        this.f36414a.f36428b.getClass();
        try {
            c1 c1Var = new c1(UpMsgType.QUERY_PUSH_STATUS, null);
            c1Var.f36383e = b.a();
            return Boolean.valueOf(((BooleanResult) b.a(z.f36460c.a(c1Var))).getStatus());
        } catch (Exception e16) {
            throw b.a(e16);
        }
    }
}
