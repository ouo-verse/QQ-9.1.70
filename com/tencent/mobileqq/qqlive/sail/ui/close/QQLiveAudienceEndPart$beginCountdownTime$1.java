package com.tencent.mobileqq.qqlive.sail.ui.close;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.qqlive.sail.ui.close.QQLiveAudienceEndPart", f = "QQLiveAudienceEndPart.kt", i = {0, 0, 0, 0}, l = {309}, m = "beginCountdownTime", n = {"this", DownloadInfo.spKey_Config, "beginTime", "leftTime"}, s = {"L$0", "L$1", "J$0", "J$1"})
/* loaded from: classes17.dex */
public final class QQLiveAudienceEndPart$beginCountdownTime$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QQLiveAudienceEndPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveAudienceEndPart$beginCountdownTime$1(QQLiveAudienceEndPart qQLiveAudienceEndPart, Continuation<? super QQLiveAudienceEndPart$beginCountdownTime$1> continuation) {
        super(continuation);
        this.this$0 = qQLiveAudienceEndPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQLiveAudienceEndPart, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object ra5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        ra5 = this.this$0.ra(null, this);
        return ra5;
    }
}
