package com.tencent.robot.profile.parts;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.robot.profile.RobotProfileViewModel;
import com.tencent.util.QUIProfileConstants;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import w24.RobotColorPalette;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019\u00a8\u0006!"}, d2 = {"Lcom/tencent/robot/profile/parts/RobotProfileImmersivePart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "robotProfile", "", "C9", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/robot/profile/RobotProfileViewModel;", "d", "Lcom/tencent/robot/profile/RobotProfileViewModel;", "viewModel", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "loadingContainer", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "loadingHeader", "i", "loadingFooter", "<init>", "(Lcom/tencent/robot/profile/RobotProfileViewModel;Landroidx/lifecycle/LifecycleOwner;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotProfileImmersivePart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotProfileViewModel viewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner viewLifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ViewGroup loadingContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView loadingHeader;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView loadingFooter;

    public RobotProfileImmersivePart(@NotNull RobotProfileViewModel viewModel, @NotNull LifecycleOwner viewLifecycleOwner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        this.viewModel = viewModel;
        this.viewLifecycleOwner = viewLifecycleOwner;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C9(GroupRobotProfile robotProfile) {
        Intent intent;
        Activity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            return;
        }
        intent.putExtra("key_day_color", com.tencent.robot.profile.utils.a.k(robotProfile, true));
        intent.putExtra("key_night_color", com.tencent.robot.profile.utils.a.r(robotProfile, true));
        intent.putExtra("key_avatar_dominantColor", robotProfile.avatarDominantColor);
        RobotColorPalette d16 = w24.c.f444463a.d(intent.getExtras(), QUIProfileConstants.PROFILE_ID_ROBOT_PROFILE);
        be0.a.b(d16.getProfileId()).c(d16.getColorPalette());
        intent.putExtra("key_open_color_palette", true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "robot.profile.RobotProfileImmersivePart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f772343t);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026_profile_blank_container)");
        this.loadingContainer = (ViewGroup) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f772943z);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026file_loading_header_view)");
        this.loadingHeader = (ImageView) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f772843y);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026file_loading_footer_view)");
        this.loadingFooter = (ImageView) findViewById3;
        Window window = null;
        if (QQTheme.isNowThemeIsNight()) {
            ImageView imageView = this.loadingHeader;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingHeader");
                imageView = null;
            }
            Drawable drawable = imageView.getDrawable();
            drawable.setTintMode(PorterDuff.Mode.SRC_IN);
            drawable.setTintList(ColorStateList.valueOf(-1));
            ImageView imageView2 = this.loadingFooter;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadingFooter");
                imageView2 = null;
            }
            Drawable drawable2 = imageView2.getDrawable();
            drawable2.setTintMode(PorterDuff.Mode.SRC_IN);
            drawable2.setTintList(ColorStateList.valueOf(-1));
        }
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getContext()) + com.tencent.biz.qui.quisecnavbar.f.g();
        ViewGroup viewGroup = this.loadingContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
            viewGroup = null;
        }
        viewGroup.setPadding(viewGroup.getPaddingLeft(), statusBarHeight + ViewUtils.dip2px(198.0f), viewGroup.getPaddingRight(), viewGroup.getPaddingBottom());
        LiveData<GroupRobotProfile> r26 = this.viewModel.r2();
        LifecycleOwner lifecycleOwner = this.viewLifecycleOwner;
        final Function1<GroupRobotProfile, Unit> function1 = new Function1<GroupRobotProfile, Unit>() { // from class: com.tencent.robot.profile.parts.RobotProfileImmersivePart$onInitView$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GroupRobotProfile groupRobotProfile) {
                invoke2(groupRobotProfile);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GroupRobotProfile it) {
                ViewGroup viewGroup2;
                viewGroup2 = RobotProfileImmersivePart.this.loadingContainer;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingContainer");
                    viewGroup2 = null;
                }
                viewGroup2.setVisibility(8);
                RobotProfileImmersivePart robotProfileImmersivePart = RobotProfileImmersivePart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                robotProfileImmersivePart.C9(it);
            }
        };
        r26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.robot.profile.parts.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RobotProfileImmersivePart.B9(Function1.this, obj);
            }
        });
        com.tencent.mobileqq.qui.b bVar = com.tencent.mobileqq.qui.b.f276860a;
        Activity activity = getActivity();
        if (activity != null) {
            window = activity.getWindow();
        }
        bVar.l(window);
    }
}
