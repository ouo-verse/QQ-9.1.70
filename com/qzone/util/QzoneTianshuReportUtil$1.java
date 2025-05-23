package com.qzone.util;

import TianShuJce.AdItem;
import TianShuJce.AdPlacementInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
class QzoneTianshuReportUtil$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ byte[] f59750d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f59751e;

    @Override // java.lang.Runnable
    public void run() {
        AdItem adItem;
        try {
            AdPlacementInfo adPlacementInfo = (AdPlacementInfo) cooperation.vip.a.a(AdPlacementInfo.class, this.f59750d);
            if (adPlacementInfo != null) {
                ArrayList<AdItem> arrayList = adPlacementInfo.lst;
                if (arrayList != null && arrayList.size() > 0) {
                    adItem = adPlacementInfo.lst.get(0);
                    ak.f(adItem, this.f59751e);
                }
                adItem = null;
                ak.f(adItem, this.f59751e);
            }
        } catch (Exception e16) {
            QLog.e("QzoneTianshuReportUtil", 1, "exception is " + e16);
        }
    }
}
