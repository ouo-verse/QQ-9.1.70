package com.tencent.mobileqq.zootopia.openid;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.mobileqq.z1.base.openId.ZootopiaOpenIdResult;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 72\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J \u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0019H\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0002J\u001a\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0016H\u0002J+\u0010#\u001a\u00020\u00022#\u0010\"\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0004\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00020\u001eJ\u000e\u0010$\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010&\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010%\u001a\u00020\bR\u0018\u0010)\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001c\u00104\u001a\b\u0012\u0004\u0012\u00020\u0006018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/zootopia/openid/ZootopiaOpenIdSilentHelper;", "", "", "f", "", "uin", "Lcom/tencent/mobileqq/zootopia/openid/a;", "callback", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "Lcom/tencent/mobileqq/Doraemon/DoraemonAPIManager;", "apiMgr", "o", "Landroid/app/Activity;", "topActivity", "g", "", "code", "msg", "p", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lorg/json/JSONObject;", "r", "j", "info", DomainData.DOMAIN_NAME, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "openId", "afterLaunchOpenidAction", ReportConstant.COSTREPORT_PREFIX, "t", "readCacheOnly", tl.h.F, "a", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "memCache", "b", "Ljava/lang/String;", "requestingFromDoraemonForUin", "", "c", "J", "lastRequestingTime", "Ljava/util/concurrent/CopyOnWriteArrayList;", "d", "Ljava/util/concurrent/CopyOnWriteArrayList;", "blockingCallbacks", "<init>", "()V", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaOpenIdSilentHelper {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Lazy<ZootopiaOpenIdSilentHelper> f328598f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private volatile ZootopiaOpenIdResult memCache;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile String requestingFromDoraemonForUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long lastRequestingTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CopyOnWriteArrayList<a> blockingCallbacks = new CopyOnWriteArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/zootopia/openid/ZootopiaOpenIdSilentHelper$a;", "", "Lcom/tencent/mobileqq/zootopia/openid/ZootopiaOpenIdSilentHelper;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zootopia/openid/ZootopiaOpenIdSilentHelper;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "HELPER_INNER_ERR", "I", "", "MAX_BLOCKING_TIME", "J", "NO_CACHE_ERR", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.openid.ZootopiaOpenIdSilentHelper$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZootopiaOpenIdSilentHelper a() {
            return (ZootopiaOpenIdSilentHelper) ZootopiaOpenIdSilentHelper.f328598f.getValue();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/zootopia/openid/ZootopiaOpenIdSilentHelper$c", "Lcom/tencent/mobileqq/Doraemon/a;", "", "code", "", "onPermission", "Lorg/json/JSONObject;", "result", "onSuccess", "", "msg", "onFailure", "onComplete", "onTrigger", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.Doraemon.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f328604b;

        c(String str) {
            this.f328604b = str;
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onFailure(int code, String msg2) {
            ZootopiaOpenIdSilentHelper zootopiaOpenIdSilentHelper = ZootopiaOpenIdSilentHelper.this;
            String str = this.f328604b;
            if (msg2 == null) {
                msg2 = "failure empty des";
            }
            zootopiaOpenIdSilentHelper.p(str, code, msg2);
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onPermission(int code) {
            ZootopiaOpenIdSilentHelper.this.p(this.f328604b, code, "permission error");
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onSuccess(JSONObject result) {
            QLog.i("ZootopiaOpenIdSilentHelper", 1, "loginSilent onSuccess result=" + result);
            ZootopiaOpenIdResult r16 = ZootopiaOpenIdSilentHelper.this.r(this.f328604b, result);
            if (r16 == null || !ZootopiaOpenIdSilentHelper.this.n(this.f328604b, r16)) {
                ZootopiaOpenIdSilentHelper.this.p(this.f328604b, -999, "parsed failure");
            } else {
                ZootopiaOpenIdSilentHelper.this.q(this.f328604b, r16);
            }
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onTrigger(JSONObject result) {
            QLog.i("ZootopiaOpenIdSilentHelper", 1, "loginSilent onTrigger");
            if (QLog.isColorLevel()) {
                QLog.i("ZootopiaOpenIdSilentHelper", 1, "loginSilent onTrigger result=" + result);
            }
        }

        @Override // com.tencent.mobileqq.Doraemon.a
        public void onComplete() {
            QLog.i("ZootopiaOpenIdSilentHelper", 1, "loginSilent onComplete");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/openid/ZootopiaOpenIdSilentHelper$d", "Lcom/tencent/mobileqq/zootopia/openid/a;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "", "errCode", "", "errMsg", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<String, Unit> f328605a;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function1<? super String, Unit> function1) {
            this.f328605a = function1;
        }

        @Override // com.tencent.mobileqq.zootopia.openid.a
        public void b(int errCode, String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("ZootopiaOpenIdSilentHelper", 1, "preloadOpenIdAtLaunch ERROR: " + errCode + " - " + errMsg);
        }

        @Override // com.tencent.mobileqq.zootopia.openid.a
        public void a(ZootopiaOpenIdResult result) {
            QLog.i("ZootopiaOpenIdSilentHelper", 1, "preloadOpenIdAtLaunch SUCCESS");
            this.f328605a.invoke(result != null ? result.getOpenId() : null);
        }
    }

    static {
        Lazy<ZootopiaOpenIdSilentHelper> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaOpenIdSilentHelper>() { // from class: com.tencent.mobileqq.zootopia.openid.ZootopiaOpenIdSilentHelper$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaOpenIdSilentHelper invoke() {
                return new ZootopiaOpenIdSilentHelper();
            }
        });
        f328598f = lazy;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0027 A[Catch: all -> 0x0034, TryCatch #0 {, blocks: (B:4:0x0002, B:6:0x000d, B:8:0x0013, B:10:0x001b, B:15:0x0027, B:16:0x002c), top: B:3:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final synchronized void f() {
        boolean z16;
        boolean isBlank;
        AppRuntime peekAppRuntime;
        this.memCache = null;
        this.blockingCallbacks.clear();
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        String currentUin = (mobileQQ == null || (peekAppRuntime = mobileQQ.peekAppRuntime()) == null) ? null : peekAppRuntime.getCurrentUin();
        if (currentUin != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(currentUin);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    h.f328624a.b(currentUin);
                }
                this.requestingFromDoraemonForUin = null;
                this.lastRequestingTime = 0L;
            }
        }
        z16 = true;
        if (!z16) {
        }
        this.requestingFromDoraemonForUin = null;
        this.lastRequestingTime = 0L;
    }

    private final DoraemonAPIManager g(Activity topActivity) {
        QLog.i("ZootopiaOpenIdSilentHelper", 1, "getDoraemonAPIManager topActivity=" + topActivity);
        IDoraemonService iDoraemonService = (IDoraemonService) QRoute.api(IDoraemonService.class);
        iDoraemonService.prepare();
        return iDoraemonService.createAPIManager(topActivity, 1, ZootopiaEnterParams.ZPLAN_APP_ID);
    }

    private final Activity j() {
        Activity topActivity = Foreground.getTopActivity();
        return topActivity == null ? QBaseActivity.sTopActivity : topActivity;
    }

    private final synchronized void k(String uin, a callback) {
        boolean z16 = this.lastRequestingTime > 0 && System.currentTimeMillis() - this.lastRequestingTime > 5000;
        QLog.i("ZootopiaOpenIdSilentHelper", 1, "handleFromDoraemon isBlockingTimeOut=" + z16);
        if (this.requestingFromDoraemonForUin != null && !z16) {
            if (!TextUtils.equals(uin, this.requestingFromDoraemonForUin)) {
                callback.b(-999, "requesting for other uin");
                return;
            } else {
                this.blockingCallbacks.addIfAbsent(callback);
                QLog.i("ZootopiaOpenIdSilentHelper", 1, "handleFromDoraemon requestingFromDoraemonForUin != null return");
                return;
            }
        }
        this.blockingCallbacks.addIfAbsent(callback);
        this.requestingFromDoraemonForUin = uin;
        this.lastRequestingTime = System.currentTimeMillis();
        Activity j3 = j();
        if (j3 == null) {
            QLog.i("ZootopiaOpenIdSilentHelper", 1, "handleFromDoraemon, topActivity is null");
            p(uin, -999, "activity is null");
            return;
        }
        DoraemonAPIManager g16 = g(j3);
        if (g16 == null) {
            QLog.i("ZootopiaOpenIdSilentHelper", 1, "apiMgr is null");
            p(uin, -999, "apiMgr is null");
        } else {
            o(g16, uin);
        }
    }

    private final synchronized boolean l(String uin, a callback) {
        ZootopiaOpenIdResult zootopiaOpenIdResult = this.memCache;
        if (zootopiaOpenIdResult == null) {
            return false;
        }
        if (n(uin, zootopiaOpenIdResult)) {
            if (QLog.isColorLevel()) {
                QLog.i("ZootopiaOpenIdSilentHelper", 1, "handleFromMem result=" + zootopiaOpenIdResult);
            }
            callback.a(zootopiaOpenIdResult);
            return true;
        }
        this.memCache = null;
        return false;
    }

    private final synchronized boolean m(String uin, a callback) {
        h hVar = h.f328624a;
        ZootopiaOpenIdResult e16 = hVar.e(uin);
        if (e16 == null) {
            return false;
        }
        if (n(uin, e16)) {
            this.memCache = e16;
            if (QLog.isColorLevel()) {
                QLog.i("ZootopiaOpenIdSilentHelper", 1, "handleFromSP spCache=" + e16);
            }
            callback.a(e16);
            return true;
        }
        this.memCache = null;
        hVar.b(uin);
        return false;
    }

    private final void o(DoraemonAPIManager apiMgr, String uin) {
        QLog.i("ZootopiaOpenIdSilentHelper", 1, "loginSilent");
        apiMgr.d("loginSilent", null, new c(uin));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void p(String uin, int code, String msg2) {
        QLog.i("ZootopiaOpenIdSilentHelper", 1, "notifyHandleFromDoraemonFailed, " + code + ", " + msg2);
        if (TextUtils.equals(uin, this.requestingFromDoraemonForUin)) {
            Iterator<T> it = this.blockingCallbacks.iterator();
            while (it.hasNext()) {
                ((a) it.next()).b(code, msg2);
            }
            this.blockingCallbacks.clear();
            this.requestingFromDoraemonForUin = null;
            this.lastRequestingTime = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void q(String uin, ZootopiaOpenIdResult result) {
        QLog.i("ZootopiaOpenIdSilentHelper", 1, "notifyHandleFromDoraemonSuccessed");
        if (QLog.isColorLevel()) {
            QLog.i("ZootopiaOpenIdSilentHelper", 1, "notifyHandleFromDoraemonSuccessed result=" + result);
        }
        if (TextUtils.equals(uin, this.requestingFromDoraemonForUin)) {
            this.memCache = result;
            Iterator<T> it = this.blockingCallbacks.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(result);
            }
            this.blockingCallbacks.clear();
            h.f328624a.h(uin, result);
            this.requestingFromDoraemonForUin = null;
            this.lastRequestingTime = 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003e A[Catch: all -> 0x0082, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0024, B:7:0x002a, B:9:0x0032, B:14:0x003e, B:18:0x0048, B:20:0x004e, B:23:0x0059, B:25:0x005f, B:29:0x006c, B:32:0x007d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0048 A[Catch: all -> 0x0082, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0024, B:7:0x002a, B:9:0x0032, B:14:0x003e, B:18:0x0048, B:20:0x004e, B:23:0x0059, B:25:0x005f, B:29:0x006c, B:32:0x007d), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void h(a callback, boolean readCacheOnly) {
        boolean z16;
        boolean isBlank;
        AppRuntime peekAppRuntime;
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("ZootopiaOpenIdSilentHelper", 1, "getOpenIdInfo start - " + readCacheOnly);
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        String currentUin = (mobileQQ == null || (peekAppRuntime = mobileQQ.peekAppRuntime()) == null) ? null : peekAppRuntime.getCurrentUin();
        if (currentUin != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(currentUin);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    callback.b(-999, "uin isNullOrBlank");
                    return;
                }
                if (l(currentUin, callback)) {
                    QLog.i("ZootopiaOpenIdSilentHelper", 1, "handle from mem");
                    return;
                }
                if (m(currentUin, callback)) {
                    QLog.i("ZootopiaOpenIdSilentHelper", 1, "handle from sp");
                    return;
                }
                if (readCacheOnly) {
                    callback.b(-888, "no cache found");
                    k(currentUin, new b());
                } else {
                    k(currentUin, callback);
                }
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    public final void s(Function1<? super String, Unit> afterLaunchOpenidAction) {
        Intrinsics.checkNotNullParameter(afterLaunchOpenidAction, "afterLaunchOpenidAction");
        QLog.i("ZootopiaOpenIdSilentHelper", 1, "preloadOpenIdAtLaunch");
        i(this, new d(afterLaunchOpenidAction), false, 2, null);
    }

    public final synchronized void t(a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        f();
        i(this, callback, false, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean n(String uin, ZootopiaOpenIdResult info) {
        if (info == null) {
            return false;
        }
        if (!TextUtils.equals(uin, info.getUin())) {
            QLog.d("ZootopiaOpenIdSilentHelper", 4, "isValidOpenIdInfo, uin not equals");
            return false;
        }
        if (!TextUtils.isEmpty(info.getOpenId()) && !TextUtils.isEmpty(info.getAccessToken()) && !TextUtils.isEmpty(info.getPayToken())) {
            QLog.i("ZootopiaOpenIdSilentHelper", 1, "isValidOpenIdInfo, info.expiredTime=" + info.getExpiredTime());
            if (NetConnInfoCenter.getServerTimeMillis() < info.getExpiredTime() - MiniBoxNoticeInfo.MIN_5) {
                return true;
            }
            QLog.i("ZootopiaOpenIdSilentHelper", 1, "isValidOpenIdInfo, expire");
            return false;
        }
        QLog.d("ZootopiaOpenIdSilentHelper", 4, "isValidOpenIdInfo, some info empty");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ZootopiaOpenIdResult r(String uin, JSONObject result) {
        if (result == null) {
            return null;
        }
        long min = Math.min(result.optLong("expire_in", 0L) * 1000, 432000000L);
        String optString = result.optString("openid", "");
        Intrinsics.checkNotNullExpressionValue(optString, "data.optString(ZootopiaO\u2026Y_SDK_SILENT_OPEN_ID, \"\")");
        String optString2 = result.optString(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN, "");
        Intrinsics.checkNotNullExpressionValue(optString2, "data.optString(ZootopiaO\u2026_SILENT_ACCESS_TOKEN, \"\")");
        String optString3 = result.optString("pay_token", "");
        Intrinsics.checkNotNullExpressionValue(optString3, "data.optString(ZootopiaO\u2026SDK_SILENT_PAY_TOKEN, \"\")");
        return new ZootopiaOpenIdResult(uin, optString, optString2, optString3, NetConnInfoCenter.getServerTimeMillis() + min, NetConnInfoCenter.getServerTimeMillis());
    }

    public static /* synthetic */ void i(ZootopiaOpenIdSilentHelper zootopiaOpenIdSilentHelper, a aVar, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        zootopiaOpenIdSilentHelper.h(aVar, z16);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/openid/ZootopiaOpenIdSilentHelper$b", "Lcom/tencent/mobileqq/zootopia/openid/a;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "", "errCode", "", "errMsg", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements a {
        b() {
        }

        @Override // com.tencent.mobileqq.zootopia.openid.a
        public void b(int errCode, String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        }

        @Override // com.tencent.mobileqq.zootopia.openid.a
        public void a(ZootopiaOpenIdResult result) {
        }
    }
}
