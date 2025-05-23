package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
@Beta
/* loaded from: classes2.dex */
public final class ExecutionSequencer {

    /* compiled from: P */
    /* renamed from: com.google.common.util.concurrent.ExecutionSequencer$4, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ q f35124d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ q f35125e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AtomicReference f35126f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ t f35127h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ q f35128i;
        final /* synthetic */ ExecutionSequencer this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f35124d.isDone() || (this.f35125e.isCancelled() && androidx.lifecycle.c.a(this.f35126f, RunningState.NOT_RUN, RunningState.CANCELLED))) {
                this.f35127h.F(this.f35128i);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    enum RunningState {
        NOT_RUN,
        CANCELLED,
        STARTED
    }
}
