package com.tencent.biz.qqcircle.immersive.views.mixfeed.piclayerpage;

import android.content.res.Configuration;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.cm;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes4.dex */
public class m extends cm<FeedCloudMeta$StFeed> {
    public void e() {
        Iterator<String> it = this.f86069d.keySet().iterator();
        while (it.hasNext()) {
            QFSBaseFeedChildPresenter qFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter) this.f86069d.get(it.next());
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.K0();
            }
        }
    }

    public void f(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        Iterator<String> it = this.f86069d.keySet().iterator();
        while (it.hasNext()) {
            QFSBaseFeedChildPresenter qFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter) this.f86069d.get(it.next());
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.V0(new e30.b(feedCloudMeta$StFeed));
                qFSBaseFeedChildPresenter.L0(feedCloudMeta$StFeed, i3);
            }
        }
    }

    public void g(Configuration configuration) {
        Iterator<String> it = this.f86069d.keySet().iterator();
        while (it.hasNext()) {
            QFSBaseFeedChildPresenter qFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter) this.f86069d.get(it.next());
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.T0(new com.tencent.biz.qqcircle.immersive.feed.event.k(configuration));
            }
        }
    }

    public void h() {
        Iterator<String> it = this.f86069d.keySet().iterator();
        while (it.hasNext()) {
            QFSBaseFeedChildPresenter qFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter) this.f86069d.get(it.next());
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.M0();
            }
        }
    }

    public void i(View view) {
        Iterator<String> it = this.f86069d.keySet().iterator();
        while (it.hasNext()) {
            QFSBaseFeedChildPresenter qFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter) this.f86069d.get(it.next());
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.N0(view);
            }
        }
    }

    public void j() {
        Iterator<String> it = this.f86069d.keySet().iterator();
        while (it.hasNext()) {
            QFSBaseFeedChildPresenter qFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter) this.f86069d.get(it.next());
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.onDestroy();
            }
        }
    }

    public void k() {
        Iterator<String> it = this.f86069d.keySet().iterator();
        while (it.hasNext()) {
            QFSBaseFeedChildPresenter qFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter) this.f86069d.get(it.next());
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.onPaused(null);
            }
        }
    }

    public void l() {
        Iterator<String> it = this.f86069d.keySet().iterator();
        while (it.hasNext()) {
            QFSBaseFeedChildPresenter qFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter) this.f86069d.get(it.next());
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.onResumed(null);
            }
        }
    }

    public void m() {
        Iterator<String> it = this.f86069d.keySet().iterator();
        while (it.hasNext()) {
            QFSBaseFeedChildPresenter qFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter) this.f86069d.get(it.next());
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.onStop(null);
            }
        }
    }

    public void n(ViewGroup viewGroup) {
        Iterator<String> it = this.f86069d.keySet().iterator();
        while (it.hasNext()) {
            QFSBaseFeedChildPresenter qFSBaseFeedChildPresenter = (QFSBaseFeedChildPresenter) this.f86069d.get(it.next());
            if (qFSBaseFeedChildPresenter != null) {
                qFSBaseFeedChildPresenter.X0(viewGroup);
            }
        }
    }
}
