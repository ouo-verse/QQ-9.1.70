package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class af implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    public jc2.b f202496d = new jc2.b(new ArrayList(), "", new HashMap());

    public static af c(String str) {
        af afVar = new af();
        try {
            afVar.f202496d = jc2.a.a(str);
            QLog.d("OnlineAutoStatusConfProcessor", 1, "confBean = " + afVar.toString());
            return afVar;
        } catch (Exception e16) {
            QLog.e("OnlineAutoStatusConfProcessor", 1, "parse e:", e16.toString());
            return afVar;
        }
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f202496d.f409783c.get(str);
    }

    public jc2.c b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (jc2.c cVar : this.f202496d.f409782b) {
            if (str.equals(cVar.f409784a)) {
                return cVar;
            }
        }
        return null;
    }
}
