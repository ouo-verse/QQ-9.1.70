package com.hihonor.push.sdk;

import android.content.Context;
import com.hihonor.push.sdk.common.data.UpMsgType;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class n implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f36412a;

    public n(s sVar) {
        this.f36412a = sVar;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        s sVar = this.f36412a;
        a0 a0Var = sVar.f36428b;
        Context context = sVar.f36427a;
        a0Var.getClass();
        try {
            d1 d1Var = new d1(UpMsgType.UNREGISTER_PUSH_TOKEN, null);
            d1Var.f36383e = b.a();
            b.a(z.f36460c.a(d1Var));
            d.f36363b.a(context, null);
            return null;
        } catch (Exception e16) {
            throw b.a(e16);
        }
    }
}
