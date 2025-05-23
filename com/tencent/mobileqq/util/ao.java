package com.tencent.mobileqq.util;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.richstatus.StatusManager;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ao {

    /* renamed from: a, reason: collision with root package name */
    QQAppInterface f306579a;

    /* renamed from: b, reason: collision with root package name */
    StatusManager f306580b;

    public ao(QQAppInterface qQAppInterface) {
        this.f306579a = qQAppInterface;
    }

    public Bundle a(Bundle bundle) {
        String[] split;
        com.tencent.mobileqq.richstatus.a J;
        String str;
        ArrayList<String> stringArrayList = bundle.getStringArrayList("key");
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("key", stringArrayList);
        if (stringArrayList != null && stringArrayList.size() != 0) {
            if (this.f306580b == null) {
                this.f306580b = (StatusManager) this.f306579a.getManager(QQManagerFactory.STATUS_MANAGER);
            }
            if (this.f306580b == null) {
                return bundle2;
            }
            ArrayList<String> arrayList = new ArrayList<>(stringArrayList.size());
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    split = null;
                } else {
                    split = next.split("_s_");
                }
                String str2 = "";
                if (split != null && split.length == 3) {
                    try {
                        int parseInt = Integer.parseInt(split[0]);
                        String str3 = split[1];
                        int parseInt2 = Integer.parseInt(split[2]);
                        if (parseInt == 1 && (J = this.f306580b.J(Integer.parseInt(str3))) != null) {
                            if (parseInt2 == 201) {
                                str = J.f282296c;
                            } else {
                                str = J.f282297d;
                            }
                            str2 = str;
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
                com.tencent.mobileqq.nearby.l.c("getIconUrl", "getIconUrl", next, str2);
                arrayList.add(str2);
            }
            bundle2.putStringArrayList("path", arrayList);
        }
        return bundle2;
    }
}
