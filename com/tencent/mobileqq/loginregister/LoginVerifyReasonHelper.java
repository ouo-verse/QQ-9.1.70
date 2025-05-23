package com.tencent.mobileqq.loginregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dt.api.IQSecChannel;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.loginregister.LoginVerifyReasonHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tenpay.sdk.util.QWSoterConstans;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\u001a\u0005\u001bB\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J6\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007R0\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/loginregister/LoginVerifyReasonHelper;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Loicq/wlogin_sdk/devicelock/DevlockInfo;", "b", "devlockInfo", "", "businessType", "sceneType", "Lcom/tencent/mobileqq/loginregister/callback/a;", "callback", "", "timeout", "", "c", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/loginregister/LoginVerifyReasonHelper$a;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "queryJobMap", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "<init>", "()V", "a", "QueryState", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LoginVerifyReasonHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LoginVerifyReasonHelper f242804a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, a> queryJobMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Object lock;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/loginregister/LoginVerifyReasonHelper$QueryState;", "", "(Ljava/lang/String;I)V", QZoneCoverStoreJsPlugin.INIT_PLUGIN, "Running", "Finish", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class QueryState {
        private static final /* synthetic */ QueryState[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final QueryState Finish;
        public static final QueryState Init;
        public static final QueryState Running;

        private static final /* synthetic */ QueryState[] $values() {
            return new QueryState[]{Init, Running, Finish};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24273);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            Init = new QueryState(QZoneCoverStoreJsPlugin.INIT_PLUGIN, 0);
            Running = new QueryState("Running", 1);
            Finish = new QueryState("Finish", 2);
            $VALUES = $values();
        }

        QueryState(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static QueryState valueOf(String str) {
            return (QueryState) Enum.valueOf(QueryState.class, str);
        }

        public static QueryState[] values() {
            return (QueryState[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b*\u0010+J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J \u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J \u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u001a\u0010\u0016\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010!R$\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u00020#j\b\u0012\u0004\u0012\u00020\u0002`$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010%R\u0014\u0010)\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/loginregister/LoginVerifyReasonHelper$a;", "", "Lcom/tencent/mobileqq/loginregister/callback/a;", "callback", "", "timeout", "", "e", "Lcom/tencent/mobileqq/loginregister/LoginVerifyReasonHelper$QueryState;", "newState", "d", "g", "k", "", "uin", "", "code", QCircleWeakNetReporter.KEY_COST, "i", "start", "checkTime", "j", tl.h.F, "Lcom/tencent/mobileqq/loginregister/LoginVerifyReasonHelper$b;", "a", "Lcom/tencent/mobileqq/loginregister/LoginVerifyReasonHelper$b;", "queryRawData", "b", "Lcom/tencent/mobileqq/loginregister/LoginVerifyReasonHelper$QueryState;", "state", "c", "J", "startTime", "Ljava/lang/String;", "response", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "callbackSet", "f", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "<init>", "(Lcom/tencent/mobileqq/loginregister/LoginVerifyReasonHelper$b;)V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final b queryRawData;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private QueryState state;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private long startTime;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String response;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final HashSet<com.tencent.mobileqq.loginregister.callback.a> callbackSet;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Object lock;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.loginregister.LoginVerifyReasonHelper$a$a, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        public /* synthetic */ class C7993a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f242813a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24256);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 1)) {
                    redirector.redirect((short) 1);
                    return;
                }
                int[] iArr = new int[QueryState.values().length];
                try {
                    iArr[QueryState.Init.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[QueryState.Running.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[QueryState.Finish.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f242813a = iArr;
            }
        }

        public a(@NotNull b queryRawData) {
            Intrinsics.checkNotNullParameter(queryRawData, "queryRawData");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) queryRawData);
                return;
            }
            this.queryRawData = queryRawData;
            this.state = QueryState.Init;
            this.callbackSet = new HashSet<>();
            this.lock = new Object();
        }

        private final void d(QueryState newState) {
            synchronized (this.lock) {
                QueryState queryState = this.state;
                int i3 = C7993a.f242813a[newState.ordinal()];
                if (i3 != 2) {
                    if (i3 == 3) {
                        QueryState queryState2 = this.state;
                        if (queryState2 != QueryState.Init && queryState2 != QueryState.Running) {
                            return;
                        }
                        this.state = newState;
                        g();
                    }
                } else {
                    QueryState queryState3 = this.state;
                    if (queryState3 == QueryState.Finish) {
                        g();
                    } else if (queryState3 == QueryState.Init) {
                        this.state = QueryState.Running;
                        this.startTime = System.currentTimeMillis();
                        k();
                    }
                }
                QLog.d("LoginVerifyReasonHelper", 4, "changeState: " + queryState + " -> " + newState);
                Unit unit = Unit.INSTANCE;
            }
        }

        private final void e(final com.tencent.mobileqq.loginregister.callback.a callback, long timeout) {
            if (timeout > 0) {
                ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.loginregister.ab
                    @Override // java.lang.Runnable
                    public final void run() {
                        LoginVerifyReasonHelper.a.f(LoginVerifyReasonHelper.a.this, callback);
                    }
                }, 16, null, false, timeout);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(a this$0, com.tencent.mobileqq.loginregister.callback.a callback) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            synchronized (this$0.lock) {
                QLog.d("LoginVerifyReasonHelper", 4, "checkTimeout contains: " + this$0.callbackSet.contains(callback));
                if (this$0.callbackSet.contains(callback)) {
                    QLog.i("LoginVerifyReasonHelper", 1, "queryVerifyReason timeout. response: " + this$0.response);
                    this$0.callbackSet.remove(callback);
                    callback.onResult(this$0.response);
                    this$0.j(String.valueOf(this$0.queryRawData.c()), this$0.startTime, System.currentTimeMillis());
                }
                Unit unit = Unit.INSTANCE;
            }
        }

        private final void g() {
            synchronized (this.lock) {
                Iterator<com.tencent.mobileqq.loginregister.callback.a> it = this.callbackSet.iterator();
                while (it.hasNext()) {
                    it.next().onResult(this.response);
                }
                this.callbackSet.clear();
                Unit unit = Unit.INSTANCE;
            }
        }

        private final void i(String uin, int code, long cost) {
            String str;
            try {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(IPrefRecorder.AI_ELIMINATE_RESPONSE_CODE, String.valueOf(code));
                if (code == 0) {
                    str = "true";
                } else {
                    str = "false";
                }
                linkedHashMap.put(VRReportDefine$ReportParam.IS_SUCCESS, str);
                linkedHashMap.put("cost_time", String.valueOf(cost));
                QQBeaconReport.report(uin, "login_verify_tips_query", linkedHashMap);
            } catch (Exception e16) {
                QLog.e("LoginVerifyReasonHelper", 1, "reportSSOSend exception: ", e16);
            }
        }

        private final void j(String uin, long start, long checkTime) {
            try {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("start", String.valueOf(start));
                linkedHashMap.put("check_time", String.valueOf(checkTime));
                QQBeaconReport.report(uin, "login_verify_tips_query_timeout", linkedHashMap);
            } catch (Exception e16) {
                QLog.e("LoginVerifyReasonHelper", 1, "reportSSOSend exception: ", e16);
            }
        }

        private final void k() {
            boolean z16;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (!(peekAppRuntime instanceof AppInterface)) {
                QLog.e("LoginVerifyReasonHelper", 1, "sendRequest appRuntime is not AppInterface");
                d(QueryState.Finish);
                return;
            }
            String a16 = this.queryRawData.a();
            if (QLog.isDevelopLevel()) {
                QLog.d("LoginVerifyReasonHelper", 4, "sendRequest json: " + a16);
            }
            if (a16.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                d(QueryState.Finish);
                return;
            }
            try {
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                byte[] bytes = a16.getBytes(UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                final long currentTimeMillis = System.currentTimeMillis();
                ((IQSecChannel) QRoute.api(IQSecChannel.class)).sendRequest((AppInterface) peekAppRuntime, "QueryVerifyReason", bytes, new com.tencent.mobileqq.dt.api.a() { // from class: com.tencent.mobileqq.loginregister.ac
                    @Override // com.tencent.mobileqq.dt.api.a
                    public final void onResult(int i3, byte[] bArr) {
                        LoginVerifyReasonHelper.a.l(currentTimeMillis, this, i3, bArr);
                    }
                });
            } catch (Exception e16) {
                QLog.e("LoginVerifyReasonHelper", 1, "sendRequest Exception: ", e16);
                d(QueryState.Finish);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(final long j3, final a this$0, final int i3, final byte[] bArr) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.loginregister.ad
                @Override // java.lang.Runnable
                public final void run() {
                    LoginVerifyReasonHelper.a.m(j3, i3, this$0, bArr);
                }
            }, 16, null, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:15:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final void m(long j3, int i3, a this$0, byte[] bArr) {
            String str;
            boolean z16;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            long currentTimeMillis = System.currentTimeMillis() - j3;
            QLog.i("LoginVerifyReasonHelper", 1, "sendRequest onResponse result: " + i3 + ", cost: " + currentTimeMillis);
            this$0.i(String.valueOf(this$0.queryRawData.c()), i3, currentTimeMillis);
            if (i3 == 0 && bArr != null) {
                try {
                    if (bArr.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                } catch (Exception e16) {
                    QLog.e("LoginVerifyReasonHelper", 1, "sendRequest parse data Exception: ", e16);
                }
                if (!z16) {
                    JSONObject jSONObject = new JSONObject(new String(bArr, Charsets.UTF_8));
                    int i16 = jSONObject.getInt("state");
                    QLog.i("LoginVerifyReasonHelper", 1, "sendRequest onResponse: " + jSONObject);
                    if (i16 == 1) {
                        str = jSONObject.getString("prompt");
                        synchronized (this$0.lock) {
                            this$0.response = str;
                            Unit unit = Unit.INSTANCE;
                        }
                        this$0.d(QueryState.Finish);
                        return;
                    }
                }
            }
            str = null;
            synchronized (this$0.lock) {
            }
        }

        public final void h(@Nullable com.tencent.mobileqq.loginregister.callback.a callback, long timeout) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, callback, Long.valueOf(timeout));
                return;
            }
            if (callback != null) {
                synchronized (this.lock) {
                    this.callbackSet.add(callback);
                }
                e(callback, timeout);
            }
            d(QueryState.Running);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\u0018\u0000 \u00172\u00020\u0001:\u0001\u0004B=\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\n\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0005R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0005\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/loginregister/LoginVerifyReasonHelper$b;", "", "", "b", "a", "Ljava/lang/String;", PreloadTRTCPlayerParams.KEY_SIG, "", "I", "businessType", "c", "sceneType", "", "d", "J", "()J", "uin", "e", "account", "f", "uinToken", "<init>", "(Ljava/lang/String;IIJLjava/lang/String;Ljava/lang/String;)V", "g", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String sig;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int businessType;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int sceneType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long uin;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String account;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String uinToken;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/loginregister/LoginVerifyReasonHelper$b$a;", "", "Loicq/wlogin_sdk/devicelock/DevlockInfo;", "devlockInfo", "", "businessType", "sceneType", "Lcom/tencent/mobileqq/loginregister/LoginVerifyReasonHelper$b;", "a", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.loginregister.LoginVerifyReasonHelper$b$a, reason: from kotlin metadata */
        /* loaded from: classes15.dex */
        public static final class Companion {
            static IPatchRedirector $redirector_;

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                    return;
                }
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
            }

            /* JADX WARN: Code restructure failed: missing block: B:32:0x007d, code lost:
            
                r3 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r3);
             */
            @Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final b a(@Nullable DevlockInfo devlockInfo, int businessType, int sceneType) {
                boolean z16;
                String str;
                long j3;
                String str2;
                Long longOrNull;
                IPatchRedirector iPatchRedirector = $redirector_;
                boolean z17 = false;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (b) iPatchRedirector.redirect((short) 2, this, devlockInfo, Integer.valueOf(businessType), Integer.valueOf(sceneType));
                }
                if (devlockInfo == null) {
                    return null;
                }
                String str3 = devlockInfo.OtherDevLockVerifyUrl;
                if (str3 != null && str3.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    return null;
                }
                try {
                    Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(str3);
                    String str4 = argumentsFromURL.get(PreloadTRTCPlayerParams.KEY_SIG);
                    if (str4 == null || str4.length() == 0) {
                        z17 = true;
                    }
                    if (z17) {
                        QLog.e("LoginVerifyReasonHelper", 1, "buildRequestJson account or sig is empty");
                        return null;
                    }
                    String str5 = argumentsFromURL.get("account");
                    if (str5 == null) {
                        str = "";
                    } else {
                        str = str5;
                    }
                    String str6 = argumentsFromURL.get("uin");
                    if (str6 != null && longOrNull != null) {
                        j3 = longOrNull.longValue();
                    } else {
                        j3 = 0;
                    }
                    long j16 = j3;
                    String str7 = argumentsFromURL.get("uin-token");
                    if (str7 == null) {
                        str2 = "";
                    } else {
                        str2 = str7;
                    }
                    return new b(str4, businessType, sceneType, j16, str, str2);
                } catch (Exception e16) {
                    QLog.e("LoginVerifyReasonHelper", 1, "buildRequestJson catch exception: ", e16);
                    return null;
                }
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
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24269);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 6)) {
                redirector.redirect((short) 6);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public b(@NotNull String sig, int i3, int i16, long j3, @NotNull String account, @NotNull String uinToken) {
            Intrinsics.checkNotNullParameter(sig, "sig");
            Intrinsics.checkNotNullParameter(account, "account");
            Intrinsics.checkNotNullParameter(uinToken, "uinToken");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, sig, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3), account, uinToken);
                return;
            }
            this.sig = sig;
            this.businessType = i3;
            this.sceneType = i16;
            this.uin = j3;
            this.account = account;
            this.uinToken = uinToken;
        }

        @NotNull
        public final String a() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(QWSoterConstans.CGI_KEY_BUSI_TYPE, this.businessType);
                jSONObject.put(VRReportDefine$ReportParam.SCENE_TYPE, this.sceneType);
                jSONObject.put("login_time", System.currentTimeMillis());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(PreloadTRTCPlayerParams.KEY_SIG, this.sig);
                boolean z17 = false;
                if (this.account.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    jSONObject2.put("account", this.account);
                }
                long j3 = this.uin;
                if (j3 > 0) {
                    jSONObject2.put("uin", j3);
                }
                if (this.uinToken.length() > 0) {
                    z17 = true;
                }
                if (z17) {
                    jSONObject2.put("uin_token", this.uinToken);
                }
                jSONObject.put("login_sig", jSONObject2);
                jSONObject.put("platform", 2);
                jSONObject.put("version", com.tencent.mobileqq.utils.ah.P());
                String jSONObject3 = jSONObject.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "json.toString()");
                return jSONObject3;
            } catch (Exception e16) {
                QLog.e("LoginVerifyReasonHelper", 1, "buildRequestJson catch exception: ", e16);
                QLog.e("LoginVerifyReasonHelper", 1, "buildRequestJson buildJsonFail");
                return "";
            }
        }

        @NotNull
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.businessType + "_" + this.sceneType + "_" + this.sig;
        }

        public final long c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
            }
            return this.uin;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24275);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f242804a = new LoginVerifyReasonHelper();
        queryJobMap = new HashMap<>();
        lock = new Object();
    }

    LoginVerifyReasonHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @Nullable
    public static final DevlockInfo b(@Nullable Activity activity) {
        Intent intent;
        if (activity == null || (intent = activity.getIntent()) == null) {
            return null;
        }
        Parcelable parcelableExtra = intent.getParcelableExtra(AuthDevOpenUgActivity.KEY_DEVLOCK_INFO);
        if (!(parcelableExtra instanceof DevlockInfo)) {
            return null;
        }
        return (DevlockInfo) parcelableExtra;
    }

    @JvmStatic
    public static final void c(@Nullable DevlockInfo devlockInfo, int businessType, int sceneType, @Nullable final com.tencent.mobileqq.loginregister.callback.a callback, final long timeout) {
        if (QLog.isDevelopLevel()) {
            QLog.d("LoginVerifyReasonHelper", 4, "queryLoginVerifyReason businessType: " + businessType + " sceneType: " + sceneType + ", timeout: " + timeout);
        }
        final b a16 = b.INSTANCE.a(devlockInfo, businessType, sceneType);
        if (a16 == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.loginregister.aa
            @Override // java.lang.Runnable
            public final void run() {
                LoginVerifyReasonHelper.d(LoginVerifyReasonHelper.b.this, callback, timeout);
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(b queryRawData, com.tencent.mobileqq.loginregister.callback.a aVar, long j3) {
        Intrinsics.checkNotNullParameter(queryRawData, "$queryRawData");
        synchronized (lock) {
            HashMap<String, a> hashMap = queryJobMap;
            a aVar2 = hashMap.get(queryRawData.b());
            if (aVar2 == null) {
                aVar2 = new a(queryRawData);
                hashMap.put(queryRawData.b(), aVar2);
            }
            aVar2.h(aVar, j3);
            Unit unit = Unit.INSTANCE;
        }
    }
}
