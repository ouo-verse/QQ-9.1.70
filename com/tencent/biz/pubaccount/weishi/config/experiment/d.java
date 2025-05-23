package com.tencent.biz.pubaccount.weishi.config.experiment;

import UserGrowth.stGetAllABTestPolicyRsp;
import UserGrowth.stGrayPolicyInfo;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.pubaccount.weishi.util.s;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import mqq.util.LogUtil;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private String f80650a;

    /* renamed from: b, reason: collision with root package name */
    private String f80651b;

    /* renamed from: c, reason: collision with root package name */
    private String f80652c;

    /* renamed from: d, reason: collision with root package name */
    private stGetAllABTestPolicyRsp f80653d;

    public d(String str, stGetAllABTestPolicyRsp stgetallabtestpolicyrsp) {
        this.f80650a = str;
        this.f80653d = stgetallabtestpolicyrsp;
        this.f80651b = f(stgetallabtestpolicyrsp.policyInfo);
        this.f80652c = a(this.f80653d);
    }

    public String b() {
        return this.f80652c;
    }

    public stGrayPolicyInfo c(String str) {
        Map<String, stGrayPolicyInfo> map = this.f80653d.policyInfo;
        if (map == null || map.isEmpty()) {
            return null;
        }
        return this.f80653d.policyInfo.get(str);
    }

    public stGetAllABTestPolicyRsp d() {
        return this.f80653d;
    }

    public String e() {
        return this.f80651b;
    }

    public String g() {
        return this.f80650a;
    }

    public String toString() {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("WSExpPolicyEntities{\nmUin='");
        sb5.append(LogUtil.getSafePrintUin(this.f80650a));
        sb5.append('\'');
        sb5.append("\nmTestIds='");
        sb5.append(this.f80651b);
        sb5.append('\'');
        sb5.append("\nserverTime='");
        sb5.append(this.f80653d.serverTime);
        sb5.append('\'');
        sb5.append("\nmPolicyInfoMap=");
        Map<String, stGrayPolicyInfo> map = this.f80653d.policyInfo;
        if (map != null) {
            str = map.toString();
        } else {
            str = "null";
        }
        sb5.append(str);
        sb5.append('}');
        return sb5.toString();
    }

    private String a(stGetAllABTestPolicyRsp stgetallabtestpolicyrsp) {
        if (stgetallabtestpolicyrsp == null) {
            return "";
        }
        return Base64.encodeToString(s.b(stgetallabtestpolicyrsp), 0);
    }

    private String f(Map<String, stGrayPolicyInfo> map) {
        if (map != null && !map.isEmpty()) {
            HashSet hashSet = new HashSet();
            StringBuilder sb5 = new StringBuilder();
            Iterator<Map.Entry<String, stGrayPolicyInfo>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                String str = it.next().getValue().grayPolicyId;
                if (!TextUtils.isEmpty(str) && !hashSet.contains(str)) {
                    hashSet.add(str);
                    sb5.append(str);
                    sb5.append("_");
                }
            }
            if (sb5.length() > 0) {
                sb5.deleteCharAt(sb5.length() - 1);
            }
            return sb5.toString();
        }
        return "";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (!TextUtils.equals(dVar.g(), g())) {
            return false;
        }
        stGetAllABTestPolicyRsp stgetallabtestpolicyrsp = dVar.f80653d;
        stGetAllABTestPolicyRsp stgetallabtestpolicyrsp2 = this.f80653d;
        if (stgetallabtestpolicyrsp == null || stgetallabtestpolicyrsp2 == null) {
            return stgetallabtestpolicyrsp == stgetallabtestpolicyrsp2;
        }
        Map<String, stGrayPolicyInfo> map = stgetallabtestpolicyrsp.policyInfo;
        Map<String, stGrayPolicyInfo> map2 = stgetallabtestpolicyrsp2.policyInfo;
        if (map == null) {
            return map2 == null;
        }
        return map.equals(map2);
    }
}
