package com.tencent.biz.qqcircle.tedgers2.datapool;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.tedgers2.bean.QFSEdgeItem;
import com.tencent.biz.qqcircle.tedgers2.datapool.loader.DetailItemLoader;
import com.tencent.biz.qqcircle.tedgers2.datapool.loader.RawItemLoader;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.List;

/* loaded from: classes5.dex */
public class DataPoolLoaderManager extends dc0.a {

    /* renamed from: c, reason: collision with root package name */
    private final RawItemLoader f92474c;

    /* renamed from: d, reason: collision with root package name */
    private final DetailItemLoader f92475d;

    /* renamed from: e, reason: collision with root package name */
    private DataPoolConfig f92476e;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f92477f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f92478g;

    /* renamed from: h, reason: collision with root package name */
    private final Handler.Callback f92479h;

    /* renamed from: i, reason: collision with root package name */
    private final com.tencent.biz.qqcircle.tedgers2.datapool.loader.d f92480i;

    /* renamed from: com.tencent.biz.qqcircle.tedgers2.datapool.DataPoolLoaderManager$4, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f92481d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f92482e;
        final /* synthetic */ DataPoolLoaderManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.f92475d.B(this.f92481d, this.f92482e);
        }
    }

    /* renamed from: com.tencent.biz.qqcircle.tedgers2.datapool.DataPoolLoaderManager$5, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass5 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f92483d;
        final /* synthetic */ DataPoolLoaderManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.f92475d.E(this.f92483d);
        }
    }

    /* loaded from: classes5.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                DataPoolLoaderManager.this.t();
                return true;
            }
            if (i3 == 2) {
                DataPoolLoaderManager.this.s();
                return true;
            }
            if (i3 == 3) {
                DataPoolLoaderManager.this.r();
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    class b implements com.tencent.biz.qqcircle.tedgers2.datapool.loader.d {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.tedgers2.datapool.loader.d
        public List<QFSEdgeItem> a(int i3) {
            ((dc0.a) DataPoolLoaderManager.this).f393528b.e("DP-LoaderManager", "[ILoaderProxy]  [getRawItemList]  | size = " + i3);
            if (DataPoolLoaderManager.this.f92474c != null) {
                return DataPoolLoaderManager.this.f92474c.z(i3);
            }
            return null;
        }

        @Override // com.tencent.biz.qqcircle.tedgers2.datapool.loader.d
        public void b(List<QFSEdgeItem> list) {
            int size;
            dc0.c cVar = ((dc0.a) DataPoolLoaderManager.this).f393528b;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[ILoaderProxy]  [removeRawItemList]  | list.size = ");
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            sb5.append(size);
            cVar.e("DP-LoaderManager", sb5.toString());
            if (DataPoolLoaderManager.this.f92474c != null) {
                DataPoolLoaderManager.this.f92474c.D(list);
            }
        }
    }

    public DataPoolLoaderManager(dc0.b bVar, DataPoolConfig dataPoolConfig) {
        super(bVar);
        a aVar = new a();
        this.f92479h = aVar;
        b bVar2 = new b();
        this.f92480i = bVar2;
        this.f92476e = dataPoolConfig;
        Handler createNewThreadHandler = RFWThreadManager.createNewThreadHandler("THREAD_DataPool", 0, aVar);
        this.f92477f = createNewThreadHandler;
        this.f92474c = new RawItemLoader(bVar, dataPoolConfig, createNewThreadHandler, bVar2);
        this.f92475d = new DetailItemLoader(bVar, dataPoolConfig, createNewThreadHandler, bVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.f92478g) {
            this.f393528b.e("DP-LoaderManager", "[handleDetailItemLoopValidCheck] mIsCloseLoadData true ");
        } else {
            this.f393528b.e("DP-LoaderManager", "[handleDetailItemLoopValidCheck] ");
            this.f92475d.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (this.f92478g) {
            this.f393528b.e("DP-LoaderManager", "[handleRawItemLoopValidCheck] mIsCloseLoadData true ");
        } else {
            this.f393528b.e("DP-LoaderManager", "[handleRawItemLoopValidCheck] ");
            this.f92474c.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.f393528b.e("DP-LoaderManager", "[handleStartLoad]  | mIsCloseLoadData = " + this.f92478g);
        if (this.f92478g) {
            return;
        }
        if (c() != null && !c().g()) {
            this.f393528b.e("DP-LoaderManager", "[handleStartLoad]  | getEnableTedgeRSRerank = false");
        } else {
            this.f92474c.l();
            this.f92475d.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u() {
        this.f393528b.a("DP-LoaderManager", "[clearPool]");
        this.f92478g = true;
        this.f92474c.e();
        this.f92475d.e();
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_tedge_data_pool_enable_auto_release_thread", true)) {
            try {
                this.f92477f.removeCallbacksAndMessages(null);
                this.f92477f.getLooper().quitSafely();
            } catch (Exception e16) {
                this.f393528b.a("DP-LoaderManager", "[clearPool] error:" + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v() {
        this.f393528b.a("DP-LoaderManager", "[restart]");
        this.f92478g = false;
        this.f92474c.E();
        this.f92475d.G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w() {
        this.f393528b.a("DP-LoaderManager", "[stop]");
        this.f92478g = true;
        this.f92474c.F();
        this.f92475d.H();
        this.f92477f.removeMessages(1);
    }

    public void A() {
        this.f92477f.post(new Runnable() { // from class: com.tencent.biz.qqcircle.tedgers2.datapool.b
            @Override // java.lang.Runnable
            public final void run() {
                DataPoolLoaderManager.this.w();
            }
        });
    }

    public void p() {
        this.f92477f.post(new Runnable() { // from class: com.tencent.biz.qqcircle.tedgers2.datapool.d
            @Override // java.lang.Runnable
            public final void run() {
                DataPoolLoaderManager.this.u();
            }
        });
    }

    public List<QFSEdgeItem> q(int i3, long j3) {
        return this.f92475d.z(i3, j3);
    }

    public void x(final List<QFSEdgeItem> list) {
        this.f92477f.post(new Runnable() { // from class: com.tencent.biz.qqcircle.tedgers2.datapool.DataPoolLoaderManager.6
            @Override // java.lang.Runnable
            public void run() {
                DataPoolLoaderManager.this.f92475d.F(list);
            }
        });
    }

    public void y() {
        this.f92477f.post(new Runnable() { // from class: com.tencent.biz.qqcircle.tedgers2.datapool.c
            @Override // java.lang.Runnable
            public final void run() {
                DataPoolLoaderManager.this.v();
            }
        });
    }

    public void z() {
        this.f92477f.post(new Runnable() { // from class: com.tencent.biz.qqcircle.tedgers2.datapool.DataPoolLoaderManager.3
            @Override // java.lang.Runnable
            public void run() {
                DataPoolLoaderManager.this.f92478g = false;
                DataPoolLoaderManager.this.f92477f.sendEmptyMessage(1);
            }
        });
    }
}
