package e80;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.cm;
import com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus;
import java.io.Serializable;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j<T> extends cm<T> implements f, h {
    @Override // e80.h
    public void H() {
        Iterator<QFSBaseFeedChildPresenter<T>> it = this.f86069d.values().iterator();
        while (it.hasNext()) {
            IRFWLayerScrollerStatus iRFWLayerScrollerStatus = (QFSBaseFeedChildPresenter) ((QFSBaseFeedChildPresenter<T>) it.next());
            if (iRFWLayerScrollerStatus instanceof h) {
                ((h) iRFWLayerScrollerStatus).H();
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void a() {
        Iterator<QFSBaseFeedChildPresenter<T>> it = this.f86069d.values().iterator();
        while (it.hasNext()) {
            IRFWLayerScrollerStatus iRFWLayerScrollerStatus = (QFSBaseFeedChildPresenter) ((QFSBaseFeedChildPresenter<T>) it.next());
            if (iRFWLayerScrollerStatus instanceof com.tencent.biz.qqcircle.immersive.scrollers.a) {
                ((com.tencent.biz.qqcircle.immersive.scrollers.a) iRFWLayerScrollerStatus).a();
            }
        }
    }

    public void e() {
        for (QFSBaseFeedChildPresenter<T> qFSBaseFeedChildPresenter : this.f86069d.values()) {
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.K0();
            }
        }
    }

    @Override // e80.f
    public void e0() {
        Iterator<QFSBaseFeedChildPresenter<T>> it = this.f86069d.values().iterator();
        while (it.hasNext()) {
            IRFWLayerScrollerStatus iRFWLayerScrollerStatus = (QFSBaseFeedChildPresenter) ((QFSBaseFeedChildPresenter<T>) it.next());
            if (iRFWLayerScrollerStatus instanceof f) {
                ((f) iRFWLayerScrollerStatus).e0();
            }
        }
    }

    public void f(T t16, int i3) {
        for (QFSBaseFeedChildPresenter<T> qFSBaseFeedChildPresenter : this.f86069d.values()) {
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.L0(t16, i3);
            }
        }
    }

    public void g() {
        for (QFSBaseFeedChildPresenter<T> qFSBaseFeedChildPresenter : this.f86069d.values()) {
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.M0();
            }
        }
    }

    public void h(View view) {
        for (QFSBaseFeedChildPresenter<T> qFSBaseFeedChildPresenter : this.f86069d.values()) {
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.N0(view);
            }
        }
    }

    public void i(Serializable serializable) {
        for (QFSBaseFeedChildPresenter<T> qFSBaseFeedChildPresenter : this.f86069d.values()) {
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.U0((QCircleExtraTypeInfo) serializable);
            }
        }
    }

    @Override // e80.g
    public boolean isPlaying() {
        Iterator<QFSBaseFeedChildPresenter<T>> it = this.f86069d.values().iterator();
        while (it.hasNext()) {
            IRFWLayerScrollerStatus iRFWLayerScrollerStatus = (QFSBaseFeedChildPresenter) ((QFSBaseFeedChildPresenter<T>) it.next());
            if ((iRFWLayerScrollerStatus instanceof g) && ((g) iRFWLayerScrollerStatus).isPlaying()) {
                return true;
            }
        }
        return false;
    }

    public void j(e30.b bVar) {
        for (QFSBaseFeedChildPresenter<T> qFSBaseFeedChildPresenter : this.f86069d.values()) {
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.V0(bVar);
            }
        }
    }

    public void k(ViewGroup viewGroup) {
        for (QFSBaseFeedChildPresenter<T> qFSBaseFeedChildPresenter : this.f86069d.values()) {
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.X0(viewGroup);
            }
        }
    }

    @Override // e80.g, com.tencent.biz.qqcircle.immersive.scrollers.a
    @Deprecated
    public void pause() {
        Iterator<QFSBaseFeedChildPresenter<T>> it = this.f86069d.values().iterator();
        while (it.hasNext()) {
            IRFWLayerScrollerStatus iRFWLayerScrollerStatus = (QFSBaseFeedChildPresenter) ((QFSBaseFeedChildPresenter<T>) it.next());
            if (iRFWLayerScrollerStatus instanceof com.tencent.biz.qqcircle.immersive.scrollers.a) {
                ((com.tencent.biz.qqcircle.immersive.scrollers.a) iRFWLayerScrollerStatus).pause();
            }
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.scrollers.a
    public void play() {
        Iterator<QFSBaseFeedChildPresenter<T>> it = this.f86069d.values().iterator();
        while (it.hasNext()) {
            IRFWLayerScrollerStatus iRFWLayerScrollerStatus = (QFSBaseFeedChildPresenter) ((QFSBaseFeedChildPresenter<T>) it.next());
            if (iRFWLayerScrollerStatus instanceof com.tencent.biz.qqcircle.immersive.scrollers.a) {
                ((com.tencent.biz.qqcircle.immersive.scrollers.a) iRFWLayerScrollerStatus).play();
            }
        }
    }

    @Override // e80.g
    public void stop() {
        Iterator<QFSBaseFeedChildPresenter<T>> it = this.f86069d.values().iterator();
        while (it.hasNext()) {
            IRFWLayerScrollerStatus iRFWLayerScrollerStatus = (QFSBaseFeedChildPresenter) ((QFSBaseFeedChildPresenter<T>) it.next());
            if (iRFWLayerScrollerStatus instanceof g) {
                ((g) iRFWLayerScrollerStatus).stop();
            }
        }
    }
}
