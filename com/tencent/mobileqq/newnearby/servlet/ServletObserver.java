package com.tencent.mobileqq.newnearby.servlet;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes33.dex */
public abstract class ServletObserver implements BusinessObserver {

    /* renamed from: d, reason: collision with root package name */
    public WeakReference<AppRuntime> f254229d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f254230e;

    public ServletObserver() {
        this.f254229d = new WeakReference<>(null);
        this.f254230e = true;
    }

    public abstract void c(int i3, byte[] bArr, Bundle bundle);

    @Override // mqq.observer.BusinessObserver
    public void onReceive(final int i3, final boolean z16, final Bundle bundle) {
        if (this.f254230e) {
            b(i3, z16, bundle);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.newnearby.servlet.ServletObserver.1
                @Override // java.lang.Runnable
                public void run() {
                    ServletObserver.this.b(i3, z16, bundle);
                }
            }, 128, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i3, boolean z16, Bundle bundle) {
        if (!z16) {
            int i16 = bundle.getInt("data_error_code", -1);
            QLog.e("ServletObserver", 1, "nearby ssoRsp fail, errCode=" + i16 + ", errMsg=" + bundle.getString("data_error_msg", ""));
            c(i16, null, bundle);
            return;
        }
        c(0, bundle.getByteArray("data"), bundle);
    }

    public ServletObserver(boolean z16) {
        this.f254229d = new WeakReference<>(null);
        this.f254230e = z16;
    }
}
