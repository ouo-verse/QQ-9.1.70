package com.tencent.mobileqq.guild.media.core.logic;

import com.tencent.mobileqq.guild.media.core.CommonRsp;
import com.tencent.mobileqq.guild.media.core.EnterChannelState;
import com.tencent.mobileqq.guild.media.core.data.MediaRoomStatus;
import com.tencent.mobileqq.guild.media.core.logic.MediaChannelMultiRoomHelper;
import com.tencent.mobileqq.guild.util.Logger;
import java.util.Iterator;
import java.util.List;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.media.core.logic.MediaChannelMultiRoomHelper$enterSubRoomList$1", f = "MediaChannelMultiRoomHelper.kt", i = {0, 1}, l = {379, com.tencent.luggage.wxa.v1.b.CTRL_INDEX}, m = "invokeSuspend", n = {"mainRoomState", "it"}, s = {"L$0", "L$2"})
/* loaded from: classes14.dex */
public final class MediaChannelMultiRoomHelper$enterSubRoomList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<MediaRoomStatus> $roomList;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ MediaChannelMultiRoomHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaChannelMultiRoomHelper$enterSubRoomList$1(MediaChannelMultiRoomHelper mediaChannelMultiRoomHelper, List<MediaRoomStatus> list, Continuation<? super MediaChannelMultiRoomHelper$enterSubRoomList$1> continuation) {
        super(2, continuation);
        this.this$0 = mediaChannelMultiRoomHelper;
        this.$roomList = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MediaChannelMultiRoomHelper$enterSubRoomList$1(this.this$0, this.$roomList, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0172  */
    /* JADX WARN: Type inference failed for: r12v19, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v5, types: [T, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0163 -> B:6:0x016a). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Ref.ObjectRef objectRef;
        Iterator it;
        MediaChannelMultiRoomHelper mediaChannelMultiRoomHelper;
        MediaChannelMultiRoomHelper$enterSubRoomList$1 mediaChannelMultiRoomHelper$enterSubRoomList$1;
        ?? value;
        EnterTrtcRoomReq H0;
        Object h16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    MediaRoomStatus mediaRoomStatus = (MediaRoomStatus) this.L$2;
                    Iterator it5 = (Iterator) this.L$1;
                    MediaChannelMultiRoomHelper mediaChannelMultiRoomHelper2 = (MediaChannelMultiRoomHelper) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    MediaChannelMultiRoomHelper mediaChannelMultiRoomHelper3 = mediaChannelMultiRoomHelper2;
                    Iterator it6 = it5;
                    MediaRoomStatus mediaRoomStatus2 = mediaRoomStatus;
                    Object obj2 = coroutine_suspended;
                    MediaChannelMultiRoomHelper$enterSubRoomList$1 mediaChannelMultiRoomHelper$enterSubRoomList$12 = this;
                    CommonRsp commonRsp = (CommonRsp) obj;
                    if (!commonRsp.c()) {
                        mediaChannelMultiRoomHelper3.U0(mediaRoomStatus2.getRoomStrId(), commonRsp);
                    }
                    mediaChannelMultiRoomHelper$enterSubRoomList$1 = mediaChannelMultiRoomHelper$enterSubRoomList$12;
                    coroutine_suspended = obj2;
                    it = it6;
                    mediaChannelMultiRoomHelper = mediaChannelMultiRoomHelper3;
                    if (!it.hasNext()) {
                        MediaRoomStatus mediaRoomStatus3 = (MediaRoomStatus) it.next();
                        H0 = mediaChannelMultiRoomHelper.H0(mediaRoomStatus3);
                        mediaChannelMultiRoomHelper$enterSubRoomList$1.L$0 = mediaChannelMultiRoomHelper;
                        mediaChannelMultiRoomHelper$enterSubRoomList$1.L$1 = it;
                        mediaChannelMultiRoomHelper$enterSubRoomList$1.L$2 = mediaRoomStatus3;
                        mediaChannelMultiRoomHelper$enterSubRoomList$1.label = 2;
                        h16 = mediaChannelMultiRoomHelper.h1(H0, mediaChannelMultiRoomHelper$enterSubRoomList$1);
                        if (h16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Object obj3 = coroutine_suspended;
                        mediaChannelMultiRoomHelper$enterSubRoomList$12 = mediaChannelMultiRoomHelper$enterSubRoomList$1;
                        obj = h16;
                        mediaChannelMultiRoomHelper3 = mediaChannelMultiRoomHelper;
                        it6 = it;
                        mediaRoomStatus2 = mediaRoomStatus3;
                        obj2 = obj3;
                        CommonRsp commonRsp2 = (CommonRsp) obj;
                        if (!commonRsp2.c()) {
                        }
                        mediaChannelMultiRoomHelper$enterSubRoomList$1 = mediaChannelMultiRoomHelper$enterSubRoomList$12;
                        coroutine_suspended = obj2;
                        it = it6;
                        mediaChannelMultiRoomHelper = mediaChannelMultiRoomHelper3;
                        if (!it.hasNext()) {
                            return Unit.INSTANCE;
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                objectRef = (Ref.ObjectRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
        } else {
            ResultKt.throwOnFailure(obj);
            Logger logger = Logger.f235387a;
            List<MediaRoomStatus> list = this.$roomList;
            logger.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[enterSubRoomList] roomList " + list);
            objectRef = new Ref.ObjectRef();
            objectRef.element = this.this$0.mediaChannelCore.o0().l().getValue();
            List<MediaRoomStatus> list2 = this.$roomList;
            logger.d().d("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, "[handleEnterSubRoomList] mainRoomState[" + objectRef.element + "] roomList " + list2);
            if (objectRef.element != EnterChannelState.ENTER_SUC) {
                MediaChannelMultiRoomHelper.b bVar = this.this$0.waitForMainTRTCRoom;
                if (bVar != null) {
                    bVar.a();
                }
                this.this$0.waitForMainTRTCRoom = new MediaChannelMultiRoomHelper.b(null, 1, null);
                MediaChannelMultiRoomHelper.b bVar2 = this.this$0.waitForMainTRTCRoom;
                if (bVar2 != null) {
                    this.L$0 = objectRef;
                    this.label = 1;
                    if (bVar2.b(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                value = this.this$0.mediaChannelCore.o0().l().getValue();
                objectRef.element = value;
                if (value != EnterChannelState.ENTER_SUC) {
                    Logger logger2 = Logger.f235387a;
                    Logger.b bVar3 = new Logger.b();
                    String str = "[enterSubRoomList] mainRoomState invalid. state[" + objectRef.element + " ]";
                    if (str instanceof String) {
                        bVar3.a().add(str);
                    }
                    Iterator<T> it7 = bVar3.a().iterator();
                    while (it7.hasNext()) {
                        Logger.f235387a.d().e("QGMC.MediaGroup.MediaChannelMultiRoomHelper", 1, (String) it7.next(), null);
                    }
                    return Unit.INSTANCE;
                }
            }
            this.this$0.waitForMainTRTCRoom = null;
            List<MediaRoomStatus> list3 = this.$roomList;
            MediaChannelMultiRoomHelper mediaChannelMultiRoomHelper4 = this.this$0;
            it = list3.iterator();
            mediaChannelMultiRoomHelper = mediaChannelMultiRoomHelper4;
            mediaChannelMultiRoomHelper$enterSubRoomList$1 = this;
            if (!it.hasNext()) {
            }
        }
        Unit unit = Unit.INSTANCE;
        value = this.this$0.mediaChannelCore.o0().l().getValue();
        objectRef.element = value;
        if (value != EnterChannelState.ENTER_SUC) {
        }
        this.this$0.waitForMainTRTCRoom = null;
        List<MediaRoomStatus> list32 = this.$roomList;
        MediaChannelMultiRoomHelper mediaChannelMultiRoomHelper42 = this.this$0;
        it = list32.iterator();
        mediaChannelMultiRoomHelper = mediaChannelMultiRoomHelper42;
        mediaChannelMultiRoomHelper$enterSubRoomList$1 = this;
        if (!it.hasNext()) {
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MediaChannelMultiRoomHelper$enterSubRoomList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
