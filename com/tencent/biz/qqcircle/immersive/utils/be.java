package com.tencent.biz.qqcircle.immersive.utils;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.qqcircle.immersive.utils.bi;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
/* loaded from: classes4.dex */
public class be {

    /* renamed from: c, reason: collision with root package name */
    private static volatile be f90176c;

    /* renamed from: a, reason: collision with root package name */
    private final Set<bi.a> f90177a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    private Pair<String, Bitmap> f90178b;

    be() {
    }

    public static be c() {
        if (f90176c == null) {
            synchronized (be.class) {
                if (f90176c == null) {
                    f90176c = new be();
                }
            }
        }
        return f90176c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(Pair pair) {
        if (pair != null && pair.first != null && pair.second != null) {
            this.f90178b = new Pair<>((String) pair.first, (Bitmap) pair.second);
            f();
        } else {
            QLog.e("QFP-QFSVideoCaptureFrameManager", 1, "[saveTextureFrameToBitmap] bitmapInfo == null || bitmapInfo.first == null || bitmapInfo.second == null.");
            this.f90178b = new Pair<>(null, null);
            f();
        }
    }

    private void f() {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.f90177a);
        this.f90177a.clear();
        QLog.d("QFP-QFSVideoCaptureFrameManager", 1, "[notifyAllCallback] current callback size: " + this.f90177a.size() + " | display callback set size: " + copyOnWriteArraySet.size());
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((bi.a) it.next()).a(this.f90178b);
        }
        this.f90178b = null;
    }

    private void g(bi.a aVar) {
        if (aVar == null) {
            QLog.e("QFP-QFSVideoCaptureFrameManager", 1, "[registerOnSaveFrameBitmapCallback] callback == null.");
            return;
        }
        QLog.d("QFP-QFSVideoCaptureFrameManager", 1, "[registerOnSaveFrameBitmapCallback] callback: " + aVar);
        this.f90177a.add(aVar);
    }

    public void b() {
        bi.d();
    }

    public boolean d() {
        return uq3.c.W5();
    }

    public void h(QFSVideoView qFSVideoView, FeedCloudMeta$StFeed feedCloudMeta$StFeed, bi.a aVar) {
        String g16 = com.tencent.biz.qqcircle.utils.bj.g(feedCloudMeta$StFeed);
        if (TextUtils.isEmpty(g16)) {
            QLog.e("QFP-QFSVideoCaptureFrameManager", 1, "[saveTextureFrameToBitmap] current feed id is empty.");
            return;
        }
        g(aVar);
        Pair<String, Bitmap> pair = this.f90178b;
        if (pair != null && TextUtils.equals((CharSequence) pair.first, g16)) {
            f();
        } else {
            bi.q(qFSVideoView, feedCloudMeta$StFeed, new bi.a() { // from class: com.tencent.biz.qqcircle.immersive.utils.bd
                @Override // com.tencent.biz.qqcircle.immersive.utils.bi.a
                public final void a(Pair pair2) {
                    be.this.e(pair2);
                }
            });
        }
    }
}
