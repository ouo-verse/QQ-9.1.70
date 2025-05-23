package com.qzone.reborn.feedx.widget.header;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.qzone.proxy.covercomponent.CoverComponentProxy;
import com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer;
import com.tencent.component.hdasync.HdAsync;
import com.tencent.component.hdasync.HdAsyncAction;
import com.tencent.component.hdasync.HdAsyncResult;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bh extends ay {
    private Runnable G;
    private long H;
    private com.qzone.reborn.feedx.viewmodel.w I;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a extends HdAsyncAction {
        a(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            Handler f16 = bh.this.f();
            if (f16 != null && bh.this.G != null) {
                f16.removeCallbacks(bh.this.G);
                f16.postDelayed(bh.this.G, bh.this.H);
            }
            return doNext(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b extends HdAsyncAction {
        b(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.component.hdasync.HdAsyncAction, com.tencent.component.hdasync.BaseAction
        public HdAsyncResult call(Object obj) {
            bh.this.H = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZONECOVER, QzoneConfig.SECONDARY_HOMEPAGE_GUEST_DEFAULT_COVER_SHOW_DELAY_MS, 3000);
            if (CoverComponentProxy.f50099g.getServiceInterface().getCoverFromCache(bh.this.w()) == null) {
                return doNext(true);
            }
            return doNext(false);
        }
    }

    public bh(View view) {
        super(view);
        this.G = null;
        this.H = 3000L;
    }

    private com.qzone.reborn.feedx.viewmodel.w H() {
        if (this.I == null) {
            this.I = (com.qzone.reborn.feedx.viewmodel.w) k(com.qzone.reborn.feedx.viewmodel.w.class);
        }
        return this.I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        IQZoneCoverContainer iQZoneCoverContainer = this.f56219i;
        if (iQZoneCoverContainer != null) {
            iQZoneCoverContainer.setEmptyCover();
        }
    }

    public void J() {
        Handler f16 = f();
        Runnable runnable = this.G;
        if (runnable == null || f16 == null) {
            return;
        }
        f16.removeCallbacks(runnable);
    }

    public void K() {
        try {
            if (this.G == null) {
                this.G = new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.bg
                    @Override // java.lang.Runnable
                    public final void run() {
                        bh.this.I();
                    }
                };
            }
            HdAsync.with(this).then(new b(QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.NormalThread))).then(new a(Looper.getMainLooper())).call();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public View e() {
        return this.f56217f;
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QzoneUserHomeCoverElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.ay, com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onDestroy() {
        super.onDestroy();
        J();
        this.G = null;
    }

    @Override // com.qzone.reborn.feedx.widget.header.ay, com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        if (message.what == 1000024) {
            J();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.ay
    int t() {
        return 2;
    }

    @Override // com.qzone.reborn.feedx.widget.header.ay
    tc.b v() {
        return (tc.b) k(com.qzone.reborn.feedx.viewmodel.w.class);
    }

    @Override // com.qzone.reborn.feedx.widget.header.ay
    long w() {
        return H().getMUin();
    }

    @Override // com.qzone.reborn.feedx.widget.header.ay
    public void x() {
        super.x();
        if (H().M2()) {
            return;
        }
        K();
    }
}
