package com.tencent.mobileqq.qwallet.impl;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.Vibrator;
import android.text.TextUtils;
import com.qwallet.temp.IQQAppInterfaceTemp;
import com.qwallet.temp.IQWalletPBTemp;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.ark.ark;
import com.tencent.av.utils.ad;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.util.notification.NotificationFactory;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QWalletGoldMsgTipsElem;
import com.tencent.mobileqq.data.QWalletSubmsgtype0x66$MsgBody;
import com.tencent.mobileqq.data.QWalletSubmsgtype0x7e$MsgBody$OnlinePush;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.qwallet.IQWalletPayApi;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.util.az;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tenpay.sdk.Cgi;
import cooperation.qwallet.plugin.IPayLogic;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.QWalletLockScreenActivity;
import cooperation.qwallet.plugin.impl.QWalletHelperDelegate;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes16.dex */
public class QWalletPushManager {

    /* renamed from: c, reason: collision with root package name */
    private static long f278221c;

    /* renamed from: a, reason: collision with root package name */
    private static ArrayList<IQWalletPayApi.a> f278219a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private static HashMap<String, Integer> f278220b = new HashMap<>(16);

    /* renamed from: d, reason: collision with root package name */
    private static final long[] f278222d = {100, 200, 200, 100};

    /* JADX INFO: Access modifiers changed from: private */
    public static void A(BaseQQAppInterface baseQQAppInterface) {
        if (baseQQAppInterface != null && f278219a != null) {
            boolean isScreenLocked = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).isScreenLocked(baseQQAppInterface.getApp());
            QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "startForegroundPay isScreenLock=" + isScreenLocked);
            if (isScreenLocked) {
                return;
            }
            IQWalletPayApi.a i3 = i();
            if (i3 == null) {
                if (f278219a.size() > 0) {
                    IQWalletPayApi.a aVar = f278219a.get(0);
                    if (aVar != null && h(aVar.f277005c) != 0) {
                        B(baseQQAppInterface, aVar);
                        return;
                    } else {
                        f278219a.remove(0);
                        A(baseQQAppInterface);
                        return;
                    }
                }
                return;
            }
            C(baseQQAppInterface, i3);
        }
    }

    private static void B(BaseQQAppInterface baseQQAppInterface, IQWalletPayApi.a aVar) {
        boolean isPaying = ((IPayLogic) QRoute.api(IPayLogic.class)).isPaying();
        boolean isQWalletProcessExist = QWalletHelperDelegate.isQWalletProcessExist(baseQQAppInterface.getApplication().getApplicationContext());
        if (isPaying && isQWalletProcessExist) {
            return;
        }
        aVar.f277010h = 1;
        try {
            Intent payBridgeIntent = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getPayBridgeIntent(BaseApplication.getContext());
            payBridgeIntent.addFlags(872415232);
            payBridgeIntent.putExtra(ark.ARKMETADATA_JSON, aVar.f277006d);
            payBridgeIntent.putExtra("callbackSn", "0");
            payBridgeIntent.putExtra("payparmas_from_pcpush", true);
            payBridgeIntent.putExtra("pay_requestcode", h(aVar.f277005c));
            payBridgeIntent.putExtra(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 2);
            BaseApplication.getContext().startActivity(payBridgeIntent);
        } catch (Exception e16) {
            QLog.e("QWalletPushManager", 1, "error msg in qqpay-impl module: ", e16);
            aVar.f277010h = 2;
            QLog.e(IQWalletHelper.TAG_WALLET_PUSH, 2, "Starting pay throws Exception.", e16);
        }
    }

    private static void C(BaseQQAppInterface baseQQAppInterface, IQWalletPayApi.a aVar) {
        boolean isPaying = ((IPayLogic) QRoute.api(IPayLogic.class)).isPaying();
        boolean z16 = false;
        if (isPaying && !QWalletHelperDelegate.isQWalletProcessExist(baseQQAppInterface.getApplication().getApplicationContext())) {
            isPaying = false;
        }
        if (isPaying) {
            if (aVar.f277009g + 43200000 <= System.currentTimeMillis()) {
                z16 = true;
            }
            isPaying = z16;
        }
        if (!isPaying) {
            aVar.f277010h = 2;
            A(baseQQAppInterface);
        }
    }

    @SuppressLint({"MissingPermission"})
    private static void D(BaseQQAppInterface baseQQAppInterface) {
        boolean z16;
        Vibrator vibrator;
        if (((IQQAppInterfaceTemp) QRoute.api(IQQAppInterfaceTemp.class)).getALLGeneralSettingVibrate(baseQQAppInterface) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (vibrator = (Vibrator) baseQQAppInterface.getApp().getSystemService("vibrator")) != null) {
            vibrator.vibrate(f278222d, -1);
        }
        QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "canVibrator=" + z16);
    }

    private static void b(BaseQQAppInterface baseQQAppInterface, String str, boolean z16) {
        SharedPreferences sharedPreferences = baseQQAppInterface.getApp().getSharedPreferences(IQWalletHelper.PREF_NAME_MULTI_PROCESS, 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean(str, z16).apply();
        }
    }

    private static boolean c(BaseQQAppInterface baseQQAppInterface, IQWalletPayApi.a aVar) {
        int i3;
        if (baseQQAppInterface != null && f278219a != null && aVar != null && (i3 = aVar.f277005c) >= 1 && i3 <= 7 && !TextUtils.isEmpty(aVar.f277006d)) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "params error, pcPayDatas=" + f278219a + ",app=" + baseQQAppInterface + ",pcPayData=" + aVar);
            return false;
        }
        return false;
    }

    private static boolean d(BaseQQAppInterface baseQQAppInterface, int i3, int i16) {
        if (i3 >= 1 && i3 <= 8 && i16 >= 1 && i16 <= 2 && baseQQAppInterface != null) {
            return true;
        }
        return false;
    }

    public static void e() {
        ArrayList<IQWalletPayApi.a> arrayList = f278219a;
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
    }

    public static IQWalletPayApi.a f(boolean z16) {
        ArrayList<IQWalletPayApi.a> arrayList = f278219a;
        if (arrayList == null) {
            return null;
        }
        if (z16) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                IQWalletPayApi.a aVar = f278219a.get(size);
                if (aVar != null && aVar.f277010h == 0) {
                    return aVar;
                }
            }
        } else {
            for (int i3 = 0; i3 < f278219a.size(); i3++) {
                IQWalletPayApi.a aVar2 = f278219a.get(i3);
                if (aVar2 != null && aVar2.f277010h == 0) {
                    return aVar2;
                }
            }
        }
        return null;
    }

    public static int g() {
        if (f278219a == null) {
            return 0;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < f278219a.size(); i16++) {
            IQWalletPayApi.a aVar = f278219a.get(i16);
            if (aVar != null && aVar.f277010h == 0) {
                i3++;
            }
        }
        return i3;
    }

    public static int h(int i3) {
        switch (i3) {
            case 1:
                return 9;
            case 2:
                return 4;
            case 3:
                return 11;
            case 4:
                return 8;
            case 5:
                return 7;
            case 6:
                return 6;
            case 7:
                return 5;
            case 8:
                return 14;
            default:
                return 0;
        }
    }

    private static IQWalletPayApi.a i() {
        if (f278219a == null) {
            return null;
        }
        for (int i3 = 0; i3 < f278219a.size(); i3++) {
            IQWalletPayApi.a aVar = f278219a.get(i3);
            if (aVar != null && aVar.f277010h == 1) {
                return aVar;
            }
        }
        return null;
    }

    protected static boolean j(long j3, int i3, long j16, int i16) {
        StringBuilder sb5 = new StringBuilder(32);
        sb5.append(j3);
        sb5.append(i3);
        sb5.append(j16);
        sb5.append(i16);
        String sb6 = sb5.toString();
        if (TextUtils.isEmpty(sb6)) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (f278220b) {
            if (Math.abs(currentTimeMillis - f278221c) > 1800000) {
                f278220b.clear();
            } else if (f278220b.containsKey(sb6)) {
                return true;
            }
            f278220b.put(sb6, null);
            f278221c = currentTimeMillis;
            return false;
        }
    }

    private static void k(BaseQQAppInterface baseQQAppInterface, JSONObject jSONObject) {
        SharedPreferences sharedPreferences = baseQQAppInterface.getApp().getSharedPreferences(IQWalletHelper.PREF_NAME_MULTI_PROCESS, 4);
        if (sharedPreferences != null) {
            String currentAccountUin = baseQQAppInterface.getCurrentAccountUin();
            long j3 = sharedPreferences.getLong(IQWalletHelper.PREF_KEY_MULTI_TENWATCH_REQ_TIME_PREFIX + currentAccountUin, 0L);
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
            if (serverTimeMillis < j3) {
                sharedPreferences.edit().putLong(IQWalletHelper.PREF_KEY_MULTI_TENWATCH_REQ_TIME_PREFIX + currentAccountUin, 0L).apply();
                return;
            }
            if (serverTimeMillis - j3 < 300) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("retCode", 0);
                    jSONObject2.put("retMsg", "");
                    jSONObject2.put("businessType", 4);
                    jSONObject2.put("retData", jSONObject);
                } catch (Exception e16) {
                    QLog.e("QWalletPushManager", 1, "error msg in qqpay-impl module: ", e16);
                }
                ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).onPayMsgRsp(4, "ResultCode.RESULT_OK", jSONObject2.toString());
            }
        }
    }

    private static void l(BaseQQAppInterface baseQQAppInterface, IQWalletPayApi.a aVar) {
        if (!c(baseQQAppInterface, aVar)) {
            return;
        }
        synchronized (f278219a) {
            f278219a.add(aVar);
            if (c.a(baseQQAppInterface)) {
                A(baseQQAppInterface);
            } else {
                z(baseQQAppInterface, aVar);
            }
            m(baseQQAppInterface, aVar);
        }
    }

    private static void m(BaseQQAppInterface baseQQAppInterface, IQWalletPayApi.a aVar) {
        String string;
        if (((IQWalletTemp) QRoute.api(IQWalletTemp.class)).isScreenLocked(baseQQAppInterface.getApp())) {
            ((PowerManager) baseQQAppInterface.getApp().getSystemService("power")).newWakeLock(268435462, IQWalletHelper.TAG_WALLET_PUSH).acquire(10000L);
            String format = String.format(BaseApplication.getContext().getString(R.string.g6t), Integer.valueOf(g()));
            if (!TextUtils.isEmpty(aVar.f277007e)) {
                string = aVar.f277007e;
            } else {
                string = BaseApplication.getContext().getString(R.string.g6s);
            }
            Intent intent = new Intent(baseQQAppInterface.getApp(), (Class<?>) QWalletLockScreenActivity.class);
            intent.addFlags(67108864);
            intent.addFlags(268435456);
            intent.addFlags(262144);
            intent.addFlags(1073741824);
            intent.putExtra("title", format);
            intent.putExtra("content", string);
            intent.putExtra("time", en.g(BaseApplication.getContext(), aVar.f277008f));
            baseQQAppInterface.getApp().startActivity(intent);
        }
        boolean isRingerSilent = ((IQQAppInterfaceTemp) QRoute.api(IQQAppInterfaceTemp.class)).isRingerSilent(baseQQAppInterface);
        boolean h16 = ad.h(baseQQAppInterface.getApp());
        boolean isVideoChatting = ((IQQAppInterfaceTemp) QRoute.api(IQQAppInterfaceTemp.class)).isVideoChatting(baseQQAppInterface);
        boolean isPttRecordingOrPlaying = ((IQQAppInterfaceTemp) QRoute.api(IQQAppInterfaceTemp.class)).isPttRecordingOrPlaying(baseQQAppInterface);
        boolean a16 = az.a(baseQQAppInterface.getApp().getApplicationContext(), baseQQAppInterface);
        if (QLog.isColorLevel()) {
            QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "isRingerSilent=" + isRingerSilent + ",isCalling=" + h16 + ",isVideoChatting=" + isVideoChatting + ",isRecordingPtt=" + isPttRecordingOrPlaying + ",canDisturb=" + a16);
        }
        if (a16 && !h16 && !isRingerSilent && !isVideoChatting && !isPttRecordingOrPlaying) {
            D(baseQQAppInterface);
            w(baseQQAppInterface);
        }
    }

    public static void n(final BaseQQAppInterface baseQQAppInterface, boolean z16) {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "onQQForeground isFromGestureLock=" + z16);
        }
        if (baseQQAppInterface == null || f(false) == null) {
            return;
        }
        if (z16) {
            i3 = 5;
        } else {
            i3 = 1000;
        }
        MqqHandler subThreadHandler = ThreadManager.getSubThreadHandler();
        if (subThreadHandler != null) {
            subThreadHandler.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qwallet.impl.QWalletPushManager.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.a(BaseQQAppInterface.this)) {
                        QWalletPushManager.A(BaseQQAppInterface.this);
                    }
                }
            }, i3);
        }
    }

    private static void o(BaseQQAppInterface baseQQAppInterface, String str) {
        if (TextUtils.isEmpty(str)) {
            com.tencent.mobileqq.qwallet.utils.f.b(IQWalletHelper.TAG_WALLET_PUSH, "params error: " + str);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean z16 = false;
            int optInt = jSONObject.optInt("module", 0);
            int optInt2 = jSONObject.optInt("action", 0);
            if (!d(baseQQAppInterface, optInt, optInt2)) {
                return;
            }
            if (optInt == 1) {
                z16 = p(optInt2, baseQQAppInterface);
            } else if (optInt == 2) {
                z16 = q(optInt2, baseQQAppInterface);
            }
            boolean isQWalletProcessExist = QWalletHelperDelegate.isQWalletProcessExist(baseQQAppInterface.getApp());
            if (z16 && isQWalletProcessExist) {
                y(baseQQAppInterface, optInt);
            }
        } catch (JSONException e16) {
            com.tencent.mobileqq.qwallet.utils.f.d(IQWalletHelper.TAG_WALLET_PUSH, "Parsing PCPAYDATA throws JSONException.", e16);
        }
    }

    private static boolean p(int i3, BaseQQAppInterface baseQQAppInterface) {
        if (i3 == 1) {
            b(baseQQAppInterface, IQWalletHelper.PREF_KEY_MULTI_IS_REFRESH_HOME, true);
            return true;
        }
        if (i3 == 2) {
            FileUtils.deleteFile(baseQQAppInterface.getApp().getFilesDir() + "/" + MD5.toMD5("qwallet_home_recomment_" + baseQQAppInterface.getCurrentAccountUin()));
            StringBuilder sb5 = new StringBuilder();
            sb5.append("qwallet_home_recomment_");
            sb5.append(baseQQAppInterface.getCurrentAccountUin());
            FileUtils.deleteFile(baseQQAppInterface.getApp().getFilesDir() + "/" + MD5.toMD5(sb5.toString()) + "_");
            return true;
        }
        return false;
    }

    private static boolean q(int i3, BaseQQAppInterface baseQQAppInterface) {
        if (i3 == 1) {
            b(baseQQAppInterface, IQWalletHelper.PREF_KEY_MULTI_IS_REFRESH_CENTER, true);
            return true;
        }
        if (i3 == 2) {
            FileUtils.deleteFile(baseQQAppInterface.getApp().getFilesDir() + "/" + MD5.toMD5("qwallet_home_personalInfo_" + baseQQAppInterface.getCurrentAccountUin()));
            return true;
        }
        return false;
    }

    public static void r(BaseQQAppInterface baseQQAppInterface, byte[] bArr, long j3, int i3, long j16, int i16) {
        byte[] bArr2;
        if (bArr != null && !j(j3, i3, j16, i16)) {
            int i17 = -1;
            try {
                QWalletSubmsgtype0x66$MsgBody convertToMsgBody = ((IQWalletPBTemp) QRoute.api(IQWalletPBTemp.class)).convertToMsgBody(bArr);
                i17 = convertToMsgBody.pushType;
                bArr2 = convertToMsgBody.pushData;
            } catch (Exception e16) {
                QLog.w(IQWalletHelper.TAG_WALLET_PUSH, 2, "Parsing Msg0x210Sub0x66 data throws Exception.", e16);
                bArr2 = null;
            }
            QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "pushType = " + i17);
            if (bArr2 == null) {
                return;
            }
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 != 5) {
                        if (i17 != 8) {
                            QLog.w(IQWalletHelper.TAG_WALLET_PUSH, 2, "Unknow pushType.");
                            return;
                        } else {
                            u(bArr2);
                            return;
                        }
                    }
                    t(baseQQAppInterface, bArr2);
                    return;
                }
                try {
                    o(baseQQAppInterface, new String(bArr2, "UTF-8"));
                    return;
                } catch (Exception e17) {
                    QLog.e(IQWalletHelper.TAG_WALLET_PUSH, 2, "Coverting pushData Exception.", e17);
                    return;
                }
            }
            s(baseQQAppInterface, bArr2);
        }
    }

    private static void s(BaseQQAppInterface baseQQAppInterface, byte[] bArr) {
        try {
            String str = new String(bArr, "UTF-8");
            if (!TextUtils.isEmpty(str)) {
                IQWalletPayApi.a aVar = new IQWalletPayApi.a();
                aVar.f277008f = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject(str);
                aVar.f277003a = jSONObject.optLong("tradeTime", 0L);
                aVar.f277004b = jSONObject.optInt("expTime", 0);
                aVar.f277005c = jSONObject.optInt("payType", 0);
                aVar.f277007e = jSONObject.optString("notifyText");
                JSONObject optJSONObject = jSONObject.optJSONObject("payData");
                if (optJSONObject != null) {
                    aVar.f277006d = optJSONObject.toString();
                }
                l(baseQQAppInterface, aVar);
            }
        } catch (Exception e16) {
            QLog.e(IQWalletHelper.TAG_WALLET_PUSH, 2, "Coverting pushData Exception.", e16);
        }
    }

    private static void t(BaseQQAppInterface baseQQAppInterface, byte[] bArr) {
        try {
            String str = new String(bArr, "UTF-8");
            if (!TextUtils.isEmpty(str)) {
                IQWalletPayApi.a aVar = new IQWalletPayApi.a();
                aVar.f277008f = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject(str);
                aVar.f277003a = jSONObject.optLong("tradeTime", 0L);
                aVar.f277004b = jSONObject.optInt("expTime", 0);
                aVar.f277005c = jSONObject.optInt("payType", 0);
                aVar.f277007e = jSONObject.optString("notifyText");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(HippyHeaderListViewController.VIEW_TAG, "hbPackConfirm");
                jSONObject2.put(PayProxy.Source.PAY_REQUEST_PAY_COME_FROM, 2);
                jSONObject2.put("appInfo", "appid#1344242394|bargainor_id#1000030201|channel#pc@0001");
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.putOpt("push_data", jSONObject.optString("key", ""));
                jSONObject2.put("extra_data", jSONObject3.toString());
                aVar.f277006d = jSONObject2.toString();
                l(baseQQAppInterface, aVar);
            }
        } catch (Exception e16) {
            QLog.e(IQWalletHelper.TAG_WALLET_PUSH, 2, "Coverting pushData Exception.", e16);
        }
    }

    private static void u(byte[] bArr) {
        try {
            QWalletGoldMsgTipsElem convertTroopTips = ((IQWalletPBTemp) QRoute.api(IQWalletPBTemp.class)).convertTroopTips(bArr);
            if (convertTroopTips.type == 3) {
                ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).pushBy0x210Sub0x66(bArr);
                NotifyMsgApiImpl.onReceiveAAPaySysNotifyStatic(0, convertTroopTips, null);
            }
        } catch (Exception e16) {
            QLog.e(IQWalletHelper.TAG_WALLET_PUSH, 2, "Coverting pushData Exception.", e16);
        }
    }

    public static void v(BaseQQAppInterface baseQQAppInterface, byte[] bArr, long j3, int i3, long j16, int i16) {
        if (bArr == null) {
            QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "parseMsg0x210Sub0x7e,msgType0x210Bytes is null");
            return;
        }
        if (j(j3, i3, j16, i16)) {
            QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "parseMsg0x210Sub0x7e,msg repeated");
            return;
        }
        try {
            QWalletSubmsgtype0x7e$MsgBody$OnlinePush convertToOnlinePush = ((IQWalletPBTemp) QRoute.api(IQWalletPBTemp.class)).convertToOnlinePush(bArr);
            if (convertToOnlinePush == null) {
                return;
            }
            int i17 = convertToOnlinePush.action;
            String str = convertToOnlinePush.extend;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("action", i17);
                jSONObject.put(QFSEdgeItem.KEY_EXTEND, new JSONObject(str));
                Intent intent = new Intent(Cgi.BROADCAST_INTENT_ACTION_PUSH);
                intent.putExtra("extra_data", jSONObject.toString());
                BaseApplication.getContext().sendBroadcast(intent);
                QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "parseMsg0x210Sub0x7e, extra=" + jSONObject);
            } catch (Exception e16) {
                QLog.w(IQWalletHelper.TAG_WALLET_PUSH, 2, "Parsing Msg0x210Sub0x7e data throws Exception.", e16);
            }
            k(baseQQAppInterface, jSONObject);
            if (QLog.isDevelopLevel()) {
                QLog.i(IQWalletHelper.TAG_WALLET_PUSH, 4, "Receive Data, action:" + i17 + " timestamp:" + convertToOnlinePush.timestamp + " extend:" + str + " serialno:" + convertToOnlinePush.serialno + " billno:" + convertToOnlinePush.billno + " appinfo:" + convertToOnlinePush.appinfo + " amount:" + convertToOnlinePush.amount + " jumpurl:" + convertToOnlinePush.jumpurl + " json:" + jSONObject);
            }
        } catch (Exception e17) {
            QLog.w(IQWalletHelper.TAG_WALLET_PUSH, 2, "Parsing Msg0x210Sub0x7e data throws Exception.", e17);
        }
    }

    private static void w(BaseQQAppInterface baseQQAppInterface) {
        boolean z16;
        if (((IQQAppInterfaceTemp) QRoute.api(IQQAppInterfaceTemp.class)).getALLGeneralSettingRing(baseQQAppInterface) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            String themeVoiceRootPath = ThemeUtil.getThemeVoiceRootPath();
            if (themeVoiceRootPath != null) {
                File file = new File(themeVoiceRootPath + File.separatorChar + "message.mp3");
                if (file.exists()) {
                    AudioUtil.p(Uri.fromFile(file), false, true);
                    return;
                }
            }
            AudioUtil.r(R.raw.f169478ac, false);
        }
        QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "canPlaySound=" + z16);
    }

    public static void x() {
        ArrayList<IQWalletPayApi.a> arrayList = f278219a;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            IQWalletPayApi.a aVar = f278219a.get(size);
            if (aVar == null || aVar.f277010h == 1) {
                f278219a.remove(size);
            }
        }
    }

    private static void y(BaseQQAppInterface baseQQAppInterface, int i3) {
        String str;
        if (i3 == 1) {
            str = IQWalletHelper.ACTION_BROADCAST_RERESH_HOME;
        } else {
            str = IQWalletHelper.ACTION_BROADCAST_RERESH_CENTER;
        }
        baseQQAppInterface.getApp().sendBroadcast(new Intent(str));
    }

    private static void z(BaseQQAppInterface baseQQAppInterface, IQWalletPayApi.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d(IQWalletHelper.TAG_WALLET_PUSH, 2, "startBackgroundPay");
        }
        if (baseQQAppInterface != null && baseQQAppInterface.getApp() != null && aVar != null) {
            String format = String.format(BaseApplication.getContext().getString(R.string.g6t), Integer.valueOf(g()));
            String str = aVar.f277007e;
            if (TextUtils.isEmpty(str)) {
                str = BaseApplication.getContext().getString(R.string.g6s);
            }
            Bundle bundle = new Bundle();
            bundle.putString("callbackSn", "0");
            bundle.putBoolean("payparmas_from_pcpush", true);
            bundle.putInt("pay_requestcode", 12);
            bundle.putInt(PayProxy.Source.PAY_TYPE_EXTRA_KEY, 2);
            Intent payBridgeIntent = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getPayBridgeIntent(baseQQAppInterface.getApp());
            payBridgeIntent.addFlags(268435456);
            payBridgeIntent.putExtras(bundle);
            payBridgeIntent.putExtra(QQNotificationManager.PARAM_NOTIFYID, 238);
            try {
                Notification build = NotificationFactory.createNotificationCompatBuilder(QQNotificationManager.CHANNEL_ID_SHOW_BADGE).setSmallIcon(R.drawable.b8f).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentTitle(format).setContentText(str).setContentIntent(PendingIntent.getActivity(baseQQAppInterface.getApp(), 12, payBridgeIntent, 1140850688)).build();
                QQNotificationManager qQNotificationManager = QQNotificationManager.getInstance();
                if (qQNotificationManager != null) {
                    qQNotificationManager.cancel(IQWalletHelper.TAG_WALLET_PUSH, 238);
                    qQNotificationManager.notify(IQWalletHelper.TAG_WALLET_PUSH, 238, build);
                }
            } catch (Throwable th5) {
                QLog.e("QWalletPushManager", 1, th5, new Object[0]);
            }
        }
    }
}
