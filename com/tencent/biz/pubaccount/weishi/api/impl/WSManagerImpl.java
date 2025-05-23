package com.tencent.biz.pubaccount.weishi.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi.api.IWSManager;
import com.tencent.biz.pubaccount.weishi.cache.WSRedDotPreloadManager;
import com.tencent.biz.pubaccount.weishi.q;
import com.tencent.biz.pubaccount.weishi.report.e;
import com.tencent.biz.pubaccount.weishi.util.ao;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.j;
import com.tencent.biz.pubaccount.weishi.z;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import d20.a;
import d20.d;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSManagerImpl implements IWSManager {
    @Override // com.tencent.biz.pubaccount.weishi.api.IWSManager
    public boolean doJumpAction(String str, Context context, Map<String, String> map, Object obj) {
        a a16 = d.a(str);
        if (a16 != null) {
            return a16.a(context, map, obj);
        }
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.api.IWSManager
    public void enterTrendsTabWs(Context context, String str, boolean z16, BusinessInfoCheckUpdate.AppInfo appInfo, Intent intent) {
        z.e(context, str, z16, appInfo, intent);
    }

    @Override // com.tencent.biz.pubaccount.weishi.api.IWSManager
    public boolean enterWSOperationH5(Context context, HashMap<String, String> hashMap) {
        return z.g(context, hashMap);
    }

    @Override // com.tencent.biz.pubaccount.weishi.api.IWSManager
    public void enterWSPublicAccount(Context context, String str, boolean z16) {
        z.l(context, new q(str, 0, z16));
    }

    @Override // com.tencent.biz.pubaccount.weishi.api.IWSManager
    public boolean enterWSVerticalPlayerPageForMiniApp(Context context, HashMap<String, String> hashMap) {
        return n00.a.a().b(context, hashMap);
    }

    @Override // com.tencent.biz.pubaccount.weishi.api.IWSManager
    public QIPCModule getIPCModule() {
        return com.tencent.biz.pubaccount.weishi.ipc.a.b();
    }

    @Override // com.tencent.biz.pubaccount.weishi.api.IWSManager
    public void handleArkJump(String str, String str2) {
        j.e(str, str2);
    }

    @Override // com.tencent.biz.pubaccount.weishi.api.IWSManager
    public boolean isBeaconRealtimeSwitchOpen() {
        return e.f81531f;
    }

    @Override // com.tencent.biz.pubaccount.weishi.api.IWSManager
    public boolean isFastClick() {
        return bb.E();
    }

    @Override // com.tencent.biz.pubaccount.weishi.api.IWSManager
    public void openQQSchema(Context context, String str, Object obj) {
        c20.a.d(context, str, obj);
    }

    @Override // com.tencent.biz.pubaccount.weishi.api.IWSManager
    public void openWeishi(Context context, String str, String str2) {
        ao.e(context, str, str2);
    }

    @Override // com.tencent.biz.pubaccount.weishi.api.IWSManager
    public void preloadData() {
        WSRedDotPreloadManager.d().g();
    }

    @Override // com.tencent.biz.pubaccount.weishi.api.IWSManager
    public void sendArkMsg(Bundle bundle, sy.a aVar) {
        k10.a.f411382a.a(bundle, aVar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.api.IWSManager
    public void setBeaconRealtimeSwitchOpen(boolean z16) {
        e.f81531f = z16;
    }

    @Override // com.tencent.biz.pubaccount.weishi.api.IWSManager
    public void setWeishiLastFeedId(String str) {
        bb.f81755c = str;
    }
}
