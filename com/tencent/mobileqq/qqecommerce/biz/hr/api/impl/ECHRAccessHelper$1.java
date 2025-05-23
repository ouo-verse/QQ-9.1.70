package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl;

import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes35.dex */
class ECHRAccessHelper$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f262577d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ AppRuntime f262578e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f262579f;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a implements com.tencent.biz.common.offline.a {
        a() {
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String str, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("ViolaAccessHelpers", 2, "downOffline  code " + i3 + "  param " + str);
            }
            if (i3 != 0) {
                ECHRAccessHelper$1.this.getClass();
                return;
            }
            if (str == null) {
                ECHRAccessHelper$1.this.getClass();
                return;
            }
            if (str.contains("url")) {
                QLog.d("ViolaAccessHelpers", 2, "checkUpByBusinessId load success. contains url. cost=", Long.valueOf(System.currentTimeMillis() - ECHRAccessHelper$1.this.f262579f));
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ECHRAccessHelper$1 eCHRAccessHelper$1 = ECHRAccessHelper$1.this;
            long j3 = currentTimeMillis - eCHRAccessHelper$1.f262579f;
            eCHRAccessHelper$1.getClass();
            QLog.d("ViolaAccessHelpers", 2, "checkUpByBusinessId load success. no update. cost=", Long.valueOf(j3));
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int i3) {
            ECHRAccessHelper$1.this.getClass();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        HtmlOffline.k(this.f262577d, this.f262578e, new a(), true, 0, true);
    }
}
