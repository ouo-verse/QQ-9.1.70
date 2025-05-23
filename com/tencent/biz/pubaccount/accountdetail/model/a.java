package com.tencent.biz.pubaccount.accountdetail.model;

import android.os.Bundle;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailDynamicDataManagerService;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.impl.PublicAccountObserverImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.mp.account_detail_dynamic_list$AccountDetailDynamicListRequest;
import com.tencent.mobileqq.mp.account_detail_dynamic_list$AccountDetailDynamicListResponse;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static long f79107a = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.accountdetail.model.a$a, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C0799a implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f79108d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f79109e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ PublicAccountObserverImpl f79110f;

        C0799a(QQAppInterface qQAppInterface, boolean z16, PublicAccountObserverImpl publicAccountObserverImpl) {
            this.f79108d = qQAppInterface;
            this.f79109e = z16;
            this.f79110f = publicAccountObserverImpl;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.d("AccountDetailDynamicListModel", 2, "getAccountDetailDynamicList isSuccess:" + String.valueOf(z16));
            }
            byte[] byteArray = bundle.getByteArray("data");
            int d16 = (!z16 || byteArray == null) ? 1 : a.d(this.f79108d, this.f79109e, byteArray, false);
            PublicAccountObserverImpl publicAccountObserverImpl = this.f79110f;
            if (publicAccountObserverImpl != null) {
                publicAccountObserverImpl.onDynamicListGet(z16, d16);
            }
            if (QLog.isColorLevel()) {
                QLog.d("AccountDetailDynamicListModel", 2, "getAccountDetailDynamicList onReceiveerrCode:" + d16);
            }
        }
    }

    public static void b(QQAppInterface qQAppInterface, long j3, PublicAccountObserverImpl publicAccountObserverImpl) {
        zx.a aVar = (zx.a) ((IPublicAccountDetailDynamicDataManagerService) qQAppInterface.getRuntimeService(IPublicAccountDetailDynamicDataManagerService.class, "all")).getAccountDetailDynamicInfoFromCache(j3);
        if (aVar != null) {
            long j16 = aVar.f453622b;
            if (j16 > 0) {
                if (f79107a != j16) {
                    a(qQAppInterface, j3, j16, 25, publicAccountObserverImpl);
                    return;
                }
                return;
            }
        }
        c(qQAppInterface, j3, publicAccountObserverImpl);
    }

    public static void c(QQAppInterface qQAppInterface, long j3, PublicAccountObserverImpl publicAccountObserverImpl) {
        ((IPublicAccountDetailDynamicDataManagerService) qQAppInterface.getRuntimeService(IPublicAccountDetailDynamicDataManagerService.class, "all")).getDynamicListForFirstEnterFromDB(qQAppInterface, j3, publicAccountObserverImpl);
        a(qQAppInterface, j3, 0L, 25, publicAccountObserverImpl);
    }

    public static synchronized int d(QQAppInterface qQAppInterface, boolean z16, byte[] bArr, boolean z17) {
        int i3;
        List<ByteStringMicro> list;
        synchronized (a.class) {
            account_detail_dynamic_list$AccountDetailDynamicListResponse account_detail_dynamic_list_accountdetaildynamiclistresponse = new account_detail_dynamic_list$AccountDetailDynamicListResponse();
            int i16 = 2;
            try {
                account_detail_dynamic_list_accountdetaildynamiclistresponse.mergeFrom(bArr);
                int i17 = 0;
                if (account_detail_dynamic_list_accountdetaildynamiclistresponse.ret_info.has() && account_detail_dynamic_list_accountdetaildynamiclistresponse.ret_info.ret_code.get() == 0) {
                    if (account_detail_dynamic_list_accountdetaildynamiclistresponse.puin.has() && account_detail_dynamic_list_accountdetaildynamiclistresponse.last_msg_id.has() && account_detail_dynamic_list_accountdetaildynamiclistresponse.msg_cnt.has()) {
                        long j3 = account_detail_dynamic_list_accountdetaildynamiclistresponse.puin.get();
                        long j16 = account_detail_dynamic_list_accountdetaildynamiclistresponse.last_msg_id.get();
                        long j17 = account_detail_dynamic_list_accountdetaildynamiclistresponse.msg_cnt.get();
                        if (QLog.isColorLevel()) {
                            QLog.d("AccountDetailDynamicListModel", 2, "updateAccountDetailDynamicInfo puin:" + j3 + " last_msg_id:" + j16 + " msg_cnt:" + j17 + " isFirstEnter:" + z16 + " isFromDB:" + z17);
                        }
                        IPublicAccountDetailDynamicDataManagerService iPublicAccountDetailDynamicDataManagerService = (IPublicAccountDetailDynamicDataManagerService) qQAppInterface.getRuntimeService(IPublicAccountDetailDynamicDataManagerService.class, "all");
                        ArrayList arrayList = (ArrayList) iPublicAccountDetailDynamicDataManagerService.getDynamicListFromCache(j3);
                        if (z16 && z17 && arrayList != null && !arrayList.isEmpty()) {
                            return 6;
                        }
                        ArrayList<String> arrayList2 = new ArrayList<>();
                        if (account_detail_dynamic_list_accountdetaildynamiclistresponse.msg_infos.has()) {
                            List<ByteStringMicro> list2 = account_detail_dynamic_list_accountdetaildynamiclistresponse.msg_infos.get();
                            int size = list2 == null ? 0 : list2.size();
                            while (i17 < size) {
                                try {
                                    String stringUtf8 = list2.get(i17).toStringUtf8();
                                    arrayList2.add(stringUtf8);
                                    if (QLog.isColorLevel()) {
                                        list = list2;
                                        i16 = 2;
                                        QLog.d("AccountDetailDynamicListModel", 2, "updateAccountDetailDynamicInfo jsonBody" + stringUtf8);
                                    } else {
                                        list = list2;
                                        i16 = 2;
                                    }
                                    i17++;
                                    list2 = list;
                                } catch (Exception unused) {
                                    i16 = 2;
                                }
                            }
                        }
                        i3 = j17 == ((long) arrayList2.size()) ? iPublicAccountDetailDynamicDataManagerService.updateAccountDetailDynamicInfo(bArr, z16, j3, j16, j17, arrayList2, z17) : 5;
                    } else {
                        i3 = 4;
                    }
                    i16 = i3;
                } else {
                    i16 = 0;
                }
            } catch (Exception unused2) {
            }
            return i16;
        }
    }

    private static void a(QQAppInterface qQAppInterface, long j3, long j16, int i3, PublicAccountObserverImpl publicAccountObserverImpl) {
        String str;
        PublicAccountDetailImpl publicAccountDetailImpl;
        if (QLog.isColorLevel()) {
            QLog.d("AccountDetailDynamicListModel", 2, "getAccountDetailDynamicList last_msg_id:" + j16 + "  msg_cnt:" + i3 + "  mLastMSgID: " + f79107a);
        }
        NewIntent newIntent = new NewIntent(qQAppInterface.getApp(), PublicAccountServletImpl.class);
        newIntent.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_ACCOUNT_DETAIL_DYNAMIC_LIST);
        account_detail_dynamic_list$AccountDetailDynamicListRequest account_detail_dynamic_list_accountdetaildynamiclistrequest = new account_detail_dynamic_list$AccountDetailDynamicListRequest();
        account_detail_dynamic_list_accountdetaildynamiclistrequest.versionInfo.set(AppSetting.f99551k + ",3," + AppSetting.f99542b);
        account_detail_dynamic_list_accountdetaildynamiclistrequest.puin.set(j3);
        account_detail_dynamic_list_accountdetaildynamiclistrequest.last_msg_id.set(j16);
        account_detail_dynamic_list_accountdetaildynamiclistrequest.msg_cnt.set(i3);
        newIntent.putExtra("data", account_detail_dynamic_list_accountdetaildynamiclistrequest.toByteArray());
        int i16 = 1;
        boolean z16 = j16 == 0;
        newIntent.putExtra("isFirstEnter", z16);
        f79107a = j16;
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (iPublicAccountDataManager != null && (publicAccountDetailImpl = (PublicAccountDetailImpl) iPublicAccountDataManager.findAccountDetailInfo(String.valueOf(j3))) != null) {
            r9 = publicAccountDetailImpl.followType == 1;
            i16 = PublicAccountDetailImpl.getReportAccountType(qQAppInterface, String.valueOf(j3), publicAccountDetailImpl);
        }
        IPublicAccountReportUtils iPublicAccountReportUtils = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
        String str2 = j3 + "";
        String str3 = j16 + "";
        if (r9) {
            str = "02";
        } else {
            str = HiAnalyticsConstant.KeyAndValue.NUMBER_01;
        }
        iPublicAccountReportUtils.publicAccountReportClickEvent(null, str2, "0X80077FF", "0X80077FF", 0, 0, "1", str3, str, String.valueOf(i16), false);
        newIntent.setObserver(new C0799a(qQAppInterface, z16, publicAccountObserverImpl));
        qQAppInterface.startServlet(newIntent);
        if (QLog.isColorLevel()) {
            QLog.d("AccountDetailDynamicListModel", 2, "getAccountDetailDynamicList exit");
        }
    }
}
