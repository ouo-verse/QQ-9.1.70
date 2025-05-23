package com.tencent.mobileqq.icgame.api.login.impl;

import com.google.gson.Gson;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.icgame.api.ILiveNetRequest;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.icgame.api.login.ILiveLoginApi;
import com.tencent.mobileqq.icgame.api.sso.QQLiveResponse;
import com.tencent.mobileqq.icgame.context.QQLiveContext;
import com.tencent.mobileqq.icgame.login.LiveLoginInfo;
import com.tencent.mobileqq.icgame.sso.request.LiveLoginRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.utils.LiveCoroutineScopes;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import d32.LiveConfig;
import dz0.a;
import dz0.d;
import dz0.f;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import r32.QQConnectAuthInfo;
import rt0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 92\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b7\u00108J7\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u000f\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J%\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001e\u0010 \u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0002J(\u0010\"\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\rH\u0002J$\u0010%\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010$\u001a\u0004\u0018\u00010#H\u0016J\u001c\u0010&\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016JI\u0010,\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022/\u0010+\u001a+\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\f\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\t\u0018\u00010'j\u0004\u0018\u0001`*H\u0016RM\u0010/\u001a9\u0012\u0004\u0012\u00020\u0002\u0012/\u0012-\u0012)\u0012'\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00040\f\u00a2\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\t0'j\u0002`*0.0-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006:"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/login/impl/LiveLoginApiImpl;", "Lcom/tencent/mobileqq/icgame/api/login/ILiveLoginApi;", "", "appId", "Lcom/tencent/mobileqq/icgame/login/LiveLoginInfo;", "loginInfo", "uin", "", "isRetry", "", "getAuthAndDoRequest", "(Ljava/lang/String;Lcom/tencent/mobileqq/icgame/login/LiveLoginInfo;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/icgame/api/sso/QQLiveResponse;", "Ldz0/d;", "loginResponse", "handleLoginRspFail", "Lcom/tencent/mobileqq/icgame/api/login/impl/AuthRequestRsp;", "authRequestRsp", "qqConnectappId", "handleGetAuthInfoFailed", "saveLiveInfo", "deleteLiveInfo", "getLiveInfoFromMmkv", "mmkvKey", "qqConnectAppid", "getAuthInfoAwait", "(Ljava/lang/String;Lcom/tencent/mobileqq/icgame/login/LiveLoginInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lr32/c;", "authRsp", "doLoginRequest", "(Ljava/lang/String;Lr32/c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "response", "notifyResult", "loginRsp", "assembleLoginInfo", "Lcom/tencent/mobileqq/qqlive/data/user/LiveUserInfo;", ITVKPlayerEventListener.KEY_USER_INFO, "updateUserInfo", "getLoginInfo", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lcom/tencent/mobileqq/icgame/api/login/LoginCallback;", "callback", "login", "", "", "pendingLoginCallback", "Ljava/util/Map;", "Lkotlinx/coroutines/CoroutineScope;", "scope$delegate", "Lkotlin/Lazy;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "()V", "Companion", "ic-game-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LiveLoginApiImpl implements ILiveLoginApi {
    private static final long ERROR_CODE_OPENID_EXPIRED = 1007;

    @NotNull
    private static final String LOG_TAG = "ICGameLogin|ICGameLiveLoginApiImpl";

    @NotNull
    private static final String MMKV_KEY_LOGIN_PREFIX = "icgame_mmkv_key_login_info_";

    @NotNull
    private Map<String, List<Function1<QQLiveResponse<LiveLoginInfo>, Unit>>> pendingLoginCallback = new LinkedHashMap();

    /* renamed from: scope$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy scope;

    public LiveLoginApiImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineScope>() { // from class: com.tencent.mobileqq.icgame.api.login.impl.LiveLoginApiImpl$scope$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineScope invoke() {
                return CoroutineScopeKt.CoroutineScope(LiveCoroutineScopes.f273421a.b());
            }
        });
        this.scope = lazy;
    }

    private final LiveLoginInfo assembleLoginInfo(String appId, String uin, QQConnectAuthInfo authRsp, d loginRsp) {
        String str;
        long j3;
        String str2;
        String str3;
        String str4;
        String str5;
        int i3;
        String str6;
        int i16;
        String accessToken = authRsp.getAccessToken();
        String openid = authRsp.getOpenid();
        a aVar = loginRsp.f395250a;
        String str7 = null;
        if (aVar != null) {
            str = aVar.f395230a;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        long j16 = 0;
        if (aVar != null) {
            j3 = aVar.f395232c;
        } else {
            j3 = 0;
        }
        if (aVar != null) {
            j16 = aVar.f395231b;
        }
        long j17 = j16;
        if (aVar != null) {
            str2 = aVar.f395234e;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str3 = "";
        } else {
            str3 = str2;
        }
        if (aVar != null) {
            str4 = aVar.f395236g;
        } else {
            str4 = null;
        }
        if (str4 == null) {
            str5 = "";
        } else {
            str5 = str4;
        }
        if (aVar != null) {
            i3 = aVar.f395235f;
        } else {
            i3 = -1;
        }
        int i17 = i3;
        f fVar = loginRsp.f395251b;
        if (fVar != null) {
            str7 = fVar.f395260a;
        }
        if (str7 == null) {
            str6 = "";
        } else {
            str6 = str7;
        }
        if (fVar != null) {
            i16 = fVar.f395261b;
        } else {
            i16 = 0;
        }
        return new LiveLoginInfo(appId, accessToken, openid, str, j3, uin, j17, str3, str5, i17, str6, i16, NetConnInfoCenter.getServerTime(), authRsp.getExpireTime());
    }

    private final void deleteLiveInfo(String appId, String uin) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_ICGAME);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_ICGAME)");
        from.removeKey(mmkvKey(appId, uin));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object doLoginRequest(String str, QQConnectAuthInfo qQConnectAuthInfo, Continuation<? super QQLiveResponse<d>> continuation) {
        boolean isBlank;
        String str2;
        rt0.a.INSTANCE.g(LOG_TAG, "login", "doLoginRequest, appId " + str);
        LiveConfig a16 = d32.a.INSTANCE.a(str).a();
        String loginAuthAppId = a16.getLoginAuthAppId();
        isBlank = StringsKt__StringsJVMKt.isBlank(loginAuthAppId);
        if (isBlank) {
            str2 = str;
        } else {
            str2 = loginAuthAppId;
        }
        return ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequestOnSuspend(new LiveLoginRequest(str, qQConnectAuthInfo.getOpenid(), qQConnectAuthInfo.getAccessToken(), str2, a16.getLoginExtData(), a16.getClientType()), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getAuthAndDoRequest(String str, LiveLoginInfo liveLoginInfo, String str2, boolean z16, Continuation<? super Unit> continuation) {
        LiveLoginApiImpl$getAuthAndDoRequest$1 liveLoginApiImpl$getAuthAndDoRequest$1;
        Object coroutine_suspended;
        int i3;
        String loginAuthAppId;
        String str3;
        Object authInfoAwait;
        LiveLoginApiImpl liveLoginApiImpl;
        String str4;
        boolean z17;
        AuthRequestRsp authRequestRsp;
        String str5;
        LiveLoginApiImpl liveLoginApiImpl2;
        QQLiveResponse<d> qQLiveResponse;
        if (continuation instanceof LiveLoginApiImpl$getAuthAndDoRequest$1) {
            liveLoginApiImpl$getAuthAndDoRequest$1 = (LiveLoginApiImpl$getAuthAndDoRequest$1) continuation;
            int i16 = liveLoginApiImpl$getAuthAndDoRequest$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                liveLoginApiImpl$getAuthAndDoRequest$1.label = i16 - Integer.MIN_VALUE;
                LiveLoginApiImpl$getAuthAndDoRequest$1 liveLoginApiImpl$getAuthAndDoRequest$12 = liveLoginApiImpl$getAuthAndDoRequest$1;
                Object obj = liveLoginApiImpl$getAuthAndDoRequest$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = liveLoginApiImpl$getAuthAndDoRequest$12.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        z17 = liveLoginApiImpl$getAuthAndDoRequest$12.Z$0;
                        AuthRequestRsp authRequestRsp2 = (AuthRequestRsp) liveLoginApiImpl$getAuthAndDoRequest$12.L$3;
                        String str6 = (String) liveLoginApiImpl$getAuthAndDoRequest$12.L$2;
                        String str7 = (String) liveLoginApiImpl$getAuthAndDoRequest$12.L$1;
                        LiveLoginApiImpl liveLoginApiImpl3 = (LiveLoginApiImpl) liveLoginApiImpl$getAuthAndDoRequest$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        str5 = str6;
                        authRequestRsp = authRequestRsp2;
                        liveLoginApiImpl2 = liveLoginApiImpl3;
                        str4 = str7;
                        qQLiveResponse = (QQLiveResponse) obj;
                        d rsp = qQLiveResponse.getRsp();
                        if (qQLiveResponse.isFailed() && rsp != null) {
                            a.Companion companion = rt0.a.INSTANCE;
                            companion.k(LOG_TAG, "login", "login success");
                            LiveLoginInfo assembleLoginInfo = liveLoginApiImpl2.assembleLoginInfo(str4, str5, authRequestRsp.getAuthInfo(), rsp);
                            liveLoginApiImpl2.saveLiveInfo(str4, assembleLoginInfo);
                            companion.k(LOG_TAG, "login", "save success");
                            if (companion.m()) {
                                companion.g(LOG_TAG, "login", "login success, " + assembleLoginInfo);
                            }
                            liveLoginApiImpl2.notifyResult(str4, new QQLiveResponse<>(qQLiveResponse.getRequest(), true, 0L, null, assembleLoginInfo));
                            return Unit.INSTANCE;
                        }
                        liveLoginApiImpl2.deleteLiveInfo(str4, str5);
                        if (ERROR_CODE_OPENID_EXPIRED != qQLiveResponse.getRetCode() && !z17) {
                            rt0.a.INSTANCE.h(LOG_TAG, "login", "openid expired, deleteLiveInfo and relogin");
                            liveLoginApiImpl$getAuthAndDoRequest$12.L$0 = null;
                            liveLoginApiImpl$getAuthAndDoRequest$12.L$1 = null;
                            liveLoginApiImpl$getAuthAndDoRequest$12.L$2 = null;
                            liveLoginApiImpl$getAuthAndDoRequest$12.L$3 = null;
                            liveLoginApiImpl$getAuthAndDoRequest$12.label = 3;
                            if (liveLoginApiImpl2.getAuthAndDoRequest(str4, null, str5, true, liveLoginApiImpl$getAuthAndDoRequest$12) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            liveLoginApiImpl2.handleLoginRspFail(qQLiveResponse, str4);
                        }
                        return Unit.INSTANCE;
                    }
                    z17 = liveLoginApiImpl$getAuthAndDoRequest$12.Z$0;
                    loginAuthAppId = (String) liveLoginApiImpl$getAuthAndDoRequest$12.L$3;
                    String str8 = (String) liveLoginApiImpl$getAuthAndDoRequest$12.L$2;
                    str4 = (String) liveLoginApiImpl$getAuthAndDoRequest$12.L$1;
                    liveLoginApiImpl = (LiveLoginApiImpl) liveLoginApiImpl$getAuthAndDoRequest$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    authInfoAwait = obj;
                    str3 = str8;
                } else {
                    ResultKt.throwOnFailure(obj);
                    loginAuthAppId = d32.a.INSTANCE.a(str).a().getLoginAuthAppId();
                    liveLoginApiImpl$getAuthAndDoRequest$12.L$0 = this;
                    liveLoginApiImpl$getAuthAndDoRequest$12.L$1 = str;
                    str3 = str2;
                    liveLoginApiImpl$getAuthAndDoRequest$12.L$2 = str3;
                    liveLoginApiImpl$getAuthAndDoRequest$12.L$3 = loginAuthAppId;
                    liveLoginApiImpl$getAuthAndDoRequest$12.Z$0 = z16;
                    liveLoginApiImpl$getAuthAndDoRequest$12.label = 1;
                    authInfoAwait = getAuthInfoAwait(loginAuthAppId, liveLoginInfo, liveLoginApiImpl$getAuthAndDoRequest$12);
                    if (authInfoAwait == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    liveLoginApiImpl = this;
                    str4 = str;
                    z17 = z16;
                }
                authRequestRsp = (AuthRequestRsp) authInfoAwait;
                if (authRequestRsp.getCode() != 0 && authRequestRsp.getAuthInfo() != null) {
                    a.Companion companion2 = rt0.a.INSTANCE;
                    companion2.k(LOG_TAG, "login", "auth success");
                    if (companion2.m()) {
                        companion2.g(LOG_TAG, "login", "auth success, " + authRequestRsp.getAuthInfo());
                    }
                    QQConnectAuthInfo authInfo = authRequestRsp.getAuthInfo();
                    liveLoginApiImpl$getAuthAndDoRequest$12.L$0 = liveLoginApiImpl;
                    liveLoginApiImpl$getAuthAndDoRequest$12.L$1 = str4;
                    liveLoginApiImpl$getAuthAndDoRequest$12.L$2 = str3;
                    liveLoginApiImpl$getAuthAndDoRequest$12.L$3 = authRequestRsp;
                    liveLoginApiImpl$getAuthAndDoRequest$12.Z$0 = z17;
                    liveLoginApiImpl$getAuthAndDoRequest$12.label = 2;
                    Object doLoginRequest = liveLoginApiImpl.doLoginRequest(str4, authInfo, liveLoginApiImpl$getAuthAndDoRequest$12);
                    if (doLoginRequest == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    LiveLoginApiImpl liveLoginApiImpl4 = liveLoginApiImpl;
                    str5 = str3;
                    obj = doLoginRequest;
                    liveLoginApiImpl2 = liveLoginApiImpl4;
                    qQLiveResponse = (QQLiveResponse) obj;
                    d rsp2 = qQLiveResponse.getRsp();
                    if (qQLiveResponse.isFailed()) {
                    }
                    liveLoginApiImpl2.deleteLiveInfo(str4, str5);
                    if (ERROR_CODE_OPENID_EXPIRED != qQLiveResponse.getRetCode()) {
                    }
                    liveLoginApiImpl2.handleLoginRspFail(qQLiveResponse, str4);
                    return Unit.INSTANCE;
                }
                liveLoginApiImpl.deleteLiveInfo(str4, str3);
                liveLoginApiImpl.handleGetAuthInfoFailed(authRequestRsp, loginAuthAppId);
                return Unit.INSTANCE;
            }
        }
        liveLoginApiImpl$getAuthAndDoRequest$1 = new LiveLoginApiImpl$getAuthAndDoRequest$1(this, continuation);
        LiveLoginApiImpl$getAuthAndDoRequest$1 liveLoginApiImpl$getAuthAndDoRequest$122 = liveLoginApiImpl$getAuthAndDoRequest$1;
        Object obj2 = liveLoginApiImpl$getAuthAndDoRequest$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = liveLoginApiImpl$getAuthAndDoRequest$122.label;
        if (i3 == 0) {
        }
        authRequestRsp = (AuthRequestRsp) authInfoAwait;
        if (authRequestRsp.getCode() != 0) {
        }
        liveLoginApiImpl.deleteLiveInfo(str4, str3);
        liveLoginApiImpl.handleGetAuthInfoFailed(authRequestRsp, loginAuthAppId);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object getAuthAndDoRequest$default(LiveLoginApiImpl liveLoginApiImpl, String str, LiveLoginInfo liveLoginInfo, String str2, boolean z16, Continuation continuation, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        return liveLoginApiImpl.getAuthAndDoRequest(str, liveLoginInfo, str2, z16, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getAuthInfoAwait(String str, LiveLoginInfo liveLoginInfo, Continuation<? super AuthRequestRsp> continuation) {
        Continuation intercepted;
        Object orThrow;
        Object coroutine_suspended;
        boolean z16;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        a.Companion companion = rt0.a.INSTANCE;
        companion.k(LOG_TAG, "getAuthInfoAwait", "getAuthInfoAwait, appid " + str + ", loginInfo " + liveLoginInfo);
        if (liveLoginInfo != null) {
            companion.k(LOG_TAG, "getAuthInfoAwait", "cached loginInfo not null");
            boolean z17 = true;
            if (liveLoginInfo.getOpenId().length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (liveLoginInfo.getAccessToken().length() <= 0) {
                    z17 = false;
                }
                if (z17 && liveLoginInfo.getOpenidExpireTime() != 0) {
                    QQConnectAuthInfo qQConnectAuthInfo = new QQConnectAuthInfo(liveLoginInfo.getOpenId(), liveLoginInfo.getAccessToken(), "", 0, liveLoginInfo.getOpenidExpireTime());
                    boolean d16 = qQConnectAuthInfo.d();
                    companion.k(LOG_TAG, "getAuthInfoAwait", "cached authInfoValid " + d16);
                    if (d16) {
                        Result.Companion companion2 = Result.INSTANCE;
                        safeContinuation.resumeWith(Result.m476constructorimpl(new AuthRequestRsp(0, null, qQConnectAuthInfo)));
                        orThrow = safeContinuation.getOrThrow();
                        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (orThrow == coroutine_suspended) {
                            DebugProbes.probeCoroutineSuspended(continuation);
                        }
                        return orThrow;
                    }
                }
            }
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity == null) {
            companion.h(LOG_TAG, "getAuthInfoAwait", "cannot get top activity");
            Result.Companion companion3 = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(new AuthRequestRsp(-10101, "cannot get top activity", null)));
        } else {
            ((IDoraemonService) QRoute.api(IDoraemonService.class)).prepare();
            DoraemonAPIManager createAPIManager = ((IDoraemonService) QRoute.api(IDoraemonService.class)).createAPIManager(qBaseActivity, 6, str);
            companion.k(LOG_TAG, "getAuthInfoAwait", "call doraemon loginSilent, qqConnectAppid " + str);
            createAPIManager.d("loginSilent", null, new com.tencent.mobileqq.Doraemon.a() { // from class: com.tencent.mobileqq.icgame.api.login.impl.LiveLoginApiImpl$getAuthInfoAwait$2$2
                @Override // com.tencent.mobileqq.Doraemon.a
                public void onComplete() {
                    rt0.a.INSTANCE.k("ICGameLogin|ICGameLiveLoginApiImpl", "getAuthInfoAwait", "onComplete");
                }

                @Override // com.tencent.mobileqq.Doraemon.a
                public void onFailure(int code, @Nullable String msg2) {
                    rt0.a.INSTANCE.h("ICGameLogin|ICGameLiveLoginApiImpl", "getAuthInfoAwait", "onFailure, code " + code + " , msg " + msg2);
                    Continuation<AuthRequestRsp> continuation2 = safeContinuation;
                    Result.Companion companion4 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m476constructorimpl(new AuthRequestRsp(code, msg2, null)));
                }

                @Override // com.tencent.mobileqq.Doraemon.a
                public void onPermission(int code) {
                    rt0.a.INSTANCE.h("ICGameLogin|ICGameLiveLoginApiImpl", "getAuthInfoAwait", "onPermission, code " + code);
                    Continuation<AuthRequestRsp> continuation2 = safeContinuation;
                    Result.Companion companion4 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m476constructorimpl(new AuthRequestRsp(code, "onPermission " + code, null)));
                }

                @Override // com.tencent.mobileqq.Doraemon.a
                public void onSuccess(@Nullable JSONObject result) {
                    if (result == null) {
                        rt0.a.INSTANCE.h("ICGameLogin|ICGameLiveLoginApiImpl", "getAuthInfoAwait", "onSuccess, but result empty");
                        Continuation<AuthRequestRsp> continuation2 = safeContinuation;
                        Result.Companion companion4 = Result.INSTANCE;
                        continuation2.resumeWith(Result.m476constructorimpl(new AuthRequestRsp(-10103, "onSuccess, but result empty", null)));
                        return;
                    }
                    try {
                        QQConnectAuthInfo qQConnectAuthInfo2 = (QQConnectAuthInfo) new Gson().fromJson(result.toString(), QQConnectAuthInfo.class);
                        rt0.a.INSTANCE.k("ICGameLogin|ICGameLiveLoginApiImpl", "getAuthInfoAwait", "onSuccess");
                        Continuation<AuthRequestRsp> continuation3 = safeContinuation;
                        Result.Companion companion5 = Result.INSTANCE;
                        continuation3.resumeWith(Result.m476constructorimpl(new AuthRequestRsp(0, null, qQConnectAuthInfo2)));
                    } catch (Exception e16) {
                        rt0.a.INSTANCE.i("ICGameLogin|ICGameLiveLoginApiImpl", "getAuthInfoAwait", "onSuccess, but parse info failed ", e16);
                        Continuation<AuthRequestRsp> continuation4 = safeContinuation;
                        Result.Companion companion6 = Result.INSTANCE;
                        continuation4.resumeWith(Result.m476constructorimpl(new AuthRequestRsp(-10102, "onSuccess, but parse info failed ", null)));
                    }
                }

                @Override // com.tencent.mobileqq.Doraemon.a
                public void onTrigger(@Nullable JSONObject result) {
                    rt0.a.INSTANCE.k("ICGameLogin|ICGameLiveLoginApiImpl", "getAuthInfoAwait", "onTrigger, result " + result);
                }
            });
        }
        orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final LiveLoginInfo getLiveInfoFromMmkv(String appId, String uin) {
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
                        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_ICGAME);
                        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_ICGAME)");
                        return (LiveLoginInfo) from.decodeParcelable(mmkvKey(appId, uin), LiveLoginInfo.class, null);
                    }
                }
            }
            z16 = true;
            if (!z16) {
            }
        }
        rt0.a.INSTANCE.i(LOG_TAG, "get", "invalid params, appId=" + appId + ", uin=" + uin, new RuntimeException());
        return null;
    }

    private final CoroutineScope getScope() {
        return (CoroutineScope) this.scope.getValue();
    }

    private final void handleGetAuthInfoFailed(AuthRequestRsp authRequestRsp, String qqConnectappId) {
        Map mapOf;
        String traceId;
        notifyResult(qqConnectappId, new QQLiveResponse<>(null, false, authRequestRsp.getCode(), authRequestRsp.getMsg(), null));
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("event_code", String.valueOf(authRequestRsp.getCode()));
        String msg2 = authRequestRsp.getMsg();
        String str = "";
        if (msg2 == null) {
            msg2 = "";
        }
        pairArr[1] = TuplesKt.to(AudienceReportConst.EVENT_MSG, msg2);
        QQLiveContext b16 = QQLiveContext.INSTANCE.b(qqConnectappId);
        if (b16 != null && (traceId = b16.getTraceId()) != null) {
            str = traceId;
        }
        pairArr[2] = TuplesKt.to("ext1", str);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        com.tencent.mobileqq.icgame.techreport.d.g("ev_icgame_login", mapOf);
    }

    private final void handleLoginRspFail(QQLiveResponse<d> loginResponse, String appId) {
        Map mapOf;
        String traceId;
        rt0.a.INSTANCE.h(LOG_TAG, "login", "login error, errCode=" + loginResponse.getRetCode() + ", errMsg=" + loginResponse.getErrMsg());
        notifyResult(appId, new QQLiveResponse<>(loginResponse.getRequest(), loginResponse.isSuccess(), loginResponse.getRetCode(), loginResponse.getErrMsg(), null));
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("event_code", String.valueOf(loginResponse.getRetCode()));
        String errMsg = loginResponse.getErrMsg();
        String str = "";
        if (errMsg == null) {
            errMsg = "";
        }
        pairArr[1] = TuplesKt.to(AudienceReportConst.EVENT_MSG, errMsg);
        QQLiveContext b16 = QQLiveContext.INSTANCE.b(appId);
        if (b16 != null && (traceId = b16.getTraceId()) != null) {
            str = traceId;
        }
        pairArr[2] = TuplesKt.to("ext1", str);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        com.tencent.mobileqq.icgame.techreport.d.g("ev_icgame_login", mapOf);
    }

    private final String mmkvKey(String appId, String uin) {
        return MMKV_KEY_LOGIN_PREFIX + appId + "_" + uin;
    }

    private final void notifyResult(String appId, QQLiveResponse<LiveLoginInfo> response) {
        List<Function1<QQLiveResponse<LiveLoginInfo>, Unit>> list = this.pendingLoginCallback.get(appId);
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(response);
            }
        }
        List<Function1<QQLiveResponse<LiveLoginInfo>, Unit>> list2 = this.pendingLoginCallback.get(appId);
        if (list2 != null) {
            list2.clear();
        }
        this.pendingLoginCallback.remove(appId);
    }

    private final void saveLiveInfo(String appId, LiveLoginInfo loginInfo) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_ICGAME);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_ICGAME)");
        from.encodeParcelable(mmkvKey(appId, loginInfo.getUin()), loginInfo);
    }

    @Override // com.tencent.mobileqq.icgame.api.login.ILiveLoginApi
    @Nullable
    public LiveLoginInfo getLoginInfo(@NotNull String appId, @Nullable String uin) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        LiveLoginInfo liveInfoFromMmkv = getLiveInfoFromMmkv(appId, uin);
        boolean z16 = false;
        if (liveInfoFromMmkv != null && liveInfoFromMmkv.u()) {
            z16 = true;
        }
        if (z16) {
            return liveInfoFromMmkv;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.icgame.api.login.ILiveLoginApi
    public void login(@NotNull String appId, @NotNull String uin, @Nullable Function1<? super QQLiveResponse<LiveLoginInfo>, Unit> callback) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(uin, "uin");
        BuildersKt__Builders_commonKt.launch$default(getScope(), null, null, new LiveLoginApiImpl$login$1(this, appId, uin, callback, null), 3, null);
    }

    @Override // com.tencent.mobileqq.icgame.api.login.ILiveLoginApi
    public boolean updateUserInfo(@NotNull String appId, @Nullable String uin, @Nullable LiveUserInfo userInfo) {
        boolean z16;
        LiveLoginInfo a16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(appId, "appId");
        if (uin != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(uin);
            if (!isBlank) {
                z16 = false;
                if (z16 && userInfo != null) {
                    LiveLoginInfo liveInfoFromMmkv = getLiveInfoFromMmkv(appId, uin);
                    if (liveInfoFromMmkv != null && liveInfoFromMmkv.getUid() == userInfo.uid) {
                        String headUrl = userInfo.headUrl;
                        String nick = userInfo.nick;
                        int i3 = userInfo.sex;
                        Intrinsics.checkNotNullExpressionValue(nick, "nick");
                        Intrinsics.checkNotNullExpressionValue(headUrl, "headUrl");
                        a16 = liveInfoFromMmkv.a((r35 & 1) != 0 ? liveInfoFromMmkv.appId : null, (r35 & 2) != 0 ? liveInfoFromMmkv.accessToken : null, (r35 & 4) != 0 ? liveInfoFromMmkv.openId : null, (r35 & 8) != 0 ? liveInfoFromMmkv.businessUid : null, (r35 & 16) != 0 ? liveInfoFromMmkv.tinyId : 0L, (r35 & 32) != 0 ? liveInfoFromMmkv.uin : null, (r35 & 64) != 0 ? liveInfoFromMmkv.uid : 0L, (r35 & 128) != 0 ? liveInfoFromMmkv.nickname : nick, (r35 & 256) != 0 ? liveInfoFromMmkv.avatarUrl : headUrl, (r35 & 512) != 0 ? liveInfoFromMmkv.sex : i3, (r35 & 1024) != 0 ? liveInfoFromMmkv.a2 : null, (r35 & 2048) != 0 ? liveInfoFromMmkv.a2ExpireTime : 0, (r35 & 4096) != 0 ? liveInfoFromMmkv.loginTime : 0L, (r35 & 8192) != 0 ? liveInfoFromMmkv.openidExpireTime : 0L);
                        saveLiveInfo(appId, a16);
                        a.Companion companion = rt0.a.INSTANCE;
                        if (companion.m()) {
                            companion.k(LOG_TAG, "updateUserInfo", "user info updated, " + a16);
                        } else {
                            companion.k(LOG_TAG, "updateUserInfo", "user info updated, uin=" + uin + ", nickname=" + a16.getNickname() + ", avatar=" + a16.getAvatarUrl());
                        }
                        return true;
                    }
                    rt0.a.INSTANCE.q(LOG_TAG, "updateUserInfo", "no login info found");
                    return false;
                }
                rt0.a.INSTANCE.q(LOG_TAG, "updateUserInfo", "invalid params, " + uin + ", " + userInfo);
                return false;
            }
        }
        z16 = true;
        if (z16) {
        }
        rt0.a.INSTANCE.q(LOG_TAG, "updateUserInfo", "invalid params, " + uin + ", " + userInfo);
        return false;
    }
}
