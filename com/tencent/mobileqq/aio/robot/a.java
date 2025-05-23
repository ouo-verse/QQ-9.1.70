package com.tencent.mobileqq.aio.robot;

import android.content.Context;
import com.tencent.aio.api.factory.j;
import com.tencent.mobileqq.aio.factory.e;
import com.tencent.mobileqq.aio.factory.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/aio/robot/a;", "Lcom/tencent/aio/api/factory/j;", "Lcom/tencent/mobileqq/aio/factory/e;", h.F, "Lcom/tencent/mobileqq/aio/robot/b;", "i", "Lcom/tencent/mobileqq/aio/factory/f;", "j", "Landroid/content/Context;", "context", "", "c", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a implements j {
    @Override // com.tencent.aio.api.factory.j
    @Nullable
    public com.tencent.aio.base.mvvm.a<Object, Object> a() {
        return j.a.b(this);
    }

    @Override // com.tencent.aio.api.factory.j
    public int c(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return com.tencent.mobileqq.aio.factory.a.a(context);
    }

    @Override // com.tencent.aio.api.factory.j
    @Nullable
    public com.tencent.aio.base.mvvm.a<Object, Object> d() {
        return j.a.a(this);
    }

    @Override // com.tencent.aio.api.factory.j
    public int e(@NotNull Context context) {
        return j.a.c(this, context);
    }

    @Override // com.tencent.aio.api.factory.h
    @Nullable
    public com.tencent.aio.api.b getLayoutDelegate() {
        return j.a.e(this);
    }

    @Override // com.tencent.aio.api.factory.j
    @NotNull
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public e b() {
        return new e(null, 1, null);
    }

    @Override // com.tencent.aio.api.factory.j
    @NotNull
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public b getViewBinder() {
        return new b();
    }

    @Override // com.tencent.aio.api.factory.j
    @NotNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public f f() {
        return f.f188791a;
    }
}
