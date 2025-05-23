package ai0;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.ecommerce.biz.hippy.api.IECHippyEngine;
import com.tencent.ecommerce.biz.hippy.api.IECHippyEngineListener;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016R\u0017\u0010\u0018\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lai0/b;", "Lcom/tencent/ecommerce/biz/hippy/api/IECHippyEngine;", "Lcom/tencent/mtt/hippy/common/HippyMap;", "map", "", "setPropsMap", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Lorg/json/JSONObject;", ISchemeApi.KEY_PAGE_DATA, "Lcom/tencent/ecommerce/biz/hippy/api/IECHippyEngineListener;", "engineListener", "initHippyInContainer", "Lcom/tencent/mtt/hippy/HippyRootView;", "getHippyRootView", "Landroidx/fragment/app/Fragment;", "getCurrentFragment", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onDestroyView", "a", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class b implements IECHippyEngine {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Fragment fragment;

    public b(@NotNull Fragment fragment) {
        this.fragment = fragment;
    }

    @Override // com.tencent.ecommerce.biz.hippy.api.IECHippyEngine
    @NotNull
    /* renamed from: getCurrentFragment, reason: from getter */
    public Fragment getFragment() {
        return this.fragment;
    }

    @Override // com.tencent.ecommerce.biz.hippy.api.IECHippyEngine
    @Nullable
    public HippyRootView getHippyRootView() {
        return null;
    }

    @Override // com.tencent.ecommerce.biz.hippy.api.IECHippyEngine
    public void initHippyInContainer(@NotNull ViewGroup container, @Nullable JSONObject pageData, @Nullable IECHippyEngineListener engineListener) {
        if (engineListener != null) {
            engineListener.onError(-1, "");
        }
    }

    @Override // com.tencent.ecommerce.biz.hippy.api.IECHippyEngine
    public void onDestroyView() {
    }

    @Override // com.tencent.ecommerce.biz.hippy.api.IECHippyEngine
    public void onPause() {
    }

    @Override // com.tencent.ecommerce.biz.hippy.api.IECHippyEngine
    public void onResume() {
    }

    @Override // com.tencent.ecommerce.biz.hippy.api.IECHippyEngine
    public void setPropsMap(@NotNull HippyMap map) {
    }
}
