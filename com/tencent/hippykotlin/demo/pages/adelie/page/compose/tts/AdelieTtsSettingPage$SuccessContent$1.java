package com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.AdelieTtsSettingPage$SuccessContent$1", f = "AdelieTtsSettingPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdelieTtsSettingPage$SuccessContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ AdelieTtsSettingPage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieTtsSettingPage$SuccessContent$1(AdelieTtsSettingPage adelieTtsSettingPage, Continuation<? super AdelieTtsSettingPage$SuccessContent$1> continuation) {
        super(2, continuation);
        this.this$0 = adelieTtsSettingPage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdelieTtsSettingPage$SuccessContent$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AdelieTtsSettingPage$SuccessContent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        AdelieTtsSettingPage adelieTtsSettingPage = this.this$0;
        String str = adelieTtsSettingPage.getSettingParams(adelieTtsSettingPage.getPageData()).ttsId;
        AdelieTtsDataManager adelieTtsDataManager = AdelieTtsDataManager.INSTANCE;
        if (str.length() == 0) {
            str = "none_voice";
        }
        AdelieTtsInfo ttsInfoById = adelieTtsDataManager.getTtsInfoById(str);
        if (ttsInfoById != null) {
            ttsInfoById.playState$delegate.setValue(TtsPlayState.COMPLETED);
        }
        return Unit.INSTANCE;
    }
}
