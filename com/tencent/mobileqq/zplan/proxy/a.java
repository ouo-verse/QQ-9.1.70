package com.tencent.mobileqq.zplan.proxy;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.z1.base.openId.ZootopiaOpenIdResult;
import com.tencent.mobileqq.zootopia.lua.ai;
import com.tencent.mobileqq.zootopia.qav.ZplanAVControllerForQAV;
import com.tencent.mobileqq.zplan.ZPlanAppInterface;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J4\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J\u0018\u0010!\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0018H\u0002J\u0012\u0010\"\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010#\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J&\u0010&\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00182\b\u0010%\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u001c\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/a;", "Lzx4/a;", "Landroid/os/Bundle;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "Lcom/tencent/zplan/e;", "callback", tl.h.F, "o", "p", "l", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "i", "k", "g", ReportConstant.COSTREPORT_PREFIX, "", "status", "u", "", ViewStickEventHelper.IS_SHOW, "", "peerUin", "peerNickName", "isGroup", "", "roomId", "v", "ready", "jsonString", "r", "t", "w", "action", "bundle", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/os/RemoteCallbackList;", "a", "Landroid/os/RemoteCallbackList;", "mRemoteCallbackList", "<init>", "()V", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a implements zx4.a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static long f334949c;

    /* renamed from: d, reason: collision with root package name */
    private static long f334950d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final RemoteCallbackList<com.tencent.zplan.e> mRemoteCallbackList = new RemoteCallbackList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/a$a;", "", "", "connectedTime", "J", "a", "()J", "c", "(J)V", "otherTerChatTime", "b", "setOtherTerChatTime", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.proxy.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return a.f334949c;
        }

        public final long b() {
            return a.f334950d;
        }

        public final void c(long j3) {
            a.f334949c = j3;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/proxy/a$b", "Lcom/tencent/mobileqq/zootopia/lua/ai$a$a;", "", "isInGame", "", VirtualAppProxy.KEY_GAME_ID, "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements ai.Companion.InterfaceC9112a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.zplan.e f334953b;

        b(com.tencent.zplan.e eVar) {
            this.f334953b = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.lua.ai.Companion.InterfaceC9112a
        public void a(boolean isInGame, int gameId) {
            if (QLog.isColorLevel()) {
                QLog.i("QQZPlanActionProxy", 2, "handleIsInZplanHome isInGame " + isInGame + " gameId " + gameId);
            }
            a.this.t(this.f334953b);
            boolean z16 = gameId == 200001;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isInSmallHomeMod", z16);
            a aVar = a.this;
            boolean z17 = isInGame && ZplanAVControllerForQAV.INSTANCE.t(gameId);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
            aVar.r(z17, jSONObject2);
            a.this.w(this.f334953b);
        }
    }

    private final void h(com.tencent.zplan.e callback) {
        ai.INSTANCE.a(new b(callback));
    }

    private final void j(Bundle data) {
        QLog.d("QQZPlanActionProxy", 1, "handleOnAudioCallStatus " + (data != null ? Integer.valueOf(data.getInt("status")) : null));
        if (data == null) {
            QLog.d("QQZPlanActionProxy", 1, "handleOnAudioCallStatus data is null");
            return;
        }
        String string = data.getString("caller");
        if (string == null) {
            string = "";
        }
        String string2 = data.getString("callee");
        if (string2 == null) {
            string2 = "";
        }
        boolean z16 = data.getBoolean("isReceiver", false);
        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
            QLog.e("QQZPlanActionProxy", 1, "handleOnAudioCallStatus peerUin isEmpty");
        }
        switch (data.getInt("status")) {
            case 2:
                ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).openIdRemoteManagerGetOpenIdInfoSilent(new c(z16, string, string2));
                f334949c = data.getLong("connectedTime");
                u(1);
                return;
            case 3:
                ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).openIdRemoteManagerGetOpenIdInfoSilent(new e(z16, string, string2));
                s();
                ZplanAVControllerForQAV.INSTANCE.D(false);
                return;
            case 4:
                ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).openIdRemoteManagerGetOpenIdInfoSilent(new d(z16, string, string2));
                s();
                v(false, null, null, false, 0L);
                ZplanAVControllerForQAV.INSTANCE.D(false);
                return;
            case 5:
                v(false, null, null, false, 0L);
                s();
                ZplanAVControllerForQAV.INSTANCE.D(false);
                return;
            case 6:
                ai.INSTANCE.g(3, "", string2);
                s();
                ZplanAVControllerForQAV.INSTANCE.D(false);
                return;
            case 7:
                ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).openIdRemoteManagerGetOpenIdInfoSilent(new f());
                s();
                ZplanAVControllerForQAV.INSTANCE.D(false);
                return;
            case 8:
                ai.INSTANCE.g(1, string, string2);
                f334949c = data.getLong("connectedTime");
                u(1);
                ZplanAVControllerForQAV.INSTANCE.D(false);
                return;
            case 9:
                ai.INSTANCE.g(2, "", string2);
                ZplanAVControllerForQAV.INSTANCE.D(false);
                return;
            case 10:
                v(false, null, null, false, 0L);
                return;
            case 11:
                v(false, null, null, false, 0L);
                return;
            case 12:
                u(1);
                ZplanAVControllerForQAV.INSTANCE.D(false);
                return;
            default:
                return;
        }
    }

    private final void k(Bundle data) {
        ZplanAVControllerForQAV.INSTANCE.F(true);
        QLog.d("QQZPlanActionProxy", 1, "handleOnNeedRestoreGameMode.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(boolean ready, String jsonString) {
        synchronized (this.mRemoteCallbackList) {
            int beginBroadcast = this.mRemoteCallbackList.beginBroadcast();
            for (int i3 = 0; i3 < beginBroadcast; i3++) {
                try {
                    com.tencent.zplan.e broadcastItem = this.mRemoteCallbackList.getBroadcastItem(i3);
                    Intrinsics.checkNotNull(broadcastItem);
                    broadcastItem.T0(ready, jsonString);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        this.mRemoteCallbackList.finishBroadcast();
    }

    private final void s() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null && (appInterface instanceof ZPlanAppInterface)) {
            ((ZPlanAppInterface) appInterface).s(new Object[]{2});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(com.tencent.zplan.e callback) {
        synchronized (this.mRemoteCallbackList) {
            this.mRemoteCallbackList.register(callback);
        }
    }

    private final void u(int status) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null && (appInterface instanceof ZPlanAppInterface)) {
            ((ZPlanAppInterface) appInterface).s(new Object[]{1, Integer.valueOf(status)});
        }
    }

    private final void v(boolean isShow, String peerUin, String peerNickName, boolean isGroup, long roomId) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null && (appInterface instanceof ZPlanAppInterface)) {
            if (isShow) {
                ((ZPlanAppInterface) appInterface).s(new Object[]{3, peerUin, peerNickName, Boolean.valueOf(isGroup), Long.valueOf(roomId)});
            } else {
                ((ZPlanAppInterface) appInterface).s(new Object[]{4});
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(com.tencent.zplan.e callback) {
        synchronized (this.mRemoteCallbackList) {
            this.mRemoteCallbackList.unregister(callback);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/proxy/a$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "b", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<ZootopiaOpenIdResult> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f334954d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f334955e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f334956f;

        c(boolean z16, String str, String str2) {
            this.f334954d = z16;
            this.f334955e = str;
            this.f334956f = str2;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ZootopiaOpenIdResult result) {
            a(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("QQZPlanActionProxy", 1, "getOpenIdInfoSilent failure error " + error + " message " + message);
            a(null);
        }

        private final void a(ZootopiaOpenIdResult result) {
            if (result != null) {
                boolean z16 = this.f334954d;
                String str = this.f334955e;
                String str2 = this.f334956f;
                QLog.i("QQZPlanActionProxy", 1, "handleOpenIdResult openId " + result.getOpenId());
                if (z16) {
                    ai.INSTANCE.f(2, str, result.getOpenId());
                } else {
                    ai.INSTANCE.f(2, result.getOpenId(), str2);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/proxy/a$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "b", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.api.e<ZootopiaOpenIdResult> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f334957d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f334958e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f334959f;

        d(boolean z16, String str, String str2) {
            this.f334957d = z16;
            this.f334958e = str;
            this.f334959f = str2;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ZootopiaOpenIdResult result) {
            a(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("QQZPlanActionProxy", 1, "getOpenIdInfoSilent failure error " + error + " message " + message);
            a(null);
        }

        private final void a(ZootopiaOpenIdResult result) {
            if (result != null) {
                boolean z16 = this.f334957d;
                String str = this.f334958e;
                String str2 = this.f334959f;
                QLog.i("QQZPlanActionProxy", 1, "handleOpenIdResult openId " + result.getOpenId());
                if (z16) {
                    ai.INSTANCE.f(4, str, result.getOpenId());
                } else {
                    ai.INSTANCE.f(4, result.getOpenId(), str2);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/proxy/a$e", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "b", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements com.tencent.mobileqq.zootopia.api.e<ZootopiaOpenIdResult> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f334960d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f334961e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f334962f;

        e(boolean z16, String str, String str2) {
            this.f334960d = z16;
            this.f334961e = str;
            this.f334962f = str2;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ZootopiaOpenIdResult result) {
            a(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("QQZPlanActionProxy", 1, "getOpenIdInfoSilent failure error " + error + " message " + message);
            a(null);
        }

        private final void a(ZootopiaOpenIdResult result) {
            if (result != null) {
                boolean z16 = this.f334960d;
                String str = this.f334961e;
                String str2 = this.f334962f;
                QLog.i("QQZPlanActionProxy", 1, "handleOpenIdResult openId " + result.getOpenId());
                if (z16) {
                    ai.INSTANCE.f(3, str, result.getOpenId());
                } else {
                    ai.INSTANCE.f(3, result.getOpenId(), str2);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/proxy/a$f", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "b", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements com.tencent.mobileqq.zootopia.api.e<ZootopiaOpenIdResult> {
        f() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ZootopiaOpenIdResult result) {
            a(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("QQZPlanActionProxy", 1, "getOpenIdInfoSilent failure error " + error + " message " + message);
            a(null);
        }

        private final void a(ZootopiaOpenIdResult result) {
            if (result != null) {
                QLog.i("QQZPlanActionProxy", 1, "handleOpenIdResult openId " + result.getOpenId());
                ai.INSTANCE.g(3, "", result.getOpenId());
            }
        }
    }

    private final void g(Bundle data) {
        QLog.d("QQZPlanActionProxy", 1, "handleEnterCallList");
        if (data != null) {
            ai.INSTANCE.d(false, data.getStringArrayList("callList"));
        }
    }

    private final void i(Bundle data) {
        u(2);
    }

    private final void l(Bundle data) {
        long j3;
        long j16;
        if (data != null) {
            j3 = data.getLong("connectedTime");
        } else {
            j3 = f334949c;
        }
        f334949c = j3;
        if (data != null) {
            j16 = data.getLong("otherTerChatTime");
        } else {
            j16 = f334950d;
        }
        f334950d = j16;
        QLog.d("QQZPlanActionProxy", 1, "handleOnNotifyConnectedTime " + f334949c);
    }

    @Override // zx4.a
    public void z(String action, Bundle bundle, com.tencent.zplan.e callback) {
        if (action != null) {
            switch (action.hashCode()) {
                case -2141779874:
                    if (action.equals("tencent.video.v2z.on_receive_gaudio_call")) {
                        p(bundle);
                        return;
                    }
                    break;
                case -1831529321:
                    if (action.equals("tencent.video.v2z.notify_speaking_status")) {
                        n(bundle);
                        return;
                    }
                    break;
                case -1502549314:
                    if (action.equals("tencent.video.v2z.notify_net_status")) {
                        m(bundle);
                        return;
                    }
                    break;
                case -1189622889:
                    if (action.equals("tencent.video.v2z.on_receive_audio_call")) {
                        o(bundle);
                        return;
                    }
                    break;
                case -712962646:
                    if (action.equals("tencent.video.v2z.notify_conneceted_time")) {
                        l(bundle);
                        return;
                    }
                    break;
                case -579065780:
                    if (action.equals("tencent.video.v2z.is_in_zplan_home")) {
                        h(callback);
                        return;
                    }
                    break;
                case 50030044:
                    if (action.equals("tencent.video.v2z.call_list_return")) {
                        g(bundle);
                        return;
                    }
                    break;
                case 111064308:
                    if (action.equals("tencent.video.v2z.on_request_audio_ret")) {
                        q(bundle);
                        return;
                    }
                    break;
                case 335066081:
                    if (action.equals("tencent.video.z2v.report_user_zplan_home_status")) {
                        return;
                    }
                    break;
                case 459946998:
                    if (action.equals("tencent.video.v2z.on_audio_call_status")) {
                        j(bundle);
                        return;
                    }
                    break;
                case 1147806850:
                    if (action.equals("tencent.video.v2z.notify_audio_call_abort")) {
                        i(bundle);
                        return;
                    }
                    break;
                case 1535266016:
                    if (action.equals("tencent.video.v2z.notify_need_restore_game_mode")) {
                        k(bundle);
                        return;
                    }
                    break;
            }
        }
        QLog.w("QQZPlanActionProxy", 2, "action not equals :" + action);
    }

    private final void m(Bundle data) {
        Boolean valueOf = data != null ? Boolean.valueOf(data.getBoolean("isWifi")) : null;
        Boolean valueOf2 = data != null ? Boolean.valueOf(data.getBoolean("isBad")) : null;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null && (appInterface instanceof ZPlanAppInterface)) {
            ((ZPlanAppInterface) appInterface).s(new Object[]{6, valueOf, valueOf2});
        }
    }

    private final void n(Bundle data) {
        Long valueOf = data != null ? Long.valueOf(data.getLong("uin")) : null;
        Boolean valueOf2 = data != null ? Boolean.valueOf(data.getBoolean("isSpeaking")) : null;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null && (appInterface instanceof ZPlanAppInterface)) {
            ((ZPlanAppInterface) appInterface).s(new Object[]{5, valueOf, valueOf2});
        }
    }

    private final void o(Bundle data) {
        String string = data != null ? data.getString("peerUin") : null;
        String string2 = data != null ? data.getString("peerNickName") : null;
        Long valueOf = data != null ? Long.valueOf(data.getLong("roomId")) : null;
        ZplanAVControllerForQAV.INSTANCE.A(string);
        v(true, string, string2, false, valueOf != null ? valueOf.longValue() : 0L);
    }

    private final void p(Bundle data) {
        String string = data != null ? data.getString("peerUin") : null;
        String string2 = data != null ? data.getString("peerNickName") : null;
        Long valueOf = data != null ? Long.valueOf(data.getLong("roomId")) : null;
        ZplanAVControllerForQAV.INSTANCE.A(string);
        v(true, string, string2, true, valueOf != null ? valueOf.longValue() : 0L);
    }

    private final void q(Bundle data) {
        String string = data != null ? data.getString("peerUin") : null;
        Integer valueOf = data != null ? Integer.valueOf(data.getInt("retCode")) : null;
        QLog.i("QQZPlanActionProxy", 2, "handleOnRequestAudioRet peerUin: " + string);
        if (string != null) {
            ai.Companion companion = ai.INSTANCE;
            Intrinsics.checkNotNull(valueOf);
            companion.k(valueOf.intValue(), string);
        }
    }
}
