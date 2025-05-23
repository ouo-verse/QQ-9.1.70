package com.tencent.mobileqq.vas.api;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vip.api.VipData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0011J6\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH&J>\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IPendantNumApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "wrapPendantNum", "Landroid/graphics/drawable/Drawable;", "uin", "", "baseDrawable", "numberInfo", "Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;", "needScale", "", "callback", "Lcom/tencent/mobileqq/vas/api/IPendantNumApi$LoadVipNumInfoCallback;", "appId", "Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo$APPID;", "itemId", "", "LoadVipNumInfoCallback", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IPendantNumApi extends QRouteApi {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Drawable wrapPendantNum$default(IPendantNumApi iPendantNumApi, String str, Drawable drawable, VipData.VipNumberInfo vipNumberInfo, boolean z16, LoadVipNumInfoCallback loadVipNumInfoCallback, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: wrapPendantNum");
            }
            if ((i3 & 8) != 0) {
                z16 = false;
            }
            boolean z17 = z16;
            if ((i3 & 16) != 0) {
                loadVipNumInfoCallback = null;
            }
            return iPendantNumApi.wrapPendantNum(str, drawable, vipNumberInfo, z17, loadVipNumInfoCallback);
        }

        public static /* synthetic */ Drawable wrapPendantNum$default(IPendantNumApi iPendantNumApi, String str, Drawable drawable, VipData.VipNumberInfo.APPID appid, int i3, boolean z16, LoadVipNumInfoCallback loadVipNumInfoCallback, int i16, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: wrapPendantNum");
            }
            if ((i16 & 16) != 0) {
                z16 = false;
            }
            boolean z17 = z16;
            if ((i16 & 32) != 0) {
                loadVipNumInfoCallback = null;
            }
            return iPendantNumApi.wrapPendantNum(str, drawable, appid, i3, z17, loadVipNumInfoCallback);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IPendantNumApi$LoadVipNumInfoCallback;", "", "success", "", "vipNumberInfo", "Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;", "vas_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public interface LoadVipNumInfoCallback {
        void success(@NotNull VipData.VipNumberInfo vipNumberInfo);
    }

    @NotNull
    Drawable wrapPendantNum(@NotNull String uin, @NotNull Drawable baseDrawable, @NotNull VipData.VipNumberInfo.APPID appId, int itemId, boolean needScale, @Nullable LoadVipNumInfoCallback callback);

    @NotNull
    Drawable wrapPendantNum(@NotNull String uin, @NotNull Drawable baseDrawable, @NotNull VipData.VipNumberInfo numberInfo, boolean needScale, @Nullable LoadVipNumInfoCallback callback);
}
