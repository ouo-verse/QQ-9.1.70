package com.tencent.qqnt.avatar.dynamic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.qqnt.avatar.dynamic.DynamicAvatarLoadTask", f = "DynamicAvatarLoadTask.kt", i = {0}, l = {67}, m = "getFile", n = {"this"}, s = {"L$0"})
/* loaded from: classes23.dex */
public final class DynamicAvatarLoadTask$getFile$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DynamicAvatarLoadTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicAvatarLoadTask$getFile$1(DynamicAvatarLoadTask dynamicAvatarLoadTask, Continuation<? super DynamicAvatarLoadTask$getFile$1> continuation) {
        super(continuation);
        this.this$0 = dynamicAvatarLoadTask;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dynamicAvatarLoadTask, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object h16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        h16 = this.this$0.h(null, null, null, this);
        return h16;
    }
}
