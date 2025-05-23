package com.tencent.mobileqq.qqlive.api.player.impl;

import android.os.Handler;
import br4.b;
import br4.c;
import br4.d;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.player.IPlayerChangeUrlManager;
import com.tencent.mobileqq.qqlive.api.player.PlayerDefinitionKt;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.data.room.EnterRoomInfo;
import com.tencent.mobileqq.qqlive.sso.request.GetRoomPlayRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ\u0010\u0010\u0010\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/player/impl/PlayerChangeUrlModel;", "", "", "doRequestChangeUrl", "", "getMaxRetryTimes", "Lbr4/d;", "roomInfo", "printLog", "Lcom/tencent/mobileqq/qqlive/data/room/EnterRoomInfo$VideoDefinition;", "targetDefinition", "", "getUrl", "Lcom/tencent/mobileqq/qqlive/api/player/IPlayerChangeUrlManager$Callback;", "callback", "getChangedUrl", "getUrlByDefinition", "", "roomId", "J", "retryCounter", "I", "Lbr4/d;", "Lcom/tencent/mobileqq/qqlive/api/player/IPlayerChangeUrlManager$Callback;", "Ljava/lang/Runnable;", "retryRequestRunnable", "Ljava/lang/Runnable;", "<init>", "(J)V", "Companion", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class PlayerChangeUrlModel {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int DEFAULT_RETRY_TIMES = 1;

    @NotNull
    private static final String TAG = "QQLive_Player|PlayerChangeUrlModel";

    @Nullable
    private IPlayerChangeUrlManager.Callback callback;
    private int retryCounter;

    @NotNull
    private final Runnable retryRequestRunnable;
    private final long roomId;

    @Nullable
    private d roomInfo;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/player/impl/PlayerChangeUrlModel$Companion;", "", "()V", "DEFAULT_RETRY_TIMES", "", "TAG", "", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42960);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[EnterRoomInfo.VideoDefinition.values().length];
            try {
                iArr[EnterRoomInfo.VideoDefinition.SD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnterRoomInfo.VideoDefinition.HD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnterRoomInfo.VideoDefinition.SHD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnterRoomInfo.VideoDefinition.FHD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42975);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PlayerChangeUrlModel(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, j3);
        } else {
            this.roomId = j3;
            this.retryRequestRunnable = new Runnable() { // from class: com.tencent.mobileqq.qqlive.api.player.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    PlayerChangeUrlModel.retryRequestRunnable$lambda$1(PlayerChangeUrlModel.this);
                }
            };
        }
    }

    private final void doRequestChangeUrl() {
        AegisLogger.INSTANCE.i(TAG, "doRequestChangeUrl", "roomId:" + this.roomId + ", retry:" + this.retryCounter);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new GetRoomPlayRequest(new long[]{this.roomId}, 0), new Function1<QQLiveResponse<b>, Unit>() { // from class: com.tencent.mobileqq.qqlive.api.player.impl.PlayerChangeUrlModel$doRequestChangeUrl$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PlayerChangeUrlModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<b> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<b> rsp) {
                IPlayerChangeUrlManager.Callback callback;
                d[] dVarArr;
                long j3;
                IPlayerChangeUrlManager.Callback callback2;
                d[] dVarArr2;
                IPlayerChangeUrlManager.Callback callback3;
                int i3;
                int maxRetryTimes;
                int i16;
                Runnable runnable;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
                    return;
                }
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                b rsp2 = rsp.getRsp();
                boolean z16 = rsp.isFailed() || rsp2 == null;
                if (z16) {
                    AegisLogger.INSTANCE.i("QQLive_Player|PlayerChangeUrlModel", "retCode:" + rsp.getRetCode() + ", errMsg:" + rsp.getErrMsg());
                    i3 = PlayerChangeUrlModel.this.retryCounter;
                    maxRetryTimes = PlayerChangeUrlModel.this.getMaxRetryTimes();
                    if (i3 < maxRetryTimes) {
                        PlayerChangeUrlModel playerChangeUrlModel = PlayerChangeUrlModel.this;
                        i16 = playerChangeUrlModel.retryCounter;
                        playerChangeUrlModel.retryCounter = i16 + 1;
                        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                        runnable = PlayerChangeUrlModel.this.retryRequestRunnable;
                        uIHandlerV2.post(runnable);
                        return;
                    }
                }
                PlayerChangeUrlModel.this.retryCounter = 0;
                if (z16) {
                    callback3 = PlayerChangeUrlModel.this.callback;
                    if (callback3 != null) {
                        long retCode = rsp.getRetCode();
                        String errMsg = rsp.getErrMsg();
                        if (errMsg == null) {
                            errMsg = "";
                        }
                        callback3.onError(retCode, errMsg);
                        return;
                    }
                    return;
                }
                AegisLogger.INSTANCE.i("QQLive_Player|PlayerChangeUrlModel", "getChangedUrl", "size:" + ((rsp2 == null || (dVarArr2 = rsp2.f29020a) == null) ? null : Integer.valueOf(dVarArr2.length)));
                if (rsp2 != null && (dVarArr = rsp2.f29020a) != null) {
                    PlayerChangeUrlModel playerChangeUrlModel2 = PlayerChangeUrlModel.this;
                    for (d roomInfo : dVarArr) {
                        j3 = playerChangeUrlModel2.roomId;
                        if (j3 == roomInfo.f29028a) {
                            playerChangeUrlModel2.roomInfo = roomInfo;
                            Intrinsics.checkNotNullExpressionValue(roomInfo, "roomInfo");
                            playerChangeUrlModel2.printLog(roomInfo);
                            callback2 = playerChangeUrlModel2.callback;
                            if (callback2 != null) {
                                callback2.onResult(PlayerChangeUrlModel.getUrl$default(playerChangeUrlModel2, roomInfo, null, 2, null));
                                return;
                            }
                            return;
                        }
                    }
                }
                callback = PlayerChangeUrlModel.this.callback;
                if (callback != null) {
                    callback.onError(rsp.getRetCode(), "Not find url.");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getMaxRetryTimes() {
        return ht3.a.b("qqlive_player_change_url_api_retry_times", 1);
    }

    private final String getUrl(d roomInfo, EnterRoomInfo.VideoDefinition targetDefinition) {
        if (targetDefinition == null) {
            targetDefinition = PlayerDefinitionKt.getDefinition$default(null, 1, null);
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[targetDefinition.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        String str = roomInfo.f29029b.f29025e;
                        Intrinsics.checkNotNullExpressionValue(str, "roomInfo.playInfo.flv720P");
                        return str;
                    }
                    String str2 = roomInfo.f29029b.f29026f;
                    Intrinsics.checkNotNullExpressionValue(str2, "roomInfo.playInfo.flv1080P");
                    return str2;
                }
                String str3 = roomInfo.f29029b.f29025e;
                Intrinsics.checkNotNullExpressionValue(str3, "roomInfo.playInfo.flv720P");
                return str3;
            }
            String str4 = roomInfo.f29029b.f29024d;
            Intrinsics.checkNotNullExpressionValue(str4, "roomInfo.playInfo.flv540P");
            return str4;
        }
        String str5 = roomInfo.f29029b.f29023c;
        Intrinsics.checkNotNullExpressionValue(str5, "roomInfo.playInfo.flv360P");
        return str5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ String getUrl$default(PlayerChangeUrlModel playerChangeUrlModel, d dVar, EnterRoomInfo.VideoDefinition videoDefinition, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            videoDefinition = null;
        }
        return playerChangeUrlModel.getUrl(dVar, videoDefinition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void printLog(d roomInfo) {
        c cVar = roomInfo.f29029b;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i(TAG, "flv360P:" + cVar.f29023c);
        companion.i(TAG, "flv540P:" + cVar.f29024d);
        companion.i(TAG, "flv720P:" + cVar.f29025e);
        companion.i(TAG, "flv1080P:" + cVar.f29026f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void retryRequestRunnable$lambda$1(PlayerChangeUrlModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.doRequestChangeUrl();
    }

    public final void getChangedUrl(@NotNull IPlayerChangeUrlManager.Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        doRequestChangeUrl();
    }

    @NotNull
    public final String getUrlByDefinition(@Nullable EnterRoomInfo.VideoDefinition targetDefinition) {
        String url;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) targetDefinition);
        }
        d dVar = this.roomInfo;
        if (dVar == null || (url = getUrl(dVar, targetDefinition)) == null) {
            return "";
        }
        return url;
    }
}
