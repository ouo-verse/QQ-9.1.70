package com.tencent.mobileqq.tianshu.api;

import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.data.NumRedGetMsgCallback;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;
import org.json.JSONObject;

/* compiled from: P */
@Service(needUin = false, process = {""})
/* loaded from: classes18.dex */
public interface IRedTouchManager extends IRuntimeService {

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        boolean a(BusinessInfoCheckUpdate.AppInfo appInfo);
    }

    String appToString(BusinessInfoCheckUpdate.AppInfo appInfo);

    void checkMsgExpire();

    void conversationRemainReport();

    @Nullable
    @Deprecated
    BusinessInfoCheckUpdate.AppInfo createNumAppInfo(int i3, int i16, String str, int i17);

    @Nullable
    @Deprecated
    BusinessInfoCheckUpdate.AppInfo createNumAppInfo(int i3, int i16, String str, int i17, boolean z16);

    void dismissRedTouch(String str);

    void getAndSetAppInfoJsReport(int i3, ArrayList<String> arrayList, String str, String str2, String str3, String str4, String str5, int i16);

    int getAppIdByPath(String str);

    @Nullable
    @Deprecated
    BusinessInfoCheckUpdate.AppInfo getAppInfo(int i3, String str);

    @Nullable
    BusinessInfoCheckUpdate.AppInfo getAppInfoByPath(String str);

    BusinessInfoCheckUpdate.AppInfo getAppInfoFilterByID(int i3, String str, String str2);

    @Nullable
    JSONObject getBufferExtParamAppInfo(BusinessInfoCheckUpdate.AppInfo appInfo);

    int getExtraNumRedTotalNum(int i3);

    String getLastClickPath(AppInterface appInterface);

    @Nullable
    BusinessInfoCheckUpdate.TimeRspBody getLocalTimeRspBody();

    void getNumRedMsgByMsgIdArray(long[] jArr, String str, NumRedGetMsgCallback numRedGetMsgCallback);

    int getNumRedNumByAppIdAndMsgType(int i3, int i16);

    int getNumRedNumByPath(String str, int i3);

    @Nullable
    @Deprecated
    List<BusinessInfoCheckUpdate.NumRedPath> getNumRedPathListByAppId(int i3);

    @Nullable
    @Deprecated
    BusinessInfoCheckUpdate.AppInfo getNumRedPointInfo(int i3, String str);

    int getNumRedShowNumByAppSet(int i3);

    @Nullable
    BusinessInfoCheckUpdate.RedTypeInfo getRedTouchInfoByAppSet(int i3);

    @Nullable
    BusinessInfoCheckUpdate.RedTypeInfo getRedTouchInfoByAppSet(int i3, String str);

    @Nullable
    BusinessInfoCheckUpdate.RedTypeInfo getRedTouchInfoByAppSet(int i3, String str, List<String> list);

    List<BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface> getRegisterInterfaces();

    @Nullable
    String getSetAppInfoReportMsg(String str, String str2);

    String getTraceInfo();

    boolean hasAppInfo(String str);

    boolean isNumRedTouchEnable(int i3);

    boolean isUnShowMsgByAppId(int i3);

    boolean notifyAppInfoChangeUpdate(BusinessInfoCheckUpdate.TimeRspBody timeRspBody, BusinessInfoCheckUpdate.TimeRspBody timeRspBody2, int i3);

    void onRedTouchItemClick(BusinessInfoCheckUpdate.AppInfo appInfo, String str);

    void onRedTouchItemClick(String str);

    void onRedTouchItemExposure(BusinessInfoCheckUpdate.AppInfo appInfo, String str);

    void onReportBusinessRedTouch(BusinessInfoCheckUpdate.AppInfo appInfo, String str);

    void onReportNumRedPoint(int i3, String str);

    void onReportRedPointClickWithMissions(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16, List<String> list);

    void onReportRedPointExposure(BusinessInfoCheckUpdate.AppInfo appInfo);

    void parseNumRedPushInfo(byte[] bArr);

    boolean parsePushRedTouchInfo(byte[] bArr);

    void redTouchsArrived(BusinessInfoCheckUpdate.TimeRspBody timeRspBody);

    void reportLevelOneRedInfo(int i3, int i16);

    void reportLevelOneRedInfo(int i3, int i16, String str);

    void reportLevelOneRedInfo(BusinessInfoCheckUpdate.AppInfo appInfo, int i3, String str);

    void reportLevelOneRedInfo(String str, int i3);

    void reportLevelZeroRedInfo(int i3, int i16);

    void reportLevelZeroRedInfo(int i3, int i16, boolean z16, a aVar);

    void reportStatistic(BusinessInfoCheckUpdate.AppInfo appInfo, JSONObject jSONObject, int i3);

    void reportStatistic(BusinessInfoCheckUpdate.AppInfo appInfo, JSONObject jSONObject, int i3, String str);

    @Nullable
    List<BusinessInfoCheckUpdate.AppInfo> requestAppInfoListByAppSet(int i3);

    @Nullable
    List<BusinessInfoCheckUpdate.AppSetting> requestSettingInfoList();

    void resetFlag();

    void residenceReport(long j3);

    boolean saveTimeRepBody(BusinessInfoCheckUpdate.TimeRspBody timeRspBody);

    int updateAppInfo(BusinessInfoCheckUpdate.AppInfo appInfo, boolean z16);

    boolean updateMsgAppInfo(BusinessInfoCheckUpdate.TimeRspBody timeRspBody, BusinessInfoCheckUpdate.TimeRspBody timeRspBody2);

    boolean updateNumberRedInfoByPath(String str, int i3);

    int updateSettingById(int i3, boolean z16, long j3, boolean z17);

    @Nullable
    String wrapperRedTouchUrl(String str, BusinessInfoCheckUpdate.AppInfo appInfo);
}
