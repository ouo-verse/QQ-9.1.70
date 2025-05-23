package com.tencent.ecommerce.biz.mainpage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.mainpage.aftersale.ECMainPageAfterSaleFragment;
import com.tencent.ecommerce.biz.mainpage.other.ECMainPageOtherFragment;
import com.tencent.ecommerce.biz.mainpage.presale.ECMainPagePreSaleFragment;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 %2\u00020\u0001:\u0002&'B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006("}, d2 = {"Lcom/tencent/ecommerce/biz/mainpage/ECMainPageFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "initArguments", "Landroid/view/View;", "view", "initUI", "Mh", "", "getContentLayoutId", "", "getBusinessDescription", "", "Bh", "Dh", "Eh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/ecommerce/biz/mainpage/ECBaseMainPageFragment;", "P", "Ljava/util/List;", "fragmentList", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "callbackId", "Lcom/google/android/material/tabs/TabLayout;", BdhLogUtil.LogTag.Tag_Req, "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "Landroidx/viewpager/widget/ViewPager;", ExifInterface.LATITUDE_SOUTH, "Landroidx/viewpager/widget/ViewPager;", "viewPager", "<init>", "()V", "T", "a", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public class ECMainPageFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private final List<ECBaseMainPageFragment> fragmentList;

    /* renamed from: Q, reason: from kotlin metadata */
    private String callbackId;

    /* renamed from: R, reason: from kotlin metadata */
    private TabLayout tabLayout;

    /* renamed from: S, reason: from kotlin metadata */
    private ViewPager viewPager;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/mainpage/ECMainPageFragment$b;", "Landroidx/fragment/app/FragmentPagerAdapter;", "", "position", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "d", "getCount", "", "Ljava/util/List;", "fragmentList", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "<init>", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends FragmentPagerAdapter {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final List<ECBaseFragment> fragmentList;

        /* JADX WARN: Multi-variable type inference failed */
        public b(FragmentManager fragmentManager, List<? extends ECBaseFragment> list) {
            super(fragmentManager);
            this.fragmentList = list;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public ECBaseFragment getItem(int position) {
            return this.fragmentList.get(position);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return this.fragmentList.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Map<String, String> mapOf;
            EventCollector.getInstance().onViewClickedBefore(view);
            IECMainFragmentCallback a16 = a.f102955c.a(ECMainPageFragment.this.callbackId);
            if (a16 != null) {
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("fragment_callback_key", "SettingFragment"));
                a16.onCallbackFinished(mapOf);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECMainPageFragment() {
        List<ECBaseMainPageFragment> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ECBaseMainPageFragment[]{new ECMainPagePreSaleFragment(ECMainPageFragmentType.MAIN_PAGE_TYPE_PRE_SALE), new ECMainPageAfterSaleFragment(ECMainPageFragmentType.MAIN_PAGE_TYPE_AFTER_SALE), new ECMainPageOtherFragment(ECMainPageFragmentType.MAIN_PAGE_TYPE_OTHER)});
        this.fragmentList = listOf;
        this.callbackId = "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        if (r0.getInt("key_show_setting") == 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Mh() {
        Bundle arguments = getArguments();
        boolean z16 = arguments != null;
        if (z16) {
            Jh(R.drawable.eoe);
            Ih(new c());
        }
    }

    private final void initArguments() {
        String str;
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("fragment_callback_id")) == null) {
            str = "";
        }
        this.callbackId = str;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Bh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Dh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECMainPageFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cs8;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intent intent;
        super.onViewCreated(view, savedInstanceState);
        setTitle("\u7535\u5546\u4e3b\u9875");
        Hh(false);
        Mh();
        initArguments();
        initUI(view);
        FragmentActivity activity = getActivity();
        Uri data = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getData();
        if (data != null) {
            ECScheme.g(data.toString(), null, 2, null);
        }
    }

    private final void initUI(View view) {
        this.tabLayout = (TabLayout) view.findViewById(R.id.nx8);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.nx9);
        this.viewPager = viewPager;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager.setAdapter(new b(getChildFragmentManager(), this.fragmentList));
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        tabLayout.setupWithViewPager(viewPager2);
        TabLayout tabLayout2 = this.tabLayout;
        if (tabLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        ECSkin eCSkin = ECSkin.INSTANCE;
        tabLayout2.setTabTextColors(eCSkin.getColor(R.color.f6942x), eCSkin.getColor(R.color.f6902t));
        TabLayout tabLayout3 = this.tabLayout;
        if (tabLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        tabLayout3.setSelectedTabIndicatorColor(eCSkin.getColor(R.color.f66424));
        int i3 = 0;
        for (Object obj : this.fragmentList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ECBaseMainPageFragment eCBaseMainPageFragment = (ECBaseMainPageFragment) obj;
            TabLayout tabLayout4 = this.tabLayout;
            if (tabLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            }
            TabLayout.g B = tabLayout4.B(i3);
            if (B != null) {
                B.t(eCBaseMainPageFragment.getType().title);
            }
            i3 = i16;
        }
        TabLayout tabLayout5 = this.tabLayout;
        if (tabLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        TabLayout.g B2 = tabLayout5.B(0);
        if (B2 != null) {
            B2.m();
        }
    }
}
