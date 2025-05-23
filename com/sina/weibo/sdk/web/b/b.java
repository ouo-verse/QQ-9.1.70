package com.sina.weibo.sdk.web.b;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.web.WebData;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class b {
    protected WebData aI;
    protected String aJ;

    /* renamed from: af, reason: collision with root package name */
    protected Context f61291af;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void onComplete();

        void onError(String str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
    }

    protected abstract void a(Bundle bundle);

    protected abstract void b(Bundle bundle);

    public abstract String getUrl();

    public final void readFromBundle(Bundle bundle) {
        this.aI = (WebData) bundle.getParcelable("web_data");
        this.aJ = bundle.getString("_weibo_transaction");
        b(bundle);
    }

    public final void setContext(Context context) {
        this.f61291af = context;
    }

    public boolean w() {
        return false;
    }

    public final Bundle writeToBundle(Bundle bundle) {
        bundle.putParcelable("web_data", this.aI);
        int type = this.aI.getType();
        if (type != 1) {
            if (type != 2) {
                if (type == 3) {
                    bundle.putInt("web_type", 3);
                }
            } else {
                bundle.putInt("web_type", 2);
            }
        } else {
            bundle.putInt("web_type", 1);
        }
        bundle.putString("_weibo_transaction", this.aJ);
        a(bundle);
        return bundle;
    }

    public final WebData x() {
        return this.aI;
    }

    public b(AuthInfo authInfo, int i3, String str, String str2) {
        this.aI = new WebData(authInfo, i3, str, str2);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(System.currentTimeMillis());
        this.aJ = sb5.toString();
    }

    public void a(a aVar) {
    }
}
