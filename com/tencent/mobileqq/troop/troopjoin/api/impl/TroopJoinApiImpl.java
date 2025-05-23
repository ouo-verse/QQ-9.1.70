package com.tencent.mobileqq.troop.troopjoin.api.impl;

import android.content.Context;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.config.b;
import com.tencent.mobileqq.troop.f;
import com.tencent.mobileqq.troop.g;
import com.tencent.mobileqq.troop.troopjoin.TryJoinTroopResult;
import com.tencent.mobileqq.troop.troopjoin.api.ITroopJoinApi;
import com.tencent.mobileqq.troop.troopjoin.modules.subtroop.switchDialog.d;
import com.tencent.mobileqq.troop.troopjoin.parser.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.trpcprotocol.TroopJoinQunAutoSwitch$RetrieveSubGroupRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&JP\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000426\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006H\u0016JX\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u001026\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006H\u0016JT\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00102:\u0010\u000e\u001a6\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\r0\u0006j\u0002`\u0019H\u0016Jf\u0010\u001e\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00102:\u0010\u000e\u001a6\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\r0\u0006j\u0002`\u0019H\u0016J0\u0010\"\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0013H\u0016J\u000e\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010#H\u0016\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/troop/troopjoin/api/impl/TroopJoinApiImpl;", "Lcom/tencent/mobileqq/troop/troopjoin/api/ITroopJoinApi;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/troop/troopjoin/a;", "param", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/troop/troopjoin/TryJoinTroopResult;", "Lkotlin/ParameterName;", "name", "result", "", "bizErrorCode", "", "callback", "joinTroop", "", "skipCheck", "tryLaunchJoinTroop", "", "troopId", "isFromTroopCard", "needShow", "Ltencent/trpcprotocol/TroopJoinQunAutoSwitch$RetrieveSubGroupRsp;", "subTroopInfo", "Lcom/tencent/mobileqq/troop/troopjoin/api/CallBackSubTroopFun;", "needShowSubTroopWithTroopId", "troopUin", "troopMemberCount", "troopMaxMemberCount", "needShowSubTroopWithTroopInfo", "mainTroopId", "sourceId", "sourcePageDTId", "showSwitchSubTroop", "Ljava/lang/Class;", "getJoinTroopJumpParser", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopJoinApiImpl implements ITroopJoinApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String ENABLE_SHOW_SUB_TROOP_CONFIG_ID = "101104";

    @NotNull
    private static final String Log_TAG = "TroopJoinApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/troopjoin/api/impl/TroopJoinApiImpl$a;", "", "", "ENABLE_SHOW_SUB_TROOP_CONFIG_ID", "Ljava/lang/String;", "Log_TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopjoin.api.impl.TroopJoinApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57929);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopJoinApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void tryLaunchJoinTroop$lambda$1(com.tencent.mobileqq.troop.troopjoin.a param, Function2 callback, String troopUin, int i3) {
        Intrinsics.checkNotNullParameter(param, "$param");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        if (!Intrinsics.areEqual(param.f(), troopUin)) {
            return;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    callback.invoke(TryJoinTroopResult.HAS_LAUNCH, Integer.valueOf(i3));
                    return;
                } else {
                    callback.invoke(TryJoinTroopResult.PARAMS_ERROR, Integer.valueOf(i3));
                    return;
                }
            }
            callback.invoke(TryJoinTroopResult.HAS_JOINED, Integer.valueOf(i3));
            return;
        }
        callback.invoke(TryJoinTroopResult.NOTHING, Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.troop.troopjoin.api.ITroopJoinApi
    @Nullable
    public Class<?> getJoinTroopJumpParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Class) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return c.class;
    }

    @Override // com.tencent.mobileqq.troop.troopjoin.api.ITroopJoinApi
    public void joinTroop(@NotNull final Context context, @NotNull final com.tencent.mobileqq.troop.troopjoin.a param, @NotNull final Function2<? super TryJoinTroopResult, ? super Integer, Unit> callback) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, param, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d(Log_TAG, 2, "joinTroop invoked.");
        if (param.f().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (param.a().length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
                    callback.invoke(TryJoinTroopResult.SYS_ERROR, 0);
                    return;
                }
                TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(param.f());
                if (param.e() == 1003) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (troopInfoFromCache != null && troopInfoFromCache.hadJoinTroop()) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                if (z19) {
                    callback.invoke(TryJoinTroopResult.HAS_JOINED, 0);
                    return;
                }
                if (param.b()) {
                    if (troopInfoFromCache != null && troopInfoFromCache.wMemberNum > 0 && troopInfoFromCache.wMemberMax > 0) {
                        needShowSubTroopWithTroopInfo(param.f(), troopInfoFromCache.wMemberNum, troopInfoFromCache.wMemberMax, z18, new Function2<Boolean, TroopJoinQunAutoSwitch$RetrieveSubGroupRsp, Unit>(context, param, callback) { // from class: com.tencent.mobileqq.troop.troopjoin.api.impl.TroopJoinApiImpl$joinTroop$1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ Function2<TryJoinTroopResult, Integer, Unit> $callback;
                            final /* synthetic */ Context $context;
                            final /* synthetic */ com.tencent.mobileqq.troop.troopjoin.a $param;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                                this.$context = context;
                                this.$param = param;
                                this.$callback = callback;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, TroopJoinApiImpl.this, context, param, callback);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopJoinQunAutoSwitch$RetrieveSubGroupRsp troopJoinQunAutoSwitch$RetrieveSubGroupRsp) {
                                invoke(bool.booleanValue(), troopJoinQunAutoSwitch$RetrieveSubGroupRsp);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z26, @NotNull TroopJoinQunAutoSwitch$RetrieveSubGroupRsp subTroopInfo) {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z26), subTroopInfo);
                                    return;
                                }
                                Intrinsics.checkNotNullParameter(subTroopInfo, "subTroopInfo");
                                if (z26) {
                                    TroopJoinApiImpl.this.showSwitchSubTroop(this.$context, this.$param.f(), subTroopInfo, this.$param.e(), this.$param.c());
                                } else {
                                    TroopJoinApiImpl.this.tryLaunchJoinTroop(this.$context, this.$param, true, this.$callback);
                                }
                            }
                        });
                        return;
                    } else {
                        needShowSubTroopWithTroopId(param.f(), z18, new Function2<Boolean, TroopJoinQunAutoSwitch$RetrieveSubGroupRsp, Unit>(context, param, callback) { // from class: com.tencent.mobileqq.troop.troopjoin.api.impl.TroopJoinApiImpl$joinTroop$2
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ Function2<TryJoinTroopResult, Integer, Unit> $callback;
                            final /* synthetic */ Context $context;
                            final /* synthetic */ com.tencent.mobileqq.troop.troopjoin.a $param;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                                this.$context = context;
                                this.$param = param;
                                this.$callback = callback;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, TroopJoinApiImpl.this, context, param, callback);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopJoinQunAutoSwitch$RetrieveSubGroupRsp troopJoinQunAutoSwitch$RetrieveSubGroupRsp) {
                                invoke(bool.booleanValue(), troopJoinQunAutoSwitch$RetrieveSubGroupRsp);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(boolean z26, @NotNull TroopJoinQunAutoSwitch$RetrieveSubGroupRsp subTroopInfo) {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z26), subTroopInfo);
                                    return;
                                }
                                Intrinsics.checkNotNullParameter(subTroopInfo, "subTroopInfo");
                                if (z26) {
                                    TroopJoinApiImpl.this.showSwitchSubTroop(this.$context, this.$param.f(), subTroopInfo, this.$param.e(), this.$param.c());
                                } else {
                                    TroopJoinApiImpl.this.tryLaunchJoinTroop(this.$context, this.$param, true, this.$callback);
                                }
                            }
                        });
                        return;
                    }
                }
                tryLaunchJoinTroop(context, param, true, callback);
                return;
            }
        }
        callback.invoke(TryJoinTroopResult.PARAMS_ERROR, -1);
    }

    @Override // com.tencent.mobileqq.troop.troopjoin.api.ITroopJoinApi
    public void needShowSubTroopWithTroopId(@NotNull final String troopId, boolean isFromTroopCard, @NotNull final Function2<? super Boolean, ? super TroopJoinQunAutoSwitch$RetrieveSubGroupRsp, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, troopId, Boolean.valueOf(isFromTroopCard), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopId, "troopId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!b.f294691a.h(ENABLE_SHOW_SUB_TROOP_CONFIG_ID, false)) {
            callback.invoke(Boolean.FALSE, new TroopJoinQunAutoSwitch$RetrieveSubGroupRsp());
        } else {
            com.tencent.mobileqq.troop.troopjoin.modules.subtroop.repository.c.f300484a.a(troopId, new Function1<TroopJoinQunAutoSwitch$RetrieveSubGroupRsp, Unit>(troopId, callback) { // from class: com.tencent.mobileqq.troop.troopjoin.api.impl.TroopJoinApiImpl$needShowSubTroopWithTroopId$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function2<Boolean, TroopJoinQunAutoSwitch$RetrieveSubGroupRsp, Unit> $callback;
                final /* synthetic */ String $troopId;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.$troopId = troopId;
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) troopId, (Object) callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(TroopJoinQunAutoSwitch$RetrieveSubGroupRsp troopJoinQunAutoSwitch$RetrieveSubGroupRsp) {
                    invoke2(troopJoinQunAutoSwitch$RetrieveSubGroupRsp);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull TroopJoinQunAutoSwitch$RetrieveSubGroupRsp it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    PBStringField pBStringField = it.group_id;
                    String str = pBStringField != null ? pBStringField.get() : null;
                    if (str == null) {
                        str = "";
                    }
                    PBStringField pBStringField2 = it.auth_sign;
                    String str2 = pBStringField2 != null ? pBStringField2.get() : null;
                    String str3 = str2 != null ? str2 : "";
                    if (str.length() > 0) {
                        if (str3.length() > 0) {
                            QLog.i("TroopJoinApiImpl", 1, "the troop has sub troop and need switch sub troop, [troopId:" + this.$troopId + " subTroopId:" + str + "]");
                            this.$callback.invoke(Boolean.TRUE, it);
                            return;
                        }
                    }
                    QLog.i("TroopJoinApiImpl", 1, "sub troop id or auth sign invalid, no sub troop");
                    this.$callback.invoke(Boolean.FALSE, new TroopJoinQunAutoSwitch$RetrieveSubGroupRsp());
                }
            }, new Function2<Integer, String, Unit>(callback) { // from class: com.tencent.mobileqq.troop.troopjoin.api.impl.TroopJoinApiImpl$needShowSubTroopWithTroopId$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function2<Boolean, TroopJoinQunAutoSwitch$RetrieveSubGroupRsp, Unit> $callback;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                    invoke(num.intValue(), str);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, @NotNull String str) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, i3, (Object) str);
                    } else {
                        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
                        this.$callback.invoke(Boolean.FALSE, new TroopJoinQunAutoSwitch$RetrieveSubGroupRsp());
                    }
                }
            }, isFromTroopCard);
        }
    }

    @Override // com.tencent.mobileqq.troop.troopjoin.api.ITroopJoinApi
    public void needShowSubTroopWithTroopInfo(@Nullable String troopUin, int troopMemberCount, int troopMaxMemberCount, boolean isFromTroopCard, @NotNull Function2<? super Boolean, ? super TroopJoinQunAutoSwitch$RetrieveSubGroupRsp, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, troopUin, Integer.valueOf(troopMemberCount), Integer.valueOf(troopMaxMemberCount), Boolean.valueOf(isFromTroopCard), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!b.f294691a.h(ENABLE_SHOW_SUB_TROOP_CONFIG_ID, false)) {
            callback.invoke(Boolean.FALSE, new TroopJoinQunAutoSwitch$RetrieveSubGroupRsp());
            return;
        }
        if (troopUin == null) {
            troopUin = "";
        }
        if (troopUin.length() > 0) {
            z16 = true;
        }
        if (z16 && troopMemberCount >= troopMaxMemberCount) {
            needShowSubTroopWithTroopId(troopUin, isFromTroopCard, callback);
        } else {
            QLog.i(Log_TAG, 1, "the troop has vacancy");
            callback.invoke(Boolean.FALSE, new TroopJoinQunAutoSwitch$RetrieveSubGroupRsp());
        }
    }

    @Override // com.tencent.mobileqq.troop.troopjoin.api.ITroopJoinApi
    public void showSwitchSubTroop(@NotNull Context context, @NotNull String mainTroopId, @NotNull TroopJoinQunAutoSwitch$RetrieveSubGroupRsp subTroopInfo, int sourceId, @NotNull String sourcePageDTId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, context, mainTroopId, subTroopInfo, Integer.valueOf(sourceId), sourcePageDTId);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mainTroopId, "mainTroopId");
        Intrinsics.checkNotNullParameter(subTroopInfo, "subTroopInfo");
        Intrinsics.checkNotNullParameter(sourcePageDTId, "sourcePageDTId");
        new d(context, mainTroopId, subTroopInfo, sourceId, sourcePageDTId).show();
    }

    @Override // com.tencent.mobileqq.troop.troopjoin.api.ITroopJoinApi
    public void tryLaunchJoinTroop(@NotNull Context context, @NotNull final com.tencent.mobileqq.troop.troopjoin.a param, boolean skipCheck, @NotNull final Function2<? super TryJoinTroopResult, ? super Integer, Unit> callback) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, param, Boolean.valueOf(skipCheck), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d(Log_TAG, 2, "tryLaunchJoinTroop invoked.");
        if (param.f().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (param.a().length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17 || param.e() == 10014) {
                if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
                    callback.invoke(TryJoinTroopResult.SYS_ERROR, 0);
                    return;
                }
                if (!skipCheck) {
                    TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(param.f());
                    if (troopInfoFromCache == null || !troopInfoFromCache.hadJoinTroop()) {
                        z18 = false;
                    }
                    if (z18) {
                        callback.invoke(TryJoinTroopResult.HAS_JOINED, 0);
                        return;
                    }
                }
                g gVar = new g();
                gVar.f296167a = param.f();
                gVar.f296169c = param.e();
                gVar.f296171e = param.a();
                gVar.f296172f = param.d();
                ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).joinTroop(context, gVar, new f() { // from class: com.tencent.mobileqq.troop.troopjoin.api.impl.a
                    @Override // com.tencent.mobileqq.troop.f
                    public final void a(String str, int i3) {
                        TroopJoinApiImpl.tryLaunchJoinTroop$lambda$1(com.tencent.mobileqq.troop.troopjoin.a.this, callback, str, i3);
                    }
                });
                return;
            }
        }
        callback.invoke(TryJoinTroopResult.PARAMS_ERROR, -1);
    }
}
