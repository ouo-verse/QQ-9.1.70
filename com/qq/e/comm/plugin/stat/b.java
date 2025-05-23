package com.qq.e.comm.plugin.stat;

import android.text.TextUtils;
import com.qq.e.comm.plugin.k.y;
import com.tencent.ams.dynamicwidget.report.LinkReportConstant$BizKey;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f39703a;

    public b(Map map) {
        this.f39703a = y.a(map);
    }

    public b a(String str) {
        try {
            this.f39703a.putOpt("pid", str);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return this;
    }

    public b b(String str) {
        try {
            this.f39703a.putOpt("aid", str);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return this;
    }

    public b c(String str) {
        try {
            this.f39703a.putOpt("traceid", str);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return this;
    }

    public b d(int i3) {
        try {
            this.f39703a.putOpt("inner_adshowtype", Integer.valueOf(i3));
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return this;
    }

    public b e(int i3) {
        try {
            this.f39703a.putOpt("act_code", Integer.valueOf(i3));
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return this;
    }

    public b f(int i3) {
        try {
            this.f39703a.putOpt(LinkReportConstant$BizKey.CLICK_ACTION_TYPE, Integer.valueOf(i3));
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return this;
    }

    public b(JSONObject jSONObject) {
        this.f39703a = jSONObject;
    }

    public b a(int i3) {
        try {
            this.f39703a.putOpt("ad_first_category", Integer.valueOf(i3));
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return this;
    }

    public b b(int i3) {
        try {
            this.f39703a.putOpt("advertiser_id", Integer.valueOf(i3));
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return this;
    }

    public b c(int i3) {
        try {
            this.f39703a.putOpt("producttype", Integer.valueOf(i3));
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return this;
    }

    public b d(String str) {
        try {
            String optString = this.f39703a.optString("adstyle");
            if (TextUtils.isEmpty(optString)) {
                this.f39703a.putOpt("adstyle", str);
            } else {
                this.f39703a.putOpt("adstyle", optString + "," + str);
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return this;
    }

    public b() {
        this(y.a());
    }

    public b a(long j3) {
        try {
            this.f39703a.putOpt("cost_time", Long.valueOf(j3));
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return this;
    }

    public b a(JSONObject jSONObject) {
        if (!y.a(jSONObject)) {
            return this;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String str = (String) keys.next();
                this.f39703a.putOpt(str, jSONObject.opt(str));
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        return this;
    }

    public b a(String str, String str2) {
        try {
            this.f39703a.putOpt(str, str2);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return this;
    }

    public b a(String str, long j3) {
        try {
            this.f39703a.putOpt(str, Long.valueOf(j3));
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return this;
    }

    public b a(String str, int i3) {
        try {
            this.f39703a.putOpt(str, Integer.valueOf(i3));
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return this;
    }

    public b a(String str, double d16) {
        try {
            this.f39703a.putOpt(str, Double.valueOf(d16));
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        return this;
    }

    public JSONObject a() {
        if (this.f39703a.length() > 0) {
            return this.f39703a;
        }
        return null;
    }
}
