package com.tencent.mobileqq.wink.magicstudio;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioLogicFragment;
import com.tencent.mobileqq.wink.magicstudio.view.ImageCreateImagePart;
import com.tencent.mobileqq.wink.magicstudio.view.ImageCreateJumpPart;
import com.tencent.mobileqq.wink.magicstudio.view.ImageCreateStylePart;
import com.tencent.mobileqq.wink.report.WinkHomeReportHelper;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0014J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0014J\b\u0010\u0015\u001a\u00020\fH\u0016R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u001c8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010%\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010\u0018\u001a\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/ImageCreationFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "", "enableRootViewSetFitsSystemWindows", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getStatusBarColor", "Landroid/content/Context;", "context", "", "onAttach", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onBackEvent", "isUseDarkTextStatusBar", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "sh", "()Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel;", "vm", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioViewModel;", "D", "rh", "()Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioViewModel;", "magicStudioVm", "Lcom/tencent/mobileqq/wink/magicstudio/p;", "E", "qh", "()Lcom/tencent/mobileqq/wink/magicstudio/p;", "jumpViewModel", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ImageCreationFragment extends ImmersivePartFragment {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy vm;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy magicStudioVm;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy jumpViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007R\u0011\u0010\t\u001a\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/ImageCreationFragment$a;", "", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/wink/magicstudio/ImageCreationFragment;", "b", "", "a", "()I", "styleSpan", "DESC_LIMIT", "I", "MAX_STYLE_COUNT", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.magicstudio.ImageCreationFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            if (Resources.getSystem().getDisplayMetrics().widthPixels / Resources.getSystem().getDisplayMetrics().heightPixels > 0.5625f) {
                return 8;
            }
            return 4;
        }

        @JvmStatic
        @NotNull
        public final ImageCreationFragment b(@Nullable Bundle bundle) {
            ImageCreationFragment imageCreationFragment = new ImageCreationFragment();
            imageCreationFragment.setArguments(bundle);
            return imageCreationFragment;
        }

        Companion() {
        }
    }

    public ImageCreationFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MagicStudioCreationViewModel>() { // from class: com.tencent.mobileqq.wink.magicstudio.ImageCreationFragment$vm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MagicStudioCreationViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(ImageCreationFragment.this).get(MagicStudioCreationViewModel.class);
                MagicStudioCreationViewModel magicStudioCreationViewModel = (MagicStudioCreationViewModel) viewModel;
                magicStudioCreationViewModel.u3(true);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026 picMode = true\n        }");
                return magicStudioCreationViewModel;
            }
        });
        this.vm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MagicStudioViewModel>() { // from class: com.tencent.mobileqq.wink.magicstudio.ImageCreationFragment$magicStudioVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MagicStudioViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(ImageCreationFragment.this.requireActivity()).get(MagicStudioViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026dioViewModel::class.java)");
                return (MagicStudioViewModel) viewModel;
            }
        });
        this.magicStudioVm = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<p>() { // from class: com.tencent.mobileqq.wink.magicstudio.ImageCreationFragment$jumpViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final p invoke() {
                ViewModel viewModel = new ViewModelProvider(ImageCreationFragment.this.requireActivity()).get(p.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(requir\u2026umpViewModel::class.java)");
                return (p) viewModel;
            }
        });
        this.jumpViewModel = lazy3;
    }

    private final p qh() {
        return (p) this.jumpViewModel.getValue();
    }

    private final MagicStudioViewModel rh() {
        return (MagicStudioViewModel) this.magicStudioVm.getValue();
    }

    private final MagicStudioCreationViewModel sh() {
        return (MagicStudioCreationViewModel) this.vm.getValue();
    }

    @JvmStatic
    @NotNull
    public static final ImageCreationFragment th(@Nullable Bundle bundle) {
        return INSTANCE.b(bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(ImageCreationFragment this$0) {
        FragmentManager supportFragmentManager;
        FragmentTransaction beginTransaction;
        FragmentTransaction remove;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            FragmentActivity activity = this$0.getActivity();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager.beginTransaction()) != null && (remove = beginTransaction.remove(this$0)) != null) {
                remove.commitAllowingStateLoss();
            }
        } catch (Throwable th5) {
            w53.b.e("ImageCreationFragment", th5);
        }
        this$0.qh().M1(null);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.mobileqq.wink.magicstudio.view.h(qh()));
        arrayList.add(new ImageCreateImagePart(qh(), sh()));
        arrayList.add(new ImageCreateStylePart(rh(), sh()));
        arrayList.add(new ImageCreateJumpPart(sh()));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean enableRootViewSetFitsSystemWindows() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.dtx;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean isUseDarkTextStatusBar() {
        if (!uq3.c.P6() || !QQTheme.isNowThemeIsNight()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        com.tencent.mobileqq.wink.l.f();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        FragmentManager supportFragmentManager;
        Fragment findFragmentByTag;
        FragmentActivity activity1;
        FragmentActivity activity = getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null && (findFragmentByTag = supportFragmentManager.findFragmentByTag("AIGC_LOGIC")) != null && (activity1 = getActivity()) != null) {
            MagicStudioLogicFragment.Companion companion = MagicStudioLogicFragment.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(activity1, "activity1");
            companion.c(activity1, findFragmentByTag, new Bundle());
        }
        View view = getView();
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.magicstudio.c
                @Override // java.lang.Runnable
                public final void run() {
                    ImageCreationFragment.uh(ImageCreationFragment.this);
                }
            }, 300L);
            return true;
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MagicStudioDataSource.f323652a.t();
        super.onDestroy();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intent intent;
        String stringExtra;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MagicStudioDataSource.f323652a.U();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && (stringExtra = intent.getStringExtra("taskid")) != null) {
            linkedHashMap.put("xsj_operation_activity_id", stringExtra);
        }
        WinkHomeReportHelper.f326257a.c(getActivity(), view, WinkDaTongReportConstant.PageId.PG_XSJ_MAGIC_STUDIO_STYLE_CHOOSE_PAGE, linkedHashMap);
        view.setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
    }
}
