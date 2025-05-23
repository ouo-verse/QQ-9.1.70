package com.tencent.mobileqq.wink.magicAvatar.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.magicAvatar.model.ClipBitmapInfo;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarGenerateInfo;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarMaterialInfo;
import com.tencent.mobileqq.wink.magicAvatar.viewmodel.MagicAvatarCropViewModel;
import com.tencent.mobileqq.wink.magicAvatar.widget.MagicAvatarNextButton;
import com.tencent.mobileqq.wink.magicAvatar.widget.TextCheckBox;
import com.tencent.mobileqq.wink.model.ModifyAvatarConfig;
import com.tencent.mobileqq.wink.view.ai;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.ttpic.openapi.filter.LightConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u0001TB\u000f\u0012\u0006\u0010*\u001a\u00020'\u00a2\u0006\u0004\bQ\u0010RJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\nH\u0016J \u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\u000e\u0010\u001b\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u0017H\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\u0012\u0010&\u001a\u00020\u00032\b\u0010%\u001a\u0004\u0018\u00010$H\u0016R\u0014\u0010*\u001a\u00020'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u00105R\u0016\u0010>\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u00105R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010L\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010O\u00a8\u0006U"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/ui/MagicAvatarCropGeneratePart;", "Lcom/tencent/biz/richframework/part/Part;", "Li83/a;", "", "S9", "R9", "T9", "ca", "da", "ea", "Landroid/view/View;", "view", "ba", "Li83/b;", "P9", "W9", "V9", "U9", "aa", "Q9", "ga", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "isSuccess", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "X5", "", "y7", "m4", "Landroid/content/Context;", "H8", "Landroid/os/Bundle;", "getParams", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel;", "d", "Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel;", "magicCropVm", "Lcom/tencent/mobileqq/wink/magicAvatar/widget/MagicAvatarNextButton;", "e", "Lcom/tencent/mobileqq/wink/magicAvatar/widget/MagicAvatarNextButton;", "setHeadBtn", "Lcom/tencent/mobileqq/wink/magicAvatar/widget/TextCheckBox;", "f", "Lcom/tencent/mobileqq/wink/magicAvatar/widget/TextCheckBox;", "share", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "preview", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "changeGenderIcon", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "countTv", BdhLogUtil.LogTag.Tag_Conn, "changeGender", "Lcom/tencent/mobileqq/wink/magicAvatar/model/ClipBitmapInfo;", "D", "Lcom/tencent/mobileqq/wink/magicAvatar/model/ClipBitmapInfo;", "clipBitmapInfo", "Lcom/tencent/mobileqq/wink/model/ModifyAvatarConfig;", "E", "Lcom/tencent/mobileqq/wink/model/ModifyAvatarConfig;", DownloadInfo.spKey_Config, UserInfo.SEX_FEMALE, "Li83/b;", "delegate", "G", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/wink/view/ai;", "H", "Lcom/tencent/mobileqq/wink/view/ai;", "uploadDialog", "<init>", "(Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/MagicAvatarCropViewModel;)V", "I", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicAvatarCropGeneratePart extends Part implements i83.a {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView changeGender;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ClipBitmapInfo clipBitmapInfo;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ModifyAvatarConfig config;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private i83.b delegate;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Bundle bundle;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ai uploadDialog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MagicAvatarCropViewModel magicCropVm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private MagicAvatarNextButton setHeadBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextCheckBox share;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView preview;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView changeGenderIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView countTv;

    public MagicAvatarCropGeneratePart(@NotNull MagicAvatarCropViewModel magicCropVm) {
        Intrinsics.checkNotNullParameter(magicCropVm, "magicCropVm");
        this.magicCropVm = magicCropVm;
        this.bundle = new Bundle();
    }

    private final i83.b P9() {
        Object obj;
        String magicAvatarDelegateClassName;
        try {
            ModifyAvatarConfig modifyAvatarConfig = this.config;
            if (modifyAvatarConfig != null && (magicAvatarDelegateClassName = modifyAvatarConfig.getMagicAvatarDelegateClassName()) != null) {
                obj = Class.forName(magicAvatarDelegateClassName).newInstance();
            } else {
                obj = null;
            }
            if (!(obj instanceof i83.b)) {
                return null;
            }
            return (i83.b) obj;
        } catch (Exception unused) {
            w53.b.f("MagicAvatarCropPart", "createAvatarDelegate \u5931\u8d25");
            return null;
        }
    }

    private final void Q9() {
        ai aiVar = this.uploadDialog;
        if (aiVar != null && aiVar.isShowing()) {
            aiVar.dismiss();
        }
    }

    private final void R9() {
        MagicAvatarNextButton magicAvatarNextButton = this.setHeadBtn;
        MagicAvatarNextButton magicAvatarNextButton2 = null;
        if (magicAvatarNextButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setHeadBtn");
            magicAvatarNextButton = null;
        }
        magicAvatarNextButton.setStates(new MagicAvatarNextButton.a.C9059a("\u8bbe\u4e3a\u5934\u50cf"));
        MagicAvatarNextButton magicAvatarNextButton3 = this.setHeadBtn;
        if (magicAvatarNextButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setHeadBtn");
            magicAvatarNextButton3 = null;
        }
        magicAvatarNextButton3.setNormalClickedListener(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.MagicAvatarCropGeneratePart$initButton$1
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
                w53.b.f("MagicAvatarCropPart", "onClickSetHead");
                MagicAvatarCropGeneratePart.this.W9();
                MagicAvatarCropGeneratePart.this.ca();
            }
        });
        MagicAvatarNextButton magicAvatarNextButton4 = this.setHeadBtn;
        if (magicAvatarNextButton4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setHeadBtn");
            magicAvatarNextButton4 = null;
        }
        magicAvatarNextButton4.setVipClickedListener(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.MagicAvatarCropGeneratePart$initButton$2
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
                ModifyAvatarConfig modifyAvatarConfig;
                modifyAvatarConfig = MagicAvatarCropGeneratePart.this.config;
                String openVipSchema = modifyAvatarConfig != null ? modifyAvatarConfig.getOpenVipSchema() : null;
                w53.b.f("MagicAvatarCropPart", "vipClickedListener url is: " + openVipSchema);
                MagicAvatarCropGeneratePart.this.da();
                com.tencent.mobileqq.wink.f.l(MagicAvatarCropGeneratePart.this.getContext(), openVipSchema);
            }
        });
        MagicAvatarNextButton magicAvatarNextButton5 = this.setHeadBtn;
        if (magicAvatarNextButton5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setHeadBtn");
        } else {
            magicAvatarNextButton2 = magicAvatarNextButton5;
        }
        magicAvatarNextButton2.setErrorClickedListener(new Function0<Unit>() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.MagicAvatarCropGeneratePart$initButton$3
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (NetworkUtil.isNetworkAvailable()) {
                    return;
                }
                QQToast.makeText(MobileQQ.sMobileQQ, "\u5f53\u524d\u65e0\u7f51\u7edc\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u94fe\u63a5", 0).show();
            }
        });
    }

    private final void S9() {
        String str;
        boolean z16;
        String modifyAvatarErrorMessage;
        Bundle bundle = this.bundle;
        ModifyAvatarConfig modifyAvatarConfig = this.config;
        String str2 = "";
        if (modifyAvatarConfig == null || (str = modifyAvatarConfig.getOldAvatarFilePath()) == null) {
            str = "";
        }
        bundle.putString("key_old_file", str);
        Bundle bundle2 = this.bundle;
        ModifyAvatarConfig modifyAvatarConfig2 = this.config;
        if (modifyAvatarConfig2 != null) {
            z16 = modifyAvatarConfig2.getModifyChancesUsedUp();
        } else {
            z16 = false;
        }
        bundle2.putBoolean("key_can_sethead", z16);
        Bundle bundle3 = this.bundle;
        ModifyAvatarConfig modifyAvatarConfig3 = this.config;
        if (modifyAvatarConfig3 != null && (modifyAvatarErrorMessage = modifyAvatarConfig3.getModifyAvatarErrorMessage()) != null) {
            str2 = modifyAvatarErrorMessage;
        }
        bundle3.putString("key_qcircle_limit_tip", str2);
    }

    private final void T9() {
        Fragment hostFragment = getHostFragment();
        if (hostFragment == null) {
            return;
        }
        LifecycleOwnerKt.getLifecycleScope(hostFragment).launchWhenResumed(new MagicAvatarCropGeneratePart$initObserver$1(this, null));
        LifecycleOwnerKt.getLifecycleScope(hostFragment).launchWhenResumed(new MagicAvatarCropGeneratePart$initObserver$2(this, null));
        LifecycleOwnerKt.getLifecycleScope(hostFragment).launchWhenResumed(new MagicAvatarCropGeneratePart$initObserver$3(this, null));
        LifecycleOwnerKt.getLifecycleScope(hostFragment).launchWhenResumed(new MagicAvatarCropGeneratePart$initObserver$4(this, null));
        LifecycleOwnerKt.getLifecycleScope(hostFragment).launchWhenResumed(new MagicAvatarCropGeneratePart$initObserver$5(this, null));
    }

    private final void U9() {
        ModifyAvatarConfig modifyAvatarConfig = this.config;
        if (modifyAvatarConfig != null && modifyAvatarConfig.getShowShare()) {
            TextCheckBox textCheckBox = this.share;
            TextView textView = null;
            if (textCheckBox == null) {
                Intrinsics.throwUninitializedPropertyAccessException("share");
                textCheckBox = null;
            }
            textCheckBox.setVisibility(0);
            TextCheckBox textCheckBox2 = this.share;
            if (textCheckBox2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("share");
                textCheckBox2 = null;
            }
            textCheckBox2.setChecked(modifyAvatarConfig.getSelectShareByDefault());
            TextCheckBox textCheckBox3 = this.share;
            if (textCheckBox3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("share");
                textCheckBox3 = null;
            }
            textCheckBox3.setText(modifyAvatarConfig.getShareTipsText());
            if (modifyAvatarConfig.getAvatarSource() == 0) {
                TextView textView2 = this.preview;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("preview");
                } else {
                    textView = textView2;
                }
                textView.setVisibility(0);
            }
        }
    }

    private final void V9() {
        if (this.magicCropVm.p2()) {
            return;
        }
        broadcastMessage("broadcast_photo", Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W9() {
        if (this.magicCropVm.p2()) {
            return;
        }
        broadcastMessage("broadcast_photo", Boolean.FALSE);
        uq3.k a16 = uq3.k.a();
        TextCheckBox textCheckBox = this.share;
        if (textCheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("share");
            textCheckBox = null;
        }
        a16.j("qfs_share_avatar_video_to_xsj", textCheckBox.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(MagicAvatarCropGeneratePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.V9();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(MagicAvatarCropGeneratePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = this$0.changeGenderIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeGenderIcon");
            imageView = null;
        }
        this$0.ba(imageView);
        this$0.magicCropVm.m2();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(MagicAvatarCropGeneratePart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.changeGender;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeGender");
            textView = null;
        }
        this$0.ba(textView);
        this$0.magicCropVm.m2();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void aa() {
        ModifyAvatarConfig modifyAvatarConfig = this.config;
        if (modifyAvatarConfig != null && modifyAvatarConfig.getAvatarSource() == 0) {
            ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure("exp_xsj_avatarVideo");
        }
    }

    private final void ba(View view) {
        String str;
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_GENDER_SWITCH);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
        Map<String, Object> reportMap = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(reportMap, "reportMap");
        MagicAvatarCropViewModel magicAvatarCropViewModel = this.magicCropVm;
        if (magicAvatarCropViewModel.M2(magicAvatarCropViewModel.getInfoFromPicker())) {
            str = LightConstants.FEMALE;
        } else {
            str = LightConstants.MALE;
        }
        reportMap.put("xsj_gender", str);
        VideoReport.reportEvent("clck", view, reportMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ca() {
        String str;
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        MagicAvatarNextButton magicAvatarNextButton = this.setHeadBtn;
        MagicAvatarNextButton magicAvatarNextButton2 = null;
        if (magicAvatarNextButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setHeadBtn");
            magicAvatarNextButton = null;
        }
        VideoReport.setElementId(magicAvatarNextButton, WinkDaTongReportConstant.ElementId.EM_XSJ_CHOOSE_PICTURE);
        Intrinsics.checkNotNullExpressionValue(params, "params");
        MagicAvatarMaterialInfo currentSelectMaterial = this.magicCropVm.getCurrentSelectMaterial();
        if (currentSelectMaterial != null) {
            str = currentSelectMaterial.getStyleName();
        } else {
            str = null;
        }
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_STYLE, str);
        TextCheckBox textCheckBox = this.share;
        if (textCheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("share");
            textCheckBox = null;
        }
        params.put("xsj_is_tick", Integer.valueOf(textCheckBox.d() ? 1 : 0));
        params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_CHOOSE_PICTURE);
        params.put("dt_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_MAGIC_AVATAR_CONFIRM_PAGE);
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_MAGIC_AVATAR_CONFIRM_PAGE);
        MagicAvatarNextButton magicAvatarNextButton3 = this.setHeadBtn;
        if (magicAvatarNextButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setHeadBtn");
        } else {
            magicAvatarNextButton2 = magicAvatarNextButton3;
        }
        VideoReport.reportEvent("ev_xsj_abnormal_clck", magicAvatarNextButton2, params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void da() {
        String str;
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        MagicAvatarNextButton magicAvatarNextButton = this.setHeadBtn;
        MagicAvatarNextButton magicAvatarNextButton2 = null;
        if (magicAvatarNextButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setHeadBtn");
            magicAvatarNextButton = null;
        }
        VideoReport.setElementId(magicAvatarNextButton, WinkDaTongReportConstant.ElementId.EM_XSJ_VIP_BUTTON);
        Intrinsics.checkNotNullExpressionValue(params, "params");
        MagicAvatarMaterialInfo currentSelectMaterial = this.magicCropVm.getCurrentSelectMaterial();
        if (currentSelectMaterial != null) {
            str = currentSelectMaterial.getStyleName();
        } else {
            str = null;
        }
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_STYLE, str);
        params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_VIP_BUTTON);
        params.put("dt_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_MAGIC_AVATAR_CONFIRM_PAGE);
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_MAGIC_AVATAR_CONFIRM_PAGE);
        MagicAvatarNextButton magicAvatarNextButton3 = this.setHeadBtn;
        if (magicAvatarNextButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setHeadBtn");
        } else {
            magicAvatarNextButton2 = magicAvatarNextButton3;
        }
        VideoReport.reportEvent("ev_xsj_abnormal_clck", magicAvatarNextButton2, params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ea() {
        String str;
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        MagicAvatarNextButton magicAvatarNextButton = this.setHeadBtn;
        MagicAvatarNextButton magicAvatarNextButton2 = null;
        if (magicAvatarNextButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setHeadBtn");
            magicAvatarNextButton = null;
        }
        VideoReport.setElementId(magicAvatarNextButton, WinkDaTongReportConstant.ElementId.EM_XSJ_VIP_BUTTON);
        Intrinsics.checkNotNullExpressionValue(params, "params");
        MagicAvatarGenerateInfo infoFromPicker = this.magicCropVm.getInfoFromPicker();
        if (infoFromPicker != null) {
            str = infoFromPicker.getOriginStyleName();
        } else {
            str = null;
        }
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_STYLE, str);
        params.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_VIP_BUTTON);
        params.put("dt_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_MAGIC_AVATAR_CONFIRM_PAGE);
        params.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_MAGIC_AVATAR_CONFIRM_PAGE);
        MagicAvatarNextButton magicAvatarNextButton3 = this.setHeadBtn;
        if (magicAvatarNextButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setHeadBtn");
        } else {
            magicAvatarNextButton2 = magicAvatarNextButton3;
        }
        VideoReport.reportEvent("ev_xsj_abnormal_imp", magicAvatarNextButton2, params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ga() {
        ai aiVar = this.uploadDialog;
        if (aiVar != null) {
            aiVar.dismiss();
        }
        ai a16 = new ai.b(getContext(), R.style.f173547a45).h(false).i("\u5934\u50cf\u8bbe\u7f6e\u4e2d").a();
        this.uploadDialog = a16;
        if (a16 != null) {
            a16.show();
        }
    }

    @Override // i83.a
    @NotNull
    public Context H8() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return context;
    }

    @Override // i83.a
    public void X5(boolean isSuccess, @Nullable Exception error) {
        if (!isSuccess) {
            Q9();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("isSetHeadResult", true);
        Activity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        Activity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    @Override // i83.a
    @NotNull
    /* renamed from: getParams, reason: from getter */
    public Bundle getBundle() {
        return this.bundle;
    }

    @Override // i83.a
    public boolean m4() {
        TextCheckBox textCheckBox = this.share;
        TextCheckBox textCheckBox2 = null;
        if (textCheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("share");
            textCheckBox = null;
        }
        if (textCheckBox.getVisibility() == 0) {
            TextCheckBox textCheckBox3 = this.share;
            if (textCheckBox3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("share");
            } else {
                textCheckBox2 = textCheckBox3;
            }
            return textCheckBox2.d();
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Bundle arguments;
        Bundle bundle;
        ModifyAvatarConfig modifyAvatarConfig;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.ipt);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.setheadBtn)");
        this.setHeadBtn = (MagicAvatarNextButton) findViewById;
        View findViewById2 = rootView.findViewById(R.id.iqr);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.share)");
        this.share = (TextCheckBox) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.fyh);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.preview_btn)");
        this.preview = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.trf);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.change_gener_icon)");
        this.changeGenderIcon = (ImageView) findViewById4;
        View findViewById5 = rootView.findViewById(R.id.tre);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.change_gender)");
        this.changeGender = (TextView) findViewById5;
        View findViewById6 = rootView.findViewById(R.id.u_1);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.count_tv)");
        this.countTv = (TextView) findViewById6;
        ImageView imageView = this.changeGenderIcon;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("changeGenderIcon");
            imageView = null;
        }
        imageView.setImageDrawable(URLDrawable.getDrawable("https://qq-video.cdn-go.cn/ios/latest/defaultmode/8973/qvideo_icon_general_sort_primary@3x.png", URLDrawable.URLDrawableOptions.obtain()));
        Fragment hostFragment = getHostFragment();
        if (hostFragment != null && (arguments = hostFragment.getArguments()) != null && (bundle = arguments.getBundle(AECameraConstants.AVATAR_EXTRA_DATA)) != null && (modifyAvatarConfig = (ModifyAvatarConfig) bundle.getParcelable("avatar_config")) != null) {
            this.config = modifyAvatarConfig;
            S9();
            this.delegate = P9();
            U9();
            R9();
            aa();
            TextView textView2 = this.preview;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preview");
                textView2 = null;
            }
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MagicAvatarCropGeneratePart.X9(MagicAvatarCropGeneratePart.this, view);
                }
            });
            T9();
            ImageView imageView2 = this.changeGenderIcon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("changeGenderIcon");
                imageView2 = null;
            }
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MagicAvatarCropGeneratePart.Y9(MagicAvatarCropGeneratePart.this, view);
                }
            });
            TextView textView3 = this.changeGender;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("changeGender");
            } else {
                textView = textView3;
            }
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.magicAvatar.ui.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MagicAvatarCropGeneratePart.Z9(MagicAvatarCropGeneratePart.this, view);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        i83.b bVar = this.delegate;
        if (bVar != null) {
            bVar.release();
        }
    }

    @Override // i83.a
    @NotNull
    public String y7() {
        String path;
        ClipBitmapInfo clipBitmapInfo = this.clipBitmapInfo;
        if (clipBitmapInfo == null || (path = clipBitmapInfo.getPath()) == null) {
            return "";
        }
        return path;
    }
}
