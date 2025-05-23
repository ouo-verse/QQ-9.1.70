package bt1;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import at1.GuildGameCreateBean;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.media.core.MediaChannelCore;
import com.tencent.mobileqq.guild.media.core.data.UserBusinessInfo;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.data.q;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.l;
import com.tencent.mobileqq.guild.media.core.m;
import com.tencent.mobileqq.guild.media.game.service.model.p005enum.RoomState;
import com.tencent.mobileqq.guild.media.game.service.repository.GuildGameKernelServiceKt;
import com.tencent.mobileqq.guild.performance.report.aa;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.dq;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildThemeInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameBaseRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameGameStaticInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameRoomStateInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSmobaGameSmobaRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.fi;
import com.tencent.mobileqq.qqguildsdk.data.genc.fj;
import com.tencent.mobileqq.qqguildsdk.data.genc.fl;
import com.tencent.mobileqq.qqguildsdk.data.genc.fm;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.dh;
import wh2.em;
import wh2.eu;
import wh2.ev;
import wh2.ew;
import zs1.GuildAuthGameBean;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 X2\u00020\u0001:\u0001YB\u0007\u00a2\u0006\u0004\bV\u0010WJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0006J\u0006\u0010\u001d\u001a\u00020\u0002J\u0006\u0010\u001e\u001a\u00020\u0002J\u0006\u0010\u001f\u001a\u00020\u0002R(\u0010(\u001a\b\u0012\u0004\u0012\u00020!0 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R(\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R(\u00101\u001a\b\u0012\u0004\u0012\u00020-0 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010#\u001a\u0004\b/\u0010%\"\u0004\b0\u0010'R(\u00105\u001a\b\u0012\u0004\u0012\u00020-0 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010#\u001a\u0004\b3\u0010%\"\u0004\b4\u0010'R4\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u0006060 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010#\u001a\u0004\b9\u0010%\"\u0004\b:\u0010'R4\u0010?\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u0006060 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010#\u001a\u0004\b=\u0010%\"\u0004\b>\u0010'R4\u0010C\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006060 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010#\u001a\u0004\bA\u0010%\"\u0004\bB\u0010'R(\u0010G\u001a\b\u0012\u0004\u0012\u0002070 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010#\u001a\u0004\bE\u0010%\"\u0004\bF\u0010'R4\u0010K\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u0006060 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010#\u001a\u0004\bI\u0010%\"\u0004\bJ\u0010'R4\u0010O\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\u0006060 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u0010#\u001a\u0004\bM\u0010%\"\u0004\bN\u0010'R\u0017\u0010U\u001a\u00020P8\u0006\u00a2\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\u00a8\u0006Z"}, d2 = {"Lbt1/h;", "Landroidx/lifecycle/ViewModel;", "", "z2", "Lat1/a;", "e2", "", "tinyId", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "r2", "o2", SemanticAttributes.DbSystemValues.H2, "p2", "i2", "", "q2", "j2", "Lcom/tencent/mobileqq/guild/media/core/data/q;", ICustomDataEditor.STRING_PARAM_2, "y2", "Lbt1/i;", "roomAuthParams", "R1", "T1", "Lcom/tencent/mobileqq/qqguildsdk/data/dq;", "gameModeInfo", "W1", "from", "Z1", "t2", "v2", "x2", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/guild/media/game/service/model/enum/RoomState;", "i", "Landroidx/lifecycle/MutableLiveData;", "getRoomStateObservable", "()Landroidx/lifecycle/MutableLiveData;", "setRoomStateObservable", "(Landroidx/lifecycle/MutableLiveData;)V", "roomStateObservable", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getGameDurationObservable", "setGameDurationObservable", "gameDurationObservable", "Lzs1/a;", BdhLogUtil.LogTag.Tag_Conn, "b2", "setAuthGameObservable", "authGameObservable", "D", "c2", "setAuthJoinGameObservable", "authJoinGameObservable", "Lkotlin/Pair;", "", "E", "f2", "setCreateRoomResult", "createRoomResult", UserInfo.SEX_FEMALE, "g2", "setDismissRoomResult", "dismissRoomResult", "G", ICustomDataEditor.NUMBER_PARAM_2, "setSchemeObservable", "schemeObservable", "H", "d2", "setCanClose", "canClose", "I", "k2", "setJoinRoomResult", "joinRoomResult", "J", "m2", "setQuitRoomResult", "quitRoomResult", "Lcom/tencent/mobileqq/guild/media/core/l;", "K", "Lcom/tencent/mobileqq/guild/media/core/l;", "l2", "()Lcom/tencent/mobileqq/guild/media/core/l;", "mediaChannelDataHub", "<init>", "()V", "L", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h extends ViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<RoomState> roomStateObservable = new MutableLiveData<>(RoomState.Origin);

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MutableLiveData<Integer> gameDurationObservable = new MutableLiveData<>(0);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<GuildAuthGameBean> authGameObservable = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<GuildAuthGameBean> authJoinGameObservable = new MutableLiveData<>();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Pair<Boolean, String>> createRoomResult = new MutableLiveData<>();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Pair<Boolean, String>> dismissRoomResult = new MutableLiveData<>();

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Pair<String, String>> schemeObservable = new MutableLiveData<>();

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> canClose = new MutableLiveData<>(Boolean.FALSE);

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Pair<Boolean, String>> joinRoomResult = new MutableLiveData<>();

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Pair<Boolean, String>> quitRoomResult = new MutableLiveData<>();

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final l mediaChannelDataHub = j.c();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(h this$0, int i3, String errMsg, int i16, IGProSecurityResult iGProSecurityResult, String tipsContent, ArrayList gameModes) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QMGame.GuildGameRoomViewModel", 1, "authCanCreateRoom state: " + i16 + ", result: " + i3 + ", msg: " + errMsg);
        aa aaVar = aa.f230980i;
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        aaVar.v(i3, errMsg);
        if (i3 == 0) {
            MutableLiveData<GuildAuthGameBean> mutableLiveData = this$0.authGameObservable;
            Intrinsics.checkNotNullExpressionValue(tipsContent, "tipsContent");
            Intrinsics.checkNotNullExpressionValue(gameModes, "gameModes");
            mutableLiveData.setValue(new GuildAuthGameBean(errMsg, i16, iGProSecurityResult, tipsContent, gameModes));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(h this$0, int i3, String errMsg, int i16, IGProSecurityResult iGProSecurityResult, String tipsContent, ArrayList gameModes) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QMGame.GuildGameRoomViewModel", 1, "authCanJoinGameRoom state: " + i16 + ", result: " + i3 + ", msg: " + errMsg);
        aa aaVar = aa.f230980i;
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        aaVar.v(i3, errMsg);
        if (i3 == 0) {
            MutableLiveData<GuildAuthGameBean> mutableLiveData = this$0.authJoinGameObservable;
            Intrinsics.checkNotNullExpressionValue(tipsContent, "tipsContent");
            Intrinsics.checkNotNullExpressionValue(gameModes, "gameModes");
            mutableLiveData.setValue(new GuildAuthGameBean(errMsg, i16, iGProSecurityResult, tipsContent, gameModes));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(h this$0, int i3, String errMsg, IGProVoiceSmobaGameBaseRoomInfo iGProVoiceSmobaGameBaseRoomInfo, IGProVoiceSmobaGameSmobaRoomInfo iGProVoiceSmobaGameSmobaRoomInfo, IGProVoiceSmobaGameRoomStateInfo iGProVoiceSmobaGameRoomStateInfo, String str) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QMGame.GuildGameRoomViewModel", 4, "createRoom " + i3 + " " + errMsg + " " + iGProVoiceSmobaGameBaseRoomInfo.getRoomId() + " " + str);
        aa aaVar = aa.f230980i;
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        aaVar.r(i3, errMsg);
        MediaChannelCore.INSTANCE.a().o0().j0(new GuildGameCreateBean(1, iGProVoiceSmobaGameRoomStateInfo, 0L, 0L, 0, null, 60, null));
        MutableLiveData<Pair<Boolean, String>> mutableLiveData = this$0.createRoomResult;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        mutableLiveData.setValue(new Pair<>(Boolean.valueOf(z16), errMsg));
        this$0.schemeObservable.setValue(new Pair<>(str, OperateCustomButton.OPERATE_CREATE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(h this$0, int i3, String str) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QMGame.GuildGameRoomViewModel", 4, "dismissRoom " + i3 + " " + str);
        MutableLiveData<Pair<Boolean, String>> mutableLiveData = this$0.dismissRoomResult;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        mutableLiveData.setValue(new Pair<>(Boolean.valueOf(z16), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u2(h this$0, int i3, String errMsg, String str) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("QMGame.GuildGameRoomViewModel", 4, "joinRoom " + i3 + " " + errMsg + " " + str);
        aa aaVar = aa.f230980i;
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        aaVar.q(i3, errMsg);
        this$0.schemeObservable.setValue(new Pair<>(str, IHWTroopUtilsApi.HOMEWORK_TROOP_JOIN_SOURCE));
        MutableLiveData<Pair<Boolean, String>> mutableLiveData = this$0.joinRoomResult;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        mutableLiveData.setValue(new Pair<>(Boolean.valueOf(z16), errMsg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w2(h this$0, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = true;
        QLog.d("QMGame.GuildGameRoomViewModel", 1, "quitRoom " + i3 + " " + errMsg);
        aa aaVar = aa.f230980i;
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        aaVar.p(i3, errMsg);
        MutableLiveData<Pair<Boolean, String>> mutableLiveData = this$0.quitRoomResult;
        if (i3 != 0) {
            z16 = false;
        }
        mutableLiveData.setValue(new Pair<>(Boolean.valueOf(z16), errMsg));
    }

    public final void R1(@NotNull RoomAuthParams roomAuthParams) {
        Intrinsics.checkNotNullParameter(roomAuthParams, "roomAuthParams");
        dh dhVar = new dh() { // from class: bt1.c
            @Override // vh2.dh
            public final void a(int i3, String str, int i16, IGProSecurityResult iGProSecurityResult, String str2, ArrayList arrayList) {
                h.S1(h.this, i3, str, i16, iGProSecurityResult, str2, arrayList);
            }
        };
        com.tencent.mobileqq.guild.media.game.service.repository.a a16 = GuildGameKernelServiceKt.a();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        a16.a(peekAppRuntime, roomAuthParams, dhVar);
    }

    public final void T1(@NotNull RoomAuthParams roomAuthParams) {
        Intrinsics.checkNotNullParameter(roomAuthParams, "roomAuthParams");
        dh dhVar = new dh() { // from class: bt1.b
            @Override // vh2.dh
            public final void a(int i3, String str, int i16, IGProSecurityResult iGProSecurityResult, String str2, ArrayList arrayList) {
                h.U1(h.this, i3, str, i16, iGProSecurityResult, str2, arrayList);
            }
        };
        com.tencent.mobileqq.guild.media.game.service.repository.a a16 = GuildGameKernelServiceKt.a();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        a16.a(peekAppRuntime, roomAuthParams, dhVar);
    }

    public final void W1(@NotNull dq gameModeInfo) {
        Intrinsics.checkNotNullParameter(gameModeInfo, "gameModeInfo");
        QLog.d("QMGame.GuildGameRoomViewModel", 1, "createRoom " + gameModeInfo.getId() + " - " + gameModeInfo.getName());
        fi fiVar = new fi();
        fiVar.f(1);
        fiVar.e(Long.parseLong(m.d(this.mediaChannelDataHub)));
        fiVar.d(Long.parseLong(m.b(this.mediaChannelDataHub)));
        fm fmVar = new fm();
        String id5 = gameModeInfo.getId();
        Intrinsics.checkNotNullExpressionValue(id5, "gameModeInfo.id");
        fmVar.b(Integer.parseInt(id5));
        eu euVar = new eu() { // from class: bt1.f
            @Override // wh2.eu
            public final void a(int i3, String str, IGProVoiceSmobaGameBaseRoomInfo iGProVoiceSmobaGameBaseRoomInfo, IGProVoiceSmobaGameSmobaRoomInfo iGProVoiceSmobaGameSmobaRoomInfo, IGProVoiceSmobaGameRoomStateInfo iGProVoiceSmobaGameRoomStateInfo, String str2) {
                h.X1(h.this, i3, str, iGProVoiceSmobaGameBaseRoomInfo, iGProVoiceSmobaGameSmobaRoomInfo, iGProVoiceSmobaGameRoomStateInfo, str2);
            }
        };
        com.tencent.mobileqq.guild.media.game.service.repository.a a16 = GuildGameKernelServiceKt.a();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        a16.b(peekAppRuntime, fiVar, fmVar, euVar);
    }

    public final void Z1(@NotNull String from) {
        Intrinsics.checkNotNullParameter(from, "from");
        if (Intrinsics.areEqual(from, OperateCustomButton.OPERATE_CREATE) && e2().getRoomInfo() != null) {
            IGProVoiceSmobaGameRoomStateInfo roomInfo = e2().getRoomInfo();
            boolean z16 = false;
            if (roomInfo != null && roomInfo.getRoomId() == 0) {
                z16 = true;
            }
            if (z16) {
                this.dismissRoomResult.setValue(new Pair<>(Boolean.FALSE, HardCodeUtil.qqStr(R.string.f1493211z)));
                return;
            }
            fj fjVar = new fj();
            IGProVoiceSmobaGameRoomStateInfo roomInfo2 = e2().getRoomInfo();
            Intrinsics.checkNotNull(roomInfo2);
            fjVar.g(roomInfo2.getRoomId());
            fjVar.f(Long.parseLong(m.d(this.mediaChannelDataHub)));
            fjVar.e(Long.parseLong(m.b(this.mediaChannelDataHub)));
            em emVar = new em() { // from class: bt1.g
                @Override // wh2.em
                public final void onResult(int i3, String str) {
                    h.a2(h.this, i3, str);
                }
            };
            com.tencent.mobileqq.guild.media.game.service.repository.a a16 = GuildGameKernelServiceKt.a();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
            a16.c(peekAppRuntime, fjVar, emVar);
        }
    }

    @NotNull
    public final MutableLiveData<GuildAuthGameBean> b2() {
        return this.authGameObservable;
    }

    @NotNull
    public final MutableLiveData<GuildAuthGameBean> c2() {
        return this.authJoinGameObservable;
    }

    @NotNull
    public final MutableLiveData<Boolean> d2() {
        return this.canClose;
    }

    @NotNull
    public final GuildGameCreateBean e2() {
        if (this.mediaChannelDataHub.o()) {
            return this.mediaChannelDataHub.n();
        }
        return new GuildGameCreateBean(0, null, 0L, 0L, 0, null, 63, null);
    }

    @NotNull
    public final MutableLiveData<Pair<Boolean, String>> f2() {
        return this.createRoomResult;
    }

    @NotNull
    public final MutableLiveData<Pair<Boolean, String>> g2() {
        return this.dismissRoomResult;
    }

    @NotNull
    public final String h2() {
        String str;
        IGProGuildThemeInfo value = this.mediaChannelDataHub.Q().getValue();
        if (value != null) {
            str = value.getSessionId();
        } else {
            str = null;
        }
        return String.valueOf(str);
    }

    @NotNull
    public final String i2() {
        String str;
        IGProVoiceSmobaGameGameStaticInfo gameInfo;
        IGProVoiceSmobaGameRoomStateInfo roomInfo = e2().getRoomInfo();
        if (roomInfo != null && (gameInfo = roomInfo.getGameInfo()) != null) {
            str = gameInfo.getGameMode();
        } else {
            str = null;
        }
        return String.valueOf(str);
    }

    public final int j2() {
        return this.mediaChannelDataHub.getUserInfoList().f228125a.size();
    }

    @NotNull
    public final MutableLiveData<Pair<Boolean, String>> k2() {
        return this.joinRoomResult;
    }

    @NotNull
    /* renamed from: l2, reason: from getter */
    public final l getMediaChannelDataHub() {
        return this.mediaChannelDataHub;
    }

    @NotNull
    public final MutableLiveData<Pair<Boolean, String>> m2() {
        return this.quitRoomResult;
    }

    @NotNull
    public final MutableLiveData<Pair<String, String>> n2() {
        return this.schemeObservable;
    }

    @NotNull
    public final String o2() {
        return this.mediaChannelDataHub.getSelfUserInfo().C.getUserInfoInGame().getIdentityDesc();
    }

    @NotNull
    public final String p2() {
        Long l3;
        IGProVoiceSmobaGameRoomStateInfo roomInfo = e2().getRoomInfo();
        if (roomInfo != null) {
            l3 = Long.valueOf(roomInfo.getRoomId());
        } else {
            l3 = null;
        }
        return String.valueOf(l3);
    }

    public final int q2() {
        IGProVoiceSmobaGameRoomStateInfo roomInfo = e2().getRoomInfo();
        if (roomInfo != null) {
            return roomInfo.getRoomState();
        }
        return 0;
    }

    @Nullable
    public final p r2(@NotNull String tinyId) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        return this.mediaChannelDataHub.getUserInfoList().g(tinyId);
    }

    @Nullable
    public final q s2(@NotNull String tinyId) {
        UserBusinessInfo userBusinessInfo;
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        p r26 = r2(tinyId);
        if (r26 != null && (userBusinessInfo = r26.C) != null) {
            return userBusinessInfo.getUserInfoInGame();
        }
        return null;
    }

    public final void t2() {
        IGProVoiceSmobaGameRoomStateInfo roomInfo = e2().getRoomInfo();
        boolean z16 = false;
        if (roomInfo != null && roomInfo.getRoomId() == 0) {
            z16 = true;
        }
        if (z16) {
            this.joinRoomResult.setValue(new Pair<>(Boolean.FALSE, HardCodeUtil.qqStr(R.string.f1493211z)));
            return;
        }
        ev evVar = new ev() { // from class: bt1.e
            @Override // wh2.ev
            public final void onEnterGProVoiceSmobaGameRoom(int i3, String str, String str2) {
                h.u2(h.this, i3, str, str2);
            }
        };
        com.tencent.mobileqq.guild.media.game.service.repository.a a16 = GuildGameKernelServiceKt.a();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        IGProVoiceSmobaGameRoomStateInfo roomInfo2 = e2().getRoomInfo();
        Intrinsics.checkNotNull(roomInfo2);
        long roomId = roomInfo2.getRoomId();
        IGProVoiceSmobaGameRoomStateInfo roomInfo3 = e2().getRoomInfo();
        Intrinsics.checkNotNull(roomInfo3);
        a16.d(peekAppRuntime, roomId, roomInfo3.getRoomType(), Long.parseLong(m.d(this.mediaChannelDataHub)), Long.parseLong(m.b(this.mediaChannelDataHub)), evVar);
    }

    public final void v2() {
        fl flVar = new fl();
        IGProVoiceSmobaGameRoomStateInfo roomInfo = e2().getRoomInfo();
        Intrinsics.checkNotNull(roomInfo);
        flVar.g(roomInfo.getRoomId());
        flVar.f(Long.parseLong(m.d(this.mediaChannelDataHub)));
        flVar.e(Long.parseLong(m.b(this.mediaChannelDataHub)));
        if (flVar.d() == 0) {
            QLog.d("QMGame.GuildGameRoomViewModel", 1, "quitRoom room already dismiss");
            aa.f230980i.p(0, "");
            this.quitRoomResult.setValue(new Pair<>(Boolean.TRUE, ""));
        } else {
            ew ewVar = new ew() { // from class: bt1.d
                @Override // wh2.ew
                public final void onVoiceSmobaGameQuitRoomCallback(int i3, String str) {
                    h.w2(h.this, i3, str);
                }
            };
            com.tencent.mobileqq.guild.media.game.service.repository.a a16 = GuildGameKernelServiceKt.a();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
            a16.e(peekAppRuntime, flVar, ewVar);
        }
    }

    public final void x2() {
        this.roomStateObservable.setValue(RoomState.Origin);
        this.gameDurationObservable.setValue(0);
        this.authGameObservable.setValue(null);
        this.authJoinGameObservable.setValue(null);
        this.createRoomResult.setValue(null);
        this.dismissRoomResult.setValue(null);
        this.schemeObservable.setValue(null);
        this.joinRoomResult.setValue(null);
        this.quitRoomResult.setValue(null);
    }

    public final void y2() {
        aa.f230980i.n(q2(), 0, "");
        j.a().d(1);
    }

    public final void z2() {
        boolean z16;
        MutableLiveData<Boolean> mutableLiveData = this.canClose;
        if (!Intrinsics.areEqual(String.valueOf(m.e(j.c())), j.c().getSelfUserInfo().f228093a) && !ch.h0(m.b(j.c())) && !ch.m0(m.d(j.c()))) {
            z16 = false;
        } else {
            z16 = true;
        }
        mutableLiveData.setValue(Boolean.valueOf(z16));
    }
}
