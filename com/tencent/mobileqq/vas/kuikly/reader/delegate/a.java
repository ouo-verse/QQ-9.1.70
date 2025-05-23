package com.tencent.mobileqq.vas.kuikly.reader.delegate;

import androidx.annotation.CallSuper;
import kotlin.Metadata;
import kotlin.jvm.JvmField;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0017J\b\u0010\u0004\u001a\u00020\u0002H\u0017R\u0016\u0010\b\u001a\u00020\u00058\u0004@\u0004X\u0085\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/a;", "Lcom/tencent/mobileqq/vas/kuikly/reader/delegate/e;", "", "recycle", "b", "", "a", "Z", "dirty", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public abstract class a implements e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @JvmField
    protected boolean dirty = true;

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.e
    @CallSuper
    public void b() {
        this.dirty = false;
    }

    @Override // com.tencent.mobileqq.vas.kuikly.reader.delegate.e
    @CallSuper
    public void recycle() {
        this.dirty = true;
    }
}
