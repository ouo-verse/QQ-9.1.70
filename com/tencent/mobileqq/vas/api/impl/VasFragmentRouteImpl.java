package com.tencent.mobileqq.vas.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.app.ActivityOptionsCompat;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.ai.AIAvatarHomeFragment;
import com.tencent.mobileqq.microapp.sdk.MiniAppBridgeActivity;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pendant.AvatarPendantShopFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quiprofile.AIAvatarProfileThemeActivity;
import com.tencent.mobileqq.vas.api.IAIAvatarConfig;
import com.tencent.mobileqq.vas.api.IVasFragmentRoute;
import com.tencent.mobileqq.vas.pendant.api.IPendantAvatarShopReport;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasFragmentRouteImpl;", "Lcom/tencent/mobileqq/vas/api/IVasFragmentRoute;", "()V", "insertAvatarPendantInfo", "", "intent", "Landroid/content/Intent;", "pathList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "openAvatarPendantShop", "context", "Landroid/app/Activity;", "from", "shareView", "Landroid/view/View;", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasFragmentRouteImpl implements IVasFragmentRoute {
    @Override // com.tencent.mobileqq.vas.api.IVasFragmentRoute
    public void insertAvatarPendantInfo(@NotNull Intent intent, @NotNull ArrayList<String> pathList) {
        boolean z16;
        Class cls;
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(pathList, "pathList");
        if (PadUtil.a(BaseApplication.context) == DeviceType.FOLD) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            intent.putExtra(MiniAppBridgeActivity.KEY_LAUNCH_PARAM, new com.tencent.mobileqq.pad.b().g(false).h(LaunchMode.singleTop).a());
            intent.putExtra("is_add_fragment", true);
            if (((IAIAvatarConfig) QRoute.api(IAIAvatarConfig.class)).enableAvatarNewPage()) {
                cls = AIAvatarHomeFragment.class;
            } else {
                cls = AvatarPendantShopFragment.class;
            }
            intent.putExtra("top_fragment_class", cls.getCanonicalName());
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("PhotoConst.PHOTO_PATHS", pathList);
            if (pathList.size() == 1) {
                bundle.putString("PhotoConst.SINGLE_PHOTO_PATH", pathList.get(0));
            }
            intent.putExtra("extra_argument", bundle);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasFragmentRoute
    public void openAvatarPendantShop(@NotNull Activity context, @NotNull String from) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(from, "from");
        openAvatarPendantShop(context, from, null);
    }

    @Override // com.tencent.mobileqq.vas.api.IVasFragmentRoute
    public void openAvatarPendantShop(@NotNull Activity context, @NotNull String from, @Nullable View shareView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(from, "from");
        ((IPendantAvatarShopReport) QRoute.api(IPendantAvatarShopReport.class)).setPositionId(from);
        boolean z16 = PadUtil.a(context) == DeviceType.FOLD;
        Class cls = ((IAIAvatarConfig) QRoute.api(IAIAvatarConfig.class)).enableAvatarNewPage() ? AIAvatarHomeFragment.class : AvatarPendantShopFragment.class;
        if (z16) {
            com.tencent.mobileqq.pad.i.e(context, null, cls, new com.tencent.mobileqq.pad.b().g(false).h(LaunchMode.singleTop).a());
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("public_fragment_class", cls.getName());
        if (((IAIAvatarConfig) QRoute.api(IAIAvatarConfig.class)).enableAvatarNewPage()) {
            intent.setClass(context, AIAvatarProfileThemeActivity.class);
        } else {
            intent.setClass(context, QPublicFragmentActivity.class);
        }
        if (shareView != null && ((IAIAvatarConfig) QRoute.api(IAIAvatarConfig.class)).enableAvatarPageTransitionAnim()) {
            intent.putExtra("public_fragment_window_feature", 13);
            ActivityOptionsCompat makeSceneTransitionAnimation = ActivityOptionsCompat.makeSceneTransitionAnimation(context, shareView, "avatar");
            Intrinsics.checkNotNullExpressionValue(makeSceneTransitionAnimation, "makeSceneTransitionAnima\u2026ext, shareView, \"avatar\")");
            context.startActivity(intent, makeSceneTransitionAnimation.toBundle());
            return;
        }
        context.startActivity(intent);
    }
}
