package com.tencent.mobileqq.qqecommerce.biz.kuikly.container;

import android.content.Context;
import android.content.ContextWrapper;
import com.qq.e.comm.managers.plugin.PM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0014J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/e;", "Landroid/content/ContextWrapper;", "Landroid/content/Context;", "getBaseContext", PM.BASE, "", "attachBaseContext", "newContext", "a", "Landroid/content/Context;", "customBaseContext", "context", "<init>", "(Landroid/content/Context;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Context customBaseContext;

    public e(Context context) {
        super(context);
        this.customBaseContext = context;
    }

    public final void a(Context newContext) {
        Intrinsics.checkNotNullParameter(newContext, "newContext");
        this.customBaseContext = newContext;
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        this.customBaseContext = base;
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        Context context = this.customBaseContext;
        return context == null ? super.getBaseContext() : context;
    }
}
