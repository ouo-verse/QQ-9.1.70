package com.tencent.guild.aio.msglist.text.util;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\u0018\u0000 \u0019*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\nB\u001f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0006R*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\t\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/guild/aio/msglist/text/util/i;", "T", "Landroidx/lifecycle/Observer;", "value", "", "onChanged", "(Ljava/lang/Object;)V", "", "d", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "c", "payload", "e", "Landroidx/lifecycle/Observer;", "getObserver", "()Landroidx/lifecycle/Observer;", "b", "(Landroidx/lifecycle/Observer;)V", "observer", "f", "mValue", "<init>", "(Ljava/lang/Object;Landroidx/lifecycle/Observer;)V", tl.h.F, "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class i<T> implements Observer<T> {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final Object f111950i = new Object();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Object payload;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Observer<T> observer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Object mValue;

    public i(@NotNull Object payload, @Nullable Observer<T> observer) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.payload = payload;
        this.observer = observer;
        this.mValue = f111950i;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final Object getPayload() {
        return this.payload;
    }

    public final void b(@Nullable Observer<T> observer) {
        this.observer = observer;
    }

    public final void c(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<set-?>");
        this.payload = obj;
    }

    @Override // androidx.lifecycle.Observer
    public void onChanged(T value) {
        this.mValue = value;
        Observer<T> observer = this.observer;
        if (observer != null) {
            observer.onChanged(value);
        }
    }
}
