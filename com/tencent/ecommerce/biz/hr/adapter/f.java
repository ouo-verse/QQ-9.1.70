package com.tencent.ecommerce.biz.hr.adapter;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import d01.i;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/adapter/f;", "Ld01/i;", "", "tag", "msg", "", "d", "e", "i", "", "a", "()Z", "asyncLogEnable", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class f implements i {

    /* renamed from: a, reason: collision with root package name */
    public static final f f102526a = new f();

    f() {
    }

    @Override // d01.i
    public boolean a() {
        return true;
    }

    @Override // d01.i
    public void d(String tag, String msg2) {
        if (cg0.a.c()) {
            cg0.a.b(tag, msg2);
        }
    }

    @Override // d01.i
    public void e(String tag, String msg2) {
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getLogger().logError(tag, msg2);
    }

    @Override // d01.i
    public void i(String tag, String msg2) {
        cg0.a.b(tag, msg2);
    }
}
