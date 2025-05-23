package com.tencent.mobileqq.mini.util;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u00020\u00002\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bJ \u0010\n\u001a\u00020\u00002\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u000bJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u0014\u0010\u0011\u001a\u00020\u00002\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\bJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u000fJ\u0006\u0010\u0017\u001a\u00020\rJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u000fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/mini/util/SimpleRequest;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "condition", "Lkotlin/Function0;", "", "failedCallBack", "Lkotlin/Function2;", "", "", "gapTime", "", "isTimeout", "logic", "max_time", "timeoutTime", "block", "gap", "maxTime", Const.BUNDLE_KEY_REQUEST, "timeout", "time", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class SimpleRequest {
    private Function0<Boolean> condition;
    private Function2<? super Integer, ? super String, Unit> failedCallBack;
    private boolean isTimeout;
    private Function0<Unit> logic;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int TIME_OUT = 1;
    private static final int OVER_MAX_TIME = 2;
    private static final int EXCEPTION = 3;
    private long timeoutTime = MiniBoxNoticeInfo.MIN_5;
    private long gapTime = 3000;
    private int max_time = 5;
    private final String TAG = "SimpleRequest";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/mini/util/SimpleRequest$Companion;", "", "()V", "EXCEPTION", "", "getEXCEPTION", "()I", "OVER_MAX_TIME", "getOVER_MAX_TIME", "TIME_OUT", "getTIME_OUT", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getEXCEPTION() {
            return SimpleRequest.EXCEPTION;
        }

        public final int getOVER_MAX_TIME() {
            return SimpleRequest.OVER_MAX_TIME;
        }

        public final int getTIME_OUT() {
            return SimpleRequest.TIME_OUT;
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void request$lambda$1(SimpleRequest this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(this$0.TAG, 1, "request timeout");
        QLog.i(this$0.TAG, 1, "2thread:" + Thread.currentThread().getId());
        if (this$0.isTimeout) {
            return;
        }
        this$0.isTimeout = true;
        Function2<? super Integer, ? super String, Unit> function2 = this$0.failedCallBack;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(TIME_OUT), "timeout");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void request$lambda$4(SimpleRequest this$0, Runnable runnable) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z17 = false;
        int i3 = 0;
        do {
            try {
                if (i3 > this$0.max_time) {
                    break;
                }
                QLog.i(this$0.TAG, 1, "request time : " + i3);
                Function0<Boolean> function0 = this$0.condition;
                Intrinsics.checkNotNull(function0);
                if (function0.invoke().booleanValue()) {
                    QLog.i(this$0.TAG, 1, "start request");
                    Function0<Unit> function02 = this$0.logic;
                    Intrinsics.checkNotNull(function02);
                    function02.invoke();
                    z16 = false;
                    z17 = true;
                    break;
                }
                LockMethodProxy.sleep(this$0.gapTime);
                i3++;
            } catch (Exception e16) {
                QLog.i(this$0.TAG, 1, "Exception:" + e16);
                Function2<? super Integer, ? super String, Unit> function2 = this$0.failedCallBack;
                if (function2 != null) {
                    function2.invoke(Integer.valueOf(EXCEPTION), e16.toString());
                }
                z16 = true;
            }
        } while (!this$0.isTimeout);
        z16 = false;
        if (!this$0.isTimeout) {
            ThreadManagerV2.removeJob(runnable, 16);
        }
        if (z17 || z16) {
            return;
        }
        QLog.i(this$0.TAG, 1, "not run");
        Function2<? super Integer, ? super String, Unit> function22 = this$0.failedCallBack;
        if (function22 != null) {
            function22.invoke(Integer.valueOf(OVER_MAX_TIME), "over max time");
        }
    }

    public final SimpleRequest condition(Function0<Boolean> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.condition = block;
        return this;
    }

    public final SimpleRequest failedCallBack(Function2<? super Integer, ? super String, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.failedCallBack = block;
        return this;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final SimpleRequest logic(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.logic = block;
        return this;
    }

    public final void request() {
        if (this.logic == null || this.condition == null) {
            return;
        }
        final Runnable executeDelay = ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.mini.util.a
            @Override // java.lang.Runnable
            public final void run() {
                SimpleRequest.request$lambda$1(SimpleRequest.this);
            }
        }, 16, null, true, this.timeoutTime);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.util.b
            @Override // java.lang.Runnable
            public final void run() {
                SimpleRequest.request$lambda$4(SimpleRequest.this, executeDelay);
            }
        }, 16, null, true);
    }

    public final SimpleRequest gap(long gapTime) {
        if (gapTime > 0) {
            this.gapTime = gapTime;
        }
        return this;
    }

    public final SimpleRequest maxTime(long maxTime) {
        if (maxTime > 0) {
            this.max_time = this.max_time;
        }
        return this;
    }

    public final SimpleRequest timeout(long time) {
        if (time > 0) {
            this.timeoutTime = time;
        }
        return this;
    }
}
