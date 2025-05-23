package fv2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.f;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private volatile a f400841a;

    private static boolean b(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.b bVar) {
        f fVar;
        if (bVar != null && (fVar = bVar.f303770a) != null && fVar.f303829t != null) {
            return true;
        }
        return false;
    }

    public a a(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.download.b bVar) {
        if (!b(bVar)) {
            return null;
        }
        if (this.f400841a == null) {
            synchronized (c.class) {
                if (this.f400841a == null) {
                    this.f400841a = new c();
                }
            }
        }
        return this.f400841a;
    }
}
