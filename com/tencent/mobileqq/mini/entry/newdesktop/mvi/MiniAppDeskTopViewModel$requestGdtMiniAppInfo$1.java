package com.tencent.mobileqq.mini.entry.newdesktop.mvi;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.entry.GdtAdManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataMiniAppAdManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopUIState;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/mini/entry/newdesktop/mvi/MiniAppDeskTopViewModel$requestGdtMiniAppInfo$1", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopDataMiniAppAdManager$MiniAppAdCallback;", "onGetMiniAppAdFailure", "", "errorCode", "", "errorMessage", "", "onGetMiniAppAdSuccess", "gdtAdInfo", "Lcom/tencent/gdtad/aditem/GdtAd;", "miniAppAdRequestIntervalTime", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppDeskTopViewModel$requestGdtMiniAppInfo$1 implements DesktopDataMiniAppAdManager.MiniAppAdCallback {
    final /* synthetic */ HashMap<Integer, List<DesktopItemInfo>> $miniAppInfoMap;
    final /* synthetic */ MiniAppDeskTopViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MiniAppDeskTopViewModel$requestGdtMiniAppInfo$1(MiniAppDeskTopViewModel miniAppDeskTopViewModel, HashMap<Integer, List<DesktopItemInfo>> hashMap) {
        this.this$0 = miniAppDeskTopViewModel;
        this.$miniAppInfoMap = hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onGetMiniAppAdSuccess$lambda$0(MiniAppDeskTopViewModel this$0, HashMap miniAppInfoMap, GdtAd gdtAdInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(miniAppInfoMap, "$miniAppInfoMap");
        Intrinsics.checkNotNullParameter(gdtAdInfo, "$gdtAdInfo");
        this$0.insertGdtAdInfo((List) miniAppInfoMap.get(1), gdtAdInfo);
        this$0.getMUiState().postValue(new MiniAppDeskTopUIState.UpdateDesktopMiniAppInfo(miniAppInfoMap, 1));
    }

    @Override // com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataMiniAppAdManager.MiniAppAdCallback
    public void onGetMiniAppAdFailure(int errorCode, String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        GdtAdManager.getInstance().updateLastAllowRequestTime(180);
        QLog.e(this.this$0.getTAG(), 1, "onGetMiniAppAdFailure errorCode:" + errorCode + "  errorMessage:" + errorMessage);
    }

    @Override // com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataMiniAppAdManager.MiniAppAdCallback
    public void onGetMiniAppAdSuccess(final GdtAd gdtAdInfo, int miniAppAdRequestIntervalTime) {
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo;
        PBStringField pBStringField;
        Intrinsics.checkNotNullParameter(gdtAdInfo, "gdtAdInfo");
        if (-1 != miniAppAdRequestIntervalTime) {
            GdtAdManager.getInstance().updateLastAllowRequestTime(miniAppAdRequestIntervalTime);
        }
        final MiniAppDeskTopViewModel miniAppDeskTopViewModel = this.this$0;
        final HashMap<Integer, List<DesktopItemInfo>> hashMap = this.$miniAppInfoMap;
        miniAppDeskTopViewModel.runningInMainThread(new Runnable() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.mvi.f
            @Override // java.lang.Runnable
            public final void run() {
                MiniAppDeskTopViewModel$requestGdtMiniAppInfo$1.onGetMiniAppAdSuccess$lambda$0(MiniAppDeskTopViewModel.this, hashMap, gdtAdInfo);
            }
        });
        String tag = this.this$0.getTAG();
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = gdtAdInfo.info;
        QLog.d(tag, 1, "onGetMiniAppAdSuccess getAdName" + ((adInfo == null || (displayInfo = adInfo.display_info) == null || (pBStringField = displayInfo.mini_program_name) == null) ? null : pBStringField.get()));
    }
}
