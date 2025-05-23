package com.tencent.rdelivery.reshub.local;

import com.tencent.raft.standard.storage.IRStorage;
import com.tencent.rdelivery.reshub.core.g;
import com.tencent.rdelivery.reshub.core.j;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0016\u0010\u000f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/rdelivery/reshub/local/d;", "", "T", "Lkotlin/Function0;", "action", "b", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lcom/tencent/raft/standard/storage/IRStorage;", "a", "Lcom/tencent/raft/standard/storage/IRStorage;", "configStorage", "", "Z", "multiProcessMode", "c", "locked", "d", "()Z", "needSync", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final boolean multiProcessMode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean locked;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final boolean needSync;

    /* renamed from: e, reason: collision with root package name */
    public static final d f364544e = new d();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final IRStorage configStorage = g.c();

    static {
        boolean R = j.L.R();
        multiProcessMode = R;
        needSync = R;
    }

    d() {
    }

    public final boolean a() {
        return needSync;
    }

    public final <T> T b(@NotNull Function0<? extends T> action) {
        Intrinsics.checkParameterIsNotNull(action, "action");
        if (multiProcessMode && !locked) {
            IRStorage iRStorage = configStorage;
            iRStorage.lock();
            try {
                locked = true;
                T invoke = action.invoke();
                locked = false;
                iRStorage.unlock();
                return invoke;
            } catch (Throwable th5) {
                locked = false;
                configStorage.unlock();
                throw th5;
            }
        }
        return action.invoke();
    }
}
