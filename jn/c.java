package jn;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kn.d;
import kn.e;
import rn.g;

/* compiled from: P */
/* loaded from: classes38.dex */
public class c extends ho.b {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, a> f410637a;

    static {
        HashMap hashMap = new HashMap();
        f410637a = hashMap;
        hashMap.put("feedlist", new kn.c());
        hashMap.put("publish", new e());
        hashMap.put("message", new d());
        hashMap.put("feeddetail", new kn.a());
        hashMap.put("feedhistory", new kn.b());
    }

    @Override // ho.b
    public boolean a(Context context, QZoneSchemeBean qZoneSchemeBean) {
        if (!g.d()) {
            QLog.e("QZMSchemaLauncher", 1, "parseScheme moment switch is closed,direct return!");
            return false;
        }
        if (TextUtils.isEmpty(qZoneSchemeBean.getPageAction())) {
            QLog.e("QZMSchemaLauncher", 1, "parseScheme  scheme pageAction == null");
            return false;
        }
        a aVar = f410637a.get(qZoneSchemeBean.getPageAction());
        if (aVar != null) {
            aVar.a(context, qZoneSchemeBean);
            return true;
        }
        QLog.e("QZMSchemaLauncher", 1, "parseScheme  scheme pageAction = " + qZoneSchemeBean.getPageAction() + " , not find parser in sSchemeParserMap, please register map");
        return false;
    }
}
