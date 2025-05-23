package com.tencent.mobileqq.zplan.authorize.impl.checker;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\b&\u0018\u0000 \u0019*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003:\u0001\u000bB\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0005\u001a\u00020\u0004H&J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\bH\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ+\u0010\r\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\b\u00a2\u0006\u0004\b\r\u0010\fJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0004J\u0016\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017R0\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010&\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/impl/checker/BaseChecker;", BdhLogUtil.LogTag.Tag_Req, "T", "", "", "b", Const.BUNDLE_KEY_REQUEST, "lastCheckResult", "Lcom/tencent/mobileqq/zplan/authorize/api/a;", "callback", "", "a", "(Ljava/lang/Object;Ljava/lang/Object;Lcom/tencent/mobileqq/zplan/authorize/api/a;)V", "d", "log", "f", "e", "", "id", h.F, "toast", "i", ZPlanPublishSource.FROM_SCHEME, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "c", "Lcom/tencent/mobileqq/zplan/authorize/impl/checker/BaseChecker;", "getNextChecker", "()Lcom/tencent/mobileqq/zplan/authorize/impl/checker/BaseChecker;", "g", "(Lcom/tencent/mobileqq/zplan/authorize/impl/checker/BaseChecker;)V", "nextChecker", "", "J", "getCheckStartTime", "()J", "setCheckStartTime", "(J)V", "checkStartTime", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public abstract class BaseChecker<R, T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private BaseChecker<R, T> nextChecker;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long checkStartTime;

    public void a(R request, T lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<T> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        f("check start");
        this.checkStartTime = System.currentTimeMillis();
    }

    public abstract String b();

    public final void c(String scheme, ZootopiaSource source) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(source, "source");
        f("gotoSchemePage");
        String appendSourceToScheme = ((ISchemeApi) QRoute.api(ISchemeApi.class)).appendSourceToScheme(scheme, source);
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        iSchemeApi.launchScheme(context, appendSourceToScheme);
    }

    public final void d(R request, T lastCheckResult, com.tencent.mobileqq.zplan.authorize.api.a<T> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        f("handleCheckPassed cost " + (System.currentTimeMillis() - this.checkStartTime));
        BaseChecker<R, T> baseChecker = this.nextChecker;
        if (baseChecker == null) {
            callback.b(lastCheckResult);
        } else if (baseChecker != null) {
            baseChecker.a(request, lastCheckResult, callback);
        }
    }

    public final void e(String log) {
        Intrinsics.checkNotNullParameter(log, "log");
        QLog.e("Checker_" + b(), 1, log);
    }

    public final void f(String log) {
        Intrinsics.checkNotNullParameter(log, "log");
        QLog.i("Checker_" + b(), 1, log);
    }

    public final void g(BaseChecker<R, T> baseChecker) {
        this.nextChecker = baseChecker;
    }

    public final void h(final int id5) {
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker$toast$1
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
                QQToastUtil.showQQToast(1, id5);
            }
        });
    }

    public final void i(final String toast) {
        Intrinsics.checkNotNullParameter(toast, "toast");
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.authorize.impl.checker.BaseChecker$toast$2
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
                QQToastUtil.showQQToast(1, toast);
            }
        });
    }
}
