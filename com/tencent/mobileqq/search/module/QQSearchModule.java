package com.tencent.mobileqq.search.module;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCirclePolymerizationBean;
import com.tencent.biz.qqcircle.launcher.c;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.w;
import com.tencent.mobileqq.vashealth.api.IQQHealthService;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StTagInfo;
import i01.e;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import mqq.app.api.ProcessConstant;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J?\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\r\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J?\u0010\u000e\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0002J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0014H\u0002JI\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022+\u0010\u000b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nH\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/search/module/QQSearchModule;", "Li01/e;", "", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "i", "p", "d", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "stFeed", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lfeedcloud/FeedCloudMeta$StFeed;", "l", "method", "call", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class QQSearchModule extends e {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/search/module/QQSearchModule$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "Lcom/tencent/mobileqq/qqpermission/view/PermissionRequestDialog;", "dialog", "", "", "deniedPermissions", "", AdCommonMethodHandler.AdCommonEvent.ON_DIALOG_SHOW, "onMultiSceneDialogDenied", "Lcom/tencent/mobileqq/qqpermission/view/a;", "onMultiSceneDialogShow", "onAllGranted", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Object, Unit> f283551a;

        b(Function1<Object, Unit> function1) {
            this.f283551a = function1;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            Map mapOf;
            Function1<Object, Unit> function1 = this.f283551a;
            if (function1 != null) {
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("errorCode", 0), TuplesKt.to("msg", "onAllGranted"));
                function1.invoke(mapOf);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(@Nullable PermissionRequestDialog dialog, @Nullable List<String> deniedPermissions) {
            super.onDialogShow(dialog, deniedPermissions);
            QLog.d("QQSearchModule", 1, "onMultiSceneDialogShow");
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onMultiSceneDialogDenied() {
            super.onMultiSceneDialogDenied();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onMultiSceneDialogShow(@Nullable com.tencent.mobileqq.qqpermission.view.a dialog) {
            super.onMultiSceneDialogShow(dialog);
            QLog.d("QQSearchModule", 1, "onMultiSceneDialogShow");
        }
    }

    private final void d(String params, final Function1<Object, Unit> callback) {
        QLog.d("QQSearchModule", 4, "getLBSInfo");
        SearchUtil.r(getContext(), new SearchUtil.b() { // from class: com.tencent.mobileqq.search.module.b
            @Override // com.tencent.mobileqq.search.SearchUtil.b
            public final void a(int i3, String str) {
                QQSearchModule.g(Function1.this, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 function1, int i3, String str) {
        Map mapOf;
        if (function1 != null) {
            Pair[] pairArr = new Pair[2];
            pairArr[0] = TuplesKt.to("errorCode", Integer.valueOf(i3));
            if (str == null) {
                str = "";
            }
            pairArr[1] = TuplesKt.to("lbs", str);
            mapOf = MapsKt__MapsKt.mapOf(pairArr);
            function1.invoke(mapOf);
        }
    }

    private final void i(String params, Function1<Object, Unit> callback) {
        Map mapOf;
        QLog.d("QQSearchModule", 4, "hasPermission");
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        int hasPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_BIG_SEARCH, QQPermissionConstants.Business.SCENE.SCENE_BIG_SEARCH)).hasPermission(QQPermissionConstants.Business.ID.QQ_BUSINESS_BIG_SEARCH, "android.permission.ACCESS_COARSE_LOCATION");
        if (callback != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("errorCode", Integer.valueOf(hasPermission)));
            callback.invoke(mapOf);
        }
    }

    private final void j(String params) {
        QLog.d("QQSearchModule", 4, "openLastFunction");
        Context context = getContext();
        if (context == null || params == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(new JSONObject(params).optString("funcPayload"));
        String optString = jSONObject.optString(WadlProxyConsts.KEY_JUMP_URL);
        if (!TextUtils.isEmpty(optString)) {
            SearchUtils.Q0(null, context, optString);
            return;
        }
        String optString2 = jSONObject.optString(Utils.KEY_BUSINESS_ID);
        if (Intrinsics.areEqual("63", optString2)) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            if (((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).startNewWeatherWebPageActivityBySearch(getContext(), (QQAppInterface) runtime)) {
                return;
            }
        }
        if (Intrinsics.areEqual("24", optString2)) {
            AppRuntime runtime2 = BaseApplicationImpl.getApplication().getRuntime();
            Intrinsics.checkNotNull(runtime2, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            QQAppInterface qQAppInterface = (QQAppInterface) runtime2;
            IRuntimeService runtimeService = qQAppInterface.getRuntimeService(IQQHealthService.class, ProcessConstant.MULTI);
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IQ\u2026a, ProcessConstant.MULTI)");
            if (((IQQHealthService) runtimeService).redirectAIOToMainPage(qQAppInterface.getApplicationContext(), 166)) {
                return;
            }
        }
        if (!TextUtils.isEmpty(optString2)) {
            Integer valueOf = Integer.valueOf(optString2);
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(id)");
            SearchUtils.A0(context, valueOf.intValue(), 21012);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(FeedCloudMeta$StFeed stFeed) {
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUin(stFeed.poster.f398463id.get());
        c.d0(getActivity(), qCircleInitBean);
    }

    private final void m(String stFeed) {
        boolean z16;
        boolean z17;
        if (stFeed != null && stFeed.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        String pbToken = new JSONObject(stFeed).optString("feedPbToken", "");
        Intrinsics.checkNotNullExpressionValue(pbToken, "pbToken");
        if (pbToken.length() > 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            pg2.a.f426173a.a(pbToken, new Function1<MessageMicro<?>, Unit>() { // from class: com.tencent.mobileqq.search.module.QQSearchModule$openQCirclePersonalDetailPage$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MessageMicro<?> messageMicro) {
                    invoke2(messageMicro);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull MessageMicro<?> pb5) {
                    Intrinsics.checkNotNullParameter(pb5, "pb");
                    if (pb5 instanceof FeedCloudMeta$StFeed) {
                        QQSearchModule.this.l((FeedCloudMeta$StFeed) pb5);
                    }
                }
            });
            return;
        }
        QLog.e("QQSearchModule", 2, "openQCirclePersonalDetailPage error", "pbToken=" + pbToken);
    }

    private final void o(String params) {
        Context context = getContext();
        if (context == null || params == null) {
            return;
        }
        String optString = new JSONObject(params).optString("hotTagName");
        QCirclePolymerizationBean qCirclePolymerizationBean = new QCirclePolymerizationBean();
        FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = new FeedCloudMeta$StTagInfo();
        feedCloudMeta$StTagInfo.tagName.set(optString);
        qCirclePolymerizationBean.setTagInfo(feedCloudMeta$StTagInfo);
        qCirclePolymerizationBean.setPolymerizationType(7);
        c.j0(context, qCirclePolymerizationBean);
    }

    private final void p(String params, Function1<Object, Unit> callback) {
        Activity activity;
        boolean c16 = w.c();
        QLog.d("QQSearchModule", 4, "requestPermission hasShow=" + c16);
        if (c16 || (activity = getActivity()) == null) {
            return;
        }
        BusinessConfig businessConfig = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_BIG_SEARCH, QQPermissionConstants.Business.SCENE.SCENE_BIG_SEARCH);
        w.d();
        QQPermissionFactory.getQQPermission(activity, businessConfig).requestPermissions(new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 2, new b(callback));
    }

    private final void q(String params) {
        if (params == null) {
            return;
        }
        SearchUtils.i1(new JSONObject(params).optString("keyWord"));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    @Override // i01.e, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -2053827893:
                if (method.equals("qCircleOpenPersonalDetailPage")) {
                    m(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1853311029:
                if (method.equals("saveSearchHistoryForNetSearch")) {
                    q(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case -1399205896:
                if (method.equals("openLastFunction")) {
                    j(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 171850761:
                if (method.equals("hasPermission")) {
                    i(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 746581438:
                if (method.equals("requestPermission")) {
                    p(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1017155541:
                if (method.equals("getLbsInfo")) {
                    d(params, callback);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            case 1662478886:
                if (method.equals("openHotTagPage")) {
                    o(params);
                    return Unit.INSTANCE;
                }
                return super.call(method, params, callback);
            default:
                return super.call(method, params, callback);
        }
    }
}
