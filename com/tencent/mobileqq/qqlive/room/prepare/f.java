package com.tencent.mobileqq.qqlive.room.prepare;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.ITimiGameApi;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class f {
    static IPatchRedirector $redirector_;

    public static void a(View view, String str, Map<String, String> map) {
        if (view != null) {
            ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().a(view, true, null, str, new HashMap(map));
        } else if (QLog.isColorLevel()) {
            QLog.d("PrepareDaTongHelper", 1, "the view is null");
        }
    }

    private static String b(k kVar) {
        QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare;
        QQLiveAnchorDataRoomAttr qQLiveAnchorDataRoomAttr;
        if (kVar == null || (qQLiveAnchorDataPrepare = kVar.f271954i) == null || (qQLiveAnchorDataRoomAttr = qQLiveAnchorDataPrepare.roomAttr) == null || qQLiveAnchorDataRoomAttr.liveRoomType != 0) {
            return "0";
        }
        return "1";
    }

    public static Map<String, String> c(k kVar, IQQLiveSDK iQQLiveSDK) {
        HashMap hashMap = new HashMap();
        if (kVar != null && kVar.W1() != null) {
            QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare = kVar.f271954i;
            hashMap.put("qqlive_zhibo_type", b(kVar));
            hashMap.put("qqlive_room_id", String.valueOf(qQLiveAnchorDataPrepare.roomInfo.f271212id));
            hashMap.put("qqlive_livestart_source", String.valueOf(kVar.b2()));
        }
        if (iQQLiveSDK.getLoginModule() != null && iQQLiveSDK.getLoginModule().getLoginInfo() != null) {
            String valueOf = String.valueOf(iQQLiveSDK.getLoginModule().getLoginInfo().uid);
            hashMap.put("qqlive_user_id", valueOf);
            hashMap.put("qqlive_anchor_id", valueOf);
        }
        hashMap.put("zengzhi_tracedetail ", "");
        return hashMap;
    }
}
