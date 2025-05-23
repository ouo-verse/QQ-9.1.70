package com.tencent.mobileqq.troop.selectmember;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.selectmember.config.TroopSelectMemberConfig;
import com.tencent.mobileqq.troop.selectmember.config.a;
import com.tencent.mobileqq.troop.selectmember.part.TroopSelectMemberIndexPart;
import com.tencent.mobileqq.troop.selectmember.part.TroopSelectMemberLoadingPart;
import com.tencent.mobileqq.troop.selectmember.part.TroopSelectMemberTitlePart;
import com.tencent.mobileqq.troop.selectmember.part.list.TroopSelectMemberListPart;
import com.tencent.mobileqq.troop.selectmember.part.search.TroopSelectMemberSearchBarPart;
import com.tencent.mobileqq.troop.selectmember.vm.TroopSelectMemberVM;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.e;
import com.tencent.qqnt.report.TroopFeatureReport;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0014J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/TroopSelectMemberFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "Lcom/tencent/biz/richframework/part/Part;", "ph", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "", "getContentLayoutId", "assembleParts", "Lcom/tencent/mobileqq/troop/selectmember/vm/TroopSelectMemberVM;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/selectmember/vm/TroopSelectMemberVM;", "viewModel", "<init>", "()V", "D", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSelectMemberFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private TroopSelectMemberVM viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/TroopSelectMemberFragment$a;", "", "Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;", DownloadInfo.spKey_Config, "", "b", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "", "c", "(Lcom/tencent/mobileqq/troop/selectmember/config/TroopSelectMemberConfig;Landroid/app/Activity;Ljava/lang/Integer;)V", "Lcom/tencent/mobileqq/troop/selectmember/TroopSelectMemberFragment;", "a", "", "KEY_CONFIG", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.selectmember.TroopSelectMemberFragment$a, reason: from kotlin metadata */
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

        private final boolean b(TroopSelectMemberConfig config) {
            if (a.i(config)) {
                e.k(null, 1, "\u914d\u7f6e\u53c2\u6570\u5f02\u5e38", 0, null, 25, null);
                return true;
            }
            return false;
        }

        public static /* synthetic */ void d(Companion companion, TroopSelectMemberConfig troopSelectMemberConfig, Activity activity, Integer num, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                activity = null;
            }
            if ((i3 & 4) != 0) {
                num = null;
            }
            companion.c(troopSelectMemberConfig, activity, num);
        }

        @JvmStatic
        @Nullable
        public final TroopSelectMemberFragment a(@NotNull TroopSelectMemberConfig config) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (TroopSelectMemberFragment) iPatchRedirector.redirect((short) 3, (Object) this, (Object) config);
            }
            Intrinsics.checkNotNullParameter(config, "config");
            if (b(config)) {
                return null;
            }
            TroopSelectMemberFragment troopSelectMemberFragment = new TroopSelectMemberFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable("key_troop_select_member_config", config);
            troopSelectMemberFragment.setArguments(bundle);
            return troopSelectMemberFragment;
        }

        @JvmStatic
        public final void c(@NotNull TroopSelectMemberConfig config, @Nullable Activity activity, @Nullable Integer requestCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, config, activity, requestCode);
                return;
            }
            Intrinsics.checkNotNullParameter(config, "config");
            if (b(config)) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("key_troop_select_member_config", config);
            if (QLog.isColorLevel()) {
                QLog.i("TroopSelectMemberFrag", 2, "[launch] activity:" + activity + ", requestCode:" + requestCode + ", config:" + config);
            }
            if (activity != null && requestCode != null) {
                QPublicFragmentActivity.b.e(activity, intent, QPublicFragmentActivity.class, TroopSelectMemberFragment.class, requestCode.intValue());
            } else {
                QPublicFragmentActivity.b.d(intent, QPublicFragmentActivity.class, TroopSelectMemberFragment.class);
            }
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54823);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSelectMemberFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final List<Part> ph() {
        ArrayList arrayList = new ArrayList();
        TroopSelectMemberVM troopSelectMemberVM = this.viewModel;
        if (troopSelectMemberVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            troopSelectMemberVM = null;
        }
        arrayList.addAll(troopSelectMemberVM.T0().d());
        return arrayList;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new TroopSelectMemberTitlePart(), new TroopSelectMemberSearchBarPart(), new TroopSelectMemberListPart(), new TroopSelectMemberLoadingPart(), new TroopSelectMemberIndexPart());
            mutableListOf.addAll(ph());
            return mutableListOf;
        }
        return (List) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.i0u;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        ViewModel viewModel = getViewModel(TroopSelectMemberVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(TroopSelectMemberVM::class.java)");
        this.viewModel = (TroopSelectMemberVM) viewModel;
        TroopSelectMemberConfig troopSelectMemberConfig = (TroopSelectMemberConfig) requireActivity().getIntent().getParcelableExtra("key_troop_select_member_config");
        if (troopSelectMemberConfig == null) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                troopSelectMemberConfig = (TroopSelectMemberConfig) arguments.getParcelable("key_troop_select_member_config");
            } else {
                troopSelectMemberConfig = null;
            }
        }
        if (troopSelectMemberConfig == null) {
            requireActivity().finish();
            Unit unit = Unit.INSTANCE;
            QLog.e("TroopSelectMemberFrag", 1, "[onCreate] launchConfig is null ");
        }
        if (troopSelectMemberConfig != null) {
            TroopSelectMemberVM troopSelectMemberVM = this.viewModel;
            if (troopSelectMemberVM == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                troopSelectMemberVM = null;
            }
            troopSelectMemberVM.t2(getActivity(), troopSelectMemberConfig);
        }
        TroopFeatureReport troopFeatureReport = TroopFeatureReport.f361921a;
        if (troopSelectMemberConfig != null) {
            num = Integer.valueOf(troopSelectMemberConfig.c());
        } else {
            num = null;
        }
        TroopFeatureReport.c(troopFeatureReport, "TroopSelectMemberFrag-" + num, false, 2, null);
    }
}
