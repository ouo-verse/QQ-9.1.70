package ck;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.reborn.route.QZoneSchemeBean;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import dk.e;
import dk.f;
import dk.g;
import dk.h;
import dk.i;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d extends ho.b {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, b> f31010a;

    static {
        HashMap hashMap = new HashMap();
        f31010a = hashMap;
        hashMap.put("openspacepage", new e());
        hashMap.put("albumlistpage", new dk.b());
        hashMap.put("detail", new dk.c());
        hashMap.put("writemood", new i());
        hashMap.put("uploadphoto", new h());
        hashMap.put("albumdetail", new dk.a());
        hashMap.put("queryopenspacepage", new g());
        hashMap.put("managepage", new f());
        hashMap.put("lovetree", new dk.d());
    }

    @Override // ho.b
    public boolean a(Context context, QZoneSchemeBean qZoneSchemeBean) {
        if (TextUtils.isEmpty(qZoneSchemeBean.getPageAction())) {
            QLog.e("QZoneIntimateSpaceSchemeLauncher", 1, "parseScheme  scheme pageAction == null");
            return false;
        }
        b bVar = f31010a.get(qZoneSchemeBean.getPageAction());
        if (bVar != null) {
            bVar.e(context, qZoneSchemeBean);
            QZoneLoginReportHelper.reportLoginFromIntimateSpace();
            return true;
        }
        QLog.e("QZoneIntimateSpaceSchemeLauncher", 1, "parseScheme  scheme pageAction = " + qZoneSchemeBean.getPageAction() + " , not find parser in sSchemeParserMap, please register map");
        return false;
    }
}
