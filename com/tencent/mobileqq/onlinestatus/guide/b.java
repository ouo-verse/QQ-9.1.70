package com.tencent.mobileqq.onlinestatus.guide;

import android.text.TextUtils;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public String f255903c;

    /* renamed from: d, reason: collision with root package name */
    public String f255904d;

    /* renamed from: a, reason: collision with root package name */
    public long f255901a = 0;

    /* renamed from: b, reason: collision with root package name */
    public long f255902b = 0;

    /* renamed from: e, reason: collision with root package name */
    public boolean f255905e = true;

    public static b a(JSONObject jSONObject) {
        String str;
        String str2;
        long j3;
        long j16;
        if (jSONObject == null) {
            return null;
        }
        boolean z16 = true;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("online_status_guide");
            if (optJSONObject != null) {
                j3 = optJSONObject.optLong(ProfileCardDtReportUtil.STATUS_ID);
                try {
                    j16 = optJSONObject.optLong("duration");
                    try {
                        str = optJSONObject.optString("title");
                        try {
                            str2 = optJSONObject.optString("icon");
                            try {
                                z16 = optJSONObject.optBoolean("showInStudyMode", true);
                            } catch (Exception e16) {
                                e = e16;
                                QLog.i("StatusGuideInfo", 1, "parse", e);
                                if (j3 > 0) {
                                }
                                return null;
                            }
                        } catch (Exception e17) {
                            e = e17;
                            str2 = null;
                        }
                    } catch (Exception e18) {
                        e = e18;
                        str = null;
                        str2 = null;
                    }
                } catch (Exception e19) {
                    e = e19;
                    str = null;
                    str2 = null;
                    j16 = 0;
                }
            } else {
                str = null;
                str2 = null;
                j3 = 0;
                j16 = 0;
            }
        } catch (Exception e26) {
            e = e26;
            str = null;
            str2 = null;
            j3 = 0;
            j16 = 0;
        }
        if (j3 > 0 || j16 <= 0 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        b bVar = new b();
        bVar.f255901a = j3;
        bVar.f255902b = j16;
        bVar.f255903c = str;
        bVar.f255904d = str2;
        bVar.f255905e = z16;
        return bVar;
    }
}
