package com.tencent.mobileqq.zplan.emoticon.panel.util;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil", f = "ZPlanEmoticonUtil.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {850}, m = "toResourceParam", n = {"this", "$this$toResourceParam", "uin", "mode", "priority", "generalSwitches", "currEngineType", DownloadInfo.spKey_Config, "width", "height", "reqFrom", "downloadFromNetIfLocalAbsent"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "I$0", "I$1", "I$2", "Z$0"})
/* loaded from: classes34.dex */
public final class ZPlanEmoticonUtil$toResourceParam$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ZPlanEmoticonUtil this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanEmoticonUtil$toResourceParam$1(ZPlanEmoticonUtil zPlanEmoticonUtil, Continuation<? super ZPlanEmoticonUtil$toResourceParam$1> continuation) {
        super(continuation);
        this.this$0 = zPlanEmoticonUtil;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object j06;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        j06 = this.this$0.j0(null, null, null, 0, 0, null, 0, false, this);
        return j06;
    }
}
