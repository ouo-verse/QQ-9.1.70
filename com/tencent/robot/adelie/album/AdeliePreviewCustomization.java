package com.tencent.robot.adelie.album;

import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.peak.api.IPeakHelperApi;
import com.tencent.mobileqq.qqalbum.IPhotoTempUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.customization.common.b;
import com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.robot.qqmc.RobotQQMC;
import com.tencent.robot.qqmc.model.c;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u0019*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u001aB\u001d\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\"\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/robot/adelie/album/AdeliePreviewCustomization;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "O", "Lcom/tencent/qqnt/qbasealbum/customization/picker/PickerCustomizationBase;", "Landroid/content/Intent;", "intent", "", "initData", "Landroid/view/View;", "view", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "mediaInfo", "", "layoutPosition", "onItemClickEvent", "requestCode", QzoneIPCModule.RESULT_CODE, "data", "onActivityResult", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "photoCommonData", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/qqnt/qbasealbum/customization/common/b;)V", "Companion", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdeliePreviewCustomization<O extends com.tencent.qqnt.qbasealbum.customization.common.a> extends PickerCustomizationBase<O> {

    @NotNull
    private static final Lazy<c> AVATAR_CONFIG$delegate;
    public static final int CROP_IMAGE_REQUEST = 100002;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "AdeliePreviewCustomization";

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/robot/adelie/album/AdeliePreviewCustomization$a;", "", "Lcom/tencent/robot/qqmc/model/c;", "AVATAR_CONFIG$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/robot/qqmc/model/c;", "AVATAR_CONFIG", "", "CROP_IMAGE_REQUEST", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.adelie.album.AdeliePreviewCustomization$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final c a() {
            return (c) AdeliePreviewCustomization.AVATAR_CONFIG$delegate.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<c> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.robot.adelie.album.AdeliePreviewCustomization$Companion$AVATAR_CONFIG$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                return RobotQQMC.INSTANCE.getCreationAvatarConfig();
            }
        });
        AVATAR_CONFIG$delegate = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdeliePreviewCustomization(@NotNull FragmentActivity activity, @NotNull b<O> photoCommonData) {
        super(activity, photoCommonData);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(photoCommonData, "photoCommonData");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initData$lambda$0(AdeliePreviewCustomization this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IPeakHelperApi) QRoute.api(IPeakHelperApi.class)).preloadPeakProcess(this$0.getActivity());
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void initData(@Nullable Intent intent) {
        ox3.a.g("AdeliePreviewCustomization", new Function0<String>() { // from class: com.tencent.robot.adelie.album.AdeliePreviewCustomization$initData$1
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return "[picker] initData";
            }
        });
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.robot.adelie.album.a
            @Override // java.lang.Runnable
            public final void run() {
                AdeliePreviewCustomization.initData$lambda$0(AdeliePreviewCustomization.this);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onActivityResult(final int requestCode, final int resultCode, @Nullable final Intent data) {
        ox3.a.g("AdeliePreviewCustomization", new Function0<String>() { // from class: com.tencent.robot.adelie.album.AdeliePreviewCustomization$onActivityResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return "onActivityResult requestCode:" + requestCode + " resultCode:" + resultCode + " " + (data != null);
            }
        });
        if (requestCode == 100002 && resultCode == -1) {
            getActivity().setResult(-1, data);
            getActivity().finish();
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase, com.tencent.qqnt.qbasealbum.customization.picker.AbstractPickerLogic
    public void onItemClickEvent(@NotNull View view, @NotNull LocalMediaInfo mediaInfo, final int layoutPosition) {
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        if (mediaInfo.getPath() == null) {
            ox3.a.c("AdeliePreviewCustomization", new Function0<String>() { // from class: com.tencent.robot.adelie.album.AdeliePreviewCustomization$onItemClickEvent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return "[picker] onItemClickEvent layoutPosition:" + layoutPosition + " path is null";
                }
            });
            return;
        }
        ox3.a.g("AdeliePreviewCustomization", new Function0<String>() { // from class: com.tencent.robot.adelie.album.AdeliePreviewCustomization$onItemClickEvent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return "[picker] onItemClickEvent layoutPosition:" + layoutPosition + ", AVATAR_CONFIG=" + AdeliePreviewCustomization.INSTANCE.a();
            }
        });
        DisplayMetrics displayMetrics = getActivity().getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "activity.resources.displayMetrics");
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(displayMetrics.widthPixels, displayMetrics.heightPixels);
        int i3 = (int) (((coerceAtMost - 10) * 0.8f) + 0.5d);
        Intent cropActivity = ((IPhotoTempUtils) QRoute.api(IPhotoTempUtils.class)).toCropActivity(getActivity(), new Intent());
        cropActivity.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", getActivity().getClass().getName());
        cropActivity.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        cropActivity.putExtra(PeakConstants.CLIP_WIDTH, i3);
        cropActivity.putExtra(PeakConstants.CLIP_HEIGHT, i3);
        Companion companion = INSTANCE;
        cropActivity.putExtra(PeakConstants.TARGET_WIDTH, companion.a().getCropSize());
        cropActivity.putExtra(PeakConstants.TARGET_HEIGHT, companion.a().getCropSize());
        cropActivity.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        cropActivity.putExtra("PhotoConst.SINGLE_PHOTO_PATH", mediaInfo.getPath());
        cropActivity.putExtra(PeakConstants.IS_START_ACTIVITY_FOR_RESULT, true);
        cropActivity.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 1);
        cropActivity.putExtra(PeakConstants.COMPRESS_QUALITY, companion.a().getCompressQuality());
        cropActivity.putExtra(PeakConstants.TITLE_BAR_BLACK_BG, true);
        cropActivity.putExtra("PhotoConst.SUB_SOURCE_FROM", "SUB_FROM_ROBOT_ADELIE_AVATAR");
        cropActivity.putExtra(PeakConstants.TARGET_PATH, VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH) + "/adelie/tmp/" + System.currentTimeMillis() + "_portrait.tmp");
        getActivity().startActivityForResult(cropActivity, 100002);
    }
}
