package com.tencent.mobileqq.vas.pendant.api;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.avatar.g;
import com.tencent.mobileqq.vip.api.VipData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012J6\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0004H&J\b\u0010\u0010\u001a\u00020\u000fH&J\b\u0010\u0011\u001a\u00020\u000fH&\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/pendant/api/IPendantManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "pendantId", "", "targetId", "", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "diyId", "Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;", "numberInfo", "Lcom/tencent/mobileqq/vas/avatar/g;", "getPendantDrawable", "id", "Landroid/graphics/drawable/Drawable;", "", "pause", "resume", "Companion", "vas_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IPendantManager extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int PENDANT_TARGET_ID_AIO = 8;
    public static final int PENDANT_TARGET_ID_ALL = 5;
    public static final int PENDANT_TARGET_ID_DRAWER = 6;
    public static final int PENDANT_TARGET_ID_MARKET = 7;
    public static final int PENDANT_TARGET_ID_PHOTOCROP = 3;
    public static final int PENDANT_TARGET_ID_PROFILE = 1;
    public static final int PENDANT_TARGET_ID_PROFILE_PREVIEW = 2;
    public static final int PENDANT_TARGET_ID_RECENT = 9;
    public static final int PENDANT_TARGET_ID_THUMB = 4;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/vas/pendant/api/IPendantManager$Companion;", "", "()V", "PENDANT_TARGET_ID_AIO", "", "PENDANT_TARGET_ID_ALL", "PENDANT_TARGET_ID_DRAWER", "PENDANT_TARGET_ID_MARKET", "PENDANT_TARGET_ID_PHOTOCROP", "PENDANT_TARGET_ID_PROFILE", "PENDANT_TARGET_ID_PROFILE_PREVIEW", "PENDANT_TARGET_ID_RECENT", "PENDANT_TARGET_ID_THUMB", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int PENDANT_TARGET_ID_AIO = 8;
        public static final int PENDANT_TARGET_ID_ALL = 5;
        public static final int PENDANT_TARGET_ID_DRAWER = 6;
        public static final int PENDANT_TARGET_ID_MARKET = 7;
        public static final int PENDANT_TARGET_ID_PHOTOCROP = 3;
        public static final int PENDANT_TARGET_ID_PROFILE = 1;
        public static final int PENDANT_TARGET_ID_PROFILE_PREVIEW = 2;
        public static final int PENDANT_TARGET_ID_RECENT = 9;
        public static final int PENDANT_TARGET_ID_THUMB = 4;

        Companion() {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ g getPendantDrawable$default(IPendantManager iPendantManager, long j3, int i3, String str, int i16, VipData.VipNumberInfo vipNumberInfo, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 16) != 0) {
                    vipNumberInfo = null;
                }
                return iPendantManager.getPendantDrawable(j3, i3, str, i16, vipNumberInfo);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPendantDrawable");
        }
    }

    @NotNull
    Drawable getPendantDrawable(int id5);

    @Nullable
    g getPendantDrawable(long pendantId, int targetId, @NotNull String senderUin, int diyId, @Nullable VipData.VipNumberInfo numberInfo);

    void pause();

    void resume();
}
