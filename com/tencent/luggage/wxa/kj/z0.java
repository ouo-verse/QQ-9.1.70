package com.tencent.luggage.wxa.kj;

import android.content.res.Configuration;
import android.view.View;
import com.tencent.luggage.wxa.oj.c;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public class z0 implements com.tencent.luggage.wxa.mj.i, com.tencent.luggage.wxa.mj.c {

    /* renamed from: a, reason: collision with root package name */
    public final v f132603a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.oj.c f132604b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            z0.this.f132604b.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.oj.a f132606a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ z0 f132607b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Configuration f132608c;

        public b(com.tencent.luggage.wxa.oj.a aVar, z0 z0Var, Configuration configuration) {
            this.f132606a = aVar;
            this.f132607b = z0Var;
            this.f132608c = configuration;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f132606a.a(this.f132607b.f132603a.D().shouldInLargeScreenCompatMode(), this.f132608c.orientation);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            z0.this.f132604b.b();
        }
    }

    public z0(v page, com.tencent.luggage.wxa.oj.c H) {
        Intrinsics.checkNotNullParameter(page, "page");
        Intrinsics.checkNotNullParameter(H, "H");
        this.f132603a = page;
        this.f132604b = H;
    }

    @Override // com.tencent.luggage.wxa.mj.i
    public boolean c() {
        if (this.f132604b.getCurrentState() == c.b.HIDDEN) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.mj.c
    public void onBackground() {
        this.f132604b.c();
    }

    @Override // com.tencent.luggage.wxa.mj.c
    public void onConfigurationChanged(Configuration newConfig) {
        com.tencent.luggage.wxa.oj.a aVar;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        com.tencent.luggage.wxa.oj.c cVar = this.f132604b;
        if (cVar instanceof com.tencent.luggage.wxa.oj.a) {
            aVar = (com.tencent.luggage.wxa.oj.a) cVar;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            this.f132603a.c(new b(aVar, this, newConfig));
        }
    }

    @Override // com.tencent.luggage.wxa.mj.c
    public void onForeground() {
        com.tencent.luggage.wxa.oj.a aVar;
        this.f132604b.d();
        com.tencent.luggage.wxa.oj.c cVar = this.f132604b;
        if (cVar instanceof com.tencent.luggage.wxa.oj.a) {
            aVar = (com.tencent.luggage.wxa.oj.a) cVar;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.a(this.f132603a.D().shouldInLargeScreenCompatMode(), this.f132603a.getContext().getResources().getConfiguration().orientation);
        }
    }

    @Override // com.tencent.luggage.wxa.mj.i
    public void a() {
        v vVar = this.f132603a;
        if (com.tencent.luggage.wxa.tn.c0.b()) {
            this.f132604b.a();
            return;
        }
        View contentView = vVar.getContentView();
        if (contentView != null) {
            contentView.post(new a());
        }
    }

    @Override // com.tencent.luggage.wxa.mj.i
    public void b() {
        v vVar = this.f132603a;
        if (com.tencent.luggage.wxa.tn.c0.b()) {
            this.f132604b.b();
            return;
        }
        View contentView = vVar.getContentView();
        if (contentView != null) {
            contentView.post(new c());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public z0(v page) {
        this(page, r0);
        Intrinsics.checkNotNullParameter(page, "page");
        com.tencent.luggage.wxa.oj.c b16 = c.a.CC.b(page);
        Intrinsics.checkNotNullExpressionValue(b16, "createHelper(page)");
    }

    @Override // com.tencent.luggage.wxa.mj.c
    public void onDestroy() {
    }
}
