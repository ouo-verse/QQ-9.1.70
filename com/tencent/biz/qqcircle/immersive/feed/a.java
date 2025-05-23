package com.tencent.biz.qqcircle.immersive.feed;

import android.os.Bundle;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.mobileqq.qqlive.api.room.QCircleLiveFeedsPlayerEvent;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Surface f85319a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, c> f85320b;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.immersive.feed.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private class C0877a extends c {
        C0877a() {
            super();
        }

        @Override // com.tencent.biz.qqcircle.immersive.feed.a.c
        void a(@NonNull QFSVideoView qFSVideoView, Bundle bundle) {
            if (qFSVideoView.getSuperPlayer() == null) {
                QLog.e("FeedsVideoRenderSurfaceBinding", 2, "HandleFixXYEvent super player is null");
            } else if (bundle == null) {
                QLog.e("FeedsVideoRenderSurfaceBinding", 2, "HandleFixXYEvent params is null");
            } else {
                qFSVideoView.getSuperPlayer().setXYaxis(bundle.getInt(QCircleLiveFeedsPlayerEvent.EVENT_FIX_XY));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private class b extends c {
        b() {
            super();
        }

        @Override // com.tencent.biz.qqcircle.immersive.feed.a.c
        void a(@NonNull QFSVideoView qFSVideoView, Bundle bundle) {
            QLog.e("FeedsVideoRenderSurfaceBinding", 2, "HandlePauseEvent super player pause");
            qFSVideoView.pause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public abstract class c {
        c() {
        }

        abstract void a(@NonNull QFSVideoView qFSVideoView, Bundle bundle);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private class d extends c {
        d() {
            super();
        }

        @Override // com.tencent.biz.qqcircle.immersive.feed.a.c
        void a(@NonNull QFSVideoView qFSVideoView, Bundle bundle) {
            qFSVideoView.release();
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private class e extends c {
        e() {
            super();
        }

        @Override // com.tencent.biz.qqcircle.immersive.feed.a.c
        void a(@NonNull QFSVideoView qFSVideoView, Bundle bundle) {
            QLog.e("FeedsVideoRenderSurfaceBinding", 2, "HandleResumeEvent super player resume");
            qFSVideoView.start();
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private class f extends c {
        f() {
            super();
        }

        @Override // com.tencent.biz.qqcircle.immersive.feed.a.c
        void a(@NonNull QFSVideoView qFSVideoView, Bundle bundle) {
            QLog.e("FeedsVideoRenderSurfaceBinding", 2, "HandleStartEvent super player start");
            qFSVideoView.start();
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private class g extends c {
        g() {
            super();
        }

        @Override // com.tencent.biz.qqcircle.immersive.feed.a.c
        void a(@NonNull QFSVideoView qFSVideoView, Bundle bundle) {
            QLog.e("FeedsVideoRenderSurfaceBinding", 2, "HandleStopEvent super player stop");
            qFSVideoView.stop();
        }
    }

    public a() {
        HashMap hashMap = new HashMap();
        this.f85320b = hashMap;
        hashMap.put("start", new f());
        this.f85320b.put("stop", new g());
        this.f85320b.put("resume", new e());
        this.f85320b.put("pause", new b());
        this.f85320b.put("release", new d());
        this.f85320b.put(QCircleLiveFeedsPlayerEvent.EVENT_FIX_XY, new C0877a());
    }

    private boolean b() {
        if (this.f85319a == null) {
            return false;
        }
        return true;
    }

    public void a(@NonNull QFSVideoView qFSVideoView, @NonNull QCircleLiveFeedsPlayerEvent qCircleLiveFeedsPlayerEvent) {
        c cVar = this.f85320b.get(qCircleLiveFeedsPlayerEvent.getEventType());
        if (cVar == null) {
            QLog.e("FeedsVideoRenderSurfaceBinding", 2, "handlePlayerEvent handler is null");
        } else {
            cVar.a(qFSVideoView, qCircleLiveFeedsPlayerEvent.getParams());
        }
    }

    public boolean c(@NonNull QFSVideoView qFSVideoView) {
        if (!b()) {
            QLog.e("FeedsVideoRenderSurfaceBinding", 2, "resetSurface isFeedsVideoViewSurfaceValid is false");
            return false;
        }
        if (qFSVideoView.getSuperPlayer() == null) {
            QLog.e("FeedsVideoRenderSurfaceBinding", 2, "resetSurface videoView.getSuperPlayer() is null");
            return false;
        }
        qFSVideoView.getSuperPlayer().setSurface(this.f85319a);
        qFSVideoView.getSuperPlayer().setXYaxis(2);
        return true;
    }

    public boolean d(@NonNull QFSVideoView qFSVideoView, @NonNull Surface surface) {
        if (qFSVideoView.getSuperPlayer() == null) {
            QLog.e("FeedsVideoRenderSurfaceBinding", 2, "switchSurface videoView.getSuperPlayer() is null");
            return false;
        }
        if (qFSVideoView.getSuperPlayer().getVideoView() == null) {
            QLog.e("FeedsVideoRenderSurfaceBinding", 2, "switchSurface videoView.getSuperPlayer().getVideoView() is null");
            return false;
        }
        this.f85319a = qFSVideoView.getSuperPlayer().getVideoView().getSurface();
        qFSVideoView.getSuperPlayer().setSurface(surface);
        qFSVideoView.getSuperPlayer().setXYaxis(2);
        return true;
    }
}
