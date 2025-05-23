package com.tencent.robot.adelie.homepage.ugc.viewmodel;

import com.google.gson.Gson;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.homepage.download.AdelieGenerateImageRequest;
import com.tencent.robot.adelie.homepage.ugc.AdelieAvatarGenerateProgress;
import com.tencent.robot.adelie.homepage.ugc.viewmodel.AdelieUgcImageViewModel;
import d24.GenerateImageItem;
import d24.GenerateRspExtraInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowAIGCGenerate$GenerateReply;
import qshadow.ShadowAIGCGenerate$GenerateRequest;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.robot.adelie.homepage.ugc.viewmodel.AdelieUgcImageViewModel$fetchUgcImage$1", f = "AdelieUgcImageViewModel.kt", i = {}, l = {265}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class AdelieUgcImageViewModel$fetchUgcImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AdelieUgcImageViewModel.b $callback;
    final /* synthetic */ ShadowAIGCGenerate$GenerateRequest $generateReq;
    final /* synthetic */ int $id;
    int label;
    final /* synthetic */ AdelieUgcImageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdelieUgcImageViewModel$fetchUgcImage$1(AdelieUgcImageViewModel adelieUgcImageViewModel, ShadowAIGCGenerate$GenerateRequest shadowAIGCGenerate$GenerateRequest, int i3, AdelieUgcImageViewModel.b bVar, Continuation<? super AdelieUgcImageViewModel$fetchUgcImage$1> continuation) {
        super(2, continuation);
        this.this$0 = adelieUgcImageViewModel;
        this.$generateReq = shadowAIGCGenerate$GenerateRequest;
        this.$id = i3;
        this.$callback = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AdelieUgcImageViewModel$fetchUgcImage$1(this.this$0, this.$generateReq, this.$id, this.$callback, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ShadowAIGCGenerate$GenerateReply shadowAIGCGenerate$GenerateReply;
        Map map;
        Map map2;
        AdelieAvatarGenerateProgress adelieAvatarGenerateProgress;
        Map map3;
        Long l3;
        boolean z16;
        Map map4;
        Map map5;
        Map map6;
        AdelieAvatarGenerateProgress adelieAvatarGenerateProgress2;
        Map map7;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        String str = null;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            AdelieUgcImageViewModel$fetchUgcImage$1$fullReply$1 adelieUgcImageViewModel$fetchUgcImage$1$fullReply$1 = new AdelieUgcImageViewModel$fetchUgcImage$1$fullReply$1(this.$generateReq, this.this$0, null);
            this.label = 1;
            obj = TimeoutKt.withTimeout(30000L, adelieUgcImageViewModel$fetchUgcImage$1$fullReply$1, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        AdelieGenerateImageRequest.FullReply fullReply = (AdelieGenerateImageRequest.FullReply) obj;
        if (fullReply != null) {
            shadowAIGCGenerate$GenerateReply = fullReply.getDate();
        } else {
            shadowAIGCGenerate$GenerateReply = null;
        }
        boolean z17 = false;
        if (shadowAIGCGenerate$GenerateReply != null && !shadowAIGCGenerate$GenerateReply.medias.isEmpty()) {
            String str2 = shadowAIGCGenerate$GenerateReply.medias.get(0).string_data.get();
            if (str2 != null && str2.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String str3 = shadowAIGCGenerate$GenerateReply.medias.get(0).string_data.get();
                GenerateRspExtraInfo generateRspExtraInfo = (GenerateRspExtraInfo) new Gson().fromJson(shadowAIGCGenerate$GenerateReply.extra.get(), GenerateRspExtraInfo.class);
                map4 = this.this$0.mCurrentFetchingImageItems;
                AdelieUgcImageViewModel adelieUgcImageViewModel = this.this$0;
                int i16 = this.$id;
                AdelieUgcImageViewModel.b bVar = this.$callback;
                synchronized (map4) {
                    map5 = adelieUgcImageViewModel.mCurrentFetchingImageItems;
                    GenerateImageItem generateImageItem = (GenerateImageItem) map5.get(Boxing.boxInt(i16));
                    if (generateImageItem != null) {
                        QLog.i("AdelieUgcImageViewModel", 1, "fetchUgcImage id: " + i16 + " success");
                        generateImageItem.i(1);
                        generateImageItem.c().postValue(str3);
                        generateImageItem.getExtraInfo().h(generateRspExtraInfo.getWorkflow_id());
                        generateImageItem.getExtraInfo().f(generateRspExtraInfo.getSeed());
                        long currentTimeMillis = System.currentTimeMillis();
                        map6 = adelieUgcImageViewModel.mCurrentFetchingTimeStamps;
                        Object obj2 = map6.get(Boxing.boxInt(i16));
                        Intrinsics.checkNotNull(obj2);
                        QLog.i("AdelieUgcImageViewModel", 1, "[UGC-QQ-Agent][Performance] AI generate image time: " + (currentTimeMillis - ((Number) obj2).longValue()));
                        if (bVar != null) {
                            bVar.a(generateImageItem);
                        }
                        adelieAvatarGenerateProgress2 = adelieUgcImageViewModel.generateProgress;
                        map7 = adelieUgcImageViewModel.mCurrentFetchingImageItems;
                        adelieAvatarGenerateProgress2.h(new WeakReference<>(map7));
                    }
                }
                return Unit.INSTANCE;
            }
        }
        if (fullReply != null && fullReply.getErrorCode() == 0) {
            z17 = true;
        }
        if (!z17) {
            AdelieUgcImageViewModel adelieUgcImageViewModel2 = this.this$0;
            if (fullReply != null) {
                l3 = Boxing.boxLong(fullReply.getErrorCode());
            } else {
                l3 = null;
            }
            if (fullReply != null) {
                str = fullReply.getErrMsg();
            }
            adelieUgcImageViewModel2.s2(l3, str);
        }
        map = this.this$0.mCurrentFetchingImageItems;
        AdelieUgcImageViewModel adelieUgcImageViewModel3 = this.this$0;
        int i17 = this.$id;
        AdelieUgcImageViewModel.b bVar2 = this.$callback;
        synchronized (map) {
            map2 = adelieUgcImageViewModel3.mCurrentFetchingImageItems;
            GenerateImageItem generateImageItem2 = (GenerateImageItem) map2.get(Boxing.boxInt(i17));
            if (generateImageItem2 != null) {
                QLog.e("AdelieUgcImageViewModel", 1, "fetchUgcImage id: " + i17 + " failed");
                generateImageItem2.i(2);
                if (bVar2 != null) {
                    bVar2.onFailure();
                }
                adelieAvatarGenerateProgress = adelieUgcImageViewModel3.generateProgress;
                map3 = adelieUgcImageViewModel3.mCurrentFetchingImageItems;
                adelieAvatarGenerateProgress.h(new WeakReference<>(map3));
                Unit unit = Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AdelieUgcImageViewModel$fetchUgcImage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
