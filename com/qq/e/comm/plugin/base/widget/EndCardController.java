package com.qq.e.comm.plugin.base.widget;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.base.ad.model.f;
import com.qq.e.comm.plugin.k.au;
import com.qq.e.comm.plugin.k.ay;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.plugin.webview.bridge.GDTJSEvent;
import com.qq.e.comm.plugin.webview.inner.IInnerWebView;
import com.qq.e.comm.plugin.webview.inner.InnerWebViewListener;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.cfg.VideoOption;
import com.qq.e.tg.nativ.MediaView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class EndCardController {

    /* renamed from: a, reason: collision with root package name */
    public com.qq.e.comm.plugin.stat.b f39288a;

    /* renamed from: b, reason: collision with root package name */
    public com.qq.e.comm.plugin.stat.c f39289b;

    /* renamed from: c, reason: collision with root package name */
    private d f39290c;

    /* renamed from: d, reason: collision with root package name */
    private f f39291d;

    /* renamed from: e, reason: collision with root package name */
    private com.qq.e.comm.plugin.base.ad.clickcomponent.e.a f39292e;

    /* renamed from: f, reason: collision with root package name */
    private int f39293f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f39294g = true;

    /* renamed from: h, reason: collision with root package name */
    private String f39295h;

    /* renamed from: i, reason: collision with root package name */
    private int f39296i;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface EndCardLocation {
    }

    public EndCardController(f fVar, com.qq.e.comm.plugin.stat.b bVar, com.qq.e.comm.plugin.stat.c cVar) {
        this.f39291d = fVar;
        this.f39288a = bVar;
        this.f39289b = cVar;
    }

    public void a(Context context, MediaView mediaView, c cVar, int i3) {
        if (!b() || mediaView == null || context == null) {
            return;
        }
        if (this.f39290c == null) {
            d dVar = new d(context);
            this.f39290c = dVar;
            IInnerWebView a16 = dVar.a();
            ((PublicApi.WebViewApi) PublicApiHelper.getModuleApi(PublicApi.WebViewApi.class)).addHandler(com.qq.e.comm.plugin.n.c.f39697c, a16, "videoService", this.f39291d, cVar, this.f39288a, this.f39289b);
            a16.setInnerWebViewListener(new InnerWebViewListener() { // from class: com.qq.e.comm.plugin.base.widget.EndCardController.1
            });
            this.f39290c.a().loadUrl(a(this.f39291d.L()));
            au.a(30291, 0, this.f39288a, this.f39289b, 0);
        }
        this.f39290c.d();
        a(i3);
        this.f39290c.setVisibility(4);
        this.f39290c.a(mediaView, (mediaView.getWidth() - mediaView.getPaddingLeft()) - mediaView.getPaddingRight(), (mediaView.getHeight() - mediaView.getPaddingTop()) - mediaView.getPaddingBottom());
    }

    public boolean b() {
        boolean z16;
        boolean z17;
        if (this.f39291d.v().optInt("native_video_endcard") == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        int integer = GDTADManager.getInstance().getSM().getInteger("nativeVideoEndcard", 0);
        int K = this.f39291d.K();
        if (integer == 3 || ((integer == 1 && K == 3) || (integer == 2 && K == 4))) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!this.f39294g || this.f39291d.L().isEmpty()) {
            return false;
        }
        if (!z16 && !z17) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
    
        if (com.qq.e.comm.plugin.j.c.a(r4.f39291d.s(), "videoCeilingMediaCyclePlay", 0, 1) == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001a, code lost:
    
        if (com.qq.e.comm.plugin.j.c.a(r4.f39291d.s(), "outerMediaCyclePlay", 0, 1) == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        boolean z16;
        int i3;
        if (this.f39290c != null && (i3 = this.f39293f) != 3) {
            z16 = true;
            if (i3 == 1) {
            }
            if (this.f39293f == 2) {
            }
        }
        z16 = false;
        if (z16) {
            this.f39290c.setVisibility(0);
            au.a(30321, 0, this.f39288a, this.f39289b, 0);
        }
    }

    public void d() {
        d dVar = this.f39290c;
        if (dVar != null) {
            dVar.setVisibility(4);
        }
    }

    public d a() {
        return this.f39290c;
    }

    public void a(com.qq.e.comm.plugin.base.ad.clickcomponent.e.a aVar) {
        this.f39292e = aVar;
    }

    public void a(int i3) {
        this.f39293f = i3;
    }

    public void a(int i3, int i16) {
        IInnerWebView a16;
        d dVar = this.f39290c;
        if (dVar == null || (a16 = dVar.a()) == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("status", Integer.valueOf(i3));
            jSONObject.putOpt("progress", Integer.valueOf(i16));
            ((PublicApi.WebViewApi) PublicApiHelper.getModuleApi(PublicApi.WebViewApi.class)).fireJSEvent(a16, new GDTJSEvent("onAPKStatusUpdate", jSONObject));
            GDTLogger.d(String.format("jsbridge.dispatch updateAppDownloadStatus\uff08%d,%d\uff09", Integer.valueOf(i3), Integer.valueOf(i16)));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void a(VideoOption videoOption) {
        if (videoOption == null) {
            return;
        }
        this.f39294g = videoOption.getEndCardOpening();
        this.f39295h = videoOption.getEndCardBtnColor();
        this.f39296i = videoOption.getEndCardBtnRadius();
    }

    public String a(String str) {
        JSONObject jSONObject = new JSONObject();
        String str2 = null;
        try {
            if (!TextUtils.isEmpty(this.f39295h)) {
                jSONObject.put("color", this.f39295h);
            }
            int i3 = this.f39296i;
            if (i3 != 0) {
                jSONObject.put("radius", i3);
            }
            if (!TextUtils.isEmpty(jSONObject.toString())) {
                str2 = URLEncoder.encode(jSONObject.toString(), "UTF-8");
            }
        } catch (Throwable th5) {
            GDTLogger.e("native video make endCard url error :", th5);
        }
        return !TextUtils.isEmpty(str2) ? ay.c(str, "params", str2) : str;
    }
}
