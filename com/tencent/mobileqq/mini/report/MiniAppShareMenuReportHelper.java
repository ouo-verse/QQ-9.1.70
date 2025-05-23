package com.tencent.mobileqq.mini.report;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppShareMenuReportHelper {
    private static final String DT_CUR_PG = "cur_pg";
    private static final String MINI_APP_ID = "app_id";
    private static final String SHARE_SHEET_CHANNEL_REPORT_KEY = "em_share_item";
    private static final String SHARE_SHEET_FRIEND_SHARE_KEY = "em_shareview_msg_icon_button";
    private static final String SHARE_SHEET_FUNCTION_REPORT_KEY = "em_bas_small_program_panel_function";
    private static final String SHARE_SOURCE = "share_source";
    private static final String TAG = "MiniAppShareMenuReportHelper";
    private Map<Integer, Integer> mShareChannelToReportIndexMap;
    private Map<Integer, Integer> mShareFunctionToReportIndexMap = new HashMap();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    private static class InstanceHolder {
        static final MiniAppShareMenuReportHelper INSTANCE = new MiniAppShareMenuReportHelper();

        InstanceHolder() {
        }
    }

    MiniAppShareMenuReportHelper() {
        HashMap hashMap = new HashMap();
        this.mShareChannelToReportIndexMap = hashMap;
        hashMap.put(2, 1);
        this.mShareChannelToReportIndexMap.put(3, 2);
        this.mShareChannelToReportIndexMap.put(9, 3);
        this.mShareChannelToReportIndexMap.put(10, 4);
        this.mShareChannelToReportIndexMap.put(184, 5);
        this.mShareChannelToReportIndexMap.put(171, 7);
        this.mShareFunctionToReportIndexMap.put(70, 1);
        this.mShareFunctionToReportIndexMap.put(76, 2);
        this.mShareFunctionToReportIndexMap.put(14, 3);
        this.mShareFunctionToReportIndexMap.put(128, 4);
        this.mShareFunctionToReportIndexMap.put(6, 5);
        this.mShareFunctionToReportIndexMap.put(158, 6);
        this.mShareFunctionToReportIndexMap.put(78, 7);
        this.mShareFunctionToReportIndexMap.put(83, 8);
        this.mShareFunctionToReportIndexMap.put(151, 9);
    }

    public static MiniAppShareMenuReportHelper getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void miniAppShareSheetItemClickReport(String str, String str2, int i3, int i16) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("biz_source", "biz_src_miniapp");
        hashMap2.put("pgid", "pg_qdesign_shareview");
        hashMap.put("cur_pg", hashMap2);
        hashMap.put("pgid", "pg_qdesign_shareview");
        String str3 = SHARE_SHEET_CHANNEL_REPORT_KEY;
        if (i16 != 2 && i16 != 3 && i16 != 9 && i16 != 10) {
            switch (i16) {
                case 6:
                case 14:
                case 70:
                case 76:
                case 78:
                case 83:
                case 128:
                case 151:
                case 158:
                    hashMap.put(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, this.mShareFunctionToReportIndexMap.get(Integer.valueOf(i16)));
                    str3 = SHARE_SHEET_FUNCTION_REPORT_KEY;
                    break;
                case 72:
                    hashMap.put("to_uin", str2);
                    hashMap.put("share_user_source", Integer.valueOf(i3));
                    str3 = SHARE_SHEET_FRIEND_SHARE_KEY;
                    break;
                case 171:
                case 184:
                    break;
                default:
                    hashMap.put(SHARE_SOURCE, 6);
                    break;
            }
            hashMap.put("eid", str3);
            hashMap.put("app_id", str);
            VideoReport.reportEvent("dt_clck", hashMap);
            QLog.d(TAG, 1, "miniAppShareSheetItemClickReport action:" + i16 + " key:" + str3);
        }
        hashMap.put(SHARE_SOURCE, this.mShareChannelToReportIndexMap.get(Integer.valueOf(i16)));
        hashMap.put("eid", str3);
        hashMap.put("app_id", str);
        VideoReport.reportEvent("dt_clck", hashMap);
        QLog.d(TAG, 1, "miniAppShareSheetItemClickReport action:" + i16 + " key:" + str3);
    }

    public void shareSheetShareFriendExpoReport(String str, List<String> list, List<Integer> list2) {
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            if (list.size() != list2.size()) {
                QLog.e(TAG, 1, "uinInfos or source size is not same!");
                return;
            }
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("biz_source", "biz_src_miniapp");
                hashMap2.put("pgid", "pg_qdesign_shareview");
                hashMap.put("to_uin", list.get(i3));
                hashMap.put("share_user_source", list2.get(i3));
                hashMap.put("pgid", "pg_qdesign_shareview");
                hashMap.put("eid", SHARE_SHEET_FRIEND_SHARE_KEY);
                hashMap.put("app_id", str);
                hashMap.put("cur_pg", hashMap2);
                VideoReport.reportEvent("dt_imp", hashMap);
            }
            return;
        }
        QLog.e(TAG, 1, "uinInfos or source is null or empty!");
    }

    public void shareSheetShowReport(String str) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("pgid", "pg_qdesign_shareview");
        hashMap.put("pgid", "pg_qdesign_shareview");
        hashMap.put("app_id", str);
        hashMap.put("biz_source", "biz_src_miniapp");
        hashMap.put("cur_pg", hashMap2);
        VideoReport.reportEvent("dt_pgin", hashMap);
        QLog.d(TAG, 1, "shareSheetShowReport appId:" + str);
    }

    public void shareSheetChannelExpoReport(String str, List<Integer> list) {
        if (list != null && !list.isEmpty()) {
            for (Integer num : list) {
                if (this.mShareChannelToReportIndexMap.containsKey(num)) {
                    HashMap hashMap = new HashMap();
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("biz_source", "biz_src_miniapp");
                    hashMap2.put("pgid", "pg_qdesign_shareview");
                    hashMap.put("cur_pg", hashMap2);
                    hashMap.put(SHARE_SOURCE, this.mShareChannelToReportIndexMap.get(num));
                    hashMap.put("pgid", "pg_qdesign_shareview");
                    hashMap.put("eid", SHARE_SHEET_CHANNEL_REPORT_KEY);
                    hashMap.put("app_id", str);
                    VideoReport.reportEvent("dt_imp", hashMap);
                }
            }
            return;
        }
        QLog.d(TAG, 1, "setMiniAppShareSheetExpo shareSheetItems is null or empty!");
    }
}
