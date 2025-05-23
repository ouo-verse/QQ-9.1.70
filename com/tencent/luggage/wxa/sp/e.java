package com.tencent.luggage.wxa.sp;

import com.tencent.luggage.wxa.np.h;
import com.tencent.luggage.wxa.np.i;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class e extends h {

    /* renamed from: c, reason: collision with root package name */
    public Object f140581c;

    public e() {
        super(-1);
        this.f140581c = null;
    }

    public Object d() {
        return this.f140581c;
    }

    @Override // com.tencent.luggage.wxa.np.h
    public String toString() {
        if (d() == null) {
            return super.toString();
        }
        return String.format("total: %s, extData: %s", super.toString(), d().toString());
    }

    public e(int i3, String str) {
        this(i3, str, null);
    }

    public e(int i3, String str, Object obj) {
        super(i3, str);
        this.f140581c = null;
        if (i3 == 1008) {
            this.f135897b = "not initialized yet. please make sure you've already called SoterWrapperApi.init(...) and call backed";
        } else if (i3 == 1011) {
            this.f135897b = "context instance already released. should not happen normally, you can try to call again";
        } else if (i3 == 1019) {
            this.f135897b = "upload or verify signature in server side failed";
        } else if (i3 == 1013) {
            this.f135897b = "there must be at least 1 biometric enrolled in system to complete this process. please check it previously";
        } else if (i3 != 1014) {
            switch (i3) {
                case 1002:
                    this.f135897b = "get support soter failed remotely";
                    break;
                case 1003:
                    this.f135897b = "upload app secure key";
                    break;
                case 1004:
                    this.f135897b = "upload auth key failed";
                    break;
            }
        } else {
            this.f135897b = "get challenge failed";
        }
        if (!i.a(str)) {
            this.f135897b = str;
        }
        this.f140581c = obj;
    }

    public e(int i3) {
        this(i3, "", null);
    }

    public e(int i3, Object obj) {
        this(i3, "", obj);
    }
}
