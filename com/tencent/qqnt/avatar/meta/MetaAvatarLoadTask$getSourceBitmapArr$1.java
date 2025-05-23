package com.tencent.qqnt.avatar.meta;

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
@DebugMetadata(c = "com.tencent.qqnt.avatar.meta.MetaAvatarLoadTask", f = "MetaAvatarLoadTask.kt", i = {0, 0, 0, 0}, l = {135}, m = "getSourceBitmapArr", n = {"this", "listener", "avatarInfoArr", "bitmapArr"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes23.dex */
public final class MetaAvatarLoadTask$getSourceBitmapArr$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MetaAvatarLoadTask this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetaAvatarLoadTask$getSourceBitmapArr$1(MetaAvatarLoadTask metaAvatarLoadTask, Continuation<? super MetaAvatarLoadTask$getSourceBitmapArr$1> continuation) {
        super(continuation);
        this.this$0 = metaAvatarLoadTask;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) metaAvatarLoadTask, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        g16 = this.this$0.g(null, null, null, this);
        return g16;
    }
}
