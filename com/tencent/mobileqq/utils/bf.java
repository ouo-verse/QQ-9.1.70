package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bf extends l {

    /* renamed from: f, reason: collision with root package name */
    private static volatile bf f307485f;

    /* renamed from: d, reason: collision with root package name */
    private List<Pair<String, String>> f307487d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private boolean f307488e = false;

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f307486c = BaseApplication.getContext().getSharedPreferences("qq_safe_jump_whitelist", 0);

    static {
        l.f307808a = BaseApplication.getContext().getFilesDir().getAbsoluteFile() + File.separator + "jumpConfig/";
        StringBuilder sb5 = new StringBuilder();
        sb5.append(l.f307808a);
        sb5.append("qq_safe_jump_whitelist.xml");
        l.f307809b = sb5.toString();
    }

    bf() {
    }

    public static bf h() {
        if (f307485f == null) {
            synchronized (bf.class) {
                if (f307485f == null) {
                    f307485f = new bf();
                }
            }
        }
        return f307485f;
    }

    private void j(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("JumpFilterHelper", 2, "reportIllegalJump pkg=" + str + ";cmp=" + str2);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(str, str2);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "JumpIllegal", true, 0L, 0L, hashMap, null);
    }

    @Override // com.tencent.mobileqq.utils.l
    protected Object a(XmlPullParser xmlPullParser) throws Exception {
        if (xmlPullParser == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2 && xmlPullParser.getName().equalsIgnoreCase("Item")) {
                String attributeValue = xmlPullParser.getAttributeValue(null, "pkg");
                String attributeValue2 = xmlPullParser.getAttributeValue(null, "cmp");
                if (attributeValue != null && attributeValue2 != null) {
                    arrayList.add(new Pair(attributeValue, attributeValue2));
                }
                if (QLog.isColorLevel()) {
                    QLog.d("JumpFilterHelper", 2, "doParseRules pkg=" + attributeValue + ";cmp=" + attributeValue2);
                }
            }
            eventType = xmlPullParser.next();
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (QLog.isColorLevel()) {
            QLog.d("JumpFilterHelper", 2, "doParseRules :  cost time:" + currentTimeMillis2 + "ms;size=" + arrayList.size());
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.utils.l
    protected int b() {
        return R.xml.f174407k;
    }

    @Override // com.tencent.mobileqq.utils.l
    protected void f(Object obj) {
        this.f307487d = (List) obj;
        this.f307488e = true;
    }

    public long g() {
        long j3 = this.f307486c.getLong("key_jump_whitelist_version", 0L);
        if (QLog.isColorLevel()) {
            QLog.d("JumpFilterHelper", 2, "getConfigVersion version=" + j3);
        }
        return j3;
    }

    public boolean i(Context context, String str, String str2) {
        Pair pair = new Pair(str, str2);
        if (!this.f307488e) {
            synchronized (f307485f) {
                if (!this.f307488e) {
                    c(context);
                }
            }
        }
        if (!this.f307487d.contains(pair)) {
            j(str, str2);
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("JumpFilterHelper", 2, "isIllegalJump pkg=" + str + ";cmp=" + str2);
            return false;
        }
        return false;
    }
}
