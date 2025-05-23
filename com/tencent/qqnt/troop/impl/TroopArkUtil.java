package com.tencent.qqnt.troop.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopArkApi;
import com.tencent.qqnt.troop.TroopBatchFetch;
import com.tencent.qqnt.troopmemberlist.datasync.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J*\u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u0014\u0010\u0013\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/troop/impl/TroopArkUtil;", "Lcom/tencent/qqnt/troop/ITroopArkApi;", "", "troopUin", "Lcom/tencent/qqnt/troopmemberlist/datasync/e;", "data", "", "onBatchGetTroopInfoResp", "", "result", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "detailInfo", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "troopInfoData", "dealWithDetailInfo", "infoData", "realOpenTroopManage", "params", "openTroopManageForScheme", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class TroopArkUtil implements ITroopArkApi {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final TroopArkUtil INSTANCE;

    @NotNull
    private static final String TAG = "TroopArkApiImpl";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63193);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new TroopArkUtil();
        }
    }

    TroopArkUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void dealWithDetailInfo(int result, TroopInfo detailInfo, TroopInfoData troopInfoData, String troopUin) {
        TroopInfo troopInfo;
        if (result == 72) {
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            QQToast.makeText(qBaseActivity, R.string.bnu, 1).show(qBaseActivity.getTitleBarHeight());
            return;
        }
        if (detailInfo != null) {
            troopInfoData.coverFrom(detailInfo);
            ITroopInfoService iTroopInfoService = (ITroopInfoService) bg.l(ITroopInfoService.class);
            if (iTroopInfoService != null) {
                troopInfo = iTroopInfoService.findTroopInfo(troopUin);
            } else {
                troopInfo = null;
            }
            if (troopInfo != null) {
                troopInfoData.newTroopName = troopInfo.getTroopDisplayName();
            }
            troopInfoData.isQidianPrivateTroop = TroopInfo.isQidianPrivateTroop(detailInfo.dwGroupFlagExt3);
            return;
        }
        QLog.e(TAG, 1, "[batchOidbResp] detailInfo is null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBatchGetTroopInfoResp(String troopUin, e data) {
        QLog.i(TAG, 1, "[onBatchGetTroopInfoResp] isSus:" + data.n() + " ");
        if (data.k() == null) {
            QLog.e(TAG, 1, "[onBatchGetTroopInfoResp] data detailInfo is null!");
            return;
        }
        TroopInfoData troopInfoData = new TroopInfoData();
        troopInfoData.isMember = true;
        dealWithDetailInfo(data.l(), data.k(), troopInfoData, troopUin);
        realOpenTroopManage(troopUin, troopInfoData);
    }

    private final void realOpenTroopManage(String troopUin, TroopInfoData infoData) {
        String str;
        Intent intent = new Intent();
        AppInterface e16 = bg.e();
        if (e16 != null) {
            str = e16.getCurrentAccountUin();
        } else {
            str = null;
        }
        intent.putExtra("uin", str);
        intent.putExtra("troop_uin", troopUin);
        intent.putExtra(AppConstants.Key.FORWARD_LOCATION, infoData.troopLocation);
        intent.putExtra(AppConstants.Key.FORWARD_LATITUDE, infoData.troopLat);
        intent.putExtra(AppConstants.Key.FORWARD_LONGITUDE, infoData.troopLon);
        intent.putExtra(AppConstants.Key.FORWARD_CITYID, infoData.cityId);
        intent.putExtra(AppConstants.Key.KEY_QIDIAN_PRIVATE_TROOP, infoData.isQidianPrivateTroop);
        QPublicFragmentActivity.startForResult(QBaseActivity.sTopActivity, intent, ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).getTroopManageClass(), -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v17, types: [T, java.lang.Object, java.lang.String] */
    @Override // com.tencent.qqnt.troop.ITroopArkApi
    public void openTroopManageForScheme(@NotNull String params) {
        TroopInfo troopInfo;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        try {
            ?? optString = new JSONObject(params).optString("gc");
            Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"gc\")");
            objectRef.element = optString;
            if (TextUtils.isEmpty((CharSequence) optString)) {
                QLog.e(TAG, 1, "[openTroopManage] troopUin empty!");
                return;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "json error!", e16);
        }
        ITroopInfoService iTroopInfoService = (ITroopInfoService) bg.l(ITroopInfoService.class);
        if (iTroopInfoService != null) {
            troopInfo = iTroopInfoService.findTroopInfo((String) objectRef.element);
        } else {
            troopInfo = null;
        }
        if (troopInfo != null && troopInfo.isOwnerOrAdmin()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            TroopBatchFetch.c((String) objectRef.element, true, null, TAG, new Function1<e, Unit>(objectRef) { // from class: com.tencent.qqnt.troop.impl.TroopArkUtil$openTroopManageForScheme$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Ref.ObjectRef<String> $troopUin;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$troopUin = objectRef;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) objectRef);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(e eVar) {
                    invoke2(eVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull e it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    } else {
                        Intrinsics.checkNotNullParameter(it, "it");
                        TroopArkUtil.INSTANCE.onBatchGetTroopInfoResp(this.$troopUin.element, it);
                    }
                }
            });
        } else {
            QQToast.makeText((Context) null, 1, "\u975e\u7fa4\u4e3b\u6216\u8005\u7ba1\u7406\u5458!", 0).show();
        }
    }
}
