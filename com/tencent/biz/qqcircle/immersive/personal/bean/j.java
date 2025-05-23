package com.tencent.biz.qqcircle.immersive.personal.bean;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private String f88478a = "INVALID_GUIDE_INFO";

    /* renamed from: b, reason: collision with root package name */
    private boolean f88479b;

    /* renamed from: c, reason: collision with root package name */
    private k f88480c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f88481d;

    public k a() {
        return this.f88480c;
    }

    public String b() {
        return this.f88478a;
    }

    public boolean c() {
        if (this.f88479b && this.f88481d) {
            return true;
        }
        return false;
    }

    public void d(k kVar) {
        this.f88480c = kVar;
        this.f88481d = true;
    }

    public boolean e(String str) {
        QLog.d("QFSPersonalDraftInfo", 1, "setDraftGuideInfo, draftGuideInfo: " + str + ", mDraftGuideInfo: " + this.f88478a);
        boolean equals = TextUtils.equals(this.f88478a, str);
        this.f88478a = str;
        this.f88479b = true;
        return !equals;
    }
}
