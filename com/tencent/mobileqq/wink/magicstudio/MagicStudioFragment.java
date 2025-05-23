package com.tencent.mobileqq.wink.magicstudio;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.api.IFSQQBaseService;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioFragment$pagerAdapter$2;
import com.tencent.mobileqq.wink.pager.FragmentPager;
import com.tencent.mobileqq.wink.report.WinkHomeReportHelper;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 K2\u00020\u0001:\u0001LB\u0007\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0014J\b\u0010\u001e\u001a\u00020\nH\u0014J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016J\"\u0010'\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(H\u0016R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R+\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u000501j\b\u0012\u0004\u0012\u00020\u0005`28BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u0010-\u001a\u0004\b4\u00105R\u001b\u0010;\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b8\u0010-\u001a\u0004\b9\u0010:R\u001b\u0010>\u001a\u0002078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010-\u001a\u0004\b=\u0010:R\u001b\u0010C\u001a\u00020?8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010-\u001a\u0004\bA\u0010BR\u001b\u0010H\u001a\u00020D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010-\u001a\u0004\bF\u0010G\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioFragment;", "Lcom/tencent/mobileqq/wink/magicstudio/WinkMagicStudioBaseFragment;", "", "initView", "yh", "", "action", "Ch", "target", "Dh", "", "onBackEvent", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "contentView", "onViewCreatedAfterPartInit", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getStatusBarColor", "isUseDarkTextStatusBar", "xc", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$b;", "callback", "P6", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Landroid/content/Context;", "context", "onAttach", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "wh", "()Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "tab", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "D", "xh", "()Ljava/util/ArrayList;", "tabTitles", "Landroid/widget/ImageView;", "E", "sh", "()Landroid/widget/ImageView;", "close", UserInfo.SEX_FEMALE, "th", "license", "Landroidx/viewpager2/widget/ViewPager2;", "G", "uh", "()Landroidx/viewpager2/widget/ViewPager2;", "pager", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "H", "vh", "()Landroidx/viewpager2/adapter/FragmentStateAdapter;", "pagerAdapter", "<init>", "()V", "I", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicStudioFragment extends WinkMagicStudioBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy tab;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy tabTitles;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy close;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy license;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy pager;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy pagerAdapter;

    public MagicStudioFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        Lazy lazy6;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QUIPageTabBar>() { // from class: com.tencent.mobileqq.wink.magicstudio.MagicStudioFragment$tab$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QUIPageTabBar invoke() {
                return (QUIPageTabBar) MagicStudioFragment.this.requireView().findViewById(R.id.f99655qd);
            }
        });
        this.tab = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ArrayList<String>>() { // from class: com.tencent.mobileqq.wink.magicstudio.MagicStudioFragment$tabTitles$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ArrayList<String> invoke() {
                ArrayList<String> arrayListOf;
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(MagicStudioFragment.this.getString(R.string.f170136yn0));
                return arrayListOf;
            }
        });
        this.tabTitles = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.magicstudio.MagicStudioFragment$close$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) MagicStudioFragment.this.requireView().findViewById(R.id.close);
            }
        });
        this.close = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<ImageView>() { // from class: com.tencent.mobileqq.wink.magicstudio.MagicStudioFragment$license$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ImageView invoke() {
                return (ImageView) MagicStudioFragment.this.requireView().findViewById(R.id.yhx);
            }
        });
        this.license = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(new Function0<ViewPager2>() { // from class: com.tencent.mobileqq.wink.magicstudio.MagicStudioFragment$pager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewPager2 invoke() {
                ViewPager2 viewPager2 = (ViewPager2) MagicStudioFragment.this.requireView().findViewById(R.id.fho);
                viewPager2.setUserInputEnabled(false);
                return viewPager2;
            }
        });
        this.pager = lazy5;
        lazy6 = LazyKt__LazyJVMKt.lazy(new Function0<MagicStudioFragment$pagerAdapter$2.a>() { // from class: com.tencent.mobileqq.wink.magicstudio.MagicStudioFragment$pagerAdapter$2

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/magicstudio/MagicStudioFragment$pagerAdapter$2$a", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes21.dex */
            public static final class a extends FragmentStateAdapter {
                a(FragmentActivity fragmentActivity) {
                    super(fragmentActivity);
                }

                @Override // androidx.viewpager2.adapter.FragmentStateAdapter
                @NotNull
                public Fragment createFragment(int position) {
                    if (position == 0) {
                        return new TextCreationFragment();
                    }
                    throw new IllegalArgumentException("unknown position");
                }

                @Override // androidx.recyclerview.widget.RecyclerView.Adapter
                public int getItemCount() {
                    return 1;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(MagicStudioFragment.this.requireActivity());
            }
        });
        this.pagerAdapter = lazy6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(MagicStudioFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(MagicStudioFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent handleFSPublishHybirdActivityIntent = ((IFSQQBaseService) QRoute.api(IFSQQBaseService.class)).handleFSPublishHybirdActivityIntent(this$0.getContext(), "https://rule.tencent.com/rule/202312070001", new Intent(), -1);
        handleFSPublishHybirdActivityIntent.putExtra(QQWinkConstants.WEB_COLOR_NOTE_TYPE, 3);
        this$0.requireContext().startActivity(handleFSPublishHybirdActivityIntent);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Ch(String action) {
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        VideoReport.setElementId(wh(), "em_magic_studio_top_tab");
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_tab_name", action);
        params.put("xsj_eid", "em_magic_studio_top_tab");
        params.put("dt_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_MAIGC_STUDIO_PAGE);
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_MAIGC_STUDIO_PAGE);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", wh(), params);
    }

    private final void Dh(String target) {
        Iterator<String> it = xh().iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next(), target)) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 > -1 && uh().getAdapter() != null) {
            RecyclerView.Adapter adapter = uh().getAdapter();
            Intrinsics.checkNotNull(adapter);
            if (i3 < adapter.getItemCount()) {
                w53.b.f("MagicStudioFragment", "setSchemePosition = " + i3);
                uh().setCurrentItem(i3, false);
            }
        }
    }

    private final void initView() {
        String str;
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            str = intent.getStringExtra("taskid");
        } else {
            str = null;
        }
        if (str != null && com.tencent.mobileqq.wink.utils.t.f326727a.b(str)) {
            sh().setImageResource(R.drawable.qui_chevron_left);
        } else if ((getActivity() instanceof QQWinkActivity) && !r93.h.f430993a.g()) {
            sh().setImageResource(R.drawable.qui_chevron_left_icon_white);
        } else {
            sh().setImageResource(R.drawable.qui_close);
        }
        requireView().setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        sh().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MagicStudioFragment.Ah(MagicStudioFragment.this, view);
            }
        });
        th().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicstudio.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MagicStudioFragment.Bh(MagicStudioFragment.this, view);
            }
        });
    }

    private final ImageView sh() {
        Object value = this.close.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-close>(...)");
        return (ImageView) value;
    }

    private final ImageView th() {
        Object value = this.license.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-license>(...)");
        return (ImageView) value;
    }

    private final ViewPager2 uh() {
        Object value = this.pager.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-pager>(...)");
        return (ViewPager2) value;
    }

    private final FragmentStateAdapter vh() {
        return (FragmentStateAdapter) this.pagerAdapter.getValue();
    }

    private final QUIPageTabBar wh() {
        Object value = this.tab.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tab>(...)");
        return (QUIPageTabBar) value;
    }

    private final ArrayList<String> xh() {
        return (ArrayList) this.tabTitles.getValue();
    }

    private final void yh() {
        String str;
        uh().setAdapter(vh());
        wh().setIsShowLine(false);
        QUIPageTabBar wh5 = wh();
        Object[] array = xh().toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        wh5.setTabData((String[]) array);
        if (r93.h.f430993a.g()) {
            wh().setCheckedColor(ie0.a.f().h(getContext(), R.color.qui_common_text_primary, 1000));
        }
        wh().bindViewPager2(uh());
        wh().setOnCurrentTabClickListener(new QUIPageTabBar.h() { // from class: com.tencent.mobileqq.wink.magicstudio.o
            @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.h
            public final void k1(int i3) {
                MagicStudioFragment.zh(MagicStudioFragment.this, i3);
            }
        });
        uh().setCurrentItem(0, false);
        Map map = (Map) requireActivity().getIntent().getSerializableExtra("key_attrs");
        String str2 = null;
        if (map != null) {
            str = (String) map.get("target");
        } else {
            str = null;
        }
        if (map != null) {
            str2 = (String) map.get("second_target");
        }
        if (map != null && Intrinsics.areEqual(str, "15") && str2 != null) {
            w53.b.f("MagicStudioFragment", "SECOND_TARGET = " + str2);
            switch (str2.hashCode()) {
                case 48:
                    if (str2.equals("0")) {
                        String string = getString(R.string.f170136yn0);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.ae_magic_studio_creation)");
                        Dh(string);
                        return;
                    }
                    return;
                case 49:
                    if (str2.equals("1")) {
                        String string2 = getString(R.string.yn7);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.ae_magic_studio_mine)");
                        Dh(string2);
                        return;
                    }
                    return;
                case 50:
                    if (str2.equals("2")) {
                        String string3 = getString(R.string.yn9);
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.ae_magic_studio_pic_genenrate)");
                        Dh(string3);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(MagicStudioFragment this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String str = this$0.xh().get(i3);
        Intrinsics.checkNotNullExpressionValue(str, "tabTitles[position]");
        this$0.Ch(str);
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void P6(@NotNull FragmentPager.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.dtw;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean isUseDarkTextStatusBar() {
        if (!uq3.c.P6()) {
            return true;
        }
        return !QQTheme.isNowThemeIsNight();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ((MagicStudioViewModel) new ViewModelProvider(activity).get(MagicStudioViewModel.class)).Z1(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        com.tencent.mobileqq.wink.l.f();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Fragment fragment;
        Fragment fragment2;
        Fragment fragment3;
        boolean z16;
        FragmentManager supportFragmentManager;
        FragmentManager supportFragmentManager2;
        FragmentTransaction beginTransaction;
        FragmentTransaction remove;
        FragmentManager supportFragmentManager3;
        FragmentManager supportFragmentManager4;
        FragmentActivity activity = getActivity();
        ImageCreationFragment imageCreationFragment = null;
        if (activity != null && (supportFragmentManager4 = activity.getSupportFragmentManager()) != null) {
            fragment = supportFragmentManager4.findFragmentByTag("AIGCImgSelect");
        } else {
            fragment = null;
        }
        MultiSelectFragment multiSelectFragment = (MultiSelectFragment) fragment;
        if (multiSelectFragment != null) {
            return multiSelectFragment.onBackEvent();
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (supportFragmentManager3 = activity2.getSupportFragmentManager()) != null) {
            fragment2 = supportFragmentManager3.findFragmentByTag("MAGIC_STUDIO_CAPTURE");
        } else {
            fragment2 = null;
        }
        if (fragment2 != null) {
            FragmentActivity activity3 = getActivity();
            if (activity3 != null && (supportFragmentManager2 = activity3.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager2.beginTransaction()) != null && (remove = beginTransaction.remove(fragment2)) != null) {
                remove.commitAllowingStateLoss();
            }
            return true;
        }
        FragmentActivity activity4 = getActivity();
        if (activity4 != null && (supportFragmentManager = activity4.getSupportFragmentManager()) != null) {
            fragment3 = supportFragmentManager.findFragmentByTag("AIGCImgCreate");
        } else {
            fragment3 = null;
        }
        if (fragment3 instanceof ImageCreationFragment) {
            imageCreationFragment = (ImageCreationFragment) fragment3;
        }
        if (imageCreationFragment != null) {
            z16 = imageCreationFragment.onBackEvent();
        } else {
            z16 = false;
        }
        if (z16 || super.onBackEvent()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        yh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        Intent intent;
        String stringExtra;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && (stringExtra = intent.getStringExtra("taskid")) != null) {
            linkedHashMap.put("xsj_operation_activity_id", stringExtra);
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) stringExtra, (CharSequence) QCircleScheme.AttrQQPublish.BUSINESS_TASK_ID_QQ_ROBOT_PREFIX, false, 2, (Object) null);
            if (contains$default) {
                linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, 1);
            } else {
                linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, 0);
            }
        }
        WinkHomeReportHelper.f326257a.c(getActivity(), contentView, WinkDaTongReportConstant.PageId.PG_XSJ_MAIGC_STUDIO_PAGE, linkedHashMap);
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void xc() {
    }
}
