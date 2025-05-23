package com.qzone.business.tianshu;

import android.text.TextUtils;
import com.qzone.business.tianshu.model.QZoneBubbleInfo;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class k extends b {

    /* renamed from: c, reason: collision with root package name */
    private static volatile k f44878c;

    /* renamed from: b, reason: collision with root package name */
    private QZoneBubbleInfo f44879b;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
    }

    public static k i() {
        if (f44878c == null) {
            synchronized (k.class) {
                if (f44878c == null) {
                    f44878c = new k();
                }
            }
        }
        return f44878c;
    }

    @Override // com.qzone.business.tianshu.b
    int b() {
        return gdt_analysis_event.EVENT_REWARDED_VIDEO_DATA_WITHOUT_GDTAD;
    }

    @Override // com.qzone.business.tianshu.b
    public void f(int i3) {
        TianShuAccess.AdItem adItem = this.f44856a;
        if (adItem == null || adItem.argList.get() == null) {
            return;
        }
        List<TianShuAccess.MapEntry> list = this.f44856a.argList.get();
        HashMap hashMap = new HashMap();
        for (TianShuAccess.MapEntry mapEntry : list) {
            String str = mapEntry.key.get();
            String str2 = mapEntry.value.get();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                hashMap.put(str, str2);
            }
        }
        QZoneBubbleInfo qZoneBubbleInfo = new QZoneBubbleInfo(this.f44856a);
        this.f44879b = qZoneBubbleInfo;
        qZoneBubbleInfo.setId(String.valueOf(this.f44856a.iAdId.get()));
        this.f44879b.setAdItem(this.f44856a);
        this.f44879b.setMaxTimes(com.qzone.album.util.o.a((String) hashMap.get("max"), 1));
        this.f44879b.setWords((String) hashMap.get("writing"));
        this.f44879b.setStartTime(com.qzone.album.util.o.b((String) hashMap.get("startTime"), 0L));
        this.f44879b.setEndTime(com.qzone.album.util.o.b((String) hashMap.get("endTime"), 0L));
        this.f44879b.setLeftImageUrl((String) hashMap.get("pic"));
    }

    public void j() {
        QLog.i("QZoneIntimateEntranceGuideBubbleHelper", 1, "QZoneIntimateEntranceGuideBubbleHelper release");
        i().k(null);
    }

    @Override // com.qzone.business.tianshu.b
    List<Integer> c() {
        return Collections.singletonList(Integer.valueOf(gdt_analysis_event.EVENT_REWARDED_VIDEO_DATA_WITHOUT_GDTAD));
    }

    public void k(a aVar) {
    }
}
