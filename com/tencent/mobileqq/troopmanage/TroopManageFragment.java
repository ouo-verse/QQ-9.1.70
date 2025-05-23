package com.tencent.mobileqq.troopmanage;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.activity.TroopNickRuleFragment;
import com.tencent.mobileqq.troop.troopsetting.modules.searchway.model.TroopSearchWay;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troopmanage.base.g;
import com.tencent.mobileqq.troopmanage.component.AddGroupSettingComponent;
import com.tencent.mobileqq.troopmanage.component.AuthorityManageComponent;
import com.tencent.mobileqq.troopmanage.component.TransferGroupComponent;
import com.tencent.mobileqq.troopmanage.component.ak;
import com.tencent.mobileqq.troopmanage.component.bv;
import com.tencent.mobileqq.troopmanage.event.TroopManageSpeechLimitEvent;
import com.tencent.mobileqq.troopmanage.event.TroopManageTroopFeedEvent;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.troopmanage.repo.h;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\"\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J&\u0010\u001e\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u0012H\u0014R*\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010!j\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/TroopManageFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "sh", "rh", "ph", "contentView", "qh", "", "troopUin", "", "uh", "th", "vh", "useQUISecNavBar", "secNavBarNeedImmersive", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "getContentLayoutId", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "mHasDeletedMembers", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "D", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "E", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopManageFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ArrayList<String> mHasDeletedMembers;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private QUIListItemAdapter adapter;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TroopManageViewModel viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/TroopManageFragment$a;", "", "", "OPERATION_SET", "I", "REQUEST_FOR_ADMIN", "REQUEST_FOR_MODIFY_JOIN_TROOP_TYPE", "REQUEST_FOR_SELECT_TROOP_ADMIN", "REQUEST_FOR_TROOP_FEED_SETTING", "REQUEST_FOR_TROOP_INFO", "REQUEST_FOR_TROOP_MEMBER", "REQUEST_FOR_TROOP_MEMBER_CARD_RULE", "REQUEST_FOR_TROOP_SPEECH_LIMIT", "REQUEST_FOR_TROOP_TRANSFER", "REQUEST_FRO_TROOP_MANAGE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troopmanage.TroopManageFragment$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62682);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopManageFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void ph() {
        QUIListItemAdapter qUIListItemAdapter;
        TroopManageViewModel troopManageViewModel = this.viewModel;
        if (troopManageViewModel == null || (qUIListItemAdapter = this.adapter) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ITroopManageApi iTroopManageApi = (ITroopManageApi) QRoute.api(ITroopManageApi.class);
        QBaseActivity qBaseActivity = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        arrayList.add(iTroopManageApi.getDataManageComponent(qBaseActivity, qUIListItemAdapter, viewLifecycleOwner, troopManageViewModel, "pg_group_set_manage"));
        QBaseActivity qBaseActivity2 = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity2, "qBaseActivity");
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        arrayList.add(new AddGroupSettingComponent(qBaseActivity2, qUIListItemAdapter, viewLifecycleOwner2, troopManageViewModel, "pg_group_set_manage").I());
        ITroopManageApi iTroopManageApi2 = (ITroopManageApi) QRoute.api(ITroopManageApi.class);
        QBaseActivity qBaseActivity3 = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity3, "qBaseActivity");
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        arrayList.add(iTroopManageApi2.getMemberManageComponent(qBaseActivity3, qUIListItemAdapter, viewLifecycleOwner3, troopManageViewModel, "pg_group_set_manage"));
        QBaseActivity qBaseActivity4 = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity4, "qBaseActivity");
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "viewLifecycleOwner");
        arrayList.add(new AuthorityManageComponent(qBaseActivity4, qUIListItemAdapter, viewLifecycleOwner4, troopManageViewModel, "pg_group_set_manage").L());
        QBaseActivity qBaseActivity5 = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity5, "qBaseActivity");
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "viewLifecycleOwner");
        arrayList.add(new ak(qBaseActivity5, qUIListItemAdapter, viewLifecycleOwner5, troopManageViewModel, "pg_group_set_manage").z());
        QBaseActivity qBaseActivity6 = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity6, "qBaseActivity");
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner6, "viewLifecycleOwner");
        arrayList.add(new TransferGroupComponent(qBaseActivity6, qUIListItemAdapter, viewLifecycleOwner6, troopManageViewModel, "pg_group_set_manage").F());
        Object[] array = arrayList.toArray(new Group[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Group[] groupArr = (Group[]) array;
        qUIListItemAdapter.t0((Group[]) Arrays.copyOf(groupArr, groupArr.length));
    }

    private final void qh(View contentView) {
        try {
            VideoReport.addToDetectionWhitelist(getQBaseActivity());
            VideoReport.setPageId(contentView, "pg_group_set_manage");
            VideoReport.setPageParams(contentView, new PageParams(bv.INSTANCE.a(this.viewModel)));
            VideoReport.setPageReportPolicy(contentView, PageReportPolicy.REPORT_ALL);
        } catch (Exception e16) {
            QLog.e("TroopManageFragment", 1, "reportDtOnCreate e: " + e16);
        }
    }

    private final void rh(View rootView) {
        View findViewById = rootView.findViewById(R.id.f102545y7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026oop_manage_recycler_view)");
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(null, false, false, 7, null);
        this.adapter = qUIListItemAdapter;
        ((QUISettingsRecyclerView) findViewById).setAdapter(qUIListItemAdapter);
    }

    private final void sh(View rootView) {
        rh(rootView);
        ph();
    }

    private final boolean th() {
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean uh(String troopUin) {
        Long longOrNull;
        long longValue;
        if (TextUtils.isEmpty(troopUin)) {
            return false;
        }
        if (troopUin != null) {
            try {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
            } catch (Throwable th5) {
                QLog.e("TroopManageFragment", 1, "troopUin.toLongOrNull() e: " + th5);
            }
            if (longOrNull != null) {
                longValue = longOrNull.longValue();
                if (longValue <= 0) {
                    return false;
                }
                return true;
            }
        }
        longValue = 0;
        if (longValue <= 0) {
        }
        return true;
    }

    private final boolean vh() {
        return requireArguments().getBoolean("from_multi_troop_manage_tab", false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, inflater, container, savedInstanceState);
            return;
        }
        super.doOnCreateView(inflater, container, savedInstanceState);
        if (vh()) {
            QUISecNavBar qUISecNavBar = this.quiSecNavBar;
            if (qUISecNavBar != null) {
                qUISecNavBar.setVisibility(8);
            }
        } else {
            requireArguments().putInt(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, 2);
            requireArguments().putInt("page_status", 3);
            setTitle(getString(R.string.i7o));
        }
        String string = requireArguments().getString("troop_uin");
        if (th() && uh(string)) {
            h hVar = h.f303236a;
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            TroopManageViewModel troopManageViewModel = (TroopManageViewModel) hVar.c(string, requireActivity).get(TroopManageViewModel.class);
            this.viewModel = troopManageViewModel;
            if (troopManageViewModel != null) {
                Bundle requireArguments = requireArguments();
                Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
                troopManageViewModel.L1(requireArguments);
            }
            View mContentView = ((QIphoneTitleBarFragment) this).mContentView;
            if (mContentView != null) {
                Intrinsics.checkNotNullExpressionValue(mContentView, "mContentView");
                sh(mContentView);
                View mContentView2 = ((QIphoneTitleBarFragment) this).mContentView;
                Intrinsics.checkNotNullExpressionValue(mContentView2, "mContentView");
                qh(mContentView2);
            }
            SimpleEventBus.getInstance().registerReceiver(this.viewModel);
            return;
        }
        getQBaseActivity().finish();
        QLog.e("TroopManageFragment", 1, "doOnCreateView trooopUin invalid, troopUin = " + string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return R.layout.g0t;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Bundle extras;
        Bundle extras2;
        TroopManageViewModel troopManageViewModel;
        TroopManageViewModel troopManageViewModel2;
        TroopManageViewModel troopManageViewModel3;
        TroopManageViewModel troopManageViewModel4;
        TroopManageViewModel troopManageViewModel5;
        String str;
        boolean z16;
        com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.b Z1;
        com.tencent.mobileqq.troopmanage.repo.a X1;
        com.tencent.mobileqq.troopmanage.repo.b m3;
        TroopManageViewModel troopManageViewModel6;
        String str2;
        String string;
        TroopManageViewModel troopManageViewModel7;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        if (getQBaseActivity() == null) {
            QLog.e("TroopManageFragment", 1, "onActivityResult activity invalid, ignore.");
            return;
        }
        if (requestCode != 1) {
            if (requestCode != 2) {
                if (requestCode != 4) {
                    if (requestCode != 19) {
                        if (requestCode != 24) {
                            if (requestCode != 32) {
                                if (requestCode != 21) {
                                    if (requestCode != 22) {
                                        if (requestCode != 26) {
                                            if (requestCode == 27 && data != null && resultCode == -1 && (troopManageViewModel7 = this.viewModel) != null) {
                                                com.tencent.mobileqq.troopmanage.repo.b m16 = troopManageViewModel7.X1().m();
                                                m16.i().troopFeedTalkPermission = data.getIntExtra(ITroopUtilsApi.TROOP_MANAGE_GUILD_FEED_PERMISSION, -1);
                                                m16.i().troopFeedSwitch = data.getBooleanExtra(ITroopUtilsApi.TROOP_MANAGE_GUILD_FEED_SWITCH, true);
                                                troopManageViewModel7.f2().postValue(new TroopManageTroopFeedEvent(m16.i().troopFeedSwitch, m16.i().troopFeedTalkPermission));
                                                return;
                                            }
                                            return;
                                        }
                                        if (data != null && resultCode == -1 && (troopManageViewModel6 = this.viewModel) != null) {
                                            com.tencent.mobileqq.troopmanage.repo.b m17 = troopManageViewModel6.X1().m();
                                            TroopInfo h16 = m17.h();
                                            if (data.getStringExtra(TroopNickRuleFragment.R) != null) {
                                                str2 = data.getStringExtra(TroopNickRuleFragment.R);
                                            } else {
                                                str2 = "";
                                            }
                                            h16.groupCardPrefixIntro = str2;
                                            if (data.getStringArrayListExtra(TroopNickRuleFragment.S) != null) {
                                                m17.h().groupCardPrefix = data.getStringArrayListExtra(TroopNickRuleFragment.S);
                                            }
                                            if (TextUtils.isEmpty(m17.h().groupCardPrefixIntro) && m17.h().groupCardPrefix.isEmpty()) {
                                                string = getQBaseActivity().getString(R.string.eqt);
                                            } else {
                                                string = getQBaseActivity().getString(R.string.f180883c_);
                                            }
                                            Intrinsics.checkNotNullExpressionValue(string, "if (TextUtils.isEmpty(tr\u2026                        }");
                                            troopManageViewModel6.h2().postValue(string);
                                            return;
                                        }
                                        return;
                                    }
                                    if (data != null && resultCode == -1) {
                                        String stringExtra = data.getStringExtra("bundle_key_new_search_way");
                                        TroopManageViewModel troopManageViewModel8 = this.viewModel;
                                        if (troopManageViewModel8 != null && (X1 = troopManageViewModel8.X1()) != null && (m3 = X1.m()) != null) {
                                            str = m3.j();
                                        } else {
                                            str = null;
                                        }
                                        if (stringExtra != null && stringExtra.length() != 0) {
                                            z16 = false;
                                        } else {
                                            z16 = true;
                                        }
                                        if (!z16) {
                                            if (str == null || str.length() == 0) {
                                                i3 = 1;
                                            }
                                            if (i3 == 0) {
                                                TroopSearchWay valueOf = TroopSearchWay.valueOf(stringExtra);
                                                TroopManageViewModel troopManageViewModel9 = this.viewModel;
                                                if (troopManageViewModel9 != null && (Z1 = troopManageViewModel9.Z1()) != null) {
                                                    Z1.c(str, valueOf);
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                if (data != null && resultCode == -1) {
                                    boolean booleanExtra = data.getBooleanExtra(AppConstants.Key.IS_NEED_FINISH, false);
                                    String stringExtra2 = data.getStringExtra(AppConstants.Key.FIN_TIP_MSG);
                                    String stringExtra3 = data.getStringExtra("uin");
                                    if (booleanExtra) {
                                        Intent intent = new Intent();
                                        intent.putExtra(AppConstants.Key.FIN_TIP_MSG, stringExtra2);
                                        intent.putExtra("uin", stringExtra3);
                                        getQBaseActivity().setResult(resultCode, intent);
                                        getQBaseActivity().finish();
                                        return;
                                    }
                                    if (stringExtra2 != null && !TextUtils.isEmpty(stringExtra2)) {
                                        g.f303036a.c(stringExtra2);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            if (data != null && resultCode == -1 && (troopManageViewModel5 = this.viewModel) != null) {
                                String stringExtra4 = data.getStringExtra("troop_uin");
                                String str3 = "0";
                                if (stringExtra4 == null) {
                                    stringExtra4 = "0";
                                }
                                Intrinsics.checkNotNullExpressionValue(stringExtra4, "data.getStringExtra(Troo\u2026s.PARAM_TROOP_UIN) ?: \"0\"");
                                String stringExtra5 = data.getStringExtra("member_uin");
                                if (stringExtra5 != null) {
                                    str3 = stringExtra5;
                                }
                                Intrinsics.checkNotNullExpressionValue(str3, "data.getStringExtra(Troo\u2026.PARAM_MEMBER_UIN) ?: \"0\"");
                                troopManageViewModel5.X1().r((byte) 1, stringExtra4, str3);
                                return;
                            }
                            return;
                        }
                        if (data != null && resultCode == -1) {
                            SimpleEventBus.getInstance().dispatchEvent(new TroopManageSpeechLimitEvent(data.getIntExtra(AppConstants.Key.LIMIT_FREQ, -1)));
                            return;
                        }
                        return;
                    }
                    if (data != null && resultCode == -1 && (troopManageViewModel4 = this.viewModel) != null) {
                        com.tencent.mobileqq.troopmanage.repo.b m18 = troopManageViewModel4.X1().m();
                        troopManageViewModel4.X1().h(data.getBooleanExtra("isCanSearchByTroopUin", m18.h().mCanSearchByTroopUin), data.getBooleanExtra("isCanSearchByKeywords", m18.h().mCanSearchByKeywords), data.getBooleanExtra("onlyInvite", false), data.getIntExtra("cGroupOption", m18.h().cGroupOption), data.getBooleanExtra("isSetFee", false), data.getBooleanExtra("isSetSuccess", false));
                        return;
                    }
                    return;
                }
                if (resultCode == -1 && (troopManageViewModel3 = this.viewModel) != null) {
                    troopManageViewModel3.X1().d();
                    return;
                }
                return;
            }
            if (data == null || resultCode != -1 || (extras2 = data.getExtras()) == null) {
                return;
            }
            TroopManageViewModel troopManageViewModel10 = this.viewModel;
            if (troopManageViewModel10 != null) {
                i3 = troopManageViewModel10.N1();
            }
            ArrayList<String> stringArrayList = extras2.getStringArrayList("deleted_members");
            if (stringArrayList != null) {
                ArrayList<String> arrayList = this.mHasDeletedMembers;
                if (arrayList == null) {
                    this.mHasDeletedMembers = stringArrayList;
                } else if (arrayList != null) {
                    arrayList.addAll(stringArrayList);
                }
            }
            Intent intent2 = new Intent();
            intent2.putExtra("param_admins", extras2.getStringArrayList("param_admins"));
            intent2.putExtra("deleted_members", this.mHasDeletedMembers);
            getQBaseActivity().setResult(-1, intent2);
            if (i3 != extras2.getInt("param_admins_count") && (troopManageViewModel2 = this.viewModel) != null) {
                troopManageViewModel2.X1().t(i3);
            }
            ArrayList<String> stringArrayList2 = extras2.getStringArrayList("param_admins");
            if (stringArrayList2 != null && (troopManageViewModel = this.viewModel) != null) {
                troopManageViewModel.X1().g(stringArrayList2);
                return;
            }
            return;
        }
        if (data == null || resultCode != -1 || (extras = data.getExtras()) == null) {
            return;
        }
        Intent intent3 = new Intent();
        if (extras.getBoolean(AppConstants.Key.IS_NEED_FINISH)) {
            intent3.putExtra(AppConstants.Key.IS_NEED_FINISH, true);
            getQBaseActivity().setResult(-1, intent3);
            getQBaseActivity().finish();
        } else if (extras.getBoolean("finish_chat_setting")) {
            intent3.putExtra("finish_chat_setting", true);
            getQBaseActivity().setResult(-1, intent3);
            getQBaseActivity().finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this.viewModel);
        TroopManageViewModel troopManageViewModel = this.viewModel;
        if (troopManageViewModel != null) {
            troopManageViewModel.M1();
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("troop_uin");
        } else {
            str = null;
        }
        h.f303236a.d(str);
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean secNavBarNeedImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return !vh();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }
}
