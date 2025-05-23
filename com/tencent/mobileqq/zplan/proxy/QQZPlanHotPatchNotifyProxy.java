package com.tencent.mobileqq.zplan.proxy;

import android.os.Looper;
import com.google.gson.Gson;
import com.tencent.component.media.image.ImageTaskConst;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.zootopia.utils.DataConvertUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import com.tencent.zplan.luabridge.plugins.data.CommonLoadingData;
import com.tencent.zplan.resource.api.ZPlanSceneResourceErrType;
import cy4.ZPlanResourceBusinessData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import yh3.ZPlanHotPatchResult;
import yh3.ZPlanHotPatchVersionInfo;
import yh3.ZPlanLoadingErrorInfo;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J2\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/proxy/QQZPlanHotPatchNotifyProxy;", "Lzx4/g;", "Lkotlin/Function0;", "", "action", "e", "runner", "f", "Lcom/tencent/zplan/luabridge/plugins/data/CommonLoadingData;", "loadingData", "notifyHotPatchProgress", "", "versionInfo", "c", "Lcy4/b;", OpenHippyInfo.EXTRA_KEY_BUSINESS_DATA, "a", "Lcom/tencent/zplan/resource/api/ZPlanSceneResourceErrType;", ImageTaskConst.ERROR_TYPE, "", "errorCode", "errorMessage", "totalTaskCount", "failedTaskCount", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class QQZPlanHotPatchNotifyProxy implements zx4.g {

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/mobileqq/zplan/proxy/QQZPlanHotPatchNotifyProxy$b", "Lai3/b;", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements ai3.b {
        b() {
        }
    }

    private final void e(final Function0<Unit> action) {
        boolean isProcessRunning = QIPCServerHelper.getInstance().isProcessRunning("com.tencent.mobileqq:zplan");
        QLog.i("QQZPlanHotPatchNotifyProxy_", 1, "checkNotifyZPlanProcess -isZPlanUsing - " + isProcessRunning);
        if (isProcessRunning) {
            f(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.proxy.QQZPlanHotPatchNotifyProxy$checkNotifyZPlanProcess$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    action.invoke();
                }
            });
        }
    }

    private final void f(final Function0<Unit> runner) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.proxy.k
                @Override // java.lang.Runnable
                public final void run() {
                    QQZPlanHotPatchNotifyProxy.g(Function0.this);
                }
            }, 16, null, false);
        } else {
            runner.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function0 runner) {
        Intrinsics.checkNotNullParameter(runner, "$runner");
        runner.invoke();
    }

    @Override // zx4.g
    public void a(ZPlanResourceBusinessData businessData) {
        Intrinsics.checkNotNullParameter(businessData, "businessData");
        QLog.i("QQZPlanHotPatchNotifyProxy_", 1, "notifyHotPatchSuccess - " + businessData);
        yh3.c cVar = yh3.c.f450357a;
        String json = DataConvertUtil.f329546a.a().toJson(new ZPlanHotPatchResult());
        Intrinsics.checkNotNullExpressionValue(json, "DataConvertUtil.gson.toJson(ZPlanHotPatchResult())");
        cVar.b(json);
    }

    @Override // zx4.g
    public void b(ZPlanSceneResourceErrType errType, int errorCode, String errorMessage, int totalTaskCount, int failedTaskCount) {
        Intrinsics.checkNotNullParameter(errType, "errType");
        QLog.e("QQZPlanHotPatchNotifyProxy_", 1, "notifyHotPatchError - errType: " + errType + ", errorCode: " + errorCode + ", errorMessage: " + errorMessage + ", totalTaskCount: " + totalTaskCount + ", failedTaskCount: " + failedTaskCount);
        yh3.c cVar = yh3.c.f450357a;
        Gson a16 = DataConvertUtil.f329546a.a();
        String string = BaseApplication.context.getResources().getString(R.string.xqn);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ing_hotpatch_failed_tile)");
        String string2 = BaseApplication.context.getResources().getString(R.string.xqm);
        Intrinsics.checkNotNullExpressionValue(string2, "context.resources.getStr\u2026ding_hotpatch_failed_msg)");
        if (errorMessage == null) {
            errorMessage = "";
        }
        String json = a16.toJson(new ZPlanLoadingErrorInfo(0, string, string2, 0, 0, errorCode, errorMessage));
        Intrinsics.checkNotNullExpressionValue(json, "DataConvertUtil.gson.toJ\u2026          )\n            )");
        cVar.c(json, new b());
        QQToastUtil.showQQToastInUiThread(1, BaseApplication.context.getResources().getString(R.string.xw8));
    }

    @Override // zx4.g
    public void c(String versionInfo) {
        Intrinsics.checkNotNullParameter(versionInfo, "versionInfo");
        QLog.i("QQZPlanHotPatchNotifyProxy_", 1, "notifyHotPatchStart - " + versionInfo);
        yh3.c cVar = yh3.c.f450357a;
        String json = DataConvertUtil.f329546a.a().toJson(new ZPlanHotPatchVersionInfo(0, false, 0.0f, 0.0f));
        Intrinsics.checkNotNullExpressionValue(json, "DataConvertUtil.gson.toJ\u2026          )\n            )");
        cVar.e(json);
    }

    @Override // zx4.g
    public void notifyHotPatchProgress(final CommonLoadingData loadingData) {
        Intrinsics.checkNotNullParameter(loadingData, "loadingData");
        yh3.c.f450357a.d(loadingData);
        e(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.proxy.QQZPlanHotPatchNotifyProxy$notifyHotPatchProgress$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((com.tencent.mobileqq.zootopia.download.hotpatch.ipc.a) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.download.hotpatch.ipc.a.class)).notifyHotPatchProgress(CommonLoadingData.this);
            }
        });
    }
}
