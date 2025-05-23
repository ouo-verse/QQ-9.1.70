package com.tencent.mobileqq.troop.utils;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.GrayTipsMessageConstants$HighlightItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public class an {
    static IPatchRedirector $redirector_;

    public static void a(AppRuntime appRuntime, String str, String str2, List<String> list, long j3) {
        if (System.currentTimeMillis() <= LocalMultiProcConfig.getLong4Uin(QzoneConfig.QZONE_CONFIG_MAIN_KEY_TROOP_GRAY_TIPS, 0L, Long.parseLong(str2)) * 1000) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopGrayTipUtils", 2, "Unable to display gray tips during cool down");
                return;
            }
            return;
        }
        int config = QzoneConfig.getInstance().getConfig(QzoneConfig.QZONE_CONFIG_MAIN_KEY_TROOP_GRAY_TIPS, QzoneConfig.QZONE_CONFIG_SECONDARY_KEY_TROOP_GRAY_TIPS_MIN_PHOTO_COUNT, 9);
        if (list.size() < config) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopGrayTipUtils", 2, "Unable to display gray tips, current photos count: " + list.size() + " required min photos count: " + config);
                return;
            }
            return;
        }
        String qqStr = HardCodeUtil.qqStr(R.string.vtj);
        String qqStr2 = HardCodeUtil.qqStr(R.string.vth);
        String qqStr3 = HardCodeUtil.qqStr(R.string.vti);
        String str3 = qqStr + " " + qqStr2 + " " + qqStr3;
        com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(str, str2, str3, 1, MessageRecord.MSG_TYPE_UNITE_GRAY_NORMAL, 131086, System.currentTimeMillis() / 1000);
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (i3 != list.size() - 1) {
                sb5.append(list.get(i3));
                sb5.append(",");
            } else {
                sb5.append(list.get(i3));
            }
        }
        ArrayList<GrayTipsMessageConstants$HighlightItem> arrayList = new ArrayList<>();
        int color = BaseApplicationImpl.getApplication().getResources().getColor(R.color.ang);
        GrayTipsMessageConstants$HighlightItem grayTipsMessageConstants$HighlightItem = new GrayTipsMessageConstants$HighlightItem(0, qqStr.length(), Long.parseLong(str2), 0, 50, sb5.toString(), "", "", "", color);
        GrayTipsMessageConstants$HighlightItem grayTipsMessageConstants$HighlightItem2 = new GrayTipsMessageConstants$HighlightItem(str3.length() - qqStr3.length(), str3.length(), Long.parseLong(str2), 0, 51, "", "", "", "", color);
        arrayList.add(grayTipsMessageConstants$HighlightItem);
        arrayList.add(grayTipsMessageConstants$HighlightItem2);
        gVar.k(arrayList);
        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
        messageForUniteGrayTip.initGrayTipMsg(appRuntime, gVar);
        messageForUniteGrayTip.saveExtInfoToExtStr("grayLastUniseq", j3 + "");
        com.tencent.mobileqq.graytip.f.a(appRuntime, messageForUniteGrayTip);
        LpReportInfo_pf00064.allReport(40, 3, 1);
    }
}
