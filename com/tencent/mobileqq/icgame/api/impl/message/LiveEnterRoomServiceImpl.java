package com.tencent.mobileqq.icgame.api.impl.message;

import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.message.IQQLiveEnterRoomService;
import com.tencent.mobileqq.icgame.api.room.ILiveRoom;
import com.tencent.mobileqq.icgame.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.RoomAudienceInfo;
import com.tencent.mobileqq.qqlive.utils.LiveCoroutineScopes;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/impl/message/LiveEnterRoomServiceImpl;", "Lcom/tencent/mobileqq/icgame/api/message/IQQLiveEnterRoomService;", "", "subscribePush", "Lwy0/a;", "rsp", "notifyAudienceInfo", "Lwy0/b;", ITVKPlayerEventListener.KEY_USER_INFO, "notifyUserEnterRoom", "Lcom/tencent/mobileqq/icgame/api/IQQLiveSDK;", "sdkImpl", "init", "reset", "destroy", "La32/a;", "listener", "addEnterRoomMessageListener", "delEnterRoomMessageListener", "Lcom/tencent/mobileqq/icgame/api/room/ILiveRoom;", "room", "bindRoom", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "jobException", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlinx/coroutines/CoroutineScope;", "pushScope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/Job;", "pushJob", "Lkotlinx/coroutines/Job;", "currentRoom", "Lcom/tencent/mobileqq/icgame/api/room/ILiveRoom;", "sdk", "Lcom/tencent/mobileqq/icgame/api/IQQLiveSDK;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "enterRoomReceiveListenerSet", "Ljava/util/concurrent/CopyOnWriteArraySet;", "<init>", "()V", "Companion", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LiveEnterRoomServiceImpl implements IQQLiveEnterRoomService {

    @NotNull
    public static final String LOG_TAG = "ICGamePush|ICGameLiveEnterRoomServiceImpl";
    public static final int USER_ENTER_ROOM_CMD = 200;
    public static final int USER_ENTER_ROOM_OP = 1;

    @Nullable
    private ILiveRoom currentRoom;

    @NotNull
    private final CopyOnWriteArraySet<a32.a> enterRoomReceiveListenerSet;

    @NotNull
    private final CoroutineExceptionHandler jobException;

    @Nullable
    private Job pushJob;

    @NotNull
    private final CoroutineScope pushScope;

    @Nullable
    private IQQLiveSDK sdk;

    public LiveEnterRoomServiceImpl() {
        LiveEnterRoomServiceImpl$special$$inlined$CoroutineExceptionHandler$1 liveEnterRoomServiceImpl$special$$inlined$CoroutineExceptionHandler$1 = new LiveEnterRoomServiceImpl$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE);
        this.jobException = liveEnterRoomServiceImpl$special$$inlined$CoroutineExceptionHandler$1;
        this.pushScope = CoroutineScopeKt.CoroutineScope(LiveCoroutineScopes.f273421a.c().plus(liveEnterRoomServiceImpl$special$$inlined$CoroutineExceptionHandler$1));
        this.enterRoomReceiveListenerSet = new CopyOnWriteArraySet<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyAudienceInfo(wy0.a rsp) {
        RoomAudienceInfo roomAudienceInfo = new RoomAudienceInfo();
        roomAudienceInfo.fakeTotalPeople = rsp.f446721j;
        wy0.c userList = rsp.f446718g;
        if (userList != null) {
            Intrinsics.checkNotNullExpressionValue(userList, "userList");
            roomAudienceInfo.userCount = userList.f446737a;
        }
        Iterator<T> it = this.enterRoomReceiveListenerSet.iterator();
        while (it.hasNext()) {
            ((a32.a) it.next()).onRecAudienceInfo(roomAudienceInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyUserEnterRoom(wy0.b userInfo) {
        BaseAnchorInfo anchorInfo;
        ILiveRoom iLiveRoom = this.currentRoom;
        if (iLiveRoom == null || (anchorInfo = iLiveRoom.getAnchorInfo()) == null || anchorInfo.getAnchorUid() == userInfo.f446726a) {
            return;
        }
        LiveMessageData.SpeakerInfo speakerInfo = new LiveMessageData.SpeakerInfo();
        speakerInfo.mSpeakId = userInfo.f446726a;
        speakerInfo.mSpeakerName = userInfo.f446731f;
        byte[] bArr = userInfo.f446734i;
        Intrinsics.checkNotNullExpressionValue(bArr, "userInfo.logoFullUrl");
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-8\")");
        speakerInfo.mLogo = new String(bArr, forName);
        speakerInfo.mClientType = userInfo.f446730e;
        speakerInfo.mBusinessUid = userInfo.f446736k;
        speakerInfo.mBusinessData = userInfo.f446733h;
        a.Companion companion = rt0.a.INSTANCE;
        if (companion.m()) {
            companion.g(LOG_TAG, "notifyUserEnterRoom", speakerInfo.mSpeakerName + " entered room");
        }
        Iterator<T> it = this.enterRoomReceiveListenerSet.iterator();
        while (it.hasNext()) {
            ((a32.a) it.next()).a(speakerInfo);
        }
    }

    private final void subscribePush() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.pushScope, null, null, new LiveEnterRoomServiceImpl$subscribePush$1(this, null), 3, null);
        launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.icgame.api.impl.message.LiveEnterRoomServiceImpl$subscribePush$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                rt0.a.INSTANCE.k(LiveEnterRoomServiceImpl.LOG_TAG, "subscribePush", "pushJob is completed");
            }
        });
        this.pushJob = launch$default;
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLiveEnterRoomService
    public void addEnterRoomMessageListener(@Nullable a32.a listener) {
        if (listener != null) {
            this.enterRoomReceiveListenerSet.add(listener);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLiveEnterRoomService
    public void bindRoom(@Nullable ILiveRoom room) {
        rt0.a.INSTANCE.j(LOG_TAG, "bindRoom");
        Job job = this.pushJob;
        if (job != null) {
            job.cancel((CancellationException) null);
        }
        this.currentRoom = room;
        subscribePush();
    }

    @Override // com.tencent.mobileqq.icgame.api.message.IQQLiveEnterRoomService
    public void delEnterRoomMessageListener(@Nullable a32.a listener) {
        if (listener != null) {
            this.enterRoomReceiveListenerSet.remove(listener);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
        rt0.a.INSTANCE.j(LOG_TAG, "destroy");
        this.enterRoomReceiveListenerSet.clear();
        Job job = this.pushJob;
        if (job != null) {
            job.cancel((CancellationException) null);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(@Nullable IQQLiveSDK sdkImpl) {
        a.Companion companion = rt0.a.INSTANCE;
        companion.j(LOG_TAG, "init");
        if (sdkImpl == null) {
            companion.q(LOG_TAG, "init", "invalid sdkImpl");
        } else {
            this.sdk = sdkImpl;
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
        rt0.a.INSTANCE.j(LOG_TAG, "reset");
        this.enterRoomReceiveListenerSet.clear();
        Job job = this.pushJob;
        if (job != null) {
            job.cancel((CancellationException) null);
        }
    }
}
