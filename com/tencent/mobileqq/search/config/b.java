package com.tencent.mobileqq.search.config;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.config.ai;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList<a> f283109a;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int[] f283110a;

        /* renamed from: b, reason: collision with root package name */
        int[] f283111b;

        /* renamed from: c, reason: collision with root package name */
        int[] f283112c;

        public a(int[] iArr, int[] iArr2, int[] iArr3) {
            this.f283110a = c(iArr);
            this.f283111b = c(iArr2);
            this.f283112c = iArr3;
        }

        private boolean a(int[] iArr, int i3) {
            if (iArr == null || Arrays.binarySearch(iArr, i3) > -1) {
                return true;
            }
            return false;
        }

        private int[] c(int[] iArr) {
            if (iArr != null) {
                Arrays.sort(iArr);
            }
            return iArr;
        }

        boolean b(int i3, int i16) {
            if (a(this.f283110a, i3) && a(this.f283111b, i16)) {
                return true;
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (Arrays.equals(this.f283110a, aVar.f283110a) && Arrays.equals(this.f283111b, aVar.f283111b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.f283110a) * 31) + Arrays.hashCode(this.f283111b);
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

    public static b c(ai[] aiVarArr) {
        String str;
        b bVar = new b();
        if (aiVarArr != null && aiVarArr.length > 0) {
            str = aiVarArr[0].f202268b;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SearchEntrySortConfigBean", 2, "parse conf=" + str);
        }
        try {
            ArrayList<a> arrayList = new ArrayList<>();
            JSONArray jSONArray = new JSONArray(str);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject != null && b(d(optJSONObject.optJSONArray("os")))) {
                    int[] d16 = d(optJSONObject.optJSONArray("scene"));
                    int[] d17 = d(optJSONObject.optJSONArray("mode"));
                    int[] d18 = d(optJSONObject.optJSONArray("sort"));
                    if (d18 != null && d18.length != 0) {
                        arrayList.add(new a(d16, d17, d18));
                    }
                }
            }
            bVar.f283109a = arrayList;
            QLog.d("SearchEntrySortConfigBean", 1, "parse success: list size = " + arrayList.size());
        } catch (JSONException unused) {
            QLog.e("SearchEntrySortConfigBean", 1, "parse json error");
        }
        return bVar;
    }

    @Nullable
    private static int[] d(JSONArray jSONArray) {
        if (jSONArray != null) {
            int[] iArr = new int[jSONArray.length()];
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                iArr[i3] = jSONArray.optInt(i3);
            }
            return iArr;
        }
        return null;
    }

    @Nullable
    public int[] a(int i3, int i16) {
        ArrayList<a> arrayList = this.f283109a;
        if (arrayList == null) {
            return null;
        }
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.b(i3, i16)) {
                return next.f283112c;
            }
        }
        return null;
    }
}
