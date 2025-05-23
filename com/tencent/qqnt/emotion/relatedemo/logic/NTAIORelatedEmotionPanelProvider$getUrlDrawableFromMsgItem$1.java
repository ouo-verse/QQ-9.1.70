package com.tencent.qqnt.emotion.relatedemo.logic;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.qqnt.emotion.relatedemo.logic.NTAIORelatedEmotionPanelProvider", f = "NTAIORelatedEmotionPanelProvider.kt", i = {}, l = {162}, m = "getUrlDrawableFromMsgItem", n = {}, s = {})
/* loaded from: classes24.dex */
public final class NTAIORelatedEmotionPanelProvider$getUrlDrawableFromMsgItem$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NTAIORelatedEmotionPanelProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTAIORelatedEmotionPanelProvider$getUrlDrawableFromMsgItem$1(NTAIORelatedEmotionPanelProvider nTAIORelatedEmotionPanelProvider, Continuation<? super NTAIORelatedEmotionPanelProvider$getUrlDrawableFromMsgItem$1> continuation) {
        super(continuation);
        this.this$0 = nTAIORelatedEmotionPanelProvider;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) nTAIORelatedEmotionPanelProvider, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object n3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        n3 = this.this$0.n(this);
        return n3;
    }
}
