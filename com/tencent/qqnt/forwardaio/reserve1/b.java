package com.tencent.qqnt.forwardaio.reserve1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IMsgForwardApi;
import com.tencent.qqnt.forwardaio.reserve1.ForwardAIOReserve1UIState;
import com.tencent.qqnt.forwardaio.reserve1.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/forwardaio/reserve1/b;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/qqnt/forwardaio/reserve1/a;", "Lcom/tencent/qqnt/forwardaio/reserve1/ForwardAIOReserve1UIState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", "b1", "", "bindViewAndData", "state", "c1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "Lyw3/a;", "e", "Lyw3/a;", "memViewController", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b extends com.tencent.aio.base.mvvm.a<a, ForwardAIOReserve1UIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout container;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private yw3.a memViewController;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<a, ForwardAIOReserve1UIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new ForwardAIOReserve1VM();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.bindViewAndData();
        a.b bVar = new a.b(0);
        sendIntent(bVar);
        FrameLayout frameLayout = this.container;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            frameLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = bVar.a();
        } else {
            FrameLayout frameLayout3 = this.container;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                frameLayout3 = null;
            }
            frameLayout3.setPadding(0, bVar.a(), 0, 0);
        }
        FrameLayout frameLayout4 = this.container;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
        } else {
            frameLayout2 = frameLayout4;
        }
        frameLayout2.setBackgroundResource(R.drawable.qui_common_bg_bottom_standard_bg_corner_6);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull ForwardAIOReserve1UIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof ForwardAIOReserve1UIState.UpdateMem) {
            FrameLayout frameLayout = null;
            if (((ForwardAIOReserve1UIState.UpdateMem) state).a()) {
                if (this.memViewController == null) {
                    yw3.a memberViewController = ((IMsgForwardApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IMsgForwardApi.class)).getMemberViewController();
                    this.memViewController = memberViewController;
                    if (memberViewController != null) {
                        a.C9622a c9622a = new a.C9622a(null, 0, 0.0f, 7, null);
                        sendIntent(c9622a);
                        FrameLayout frameLayout2 = this.container;
                        if (frameLayout2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                            frameLayout2 = null;
                        }
                        Context context = frameLayout2.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "container.context");
                        View a16 = memberViewController.a(context, c9622a.c(), c9622a.a(), c9622a.b());
                        FrameLayout frameLayout3 = this.container;
                        if (frameLayout3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                            frameLayout3 = null;
                        }
                        frameLayout3.addView(a16);
                    }
                }
                FrameLayout frameLayout4 = this.container;
                if (frameLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
                } else {
                    frameLayout = frameLayout4;
                }
                frameLayout.setVisibility(0);
                return;
            }
            FrameLayout frameLayout5 = this.container;
            if (frameLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            } else {
                frameLayout = frameLayout5;
            }
            frameLayout.setVisibility(8);
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        FrameLayout frameLayout = new FrameLayout(createViewParams.a());
        this.container = frameLayout;
        frameLayout.setVisibility(8);
        FrameLayout frameLayout2 = this.container;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            frameLayout2 = null;
        }
        frameLayout2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout3 = this.container;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(ParseCommon.CONTAINER);
            return null;
        }
        return frameLayout3;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroy();
        yw3.a aVar = this.memViewController;
        if (aVar != null) {
            aVar.onDestroy();
        }
    }
}
