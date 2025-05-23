package com.tencent.qzonehub.api.impl;

import NS_MOBILE_FEEDS.mobile_online_report_item;
import com.qzone.reborn.publicaccount.QZonePublicAccountNotifyPushRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.servlet.i;
import com.tencent.mobileqq.servlet.j;
import com.tencent.mobileqq.servlet.k;
import com.tencent.mobileqq.servlet.m;
import com.tencent.mobileqq.servlet.n;
import com.tencent.mobileqq.servlet.o;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qzonehub.api.IQzoneReq;
import cooperation.qzone.report.QzoneOnlineTimeServlet;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QzoneReqImpl implements IQzoneReq {
    @Override // com.tencent.qzonehub.api.IQzoneReq
    public void sendPublicAccountPushReq() {
        QZonePublicAccountNotifyPushRequest.requestPushMessage();
    }

    @Override // com.tencent.qzonehub.api.IQzoneReq
    public void sentGetAlbumListNumServlet(BusinessObserver businessObserver, long j3) {
        NewIntent newIntent = new NewIntent(BaseApplication.getContext(), i.class);
        newIntent.putExtra("selfuin", j3);
        BaseApplicationImpl.getApplication().getRuntime().registObserver(businessObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    @Override // com.tencent.qzonehub.api.IQzoneReq
    public void sentGetGroupCountServlet(BusinessObserver businessObserver, long j3, long j16) {
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), k.class);
        newIntent.putExtra("key_uin", j3);
        newIntent.putExtra("key_troop_uin", j16);
        BaseApplicationImpl.getApplication().getRuntime().registObserver(businessObserver);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    @Override // com.tencent.qzonehub.api.IQzoneReq
    public void sentPushAckServlet(long j3, long j16, String str, long j17) {
        NewIntent newIntent = new NewIntent(BaseApplication.getContext(), n.class);
        newIntent.putExtra("timestamp", j3);
        newIntent.putExtra("hostuin", j16);
        newIntent.putExtra("mark", str);
        newIntent.putExtra("flag", j17);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }

    @Override // com.tencent.qzonehub.api.IQzoneReq
    public void sentGetPublicMsgServlet(AppRuntime appRuntime, BusinessObserver businessObserver, long j3, String str) {
        if (appRuntime == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(BaseApplicationImpl.getApplication(), o.class);
        newIntent.putExtra("key_uin", Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
        newIntent.putExtra("has_photo", str);
        appRuntime.registObserver(businessObserver);
        appRuntime.startServlet(newIntent);
    }

    @Override // com.tencent.qzonehub.api.IQzoneReq
    public void sentNewestFeedServlet(AppRuntime appRuntime, BusinessObserver businessObserver, long j3, long[] jArr, long j16, int i3) {
        if (appRuntime == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(appRuntime.getApplicationContext(), j.class);
        newIntent.putExtra("selfuin", j3);
        newIntent.putExtra("hostuin", jArr);
        newIntent.putExtra("lasttime", j16);
        newIntent.putExtra("src", i3);
        appRuntime.registObserver(businessObserver);
        appRuntime.startServlet(newIntent);
    }

    @Override // com.tencent.qzonehub.api.IQzoneReq
    public void sentOnlineServlet(AppRuntime appRuntime, String str, long j3) {
        if (appRuntime == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(appRuntime.getApplication(), m.class);
        newIntent.putExtra("key_uin", str);
        newIntent.putExtra("lastPushMsgTime", j3);
        appRuntime.startServlet(newIntent);
    }

    @Override // com.tencent.qzonehub.api.IQzoneReq
    public void sentOnlineTimeServlet(ArrayList<mobile_online_report_item> arrayList) {
        if (arrayList == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(BaseApplication.getContext(), QzoneOnlineTimeServlet.class);
        newIntent.putExtra("list", arrayList);
        BaseApplicationImpl.getApplication().getRuntime().startServlet(newIntent);
    }
}
