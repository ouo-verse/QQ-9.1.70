package com.tencent.mobileqq.vas.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.vas.api.IPendantNumApi;
import com.tencent.mobileqq.vas.pendant.drawable.o;
import com.tencent.mobileqq.vip.api.VipData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J:\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/PendantNumApiImpl;", "Lcom/tencent/mobileqq/vas/api/IPendantNumApi;", "()V", "wrapPendantNum", "Landroid/graphics/drawable/Drawable;", "uin", "", "baseDrawable", "numberInfo", "Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo;", "needScale", "", "callback", "Lcom/tencent/mobileqq/vas/api/IPendantNumApi$LoadVipNumInfoCallback;", "appId", "Lcom/tencent/mobileqq/vip/api/VipData$VipNumberInfo$APPID;", "itemId", "", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class PendantNumApiImpl implements IPendantNumApi {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void wrapPendantNum$lambda$2$lambda$1(IPendantNumApi.LoadVipNumInfoCallback loadVipNumInfoCallback, VipData.VipNumberInfo info) {
        if (loadVipNumInfoCallback != null) {
            Intrinsics.checkNotNullExpressionValue(info, "info");
            loadVipNumInfoCallback.success(info);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void wrapPendantNum$lambda$4$lambda$3(IPendantNumApi.LoadVipNumInfoCallback loadVipNumInfoCallback, VipData.VipNumberInfo info) {
        if (loadVipNumInfoCallback != null) {
            Intrinsics.checkNotNullExpressionValue(info, "info");
            loadVipNumInfoCallback.success(info);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IPendantNumApi
    @NotNull
    public Drawable wrapPendantNum(@NotNull String uin, @NotNull Drawable baseDrawable, @NotNull VipData.VipNumberInfo.APPID appId, int itemId, boolean needScale, @Nullable final IPendantNumApi.LoadVipNumInfoCallback callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(baseDrawable, "baseDrawable");
        Intrinsics.checkNotNullParameter(appId, "appId");
        VipData.VipNumberInfo vipNumberInfo = new VipData.VipNumberInfo();
        vipNumberInfo.setAppId(appId.getId());
        vipNumberInfo.setItemId(itemId);
        Unit unit = Unit.INSTANCE;
        com.tencent.mobileqq.vas.pendant.drawable.o oVar = new com.tencent.mobileqq.vas.pendant.drawable.o(uin, baseDrawable, vipNumberInfo);
        oVar.E(needScale);
        oVar.D(new o.a() { // from class: com.tencent.mobileqq.vas.api.impl.o
            @Override // com.tencent.mobileqq.vas.pendant.drawable.o.a
            public final void success(VipData.VipNumberInfo vipNumberInfo2) {
                PendantNumApiImpl.wrapPendantNum$lambda$2$lambda$1(IPendantNumApi.LoadVipNumInfoCallback.this, vipNumberInfo2);
            }
        });
        oVar.A(true);
        return oVar;
    }

    @Override // com.tencent.mobileqq.vas.api.IPendantNumApi
    @NotNull
    public Drawable wrapPendantNum(@NotNull String uin, @NotNull Drawable baseDrawable, @NotNull VipData.VipNumberInfo numberInfo, boolean needScale, @Nullable final IPendantNumApi.LoadVipNumInfoCallback callback) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(baseDrawable, "baseDrawable");
        Intrinsics.checkNotNullParameter(numberInfo, "numberInfo");
        com.tencent.mobileqq.vas.pendant.drawable.o oVar = new com.tencent.mobileqq.vas.pendant.drawable.o(uin, baseDrawable, numberInfo);
        oVar.E(needScale);
        oVar.D(new o.a() { // from class: com.tencent.mobileqq.vas.api.impl.p
            @Override // com.tencent.mobileqq.vas.pendant.drawable.o.a
            public final void success(VipData.VipNumberInfo vipNumberInfo) {
                PendantNumApiImpl.wrapPendantNum$lambda$4$lambda$3(IPendantNumApi.LoadVipNumInfoCallback.this, vipNumberInfo);
            }
        });
        oVar.B(numberInfo, false);
        return oVar;
    }
}
