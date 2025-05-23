package com.tencent.mobileqq.matchfriend.aio.background.state;

import android.view.View;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.biz.qui.quipolarlight.QUIPolarLightView;
import com.tencent.biz.qui.quipolarlight.a;
import com.tencent.biz.qui.quipolarlight.render.PolarImageRender;
import com.tencent.mobileqq.matchfriend.aio.background.BaseMutualMarkAIOBackgroundProxy;
import com.tencent.mobileqq.matchfriend.aio.background.PAGViewDelegate;
import com.tencent.mobileqq.matchfriend.aio.background.state.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.m;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.libpag.PAGFile;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J0\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/aio/background/state/BaseStateAnimator;", "Lcom/tencent/mobileqq/matchfriend/aio/background/state/a;", "Lcom/tencent/biz/qui/quipolarlight/QUIPolarLightView;", "polarLightView", "", "e", "Lcom/tencent/mobileqq/matchfriend/aio/background/BaseMutualMarkAIOBackgroundProxy$f;", "state", "Lcom/tencent/mobileqq/matchfriend/aio/background/state/a$a;", "viewParams", "", "immediate", "b", "params", "a", "f", "Lcom/tencent/mobileqq/matchfriend/aio/background/PAGViewDelegate;", "pv", "Landroid/view/View;", "view", "d", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class BaseStateAnimator implements a {
    @Override // com.tencent.mobileqq.matchfriend.aio.background.state.a
    public void a(a.AnimatorParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        params.getPolarLightView().stopAnimation();
        params.getPagView().g(new Function2<com.tencent.mobileqq.matchfriend.aio.background.d, View, Unit>() { // from class: com.tencent.mobileqq.matchfriend.aio.background.state.BaseStateAnimator$cancel$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.matchfriend.aio.background.d dVar, View view) {
                invoke2(dVar, view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.tencent.mobileqq.matchfriend.aio.background.d api, View view) {
                Intrinsics.checkNotNullParameter(api, "api");
                Intrinsics.checkNotNullParameter(view, "view");
                api.b(view);
            }
        });
    }

    @Override // com.tencent.mobileqq.matchfriend.aio.background.state.a
    public void b(final BaseMutualMarkAIOBackgroundProxy.f state, final a.AnimatorParams viewParams, final boolean immediate) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(viewParams, "viewParams");
        if (QLog.isColorLevel()) {
            QLog.i("BaseStateAnimator", 2, "start state: " + state + ", immediate: " + immediate + ", pagFilePath: " + viewParams.getPagFilePath() + "\uff0c exist: " + m.e(viewParams.getPagFilePath()));
        }
        if (viewParams.getPagFilePath().length() == 0) {
            if (QLog.isColorLevel()) {
                QLog.i("BaseStateAnimator", 2, "start pagFilePath is empty return");
            }
        } else if (immediate && !f()) {
            if (QLog.isColorLevel()) {
                QLog.i("BaseStateAnimator", 2, "start immediate and not support immediate return");
            }
        } else {
            PAGViewDelegate pagView = viewParams.getPagView();
            pagView.f();
            pagView.g(new Function2<com.tencent.mobileqq.matchfriend.aio.background.d, View, Unit>() { // from class: com.tencent.mobileqq.matchfriend.aio.background.state.BaseStateAnimator$start$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.matchfriend.aio.background.d dVar, View view) {
                    invoke2(dVar, view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(com.tencent.mobileqq.matchfriend.aio.background.d api, View view) {
                    Object m476constructorimpl;
                    Intrinsics.checkNotNullParameter(api, "api");
                    Intrinsics.checkNotNullParameter(view, "view");
                    BaseStateAnimator baseStateAnimator = BaseStateAnimator.this;
                    a.AnimatorParams animatorParams = viewParams;
                    BaseMutualMarkAIOBackgroundProxy.f fVar = state;
                    boolean z16 = immediate;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        PAGFile Load = PagViewMonitor.Load(animatorParams.getPagFilePath());
                        if (Load == null) {
                            QLog.i("BaseStateAnimator", 2, "load pag file failed, pag file path: " + animatorParams.getPagFilePath());
                        } else {
                            com.tencent.mobileqq.matchfriend.aio.utils.c.f243986a.m();
                            baseStateAnimator.d(fVar, animatorParams, z16, animatorParams.getPagView(), view);
                            baseStateAnimator.e(animatorParams.getPolarLightView());
                            if (z16) {
                                Load.setProgress(1.0d);
                            }
                            api.a(view, Load);
                        }
                        m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th5) {
                        Result.Companion companion2 = Result.INSTANCE;
                        m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                    }
                    Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                    if (m479exceptionOrNullimpl != null) {
                        a.AnimatorParams animatorParams2 = viewParams;
                        QLog.e("BaseStateAnimator", 2, m479exceptionOrNullimpl, new Object[0]);
                        if (QLog.isColorLevel()) {
                            QLog.i("BaseStateAnimator", 2, "pagFilePath: " + animatorParams2.getPagFilePath() + ", exist: " + m.f352305a.f(animatorParams2.getPagFilePath()));
                        }
                    }
                }
            });
        }
    }

    public void d(BaseMutualMarkAIOBackgroundProxy.f state, a.AnimatorParams viewParams, boolean immediate, PAGViewDelegate pv5, View view) {
        throw null;
    }

    public boolean f() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(QUIPolarLightView polarLightView) {
        ArrayList arrayListOf;
        polarLightView.setVisibility(0);
        PolarImageRender polarLightRender = polarLightView.getPolarLightRender();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(11723775, 16696575, 11599813);
        polarLightRender.s(arrayListOf);
        polarLightView.getPolarLightRender().q(new a.b(0.5f, 0.5f, 0.5f, 0.5f, 0.0f));
        polarLightView.m();
    }
}
