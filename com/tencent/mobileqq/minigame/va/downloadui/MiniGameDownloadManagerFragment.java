package com.tencent.mobileqq.minigame.va.downloadui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager.widget.ViewPager;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.mini.databinding.MiniGameDownloadManagerBinding;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadDataWrapper;
import com.tencent.mobileqq.util.cu;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0013\u0018\u0000 82\u00020\u0001:\u00018B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020\u001fH\u0016J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u001fH\u0016J\u0010\u0010/\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020-H\u0002J\u001a\u00100\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020\u001fH\u0002J\b\u00105\u001a\u00020\u001fH\u0002J\b\u00106\u001a\u00020\u001fH\u0002J\b\u00107\u001a\u00020\u001fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001b\u0010\u001c\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameDownloadManagerFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "()V", "binding", "Lcom/tencent/mobileqq/mini/databinding/MiniGameDownloadManagerBinding;", "downloadedFragment", "Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameVADownloadedFragment;", "getDownloadedFragment", "()Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameVADownloadedFragment;", "downloadedFragment$delegate", "Lkotlin/Lazy;", "downloadingFragment", "Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameVADownloadingFragment;", "getDownloadingFragment", "()Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameVADownloadingFragment;", "downloadingFragment$delegate", "isSetGestureLayout", "", "managerListener", "com/tencent/mobileqq/minigame/va/downloadui/MiniGameDownloadManagerFragment$managerListener$1", "Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameDownloadManagerFragment$managerListener$1;", "pagerAdapter", "Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameDownloadPagerAdapter;", "topGestureLayout", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "viewModel", "Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameVADownloadViewModel;", "getViewModel", "()Lcom/tencent/mobileqq/minigame/va/downloadui/MiniGameVADownloadViewModel;", "viewModel$delegate", "init", "", "initDownloadingCount", "initViewPager", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onSelected", "view", "Landroid/widget/TextView;", "onStart", "onUnSelected", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "setDownloadingCount", "count", "", "setGestureLayout", "toDownloadedPage", "toDownloadingPage", "toPage", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameDownloadManagerFragment extends QPublicBaseFragment {
    public static final int DOWNLOADED_POSITION = 1;
    public static final int DOWNLOADING_POSITION = 0;
    public static final String DOWNLOAD_TAB_KEY = "tab";
    private MiniGameDownloadManagerBinding binding;

    /* renamed from: downloadedFragment$delegate, reason: from kotlin metadata */
    private final Lazy downloadedFragment;

    /* renamed from: downloadingFragment$delegate, reason: from kotlin metadata */
    private final Lazy downloadingFragment;
    private boolean isSetGestureLayout;
    private final MiniGameDownloadManagerFragment$managerListener$1 managerListener;
    private MiniGameDownloadPagerAdapter pagerAdapter;
    private TopGestureLayout topGestureLayout;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public MiniGameDownloadManagerFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MiniGameVADownloadedFragment>() { // from class: com.tencent.mobileqq.minigame.va.downloadui.MiniGameDownloadManagerFragment$downloadedFragment$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniGameVADownloadedFragment invoke() {
                return new MiniGameVADownloadedFragment();
            }
        });
        this.downloadedFragment = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MiniGameVADownloadingFragment>() { // from class: com.tencent.mobileqq.minigame.va.downloadui.MiniGameDownloadManagerFragment$downloadingFragment$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniGameVADownloadingFragment invoke() {
                return new MiniGameVADownloadingFragment();
            }
        });
        this.downloadingFragment = lazy2;
        this.managerListener = new MiniGameDownloadManagerFragment$managerListener$1(this);
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<MiniGameVADownloadViewModel>() { // from class: com.tencent.mobileqq.minigame.va.downloadui.MiniGameDownloadManagerFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MiniGameVADownloadViewModel invoke() {
                ViewModel viewModel = com.tencent.mobileqq.mvvm.h.a(MiniGameDownloadManagerFragment.this.getQBaseActivity()).get(MiniGameVADownloadViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(qBas\u2026oadViewModel::class.java)");
                return (MiniGameVADownloadViewModel) viewModel;
            }
        });
        this.viewModel = lazy3;
    }

    private final MiniGameVADownloadedFragment getDownloadedFragment() {
        return (MiniGameVADownloadedFragment) this.downloadedFragment.getValue();
    }

    private final MiniGameVADownloadingFragment getDownloadingFragment() {
        return (MiniGameVADownloadingFragment) this.downloadingFragment.getValue();
    }

    private final void init() {
        MiniGameDownloadManagerBinding miniGameDownloadManagerBinding = this.binding;
        if (miniGameDownloadManagerBinding == null) {
            return;
        }
        miniGameDownloadManagerBinding.back.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.va.downloadui.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameDownloadManagerFragment.init$lambda$0(MiniGameDownloadManagerFragment.this, view);
            }
        });
        miniGameDownloadManagerBinding.downloading.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.va.downloadui.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameDownloadManagerFragment.init$lambda$1(MiniGameDownloadManagerFragment.this, view);
            }
        });
        miniGameDownloadManagerBinding.downloaded.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.minigame.va.downloadui.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MiniGameDownloadManagerFragment.init$lambda$2(MiniGameDownloadManagerFragment.this, view);
            }
        });
        initViewPager();
        toPage();
        initDownloadingCount();
        getViewModel().queryDownloadData();
        getViewModel().getCurChangePayloadData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.minigame.va.downloadui.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MiniGameDownloadManagerFragment.init$lambda$3(MiniGameDownloadManagerFragment.this, (MiniGameDownloadDataWrapper) obj);
            }
        });
        MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "929236", "8", "", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$0(MiniGameDownloadManagerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$1(MiniGameDownloadManagerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.toDownloadingPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$2(MiniGameDownloadManagerFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.toDownloadedPage();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$3(MiniGameDownloadManagerFragment this$0, MiniGameDownloadDataWrapper miniGameDownloadDataWrapper) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (miniGameDownloadDataWrapper.getDownloadStatus() == 9) {
            this$0.toDownloadedPage();
        }
    }

    private final void initDownloadingCount() {
        getViewModel().getDownloadingDatas().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.minigame.va.downloadui.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MiniGameDownloadManagerFragment.initDownloadingCount$lambda$6(MiniGameDownloadManagerFragment.this, (List) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDownloadingCount$lambda$6(MiniGameDownloadManagerFragment this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setDownloadingCount(list.size());
    }

    private final void initViewPager() {
        ViewPager viewPager;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        MiniGameDownloadPagerAdapter miniGameDownloadPagerAdapter = new MiniGameDownloadPagerAdapter(childFragmentManager);
        this.pagerAdapter = miniGameDownloadPagerAdapter;
        miniGameDownloadPagerAdapter.addFragment(getDownloadingFragment());
        MiniGameDownloadPagerAdapter miniGameDownloadPagerAdapter2 = this.pagerAdapter;
        if (miniGameDownloadPagerAdapter2 != null) {
            miniGameDownloadPagerAdapter2.addFragment(getDownloadedFragment());
        }
        MiniGameDownloadManagerBinding miniGameDownloadManagerBinding = this.binding;
        if (miniGameDownloadManagerBinding == null || (viewPager = miniGameDownloadManagerBinding.downloadContent) == null) {
            return;
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.tencent.mobileqq.minigame.va.downloadui.MiniGameDownloadManagerFragment$initViewPager$1$1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int position) {
                MiniGameDownloadManagerBinding miniGameDownloadManagerBinding2;
                TopGestureLayout topGestureLayout;
                TopGestureLayout topGestureLayout2;
                miniGameDownloadManagerBinding2 = MiniGameDownloadManagerFragment.this.binding;
                if (miniGameDownloadManagerBinding2 != null) {
                    MiniGameDownloadManagerFragment miniGameDownloadManagerFragment = MiniGameDownloadManagerFragment.this;
                    if (position != 0) {
                        topGestureLayout = miniGameDownloadManagerFragment.topGestureLayout;
                        if (topGestureLayout != null) {
                            topGestureLayout.setInterceptTouchFlag(false);
                        }
                        TextView textView = miniGameDownloadManagerBinding2.downloaded;
                        Intrinsics.checkNotNullExpressionValue(textView, "it.downloaded");
                        miniGameDownloadManagerFragment.onSelected(textView);
                        TextView textView2 = miniGameDownloadManagerBinding2.downloading;
                        Intrinsics.checkNotNullExpressionValue(textView2, "it.downloading");
                        miniGameDownloadManagerFragment.onUnSelected(textView2);
                        return;
                    }
                    TextView textView3 = miniGameDownloadManagerBinding2.downloading;
                    Intrinsics.checkNotNullExpressionValue(textView3, "it.downloading");
                    miniGameDownloadManagerFragment.onSelected(textView3);
                    TextView textView4 = miniGameDownloadManagerBinding2.downloaded;
                    Intrinsics.checkNotNullExpressionValue(textView4, "it.downloaded");
                    miniGameDownloadManagerFragment.onUnSelected(textView4);
                    topGestureLayout2 = miniGameDownloadManagerFragment.topGestureLayout;
                    if (topGestureLayout2 != null) {
                        topGestureLayout2.setInterceptTouchFlag(true);
                    }
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int p06) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int p06, float p16, int p26) {
            }
        });
        viewPager.setAdapter(this.pagerAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSelected(TextView view) {
        view.setTextColor(getResources().getColor(R.color.f88987));
        view.setBackgroundResource(R.drawable.iow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$4(MiniGameDownloadManagerFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setGestureLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onUnSelected(TextView view) {
        view.setTextColor(getResources().getColor(R.color.f89088));
        view.setBackgroundResource(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDownloadingCount(int count) {
        MiniGameDownloadManagerBinding miniGameDownloadManagerBinding = this.binding;
        if (miniGameDownloadManagerBinding == null) {
            return;
        }
        if (count == 0) {
            miniGameDownloadManagerBinding.downloadingCount.setVisibility(4);
        } else {
            miniGameDownloadManagerBinding.downloadingCount.setVisibility(0);
            miniGameDownloadManagerBinding.downloadingCount.setText(String.valueOf(count));
        }
    }

    private final void setGestureLayout() {
        TopGestureLayout topGestureLayout;
        ViewPager viewPager;
        Window window;
        if (this.isSetGestureLayout) {
            return;
        }
        this.isSetGestureLayout = true;
        FragmentActivity activity = getActivity();
        View decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
        ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (viewGroup == null) {
            return;
        }
        View childAt = viewGroup.getChildAt(0);
        TopGestureLayout topGestureLayout2 = childAt instanceof TopGestureLayout ? (TopGestureLayout) childAt : null;
        if (topGestureLayout2 == null) {
            return;
        }
        this.topGestureLayout = topGestureLayout2;
        MiniGameDownloadManagerBinding miniGameDownloadManagerBinding = this.binding;
        if (!((miniGameDownloadManagerBinding == null || (viewPager = miniGameDownloadManagerBinding.downloadContent) == null || viewPager.getCurrentItem() != 1) ? false : true) || (topGestureLayout = this.topGestureLayout) == null) {
            return;
        }
        topGestureLayout.setInterceptTouchFlag(false);
    }

    private final void toDownloadedPage() {
        MiniGameDownloadManagerBinding miniGameDownloadManagerBinding = this.binding;
        ViewPager viewPager = miniGameDownloadManagerBinding != null ? miniGameDownloadManagerBinding.downloadContent : null;
        if (viewPager == null) {
            return;
        }
        viewPager.setCurrentItem(1);
    }

    private final void toDownloadingPage() {
        MiniGameDownloadManagerBinding miniGameDownloadManagerBinding = this.binding;
        ViewPager viewPager = miniGameDownloadManagerBinding != null ? miniGameDownloadManagerBinding.downloadContent : null;
        if (viewPager == null) {
            return;
        }
        viewPager.setCurrentItem(0);
    }

    private final void toPage() {
        Intent intent;
        FragmentActivity activity = getActivity();
        Integer valueOf = (activity == null || (intent = activity.getIntent()) == null) ? null : Integer.valueOf(intent.getIntExtra("tab", -1));
        if (valueOf != null && valueOf.intValue() == 0) {
            MiniGameDownloadManagerBinding miniGameDownloadManagerBinding = this.binding;
            if (miniGameDownloadManagerBinding != null) {
                TextView textView = miniGameDownloadManagerBinding.downloading;
                Intrinsics.checkNotNullExpressionValue(textView, "it.downloading");
                onSelected(textView);
                TextView textView2 = miniGameDownloadManagerBinding.downloaded;
                Intrinsics.checkNotNullExpressionValue(textView2, "it.downloaded");
                onUnSelected(textView2);
                return;
            }
            return;
        }
        if (valueOf != null && valueOf.intValue() == 1) {
            toDownloadedPage();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        MiniGameDownloadManagerBinding inflate = MiniGameDownloadManagerBinding.inflate(inflater, container, false);
        this.binding = inflate;
        if (inflate != null) {
            return inflate.getRoot();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.minigame.va.downloadui.a
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameDownloadManagerFragment.onStart$lambda$4(MiniGameDownloadManagerFragment.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (!cu.g() && !cu.f()) {
            requireActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
        } else {
            ImmersiveUtils.setStatusBarDarkMode(requireActivity().getWindow(), true);
        }
        init();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.binding = null;
        super.onDestroy();
    }

    private final MiniGameVADownloadViewModel getViewModel() {
        return (MiniGameVADownloadViewModel) this.viewModel.getValue();
    }
}
