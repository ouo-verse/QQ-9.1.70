package com.tencent.mobileqq.troopmanage.multigroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troopmanage.TroopManageFragment;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ,2\u00020\u0001:\u0002-.B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000e0\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0014J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\"\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\u001a\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010!\u001a\u00020\u0013H\u0016R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/multigroup/TroopManageTabFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/view/View;", "view", "", "initViews", "", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "rh", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "tabBar", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "sh", "", "btnType", "", "", "qh", "", "useQUISecNavBar", "getContentLayoutId", "isWrapContent", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "needImmersive", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "mViewModel", "Lcom/tencent/mobileqq/troopmanage/multigroup/TroopManageTabFragment$b;", "D", "Lcom/tencent/mobileqq/troopmanage/multigroup/TroopManageTabFragment$b;", "mAdapter", "<init>", "()V", "E", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopManageTabFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TroopManageViewModel mViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private b mAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/multigroup/TroopManageTabFragment$a;", "", "", "FROM_MULTI_TROOP_MANAGE_TAB", "Ljava/lang/String;", "", "MULTI_GROUP_MANAGE_TAB_INDEX", "I", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troopmanage.multigroup.TroopManageTabFragment$a, reason: from kotlin metadata */
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/multigroup/TroopManageTabFragment$b;", "Landroidx/fragment/app/FragmentPagerAdapter;", "", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "d", "data", "", "setData", "", "position", "Landroidx/fragment/app/Fragment;", "getItem", "getCount", "", "Ljava/util/List;", "mData", "Landroidx/fragment/app/FragmentManager;", "fm", "<init>", "(Landroidx/fragment/app/FragmentManager;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends FragmentPagerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<QPublicBaseFragment> mData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull FragmentManager fm5) {
            super(fm5);
            Intrinsics.checkNotNullParameter(fm5, "fm");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) fm5);
            } else {
                this.mData = new ArrayList();
            }
        }

        @NotNull
        public final List<QPublicBaseFragment> d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.mData;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.mData.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        @NotNull
        public Fragment getItem(int position) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Fragment) iPatchRedirector.redirect((short) 4, (Object) this, position);
            }
            return this.mData.get(position);
        }

        public final void setData(@NotNull List<? extends QPublicBaseFragment> data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            this.mData.clear();
            this.mData.addAll(data);
            notifyDataSetChanged();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62980);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopManageTabFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void initViews(View view) {
        setTitle(getString(R.string.i7o));
        View findViewById = view.findViewById(R.id.zjh);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.multi_troop_page_tab_bar)");
        QUIPageTabBar qUIPageTabBar = (QUIPageTabBar) findViewById;
        View findViewById2 = view.findViewById(R.id.zji);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.multi_troop_pager)");
        ViewPager viewPager = (ViewPager) findViewById2;
        qUIPageTabBar.setTabData(new String[]{getString(R.string.f235027aj), getString(R.string.f235017ai)});
        FragmentManager requireFragmentManager = requireFragmentManager();
        Intrinsics.checkNotNullExpressionValue(requireFragmentManager, "requireFragmentManager()");
        b bVar = new b(requireFragmentManager);
        this.mAdapter = bVar;
        bVar.setData(rh());
        viewPager.setAdapter(this.mAdapter);
        qUIPageTabBar.setViewPager(viewPager);
        final TroopManageViewModel troopManageViewModel = this.mViewModel;
        if (troopManageViewModel == null) {
            return;
        }
        qUIPageTabBar.setTabChangeListener(new QUIPageTabBar.i() { // from class: com.tencent.mobileqq.troopmanage.multigroup.a
            @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
            public final void I0(int i3, boolean z16) {
                TroopManageTabFragment.th(TroopManageTabFragment.this, troopManageViewModel, i3, z16);
            }
        });
        sh(qUIPageTabBar, viewPager);
        com.tencent.mobileqq.troopmanage.report.a aVar = com.tencent.mobileqq.troopmanage.report.a.f303239a;
        aVar.c("pg_group_set_manage", "em_group_manage_switch", qh(1), troopManageViewModel);
        aVar.c("pg_group_set_manage", "em_group_manage_switch", qh(2), troopManageViewModel);
    }

    private final Map<String, Integer> qh(int btnType) {
        HashMap hashMap = new HashMap();
        hashMap.put("btn_type", Integer.valueOf(btnType));
        return hashMap;
    }

    private final List<QPublicBaseFragment> rh() {
        ArrayList arrayList = new ArrayList();
        TroopManageFragment troopManageFragment = new TroopManageFragment();
        troopManageFragment.setArguments(requireArguments());
        arrayList.add(troopManageFragment);
        TroopMultiGroupManageFragment troopMultiGroupManageFragment = new TroopMultiGroupManageFragment();
        troopMultiGroupManageFragment.setArguments(requireArguments());
        arrayList.add(troopMultiGroupManageFragment);
        return arrayList;
    }

    private final void sh(QUIPageTabBar tabBar, ViewPager viewPager) {
        Bundle arguments = getArguments();
        boolean z16 = false;
        if (arguments != null) {
            z16 = arguments.getBoolean("is_from_app_item_clk", false);
        }
        if (z16) {
            tabBar.setCurrentPosition(1);
            viewPager.setCurrentItem(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(TroopManageTabFragment this$0, TroopManageViewModel viewModel, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(viewModel, "$viewModel");
        com.tencent.mobileqq.troopmanage.report.a.f303239a.a("pg_group_set_manage", "em_group_manage_switch", this$0.qh(i3 + 1), viewModel);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.g1b;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
        b bVar = this.mAdapter;
        if (bVar == null) {
            return;
        }
        Iterator<T> it = bVar.d().iterator();
        while (it.hasNext()) {
            ((QPublicBaseFragment) it.next()).onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        requireArguments().putBoolean("from_multi_troop_manage_tab", true);
        requireArguments().putInt(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, 2);
        requireArguments().putInt("page_status", 2);
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("troop_uin");
        } else {
            str = null;
        }
        com.tencent.mobileqq.troopmanage.repo.h hVar = com.tencent.mobileqq.troopmanage.repo.h.f303236a;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        TroopManageViewModel troopManageViewModel = (TroopManageViewModel) hVar.c(str, requireActivity).get(TroopManageViewModel.class);
        this.mViewModel = troopManageViewModel;
        if (troopManageViewModel != null) {
            Bundle requireArguments = requireArguments();
            Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
            troopManageViewModel.L1(requireArguments);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        TroopManageViewModel troopManageViewModel = this.mViewModel;
        if (troopManageViewModel != null) {
            troopManageViewModel.M1();
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
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
