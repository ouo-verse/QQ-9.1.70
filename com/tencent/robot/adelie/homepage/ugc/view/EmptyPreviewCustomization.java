package com.tencent.robot.adelie.homepage.ugc.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase;
import com.tencent.robot.qqmc.RobotQQMC;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u0010*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\u0011B\u001d\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/EmptyPreviewCustomization;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "O", "Lcom/tencent/qqnt/qbasealbum/customization/preview/PreviewCustomizationBase;", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "getBottomView", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/qqnt/qbasealbum/customization/common/b;", "photoCommonData", "<init>", "(Landroidx/fragment/app/FragmentActivity;Lcom/tencent/qqnt/qbasealbum/customization/common/b;)V", "Companion", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class EmptyPreviewCustomization<O extends com.tencent.qqnt.qbasealbum.customization.common.a> extends PreviewCustomizationBase<O> {

    @NotNull
    private static final Lazy<com.tencent.robot.qqmc.model.c> AVATAR_CONFIG$delegate;

    @NotNull
    public static final String TAG = "AdeliePreviewCustomization";

    static {
        Lazy<com.tencent.robot.qqmc.model.c> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.robot.qqmc.model.c>() { // from class: com.tencent.robot.adelie.homepage.ugc.view.EmptyPreviewCustomization$Companion$AVATAR_CONFIG$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.robot.qqmc.model.c invoke() {
                return RobotQQMC.INSTANCE.getCreationAvatarConfig();
            }
        });
        AVATAR_CONFIG$delegate = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyPreviewCustomization(@NotNull FragmentActivity activity, @NotNull com.tencent.qqnt.qbasealbum.customization.common.b<O> photoCommonData) {
        super(activity, photoCommonData);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(photoCommonData, "photoCommonData");
    }

    @Override // com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase, com.tencent.qqnt.qbasealbum.customization.preview.a
    @Nullable
    public View getBottomView(@NotNull Context context, @NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(parent, "parent");
        View bottomView = super.getBottomView(context, parent);
        TextView magicStickBtn = getMagicStickBtn();
        if (magicStickBtn != null) {
            magicStickBtn.setVisibility(8);
        }
        Button sendBtn = getSendBtn();
        if (sendBtn != null) {
            sendBtn.setText("\u786e\u5b9a");
        }
        return bottomView;
    }
}
