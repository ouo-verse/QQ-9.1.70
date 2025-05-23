package com.tencent.mobileqq.qqnews.hippy.module;

import android.app.Activity;
import android.content.Intent;
import androidx.activity.result.ActivityResultCaller;
import com.tencent.biz.pubaccount.accountdetail.api.IMsgListPluginApi;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDataCardApi;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.cardcontainer.api.IChatListTestAndVibrateApi;
import com.tencent.mobileqq.qqnews.hippy.module.QQNewsHippyModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;

/* compiled from: P */
@HippyNativeModule(name = "QQNewsModule")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\u0006H\u0007J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqnews/hippy/module/QQNewsHippyModule;", "Lcom/tencent/hippy/qq/module/QQBaseModule;", "context", "Lcom/tencent/mtt/hippy/HippyEngineContext;", "(Lcom/tencent/mtt/hippy/HippyEngineContext;)V", "isMessageTabTop", "", "jsonStr", "", "promise", "Lcom/tencent/mtt/hippy/modules/Promise;", "openQQNewsPAPage", "setMessageTabTop", "setTitleBarShow", "params", "Lcom/tencent/mtt/hippy/common/HippyMap;", "qqnews-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class QQNewsHippyModule extends QQBaseModule {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqnews/hippy/module/QQNewsHippyModule$a", "Lcom/tencent/biz/pubaccount/api/IPublicAccountCommonMrg$a;", "", QzoneIPCModule.RESULT_CODE, "", "isTop", "", "b", "qqnews-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a extends IPublicAccountCommonMrg.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Promise f274142b;

        a(Promise promise) {
            this.f274142b = promise;
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg.a
        public void b(int resultCode, boolean isTop) {
            String str;
            Promise promise = this.f274142b;
            HippyMap hippyMap = new HippyMap();
            if (isTop) {
                str = "1";
            } else {
                str = "0";
            }
            hippyMap.pushString("isMessageTop", str);
            promise.resolve(hippyMap);
        }
    }

    public QQNewsHippyModule(@Nullable HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMessageTabTop$lambda$1(int i3, String str) {
        QLog.i("QQNewsHippyModule", 1, "setTop: result = " + i3 + ", errMsg = " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTitleBarShow$lambda$0(QQNewsHippyModule this$0, int i3) {
        aj2.a aVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityResultCaller fragment = this$0.getFragment();
        if (fragment instanceof aj2.a) {
            aVar = (aj2.a) fragment;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.a(i3);
        }
    }

    @HippyMethod(name = "isMessageTabTop")
    public final void isMessageTabTop(@NotNull String jsonStr, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).getTopState("u_8zYoRDnwjpWg91HWuO-WGA", new a(promise));
        } catch (JSONException e16) {
            promise.reject("[Error] check top state error: " + jsonStr);
            QLog.e("QQNewsHippyModule", 1, "check top state error: " + e16.getMessage());
        }
    }

    @HippyMethod(name = "openQQNewsPAPage")
    public final void openQQNewsPAPage() {
        if (((IChatListTestAndVibrateApi) QRoute.api(IChatListTestAndVibrateApi.class)).getPublicAccountPluginSwitch() && ((IMsgListPluginApi) QRoute.api(IMsgListPluginApi.class)).getEntityByUin("QQNewsHippyModule", Long.parseLong("2909288299")) != null) {
            Intent intent = new Intent();
            intent.putExtra("uin", "2909288299");
            intent.putExtra("chatPage", true);
            IPublicAccountDataCardApi iPublicAccountDataCardApi = (IPublicAccountDataCardApi) QRoute.api(IPublicAccountDataCardApi.class);
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            iPublicAccountDataCardApi.startPublicAccountDataCardPage(activity, intent);
            return;
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(getActivity(), IPublicAccountDetailActivity.ROUTE_NAME);
        activityURIRequest.extra().putBoolean("fromQQNewsPubNew", true);
        activityURIRequest.extra().putString("uin", "2909288299");
        QRoute.startUri(activityURIRequest, (o) null);
    }

    @HippyMethod(name = "setMessageTabTop")
    public final void setMessageTabTop(@NotNull String jsonStr, @NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).setTop(Long.parseLong("2909288299"), "u_8zYoRDnwjpWg91HWuO-WGA", true, new IOperateCallback() { // from class: cj2.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    QQNewsHippyModule.setMessageTabTop$lambda$1(i3, str);
                }
            });
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushString("isSuccess", "1");
            promise.resolve(hippyMap);
        } catch (JSONException e16) {
            promise.reject("[Error] set top state error: " + e16.getMessage());
            QLog.e("QQNewsHippyModule", 1, "set top state error: " + e16.getMessage());
        }
    }

    @HippyMethod(name = "setTitleBarShow")
    public final void setTitleBarShow(@NotNull HippyMap params) {
        Intrinsics.checkNotNullParameter(params, "params");
        final int i3 = params.getInt("action");
        HippyQQEngine.runTaskInUIThread(new Runnable() { // from class: cj2.b
            @Override // java.lang.Runnable
            public final void run() {
                QQNewsHippyModule.setTitleBarShow$lambda$0(QQNewsHippyModule.this, i3);
            }
        });
    }
}
