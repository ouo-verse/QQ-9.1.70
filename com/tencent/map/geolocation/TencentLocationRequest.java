package com.tencent.map.geolocation;

import android.os.Bundle;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class TencentLocationRequest {
    public static final int REQUEST_LEVEL_ADMIN_AREA = 3;
    public static final int REQUEST_LEVEL_FORMATTED_ADDRESS = 5;
    public static final int REQUEST_LEVEL_GEO = 0;
    public static final int REQUEST_LEVEL_GLOBAL_ADMIN_AREA = 7;
    public static final int REQUEST_LEVEL_NAME = 1;
    public static final int REQUEST_LEVEL_POI = 4;

    /* renamed from: a, reason: collision with root package name */
    public long f147572a;

    /* renamed from: b, reason: collision with root package name */
    public long f147573b;

    /* renamed from: c, reason: collision with root package name */
    public int f147574c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f147575d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f147576e;

    /* renamed from: f, reason: collision with root package name */
    public int f147577f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f147578g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f147579h;

    /* renamed from: i, reason: collision with root package name */
    public String f147580i;

    /* renamed from: j, reason: collision with root package name */
    public Bundle f147581j;

    public TencentLocationRequest() {
    }

    public static void copy(TencentLocationRequest tencentLocationRequest, TencentLocationRequest tencentLocationRequest2) {
        tencentLocationRequest.f147572a = tencentLocationRequest2.f147572a;
        tencentLocationRequest.f147574c = tencentLocationRequest2.f147574c;
        tencentLocationRequest.f147575d = tencentLocationRequest2.f147575d;
        tencentLocationRequest.f147576e = tencentLocationRequest2.f147576e;
        tencentLocationRequest.f147577f = tencentLocationRequest2.f147577f;
        tencentLocationRequest.f147580i = tencentLocationRequest2.f147580i;
        tencentLocationRequest.f147573b = tencentLocationRequest2.f147573b;
        tencentLocationRequest.f147578g = tencentLocationRequest2.f147578g;
        tencentLocationRequest.f147579h = tencentLocationRequest2.f147579h;
        tencentLocationRequest.f147581j.clear();
        tencentLocationRequest.f147581j.putAll(tencentLocationRequest2.f147581j);
    }

    public static TencentLocationRequest create() {
        TencentLocationRequest tencentLocationRequest = new TencentLocationRequest();
        tencentLocationRequest.f147572a = 10000L;
        tencentLocationRequest.f147574c = 1;
        tencentLocationRequest.f147575d = true;
        tencentLocationRequest.f147579h = true;
        tencentLocationRequest.f147576e = false;
        tencentLocationRequest.f147577f = Integer.MAX_VALUE;
        tencentLocationRequest.f147573b = -1L;
        tencentLocationRequest.f147578g = false;
        tencentLocationRequest.f147580i = "";
        tencentLocationRequest.f147581j = new Bundle();
        return tencentLocationRequest;
    }

    public long getCheckInterval() {
        return this.f147573b;
    }

    public Bundle getExtras() {
        return this.f147581j;
    }

    public long getInterval() {
        return this.f147572a;
    }

    public String getPhoneNumber() {
        String string = this.f147581j.getString(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER);
        if (string == null) {
            return "";
        }
        return string;
    }

    public String getQQ() {
        return this.f147580i;
    }

    public int getRequestLevel() {
        return this.f147574c;
    }

    public boolean isAllowCache() {
        return this.f147575d;
    }

    public boolean isAllowDirection() {
        return this.f147576e;
    }

    public boolean isAllowGPS() {
        return this.f147579h;
    }

    public boolean isAllowPedometer() {
        return this.f147578g;
    }

    public TencentLocationRequest setAllowCache(boolean z16) {
        this.f147575d = z16;
        return this;
    }

    public TencentLocationRequest setAllowDirection(boolean z16) {
        this.f147576e = z16;
        return this;
    }

    public TencentLocationRequest setAllowGPS(boolean z16) {
        this.f147579h = z16;
        return this;
    }

    public TencentLocationRequest setAllowPedometer(boolean z16) {
        this.f147578g = z16;
        return this;
    }

    public TencentLocationRequest setCheckInterval(long j3) {
        if (j3 >= 30000) {
            this.f147573b = j3;
            return this;
        }
        throw new IllegalArgumentException("interval should >= 30*1000");
    }

    public TencentLocationRequest setInterval(long j3) {
        if (j3 >= 0) {
            this.f147572a = j3;
            return this;
        }
        throw new IllegalArgumentException("interval should >= 0");
    }

    public TencentLocationRequest setPhoneNumber(String str) {
        if (str == null) {
            str = "";
        }
        this.f147581j.putString(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER, str);
        return this;
    }

    public TencentLocationRequest setQQ(String str) {
        this.f147580i = str;
        return this;
    }

    public TencentLocationRequest setRequestLevel(int i3) {
        if (TencentExtraKeys.isAllowedLevel(i3)) {
            this.f147574c = i3;
            return this;
        }
        throw new IllegalArgumentException("request_level: " + i3 + " not supported!");
    }

    public String toString() {
        return "TencentLocationRequest [mInterval=" + this.f147572a + ", mCheckInterval=" + this.f147573b + ", mRequestLevel=" + this.f147574c + ", mAllowCache=" + this.f147575d + ", mAllowDirection=" + this.f147576e + ", mNumUpdates=" + this.f147577f + ", mAllowStepCount=" + this.f147578g + ", mAllowGps=" + this.f147579h + ", mQQ=" + this.f147580i + ", mExtras=" + this.f147581j + "]";
    }

    public TencentLocationRequest(TencentLocationRequest tencentLocationRequest) {
        this.f147572a = tencentLocationRequest.f147572a;
        this.f147574c = tencentLocationRequest.f147574c;
        this.f147575d = tencentLocationRequest.f147575d;
        this.f147576e = tencentLocationRequest.f147576e;
        this.f147577f = tencentLocationRequest.f147577f;
        this.f147573b = tencentLocationRequest.f147573b;
        this.f147578g = tencentLocationRequest.f147578g;
        this.f147579h = tencentLocationRequest.f147579h;
        this.f147580i = tencentLocationRequest.f147580i;
        Bundle bundle = new Bundle();
        this.f147581j = bundle;
        bundle.putAll(tencentLocationRequest.f147581j);
    }
}
