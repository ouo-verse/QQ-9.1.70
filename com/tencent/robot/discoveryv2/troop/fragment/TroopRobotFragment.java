package com.tencent.robot.discoveryv2.troop.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.robot.discoveryv2.common.recommend.content.RecommendContentPart;
import com.tencent.robot.discoveryv2.common.repository.core.RobotRepositoryPart;
import com.tencent.robot.discoveryv2.common.reserve.ReservePart;
import com.tencent.robot.discoveryv2.common.search.RobotSearchEntryPart;
import com.tencent.robot.discoveryv2.troop.added.TroopRobotAddedPart;
import com.tencent.robot.discoveryv2.troop.repository.TroopRobotRepositoryDelegate;
import com.tencent.robot.troop.discovery.TroopRobotDiscoveryLaunchArgs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r34.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u000f\u001a\u00020\nH\u0016J&\u0010\u0016\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\u001c\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014J\u001a\u0010\u0019\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0014J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016R\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/robot/discoveryv2/troop/fragment/TroopRobotFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "rh", "initSoftInputMode", "qh", "sh", "Landroid/view/View;", "view", "ph", "", "useQUISecNavBar", "needImmersive", "", "getContentLayoutId", "isWrapContent", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "contentView", "onViewCreatedBeforePartInit", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onFragmentViewDestroyed", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "Lr34/a;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "globalIocList", "<init>", "()V", "D", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopRobotFragment extends QIphoneTitleBarFragment {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private List<? extends a> globalIocList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/robot/discoveryv2/troop/fragment/TroopRobotFragment$a;", "", "Lcom/tencent/robot/troop/discovery/a;", "launchArgs", "", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.discoveryv2.troop.fragment.TroopRobotFragment$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull TroopRobotDiscoveryLaunchArgs launchArgs) {
            boolean z16;
            Intrinsics.checkNotNullParameter(launchArgs, "launchArgs");
            if (launchArgs.getContext() != null) {
                String troopUin = launchArgs.getTroopUin();
                if (troopUin != null && troopUin.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    Intent intent = new Intent();
                    intent.putExtra("param_uin", launchArgs.getTroopUin());
                    intent.putExtra("param_launch_source_type", launchArgs.getLaunchSourceType().getValue());
                    QPublicFragmentActivity.start(launchArgs.getContext(), intent, TroopRobotFragment.class);
                    return;
                }
            }
            QLog.e("IphoneTitleBarFragment", 1, "launcher args error! return.");
        }

        Companion() {
        }
    }

    private final void initSoftInputMode() {
        Window window;
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(34);
        }
    }

    private final void ph(View view) {
        Intent intent;
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(view, "pg_group_swarm_obot_recommendation");
        FragmentActivity activity = getActivity();
        int i3 = 0;
        if (activity != null && (intent = activity.getIntent()) != null) {
            i3 = intent.getIntExtra("param_launch_source_type", 0);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(IFileBrowserService.FILE_BROWSER_PAGE_FROM, Integer.valueOf(i3));
        VideoReport.setPageParams(view, new PageParams(hashMap));
        VideoReport.setPageContentId(view, String.valueOf(SystemClock.elapsedRealtime()), true);
        VideoReport.setPageReportPolicy(view, PageReportPolicy.REPORT_ALL);
    }

    private final void qh() {
        List<? extends a> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        List<? extends a> list = emptyList;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(((QIphoneTitleBarFragment) this).mContentView);
        }
        this.globalIocList = list;
    }

    private final void rh() {
        setTitle(requireActivity().getResources().getString(R.string.i8v));
    }

    private final void sh() {
        List<? extends a> list = this.globalIocList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("globalIocList");
            list = null;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(((QIphoneTitleBarFragment) this).mContentView);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new ReservePart(), new RobotSearchEntryPart(), new TroopRobotAddedPart(), new RecommendContentPart(), new RobotRepositoryPart(new TroopRobotRepositoryDelegate()));
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        rh();
        initSoftInputMode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g1l;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onFragmentViewDestroyed() {
        super.onFragmentViewDestroyed();
        sh();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ph(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@Nullable View contentView, @Nullable Bundle savedInstanceState) {
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        qh();
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        return true;
    }
}
