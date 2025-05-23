package com.tencent.hippy.qq.api;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.mtt.hippy.dom.node.DomNodeRecord;
import com.tencent.qqmini.v8rt.engine.EnginePathProvider;
import java.util.ArrayList;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Service(process = {"all"})
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001$JN\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J$\u0010\u0011\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\tH&J&\u0010\u0014\u001a\u00020\u00122\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H&J2\u0010\u0016\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\tH&JD\u0010\u001c\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J@\u0010\u001d\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0013\u001a\u00020\t2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H&\u00a8\u0006%"}, d2 = {"Lcom/tencent/hippy/qq/api/IHippyDomNodeManager;", "Lmqq/app/api/IRuntimeService;", "addSnapshotRootViewIfNeed", "Lcom/tencent/mtt/hippy/HippyRootView;", EnginePathProvider.ENGINE_DIR, "Lcom/tencent/mtt/hippy/HippyEngine;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", "bundleName", "", HippyQQConstants.KEY_BUNDLE_VERSION, "", OpenHippyInfo.EXTRA_KEY_PRE_RENDER_TAG, "loadParams", "Lcom/tencent/mtt/hippy/HippyEngine$ModuleLoadParams;", "loadListener", "Lcom/tencent/hippy/qq/api/IHippyDomNodeManager$SnapshotLoadListener;", "deleteDomNodeCache", "", HippyQQConstants.KEY_RENDER_TAG, "removeSnapshotRootViewIfNeed", "snapShotRootView", "reportSnapshotShow", "costTime", "", "success", "", "errMsg", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_RESTORE_INSTANCE_STATE, "saveInstanceState", "renderVersion", "renderData", "Lorg/json/JSONObject;", "recordList", "Ljava/util/ArrayList;", "Lcom/tencent/mtt/hippy/dom/node/DomNodeRecord;", "SnapshotLoadListener", "hippy-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public interface IHippyDomNodeManager extends IRuntimeService {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/hippy/qq/api/IHippyDomNodeManager$SnapshotLoadListener;", "", "onLoadComplete", "", "onLoadFailed", "errorMsg", "", "hippy-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public interface SnapshotLoadListener {
        void onLoadComplete();

        void onLoadFailed(@NotNull String errorMsg);
    }

    @Nullable
    HippyRootView addSnapshotRootViewIfNeed(@Nullable HippyEngine engine, @Nullable ViewGroup container, @Nullable String bundleName, int bundleVersion, @Nullable String preRenderTag, @Nullable HippyEngine.ModuleLoadParams loadParams, @Nullable SnapshotLoadListener loadListener);

    void deleteDomNodeCache(@Nullable String bundleName, int bundleVersion, @Nullable String renderTag);

    void removeSnapshotRootViewIfNeed(@Nullable HippyEngine engine, @Nullable ViewGroup container, @Nullable HippyRootView snapShotRootView);

    void reportSnapshotShow(@Nullable String bundleName, int bundleVersion, long costTime, boolean success, @NotNull String errMsg);

    @Nullable
    HippyRootView restoreInstanceState(@Nullable HippyEngine engine, @Nullable String bundleName, int bundleVersion, @Nullable String preRenderTag, @Nullable HippyEngine.ModuleLoadParams loadParams, @Nullable SnapshotLoadListener loadListener);

    void saveInstanceState(int bundleVersion, @NotNull String bundleName, int renderVersion, @Nullable JSONObject renderData, @NotNull String renderTag, @NotNull ArrayList<DomNodeRecord> recordList);
}
