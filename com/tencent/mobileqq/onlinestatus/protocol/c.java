package com.tencent.mobileqq.onlinestatus.protocol;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.onlinestatus.model.f;
import com.tencent.mobileqq.onlinestatus.protocol.OnlineStatusAvatarSwitchBatchHelper;
import com.tencent.mobileqq.onlinestatus.protocol.OnlineStatusAvatarSwitchProcessor;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.data.SquareJSConst;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b#\u0010$J9\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006J9\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00072!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006J9\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00072!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006J`\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102B\u0010\f\u001a>\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000b0\u0013J9\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00152!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001b\u001a\u00020\u001aJ\u001f\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0015H\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/protocol/c;", "Lcom/tencent/mobileqq/mvvm/a;", "Lmqq/app/AppRuntime;", "appRuntime", "", "switchOn", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "callback", DomainData.DOMAIN_NAME, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "", SquareJSConst.Params.PARAMS_UIN_LIST, "Lkotlin/Function2;", "", "Lcom/tencent/mobileqq/onlinestatus/model/f;", "switchMap", "p", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "o", "", "uin", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/String;Lcom/tencent/mobileqq/onlinestatus/model/f;)V", "Landroid/content/SharedPreferences;", "a", "Landroid/content/SharedPreferences;", "sp", "<init>", "()V", "b", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c extends com.tencent.mobileqq.mvvm.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final c f256149c = new c();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SharedPreferences sp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/protocol/c$a;", "", "Lcom/tencent/mobileqq/onlinestatus/protocol/c;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/onlinestatus/protocol/c;", "a", "()Lcom/tencent/mobileqq/onlinestatus/protocol/c;", "", "KEY_SWITCH_VALUE", "Ljava/lang/String;", "SP_NAME", "TAG", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.onlinestatus.protocol.c$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final c a() {
            return c.f256149c;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/onlinestatus/protocol/c$b", "Lcom/tencent/mobileqq/onlinestatus/protocol/OnlineStatusAvatarSwitchProcessor$c;", "", "success", "Lcom/tencent/mobileqq/onlinestatus/model/f;", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b implements OnlineStatusAvatarSwitchProcessor.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f256151a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f256152b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Boolean, Unit> function1, c cVar) {
            this.f256151a = function1;
            this.f256152b = cVar;
        }

        @Override // com.tencent.mobileqq.onlinestatus.protocol.OnlineStatusAvatarSwitchProcessor.c
        public void a(boolean success, @NotNull f r56) {
            Intrinsics.checkNotNullParameter(r56, "switch");
            if (success) {
                QLog.i("OnlineStatusAvatar.SwitchRepository", 1, "[setSwitchToRemote] success, switch=" + r56);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime != null) {
                    c cVar = this.f256152b;
                    String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
                    Intrinsics.checkNotNullExpressionValue(currentAccountUin, "it.currentAccountUin");
                    cVar.q(currentAccountUin, r56);
                }
            }
            this.f256151a.invoke(Boolean.valueOf(success));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/onlinestatus/protocol/c$c", "Lcom/tencent/mobileqq/onlinestatus/protocol/OnlineStatusAvatarSwitchBatchHelper$a;", "", "success", "", "", "Lcom/tencent/mobileqq/onlinestatus/model/f;", "switchMap", "", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.onlinestatus.protocol.c$c, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C8190c implements OnlineStatusAvatarSwitchBatchHelper.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<Long> f256153a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f256154b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function2<Boolean, Map<Long, f>, Unit> f256155c;

        /* JADX WARN: Multi-variable type inference failed */
        C8190c(List<Long> list, c cVar, Function2<? super Boolean, ? super Map<Long, f>, Unit> function2) {
            this.f256153a = list;
            this.f256154b = cVar;
            this.f256155c = function2;
        }

        @Override // com.tencent.mobileqq.onlinestatus.protocol.OnlineStatusAvatarSwitchBatchHelper.a
        public void a(boolean success, @NotNull Map<Long, f> switchMap) {
            Intrinsics.checkNotNullParameter(switchMap, "switchMap");
            QLog.i("OnlineStatusAvatar.SwitchRepository", 1, "[updateFriendSwitch] update local, uinList=" + this.f256153a.size() + "->" + switchMap.size());
            for (Map.Entry<Long, f> entry : switchMap.entrySet()) {
                this.f256154b.q(String.valueOf(entry.getKey().longValue()), entry.getValue());
            }
            this.f256155c.invoke(Boolean.valueOf(success), switchMap);
        }
    }

    public c() {
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(BaseApplication.getContext(), "SP_OnlineStatusAvatarSwitchRepository", "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromSpAdapter, "fromSpAdapter(BaseApplic\u2026E, QMMKVFile.FILE_COMMON)");
        this.sp = fromSpAdapter;
    }

    @Nullable
    public final f k(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        String str = "PANEL_SWITCH_" + uin;
        if (!this.sp.contains(str)) {
            return null;
        }
        return new f(this.sp.getInt(str, 0));
    }

    public final void l(@NotNull AppRuntime appRuntime, boolean switchOn, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "appRuntime.currentAccountUin");
        f k3 = k(currentAccountUin);
        if (k3 == null) {
            k3 = new f(false, false, 0, 7, null);
        }
        k3.g(switchOn);
        QLog.i("OnlineStatusAvatar.SwitchRepository", 1, "[setAutoWhiteSwitch], switch=" + k3);
        o(appRuntime, k3, callback);
    }

    public final void m(@NotNull AppRuntime appRuntime, boolean switchOn, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "appRuntime.currentAccountUin");
        f k3 = k(currentAccountUin);
        if (k3 == null) {
            k3 = new f(false, false, 0, 7, null);
        }
        k3.h(switchOn);
        QLog.i("OnlineStatusAvatar.SwitchRepository", 1, "[setGrayWhiteSwitch], switch=" + k3);
        o(appRuntime, k3, callback);
    }

    public final void n(@NotNull AppRuntime appRuntime, int switchOn, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String currentAccountUin = appRuntime.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "appRuntime.currentAccountUin");
        f k3 = k(currentAccountUin);
        if (k3 == null) {
            k3 = new f(false, false, 0, 7, null);
        }
        k3.i(switchOn);
        QLog.i("OnlineStatusAvatar.SwitchRepository", 1, "[setPanelSwitch], switch=" + k3);
        o(appRuntime, k3, callback);
    }

    public final void o(@NotNull AppRuntime appRuntime, @NotNull f r36, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(r36, "switch");
        Intrinsics.checkNotNullParameter(callback, "callback");
        new OnlineStatusAvatarSwitchProcessor(appRuntime).d(r36, new b(callback, this));
    }

    public final void p(@NotNull AppRuntime appRuntime, @NotNull List<Long> uinList, @NotNull Function2<? super Boolean, ? super Map<Long, f>, Unit> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(uinList, "uinList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!(appRuntime instanceof AppInterface)) {
            QLog.i("OnlineStatusAvatar.SwitchRepository", 1, "[updateFriendSwitch] not app interface, " + appRuntime + " ");
            Boolean bool = Boolean.FALSE;
            emptyMap = MapsKt__MapsKt.emptyMap();
            callback.invoke(bool, emptyMap);
            return;
        }
        new OnlineStatusAvatarSwitchBatchHelper(uinList).g((AppInterface) appRuntime, new C8190c(uinList, this, callback));
    }

    public final void q(@NotNull String uin, @NotNull f r56) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(r56, "switch");
        this.sp.edit().putInt("PANEL_SWITCH_" + uin, r56.b()).apply();
    }
}
