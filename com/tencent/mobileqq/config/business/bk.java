package com.tencent.mobileqq.config.business;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import cooperation.qzone.util.QZoneImageUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class bk {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, String> f202617a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private HashMap<String, ArrayList<String>> f202618b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private List<String> f202619c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private boolean f202620d = false;

    /* renamed from: e, reason: collision with root package name */
    private float f202621e = 5.0E-4f;

    public static bk c(String str) {
        boolean z16;
        bk bkVar = new bk();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("disallow");
            if (optJSONArray != null) {
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                    String str2 = "" + i3;
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray(QZoneImageUtils.KEY_MATCH);
                    if (optJSONArray2 != null) {
                        for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                            bkVar.f202617a.put(optJSONArray2.optString(i16), str2);
                        }
                    }
                    JSONArray optJSONArray3 = jSONObject2.optJSONArray(DTConstants.TAG.API);
                    if (optJSONArray3 != null) {
                        ArrayList<String> arrayList = new ArrayList<>(optJSONArray3.length());
                        for (int i17 = 0; i17 < optJSONArray3.length(); i17++) {
                            arrayList.add(optJSONArray3.optString(i17));
                        }
                        bkVar.f202618b.put(str2, arrayList);
                    }
                }
            }
            if (1 == jSONObject.optInt("forbidIframeRiskCall", 0)) {
                z16 = true;
            } else {
                z16 = false;
            }
            bkVar.f202620d = z16;
            bkVar.f202621e = (float) jSONObject.optDouble("iframeCallReportRate", 5.000000237487257E-4d);
            JSONArray optJSONArray4 = jSONObject.optJSONArray("risk");
            if (optJSONArray4 != null) {
                for (int i18 = 0; i18 < optJSONArray4.length(); i18++) {
                    String optString = optJSONArray4.optString(i18);
                    if (!TextUtils.isEmpty(optString)) {
                        bkVar.f202619c.add(optString);
                    }
                }
            }
            QLog.d("WVBlacklistConfProcessor", 2, "confBean = " + bkVar.toString());
            return bkVar;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("WVBlacklistConfProcessor", 1, "parse e:", e16.toString());
            }
            return bkVar;
        }
    }

    public boolean a(String str, String str2) {
        if (str == null) {
            QLog.w("WVBlacklistConfProcessor", 1, "url is null");
            return false;
        }
        String host = Uri.parse(str).getHost();
        if (!this.f202617a.containsKey(host)) {
            return false;
        }
        ArrayList<String> arrayList = this.f202618b.get(this.f202617a.get(host));
        if (arrayList != null) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                if (str2.equals(it.next())) {
                    QLog.d("WVBlacklistConfProcessor", 1, "hit black domain");
                    return true;
                }
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("WVBlacklistConfProcessor", 1, "not in black");
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:
    
        if (r3.f202619c.contains(r4) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair<Boolean, String> b(String str, boolean z16) {
        if (z16) {
            for (String str2 : this.f202619c) {
                if (str.startsWith(str2)) {
                    str = str2;
                    break;
                }
            }
            str = null;
        }
        return new Pair<>(Boolean.valueOf(this.f202620d), str);
    }

    public boolean d() {
        if (Math.random() < this.f202621e) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(100);
        sb5.append(this.f202618b.toString());
        sb5.append(",");
        sb5.append("forbidIframeRiskCall:");
        sb5.append(this.f202620d);
        sb5.append(",");
        sb5.append("iframeCallReportRate:");
        sb5.append(this.f202621e);
        sb5.append(",");
        sb5.append("riskMethods:");
        sb5.append(Arrays.toString(this.f202619c.toArray()));
        return sb5.toString();
    }
}
