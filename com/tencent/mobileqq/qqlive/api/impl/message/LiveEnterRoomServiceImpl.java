package com.tencent.mobileqq.qqlive.api.impl.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveEnterRoomService;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.callback.room.RoomAudienceInfoListener;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.room.BaseAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.RoomAudienceInfo;
import com.tencent.mobileqq.qqlive.utils.LiveCoroutineScopes;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/impl/message/LiveEnterRoomServiceImpl;", "Lcom/tencent/mobileqq/qqlive/api/message/IQQLiveEnterRoomService;", "", "subscribePush", "Lsq3/a;", "rsp", "notifyAudienceInfo", "Lsq3/b;", ITVKPlayerEventListener.KEY_USER_INFO, "notifyUserEnterRoom", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;", "sdkImpl", "init", "reset", "destroy", "Lcom/tencent/mobileqq/qqlive/callback/room/RoomAudienceInfoListener;", "listener", "addEnterRoomMessageListener", "delEnterRoomMessageListener", "Lcom/tencent/mobileqq/qqlive/api/room/ILiveRoom;", "room", "bindRoom", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "jobException", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlinx/coroutines/CoroutineScope;", "pushScope", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/Job;", "pushJob", "Lkotlinx/coroutines/Job;", "currentRoom", "Lcom/tencent/mobileqq/qqlive/api/room/ILiveRoom;", "sdk", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;", "Ljava/util/concurrent/CopyOnWriteArraySet;", "enterRoomReceiveListenerSet", "Ljava/util/concurrent/CopyOnWriteArraySet;", "<init>", "()V", "Companion", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class LiveEnterRoomServiceImpl implements IQQLiveEnterRoomService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String LOG_TAG = "Push|LiveEnterRoomServiceImpl";
    public static final int USER_ENTER_ROOM_OP = 1;

    @Nullable
    private ILiveRoom currentRoom;

    @NotNull
    private final CopyOnWriteArraySet<RoomAudienceInfoListener> enterRoomReceiveListenerSet;

    @NotNull
    private final CoroutineExceptionHandler jobException;

    @Nullable
    private Job pushJob;

    @NotNull
    private final CoroutineScope pushScope;

    @Nullable
    private IQQLiveSDK sdk;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/impl/message/LiveEnterRoomServiceImpl$Companion;", "", "()V", "LOG_TAG", "", "USER_ENTER_ROOM_OP", "", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31882);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LiveEnterRoomServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        LiveEnterRoomServiceImpl$special$$inlined$CoroutineExceptionHandler$1 liveEnterRoomServiceImpl$special$$inlined$CoroutineExceptionHandler$1 = new LiveEnterRoomServiceImpl$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE);
        this.jobException = liveEnterRoomServiceImpl$special$$inlined$CoroutineExceptionHandler$1;
        this.pushScope = CoroutineScopeKt.CoroutineScope(LiveCoroutineScopes.f273421a.c().plus(liveEnterRoomServiceImpl$special$$inlined$CoroutineExceptionHandler$1));
        this.enterRoomReceiveListenerSet = new CopyOnWriteArraySet<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyAudienceInfo(sq3.a rsp) {
        RoomAudienceInfo roomAudienceInfo = new RoomAudienceInfo();
        roomAudienceInfo.fakeTotalPeople = rsp.f434228j;
        sq3.c userList = rsp.f434225g;
        if (userList != null) {
            Intrinsics.checkNotNullExpressionValue(userList, "userList");
            roomAudienceInfo.userCount = userList.f434244a;
        }
        Iterator<T> it = this.enterRoomReceiveListenerSet.iterator();
        while (it.hasNext()) {
            ((RoomAudienceInfoListener) it.next()).onRecAudienceInfo(roomAudienceInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyUserEnterRoom(sq3.b userInfo) {
        BaseAnchorInfo anchorInfo;
        ILiveRoom iLiveRoom = this.currentRoom;
        if (iLiveRoom == null || (anchorInfo = iLiveRoom.getAnchorInfo()) == null || anchorInfo.getAnchorUid() == userInfo.f434233a) {
            return;
        }
        LiveMessageData.SpeakerInfo speakerInfo = new LiveMessageData.SpeakerInfo();
        speakerInfo.mSpeakId = userInfo.f434233a;
        speakerInfo.mSpeakerName = userInfo.f434238f;
        byte[] bArr = userInfo.f434241i;
        Intrinsics.checkNotNullExpressionValue(bArr, "userInfo.logoFullUrl");
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-8\")");
        speakerInfo.mLogo = new String(bArr, forName);
        speakerInfo.mClientType = userInfo.f434237e;
        speakerInfo.mBusinessUid = userInfo.f434243k;
        speakerInfo.mBusinessData = userInfo.f434240h;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isDevelopLevel()) {
            companion.d(LOG_TAG, "notifyUserEnterRoom", speakerInfo.mSpeakerName + " entered room");
        }
        Iterator<T> it = this.enterRoomReceiveListenerSet.iterator();
        while (it.hasNext()) {
            ((RoomAudienceInfoListener) it.next()).onAudienceEnterRoom(speakerInfo);
        }
    }

    private final void subscribePush() {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.pushScope, null, null, new LiveEnterRoomServiceImpl$subscribePush$1(this, null), 3, null);
        launch$default.invokeOnCompletion(LiveEnterRoomServiceImpl$subscribePush$2$1.INSTANCE);
        this.pushJob = launch$default;
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLiveEnterRoomService
    public void addEnterRoomMessageListener(@Nullable RoomAudienceInfoListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.enterRoomReceiveListenerSet.add(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLiveEnterRoomService
    public void bindRoom(@Nullable ILiveRoom room) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) room);
            return;
        }
        AegisLogger.INSTANCE.i(LOG_TAG, "bindRoom");
        Job job = this.pushJob;
        if (job != null) {
            job.cancel((CancellationException) null);
        }
        this.currentRoom = room;
        subscribePush();
    }

    @Override // com.tencent.mobileqq.qqlive.api.message.IQQLiveEnterRoomService
    public void delEnterRoomMessageListener(@Nullable RoomAudienceInfoListener listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) listener);
        } else if (listener != null) {
            this.enterRoomReceiveListenerSet.remove(listener);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i(LOG_TAG, "destroy");
        this.enterRoomReceiveListenerSet.clear();
        Job job = this.pushJob;
        if (job != null) {
            job.cancel((CancellationException) null);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(@Nullable IQQLiveSDK sdkImpl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sdkImpl);
            return;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i(LOG_TAG, "init");
        if (sdkImpl == null) {
            companion.w(LOG_TAG, "init", "invalid sdkImpl");
        } else {
            this.sdk = sdkImpl;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i(LOG_TAG, "reset");
        this.enterRoomReceiveListenerSet.clear();
        Job job = this.pushJob;
        if (job != null) {
            job.cancel((CancellationException) null);
        }
    }
}
