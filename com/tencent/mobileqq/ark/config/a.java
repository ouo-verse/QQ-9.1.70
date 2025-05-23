package com.tencent.mobileqq.ark.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes11.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private String f199249a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<c> f199250b;

    public a(String str) {
        this.f199249a = str;
        this.f199250b = b(str);
    }

    public Object a(Map<String, Object> map) {
        if (map == null || this.f199250b.size() == 0) {
            return null;
        }
        Iterator<c> it = this.f199250b.iterator();
        Object obj = map;
        while (it.hasNext()) {
            obj = it.next().a(obj);
        }
        return obj;
    }

    public ArrayList<c> b(String str) {
        ArrayList<String> c16 = c(str);
        if (c16 == null || c16.size() == 0 || !c16.get(0).equals("$")) {
            return null;
        }
        ArrayList<c> arrayList = new ArrayList<>();
        for (int i3 = 1; i3 < c16.size(); i3++) {
            try {
                String str2 = c16.get(i3);
                if (TextUtils.isEmpty(str2)) {
                    return null;
                }
                if (str2.charAt(0) == '.') {
                    arrayList.add(new d(str2.substring(1)));
                } else {
                    String c17 = e.a().c(str2);
                    if (!TextUtils.isEmpty(c17)) {
                        arrayList.add(new d(c17));
                    } else {
                        String b16 = e.a().b(str2);
                        if (TextUtils.isEmpty(b16)) {
                            return null;
                        }
                        arrayList.add(new b(Integer.parseInt(b16)));
                    }
                }
            } catch (Exception e16) {
                QLog.e(ArkMsgReplyConfigMgr.TAG, 1, "parsePattern error:" + e16.getMessage());
            }
        }
        return arrayList;
    }

    public ArrayList<String> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder sb5 = new StringBuilder();
        boolean z16 = false;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (!z16) {
                if (charAt == '.' || charAt == '[') {
                    if (sb5.length() == 0) {
                        return null;
                    }
                    arrayList.add(sb5.toString());
                    sb5 = new StringBuilder();
                    if (charAt == '[') {
                        z16 = true;
                    }
                    z16 = false;
                }
            } else {
                if (charAt != ']') {
                }
                z16 = false;
            }
            sb5.append(charAt);
        }
        if (sb5.length() == 0) {
            return null;
        }
        arrayList.add(sb5.toString());
        return arrayList;
    }
}
