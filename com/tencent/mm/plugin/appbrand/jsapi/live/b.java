package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.ff.h;
import com.tencent.luggage.wxa.ic.e;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.uk.h0;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b extends TXCloudVideoView {

    /* renamed from: k, reason: collision with root package name */
    private static final String f152105k = "MicroMsg.AppBrandLivePusherView";

    /* renamed from: a, reason: collision with root package name */
    private h0 f152106a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f152107b;

    /* renamed from: c, reason: collision with root package name */
    public int f152108c;

    /* renamed from: d, reason: collision with root package name */
    private c f152109d;

    /* renamed from: e, reason: collision with root package name */
    public String f152110e;

    /* renamed from: f, reason: collision with root package name */
    public String f152111f;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.luggage.wxa.ff.b f152112g;

    /* renamed from: h, reason: collision with root package name */
    private ITXLivePushListener f152113h;

    /* renamed from: i, reason: collision with root package name */
    private f f152114i;

    /* renamed from: j, reason: collision with root package name */
    private e f152115j;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements h0.b {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.uk.h0.b
        public void onFourOrientationsChange(h0.a aVar, h0.a aVar2) {
            int i3 = C7060b.f152117a[aVar2.ordinal()];
            int i16 = 1;
            if (i3 != 1) {
                i16 = 2;
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            i16 = 3;
                        }
                    }
                }
                i16 = 0;
            }
            b.this.f152109d.a();
            b.this.f152109d.f152119a = i16;
            b.this.f152109d.b();
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.live.b$b, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class C7060b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f152117a;

        static {
            int[] iArr = new int[h0.a.values().length];
            f152117a = iArr;
            try {
                iArr[h0.a.LANDSCAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f152117a[h0.a.PORTRAIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f152117a[h0.a.REVERSE_PORTRAIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f152117a[h0.a.REVERSE_LANDSCAPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private static final int f152118d = 250;

        /* renamed from: a, reason: collision with root package name */
        int f152119a;

        /* renamed from: b, reason: collision with root package name */
        int f152120b = 0;

        public c() {
        }

        public void a() {
            this.f152120b = 0;
            b.this.f152107b.removeCallbacks(this);
        }

        public void b() {
            b.this.f152107b.postDelayed(this, 250L);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f152120b++;
            w.d(b.f152105k, "[CheckRotateTask] number=" + this.f152120b + "  senorAngle=" + this.f152119a);
            int a16 = b.this.a();
            if (a16 == this.f152119a) {
                b.this.a(a16);
            } else if (this.f152120b < 8) {
                b.this.f152107b.postDelayed(this, 250L);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        @Deprecated
        public static final int f152122a = 10003;

        /* renamed from: b, reason: collision with root package name */
        @Deprecated
        public static final int f152123b = 10004;

        /* renamed from: c, reason: collision with root package name */
        @Deprecated
        public static final int f152124c = 10005;
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface e {
        void onError(@NonNull com.tencent.luggage.wxa.af.c cVar, int i3, String str, HashMap<String, Object> hashMap);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface f {
        void onLivePusherExit();
    }

    public b(Context context) {
        super(context);
        this.f152107b = new Handler(getContext().getMainLooper());
        this.f152108c = 0;
        this.f152109d = new c();
        this.f152110e = "";
        a(context);
    }

    public void d() {
        h unInitLivePusher = this.f152112g.unInitLivePusher();
        w.d(f152105k, "onDestroy code:%d info:%s", Integer.valueOf(unInitLivePusher.f126108a), unInitLivePusher.f126109b);
        f fVar = this.f152114i;
        if (fVar != null) {
            fVar.onLivePusherExit();
        }
    }

    public void e() {
        h enterForeground = this.f152112g.enterForeground();
        w.d(f152105k, "onForeground code:%d info:%s", Integer.valueOf(enterForeground.f126108a), enterForeground.f126109b);
        this.f152106a.enable();
    }

    public void b() {
        this.f152112g.enterForeground();
    }

    public void c() {
        h enterBackground = this.f152112g.enterBackground(false);
        w.d(f152105k, "onBackground code:%d info:%s", Integer.valueOf(enterBackground.f126108a), enterBackground.f126109b);
        this.f152106a.disable();
    }

    public void a(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a(a());
    }

    public void b(Bundle bundle) {
        h updateLivePusher = this.f152112g.updateLivePusher(bundle);
        w.d(f152105k, "onUpdate code:%d info:%s", Integer.valueOf(updateLivePusher.f126108a), updateLivePusher.f126109b);
    }

    private void a(Context context) {
        this.f152112g = new TXLivePusherJSAdapter(context);
        setBackgroundColor(-16777216);
        h0 h0Var = new h0(getContext(), new a());
        this.f152106a = h0Var;
        h0Var.enable();
        a(a());
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f152107b = new Handler(getContext().getMainLooper());
        this.f152108c = 0;
        this.f152109d = new c();
        this.f152110e = "";
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() {
        return ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i3) {
        if (i3 == this.f152108c) {
            return false;
        }
        this.f152108c = i3;
        w.d(f152105k, "orientation changed senorAngle = " + i3);
        this.f152112g.notifyOrientationChanged(i3);
        return true;
    }

    public void a(e.d dVar) {
        w.d(f152105k, "onAppBrandPause pauseType:%s", dVar);
        if (dVar == e.d.BACK || dVar == e.d.CLOSE || dVar == e.d.LAUNCH_MINI_PROGRAM) {
            this.f152112g.enterBackground(true);
        }
    }

    public void a(Bundle bundle) {
        h initLivePusher = this.f152112g.initLivePusher(this, bundle);
        w.d(f152105k, "onInsert code:%d info:%s", Integer.valueOf(initLivePusher.f126108a), initLivePusher.f126109b);
    }

    public boolean a(String str, JSONObject jSONObject) {
        h operateLivePusher = this.f152112g.operateLivePusher(str, jSONObject);
        w.d(f152105k, "onOperate code:%d info:%s", Integer.valueOf(operateLivePusher.f126108a), operateLivePusher.f126109b);
        return operateLivePusher.f126108a == 0;
    }

    public void a(@NonNull com.tencent.luggage.wxa.af.c cVar, int i3, String str, HashMap<String, Object> hashMap) {
        w.h(f152105k, "onError code:%d msg:%s", Integer.valueOf(i3), str);
        e eVar = this.f152115j;
        if (eVar != null) {
            eVar.onError(cVar, i3, str, hashMap);
        }
    }

    public void a(ITXLivePushListener iTXLivePushListener) {
        this.f152113h = iTXLivePushListener;
        this.f152112g.setPushListener(iTXLivePushListener);
    }

    public void a(TXLivePusher.ITXSnapshotListener iTXSnapshotListener) {
        this.f152112g.setSnapshotListener(iTXSnapshotListener);
    }

    public void a(TXLivePusher.OnBGMNotify onBGMNotify) {
        this.f152112g.setBGMNotifyListener(onBGMNotify);
    }

    public void a(TXLivePusher.ITXAudioVolumeEvaluationListener iTXAudioVolumeEvaluationListener) {
        this.f152112g.setAudioVolumeListener(iTXAudioVolumeEvaluationListener);
    }

    public void a(f fVar) {
        this.f152114i = fVar;
    }

    public void a(e eVar) {
        this.f152115j = eVar;
    }
}
