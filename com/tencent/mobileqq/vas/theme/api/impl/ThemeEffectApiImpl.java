package com.tencent.mobileqq.vas.theme.api.impl;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.api.IVasTempApi;
import com.tencent.mobileqq.vas.theme.AbsTintManger;
import com.tencent.mobileqq.vas.theme.api.IThemeEffectApi;
import com.tencent.mobileqq.vas.theme.api.IThemeVideoController;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.video.DefaultVideoController;
import com.tencent.mobileqq.vas.theme.video.LoopVideoController;
import com.tencent.mobileqq.vas.theme.video.SuperThemeVideoController;
import com.tencent.mobileqq.vas.theme.video.a;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.xaction.log.b;
import i33.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/theme/api/impl/ThemeEffectApiImpl;", "Lcom/tencent/mobileqq/vas/theme/api/IThemeEffectApi;", "()V", "createThemeVideoController", "Lcom/tencent/mobileqq/vas/theme/api/IThemeVideoController;", "getTintManagerV2", "Lcom/tencent/mobileqq/vas/theme/AbsTintManger;", "newLoopVideoController", "videoPath", "", "staticRes", "Landroid/graphics/drawable/Drawable;", "bgContainer", "Landroid/view/ViewGroup;", "switchAIOBackground", "", "isAvatar", "", "friendsUin", "uinType", "", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class ThemeEffectApiImpl implements IThemeEffectApi {
    @Override // com.tencent.mobileqq.vas.theme.api.IThemeEffectApi
    @NotNull
    public IThemeVideoController createThemeVideoController() {
        if (ThemeUtil.useNativeThemeVideoPlayer()) {
            if (ThemeUtil.isNowThemeIsSuperTheme()) {
                return new SuperThemeVideoController();
            }
            return new DefaultVideoController();
        }
        return new a();
    }

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeEffectApi
    @Nullable
    public AbsTintManger getTintManagerV2() {
        return c.instance();
    }

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeEffectApi
    @Nullable
    public IThemeVideoController newLoopVideoController(@NotNull String videoPath, @Nullable Drawable staticRes, @NotNull ViewGroup bgContainer) {
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        Intrinsics.checkNotNullParameter(bgContainer, "bgContainer");
        return new LoopVideoController(videoPath, staticRes, bgContainer);
    }

    @Override // com.tencent.mobileqq.vas.theme.api.IThemeEffectApi
    public void switchAIOBackground(boolean isAvatar, @NotNull String friendsUin, int uinType) {
        String str;
        Intrinsics.checkNotNullParameter(friendsUin, "friendsUin");
        if (isAvatar) {
            str = ChatBackgroundUtil.getShopBgPath("47967");
            Intrinsics.checkNotNullExpressionValue(str, "{\n            ChatBackgr\u2026_ID.toString())\n        }");
        } else {
            str = "null";
        }
        b.a("ThemeEffectApiImpl", 1, "switchAIOBackground isAvatar:" + isAvatar + ",uin:" + friendsUin + ",uinType:" + uinType);
        IVasTempApi.Companion companion = IVasTempApi.INSTANCE;
        QRouteApi api = QRoute.api(IVasTempApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IVasTempApi::class.java)");
        ((IVasTempApi) api).setCustomChatBackground(friendsUin, str, 0, uinType);
    }
}
