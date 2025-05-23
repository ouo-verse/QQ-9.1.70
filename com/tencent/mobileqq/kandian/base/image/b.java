package com.tencent.mobileqq.kandian.base.image;

import android.graphics.Bitmap;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.kandian.base.image.api.IRIJImageOptConfig;
import com.tencent.mobileqq.qroute.QRoute;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {

    /* renamed from: y, reason: collision with root package name */
    public static int f239003y = 2;

    /* renamed from: a, reason: collision with root package name */
    public URL f239004a;

    /* renamed from: b, reason: collision with root package name */
    public int f239005b;

    /* renamed from: c, reason: collision with root package name */
    public int f239006c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f239008e;

    /* renamed from: h, reason: collision with root package name */
    public long f239011h;

    /* renamed from: i, reason: collision with root package name */
    public long f239012i;

    /* renamed from: j, reason: collision with root package name */
    public long f239013j;

    /* renamed from: k, reason: collision with root package name */
    public long f239014k;

    /* renamed from: l, reason: collision with root package name */
    public long f239015l;

    /* renamed from: m, reason: collision with root package name */
    public long f239016m;

    /* renamed from: n, reason: collision with root package name */
    public long f239017n;

    /* renamed from: o, reason: collision with root package name */
    public long f239018o;

    /* renamed from: r, reason: collision with root package name */
    public String f239021r;

    /* renamed from: s, reason: collision with root package name */
    public String f239022s;

    /* renamed from: t, reason: collision with root package name */
    public long f239023t;

    /* renamed from: w, reason: collision with root package name */
    public boolean f239026w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f239027x;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f239007d = false;

    /* renamed from: f, reason: collision with root package name */
    Bitmap.Config f239009f = Bitmap.Config.ARGB_8888;

    /* renamed from: g, reason: collision with root package name */
    public int f239010g = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f239019p = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f239020q = -2;

    /* renamed from: u, reason: collision with root package name */
    public int f239024u = 0;

    /* renamed from: v, reason: collision with root package name */
    public String f239025v = "";

    public b() {
        this.f239026w = false;
        this.f239027x = false;
        this.f239026w = ((IRIJImageOptConfig) QRoute.api(IRIJImageOptConfig.class)).useInnerDns();
        this.f239027x = ((IRIJImageOptConfig) QRoute.api(IRIJImageOptConfig.class)).useIpConnect();
    }

    public String a() {
        return "kandian_zimage_image_req_" + hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f239005b != bVar.f239005b || this.f239006c != bVar.f239006c || this.f239010g != bVar.f239010g) {
            return false;
        }
        URL url = this.f239004a;
        if (url == null ? bVar.f239004a != null : !url.equals(bVar.f239004a)) {
            return false;
        }
        if (this.f239009f == bVar.f239009f) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        URL url = this.f239004a;
        if (url != null) {
            i3 = url.hashCode();
        } else {
            i3 = 0;
        }
        return (((((i3 * 31) + this.f239005b) * 31) + this.f239006c) * 31) + this.f239010g;
    }

    public String toString() {
        return this.f239004a + " " + this.f239005b + HippyTKDListViewAdapter.X + this.f239006c + " isPreload:" + this.f239008e + " isCancel:" + this.f239007d + " startTime: " + this.f239011h + " enterSubThreadTime: " + this.f239012i + " enterThreadPoolTime: " + this.f239013j + " startThreadPoolTime: " + this.f239014k + " downloadAndWriteFileTime: " + this.f239015l + " decodeTime: " + this.f239016m + " enterMainThreadTime: " + this.f239017n + " endTime: " + this.f239018o + " failCode: " + this.f239020q + " errMsg: " + this.f239021r + " supportInnerIp: " + this.f239026w + " useIpConnect:" + this.f239027x;
    }
}
