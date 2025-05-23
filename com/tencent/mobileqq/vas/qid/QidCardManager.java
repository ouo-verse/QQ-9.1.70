package com.tencent.mobileqq.vas.qid;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ev;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.config.business.qvip.QVipQidProcessor;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.mobileqq.vip.f;
import com.tencent.mobileqq.vip.g;
import com.tencent.mobileqq.vip.h;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import org.apache.http.util.ByteArrayBuffer;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QidCardManager {
    public static final String CMD_GET_QID_PROFILE = "vapfService.qidService.GetProfileSSO";
    public static final String CM_SHOW_DEFAULT_BOY_URL = "https://qqshowar.gtimg.cn/qqshow/1/2d/body/100.png";
    public static final String CM_SHOW_DEFAULT_GIRL_URL = "https://qqshowar.gtimg.cn/qqshow/0/2d/body/100.png";
    public static final String CM_SHOW_MATCH_URL = "https://qqshowar.gtimg.cn/qqshow/%s/2d/body/640.png";
    public static final int REQUEST_QID_EDIT_CODE = 1;
    public static final String TAG = "QidCardManager";
    private static String ROOT = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "qid/");
    private static String SP_VIP_QID_INFO = "sp_vip_qid_info";
    private static String LAST_QID_BG = "last_qid_bg";

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class QidCardReport {
        public static final int QID_PROFILE_RES_ID_ACTIVITY = 3;
        public static final int QID_PROFILE_RES_ID_COMMON = 1;
        public static final int QID_PROFILE_RES_ID_SVIP = 2;
        public static final int QID_PROFILE_RES_ID_UNDEFINED = 10;
        private static final int QID_PROFILE_RES_ID_UNSET = 0;
        public static final int QID_PROFILE_TYPE_COMMON = 1;
        public static final int QID_PROFILE_TYPE_SVIP = 2;
        public static final int QID_PROFILE_TYPE_UNDEFINED = 10;
        public static final int QID_PROFILE_TYPE_UNSET = 0;
        static Map<String, ReportData> reportDataMap;
        public static int sQidResId;
        public static int sQidTypeId;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes20.dex */
        public static class ReportData {
            public int resId;
            public int typeId;

            public ReportData(int i3, int i16) {
                this.resId = i3;
                this.typeId = i16;
            }
        }

        static {
            HashMap hashMap = new HashMap();
            reportDataMap = hashMap;
            hashMap.put("svip_qidbg_pag.pag", new ReportData(2, 2));
            reportDataMap.put("svip_pag.pag", new ReportData(2, 1));
            reportDataMap.put("comm_qidbg_pag.pag", new ReportData(1, 2));
            reportDataMap.put("comm_pag.pag", new ReportData(1, 1));
            reportDataMap.put("activity_qidbg_pag.pag", new ReportData(3, 2));
            reportDataMap.put("activity_pag.pag", new ReportData(3, 1));
        }

        public static void initReportParamsId(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            for (String str2 : reportDataMap.keySet()) {
                if (str.endsWith(str2)) {
                    ReportData reportData = reportDataMap.get(str2);
                    sQidResId = reportData.resId;
                    sQidTypeId = reportData.typeId;
                    return;
                }
            }
            sQidResId = 10;
            sQidTypeId = 10;
        }

        public static void reportQidQrCard(String str) {
            ReportController.o(null, "dc00898", "", "", "", str, 0, 0, String.valueOf(sQidResId), String.valueOf(sQidTypeId), "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f310579a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QidPagView f310580b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QidPagView.QidData f310581c;

        a(Activity activity, QidPagView qidPagView, QidPagView.QidData qidData) {
            this.f310579a = activity;
            this.f310580b = qidPagView;
            this.f310581c = qidData;
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onCancel(g gVar) {
            super.onCancel(gVar);
        }

        @Override // com.tencent.mobileqq.vip.f
        public void onDone(g gVar) {
            boolean z16;
            super.onDone(gVar);
            Activity activity = this.f310579a;
            if (activity != null && !activity.isFinishing()) {
                if (gVar.i() == 3 && gVar.f313006d == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    this.f310580b.updateQR(this.f310581c);
                    return;
                }
                QLog.d(QidCardManager.TAG, 2, "QID_QR,download,error:" + gVar.f313006d + "," + gVar.f313007e);
            }
        }

        @Override // com.tencent.mobileqq.vip.f
        public boolean onStart(g gVar) {
            if (QLog.isColorLevel()) {
                QLog.d(QidCardManager.TAG, 2, "QID_QR,download,start");
            }
            return super.onStart(gVar);
        }
    }

    public static File checkQidPagFile(String str) {
        String obtainPagPathByUrl = obtainPagPathByUrl(str);
        if (TextUtils.isEmpty(obtainPagPathByUrl)) {
            return null;
        }
        File file = new File(obtainPagPathByUrl);
        if (!file.exists()) {
            return null;
        }
        return file;
    }

    public static void downloadQidRes(Activity activity, QidPagView qidPagView, QidPagView.QidData qidData) {
        if (qidData != null && !TextUtils.isEmpty(qidData.pagUrl) && !TextUtils.isEmpty(qidData.savePath)) {
            if (getQidResDownLoader() == null) {
                return;
            }
            getQidResDownLoader().startDownload(new g(qidData.pagUrl, new File(qidData.savePath)), new a(activity, qidPagView, qidData), null);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "QID_QR,download,params error");
        }
    }

    public static String getCmShowFailPath() {
        Card findAndCreateCardByUin = ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).findAndCreateCardByUin(VasUtil.getCurrentUin());
        if (findAndCreateCardByUin != null) {
            if (findAndCreateCardByUin.shGender == 1) {
                return CM_SHOW_DEFAULT_GIRL_URL;
            }
            return CM_SHOW_DEFAULT_BOY_URL;
        }
        return null;
    }

    public static String getLastQidBg(String str) {
        return BaseApplication.getContext().getSharedPreferences(SP_VIP_QID_INFO, 0).getString(LAST_QID_BG + str, "");
    }

    private static h getQidResDownLoader() {
        return ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).getDownloader(VasUtil.getApp());
    }

    public static String jointCmShowUrl(String str) {
        String simpleCryptoWithUin = simpleCryptoWithUin(str);
        if (!TextUtils.isEmpty(simpleCryptoWithUin)) {
            return String.format(CM_SHOW_MATCH_URL, simpleCryptoWithUin);
        }
        return null;
    }

    public static void jumpQidEditPage(AppRuntime appRuntime, Activity activity, int i3) {
        String currentAccountUin;
        Intent qQBrowserIntent = ((IVasDepTemp) QRoute.api(IVasDepTemp.class)).getQQBrowserIntent();
        String buildTraceDetailUrl = ((IVipTraceDetailReport) QRoute.api(IVipTraceDetailReport.class)).buildTraceDetailUrl(QVipQidProcessor.get().getQidUrl(), IVipTraceDetailReport.FROM.DRAWER_QRCODE_EDIT_QID);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "jumpQidEditPage url:" + buildTraceDetailUrl);
        }
        qQBrowserIntent.putExtra("url", buildTraceDetailUrl);
        qQBrowserIntent.putExtra("hide_more_button", true);
        if (appRuntime == null) {
            currentAccountUin = "";
        } else {
            currentAccountUin = appRuntime.getCurrentAccountUin();
        }
        qQBrowserIntent.putExtra("uin", currentAccountUin);
        qQBrowserIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
        if (activity != null) {
            activity.startActivityForResult(qQBrowserIntent, i3);
        }
    }

    public static boolean needHideSearchQid(AppRuntime appRuntime, ProfileCardInfo profileCardInfo) {
        AllInOne allInOne;
        Card card;
        boolean z16;
        if (appRuntime == null || profileCardInfo == null || (allInOne = profileCardInfo.allInOne) == null || (card = profileCardInfo.card) == null) {
            return false;
        }
        if (allInOne.profileEntryType == 129) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z17 = !((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(ev.b(card.uin), TAG);
        if (!z16 || !z17) {
            return false;
        }
        return true;
    }

    public static String obtainPagPathByUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ROOT + MD5Utils.toMD5(str) + ".pag";
    }

    public static boolean setLastQidBg(String str, String str2) {
        SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences(SP_VIP_QID_INFO, 0).edit();
        edit.putString(LAST_QID_BG + str, str2);
        return edit.commit();
    }

    private static String simpleCryptoWithUin(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = {50, 48, 50, 48};
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(1024);
        int i3 = 0;
        for (int i16 = 0; i16 < bytes.length && i16 < 4; i16++) {
            byteArrayBuffer.append(bytes[i16] ^ 165);
            byteArrayBuffer.append(bArr[i16] ^ 165);
            i3++;
        }
        for (int i17 = i3; i17 < bytes.length; i17++) {
            byteArrayBuffer.append(bytes[i17] ^ 165);
        }
        while (i3 < 4) {
            byteArrayBuffer.append(bArr[i3] ^ 165);
            i3++;
        }
        return HexUtil.bytes2HexStr(byteArrayBuffer.toByteArray()).toLowerCase();
    }
}
