package com.tencent.qqmini.minigame.floatview;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes23.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private int f346402b = 0;

    /* renamed from: a, reason: collision with root package name */
    private HashMap<Integer, a> f346401a = new HashMap<>();

    public void a(int i3) {
        QMLog.i("floatBox.GameFloatViewManager", " [addFloatView], type:" + i3 + ",size:" + this.f346401a.size());
        a aVar = this.f346401a.get(Integer.valueOf(i3));
        if (aVar != null) {
            QMLog.i("floatBox.GameFloatViewManager", "remove it first");
            aVar.c();
            aVar = null;
        }
        switch (i3) {
            case 17:
                aVar = new ScreenRecordManager();
                break;
            case 18:
                aVar = new FloatBoxManager();
                break;
            case 19:
                aVar = new TaskNavigationManager();
                break;
        }
        if (aVar != null) {
            this.f346401a.put(Integer.valueOf(i3), aVar);
            aVar.g(this.f346402b);
        }
    }

    public void b(int i3, String str) {
        a d16 = d(i3);
        if (d16 == null) {
            return;
        }
        d16.b(str);
    }

    public void c() {
        HashMap<Integer, a> hashMap = this.f346401a;
        if (hashMap == null) {
            return;
        }
        hashMap.clear();
    }

    public a d(int i3) {
        return this.f346401a.get(Integer.valueOf(i3));
    }

    public void e(String str) {
        Iterator<a> it = this.f346401a.values().iterator();
        while (it.hasNext()) {
            it.next().e(str);
        }
    }

    public void f() {
        QMLog.i("floatBox.GameFloatViewManager", "[onDestroy]");
        HashMap<Integer, a> hashMap = this.f346401a;
        if (hashMap != null && hashMap.size() != 0) {
            Iterator<a> it = this.f346401a.values().iterator();
            while (it.hasNext()) {
                it.next().f();
            }
            c();
        }
    }

    public void g(int i3) {
        QMLog.i("floatBox.GameFloatViewManager", "[onLoadingAdStatusChanged] status:" + i3);
        this.f346402b = i3;
        HashMap<Integer, a> hashMap = this.f346401a;
        if (hashMap != null && hashMap.size() != 0) {
            Iterator<a> it = this.f346401a.values().iterator();
            while (it.hasNext()) {
                it.next().g(i3);
            }
        }
    }

    public void h(Activity activity) {
        HashMap<Integer, a> hashMap = this.f346401a;
        if (hashMap != null && hashMap.size() != 0) {
            Iterator<a> it = this.f346401a.values().iterator();
            while (it.hasNext()) {
                it.next().h(activity);
            }
        }
    }

    public void i(IMiniAppContext iMiniAppContext) {
        QMLog.i("floatBox.GameFloatViewManager", "[setAppContext]");
        HashMap<Integer, a> hashMap = this.f346401a;
        if (hashMap != null && hashMap.size() != 0) {
            Iterator<a> it = this.f346401a.values().iterator();
            while (it.hasNext()) {
                it.next().i(iMiniAppContext);
            }
        }
    }

    public void j(TritonEngine tritonEngine) {
        QMLog.i("floatBox.GameFloatViewManager", "[setEngine]");
        HashMap<Integer, a> hashMap = this.f346401a;
        if (hashMap != null && hashMap.size() != 0) {
            Iterator<a> it = this.f346401a.values().iterator();
            while (it.hasNext()) {
                it.next().j(tritonEngine);
            }
        }
    }

    public void k(ViewGroup viewGroup) {
        QMLog.i("floatBox.GameFloatViewManager", "[setRootView]");
        HashMap<Integer, a> hashMap = this.f346401a;
        if (hashMap != null && hashMap.size() != 0) {
            Iterator<a> it = this.f346401a.values().iterator();
            while (it.hasNext()) {
                it.next().k(viewGroup);
            }
        }
    }

    public void l(MiniAppInfo miniAppInfo) {
        QMLog.i("floatBox.GameFloatViewManager", "[updateMiniAppInfo]");
        HashMap<Integer, a> hashMap = this.f346401a;
        if (hashMap != null && hashMap.size() != 0) {
            Iterator<a> it = this.f346401a.values().iterator();
            while (it.hasNext()) {
                it.next().l(miniAppInfo);
            }
        }
    }
}
