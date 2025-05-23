package com.tencent.mobileqq.wink.magicAvatar.ui;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarGenerateInfo;
import com.tencent.mobileqq.wink.magicAvatar.picker.MagicAvatarPickerViewModel;
import com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel;
import com.tencent.mobileqq.wink.model.ModifyAvatarConfig;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 +2\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\u001a\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\b\u0010\u0017\u001a\u00020\nH\u0014J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\b\u0010\u001a\u001a\u00020\u0018H\u0014R\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/ui/MagicAvatarCropFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Lcom/tencent/mobileqq/wink/model/ModifyAvatarConfig;", "sh", "Landroid/view/View;", "view", "", "rh", "Lcom/tencent/qqlive/module/videoreport/PageParams;", "xh", "", "getContentLayoutId", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedAfterPartInit", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onDestroyView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getStatusBarColor", "", "needAdjustImmersive", "needSupportFullScreen", BdhLogUtil.LogTag.Tag_Conn, "Z", "isFromPause", "Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel;", "D", "Lkotlin/Lazy;", "th", "()Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel;", "magicCropVm", "Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel;", "E", "uh", "()Lcom/tencent/mobileqq/wink/magicAvatar/picker/MagicAvatarPickerViewModel;", "pickerVm", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicAvatarCropFragment extends ImmersivePartFragment {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isFromPause;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy magicCropVm;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy pickerVm;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/ui/MagicAvatarCropFragment$a;", "", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarGenerateInfo;", "info", "Lcom/tencent/mobileqq/wink/magicAvatar/ui/MagicAvatarCropFragment;", "a", "", "BROADCAST_INIT", "Ljava/lang/String;", "BROADCAST_PHOTO", "STYLE_IMG", "TAG", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.magicAvatar.ui.MagicAvatarCropFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MagicAvatarCropFragment a(@Nullable Bundle bundle, @NotNull MagicAvatarGenerateInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            MagicAvatarCropFragment magicAvatarCropFragment = new MagicAvatarCropFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putAll(bundle);
            bundle2.putParcelable("style_img", info);
            magicAvatarCropFragment.setArguments(bundle2);
            return magicAvatarCropFragment;
        }

        Companion() {
        }
    }

    public MagicAvatarCropFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MagicAvatarCropViewModel>() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.MagicAvatarCropFragment$magicCropVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MagicAvatarCropViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(MagicAvatarCropFragment.this).get(MagicAvatarCropViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026ropViewModel::class.java)");
                return (MagicAvatarCropViewModel) viewModel;
            }
        });
        this.magicCropVm = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MagicAvatarPickerViewModel>() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.MagicAvatarCropFragment$pickerVm$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MagicAvatarPickerViewModel invoke() {
                ViewModel viewModel = new ViewModelProvider(MagicAvatarCropFragment.this).get(MagicAvatarPickerViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).\u2026kerViewModel::class.java)");
                return (MagicAvatarPickerViewModel) viewModel;
            }
        });
        this.pickerVm = lazy2;
    }

    private final void rh(View view) {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(view, WinkDaTongReportConstant.PageId.PG_XSJ_MAGIC_AVATAR_CONFIRM_PAGE);
        VideoReport.setPageReportPolicy(view, PageReportPolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_pgin", view, xh(view).getBasicParams());
    }

    private final ModifyAvatarConfig sh() {
        Bundle bundle;
        Bundle arguments = getArguments();
        if (arguments != null && (bundle = arguments.getBundle(AECameraConstants.AVATAR_EXTRA_DATA)) != null) {
            return (ModifyAvatarConfig) bundle.getParcelable("avatar_config");
        }
        return null;
    }

    private final MagicAvatarCropViewModel th() {
        return (MagicAvatarCropViewModel) this.magicCropVm.getValue();
    }

    private final MagicAvatarPickerViewModel uh() {
        return (MagicAvatarPickerViewModel) this.pickerVm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(MagicAvatarCropFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setStatusBarTextColor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final PageParams xh(View view) {
        String str;
        String c16 = WinkContext.INSTANCE.d().getDtParams().c();
        Map<String, Object> paramsMap = WinkDTParamBuilder.buildElementParams();
        ModifyAvatarConfig sh5 = sh();
        boolean z16 = false;
        if (sh5 != null && sh5.getAvatarSource() == 1) {
            z16 = true;
        }
        if (z16) {
            str = "bas";
        } else {
            str = QCircleDaTongConstant.ElementParamValue.MAGIC_AVATAR;
        }
        Intrinsics.checkNotNullExpressionValue(paramsMap, "paramsMap");
        paramsMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_FROM, str);
        PageParams map = new WinkDTParamBuilder().buildPageParams(paramsMap, c16);
        VideoReport.setPageParams(view, map);
        Intrinsics.checkNotNullExpressionValue(map, "map");
        return map;
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MagicAvatarInitPart(uh(), th()));
        arrayList.add(new i(th()));
        arrayList.add(new MagicAvatarCropPart(th()));
        arrayList.add(new MagicAvatarCropStylePart(uh(), th()));
        arrayList.add(new MagicAvatarCropGeneratePart(th()));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i5x;
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

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        w53.b.a("MagicAvatarCropFragment", "onDestroyView");
        VideoReport.reportEvent("dt_pgout", getView(), xh(getView()).getBasicParams());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.isFromPause = true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        w53.b.f("MagicAvatarCropFragment", "isFromPause = " + this.isFromPause);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.a
            @Override // java.lang.Runnable
            public final void run() {
                MagicAvatarCropFragment.vh(MagicAvatarCropFragment.this);
            }
        });
        th().o2();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        int i3;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MagicAvatarCropFragment.wh(view2);
            }
        });
        MagicAvatarCropViewModel th5 = th();
        ModifyAvatarConfig sh5 = sh();
        if (sh5 != null) {
            i3 = sh5.getAvatarSource();
        } else {
            i3 = 0;
        }
        th5.K2(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        rh(contentView);
    }
}
