package com.tencent.mobileqq.matchfriend.aio.foreground;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.aio.foreground.StrangerGainMutualMarkView;
import com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerForegroundApi;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.QQStrangerInteractiveMarkModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0016\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0003J\u000e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/foreground/StrangerGainMutualMarkForegroundDelegate;", "", "Lkotlin/Function0;", "", "block", "j", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "model", "Lcom/tencent/mobileqq/matchfriend/aio/foreground/a;", "result", DomainData.DOMAIN_NAME, "Landroid/content/Context;", "context", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "f", "l", "Lcom/tencent/aio/api/runtime/a;", tl.h.F, "i", "p", "a", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lm72/a;", "b", "Lm72/a;", "resourceLoader", "Landroid/app/Dialog;", "c", "Landroid/app/Dialog;", "gainMutualMarkAnimatorDialog", "Landroid/os/Handler;", "d", "Lkotlin/Lazy;", "g", "()Landroid/os/Handler;", "subHandler", "<init>", "()V", "e", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class StrangerGainMutualMarkForegroundDelegate {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private m72.a<QQStrangerInteractiveMarkModel, a> resourceLoader = new ForegroundResourceLoader();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Dialog gainMutualMarkAnimatorDialog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy subHandler;

    public StrangerGainMutualMarkForegroundDelegate() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.mobileqq.matchfriend.aio.foreground.StrangerGainMutualMarkForegroundDelegate$subHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return new Handler(ThreadManagerV2.getQQCommonThreadLooper());
            }
        });
        this.subHandler = lazy;
    }

    private final void f() {
        Dialog dialog = this.gainMutualMarkAnimatorDialog;
        if (dialog != null) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            this.gainMutualMarkAnimatorDialog = null;
        }
    }

    private final Handler g() {
        return (Handler) this.subHandler.getValue();
    }

    private final void j(final Function0<Unit> block) {
        g().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.aio.foreground.d
            @Override // java.lang.Runnable
            public final void run() {
                StrangerGainMutualMarkForegroundDelegate.k(Function0.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    private final void l(final QQStrangerInteractiveMarkModel model) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.aio.foreground.f
            @Override // java.lang.Runnable
            public final void run() {
                StrangerGainMutualMarkForegroundDelegate.m(QQStrangerInteractiveMarkModel.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(QQStrangerInteractiveMarkModel model) {
        Intrinsics.checkNotNullParameter(model, "$model");
        com.tencent.mobileqq.matchfriend.aio.utils.c.f243986a.f(model.level, model.subtype);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(final QQStrangerInteractiveMarkModel model, a result) {
        Fragment c16;
        final FragmentActivity activity;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null || (c16 = aVar.c()) == null || (activity = c16.getActivity()) == null) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.aio.foreground.e
            @Override // java.lang.Runnable
            public final void run() {
                StrangerGainMutualMarkForegroundDelegate.o(FragmentActivity.this, this, model);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(FragmentActivity this_run, StrangerGainMutualMarkForegroundDelegate this$0, QQStrangerInteractiveMarkModel model) {
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(model, "$model");
        if (this_run.isFinishing() || this_run.isDestroyed()) {
            return;
        }
        this$0.l(model);
        this$0.q(this_run, model);
    }

    private final void q(Context context, final QQStrangerInteractiveMarkModel model) {
        f();
        StrangerGainMutualMarkAnimatorDialog strangerGainMutualMarkAnimatorDialog = new StrangerGainMutualMarkAnimatorDialog(context, com.tencent.mobileqq.matchfriend.aio.utils.b.e(model, context), new Function1<StrangerGainMutualMarkView.StrangerGainMutualMarkModel, Unit>() { // from class: com.tencent.mobileqq.matchfriend.aio.foreground.StrangerGainMutualMarkForegroundDelegate$showGainMutualMarkAnimatorDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(StrangerGainMutualMarkView.StrangerGainMutualMarkModel strangerGainMutualMarkModel) {
                invoke2(strangerGainMutualMarkModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(StrangerGainMutualMarkView.StrangerGainMutualMarkModel it) {
                Intrinsics.checkNotNullParameter(it, "it");
                QRouteApi api = QRoute.api(IQQStrangerForegroundApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IQQStrangerForegroundApi::class.java)");
                IQQStrangerForegroundApi.a.a((IQQStrangerForegroundApi) api, QQStrangerInteractiveMarkModel.this, null, 2, null);
            }
        });
        this.gainMutualMarkAnimatorDialog = strangerGainMutualMarkAnimatorDialog;
        strangerGainMutualMarkAnimatorDialog.show();
    }

    public final void h(com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.aioContext = context;
    }

    public final void i() {
        f();
        g().removeCallbacksAndMessages(null);
        this.aioContext = null;
    }

    public final void p(final QQStrangerInteractiveMarkModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        j(new Function0<Unit>() { // from class: com.tencent.mobileqq.matchfriend.aio.foreground.StrangerGainMutualMarkForegroundDelegate$setMutualMarkModel$1
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
                m72.a aVar;
                aVar = StrangerGainMutualMarkForegroundDelegate.this.resourceLoader;
                StrangerGainMutualMarkForegroundDelegate.this.n(model, (a) aVar.a(model));
            }
        });
    }
}
