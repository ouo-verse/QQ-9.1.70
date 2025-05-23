package com.tencent.mobileqq.vasgift.api.impl.service;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftPanelResource;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;
import qh2.h;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQGiftResDownloadModuleImpl implements oh2.a {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<nh2.c> f311433a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f311434b = VasToggle.VAS_QQLINE_GIFT_PRELOAD_CONFIG.onIsEnable(true);

    /* renamed from: c, reason: collision with root package name */
    private boolean f311435c = VasToggle.VAS_GIFT_PRELOAD_SCENE_CONFIG.onIsEnable(true);

    private boolean b0(int i3) {
        JSONObject onGetJson;
        if (!this.f311435c || (onGetJson = VasToggle.VAS_GIFT_PRELOAD_SCENE_CONFIG.onGetJson()) == null) {
            return true;
        }
        try {
            JSONArray jSONArray = onGetJson.getJSONArray("scenes");
            for (int i16 = 0; i16 < jSONArray.length(); i16++) {
                if (jSONArray.getInt(i16) == i3) {
                    return false;
                }
            }
        } catch (Exception unused) {
        }
        return true;
    }

    private void c0(final List<com.tencent.mobileqq.qqgift.data.service.g> list, final boolean z16, final h hVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vasgift.api.impl.service.QQGiftResDownloadModuleImpl.1

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.vasgift.api.impl.service.QQGiftResDownloadModuleImpl$1$a */
            /* loaded from: classes20.dex */
            class a implements qh2.b {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ CountDownLatch f311439d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ AtomicInteger f311440e;

                a(CountDownLatch countDownLatch, AtomicInteger atomicInteger) {
                    this.f311439d = countDownLatch;
                    this.f311440e = atomicInteger;
                }

                @Override // qh2.g
                public void onLoadFail(int i3, int i16, int i17, String str) {
                    h hVar = hVar;
                    if (hVar != null) {
                        hVar.b(false, i3, "errCode:" + i16 + ", httpCode:" + i17 + ", errMsg:" + str);
                    }
                    this.f311439d.countDown();
                }

                @Override // qh2.b
                public void onLoadSuccess(int i3, String str) {
                    h hVar = hVar;
                    if (hVar != null) {
                        hVar.b(true, i3, "path:" + str);
                    }
                    this.f311439d.countDown();
                    this.f311440e.incrementAndGet();
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                QQGiftResDownloadModuleImpl qQGiftResDownloadModuleImpl = QQGiftResDownloadModuleImpl.this;
                List d06 = qQGiftResDownloadModuleImpl.d0(qQGiftResDownloadModuleImpl.f0(), list);
                if (d06 != null && d06.size() != 0) {
                    CountDownLatch countDownLatch = new CountDownLatch(d06.size());
                    AtomicInteger atomicInteger = new AtomicInteger(0);
                    Iterator it = d06.iterator();
                    while (it.hasNext()) {
                        com.tencent.mobileqq.qqgift.updatasystem.b.k().g(((com.tencent.mobileqq.qqgift.data.service.g) it.next()).c(), Long.valueOf(com.tencent.mobileqq.qqgift.updatasystem.c.INSTANCE.b()), z16, QQGiftResDownloadModuleImpl.this.e0(), new a(countDownLatch, atomicInteger));
                    }
                    try {
                        countDownLatch.await(5L, TimeUnit.MINUTES);
                    } catch (InterruptedException unused) {
                        QLog.e("QQGiftResDownloadModuleImpl", 1, "[downloadAnimationResources] ");
                    }
                    h hVar2 = hVar;
                    if (hVar2 != null) {
                        hVar2.a(d06.size(), atomicInteger.get());
                        return;
                    }
                    return;
                }
                h hVar3 = hVar;
                if (hVar3 != null) {
                    hVar3.a(0, 0);
                }
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.tencent.mobileqq.qqgift.data.service.g> d0(int i3, List<com.tencent.mobileqq.qqgift.data.service.g> list) {
        if (i3 == 0) {
            return list;
        }
        if (!b0(i3)) {
            return null;
        }
        if (this.f311434b) {
            JSONObject onGetJson = VasToggle.VAS_QQLINE_GIFT_PRELOAD_CONFIG.onGetJson();
            if (onGetJson == null) {
                return list;
            }
            try {
                JSONArray jSONArray = onGetJson.getJSONObject("preload_gifts").getJSONArray(String.valueOf(i3));
                int i16 = onGetJson.getInt("preload_highlevel_gift");
                ArrayList arrayList = new ArrayList();
                for (com.tencent.mobileqq.qqgift.data.service.g gVar : list) {
                    if (i16 == 1 && (gVar.a() == 2 || gVar.a() == 1)) {
                        if (!arrayList.contains(gVar)) {
                            arrayList.add(gVar);
                        }
                    } else {
                        int i17 = 0;
                        while (true) {
                            if (i17 >= jSONArray.length()) {
                                break;
                            }
                            if (jSONArray.getInt(i17) == gVar.b()) {
                                if (!arrayList.contains(gVar)) {
                                    arrayList.add(gVar);
                                }
                            } else {
                                i17++;
                            }
                        }
                    }
                }
                return arrayList;
            } catch (Exception e16) {
                QLog.e("QQGiftResDownloadModuleImpl", 1, e16, new Object[0]);
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e0() {
        int c16;
        nh2.c g06 = g0();
        if (g06 != null && g06.a() != null && (c16 = g06.a().c()) != 0) {
            return String.valueOf(c16);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f0() {
        nh2.c g06 = g0();
        if (g06 != null && g06.getSDKConfig() != null) {
            return g06.getSDKConfig().f264972a;
        }
        return 0;
    }

    private nh2.c g0() {
        WeakReference<nh2.c> weakReference = this.f311433a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // oh2.a
    public void E(int i3, qh2.b bVar) {
        com.tencent.mobileqq.qqgift.updatasystem.b.k().g(i3, Long.valueOf(com.tencent.mobileqq.qqgift.updatasystem.c.INSTANCE.b()), false, e0(), bVar);
    }

    @Override // nh2.a
    public void N(nh2.c cVar) {
        this.f311433a = new WeakReference<>(cVar);
    }

    @Override // oh2.a
    public void R(int i3, qh2.c cVar) {
        com.tencent.mobileqq.qqgift.updatasystem.b.k().i(i3, e0(), cVar);
    }

    @Override // oh2.a
    public void S(List<com.tencent.mobileqq.qqgift.data.service.g> list, h hVar) {
        c0(list, true, hVar);
    }

    @Override // oh2.a
    public void e(int i3, qh2.f fVar) {
        com.tencent.mobileqq.qqgift.updatasystem.b.k().j(i3, e0(), fVar);
    }

    @Override // oh2.a
    public void f(int i3, qh2.b bVar) {
        com.tencent.mobileqq.qqgift.updatasystem.b.k().g(i3, Long.valueOf(com.tencent.mobileqq.qqgift.updatasystem.c.INSTANCE.b()), true, e0(), bVar);
    }

    @Override // oh2.a
    public void g(int i3, qh2.b bVar) {
        com.tencent.mobileqq.qqgift.updatasystem.b.k().g(i3, 311L, false, e0(), bVar);
    }

    @Override // oh2.a
    public void h(List<com.tencent.mobileqq.qqgift.data.service.g> list, h hVar) {
        c0(list, false, hVar);
    }

    @Override // oh2.a
    public void i(final List<com.tencent.mobileqq.qqgift.data.service.g> list, final h hVar) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vasgift.api.impl.service.QQGiftResDownloadModuleImpl.2

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.vasgift.api.impl.service.QQGiftResDownloadModuleImpl$2$a */
            /* loaded from: classes20.dex */
            class a implements qh2.f {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ CountDownLatch f311444d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ AtomicInteger f311445e;

                a(CountDownLatch countDownLatch, AtomicInteger atomicInteger) {
                    this.f311444d = countDownLatch;
                    this.f311445e = atomicInteger;
                }

                @Override // qh2.f
                public void c(int i3, QQGiftPanelResource qQGiftPanelResource) {
                    h hVar = hVar;
                    if (hVar != null) {
                        hVar.b(true, i3, qQGiftPanelResource.toString());
                    }
                    this.f311444d.countDown();
                    this.f311445e.incrementAndGet();
                }

                @Override // qh2.g
                public void onLoadFail(int i3, int i16, int i17, String str) {
                    h hVar = hVar;
                    if (hVar != null) {
                        hVar.b(false, i3, "errCode:" + i16 + ", httpCode:" + i17 + ", errMsg:" + str);
                    }
                    this.f311444d.countDown();
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                QQGiftResDownloadModuleImpl qQGiftResDownloadModuleImpl = QQGiftResDownloadModuleImpl.this;
                List d06 = qQGiftResDownloadModuleImpl.d0(qQGiftResDownloadModuleImpl.f0(), list);
                if (d06 != null && d06.size() != 0) {
                    CountDownLatch countDownLatch = new CountDownLatch(d06.size());
                    AtomicInteger atomicInteger = new AtomicInteger(0);
                    Iterator it = d06.iterator();
                    while (it.hasNext()) {
                        com.tencent.mobileqq.qqgift.updatasystem.b.k().j(((com.tencent.mobileqq.qqgift.data.service.g) it.next()).c(), QQGiftResDownloadModuleImpl.this.e0(), new a(countDownLatch, atomicInteger));
                    }
                    try {
                        countDownLatch.await(5L, TimeUnit.MINUTES);
                    } catch (InterruptedException unused) {
                        QLog.e("QQGiftResDownloadModuleImpl", 1, "[downloadAnimationResources] ");
                    }
                    h hVar2 = hVar;
                    if (hVar2 != null) {
                        hVar2.a(d06.size(), atomicInteger.get());
                        return;
                    }
                    return;
                }
                h hVar3 = hVar;
                if (hVar3 != null) {
                    hVar3.a(0, 0);
                }
            }
        }, 128, null, false);
    }

    @Override // nh2.a
    public void destroy() {
    }

    @Override // nh2.a
    public void reset() {
    }
}
