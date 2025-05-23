package com.tencent.mobileqq.troop.edittroopinfo.parts;

import android.app.Activity;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/edittroopinfo/parts/EditTroopTitlePart;", "Lcom/tencent/mobileqq/troop/edittroopinfo/parts/base/b;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "", "hasScrollUp", "J9", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "e", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "titleBar", "f", "Landroid/view/View;", "titleBg", tl.h.F, "Ljava/lang/Boolean;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class EditTroopTitlePart extends com.tencent.mobileqq.troop.edittroopinfo.parts.base.b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QUISecNavBar titleBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View titleBg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean hasScrollUp;

    public EditTroopTitlePart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void J9(boolean hasScrollUp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, hasScrollUp);
            return;
        }
        if (Intrinsics.areEqual(this.hasScrollUp, Boolean.valueOf(hasScrollUp))) {
            return;
        }
        this.hasScrollUp = Boolean.valueOf(hasScrollUp);
        View view = null;
        if (hasScrollUp) {
            View view2 = this.titleBg;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleBg");
            } else {
                view = view2;
            }
            view.setAlpha(1.0f);
            return;
        }
        View view3 = this.titleBg;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBg");
        } else {
            view = view3;
        }
        view.setAlpha(0.0f);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.jo9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.title_bar)");
        QUISecNavBar qUISecNavBar = (QUISecNavBar) findViewById;
        this.titleBar = qUISecNavBar;
        QUISecNavBar qUISecNavBar2 = null;
        if (qUISecNavBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            qUISecNavBar = null;
        }
        View findViewById2 = qUISecNavBar.findViewById(R.id.f81564ei);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "titleBar.findViewById(R.id.sec_nav_bar)");
        this.titleBg = findViewById2;
        J9(false);
        QUISecNavBar qUISecNavBar3 = this.titleBar;
        if (qUISecNavBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            qUISecNavBar3 = null;
        }
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        qUISecNavBar3.R(activity);
        QUISecNavBar qUISecNavBar4 = this.titleBar;
        if (qUISecNavBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        } else {
            qUISecNavBar2 = qUISecNavBar4;
        }
        qUISecNavBar2.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.troop.edittroopinfo.parts.EditTroopTitlePart$onInitView$1
            static IPatchRedirector $redirector_;

            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes19.dex */
            public /* synthetic */ class a {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f295103a;

                static {
                    IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32637);
                    $redirector_ = redirector;
                    if (redirector != null && redirector.hasPatch((short) 1)) {
                        redirector.redirect((short) 1);
                        return;
                    }
                    int[] iArr = new int[BaseAction.values().length];
                    try {
                        iArr[BaseAction.ACTION_LEFT_BUTTON.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    f295103a = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EditTroopTitlePart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                invoke2(view, baseAction);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View view, @NotNull BaseAction baseAction) {
                Activity activity2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view, (Object) baseAction);
                    return;
                }
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(baseAction, "baseAction");
                if (a.f295103a[baseAction.ordinal()] != 1 || (activity2 = EditTroopTitlePart.this.getActivity()) == null) {
                    return;
                }
                activity2.finish();
            }
        });
    }
}
