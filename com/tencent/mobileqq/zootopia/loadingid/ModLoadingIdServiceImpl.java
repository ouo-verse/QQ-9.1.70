package com.tencent.mobileqq.zootopia.loadingid;

import com.tencent.mobileqq.zootopia.c;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.report.UploadQualityReportBuilder;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.engine.ZPlanServiceHelper;
import ic3.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016R0\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u000ej\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R$\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0012j\b\u0012\u0004\u0012\u00020\u0007`\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zootopia/loadingid/ModLoadingIdServiceImpl;", "Lic3/a;", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "", UploadQualityReportBuilder.STATE_CONNECT, "", "serviceConnected", "", "mapId", "", "getLoadingId", "modExit", "modLoadFinish", "processExit", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "mLoadingIdCache", "Ljava/util/HashMap;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "mModLoadingSuccessCache", "Ljava/util/HashSet;", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ModLoadingIdServiceImpl implements a, ZPlanEngineStatusUpdateListener {
    private static final String TAG = "ModLoadingIdServiceImpl_";
    private final HashMap<Integer, String> mLoadingIdCache = new HashMap<>();
    private final HashSet<Integer> mModLoadingSuccessCache = new HashSet<>();

    public ModLoadingIdServiceImpl() {
        ZPlanServiceHelper.I.E0(this);
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
    public void engineInitFinish(boolean z16) {
        ZPlanEngineStatusUpdateListener.a.c(this, z16);
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

    @Override // ic3.a
    public String getLoadingId(int mapId) {
        String str = this.mLoadingIdCache.get(Integer.valueOf(mapId));
        if (str == null) {
            str = "";
        }
        if (str.length() > 0) {
            QLog.i(TAG, 1, "getLoadingId map:" + mapId + " from cache:" + str);
            return str;
        }
        String a16 = c.f327951a.a(System.currentTimeMillis());
        this.mLoadingIdCache.put(Integer.valueOf(mapId), a16);
        QLog.i(TAG, 1, "getLoadingId map:" + mapId + " new gen:" + a16);
        return a16;
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void hotPatchDownloadFailed(int i3, String str) {
        ZPlanEngineStatusUpdateListener.a.h(this, i3, str);
    }

    @Override // ic3.a
    public void modExit(int mapId) {
        boolean contains = this.mModLoadingSuccessCache.contains(Integer.valueOf(mapId));
        QLog.i(TAG, 1, "modExit map:" + mapId + ", modHasLoadSucceed:" + contains);
        if (contains) {
            this.mLoadingIdCache.remove(Integer.valueOf(mapId));
            this.mModLoadingSuccessCache.remove(Integer.valueOf(mapId));
        }
    }

    @Override // ic3.a
    public void modLoadFinish(int mapId) {
        QLog.i(TAG, 1, "modLoadFinish map:" + mapId);
        this.mModLoadingSuccessCache.add(Integer.valueOf(mapId));
    }

    public void processExit() {
        QLog.i(TAG, 1, "processExit");
        Set<Integer> keySet = new HashMap(this.mLoadingIdCache).keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "idCache.keys");
        for (Integer it : keySet) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            modExit(it.intValue());
        }
        this.mModLoadingSuccessCache.clear();
    }

    @Override // com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener
    public void serviceConnected(boolean connect) {
        if (connect) {
            return;
        }
        processExit();
    }
}
