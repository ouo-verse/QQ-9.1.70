package com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.so;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u000e\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u001c\u0010\u000f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u001c\u0010\u0012\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0014R\u0016\u0010\u001c\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0016\u0010\u001d\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0014R\u0018\u0010 \u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/ECHRASoLoaderManager;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/h;", "", "loaderType", "", "", "e", "(I)[Ljava/lang/String;", "d", "()[Ljava/lang/String;", "from", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/h;", "callback", "", "f", "g", "", tl.h.F, "loadLibrary", "a", "Z", "useV8SoLoader", "b", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/h;", "soLoader", "c", "I", "enableOnePageOneRuntime", "loadSuccess", "useViolaSoLoaderV2", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/g;", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/g;", "violaSoLoaderV2", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECHRASoLoaderManager implements h {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    private static final Lazy<ECHRASoLoaderManager> f262714i;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private volatile boolean useV8SoLoader;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private h soLoader;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile int loaderType = 4;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean enableOnePageOneRuntime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile boolean loadSuccess;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean useViolaSoLoaderV2;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private g violaSoLoaderV2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/ECHRASoLoaderManager$a;", "", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/ECHRASoLoaderManager;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/ECHRASoLoaderManager;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "SP_KEY_VIOLA_USE_V8", "Ljava/lang/String;", "TAG", "", "VIOLA_LEGACY_SO", "I", "VIOLA_SO_64_URL", "VIOLA_SO_URL", "VIOLA_USE_V8", "VIOLA_USE_V8_MULTI_INSTANCE", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.so.ECHRASoLoaderManager$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ECHRASoLoaderManager a() {
            return (ECHRASoLoaderManager) ECHRASoLoaderManager.f262714i.getValue();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/hr/api/impl/so/ECHRASoLoaderManager$b", "Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/h;", "", "code", "", "onError", IProfileCardConst.KEY_FROM_TYPE, "b", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.qqecommerce.biz.hr.api.h {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f262723b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqecommerce.biz.hr.api.h f262724c;

        b(String str, com.tencent.mobileqq.qqecommerce.biz.hr.api.h hVar) {
            this.f262723b = str;
            this.f262724c = hVar;
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.h
        public void b(int fromType) {
            ECHRASoLoaderManager.this.loadSuccess = true;
            QLog.e("ViolaSoLoaderManager", 1, "innerLoadLibrary finish, loader type: " + ECHRASoLoaderManager.this.loaderType + ", fromType: " + fromType + ", from: " + this.f262723b);
            com.tencent.mobileqq.qqecommerce.biz.hr.api.h hVar = this.f262724c;
            if (hVar != null) {
                hVar.b(fromType);
            }
        }

        @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.h
        public void onError(int code) {
            ECHRASoLoaderManager.this.loadSuccess = false;
            QLog.e("ViolaSoLoaderManager", 1, "innerLoadLibrary error, errorCode: " + code + ", loaderType: " + ECHRASoLoaderManager.this.loaderType + ", from: " + this.f262723b);
            com.tencent.mobileqq.qqecommerce.biz.hr.api.h hVar = this.f262724c;
            if (hVar != null) {
                hVar.onError(code);
            }
        }
    }

    static {
        Lazy<ECHRASoLoaderManager> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<ECHRASoLoaderManager>() { // from class: com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.so.ECHRASoLoaderManager$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECHRASoLoaderManager invoke() {
                return new ECHRASoLoaderManager();
            }
        });
        f262714i = lazy;
    }

    public ECHRASoLoaderManager() {
        this.enableOnePageOneRuntime = true;
        this.useV8SoLoader = this.loaderType != 0;
        this.soLoader = new d(e(this.loaderType));
        this.useViolaSoLoaderV2 = true;
        if (this.useV8SoLoader && this.useViolaSoLoaderV2) {
            this.violaSoLoaderV2 = new g(d());
        }
        this.enableOnePageOneRuntime = true;
    }

    private final String[] d() {
        return new String[]{"j2v8-android-arm64-v8a"};
    }

    private final String[] e(int loaderType) {
        return d();
    }

    private final void f(String from, com.tencent.mobileqq.qqecommerce.biz.hr.api.h callback) {
        if (this.loadSuccess) {
            if (callback != null) {
                callback.b(5);
                return;
            }
            return;
        }
        QLog.w("ViolaSoLoaderManager", 1, "start load library. from: " + from + ", loaderType: " + this.loaderType);
        h hVar = this.soLoader;
        if (hVar != null) {
            hVar.loadLibrary(from, new b(from, callback));
        }
    }

    private final void g(String from, com.tencent.mobileqq.qqecommerce.biz.hr.api.h callback) {
        g gVar = this.violaSoLoaderV2;
        if (gVar != null) {
            gVar.loadLibrary(from, callback);
        }
    }

    private final boolean h() {
        return this.useViolaSoLoaderV2 && this.violaSoLoaderV2 != null;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.impl.so.h
    public void loadLibrary(String from, com.tencent.mobileqq.qqecommerce.biz.hr.api.h callback) {
        if (h()) {
            g(from, callback);
        } else {
            f(from, callback);
        }
    }
}
