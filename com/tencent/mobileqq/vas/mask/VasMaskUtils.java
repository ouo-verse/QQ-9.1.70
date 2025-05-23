package com.tencent.mobileqq.vas.mask;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.mobileqq.vip.api.j;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0007*\u0001\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/mask/VasMaskUtils;", "", "", "uin", "", "getDefSpecialShapeMaskId", "getSpecialShapeBtnText", "getSpecialShapeBtnJumUrl", "TAG", "Ljava/lang/String;", "HEXAGON_SET_URL", "com/tencent/mobileqq/vas/mask/VasMaskUtils$specialAvatarMap$1", "specialAvatarMap", "Lcom/tencent/mobileqq/vas/mask/VasMaskUtils$specialAvatarMap$1;", "<init>", "()V", "a", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasMaskUtils {

    @NotNull
    private static final String HEXAGON_SET_URL = "https://zb.vip.qq.com/mall/hexagon?_wv=16777216";

    @NotNull
    private static final String TAG = "VasMaskUtils";

    @NotNull
    public static final VasMaskUtils INSTANCE = new VasMaskUtils();

    @NotNull
    private static VasMaskUtils$specialAvatarMap$1 specialAvatarMap = new VasMaskUtils$specialAvatarMap$1();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016R\"\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/mask/VasMaskUtils$a;", "Lcom/tencent/mobileqq/vip/api/j;", "Lcom/tencent/mobileqq/vip/api/VipData;", "newData", "oldData", "", "changed", "", "a", "I", "()I", "b", "(I)V", "specialAvatarId", "<init>", "()V", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements j {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private volatile int specialAvatarId = -1;

        /* renamed from: a, reason: from getter */
        public final int getSpecialAvatarId() {
            return this.specialAvatarId;
        }

        public final void b(int i3) {
            this.specialAvatarId = i3;
        }

        @Override // com.tencent.mobileqq.vip.api.j
        public void changed(@NotNull VipData newData, @Nullable VipData oldData) {
            Intrinsics.checkNotNullParameter(newData, "newData");
            this.specialAvatarId = newData.getSpecialAvatarId();
        }
    }

    VasMaskUtils() {
    }

    public final int getDefSpecialShapeMaskId(@Nullable String uin) {
        if (uin != null && !QQTheme.isNowSimpleUI()) {
            a aVar = (a) specialAvatarMap.get((Object) uin);
            if (aVar != null) {
                return aVar.getSpecialAvatarId();
            }
            QRouteApi api = QRoute.api(IVipDataUtils.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IVipDataUtils::class.java)");
            IVipDataUtils iVipDataUtils = (IVipDataUtils) api;
            a aVar2 = new a();
            specialAvatarMap.put(uin, aVar2);
            iVipDataUtils.registerVipDataChangedCallback(uin, aVar2);
            VipData vipDataForFriends = iVipDataUtils.getVipDataForFriends(uin);
            if (vipDataForFriends.getSpecialAvatarId() > 0) {
                aVar2.b(vipDataForFriends.getSpecialAvatarId());
                return vipDataForFriends.getSpecialAvatarId();
            }
        }
        return 0;
    }

    @NotNull
    public final String getSpecialShapeBtnJumUrl() {
        try {
            String string = VasLongToggle.AVATAR_SPECIAL_SHAPE.getJson().getString("jumpurl");
            if (TextUtils.isEmpty(string)) {
                return HEXAGON_SET_URL;
            }
            Intrinsics.checkNotNullExpressionValue(string, "{\n                url\n            }");
            return string;
        } catch (Exception e16) {
            QLog.w(TAG, 1, "getSpecialShapeBtnText e:" + e16);
            return "";
        }
    }

    @NotNull
    public final String getSpecialShapeBtnText() {
        try {
            String string = VasLongToggle.AVATAR_SPECIAL_SHAPE.getJson().getString("button");
            Intrinsics.checkNotNullExpressionValue(string, "AVATAR_SPECIAL_SHAPE.getJson().getString(\"button\")");
            return string;
        } catch (Exception e16) {
            QLog.w(TAG, 1, "getSpecialShapeBtnText e:" + e16);
            return "";
        }
    }
}
