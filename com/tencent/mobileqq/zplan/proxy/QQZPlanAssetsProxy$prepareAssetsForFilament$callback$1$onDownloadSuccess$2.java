package com.tencent.mobileqq.zplan.proxy;

import com.tencent.filament.zplan.avatar.exception.FetchFileException;
import com.tencent.filament.zplan.avatar.model.EnumUserGender;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.zplan.meme.action.MemeZPlanBaseAction;
import com.tencent.zplan.meme.model.AvatarCharacterInfo;
import cy4.ZPlanResourceBusinessData;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import wx4.PrepareAssetsStatistic;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.proxy.QQZPlanAssetsProxy$prepareAssetsForFilament$callback$1$onDownloadSuccess$2", f = "QQZPlanAssetsProxy.kt", i = {0}, l = {124}, m = "invokeSuspend", n = {"downloadStartTime"}, s = {"J$0"})
/* loaded from: classes34.dex */
final class QQZPlanAssetsProxy$prepareAssetsForFilament$callback$1$onDownloadSuccess$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MemeZPlanBaseAction $action;
    final /* synthetic */ Map<String, AvatarCharacterInfo> $avatarCharacterMap;
    final /* synthetic */ ZPlanResourceBusinessData $businessData;
    final /* synthetic */ yx4.a $listener;
    final /* synthetic */ Ref.ObjectRef<AvatarCharacterInfo> $senderAvatarInfo;
    final /* synthetic */ cy4.c $statisticData;
    final /* synthetic */ List<jx4.b> $stickerConfigList;
    final /* synthetic */ FilamentUrlTemplate $urlTemplate;
    long J$0;
    int label;
    final /* synthetic */ QQZPlanAssetsProxy this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQZPlanAssetsProxy$prepareAssetsForFilament$callback$1$onDownloadSuccess$2(Ref.ObjectRef<AvatarCharacterInfo> objectRef, MemeZPlanBaseAction memeZPlanBaseAction, QQZPlanAssetsProxy qQZPlanAssetsProxy, List<jx4.b> list, FilamentUrlTemplate filamentUrlTemplate, yx4.a aVar, cy4.c cVar, Map<String, AvatarCharacterInfo> map, ZPlanResourceBusinessData zPlanResourceBusinessData, Continuation<? super QQZPlanAssetsProxy$prepareAssetsForFilament$callback$1$onDownloadSuccess$2> continuation) {
        super(2, continuation);
        this.$senderAvatarInfo = objectRef;
        this.$action = memeZPlanBaseAction;
        this.this$0 = qQZPlanAssetsProxy;
        this.$stickerConfigList = list;
        this.$urlTemplate = filamentUrlTemplate;
        this.$listener = aVar;
        this.$statisticData = cVar;
        this.$avatarCharacterMap = map;
        this.$businessData = zPlanResourceBusinessData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQZPlanAssetsProxy$prepareAssetsForFilament$callback$1$onDownloadSuccess$2(this.$senderAvatarInfo, this.$action, this.this$0, this.$stickerConfigList, this.$urlTemplate, this.$listener, this.$statisticData, this.$avatarCharacterMap, this.$businessData, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        int i3;
        long currentTimeMillis;
        boolean z16;
        long j3;
        gx4.a character;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        try {
            if (i16 == 0) {
                ResultKt.throwOnFailure(obj);
                EnumUserGender.Companion companion = EnumUserGender.INSTANCE;
                AvatarCharacterInfo avatarCharacterInfo = this.$senderAvatarInfo.element;
                if (avatarCharacterInfo != null && (character = avatarCharacterInfo.getCharacter()) != null) {
                    i3 = character.f403750e;
                } else {
                    i3 = this.$action.getSenderInfo().get_gender();
                }
                EnumUserGender a16 = companion.a(i3);
                currentTimeMillis = System.currentTimeMillis();
                if (a16 == EnumUserGender.GENDER_UNINIT) {
                    z16 = false;
                    PrepareAssetsStatistic g16 = this.this$0.g(this.$statisticData, true, true, z16);
                    g16.c(System.currentTimeMillis() - currentTimeMillis);
                    g16.d(g16.getTotalTimeCost() + g16.getDownloadTimeCost());
                    this.$listener.onSuccess(this.$avatarCharacterMap, this.$businessData.d(), g16);
                    return Unit.INSTANCE;
                }
                QQZPlanAssetsProxy qQZPlanAssetsProxy = this.this$0;
                List<jx4.b> list = this.$stickerConfigList;
                FilamentUrlTemplate filamentUrlTemplate = this.$urlTemplate;
                this.J$0 = currentTimeMillis;
                this.label = 1;
                obj = qQZPlanAssetsProxy.d(list, a16, filamentUrlTemplate, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j3 = currentTimeMillis;
            } else if (i16 == 1) {
                j3 = this.J$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z16 = ((Boolean) obj).booleanValue();
            currentTimeMillis = j3;
            PrepareAssetsStatistic g162 = this.this$0.g(this.$statisticData, true, true, z16);
            g162.c(System.currentTimeMillis() - currentTimeMillis);
            g162.d(g162.getTotalTimeCost() + g162.getDownloadTimeCost());
            this.$listener.onSuccess(this.$avatarCharacterMap, this.$businessData.d(), g162);
            return Unit.INSTANCE;
        } catch (FetchFileException e16) {
            this.$listener.onFail(e16.getErrorCode(), e16.getErrorMessage());
            return Unit.INSTANCE;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQZPlanAssetsProxy$prepareAssetsForFilament$callback$1$onDownloadSuccess$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
