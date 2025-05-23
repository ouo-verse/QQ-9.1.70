package com.tencent.mobileqq.troop.troopcard.reborn;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.data.v;
import com.tencent.mobileqq.troop.data.w;
import com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardBasicInfoPart;
import com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardBottomPart;
import com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardCoverPart;
import com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardEssenceMsgPart;
import com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardHOKGameDataPart;
import com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardMDGameDataPart;
import com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardMedalPart;
import com.tencent.mobileqq.troop.troopcard.reborn.part.TroopInfoCardTitlePart;
import com.tencent.mobileqq.troop.troopcard.reborn.vm.TroopBasicInfoViewModel;
import com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.am;
import com.tencent.open.base.h;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/TroopInfoCardFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "setStatusBarImmersive", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/content/Intent;", "intent", "onNewIntent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onPostThemeChanged", "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/troopcard/reborn/vm/TroopBasicInfoViewModel;", "basicInfoViewModel", "<init>", "()V", "D", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopInfoCardFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TroopBasicInfoViewModel basicInfoViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/reborn/TroopInfoCardFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcard.reborn.TroopInfoCardFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56973);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopInfoCardFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void setStatusBarImmersive() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null && ImmersiveUtils.isSupporImmersive() == 1) {
            ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNight(), qBaseActivity.getWindow());
            if (SystemBarActivityModule.getSystemBarComp(qBaseActivity) == null) {
                SystemBarActivityModule.setImmersiveStatus(qBaseActivity, 0);
                return;
            }
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarDrawable(null);
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarColor(0);
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusColor(0);
            SystemBarActivityModule.getSystemBarComp(qBaseActivity).setStatusBarDarkMode(QQTheme.isNowThemeIsNight());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        AppInterface appInterface;
        List<Part> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new TroopInfoCardTitlePart(appInterface), new TroopInfoCardCoverPart(appInterface), new TroopInfoCardBasicInfoPart(appInterface), new TroopInfoCardMedalPart(appInterface), new TroopInfoCardHOKGameDataPart(appInterface), new TroopInfoCardMDGameDataPart(appInterface), new TroopInfoCardEssenceMsgPart(appInterface), new TroopInfoCardBottomPart(appInterface));
            return mutableListOf;
        }
        return new ArrayList();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle bundle;
        AppInterface appInterface;
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (bundle = intent.getExtras()) == null) {
            bundle = new Bundle();
        }
        v a16 = v.INSTANCE.a(bundle);
        if (a16 == null) {
            QLog.e("TroopInfoCardFragment", 1, "onCreate init TroopInfoWrapper error");
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        boolean areEqual = Intrinsics.areEqual(bundle.getString("is_from_game"), "true");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return;
        }
        TroopBasicInfoViewModel troopBasicInfoViewModel = (TroopBasicInfoViewModel) getViewModel(TroopBasicInfoViewModel.class);
        this.basicInfoViewModel = troopBasicInfoViewModel;
        if (troopBasicInfoViewModel != null) {
            troopBasicInfoViewModel.O2(appInterface, a16, areEqual);
        }
        QLog.i("TroopInfoCardFragment", 1, "TroopInfoCardFragment.parseFromIntent sourceId=" + a16.g() + ", channelSourceItem=" + a16.d() + ", userFrom=" + a16.j() + ", statOption=" + a16.h() + ", isFromGame=" + areEqual + ", ");
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new TroopInfoCardFragment$onCreate$1(this, null));
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            inflate = (View) iPatchRedirector.redirect((short) 5, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            inflate = inflater.inflate(R.layout.h5v, container, false);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        AppInterface appInterface;
        TroopBasicInfoViewModel troopBasicInfoViewModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null && (troopBasicInfoViewModel = this.basicInfoViewModel) != null) {
            troopBasicInfoViewModel.T2(appInterface);
        }
        super.onDestroy();
        Context context = getContext();
        if (context != null) {
            h.a(context);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        super.onNewIntent(intent);
        PartManager partManager = this.mPartManager;
        if (partManager != null) {
            partManager.onNewIntent(intent);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onPostThemeChanged();
            setStatusBarImmersive();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle;
        TroopInfoData troopInfoData;
        v D2;
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        am.b(view);
        setStatusBarImmersive();
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (bundle = intent.getExtras()) == null) {
            bundle = new Bundle();
        }
        FragmentActivity activity2 = getActivity();
        TroopBasicInfoViewModel troopBasicInfoViewModel = this.basicInfoViewModel;
        if (troopBasicInfoViewModel != null && (D2 = troopBasicInfoViewModel.D2()) != null) {
            troopInfoData = w.d(D2);
        } else {
            troopInfoData = null;
        }
        TroopCardDtHelper.q(activity2, view, troopInfoData, bundle, true);
    }
}
