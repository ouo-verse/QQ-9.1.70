package com.tencent.mobileqq.troop.deletemember.parts;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.deletemember.inject.TroopDeleteMemberDataHandler;
import com.tencent.mobileqq.troop.deletemember.inject.delegate.TroopDeleteMemberGroupDelegate;
import com.tencent.mobileqq.troop.deletemember.inject.title.TroopDeleteMemberTitleHandler;
import com.tencent.mobileqq.troop.selectmember.api.ITroopSelectMemberApi;
import com.tencent.mobileqq.troop.selectmember.config.TroopSelectMemberConfig;
import com.tencent.mobileqq.troop.selectmember.config.TroopSelectMemberTitleBarConfig;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/troop/deletemember/parts/TroopDeleteMemberSelectPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "C9", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", "z9", "", "A9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/troop/deletemember/a;", "d", "Lcom/tencent/mobileqq/troop/deletemember/a;", "viewModel", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "e", "Lkotlin/Lazy;", "B9", "()Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "selectTroopMemberFrag", "<init>", "()V", "f", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopDeleteMemberSelectPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: h, reason: collision with root package name */
    private static int f295042h;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.troop.deletemember.a viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy selectTroopMemberFrag;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/deletemember/parts/TroopDeleteMemberSelectPart$a;", "", "", "DEFAULT_MAX_SELECT_COUNT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.deletemember.parts.TroopDeleteMemberSelectPart$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31389);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopDeleteMemberSelectPart() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<QPublicBaseFragment>() { // from class: com.tencent.mobileqq.troop.deletemember.parts.TroopDeleteMemberSelectPart$selectTroopMemberFrag$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopDeleteMemberSelectPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final QPublicBaseFragment invoke() {
                    TroopSelectMemberConfig z95;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (QPublicBaseFragment) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    ITroopSelectMemberApi iTroopSelectMemberApi = (ITroopSelectMemberApi) QRoute.api(ITroopSelectMemberApi.class);
                    z95 = TroopDeleteMemberSelectPart.this.z9();
                    return iTroopSelectMemberApi.createSelectTroopMemberFragment(z95);
                }
            });
            this.selectTroopMemberFrag = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int A9() {
        int i3 = f295042h;
        if (i3 > 0) {
            return i3;
        }
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("103137", "");
        if (!TextUtils.isEmpty(loadAsString)) {
            try {
                f295042h = new JSONObject(loadAsString).optInt("max_count", 500);
            } catch (JSONException e16) {
                QLog.e("TroopDeleteMemberSelect", 1, "getMaxSelectCount: ", e16);
            }
        }
        if (f295042h <= 0) {
            f295042h = 500;
        }
        return f295042h;
    }

    private final QPublicBaseFragment B9() {
        return (QPublicBaseFragment) this.selectTroopMemberFrag.getValue();
    }

    private final void C9() {
        FragmentActivity fragmentActivity;
        FragmentManager supportFragmentManager;
        Activity activity = getActivity();
        if (activity instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) activity;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null) {
            QLog.e("TroopDeleteMemberSelect", 1, "[loadMemberSelectFrag] fm is null");
            QPublicBaseFragment B9 = B9();
            if (B9 != null) {
                supportFragmentManager.beginTransaction().replace(R.id.ug5, B9).commitAllowingStateLoss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TroopSelectMemberConfig z9() {
        com.tencent.mobileqq.troop.deletemember.a aVar = this.viewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            aVar = null;
        }
        TroopSelectMemberConfig troopSelectMemberConfig = new TroopSelectMemberConfig(aVar.N1(), 2, 29);
        TroopSelectMemberTitleBarConfig o16 = troopSelectMemberConfig.o();
        String qqStr = HardCodeUtil.qqStr(R.string.f2062257q);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qq_troop_member_text)");
        o16.f(qqStr);
        troopSelectMemberConfig.o().e("\u79fb\u9664");
        com.tencent.mobileqq.troop.selectmember.config.a.m(troopSelectMemberConfig, Reflection.getOrCreateKotlinClass(TroopDeleteMemberTitleHandler.class).getQualifiedName());
        com.tencent.mobileqq.troop.selectmember.config.a.k(troopSelectMemberConfig, Reflection.getOrCreateKotlinClass(TroopDeleteMemberDataHandler.class).getQualifiedName());
        String qualifiedName = Reflection.getOrCreateKotlinClass(TroopDeleteMemberGroupDelegate.class).getQualifiedName();
        if (qualifiedName != null) {
            com.tencent.mobileqq.troop.selectmember.config.a.l(troopSelectMemberConfig, new String[]{qualifiedName});
        }
        int A9 = A9();
        troopSelectMemberConfig.t(A9);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String qqStr2 = HardCodeUtil.qqStr(R.string.f180903cb);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.qb_troop_\u2026elect_select_limit_toast)");
        String format = String.format(qqStr2, Arrays.copyOf(new Object[]{Integer.valueOf(A9)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        troopSelectMemberConfig.y(format);
        return troopSelectMemberConfig;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
        } else {
            super.onInitView(rootView);
            C9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        ViewModel viewModel = getViewModel(com.tencent.mobileqq.troop.deletemember.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopDeleteMemberVM::class.java)");
        this.viewModel = (com.tencent.mobileqq.troop.deletemember.a) viewModel;
    }
}
