package com.qzone.homepage.ui.component.newpanel;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.utils.EntryConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import cooperation.qzone.music.QzoneMusicConst;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class k {
    public static void a(Activity activity, HomePanelItem homePanelItem) {
        if (activity == null) {
            RFWLog.e("PanelEventLogic", RFWLog.USR, "[handleGameBarClick] activity is null");
            return;
        }
        BusinessInfoCheckUpdate.AppInfo appInfo = new BusinessInfoCheckUpdate.AppInfo();
        byte[] bArr = homePanelItem.businessAppInfoBytes;
        if (bArr != null) {
            try {
                appInfo.mergeFrom(bArr);
            } catch (Exception e16) {
                RFWLog.fatal("PanelEventLogic", RFWLog.USR, e16);
            }
        }
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[handleGameBarClick] hasBusinessAppInfoBytes: ");
        sb5.append(homePanelItem.businessAppInfoBytes != null);
        sb5.append(", jump_url = ");
        sb5.append(homePanelItem.jumpUrl);
        objArr[0] = sb5.toString();
        RFWLog.d("PanelEventLogic", i3, objArr);
        if (homePanelItem.businessAppInfoBytes != null) {
            com.qzone.business.tianshu.l.a(activity, appInfo);
        } else if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(homePanelItem.jumpUrl)) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportMiniGameCenterDC00087("1", "969", "9044", "904401", "209626", "20", EntryConstants.LEBA_ENTRY);
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniGameCenter(activity, EntryConstants.LEBA_ENTRY);
        } else {
            vo.c.l(activity, homePanelItem.jumpUrl);
        }
    }

    public static void b(Activity activity, long j3, HomePanelItem homePanelItem, x6.a aVar, int i3) {
        Intent e16;
        int i16;
        String str;
        if (homePanelItem == null) {
            return;
        }
        String str2 = homePanelItem.jumpUrl;
        if (homePanelItem.tabId == 17) {
            a(activity, homePanelItem);
        } else if ("mqzone://arouse/persionsetting".equals(str2)) {
            vo.c.M(activity, IVipTraceDetailReport.FROM.QZONE_DRESS_UP_PRESONAL);
        } else if (!TextUtils.isEmpty(str2)) {
            HashMap hashMap = new HashMap();
            hashMap.put("uin", Long.valueOf(j3));
            yo.d.e(str2, activity, null, hashMap);
        } else if (homePanelItem.tabId == 7) {
            if (aVar != null && aVar.bgVoiceType == 3) {
                e16 = e8.f.a().c().k(j3, QzoneMusicConst.QusicFrom.HOME_PAGE);
            } else {
                e16 = e8.f.a().c().e(j3, QzoneMusicConst.QusicFrom.HOME_PAGE);
            }
            if (e16 != null) {
                activity.startActivity(e16);
            }
        }
        if (i3 == 0) {
            i16 = 126;
        } else if (i3 != 1) {
            return;
        } else {
            i16 = 127;
        }
        int i17 = homePanelItem.tabId * 100;
        ArrayList<RedInfo> arrayList = homePanelItem.redInfos;
        if (arrayList != null && arrayList.size() > 0) {
            str = "1";
        } else {
            str = "0";
        }
        LpReportInfo_pf00064.allReport(i16, i17, 2, str);
    }
}
