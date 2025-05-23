package com.tencent.mobileqq.vas.api.impl;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheQzoneVipData;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.minigame.minigamecenter.hippy.MiniGameCenterHippyFragment;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.vas.api.IVasAdv;
import cooperation.vip.pb.TianShuAccess;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasAdvImpl;", "Lcom/tencent/mobileqq/vas/api/IVasAdv;", "()V", "readQzoneWidgetCache", "", "requestQzoneWidget", "", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasAdvImpl implements IVasAdv {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestQzoneWidget$lambda$3(int i3, boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField;
        if (getAdsRsp == null) {
            return;
        }
        List<TianShuAccess.RspEntry> ads = getAdsRsp.mapAds.get();
        Intrinsics.checkNotNullExpressionValue(ads, "ads");
        for (TianShuAccess.RspEntry rspEntry : ads) {
            if (rspEntry.key.get() == i3 && (pBRepeatMessageField = (adPlacementInfo = rspEntry.value.get()).lst) != null && pBRepeatMessageField.size() > 0) {
                TianShuAccess.AdItem adItem = adPlacementInfo.lst.get(0);
                Intrinsics.checkNotNullExpressionValue(adItem, "infos.lst.get(0)");
                TianShuAccess.AdItem adItem2 = adItem;
                JSONObject jSONObject = new JSONObject();
                List<TianShuAccess.MapEntry> list = adItem2.argList.get();
                Intrinsics.checkNotNullExpressionValue(list, "adItem.argList.get()");
                for (TianShuAccess.MapEntry mapEntry : list) {
                    String str = mapEntry.key.get();
                    if (str != null) {
                        switch (str.hashCode()) {
                            case -1835716190:
                                if (str.equals(WidgetCacheQzoneVipData.SHOW_ADV_DURATION)) {
                                    String str2 = mapEntry.value.get();
                                    Intrinsics.checkNotNullExpressionValue(str2, "it.value.get()");
                                    jSONObject.put(str, Long.parseLong(str2));
                                    break;
                                } else {
                                    break;
                                }
                            case 116765:
                                if (str.equals("vip")) {
                                    jSONObject.put(str, mapEntry.value.get());
                                    break;
                                } else {
                                    break;
                                }
                            case 3321850:
                                if (str.equals(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK)) {
                                    jSONObject.put(str, mapEntry.value.get());
                                    break;
                                } else {
                                    break;
                                }
                            case 105010876:
                                if (str.equals("novip")) {
                                    jSONObject.put(str, mapEntry.value.get());
                                    break;
                                } else {
                                    break;
                                }
                            case 1231939563:
                                if (str.equals(WidgetCacheQzoneVipData.KEEP_SHOW_ADV)) {
                                    String str3 = mapEntry.value.get();
                                    Intrinsics.checkNotNullExpressionValue(str3, "it.value.get()");
                                    jSONObject.put(str, Integer.parseInt(str3));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                }
                jSONObject.put(MiniGameCenterHippyFragment.EXTRA_KEY_AD_TRACE_INFO, adItem2.traceinfo.get());
                jSONObject.put("adId", adItem2.iAdId.get());
                VipMMKV.INSTANCE.getQzoneVipData(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin()).encodeString("adv_widget", jSONObject.toString());
                return;
            }
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAdv
    @NotNull
    public String readQzoneWidgetCache() {
        String decodeString = VipMMKV.INSTANCE.getQzoneVipData(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin()).decodeString("adv_widget", "");
        Intrinsics.checkNotNull(decodeString);
        return decodeString;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasAdv
    public void requestQzoneWidget() {
        List<TianShuAdPosItemData> listOf;
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        final int i3 = 174;
        tianShuAdPosItemData.mPosId = 174;
        tianShuAdPosItemData.mNeedCnt = 1;
        ITianshuManager iTianshuManager = (ITianshuManager) QRoute.api(ITianshuManager.class);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(tianShuAdPosItemData);
        iTianshuManager.requestAdv(listOf, new TianShuGetAdvCallback() { // from class: com.tencent.mobileqq.vas.api.impl.x
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public final void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                VasAdvImpl.requestQzoneWidget$lambda$3(i3, z16, getAdsRsp);
            }
        });
    }
}
