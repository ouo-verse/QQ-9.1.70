package com.tencent.mapsdk.internal;

import android.text.TextUtils;
import com.tencent.map.sdk.comps.offlinemap.OfflineItem;
import com.tencent.map.sdk.comps.offlinemap.OfflineItemController;
import com.tencent.map.sdk.comps.offlinemap.OfflineStatus;
import com.tencent.map.sdk.comps.offlinemap.OfflineStatusChangedListener;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.kp;
import com.tencent.mobileqq.videocodec.ffmpeg.Argument;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes9.dex */
public final class ca implements OfflineItemController {

    /* renamed from: a, reason: collision with root package name */
    OfflineStatusChangedListener f147976a;

    /* renamed from: b, reason: collision with root package name */
    a f147977b;

    /* renamed from: c, reason: collision with root package name */
    private final mv f147978c;

    /* renamed from: d, reason: collision with root package name */
    private final cb f147979d;

    /* renamed from: e, reason: collision with root package name */
    private final OfflineItem f147980e;

    /* renamed from: f, reason: collision with root package name */
    private final String f147981f;

    /* renamed from: g, reason: collision with root package name */
    private final File f147982g;

    /* renamed from: h, reason: collision with root package name */
    private final File f147983h;

    /* renamed from: i, reason: collision with root package name */
    private final File f147984i;

    /* renamed from: j, reason: collision with root package name */
    private String f147985j;

    /* renamed from: k, reason: collision with root package name */
    private final lw f147986k;

    /* renamed from: l, reason: collision with root package name */
    private final b f147987l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f147988m;

    /* renamed from: n, reason: collision with root package name */
    private final bp f147989n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        void a(OfflineItem offlineItem, int i3);

        void a(OfflineItem offlineItem, boolean z16);

