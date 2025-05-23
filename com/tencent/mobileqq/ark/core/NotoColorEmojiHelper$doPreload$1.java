package com.tencent.mobileqq.ark.core;

import com.tencent.ark.ArkAppPreloader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.api.IZootopiaApi;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.ark.core.NotoColorEmojiHelper$doPreload$1", f = "NotoColorEmojiHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes11.dex */
public final class NotoColorEmojiHelper$doPreload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotoColorEmojiHelper$doPreload$1(Continuation<? super NotoColorEmojiHelper$doPreload$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new NotoColorEmojiHelper$doPreload$1(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                com.tencent.rdelivery.reshub.api.i resHubInstance = ((IZootopiaApi) QRoute.api(IZootopiaApi.class)).getResHubInstance();
                com.tencent.rdelivery.reshub.api.g b16 = resHubInstance.b("ark_notoemoji_ttf", true);
                if (b16 != null && b16.e() != null) {
                    File file = new File(b16.e());
                    if (file.exists()) {
                        ArkAppPreloader.setEmojiFontBasePath(file.getCanonicalPath());
                        QLog.i("ArkApp.Emoji", 1, "setEmojiFontBasePath:" + file.getCanonicalPath());
                    }
                }
                resHubInstance.e("ark_notoemoji_ttf", NotoColorEmojiHelper.f199321a.b());
            } catch (Throwable th5) {
                QLog.e("ArkApp.Emoji", 1, "load failed for " + th5);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((NotoColorEmojiHelper$doPreload$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
