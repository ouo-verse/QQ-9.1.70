package com.tencent.mobileqq.vas.avatar.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.avatar.IVasAvatarView;
import com.tencent.mobileqq.vas.avatar.g;
import com.tencent.mobileqq.vip.api.VipData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&JH\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\bH&JV\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u000f\u001a\u00020\bH&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/vas/avatar/api/IVasAvatarManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/vas/avatar/IVasAvatarView;", "getVasAvatarView", "", "uin", "", "faceId", "headSize", "shopSource", "useSource", "Lcom/tencent/mobileqq/vas/avatar/api/IVasAvatarManager$DrawableCreateCallback;", "createSuccessCallback", "specialShapeMaskId", "", "getVasAvatarDrawable", "Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;", "numberInfo", "", "isAutoDownload", "Lcom/tencent/mobileqq/vas/avatar/g;", "DrawableCreateCallback", "vas_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasAvatarManager extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void getVasAvatarDrawable$default(IVasAvatarManager iVasAvatarManager, String str, int i3, int i16, int i17, int i18, DrawableCreateCallback drawableCreateCallback, int i19, int i26, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVasAvatarDrawable");
            }
            iVasAvatarManager.getVasAvatarDrawable(str, i3, (i26 & 4) != 0 ? 200 : i16, (i26 & 8) != 0 ? 0 : i17, (i26 & 16) != 0 ? -1 : i18, drawableCreateCallback, (i26 & 64) != 0 ? 0 : i19);
        }

        public static /* synthetic */ g getVasAvatarDrawable$default(IVasAvatarManager iVasAvatarManager, String str, int i3, int i16, int i17, int i18, VipData.VipNumberInfo vipNumberInfo, boolean z16, int i19, int i26, Object obj) {
            if (obj == null) {
                return iVasAvatarManager.getVasAvatarDrawable(str, i3, (i26 & 4) != 0 ? 200 : i16, (i26 & 8) != 0 ? 0 : i17, (i26 & 16) != 0 ? -1 : i18, (i26 & 32) != 0 ? null : vipNumberInfo, (i26 & 64) != 0 ? true : z16, (i26 & 128) != 0 ? 0 : i19);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVasAvatarDrawable");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/avatar/api/IVasAvatarManager$DrawableCreateCallback;", "", "createCallback", "", "d", "Landroid/graphics/drawable/Drawable;", "createFail", "code", "", "msg", "", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public interface DrawableCreateCallback {
        void createCallback(@Nullable Drawable d16);

        void createFail(int code, @Nullable String msg2);
    }

    @NotNull
    g getVasAvatarDrawable(@NotNull String uin, int faceId, int headSize, int shopSource, int useSource, @Nullable VipData.VipNumberInfo numberInfo, boolean isAutoDownload, int specialShapeMaskId);

    void getVasAvatarDrawable(@NotNull String uin, int faceId, int headSize, int shopSource, int useSource, @NotNull DrawableCreateCallback createSuccessCallback, int specialShapeMaskId);

    @NotNull
    IVasAvatarView getVasAvatarView(@NotNull Context context);
}
