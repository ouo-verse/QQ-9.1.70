package com.tencent.mobileqq.zplan.couple.api;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.zplan.aio.couple.CoupleAvatarSubScene;
import com.tencent.mobileqq.zplan.aio.couple.i;
import com.tencent.mobileqq.zplan.couple.ZPlanCoupleSwitchChgSource;
import com.tencent.mobileqq.zplan.couple.config.ZPlanCoupleBubbleConfig;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J$\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0011H&J \u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0004H&J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H&J4\u0010 \u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH&J(\u0010#\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0012H&J\"\u0010$\u001a\u0004\u0018\u00010\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0012H&J\b\u0010%\u001a\u00020\tH&J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&H&J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0002H&J\u0010\u0010*\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u0002H&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/zplan/couple/api/IZPlanCoupleSceneHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "friendUin", "", "getCoupleAvatarSwitchState", "open", "Lcom/tencent/mobileqq/zplan/couple/ZPlanCoupleSwitchChgSource;", "source", "", "setCoupleAvatarSwitchState", "peerUin", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/zplan/aio/couple/i;", "getCoupleAvatarViewController", "clearCurrentCoupleAvatarViewController", "", "", "getCoupleSceneId", "sceneID", "needPush", "setCoupleSceneId", "Lcom/tencent/mobileqq/zplan/aio/couple/CoupleAvatarSubScene;", "subScene", "Lcom/tencent/mobileqq/zplan/couple/manager/a;", "createBubblePlayManager", "targetDrawableWidth", "targetDrawableHeight", "bgPicUrl", "Landroid/graphics/drawable/Drawable;", "lastBgDrawable", "getBackgroundDrawable", "selfUin", "uinType", "setZPlanChatBackgroundPicPath", "getZPlanChatBackgroundPicPath", "requestZPlanSettingBubbles", "", "Lcom/tencent/mobileqq/zplan/couple/config/a;", "getZPlanSettingBubbles", "getSettingBubbleShownMark", "setSettingBubbleShownMark", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes21.dex */
public interface IZPlanCoupleSceneHelper extends QRouteApi {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        public static /* synthetic */ i a(IZPlanCoupleSceneHelper iZPlanCoupleSceneHelper, String str, com.tencent.aio.api.runtime.a aVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    aVar = null;
                }
                return iZPlanCoupleSceneHelper.getCoupleAvatarViewController(str, aVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCoupleAvatarViewController");
        }
    }

    void clearCurrentCoupleAvatarViewController(@NotNull String peerUin, @NotNull com.tencent.aio.api.runtime.a aioContext);

    @NotNull
    com.tencent.mobileqq.zplan.couple.manager.a createBubblePlayManager(@NotNull CoupleAvatarSubScene subScene);

    @Nullable
    Drawable getBackgroundDrawable(@NotNull CoupleAvatarSubScene subScene, int targetDrawableWidth, int targetDrawableHeight, @NotNull String bgPicUrl, @Nullable Drawable lastBgDrawable);

    boolean getCoupleAvatarSwitchState(@NotNull String friendUin);

    @Nullable
    i getCoupleAvatarViewController(@NotNull String peerUin, @Nullable com.tencent.aio.api.runtime.a aioContext);

    int getCoupleSceneId(long friendUin);

    boolean getSettingBubbleShownMark(@NotNull String selfUin);

    @Nullable
    String getZPlanChatBackgroundPicPath(@NotNull String selfUin, @NotNull String friendUin, int uinType);

    @NotNull
    List<ZPlanCoupleBubbleConfig> getZPlanSettingBubbles();

    void requestZPlanSettingBubbles();

    void setCoupleAvatarSwitchState(@NotNull String friendUin, boolean open, @Nullable ZPlanCoupleSwitchChgSource source);

    void setCoupleSceneId(long friendUin, int sceneID, boolean needPush);

    void setSettingBubbleShownMark(@NotNull String selfUin);

    void setZPlanChatBackgroundPicPath(@NotNull String selfUin, @NotNull String friendUin, @NotNull String bgPicUrl, int uinType);
}
