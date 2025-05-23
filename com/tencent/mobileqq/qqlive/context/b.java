package com.tencent.mobileqq.qqlive.context;

import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.ILiveRoomApi;
import com.tencent.mobileqq.qqlive.api.login.ILiveLoginApi;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.player.IQQLivePlayer;
import com.tencent.mobileqq.qqlive.sail.model.AudienceRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.player.PlayerConfig;
import com.tencent.mobileqq.qqlive.sail.room.d;
import com.tencent.mobileqq.qqlive.sail.room.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.bv;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\t\u001a\u00020\u0007*\u00020\u00002'\u0010\b\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00030\u0002\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0001\u001a\n\u0010\u000b\u001a\u00020\n*\u00020\u0000\u001a&\u0010\u0013\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qqlive/context/QQLiveContext;", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "Lcom/tencent/mobileqq/qqlive/login/LiveLoginInfo;", "Lkotlin/ParameterName;", "name", "response", "", "callback", "c", "Lcom/tencent/mobileqq/qqlive/sail/room/d;", "b", "Lcom/tencent/mobileqq/qqlive/sail/model/AudienceRoomInfo;", "roomInfo", "Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;", "playerConfig", "Lcom/tencent/mobileqq/qqlive/player/IQQLivePlayer;", "player", "Lcom/tencent/mobileqq/qqlive/sail/room/e;", "a", "qq-live-sdk-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/qqlive/context/b$a", "Lmqq/manager/MainTicketCallback;", "Lmqq/manager/MainTicketInfo;", "info", "", "onSuccess", "", "errorCode", "", "errorMsg", "onFail", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements MainTicketCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f271206a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f271207b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<QQLiveResponse<LiveLoginInfo>, Unit> f271208c;

        /* JADX WARN: Multi-variable type inference failed */
        a(String str, String str2, Function1<? super QQLiveResponse<LiveLoginInfo>, Unit> function1) {
            this.f271206a = str;
            this.f271207b = str2;
            this.f271208c = function1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, function1);
            }
        }

        @Override // mqq.manager.MainTicketCallback
        public void onFail(int errorCode, @NotNull String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
            } else {
                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                QLog.i("QQLiveContext.login", 1, "async get login ticket fail");
            }
        }

        @Override // mqq.manager.MainTicketCallback
        public void onSuccess(@NotNull MainTicketInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) info);
                return;
            }
            Intrinsics.checkNotNullParameter(info, "info");
            QLog.i("QQLiveContext.login", 1, "async get login ticket success");
            ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).login(this.f271206a, this.f271207b, info.getA2(), this.f271208c);
        }
    }

    @NotNull
    public static final e a(@NotNull QQLiveContext qQLiveContext, @NotNull AudienceRoomInfo roomInfo, @NotNull PlayerConfig playerConfig, @Nullable IQQLivePlayer iQQLivePlayer) {
        Intrinsics.checkNotNullParameter(qQLiveContext, "<this>");
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        Intrinsics.checkNotNullParameter(playerConfig, "playerConfig");
        if (Intrinsics.areEqual(roomInfo.l(), qQLiveContext.g())) {
            return ((ILiveRoomApi) QRoute.api(ILiveRoomApi.class)).createAudienceRoom(roomInfo, playerConfig, iQQLivePlayer);
        }
        AegisLogger.INSTANCE.w("Open_Live|QQLiveContext", "createAudienceRoom", "different appId, " + roomInfo.l() + ", " + qQLiveContext.g());
        throw new IllegalArgumentException("different appId, " + roomInfo.l() + ", " + qQLiveContext.g());
    }

    @NotNull
    public static final d b(@NotNull QQLiveContext qQLiveContext) {
        Intrinsics.checkNotNullParameter(qQLiveContext, "<this>");
        return ((ILiveRoomApi) QRoute.api(ILiveRoomApi.class)).createTrtcRoom(qQLiveContext.g());
    }

    public static final void c(@NotNull QQLiveContext qQLiveContext, @NotNull Function1<? super QQLiveResponse<LiveLoginInfo>, Unit> callback) {
        Intrinsics.checkNotNullParameter(qQLiveContext, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            peekAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        }
        if (peekAppRuntime != null) {
            String g16 = qQLiveContext.g();
            String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
            if (account == null) {
                account = "";
            }
            TicketManager ticketManager = (TicketManager) peekAppRuntime.getManager(2);
            if (ticketManager != null) {
                if (ticketManager.useAsyncTicketInterface()) {
                    ticketManager.getA2(bv.b(account, 0L), 16, new a(g16, account, callback));
                    return;
                }
                String a26 = ticketManager.getA2(account);
                QLog.i("QQLiveContext.login", 1, "sync get login ticket");
                ((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).login(g16, account, a26, callback);
            }
        }
    }
}
