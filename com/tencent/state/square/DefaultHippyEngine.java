package com.tencent.state.square;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.square.api.FloatPanelParams;
import com.tencent.state.square.api.ISquareHippyEngine;
import com.tencent.state.square.api.ISquareHippyMethodObserver;
import com.tencent.state.square.api.OpenHippyParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J*\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/DefaultHippyEngine;", "Lcom/tencent/state/square/api/ISquareHippyEngine;", "()V", "addMethodObserver", "", "observer", "Lcom/tencent/state/square/api/ISquareHippyMethodObserver;", "destroyPreloadHippy", "params", "Lcom/tencent/state/square/api/OpenHippyParams;", "openHippyPage", "context", "Landroid/content/Context;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "isPanel", "", "preloadHippyPage", "removeMethodObserver", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final class DefaultHippyEngine implements ISquareHippyEngine {
    @Override // com.tencent.state.square.api.ISquareHippyEngine
    public void addMethodObserver(@NotNull ISquareHippyMethodObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
    }

    @Override // com.tencent.state.square.api.ISquareHippyEngine
    @Nullable
    public Fragment createHippyFragment(@NotNull JSONObject params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return ISquareHippyEngine.DefaultImpls.createHippyFragment(this, params);
    }

    @Override // com.tencent.state.square.api.ISquareHippyEngine
    public void destroyPreloadHippy(@NotNull OpenHippyParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
    }

    @Override // com.tencent.state.square.api.ISquareHippyEngine
    public void openHippyPage(@NotNull Context context, @Nullable FragmentManager fragmentManager, @NotNull OpenHippyParams params, boolean isPanel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
    }

    @Override // com.tencent.state.square.api.ISquareHippyEngine
    public void openHippyPanel(@Nullable Context context, @Nullable FragmentManager fragmentManager, @NotNull OpenHippyParams params, @NotNull FloatPanelParams panel) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(panel, "panel");
        ISquareHippyEngine.DefaultImpls.openHippyPanel(this, context, fragmentManager, params, panel);
    }

    @Override // com.tencent.state.square.api.ISquareHippyEngine
    public void preloadHippyPage(@NotNull OpenHippyParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
    }

    @Override // com.tencent.state.square.api.ISquareHippyEngine
    public void removeMethodObserver(@NotNull ISquareHippyMethodObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
    }
}
