package com.tencent.mobileqq.activity.qcircle.bubble;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qcircle.tab.QCircleTabAvatarHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J)\u0010\u000e\u001a\u00020\f2!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bJ\u0006\u0010\u000f\u001a\u00020\u0004R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/activity/qcircle/bubble/QCircleTianShuBubbleChecker;", "", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "g", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "e", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "allowed", "", "callback", "c", tl.h.F, "f", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "curApp", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class QCircleTianShuBubbleChecker {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final QCircleTianShuBubbleChecker f184511a = new QCircleTianShuBubbleChecker();

    QCircleTianShuBubbleChecker() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(String str, Function1 callback, QQAppInterface app, RedpointObserver tianShuRedPointObserver) {
        String str2;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(tianShuRedPointObserver, "$tianShuRedPointObserver");
        QLog.i("QCircleTabRedPoint-TianShuBubbleChecker", 1, "allowShowBubble, timeout");
        QQAppInterface f16 = f184511a.f();
        if (f16 != null) {
            str2 = f16.getCurrentUin();
        } else {
            str2 = null;
        }
        if (!Intrinsics.areEqual(str, str2)) {
            QLog.e("QCircleTabRedPoint-TianShuBubbleChecker", 1, "allowShowBubble, timeout, account change");
        } else {
            callback.invoke(Boolean.FALSE);
        }
        if (!QCircleTabRedPointBubbleShowController.v()) {
            QCircleTabAvatarHelper.O();
        }
        app.removeObserver(tianShuRedPointObserver);
    }

    private final BusinessInfoCheckUpdate.AppInfo e(QQAppInterface app) {
        IRuntimeService runtimeService = app.getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ssConstant.MAIN\n        )");
        return ((IRedTouchManager) runtimeService).getAppInfo(16, "140110");
    }

    private final QQAppInterface f() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(runtime instanceof QQAppInterface)) {
            return null;
        }
        return (QQAppInterface) runtime;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g(QQAppInterface app) {
        boolean z16;
        int i3;
        PBUInt32Field pBUInt32Field;
        BusinessInfoCheckUpdate.AppInfo e16 = e(app);
        if (e16 != null && e16.has()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (e16 != null && (pBUInt32Field = e16.exposure_max) != null) {
            i3 = pBUInt32Field.get();
        } else {
            i3 = 0;
        }
        QLog.e("QCircleTabRedPoint-TianShuBubbleChecker", 1, "isAppInfoValid, isAppInfoValid=" + z16 + ",exposureMaxCount=" + i3);
        if (z16 && i3 > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [T, com.tencent.mobileqq.activity.qcircle.bubble.l] */
    public final void c(@NotNull final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean h16 = h();
        QLog.i("QCircleTabRedPoint-TianShuBubbleChecker", 1, "allowShowBubble, isTianShuSwitchOn=" + h16);
        if (!h16) {
            callback.invoke(Boolean.TRUE);
            return;
        }
        final QQAppInterface f16 = f();
        if (f16 == null) {
            QLog.e("QCircleTabRedPoint-TianShuBubbleChecker", 1, "allowShowBubble, app is null");
            callback.invoke(Boolean.FALSE);
            return;
        }
        if (g(f16)) {
            QLog.i("QCircleTabRedPoint-TianShuBubbleChecker", 1, "allowShowBubble, notnull appInfo");
            callback.invoke(Boolean.TRUE);
            return;
        }
        QLog.i("QCircleTabRedPoint-TianShuBubbleChecker", 1, "allowShowBubble, get null appInfo at first time");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final RedpointObserver redpointObserver = new RedpointObserver() { // from class: com.tencent.mobileqq.activity.qcircle.bubble.QCircleTianShuBubbleChecker$allowShowBubble$tianShuRedPointObserver$1
            @Override // com.tencent.mobileqq.tianshu.observer.RedpointObserver
            public void onDataChange(boolean isSucc) {
                super.onDataChange(isSucc);
                final QQAppInterface qQAppInterface = QQAppInterface.this;
                final Function1<Boolean, Unit> function1 = callback;
                final Ref.ObjectRef<Runnable> objectRef2 = objectRef;
                com.tencent.mobileqq.activity.qcircle.utils.g.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.activity.qcircle.bubble.QCircleTianShuBubbleChecker$allowShowBubble$tianShuRedPointObserver$1$onDataChange$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        boolean g16;
                        g16 = QCircleTianShuBubbleChecker.f184511a.g(QQAppInterface.this);
                        if (g16) {
                            QLog.i("QCircleTabRedPoint-TianShuBubbleChecker", 1, "allowShowBubble, tianShuRedPointObserver, get notnull appInfo");
                            function1.invoke(Boolean.TRUE);
                            Runnable runnable = objectRef2.element;
                            if (runnable != null) {
                                ThreadManagerV2.getUIHandlerV2().removeCallbacks(runnable);
                            }
                            QQAppInterface.this.removeObserver(this);
                        }
                    }
                });
            }
        };
        final String currentUin = f16.getCurrentUin();
        objectRef.element = new Runnable() { // from class: com.tencent.mobileqq.activity.qcircle.bubble.l
            @Override // java.lang.Runnable
            public final void run() {
                QCircleTianShuBubbleChecker.d(currentUin, callback, f16, redpointObserver);
            }
        };
        f16.addObserver(redpointObserver);
        ThreadManagerV2.getUIHandlerV2().postDelayed((Runnable) objectRef.element, 10000L);
    }

    public final boolean h() {
        if (((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).isTestEnv() || ((Number) ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).getAladdinConfig(659, "qcircle_bubble_tianshu_switch", 1)).intValue() != 1) {
            return false;
        }
        return true;
    }
}
