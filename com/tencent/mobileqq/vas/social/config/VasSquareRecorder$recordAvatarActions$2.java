package com.tencent.mobileqq.vas.social.config;

import com.tencent.state.square.data.Resource;
import com.tencent.state.square.record.RecordIdentifier;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.vas.social.config.VasSquareRecorder", f = "VasSquareRecorder.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {82, 85}, m = "recordAvatarActions", n = {"this", "resource", "recordIdentifier", "forceCallback", "needAddToHead", "resource", "recordIdentifier", "dressKeys", "forceCallback", "needAddToHead"}, s = {"L$0", "L$1", "L$2", "Z$0", "Z$1", "L$0", "L$1", "L$2", "Z$0", "Z$1"})
/* loaded from: classes35.dex */
public final class VasSquareRecorder$recordAvatarActions$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VasSquareRecorder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasSquareRecorder$recordAvatarActions$2(VasSquareRecorder vasSquareRecorder, Continuation<? super VasSquareRecorder$recordAvatarActions$2> continuation) {
        super(continuation);
        this.this$0 = vasSquareRecorder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.recordAvatarActions((Resource) null, (RecordIdentifier) null, false, false, (Continuation<? super Boolean>) this);
    }
}
