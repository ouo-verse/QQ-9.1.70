package com.qq.e.comm.plugin.base.ad.clickcomponent.e;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.base.media.video.GDTVideoView;
import com.qq.e.comm.plugin.k.m;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements ACTD {

    /* renamed from: a, reason: collision with root package name */
    private Activity f38612a;

    /* renamed from: b, reason: collision with root package name */
    private g f38613b;

    /* renamed from: c, reason: collision with root package name */
    private c f38614c;

    /* renamed from: e, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.ad.model.f f38616e;

    /* renamed from: h, reason: collision with root package name */
    private long f38619h;

    /* renamed from: i, reason: collision with root package name */
    private String f38620i;

    /* renamed from: d, reason: collision with root package name */
    private a f38615d = new a();

    /* renamed from: f, reason: collision with root package name */
    private com.qq.e.comm.plugin.stat.b f38617f = new com.qq.e.comm.plugin.stat.b();

    /* renamed from: g, reason: collision with root package name */
    private com.qq.e.comm.plugin.stat.c f38618g = new com.qq.e.comm.plugin.stat.c();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class a implements com.qq.e.comm.plugin.base.media.video.a {
        a() {
        }

        @Override // com.qq.e.comm.plugin.base.media.video.a
        public void a() {
        }

        @Override // com.qq.e.comm.plugin.base.media.video.a
        public void a(boolean z16) {
        }

        @Override // com.qq.e.comm.plugin.base.media.video.a
        public void b() {
        }

        @Override // com.qq.e.comm.plugin.base.media.video.a
        public void c() {
        }
    }

    public b(Activity activity) {
        this.f38612a = activity;
    }

    private void a() {
        this.f38619h = this.f38612a.getIntent().getLongExtra("detailPagePlayTime", 0L);
        String stringExtra = this.f38612a.getIntent().getStringExtra("data");
        this.f38620i = this.f38612a.getIntent().getStringExtra("posId");
        String stringExtra2 = this.f38612a.getIntent().getStringExtra("adThreadId");
        if (TextUtils.isEmpty(stringExtra)) {
            e();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(stringExtra);
            com.qq.e.comm.plugin.base.ad.model.f fVar = new com.qq.e.comm.plugin.base.ad.model.f(GDTADManager.getInstance().getAppStatus().getAPPID(), this.f38620i, stringExtra2, com.qq.e.comm.plugin.base.ad.b.NATIVEUNIFIEDAD);
            this.f38616e = fVar;
            fVar.e(jSONObject);
            if (this.f38613b == null) {
                this.f38613b = new g(this.f38612a, this.f38616e);
            }
        } catch (Throwable th5) {
            GDTLogger.e("handleCreateFromOutClickEvent", th5);
        }
        if (this.f38613b == null) {
            e();
            return;
        }
        JSONObject a16 = m.a(this.f38618g.a(), this.f38612a, this.f38613b);
        StatTracer.trackEvent(30292, 2, this.f38617f, new com.qq.e.comm.plugin.stat.c(a16));
        GDTLogger.i("before: " + a16.toString());
        this.f38612a.getWindow().setFlags(16777216, 16777216);
    }

    @TargetApi(14)
    private void b() {
        g gVar = this.f38613b;
        if (gVar == null) {
            GDTLogger.e("handleMediaViewOutSideJump error");
            e();
            return;
        }
        gVar.a(false);
        if (this.f38613b.f38706d != null) {
            this.f38613b.f38706d.b(com.qq.e.comm.plugin.j.c.a(this.f38620i, "fullScreenDetailMediaCyclePlay", 0, 1));
            this.f38613b.f38706d.c(false);
        }
        if (!this.f38613b.f38722t) {
            GDTLogger.e("handleMediaViewOutSideJump error");
            e();
        }
    }

    private void c() {
        g gVar;
        if (SDKStatus.getSDKVersionCode() < 120) {
            GDTLogger.e("not support below 120 versionCode");
            return;
        }
        Bundle extras = this.f38612a.getIntent().getExtras();
        if (extras != null) {
            ResultReceiver resultReceiver = (ResultReceiver) extras.getParcelable("key_result_receiver");
            Bundle bundle = new Bundle();
            if (resultReceiver != null && (gVar = this.f38613b) != null) {
                int u16 = gVar.u();
                if (u16 <= 0) {
                    u16 = (int) this.f38619h;
                }
                bundle.putLong("key_video_position", u16);
                resultReceiver.send(-1, bundle);
            }
        }
    }

    private void d() {
        if (this.f38613b != null && this.f38612a != null) {
            Intent intent = new Intent(this.f38613b.d());
            int u16 = this.f38613b.u();
            if (u16 <= 0) {
                u16 = (int) this.f38619h;
            }
            intent.putExtra("key_video_position", u16);
            this.f38612a.sendBroadcast(intent);
        }
    }

    private void e() {
        this.f38612a.finish();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        boolean z16;
        RelativeLayout relativeLayout = new RelativeLayout(this.f38612a);
        c cVar = new c(this.f38612a);
        this.f38614c = cVar;
        cVar.a(this.f38613b);
        relativeLayout.addView(this.f38614c, new RelativeLayout.LayoutParams(-1, -1));
        this.f38612a.setContentView(relativeLayout);
        this.f38612a.setRequestedOrientation(1);
        b();
        GDTVideoView gDTVideoView = this.f38613b.f38706d;
        com.qq.e.comm.plugin.base.media.video.b bVar = this.f38613b.f38705c;
        com.qq.e.comm.plugin.base.ad.model.f fVar = this.f38616e;
        if (fVar != null) {
            z16 = a(fVar);
        } else {
            z16 = false;
        }
        this.f38614c.a(gDTVideoView, bVar, this.f38616e, z16);
        this.f38613b.c(11);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        com.qq.e.comm.plugin.base.media.video.b bVar;
        GDTLogger.d("FullScreenVideoActivityDelegate onBackPressed");
        if (this.f38613b.f38706d != null && this.f38613b.f38706d.c() && (bVar = this.f38613b.f38705c) != null) {
            bVar.d();
        }
        e();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        GDTLogger.d("handleJump video ceiling onBeforeCreate");
        this.f38612a.setTheme(R.style.Theme.Black.NoTitleBar.Fullscreen);
        long longExtra = this.f38612a.getIntent().getLongExtra("clickStartTime", System.currentTimeMillis());
        a();
        this.f38618g.a("cost_time", Long.valueOf(System.currentTimeMillis() - longExtra));
        StatTracer.trackEvent(30222, 1, this.f38617f, this.f38618g);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        GDTLogger.d("FullScreenVideoActivityDelegate onDestroy");
        d();
        c cVar = this.f38614c;
        if (cVar != null) {
            cVar.c();
        }
        g gVar = this.f38613b;
        if (gVar != null) {
            gVar.s();
            StatTracer.trackEvent(30222, 2, this.f38617f, this.f38618g);
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
        c();
        c cVar = this.f38614c;
        if (cVar != null) {
            cVar.b();
        }
        if (this.f38613b.f38706d != null && this.f38613b.f38706d.c()) {
            g gVar = this.f38613b;
            if (!gVar.f38723u) {
                gVar.c();
                this.f38613b.v();
            }
        }
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
        c cVar = this.f38614c;
        if (cVar != null) {
            cVar.a();
        }
        g gVar = this.f38613b;
        if (gVar != null) {
            gVar.a(gVar.u());
            this.f38613b.t();
            this.f38613b.a(this.f38615d);
        }
    }

    public static boolean a(com.qq.e.comm.plugin.base.ad.model.f fVar) {
        return fVar.B() > fVar.A();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i3, int i16, Intent intent) {
    }
}
