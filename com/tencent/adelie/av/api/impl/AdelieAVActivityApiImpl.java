package com.tencent.adelie.av.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.adelie.av.api.IAdelieAVActivityApi;
import com.tencent.adelie.av.qav.AdelieAVController;
import com.tencent.adelie.av.ui.AdelieAVActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import rp.a;

/* compiled from: P */
/* loaded from: classes37.dex */
public class AdelieAVActivityApiImpl implements IAdelieAVActivityApi {
    private static final String TAG = "AdelieAVActivityApiImpl";
    public static long sPlusPanelClickTime;

    @Override // com.tencent.adelie.av.api.IAdelieAVActivityApi
    public boolean isInAdelieAVRoom() {
        return AdelieAVController.J() && AdelieAVController.D().G();
    }

    @Override // com.tencent.adelie.av.api.IAdelieAVActivityApi
    public boolean isOpenEntrance() {
        return a.d();
    }

    @Override // com.tencent.adelie.av.api.IAdelieAVActivityApi
    public void setClickTime(long j3) {
        sPlusPanelClickTime = j3;
    }

    @Override // com.tencent.adelie.av.api.IAdelieAVActivityApi
    public void startActivity(Context context, Intent intent) {
        intent.setClass(context, AdelieAVActivity.class);
        context.startActivity(intent);
    }

    @Override // com.tencent.adelie.av.api.IAdelieAVActivityApi
    public void startAudioCall(long j3, AppRuntime appRuntime, Context context, int i3, String str) {
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179557e = String.valueOf(j3);
        sessionInfo.f179559f = String.valueOf(j3);
        sessionInfo.f179555d = i3;
        sessionInfo.f179563i = str;
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        if (qQAppInterface.getAVNotifyCenter().g(context, 1, sessionInfo.f179555d, sessionInfo.f179557e)) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("should_believe_only_audio_flag", "true");
        hashMap.put("from", "1");
        QLog.i(TAG, 1, "startAudioCall uin:" + j3 + " chatType:" + i3 + " nick:" + str);
        ((IAdelieAVActivityApi) QRoute.api(IAdelieAVActivityApi.class)).setClickTime(System.currentTimeMillis());
        PlusPanelUtils.h(qQAppInterface, context, sessionInfo, true, "AIO_Adelie_AV", hashMap);
    }
}
