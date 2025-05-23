package com.tencent.aegiskmm;

import com.tencent.aegiskmm.bean.AegisBean;
import com.tencent.aegiskmm.bean.AegisConfig;
import com.tencent.aegiskmm.bean.AegisLogLevel;
import com.tencent.aegiskmm.bean.AegisLogType;
import com.tencent.aegiskmm.bean.DataItem;
import com.tencent.aegiskmm.bean.NormalLog;
import com.tencent.aegiskmm.bean.RequestPayLoad;
import com.tencent.aegiskmm.utils.Throttle;
import com.tencent.kuikly.core.exception.PagerNotFoundException;
import com.tencent.kuikly.core.module.NetworkModule;
import com.tencent.kuikly.core.module.NetworkResponse;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bD\u0010EJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J.\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u001b\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eJ/\u0010\"\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\fH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010#R\u0017\u0010(\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010.\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\u0014\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010/\u001a\u0004\b0\u00101R\"\u00104\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0016\u0010:\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u00109R$\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u000f0;j\b\u0012\u0004\u0012\u00020\u000f`<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R \u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020A0@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010B\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006F"}, d2 = {"Lcom/tencent/aegiskmm/CoreApiImpl;", "Lcom/tencent/aegiskmm/bean/c;", "Lcom/tencent/aegiskmm/bean/f;", "log", "", "k", "", "args", "Lcom/tencent/aegiskmm/bean/AegisLogLevel;", "level", "Lcom/tencent/aegiskmm/bean/AegisLogType;", "type", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "extInfo", "e", "Lcom/tencent/aegiskmm/bean/d;", "g", "msg", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aegiskmm/bean/b;", DownloadInfo.spKey_Config, "d", "i", "stackTrace", "c", "a", DomainData.DOMAIN_NAME, "Lcom/tencent/aegiskmm/bean/i;", "payload", "j", "(Lcom/tencent/aegiskmm/bean/i;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "url", "param", "headers", "l", "(Ljava/lang/String;Lcom/tencent/kuikly/core/nvi/serialization/json/e;Lcom/tencent/kuikly/core/nvi/serialization/json/e;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/aegiskmm/f;", "Lcom/tencent/aegiskmm/f;", "getPlatform", "()Lcom/tencent/aegiskmm/f;", "platform", "Lcom/tencent/aegiskmm/bean/a;", "b", "Lcom/tencent/aegiskmm/bean/a;", "getBean", "()Lcom/tencent/aegiskmm/bean/a;", "bean", "Lcom/tencent/aegiskmm/bean/b;", h.F, "()Lcom/tencent/aegiskmm/bean/b;", "", "Z", "isInit", "()Z", "setInit", "(Z)V", "Lcom/tencent/aegiskmm/RemoteConfigManager;", "Lcom/tencent/aegiskmm/RemoteConfigManager;", "remoteConfigManager", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "dataItemQueue", "", "", "Ljava/util/Map;", "timeMap", "<init>", "()V", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes37.dex */
public final class CoreApiImpl implements com.tencent.aegiskmm.bean.c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isInit;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RemoteConfigManager remoteConfigManager;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final f platform = g.a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AegisBean bean = new AegisBean(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final AegisConfig config = new AegisConfig(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0.0f, 0, false, null, false, null, null, null, null, null, null, null, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK, null);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<DataItem> dataItemQueue = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Map<String, Long> timeMap = new LinkedHashMap();

    private final void d(AegisConfig config) {
        String str;
        this.bean.f("session-" + this.platform.a());
        try {
            com.tencent.kuikly.core.pager.g pageData = com.tencent.kuikly.core.manager.c.f117352a.g().getPageData();
            a.f61726d.b().d("KA", "extendBean pageData " + pageData.n() + '}');
            AegisBean aegisBean = this.bean;
            if (pageData.u()) {
                str = "test";
            } else {
                str = "production";
            }
            aegisBean.d(str);
            this.bean.e(pageData.getPlatform());
            AegisBean aegisBean2 = this.bean;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(pageData.h());
            sb5.append('*');
            sb5.append(pageData.g());
            aegisBean2.g(sb5.toString());
            AegisBean aegisBean3 = this.bean;
            StringBuilder sb6 = new StringBuilder();
            sb6.append(pageData.m());
            sb6.append('*');
            sb6.append(pageData.l());
            aegisBean3.i(sb6.toString());
        } catch (PagerNotFoundException unused) {
        }
    }

    private final NormalLog e(String args, AegisLogLevel level, AegisLogType type, com.tencent.kuikly.core.nvi.serialization.json.e extInfo) {
        return new NormalLog(args, level, type, extInfo);
    }

    private final DataItem g(NormalLog log) {
        AegisBean aegisBean = this.bean;
        String name = log.getType().name();
        if (name != null) {
            String lowerCase = name.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            aegisBean.h(lowerCase);
            return new DataItem(this.platform.a(), log.e(), this.bean.k());
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    private final void k(NormalLog log) {
        a aVar = a.f61726d;
        aVar.b().d("KA", "send log:" + g(log));
        if (!(log.getLevel() == AegisLogLevel.ERROR || log.getLevel() == AegisLogLevel.NATIVE_ENGINE_ERROR)) {
            switch (c.f61787a[log.getType().ordinal()]) {
                case 1:
                    RemoteConfigManager remoteConfigManager = this.remoteConfigManager;
                    if (remoteConfigManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("remoteConfigManager");
                    }
                    if (!remoteConfigManager.getLogSwitch()) {
                        aVar.b().d("KA", "send log return for logSwitch off");
                        return;
                    }
                    break;
                case 2:
                    RemoteConfigManager remoteConfigManager2 = this.remoteConfigManager;
                    if (remoteConfigManager2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("remoteConfigManager");
                    }
                    if (!remoteConfigManager2.getPvSwitch()) {
                        aVar.b().d("KA", "send log return for pvSwitch off");
                        return;
                    }
                    break;
                case 3:
                    RemoteConfigManager remoteConfigManager3 = this.remoteConfigManager;
                    if (remoteConfigManager3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("remoteConfigManager");
                    }
                    if (!remoteConfigManager3.getApiStaticSwitch()) {
                        aVar.b().d("KA", "send log return for apiStaticSwitch off");
                        return;
                    }
                    break;
                case 4:
                    RemoteConfigManager remoteConfigManager4 = this.remoteConfigManager;
                    if (remoteConfigManager4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("remoteConfigManager");
                    }
                    if (!remoteConfigManager4.getLogSwitch()) {
                        aVar.b().d("KA", "send log return for logSwitch off");
                        return;
                    }
                    break;
                case 5:
                    RemoteConfigManager remoteConfigManager5 = this.remoteConfigManager;
                    if (remoteConfigManager5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("remoteConfigManager");
                    }
                    if (!remoteConfigManager5.getCustomSpeedTestSwitch()) {
                        aVar.b().d("KA", "send log return for customSpeedTestSwitch off");
                        return;
                    }
                    break;
                case 6:
                    RemoteConfigManager remoteConfigManager6 = this.remoteConfigManager;
                    if (remoteConfigManager6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("remoteConfigManager");
                    }
                    if (!remoteConfigManager6.getCustomEventSwitch()) {
                        aVar.b().d("KA", "send log return for customEventSwitch off");
                        return;
                    }
                    break;
                case 7:
                    RemoteConfigManager remoteConfigManager7 = this.remoteConfigManager;
                    if (remoteConfigManager7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("remoteConfigManager");
                    }
                    if (!remoteConfigManager7.getPerformanceSwitch()) {
                        aVar.b().d("KA", "send log return for performanceSwitch off");
                        return;
                    }
                    break;
                case 8:
                    aVar.b().d("KA", "send log return for API_SPEED");
                    return;
                case 9:
                    aVar.b().d("KA", "send log return for ASSETS_SPEED");
                    return;
                case 10:
                    aVar.b().d("KA", "send log return for WEB_VITALS");
                    return;
            }
        }
        this.dataItemQueue.add(g(log));
        Throttle.f61800b.c(this.config.getDelay(), com.tencent.kuikly.core.coroutines.e.f117232d, new CoreApiImpl$send$1(this, null)).invoke();
    }

    @Override // com.tencent.aegiskmm.bean.c
    public void a(NormalLog log) {
        Intrinsics.checkNotNullParameter(log, "log");
        if (!this.isInit) {
            a.f61726d.b().e("KA", "\u8bf7\u5148\u8c03\u7528init\u65b9\u6cd5");
        } else {
            k(log);
        }
    }

    public void c(String msg2, String stackTrace) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(stackTrace, "stackTrace");
        if (!this.isInit) {
            a.f61726d.b().e("KA", "\u8bf7\u5148\u8c03\u7528init\u65b9\u6cd5");
            return;
        }
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("stack", stackTrace);
        k(e(msg2, AegisLogLevel.ERROR, AegisLogType.NORMAL, eVar));
    }

    /* renamed from: h, reason: from getter */
    public final AegisConfig getConfig() {
        return this.config;
    }

    public final void i(AegisConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.isInit = true;
        n(config);
        String dId = config.getDId();
        if (dId.length() == 0) {
            dId = config.getAId();
        }
        this.remoteConfigManager = new RemoteConfigManager(config.getUid(), config.getAppId(), config.getAppKey(), dId, config.getReportToTestServer());
        try {
            for (com.tencent.aegiskmm.bean.g gVar : this.config.t()) {
                gVar.d(this);
                gVar.a();
                if (this.config.getReportImmediately()) {
                    gVar.b();
                }
            }
        } catch (Error e16) {
            m(e16.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object j(RequestPayLoad requestPayLoad, Continuation<? super Unit> continuation) {
        String str;
        Object coroutine_suspended;
        if (Intrinsics.areEqual(this.bean.getId(), "")) {
            a.f61726d.b().e("KA", "\u53c2\u6570\u9519\u8bef\u6216\u8005\u6ca1\u6709\u9879\u76eeID");
            return Unit.INSTANCE;
        }
        if (this.config.getReportToTestServer()) {
            str = "https://t.rmonitor.qq.com/collect/aegisV2";
        } else {
            str = "https://rmonitor.qq.com/collect/aegisV2";
        }
        com.tencent.kuikly.core.nvi.serialization.json.e b16 = requestPayLoad.b();
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("Content-Type", "application/json");
        Unit unit = Unit.INSTANCE;
        Object l3 = l(str, b16, eVar, continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return l3 == coroutine_suspended ? l3 : Unit.INSTANCE;
    }

    public void n(AegisConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (!this.isInit) {
            a.f61726d.b().e("KA", "\u8bf7\u5148\u8c03\u7528init\u65b9\u6cd5");
            return;
        }
        this.config.b(config);
        d(config);
        this.bean.b(config);
    }

    final /* synthetic */ Object l(final String str, final com.tencent.kuikly.core.nvi.serialization.json.e eVar, final com.tencent.kuikly.core.nvi.serialization.json.e eVar2, Continuation<? super com.tencent.kuikly.core.nvi.serialization.json.e> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        try {
            NetworkModule.f((NetworkModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNetworkModule"), str, true, eVar, eVar2, eVar2 != null ? eVar2.p("Cookie") : null, 0, new Function4<com.tencent.kuikly.core.nvi.serialization.json.e, Boolean, String, NetworkResponse, Unit>() { // from class: com.tencent.aegiskmm.CoreApiImpl$sendHttpRequest$$inlined$suspendCoroutine$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar3, Boolean bool, String str2, NetworkResponse networkResponse) {
                    invoke(eVar3, bool.booleanValue(), str2, networkResponse);
                    return Unit.INSTANCE;
                }

                public final void invoke(com.tencent.kuikly.core.nvi.serialization.json.e data, boolean z16, String errorMsg, NetworkResponse response) {
                    Intrinsics.checkNotNullParameter(data, "data");
                    Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                    Intrinsics.checkNotNullParameter(response, "response");
                    a aVar = a.f61726d;
                    aVar.b().d("KA", "Aegis Report finish! url:" + str + ",param:" + eVar + " success:" + z16 + ",data:" + data + ",error:" + errorMsg + ",code:" + response);
                    if (z16) {
                        Continuation.this.resumeWith(Result.m476constructorimpl(data));
                        return;
                    }
                    Continuation continuation2 = Continuation.this;
                    com.tencent.kuikly.core.nvi.serialization.json.e eVar3 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                    eVar3.v("error", "Aegis \u8bf7\u6c42\u9519\u8bef:" + errorMsg);
                    continuation2.resumeWith(Result.m476constructorimpl(eVar3));
                    aVar.b().e("KA", "Aegis \u8bf7\u6c42\u9519\u8bef:" + errorMsg);
                }
            }, 32, null);
        } catch (Error e16) {
            com.tencent.kuikly.core.nvi.serialization.json.e eVar3 = new com.tencent.kuikly.core.nvi.serialization.json.e();
            eVar3.v("error", "Aegis \u8bf7\u6c42\u9519\u8bef:" + e16.getMessage());
            safeContinuation.resumeWith(Result.m476constructorimpl(eVar3));
            a.f61726d.b().e("KA", "\"Aegis \u8bf7\u6c42\u9519\u8bef\uff1a" + e16.getMessage() + '\"');
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final void m(String msg2) {
        if (msg2 == null) {
            msg2 = "";
        }
        k(f(this, msg2, AegisLogLevel.SDK_ERROR, null, null, 12, null));
    }

    static /* synthetic */ NormalLog f(CoreApiImpl coreApiImpl, String str, AegisLogLevel aegisLogLevel, AegisLogType aegisLogType, com.tencent.kuikly.core.nvi.serialization.json.e eVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            aegisLogLevel = AegisLogLevel.INFO;
        }
        if ((i3 & 4) != 0) {
            aegisLogType = AegisLogType.NORMAL;
        }
        if ((i3 & 8) != 0) {
            eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        }
        return coreApiImpl.e(str, aegisLogLevel, aegisLogType, eVar);
    }
}
