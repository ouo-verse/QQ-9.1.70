package com.tencent.mobileqq.zootopia.ue;

import android.view.KeyEvent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.ue.c;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u0000 )2\u00020\u0001:\u0001*B\u0019\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\b\b\u0003\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\b'\u0010(J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR!\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ue/ZootopiaUeModuleManager;", "Lcom/tencent/mobileqq/zootopia/ue/c;", "", "b", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zootopia/ue/d;", DownloadInfo.spKey_Config, "", "u9", "destroy", "resume", "pause", "Landroid/view/KeyEvent;", "event", "", "d", "success", "engineInitFinish", UploadQualityReportBuilder.STATE_CONNECT, "serviceConnected", "engineDestroy", "", "I", "viewType", "", "e", "Ljava/lang/String;", "getPayPluginScene", "()Ljava/lang/String;", "payPluginScene", "f", "Lkotlin/Lazy;", "c", "()Ljava/util/List;", "modules", tl.h.F, "Ljava/util/List;", "portalModules", "<init>", "(ILjava/lang/String;)V", "i", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaUeModuleManager implements c {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int viewType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String payPluginScene;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy modules;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final List<c> portalModules;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ue/ZootopiaUeModuleManager$a;", "", "", "viewType", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.ue.ZootopiaUeModuleManager$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final String a(int viewType) {
            if (viewType != 1 && viewType != 2) {
                return "0";
            }
            return ZootopiaSource.SUB_SOURCE_STORE;
        }
    }

    public ZootopiaUeModuleManager(int i3, @PayPluginScene String payPluginScene) {
        Lazy lazy;
        List<c> listOf;
        Intrinsics.checkNotNullParameter(payPluginScene, "payPluginScene");
        this.viewType = i3;
        this.payPluginScene = payPluginScene;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends c>>() { // from class: com.tencent.mobileqq.zootopia.ue.ZootopiaUeModuleManager$modules$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends c> invoke() {
                List<? extends c> b16;
                b16 = ZootopiaUeModuleManager.this.b();
                return b16;
            }
        });
        this.modules = lazy;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new c[]{new f(), new i(), new ZootopiaPayViewModule(payPluginScene), new ZootopiaResidenceModule(), new g()});
        this.portalModules = listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<c> b() {
        List<c> plus;
        List<c> emptyList;
        int i3 = this.viewType;
        if (i3 == 1) {
            return this.portalModules;
        }
        if (i3 != 2) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        plus = CollectionsKt___CollectionsKt.plus((Collection<? extends h>) ((Collection<? extends Object>) this.portalModules), new h());
        return plus;
    }

    private final List<c> c() {
        return (List) this.modules.getValue();
    }

    @Override // com.tencent.mobileqq.zootopia.ue.c
    public void destroy() {
        Iterator<T> it = c().iterator();
        while (it.hasNext()) {
            ((c) it.next()).destroy();
        }
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineDestroy() {
        Iterator<T> it = c().iterator();
        while (it.hasNext()) {
            ((c) it.next()).engineDestroy();
        }
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
    public void engineFirstFrame() {
        c.a.b(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInitFinish(boolean success) {
        Iterator<T> it = c().iterator();
        while (it.hasNext()) {
            ((c) it.next()).engineInitFinish(success);
        }
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInversePurged() {
        c.a.d(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurged() {
        c.a.e(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurging() {
        c.a.f(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineSuspended() {
        c.a.g(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void hotPatchDownloadFailed(int i3, String str) {
        c.a.h(this, i3, str);
    }

    @Override // com.tencent.mobileqq.zootopia.ue.c
    public void pause() {
        Iterator<T> it = c().iterator();
        while (it.hasNext()) {
            ((c) it.next()).pause();
        }
    }

    @Override // com.tencent.mobileqq.zootopia.ue.c
    public void resume() {
        Iterator<T> it = c().iterator();
        while (it.hasNext()) {
            ((c) it.next()).resume();
        }
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void serviceConnected(boolean connect) {
        Iterator<T> it = c().iterator();
        while (it.hasNext()) {
            ((c) it.next()).serviceConnected(connect);
        }
    }

    @Override // com.tencent.mobileqq.zootopia.ue.c
    public void u9(FragmentActivity activity, d config) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(config, "config");
        Iterator<T> it = c().iterator();
        while (it.hasNext()) {
            ((c) it.next()).u9(activity, config);
        }
    }

    public final boolean d(KeyEvent event) {
        if (!(event != null && event.getKeyCode() == 4)) {
            return false;
        }
        ZPlanServiceHelper.I.s0(event.getKeyCode(), event);
        return true;
    }

    public /* synthetic */ ZootopiaUeModuleManager(int i3, String str, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? PayPluginScene.OTHERS : str);
    }
}
