package com.tencent.mobileqq.emoticonview.ai.emoticon;

import com.tencent.mobileqq.emoticonview.api.IEmoticonPanelIpcService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.emoticonview.ai.emoticon.AiEmoticonUploadHelper", f = "AiEmoticonUploadHelper.kt", i = {0, 0}, l = {65, 81}, m = IEmoticonPanelIpcService.ACTION_UPLOAD_PIC_AND_CHECK, n = {"this", "emojiService"}, s = {"L$0", "L$1"})
/* loaded from: classes12.dex */
public final class AiEmoticonUploadHelper$uploadPicAndCheck$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AiEmoticonUploadHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiEmoticonUploadHelper$uploadPicAndCheck$1(AiEmoticonUploadHelper aiEmoticonUploadHelper, Continuation<? super AiEmoticonUploadHelper$uploadPicAndCheck$1> continuation) {
        super(continuation);
        this.this$0 = aiEmoticonUploadHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aiEmoticonUploadHelper, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.uploadPicAndCheck(null, null, this);
    }
}
