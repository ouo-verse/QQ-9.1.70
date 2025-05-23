package com.tencent.qqlive.superplayer.vinfo;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemProperties;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.superplayer.tools.utils.e;
import com.tencent.qqlive.superplayer.tools.utils.g;
import com.tencent.qqlive.superplayer.vinfo.b;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import wt3.a;
import wt3.b;
import zt3.j;

/* loaded from: classes22.dex */
public class TVKPlayerWrapperCGIModel {

    /* renamed from: e, reason: collision with root package name */
    private static boolean f345519e = false;

    /* renamed from: f, reason: collision with root package name */
    private static boolean f345520f = false;

    /* renamed from: a, reason: collision with root package name */
    private d f345521a;

    /* renamed from: b, reason: collision with root package name */
    private Queue<c> f345522b = new LinkedBlockingQueue();

    /* renamed from: c, reason: collision with root package name */
    private CGICombineCallback f345523c = new CGICombineCallback();

    /* renamed from: d, reason: collision with root package name */
    private b f345524d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public class CGICombineCallback implements b.a, a.InterfaceC11507a {
        CGICombineCallback() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i(int i3, int i16, String str, int i17, String str2) {
            c o16 = TVKPlayerWrapperCGIModel.this.o(i3);
            if (o(o16)) {
                TVKPlayerWrapperCGIModel.this.t(i3);
                return;
            }
            o16.f345544c = 3;
            TVKPlayerWrapperCGIModel.this.t(i3);
            TVKPlayerWrapperCGIModel.this.f345521a.onGetVodInfoFailed(o16.f345543b, o16.f345547f, i16, str, i17, str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(int i3, TVKLiveVideoInfo tVKLiveVideoInfo) {
            c o16 = TVKPlayerWrapperCGIModel.this.o(i3);
            if (o(o16)) {
                TVKPlayerWrapperCGIModel.this.t(i3);
                return;
            }
            o16.f345544c = 3;
            TVKPlayerWrapperCGIModel.this.t(i3);
            TVKPlayerWrapperCGIModel.this.f345521a.onGetLiveInfoFailed(o16.f345543b, o16.f345547f, tVKLiveVideoInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k(int i3, TVKLiveVideoInfo tVKLiveVideoInfo) {
            c o16 = TVKPlayerWrapperCGIModel.this.o(i3);
            if (o(o16)) {
                TVKPlayerWrapperCGIModel.this.t(i3);
                return;
            }
            o16.f345544c = 3;
            TVKPlayerWrapperCGIModel.this.t(i3);
            TVKPlayerWrapperCGIModel.this.f345521a.onGetLiveInfoSuccess(o16.f345543b, o16.f345547f, tVKLiveVideoInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(int i3, TVKVideoInfo tVKVideoInfo) {
            c o16 = TVKPlayerWrapperCGIModel.this.o(i3);
            if (o(o16)) {
                TVKPlayerWrapperCGIModel.this.t(i3);
                return;
            }
            o16.f345544c = 3;
            TVKPlayerWrapperCGIModel.this.t(i3);
            if (n(o16, tVKVideoInfo)) {
                o16.f345546e.b().n(false);
                TVKPlayerWrapperCGIModel.this.u(o16.f345543b, o16.f345545d, o16.f345546e);
            } else {
                TVKPlayerWrapperCGIModel.this.f345521a.onGetVodInfoSuccess(o16.f345543b, o16.f345547f, tVKVideoInfo);
            }
        }

        private boolean m(c cVar, TVKNetVideoInfo tVKNetVideoInfo) {
            if (!tVKNetVideoInfo.isHevc() || tVKNetVideoInfo.getCurDefinition() == null || TextUtils.isEmpty(tVKNetVideoInfo.getCurDefinition().getDefn()) || cVar.f345545d.k().getPlayType() != 2) {
                return false;
            }
            int i3 = g.i(cVar.f345545d.k().getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_ENTER_SYSPLAYER_HEVC_CAP, ""), 0);
            if (i3 == 1) {
                i3 = 28;
            } else if (i3 == 2) {
                i3 = 33;
            }
            if (e.c(tVKNetVideoInfo.getCurDefinition().getDefn(), i3) > 0) {
                return false;
            }
            return true;
        }

        private boolean n(c cVar, TVKNetVideoInfo tVKNetVideoInfo) {
            if (TVKPlayerWrapperCGIModel.this.p()) {
                com.tencent.qqlive.superplayer.tools.utils.d.d("TVKPlayer[TVKPlayerWrapper]", "CGI : video info success , has remaining request , no need re request.");
                return false;
            }
            if (m(cVar, tVKNetVideoInfo)) {
                com.tencent.qqlive.superplayer.tools.utils.d.d("TVKPlayer[TVKPlayerWrapper]", "CGI : video info success , h265 level higher than system , re request h264");
                return true;
            }
            com.tencent.qqlive.superplayer.tools.utils.d.d("TVKPlayer[TVKPlayerWrapper]", "CGI : video info success , and no need re request new.");
            return false;
        }

        private boolean o(c cVar) {
            if (cVar == null || cVar.f345544c == 2) {
                return true;
            }
            return false;
        }

        @Override // wt3.b.a
        public void a(final int i3, final TVKVideoInfo tVKVideoInfo) {
            TVKPlayerWrapperCGIModel.this.f345524d.post(new Runnable() { // from class: com.tencent.qqlive.superplayer.vinfo.TVKPlayerWrapperCGIModel.CGICombineCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    CGICombineCallback.this.l(i3, tVKVideoInfo);
                }
            });
        }

        @Override // wt3.b.a
        public void b(final int i3, final int i16, final String str, final int i17, final String str2) {
            TVKPlayerWrapperCGIModel.this.f345524d.post(new Runnable() { // from class: com.tencent.qqlive.superplayer.vinfo.TVKPlayerWrapperCGIModel.CGICombineCallback.1
                @Override // java.lang.Runnable
                public void run() {
                    CGICombineCallback.this.i(i3, i16, str, i17, str2);
                }
            });
        }

        @Override // wt3.a.InterfaceC11507a
        public void c(final int i3, final TVKLiveVideoInfo tVKLiveVideoInfo) {
            TVKPlayerWrapperCGIModel.this.f345524d.post(new Runnable() { // from class: com.tencent.qqlive.superplayer.vinfo.TVKPlayerWrapperCGIModel.CGICombineCallback.3
                @Override // java.lang.Runnable
                public void run() {
                    CGICombineCallback.this.k(i3, tVKLiveVideoInfo);
                }
            });
        }

        @Override // wt3.a.InterfaceC11507a
        public void d(final int i3, final TVKLiveVideoInfo tVKLiveVideoInfo) {
            TVKPlayerWrapperCGIModel.this.f345524d.post(new Runnable() { // from class: com.tencent.qqlive.superplayer.vinfo.TVKPlayerWrapperCGIModel.CGICombineCallback.4
                @Override // java.lang.Runnable
                public void run() {
                    CGICombineCallback.this.j(i3, tVKLiveVideoInfo);
                }
            });
        }
    }

    /* loaded from: classes22.dex */
    private class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        int f345542a;

        /* renamed from: b, reason: collision with root package name */
        int f345543b;

        /* renamed from: c, reason: collision with root package name */
        int f345544c;

        /* renamed from: d, reason: collision with root package name */
        com.tencent.qqlive.superplayer.vinfo.c f345545d;

        /* renamed from: e, reason: collision with root package name */
        com.tencent.qqlive.superplayer.vinfo.b f345546e;

        /* renamed from: f, reason: collision with root package name */
        b.c f345547f;

        /* renamed from: g, reason: collision with root package name */
        long f345548g;

        c() {
        }
    }

    /* loaded from: classes22.dex */
    public interface d {
        void onGetLiveInfoFailed(int i3, b.c cVar, TVKLiveVideoInfo tVKLiveVideoInfo);

        void onGetLiveInfoSuccess(int i3, b.c cVar, TVKLiveVideoInfo tVKLiveVideoInfo);

        void onGetVodInfoFailed(int i3, b.c cVar, int i16, String str, int i17, String str2);

        void onGetVodInfoSuccess(int i3, b.c cVar, TVKVideoInfo tVKVideoInfo);
    }

    public TVKPlayerWrapperCGIModel(@NonNull Looper looper, d dVar) {
        this.f345521a = dVar;
        this.f345524d = new b(looper);
    }

    private c f(int i3, com.tencent.qqlive.superplayer.vinfo.c cVar, com.tencent.qqlive.superplayer.vinfo.b bVar) {
        if (i3 == 0) {
            return k(cVar, bVar);
        }
        if (i3 == 1) {
            return m(cVar, bVar);
        }
        if (i3 == 2) {
            return l(cVar, bVar);
        }
        if (i3 == 3) {
            return j(cVar, bVar);
        }
        if (i3 == 4) {
            return h(cVar, bVar);
        }
        if (i3 == 6) {
            return i(cVar, bVar);
        }
        if (i3 == 5) {
            return g(cVar, bVar);
        }
        return k(cVar, bVar);
    }

    @NonNull
    private c g(com.tencent.qqlive.superplayer.vinfo.c cVar, com.tencent.qqlive.superplayer.vinfo.b bVar) {
        s(cVar, bVar);
        c cVar2 = new c();
        cVar2.f345542a = -1;
        cVar2.f345543b = 5;
        cVar2.f345544c = 0;
        cVar2.f345545d = cVar;
        cVar2.f345546e = bVar;
        cVar2.f345547f = bVar.b().c();
        cVar2.f345548g = System.currentTimeMillis();
        return cVar2;
    }

    @NonNull
    private c h(com.tencent.qqlive.superplayer.vinfo.c cVar, com.tencent.qqlive.superplayer.vinfo.b bVar) {
        s(cVar, bVar);
        c cVar2 = new c();
        cVar2.f345542a = -1;
        cVar2.f345543b = 4;
        cVar2.f345544c = 0;
        cVar2.f345545d = cVar;
        cVar2.f345546e = bVar;
        cVar2.f345547f = bVar.b().c();
        cVar2.f345548g = System.currentTimeMillis();
        return cVar2;
    }

    @NonNull
    private c i(com.tencent.qqlive.superplayer.vinfo.c cVar, com.tencent.qqlive.superplayer.vinfo.b bVar) {
        s(cVar, bVar);
        if (-1 == cVar.g()) {
            cVar.k().getExtraRequestParamsMap().remove("playbacktime");
        } else {
            cVar.k().getExtraRequestParamsMap().put("playbacktime", String.valueOf(cVar.g()));
        }
        c cVar2 = new c();
        cVar2.f345542a = -1;
        cVar2.f345543b = 6;
        cVar2.f345544c = 0;
        cVar2.f345545d = cVar;
        cVar2.f345546e = bVar;
        cVar2.f345547f = bVar.b().c();
        cVar2.f345548g = System.currentTimeMillis();
        return cVar2;
    }

    @NonNull
    private c j(com.tencent.qqlive.superplayer.vinfo.c cVar, com.tencent.qqlive.superplayer.vinfo.b bVar) {
        s(cVar, bVar);
        cVar.k().addProxyExtraMap("tv_task_type", String.valueOf(1));
        return new c();
    }

    @NonNull
    private c k(com.tencent.qqlive.superplayer.vinfo.c cVar, com.tencent.qqlive.superplayer.vinfo.b bVar) {
        s(cVar, bVar);
        c cVar2 = new c();
        cVar2.f345542a = -1;
        cVar2.f345543b = 0;
        cVar2.f345544c = 0;
        cVar2.f345545d = cVar;
        cVar2.f345546e = bVar;
        cVar2.f345547f = bVar.b().c();
        cVar2.f345548g = System.currentTimeMillis();
        return cVar2;
    }

    @NonNull
    private c l(com.tencent.qqlive.superplayer.vinfo.c cVar, com.tencent.qqlive.superplayer.vinfo.b bVar) {
        s(cVar, bVar);
        c cVar2 = new c();
        cVar2.f345542a = -1;
        cVar2.f345543b = 2;
        cVar2.f345544c = 0;
        cVar2.f345545d = cVar;
        cVar2.f345546e = bVar;
        cVar2.f345547f = bVar.b().c();
        cVar2.f345548g = System.currentTimeMillis();
        return cVar2;
    }

    @NonNull
    private c m(com.tencent.qqlive.superplayer.vinfo.c cVar, com.tencent.qqlive.superplayer.vinfo.b bVar) {
        s(cVar, bVar);
        c cVar2 = new c();
        cVar2.f345542a = -1;
        cVar2.f345543b = 1;
        cVar2.f345544c = 0;
        cVar2.f345545d = cVar;
        cVar2.f345546e = bVar;
        cVar2.f345547f = bVar.b().c();
        cVar2.f345548g = System.currentTimeMillis();
        return cVar2;
    }

    private void n(c cVar) {
        com.tencent.qqlive.superplayer.tools.utils.d.d("TVKPlayer[TVKPlayerWrapper]", "CGI : ## videoInfo Request ##");
        String vid = cVar.f345545d.k().getVid();
        String d16 = cVar.f345547f.d();
        String a16 = cVar.f345547f.a();
        boolean o16 = cVar.f345547f.o();
        boolean i3 = cVar.f345547f.i();
        boolean q16 = cVar.f345547f.q();
        boolean g16 = cVar.f345547f.g();
        long g17 = cVar.f345545d.g();
        int i16 = cVar.f345543b;
        if (i16 == 0) {
            com.tencent.qqlive.superplayer.tools.utils.d.d("TVKPlayer[TVKPlayerWrapper]", "CGI : request type :normal request");
        } else if (i16 == 1) {
            com.tencent.qqlive.superplayer.tools.utils.d.d("TVKPlayer[TVKPlayerWrapper]", "CGI : request type :switch definition request");
        } else if (i16 == 2) {
            com.tencent.qqlive.superplayer.tools.utils.d.d("TVKPlayer[TVKPlayerWrapper]", "CGI : request type :switch audio track request");
        } else if (i16 == 3) {
            com.tencent.qqlive.superplayer.tools.utils.d.d("TVKPlayer[TVKPlayerWrapper]", "CGI : request type :loop play request");
        } else if (i16 == 4) {
            com.tencent.qqlive.superplayer.tools.utils.d.d("TVKPlayer[TVKPlayerWrapper]", "CGI : request type :high rail request");
        } else if (i16 == 6) {
            com.tencent.qqlive.superplayer.tools.utils.d.d("TVKPlayer[TVKPlayerWrapper]", "CGI : request type :live back play");
        }
        if (!TextUtils.isEmpty(vid)) {
            com.tencent.qqlive.superplayer.tools.utils.d.d("TVKPlayer[TVKPlayerWrapper]", "CGI : request param : vid : " + vid);
        }
        com.tencent.qqlive.superplayer.tools.utils.d.d("TVKPlayer[TVKPlayerWrapper]", "CGI : request param : definition  :" + d16);
        com.tencent.qqlive.superplayer.tools.utils.d.d("TVKPlayer[TVKPlayerWrapper]", "CGI : request param : h265Enable  :" + o16);
        com.tencent.qqlive.superplayer.tools.utils.d.d("TVKPlayer[TVKPlayerWrapper]", "CGI : request param : audioTrack  :" + a16);
        com.tencent.qqlive.superplayer.tools.utils.d.d("TVKPlayer[TVKPlayerWrapper]", "CGI : request param : drmEnable   :" + i3);
        com.tencent.qqlive.superplayer.tools.utils.d.d("TVKPlayer[TVKPlayerWrapper]", "CGI : request param : hdr10Enable :" + q16);
        com.tencent.qqlive.superplayer.tools.utils.d.d("TVKPlayer[TVKPlayerWrapper]", "CGI : request param : dolbyEnable :" + g16);
        com.tencent.qqlive.superplayer.tools.utils.d.d("TVKPlayer[TVKPlayerWrapper]", "CGI : request param : playbacktimems :" + g17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public c o(int i3) {
        for (c cVar : this.f345522b) {
            if (i3 == cVar.f345542a) {
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean p() {
        Iterator<c> it = this.f345522b.iterator();
        while (it.hasNext()) {
            int i3 = it.next().f345544c;
            if (i3 == 0 || i3 == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean q() {
        String str;
        if (f345519e) {
            return f345520f;
        }
        boolean z16 = false;
        try {
            str = (String) SystemProperties.class.getMethod("get", String.class).invoke(SystemProperties.class, "dolby.ds.state");
        } catch (Exception e16) {
            e16.printStackTrace();
            str = null;
        }
        if (str != null && !str.trim().equals("")) {
            z16 = true;
        }
        f345520f = z16;
        f345519e = true;
        return z16;
    }

    private void r() {
        Iterator<c> it = this.f345522b.iterator();
        while (it.hasNext()) {
            it.next().f345544c = 2;
        }
    }

    private void s(com.tencent.qqlive.superplayer.vinfo.c cVar, com.tencent.qqlive.superplayer.vinfo.b bVar) {
        com.tencent.qqlive.superplayer.vinfo.d.b(cVar.k());
        com.tencent.qqlive.superplayer.vinfo.d.f(cVar, bVar);
        com.tencent.qqlive.superplayer.vinfo.d.a(cVar.k(), bVar.b().d(), bVar.b().o());
        cVar.k().addExtraRequestParamsMap("flowid", bVar.b().j());
        com.tencent.qqlive.superplayer.vinfo.d.c(cVar.k());
        com.tencent.qqlive.superplayer.vinfo.d.e(cVar.k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(int i3) {
        this.f345522b.remove(o(i3));
    }

    private void v(c cVar) {
        int i3;
        Context a16 = cVar.f345545d.a();
        TVKUserInfo i16 = cVar.f345545d.i();
        TVKPlayerVideoInfo k3 = cVar.f345545d.k();
        String d16 = cVar.f345547f.d();
        int l3 = cVar.f345547f.l();
        if (k3.getPlayType() == 2) {
            j jVar = new j(a16);
            jVar.a(this.f345523c);
            i3 = jVar.b(i16, k3, d16, l3, 0);
        } else if (k3.getPlayType() == 8) {
            j jVar2 = new j(a16);
            jVar2.a(this.f345523c);
            i3 = jVar2.b(i16, k3, d16, l3, 0);
        } else if (k3.getPlayType() == 1) {
            com.tencent.qqlive.superplayer.vinfo.live.b o16 = com.tencent.qqlive.superplayer.vinfo.live.b.o(a16);
            o16.b(this.f345523c);
            i3 = o16.a(i16, k3, d16, l3, q());
        } else {
            i3 = -1;
        }
        cVar.f345542a = i3;
        cVar.f345544c = 1;
        n(cVar);
        this.f345522b.add(cVar);
    }

    public synchronized void u(int i3, @NonNull com.tencent.qqlive.superplayer.vinfo.c cVar, @NonNull com.tencent.qqlive.superplayer.vinfo.b bVar) {
        c f16 = f(i3, cVar, bVar);
        r();
        v(f16);
    }
}
