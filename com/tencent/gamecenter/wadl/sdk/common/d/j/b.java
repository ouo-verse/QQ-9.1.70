package com.tencent.gamecenter.wadl.sdk.common.d.j;

import android.text.TextUtils;
import com.tencent.gamecenter.wadl.sdk.common.b.g;
import com.tencent.gamecenter.wadl.sdk.common.d.f;
import com.tencent.gamecenter.wadl.sdk.common.d.h;
import com.tencent.gamecenter.wadl.sdk.common.d.i;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b extends com.tencent.gamecenter.wadl.sdk.common.d.j.a implements f {

    /* renamed from: a, reason: collision with root package name */
    private final g.a f107134a = new g.a();

    /* renamed from: b, reason: collision with root package name */
    private List<f.a> f107135b = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String a16 = i.a("settings_in_client", "", true);
            com.tencent.gamecenter.wadl.sdk.common.e.b.c("SettingsClient", "loadLocal jsonData:" + a16);
            if (!TextUtils.isEmpty(a16)) {
                try {
                    b.this.f107134a.a(a16);
                    b.this.e();
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    i.b("settings_in_client", "", true);
                }
            }
        }
    }

    public b() {
        com.tencent.gamecenter.wadl.sdk.common.a.g().post(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e() {
        Iterator<f.a> it = this.f107135b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.j.a
    public String c() {
        return QCircleDaTongConstant.ElementParamValue.SETTINGS;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.j.a, com.tencent.gamecenter.wadl.sdk.common.d.c
    public void d() {
        h.e().c();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.f
    public String a(String str, int i3, String str2, String str3, String str4, String str5) {
        return this.f107134a.a(str, i3, str2, str3, str4, str5);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.j.a, com.tencent.gamecenter.wadl.sdk.common.d.b
    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !com.tencent.gamecenter.wadl.sdk.common.d.k.a.b.a().c().equals(str2)) {
            com.tencent.gamecenter.wadl.sdk.common.d.k.a.b.a().a(str2, true);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f107134a) {
            this.f107134a.a();
            this.f107134a.a(str);
        }
        i.b("settings_in_client", this.f107134a.b(), true);
        e();
    }
}