        void b(OfflineItem offlineItem, boolean z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b extends ly implements lv {

        /* renamed from: c, reason: collision with root package name */
        private lx f147994c;

        /* renamed from: d, reason: collision with root package name */
        private File f147995d;

        b() {
        }

        @Override // com.tencent.mapsdk.internal.lv
        public final void a(String str) {
            this.f147995d = new File(ca.this.f147981f, this.f149291b + ".tmp");
            LogUtil.c(ky.f149116v, "\u5f00\u59cb\u4e0b\u8f7d:[" + this.f147995d + "]");
            if (ca.this.f147976a != null) {
                ca.this.f147976a.onStatusChanged(ca.this.f147980e, OfflineStatus.START);
            }
        }

        @Override // com.tencent.mapsdk.internal.lv
        public final void b(String str) {
            if (this.f147995d != null) {
                LogUtil.d(ky.f149116v, "\u53d6\u6d88\u4e0b\u8f7d:[" + this.f147995d + "]");
                kt.b(this.f147995d);
            }
            if (ca.this.f147976a != null) {
                ca.this.f147976a.onStatusChanged(ca.this.f147980e, OfflineStatus.CANCEL);
            }
        }

        @Override // com.tencent.mapsdk.internal.lv
        public final void c(String str) {
            File file = this.f147995d;
            if (file != null && file.exists()) {
                LogUtil.c(ky.f149116v, "\u5b8c\u6210\u4e0b\u8f7d:[" + this.f147995d + "]");
                LogUtil.c(ky.f149116v, "\u521b\u5efa\u57ce\u5e02\u7f13\u5b58\u6587\u4ef6:[" + ca.this.f147983h + "]");
                kt.b(ca.this.f147983h);
                kt.a(this.f147995d, ca.this.f147982g);
                ca.this.a();
                if (!ca.this.f147983h.exists()) {
                    LogUtil.d(ky.f149116v, "\u7f13\u5b58\u6587\u4ef6\u521b\u5efa\u5931\u8d25\uff01");
                    return;
                }
                LogUtil.c(ky.f149116v, "\u89e3\u538b\u6210\u529f:[" + ca.this.f147983h + "]");
                cb cbVar = ca.this.f147979d;
                mv mvVar = ca.this.f147978c;
                if (mvVar != null) {
                    mvVar.a(cbVar.f147998c + "-md5", cbVar.f147997b);
                    mvVar.a(cbVar.f147998c + Argument.VERSION, cbVar.f148000e);
                }
                LogUtil.c(ky.f149116v, "\u4fdd\u6301\u57ce\u5e02\u7f13\u5b58\u4fe1\u606f:[" + cbVar + "]");
                ca.this.f147986k.b(ca.this.f147987l);
                if (ca.this.f147977b != null) {
                    ca.this.f147977b.a(ca.this.f147980e, 100);
                    ca.this.f147977b.b(ca.this.f147980e, false);
                }
                if (ca.this.f147976a != null) {
                    ca.this.f147976a.onStatusChanged(ca.this.f147980e, OfflineStatus.COMPLETED);
                }
            }
        }

        @Override // com.tencent.mapsdk.internal.lv
        public final void d(String str) {
            if (this.f147995d != null) {
                LogUtil.d(ky.f149116v, "\u7f13\u5b58\u6587\u4ef6\u4e0b\u8f7d\u5931\u8d25\uff01");
                kt.b(this.f147995d);
            }
            if (ca.this.f147976a != null) {
                ca.this.f147976a.onStatusChanged(ca.this.f147980e, OfflineStatus.ERROR);
            }
        }

        /* synthetic */ b(ca caVar, byte b16) {
            this();
        }

        @Override // com.tencent.mapsdk.internal.lv
        public final void a(String str, byte[] bArr) {
            File file;
            if (TextUtils.isEmpty(str) || !str.equals(ca.this.f147985j) || bArr == null) {
                return;
            }
            if (this.f147994c == lx.RUNNING && (file = this.f147995d) != null) {
                int length = (int) ((file.length() * 100) / ca.this.f147979d.f147999d);
                if (ca.this.f147977b != null) {
                    ca.this.f147977b.a(ca.this.f147980e, length);
                }
                LogUtil.c(ky.f149116v, "\u7f13\u5b58\u6587\u4ef6\u4e0b\u8f7d\u4e2d:\uff1alength: " + this.f147995d.length() + "\uff1a" + length + "%");
                kt.b(this.f147995d, bArr);
            }
            if (ca.this.f147976a != null) {
                ca.this.f147976a.onStatusChanged(ca.this.f147980e, OfflineStatus.DOWNLOADING);
            }
        }

        @Override // com.tencent.mapsdk.internal.lv
        public final void a(String str, lx lxVar) {
            LogUtil.c(ky.f149116v, "\u4e0b\u8f7d\u72b6\u6001\uff1a".concat(String.valueOf(lxVar)));
            this.f147994c = lxVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(bp bpVar, String str, OfflineItem offlineItem, cb cbVar, mv mvVar, OfflineStatusChangedListener offlineStatusChangedListener) {
        this.f147989n = bpVar;
        this.f147978c = mvVar;
        this.f147980e = offlineItem;
        this.f147979d = cbVar;
        this.f147976a = offlineStatusChangedListener;
        lw lwVar = new lw();
        this.f147986k = lwVar;
        this.f147987l = new b(this, (byte) 0);
        lwVar.f149268b = hu.d();
        this.f147981f = str;
        this.f147982g = new File(str, cbVar.f147998c + ".zip");
        this.f147983h = new File(str, cbVar.a());
        this.f147984i = new File(mz.a(bpVar.getContext(), (TencentMapOptions) null).d(), cbVar.a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ac, code lost:
    
        if (r7.f147983h.exists() == false) goto L24;
     */
    @Override // com.tencent.map.sdk.comps.offlinemap.OfflineItemController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized boolean checkInvalidate() {
        boolean z16;
        boolean z17;
        cb cbVar = this.f147979d;
        z16 = false;
        if (cbVar != null) {
            this.f147985j = cbVar.f147996a + File.separator + cbVar.f147998c + cbVar.f148000e + ".zip";
            mv mvVar = this.f147978c;
            if (mvVar != null) {
                String a16 = mvVar.a(cbVar.f147998c + "-md5");
                if (cbVar.f148000e != mvVar.b(cbVar.f147998c + Argument.VERSION, -1) || (a16 != null && !a16.equals(cbVar.f147997b))) {
                    z17 = true;
                    LogUtil.c(ky.f149116v, "\u68c0\u67e5\u662f\u5426\u9700\u8981\u66f4\u65b0:[" + z17 + "]");
                    if (z17 && !this.f147988m && !this.f147983h.exists()) {
                        if (this.f147982g.exists()) {
                            a();
                        }
                        z16 = true;
                    } else {
                        z16 = z17;
                    }
                }
            }
            z17 = false;
            LogUtil.c(ky.f149116v, "\u68c0\u67e5\u662f\u5426\u9700\u8981\u66f4\u65b0:[" + z17 + "]");
            if (z17) {
            }
            z16 = z17;
        }
        a aVar = this.f147977b;
        if (aVar != null) {
            aVar.b(this.f147980e, z16);
        }
        return z16;
    }

    @Override // com.tencent.map.sdk.comps.offlinemap.OfflineItemController
    public final boolean close() {
        return b(this.f147989n);
    }

    @Override // com.tencent.map.sdk.comps.offlinemap.OfflineItemController
    public final boolean open() {
        return a(this.f147989n);
    }

    @Override // com.tencent.map.sdk.comps.offlinemap.OfflineItemController
    public final boolean removeCache() {
        boolean z16;
        if (kt.b(this.f147982g) && kt.b(this.f147983h)) {
            z16 = true;
        } else {
            z16 = false;
        }
        LogUtil.c(ky.f149116v, "\u5220\u9664[" + this.f147979d.f147998c + "]\u79bb\u7ebf\u7f13\u5b58");
        return z16;
    }

    @Override // com.tencent.map.sdk.comps.offlinemap.OfflineItemController
    public final void startDownload() {
        if (this.f147989n == null) {
            OfflineStatusChangedListener offlineStatusChangedListener = this.f147976a;
            if (offlineStatusChangedListener != null) {
                offlineStatusChangedListener.onStatusChanged(this.f147980e, OfflineStatus.ERROR);
                return;
            }
            return;
        }
        if (this.f147982g.exists()) {
            kp.a((kp.g) new kp.g<Boolean>() { // from class: com.tencent.mapsdk.internal.ca.2
                private Boolean a() {
                    ca caVar = ca.this;
                    return Boolean.valueOf(caVar.a(caVar.f147989n));
                }

                @Override // java.util.concurrent.Callable
                public final /* synthetic */ Object call() throws Exception {
                    ca caVar = ca.this;
                    return Boolean.valueOf(caVar.a(caVar.f147989n));
                }
            }).a((kp.a) new kp.a<Boolean>() { // from class: com.tencent.mapsdk.internal.ca.1
                private void a(Boolean bool) {
                    if (bool.booleanValue()) {
                        if (ca.this.f147976a != null) {
                            ca.this.f147976a.onStatusChanged(ca.this.f147980e, OfflineStatus.COMPLETED);
                            return;
                        }
                        return;
                    }
                    ca.this.startDownload();
                }

                @Override // com.tencent.mapsdk.internal.kp.a, com.tencent.map.tools.Callback
                public final /* synthetic */ void callback(Object obj) {
                    if (((Boolean) obj).booleanValue()) {
                        if (ca.this.f147976a != null) {
                            ca.this.f147976a.onStatusChanged(ca.this.f147980e, OfflineStatus.COMPLETED);
                            return;
                        }
                        return;
                    }
                    ca.this.startDownload();
                }
            });
            return;
        }
        if (checkInvalidate() && !TextUtils.isEmpty(this.f147985j)) {
            if (this.f147976a != null) {
                this.f147986k.a(this.f147987l);
            }
            LogUtil.c(ky.f149116v, "\u8bf7\u6c42\u4e0b\u8f7d:[" + this.f147985j + "]");
            this.f147986k.a(this.f147985j, this.f147987l);
            OfflineStatusChangedListener offlineStatusChangedListener2 = this.f147976a;
            if (offlineStatusChangedListener2 != null) {
                offlineStatusChangedListener2.onStatusChanged(this.f147980e, OfflineStatus.READY);
                return;
            }
            return;
        }
        OfflineStatusChangedListener offlineStatusChangedListener3 = this.f147976a;
        if (offlineStatusChangedListener3 != null) {
            offlineStatusChangedListener3.onStatusChanged(this.f147980e, OfflineStatus.ERROR);
        }
    }

    @Override // com.tencent.map.sdk.comps.offlinemap.OfflineItemController
    public final void stopDownload() {
        if (TextUtils.isEmpty(this.f147985j)) {
            return;
        }
        LogUtil.c(ky.f149116v, "\u505c\u6b62\u4e0b\u8f7d:[" + this.f147985j + "]");
        this.f147986k.b(this.f147985j);
    }

    private void a(OfflineStatusChangedListener offlineStatusChangedListener) {
        this.f147976a = offlineStatusChangedListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean b(bp bpVar) {
        if (this.f147984i.exists() && bpVar != null) {
            bu H = bpVar.H();
            H.d();
            kt.a(this.f147984i, this.f147983h);
            H.e();
            H.f();
            a aVar = this.f147977b;
            if (aVar != null) {
                aVar.a(this.f147980e, false);
            }
            OfflineStatusChangedListener offlineStatusChangedListener = this.f147976a;
            if (offlineStatusChangedListener != null) {
                offlineStatusChangedListener.onStatusChanged(this.f147980e, OfflineStatus.CLOSE);
            }
            this.f147988m = false;
            LogUtil.c(ky.f149116v, "\u5173\u95ed[" + this.f147979d.f147998c + "]\u79bb\u7ebf");
            return true;
        }
        return false;
    }

    private void a(a aVar) {
        this.f147977b = aVar;
    }

    final synchronized boolean a(bp bpVar) {
        if (bpVar == null) {
            return false;
        }
        a();
        if (!this.f147983h.exists()) {
            return false;
        }
        bu H = bpVar.H();
        H.d();
        kt.a(this.f147983h, this.f147984i);
        H.e();
        H.f();
        this.f147988m = true;
        a aVar = this.f147977b;
        if (aVar != null) {
            aVar.a(this.f147980e, true);
        }
        OfflineStatusChangedListener offlineStatusChangedListener = this.f147976a;
        if (offlineStatusChangedListener != null) {
            offlineStatusChangedListener.onStatusChanged(this.f147980e, OfflineStatus.OPEN);
        }
        LogUtil.c(ky.f149116v, "\u5f00\u542f[" + this.f147979d.f147998c + "]\u79bb\u7ebf");
        return true;
    }

    private void b() {
        this.f147977b = null;
        this.f147976a = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.f147982g.exists()) {
            try {
                LogUtil.c(ky.f149116v, "\u5f00\u59cb\u7f13\u5b58\u6587\u4ef6\u6821\u9a8c...");
                String a16 = li.a(this.f147982g);
                LogUtil.c(ky.f149116v, "\u7ed3\u675f\u7f13\u5b58\u6587\u4ef6\u6821\u9a8c...");
                if (!this.f147979d.f147997b.equals(a16)) {
                    LogUtil.d(ky.f149116v, "\u7f13\u5b58\u6587\u4ef6MD5\u4e0d\u4e00\u81f4\uff01");
                    kt.b(this.f147982g);
                } else {
                    kt.b(this.f147983h);
                    kw.a(this.f147982g, this.f147983h.getParent(), new FilenameFilter() { // from class: com.tencent.mapsdk.internal.ca.3
                        @Override // java.io.FilenameFilter
                        public final boolean accept(File file, String str) {
                            return ca.this.f147983h.getName().equals(str);
                        }
                    });
                }
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }
}
