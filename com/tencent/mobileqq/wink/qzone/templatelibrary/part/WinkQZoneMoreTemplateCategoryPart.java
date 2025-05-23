package com.tencent.mobileqq.wink.qzone.templatelibrary.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IQQWinkMagicStudioApi;
import com.tencent.mobileqq.wink.qzone.templatelibrary.fragment.WinkQZoneTemplateLibViewPagerFragment;
import com.tencent.mobileqq.wink.qzone.templatelibrary.utils.WinkQZoneTemplateLibJumpHelper;
import com.tencent.mobileqq.wink.qzone.templatelibrary.viewmodel.WinkQZoneTemplateLibViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 =2\u00020\u0001:\u0002>?B\u001b\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b;\u0010<J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\"\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J-\u0010\u0017\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00122\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u001a\u001a\u00020\u0019R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001c\u00103\u001a\b\u0012\u0004\u0012\u0002000/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/WinkQZoneMoreTemplateCategoryPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "D9", "B9", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "onPartDestroy", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "", "", "permissions", "", "grantResults", "G9", "(I[Ljava/lang/String;[I)V", "", "H9", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel$a;", "d", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel$a;", "categoriesData", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "e", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "targetPositionMaterial", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "f", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "tabLayout", "Landroidx/viewpager/widget/ViewPager;", tl.h.F, "Landroidx/viewpager/widget/ViewPager;", "viewpager", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/WinkQZoneMoreTemplateCategoryPart$a;", "i", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/WinkQZoneMoreTemplateCategoryPart$a;", "adapter", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "categories", BdhLogUtil.LogTag.Tag_Conn, "Z", "initTabSelect", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;", "D", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;", "jumpHelper", "<init>", "(Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel$a;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "E", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkQZoneMoreTemplateCategoryPart extends Part {

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private WinkQZoneTemplateLibJumpHelper jumpHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final WinkQZoneTemplateLibViewModel.CategoriesData categoriesData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final MetaMaterial targetPositionMaterial;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIPageTabBar tabLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewPager viewpager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a adapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<MetaCategory> categories = new ArrayList();

    /* renamed from: C, reason: from kotlin metadata */
    private boolean initTabSelect = true;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ(\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000bH\u0016R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/part/WinkQZoneMoreTemplateCategoryPart$a;", "Landroidx/fragment/app/FragmentPagerAdapter;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "categories", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "targetPositionMaterial", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;", "jumpHelper", "", "d", "", "getCount", "position", "", "getPageTitle", "Landroidx/fragment/app/Fragment;", "getItem", "", "Ljava/util/List;", "e", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "f", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/utils/WinkQZoneTemplateLibJumpHelper;", "Landroidx/fragment/app/FragmentManager;", "fragmentMgr", "<init>", "(Landroidx/fragment/app/FragmentManager;)V", tl.h.F, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends FragmentPagerAdapter {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<MetaCategory> categories;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private MetaMaterial targetPositionMaterial;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private WinkQZoneTemplateLibJumpHelper jumpHelper;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull FragmentManager fragmentMgr) {
            super(fragmentMgr, 1);
            Intrinsics.checkNotNullParameter(fragmentMgr, "fragmentMgr");
            this.categories = new ArrayList();
        }

        public final void d(@NotNull List<MetaCategory> categories, @Nullable MetaMaterial targetPositionMaterial, @Nullable WinkQZoneTemplateLibJumpHelper jumpHelper) {
            Intrinsics.checkNotNullParameter(categories, "categories");
            this.categories.clear();
            this.categories.addAll(categories);
            this.targetPositionMaterial = targetPositionMaterial;
            this.jumpHelper = jumpHelper;
            w53.b.f("CategoryPagerAdapter", "new categories ==> " + categories.size());
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return this.categories.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        @NotNull
        public Fragment getItem(int position) {
            WinkQZoneTemplateLibViewPagerFragment winkQZoneTemplateLibViewPagerFragment = new WinkQZoneTemplateLibViewPagerFragment();
            winkQZoneTemplateLibViewPagerFragment.vh(this.categories.get(position), this.targetPositionMaterial, this.jumpHelper);
            return winkQZoneTemplateLibViewPagerFragment;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int position) {
            return this.categories.get(position).name;
        }
    }

    public WinkQZoneMoreTemplateCategoryPart(@Nullable WinkQZoneTemplateLibViewModel.CategoriesData categoriesData, @Nullable MetaMaterial metaMaterial) {
        this.categoriesData = categoriesData;
        this.targetPositionMaterial = metaMaterial;
    }

    private final void B9() {
        if (this.targetPositionMaterial == null) {
            return;
        }
        Iterator<MetaCategory> it = this.categories.iterator();
        final int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().f30532id, com.tencent.mobileqq.wink.editor.c.o(this.targetPositionMaterial))) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.qzone.templatelibrary.part.c
            @Override // java.lang.Runnable
            public final void run() {
                WinkQZoneMoreTemplateCategoryPart.C9(WinkQZoneMoreTemplateCategoryPart.this, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(WinkQZoneMoreTemplateCategoryPart this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPager viewPager = this$0.viewpager;
        if (viewPager != null) {
            viewPager.setCurrentItem(i3, false);
        }
    }

    private final void D9(View rootView) {
        QUIPageTabBar qUIPageTabBar;
        int collectionSizeOrDefault;
        MetaCategory templateCategory;
        ArrayList<MetaCategory> subCategories;
        MetaCategory picGenPicCategory;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.jumpHelper = new WinkQZoneTemplateLibJumpHelper(context, getHostFragment());
        ViewPager viewPager = null;
        if (rootView != null) {
            qUIPageTabBar = (QUIPageTabBar) rootView.findViewById(R.id.f124237it);
        } else {
            qUIPageTabBar = null;
        }
        this.tabLayout = qUIPageTabBar;
        if (rootView != null) {
            viewPager = (ViewPager) rootView.findViewById(R.id.f124247iu);
        }
        this.viewpager = viewPager;
        if (viewPager != null) {
            FragmentManager childFragmentManager = getHostFragment().getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "hostFragment.childFragmentManager");
            a aVar = new a(childFragmentManager);
            this.adapter = aVar;
            viewPager.setAdapter(aVar);
        }
        ArrayList arrayList = new ArrayList();
        WinkQZoneTemplateLibViewModel.CategoriesData categoriesData = this.categoriesData;
        if (categoriesData != null && (picGenPicCategory = categoriesData.getPicGenPicCategory()) != null) {
            arrayList.add(picGenPicCategory);
        }
        WinkQZoneTemplateLibViewModel.CategoriesData categoriesData2 = this.categoriesData;
        if (categoriesData2 != null && (templateCategory = categoriesData2.getTemplateCategory()) != null && (subCategories = templateCategory.subCategories) != null) {
            Intrinsics.checkNotNullExpressionValue(subCategories, "subCategories");
            arrayList.addAll(subCategories);
        }
        this.categories = arrayList;
        QUIPageTabBar qUIPageTabBar2 = this.tabLayout;
        if (qUIPageTabBar2 != null) {
            qUIPageTabBar2.setViewPager(this.viewpager);
        }
        a aVar2 = this.adapter;
        if (aVar2 != null) {
            aVar2.d(this.categories, this.targetPositionMaterial, this.jumpHelper);
        }
        QUIPageTabBar qUIPageTabBar3 = this.tabLayout;
        if (qUIPageTabBar3 != null) {
            List<MetaCategory> list = this.categories;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(((MetaCategory) it.next()).name);
            }
            Object[] array = arrayList2.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            qUIPageTabBar3.setTabData((String[]) array);
        }
        QUIPageTabBar qUIPageTabBar4 = this.tabLayout;
        if (qUIPageTabBar4 != null) {
            qUIPageTabBar4.setTabChangeListener(new QUIPageTabBar.i() { // from class: com.tencent.mobileqq.wink.qzone.templatelibrary.part.b
                @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
                public final void I0(int i3, boolean z16) {
                    WinkQZoneMoreTemplateCategoryPart.E9(WinkQZoneMoreTemplateCategoryPart.this, i3, z16);
                }
            });
        }
        B9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(WinkQZoneMoreTemplateCategoryPart this$0, int i3, boolean z16) {
        Object orNull;
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16 && !this$0.initTabSelect) {
            Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put("dt_pgid", WinkDaTongReportConstant.PageId.PG_QZ_CLASSIFY_GROUP);
            params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_QZ_CLASSIFY_GROUP);
            params.put("qq_pgid", WinkDaTongReportConstant.PageId.PG_QZ_CLASSIFY_GROUP);
            params.put("qq_eid", WinkDaTongReportConstant.ElementId.EM_QZ_CLASSIFY_TAB);
            orNull = CollectionsKt___CollectionsKt.getOrNull(this$0.categories, i3);
            MetaCategory metaCategory = (MetaCategory) orNull;
            if (metaCategory != null) {
                str = metaCategory.name;
            } else {
                str = null;
            }
            params.put("tab_name", str);
            com.tencent.mobileqq.wink.report.e.r(com.tencent.mobileqq.wink.report.e.f326265a, "qq_clck", this$0.tabLayout, WinkDaTongReportConstant.ElementId.EM_QZ_CLASSIFY_TAB, params, null, 16, null);
        }
        this$0.initTabSelect = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(WinkQZoneMoreTemplateCategoryPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkQZoneTemplateLibJumpHelper winkQZoneTemplateLibJumpHelper = this$0.jumpHelper;
        if (winkQZoneTemplateLibJumpHelper != null) {
            winkQZoneTemplateLibJumpHelper.t();
        }
    }

    public final void G9(int requestCode, @NotNull String[] permissions, @NotNull int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        WinkQZoneTemplateLibJumpHelper winkQZoneTemplateLibJumpHelper = this.jumpHelper;
        if (winkQZoneTemplateLibJumpHelper != null) {
            winkQZoneTemplateLibJumpHelper.s(requestCode, permissions, grantResults);
        }
    }

    public final boolean H9() {
        Activity activity = getActivity();
        if (!(activity instanceof FragmentActivity)) {
            w53.b.c("WinkQZoneMoreTemplateCategoryPart", "quit: activity is not FragmentActivity");
            return true;
        }
        FragmentActivity fragmentActivity = (FragmentActivity) activity;
        if (fragmentActivity.getSupportFragmentManager().getBackStackEntryCount() > 0) {
            Fragment findFragmentByTag = fragmentActivity.getSupportFragmentManager().findFragmentByTag(((IQQWinkMagicStudioApi) QRoute.api(IQQWinkMagicStudioApi.class)).getCaptureFragmentTag());
            if (findFragmentByTag != null) {
                fragmentActivity.getSupportFragmentManager().beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
                return false;
            }
            if (fragmentActivity.getSupportFragmentManager().findFragmentByTag(((IQQWinkMagicStudioApi) QRoute.api(IQQWinkMagicStudioApi.class)).getMultiSelectFragmentTag()) != null) {
                WinkQZoneTemplateLibJumpHelper winkQZoneTemplateLibJumpHelper = this.jumpHelper;
                if (winkQZoneTemplateLibJumpHelper != null) {
                    Activity activity2 = getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity2, "activity");
                    winkQZoneTemplateLibJumpHelper.m(activity2);
                }
                fragmentActivity.getSupportFragmentManager().popBackStack();
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 52130) {
            ((IQQWinkMagicStudioApi) QRoute.api(IQQWinkMagicStudioApi.class)).onActivityShareResult(getActivity(), requestCode, resultCode, data, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.qzone.templatelibrary.part.WinkQZoneMoreTemplateCategoryPart$onActivityResult$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            });
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.qzone.templatelibrary.part.a
                @Override // java.lang.Runnable
                public final void run() {
                    WinkQZoneMoreTemplateCategoryPart.F9(WinkQZoneMoreTemplateCategoryPart.this);
                }
            }, 200L);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        D9(rootView);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        WinkQZoneTemplateLibJumpHelper winkQZoneTemplateLibJumpHelper = this.jumpHelper;
        if (winkQZoneTemplateLibJumpHelper != null) {
            winkQZoneTemplateLibJumpHelper.t();
        }
    }
}
