package com.tencent.biz.pubaccount.weishi.player;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.player.WSVideoPluginInstall;
import com.tencent.biz.pubaccount.weishi.player.wrapper.f;
import com.tencent.biz.pubaccount.weishi.player.wrapper.m;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.util.WeakReference;

/* loaded from: classes32.dex */
public class WSVideoPreDownloadManager implements WSVideoPluginInstall.b {
    private String C;
    private Set<String> D = null;
    private List<c> E = null;

    /* renamed from: d, reason: collision with root package name */
    private final Context f81099d;

    /* renamed from: e, reason: collision with root package name */
    private WSVideoPluginInstall f81100e;

    /* renamed from: f, reason: collision with root package name */
    private b f81101f;

    /* renamed from: h, reason: collision with root package name */
    private f.a f81102h;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.player.wrapper.f f81103i;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.player.wrapper.d f81104m;

    /* loaded from: classes32.dex */
    private static class PreDownloadNotAlreadyVideoTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<WSVideoPreDownloadManager> f81105d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f81106e;

        PreDownloadNotAlreadyVideoTask(WSVideoPreDownloadManager wSVideoPreDownloadManager, boolean z16) {
            this.f81105d = new WeakReference<>(wSVideoPreDownloadManager);
            this.f81106e = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            WSVideoPreDownloadManager wSVideoPreDownloadManager = this.f81105d.get();
            if (wSVideoPreDownloadManager == null) {
                return;
            }
            if (this.f81106e && wSVideoPreDownloadManager.D != null) {
                wSVideoPreDownloadManager.D.add(wSVideoPreDownloadManager.C);
            }
            wSVideoPreDownloadManager.C = null;
            wSVideoPreDownloadManager.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements f.a {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.f.a
        public void a(String str, String str2) {
            x.m("WS_VIDEO_PRE_DL", "<<<<<<[WSVideoPreDownloadManager.java][onPreLoadSuccess] SUCCESS!! videoUrl:" + str + " SUCCESS");
            if (WSVideoPreDownloadManager.this.f81102h != null) {
                WSVideoPreDownloadManager.this.f81102h.a(str, str2);
            }
            ThreadManagerV2.post(new PreDownloadNotAlreadyVideoTask(WSVideoPreDownloadManager.this, true), 5, null, true);
        }

        @Override // com.tencent.biz.pubaccount.weishi.player.wrapper.f.a
        public void b(String str, int i3, String str2) {
            x.f("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][onPreLoadFailed] ERROR!! videoUrl:" + str + " ERROR code: " + i3);
            if (WSVideoPreDownloadManager.this.f81102h != null) {
                WSVideoPreDownloadManager.this.f81102h.b(str, i3, str2);
            }
            ThreadManagerV2.post(new PreDownloadNotAlreadyVideoTask(WSVideoPreDownloadManager.this, false), 5, null, true);
        }
    }

    /* loaded from: classes32.dex */
    public interface b {
        List<c> a(int i3, boolean z16);

        boolean b();
    }

    /* loaded from: classes32.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f81110a;

        /* renamed from: b, reason: collision with root package name */
        public String f81111b;

        /* renamed from: c, reason: collision with root package name */
        public String f81112c;

        /* renamed from: d, reason: collision with root package name */
        public long f81113d;

        /* renamed from: e, reason: collision with root package name */
        public int f81114e;

        /* renamed from: g, reason: collision with root package name */
        public boolean f81116g;

        /* renamed from: f, reason: collision with root package name */
        public boolean f81115f = true;

        /* renamed from: h, reason: collision with root package name */
        public boolean f81117h = false;

        public c(String str, int i3, long j3, boolean z16) {
            this.f81111b = str;
            this.f81114e = i3;
            this.f81116g = z16;
            this.f81113d = j3;
        }
    }

    public WSVideoPreDownloadManager(Context context) {
        this.f81099d = context;
        WSVideoPluginInstall wSVideoPluginInstall = new WSVideoPluginInstall();
        this.f81100e = wSVideoPluginInstall;
        wSVideoPluginInstall.k(this);
        if (!this.f81100e.j()) {
            this.f81100e.i();
        } else {
            q();
            r();
        }
    }

