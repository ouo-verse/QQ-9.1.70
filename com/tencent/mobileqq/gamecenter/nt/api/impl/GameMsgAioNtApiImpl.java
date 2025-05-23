package com.tencent.mobileqq.gamecenter.nt.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.activity.recent.gamemsgbox.data.GameBoxRecentUser;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.IGameQQPlayerUtilApi;
import com.tencent.mobileqq.gamecenter.data.GameGlobalData;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.msginfo.GameUserInfo;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 N2\u00020\u0001:\u0001OB\u0007\u00a2\u0006\u0004\bL\u0010MJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\"\u0010\u0018\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0016H\u0002J,\u0010 \u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J$\u0010!\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u001c\u0010!\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0016J\u008e\u0001\u0010!\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u0010#\u001a\u0004\u0018\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010\u00062\b\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010&\u001a\u0004\u0018\u00010\u00062\b\u0010'\u001a\u0004\u0018\u00010\u00062\b\u0010(\u001a\u0004\u0018\u00010\u00062\b\u0010)\u001a\u0004\u0018\u00010\u00062\b\u0010*\u001a\u0004\u0018\u00010\u00062\b\u0010+\u001a\u0004\u0018\u00010\u00062\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\rH\u0016J\u0098\u0001\u0010!\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u0010#\u001a\u0004\u0018\u00010\u00062\b\u0010$\u001a\u0004\u0018\u00010\u00062\b\u0010%\u001a\u0004\u0018\u00010\u00062\b\u0010&\u001a\u0004\u0018\u00010\u00062\b\u0010'\u001a\u0004\u0018\u00010\u00062\b\u0010(\u001a\u0004\u0018\u00010\u00062\b\u0010)\u001a\u0004\u0018\u00010\u00062\b\u0010*\u001a\u0004\u0018\u00010\u00062\b\u0010+\u001a\u0004\u0018\u00010\u00062\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010!\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u00100\u001a\u00020/2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\"\u00103\u001a\u0002012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u000201H\u0016J\u001a\u00104\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u00106\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u000105H\u0016J\u0012\u00109\u001a\u00020\r2\b\u00108\u001a\u0004\u0018\u000107H\u0016J\u0012\u0010:\u001a\u0004\u0018\u00010\u00062\u0006\u00100\u001a\u00020/H\u0016J\u0010\u0010;\u001a\u00020\u00062\u0006\u00100\u001a\u00020/H\u0016J\u0012\u0010;\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J8\u0010@\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010<\u001a\u0004\u0018\u00010\u00062\b\u0010=\u001a\u0004\u0018\u00010\u00062\b\u0010>\u001a\u0004\u0018\u00010\u00062\b\u0010?\u001a\u0004\u0018\u00010\u0006H\u0016J7\u0010F\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062#\u0010E\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020\n0AH\u0016R\u0014\u0010H\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010J\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010K\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/api/impl/GameMsgAioNtApiImpl;", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgAioNtApi;", "Lcom/tencent/mobileqq/gamecenter/msginfo/GameCenterSessionInfo;", SessionDbHelper.SESSION_ID, "Lcom/tencent/mobileqq/activity/recent/gamemsgbox/data/GameBoxRecentUser;", "convertSessionToUser", "", "convertUin", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgAioNtApi$a;", "callback", "", "checkIceBreakMessage", "str", "", "encode", "encodeOrDecodeStr", "fromTinyId", "toTinyId", "getPeerUid", "Lmqq/app/AppRuntime;", "getApp", "uin", "Lk71/b;", "listener", "getUserInfo", "recentUserInfo", "Lcom/tencent/common/app/AppInterface;", "app", "Landroid/content/Context;", "context", "", "from", "enterGameMsgPlayerAio", "enterGameMsgAio", "peerUid", "peerRoleId", "selfRoleId", "peerOpenId", "selfOpenId", "peerTinyId", "selfTinyId", "gameAppId", PreloadTRTCPlayerParams.KEY_SIG, "topGrayText", "windowFlag", "isFromPlayer", WadlProxyConsts.EXT_JSON, "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "gameSession", "Landroid/content/Intent;", "intent", "createJumpIntent", "reqCanShowIceBreakImages", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgAioNtApi$b;", "setMsgInterceptListener", "", "text", "onSendMsgIntercept", "getFriendFaceUrl", "getFriendNickName", "curUin", "myRoleId", "friendRoleId", "newReportMsg", "jumpJuBaoReport", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "sign", "receiver", "getGameSign", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi;", "msgNtApi", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi;", "sendMsgInterceptListener", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgAioNtApi$b;", "<init>", "()V", "Companion", "a", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GameMsgAioNtApiImpl implements IGameMsgAioNtApi {
    private static final long DELAY_CHECK_ICE_BREAK_MESSAGE_TIME = 1000;

    @NotNull
    private static final String TAG = "GameMsgAioNtApiImpl";

    @NotNull
    private final IGameMsgNtApi msgNtApi;

    @Nullable
    private IGameMsgAioNtApi.b sendMsgInterceptListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/gamecenter/nt/api/impl/GameMsgAioNtApiImpl$b", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi$b;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onSuccess", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements IGameMsgNtApi.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IGameMsgAioNtApi.a f212252a;

        b(IGameMsgAioNtApi.a aVar) {
            this.f212252a = aVar;
        }

        @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi.b
        public void onSuccess(@NotNull ArrayList<MsgRecord> msgList) {
            boolean z16;
            Intrinsics.checkNotNullParameter(msgList, "msgList");
            Iterator<MsgRecord> it = msgList.iterator();
            while (true) {
                if (it.hasNext()) {
                    MsgRecord msgRecord = it.next();
                    Intrinsics.checkNotNullExpressionValue(msgRecord, "msgRecord");
                    if (hd1.a.e(msgRecord) || hd1.a.d(msgRecord)) {
                        if (MsgExtKt.S(msgRecord)) {
                            z16 = true;
                            break;
                        }
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            String mAppId = GameGlobalData.INSTANCE.a().getMAppId();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[reqCanShowIceBreakImages] canShow:");
            sb5.append(!z16);
            sb5.append(",appId:");
            sb5.append(mAppId);
            QLog.i(GameMsgAioNtApiImpl.TAG, 2, sb5.toString());
            this.f212252a.onResult(!z16, mAppId);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/gamecenter/nt/api/impl/GameMsgAioNtApiImpl$c", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi$a;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "latestMsg", "", "a", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements IGameMsgNtApi.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f212254b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f212255c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<GameBoxRecentUser> f212256d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f212257e;

        c(Context context, String str, Ref.ObjectRef<GameBoxRecentUser> objectRef, int i3) {
            this.f212254b = context;
            this.f212255c = str;
            this.f212256d = objectRef;
            this.f212257e = i3;
        }

        @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi.a
        public void a(@Nullable MsgRecord latestMsg) {
            if (latestMsg != null) {
                GameMsgAioNtApiImpl gameMsgAioNtApiImpl = GameMsgAioNtApiImpl.this;
                Context context = this.f212254b;
                String str = this.f212255c;
                GameBoxRecentUser gameBoxRecentUser = this.f212256d.element;
                gameMsgAioNtApiImpl.enterGameMsgAio(context, str, gameBoxRecentUser.mToRoleId, gameBoxRecentUser.mFromRoleId, gameBoxRecentUser.mToOpenId, gameBoxRecentUser.mFromOpenId, gameBoxRecentUser.mToTinyId, gameBoxRecentUser.mFromTinyId, gameBoxRecentUser.mGameAppId, gameBoxRecentUser.mSig, "", 0, this.f212257e, false);
                return;
            }
            GameMsgAioNtApiImpl gameMsgAioNtApiImpl2 = GameMsgAioNtApiImpl.this;
            GameBoxRecentUser gameBoxRecentUser2 = this.f212256d.element;
            AppRuntime app = gameMsgAioNtApiImpl2.getApp();
            Intrinsics.checkNotNull(app, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            gameMsgAioNtApiImpl2.enterGameMsgPlayerAio(gameBoxRecentUser2, (AppInterface) app, this.f212254b, this.f212257e);
        }
    }

    public GameMsgAioNtApiImpl() {
        QRouteApi api = QRoute.api(IGameMsgNtApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGameMsgNtApi::class.java)");
        this.msgNtApi = (IGameMsgNtApi) api;
    }

    private final void checkIceBreakMessage(String convertUin, IGameMsgAioNtApi.a callback) {
        boolean z16;
        if (!GameGlobalData.INSTANCE.a().b()) {
            return;
        }
        String peerUidByUin = this.msgNtApi.getPeerUidByUin(convertUin);
        if (peerUidByUin != null && peerUidByUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e(TAG, 1, "[reqCanShowIceBreakImages] peerUid is empty,convertUin:" + convertUin);
            return;
        }
        this.msgNtApi.getMsgList(peerUidByUin, 105, 60, new b(callback));
    }

    private final GameBoxRecentUser convertSessionToUser(GameCenterSessionInfo session) {
        GameBoxRecentUser gameBoxRecentUser = new GameBoxRecentUser();
        gameBoxRecentUser.mToRoleId = session.v();
        gameBoxRecentUser.mFromRoleId = session.r();
        gameBoxRecentUser.mToTinyId = String.valueOf(session.k());
        gameBoxRecentUser.mFromTinyId = String.valueOf(session.y());
        gameBoxRecentUser.mGameAppId = session.m();
        return gameBoxRecentUser;
    }

    private final String encodeOrDecodeStr(String str, boolean encode) {
        String str2 = "";
        if (str == null) {
            str = "";
        }
        try {
            if (encode) {
                str = URLEncoder.encode(str, "UTF-8");
            } else {
                str = URLDecoder.decode(str, "UTF-8");
            }
            return str;
        } catch (UnsupportedEncodingException e16) {
            if (!encode) {
                str2 = str;
            }
            if (QLog.isColorLevel()) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("encodeOrDecodeStr [%s, %s]", Arrays.copyOf(new Object[]{Boolean.valueOf(encode), str}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                QLog.i(TAG, 2, format, e16);
            }
            return str2;
        } catch (Throwable th5) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("encodeOrDecodeStr [%s, %s]", Arrays.copyOf(new Object[]{Boolean.valueOf(encode), str}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            QLog.i(TAG, 1, format2, th5);
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v6, types: [com.tencent.mobileqq.activity.recent.gamemsgbox.data.GameBoxRecentUser, T] */
    public static final void enterGameMsgAio$lambda$0(GameMsgAioNtApiImpl this$0, String str, Context context, int i3, GameBoxRecentUser gameBoxRecentUser) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = gameBoxRecentUser;
        if (gameBoxRecentUser == 0) {
            QLog.e(TAG, 1, "[enterGameMsgAio1] userInfo is null");
            AppRuntime app = this$0.getApp();
            Intrinsics.checkNotNull(app);
            IRuntimeService runtimeService = app.getRuntimeService(IGameMsgManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "getApp()!!.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
            GameCenterSessionInfo sessionInfoByUin = ((IGameMsgManagerService) runtimeService).getSessionInfoByUin(str);
            if (sessionInfoByUin == null) {
                QLog.e(TAG, 1, "[enterGameMsgAio1] sessionInfo is null");
                return;
            }
            objectRef.element = this$0.convertSessionToUser(sessionInfoByUin);
        }
        String str2 = ((GameBoxRecentUser) objectRef.element).mFromTinyId;
        Intrinsics.checkNotNullExpressionValue(str2, "userInfo.mFromTinyId");
        String str3 = ((GameBoxRecentUser) objectRef.element).mToTinyId;
        Intrinsics.checkNotNullExpressionValue(str3, "userInfo.mToTinyId");
        String peerUid = this$0.getPeerUid(str2, str3);
        this$0.msgNtApi.getLatestMsg(peerUid, 105, new c(context, peerUid, objectRef, i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enterGameMsgPlayerAio(GameBoxRecentUser recentUserInfo, AppInterface app, Context context, int from) {
        try {
            String str = recentUserInfo.mGameAppId;
            Intrinsics.checkNotNullExpressionValue(str, "recentUserInfo.mGameAppId");
            ((IGameQQPlayerUtilApi) QRoute.api(IGameQQPlayerUtilApi.class)).openGameMsgAIO(app, context, recentUserInfo.mFromRoleId, recentUserInfo.mFromOpenId, recentUserInfo.mToRoleId, recentUserInfo.mToOpenId, null, recentUserInfo.mSig, Long.parseLong(str), recentUserInfo.mFromTinyId, recentUserInfo.mToTinyId, 0, from);
        } catch (Exception e16) {
            QLog.e(TAG, 2, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AppRuntime getApp() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getGameSign$lambda$10(Function1 receiver, GameBoxRecentUser gameBoxRecentUser) {
        String str;
        Intrinsics.checkNotNullParameter(receiver, "$receiver");
        if (gameBoxRecentUser != null) {
            str = gameBoxRecentUser.mSig;
        } else {
            str = null;
        }
        receiver.invoke(str);
    }

    private final String getPeerUid(String fromTinyId, String toTinyId) {
        return this.msgNtApi.createUidFromTinyId(fromTinyId, toTinyId);
    }

    private final void getUserInfo(String uin, k71.b<GameBoxRecentUser> listener) {
        IGameMsgBoxManager iGameMsgBoxManager;
        try {
            AppRuntime app = getApp();
            if (app != null && (iGameMsgBoxManager = (IGameMsgBoxManager) app.getRuntimeService(IGameMsgBoxManager.class, "")) != null) {
                iGameMsgBoxManager.asyncFindGameBoxRecentUserInfo(uin, listener);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reqCanShowIceBreakImages$lambda$4(GameMsgAioNtApiImpl this$0, String str, IGameMsgAioNtApi.a callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.checkIceBreakMessage(str, callback);
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi
    @NotNull
    public Intent createJumpIntent(@Nullable Context context, @NotNull TempChatGameSession gameSession, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(gameSession, "gameSession");
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            String createUidFromTinyId = ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).createUidFromTinyId(gameSession.selfTinyId, gameSession.peerTinyId);
            String gameSessionJson = this.msgNtApi.getGameSessionJson(createUidFromTinyId, gameSession.peerRoleId, gameSession.selfRoleId, gameSession.peerOpenId, gameSession.selfOpenId, String.valueOf(gameSession.peerTinyId), String.valueOf(gameSession.selfTinyId), String.valueOf(gameSession.gameAppId), "", 0);
            intent.putExtra(AppConstants.Key.KEY_GAME_MSG_FRIEND_ROLEID, gameSession.peerRoleId);
            intent.putExtra(AppConstants.Key.KEY_GAME_MSG_MY_ROLEID, gameSession.selfRoleId);
            intent.putExtra(AppConstants.Key.KEY_GAME_MSG_SIG, "");
            intent.putExtra(AppConstants.Key.KEY_GAME_MSG_SESSION, gameSessionJson);
            intent.putExtra("key_chat_type", 105);
            intent.putExtra("key_peerId", createUidFromTinyId);
            intent.putExtra("key_peerUin", Long.parseLong(this.msgNtApi.createConvertUinFromTinyId(gameSession.selfTinyId, gameSession.peerTinyId)));
            intent.putExtra("uintype", 10007);
            intent.putExtra(AppConstants.Key.KEY_GAME_MSG_OPEN_AIO_FROM, 7);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
        return intent;
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi
    public void enterGameMsgAio(@Nullable final Context context, @Nullable final String uin, final int from) {
        boolean z16 = true;
        QLog.e(TAG, 1, "[enterGameMsgAio1] uin:" + uin + ",from:" + from);
        if (context != null) {
            if (uin != null && uin.length() != 0) {
                z16 = false;
            }
            if (z16 || !(getApp() instanceof AppInterface)) {
                return;
            }
            getUserInfo(uin, new k71.b() { // from class: com.tencent.mobileqq.gamecenter.nt.api.impl.a
                @Override // k71.b
                public final void a(Object obj) {
                    GameMsgAioNtApiImpl.enterGameMsgAio$lambda$0(GameMsgAioNtApiImpl.this, uin, context, from, (GameBoxRecentUser) obj);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi
    @Nullable
    public String getFriendFaceUrl(@NotNull TempChatGameSession gameSession) {
        IGameMsgManagerService iGameMsgManagerService;
        Intrinsics.checkNotNullParameter(gameSession, "gameSession");
        AppRuntime app = getApp();
        if (app != null) {
            iGameMsgManagerService = (IGameMsgManagerService) app.getRuntimeService(IGameMsgManagerService.class, "");
        } else {
            iGameMsgManagerService = null;
        }
        if (iGameMsgManagerService != null) {
            GameCenterSessionInfo sessionInfoByUin = iGameMsgManagerService.getSessionInfoByUin(this.msgNtApi.createConvertUinFromTinyId(gameSession.selfTinyId, gameSession.peerTinyId));
            if (sessionInfoByUin != null && !TextUtils.isEmpty(sessionInfoByUin.j())) {
                return sessionInfoByUin.j();
            }
            GameUserInfo findGameUserInfo = iGameMsgManagerService.findGameUserInfo(gameSession.peerRoleId);
            if (findGameUserInfo != null && !TextUtils.isEmpty(findGameUserInfo.mFaceUrl)) {
                return findGameUserInfo.mFaceUrl;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi
    @NotNull
    public String getFriendNickName(@NotNull TempChatGameSession gameSession) {
        Intrinsics.checkNotNullParameter(gameSession, "gameSession");
        AppRuntime app = getApp();
        IGameMsgManagerService iGameMsgManagerService = app != null ? (IGameMsgManagerService) app.getRuntimeService(IGameMsgManagerService.class, "") : null;
        if (iGameMsgManagerService != null) {
            GameCenterSessionInfo sessionInfoByUin = iGameMsgManagerService.getSessionInfoByUin(this.msgNtApi.createConvertUinFromTinyId(gameSession.selfTinyId, gameSession.peerTinyId));
            if (sessionInfoByUin != null && !TextUtils.isEmpty(sessionInfoByUin.s())) {
                String s16 = sessionInfoByUin.s();
                Intrinsics.checkNotNullExpressionValue(s16, "sessionInfo.nickName");
                return s16;
            }
            GameUserInfo findGameUserInfo = iGameMsgManagerService.findGameUserInfo(gameSession.peerRoleId);
            if (findGameUserInfo != null && !TextUtils.isEmpty(findGameUserInfo.mNickInGame)) {
                String str = findGameUserInfo.mNickInGame;
                Intrinsics.checkNotNullExpressionValue(str, "usrInfo.mNickInGame");
                return str;
            }
            if (!TextUtils.isEmpty(gameSession.nickname)) {
                String str2 = gameSession.nickname;
                Intrinsics.checkNotNullExpressionValue(str2, "gameSession.nickname");
                return str2;
            }
        }
        String string = BaseApplication.getContext().getResources().getString(R.string.f1374506w);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().resources.g\u2026sg_from_nickname_default)");
        return string;
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi
    public void getGameSign(@Nullable String convertUin, @NotNull final Function1<? super String, Unit> receiver) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        getUserInfo(convertUin, new k71.b() { // from class: com.tencent.mobileqq.gamecenter.nt.api.impl.c
            @Override // k71.b
            public final void a(Object obj) {
                GameMsgAioNtApiImpl.getGameSign$lambda$10(Function1.this, (GameBoxRecentUser) obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi
    public void jumpJuBaoReport(@NotNull Context context, @Nullable String curUin, @Nullable String myRoleId, @Nullable String friendRoleId, @Nullable String newReportMsg) {
        boolean z16;
        boolean z17;
        boolean z18;
        Pair<String, String> pair;
        int i3;
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        AppRuntime app = getApp();
        if (curUin != null && curUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (myRoleId != null && myRoleId.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                if (friendRoleId != null && friendRoleId.length() != 0) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                if (!z18 && app != null) {
                    ed1.c tinyIdCache = ((IMessageFacade) app.getRuntimeService(IMessageFacade.class, "")).getTinyIdCache();
                    if (tinyIdCache != null) {
                        pair = tinyIdCache.e(curUin);
                    } else {
                        pair = null;
                    }
                    if (pair != null) {
                        String str2 = (String) pair.first;
                        try {
                            com.tencent.mobileqq.dt.api.b bVar = new com.tencent.mobileqq.dt.api.b();
                            bVar.r(curUin);
                            bVar.n(str2);
                            bVar.i("10180");
                            bVar.o(2);
                            bVar.j("0");
                            bVar.s(0);
                            bVar.l(curUin);
                            bVar.k("10007");
                            bVar.x(encodeOrDecodeStr("REPORT_IP=0&EVIL_IP=0", true));
                            String str3 = "evilroleId=" + friendRoleId + "|roleId=" + myRoleId;
                            Bundle bundle = new Bundle();
                            bundle.putString("roleId", friendRoleId);
                            Object msgCache = app.getMsgCache();
                            try {
                                Intrinsics.checkNotNull(msgCache, "null cannot be cast to non-null type com.tencent.mobileqq.service.message.MessageCache");
                                int i16 = 0;
                                try {
                                    bundle.putString("jubao_game_sig", Base64.encodeToString(((com.tencent.mobileqq.service.message.e) msgCache).b1(curUin, app.getCurrentUin()), 0));
                                    bundle.putString("friendroleid", friendRoleId);
                                    bundle.putString("myroleid", myRoleId);
                                    bundle.putString("c2c_type", "1");
                                    bundle.putString("service_type", "164");
                                    bVar.p(bundle);
                                    bVar.m(str3);
                                    if (newReportMsg == null) {
                                        str = "";
                                    } else {
                                        str = newReportMsg;
                                    }
                                    bVar.v(encodeOrDecodeStr(str, true));
                                    i16 = 0;
                                    BaseApplication.getContext().getSharedPreferences("jubao_game", 0).edit().putString("jubao_game_evil_uin_" + app.getCurrentUin(), str2).apply();
                                    ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(context, bVar);
                                    if (QLog.isColorLevel()) {
                                        QLog.i(TAG, 2, "[jumpJuBaoReport] evilUin:" + str2 + ",curUin:" + curUin + ",myRoleId:" + myRoleId + ",friendRoleId:" + friendRoleId);
                                        return;
                                    }
                                    return;
                                } catch (Throwable th5) {
                                    th = th5;
                                    i3 = i16;
                                    QLog.e(TAG, 1, th, new Object[i3]);
                                    return;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                i3 = 0;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            i3 = 0;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
        QLog.i(TAG, 1, "[jumpJuBaoReport] params error,curUin:" + curUin + ",myRoleId:" + myRoleId + ",friendRoleId:" + friendRoleId);
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi
    public boolean onSendMsgIntercept(@Nullable CharSequence text) {
        IGameMsgAioNtApi.b bVar = this.sendMsgInterceptListener;
        if (bVar != null) {
            return bVar.a(text);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi
    public void reqCanShowIceBreakImages(@Nullable final String convertUin, @NotNull final IGameMsgAioNtApi.a callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (convertUin != null && convertUin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        if (GameGlobalData.INSTANCE.a().getMIsQueryingSayHiState()) {
            QLog.i(TAG, 1, "[reqCanShowIceBreakImages] delay check");
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.nt.api.impl.b
                @Override // java.lang.Runnable
                public final void run() {
                    GameMsgAioNtApiImpl.reqCanShowIceBreakImages$lambda$4(GameMsgAioNtApiImpl.this, convertUin, callback);
                }
            }, 16, null, true, 1000L);
        } else {
            checkIceBreakMessage(convertUin, callback);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi
    public void setMsgInterceptListener(@Nullable IGameMsgAioNtApi.b listener) {
        this.sendMsgInterceptListener = listener;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0042 A[Catch: Exception -> 0x006f, TryCatch #0 {Exception -> 0x006f, blocks: (B:3:0x0005, B:6:0x000f, B:11:0x001b, B:14:0x0024, B:16:0x0042, B:17:0x0047, B:21:0x0059), top: B:2:0x0005 }] */
    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void enterGameMsgAio(@Nullable Context context, @Nullable String uin) {
        boolean z16;
        GameCenterSessionInfo sessionInfoByUin;
        try {
            QLog.i(TAG, 1, "[enterGameMsgAio3]");
            if (context != null) {
                if (uin != null && uin.length() != 0) {
                    z16 = false;
                    if (!z16 && (getApp() instanceof AppInterface)) {
                        AppRuntime app = getApp();
                        Intrinsics.checkNotNull(app);
                        IRuntimeService runtimeService = app.getRuntimeService(IGameMsgManagerService.class, "");
                        Intrinsics.checkNotNullExpressionValue(runtimeService, "getApp()!!.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
                        sessionInfoByUin = ((IGameMsgManagerService) runtimeService).getSessionInfoByUin(uin);
                        if (sessionInfoByUin == null) {
                            sessionInfoByUin = new GameCenterSessionInfo();
                        }
                        com.tencent.mobileqq.gamecenter.utils.f.S(context, sessionInfoByUin, "src2");
                        com.tencent.mobileqq.gamecenter.utils.f.Y((AppInterface) getApp(), uin, 10004, 1);
                        return;
                    }
                }
                z16 = true;
                if (!z16) {
                    AppRuntime app2 = getApp();
                    Intrinsics.checkNotNull(app2);
                    IRuntimeService runtimeService2 = app2.getRuntimeService(IGameMsgManagerService.class, "");
                    Intrinsics.checkNotNullExpressionValue(runtimeService2, "getApp()!!.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
                    sessionInfoByUin = ((IGameMsgManagerService) runtimeService2).getSessionInfoByUin(uin);
                    if (sessionInfoByUin == null) {
                    }
                    com.tencent.mobileqq.gamecenter.utils.f.S(context, sessionInfoByUin, "src2");
                    com.tencent.mobileqq.gamecenter.utils.f.Y((AppInterface) getApp(), uin, 10004, 1);
                    return;
                }
            }
            QLog.e(TAG, 1, "[enterGameMsgAio3] params invalid uin:" + uin);
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi
    @NotNull
    public String getFriendNickName(@Nullable String convertUin) {
        GameCenterSessionInfo sessionInfoByUin;
        AppRuntime app = getApp();
        IGameMsgManagerService iGameMsgManagerService = app != null ? (IGameMsgManagerService) app.getRuntimeService(IGameMsgManagerService.class, "") : null;
        if (iGameMsgManagerService != null && (sessionInfoByUin = iGameMsgManagerService.getSessionInfoByUin(convertUin)) != null && !TextUtils.isEmpty(sessionInfoByUin.s())) {
            String s16 = sessionInfoByUin.s();
            Intrinsics.checkNotNullExpressionValue(s16, "sessionInfo.nickName");
            return s16;
        }
        String string = BaseApplication.getContext().getResources().getString(R.string.f1374506w);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().resources.g\u2026sg_from_nickname_default)");
        return string;
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi
    public void enterGameMsgAio(@Nullable Context context, @Nullable String peerUid, @Nullable String peerRoleId, @Nullable String selfRoleId, @Nullable String peerOpenId, @Nullable String selfOpenId, @Nullable String peerTinyId, @Nullable String selfTinyId, @Nullable String gameAppId, @Nullable String sig, @Nullable String topGrayText, int windowFlag, int from, boolean isFromPlayer) {
        enterGameMsgAio(context, peerUid, peerRoleId, selfRoleId, peerOpenId, selfOpenId, peerTinyId, selfTinyId, gameAppId, sig, topGrayText, windowFlag, from, isFromPlayer, "");
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi
    public void enterGameMsgAio(@Nullable Context context, @Nullable String peerUid, @Nullable String peerRoleId, @Nullable String selfRoleId, @Nullable String peerOpenId, @Nullable String selfOpenId, @Nullable String peerTinyId, @Nullable String selfTinyId, @Nullable String gameAppId, @Nullable String sig, @Nullable String topGrayText, int windowFlag, int from, boolean isFromPlayer, @Nullable String extJson) {
        String str;
        int i3;
        int i16;
        if (context != null) {
            if (!(peerUid == null || peerUid.length() == 0)) {
                if (!(peerRoleId == null || peerRoleId.length() == 0)) {
                    if (!(selfRoleId == null || selfRoleId.length() == 0)) {
                        if (!(peerTinyId == null || peerTinyId.length() == 0)) {
                            if (!(selfTinyId == null || selfTinyId.length() == 0)) {
                                AppRuntime app = getApp();
                                IGameMsgBoxRuntimeService iGameMsgBoxRuntimeService = app != null ? (IGameMsgBoxRuntimeService) app.getRuntimeService(IGameMsgBoxRuntimeService.class, "") : null;
                                if (iGameMsgBoxRuntimeService != null) {
                                    iGameMsgBoxRuntimeService.setEnterGameMsgAIOAppId(gameAppId);
                                }
                                String gameSessionJson = this.msgNtApi.getGameSessionJson(peerUid, peerRoleId, selfRoleId, peerOpenId, selfOpenId, peerTinyId, selfTinyId, gameAppId, sig, windowFlag);
                                ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_CHAT_ACTVITY);
                                activityURIRequest.extra().putString(AppConstants.Key.KEY_GAME_MSG_FRIEND_ROLEID, peerRoleId);
                                activityURIRequest.extra().putString(AppConstants.Key.KEY_GAME_MSG_MY_ROLEID, selfRoleId);
                                activityURIRequest.extra().putString(AppConstants.Key.KEY_GAME_MSG_SIG, sig);
                                activityURIRequest.extra().putString(AppConstants.Key.KEY_GAME_MSG_SESSION, gameSessionJson);
                                activityURIRequest.extra().putString(AppConstants.Key.KEY_GAME_MSG_EXT_PARAMS, extJson);
                                activityURIRequest.extra().putInt("key_chat_type", 105);
                                activityURIRequest.extra().putString("key_peerId", peerUid);
                                try {
                                    activityURIRequest.extra().putLong("key_peerUin", Long.parseLong(this.msgNtApi.createConvertUinFromTinyId(Long.parseLong(selfTinyId), Long.parseLong(peerTinyId))));
                                    activityURIRequest.extra().putInt("uintype", 10007);
                                    str = TAG;
                                } catch (Exception e16) {
                                    str = TAG;
                                    QLog.e(str, 1, e16, new Object[0]);
                                }
                                activityURIRequest.extra().putString(AppConstants.Key.KEY_GAME_MSG_TOP_GRAY_TEXT, topGrayText);
                                activityURIRequest.setFlags(268435456);
                                if (isFromPlayer) {
                                    i3 = from;
                                    i16 = i3 != 5 ? i3 != 1000 ? 3 : 4 : 5;
                                } else {
                                    i3 = from;
                                    i16 = i3;
                                }
                                activityURIRequest.extra().putInt(AppConstants.Key.KEY_GAME_MSG_OPEN_AIO_FROM, i16);
                                QRoute.startUri(activityURIRequest, (o) null);
                                if (QLog.isColorLevel()) {
                                    QLog.i(str, 2, "[enterGameMsgAio4] fRoleId:" + peerRoleId + ",:" + selfRoleId + ",from:" + i3 + ",topGrayText:" + topGrayText + ",finalFrom:" + i16);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
            }
        }
        QLog.e(TAG, 1, "[enterGameMsgAio4] params invalid peerUid:" + peerUid + ",peerRoleId:" + peerRoleId + ",selfRoleId:" + selfRoleId + ",peerTinyId:" + peerTinyId + ",selfTinyId:" + selfTinyId);
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgAioNtApi
    public void enterGameMsgAio(@Nullable Context context, @NotNull TempChatGameSession gameSession, int from) {
        Intrinsics.checkNotNullParameter(gameSession, "gameSession");
        enterGameMsgAio(context, this.msgNtApi.createConvertUinFromTinyId(gameSession.selfTinyId, gameSession.peerTinyId), from);
    }
}
