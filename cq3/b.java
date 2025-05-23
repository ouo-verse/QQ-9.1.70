package cq3;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.pskey.oidb.cmd0x102a.oidb_cmd0x102a$GetPSkeyRequest;
import com.tencent.mobileqq.pskey.oidb.cmd0x102a.oidb_cmd0x102a$GetPSkeyResponse;
import com.tencent.mobileqq.pskey.oidb.cmd0x102a.oidb_cmd0x102a$PSKey;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.thirdsig.api.IOpenSigInjectService;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.open.agent.util.g;
import com.tencent.open.agent.util.i;
import com.tencent.open.agent.util.t;
import com.tencent.open.model.AccountManage;
import com.tencent.qphone.base.BaseConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import mqq.observer.BusinessObserver;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;
import org.apache.httpcore.HttpHeaders;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J.\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J2\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J:\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J2\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J,\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0014H\u0002J \u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J6\u0010\u0018\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J>\u0010\u001b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0007\u001a\u00020\u0006R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcq3/b;", "", "", "uin", "domain", "thirdAppId", "Lcom/tencent/open/model/AccountManage$g;", "callback", "", "i", "", "forceRequest", h.F, "k", "", "appId", "j", "e", "l", DomainData.DOMAIN_NAME, "", "domainToKeys", "p", "g", "f", "", "connectData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "b", "[Ljava/lang/String;", "PSKEY_DOMAINS", "<init>", "()V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f391646a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String[] PSKEY_DOMAINS = {"openmobile.qq.com", "tim.qq.com"};

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"cq3/b$a", "Lcom/tencent/open/agent/util/i;", "", "ticket", "", "a", "", "errorCode", "", "errorMsg", "onFail", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f391648a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f391649b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f391650c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f391651d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AccountManage.g f391652e;

        a(String str, String str2, String str3, boolean z16, AccountManage.g gVar) {
            this.f391648a = str;
            this.f391649b = str2;
            this.f391650c = str3;
            this.f391651d = z16;
            this.f391652e = gVar;
        }

        @Override // com.tencent.open.agent.util.i
        public void a(@Nullable byte[] ticket) {
            b.f391646a.j(this.f391648a, this.f391649b, 16L, this.f391650c, this.f391651d, this.f391652e);
        }

        @Override // com.tencent.open.agent.util.i
        public void onFail(int errorCode, @Nullable String errorMsg) {
            b.f391646a.j(this.f391648a, this.f391649b, BaseConstants.OPEN_SDK_BUFLAG_B1, this.f391650c, this.f391651d, this.f391652e);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"cq3/b$b", "Lcom/tencent/open/agent/util/i;", "", "ticket", "", "a", "", "errorCode", "", "errorMsg", "onFail", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: cq3.b$b, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C10135b implements i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f391653a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f391654b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f391655c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AccountManage.g f391656d;

        C10135b(String str, String str2, String str3, AccountManage.g gVar) {
            this.f391653a = str;
            this.f391654b = str2;
            this.f391655c = str3;
            this.f391656d = gVar;
        }

        @Override // com.tencent.open.agent.util.i
        public void a(@NotNull byte[] ticket) {
            Intrinsics.checkNotNullParameter(ticket, "ticket");
            t.b("OpenSDKPskeyManager", "onSuccess has main ticket");
            b.f391646a.m(this.f391653a, 16L, this.f391654b, this.f391655c, null, this.f391656d);
        }

        @Override // com.tencent.open.agent.util.i
        public void onFail(int errorCode, @NotNull String errorMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            t.b("OpenSDKPskeyManager", "don't has main ticket");
            b.f391646a.m(this.f391653a, BaseConstants.OPEN_SDK_BUFLAG_B1, this.f391654b, this.f391655c, null, this.f391656d);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"cq3/b$c", "Lsd2/a;", "", "errMsg", "", "onFail", "", "domainToKeyMap", "onSuccess", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements sd2.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AccountManage.g f391657a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f391658b;

        c(AccountManage.g gVar, String str) {
            this.f391657a = gVar;
            this.f391658b = str;
        }

        @Override // sd2.a
        public void onFail(@NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            t.e("OpenSDKPskeyManager", "getPskeyForOpenSDK get from main account onFail :" + errMsg);
            this.f391657a.onFail(-1, errMsg);
        }

        @Override // sd2.a
        public void onSuccess(@NotNull Map<String, String> domainToKeyMap) {
            Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
            t.b("OpenSDKPskeyManager", "getPskeyForOpenSDKFromNT get from main account  onSuccess domain: " + this.f391658b);
            this.f391657a.onSuccess(domainToKeyMap.get(this.f391658b));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"cq3/b$d", "Lcom/tencent/mobileqq/thirdsig/api/a;", "", "retCode", "", "errMsg", "", "onFail", "onSuccess", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class d implements com.tencent.mobileqq.thirdsig.api.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f391659a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f391660b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f391661c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AccountManage.g f391662d;

        d(String str, String str2, String str3, AccountManage.g gVar) {
            this.f391659a = str;
            this.f391660b = str2;
            this.f391661c = str3;
            this.f391662d = gVar;
        }

        @Override // com.tencent.mobileqq.thirdsig.api.a
        public void onFail(int retCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            t.e("OpenSDKPskeyManager", "commitOpenTicketToMsf onFail retCode: " + retCode + " errMsg: " + errMsg);
            b.f391646a.i(this.f391659a, this.f391660b, this.f391661c, this.f391662d);
        }

        @Override // com.tencent.mobileqq.thirdsig.api.a
        public void onSuccess() {
            t.b("OpenSDKPskeyManager", "commitOpenTicketToMsf onSuccess request pskey domain: " + this.f391660b);
            b.f391646a.n(this.f391659a, this.f391660b, BaseConstants.OPEN_SDK_BUFLAG_B1, this.f391662d);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"cq3/b$e", "Loicq/wlogin_sdk/request/WtTicketPromise;", "Loicq/wlogin_sdk/request/Ticket;", "ticket", "", "Done", "Loicq/wlogin_sdk/tools/ErrMsg;", "errMsg", "Failed", HttpHeaders.TIMEOUT, "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class e implements WtTicketPromise {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AccountManage.g f391663a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f391664b;

        e(AccountManage.g gVar, String str) {
            this.f391663a = gVar;
            this.f391664b = str;
        }

        @Override // oicq.wlogin_sdk.request.WtTicketPromise
        public void Done(@NotNull Ticket ticket) {
            Intrinsics.checkNotNullParameter(ticket, "ticket");
            byte[] bArr = ticket._pskey_map.get(this.f391664b);
            if (bArr == null) {
                t.e("OpenSDKPskeyManager", "[getPskeyForOpen][async] Done, but bytes is null.");
                this.f391663a.onFail(-2, "bytes is null.");
            } else {
                t.f("OpenSDKPskeyManager", "[getPskeyForOpen][async] success");
                this.f391663a.onSuccess(new String(bArr, Charsets.UTF_8));
            }
        }

        @Override // oicq.wlogin_sdk.request.WtTicketPromise
        public void Failed(@NotNull ErrMsg errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            t.f("OpenSDKPskeyManager", "[getPskeyForOpen][async] Failed, errorType = " + errMsg.getType() + "errMsg = " + errMsg.getMessage());
            this.f391663a.onFail(-2, "getPskey from wtsdk failed.");
        }

        @Override // oicq.wlogin_sdk.request.WtTicketPromise
        public void Timeout(@NotNull ErrMsg errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            t.f("OpenSDKPskeyManager", "[getPskeyForOpen][async] time out, errorType = " + errMsg.getType() + "errMsg = " + errMsg.getMessage());
            this.f391663a.onFail(-2, "getPskey from wtsdk Timeout.");
        }
    }

    b() {
    }

    private final boolean e(String uin, long appId) {
        boolean z16;
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        long decodeLong = from.decodeLong("pskey_cache_key_time_" + uin + "_" + appId, 0L);
        if (decodeLong != 0 && System.currentTimeMillis() - decodeLong <= 86400000) {
            z16 = true;
        } else {
            z16 = false;
        }
        t.b("OpenSDKPskeyManager", "check pskey cache valid result: " + z16);
        return z16;
    }

    private final String g(String uin, long appId, String domain) {
        return "pskey_cache_key_" + uin + "_" + appId + "_" + domain;
    }

    private final void h(String uin, String domain, String thirdAppId, boolean forceRequest, AccountManage.g callback) {
        boolean contains;
        contains = ArraysKt___ArraysKt.contains(PSKEY_DOMAINS, domain);
        if (!contains) {
            t.e("OpenSDKPskeyManager", "getPskeyForOpenSDK domain not in white list domain: " + domain);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        if (Intrinsics.areEqual(uin, ((AppInterface) peekAppRuntime).getAccount())) {
            k(uin, domain, callback);
        } else {
            g.m(uin, true, new a(uin, domain, thirdAppId, forceRequest, callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(String uin, String domain, String thirdAppId, AccountManage.g callback) {
        if (TextUtils.equals(MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), uin)) {
            m(uin, 16L, domain, thirdAppId, null, callback);
        } else {
            g.m(uin, true, new C10135b(uin, domain, thirdAppId, callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(String uin, String domain, long appId, String thirdAppId, boolean forceRequest, AccountManage.g callback) {
        if (!forceRequest && e(uin, appId)) {
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            String decodeString = from.decodeString(g(uin, appId, domain), "");
            if (!TextUtils.isEmpty(decodeString)) {
                callback.onSuccess(decodeString);
                return;
            } else {
                t.e("OpenSDKPskeyManager", "getPskeyFromCache pskey is null");
                callback.onFail(-1, "");
                return;
            }
        }
        t.b("OpenSDKPskeyManager", "getPskeyFromCache pskey expired uin: " + uin + ", appid: " + appId);
        l(uin, domain, appId, thirdAppId, callback);
    }

    private final void k(String uin, String domain, AccountManage.g callback) {
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IPskeyManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.waitAppRuntime\u2026ssConstant.MAIN\n        )");
        ((IPskeyManager) runtimeService).getPskey(new String[]{domain}, new c(callback, domain));
    }

    private final void l(String uin, String domain, long appId, String thirdAppId, AccountManage.g callback) {
        if (appId != BaseConstants.OPEN_SDK_BUFLAG_B1) {
            n(uin, domain, 16L, callback);
        } else {
            ((IOpenSigInjectService) QRoute.api(IOpenSigInjectService.class)).commitOpenTicketToMsf(Long.parseLong(uin), new d(uin, domain, thirdAppId, callback));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(final String uin, final String domain, final long appId, final AccountManage.g callback) {
        List<String> mutableList;
        oidb_cmd0x102a$GetPSkeyRequest oidb_cmd0x102a_getpskeyrequest = new oidb_cmd0x102a$GetPSkeyRequest();
        PBRepeatField<String> pBRepeatField = oidb_cmd0x102a_getpskeyrequest.domains;
        mutableList = ArraysKt___ArraysKt.toMutableList(PSKEY_DOMAINS);
        pBRepeatField.set(mutableList);
        oidb_cmd0x102a_getpskeyrequest.flag.set(1);
        t.b("OpenSDKPskeyManager", "requestPskeyForOpenSDK domains: " + oidb_cmd0x102a_getpskeyrequest.domains.size());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        NewIntent newIntent = new NewIntent(peekAppRuntime.getApplicationContext(), kq3.a.class);
        newIntent.withouLogin = true;
        newIntent.putExtra("cmd", "OidbSvcTcp.0x102a");
        newIntent.putExtra("timeout", 30000);
        newIntent.putExtra("uin", uin);
        newIntent.putExtra("data", oidb_cmd0x102a_getpskeyrequest.toByteArray());
        if (appId == BaseConstants.OPEN_SDK_BUFLAG_B1) {
            newIntent.putExtra("use_open_sdk_ticket", true);
        }
        newIntent.setObserver(new BusinessObserver() { // from class: cq3.a
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i3, boolean z16, Bundle bundle) {
                b.o(AccountManage.g.this, domain, uin, appId, i3, z16, bundle);
            }
        });
        peekAppRuntime.startServlet(newIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(AccountManage.g callback, String domain, String uin, long j3, int i3, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(domain, "$domain");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        t.b("OpenSDKPskeyManager", "requestPskeyForOpenSDK result: " + z16);
        if (z16 && bundle != null) {
            byte[] byteArray = bundle.getByteArray("data");
            oidb_cmd0x102a$GetPSkeyResponse oidb_cmd0x102a_getpskeyresponse = new oidb_cmd0x102a$GetPSkeyResponse();
            try {
                oidb_cmd0x102a_getpskeyresponse.mergeFrom(byteArray);
                List<oidb_cmd0x102a$PSKey> list = oidb_cmd0x102a_getpskeyresponse.private_keys.get();
                if (list != null && !list.isEmpty()) {
                    t.b("OpenSDKPskeyManager", "requestPskeyForOpenSDK pskey size: " + list.size());
                    HashMap hashMap = new HashMap();
                    String str = null;
                    for (oidb_cmd0x102a$PSKey oidb_cmd0x102a_pskey : list) {
                        String domainInfo = oidb_cmd0x102a_pskey.domain.get();
                        String key = oidb_cmd0x102a_pskey.key.get();
                        if (!TextUtils.isEmpty(domain) && !TextUtils.isEmpty(key)) {
                            Intrinsics.checkNotNullExpressionValue(domainInfo, "domainInfo");
                            Intrinsics.checkNotNullExpressionValue(key, "key");
                            hashMap.put(domainInfo, key);
                            if (Intrinsics.areEqual(domainInfo, domain)) {
                                t.b("OpenSDKPskeyManager", "success callback pskey");
                                str = key;
                            }
                        }
                    }
                    f391646a.p(uin, j3, hashMap);
                    if (!TextUtils.isEmpty(str)) {
                        if (str != null) {
                            callback.onSuccess(str);
                            return;
                        }
                        return;
                    }
                    callback.onFail(-1, "request from net domain pskey is null!");
                    return;
                }
                callback.onFail(-1, "get pskey failed");
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                t.e("OpenSDKPskeyManager", e16);
                callback.onFail(-1, e16.toString());
                return;
            }
        }
        callback.onFail(-1, "requestPskeyForOpenSDK failed");
    }

    private final void p(String uin, long appId, Map<String, String> domainToKeys) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        from.encodeLong("pskey_cache_key_time_" + uin + "_" + appId, System.currentTimeMillis());
        for (Map.Entry<String, String> entry : domainToKeys.entrySet()) {
            String key = entry.getKey();
            from.encodeString(g(uin, appId, key), entry.getValue());
            t.b("OpenSDKPskeyManager", "updatePskeyFromCache domain: " + key);
        }
    }

    public final void f(@Nullable String uin, @Nullable String domain, @Nullable String thirdAppId, boolean forceRequest, @Nullable AccountManage.g callback) {
        if (callback == null) {
            return;
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            callback.onFail(-1, "AppRuntime is null.");
            return;
        }
        if (!TextUtils.isEmpty(uin) && !TextUtils.isEmpty(domain)) {
            if (g.G("OidbSvcTcp.0x102a")) {
                t.b("OpenSDKPskeyManager", "getPsKeyAsync by new sso road domain: " + domain);
                Intrinsics.checkNotNull(uin);
                Intrinsics.checkNotNull(domain);
                h(uin, domain, thirdAppId, forceRequest, callback);
                return;
            }
            i(uin, domain, thirdAppId, callback);
            return;
        }
        callback.onFail(-1, "uin or domain is null.");
    }

    public final void m(@Nullable String uin, long appId, @Nullable String domain, @Nullable String thirdAppId, @Nullable byte[] connectData, @NotNull AccountManage.g callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        t.f("OpenSDKPskeyManager", "[getPskeyForOpen] start.");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            callback.onFail(-1, "AppRuntime is null.");
            return;
        }
        Manager manager = peekAppRuntime.getManager(2);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type mqq.manager.TicketManager");
        Ticket pskeyForOpen = ((TicketManager) manager).getPskeyForOpen(uin, appId, new String[]{domain}, g.v(thirdAppId), new e(callback, domain));
        if (pskeyForOpen != null) {
            byte[] bArr = pskeyForOpen._pskey_map.get(domain);
            if (bArr == null) {
                t.f("OpenSDKPskeyManager", "[getPskeyForOpen][sync] failed: bytes is null.");
                callback.onFail(-2, "bytes is null.");
            } else {
                t.f("OpenSDKPskeyManager", "[getPskeyForOpen][sync] success.");
                callback.onSuccess(new String(bArr, Charsets.UTF_8));
            }
        }
    }
}
