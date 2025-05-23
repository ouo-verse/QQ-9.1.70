package com.tencent.mobileqq.troop.teamup.home.part;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quisecnavbar.BaseAction;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/home/part/TroopTeamUpHomeTitlePart;", "Lcom/tencent/biz/richframework/part/Part;", "()V", "onInitView", "", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class TroopTeamUpHomeTitlePart extends Part {
    static IPatchRedirector $redirector_;

    public TroopTeamUpHomeTitlePart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        QUISecNavBar qUISecNavBar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        if (rootView != null && (qUISecNavBar = (QUISecNavBar) rootView.findViewById(R.id.jo9)) != null) {
            Fragment hostFragment = getHostFragment();
            Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
            qUISecNavBar.S(hostFragment);
            qUISecNavBar.setLeftType(2);
            qUISecNavBar.setCenterType(1);
            qUISecNavBar.setCenterText("\u7fa4\u62a5\u540d");
            qUISecNavBar.setOnBaseTitleBarClickListener(new Function2<View, BaseAction, Unit>() { // from class: com.tencent.mobileqq.troop.teamup.home.part.TroopTeamUpHomeTitlePart$onInitView$1$1
                static IPatchRedirector $redirector_;

                @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
                /* loaded from: classes19.dex */
                public /* synthetic */ class a {
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f299002a;

                    static {
                        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55882);
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
                        f299002a = iArr;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopTeamUpHomeTitlePart.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, BaseAction baseAction) {
                    invoke2(view, baseAction);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View v3, @NotNull BaseAction action) {
                    Activity activity;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) v3, (Object) action);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(v3, "v");
                    Intrinsics.checkNotNullParameter(action, "action");
                    if (a.f299002a[action.ordinal()] != 1 || (activity = TroopTeamUpHomeTitlePart.this.getActivity()) == null) {
                        return;
                    }
                    activity.finish();
                }
            });
        }
    }
}
