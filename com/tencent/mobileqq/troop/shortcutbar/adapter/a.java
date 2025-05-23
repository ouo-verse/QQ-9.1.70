package com.tencent.mobileqq.troop.shortcutbar.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.shortcutbar.adapter.TroopShortcutBarUIState;
import com.tencent.mvi.mvvm.BaseVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/troop/shortcutbar/adapter/a;", "Lcom/tencent/aio/base/mvvm/a;", "", "Lcom/tencent/mobileqq/troop/shortcutbar/adapter/TroopShortcutBarUIState;", "Landroid/view/View;", "view", "Landroid/view/ViewGroup$LayoutParams;", "params", "", "d1", "c1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/aio/api/runtime/a;", "createVM", "state", "b1", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "mRootLayout", "e", "Landroid/view/View;", "mCurrentView", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a extends com.tencent.aio.base.mvvm.a<Object, TroopShortcutBarUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout mRootLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mCurrentView;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void c1(View view) {
        int id5 = view.getId();
        FrameLayout frameLayout = this.mRootLayout;
        FrameLayout frameLayout2 = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
            frameLayout = null;
        }
        View findViewById = frameLayout.findViewById(id5);
        if (findViewById != null) {
            FrameLayout frameLayout3 = this.mRootLayout;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
            } else {
                frameLayout2 = frameLayout3;
            }
            frameLayout2.removeView(findViewById);
        }
    }

    private final void d1(View view, ViewGroup.LayoutParams params) {
        View view2 = this.mCurrentView;
        if (view2 != null) {
            c1(view2);
        }
        c1(view);
        FrameLayout frameLayout = null;
        if (params != null) {
            FrameLayout frameLayout2 = this.mRootLayout;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
            } else {
                frameLayout = frameLayout2;
            }
            frameLayout.addView(view, params);
        } else {
            FrameLayout frameLayout3 = this.mRootLayout;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootLayout");
            } else {
                frameLayout = frameLayout3;
            }
            frameLayout.addView(view);
        }
        this.mCurrentView = view;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull TroopShortcutBarUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof TroopShortcutBarUIState.SetShortcutBarViewState) {
            TroopShortcutBarUIState.SetShortcutBarViewState setShortcutBarViewState = (TroopShortcutBarUIState.SetShortcutBarViewState) state;
            d1(setShortcutBarViewState.b(), setShortcutBarViewState.a());
        } else if (state instanceof TroopShortcutBarUIState.RemoveShortcutBarViewState) {
            c1(((TroopShortcutBarUIState.RemoveShortcutBarViewState) state).a());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    public BaseVM<Object, TroopShortcutBarUIState, com.tencent.aio.api.runtime.a> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseVM) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new b();
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
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        this.mRootLayout = frameLayout;
        return frameLayout;
    }
}
