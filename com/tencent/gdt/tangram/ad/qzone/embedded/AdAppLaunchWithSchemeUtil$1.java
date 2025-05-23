package com.tencent.gdt.tangram.ad.qzone.embedded;

import android.content.Context;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.tencent.gdt.tangram.ad.qzone.AdClickData;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes31.dex */
final class AdAppLaunchWithSchemeUtil$1 extends TimerTask {

    /* renamed from: d, reason: collision with root package name */
    int f108421d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ WeakReference f108422e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ AdClickData f108423f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ Timer f108424h;

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f108421d++;
        Context context = (Context) this.f108422e.get();
        if (context != null && GdtFeedUtilForQZone.r(context)) {
            GdtFeedUtilForQZone.a(this.f108423f.m(), 2015, 0);
            this.f108424h.cancel();
        } else if (this.f108421d > 100) {
            this.f108424h.cancel();
        }
    }
}
