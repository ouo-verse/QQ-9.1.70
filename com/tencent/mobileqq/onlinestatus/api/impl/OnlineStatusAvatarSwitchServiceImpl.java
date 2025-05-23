package com.tencent.mobileqq.onlinestatus.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusAvatarSwitchService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.data.SquareJSConst;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J+\u0010\r\u001a\u00020\u00042!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016J+\u0010\u000e\u001a\u00020\u00042!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016J3\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016JP\u0010\u0014\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J3\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\b2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00040\u0007H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0016JJ\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u001728\u0010\f\u001a4\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0019\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00040\u001eH\u0016JZ\u0010\u001f\u001a\u00020\u00042\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 2B\u0010\f\u001a>\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00190#\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00040\u001eH\u0016R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010%R\u0014\u0010)\u001a\u00020&8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010(\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/api/impl/OnlineStatusAvatarSwitchServiceImpl;", "Lcom/tencent/mobileqq/onlinestatus/api/IOnlineStatusAvatarSwitchService;", "Lmqq/app/AppRuntime;", "appRuntime", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "callback", "setSelfAutoWhitelistOn", "setSelfAutoWhitelistOff", "on", "setSelfGrayWhitelistSwitch", "panelSwitch", "autoWhite", "grayWhite", "setSwitchStatus", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;)V", "resetAllSwitch", "", "uin", "Lcom/tencent/mobileqq/onlinestatus/model/f;", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "onSwitchUpdated", "setSelfPanelSwitch", "getSwitchStatus", "Lkotlin/Function2;", "updateFriendSwitchStatus", "", "", SquareJSConst.Params.PARAMS_UIN_LIST, "", "switchMap", "Lmqq/app/AppRuntime;", "Lcom/tencent/mobileqq/onlinestatus/protocol/c;", "getRepo", "()Lcom/tencent/mobileqq/onlinestatus/protocol/c;", "repo", "<init>", "()V", "Companion", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class OnlineStatusAvatarSwitchServiceImpl implements IOnlineStatusAvatarSwitchService {

    @NotNull
    private static final String TAG = "OnlineStatusAvatar.SwitchServiceImpl";
    private AppRuntime appRuntime;

    private final com.tencent.mobileqq.onlinestatus.protocol.c getRepo() {
        return com.tencent.mobileqq.onlinestatus.protocol.c.INSTANCE.a();
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusAvatarSwitchService
    @Nullable
    public com.tencent.mobileqq.onlinestatus.model.f getSwitchStatus(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return getRepo().k(uin);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        this.appRuntime = appRuntime;
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusAvatarSwitchService
    public void onSwitchUpdated(@NotNull String uin, @NotNull com.tencent.mobileqq.onlinestatus.model.f r56) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(r56, "switch");
        QLog.i(TAG, 1, "[onSwitchUpdated] uin=" + uin + ", switch=" + r56);
        getRepo().q(uin, r56);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusAvatarSwitchService
    public void resetAllSwitch() {
        com.tencent.mobileqq.onlinestatus.protocol.c repo = getRepo();
        AppRuntime appRuntime = this.appRuntime;
        AppRuntime appRuntime2 = null;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
            appRuntime = null;
        }
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "appRuntime.currentAccountUin");
        com.tencent.mobileqq.onlinestatus.model.f k3 = repo.k(currentAccountUin);
        if (k3 == null) {
            k3 = new com.tencent.mobileqq.onlinestatus.model.f(false, false, 0, 7, null);
        }
        k3.g(false);
        k3.h(false);
        k3.i(0);
        com.tencent.mobileqq.onlinestatus.protocol.c repo2 = getRepo();
        AppRuntime appRuntime3 = this.appRuntime;
        if (appRuntime3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
        } else {
            appRuntime2 = appRuntime3;
        }
        repo2.o(appRuntime2, k3, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.OnlineStatusAvatarSwitchServiceImpl$resetAllSwitch$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                QLog.i("OnlineStatusAvatar.SwitchServiceImpl", 1, "[resetAllSwitch]: result is " + z16);
            }
        });
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusAvatarSwitchService
    public void setSelfAutoWhitelistOff(@NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.onlinestatus.protocol.c repo = getRepo();
        AppRuntime appRuntime = this.appRuntime;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
            appRuntime = null;
        }
        repo.l(appRuntime, false, callback);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusAvatarSwitchService
    public void setSelfAutoWhitelistOn(@NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.onlinestatus.protocol.c repo = getRepo();
        AppRuntime appRuntime = this.appRuntime;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
            appRuntime = null;
        }
        repo.l(appRuntime, true, callback);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusAvatarSwitchService
    public void setSelfGrayWhitelistSwitch(boolean on5, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.onlinestatus.protocol.c repo = getRepo();
        AppRuntime appRuntime = this.appRuntime;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
            appRuntime = null;
        }
        repo.m(appRuntime, on5, callback);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusAvatarSwitchService
    public void setSelfPanelSwitch(boolean on5, @NotNull Function1<? super Boolean, Unit> callback) {
        int i3;
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (on5) {
            i3 = 3;
        } else {
            i3 = 1;
        }
        com.tencent.mobileqq.onlinestatus.protocol.c repo = getRepo();
        AppRuntime appRuntime = this.appRuntime;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
            appRuntime = null;
        }
        repo.n(appRuntime, i3, callback);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusAvatarSwitchService
    public void setSwitchStatus(@Nullable Boolean panelSwitch, @Nullable Boolean autoWhite, @Nullable Boolean grayWhite, @NotNull Function1<? super Boolean, Unit> callback) {
        boolean z16;
        int i3;
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.mobileqq.onlinestatus.protocol.c repo = getRepo();
        AppRuntime appRuntime = this.appRuntime;
        AppRuntime appRuntime2 = null;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
            appRuntime = null;
        }
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "appRuntime.currentAccountUin");
        com.tencent.mobileqq.onlinestatus.model.f k3 = repo.k(currentAccountUin);
        if (k3 == null) {
            k3 = new com.tencent.mobileqq.onlinestatus.model.f(false, false, 0, 7, null);
        }
        if (panelSwitch != null) {
            if (panelSwitch.booleanValue()) {
                i3 = 3;
            } else {
                i3 = 1;
            }
            k3.i(i3);
            z16 = true;
        } else {
            z16 = false;
        }
        if (autoWhite != null) {
            k3.g(autoWhite.booleanValue());
            z16 = true;
        }
        if (grayWhite != null) {
            k3.h(grayWhite.booleanValue());
            z16 = true;
        }
        if (!z16) {
            QLog.i(TAG, 1, "[setSwitchStatus] no need update, switch=" + k3);
            callback.invoke(Boolean.TRUE);
            return;
        }
        com.tencent.mobileqq.onlinestatus.protocol.c repo2 = getRepo();
        AppRuntime appRuntime3 = this.appRuntime;
        if (appRuntime3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
        } else {
            appRuntime2 = appRuntime3;
        }
        repo2.o(appRuntime2, k3, callback);
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusAvatarSwitchService
    public void updateFriendSwitchStatus(@NotNull final String uin, @NotNull final Function2<? super Boolean, ? super com.tencent.mobileqq.onlinestatus.model.f, Unit> callback) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            com.tencent.mobileqq.onlinestatus.protocol.c repo = getRepo();
            AppRuntime appRuntime = this.appRuntime;
            if (appRuntime == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
                appRuntime = null;
            }
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Long.valueOf(Long.parseLong(uin)));
            repo.p(appRuntime, arrayListOf, new Function2<Boolean, Map<Long, ? extends com.tencent.mobileqq.onlinestatus.model.f>, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.OnlineStatusAvatarSwitchServiceImpl$updateFriendSwitchStatus$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Map<Long, ? extends com.tencent.mobileqq.onlinestatus.model.f> map) {
                    invoke(bool.booleanValue(), (Map<Long, com.tencent.mobileqq.onlinestatus.model.f>) map);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @NotNull Map<Long, com.tencent.mobileqq.onlinestatus.model.f> switchMap) {
                    Intrinsics.checkNotNullParameter(switchMap, "switchMap");
                    callback.invoke(Boolean.valueOf(z16), switchMap.get(Long.valueOf(Long.parseLong(uin))));
                }
            });
        } catch (Exception e16) {
            QLog.i(TAG, 1, "[updateFriendSwitchStatus] uin=" + uin + ", exception=" + e16);
            callback.invoke(Boolean.FALSE, null);
        }
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusAvatarSwitchService
    public void updateFriendSwitchStatus(@NotNull List<Long> uinList, @NotNull final Function2<? super Boolean, ? super Map<Long, com.tencent.mobileqq.onlinestatus.model.f>, Unit> callback) {
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            com.tencent.mobileqq.onlinestatus.protocol.c repo = getRepo();
            AppRuntime appRuntime = this.appRuntime;
            if (appRuntime == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
                appRuntime = null;
            }
            repo.p(appRuntime, uinList, new Function2<Boolean, Map<Long, ? extends com.tencent.mobileqq.onlinestatus.model.f>, Unit>() { // from class: com.tencent.mobileqq.onlinestatus.api.impl.OnlineStatusAvatarSwitchServiceImpl$updateFriendSwitchStatus$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Map<Long, ? extends com.tencent.mobileqq.onlinestatus.model.f> map) {
                    invoke(bool.booleanValue(), (Map<Long, com.tencent.mobileqq.onlinestatus.model.f>) map);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, @NotNull Map<Long, com.tencent.mobileqq.onlinestatus.model.f> switchMap) {
                    Intrinsics.checkNotNullParameter(switchMap, "switchMap");
                    callback.invoke(Boolean.valueOf(z16), switchMap);
                }
            });
        } catch (Exception e16) {
            QLog.i(TAG, 1, "[updateFriendSwitchStatus] uin=" + uinList.size() + ", exception=" + e16);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
