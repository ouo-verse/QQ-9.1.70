package com.tencent.mobileqq.onlinestatus;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.onlinestatus.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes16.dex */
public class at {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<Long, w> f255486a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private w f255487b;

    private w a(long j3, w.a aVar, AppInterface appInterface, QBaseActivity qBaseActivity) {
        w wVar;
        if (j3 == 1030) {
            wVar = new wc2.a(j3, aVar, appInterface, qBaseActivity);
        } else if (OnlineStatusToggleUtils.A() && j3 == 2017) {
            wVar = new sc2.b(j3, aVar, appInterface, qBaseActivity);
        } else if (j3 == 1040) {
            wVar = new com.tencent.mobileqq.onlinestatus.view.am(j3, aVar, appInterface, qBaseActivity);
        } else {
            wVar = null;
        }
        if (wVar != null) {
            wVar.j();
            wVar.b(true);
        }
        return wVar;
    }

    public w b(long j3, w.a aVar, AppInterface appInterface, QBaseActivity qBaseActivity) {
        w wVar = this.f255487b;
        if (wVar != null && wVar.f256878g != j3) {
            wVar.i(false, j3);
        }
        w wVar2 = this.f255486a.get(Long.valueOf(j3));
        if (wVar2 != null) {
            wVar2.i(true, j3);
            wVar2.j();
            wVar2.b(false);
            return wVar2;
        }
        w a16 = a(j3, aVar, appInterface, qBaseActivity);
        if (a16 != null) {
            this.f255486a.put(Long.valueOf(j3), a16);
        }
        this.f255487b = a16;
        return a16;
    }

    public void c() {
        Iterator<Map.Entry<Long, w>> it = this.f255486a.entrySet().iterator();
        while (it.hasNext()) {
            w value = it.next().getValue();
            if (value != null) {
                value.h();
            }
        }
        this.f255487b = null;
        this.f255486a.clear();
    }
}