    private com.tencent.biz.pubaccount.weishi.player.wrapper.a p(c cVar) {
        com.tencent.biz.pubaccount.weishi.player.wrapper.d dVar = this.f81104m;
        if (dVar == null) {
            return null;
        }
        com.tencent.biz.pubaccount.weishi.player.wrapper.a b16 = dVar.b();
        b16.b(cVar, 101);
        return b16;
    }

    private void q() {
        com.tencent.biz.pubaccount.weishi.player.wrapper.d b16 = m.d().b();
        this.f81104m = b16;
        this.f81103i = b16.a(BaseApplication.getContext());
        x.j("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][initCacheMgr] mPreDownloader=" + this.f81103i);
    }

    private void r() {
        if (this.f81103i == null) {
            return;
        }
        this.D = new HashSet();
        this.E = new ArrayList();
        x.j("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][initSerialPreDownload] setPreloadCallback");
        this.f81103i.d(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        c cVar;
        List<c> list = this.E;
        if (list != null && list.size() > 0) {
            try {
                cVar = list.get(0);
                try {
                    list.remove(0);
                } catch (Exception e16) {
                    e = e16;
                    x.f("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][preDownloadNotAlreadyVideo] remove(0) ERROR = " + e.getMessage());
                    if (cVar == null) {
                    }
                    t();
                    return;
                }
            } catch (Exception e17) {
                e = e17;
                cVar = null;
            }
            if (cVar == null && !TextUtils.isEmpty(cVar.f81111b)) {
                String str = cVar.f81111b;
                this.C = str;
                if (n(str)) {
                    x.j("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][preDownloadNotAlreadyVideo] checkIsCached is TRUE! videoTitle:" + cVar.f81112c);
                    this.C = null;
                    t();
                    return;
                }
                x.j("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][preDownloadNotAlreadyVideo] checkIsCached is FALSE! videoTitle:" + cVar.f81112c);
                s(cVar);
                return;
            }
            t();
            return;
        }
        x.j("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][preDownloadNotAlreadyVideo] preDownload finish! PreDownloadList empty.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        x.j("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][releaseSerialPreDownload]");
        com.tencent.biz.pubaccount.weishi.player.wrapper.f fVar = this.f81103i;
        if (fVar != null) {
            fVar.d(null);
            fVar.destroy();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.WSVideoPluginInstall.b
    public void a(boolean z16) {
        q();
        r();
    }

    public boolean n(String str) {
        com.tencent.biz.pubaccount.weishi.player.wrapper.f fVar = this.f81103i;
        if (fVar == null) {
            return false;
        }
        Set<String> set = this.D;
        return fVar.a(p(new c(str, 0, 0L, false))) || (set != null && set.contains(str));
    }

    public void o() {
        x.j("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][destroy]");
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.player.WSVideoPreDownloadManager.1
            @Override // java.lang.Runnable
            public void run() {
                WSVideoPreDownloadManager.this.z();
                WSVideoPreDownloadManager.this.u();
                WSVideoPreDownloadManager.this.f81101f = null;
                WSVideoPreDownloadManager.this.f81102h = null;
                WSVideoPreDownloadManager.this.f81103i = null;
            }
        }, 5, null, true);
        WSVideoPluginInstall wSVideoPluginInstall = this.f81100e;
        if (wSVideoPluginInstall != null) {
            wSVideoPluginInstall.g();
            this.f81100e = null;
        }
    }

    public void w(int i3, boolean z16) {
        b bVar = this.f81101f;
        if (bVar == null) {
            return;
        }
        if (this.f81103i != null) {
            List<c> a16 = bVar.a(i3, z16);
            if (a16 == null || a16.size() <= 0) {
                return;
            }
            x.c("WS_VIDEO_PRE_DL", ">>>>>>[WSVideoPreDownloadManager.java][requestPreDownload] START!! preDownloadList size:" + a16.size());
            ThreadManagerV2.post(new PreDownloadSerialTask(this, a16), 5, null, true);
            return;
        }
        x.f("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][requestPreDownload] is off or mPreDownloader is null, return!");
    }

    public void x(b bVar) {
        this.f81101f = bVar;
    }

    public void y(f.a aVar) {
        this.f81102h = aVar;
    }

    public void z() {
        com.tencent.biz.pubaccount.weishi.player.wrapper.f fVar = this.f81103i;
        if (fVar != null) {
            fVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class PreDownloadSerialTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<WSVideoPreDownloadManager> f81107d;

        /* renamed from: e, reason: collision with root package name */
        private List<c> f81108e;

        PreDownloadSerialTask(WSVideoPreDownloadManager wSVideoPreDownloadManager, List<c> list) {
            this.f81107d = new WeakReference<>(wSVideoPreDownloadManager);
            this.f81108e = list;
        }

        private void b(WSVideoPreDownloadManager wSVideoPreDownloadManager) {
            if (this.f81108e.size() != 0) {
                c cVar = this.f81108e.get(0);
                String str = wSVideoPreDownloadManager.C;
                if (TextUtils.isEmpty(str)) {
                    x.j("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] curPreDownloadUrl is empty\uff0crestart preDownload!");
                    wSVideoPreDownloadManager.E = this.f81108e;
                    wSVideoPreDownloadManager.t();
                } else if (TextUtils.equals(str, cVar.f81111b)) {
                    x.j("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] current preDownloadUrl == PreList[0]");
                    this.f81108e.remove(0);
                    wSVideoPreDownloadManager.E = this.f81108e;
                } else {
                    x.j("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] current preDownloadUrl != PreList[0], stop download! restart preDownload!!");
                    wSVideoPreDownloadManager.E = this.f81108e;
                    wSVideoPreDownloadManager.z();
                    wSVideoPreDownloadManager.t();
                }
            }
        }

        private void e() {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                StringBuilder sb6 = new StringBuilder();
                for (c cVar : this.f81108e) {
                    sb5.append(cVar.f81112c);
                    sb5.append(APLogFileUtil.SEPARATOR_LOG);
                    sb6.append(cVar.f81111b);
                    sb6.append(APLogFileUtil.SEPARATOR_LOG);
                }
                x.j("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] preDownload listSize:" + this.f81108e.size() + ", listStr:" + ((Object) sb5));
                StringBuilder sb7 = new StringBuilder();
                sb7.append("[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] preDownload urlList:");
                sb7.append((Object) sb6);
                x.j("WS_VIDEO_PRE_DL", sb7.toString());
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            List<c> list;
            WSVideoPreDownloadManager wSVideoPreDownloadManager = this.f81107d.get();
            if (wSVideoPreDownloadManager == null || wSVideoPreDownloadManager.f81103i == null || wSVideoPreDownloadManager.D == null || (list = this.f81108e) == null || list.size() == 0) {
                return;
            }
            a(wSVideoPreDownloadManager);
            e();
            b(wSVideoPreDownloadManager);
        }

        private void a(WSVideoPreDownloadManager wSVideoPreDownloadManager) {
            int i3 = 0;
            int i16 = 0;
            while (i16 < this.f81108e.size()) {
                c cVar = this.f81108e.get(i16);
                if (wSVideoPreDownloadManager.D.contains(cVar.f81111b)) {
                    this.f81108e.remove(i16);
                    i16--;
                    x.j("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][PreDownloadSerialTask.run] hadPreDownload!! removeFromPreList:" + cVar.f81111b);
                }
                i16++;
            }
            b bVar = wSVideoPreDownloadManager.f81101f;
            if (bVar == null || bVar.b()) {
                return;
            }
            while (i3 < this.f81108e.size()) {
                if (!this.f81108e.get(i3).f81115f) {
                    this.f81108e.remove(i3);
                    i3--;
                }
                i3++;
            }
        }
    }

    public void v(int i3) {
        w(i3, true);
    }

    private void s(c cVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.f81111b)) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.player.wrapper.f fVar = this.f81103i;
        if (fVar == null) {
            x.f("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][innerDoPreDownload] start preload ERROR preDownloader == null!");
            return;
        }
        x.j("WS_VIDEO_PRE_DL", "[WSVideoPreDownloadManager.java][innerDoPreDownload] START DOWNLOAD!! duration:" + cVar.f81114e + ", title:" + cVar.f81112c + ", url:" + cVar.f81111b);
        if (TextUtils.isEmpty(cVar.f81111b)) {
            return;
        }
        fVar.b(p(cVar));
    }
}
