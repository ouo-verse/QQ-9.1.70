package com.tencent.mobileqq.troop.trooplive.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.config.b;
import com.tencent.mobileqq.troop.livesync.repository.c;
import com.tencent.mobileqq.troop.trooplive.api.ITroopLiveApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import tencent.trpcprotocol.TroopLiveSyncSvr$GetSyncRoomIDRsp;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010JL\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022:\u0010\r\u001a6\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004j\u0002`\fH\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/troop/trooplive/api/impl/TroopLiveApiImpl;", "Lcom/tencent/mobileqq/troop/trooplive/api/ITroopLiveApi;", "", "troopId", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "needJump", "Ltencent/trpcprotocol/TroopLiveSyncSvr$GetSyncRoomIDRsp;", "syncRoomInfo", "", "Lcom/tencent/mobileqq/troop/trooplive/api/CallBackSyncRoomFun;", "callback", "needJumpSyncRoom", "<init>", "()V", "Companion", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopLiveApiImpl implements ITroopLiveApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String ENABLE_CLOSE_JUMP_MAIN_LIVE = "101252";

    @NotNull
    private static final String Log_TAG = "TroopLiveApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/trooplive/api/impl/TroopLiveApiImpl$a;", "", "", "ENABLE_CLOSE_JUMP_MAIN_LIVE", "Ljava/lang/String;", "Log_TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.trooplive.api.impl.TroopLiveApiImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57943);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopLiveApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.trooplive.api.ITroopLiveApi
    public void needJumpSyncRoom(@NotNull String troopId, @NotNull final Function2<? super Boolean, ? super TroopLiveSyncSvr$GetSyncRoomIDRsp, Unit> callback) {
        Long longOrNull;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopId, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopId, "troopId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            if (!b.f294691a.h(ENABLE_CLOSE_JUMP_MAIN_LIVE, false)) {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopId);
                if (longOrNull != null) {
                    j3 = longOrNull.longValue();
                } else {
                    j3 = 0;
                }
                if (j3 > 0) {
                    c.f297726a.e(j3, new Function1<TroopLiveSyncSvr$GetSyncRoomIDRsp, Unit>(callback) { // from class: com.tencent.mobileqq.troop.trooplive.api.impl.TroopLiveApiImpl$needJumpSyncRoom$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Function2<Boolean, TroopLiveSyncSvr$GetSyncRoomIDRsp, Unit> $callback;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                            this.$callback = callback;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) callback);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(TroopLiveSyncSvr$GetSyncRoomIDRsp troopLiveSyncSvr$GetSyncRoomIDRsp) {
                            invoke2(troopLiveSyncSvr$GetSyncRoomIDRsp);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(@NotNull TroopLiveSyncSvr$GetSyncRoomIDRsp rsp) {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this, (Object) rsp);
                                return;
                            }
                            Intrinsics.checkNotNullParameter(rsp, "rsp");
                            this.$callback.invoke(Boolean.valueOf(rsp.group_code.get() > 0), rsp);
                        }
                    }, new Function2<Integer, String, Unit>(callback) { // from class: com.tencent.mobileqq.troop.trooplive.api.impl.TroopLiveApiImpl$needJumpSyncRoom$2
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Function2<Boolean, TroopLiveSyncSvr$GetSyncRoomIDRsp, Unit> $callback;

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
                                this.$callback.invoke(Boolean.FALSE, new TroopLiveSyncSvr$GetSyncRoomIDRsp());
                            }
                        }
                    });
                    return;
                } else {
                    QLog.e(Log_TAG, 1, "troop id invalid");
                    callback.invoke(Boolean.FALSE, new TroopLiveSyncSvr$GetSyncRoomIDRsp());
                    return;
                }
            }
            callback.invoke(Boolean.FALSE, new TroopLiveSyncSvr$GetSyncRoomIDRsp());
        } catch (Exception e16) {
            QLog.e(Log_TAG, 1, "[needJumpSyncRoom] on exception, e = " + e16);
            callback.invoke(Boolean.FALSE, new TroopLiveSyncSvr$GetSyncRoomIDRsp());
        }
    }
}
