package com.tencent.rdelivery.reshub.core;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.rdelivery.RDelivery;
import com.tencent.rdelivery.reshub.local.LocalResConfigManager;
import com.tencent.rdelivery.reshub.report.ReportHelper;
import com.tencent.rdelivery.reshub.util.ResRefreshManager;
import com.tencent.rdelivery.reshub.util.m;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 q2\u00020\u0001:\u0001\u001aB?\u0012\u0006\u0010^\u001a\u00020[\u0012\u0006\u0010b\u001a\u00020\u0006\u0012\u0006\u0010f\u001a\u00020c\u0012\u0006\u0010l\u001a\u00020g\u0012\n\b\u0002\u0010p\u001a\u0004\u0018\u00010m\u0012\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\bs\u0010tJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\t\u001a\u00020\u0004J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fJ\"\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u001b\u001a\u00020\u000fJ\u001e\u0010\u001e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00060\u001d2\b\b\u0002\u0010\u001b\u001a\u00020\u000fJ\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002J\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010!\u001a\u00020\u0004R\"\u0010'\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010-\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00102\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010.\u001a\u0004\b/\u00100\"\u0004\b(\u00101R$\u00109\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010@\u001a\u00020:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010F\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\"\u0010I\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010.\u001a\u0004\bG\u00100\"\u0004\bH\u00101R\"\u0010L\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010.\u001a\u0004\bJ\u00100\"\u0004\bK\u00101R\u0016\u0010N\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010.R$\u0010U\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\b\"\u0010TR\u0014\u0010X\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010WR\u0016\u0010Z\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010.R\u0017\u0010^\u001a\u00020[8\u0006\u00a2\u0006\f\n\u0004\bG\u0010\\\u001a\u0004\bM\u0010]R\u0017\u0010b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b/\u0010_\u001a\u0004\b`\u0010aR\u0017\u0010f\u001a\u00020c8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010d\u001a\u0004\bY\u0010eR\u0017\u0010l\u001a\u00020g8\u0006\u00a2\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u0019\u0010p\u001a\u0004\u0018\u00010m8\u0006\u00a2\u0006\f\n\u0004\bR\u0010n\u001a\u0004\bP\u0010oR\u0019\u0010r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b)\u0010A\u001a\u0004\bq\u0010C\u00a8\u0006u"}, d2 = {"Lcom/tencent/rdelivery/reshub/core/k;", "Lcom/tencent/rdelivery/reshub/api/e;", "Ljz3/e;", DownloadInfo.spKey_Config, "", "G", "", "id", "o", BdhLogUtil.LogTag.Tag_Conn, "", "progressStatus", "Lcom/tencent/rdelivery/reshub/report/a;", "errorInfo", "B", "", "success", "", "time", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "e", "f", "d", "c", "b", "g", "a", "validateResFile", "N", "Lkotlin/Pair;", "D", "E", "P", tl.h.F, "J", "y", "()J", "M", "(J)V", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "I", "r", "()I", "K", "(I)V", "mode", "Z", DomainData.DOMAIN_NAME, "()Z", "(Z)V", "forceRequestRemoteConfig", "Lcom/tencent/rdelivery/RDelivery;", "Lcom/tencent/rdelivery/RDelivery;", "u", "()Lcom/tencent/rdelivery/RDelivery;", "L", "(Lcom/tencent/rdelivery/RDelivery;)V", "rDelivery", "Lcom/tencent/rdelivery/reshub/core/ResLoadRequestPriority;", "Lcom/tencent/rdelivery/reshub/core/ResLoadRequestPriority;", "t", "()Lcom/tencent/rdelivery/reshub/core/ResLoadRequestPriority;", "setPriority", "(Lcom/tencent/rdelivery/reshub/core/ResLoadRequestPriority;)V", "priority", "Ljz3/e;", "w", "()Ljz3/e;", "setResConfig", "(Ljz3/e;)V", "resConfig", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "H", "filePatchChecked", "k", UserInfo.SEX_FEMALE, "bigResPatchChecked", "i", "hasAlreadyReportComplete", "Lcom/tencent/rdelivery/reshub/api/h;", "j", "Lcom/tencent/rdelivery/reshub/api/h;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/rdelivery/reshub/api/h;", "(Lcom/tencent/rdelivery/reshub/api/h;)V", "innerCallback", "Lcom/tencent/rdelivery/reshub/report/h;", "Lcom/tencent/rdelivery/reshub/report/h;", "reportRecord", "l", "forceLowDownloadPriority", "Lcom/tencent/rdelivery/reshub/core/a;", "Lcom/tencent/rdelivery/reshub/core/a;", "()Lcom/tencent/rdelivery/reshub/core/a;", "appInfo", "Ljava/lang/String;", HippyTKDListViewAdapter.X, "()Ljava/lang/String;", "resId", "Lcom/tencent/rdelivery/reshub/local/LocalResConfigManager;", "Lcom/tencent/rdelivery/reshub/local/LocalResConfigManager;", "()Lcom/tencent/rdelivery/reshub/local/LocalResConfigManager;", "configMap", "Lcom/tencent/rdelivery/reshub/util/ResRefreshManager;", "p", "Lcom/tencent/rdelivery/reshub/util/ResRefreshManager;", "v", "()Lcom/tencent/rdelivery/reshub/util/ResRefreshManager;", "refreshManager", "Lkz3/a;", "Lkz3/a;", "()Lkz3/a;", "batchContext", ReportConstant.COSTREPORT_PREFIX, "presetResConfig", "<init>", "(Lcom/tencent/rdelivery/reshub/core/a;Ljava/lang/String;Lcom/tencent/rdelivery/reshub/local/LocalResConfigManager;Lcom/tencent/rdelivery/reshub/util/ResRefreshManager;Lkz3/a;Ljz3/e;)V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class k implements com.tencent.rdelivery.reshub.api.e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long taskId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int mode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean forceRequestRemoteConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RDelivery rDelivery;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ResLoadRequestPriority priority;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private jz3.e resConfig;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean filePatchChecked;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean bigResPatchChecked;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean hasAlreadyReportComplete;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.rdelivery.reshub.api.h innerCallback;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.rdelivery.reshub.report.h reportRecord;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean forceLowDownloadPriority;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a appInfo;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String resId;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LocalResConfigManager configMap;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ResRefreshManager refreshManager;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final kz3.a batchContext;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final jz3.e presetResConfig;

    public k(@NotNull a appInfo, @NotNull String resId, @NotNull LocalResConfigManager configMap, @NotNull ResRefreshManager refreshManager, @Nullable kz3.a aVar, @Nullable jz3.e eVar) {
        Intrinsics.checkParameterIsNotNull(appInfo, "appInfo");
        Intrinsics.checkParameterIsNotNull(resId, "resId");
        Intrinsics.checkParameterIsNotNull(configMap, "configMap");
        Intrinsics.checkParameterIsNotNull(refreshManager, "refreshManager");
        this.appInfo = appInfo;
        this.resId = resId;
        this.configMap = configMap;
        this.refreshManager = refreshManager;
        this.batchContext = aVar;
        this.presetResConfig = eVar;
        this.mode = 1;
        this.priority = ResLoadRequestPriority.Normal;
        this.reportRecord = new com.tencent.rdelivery.reshub.report.h();
    }

    public static /* synthetic */ void A(k kVar, boolean z16, com.tencent.rdelivery.reshub.report.a aVar, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            aVar = new com.tencent.rdelivery.reshub.report.a();
        }
        if ((i3 & 4) != 0) {
            j3 = com.tencent.rdelivery.reshub.report.d.a();
        }
        kVar.z(z16, aVar, j3);
    }

    public static /* synthetic */ jz3.e O(k kVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = true;
        }
        return kVar.N(z16);
    }

    public static /* synthetic */ String p(k kVar, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = kVar.resId;
        }
        return kVar.o(str);
    }

    public final void B(int progressStatus, @Nullable com.tencent.rdelivery.reshub.report.a errorInfo) {
        this.reportRecord.c(progressStatus, errorInfo);
    }

    public final void C() {
        this.reportRecord.d(com.tencent.rdelivery.reshub.report.d.a());
    }

    @NotNull
    public final Pair<jz3.e, String> D(boolean validateResFile) {
        jz3.e E = E();
        if (E == null) {
            return new Pair<>(null, "No Such Res(" + this.resId + ") In Local Storage.");
        }
        String c16 = new com.tencent.rdelivery.reshub.local.c(this.appInfo).c(E, validateResFile);
        if (c16 != null) {
            return new Pair<>(null, c16);
        }
        return new Pair<>(E, "");
    }

    @Nullable
    public final jz3.e E() {
        int i3 = this.mode;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 4) {
                    return this.configMap.m(this.resId);
                }
                jz3.e p16 = this.configMap.p(this.resId, this.taskId);
                if (p16 == null && ((p16 = this.configMap.n(this.resId)) == null || !Intrinsics.areEqual(p16.f411279t, String.valueOf(this.taskId)))) {
                    p16 = null;
                }
                if (p16 == null) {
                    jz3.e m3 = this.configMap.m(this.resId);
                    if (m3 == null || !Intrinsics.areEqual(m3.f411279t, String.valueOf(this.taskId))) {
                        return null;
                    }
                    return m3;
                }
                return p16;
            }
            return this.configMap.m(this.resId);
        }
        return this.configMap.n(this.resId);
    }

    public final void F(boolean z16) {
        this.bigResPatchChecked = z16;
    }

    public final void G(@Nullable jz3.e config) {
        kz3.a aVar;
        this.resConfig = config;
        if (this.forceLowDownloadPriority && config != null) {
            config.E = 0L;
        }
        if (config != null && (aVar = this.batchContext) != null) {
            aVar.a(this.resId, config);
        }
    }

    public final void H(boolean z16) {
        this.filePatchChecked = z16;
    }

    public final void I(boolean z16) {
        this.forceRequestRemoteConfig = z16;
    }

    public final void J(@Nullable com.tencent.rdelivery.reshub.api.h hVar) {
        this.innerCallback = hVar;
    }

    public final void K(int i3) {
        this.mode = i3;
    }

    public final void L(@Nullable RDelivery rDelivery) {
        this.rDelivery = rDelivery;
    }

    public final void M(long j3) {
        this.taskId = j3;
    }

    @Nullable
    public final jz3.e N(boolean validateResFile) {
        return D(validateResFile).getFirst();
    }

    public final void P(@NotNull jz3.e config) {
        Intrinsics.checkParameterIsNotNull(config, "config");
        if (this.mode == 4) {
            this.configMap.A(this.taskId, config);
        } else {
            this.configMap.z(config);
        }
    }

    @Override // com.tencent.rdelivery.reshub.api.e
    @Nullable
    public String a() {
        return this.appInfo.getConfigStoreSuffix();
    }

    @Override // com.tencent.rdelivery.reshub.api.e
    @NotNull
    public String b() {
        Object obj;
        jz3.e eVar = this.resConfig;
        if (eVar != null) {
            obj = Long.valueOf(eVar.f411261b);
        } else {
            obj = "";
        }
        return obj.toString();
    }

    @Override // com.tencent.rdelivery.reshub.api.e
    @NotNull
    /* renamed from: c, reason: from getter */
    public String getResId() {
        return this.resId;
    }

    @Override // com.tencent.rdelivery.reshub.api.e
    @NotNull
    public String d() {
        return this.appInfo.i();
    }

    @Override // com.tencent.rdelivery.reshub.api.e
    @NotNull
    public String e() {
        return this.appInfo.c();
    }

    @Override // com.tencent.rdelivery.reshub.api.e
    @NotNull
    public String f() {
        return m.e(this.appInfo.getTarget());
    }

    @Override // com.tencent.rdelivery.reshub.api.e
    @NotNull
    public String g() {
        String str;
        jz3.e eVar = this.resConfig;
        if (eVar == null || (str = eVar.f411266g) == null) {
            return "";
        }
        return str;
    }

    public final void h() {
        this.forceLowDownloadPriority = true;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final a getAppInfo() {
        return this.appInfo;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final kz3.a getBatchContext() {
        return this.batchContext;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getBigResPatchChecked() {
        return this.bigResPatchChecked;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final LocalResConfigManager getConfigMap() {
        return this.configMap;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getFilePatchChecked() {
        return this.filePatchChecked;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getForceRequestRemoteConfig() {
        return this.forceRequestRemoteConfig;
    }

    @NotNull
    public final String o(@Nullable String id5) {
        return m.f(this.appInfo) + "resId=" + id5 + "mode=" + this.mode + "taskId=" + this.taskId;
    }

    @Nullable
    /* renamed from: q, reason: from getter */
    public final com.tencent.rdelivery.reshub.api.h getInnerCallback() {
        return this.innerCallback;
    }

    /* renamed from: r, reason: from getter */
    public final int getMode() {
        return this.mode;
    }

    @Nullable
    /* renamed from: s, reason: from getter */
    public final jz3.e getPresetResConfig() {
        return this.presetResConfig;
    }

    @NotNull
    /* renamed from: t, reason: from getter */
    public final ResLoadRequestPriority getPriority() {
        return this.priority;
    }

    @Nullable
    /* renamed from: u, reason: from getter */
    public final RDelivery getRDelivery() {
        return this.rDelivery;
    }

    @NotNull
    /* renamed from: v, reason: from getter */
    public final ResRefreshManager getRefreshManager() {
        return this.refreshManager;
    }

    @Nullable
    /* renamed from: w, reason: from getter */
    public final jz3.e getResConfig() {
        return this.resConfig;
    }

    @NotNull
    public final String x() {
        return this.resId;
    }

    /* renamed from: y, reason: from getter */
    public final long getTaskId() {
        return this.taskId;
    }

    public final void z(boolean success, @NotNull com.tencent.rdelivery.reshub.report.a errorInfo, long time) {
        Intrinsics.checkParameterIsNotNull(errorInfo, "errorInfo");
        kz3.a aVar = this.batchContext;
        if (aVar != null) {
            aVar.b(this.resId);
        }
        if (this.hasAlreadyReportComplete) {
            return;
        }
        new ReportHelper().c(this, this.reportRecord.b(success, errorInfo, time));
        this.hasAlreadyReportComplete = true;
    }
}
