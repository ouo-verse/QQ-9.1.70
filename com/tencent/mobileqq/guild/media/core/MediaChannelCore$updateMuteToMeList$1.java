package com.tencent.mobileqq.guild.media.core;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlockUserState;
import com.tencent.util.NumberUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.ae;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.core.MediaChannelCore$updateMuteToMeList$1", f = "MediaChannelCore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
final class MediaChannelCore$updateMuteToMeList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $channelId;
    final /* synthetic */ String $guildId;
    int label;
    final /* synthetic */ MediaChannelCore this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaChannelCore$updateMuteToMeList$1(String str, String str2, MediaChannelCore mediaChannelCore, Continuation<? super MediaChannelCore$updateMuteToMeList$1> continuation) {
        super(2, continuation);
        this.$guildId = str;
        this.$channelId = str2;
        this.this$0 = mediaChannelCore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MediaChannelCore mediaChannelCore, int i3, String str, IGProBlockUserState iGProBlockUserState) {
        String str2;
        boolean z16;
        n l3;
        n l16;
        ArrayList<Long> blockUserList;
        ArrayList<Long> blockUserList2;
        Logger.a d16 = Logger.f235387a.d();
        if (iGProBlockUserState != null && (blockUserList2 = iGProBlockUserState.getBlockUserList()) != null) {
            str2 = CollectionsKt___CollectionsKt.joinToString$default(blockUserList2, null, null, null, 0, null, new Function1<Long, CharSequence>() { // from class: com.tencent.mobileqq.guild.media.core.MediaChannelCore$updateMuteToMeList$1$1$1$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(Long l17) {
                    return "blockId=" + l17;
                }
            }, 31, null);
        } else {
            str2 = null;
        }
        d16.d("QGMC.Core.MediaChannelCore", 1, "updateMuteToMeList, result " + i3 + ", errMsg: " + str + ", list: " + str2);
        if (i3 == 0) {
            boolean z17 = false;
            if (iGProBlockUserState != null && (blockUserList = iGProBlockUserState.getBlockUserList()) != null && (!blockUserList.isEmpty())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                l3 = mediaChannelCore.l();
                l3.r().clear();
                l16 = mediaChannelCore.l();
                Set<Long> r16 = l16.r();
                ArrayList<Long> blockUserList3 = iGProBlockUserState.getBlockUserList();
                Intrinsics.checkNotNullExpressionValue(blockUserList3, "state.blockUserList");
                r16.addAll(blockUserList3);
                List<com.tencent.mobileqq.guild.media.core.data.p> list = mediaChannelCore.D0().f228125a;
                Intrinsics.checkNotNullExpressionValue(list, "getUserInfoList().anchors");
                ArrayList<com.tencent.mobileqq.guild.media.core.data.p> arrayList = new ArrayList();
                for (Object obj : list) {
                    if (mediaChannelCore.o0().r().contains(Long.valueOf(NumberUtil.stringToLong(((com.tencent.mobileqq.guild.media.core.data.p) obj).f228093a)))) {
                        arrayList.add(obj);
                    }
                }
                for (com.tencent.mobileqq.guild.media.core.data.p pVar : arrayList) {
                    if (!pVar.f228112t) {
                        pVar.f228112t = true;
                        z17 = true;
                    }
                }
                if (z17) {
                    for (com.tencent.mobileqq.guild.media.core.data.p pVar2 : mediaChannelCore.D0().f228125a) {
                        Intrinsics.checkNotNullExpressionValue(pVar2, "getUserInfoList().anchors");
                        com.tencent.mobileqq.guild.media.core.data.p pVar3 = pVar2;
                        if (pVar3.f228112t) {
                            mediaChannelCore.y0().muteRemoteAudio(pVar3.f228093a, true);
                        }
                    }
                    mediaChannelCore.l0().m("setUserVoicelessToMe", mediaChannelCore.getSelfUserInfo());
                }
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MediaChannelCore$updateMuteToMeList$1(this.$guildId, this.$channelId, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            IGPSService iGPSService = (IGPSService) ch.S0(IGPSService.class, "");
            long parseLong = Long.parseLong(this.$guildId);
            long parseLong2 = Long.parseLong(this.$channelId);
            final MediaChannelCore mediaChannelCore = this.this$0;
            iGPSService.fetchAudioLiveChannelBlockUserState(parseLong, parseLong2, new ae() { // from class: com.tencent.mobileqq.guild.media.core.k
                @Override // wh2.ae
                public final void a(int i3, String str, IGProBlockUserState iGProBlockUserState) {
                    MediaChannelCore$updateMuteToMeList$1.b(MediaChannelCore.this, i3, str, iGProBlockUserState);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MediaChannelCore$updateMuteToMeList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
