package com.tencent.mobileqq.zootopia.openid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.mobileqq.z1.base.openId.ZootopiaOpenIdResult;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.lua.ZootopiaOpenIdLuaPlugin;
import com.tencent.mobileqq.zootopia.lua.ar;
import com.tencent.mobileqq.zootopia.openid.ZootopiaOpenIdFragment;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.state.report.SquareReportConst;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J2\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J0\u0010\u0018\u001a\u00020\u00042\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0002J\u001a\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014H\u0002J\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J8\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0007\u001a\u00020\u0006J2\u0010%\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010#R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/zootopia/openid/f;", "", "", "uin", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "from", "mapId", "r", "Lcom/tencent/mobileqq/zootopia/openid/a;", "callback", "", "i", "Landroid/content/Context;", "context", "k", "j", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "t", "response", "l", "f", "info", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "e", "g", "", "requestFlag", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", tl.h.F, "Ljava/util/concurrent/atomic/AtomicInteger;", "b", "Ljava/util/concurrent/atomic/AtomicInteger;", "requestCount", "Lcom/tencent/mobileqq/zootopia/openid/g;", "c", "Lcom/tencent/mobileqq/zootopia/openid/g;", "requestInfo", "d", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "memCacheResult", "Lid3/d;", "Lid3/d;", "reportHelper", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class f {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static ZootopiaOpenIdRequestInfo requestInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static ZootopiaOpenIdResult memCacheResult;

    /* renamed from: a, reason: collision with root package name */
    public static final f f328608a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final AtomicInteger requestCount = new AtomicInteger(0);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final id3.d reportHelper = new id3.d(null, 1, null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zootopia/openid/f$a", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "", "success", "", "engineInitFinish", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements ZPlanEngineStatusUpdateListener {
        a() {
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineDestroy() {
            ZPlanEngineStatusUpdateListener.a.a(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
        public void engineFirstFrame() {
            ZPlanEngineStatusUpdateListener.a.b(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineInitFinish(boolean success) {
            ZPlanEngineStatusUpdateListener.a.c(this, success);
            if (success) {
                ar.f328509a.b(ZootopiaOpenIdLuaPlugin.INSTANCE.a());
            }
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineInversePurged() {
            ZPlanEngineStatusUpdateListener.a.d(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void enginePurged() {
            ZPlanEngineStatusUpdateListener.a.e(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void enginePurging() {
            ZPlanEngineStatusUpdateListener.a.f(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void engineSuspended() {
            ZPlanEngineStatusUpdateListener.a.g(this);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void hotPatchDownloadFailed(int i3, String str) {
            ZPlanEngineStatusUpdateListener.a.h(this, i3, str);
        }

        @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
        public void serviceConnected(boolean z16) {
            ZPlanEngineStatusUpdateListener.a.i(this, z16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zootopia/openid/f$b", "Lwp3/b;", "", "response", "", "onComplete", "Lwp3/a;", "e", "onError", "onCancel", "", "code", "onWarning", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends wp3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f328613a;

        b(Context context) {
            this.f328613a = context;
        }

        @Override // wp3.b
        public void onCancel() {
            QLog.i(wp3.b.TAG, 1, "default listener, onCancel");
        }

        @Override // wp3.b
        public void onComplete(Object response) {
            QLog.i(wp3.b.TAG, 1, "default listener, onComplete");
            if (this.f328613a == null) {
                return;
            }
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            AppInterface appInterface = waitAppRuntime instanceof AppInterface ? (AppInterface) waitAppRuntime : null;
            String currentUin = appInterface != null ? appInterface.getCurrentUin() : null;
            if (TextUtils.isEmpty(currentUin)) {
                return;
            }
            f fVar = f.f328608a;
            Context context = this.f328613a;
            Intrinsics.checkNotNull(currentUin);
            fVar.l(context, currentUin, response, null);
        }

        @Override // wp3.b
        public void onError(wp3.a e16) {
            QLog.i(wp3.b.TAG, 1, "default listener, onError");
        }

        @Override // wp3.b
        public void onWarning(int code) {
            QLog.i(wp3.b.TAG, 1, "default listener, onWarning");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zootopia/openid/f$c", "Lwp3/b;", "", "response", "", "onComplete", "Lwp3/a;", "e", "onError", "onCancel", "", "code", "onWarning", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends wp3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f328614a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f328615b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f328616c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.openid.a f328617d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZootopiaSource f328618e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f328619f;

        c(int i3, Context context, String str, com.tencent.mobileqq.zootopia.openid.a aVar, ZootopiaSource zootopiaSource, String str2) {
            this.f328614a = i3;
            this.f328615b = context;
            this.f328616c = str;
            this.f328617d = aVar;
            this.f328618e = zootopiaSource;
            this.f328619f = str2;
        }

        @Override // wp3.b
        public void onCancel() {
            QLog.i("ZootopiaOpenIdHelper", 1, this.f328614a + ", onCancel");
            this.f328617d.b(-1002, "cancel by sdk");
            f.f328608a.p(this.f328618e, this.f328619f);
        }

        @Override // wp3.b
        public void onComplete(Object response) {
            String str;
            int i3 = this.f328614a;
            if (QLog.isColorLevel()) {
                str = response != null ? response.toString() : null;
            } else {
                str = "";
            }
            QLog.i("ZootopiaOpenIdHelper", 1, i3 + ", onComplete:" + str);
            f fVar = f.f328608a;
            fVar.l(this.f328615b, this.f328616c, response, this.f328617d);
            fVar.q(this.f328618e, this.f328619f);
        }

        @Override // wp3.b
        public void onError(wp3.a e16) {
            QLog.i("ZootopiaOpenIdHelper", 1, this.f328614a + ", onError:" + (e16 != null ? Integer.valueOf(e16.f446029a) : null) + (e16 != null ? e16.f446030b : null));
            com.tencent.mobileqq.zootopia.openid.a aVar = this.f328617d;
            int i3 = e16 != null ? e16.f446029a : -1003;
            String str = e16 != null ? e16.f446030b : null;
            if (str == null) {
                str = "unknow error from sdk";
            }
            aVar.b(i3, str);
        }

        @Override // wp3.b
        public void onWarning(int code) {
            QLog.i("ZootopiaOpenIdHelper", 1, this.f328614a + ", onWarning:" + code);
        }
    }

    static {
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).registerZPlanEngineStatusUpdateListener(new a());
    }

    f() {
    }

    private final ZootopiaOpenIdResult f(String uin, Object response) {
        JSONObject jSONObject = response instanceof JSONObject ? (JSONObject) response : null;
        if (jSONObject == null) {
            return null;
        }
        long optLong = jSONObject.optLong("expires_in", 0L) * 1000;
        if (optLong >= 864000000) {
            optLong -= 86400000;
        }
        String optString = jSONObject.optString("openid", "");
        Intrinsics.checkNotNullExpressionValue(optString, "data.optString(ZootopiaO\u2026tils.KEY_SDK_OPEN_ID, \"\")");
        String optString2 = jSONObject.optString(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN, "");
        Intrinsics.checkNotNullExpressionValue(optString2, "data.optString(ZootopiaO\u2026KEY_SDK_ACCESS_TOKEN, \"\")");
        String optString3 = jSONObject.optString("pay_token", "");
        Intrinsics.checkNotNullExpressionValue(optString3, "data.optString(ZootopiaO\u2026ls.KEY_SDK_PAY_TOKEN, \"\")");
        return new ZootopiaOpenIdResult(uin, optString, optString2, optString3, NetConnInfoCenter.getServerTimeMillis() + optLong, NetConnInfoCenter.getServerTimeMillis());
    }

    private final boolean i(String uin, com.tencent.mobileqq.zootopia.openid.a callback) {
        ZootopiaOpenIdResult zootopiaOpenIdResult = memCacheResult;
        if (m(uin, zootopiaOpenIdResult)) {
            callback.a(zootopiaOpenIdResult);
            return true;
        }
        t(null);
        return false;
    }

    private final synchronized void j(Context context, String uin, String mapId, com.tencent.mobileqq.zootopia.openid.a callback, ZootopiaSource from) {
        ZootopiaOpenIdRequestInfo zootopiaOpenIdRequestInfo = requestInfo;
        if (zootopiaOpenIdRequestInfo != null && NetConnInfoCenter.getServerTimeMillis() - zootopiaOpenIdRequestInfo.getRequestTime() <= 5000) {
            QLog.i("ZootopiaOpenIdHelper", 1, "handleFromOpenSDK, ignore");
            callback.b(-1007, "doing request");
            return;
        }
        int incrementAndGet = requestCount.incrementAndGet();
        c cVar = new c(incrementAndGet, context, uin, callback, from, mapId);
        QLog.i("ZootopiaOpenIdHelper", 1, "handleFromOpenSDK: " + incrementAndGet);
        requestInfo = new ZootopiaOpenIdRequestInfo(NetConnInfoCenter.getServerTimeMillis(), incrementAndGet, uin, cVar);
        Bundle bundle = new Bundle();
        bundle.putInt("intent_request_flag", incrementAndGet);
        ZootopiaOpenIdFragment.INSTANCE.a(context, from, bundle);
    }

    private final boolean k(Context context, String uin, com.tencent.mobileqq.zootopia.openid.a callback) {
        h hVar = h.f328624a;
        ZootopiaOpenIdResult d16 = hVar.d(uin);
        if (d16 == null) {
            return false;
        }
        if (m(uin, d16)) {
            t(d16);
            callback.a(d16);
            return true;
        }
        t(null);
        hVar.a(uin);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(Context context, String uin, Object response, com.tencent.mobileqq.zootopia.openid.a callback) {
        ZootopiaOpenIdResult f16 = f(uin, response);
        if (f16 == null || !m(uin, f16)) {
            if (callback != null) {
                callback.b(-1004, "unexpected response");
            }
        } else {
            t(f16);
            h.f328624a.g(uin, f16);
            if (callback != null) {
                callback.a(f16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(String str) {
        f328608a.s(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(ZootopiaSource from, String mapId) {
        HashMap hashMapOf;
        QLog.i("ZootopiaOpenIdHelper", 1, "reportAuthorizationCancel");
        id3.d dVar = reportHelper;
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("zplan_authorization_result", "0");
        ZootopiaSource c16 = ag.f373258a.c(from);
        if (c16 == null) {
            c16 = ZootopiaSource.INSTANCE.i();
        }
        pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(c16));
        if (mapId == null) {
            mapId = "0";
        }
        pairArr[2] = TuplesKt.to("zplan_map_id", mapId);
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        dVar.d("ev_zplan_paradise_authorization_result", hashMapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(ZootopiaSource from, String mapId) {
        HashMap hashMapOf;
        QLog.i("ZootopiaOpenIdHelper", 1, "reportAuthorizationComplete");
        id3.d dVar = reportHelper;
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("zplan_authorization_result", "1");
        ZootopiaSource c16 = ag.f373258a.c(from);
        if (c16 == null) {
            c16 = ZootopiaSource.INSTANCE.i();
        }
        pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(c16));
        if (mapId == null) {
            mapId = "0";
        }
        pairArr[2] = TuplesKt.to("zplan_map_id", mapId);
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        dVar.d("ev_zplan_paradise_authorization_result", hashMapOf);
    }

    private final void r(ZootopiaSource from, String mapId) {
        HashMap hashMapOf;
        QLog.i("ZootopiaOpenIdHelper", 1, "reportAuthorizationStart");
        id3.d dVar = reportHelper;
        Pair[] pairArr = new Pair[2];
        ZootopiaSource c16 = ag.f373258a.c(from);
        if (c16 == null) {
            c16 = ZootopiaSource.INSTANCE.i();
        }
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(c16));
        if (mapId == null) {
            mapId = "0";
        }
        pairArr[1] = TuplesKt.to("zplan_map_id", mapId);
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        dVar.d("ev_zplan_paradise_authorization", hashMapOf);
    }

    private final void s(String uin) {
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            ZootopiaOpenIdFragment.Companion companion = ZootopiaOpenIdFragment.INSTANCE;
            ZootopiaSource g16 = ZootopiaSource.INSTANCE.g();
            Bundle bundle = new Bundle();
            bundle.putBoolean("intent_re_auth_dialog", true);
            Unit unit = Unit.INSTANCE;
            companion.a(mobileQQ, g16, bundle);
        }
    }

    private final void t(ZootopiaOpenIdResult result) {
        memCacheResult = result;
    }

    public final void e(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.i("ZootopiaOpenIdHelper", 2, "clearOpenIdCacheInfo:" + uin);
        memCacheResult = null;
        h.f328624a.a(uin);
    }

    public final void g(Context context, String uin, String mapId, com.tencent.mobileqq.zootopia.openid.a callback, ZootopiaSource from) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(from, "from");
        if (QLog.isColorLevel()) {
            QLog.i("ZootopiaOpenIdHelper", 1, "getOpenIdInfo, uin:" + uin);
        }
        if (TextUtils.isEmpty(uin)) {
            QLog.i("ZootopiaOpenIdHelper", 1, "getOpenIdInfo, uin is null or empty");
            callback.b(-1005, "uin is null or empty");
            return;
        }
        Intrinsics.checkNotNull(uin);
        if (i(uin, callback)) {
            QLog.i("ZootopiaOpenIdHelper", 1, "getOpenIdInfo, hit mem");
        } else if (k(context, uin, callback)) {
            QLog.i("ZootopiaOpenIdHelper", 1, "getOpenIdInfo, hit sp");
        } else {
            r(from, mapId);
            j(context, uin, mapId, callback, from);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004c A[Catch: all -> 0x0053, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0008, B:8:0x0010, B:10:0x0014, B:13:0x001e, B:15:0x0022, B:21:0x0038, B:26:0x004c, B:27:0x004f, B:33:0x0029), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void h(Context context, int requestFlag, int requestCode, int resultCode, Intent data) {
        wp3.b bVar;
        ZootopiaOpenIdRequestInfo zootopiaOpenIdRequestInfo = requestInfo;
        if (zootopiaOpenIdRequestInfo != null) {
            if ((zootopiaOpenIdRequestInfo != null ? zootopiaOpenIdRequestInfo.getListener() : null) != null) {
                ZootopiaOpenIdRequestInfo zootopiaOpenIdRequestInfo2 = requestInfo;
                if ((zootopiaOpenIdRequestInfo2 != null ? zootopiaOpenIdRequestInfo2.getRequestFlag() : Integer.MIN_VALUE) == requestFlag) {
                    ZootopiaOpenIdRequestInfo zootopiaOpenIdRequestInfo3 = requestInfo;
                    bVar = zootopiaOpenIdRequestInfo3 != null ? zootopiaOpenIdRequestInfo3.getListener() : null;
                    if (requestCode != -1 && resultCode == -1 && data == null) {
                        if (bVar != null) {
                            bVar.onError(new wp3.a(-1006, "invalid params", "invalid params"));
                        }
                        return;
                    } else {
                        if (bVar != null) {
                            bVar.onActivityResult(requestCode, resultCode, data);
                        }
                        requestInfo = null;
                    }
                }
            }
        }
        bVar = new b(context);
        if (requestCode != -1) {
        }
        if (bVar != null) {
        }
        requestInfo = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n() {
        boolean z16;
        boolean isBlank;
        AppRuntime waitAppRuntime;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        final String str = null;
        if (mobileQQ != null && (waitAppRuntime = mobileQQ.waitAppRuntime(null)) != null) {
            str = waitAppRuntime.getCurrentUin();
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (z16) {
                    e(str);
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.openid.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            f.o(str);
                        }
                    });
                    return;
                }
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    private final boolean m(String uin, ZootopiaOpenIdResult info) {
        if (info == null || !TextUtils.equals(uin, info.getUin()) || TextUtils.isEmpty(info.getOpenId()) || TextUtils.isEmpty(info.getAccessToken())) {
            return false;
        }
        QLog.i("ZootopiaOpenIdHelper", 1, "isValidOpenIdInfo, info.expiredTime=" + info.getExpiredTime());
        if (NetConnInfoCenter.getServerTimeMillis() < info.getExpiredTime() - MiniBoxNoticeInfo.MIN_5) {
            return true;
        }
        QLog.i("ZootopiaOpenIdHelper", 1, "isValidOpenIdInfo, expire");
        return false;
    }
}
