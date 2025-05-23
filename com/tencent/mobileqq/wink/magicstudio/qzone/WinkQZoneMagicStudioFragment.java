package com.tencent.mobileqq.wink.magicstudio.qzone;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.Part;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IQQWinkMagicStudioApi;
import com.tencent.mobileqq.wink.l;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioLogicFragment;
import com.tencent.mobileqq.wink.magicstudio.WinkMagicStudioBaseFragment;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioButtonInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle;
import com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZoneMagicStudioTitlePart;
import com.tencent.mobileqq.wink.magicstudio.qzone.part.WinkQZonePic2PicPart;
import com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioLogicUtils;
import com.tencent.mobileqq.wink.magicstudio.utils.WinkMagicStudioUtils;
import com.tencent.mobileqq.wink.pager.FragmentPager;
import com.tencent.mobileqq.wink.qzone.templatelibrary.viewmodel.WinkQZoneTemplateLibViewModel;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qzone.QzoneIPCModule;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 >2\u00020\u0001:\u0001?B\u0007\u00a2\u0006\u0004\b<\u0010=J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u000eH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0011H\u0016J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0011H\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\u0002H\u0017J\b\u0010$\u001a\u00020\u0002H\u0016J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%H\u0016R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/qzone/WinkQZoneMagicStudioFragment;", "Lcom/tencent/mobileqq/wink/magicstudio/WinkMagicStudioBaseFragment;", "", "initView", "initIntentData", "initViewModel", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedAfterPartInit", "", "getContentLayoutId", "getStatusBarColor", "", "enableRootViewSetFitsSystemWindows", "onCreate", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "isVisibleToUser", "setUserVisibleHint", "onResume", "useArgusLifecycle", "hidden", "onHiddenChanged", "onBackEvent", "Landroid/content/Context;", "context", "onAttach", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "xc", "Lcom/tencent/mobileqq/wink/pager/FragmentPager$b;", "callback", "P6", "Lcom/tencent/mobileqq/wink/magicstudio/qzone/WinkQZoneMagicStudioViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/magicstudio/qzone/WinkQZoneMagicStudioViewModel;", "magicStudioViewModel", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel;", "D", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/viewmodel/WinkQZoneTemplateLibViewModel;", "templateLibViewModel", "", "E", "Ljava/lang/String;", "pic2picSelectedStyleId", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", UserInfo.SEX_FEMALE, "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "pic2picMetaCategory", "Landroidx/fragment/app/Fragment;", "G", "Landroidx/fragment/app/Fragment;", "logicFragment", "<init>", "()V", "H", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkQZoneMagicStudioFragment extends WinkMagicStudioBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private WinkQZoneMagicStudioViewModel magicStudioViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private WinkQZoneTemplateLibViewModel templateLibViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private String pic2picSelectedStyleId;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private MetaCategory pic2picMetaCategory;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Fragment logicFragment;

    private final void initIntentData() {
        Intent intent;
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            this.pic2picSelectedStyleId = intent.getStringExtra("magic_studio_style");
            this.pic2picMetaCategory = (MetaCategory) intent.getSerializableExtra(IQQWinkMagicStudioApi.MAGIC_STUDIO_META_CATEGORY);
        }
    }

    private final void initView() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.logicFragment = ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).winkLaunchAIGCLogicFragment(activity);
        }
    }

    private final void initViewModel() {
        WinkQZoneMagicStudioViewModel a16 = WinkQZoneMagicStudioViewModel.INSTANCE.a(getActivity());
        this.magicStudioViewModel = a16;
        if (a16 != null) {
            a16.W1(this.pic2picSelectedStyleId);
        }
        ViewModel viewModel = getViewModel(WinkQZoneTemplateLibViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(WinkQZoneTe\u2026LibViewModel::class.java)");
        WinkQZoneTemplateLibViewModel winkQZoneTemplateLibViewModel = (WinkQZoneTemplateLibViewModel) viewModel;
        this.templateLibViewModel = winkQZoneTemplateLibViewModel;
        WinkQZoneTemplateLibViewModel winkQZoneTemplateLibViewModel2 = null;
        if (winkQZoneTemplateLibViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templateLibViewModel");
            winkQZoneTemplateLibViewModel = null;
        }
        MutableLiveData<WinkQZoneTemplateLibViewModel.CategoriesData> N1 = winkQZoneTemplateLibViewModel.N1();
        final Function1<WinkQZoneTemplateLibViewModel.CategoriesData, Unit> function1 = new Function1<WinkQZoneTemplateLibViewModel.CategoriesData, Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.WinkQZoneMagicStudioFragment$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WinkQZoneTemplateLibViewModel.CategoriesData categoriesData) {
                invoke2(categoriesData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(WinkQZoneTemplateLibViewModel.CategoriesData categoriesData) {
                WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel;
                winkQZoneMagicStudioViewModel = WinkQZoneMagicStudioFragment.this.magicStudioViewModel;
                if (winkQZoneMagicStudioViewModel != null) {
                    winkQZoneMagicStudioViewModel.Q1(categoriesData.getPicGenPicCategory());
                }
                WinkMagicStudioLogicUtils.f323883a.x(categoriesData.getShareCategory());
            }
        };
        N1.observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkQZoneMagicStudioFragment.rh(Function1.this, obj);
            }
        });
        WinkQZoneTemplateLibViewModel winkQZoneTemplateLibViewModel3 = this.templateLibViewModel;
        if (winkQZoneTemplateLibViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("templateLibViewModel");
        } else {
            winkQZoneTemplateLibViewModel2 = winkQZoneTemplateLibViewModel3;
        }
        winkQZoneTemplateLibViewModel2.P1(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void P6(@NotNull FragmentPager.b callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new WinkQZoneMagicStudioTitlePart(), new WinkQZonePic2PicPart());
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i7_;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, final int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        w53.b.a("WinkQZoneMagicStudioFragment", "onActivityResult requestCode:" + requestCode);
        if (requestCode == 52130) {
            WinkMagicStudioLogicUtils.f323883a.v(getActivity(), requestCode, resultCode, data, new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicstudio.qzone.WinkQZoneMagicStudioFragment$onActivityResult$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:3:0x0005, code lost:
                
                    r0 = r2.magicStudioViewModel;
                 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke2() {
                    WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel;
                    if (resultCode != -1 || winkQZoneMagicStudioViewModel == null) {
                        return;
                    }
                    winkQZoneMagicStudioViewModel.L1(2);
                }
            });
            return;
        }
        Fragment fragment = this.logicFragment;
        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        l.f();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        FragmentManager fragmentManager;
        Fragment findFragmentByTag;
        MutableLiveData<MagicStudioButtonInfo> N1;
        MagicStudioButtonInfo value;
        w53.b.a("WinkQZoneMagicStudioFragment", "onBackEvent called");
        FragmentActivity activity = getActivity();
        MagicStudioPicStyle magicStudioPicStyle = null;
        if (activity != null) {
            fragmentManager = activity.getSupportFragmentManager();
        } else {
            fragmentManager = null;
        }
        if (fragmentManager != null) {
            Iterator<String> it = MagicStudioLogicFragment.INSTANCE.a().iterator();
            while (it.hasNext()) {
                Fragment findFragmentByTag2 = fragmentManager.findFragmentByTag(it.next());
                if (findFragmentByTag2 != null) {
                    fragmentManager.beginTransaction().remove(findFragmentByTag2).commitAllowingStateLoss();
                    fragmentManager.popBackStack();
                    return true;
                }
            }
            if (fragmentManager.getBackStackEntryCount() > 0) {
                if (WinkMagicStudioLogicUtils.f323883a.h()) {
                    WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel = this.magicStudioViewModel;
                    boolean z16 = false;
                    if (winkQZoneMagicStudioViewModel != null && (N1 = winkQZoneMagicStudioViewModel.N1()) != null && (value = N1.getValue()) != null && value.getActionType() == 3) {
                        z16 = true;
                    }
                    if (z16 && (findFragmentByTag = fragmentManager.findFragmentByTag("AIGC_LOGIC")) != null) {
                        WinkMagicStudioUtils winkMagicStudioUtils = WinkMagicStudioUtils.f323888a;
                        FragmentActivity activity2 = getActivity();
                        WinkQZoneMagicStudioViewModel winkQZoneMagicStudioViewModel2 = this.magicStudioViewModel;
                        if (winkQZoneMagicStudioViewModel2 != null) {
                            magicStudioPicStyle = winkQZoneMagicStudioViewModel2.getCurrentSelectedMagicStudioPicStyle();
                        }
                        winkMagicStudioUtils.k(activity2, findFragmentByTag, magicStudioPicStyle);
                    }
                }
                WinkMagicStudioUtils.f323888a.l(fragmentManager);
                return true;
            }
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initIntentData();
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    @SuppressLint({"RestrictedApi"})
    public void onDestroy() {
        w53.b.a("WinkQZoneMagicStudioFragment", "onDestroy called");
        super.onDestroy();
        LottieCompositionCache.getInstance().clear();
        URLDrawable.clearMemoryCache();
        WinkMagicStudioLogicUtils.f323883a.y(false);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        w53.b.a("WinkQZoneMagicStudioFragment", "onHiddenChanged:" + hidden);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        w53.b.a("WinkQZoneMagicStudioFragment", "onResume");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        m83.b.f416442a.l(contentView, getActivity());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        w53.b.a("WinkQZoneMagicStudioFragment", "setUserVisibleHint:" + isVisibleToUser);
        if (isResumed() && isVisibleToUser) {
            VideoReport.reportPgIn(getFragmentContentView());
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public boolean useArgusLifecycle() {
        return true;
    }

    @Override // com.tencent.mobileqq.wink.pager.FragmentPager.d
    public void xc() {
    }
}
