package com.tencent.mobileqq.onlinestatus.api.impl;

import android.text.TextUtils;
import androidx.fragment.app.FragmentManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusMiniService;
import com.tencent.mobileqq.onlinestatus.model.CustomShareInfo;
import com.tencent.mobileqq.onlinestatus.tencentvideo.TencentVideoNameHandler;
import com.tencent.mobileqq.onlinestatus.utils.ad;
import com.tencent.mobileqq.onlinestatus.view.SyncStatusExtInfoPopWindow;
import com.tencent.mobileqq.onlinestatus.y;
import com.tencent.mobileqq.widget.QQToast;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OnlineStatusMiniServiceImpl implements IOnlineStatusMiniService {
    private static final String TAG = "OnlineStatusMiniServiceImpl";

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusMiniService
    public void doShowTencentVideoStatusPopWindow(QBaseActivity qBaseActivity, String str, String str2, String str3, int i3, JSONObject jSONObject, IOnlineStatusMiniService.c cVar, IOnlineStatusMiniService.a aVar) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            SyncStatusExtInfoPopWindow syncStatusExtInfoPopWindow = new SyncStatusExtInfoPopWindow(str, str2, str3, com.tencent.mobileqq.onlinestatus.utils.f.c(AppRuntime.Status.online, 1021L, jSONObject), null, null, (AppInterface) qBaseActivity.getAppRuntime());
            FragmentManager supportFragmentManager = qBaseActivity.getSupportFragmentManager();
            syncStatusExtInfoPopWindow.Th(i3);
            syncStatusExtInfoPopWindow.Vh(cVar);
            syncStatusExtInfoPopWindow.Rh(aVar);
            syncStatusExtInfoPopWindow.show(supportFragmentManager, "tencentVideoStatusPopWindow");
            return;
        }
        QQToast.makeText(qBaseActivity, R.string.f238167j1, 0).show();
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusMiniService
    public void sendReqToGetVideoName(String str, y.f fVar) {
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        TencentVideoNameHandler tencentVideoNameHandler = (TencentVideoNameHandler) appInterface.getBusinessHandler(TencentVideoNameHandler.class.getName());
        tencentVideoNameHandler.E2(fVar);
        tencentVideoNameHandler.D2(2, str, appInterface.getCurrentAccountUin());
    }

    @Override // com.tencent.mobileqq.onlinestatus.api.IOnlineStatusMiniService
    public void setTencentVideoStatus(AppInterface appInterface, String str, String str2, CustomShareInfo customShareInfo, IOnlineStatusMiniService.b bVar) {
        ad.c(str, str2, customShareInfo, appInterface, bVar);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
    }
}
