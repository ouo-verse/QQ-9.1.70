package f5;

import b6.b;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.tianshu.TianShuManager;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {
    public static boolean b(b bVar, BusinessFeedData businessFeedData, FeedElement feedElement) {
        if (!a(businessFeedData)) {
            return false;
        }
        if (feedElement == FeedElement.DROPDOWN_BUTTON) {
            return true;
        }
        String str = businessFeedData.getRecommAction().extendInfo.get(20);
        String str2 = businessFeedData.getRecommAction().extendInfo.get(22);
        int i3 = businessFeedData.getOperationInfoV2().actionType;
        String str3 = businessFeedData.getOperationInfoV2().actionUrl;
        String str4 = businessFeedData.getOperationInfoV2().downloadUrl;
        String str5 = businessFeedData.getOperationInfoV2().schemaPageUrl;
        if (i3 == 2) {
            bVar.Vc(str3);
            if (QLog.isColorLevel()) {
                QLog.i("MutilLink", 2, "_OpenWebPage = " + str3);
            }
        } else if (i3 == 22) {
            bVar.xb(str5);
            if (QLog.isColorLevel()) {
                QLog.i("MutilLink", 2, "_DoOpenSchemaApp = " + str5);
            }
        } else if (i3 == 23) {
            bVar.la(str5, null, null);
            if (QLog.isColorLevel()) {
                QLog.i("MutilLink", 2, "_DoOpenSchemaPage = " + str5);
            }
        } else if (i3 == 20) {
            bVar.Vc(str5);
            if (QLog.isColorLevel()) {
                QLog.i("MutilLink", 2, "_DoAsActionSchema = " + str5);
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.i("MutilLink", 2, "not support Action = " + i3);
            }
            return false;
        }
        c(str, str2, 102);
        return true;
    }

    private static void c(String str, String str2, int i3) {
        TianShuReportData tianShuReportData = new TianShuReportData();
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mToUid = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        tianShuReportData.mTraceId = tianShuReportData.mToUid + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mAppId = "tianshu.221";
        tianShuReportData.mPageId = "tianshu.221";
        tianShuReportData.mModuleId = "1";
        tianShuReportData.mItemId = str;
        tianShuReportData.mTriggerInfo = str2;
        tianShuReportData.mActionId = i3;
        tianShuReportData.mActionValue = 1;
        TianShuManager.getInstance().report(tianShuReportData);
    }

    private static boolean a(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getRecommAction() == null) {
            return false;
        }
        boolean containsKey = businessFeedData.getRecommAction().extendInfo.containsKey(20);
        if (QLog.isColorLevel()) {
            QLog.i("MutilLink", 2, "is Tianshu-AD" + containsKey);
            QLog.i("MutilLink", 2, "20 = " + businessFeedData.getRecommAction().extendInfo.containsKey(20));
            QLog.i("MutilLink", 2, "22 = " + businessFeedData.getRecommAction().extendInfo.containsKey(22));
        }
        return containsKey;
    }
}
