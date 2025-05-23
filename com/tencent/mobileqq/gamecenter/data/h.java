package com.tencent.mobileqq.gamecenter.data;

import android.text.TextUtils;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.api.impl.GameMsgManagerServiceImpl;
import com.tencent.mobileqq.gamecenter.message.TinyInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
@Deprecated
/* loaded from: classes12.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public TinyInfo f212024a = new TinyInfo();

    /* renamed from: b, reason: collision with root package name */
    public String f212025b;

    public static String a(AppRuntime appRuntime, String str) {
        TinyInfo tinyInfo;
        if (appRuntime == null) {
            QLog.w("GameCenterMsg.GameQQPlayerUtil", 1, "[getMsgExtraString] fails, app is null");
            return null;
        }
        h hVar = ((GameMsgManagerServiceImpl) appRuntime.getRuntimeService(IGameMsgManagerService.class, "")).mQQPlayerUtil;
        if (hVar == null || !hVar.b(str) || (tinyInfo = hVar.f212024a) == null) {
            return null;
        }
        return tinyInfo.toJsonStr();
    }

    private boolean b(String str) {
        if (!TextUtils.isEmpty(str) && str.equals(this.f212025b)) {
            return true;
        }
        return false;
    }
}
