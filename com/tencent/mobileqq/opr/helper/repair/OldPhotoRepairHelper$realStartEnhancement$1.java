package com.tencent.mobileqq.opr.helper.repair;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.opr.helper.repair.OldPhotoRepairHelper", f = "OldPhotoRepairHelper.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {150, 287}, m = "realStartEnhancement", n = {"this", "key", "imageInfo", "beforeUploadResultCallback", "inputBitmap", "getSrInstanceTimeStart", "this", "key", "imageInfo", "beforeUploadResultCallback", "inputBitmap", "qqOpr", "getSrInstanceStatistic"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
/* loaded from: classes16.dex */
public final class OldPhotoRepairHelper$realStartEnhancement$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OldPhotoRepairHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OldPhotoRepairHelper$realStartEnhancement$1(OldPhotoRepairHelper oldPhotoRepairHelper, Continuation<? super OldPhotoRepairHelper$realStartEnhancement$1> continuation) {
        super(continuation);
        this.this$0 = oldPhotoRepairHelper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) oldPhotoRepairHelper, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object q16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        q16 = this.this$0.q(null, null, null, null, this);
        return q16;
    }
}
