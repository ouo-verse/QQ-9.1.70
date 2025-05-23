package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.qqnt.aio.adapter.api.impl.AIOChainAniStickerApiImpl", f = "AIOChainAniStickerApiImpl.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {176}, m = "preparePicAndShow", n = {"this", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "mainScope", "option", "localPath", "fileExist", "result", "serverId", "reportChatType"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"})
/* loaded from: classes34.dex */
public final class AIOChainAniStickerApiImpl$preparePicAndShow$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIOChainAniStickerApiImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOChainAniStickerApiImpl$preparePicAndShow$1(AIOChainAniStickerApiImpl aIOChainAniStickerApiImpl, Continuation<? super AIOChainAniStickerApiImpl$preparePicAndShow$1> continuation) {
        super(continuation);
        this.this$0 = aIOChainAniStickerApiImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object preparePicAndShow;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        preparePicAndShow = this.this$0.preparePicAndShow(null, null, 0, null, 0, this);
        return preparePicAndShow;
    }
}
