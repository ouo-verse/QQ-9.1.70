package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.so;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0013B\u0015\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012\u00a2\u0006\u0004\b+\u0010,J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u001c\u0010\u0011\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010 \u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/g;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/h;", "", "from", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/h;", "callback", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "", IProfileCardConst.KEY_FROM_TYPE, "o", "code", DomainData.DOMAIN_NAME, "i", "errorCode", tl.h.F, "loadLibrary", "", "a", "[Ljava/lang/String;", "echrV8SoNames", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/b;", "b", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/b;", "violaCdnSoLoader", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/d;", "c", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/d;", "violaSoLoader", "", "d", "Z", "downloadV8SoSuccess", "e", "loadingSo", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/i;", "f", "Ljava/util/concurrent/CopyOnWriteArrayList;", "requestingList", "g", "loadSuccess", "<init>", "([Ljava/lang/String;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class g implements h {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String[] echrV8SoNames;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.so.b violaCdnSoLoader;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.so.d violaSoLoader;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile boolean downloadV8SoSuccess;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile boolean loadingSo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CopyOnWriteArrayList<i> requestingList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private volatile boolean loadSuccess;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/g$b", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/h;", "", IProfileCardConst.KEY_FROM_TYPE, "", "b", "code", "onError", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.qqecommerce.biz.hr.api.h {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f262749b;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/g$b$a", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/h;", "", IProfileCardConst.KEY_FROM_TYPE, "", "b", "code", "onError", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a implements com.tencent.mobileqq.qqecommerce.biz.hr.api.h {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ g f262750a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f262751b;

            a(g gVar, String str) {
                this.f262750a = gVar;
                this.f262751b = str;
            }

            @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.h
            public void b(int fromType) {
                this.f262750a.o(fromType);
            }

            @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.h
            public void onError(int code) {
                try {
                    code = Integer.parseInt(code + this.f262751b);
                } catch (Exception unused) {
                    QLog.e("ViolaSoLoaderV2", 1, "parse errorCode error,errorCode: " + this.f262751b + ", code: " + code);
                }
                this.f262750a.n(code);
            }
        }

        b(String str) {
            this.f262749b = str;
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.h
        public void onError(int code) {
            QLog.e("ViolaSoLoaderV2", 1, "load viola v8 error, start load from cdn, " + code + ",start load from cdn");
            String valueOf = String.valueOf(code);
            g gVar = g.this;
            gVar.m(this.f262749b, new a(gVar, valueOf));
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.h
        public void b(int fromType) {
            QLog.e("ViolaSoLoaderV2", 1, "finish load viola v8");
            g.this.o(fromType);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/g$c", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/h;", "", IProfileCardConst.KEY_FROM_TYPE, "", "b", "code", "onError", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.qqecommerce.biz.hr.api.h {
        c() {
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.h
        public void b(int fromType) {
            g.this.o(fromType);
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.h
        public void onError(int code) {
            g.this.n(code);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/g$d", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/h;", "", IProfileCardConst.KEY_FROM_TYPE, "", "b", "code", "onError", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements com.tencent.mobileqq.qqecommerce.biz.hr.api.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqecommerce.biz.hr.api.h f262753a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ g f262754b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f262755c;

        d(com.tencent.mobileqq.qqecommerce.biz.hr.api.h hVar, g gVar, String str) {
            this.f262753a = hVar;
            this.f262754b = gVar;
            this.f262755c = str;
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.h
        public void onError(int code) {
            if (this.f262754b.downloadV8SoSuccess) {
                QLog.e("ViolaSoLoaderV2", 1, "load from cdn error, but download so success, start reload so");
                this.f262754b.violaSoLoader.loadLibrary(this.f262755c, this.f262753a);
                return;
            }
            QLog.e("ViolaSoLoaderV2", 1, "load from cdn error, download so error or not finish.");
            com.tencent.mobileqq.qqecommerce.biz.hr.api.h hVar = this.f262753a;
            if (hVar != null) {
                hVar.onError(code);
            }
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.h
        public void b(int fromType) {
            QLog.e("ViolaSoLoaderV2", 1, "library from cdn success");
            com.tencent.mobileqq.qqecommerce.biz.hr.api.h hVar = this.f262753a;
            if (hVar != null) {
                hVar.b(fromType);
            }
        }
    }

    public g(String[] echrV8SoNames) {
        Intrinsics.checkNotNullParameter(echrV8SoNames, "echrV8SoNames");
        this.echrV8SoNames = echrV8SoNames;
        this.violaSoLoader = new com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.so.d(echrV8SoNames);
        this.requestingList = new CopyOnWriteArrayList<>();
    }

    private final void h(int errorCode) {
        Iterator<i> it = this.requestingList.iterator();
        while (it.hasNext()) {
            it.next().a(errorCode);
        }
        this.requestingList.clear();
    }

    private final void i(int fromType) {
        Iterator<i> it = this.requestingList.iterator();
        while (it.hasNext()) {
            it.next().b(fromType);
        }
        this.requestingList.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(g this$0, int i3, LoadExtResult loadExtResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            this$0.downloadV8SoSuccess = true;
            QLog.e("ViolaSoLoaderV2", 1, "download viola v8 success");
            return;
        }
        this$0.downloadV8SoSuccess = false;
        QLog.e("ViolaSoLoaderV2", 1, "download viola v8 error: " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(g this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (SoLoadManager.getInstance().isExist(this$0.echrV8SoNames)) {
                QLog.e("ViolaSoLoaderV2", 1, "so exist start load lib");
                this$0.violaSoLoader.loadLibrary(str, new b(str));
            } else {
                QLog.e("ViolaSoLoaderV2", 1, "so not exist, start load from cdn");
                this$0.m(str, new c());
                this$0.j();
            }
        } catch (Throwable th5) {
            QLog.e("ViolaSoLoaderV2", 1, "[ViolaSoLoaderV2.loadLibrary]: " + th5.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(String from, com.tencent.mobileqq.qqecommerce.biz.hr.api.h callback) {
        if (this.violaCdnSoLoader == null) {
            this.violaCdnSoLoader = new com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.so.b();
        }
        com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.so.b bVar = this.violaCdnSoLoader;
        if (bVar != null) {
            bVar.loadLibrary(from, new d(callback, this, from));
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.so.h
    public void loadLibrary(final String from, com.tencent.mobileqq.qqecommerce.biz.hr.api.h callback) {
        if (this.loadSuccess) {
            if (callback != null) {
                callback.b(0);
            }
        } else {
            this.requestingList.add(new i(from, callback));
            if (this.loadingSo) {
                return;
            }
            this.loadingSo = true;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.so.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.l(g.this, from);
                }
            }, 128, null, true);
        }
    }

    private final void j() {
        QLog.e("ViolaSoLoaderV2", 1, "start download v8 so");
        SoLoadManager.getInstance().download(this.echrV8SoNames, new OnLoadListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.so.f
            @Override // com.tencent.mobileqq.soload.biz.OnLoadListener
            public final void onLoadResult(int i3, LoadExtResult loadExtResult) {
                g.k(g.this, i3, loadExtResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(int code) {
        this.loadingSo = false;
        this.loadSuccess = false;
        h(code);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(int fromType) {
        this.loadingSo = false;
        this.loadSuccess = true;
        i(fromType);
    }
}
