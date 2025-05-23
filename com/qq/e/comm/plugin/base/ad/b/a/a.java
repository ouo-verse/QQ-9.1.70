package com.qq.e.comm.plugin.base.ad.b.a;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.webview.GDTADWebviewDelegate;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements ACTD, GDTADWebviewDelegate {

    /* renamed from: a, reason: collision with root package name */
    private Activity f38384a;

    public a(Activity activity) {
        this.f38384a = activity;
    }

    private void a() {
        this.f38384a.finish();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        c();
        b();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        a();
    }

    private void b() {
    }

    private void c() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i3, int i16, Intent intent) {
    }
}
