package com.tencent.sqshow.zootopia.avatar.loading.impl;

import android.os.SystemClock;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.banner.c;
import com.tencent.mobileqq.zootopia.scene.data.SceneInfo;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.sqshow.zootopia.avatar.filament.FilamentApiImpl;
import com.tencent.sqshow.zootopia.avatar.loading.ILoadingLifeCycle;
import com.tencent.state.report.SquareReportConst;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import com.tencent.zplan.world.model.FirstFrameResult;
import id3.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import t74.r;
import tl.h;
import yh3.ZPlanHotPatchVersionInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0002-.B\u0007\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J,\u0010\u000f\u001a\u00020\u00032\"\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\rH\u0002J(\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0015H\u0016J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010 \u001a\u00020\u0003H\u0016R\u0018\u0010!\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/loading/impl/LoadingLifeCycleImpl;", "Lcom/tencent/sqshow/zootopia/avatar/loading/ILoadingLifeCycle;", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "", "onEngineInitSucceed", "Lcom/tencent/sqshow/zootopia/avatar/loading/impl/LoadingLifeCycleImpl$b;", "loadingStartInfo", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "firstFrameResult", "loadFinishReport", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "params", "reportToZPlanQuality", "scene", "pageId", "rootSourceId", "sceneHash", "onLoadingStart", "", "success", "engineInitFinish", "sceneChange", "onRealEnterAvatar", "result", "onFirstFrame", "Lyh3/e;", "versionInfo", "receiveHotPatchInfo", "clearLoadingStartInfo", "markFilamentHotStart", "mLoadingStartInfo", "Lcom/tencent/sqshow/zootopia/avatar/loading/impl/LoadingLifeCycleImpl$b;", "Lid3/d;", "mReportHelper$delegate", "Lkotlin/Lazy;", "getMReportHelper", "()Lid3/d;", "mReportHelper", "Z", "<init>", "()V", "Companion", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class LoadingLifeCycleImpl implements ILoadingLifeCycle, ZPlanEngineStatusUpdateListener {
    private static final String TAG = "LoadingLifeCycleImpl_";
    private LoadingStartInfo mLoadingStartInfo;

    /* renamed from: mReportHelper$delegate, reason: from kotlin metadata */
    private final Lazy mReportHelper;
    private boolean sceneChange;

    public LoadingLifeCycleImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<d>() { // from class: com.tencent.sqshow.zootopia.avatar.loading.impl.LoadingLifeCycleImpl$mReportHelper$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d invoke() {
                return new d(null, 1, null);
            }
        });
        this.mReportHelper = lazy;
    }

    private final d getMReportHelper() {
        return (d) this.mReportHelper.getValue();
    }

    private final void loadFinishReport(LoadingStartInfo loadingStartInfo, FirstFrameResult firstFrameResult) {
        List<String> listOf;
        Object obj;
        long h16 = loadingStartInfo.h();
        QLog.i(TAG, 1, "loadFinishReport loadingStartInfo:" + loadingStartInfo + ", duration:" + h16);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("dt_pgid", loadingStartInfo.getPageId());
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, loadingStartInfo.getRootSourceId());
        hashMap.put("zplan_loading_lvtm", Long.valueOf(h16));
        hashMap.put("zplan_is_coldstart", Integer.valueOf(!loadingStartInfo.getIsHotStart() ? 1 : 0));
        int curType = firstFrameResult.getCurType();
        String params = firstFrameResult.getParams();
        if (params == null) {
            params = "";
        }
        SceneInfo sceneInfo = new SceneInfo(curType, params);
        listOf = CollectionsKt__CollectionsJVMKt.listOf("InitDress");
        sceneInfo.o(listOf);
        hashMap.put("zplan_enter_avatar_info", sceneInfo.getJsonStr());
        String str = "1";
        if (FilamentApiImpl.f369933a.d()) {
            obj = "1";
        } else {
            obj = "0";
        }
        hashMap.put("zplan_is_filament", obj);
        if (loadingStartInfo.getHotPatchVersionInfo() == null) {
            str = "0";
        }
        hashMap.put("zplan_is_hotfix", str);
        ZPlanHotPatchVersionInfo hotPatchVersionInfo = loadingStartInfo.getHotPatchVersionInfo();
        hashMap.put("zplan_hotfix_size", Integer.valueOf(hotPatchVersionInfo != null ? (int) hotPatchVersionInfo.getMUpdateSize() : 0));
        QLog.i(TAG, 1, "reportLoadingFinishEvent params:" + hashMap);
        getMReportHelper().d("ev_zplan_avatar_loading_success", hashMap);
        reportToZPlanQuality(hashMap);
    }

    private final void onEngineInitSucceed() {
        LoadingStartInfo loadingStartInfo = this.mLoadingStartInfo;
        QLog.i(TAG, 1, "onEngineInitSucceed loadingStartInfo:" + loadingStartInfo);
        if (loadingStartInfo != null && loadingStartInfo.getEngineInitSucceedTime() == 0) {
            loadingStartInfo.i(SystemClock.uptimeMillis());
        }
    }

    private final void reportToZPlanQuality(HashMap<String, Object> params) {
        Object obj;
        Object obj2;
        Object obj3;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = params.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), entry.getValue().toString());
        }
        ZPlanFeatureSwitch zPlanFeatureSwitch = ZPlanFeatureSwitch.f369852a;
        String str = "1";
        if (zPlanFeatureSwitch.f3()) {
            obj = "1";
        } else {
            obj = "0";
        }
        linkedHashMap.put("zplan_preload", obj);
        if (zPlanFeatureSwitch.N()) {
            obj2 = "1";
        } else {
            obj2 = "0";
        }
        linkedHashMap.put("zplan_parallel_world_enable", obj2);
        if (zPlanFeatureSwitch.O()) {
            obj3 = "1";
        } else {
            obj3 = "0";
        }
        linkedHashMap.put("zplan_preload_world_enable", obj3);
        if (!this.sceneChange) {
            str = "0";
        }
        linkedHashMap.put("zplan_scene_change", str);
        r.e(null, "zplan_portal_loading", linkedHashMap, 1, null);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ILoadingLifeCycle
    public void clearLoadingStartInfo(String sceneHash) {
        Intrinsics.checkNotNullParameter(sceneHash, "sceneHash");
        LoadingStartInfo loadingStartInfo = this.mLoadingStartInfo;
        QLog.i(TAG, 1, "clearLoadingStartInfo sceneHash:" + sceneHash + ", loadingHash:" + (loadingStartInfo != null ? loadingStartInfo.getSceneHash() : null));
        LoadingStartInfo loadingStartInfo2 = this.mLoadingStartInfo;
        if (Intrinsics.areEqual(loadingStartInfo2 != null ? loadingStartInfo2.getSceneHash() : null, sceneHash)) {
            this.mLoadingStartInfo = null;
        }
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineDestroy() {
        ZPlanEngineStatusUpdateListener.a.a(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
    public void engineFirstFrame() {
        ZPlanEngineStatusUpdateListener.a.b(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInitFinish(boolean success) {
        QLog.i(TAG, 1, "engineInitFinish success:" + success);
        if (success) {
            onEngineInitSucceed();
        }
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineInversePurged() {
        ZPlanEngineStatusUpdateListener.a.d(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurged() {
        ZPlanEngineStatusUpdateListener.a.e(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void enginePurging() {
        ZPlanEngineStatusUpdateListener.a.f(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void engineSuspended() {
        ZPlanEngineStatusUpdateListener.a.g(this);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void hotPatchDownloadFailed(int i3, String str) {
        ZPlanEngineStatusUpdateListener.a.h(this, i3, str);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ILoadingLifeCycle
    public void markFilamentHotStart() {
        LoadingStartInfo loadingStartInfo = this.mLoadingStartInfo;
        if (loadingStartInfo == null) {
            return;
        }
        loadingStartInfo.k(true);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ILoadingLifeCycle
    public void onFirstFrame(FirstFrameResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        LoadingStartInfo loadingStartInfo = this.mLoadingStartInfo;
        QLog.i(TAG, 1, "onFirstFrame loadingStartInfo:" + loadingStartInfo + ", result:" + result);
        if (loadingStartInfo == null) {
            return;
        }
        this.mLoadingStartInfo = null;
        loadingStartInfo.l(SystemClock.uptimeMillis());
        loadFinishReport(loadingStartInfo, result);
        this.sceneChange = false;
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ILoadingLifeCycle
    public void onRealEnterAvatar(boolean sceneChange) {
        this.sceneChange = sceneChange;
        LoadingStartInfo loadingStartInfo = this.mLoadingStartInfo;
        QLog.i(TAG, 1, "onRealEnterAvatar loadingStartInfo:" + loadingStartInfo);
        if (loadingStartInfo == null) {
            return;
        }
        if (loadingStartInfo.getRealEnterAvatarTime() == 0) {
            loadingStartInfo.m(SystemClock.uptimeMillis());
        }
        if (loadingStartInfo.getEngineInitSucceedTime() == 0) {
            loadingStartInfo.i(loadingStartInfo.getRealEnterAvatarTime());
        }
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ILoadingLifeCycle
    public void receiveHotPatchInfo(ZPlanHotPatchVersionInfo versionInfo) {
        Intrinsics.checkNotNullParameter(versionInfo, "versionInfo");
        QLog.i(TAG, 1, "receiveHotPatchInfo versionInfo:" + versionInfo + ", mLoadingStartInfo:" + this.mLoadingStartInfo);
        LoadingStartInfo loadingStartInfo = this.mLoadingStartInfo;
        if (loadingStartInfo == null) {
            return;
        }
        loadingStartInfo.j(versionInfo);
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void serviceConnected(boolean z16) {
        ZPlanEngineStatusUpdateListener.a.i(this, z16);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u001b\u001a\u00020\t\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u00101\u001a\u00020\u0004\u00a2\u0006\u0004\b2\u00103J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u001f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013R\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\f\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b!\u0010\"R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b$\u0010\"R\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\f\u001a\u0004\b&\u0010\u000e\"\u0004\b'\u0010\"R$\u0010.\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010*\u001a\u0004\b\u0010\u0010+\"\u0004\b,\u0010-R\"\u00101\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u0011\u001a\u0004\b \u0010\u0013\"\u0004\b/\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/loading/impl/LoadingLifeCycleImpl$b;", "", "", h.F, "", "toString", "", "hashCode", "other", "", "equals", "a", "J", "getLoadingStartTime", "()J", "loadingStartTime", "b", "Ljava/lang/String;", "getLoadingScene", "()Ljava/lang/String;", "loadingScene", "c", "Z", "g", "()Z", "k", "(Z)V", "isHotStart", "d", "pageId", "e", "rootSourceId", "f", "i", "(J)V", "engineInitSucceedTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "realEnterAvatarTime", "getLoadingFinishTime", "l", "loadingFinishTime", "Lyh3/e;", "Lyh3/e;", "()Lyh3/e;", "j", "(Lyh3/e;)V", "hotPatchVersionInfo", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "sceneHash", "<init>", "(JLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;JJJLyh3/e;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.avatar.loading.impl.LoadingLifeCycleImpl$b, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class LoadingStartInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final long loadingStartTime;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final String loadingScene;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean isHotStart;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String pageId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final String rootSourceId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private long engineInitSucceedTime;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private long realEnterAvatarTime;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private long loadingFinishTime;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        private ZPlanHotPatchVersionInfo hotPatchVersionInfo;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        private String sceneHash;

        public LoadingStartInfo(long j3, String loadingScene, boolean z16, String pageId, String rootSourceId, long j16, long j17, long j18, ZPlanHotPatchVersionInfo zPlanHotPatchVersionInfo, String sceneHash) {
            Intrinsics.checkNotNullParameter(loadingScene, "loadingScene");
            Intrinsics.checkNotNullParameter(pageId, "pageId");
            Intrinsics.checkNotNullParameter(rootSourceId, "rootSourceId");
            Intrinsics.checkNotNullParameter(sceneHash, "sceneHash");
            this.loadingStartTime = j3;
            this.loadingScene = loadingScene;
            this.isHotStart = z16;
            this.pageId = pageId;
            this.rootSourceId = rootSourceId;
            this.engineInitSucceedTime = j16;
            this.realEnterAvatarTime = j17;
            this.loadingFinishTime = j18;
            this.hotPatchVersionInfo = zPlanHotPatchVersionInfo;
            this.sceneHash = sceneHash;
        }

        /* renamed from: a, reason: from getter */
        public final long getEngineInitSucceedTime() {
            return this.engineInitSucceedTime;
        }

        /* renamed from: b, reason: from getter */
        public final ZPlanHotPatchVersionInfo getHotPatchVersionInfo() {
            return this.hotPatchVersionInfo;
        }

        /* renamed from: c, reason: from getter */
        public final String getPageId() {
            return this.pageId;
        }

        /* renamed from: d, reason: from getter */
        public final long getRealEnterAvatarTime() {
            return this.realEnterAvatarTime;
        }

        /* renamed from: e, reason: from getter */
        public final String getRootSourceId() {
            return this.rootSourceId;
        }

        /* renamed from: f, reason: from getter */
        public final String getSceneHash() {
            return this.sceneHash;
        }

        /* renamed from: g, reason: from getter */
        public final boolean getIsHotStart() {
            return this.isHotStart;
        }

        public final long h() {
            long coerceAtLeast;
            long coerceAtLeast2;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.engineInitSucceedTime - this.loadingStartTime, 1L);
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(this.loadingFinishTime - this.realEnterAvatarTime, 1L);
            return coerceAtLeast + coerceAtLeast2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int a16 = ((c.a(this.loadingStartTime) * 31) + this.loadingScene.hashCode()) * 31;
            boolean z16 = this.isHotStart;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int hashCode = (((((((((((a16 + i3) * 31) + this.pageId.hashCode()) * 31) + this.rootSourceId.hashCode()) * 31) + c.a(this.engineInitSucceedTime)) * 31) + c.a(this.realEnterAvatarTime)) * 31) + c.a(this.loadingFinishTime)) * 31;
            ZPlanHotPatchVersionInfo zPlanHotPatchVersionInfo = this.hotPatchVersionInfo;
            return ((hashCode + (zPlanHotPatchVersionInfo == null ? 0 : zPlanHotPatchVersionInfo.hashCode())) * 31) + this.sceneHash.hashCode();
        }

        public final void i(long j3) {
            this.engineInitSucceedTime = j3;
        }

        public final void j(ZPlanHotPatchVersionInfo zPlanHotPatchVersionInfo) {
            this.hotPatchVersionInfo = zPlanHotPatchVersionInfo;
        }

        public final void k(boolean z16) {
            this.isHotStart = z16;
        }

        public final void l(long j3) {
            this.loadingFinishTime = j3;
        }

        public final void m(long j3) {
            this.realEnterAvatarTime = j3;
        }

        public final void n(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.sceneHash = str;
        }

        public String toString() {
            return "LoadingStartInfo(loadingStartTime=" + this.loadingStartTime + ", loadingScene=" + this.loadingScene + ", isHotStart=" + this.isHotStart + ", pageId=" + this.pageId + ", rootSourceId=" + this.rootSourceId + ", engineInitSucceedTime=" + this.engineInitSucceedTime + ", realEnterAvatarTime=" + this.realEnterAvatarTime + ", loadingFinishTime=" + this.loadingFinishTime + ", hotPatchVersionInfo=" + this.hotPatchVersionInfo + ", sceneHash=" + this.sceneHash + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LoadingStartInfo)) {
                return false;
            }
            LoadingStartInfo loadingStartInfo = (LoadingStartInfo) other;
            return this.loadingStartTime == loadingStartInfo.loadingStartTime && Intrinsics.areEqual(this.loadingScene, loadingStartInfo.loadingScene) && this.isHotStart == loadingStartInfo.isHotStart && Intrinsics.areEqual(this.pageId, loadingStartInfo.pageId) && Intrinsics.areEqual(this.rootSourceId, loadingStartInfo.rootSourceId) && this.engineInitSucceedTime == loadingStartInfo.engineInitSucceedTime && this.realEnterAvatarTime == loadingStartInfo.realEnterAvatarTime && this.loadingFinishTime == loadingStartInfo.loadingFinishTime && Intrinsics.areEqual(this.hotPatchVersionInfo, loadingStartInfo.hotPatchVersionInfo) && Intrinsics.areEqual(this.sceneHash, loadingStartInfo.sceneHash);
        }

        public /* synthetic */ LoadingStartInfo(long j3, String str, boolean z16, String str2, String str3, long j16, long j17, long j18, ZPlanHotPatchVersionInfo zPlanHotPatchVersionInfo, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(j3, str, z16, str2, str3, (i3 & 32) != 0 ? 0L : j16, (i3 & 64) != 0 ? 0L : j17, (i3 & 128) != 0 ? 0L : j18, (i3 & 256) != 0 ? null : zPlanHotPatchVersionInfo, (i3 & 512) != 0 ? "" : str4);
        }
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.ILoadingLifeCycle
    public void onLoadingStart(String scene, String pageId, String rootSourceId, String sceneHash) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(rootSourceId, "rootSourceId");
        Intrinsics.checkNotNullParameter(sceneHash, "sceneHash");
        LoadingStartInfo loadingStartInfo = this.mLoadingStartInfo;
        boolean isEngineReady = ((IZPlanApi) QRoute.api(IZPlanApi.class)).isEngineReady();
        QLog.i(TAG, 1, "onLoadingStart scene:" + scene + ", loadingStartInfo:" + loadingStartInfo + ", isHotStart:" + isEngineReady);
        if (loadingStartInfo != null) {
            QLog.i(TAG, 1, "onLoadingStart loading task already started!");
            return;
        }
        LoadingStartInfo loadingStartInfo2 = new LoadingStartInfo(SystemClock.uptimeMillis(), scene, isEngineReady, pageId, rootSourceId, 0L, 0L, 0L, null, 0 == true ? 1 : 0, 992, null);
        this.mLoadingStartInfo = loadingStartInfo2;
        loadingStartInfo2.n(sceneHash);
        ZPlanServiceHelper.I.E0(this);
    }
}
