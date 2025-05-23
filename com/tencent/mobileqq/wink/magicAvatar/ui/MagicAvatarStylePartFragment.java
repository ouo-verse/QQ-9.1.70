package com.tencent.mobileqq.wink.magicAvatar.ui;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarStyleBanner;
import com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel;
import com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarStyleViewModel;
import com.tencent.mobileqq.wink.magicAvatar.widget.MagicAvatarNextButton;
import com.tencent.mobileqq.wink.model.ModifyAvatarConfig;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.util.LoadingUtil;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0014J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\"\u0010\"\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#H\u0016J\b\u0010&\u001a\u00020\u001bH\u0014J\b\u0010(\u001a\u00020'H\u0014J\b\u0010)\u001a\u00020'H\u0014J\b\u0010*\u001a\u00020'H\u0016R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001b\u00105\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010J\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010CR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010Q\u00a8\u0006U"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/ui/MagicAvatarStylePartFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "", "Ih", "Ph", "Oh", "Sh", "", "path", "Mh", "Jh", UIJsPlugin.EVENT_SHOW_LOADING, "Th", UIJsPlugin.EVENT_HIDE_LOADING, "Nh", "id", "Qh", "Lh", "Lcom/tencent/mobileqq/wink/model/ModifyAvatarConfig;", "Fh", "Landroid/view/View;", "view", "Eh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getStatusBarColor", "onResume", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getContentLayoutId", "", "needAdjustImmersive", "needSupportFullScreen", "onBackEvent", "Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarStyleViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Hh", "()Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarStyleViewModel;", "magicStyleVm", "Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel;", "D", "Gh", "()Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel;", "magicCropVm", "Landroidx/recyclerview/widget/RecyclerView;", "E", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/wink/magicAvatar/ui/p;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/magicAvatar/ui/p;", "styleAdapter", "G", "Landroid/view/View;", "loadingView", "Landroid/widget/FrameLayout;", "H", "Landroid/widget/FrameLayout;", "loadLayout", "Lcom/tencent/mobileqq/wink/magicAvatar/widget/MagicAvatarNextButton;", "I", "Lcom/tencent/mobileqq/wink/magicAvatar/widget/MagicAvatarNextButton;", "button", "J", "pagContainer", "Lorg/libpag/PAGView;", "K", "Lorg/libpag/PAGView;", "pagView", "Lorg/libpag/PAGFile;", "L", "Lorg/libpag/PAGFile;", "pag", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicAvatarStylePartFragment extends ImmersivePartFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy magicStyleVm;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy magicCropVm;

    /* renamed from: E, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private p styleAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View loadingView;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private FrameLayout loadLayout;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private MagicAvatarNextButton button;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private FrameLayout pagContainer;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private PAGView pagView;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private PAGFile pag;

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/magicAvatar/ui/MagicAvatarStylePartFragment$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.bottom = ViewExKt.d(16);
        }
    }

    public MagicAvatarStylePartFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MagicAvatarStyleViewModel>() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.MagicAvatarStylePartFragment$magicStyleVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MagicAvatarStyleViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(MagicAvatarStylePartFragment.this).get(MagicAvatarStyleViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026yleViewModel::class.java)");
                return (MagicAvatarStyleViewModel) viewModel;
            }
        });
        this.magicStyleVm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MagicAvatarCropViewModel>() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.MagicAvatarStylePartFragment$magicCropVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MagicAvatarCropViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(MagicAvatarStylePartFragment.this).get(MagicAvatarCropViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026ropViewModel::class.java)");
                return (MagicAvatarCropViewModel) viewModel;
            }
        });
        this.magicCropVm = lazy2;
    }

    private final void Eh(View view) {
        String str;
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(view, WinkDaTongReportConstant.PageId.PG_XSJ_MAGIC_AVATAR_PAGE);
        String c16 = WinkContext.INSTANCE.d().getDtParams().c();
        Map<String, Object> paramsMap = WinkDTParamBuilder.buildElementParams();
        ModifyAvatarConfig Fh = Fh();
        boolean z16 = false;
        if (Fh != null && Fh.getAvatarSource() == 1) {
            z16 = true;
        }
        if (z16) {
            str = "bas";
        } else {
            str = QCircleDaTongConstant.ElementParamValue.MAGIC_AVATAR;
        }
        Intrinsics.checkNotNullExpressionValue(paramsMap, "paramsMap");
        paramsMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FROM, str);
        VideoReport.setPageParams(view, new WinkDTParamBuilder().buildPageParams(paramsMap, c16));
    }

    private final ModifyAvatarConfig Fh() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return (ModifyAvatarConfig) arguments.getParcelable("avatar_config");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MagicAvatarCropViewModel Gh() {
        return (MagicAvatarCropViewModel) this.magicCropVm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MagicAvatarStyleViewModel Hh() {
        return (MagicAvatarStyleViewModel) this.magicStyleVm.getValue();
    }

    private final void Ih() {
        MagicAvatarNextButton magicAvatarNextButton = this.button;
        if (magicAvatarNextButton != null) {
            magicAvatarNextButton.setStates(new MagicAvatarNextButton.a.C9059a("\u4f20\u56fe\u7acb\u5373\u751f\u6210"));
        }
        MagicAvatarNextButton magicAvatarNextButton2 = this.button;
        if (magicAvatarNextButton2 != null) {
            magicAvatarNextButton2.setNormalClickedListener(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.MagicAvatarStylePartFragment$initButton$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MagicAvatarStylePartFragment.this.Sh();
                    Bundle arguments = MagicAvatarStylePartFragment.this.getArguments();
                    if (arguments != null) {
                        arguments.remove(AECameraConstants.MAGIC_AVATAR_STYLE);
                    }
                    MagicAvatarStylePartFragment.this.Oh();
                }
            });
        }
        MagicAvatarNextButton magicAvatarNextButton3 = this.button;
        if (magicAvatarNextButton3 != null) {
            magicAvatarNextButton3.setVipClickedListener(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.MagicAvatarStylePartFragment$initButton$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MagicAvatarStylePartFragment.this.Sh();
                    MagicAvatarStylePartFragment.this.Ph();
                }
            });
        }
        MagicAvatarNextButton magicAvatarNextButton4 = this.button;
        if (magicAvatarNextButton4 != null) {
            magicAvatarNextButton4.setErrorClickedListener(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.MagicAvatarStylePartFragment$initButton$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MagicAvatarCropViewModel Gh;
                    w53.b.f("MagicAvatarCropPart", "errorClickedListener");
                    MagicAvatarStylePartFragment.this.Sh();
                    Gh = MagicAvatarStylePartFragment.this.Gh();
                    Gh.o2();
                }
            });
        }
    }

    private final void Jh() {
        TextView textView;
        Object obj;
        this.loadLayout = (FrameLayout) requireView().findViewById(R.id.loading);
        View loadingDialogTipsRight = LoadingUtil.getLoadingDialogTipsRight(getContext(), false);
        this.loadingView = loadingDialogTipsRight;
        FrameLayout.LayoutParams layoutParams = null;
        if (loadingDialogTipsRight != null) {
            textView = (TextView) loadingDialogTipsRight.findViewById(R.id.yt9);
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setText("\u6b63\u5728\u52a0\u8f7d...");
        }
        View view = this.loadingView;
        if (view != null) {
            obj = view.getLayoutParams();
        } else {
            obj = null;
        }
        if (obj instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) obj;
        }
        if (layoutParams != null) {
            layoutParams.gravity = 17;
        }
        FrameLayout frameLayout = this.loadLayout;
        if (frameLayout != null) {
            frameLayout.addView(this.loadingView);
        }
        View view2 = this.loadingView;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    MagicAvatarStylePartFragment.Kh(MagicAvatarStylePartFragment.this, view3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(MagicAvatarStylePartFragment this$0, View view) {
        CharSequence charSequence;
        TextView textView;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view2 = this$0.loadingView;
        if (view2 != null && (textView = (TextView) view2.findViewById(R.id.yt9)) != null) {
            charSequence = textView.getText();
        } else {
            charSequence = null;
        }
        if (Intrinsics.areEqual(charSequence, "\u70b9\u51fb\u91cd\u8bd5")) {
            this$0.Hh().T1();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Lh() {
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new MagicAvatarStylePartFragment$initObserver$1(this, null));
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new MagicAvatarStylePartFragment$initObserver$2(this, null));
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenResumed(new MagicAvatarStylePartFragment$initObserver$3(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Mh(String path) {
        this.pag = PagViewMonitor.Load(path);
        PAGView pAGView = new PAGView(getContext());
        FrameLayout frameLayout = this.pagContainer;
        if (frameLayout != null) {
            frameLayout.addView(pAGView, new ViewGroup.MarginLayoutParams(-1, -1));
        }
        pAGView.setComposition(this.pag);
        pAGView.addListener(new a());
        pAGView.setRepeatCount(0);
        pAGView.setScaleMode(3);
        PAGView pAGView2 = this.pagView;
        if (pAGView2 != null) {
            pAGView2.setProgress(0.0d);
        }
        pAGView.play();
        this.pagView = pAGView;
    }

    private final void Nh() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        recyclerView.addItemDecoration(new b());
        p pVar = new p(new Function1<MagicAvatarStyleBanner, Unit>() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.MagicAvatarStylePartFragment$initRecyclerView$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MagicAvatarStyleBanner magicAvatarStyleBanner) {
                invoke2(magicAvatarStyleBanner);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MagicAvatarStyleBanner it) {
                Intrinsics.checkNotNullParameter(it, "it");
                MagicAvatarStylePartFragment.this.Qh(it.getId());
            }
        });
        this.styleAdapter = pVar;
        recyclerView.setAdapter(pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oh() {
        int i3;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            IQQWinkLauncher iQQWinkLauncher = (IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class);
            ModifyAvatarConfig Fh = Fh();
            if (Fh != null) {
                i3 = Fh.getRequestCode();
            } else {
                i3 = 0;
            }
            iQQWinkLauncher.jumpToMagicAvatarPickerFragment(activity, i3, getArguments());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph() {
        String str;
        ModifyAvatarConfig Fh = Fh();
        if (Fh != null) {
            str = Fh.getOpenVipSchema();
        } else {
            str = null;
        }
        w53.b.f("MagicAvatarCropPart", "vipClickedListener url is: " + str);
        com.tencent.mobileqq.wink.f.l(getContext(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qh(String id5) {
        MagicAvatarNextButton.a aVar;
        if (!NetworkUtil.isNetworkAvailable()) {
            Gh().o2();
            return;
        }
        MagicAvatarNextButton magicAvatarNextButton = this.button;
        if (magicAvatarNextButton != null) {
            aVar = magicAvatarNextButton.getStates();
        } else {
            aVar = null;
        }
        if (aVar instanceof MagicAvatarNextButton.a.C9059a) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                arguments.putString(AECameraConstants.MAGIC_AVATAR_STYLE, id5);
            }
            Oh();
            return;
        }
        if (aVar instanceof MagicAvatarNextButton.a.c) {
            Ph();
        } else {
            boolean z16 = aVar instanceof MagicAvatarNextButton.a.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(MagicAvatarStylePartFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Sh() {
        MagicAvatarNextButton magicAvatarNextButton = this.button;
        if (magicAvatarNextButton != null) {
            VideoReport.setElementId(magicAvatarNextButton, WinkDaTongReportConstant.ElementId.EM_XSJ_UPLOAD_PICTURE_BUTTON);
            VideoReport.setElementClickPolicy(getView(), ClickPolicy.REPORT_NONE);
            VideoReport.reportEvent("ev_xsj_abnormal_clck", magicAvatarNextButton, WinkDTParamBuilder.buildElementParams());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th() {
        TextView textView;
        ImageView imageView;
        View view = this.loadingView;
        if (view != null) {
            textView = (TextView) view.findViewById(R.id.yt9);
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setText("\u70b9\u51fb\u91cd\u8bd5");
        }
        View view2 = this.loadingView;
        if (view2 != null && (imageView = (ImageView) view2.findViewById(R.id.ysu)) != null) {
            imageView.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.oqx));
        }
        FrameLayout frameLayout = this.loadLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideLoading() {
        FrameLayout frameLayout = this.loadLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
    }

    private final void showLoading() {
        TextView textView;
        ImageView imageView;
        View view = this.loadingView;
        if (view != null) {
            textView = (TextView) view.findViewById(R.id.yt9);
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setText("\u6b63\u5728\u52a0\u8f7d...");
        }
        View view2 = this.loadingView;
        if (view2 != null && (imageView = (ImageView) view2.findViewById(R.id.ysu)) != null) {
            imageView.setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), 2));
        }
        FrameLayout frameLayout = this.loadLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i5y;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needAdjustImmersive() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needSupportFullScreen() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        FragmentActivity activity;
        super.onActivityResult(requestCode, resultCode, data);
        boolean z16 = false;
        if (data != null && data.getBooleanExtra("isSetHeadResult", false)) {
            z16 = true;
        }
        if (z16 && (activity = getActivity()) != null) {
            activity.finish();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return super.onBackEvent();
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.tencent.mobileqq.wink.l.f();
        w53.b.f("MagicAvatarStylePartFragment", "activity = " + getActivity());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Gh().o2();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        int i3;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Eh(view);
        View findViewById = view.findViewById(R.id.f898150s);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.style_banner)");
        this.recyclerView = (RecyclerView) findViewById;
        this.button = (MagicAvatarNextButton) view.findViewById(R.id.f82434gv);
        this.pagContainer = (FrameLayout) view.findViewById(R.id.f85064ny);
        Jh();
        view.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MagicAvatarStylePartFragment.Rh(MagicAvatarStylePartFragment.this, view2);
            }
        });
        Ih();
        Nh();
        Lh();
        Hh().T1();
        Hh().Q1(Fh());
        MagicAvatarCropViewModel Gh = Gh();
        ModifyAvatarConfig Fh = Fh();
        if (Fh != null) {
            i3 = Fh.getAvatarSource();
        } else {
            i3 = 0;
        }
        Gh.K2(i3);
        showLoading();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/magicAvatar/ui/MagicAvatarStylePartFragment$a", "Lorg/libpag/PAGView$PAGViewListener;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "onAnimationUpdate", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements PAGView.PAGViewListener {
        a() {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(@Nullable PAGView p06) {
            FrameLayout frameLayout = MagicAvatarStylePartFragment.this.pagContainer;
            if (frameLayout != null) {
                frameLayout.setVisibility(0);
            }
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(@Nullable PAGView p06) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(@Nullable PAGView p06) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(@Nullable PAGView p06) {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(@Nullable PAGView p06) {
        }
    }
}
