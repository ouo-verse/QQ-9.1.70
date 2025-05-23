package com.tencent.ecommerce.biz.hippy.api;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000e\u001a\u00020\u0007H&J\b\u0010\u000f\u001a\u00020\u0007H&J\b\u0010\u0010\u001a\u00020\u0007H&J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/hippy/api/IECHippyEngine;", "", "getCurrentFragment", "Landroidx/fragment/app/Fragment;", "getHippyRootView", "Lcom/tencent/mtt/hippy/HippyRootView;", "initHippyInContainer", "", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", ISchemeApi.KEY_PAGE_DATA, "Lorg/json/JSONObject;", "engineListener", "Lcom/tencent/ecommerce/biz/hippy/api/IECHippyEngineListener;", "onDestroyView", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "setPropsMap", "map", "Lcom/tencent/mtt/hippy/common/HippyMap;", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECHippyEngine {
    @NotNull
    Fragment getCurrentFragment();

    @Nullable
    HippyRootView getHippyRootView();

    void initHippyInContainer(@NotNull ViewGroup container, @Nullable JSONObject pageData, @Nullable IECHippyEngineListener engineListener);

    void onDestroyView();

    void onPause();

    void onResume();

    void setPropsMap(@NotNull HippyMap map);
}
