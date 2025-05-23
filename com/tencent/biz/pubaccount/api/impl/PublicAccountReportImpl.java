package com.tencent.biz.pubaccount.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg;
import com.tencent.biz.pubaccount.api.IPublicAccountMsgExtMrg;
import com.tencent.biz.pubaccount.api.IPublicAccountReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.managers.AdDurationReportManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.open.agent.api.IOpenAuthTelemetryReportMgr;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.vip.tianshu.TianShuManager;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 82\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b6\u00107J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J8\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J \u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u001a\u0010\u001f\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\u000bH\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010$\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010&\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004H\u0016J*\u0010)\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000bH\u0016J\u0010\u0010*\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010\u0006H\u0016J+\u00100\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010\u00042\b\u0010/\u001a\u0004\u0018\u00010.H\u0016\u00a2\u0006\u0004\b0\u00101J4\u00105\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\b\u00102\u001a\u0004\u0018\u00010\u00062\b\u00103\u001a\u0004\u0018\u00010\u00062\u0006\u00104\u001a\u00020\u0004H\u0016\u00a8\u0006:"}, d2 = {"Lcom/tencent/biz/pubaccount/api/impl/PublicAccountReportImpl;", "Lcom/tencent/biz/pubaccount/api/IPublicAccountReport;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "info", "", "tianshuAction", "", IOpenAuthTelemetryReportMgr.KEY_REPORT_ACTION, "from", "", "report4RecentContact", "", "uin", "actionId", "bytes_oac_msg_extend", "", "hasUnread", "businessInfo", "position", "reportPublicAccountTianShuAdv", "peerUin", "getReportExtInfo", "getAdvFromExtendMsg", "paramUrl", "Landroid/os/Bundle;", "queryParams", "publicAccountRedCount", "publicAccountSeq", "publicAccountRand", "generatePublicBusinInfo", "msgId", "publicAccountExposureReport", "getPositionInMsgList", "reportItemShowOnConversation", "reportItemClickOnConversation", "reportItemShowOnServiceFolder", "reportItemClickOnServiceFolder", "menuID", "reportMenuClickOnPublicAccountAIO", "type", "time", "reportStayTimeInPage", "reportPublicAccountADDuration", "uid", "action", "aioChatType", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "publicAccountAIOMsgReport", "(ILjava/lang/Integer;Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "itemId", "triggleInfo", "actionAttr", "exePublicAccountTianshuReport", "<init>", "()V", "Companion", "a", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class PublicAccountReportImpl implements IPublicAccountReport {
    private static final String APPID_VAB_PUSH = "vab_push";
    private static final String OAC_TRIGGLE = "oac_triggle";
    private static final String TAG = "PublicAccountReport";

    private final String generatePublicBusinInfo(String publicAccountRedCount, String publicAccountSeq, String publicAccountRand) {
        HashMap hashMap = new HashMap();
        hashMap.put("red_cnt", publicAccountRedCount);
        hashMap.put("msg_seq", publicAccountSeq);
        hashMap.put("msg_rand", publicAccountRand);
        String jSONObject = new JSONObject(hashMap).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject(map as Map<*, *>?).toString()");
        return jSONObject;
    }

    private final String getAdvFromExtendMsg(String bytes_oac_msg_extend) {
        if (TextUtils.isEmpty(bytes_oac_msg_extend)) {
            return "";
        }
        try {
            String oacTrigggle = new JSONObject(bytes_oac_msg_extend).optString(OAC_TRIGGLE);
            Intrinsics.checkNotNullExpressionValue(oacTrigggle, "oacTrigggle");
            Bundle queryParams = queryParams(oacTrigggle);
            String string = queryParams != null ? queryParams.getString("ad_id") : null;
            return string == null ? "" : string;
        } catch (Exception unused) {
            QLog.e(TAG, 2, "parseException error ");
            return "";
        }
    }

    private final int getPositionInMsgList(long peerUin) {
        aa recentContactService;
        RecentContactInfo next;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (recentContactService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")).getRecentContactService()) == null) {
            return 0;
        }
        List<RecentContactInfo> a16 = recentContactService.a();
        List<RecentContactInfo> list = a16;
        int i3 = 1;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        ListIterator<RecentContactInfo> listIterator = a16.listIterator();
        while (listIterator.hasNext() && (next = listIterator.next()) != null) {
            if (next.peerUin == peerUin) {
                return i3;
            }
            i3++;
        }
        return 0;
    }

    private final String getReportExtInfo(String bytes_oac_msg_extend, long peerUin) {
        try {
            JSONObject jSONObject = new JSONObject(bytes_oac_msg_extend);
            jSONObject.put(QCircleLpReportDc05507.KEY_POSITION_ID, getPositionInMsgList(peerUin));
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonObject.toString()");
            return jSONObject2;
        } catch (Exception unused) {
            QLog.e(TAG, 2, "getReportExtInfo error ");
            return bytes_oac_msg_extend;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void publicAccountAIOMsgReport$lambda$8(MsgRecord msgRecord, PublicAccountReportImpl this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String bytesOacMsgExtend = ((IPublicAccountMsgExtMrg) QRoute.api(IPublicAccountMsgExtMrg.class)).getBytesOacMsgExtend(msgRecord);
        if (TextUtils.isEmpty(bytesOacMsgExtend)) {
            return;
        }
        String advFromExtendMsg = this$0.getAdvFromExtendMsg(bytesOacMsgExtend);
        if (TextUtils.isEmpty(advFromExtendMsg)) {
            return;
        }
        this$0.exePublicAccountTianshuReport(i3, 0, advFromExtendMsg, this$0.getReportExtInfo(bytesOacMsgExtend, msgRecord.peerUin), 1);
    }

    private final void publicAccountExposureReport(final String uin, final long msgId) {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.j
            @Override // java.lang.Runnable
            public final void run() {
                PublicAccountReportImpl.publicAccountExposureReport$lambda$9(uin, msgId);
            }
        });
    }

    private final Bundle queryParams(String paramUrl) {
        List emptyList;
        List emptyList2;
        Bundle bundle = new Bundle();
        List<String> split = new Regex(ContainerUtils.FIELD_DELIMITER).split(paramUrl, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (!(listIterator.previous().length() == 0)) {
                    emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Object[] array = emptyList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        if (strArr != null) {
            for (String str : strArr) {
                List<String> split2 = new Regex(ContainerUtils.KEY_VALUE_DELIMITER).split(str, 0);
                if (!split2.isEmpty()) {
                    ListIterator<String> listIterator2 = split2.listIterator(split2.size());
                    while (listIterator2.hasPrevious()) {
                        if (!(listIterator2.previous().length() == 0)) {
                            emptyList2 = CollectionsKt___CollectionsKt.take(split2, listIterator2.nextIndex() + 1);
                            break;
                        }
                    }
                }
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                Object[] array2 = emptyList2.toArray(new String[0]);
                Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr2 = (String[]) array2;
                if (strArr2 != null && strArr2.length == 2) {
                    try {
                        bundle.putString(strArr2[0], URLDecoder.decode(strArr2[1], "UTF-8"));
                    } catch (UnsupportedEncodingException e16) {
                        e16.printStackTrace();
                    }
                }
            }
        }
        return bundle;
    }

    private final void report4RecentContact(final RecentContactInfo info, final int tianshuAction, final String reportAction, final int from) {
        ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).asyncGetLastMsgRecord(info, new IMsgOperateCallback() { // from class: com.tencent.biz.pubaccount.api.impl.m
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                PublicAccountReportImpl.report4RecentContact$lambda$1(RecentContactInfo.this, this, tianshuAction, reportAction, from, i3, str, arrayList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void report4RecentContact$lambda$1$lambda$0(MsgRecord msgRecord, PublicAccountReportImpl this$0, long j3, int i3, long j16, String businInfo, String reportAction, int i16, long j17, long j18) {
        Intrinsics.checkNotNullParameter(msgRecord, "$msgRecord");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(businInfo, "$businInfo");
        Intrinsics.checkNotNullParameter(reportAction, "$reportAction");
        this$0.reportPublicAccountTianShuAdv(j3, i3, ((IPublicAccountMsgExtMrg) QRoute.api(IPublicAccountMsgExtMrg.class)).getBytesOacMsgExtend(msgRecord), j16 > 0, businInfo, "0");
        ReportController.o(null, "dc00898", "", String.valueOf(j3), reportAction, reportAction, i16, 0, j17 + "", j16 + "", String.valueOf(j18), "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportPublicAccountADDuration$lambda$6(PublicAccountReportImpl this$0, RecentContactInfo info, int i3, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        if (arrayList.size() <= 0) {
            return;
        }
        MsgRecord msgRecord = (MsgRecord) arrayList.get(0);
        if (msgRecord == null) {
            return;
        }
        String bytesOacMsgExtend = ((IPublicAccountMsgExtMrg) QRoute.api(IPublicAccountMsgExtMrg.class)).getBytesOacMsgExtend(msgRecord);
        String advFromExtendMsg = this$0.getAdvFromExtendMsg(bytesOacMsgExtend);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(info.peerUin);
        sb5.append(util.base64_pad_url);
        sb5.append((int) (System.currentTimeMillis() / 1000));
        String sb6 = sb5.toString();
        boolean z16 = info.unreadCnt > 0;
        AdDurationReportManager.c.a aVar = new AdDurationReportManager.c.a();
        aVar.c(APPID_VAB_PUSH).d(advFromExtendMsg).e(sb6).f(this$0.getReportExtInfo(bytesOacMsgExtend, msgRecord.peerUin)).b(z16 ? 6 : -1);
        AdDurationReportManager.d().g(aVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportPublicAccountADDuration$lambda$7(PublicAccountReportImpl this$0, int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (arrayList == null || arrayList.isEmpty()) {
            QLog.i(TAG, 1, "foundContacts == null or size == 0");
            return;
        }
        Object obj = arrayList.get(0);
        Intrinsics.checkNotNullExpressionValue(obj, "foundContacts[0]");
        this$0.reportPublicAccountADDuration((RecentContactInfo) obj);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountReport
    public void exePublicAccountTianshuReport(int action, int position, String itemId, String triggleInfo, int actionAttr) {
        String str;
        TianShuReportData tianShuReportData = new TianShuReportData();
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null) {
            str = "";
        } else {
            str = runtime.getAccount();
            Intrinsics.checkNotNullExpressionValue(str, "appRuntime.account");
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mAppId = APPID_VAB_PUSH;
        tianShuReportData.mPageId = APPID_VAB_PUSH;
        tianShuReportData.mTraceId = str + util.base64_pad_url + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mItemId = itemId;
        tianShuReportData.mSubItemId = "";
        tianShuReportData.mOperTime = serverTimeMillis;
        tianShuReportData.mActionId = action;
        tianShuReportData.mPositionId = String.valueOf(position);
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mActionAttr = actionAttr;
        tianShuReportData.mTriggerInfo = triggleInfo;
        TianShuManager.getInstance().report(tianShuReportData);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountReport
    public void reportItemClickOnConversation(RecentContactInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        report4RecentContact(info, 102, "0X8009EB4", 1);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountReport
    public void reportItemClickOnServiceFolder(RecentContactInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        report4RecentContact(info, 140, "0X8009EB4", 2);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountReport
    public void reportItemShowOnConversation(RecentContactInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        report4RecentContact(info, 101, "0X8009EB3", 1);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountReport
    public void reportItemShowOnServiceFolder(RecentContactInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        report4RecentContact(info, 139, "0X8009EB3", 2);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountReport
    public void reportMenuClickOnPublicAccountAIO(final String uin, final int from, final int menuID) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "report Menu Click On PublicAccount AIO, UIN=", uin, " menuID=", Integer.valueOf(menuID));
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.k
            @Override // java.lang.Runnable
            public final void run() {
                PublicAccountReportImpl.reportMenuClickOnPublicAccountAIO$lambda$2(uin, from, menuID);
            }
        });
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountReport
    public void reportPublicAccountADDuration(final RecentContactInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).asyncGetLastMsgRecord(info, new IMsgOperateCallback() { // from class: com.tencent.biz.pubaccount.api.impl.n
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                PublicAccountReportImpl.reportPublicAccountADDuration$lambda$6(PublicAccountReportImpl.this, info, i3, str, arrayList);
            }
        });
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountReport
    public void reportStayTimeInPage(final String uin, final int from, final int type, final long time) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "report report Stay Time In Page, UIN=", uin, " from=", Integer.valueOf(from), " type=", Integer.valueOf(type), " time=", Long.valueOf(time));
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.p
            @Override // java.lang.Runnable
            public final void run() {
                PublicAccountReportImpl.reportStayTimeInPage$lambda$3(uin, from, type, time);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void publicAccountExposureReport$lambda$9(String str, long j3) {
        ReportController.o(null, "dc00898", "", str, "0X800A306", "0X800A306", 0, 0, "", "", j3 + "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportMenuClickOnPublicAccountAIO$lambda$2(String str, int i3, int i16) {
        ReportController.o(null, "dc00898", "", str, "0X8009EB7", "0X8009EB7", i3, 0, "", "", i16 + "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportStayTimeInPage$lambda$3(String str, int i3, int i16, long j3) {
        ReportController.o(null, "dc00898", "", str, "0X8009EB5", "0X8009EB5", i3, 0, "" + i16, j3 + "", "", "");
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountReport
    public void reportPublicAccountADDuration(String uid) {
        AppRuntime peekAppRuntime;
        aa recentContactService;
        if ((uid == null || uid.length() == 0) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || (recentContactService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getRecentContactService()) == null) {
            return;
        }
        recentContactService.F0(new Contact(103, uid, ""), new IGetContactsCallback() { // from class: com.tencent.biz.pubaccount.api.impl.o
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetContactsCallback
            public final void onResult(int i3, String str, ArrayList arrayList, ArrayList arrayList2) {
                PublicAccountReportImpl.reportPublicAccountADDuration$lambda$7(PublicAccountReportImpl.this, i3, str, arrayList, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void report4RecentContact$lambda$1(RecentContactInfo info, final PublicAccountReportImpl this$0, final int i3, final String reportAction, final int i16, int i17, String str, ArrayList arrayList) {
        final MsgRecord msgRecord;
        Intrinsics.checkNotNullParameter(info, "$info");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportAction, "$reportAction");
        if (arrayList.size() > 0 && (msgRecord = (MsgRecord) arrayList.get(0)) != null) {
            final long j3 = info.unreadCnt;
            final long j16 = info.unreadFlag;
            final long j17 = info.peerUin;
            final String generatePublicBusinInfo = this$0.generatePublicBusinInfo(String.valueOf(j3), String.valueOf(msgRecord.msgSeq), String.valueOf(msgRecord.msgRandom));
            final long j18 = msgRecord.msgId;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.i
                @Override // java.lang.Runnable
                public final void run() {
                    PublicAccountReportImpl.report4RecentContact$lambda$1$lambda$0(MsgRecord.this, this$0, j17, i3, j3, generatePublicBusinInfo, reportAction, i16, j16, j18);
                }
            }, 16, null, true);
        }
    }

    private final void reportPublicAccountTianShuAdv(long uin, int actionId, String bytes_oac_msg_extend, boolean hasUnread, String businessInfo, String position) {
        if (TextUtils.isEmpty(bytes_oac_msg_extend)) {
            return;
        }
        String advFromExtendMsg = getAdvFromExtendMsg(bytes_oac_msg_extend);
        if (TextUtils.isEmpty(advFromExtendMsg)) {
            return;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(uin);
        sb5.append(util.base64_pad_url);
        sb5.append(currentTimeMillis);
        TianShuReportData tianShuReportData = new TianShuReportData(sb5.toString(), 1, actionId, 1, APPID_VAB_PUSH, APPID_VAB_PUSH, advFromExtendMsg, APPID_VAB_PUSH, currentTimeMillis);
        tianShuReportData.mTriggerInfo = getReportExtInfo(bytes_oac_msg_extend, uin);
        tianShuReportData.mPageId = APPID_VAB_PUSH;
        tianShuReportData.mActionAttr = hasUnread ? 6 : -1;
        tianShuReportData.mBusiInfo = businessInfo;
        tianShuReportData.mPositionId = position;
        TianShuManager.getInstance().report(tianShuReportData);
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountReport
    public void publicAccountAIOMsgReport(final int action, Integer aioChatType, final MsgRecord msg2) {
        int i3;
        if (msg2 == null) {
            return;
        }
        if (aioChatType != null) {
            i3 = aioChatType.intValue();
        } else {
            i3 = msg2.chatType;
        }
        if (i3 == 118 || i3 == 103) {
            if (action == 117) {
                publicAccountExposureReport(String.valueOf(msg2.peerUin), msg2.msgId);
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.biz.pubaccount.api.impl.l
                @Override // java.lang.Runnable
                public final void run() {
                    PublicAccountReportImpl.publicAccountAIOMsgReport$lambda$8(MsgRecord.this, this, action);
                }
            }, 16, null, true);
        }
    }
}
