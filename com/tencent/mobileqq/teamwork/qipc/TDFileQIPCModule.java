package com.tencent.mobileqq.teamwork.qipc;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.open.base.f;
import eipc.EIPCResult;

/* loaded from: classes18.dex */
public class TDFileQIPCModule extends QIPCModule {
    public TDFileQIPCModule() {
        super("Module_TDFileChangeNameQIPCModule");
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        f.a("TDFileQIPCModule", "onCall action|" + str + " params|" + bundle + " callbackId|" + i3);
        if (str.equals("Action_url_2_fmdb")) {
            final String string = bundle.getString("url");
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.teamwork.qipc.TDFileQIPCModule.1
                @Override // java.lang.Runnable
                public void run() {
                    ((ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class)).processTDDocFileUrl(string);
                }
            }, null, true);
        }
        return null;
    }
}
