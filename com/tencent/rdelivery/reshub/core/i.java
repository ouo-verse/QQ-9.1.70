package com.tencent.rdelivery.reshub.core;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.rdelivery.RDelivery;
import com.tencent.rdelivery.data.RDeliveryData;
import com.tencent.rdelivery.reshub.api.i;
import com.tencent.rdelivery.reshub.api.r;
import com.tencent.rdelivery.reshub.asset.PresetRes;
import com.tencent.rdelivery.reshub.download.DownloadingTaskManager;
import com.tencent.rdelivery.reshub.loader.AutoPreloadLoader;
import com.tencent.rdelivery.reshub.loader.RemoteLoadInterceptManager;
import com.tencent.rdelivery.reshub.local.LocalResConfigManager;
import com.tencent.rdelivery.reshub.util.PendingDeleteManager;
import com.tencent.rdelivery.reshub.util.ResRefreshManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010W\u001a\u00020U\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\bX\u0010YJ \u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\"\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\"\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\rH\u0016J\"\u0010\u0015\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\u0017\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001e\u0010\u001b\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u00182\u0006\u0010\u0003\u001a\u00020\u001aH\u0016J\u001a\u0010\u001c\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010 \u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010#\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010\u00132\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010&\u001a\u0004\u0018\u00010\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u001a\u0010'\u001a\u0004\u0018\u00010\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u000e\u0010(\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020)H\u0016J\u001a\u0010.\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010\bH\u0016J\n\u00100\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00101\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\bH\u0016J\b\u00102\u001a\u00020\u0010H\u0016JC\u0010:\u001a\u0002092\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u00104\u001a\u0002032\n\b\u0002\u00106\u001a\u0004\u0018\u0001052\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u00108\u001a\u0004\u0018\u000107H\u0000\u00a2\u0006\u0004\b:\u0010;R\u0014\u0010>\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010=R\u0014\u0010A\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010@R\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010CR\u0018\u0010F\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010ER\u001a\u0010K\u001a\u00020G8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\f\u0010H\u001a\u0004\bI\u0010JR\u0014\u0010N\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010MR\u0014\u0010Q\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010PR\u0014\u0010T\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010SR\u0014\u0010W\u001a\u00020U8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u0010V\u00a8\u0006Z"}, d2 = {"Lcom/tencent/rdelivery/reshub/core/i;", "Lcom/tencent/rdelivery/reshub/api/i;", "Liz3/e;", "listener", "Lcom/tencent/rdelivery/reshub/api/r;", QQBrowserActivity.APP_PARAM, "", "u", "", "resId", "Lcom/tencent/rdelivery/reshub/api/h;", "callback", "e", "", "forceRequestRemoteConfig", "j", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "validateResFile", "Lcom/tencent/rdelivery/reshub/api/g;", "d", "a", "l", "g", "", "keys", "Liz3/l;", "f", "y", WadlProxyConsts.SCENE_ID, "Lcom/tencent/rdelivery/reshub/api/b;", "batchCallback", "c", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, tl.h.F, "deleteAll", "t", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "v", "Lcom/tencent/rdelivery/reshub/api/f;", "interceptor", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "key", "value", DomainData.DOMAIN_NAME, "Lcom/tencent/rdelivery/RDelivery;", "i", "getLastRequestServerTime", "k", "", "mode", "Lkz3/a;", "batchContext", "Ljz3/e;", "presetResConfig", "Lcom/tencent/rdelivery/reshub/core/k;", "w", "(Ljava/lang/String;ILkz3/a;ZLjz3/e;)Lcom/tencent/rdelivery/reshub/core/k;", "Lcom/tencent/rdelivery/reshub/local/LocalResConfigManager;", "Lcom/tencent/rdelivery/reshub/local/LocalResConfigManager;", "localRes", "Lcom/tencent/rdelivery/reshub/asset/PresetRes;", "Lcom/tencent/rdelivery/reshub/asset/PresetRes;", "presetRes", "Lcom/tencent/rdelivery/reshub/core/ResLoader;", "Lcom/tencent/rdelivery/reshub/core/ResLoader;", "loader", "Lcom/tencent/rdelivery/RDelivery;", "rDelivery", "Lcom/tencent/rdelivery/reshub/loader/RemoteLoadInterceptManager;", "Lcom/tencent/rdelivery/reshub/loader/RemoteLoadInterceptManager;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/rdelivery/reshub/loader/RemoteLoadInterceptManager;", "loadInterceptManager", "Lcom/tencent/rdelivery/reshub/local/c;", "Lcom/tencent/rdelivery/reshub/local/c;", "localResValidator", "Lcom/tencent/rdelivery/reshub/util/ResRefreshManager;", "Lcom/tencent/rdelivery/reshub/util/ResRefreshManager;", "refreshManager", "Liz3/c;", "Liz3/c;", "dataChangeListener", "Lcom/tencent/rdelivery/reshub/core/a;", "Lcom/tencent/rdelivery/reshub/core/a;", "appInfo", "<init>", "(Lcom/tencent/rdelivery/reshub/core/a;Liz3/e;Lcom/tencent/rdelivery/reshub/api/r;)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class i implements com.tencent.rdelivery.reshub.api.i {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final LocalResConfigManager localRes;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final PresetRes presetRes;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ResLoader loader;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RDelivery rDelivery;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RemoteLoadInterceptManager loadInterceptManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.rdelivery.reshub.local.c localResValidator;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final ResRefreshManager refreshManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final iz3.c dataChangeListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.rdelivery.reshub.core.a appInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/rdelivery/reshub/core/i$a", "Liz3/c;", "", "key", "Lcom/tencent/rdelivery/data/RDeliveryData;", "oldData", "newData", "", "a", "reshub_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes25.dex */
    public static final class a implements iz3.c {
        a() {
        }

        @Override // iz3.c
        public void a(@NotNull String key, @Nullable RDeliveryData oldData, @Nullable RDeliveryData newData) {
            Long l3;
            Intrinsics.checkParameterIsNotNull(key, "key");
            if (newData == null) {
                jz3.d.e("ResHub", "onDataChange detect delete key = " + key);
                com.tencent.rdelivery.reshub.api.g t16 = i.this.t(key);
                Long l16 = null;
                if (!(t16 instanceof jz3.e)) {
                    t16 = null;
                }
                jz3.e eVar = (jz3.e) t16;
                jz3.e n3 = i.this.localRes.n(key);
                if (n3 != null && n3.f411285z == 1) {
                    long j3 = n3.f411261b;
                    if (eVar == null || j3 != eVar.f411261b) {
                        i.this.localRes.y(key);
                        return;
                    }
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onDataChange detect delete key = ");
                sb5.append(key);
                sb5.append(", do nothing,");
                sb5.append("localVersion:");
                if (n3 != null) {
                    l3 = Long.valueOf(n3.f411261b);
                } else {
                    l3 = null;
                }
                sb5.append(l3);
                sb5.append(", presetVersion:");
                if (eVar != null) {
                    l16 = Long.valueOf(eVar.f411261b);
                }
                sb5.append(l16);
                jz3.d.e("ResHub", sb5.toString());
            }
        }
    }

    public i(@NotNull com.tencent.rdelivery.reshub.core.a appInfo, @Nullable iz3.e eVar, @Nullable r rVar) {
        Intrinsics.checkParameterIsNotNull(appInfo, "appInfo");
        this.appInfo = appInfo;
        LocalResConfigManager localResConfigManager = new LocalResConfigManager(appInfo);
        this.localRes = localResConfigManager;
        PresetRes presetRes = new PresetRes(appInfo, localResConfigManager);
        this.presetRes = presetRes;
        this.loader = new ResLoader(this, localResConfigManager, presetRes);
        this.loadInterceptManager = new RemoteLoadInterceptManager();
        this.localResValidator = new com.tencent.rdelivery.reshub.local.c(appInfo);
        this.refreshManager = new ResRefreshManager();
        this.dataChangeListener = new a();
        u(eVar, rVar);
    }

    private final void u(iz3.e listener, r extraParams) {
        if (this.rDelivery == null) {
            RDelivery e16 = lz3.g.f415854b.e(this.appInfo, listener, extraParams);
            this.rDelivery = e16;
            if (e16 != null) {
                new AutoPreloadLoader(e16, this, this.appInfo).g();
                e16.g(this.dataChangeListener);
            }
        }
    }

    public static /* synthetic */ k x(i iVar, String str, int i3, kz3.a aVar, boolean z16, jz3.e eVar, int i16, Object obj) {
        kz3.a aVar2;
        jz3.e eVar2;
        if ((i16 & 2) != 0) {
            i3 = 1;
        }
        int i17 = i3;
        if ((i16 & 4) != 0) {
            aVar2 = null;
        } else {
            aVar2 = aVar;
        }
        if ((i16 & 8) != 0) {
            z16 = false;
        }
        boolean z17 = z16;
        if ((i16 & 16) != 0) {
            eVar2 = null;
        } else {
            eVar2 = eVar;
        }
        return iVar.w(str, i17, aVar2, z17, eVar2);
    }

    @Override // com.tencent.rdelivery.reshub.api.i
    public void a(@NotNull String resId, long taskId, @Nullable com.tencent.rdelivery.reshub.api.h callback) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        ResLoader.r(this.loader, resId, taskId, callback, null, 8, null);
    }

    @Override // com.tencent.rdelivery.reshub.api.i
    @Nullable
    public com.tencent.rdelivery.reshub.api.g b(@NotNull String resId, boolean validateResFile) {
        boolean isBlank;
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        isBlank = StringsKt__StringsJVMKt.isBlank(resId);
        if (isBlank) {
            return null;
        }
        k x16 = x(this, resId, 0, null, false, null, 30, null);
        this.presetRes.a(resId);
        jz3.e N = x16.N(validateResFile);
        if (N != null) {
            v(resId);
        }
        this.refreshManager.e(N);
        return N;
    }

    @Override // com.tencent.rdelivery.reshub.api.i
    public void c(long sceneId, @Nullable com.tencent.rdelivery.reshub.api.b batchCallback) {
        new com.tencent.rdelivery.reshub.loader.a(this.rDelivery, sceneId, batchCallback, this.loader).c();
    }

    @Override // com.tencent.rdelivery.reshub.api.i
    @Nullable
    public com.tencent.rdelivery.reshub.api.g d(@NotNull String resId, long taskId, boolean validateResFile) {
        boolean isBlank;
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        isBlank = StringsKt__StringsJVMKt.isBlank(resId);
        if (isBlank) {
            return null;
        }
        k x16 = x(this, resId, 4, null, false, null, 28, null);
        x16.M(taskId);
        this.presetRes.a(resId);
        return x16.N(validateResFile);
    }

    @Override // com.tencent.rdelivery.reshub.api.i
    public void deleteAll() {
        this.localRes.g();
        RDelivery rDelivery = this.rDelivery;
        if (rDelivery != null) {
            rDelivery.h();
        }
        PendingDeleteManager.f364584c.l();
    }

    @Override // com.tencent.rdelivery.reshub.api.i
    public void e(@NotNull String resId, @Nullable com.tencent.rdelivery.reshub.api.h callback) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        ResLoader.n(this.loader, resId, callback, null, 4, null);
    }

    @Override // com.tencent.rdelivery.reshub.api.i
    public void f(@NotNull List<String> keys, @NotNull iz3.l listener) {
        Intrinsics.checkParameterIsNotNull(keys, "keys");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        RDelivery rDelivery = this.rDelivery;
        if (rDelivery != null) {
            rDelivery.I(keys, listener);
        }
    }

    @Override // com.tencent.rdelivery.reshub.api.i
    public void g(@Nullable iz3.e listener) {
        RDelivery rDelivery = this.rDelivery;
        if (rDelivery != null) {
            rDelivery.G(listener);
        }
    }

    @Override // com.tencent.rdelivery.reshub.api.i
    public long getLastRequestServerTime(@NotNull String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        RDelivery rDelivery = this.rDelivery;
        if (rDelivery != null) {
            return rDelivery.v(key);
        }
        return -1L;
    }

    @Override // com.tencent.rdelivery.reshub.api.i
    public void h(@NotNull String resId, long taskId) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        this.localRes.i(resId, taskId);
    }

    @Override // com.tencent.rdelivery.reshub.api.i
    @Nullable
    /* renamed from: i, reason: from getter */
    public RDelivery getRDelivery() {
        return this.rDelivery;
    }

    @Override // com.tencent.rdelivery.reshub.api.i
    public void j(@NotNull String resId, @Nullable com.tencent.rdelivery.reshub.api.h callback, boolean forceRequestRemoteConfig) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        this.loader.o(resId, callback, null, forceRequestRemoteConfig);
    }

    @Override // com.tencent.rdelivery.reshub.api.i
    public long k() {
        RDelivery rDelivery = this.rDelivery;
        if (rDelivery != null) {
            return rDelivery.u();
        }
        return -1L;
    }

    @Override // com.tencent.rdelivery.reshub.api.i
    @Nullable
    public com.tencent.rdelivery.reshub.api.g l(@NotNull String resId) {
        RDeliveryData z16;
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        RDelivery rDelivery = this.rDelivery;
        if (rDelivery != null && (z16 = RDelivery.z(rDelivery, resId, null, true, 2, null)) != null) {
            return lz3.h.b(z16);
        }
        return null;
    }

    @Override // com.tencent.rdelivery.reshub.api.i
    public void m(@NotNull String resId) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        this.localRes.h(resId);
    }

    @Override // com.tencent.rdelivery.reshub.api.i
    public void n(@NotNull String key, @Nullable String value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        RDelivery rDelivery = this.rDelivery;
        if (rDelivery != null) {
            rDelivery.K(key, value);
        }
    }

    @Override // com.tencent.rdelivery.reshub.api.i
    public boolean o(@NotNull String resId) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        return DownloadingTaskManager.f364485b.b(resId);
    }

    @Override // com.tencent.rdelivery.reshub.api.i
    public void p(@NotNull String resId, @Nullable com.tencent.rdelivery.reshub.api.h hVar) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        i.a.d(this, resId, hVar);
    }

    @Override // com.tencent.rdelivery.reshub.api.i
    @Nullable
    public com.tencent.rdelivery.reshub.api.g q(@NotNull String resId, boolean validateResFile) {
        boolean isBlank;
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        isBlank = StringsKt__StringsJVMKt.isBlank(resId);
        if (isBlank) {
            return null;
        }
        k x16 = x(this, resId, 2, null, false, null, 28, null);
        this.presetRes.a(resId);
        jz3.e N = x16.N(validateResFile);
        this.refreshManager.e(N);
        return N;
    }

    @NotNull
    /* renamed from: s, reason: from getter */
    public final RemoteLoadInterceptManager getLoadInterceptManager() {
        return this.loadInterceptManager;
    }

    @Nullable
    public com.tencent.rdelivery.reshub.api.g t(@NotNull String resId) {
        boolean isBlank;
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        isBlank = StringsKt__StringsJVMKt.isBlank(resId);
        if (isBlank) {
            return null;
        }
        return this.presetRes.c(resId);
    }

    public final void v(@NotNull String resId) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        this.localRes.t(resId);
    }

    @NotNull
    public final k w(@NotNull String resId, int mode, @Nullable kz3.a batchContext, boolean forceRequestRemoteConfig, @Nullable jz3.e presetResConfig) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        k kVar = new k(this.appInfo, resId, this.localRes, this.refreshManager, batchContext, presetResConfig);
        kVar.C();
        kVar.K(mode);
        kVar.L(this.rDelivery);
        kVar.I(forceRequestRemoteConfig);
        return kVar;
    }

    public void y(@NotNull String resId, @Nullable com.tencent.rdelivery.reshub.api.h callback) {
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        this.loader.u(resId, callback);
    }

    public void z(@NotNull com.tencent.rdelivery.reshub.api.f interceptor) {
        Intrinsics.checkParameterIsNotNull(interceptor, "interceptor");
        this.loadInterceptManager.d(interceptor);
    }
}
