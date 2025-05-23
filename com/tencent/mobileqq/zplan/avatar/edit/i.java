package com.tencent.mobileqq.zplan.avatar.edit;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J)\u0010\t\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002J(\u0010\u000f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/edit/i;", "", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "itemId", "", "callBack", "c", "Lmqq/app/AppRuntime;", "app", "", "actionId", "avatarEntrance", "b", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f331655a = new i();

    i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function1 callBack, boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
        Intrinsics.checkNotNullParameter(callBack, "$callBack");
        QLog.d("ZPlanAvatarEditEntranceRedDotHelper", 2, "ongetAdvs result " + z16);
        if (!z16 || getAdsRsp == null) {
            return;
        }
        List<TianShuAccess.RspEntry> list = getAdsRsp.mapAds.has() ? getAdsRsp.mapAds.get() : null;
        if (list == null) {
            QLog.w("ZPlanAvatarEditEntranceRedDotHelper", 1, "rspEntries == null");
            return;
        }
        HashMap hashMap = new HashMap();
        for (TianShuAccess.RspEntry rspEntry : list) {
            if (rspEntry.key.has()) {
                hashMap.put(Integer.valueOf(rspEntry.key.get()), rspEntry);
            }
        }
        TianShuAccess.RspEntry rspEntry2 = (TianShuAccess.RspEntry) hashMap.get(1131);
        if (rspEntry2 == null) {
            return;
        }
        TianShuAccess.AdPlacementInfo adPlacementInfo = rspEntry2.value;
        Intrinsics.checkNotNullExpressionValue(adPlacementInfo, "rspEntry.value");
        List<TianShuAccess.AdItem> list2 = adPlacementInfo.lst.get();
        Intrinsics.checkNotNullExpressionValue(list2, "adPlacementInfo.lst.get()");
        String str = "";
        String str2 = "";
        for (TianShuAccess.AdItem adItem : list2) {
            List<TianShuAccess.MapEntry> list3 = adItem.argList.get();
            Intrinsics.checkNotNullExpressionValue(list3, "item.argList.get()");
            for (TianShuAccess.MapEntry mapEntry : list3) {
                if (Intrinsics.areEqual(RedTouchWebviewHandler.PLUGIN_NAMESPACE, mapEntry.key.get())) {
                    str = mapEntry.value.get();
                    Intrinsics.checkNotNullExpressionValue(str, "mapEntry.value.get()");
                    int i3 = adItem.iAdId.get();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(i3);
                    str2 = sb5.toString();
                }
            }
        }
        if (Intrinsics.areEqual("1", str)) {
            QLog.i("ZPlanAvatarEditEntranceRedDotHelper", 1, "reportRedDotData: " + str2);
            callBack.invoke(str2);
        }
    }

    public final void b(AppRuntime app, String itemId, int actionId, int avatarEntrance) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        TianShuReportData tianShuReportData = new TianShuReportData();
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mTraceId = (app != null ? app.getCurrentUin() : null) + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = "tianshu.1131";
        tianShuReportData.mPageId = "tianshu.1131";
        tianShuReportData.mItemId = itemId;
        tianShuReportData.mOperTime = serverTimeMillis;
        tianShuReportData.mActionId = actionId;
        tianShuReportData.mActionValue = 1;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("avatar_entrance", String.valueOf(avatarEntrance));
        tianShuReportData.mBusiInfo = jSONObject.toString();
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
    }

    public final void c(final Function1<? super String, Unit> callBack) {
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        ArrayList arrayList = new ArrayList();
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = 1131;
        tianShuAdPosItemData.mNeedCnt = 1;
        arrayList.add(tianShuAdPosItemData);
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).requestAdv(arrayList, new TianShuGetAdvCallback() { // from class: com.tencent.mobileqq.zplan.avatar.edit.h
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public final void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                i.d(Function1.this, z16, getAdsRsp);
            }
        });
    }
}
