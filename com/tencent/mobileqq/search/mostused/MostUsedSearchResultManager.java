package com.tencent.mobileqq.search.mostused;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.search.mostused.a;
import com.tencent.mobileqq.search.util.m;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MostUsedSearchResultManager implements Manager {

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f283556d;

    /* renamed from: e, reason: collision with root package name */
    private a f283557e = new a("Cahce_");

    public MostUsedSearchResultManager(QQAppInterface qQAppInterface) {
        this.f283556d = qQAppInterface;
    }

    public void c(String str, String str2, String str3, int i3) {
        String str4;
        if (str != null && !TextUtils.isEmpty(str)) {
            if (str2 != null && !TextUtils.isEmpty(str2)) {
                str4 = str2;
            } else {
                str2 = "";
                str4 = str;
            }
            QLog.d("MostUsedSearchResultManager", 2, "UpdateItemUsed : key= " + str + " mostusedKey= " + str2);
            int a16 = m.a(i3);
            if (!d(a16)) {
                return;
            }
            final MostUsedSearchItem mostUsedSearchItem = new MostUsedSearchItem(str4, NetConnInfoCenter.getServerTimeMillis(), str3, i3, a16);
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.search.mostused.MostUsedSearchResultManager.1
                @Override // java.lang.Runnable
                public void run() {
                    if (MostUsedSearchResultManager.this.f283557e != null) {
                        MostUsedSearchResultManager.this.f283557e.a(MostUsedSearchResultManager.this.f283556d, mostUsedSearchItem);
                        MostUsedSearchResultManager.this.f283557e.g(MostUsedSearchResultManager.this.f283556d);
                    } else {
                        QLog.e("MostUsedSearchResultManager", 2, "UpdateItemUsed NULL cache");
                    }
                }
            });
        }
    }

    boolean d(int i3) {
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            return true;
        }
        return false;
    }

    public void e() {
        a aVar = this.f283557e;
        if (aVar != null) {
            aVar.e(this.f283556d);
            QLog.d("MostUsedSearchResultManager", 2, "init");
        } else {
            QLog.e("MostUsedSearchResultManager", 2, "init with null cache ");
        }
    }

    public ArrayList<a.c> f(String str) {
        a aVar = this.f283557e;
        if (aVar != null) {
            ArrayList<a.c> f16 = aVar.f(this.f283556d, str);
            if (f16 != null && f16.size() > 10) {
                ArrayList<a.c> arrayList = new ArrayList<>(f16.subList(0, 10));
                QLog.i("MostUsedSearchResultManager", 2, "tmpResult subList 10 ,orglist is " + f16.size());
                return arrayList;
            }
            return f16;
        }
        QLog.e("MostUsedSearchResultManager", 2, "Match with null cache");
        return null;
    }

    public void g() {
        a aVar = this.f283557e;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        g();
        this.f283557e = null;
        QLog.d("MostUsedSearchResultManager", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }
}
