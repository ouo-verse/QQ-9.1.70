package com.tencent.timi.game.component.gamecore.impl;

import ag4.i;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.timi.game.component.gamecore.impl.GameCoreServiceImpl;
import com.tencent.timi.game.component.gamecore.impl.db.UserGameInfoEntity;
import com.tencent.timi.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.timi.game.utils.l;
import fg4.j;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameAuthOuterClass$CancelGameAuthRsp;
import trpc.yes.common.GameAuthOuterClass$GetGameAuthRsp;
import trpc.yes.common.UserProxyCmdOuterClass$GetTgpaVersionInfoRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameRoleListRsp;
import trpc.yes.common.YesGameInfoOuterClass$SetUserGameDefaultRoleRsp;
import trpc.yes.common.YesGameInfoOuterClass$YesGameRoleAbsInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 e2\u00020\u0001:\u0001TB\u0007\u00a2\u0006\u0004\bc\u0010dJ\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0002J\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016J,\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001bH\u0016J\"\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u001bH\u0016J\"\u0010 \u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u001bH\u0016J\"\u0010!\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001bH\u0016J\"\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001bH\u0016J\"\u0010#\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u001bH\u0016J\"\u0010$\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u001bH\u0016JJ\u00100\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+2\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.\u0018\u00010-H\u0016J\"\u00102\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u000101\u0018\u00010\u001bH\u0016J\u0010\u00103\u001a\u00020'2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u00104\u001a\u00020'2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J4\u0010;\u001a\u00020'2\u0006\u0010\u0003\u001a\u00020\u00022\b\u00105\u001a\u0004\u0018\u00010%2\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u000109H\u0016J2\u0010A\u001a\u00020\u000b2\b\u0010<\u001a\u0004\u0018\u00010.2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010=\u001a\u00020'2\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010>H\u0016JB\u0010D\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020.0B2\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016J4\u0010E\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+H\u0016JJ\u0010F\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010,\u001a\u0004\u0018\u00010+2\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.\u0018\u00010-H\u0016J*\u0010H\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\u0006\u0010G\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010+H\u0016J\"\u0010I\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\b\u0010\u001d\u001a\u0004\u0018\u00010+H\u0016J\"\u0010J\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\b\u0010\u001d\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010K\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010M\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010LH\u0016J\b\u0010N\u001a\u00020\u000bH\u0016J\u0018\u0010O\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0007J\u0016\u0010P\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tJ\u0018\u0010Q\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0005R@\u0010V\u001a.\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00040Rj\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004`S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR@\u0010X\u001a.\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00040Rj\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004`S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010UR<\u0010Z\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040Rj\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0004`S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010UR\u0014\u0010^\u001a\u00020[8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0014\u0010b\u001a\u00020_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010a\u00a8\u0006f"}, d2 = {"Lcom/tencent/timi/game/component/gamecore/impl/GameCoreServiceImpl;", "Lag4/i;", "", "yesGameId", "Landroidx/lifecycle/MutableLiveData;", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "X3", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameRoleListRsp;", "Z3", "Ltrpc/yes/common/GameAuthOuterClass$GetGameAuthRsp;", "Y3", "", ICustomDataEditor.STRING_ARRAY_PARAM_4, "rsp", "h4", "i4", "j4", "initRegisterDatabaseModelClass", "Landroidx/lifecycle/LiveData;", "B2", "p4", Constants.BASE_IN_PLUGIN_VERSION, "q4", "G0", "o4", "Ltrpc/yes/common/YesGameInfoOuterClass$YesGameRoleAbsInfo;", "defaultInfo", "Lag4/i$b;", "Ltrpc/yes/common/YesGameInfoOuterClass$SetUserGameDefaultRoleRsp;", "callback", "e1", ICustomDataEditor.STRING_PARAM_3, "M1", "m2", "s0", "I1", "J2", "Landroid/app/Activity;", "context", "", "autoShowAccountSelect", "Lag4/i$a;", "authCallback", "Lag4/i$d;", "bindAccountCallback", "", "", "extraInfo", ICustomDataEditor.NUMBER_PARAM_4, "Ltrpc/yes/common/GameAuthOuterClass$CancelGameAuthRsp;", "Z", "Q2", "O2", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lag4/e;", "gameGangupCheckParam", "isSiliently", "Lag4/d;", "gameGangupCheckCallback", "L1", "xid", "notifyUpdate", "Lpl4/d;", "Ltrpc/yes/common/UserProxyCmdOuterClass$GetTgpaVersionInfoRsp;", "requestListener", "e3", "", "authDesc", "k4", "l4", "m4", "GetUserGameRoleListRsp", "I2", "J1", "A1", "A0", "Landroid/content/Context;", "init", "o2", "g4", "e4", "f4", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "defaultGameAccountMap", "b", "gameAccountListMap", "c", "gameAuthInfoMap", "Lcg4/a;", "d", "Lcg4/a;", "mAccountRepo", "Ldg4/a;", "e", "Ldg4/a;", "mAuthInfoRepo", "<init>", "()V", "f", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class GameCoreServiceImpl implements ag4.i {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Lazy<GameCoreServiceImpl> f376717g;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, MutableLiveData<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp>> defaultGameAccountMap = new HashMap<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, MutableLiveData<YesGameInfoOuterClass$GetUserGameRoleListRsp>> gameAccountListMap = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, MutableLiveData<GameAuthOuterClass$GetGameAuthRsp>> gameAuthInfoMap = new HashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final cg4.a mAccountRepo = new cg4.a();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final dg4.a mAuthInfoRepo = new dg4.a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/timi/game/component/gamecore/impl/GameCoreServiceImpl$a;", "", "Lcom/tencent/timi/game/component/gamecore/impl/GameCoreServiceImpl;", "INSTANCE$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/timi/game/component/gamecore/impl/GameCoreServiceImpl;", "INSTANCE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.component.gamecore.impl.GameCoreServiceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GameCoreServiceImpl a() {
            return (GameCoreServiceImpl) GameCoreServiceImpl.f376717g.getValue();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/component/gamecore/impl/GameCoreServiceImpl$b", "Lag4/i$b;", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;", "", "result", "", "errorCode", "", "errorMsg", "rsp", "", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements i.b<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f376724b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ i.b<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> f376725c;

        b(int i3, i.b<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> bVar) {
            this.f376724b = i3;
            this.f376725c = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(GameCoreServiceImpl this$0, int i3, YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp, i.b bVar) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.i4(i3, yesGameInfoOuterClass$GetUserGameDefaultRoleRsp);
            if (bVar != null) {
                bVar.i(true, 0, "", yesGameInfoOuterClass$GetUserGameDefaultRoleRsp);
            }
        }

        @Override // ag4.i.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void i(boolean result, int errorCode, @Nullable String errorMsg, @Nullable final YesGameInfoOuterClass$GetUserGameDefaultRoleRsp rsp) {
            if (result && rsp != null && cg4.b.a(rsp)) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final GameCoreServiceImpl gameCoreServiceImpl = GameCoreServiceImpl.this;
                final int i3 = this.f376724b;
                final i.b<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> bVar = this.f376725c;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.timi.game.component.gamecore.impl.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameCoreServiceImpl.b.c(GameCoreServiceImpl.this, i3, rsp, bVar);
                    }
                });
                return;
            }
            GameCoreServiceImpl.this.m2(this.f376724b, this.f376725c);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/component/gamecore/impl/GameCoreServiceImpl$c", "Lag4/i$b;", "Ltrpc/yes/common/GameAuthOuterClass$GetGameAuthRsp;", "", "result", "", "errorCode", "", "errorMsg", "rsp", "", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements i.b<GameAuthOuterClass$GetGameAuthRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f376727b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ i.b<GameAuthOuterClass$GetGameAuthRsp> f376728c;

        c(int i3, i.b<GameAuthOuterClass$GetGameAuthRsp> bVar) {
            this.f376727b = i3;
            this.f376728c = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(GameCoreServiceImpl this$0, int i3, GameAuthOuterClass$GetGameAuthRsp gameAuthOuterClass$GetGameAuthRsp, i.b bVar) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.h4(i3, gameAuthOuterClass$GetGameAuthRsp);
            if (bVar != null) {
                bVar.i(true, 0, "", gameAuthOuterClass$GetGameAuthRsp);
            }
        }

        @Override // ag4.i.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void i(boolean result, int errorCode, @Nullable String errorMsg, @Nullable final GameAuthOuterClass$GetGameAuthRsp rsp) {
            if (result && rsp != null) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final GameCoreServiceImpl gameCoreServiceImpl = GameCoreServiceImpl.this;
                final int i3 = this.f376727b;
                final i.b<GameAuthOuterClass$GetGameAuthRsp> bVar = this.f376728c;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.timi.game.component.gamecore.impl.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameCoreServiceImpl.c.c(GameCoreServiceImpl.this, i3, rsp, bVar);
                    }
                });
                return;
            }
            GameCoreServiceImpl.this.I1(this.f376727b, this.f376728c);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/component/gamecore/impl/GameCoreServiceImpl$d", "Lag4/i$b;", "Ltrpc/yes/common/YesGameInfoOuterClass$GetUserGameRoleListRsp;", "", "result", "", "errorCode", "", "errorMsg", "rsp", "", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements i.b<YesGameInfoOuterClass$GetUserGameRoleListRsp> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f376730b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ i.b<YesGameInfoOuterClass$GetUserGameRoleListRsp> f376731c;

        d(int i3, i.b<YesGameInfoOuterClass$GetUserGameRoleListRsp> bVar) {
            this.f376730b = i3;
            this.f376731c = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(i.b bVar, YesGameInfoOuterClass$GetUserGameRoleListRsp yesGameInfoOuterClass$GetUserGameRoleListRsp) {
            if (bVar != null) {
                bVar.i(true, 0, "", yesGameInfoOuterClass$GetUserGameRoleListRsp);
            }
        }

        @Override // ag4.i.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void i(boolean result, int errorCode, @Nullable String errorMsg, @Nullable final YesGameInfoOuterClass$GetUserGameRoleListRsp rsp) {
            if (result && rsp != null) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final i.b<YesGameInfoOuterClass$GetUserGameRoleListRsp> bVar = this.f376731c;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.timi.game.component.gamecore.impl.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        GameCoreServiceImpl.d.c(i.b.this, rsp);
                    }
                });
                return;
            }
            GameCoreServiceImpl.this.s3(this.f376730b, this.f376731c);
        }
    }

    static {
        Lazy<GameCoreServiceImpl> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<GameCoreServiceImpl>() { // from class: com.tencent.timi.game.component.gamecore.impl.GameCoreServiceImpl$Companion$INSTANCE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GameCoreServiceImpl invoke() {
                return new GameCoreServiceImpl();
            }
        });
        f376717g = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V3(GameCoreServiceImpl this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a4(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W3(GameCoreServiceImpl this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeUnit.sleep(500L);
        this$0.I1(i3, null);
        timeUnit.sleep(500L);
        this$0.m2(i3, null);
        timeUnit.sleep(500L);
        this$0.s3(i3, null);
    }

    private final MutableLiveData<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> X3(int yesGameId) {
        MutableLiveData<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> mutableLiveData = this.defaultGameAccountMap.get(Integer.valueOf(yesGameId));
        if (mutableLiveData == null) {
            MutableLiveData<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> mutableLiveData2 = new MutableLiveData<>();
            this.defaultGameAccountMap.put(Integer.valueOf(yesGameId), mutableLiveData2);
            return mutableLiveData2;
        }
        return mutableLiveData;
    }

    private final MutableLiveData<GameAuthOuterClass$GetGameAuthRsp> Y3(int yesGameId) {
        MutableLiveData<GameAuthOuterClass$GetGameAuthRsp> mutableLiveData = this.gameAuthInfoMap.get(Integer.valueOf(yesGameId));
        if (mutableLiveData == null) {
            MutableLiveData<GameAuthOuterClass$GetGameAuthRsp> mutableLiveData2 = new MutableLiveData<>();
            this.gameAuthInfoMap.put(Integer.valueOf(yesGameId), mutableLiveData2);
            return mutableLiveData2;
        }
        return mutableLiveData;
    }

    private final MutableLiveData<YesGameInfoOuterClass$GetUserGameRoleListRsp> Z3(int yesGameId) {
        MutableLiveData<YesGameInfoOuterClass$GetUserGameRoleListRsp> mutableLiveData = this.gameAccountListMap.get(Integer.valueOf(yesGameId));
        if (mutableLiveData == null) {
            MutableLiveData<YesGameInfoOuterClass$GetUserGameRoleListRsp> mutableLiveData2 = new MutableLiveData<>();
            this.gameAccountListMap.put(Integer.valueOf(yesGameId), mutableLiveData2);
            return mutableLiveData2;
        }
        return mutableLiveData;
    }

    private final void a4(final int yesGameId) {
        eg4.g gVar = eg4.g.f396273a;
        final GameAuthOuterClass$GetGameAuthRsp g16 = gVar.g(yesGameId);
        if (g16 != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.component.gamecore.impl.d
                @Override // java.lang.Runnable
                public final void run() {
                    GameCoreServiceImpl.b4(GameAuthOuterClass$GetGameAuthRsp.this, this, yesGameId);
                }
            });
        }
        final YesGameInfoOuterClass$GetUserGameDefaultRoleRsp j3 = gVar.j(yesGameId);
        if (j3 != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.component.gamecore.impl.e
                @Override // java.lang.Runnable
                public final void run() {
                    GameCoreServiceImpl.c4(YesGameInfoOuterClass$GetUserGameDefaultRoleRsp.this, this, yesGameId);
                }
            });
        }
        final YesGameInfoOuterClass$GetUserGameRoleListRsp m3 = gVar.m(yesGameId);
        if (m3 != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.component.gamecore.impl.f
                @Override // java.lang.Runnable
                public final void run() {
                    GameCoreServiceImpl.d4(YesGameInfoOuterClass$GetUserGameRoleListRsp.this, this, yesGameId);
                }
            });
        }
        l.i("UserGameInfoManager_", "loadCacheDataFromDB authInfo:" + g16 + ", defaultAccount:" + j3 + ", accountList:" + m3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b4(GameAuthOuterClass$GetGameAuthRsp this_run, GameCoreServiceImpl this$0, int i3) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l.i("UserGameInfoManager_", "loadCacheDataFromDB authInfo:" + this_run);
        this$0.h4(i3, this_run);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c4(YesGameInfoOuterClass$GetUserGameDefaultRoleRsp this_run, GameCoreServiceImpl this$0, int i3) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l.i("UserGameInfoManager_", "loadCacheDataFromDB defaultAccount:" + this_run);
        this$0.i4(i3, this_run);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d4(YesGameInfoOuterClass$GetUserGameRoleListRsp this_run, GameCoreServiceImpl this$0, int i3) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        l.i("UserGameInfoManager_", "loadCacheDataFromDB accountList:" + this_run);
        this$0.j4(i3, this_run);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h4(int yesGameId, GameAuthOuterClass$GetGameAuthRsp rsp) {
        o4(yesGameId, rsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i4(int yesGameId, YesGameInfoOuterClass$GetUserGameDefaultRoleRsp rsp) {
        p4(yesGameId, rsp);
    }

    private final void j4(int yesGameId, YesGameInfoOuterClass$GetUserGameRoleListRsp rsp) {
        q4(yesGameId, rsp);
    }

    @Override // ag4.i
    public void A0(final int yesGameId) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.timi.game.component.gamecore.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                GameCoreServiceImpl.V3(GameCoreServiceImpl.this, yesGameId);
            }
        }, 32, null, true);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.timi.game.component.gamecore.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                GameCoreServiceImpl.W3(GameCoreServiceImpl.this, yesGameId);
            }
        }, 128, null, true);
    }

    @Override // ag4.i
    public void A1(int yesGameId, @NotNull Activity context, @Nullable i.d callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        hg4.c.f404865a.u(yesGameId, context, callback);
    }

    @Override // ag4.i
    @NotNull
    public LiveData<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> B2(int yesGameId) {
        return X3(yesGameId);
    }

    @Override // ag4.i
    @NotNull
    public LiveData<YesGameInfoOuterClass$GetUserGameRoleListRsp> D2(int yesGameId) {
        return Z3(yesGameId);
    }

    @Override // ag4.i
    public /* bridge */ /* synthetic */ void F3(int i3, Activity activity, Boolean bool, i.a aVar, i.d dVar) {
        l4(i3, activity, bool.booleanValue(), aVar, dVar);
    }

    @Override // ag4.i
    @NotNull
    public LiveData<GameAuthOuterClass$GetGameAuthRsp> G0(int yesGameId) {
        return Y3(yesGameId);
    }

    @Override // ag4.i
    public void I1(int yesGameId, @Nullable i.b<GameAuthOuterClass$GetGameAuthRsp> callback) {
        this.mAuthInfoRepo.b(yesGameId, callback);
    }

    @Override // ag4.i
    public void I2(int yesGameId, @NotNull Activity context, @NotNull YesGameInfoOuterClass$GetUserGameRoleListRsp GetUserGameRoleListRsp, @Nullable i.d callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(GetUserGameRoleListRsp, "GetUserGameRoleListRsp");
        hg4.c.k(hg4.c.f404865a, yesGameId, context, GetUserGameRoleListRsp, callback, null, 16, null);
    }

    @Override // ag4.i
    public void J1(int yesGameId, @NotNull Activity context, @Nullable i.d callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        hg4.c.j(hg4.c.f404865a, yesGameId, context, callback, null, 8, null);
    }

    @Override // ag4.i
    public void J2(int yesGameId, @Nullable i.b<GameAuthOuterClass$GetGameAuthRsp> callback) {
        eg4.g.f396273a.h(yesGameId, new c(yesGameId, callback));
    }

    @Override // ag4.i
    public boolean L1(int yesGameId, @Nullable Activity activity, @NotNull ag4.e gameGangupCheckParam, boolean isSiliently, @Nullable ag4.d gameGangupCheckCallback) {
        Intrinsics.checkNotNullParameter(gameGangupCheckParam, "gameGangupCheckParam");
        return hg4.d.h(yesGameId, activity, gameGangupCheckParam, isSiliently, gameGangupCheckCallback);
    }

    @Override // ag4.i
    public void M1(int yesGameId, @Nullable i.b<YesGameInfoOuterClass$GetUserGameRoleListRsp> callback) {
        eg4.g.f396273a.n(yesGameId, new d(yesGameId, callback));
    }

    @Override // ag4.i
    public /* bridge */ /* synthetic */ void N2(int i3, Activity activity, Boolean bool, i.a aVar, i.d dVar, Map map) {
        m4(i3, activity, bool.booleanValue(), aVar, dVar, map);
    }

    @Override // ag4.i
    public boolean O2(int yesGameId, @Nullable Activity context) {
        return hg4.d.o(yesGameId, context);
    }

    @Override // ag4.i
    public boolean Q2(int yesGameId) {
        return hg4.d.n(yesGameId);
    }

    @Override // ag4.i
    public void Z(int yesGameId, @Nullable i.b<GameAuthOuterClass$CancelGameAuthRsp> callback) {
        this.mAuthInfoRepo.a(yesGameId, callback);
    }

    @Override // ag4.i
    public void e1(int yesGameId, @Nullable YesGameInfoOuterClass$YesGameRoleAbsInfo defaultInfo, @Nullable i.b<YesGameInfoOuterClass$SetUserGameDefaultRoleRsp> callback) {
        this.mAccountRepo.c(yesGameId, defaultInfo, callback);
    }

    @Override // ag4.i
    public void e3(@Nullable String xid, int yesGameId, boolean notifyUpdate, @Nullable pl4.d<UserProxyCmdOuterClass$GetTgpaVersionInfoRsp> requestListener) {
        j.e(xid, yesGameId, notifyUpdate, requestListener);
    }

    public final void e4(int yesGameId, @NotNull GameAuthOuterClass$GetGameAuthRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        l.i("UserGameInfoManager_", "onGetGameAuthInfoFromServer rsp:" + rsp);
        h4(yesGameId, rsp);
        eg4.g.f396273a.t(yesGameId, rsp);
    }

    public final void f4(int yesGameId, @Nullable YesGameInfoOuterClass$GetUserGameDefaultRoleRsp rsp) {
        l.i("UserGameInfoManager_", "onGetGameDefaultAccountFromServer rsp:" + rsp);
        i4(yesGameId, rsp);
        eg4.g.f396273a.w(yesGameId, rsp);
    }

    public final void g4(int yesGameId, @Nullable YesGameInfoOuterClass$GetUserGameRoleListRsp rsp) {
        l.i("UserGameInfoManager_", "onGetGameRoleInfoListFromServer rsp:" + rsp);
        j4(yesGameId, rsp);
        eg4.g.f396273a.q(yesGameId, rsp);
    }

    @Override // ag4.i
    public void initRegisterDatabaseModelClass() {
        YesDataBaseHelper.l(new UserGameInfoEntity(), null);
    }

    public void k4(int yesGameId, @NotNull Activity context, @NotNull List<String> authDesc, boolean autoShowAccountSelect, @Nullable i.a authCallback, @Nullable i.d bindAccountCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(authDesc, "authDesc");
        hg4.c.p(hg4.c.f404865a, yesGameId, context, authDesc, autoShowAccountSelect, authCallback, bindAccountCallback, null, 64, null);
    }

    public void l4(int yesGameId, @NotNull Activity context, boolean autoShowAccountSelect, @Nullable i.a authCallback, @Nullable i.d bindAccountCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        hg4.c.n(hg4.c.f404865a, yesGameId, context, autoShowAccountSelect, authCallback, bindAccountCallback, null, 32, null);
    }

    @Override // ag4.i
    public void m2(int yesGameId, @Nullable i.b<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> callback) {
        this.mAccountRepo.a(yesGameId, callback);
    }

    public void m4(int yesGameId, @NotNull Activity context, boolean autoShowAccountSelect, @Nullable i.a authCallback, @Nullable i.d bindAccountCallback, @Nullable Map<String, String> extraInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        HashMap hashMap = new HashMap();
        if (extraInfo != null) {
            hashMap.putAll(extraInfo);
        }
        hg4.c.f404865a.l(yesGameId, context, autoShowAccountSelect, authCallback, bindAccountCallback, hashMap);
    }

    public void n4(int yesGameId, @NotNull Activity context, boolean autoShowAccountSelect, @Nullable i.a authCallback, @Nullable i.d bindAccountCallback, @Nullable Map<String, String> extraInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        HashMap hashMap = new HashMap();
        if (extraInfo != null) {
            hashMap.putAll(extraInfo);
        }
        hg4.c.f404865a.q(yesGameId, context, autoShowAccountSelect, authCallback, bindAccountCallback, hashMap);
    }

    @Override // mm4.a
    public void o2() {
        this.defaultGameAccountMap.clear();
        this.gameAccountListMap.clear();
        this.gameAuthInfoMap.clear();
    }

    @Override // ag4.i
    public /* bridge */ /* synthetic */ void o3(int i3, Activity activity, List list, Boolean bool, i.a aVar, i.d dVar) {
        k4(i3, activity, list, bool.booleanValue(), aVar, dVar);
    }

    public void o4(int yesGameId, @NotNull GameAuthOuterClass$GetGameAuthRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        Y3(yesGameId).setValue(rsp);
    }

    public void p4(int yesGameId, @Nullable YesGameInfoOuterClass$GetUserGameDefaultRoleRsp rsp) {
        X3(yesGameId).setValue(rsp);
    }

    @Override // ag4.i
    public /* bridge */ /* synthetic */ void q1(int i3, Activity activity, Boolean bool, i.a aVar, i.d dVar, Map map) {
        n4(i3, activity, bool.booleanValue(), aVar, dVar, map);
    }

    public void q4(int yesGameId, @Nullable YesGameInfoOuterClass$GetUserGameRoleListRsp rsp) {
        Z3(yesGameId).setValue(rsp);
    }

    @Override // ag4.i
    public void s0(int yesGameId, @Nullable i.b<YesGameInfoOuterClass$GetUserGameDefaultRoleRsp> callback) {
        eg4.g.f396273a.k(yesGameId, new b(yesGameId, callback));
    }

    @Override // ag4.i
    public void s3(int yesGameId, @Nullable i.b<YesGameInfoOuterClass$GetUserGameRoleListRsp> callback) {
        this.mAccountRepo.b(yesGameId, callback);
    }

    @Override // mm4.a
    public void init(@Nullable Context context) {
    }
}
