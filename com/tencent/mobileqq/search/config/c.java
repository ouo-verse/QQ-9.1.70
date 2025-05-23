package com.tencent.mobileqq.search.config;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.config.ai;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<a> f283113d;

    /* renamed from: e, reason: collision with root package name */
    boolean f283114e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int[] f283115a;

        /* renamed from: b, reason: collision with root package name */
        int[] f283116b;

        /* renamed from: c, reason: collision with root package name */
        List<cp2.b> f283117c;

        public a(int[] iArr, int[] iArr2, List<cp2.b> list) {
            this.f283115a = a(iArr);
            this.f283116b = a(iArr2);
            this.f283117c = list;
        }

        private int[] a(int[] iArr) {
            if (iArr != null) {
                Arrays.sort(iArr);
            }
            return iArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (Arrays.equals(this.f283115a, aVar.f283115a) && Arrays.equals(this.f283116b, aVar.f283116b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f283115a) * 31) + Arrays.hashCode(this.f283116b);
        }
    }

    private static void a(c cVar, String str) {
        ArrayList arrayList;
        try {
            ArrayList<a> arrayList2 = new ArrayList<>();
            JSONArray jSONArray = new JSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null && b(f(optJSONObject.optJSONArray("os")))) {
                    int[] f16 = f(optJSONObject.optJSONArray("scene"));
                    int[] f17 = f(optJSONObject.optJSONArray("mode"));
                    JSONArray optJSONArray = optJSONObject.optJSONArray("op");
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        arrayList = new ArrayList(optJSONArray.length());
                        for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                            e(optJSONArray.optJSONObject(i16), arrayList);
                        }
                    } else {
                        arrayList = null;
                    }
                    if (arrayList != null && !arrayList.isEmpty()) {
                        arrayList2.add(new a(f16, f17, arrayList));
                    }
                }
            }
            cVar.f283113d = arrayList2;
            cVar.f283114e = true;
            QLog.d("search_manager_configTnnGroupSearchResultConfigBean", 1, "parse success: list size = " + arrayList2.size());
        } catch (JSONException unused) {
            QLog.e("search_manager_configTnnGroupSearchResultConfigBean", 1, "parse json error");
        }
    }

    private static boolean b(int[] iArr) {
        if (iArr == null) {
            return true;
        }
        for (int i3 : iArr) {
            if (i3 == 1) {
                return true;
            }
        }
        return false;
    }

    public static c c(String str) {
        c cVar = new c();
        a(cVar, str);
        return cVar;
    }

    public static c d(ai[] aiVarArr) {
        String str;
        c cVar = new c();
        if (aiVarArr != null && aiVarArr.length > 0) {
            str = aiVarArr[0].f202268b;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return cVar;
        }
        if (QLog.isColorLevel()) {
            QLog.d("search_manager_configTnnGroupSearchResultConfigBean", 2, "parse conf=" + str);
        }
        a(cVar, str);
        return cVar;
    }

    private static void e(@Nullable JSONObject jSONObject, @NonNull ArrayList<cp2.b> arrayList) {
        if (jSONObject == null) {
            return;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            Object opt = jSONObject.opt(str);
            if (opt != null) {
                cp2.c.a(arrayList, str, opt);
                return;
            }
        }
    }

    @Nullable
    private static int[] f(JSONArray jSONArray) {
        if (jSONArray != null) {
            int[] iArr = new int[jSONArray.length()];
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                iArr[i3] = jSONArray.optInt(i3);
            }
            return iArr;
        }
        return null;
    }
}
