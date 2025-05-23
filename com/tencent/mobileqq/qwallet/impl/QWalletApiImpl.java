package com.tencent.mobileqq.qwallet.impl;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.qq.taf.jce.JceStruct;
import com.tencent.ark.ark;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.mobileqq.activity.PayBridgeActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.qwallet.impl.servlet.QWalletTempServlet;
import com.tencent.mobileqq.qwallet.ipc.impl.QWalletIPCModule;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QWalletApiImpl implements IQWalletApi {
    public static final String TAG = "QWalletApiImpl";

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public void applyRotateAnimation(boolean z16, ViewGroup viewGroup, View view, View view2) {
        com.tencent.mobileqq.qwallet.hb.grap.b.b(z16, viewGroup, view, view2);
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public void clearQWalletCache() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qwallet.impl.QWalletApiImpl.1
            @Override // java.lang.Runnable
            public void run() {
                BaseApplication.getContext().getSharedPreferences("qwallet_can_clear", 4).edit().clear().apply();
                rl2.d.a();
            }
        }, 64, null, true);
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public long convertStringToTime(String str) {
        return d.a(str);
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public String cutTextByPix(Context context, String str, float f16, TextPaint textPaint) {
        return d.c(context, str, f16, textPaint);
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public View.OnTouchListener getAlphaChangeListener(float f16) {
        return d.f(f16);
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public String getEncodeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "error msg in qqpay-impl module: ", th5);
            return "";
        }
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public String getGuildNickName(AppRuntime appRuntime, String str, String str2) {
        return com.tencent.mobileqq.qwallet.hb.aio.impl.d.a(appRuntime, str, str2);
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public Intent getPayBridgeIntent(Context context) {
        return PayBridgeActivity.createLaunchIntent(context);
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public BaseQQAppInterface getQQAppInterface() {
        return d.n();
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public long getQWalletCacheSize() {
        return rl2.d.e();
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public QIPCModule getQWalletIPCModule() {
        return QWalletIPCModule.i();
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public AbsDownloader getQWalletPicDownloader() {
        return new a();
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public String getQWalletTmpPath() {
        return d.o();
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public void grapHbWithParam(AppInterface appInterface, String str, String str2, String str3, ResultReceiver resultReceiver) {
        d.p(appInterface, str, str2, str3, resultReceiver);
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public boolean isOnView(View view, float f16, float f17) {
        return d.q(view, f16, f17);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
    
        r5 = r5.get(0).topActivity;
     */
    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isQWalletAtTop(Context context) {
        List<ActivityManager.RunningTaskInfo> list;
        ComponentName componentName;
        try {
            list = ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(1);
        } catch (SecurityException e16) {
            QLog.w(TAG, 1, "occur SecurityException:", e16);
            list = null;
        }
        if (list == null || list.size() < 1 || componentName == null) {
            return false;
        }
        String className = componentName.getClassName();
        if (!TextUtils.isEmpty(className) && (className.contains("com.pay") || className.contains("com.tenpay"))) {
            QLog.w(TAG, 1, "qwallet at the top:" + className);
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public boolean jumpToHbDetail(Context context, Map<String, String> map) {
        String str = map.get("listid");
        String str2 = map.get("authkey");
        String str3 = map.get("grouptype");
        String str4 = map.get(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID);
        String str5 = map.get("name");
        String str6 = map.get("guild_id");
        String str7 = map.get("sub_guild_id");
        String str8 = map.get("tinyid");
        if (!TextUtils.isEmpty(str) && (!TextUtils.isEmpty(str7) || !TextUtils.isEmpty(str4))) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("listid", str);
                jSONObject.put("name", str5);
                jSONObject.put("grouptype", str3);
                jSONObject.put(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, str4);
                if (str2 != null) {
                    jSONObject.put("authkey", str2);
                }
                jSONObject2.put("guildId", str6);
                jSONObject2.put("subGuildId", str7);
                jSONObject2.put("tinyId", str8);
                jSONObject2.put("userId", com.tencent.mobileqq.base.a.c());
                jSONObject2.put(HippyHeaderListViewController.VIEW_TAG, "redgiftDetail");
                jSONObject2.put(j.T0, "appid#1344242394|bargainor_id#1000030201|channel#graytips");
                jSONObject2.put("come_from", 2);
                jSONObject2.put("extra_data", jSONObject);
                Bundle bundle = new Bundle();
                bundle.putString(ark.ARKMETADATA_JSON, jSONObject2.toString());
                bundle.putString("callbackSn", "0");
                Intent createLaunchIntent = PayBridgeActivity.createLaunchIntent(context);
                createLaunchIntent.putExtras(bundle);
                createLaunchIntent.putExtra("pay_requestcode", 5);
                if (context instanceof Application) {
                    createLaunchIntent.addFlags(268435456);
                }
                context.startActivity(createLaunchIntent);
                return true;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "error, exception: " + e16);
                return false;
            }
        }
        QLog.e(TAG, 1, "error, info is empty");
        return false;
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public String md5Encode(String str) {
        return d.u(str);
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public Object readObject(String str) throws Exception {
        return d.v(str);
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public void reportTenpay(int i3, String str) {
        com.tencent.mobileqq.qwallet.c.c(str, Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public void reqReportHBGame(String str, long j3, String str2, int i3, boolean z16, boolean z17, int i16) {
        d.w(str, j3, str2, i3, z16, z17, i16);
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public void saveObject(Object obj, String str) {
        d.x(obj, str);
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public void servletSendRequest(JceStruct jceStruct, BusinessObserver businessObserver) {
        QWalletTempServlet.b(jceStruct, businessObserver);
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public void setAlphaChangeListener(View view, float f16) {
        if (view != null) {
            view.setOnTouchListener(getAlphaChangeListener(f16));
        }
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public void sortByFileNameNum(File[] fileArr) {
        d.z(fileArr);
    }

    @Override // com.tencent.mobileqq.qwallet.IQWalletApi
    public boolean unzipAtomically(String str, String str2) {
        return d.C(str, str2);
    }
}
