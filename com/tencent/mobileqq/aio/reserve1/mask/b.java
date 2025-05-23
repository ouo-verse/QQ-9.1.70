package com.tencent.mobileqq.aio.reserve1.mask;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.reserve1.mask.MaskUIState;
import com.tencent.mobileqq.aio.reserve1.mask.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import w71.w;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/mask/b;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/mobileqq/aio/reserve1/mask/a;", "Lcom/tencent/mobileqq/aio/reserve1/mask/MaskUIState;", "", "height", "", "e1", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "bindViewAndData", "Lcom/tencent/aio/base/mvvm/b;", "b1", "state", "c1", "Lw71/w;", "d", "Lw71/w;", "mTitleBinding", "<init>", "()V", "e", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class b extends com.tencent.aio.base.mvvm.a<a, MaskUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private w mTitleBinding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/reserve1/mask/b$a;", "", "", "MASK_ALPHA", "I", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.reserve1.mask.b$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64728);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d1(int height) {
        w wVar = this.mTitleBinding;
        w wVar2 = null;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            wVar = null;
        }
        wVar.getMRv().getLayoutParams().height = height;
        w wVar3 = this.mTitleBinding;
        if (wVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
        } else {
            wVar2 = wVar3;
        }
        wVar2.getMRv().setVisibility(0);
    }

    private final void e1(int height) {
        w wVar = this.mTitleBinding;
        w wVar2 = null;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            wVar = null;
        }
        wVar.getMRv().getLayoutParams().height = height;
        w wVar3 = this.mTitleBinding;
        if (wVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            wVar3 = null;
        }
        View mRv = wVar3.getMRv();
        w wVar4 = this.mTitleBinding;
        if (wVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
        } else {
            wVar2 = wVar4;
        }
        mRv.setLayoutParams(wVar2.getMRv().getLayoutParams());
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<a, MaskUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new c();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.bindViewAndData();
        sendIntent(a.C7350a.f193287d);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setShape(0);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColors(new int[]{ColorUtils.setAlphaComponent(getMContext().getColor(R.color.qui_common_bg_nav_aio), 179), 0});
        w wVar = this.mTitleBinding;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            wVar = null;
        }
        wVar.getMRv().setBackground(gradientDrawable);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull MaskUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof MaskUIState.HideMaskView) {
            w wVar = this.mTitleBinding;
            if (wVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
                wVar = null;
            }
            wVar.getMRv().setVisibility(8);
            return;
        }
        if (state instanceof MaskUIState.ShowMaskView) {
            d1(((MaskUIState.ShowMaskView) state).a());
        } else if (state instanceof MaskUIState.UpdateMaskHeight) {
            e1(((MaskUIState.UpdateMaskHeight) state).a());
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
        w f16 = w.f(LayoutInflater.from(createViewParams.a()), createViewParams.b(), false);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(inflater, createViewParams.parent, false)");
        this.mTitleBinding = f16;
        if (f16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitleBinding");
            f16 = null;
        }
        View mRv = f16.getMRv();
        Intrinsics.checkNotNullExpressionValue(mRv, "mTitleBinding.root");
        return mRv;
    }
}
