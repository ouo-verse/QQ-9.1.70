package com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.internal_middlewares.storage;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.QQComposeViewExtCreator$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.RequestConfig;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Response;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.Custom;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.Middleware;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.internal_middlewares.storage.RequestStorage;
import com.tencent.hippykotlin.demo.pages.vas_base.vlog.VLog;
import com.tencent.hippykotlin.demo.pages.vas_base.vlog.VLogKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.pager.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import oicq.wlogin_sdk.tools.util;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class StorageMiddleware extends Middleware implements c {
    public final Function1<RequestConfig, String> keyGenerator;
    public final KClass<StorageCustom> custom = Reflection.getOrCreateKotlinClass(StorageCustom.class);
    public final RequestStorage storage = new RequestStorage();
    public final List<Function0<Unit>> actions = new ArrayList();
    public boolean isFirstExec = true;

    /* JADX WARN: Multi-variable type inference failed */
    public StorageMiddleware(Function1<? super RequestConfig, String> function1) {
        this.keyGenerator = function1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0209, code lost:
    
        if (r10 >= r12) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02cf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /* JADX WARN: Type inference failed for: r6v33, types: [java.util.List<kotlin.jvm.functions.Function0<kotlin.Unit>>, java.util.ArrayList] */
    @Override // com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.Middleware
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object execute(RequestConfig requestConfig, Custom custom, Function2<? super RequestConfig, ? super Continuation<? super Response>, ? extends Object> function2, Continuation<? super Response> continuation) {
        StorageMiddleware$execute$1 storageMiddleware$execute$1;
        Object coroutine_suspended;
        int i3;
        Object obj;
        final String str;
        Function1<Response, Boolean> function1;
        boolean z16;
        int i16;
        boolean z17;
        StorageMiddleware storageMiddleware;
        final Custom custom2;
        Function1<Response, Boolean> function12;
        boolean z18;
        Object obj2;
        final StorageMiddleware storageMiddleware2;
        int i17;
        boolean z19;
        e eVar;
        long resVersion;
        boolean z26;
        if (continuation instanceof StorageMiddleware$execute$1) {
            storageMiddleware$execute$1 = (StorageMiddleware$execute$1) continuation;
            int i18 = storageMiddleware$execute$1.label;
            if ((i18 & Integer.MIN_VALUE) != 0) {
                storageMiddleware$execute$1.label = i18 - Integer.MIN_VALUE;
                Object obj3 = storageMiddleware$execute$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = storageMiddleware$execute$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj3);
                    }
                    if (i3 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i17 = storageMiddleware$execute$1.I$0;
                    boolean z27 = storageMiddleware$execute$1.Z$0;
                    str = storageMiddleware$execute$1.L$3;
                    Function1<Response, Boolean> function13 = storageMiddleware$execute$1.L$2;
                    Custom custom3 = storageMiddleware$execute$1.L$1;
                    storageMiddleware2 = storageMiddleware$execute$1.L$0;
                    ResultKt.throwOnFailure(obj3);
                    z18 = z27;
                    custom2 = custom3;
                    function12 = function13;
                    z17 = true;
                    Response response = (Response) obj3;
                    if (i17 != 0) {
                        if (function12 != null) {
                            z26 = function12.invoke(response).booleanValue();
                        } else if (response.status == 200) {
                            z26 = false;
                            if (response.data.k("code", 0) == 0) {
                                z26 = z17;
                            }
                        } else {
                            z26 = false;
                        }
                        if (z26) {
                            final e eVar2 = new e(response.data.toString());
                            if (z18) {
                                Function1<e, Unit> function14 = ((StorageCustom) custom2).beforeSetStorage;
                                if (function14 != null) {
                                    function14.invoke(eVar2);
                                }
                                storageMiddleware2.storage.set(str, eVar2);
                            } else {
                                storageMiddleware2.actions.add(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.internal_middlewares.storage.StorageMiddleware$execute$2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        Function1<e, Unit> function15 = ((StorageCustom) Custom.this).beforeSetStorage;
                                        if (function15 != null) {
                                            function15.invoke(eVar2);
                                        }
                                        storageMiddleware2.storage.set(str, eVar2);
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                        }
                    }
                    return response;
                }
                ResultKt.throwOnFailure(obj3);
                if (this.isFirstExec) {
                    com.tencent.kuikly.core.manager.c.f117352a.g().addPagerEventObserver(this);
                    this.isFirstExec = false;
                }
                if (!(custom instanceof StorageCustom)) {
                    storageMiddleware$execute$1.label = 1;
                    obj3 = function2.invoke(requestConfig, storageMiddleware$execute$1);
                    return obj3 == coroutine_suspended ? coroutine_suspended : obj3;
                }
                StorageCustom storageCustom = (StorageCustom) custom;
                Function1<e, Unit> function15 = storageCustom.onGetStorage;
                Function1<Response, Boolean> function16 = storageCustom.isSuccess;
                Long l3 = storageCustom.minVersion;
                Long l16 = storageCustom.validPeriod;
                boolean z28 = storageCustom.isUpdateImmediately;
                Function0<Unit> function0 = storageCustom.onStorageNull;
                int i19 = function15 != null ? 1 : 0;
                Function1<RequestConfig, String> function17 = this.keyGenerator;
                String invoke = function17 != null ? function17.invoke(requestConfig) : null;
                if (invoke == null) {
                    RequestStorage.Companion companion = RequestStorage.Companion;
                    String str2 = requestConfig.baseURL;
                    String str3 = requestConfig.url;
                    if (str2.length() > 0) {
                        obj = coroutine_suspended;
                        if (!new Regex("^([a-z][a-z\\d+\\-.]*:)?//", RegexOption.IGNORE_CASE).containsMatchIn(str3)) {
                            if (str3.length() > 0) {
                                str2 = new Regex("/?/$").replace(str2, "") + '/' + new Regex("^/+").replace(str3, "");
                            }
                            str = RequestStorage.keyPrefix$delegate.getValue() + util.base64_pad_url + str2.hashCode() + util.base64_pad_url + requestConfig.method.ordinal();
                        }
                    } else {
                        obj = coroutine_suspended;
                    }
                    str2 = str3;
                    str = RequestStorage.keyPrefix$delegate.getValue() + util.base64_pad_url + str2.hashCode() + util.base64_pad_url + requestConfig.method.ordinal();
                } else {
                    obj = coroutine_suspended;
                    RequestStorage.Companion companion2 = RequestStorage.Companion;
                    str = RequestStorage.keyPrefix$delegate.getValue() + util.base64_pad_url + invoke;
                }
                VLogKt.getClog(this).log$enumunboxing$("key is " + str, 1, true);
                if (i19 != 0) {
                    RequestStorage requestStorage = this.storage;
                    e object = ((CacheModule) requestStorage.cacheModule$delegate.getValue()).getObject(str);
                    if (object == null) {
                        eVar = null;
                        RequestStorage.log.log$enumunboxing$(QQComposeViewExtCreator$$ExternalSyntheticOutline0.m("key: ", str, ", code 1"), 1, true);
                        function1 = function16;
                        z16 = z28;
                        i16 = i19;
                    } else {
                        z16 = z28;
                        i16 = i19;
                        e m3 = object.m(PublicAccountMessageUtilImpl.META_NAME);
                        VLog vLog = RequestStorage.log;
                        StringBuilder sb5 = new StringBuilder();
                        function1 = function16;
                        sb5.append("meta ");
                        sb5.append(m3);
                        vLog.log$enumunboxing$(sb5.toString(), 1, true);
                        if (requestStorage.isExpired(m3, l16)) {
                            vLog.log$enumunboxing$(QQComposeViewExtCreator$$ExternalSyntheticOutline0.m("key: ", str, ", code 2"), 1, true);
                        } else {
                            long n3 = m3 != null ? m3.n("res_version") : 0L;
                            if (!Intrinsics.areEqual("production", "development")) {
                                com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                                if (n3 <= PageDataExtKt.getResVersion(cVar.g().getPageData())) {
                                    if (l3 != null) {
                                        resVersion = l3.longValue();
                                    } else {
                                        resVersion = PageDataExtKt.getResVersion(cVar.g().getPageData());
                                    }
                                }
                                z19 = false;
                                if (z19) {
                                    vLog.log$enumunboxing$(QQComposeViewExtCreator$$ExternalSyntheticOutline0.m("key: ", str, ", code 3"), 1, true);
                                } else {
                                    e m16 = object.m("data");
                                    vLog.log$enumunboxing$(QQComposeViewExtCreator$$ExternalSyntheticOutline0.m("key: ", str, ", code 0"), 1, true);
                                    vLog.log$enumunboxing$("get " + str + ", data " + m16, 1, true);
                                    eVar = m16;
                                }
                            }
                            z19 = true;
                            if (z19) {
                            }
                        }
                        eVar = null;
                    }
                    if (eVar != null) {
                        if (function15 != null) {
                            try {
                                function15.invoke(eVar);
                            } catch (Exception e16) {
                                VLog clog = VLogKt.getClog(this);
                                StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("storage-middle callback ");
                                m17.append(requestConfig.url);
                                m17.append(TokenParser.SP);
                                m17.append(e16);
                                z17 = true;
                                clog.log$enumunboxing$(m17.toString(), 3, true);
                            }
                        }
                    } else if (function0 != null) {
                        try {
                            function0.invoke();
                        } catch (Exception e17) {
                            VLog clog2 = VLogKt.getClog(this);
                            StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("storage-middle storageNullCallback ");
                            m18.append(requestConfig.url);
                            m18.append(TokenParser.SP);
                            m18.append(e17);
                            z17 = true;
                            clog2.log$enumunboxing$(m18.toString(), 3, true);
                        }
                    }
                    storageMiddleware = this;
                    z17 = true;
                    storageMiddleware$execute$1.L$0 = storageMiddleware;
                    custom2 = custom;
                    storageMiddleware$execute$1.L$1 = custom2;
                    function12 = function1;
                    storageMiddleware$execute$1.L$2 = function12;
                    storageMiddleware$execute$1.L$3 = str;
                    z18 = z16;
                    storageMiddleware$execute$1.Z$0 = z18;
                    int i26 = i16;
                    storageMiddleware$execute$1.I$0 = i26;
                    storageMiddleware$execute$1.label = 2;
                    obj3 = function2.invoke(requestConfig, storageMiddleware$execute$1);
                    obj2 = obj;
                    if (obj3 != obj2) {
                        return obj2;
                    }
                    storageMiddleware2 = storageMiddleware;
                    i17 = i26;
                    Response response2 = (Response) obj3;
                    if (i17 != 0) {
                    }
                    return response2;
                }
                function1 = function16;
                z16 = z28;
                i16 = i19;
                z17 = true;
                storageMiddleware = this;
                storageMiddleware$execute$1.L$0 = storageMiddleware;
                custom2 = custom;
                storageMiddleware$execute$1.L$1 = custom2;
                function12 = function1;
                storageMiddleware$execute$1.L$2 = function12;
                storageMiddleware$execute$1.L$3 = str;
                z18 = z16;
                storageMiddleware$execute$1.Z$0 = z18;
                int i262 = i16;
                storageMiddleware$execute$1.I$0 = i262;
                storageMiddleware$execute$1.label = 2;
                obj3 = function2.invoke(requestConfig, storageMiddleware$execute$1);
                obj2 = obj;
                if (obj3 != obj2) {
                }
            }
        }
        storageMiddleware$execute$1 = new StorageMiddleware$execute$1(this, continuation);
        Object obj32 = storageMiddleware$execute$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = storageMiddleware$execute$1.label;
        if (i3 == 0) {
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.vas_base.krequest.middleware.Middleware
    public final KClass<StorageCustom> getCustom() {
        return this.custom;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.List<kotlin.jvm.functions.Function0<kotlin.Unit>>, java.util.ArrayList] */
    @Override // com.tencent.kuikly.core.pager.c
    public final void onPagerEvent(String str, e eVar) {
        if (Intrinsics.areEqual(str, Pager.PAGER_EVENT_WILL_DESTROY)) {
            Iterator it = this.actions.iterator();
            while (it.hasNext()) {
                ((Function0) it.next()).invoke();
            }
        }
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onRootViewSizeChanged(double d16, double d17) {
        c.a.a(this, d16, d17);
    }
}
