package com.tencent.mobileqq.qqecommerce.biz.kuikly.service;

import android.util.Size;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.css.ktx.b;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyRenderView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0006\u0010\t\u001a\u00020\u0003J\u0006\u0010\n\u001a\u00020\u0003J\u0016\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\u0010J\"\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0016\u0010\u001a\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/service/QQKMPCore;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "Lkotlin/Function0;", "", "task", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "i", "", "event", "", "data", "p", "", "l", "isSucceed", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "onPageLoadComplete", "e", "Z", "didStart", "", "f", "Ljava/util/List;", "lazyTasks", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyRenderView;", h.F, "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyRenderView;", "kmpInstance", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKMPCore implements com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean didStart;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static QQKuiklyRenderView kmpInstance;

    /* renamed from: d, reason: collision with root package name */
    public static final QQKMPCore f263203d = new QQKMPCore();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static List<Function0<Unit>> lazyTasks = new ArrayList();

    QQKMPCore() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        QQKuiklyRenderView qQKuiklyRenderView = kmpInstance;
        if (qQKuiklyRenderView != null) {
            qQKuiklyRenderView.onDetach();
        }
        kmpInstance = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        Map<String, Object> mutableMapOf;
        if (kmpInstance != null) {
            return;
        }
        Size size = new Size(ViewUtils.getScreenWidth(), ViewUtils.getScreenHeight());
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        QQKuiklyRenderView qQKuiklyRenderView = new QQKuiklyRenderView(context, this, true);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("KT_GLOBAL_PAGER_PAGE_DATA_KEY", 1));
        qQKuiklyRenderView.b("QQKMPCore", mutableMapOf, size);
        kmpInstance = qQKuiklyRenderView;
    }

    private final void m(final Function0<Unit> task) {
        if (b.l()) {
            task.invoke();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.service.a
                @Override // java.lang.Runnable
                public final void run() {
                    QQKMPCore.n(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    private final void o(Function0<Unit> task) {
        if (didStart) {
            task.invoke();
        } else {
            lazyTasks.add(task);
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
        h.a.a(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
        h.a.b(this);
    }

    public final void i() {
        m(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.service.QQKMPCore$destroyCore$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QQKMPCore.didStart = false;
                QQKMPCore.f263203d.j();
            }
        });
    }

    public final boolean l() {
        b.l();
        return didStart;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean isSucceed, ErrorReason errorReason, KuiklyRenderCoreExecuteMode executeMode) {
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        QLog.i("QQKMPCore", 1, "QQKMPCore onPageLoadComplete: " + isSucceed);
    }

    public final void p(final String event, final Object data) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(data, "data");
        o(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.service.QQKMPCore$sendEvent$1
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
                QQKuiklyRenderView qQKuiklyRenderView;
                qQKuiklyRenderView = QQKMPCore.kmpInstance;
                if (qQKuiklyRenderView != null) {
                    qQKuiklyRenderView.y0(event, data);
                }
            }
        });
    }

    public final void q() {
        m(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.service.QQKMPCore$startCore$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean z16;
                List list;
                z16 = QQKMPCore.didStart;
                if (z16) {
                    return;
                }
                QQKMPCore.didStart = true;
                QQKMPCore.f263203d.k();
                list = QQKMPCore.lazyTasks;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                QQKMPCore qQKMPCore = QQKMPCore.f263203d;
                QQKMPCore.lazyTasks = new ArrayList();
            }
        });
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
        h.a.c(this);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
        h.a.d(this);
    }
}
