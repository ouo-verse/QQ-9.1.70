package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDataCardApi;
import com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u000e\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002JI\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/p;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "c", "i", "g", "l", "Lcom/tencent/common/app/AppInterface;", "d", "method", "call", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class p extends i01.e {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/p$b", "Lcom/tencent/biz/pubaccount/api/IPublicAccountObserver$c;", "", "isSuccess", "", "uin", "", "onFollowPublicAccount", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends IPublicAccountObserver.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f263023a;

        b(Function1<Object, Unit> function1) {
            this.f263023a = function1;
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onFollowPublicAccount(boolean isSuccess, String uin) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            if (QLog.isColorLevel()) {
                QLog.i("QQKuiklyPublicAccountModule", 1, "onFollowPublicAccount isSuccess = " + isSuccess);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret", !isSuccess ? 1 : 0);
            Function1<Object, Unit> function1 = this.f263023a;
            if (function1 != null) {
                function1.invoke(jSONObject);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/p$c", "Lcom/tencent/biz/pubaccount/api/IPublicAccountObserver$c;", "", "isSuccess", "", "uin", "", "onUnfollowPublicAccount", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends IPublicAccountObserver.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f263024a;

        c(Function1<Object, Unit> function1) {
            this.f263024a = function1;
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountObserver.c
        public void onUnfollowPublicAccount(boolean isSuccess, String uin) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            if (QLog.isColorLevel()) {
                QLog.i("QQKuiklyPublicAccountModule", 1, "onUnfollowPublicAccount isSuccess = " + isSuccess);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ret", !isSuccess ? 1 : 0);
            Function1<Object, Unit> function1 = this.f263024a;
            if (function1 != null) {
                function1.invoke(jSONObject);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/kuikly/export/modules/p$d", "Lcom/tencent/biz/pubaccount/api/IPublicAccountCommonMrg$a;", "", QzoneIPCModule.RESULT_CODE, "", "isTop", "", "b", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d extends IPublicAccountCommonMrg.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f263025b;

        d(Function1<Object, Unit> function1) {
            this.f263025b = function1;
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg.a
        public void b(int resultCode, boolean isTop) {
            String str;
            JSONObject jSONObject = new JSONObject();
            if (isTop) {
                str = "1";
            } else {
                str = "0";
            }
            jSONObject.put("retCode", str);
            Function1<Object, Unit> function1 = this.f263025b;
            if (function1 != null) {
                function1.invoke(jSONObject);
            }
        }
    }

    private final void c(String params, Function1<Object, Unit> callback) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(params)) {
            return;
        }
        if (params != null) {
            try {
                jSONObject = new JSONObject(params);
            } catch (Throwable th5) {
                QLog.e("QQKuiklyPublicAccountModule", 1, "followAnchor error:", th5);
                return;
            }
        } else {
            jSONObject = null;
        }
        String optString = jSONObject != null ? jSONObject.optString(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_P_UIN) : null;
        Integer valueOf = jSONObject != null ? Integer.valueOf(jSONObject.optInt("type")) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            QRouteApi api = QRoute.api(IPublicAccountObserver.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IPublicAccountObserver::class.java)");
            IPublicAccountObserver iPublicAccountObserver = (IPublicAccountObserver) api;
            iPublicAccountObserver.setOnCallback(new b(callback));
            IPublicAccountUtil iPublicAccountUtil = (IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class);
            AppInterface d16 = d();
            AppInterface d17 = d();
            iPublicAccountUtil.followUin(d16, d17 != null ? d17.getApplicationContext() : null, optString, iPublicAccountObserver);
            return;
        }
        QRouteApi api2 = QRoute.api(IPublicAccountObserver.class);
        Intrinsics.checkNotNullExpressionValue(api2, "api(IPublicAccountObserver::class.java)");
        IPublicAccountObserver iPublicAccountObserver2 = (IPublicAccountObserver) api2;
        iPublicAccountObserver2.setOnCallback(new c(callback));
        IPublicAccountUtil iPublicAccountUtil2 = (IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class);
        AppInterface d18 = d();
        AppInterface d19 = d();
        iPublicAccountUtil2.unfollowUin(d18, d19 != null ? d19.getApplicationContext() : null, optString, false, iPublicAccountObserver2);
    }

    private final AppInterface d() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            return (AppInterface) peekAppRuntime;
        }
        return null;
    }

    private final void g(String params, Function1<Object, Unit> callback) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(params)) {
            return;
        }
        if (params != null) {
            try {
                jSONObject = new JSONObject(params);
            } catch (Throwable th5) {
                QLog.e("QQKuiklyPublicAccountModule", 1, "isPublicAccountTop error:", th5);
                return;
            }
        } else {
            jSONObject = null;
        }
        String optString = jSONObject != null ? jSONObject.optString(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_P_UIN) : null;
        if (optString == null) {
            optString = "";
        }
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(optString);
        IPublicAccountCommonMrg iPublicAccountCommonMrg = (IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        iPublicAccountCommonMrg.getTopState(uid, new d(callback));
    }

    private final void i(String params, final Function1<Object, Unit> callback) {
        JSONObject jSONObject;
        boolean z16;
        if (TextUtils.isEmpty(params)) {
            return;
        }
        if (params != null) {
            try {
                jSONObject = new JSONObject(params);
            } catch (Throwable th5) {
                QLog.e("QQKuiklyPublicAccountModule", 1, "setPublicAccountTopState error:", th5);
                return;
            }
        } else {
            jSONObject = null;
        }
        String optString = jSONObject != null ? jSONObject.optString(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_P_UIN) : null;
        if (optString == null) {
            optString = "";
        }
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(optString);
        Integer valueOf = jSONObject != null ? Integer.valueOf(jSONObject.optInt("topState")) : null;
        IPublicAccountCommonMrg iPublicAccountCommonMrg = (IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class);
        long parseLong = Long.parseLong(optString);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        if (valueOf != null && valueOf.intValue() == 1) {
            z16 = true;
            iPublicAccountCommonMrg.setTop(parseLong, uid, z16, new IOperateCallback() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.o
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    p.j(Function1.this, i3, str);
                }
            });
        }
        z16 = false;
        iPublicAccountCommonMrg.setTop(parseLong, uid, z16, new IOperateCallback() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.o
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                p.j(Function1.this, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(Function1 function1, int i3, String str) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        if (i3 == 0) {
            str2 = "0";
        } else {
            str2 = "-1";
        }
        jSONObject.put("retCode", str2);
        if (function1 != null) {
            function1.invoke(jSONObject);
        }
    }

    private final void l(String params) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(params)) {
            return;
        }
        if (params != null) {
            try {
                jSONObject = new JSONObject(params);
            } catch (Throwable th5) {
                QLog.e("QQKuiklyPublicAccountModule", 1, "startPublicAccountDataCardPage error:", th5);
                return;
            }
        } else {
            jSONObject = null;
        }
        String optString = jSONObject != null ? jSONObject.optString(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_P_UIN) : null;
        if (optString == null) {
            optString = "";
        }
        boolean optBoolean = jSONObject != null ? jSONObject.optBoolean("from_chat_page") : false;
        Intent intent = new Intent();
        intent.putExtra("uin", optString);
        intent.putExtra("chatPage", optBoolean);
        Context context = getContext();
        if (context != null) {
            ((IPublicAccountDataCardApi) QRoute.api(IPublicAccountDataCardApi.class)).startPublicAccountDataCardPage(context, intent);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -2073227141:
                if (method.equals("isPublicAccountTop")) {
                    g(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -905181461:
                if (method.equals("startPublicAccountDataCardPage")) {
                    l(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -296002402:
                if (method.equals("setPublicAccountTopState")) {
                    i(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1385931206:
                if (method.equals("followAnchor")) {
                    c(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }
}
