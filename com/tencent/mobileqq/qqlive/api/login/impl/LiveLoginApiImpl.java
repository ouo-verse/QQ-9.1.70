package com.tencent.mobileqq.qqlive.api.login.impl;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.login.ILiveLoginApi;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.report.h;
import com.tencent.mobileqq.qqlive.sso.request.LiveGetOpenInfoRequest;
import com.tencent.mobileqq.qqlive.sso.request.LiveLoginRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import ip4.a;
import ip4.d;
import ip4.f;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zq4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 42\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b2\u00103J`\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022/\u0010\u000e\u001a+\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006j\u0004\u0018\u0001`\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J5\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0015H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J(\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0019H\u0002J$\u0010\"\u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u001c\u0010#\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016JU\u0010$\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022/\u0010\u000e\u001a+\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0006j\u0004\u0018\u0001`\rH\u0016R\u0014\u0010&\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'RM\u0010*\u001a9\u0012\u0004\u0012\u00020\u0002\u0012/\u0012-\u0012)\u0012'\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006j\u0002`\r0)0(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001b\u00101\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/login/impl/LiveLoginApiImpl;", "Lcom/tencent/mobileqq/qqlive/api/login/ILiveLoginApi;", "", "appId", "uin", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "Lcom/tencent/mobileqq/qqlive/login/LiveLoginInfo;", "Lkotlin/ParameterName;", "name", "response", "", "Lcom/tencent/mobileqq/qqlive/api/login/LoginCallback;", "callback", "doLogin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginInfo", "save", "get", "mmkvKey", "Lzq4/b;", "doAuthRequest", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authRsp", "Lip4/d;", "doLoginRequest", "(Ljava/lang/String;Lzq4/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyResult", "loginRsp", "assembleLoginInfo", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "", "updateUserInfo", "getLoginInfo", "login", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "pendingLoginCallback", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlinx/coroutines/CoroutineScope;", "scope$delegate", "Lkotlin/Lazy;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "()V", "Companion", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class LiveLoginApiImpl implements ILiveLoginApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String LOG_TAG = "Login|LiveLoginApiImpl";

    @NotNull
    public static final String MMKV_KEY_LOGIN_PREFIX = "live_mmkv_key_login_";

    @NotNull
    private final Mutex mutex;

    @NotNull
    private ConcurrentHashMap<String, List<Function1<QQLiveResponse<LiveLoginInfo>, Unit>>> pendingLoginCallback;

    /* renamed from: scope$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy scope;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/login/impl/LiveLoginApiImpl$Companion;", "", "()V", "LOG_TAG", "", "MMKV_KEY_LOGIN_PREFIX", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42792);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LiveLoginApiImpl() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.pendingLoginCallback = new ConcurrentHashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(LiveLoginApiImpl$scope$2.INSTANCE);
        this.scope = lazy;
    }

    private final LiveLoginInfo assembleLoginInfo(String appId, String uin, b authRsp, d loginRsp) {
        String str;
        long j3;
        String str2;
        String str3;
        String str4;
        String str5;
        int i3;
        String str6;
        int i16;
        String str7 = authRsp.f453016b;
        Intrinsics.checkNotNullExpressionValue(str7, "authRsp.accessToken");
        String str8 = authRsp.f453015a;
        Intrinsics.checkNotNullExpressionValue(str8, "authRsp.openid");
        a aVar = loginRsp.f408158a;
        String str9 = null;
        if (aVar != null) {
            str = aVar.f408138a;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        long j16 = 0;
        if (aVar != null) {
            j3 = aVar.f408140c;
        } else {
            j3 = 0;
        }
        if (aVar != null) {
            j16 = aVar.f408139b;
        }
        long j17 = j16;
        if (aVar != null) {
            str2 = aVar.f408142e;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str3 = "";
        } else {
            str3 = str2;
        }
        if (aVar != null) {
            str4 = aVar.f408144g;
        } else {
            str4 = null;
        }
        if (str4 == null) {
            str5 = "";
        } else {
            str5 = str4;
        }
        if (aVar != null) {
            i3 = aVar.f408143f;
        } else {
            i3 = -1;
        }
        int i17 = i3;
        f fVar = loginRsp.f408159b;
        if (fVar != null) {
            str9 = fVar.f408168a;
        }
        if (str9 == null) {
            str6 = "";
        } else {
            str6 = str9;
        }
        if (fVar != null) {
            i16 = fVar.f408169b;
        } else {
            i16 = 0;
        }
        return new LiveLoginInfo(appId, str7, str8, str, j3, uin, j17, str3, str5, i17, str6, i16, NetConnInfoCenter.getServerTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object doAuthRequest(String str, String str2, String str3, Continuation<? super QQLiveResponse<b>> continuation) {
        Long l3;
        Long longOrNull;
        boolean z16;
        boolean isBlank;
        boolean isBlank2;
        Boolean bool = null;
        if (str2 != null) {
            l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(str2);
        } else {
            l3 = null;
        }
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
        if (str3 != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str3);
            if (!isBlank2) {
                z16 = false;
                if (z16 && l3 != null && longOrNull != null) {
                    return ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequestOnSuspend(new LiveGetOpenInfoRequest(longOrNull.longValue(), str3, l3.longValue()), continuation);
                }
                AegisLogger.Companion companion = AegisLogger.INSTANCE;
                if (str3 != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(str3);
                    bool = Boxing.boxBoolean(isBlank);
                }
                companion.e(LOG_TAG, "doAuthRequest", "invalid params, appId=" + str + ", uin=" + str2 + ", a2=" + bool);
                return new QQLiveResponse(null, false, AppConstants.LBS_HELLO_UIN_LONGVALUE, "invalid auth params", null);
            }
        }
        z16 = true;
        if (z16) {
        }
        AegisLogger.Companion companion2 = AegisLogger.INSTANCE;
        if (str3 != null) {
        }
        companion2.e(LOG_TAG, "doAuthRequest", "invalid params, appId=" + str + ", uin=" + str2 + ", a2=" + bool);
        return new QQLiveResponse(null, false, AppConstants.LBS_HELLO_UIN_LONGVALUE, "invalid auth params", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object doLogin(String str, String str2, String str3, Function1<? super QQLiveResponse<LiveLoginInfo>, Unit> function1, Continuation<? super Unit> continuation) {
        LiveLoginApiImpl$doLogin$1 liveLoginApiImpl$doLogin$1;
        Object coroutine_suspended;
        int i3;
        String str4;
        LiveLoginApiImpl liveLoginApiImpl;
        String str5;
        String str6;
        List<Function1<QQLiveResponse<LiveLoginInfo>, Unit>> mutableListOf;
        List<Function1<QQLiveResponse<LiveLoginInfo>, Unit>> list;
        QQLiveResponse qQLiveResponse;
        String str7;
        QQLiveResponse qQLiveResponse2;
        String str8;
        QQLiveResponse qQLiveResponse3;
        if (continuation instanceof LiveLoginApiImpl$doLogin$1) {
            liveLoginApiImpl$doLogin$1 = (LiveLoginApiImpl$doLogin$1) continuation;
            int i16 = liveLoginApiImpl$doLogin$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                liveLoginApiImpl$doLogin$1.label = i16 - Integer.MIN_VALUE;
                LiveLoginApiImpl$doLogin$1 liveLoginApiImpl$doLogin$12 = liveLoginApiImpl$doLogin$1;
                Object obj = liveLoginApiImpl$doLogin$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = liveLoginApiImpl$doLogin$12.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.pendingLoginCallback.containsKey(str)) {
                        if (function1 != null && (list = this.pendingLoginCallback.get(str)) != null) {
                            Boxing.boxBoolean(list.add(function1));
                        }
                        AegisLogger.Companion companion = AegisLogger.INSTANCE;
                        List<Function1<QQLiveResponse<LiveLoginInfo>, Unit>> list2 = this.pendingLoginCallback.get(str);
                        companion.i(LOG_TAG, "login", "no login, pending callback, size=" + (list2 != null ? Boxing.boxInt(list2.size()) : null));
                        return Unit.INSTANCE;
                    }
                    if (function1 != null) {
                        ConcurrentHashMap<String, List<Function1<QQLiveResponse<LiveLoginInfo>, Unit>>> concurrentHashMap = this.pendingLoginCallback;
                        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(function1);
                        concurrentHashMap.put(str, mutableListOf);
                    }
                    AegisLogger.INSTANCE.i(LOG_TAG, "login", "no login, to request");
                    str4 = LOG_TAG;
                    h.d(str, QQLiveReportConstants.Event.E_LOGIN, "begin", null, 8, null);
                    liveLoginApiImpl$doLogin$12.L$0 = this;
                    liveLoginApiImpl$doLogin$12.L$1 = str;
                    liveLoginApiImpl$doLogin$12.L$2 = str2;
                    liveLoginApiImpl$doLogin$12.label = 1;
                    obj = doAuthRequest(str, str2, str3, liveLoginApiImpl$doLogin$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    liveLoginApiImpl = this;
                    str5 = str;
                    str6 = str2;
                } else {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        qQLiveResponse2 = (QQLiveResponse) liveLoginApiImpl$doLogin$12.L$3;
                        str7 = (String) liveLoginApiImpl$doLogin$12.L$2;
                        str8 = (String) liveLoginApiImpl$doLogin$12.L$1;
                        liveLoginApiImpl = (LiveLoginApiImpl) liveLoginApiImpl$doLogin$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        str4 = LOG_TAG;
                        qQLiveResponse3 = (QQLiveResponse) obj;
                        if (qQLiveResponse3.isFailed() && qQLiveResponse3.getRsp() != null) {
                            AegisLogger.Companion companion2 = AegisLogger.INSTANCE;
                            companion2.i(str4, "login", "login success");
                            Intrinsics.checkNotNull(str7);
                            Object rsp = qQLiveResponse2.getRsp();
                            Intrinsics.checkNotNull(rsp);
                            Object rsp2 = qQLiveResponse3.getRsp();
                            Intrinsics.checkNotNull(rsp2);
                            LiveLoginInfo assembleLoginInfo = liveLoginApiImpl.assembleLoginInfo(str8, str7, (b) rsp, (d) rsp2);
                            liveLoginApiImpl.save(str8, assembleLoginInfo);
                            companion2.i(str4, "login", "save success");
                            if (companion2.isDevelopLevel()) {
                                companion2.d(str4, "login", "login success, " + assembleLoginInfo);
                            }
                            liveLoginApiImpl.notifyResult(str8, new QQLiveResponse<>(qQLiveResponse3.getRequest(), true, 0L, null, assembleLoginInfo));
                            return Unit.INSTANCE;
                        }
                        AegisLogger.INSTANCE.e(str4, "login", "login error, errCode=" + qQLiveResponse2.getRetCode() + ", errMsg=" + qQLiveResponse2.getErrMsg());
                        liveLoginApiImpl.notifyResult(str8, new QQLiveResponse<>(qQLiveResponse3.getRequest(), qQLiveResponse3.isSuccess(), qQLiveResponse3.getRetCode(), qQLiveResponse3.getErrMsg(), null));
                        h.c(str8, QQLiveReportConstants.Event.E_LOGIN, qQLiveResponse3.getErrMsg(), String.valueOf(qQLiveResponse3.getRetCode()));
                        return Unit.INSTANCE;
                    }
                    str6 = (String) liveLoginApiImpl$doLogin$12.L$2;
                    str5 = (String) liveLoginApiImpl$doLogin$12.L$1;
                    LiveLoginApiImpl liveLoginApiImpl2 = (LiveLoginApiImpl) liveLoginApiImpl$doLogin$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    liveLoginApiImpl = liveLoginApiImpl2;
                    str4 = LOG_TAG;
                }
                qQLiveResponse = (QQLiveResponse) obj;
                if (qQLiveResponse.isFailed() && qQLiveResponse.getRsp() != null) {
                    AegisLogger.Companion companion3 = AegisLogger.INSTANCE;
                    companion3.i(str4, "login", "auth success");
                    if (companion3.isDevelopLevel()) {
                        companion3.d(str4, "login", "auth success, " + qQLiveResponse.getRsp());
                    }
                    Object rsp3 = qQLiveResponse.getRsp();
                    Intrinsics.checkNotNull(rsp3);
                    liveLoginApiImpl$doLogin$12.L$0 = liveLoginApiImpl;
                    liveLoginApiImpl$doLogin$12.L$1 = str5;
                    liveLoginApiImpl$doLogin$12.L$2 = str6;
                    liveLoginApiImpl$doLogin$12.L$3 = qQLiveResponse;
                    liveLoginApiImpl$doLogin$12.label = 2;
                    Object doLoginRequest = liveLoginApiImpl.doLoginRequest(str5, (b) rsp3, liveLoginApiImpl$doLogin$12);
                    if (doLoginRequest == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    String str9 = str5;
                    str7 = str6;
                    qQLiveResponse2 = qQLiveResponse;
                    obj = doLoginRequest;
                    str8 = str9;
                    qQLiveResponse3 = (QQLiveResponse) obj;
                    if (qQLiveResponse3.isFailed()) {
                    }
                    AegisLogger.INSTANCE.e(str4, "login", "login error, errCode=" + qQLiveResponse2.getRetCode() + ", errMsg=" + qQLiveResponse2.getErrMsg());
                    liveLoginApiImpl.notifyResult(str8, new QQLiveResponse<>(qQLiveResponse3.getRequest(), qQLiveResponse3.isSuccess(), qQLiveResponse3.getRetCode(), qQLiveResponse3.getErrMsg(), null));
                    h.c(str8, QQLiveReportConstants.Event.E_LOGIN, qQLiveResponse3.getErrMsg(), String.valueOf(qQLiveResponse3.getRetCode()));
                    return Unit.INSTANCE;
                }
                AegisLogger.INSTANCE.e(str4, "login", "auth error, errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
                liveLoginApiImpl.notifyResult(str5, new QQLiveResponse<>(qQLiveResponse.getRequest(), qQLiveResponse.isSuccess(), qQLiveResponse.getRetCode(), qQLiveResponse.getErrMsg(), null));
                h.c(str5, QQLiveReportConstants.Event.E_LOGIN, qQLiveResponse.getErrMsg(), String.valueOf(qQLiveResponse.getRetCode()));
                return Unit.INSTANCE;
            }
        }
        liveLoginApiImpl$doLogin$1 = new LiveLoginApiImpl$doLogin$1(this, continuation);
        LiveLoginApiImpl$doLogin$1 liveLoginApiImpl$doLogin$122 = liveLoginApiImpl$doLogin$1;
        Object obj2 = liveLoginApiImpl$doLogin$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = liveLoginApiImpl$doLogin$122.label;
        if (i3 != 0) {
        }
        qQLiveResponse = (QQLiveResponse) obj2;
        if (qQLiveResponse.isFailed()) {
        }
        AegisLogger.INSTANCE.e(str4, "login", "auth error, errCode=" + qQLiveResponse.getRetCode() + ", errMsg=" + qQLiveResponse.getErrMsg());
        liveLoginApiImpl.notifyResult(str5, new QQLiveResponse<>(qQLiveResponse.getRequest(), qQLiveResponse.isSuccess(), qQLiveResponse.getRetCode(), qQLiveResponse.getErrMsg(), null));
        h.c(str5, QQLiveReportConstants.Event.E_LOGIN, qQLiveResponse.getErrMsg(), String.valueOf(qQLiveResponse.getRetCode()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doLoginRequest(String str, b bVar, Continuation<? super QQLiveResponse<d>> continuation) {
        boolean isBlank;
        String str2;
        com.tencent.mobileqq.qqlive.config.b a16 = com.tencent.mobileqq.qqlive.config.a.INSTANCE.a(str).a();
        String f16 = a16.f();
        isBlank = StringsKt__StringsJVMKt.isBlank(f16);
        if (isBlank) {
            str2 = str;
        } else {
            str2 = f16;
        }
        String g16 = a16.g();
        String str3 = bVar.f453015a;
        Intrinsics.checkNotNullExpressionValue(str3, "authRsp.openid");
        String str4 = bVar.f453016b;
        Intrinsics.checkNotNullExpressionValue(str4, "authRsp.accessToken");
        return ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequestOnSuspend(new LiveLoginRequest(str, str3, str4, str2, g16, a16.e()), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final LiveLoginInfo get(String appId, String uin) {
        boolean isBlank;
        boolean z16;
        boolean isBlank2;
        isBlank = StringsKt__StringsJVMKt.isBlank(appId);
        if (!isBlank) {
            if (uin != null) {
                isBlank2 = StringsKt__StringsJVMKt.isBlank(uin);
                if (!isBlank2) {
                    z16 = false;
                    if (!z16) {
                        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
                        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
                        return (LiveLoginInfo) from.decodeParcelable(mmkvKey(appId, uin), LiveLoginInfo.class, null);
                    }
                }
            }
            z16 = true;
            if (!z16) {
            }
        }
        AegisLogger.INSTANCE.e(LOG_TAG, "get", "invalid params, appId=" + appId + ", uin=" + uin, new RuntimeException());
        return null;
    }

    private final CoroutineScope getScope() {
        return (CoroutineScope) this.scope.getValue();
    }

    private final String mmkvKey(String appId, String uin) {
        String str;
        if (AppSetting.H) {
            str = "test";
        } else {
            str = "prod";
        }
        return MMKV_KEY_LOGIN_PREFIX + appId + "_" + uin + "_" + str;
    }

    private final void notifyResult(String appId, QQLiveResponse<LiveLoginInfo> response) {
        List<Function1<QQLiveResponse<LiveLoginInfo>, Unit>> list = this.pendingLoginCallback.get(appId);
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                try {
                    ((Function1) it.next()).invoke(response);
                } catch (Exception e16) {
                    AegisLogger.INSTANCE.e(LOG_TAG, "notifyResult", "callback error, ", e16);
                }
            }
        }
        List<Function1<QQLiveResponse<LiveLoginInfo>, Unit>> list2 = this.pendingLoginCallback.get(appId);
        if (list2 != null) {
            list2.clear();
        }
        this.pendingLoginCallback.remove(appId);
    }

    private final void save(String appId, LiveLoginInfo loginInfo) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        from.encodeParcelable(mmkvKey(appId, loginInfo.r()), loginInfo);
    }

    @Override // com.tencent.mobileqq.qqlive.api.login.ILiveLoginApi
    @Nullable
    public LiveLoginInfo getLoginInfo(@NotNull String appId, @Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveLoginInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appId, (Object) uin);
        }
        Intrinsics.checkNotNullParameter(appId, "appId");
        LiveLoginInfo liveLoginInfo = get(appId, uin);
        boolean z16 = false;
        if (liveLoginInfo != null && liveLoginInfo.t()) {
            z16 = true;
        }
        if (z16) {
            return liveLoginInfo;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.qqlive.api.login.ILiveLoginApi
    public void login(@NotNull String appId, @Nullable String uin, @Nullable String a26, @Nullable Function1<? super QQLiveResponse<LiveLoginInfo>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, appId, uin, a26, callback);
        } else {
            Intrinsics.checkNotNullParameter(appId, "appId");
            BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new LiveLoginApiImpl$login$1(this, appId, uin, callback, a26, null), 3, null);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.login.ILiveLoginApi
    public boolean updateUserInfo(@NotNull String appId, @Nullable String uin, @Nullable LiveUserInfo userInfo) {
        boolean z16;
        LiveLoginInfo a16;
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, appId, uin, userInfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (uin != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(uin);
            if (!isBlank) {
                z16 = false;
                if (z16 && userInfo != null) {
                    LiveLoginInfo liveLoginInfo = get(appId, uin);
                    if (liveLoginInfo != null && liveLoginInfo.q() == userInfo.uid) {
                        String headUrl = userInfo.headUrl;
                        String nick = userInfo.nick;
                        int i3 = userInfo.sex;
                        Intrinsics.checkNotNullExpressionValue(nick, "nick");
                        Intrinsics.checkNotNullExpressionValue(headUrl, "headUrl");
                        a16 = liveLoginInfo.a((r33 & 1) != 0 ? liveLoginInfo.appId : null, (r33 & 2) != 0 ? liveLoginInfo.com.huawei.hms.support.feature.result.CommonConstant.KEY_ACCESS_TOKEN java.lang.String : null, (r33 & 4) != 0 ? liveLoginInfo.openId : null, (r33 & 8) != 0 ? liveLoginInfo.businessUid : null, (r33 & 16) != 0 ? liveLoginInfo.tinyId : 0L, (r33 & 32) != 0 ? liveLoginInfo.uin : null, (r33 & 64) != 0 ? liveLoginInfo.uid : 0L, (r33 & 128) != 0 ? liveLoginInfo.nickname : nick, (r33 & 256) != 0 ? liveLoginInfo.com.qzone.album.data.model.PhotoCategorySummaryInfo.AVATAR_URL java.lang.String : headUrl, (r33 & 512) != 0 ? liveLoginInfo.sex : i3, (r33 & 1024) != 0 ? liveLoginInfo.com.tencent.rmonitor.custom.ICustomDataEditor.STRING_ARRAY_PARAM_2 java.lang.String : null, (r33 & 2048) != 0 ? liveLoginInfo.a2ExpireTime : 0, (r33 & 4096) != 0 ? liveLoginInfo.loginTime : 0L);
                        save(appId, a16);
                        AegisLogger.Companion companion = AegisLogger.INSTANCE;
                        if (companion.isDevelopLevel()) {
                            companion.i(LOG_TAG, "updateUserInfo", "user info updated, " + a16);
                        } else {
                            companion.i(LOG_TAG, "updateUserInfo", "user info updated, uin=" + uin + ", nickname=" + a16.m() + ", avatar=" + a16.j());
                        }
                        return true;
                    }
                    AegisLogger.INSTANCE.w(LOG_TAG, "updateUserInfo", "no login info found");
                    return false;
                }
                AegisLogger.INSTANCE.w(LOG_TAG, "updateUserInfo", "invalid params, " + uin + ", " + userInfo);
                return false;
            }
        }
        z16 = true;
        if (z16) {
        }
        AegisLogger.INSTANCE.w(LOG_TAG, "updateUserInfo", "invalid params, " + uin + ", " + userInfo);
        return false;
    }
}
