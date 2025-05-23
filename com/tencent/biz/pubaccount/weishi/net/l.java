package com.tencent.biz.pubaccount.weishi.net;

import android.os.Handler;
import android.os.Looper;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* compiled from: P */
@Deprecated
/* loaded from: classes32.dex */
public class l implements b {

    /* renamed from: n, reason: collision with root package name */
    public static boolean f80985n = false;

    /* renamed from: o, reason: collision with root package name */
    private static Handler f80986o = new Handler(Looper.getMainLooper());

    /* renamed from: p, reason: collision with root package name */
    protected static final i f80987p = i.a();

    /* renamed from: a, reason: collision with root package name */
    public transient UniAttribute f80988a;

    /* renamed from: b, reason: collision with root package name */
    public transient c f80989b;

    /* renamed from: e, reason: collision with root package name */
    public int f80992e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<Handler> f80993f;

    /* renamed from: g, reason: collision with root package name */
    public j f80994g;

    /* renamed from: h, reason: collision with root package name */
    public int f80995h;

    /* renamed from: j, reason: collision with root package name */
    public int f80997j;

    /* renamed from: l, reason: collision with root package name */
    public Object f80999l;

    /* renamed from: m, reason: collision with root package name */
    public d f81000m;

    /* renamed from: c, reason: collision with root package name */
    public transient String f80990c = "";

    /* renamed from: d, reason: collision with root package name */
    public int f80991d = 0;

    /* renamed from: i, reason: collision with root package name */
    public HashMap<Object, Object> f80996i = new HashMap<>();

    /* renamed from: k, reason: collision with root package name */
    public long f80998k = System.currentTimeMillis();

    public l() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.b
    public void a(Object obj, int i3, int i16, String str, boolean z16, d dVar) {
        if (obj instanceof UniAttribute) {
            this.f80988a = (UniAttribute) obj;
        }
        this.f80999l = obj;
        this.f80992e = i3;
        this.f80991d = i16;
        this.f80990c = str;
        this.f81000m = dVar;
        if (1000006 == i3) {
            this.f80990c = HardCodeUtil.qqStr(R.string.vkq);
        }
        g.b().a(this);
    }

    public void c() {
        j jVar = this.f80994g;
        if (jVar != null) {
            jVar.setRequestRetryCount(this.f80997j);
            if (f80985n) {
                StringBuilder sb5 = new StringBuilder();
                JceStruct jceStruct = this.f80994g.f80984m;
                if (jceStruct != null) {
                    jceStruct.display(sb5, 0);
                }
            }
            x.i("WeishiTask", "startRunTask: " + this.f80994g.getCmdString() + ", " + this.f80994g.toString());
        }
        int b16 = f80987p.b(this.f80994g, this);
        if (b16 != 0) {
            a(null, b16, b16, b(b16), false, this.f81000m);
        }
    }

    public boolean d() {
        int i3 = this.f80992e;
        return i3 == 0 || i3 == 1000 || (Math.abs(i3) <= 19999 && Math.abs(this.f80992e) >= 19000);
    }

    public l(j jVar, Handler handler, c cVar, int i3) {
        this.f80994g = jVar;
        this.f80995h = i3;
        this.f80989b = cVar;
        if (handler != null) {
            this.f80993f = new WeakReference<>(handler);
        }
    }

    private String b(int i3) {
        if (i3 != 1000006) {
            return "";
        }
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "WeishiTask\t \u7f51\u7edc\u65e0\u8fde\u63a5");
        return QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkNotConnect", "\u7f51\u7edc\u65e0\u8fde\u63a5");
    }
}
