package com.tencent.qqlive.superplayer.vinfo.live;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qqlive.superplayer.thirdparties.LocalCache;
import com.tencent.qqlive.superplayer.tools.utils.TVKHandlerThreadPool;
import com.tencent.qqlive.superplayer.tools.utils.d;
import com.tencent.qqlive.superplayer.tools.utils.g;
import com.tencent.qqlive.superplayer.tools.utils.h;
import com.tencent.qqlive.superplayer.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.superplayer.vinfo.TVKPlayerVideoInfo;
import com.tencent.qqlive.superplayer.vinfo.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import java.util.Map;
import wt3.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b implements wt3.a {

    /* renamed from: o, reason: collision with root package name */
    private static String f345620o = "MediaPlayerMgr[TVKLiveInfoGetter.java]";

    /* renamed from: p, reason: collision with root package name */
    private static int f345621p = 30000;

    /* renamed from: a, reason: collision with root package name */
    private Context f345622a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f345623b;

    /* renamed from: d, reason: collision with root package name */
    private c f345625d;

    /* renamed from: e, reason: collision with root package name */
    private String f345626e;

    /* renamed from: f, reason: collision with root package name */
    private String f345627f;

    /* renamed from: g, reason: collision with root package name */
    private TVKUserInfo f345628g;

    /* renamed from: h, reason: collision with root package name */
    private TVKPlayerVideoInfo f345629h;

    /* renamed from: i, reason: collision with root package name */
    private Map<String, String> f345630i;

    /* renamed from: k, reason: collision with root package name */
    private boolean f345632k;

    /* renamed from: l, reason: collision with root package name */
    private a.InterfaceC11507a f345633l;

    /* renamed from: c, reason: collision with root package name */
    private HandlerThread f345624c = null;

    /* renamed from: j, reason: collision with root package name */
    private int f345631j = -1;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.qqlive.superplayer.vinfo.live.a f345634m = new a();

    /* renamed from: n, reason: collision with root package name */
    private com.tencent.qqlive.superplayer.vinfo.live.a f345635n = new C9372b();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends com.tencent.qqlive.superplayer.vinfo.live.a {
        a() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.live.a
        public void b(int i3, TVKLiveVideoInfo tVKLiveVideoInfo) {
            d.a(b.f345620o, "onFailure, id: " + i3 + ", errInfo: " + tVKLiveVideoInfo.getErrInfo());
            tVKLiveVideoInfo.setErrModule(10000);
            if (b.this.f345633l != null) {
                b.this.f345633l.d(i3, tVKLiveVideoInfo);
            }
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.live.a
        public void c(int i3, TVKLiveVideoInfo tVKLiveVideoInfo) {
            if (vt3.d.f443433n0.a().booleanValue()) {
                try {
                    LocalCache a16 = LocalCache.a(b.this.f345622a);
                    if (b.this.f345628g != null && !TextUtils.isEmpty(b.this.f345628g.getLoginCookie()) && b.this.f345628g.isVip()) {
                        a16.h("live_" + b.this.f345626e + "_" + b.this.f345627f + "_" + g.d(b.this.f345628g.getLoginCookie()) + "_" + h.i(b.this.f345622a), tVKLiveVideoInfo, vt3.d.f443437o0.a().intValue());
                    } else {
                        a16.h("live_" + b.this.f345626e + "_" + b.this.f345627f + "_" + h.i(b.this.f345622a), tVKLiveVideoInfo, vt3.d.f443437o0.a().intValue());
                    }
                } catch (Throwable th5) {
                    d.b(b.f345620o, th5);
                }
            }
            d.d(b.f345620o, "[onSuccess] save cache id: " + i3 + ", progid: " + b.this.f345626e + ", def: " + b.this.f345627f);
            if (b.this.f345625d == null) {
                d.a(b.f345620o, "[handleSuccess]  mEventHandler is null ");
                b.this.q(i3, tVKLiveVideoInfo);
            } else {
                Message obtainMessage = b.this.f345625d.obtainMessage(100);
                obtainMessage.arg1 = i3;
                obtainMessage.obj = tVKLiveVideoInfo;
                b.this.f345625d.sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.qqlive.superplayer.vinfo.live.b$b, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    class C9372b extends com.tencent.qqlive.superplayer.vinfo.live.a {
        C9372b() {
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.live.a
        public void b(int i3, TVKLiveVideoInfo tVKLiveVideoInfo) {
            d.a(b.f345620o, "onFailure, preload, id: " + i3 + ", progid: " + b.this.f345626e + ", def: " + b.this.f345627f);
            if (b.this.f345624c != null) {
                TVKHandlerThreadPool.a().f(b.this.f345624c, b.this.f345625d);
                b.this.f345624c = null;
            }
            b.this.f345633l = null;
        }

        @Override // com.tencent.qqlive.superplayer.vinfo.live.a
        public void c(int i3, TVKLiveVideoInfo tVKLiveVideoInfo) {
            if (tVKLiveVideoInfo == null) {
                d.a(b.f345620o, "[handleSuccess]  preload failed, progid: " + b.this.f345626e + ", def: " + b.this.f345627f);
                return;
            }
            d.d(b.f345620o, "[onSuccess]  id: " + i3 + ", progid: " + b.this.f345626e + ", def: " + b.this.f345627f);
            try {
                LocalCache a16 = LocalCache.a(b.this.f345622a);
                if (b.this.f345628g != null && !TextUtils.isEmpty(b.this.f345628g.getLoginCookie()) && b.this.f345628g.isVip()) {
                    a16.h("live_" + b.this.f345626e + "_" + b.this.f345627f + "_" + g.d(b.this.f345628g.getLoginCookie()) + "_" + h.i(b.this.f345622a), tVKLiveVideoInfo, vt3.d.f443437o0.a().intValue());
                } else {
                    a16.h("live_" + b.this.f345626e + "_" + b.this.f345627f + "_" + h.i(b.this.f345622a), tVKLiveVideoInfo, vt3.d.f443437o0.a().intValue());
                }
            } catch (Throwable th5) {
                d.b(b.f345620o, th5);
            }
            if (b.this.f345624c != null) {
                TVKHandlerThreadPool.a().f(b.this.f345624c, b.this.f345625d);
                b.this.f345624c = null;
            }
            b.this.f345633l = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes22.dex */
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 100) {
                b.this.q(message.arg1, (TVKLiveVideoInfo) message.obj);
            } else {
                d.d(b.f345620o, "eventHandler unknow msg");
            }
        }
    }

    b(Context context) {
        this.f345622a = context.getApplicationContext();
    }

    public static b o(Context context) {
        return new b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i3, int i16, boolean z16, Map<String, String> map) {
        String str;
        TVKLiveVideoInfo tVKLiveVideoInfo;
        try {
            LocalCache a16 = LocalCache.a(this.f345622a);
            TVKUserInfo tVKUserInfo = this.f345628g;
            if (tVKUserInfo != null && !TextUtils.isEmpty(tVKUserInfo.getLoginCookie()) && this.f345628g.isVip()) {
                tVKLiveVideoInfo = (TVKLiveVideoInfo) a16.e("live_" + this.f345626e + "_" + this.f345627f + "_" + g.d(this.f345628g.getLoginCookie()) + "_" + h.i(this.f345622a));
            } else {
                tVKLiveVideoInfo = (TVKLiveVideoInfo) a16.e("live_" + this.f345626e + "_" + this.f345627f + "_" + h.i(this.f345622a));
            }
            if (tVKLiveVideoInfo != null) {
                d.d(f345620o, "preLoadLiveInfo, have cache, need not to preload");
            }
        } catch (Throwable th5) {
            d.b(f345620o, th5);
        }
        try {
            String str2 = f345620o;
            Object[] objArr = new Object[4];
            objArr[0] = this.f345626e;
            TVKUserInfo tVKUserInfo2 = this.f345628g;
            String str3 = "";
            if (tVKUserInfo2 == null) {
                str = "";
            } else {
                str = tVKUserInfo2.getUin();
            }
            objArr[1] = str;
            objArr[2] = this.f345627f;
            TVKUserInfo tVKUserInfo3 = this.f345628g;
            if (tVKUserInfo3 != null) {
                str3 = tVKUserInfo3.getLoginCookie();
            }
            objArr[3] = str3;
            d.d(str2, String.format("[getLiveInfo] progId = %s uin = %s definition = %s cookie = %s", objArr));
            com.tencent.qqlive.superplayer.vinfo.live.c cVar = new com.tencent.qqlive.superplayer.vinfo.live.c();
            cVar.i(false);
            cVar.j(false);
            cVar.k(i16);
            cVar.g(z16);
            cVar.h(map);
            new TVKLiveInfoRequest(i3, this.f345628g, this.f345626e, this.f345627f, this.f345635n, cVar).l();
        } catch (Exception e16) {
            TVKLiveVideoInfo tVKLiveVideoInfo2 = new TVKLiveVideoInfo();
            tVKLiveVideoInfo2.setErrModule(10000);
            tVKLiveVideoInfo2.setErrInfo(e16.getMessage());
            tVKLiveVideoInfo2.setRetCode(TVKCommonErrorCodeUtil.CODE.LIVE.CGI_PARAMS_ERR);
            this.f345634m.b(i3, tVKLiveVideoInfo2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i3, TVKLiveVideoInfo tVKLiveVideoInfo) {
        d.d(f345620o, "[live]handleSuccess(), id: " + i3);
        if (tVKLiveVideoInfo != null) {
            d.d(f345620o, String.format("[handleSuccess]  isGetUrl=%b isDlnaUrl=%b stream:%d", Boolean.valueOf(tVKLiveVideoInfo.isGetPreviewInfo()), Boolean.valueOf(tVKLiveVideoInfo.isGetDlnaUrl()), Integer.valueOf(tVKLiveVideoInfo.getStream())));
        } else {
            d.d(f345620o, "[handleSuccess]  data is null ");
        }
        if (this.f345632k) {
            d.a(f345620o, "[handleSuccess]  have stop ,return ");
            return;
        }
        if (tVKLiveVideoInfo != null && (tVKLiveVideoInfo.getRetCode() == 0 || tVKLiveVideoInfo.getRetCode() == 10 || tVKLiveVideoInfo.getRetCode() == 11 || tVKLiveVideoInfo.getRetCode() == 13)) {
            a.InterfaceC11507a interfaceC11507a = this.f345633l;
            if (interfaceC11507a != null) {
                interfaceC11507a.c(i3, tVKLiveVideoInfo);
                return;
            }
            return;
        }
        if (tVKLiveVideoInfo != null) {
            tVKLiveVideoInfo.setErrModule(10001);
        }
        a.InterfaceC11507a interfaceC11507a2 = this.f345633l;
        if (interfaceC11507a2 != null) {
            interfaceC11507a2.d(i3, tVKLiveVideoInfo);
        }
    }

    private void r() {
        if (this.f345623b && this.f345624c != null && this.f345625d != null) {
            return;
        }
        try {
            HandlerThread d16 = TVKHandlerThreadPool.a().d("TVK_LiveInfoGetter");
            this.f345624c = d16;
            Looper looper = d16.getLooper();
            if (looper == null) {
                Looper myLooper = Looper.myLooper();
                Looper.prepare();
                this.f345625d = new c(myLooper);
                Looper.loop();
            } else {
                this.f345625d = new c(looper);
            }
            this.f345623b = true;
        } catch (Throwable th5) {
            d.b(f345620o, th5);
        }
    }

    @Override // wt3.a
    public int a(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo, String str, int i3, boolean z16) {
        TVKLiveVideoInfo tVKLiveVideoInfo;
        r();
        int i16 = f345621p;
        f345621p = i16 + 1;
        this.f345628g = tVKUserInfo;
        this.f345626e = tVKPlayerVideoInfo.getVid();
        this.f345627f = str;
        this.f345630i = tVKPlayerVideoInfo.getExtraRequestParamsMap();
        this.f345629h = tVKPlayerVideoInfo;
        try {
            LocalCache a16 = LocalCache.a(this.f345622a);
            TVKUserInfo tVKUserInfo2 = this.f345628g;
            if (tVKUserInfo2 != null && !TextUtils.isEmpty(tVKUserInfo2.getLoginCookie()) && this.f345628g.isVip()) {
                tVKLiveVideoInfo = (TVKLiveVideoInfo) a16.e("live_" + this.f345626e + "_" + str + "_" + g.d(this.f345628g.getLoginCookie()) + "_" + h.i(this.f345622a));
            } else {
                tVKLiveVideoInfo = (TVKLiveVideoInfo) a16.e("live_" + this.f345626e + "_" + str + "_" + h.i(this.f345622a));
            }
            if (tVKLiveVideoInfo != null) {
                d.d(f345620o, "getLiveInfo, have cache");
                c cVar = this.f345625d;
                if (cVar == null) {
                    d.a(f345620o, "[handleSuccess]  mEventHandler is null ");
                    q(i16, tVKLiveVideoInfo);
                    return i16;
                }
                Message obtainMessage = cVar.obtainMessage(100);
                obtainMessage.arg1 = i16;
                obtainMessage.obj = tVKLiveVideoInfo;
                this.f345625d.sendMessage(obtainMessage);
                return i16;
            }
        } catch (Throwable th5) {
            d.b(f345620o, th5);
        }
        try {
            d.d(f345620o, String.format("[getLiveInfo] progId = %s uin = %s definition = %s cookie = %s", this.f345626e, tVKUserInfo.getUin(), str, tVKUserInfo.getLoginCookie()));
            com.tencent.qqlive.superplayer.vinfo.live.c cVar2 = new com.tencent.qqlive.superplayer.vinfo.live.c();
            cVar2.i(false);
            cVar2.j(false);
            cVar2.k(i3);
            cVar2.g(z16);
            cVar2.h(this.f345630i);
            cVar2.l(this.f345629h);
            new TVKLiveInfoRequest(i16, tVKUserInfo, this.f345626e, str, this.f345634m, cVar2).l();
        } catch (Exception e16) {
            TVKLiveVideoInfo tVKLiveVideoInfo2 = new TVKLiveVideoInfo();
            tVKLiveVideoInfo2.setErrModule(10000);
            tVKLiveVideoInfo2.setErrInfo(e16.getMessage());
            this.f345634m.b(i16, tVKLiveVideoInfo2);
        }
        return i16;
    }

    @Override // wt3.a
    public void b(a.InterfaceC11507a interfaceC11507a) {
        this.f345633l = interfaceC11507a;
    }
}
