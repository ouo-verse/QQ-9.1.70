package com.tencent.qqnt.aio.reserve2.animation;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.lazy.FrameLayoutLazyVB;
import com.tencent.qqnt.aio.reserve2.animation.AnimationMviUIState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0014J\u001a\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/reserve2/animation/a;", "Lcom/tencent/qqnt/aio/lazy/FrameLayoutLazyVB;", "", "Lcom/tencent/qqnt/aio/reserve2/animation/AnimationMviUIState;", "", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "Landroid/view/View;", "view", "", "k1", "l1", "Landroid/view/ViewGroup$LayoutParams;", "e1", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "state", "j1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a extends FrameLayoutLazyVB<Object, AnimationMviUIState> {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void k1(int busiType, View view) {
        if (QLog.isDevelopLevel()) {
            QLog.i("MsgExt", 4, "[inflateAnimationView]: busiType is " + busiType);
        }
        i1(view);
    }

    private final void l1(int busiType) {
        if (QLog.isDevelopLevel()) {
            QLog.i("MsgExt", 4, "[removeAnimationView]: busiType is " + busiType);
        }
        h1();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<Object, AnimationMviUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseVM) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new BusiAnimationVM();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.aio.lazy.FrameLayoutLazyVB
    @NotNull
    public ViewGroup.LayoutParams e1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ViewGroup.LayoutParams) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new ViewGroup.LayoutParams(-1, -1);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull AnimationMviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof AnimationMviUIState.AddFullScreenView) {
            AnimationMviUIState.AddFullScreenView addFullScreenView = (AnimationMviUIState.AddFullScreenView) state;
            k1(addFullScreenView.a(), addFullScreenView.b());
        } else if (state instanceof AnimationMviUIState.RemoveFullScreenView) {
            l1(((AnimationMviUIState.RemoveFullScreenView) state).a());
        }
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onDestroy();
            h1();
        }
    }
}
