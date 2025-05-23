package com.qzone.business.tianshu;

import android.text.TextUtils;
import android.util.Log;
import com.qzone.business.tianshu.model.QZoneBubbleInfo;
import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.vip.pb.TianShuAccess;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class h extends b {

    /* renamed from: d, reason: collision with root package name */
    private static volatile h f44869d;

    /* renamed from: b, reason: collision with root package name */
    private QZoneBubbleInfo f44870b;

    /* renamed from: c, reason: collision with root package name */
    private a f44871c;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface a {
        void a(QZoneBubbleInfo qZoneBubbleInfo);
    }

    private void k(final byte[] bArr) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.business.tianshu.g
            @Override // java.lang.Runnable
            public final void run() {
                h.this.p(bArr);
            }
        });
    }

    public static h l() {
        if (f44869d == null) {
            synchronized (h.class) {
                if (f44869d == null) {
                    f44869d = new h();
                }
            }
        }
        return f44869d;
    }

    private String n(String str) {
        return "gallery_entrance_bubble_count" + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(byte[] bArr) {
        try {
            TianShuAccess.RspEntry rspEntry = new TianShuAccess.RspEntry();
            rspEntry.mergeFrom(bArr);
            if (!rspEntry.has() || !h(rspEntry) || !t(rspEntry.key.get())) {
                super.a();
            } else {
                this.f44856a = rspEntry.value.lst.get(0);
                f(rspEntry.key.get());
                QLog.d("QZoneGalleryEntranceGuideBubbleHelper", 1, "fetchData from redpoint success,adPostId:", Integer.valueOf(rspEntry.key.get()));
                QZoneUnreadServletLogic.f0(LoginData.getInstance().getUinString(), null);
            }
        } catch (Exception e16) {
            QLog.e("QZoneGalleryEntranceGuideBubbleHelper", 1, "fetchData parseTianshu error", Log.getStackTraceString(e16));
        }
    }

    private boolean t(int i3) {
        if (i3 == 1140) {
            return true;
        }
        return false;
    }

    @Override // com.qzone.business.tianshu.b
    public void a() {
        byte[] m3 = QZoneUnreadServletLogic.m(LoginData.getInstance().getUinString());
        if (m3 != null && m3.length != 0) {
            k(m3);
        } else {
            super.a();
        }
    }

    @Override // com.qzone.business.tianshu.b
    int b() {
        return 1140;
    }

    @Override // com.qzone.business.tianshu.b
    public void f(int i3) {
        String str;
        TianShuAccess.AdItem adItem = this.f44856a;
        if (adItem == null || adItem.argList.get() == null) {
            return;
        }
        List<TianShuAccess.MapEntry> list = this.f44856a.argList.get();
        HashMap hashMap = new HashMap();
        for (TianShuAccess.MapEntry mapEntry : list) {
            String str2 = mapEntry.key.get();
            String str3 = mapEntry.value.get();
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                hashMap.put(str2, str3);
            }
        }
        QZoneBubbleInfo qZoneBubbleInfo = new QZoneBubbleInfo(this.f44856a);
        this.f44870b = qZoneBubbleInfo;
        qZoneBubbleInfo.setId(String.valueOf(this.f44856a.iAdId.get()));
        this.f44870b.setAdItem(this.f44856a);
        this.f44870b.setMaxTimes(com.qzone.album.util.o.a((String) hashMap.get("max"), 1));
        String str4 = (String) hashMap.get("type");
        this.f44870b.setType(str4);
        QZoneBubbleInfo qZoneBubbleInfo2 = this.f44870b;
        if (TextUtils.equals(str4, "lunbo")) {
            str = "lunbo_word";
        } else {
            str = "bubble_word";
        }
        qZoneBubbleInfo2.setWords((String) hashMap.get(str));
        this.f44870b.setIsShowArrow(com.qzone.album.util.o.a((String) hashMap.get("bubble_arrow"), 1) == 1);
        this.f44870b.setStartTime(com.qzone.album.util.o.b((String) hashMap.get("startTime"), 0L));
        this.f44870b.setEndTime(com.qzone.album.util.o.b((String) hashMap.get("endTime"), 0L));
        this.f44870b.setBackgroundUrl((String) hashMap.get("bubble_photo"));
        this.f44870b.setJumpUrl((String) hashMap.get("bubble_target"));
        ArrayList<String> arrayList = new ArrayList<>();
        String str5 = (String) hashMap.get("lunbo_1");
        String str6 = (String) hashMap.get("lunbo_2");
        String str7 = (String) hashMap.get("lunbo_3");
        arrayList.add(str5);
        arrayList.add(str6);
        arrayList.add(str7);
        this.f44870b.setLoopPicList(arrayList);
        this.f44871c.a(this.f44870b);
    }

    public void q() {
        l().r(null);
    }

    public void r(a aVar) {
        this.f44871c = aVar;
    }

    public boolean s(QZoneBubbleInfo qZoneBubbleInfo) {
        return (qZoneBubbleInfo.getStartTime() == 0 && qZoneBubbleInfo.getEndTime() == 0) || (qZoneBubbleInfo.getStartTime() < System.currentTimeMillis() && System.currentTimeMillis() < qZoneBubbleInfo.getEndTime());
    }

    @Override // com.qzone.business.tianshu.b
    List<Integer> c() {
        return Collections.singletonList(1140);
    }

    public void o(QZoneBubbleInfo qZoneBubbleInfo) {
        if (qZoneBubbleInfo != null) {
            u5.b.r0(n(qZoneBubbleInfo.getId()), m(qZoneBubbleInfo) + 1, LoginData.getInstance().getUin());
        }
    }

    public int m(QZoneBubbleInfo qZoneBubbleInfo) {
        if (qZoneBubbleInfo == null) {
            return 0;
        }
        return u5.b.H(n(qZoneBubbleInfo.getId()), 0, LoginData.getInstance().getUin());
    }
}
