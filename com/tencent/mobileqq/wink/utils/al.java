package com.tencent.mobileqq.wink.utils;

import com.tencent.mobileqq.wink.edit.manager.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ%\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/al;", "", "", "path", "", "throwException", "a", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class al {

    /* renamed from: a */
    @NotNull
    public static final al f326675a = new al();

    al() {
    }

    public static /* synthetic */ Object b(al alVar, String str, boolean z16, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        return alVar.a(str, z16, continuation);
    }

    @Nullable
    public final Object a(@NotNull String str, boolean z16, @NotNull Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        com.tencent.mobileqq.wink.edit.manager.g.c(str, an.f326680a.h(str), new a(cancellableContinuationImpl, z16, str));
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/utils/al$a", "Lcom/tencent/mobileqq/wink/edit/manager/g$b;", "", "imageDownLoadUrl", "", "onSuccess", "onFail", "onCancel", "", "progress", "onProgress", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements g.b {

        /* renamed from: d */
        final /* synthetic */ CancellableContinuation<String> f326676d;

        /* renamed from: e */
        final /* synthetic */ boolean f326677e;

        /* renamed from: f */
        final /* synthetic */ String f326678f;

        /* JADX WARN: Multi-variable type inference failed */
        a(CancellableContinuation<? super String> cancellableContinuation, boolean z16, String str) {
            this.f326676d = cancellableContinuation;
            this.f326677e = z16;
            this.f326678f = str;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.g.b
        public void onCancel() {
            w53.b.c("WinkEditorIpcControllerUtil", "uploadOriginImageFile " + this.f326678f + " canceled");
            if (this.f326676d.isActive() && !this.f326676d.isCancelled()) {
                if (this.f326677e) {
                    CancellableContinuation<String> cancellableContinuation = this.f326676d;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("upload cancel"))));
                    return;
                }
                this.f326676d.resumeWith(Result.m476constructorimpl(""));
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.g.b
        public void onFail() {
            w53.b.c("WinkEditorIpcControllerUtil", "uploadOriginImageFile " + this.f326678f + " failed");
            if (this.f326676d.isActive() && !this.f326676d.isCancelled()) {
                if (this.f326677e) {
                    CancellableContinuation<String> cancellableContinuation = this.f326676d;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("upload fail"))));
                    return;
                }
                this.f326676d.resumeWith(Result.m476constructorimpl(""));
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.g.b
        public void onSuccess(@Nullable String imageDownLoadUrl) {
            boolean z16;
            w53.b.a("WinkEditorIpcControllerUtil", "upload result path: " + imageDownLoadUrl);
            if (this.f326676d.isActive() && !this.f326676d.isCancelled()) {
                if (imageDownLoadUrl != null && imageDownLoadUrl.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    this.f326676d.resumeWith(Result.m476constructorimpl(imageDownLoadUrl));
                } else {
                    if (this.f326677e) {
                        CancellableContinuation<String> cancellableContinuation = this.f326676d;
                        Result.Companion companion = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("upload empty"))));
                        return;
                    }
                    this.f326676d.resumeWith(Result.m476constructorimpl(""));
                }
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.g.b
        public void onProgress(int progress) {
        }
    }
}
