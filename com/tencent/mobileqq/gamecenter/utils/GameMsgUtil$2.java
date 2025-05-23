package com.tencent.mobileqq.gamecenter.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
class GameMsgUtil$2 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AppInterface f213414d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f213415e;

    @Override // java.lang.Runnable
    public void run() {
        try {
            IGameMsgBoxManager iGameMsgBoxManager = (IGameMsgBoxManager) this.f213414d.getRuntimeService(IGameMsgBoxManager.class, "");
            gd1.a findGameDetailInfoByConvertUin = iGameMsgBoxManager.findGameDetailInfoByConvertUin(this.f213415e);
            if (findGameDetailInfoByConvertUin == null) {
                return;
            }
            String str = "1";
            if (iGameMsgBoxManager.getUnreadCount(this.f213415e) > 0) {
                str = "0";
            }
            f.c0(findGameDetailInfoByConvertUin.f401939c, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92004", "206349", "", "3", "20", str);
        } catch (Throwable th5) {
            QLog.e(f.f213434a, 1, th5, new Object[0]);
        }
    }
}
