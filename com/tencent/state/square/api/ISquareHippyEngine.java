package com.tencent.state.square.api;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000bH&J,\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H&J,\u0010\u0013\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u000bH&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/square/api/ISquareHippyEngine;", "", "addMethodObserver", "", "observer", "Lcom/tencent/state/square/api/ISquareHippyMethodObserver;", "createHippyFragment", "Landroidx/fragment/app/Fragment;", "params", "Lorg/json/JSONObject;", "destroyPreloadHippy", "Lcom/tencent/state/square/api/OpenHippyParams;", "openHippyPage", "context", "Landroid/content/Context;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "isPanel", "", "openHippyPanel", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, "Lcom/tencent/state/square/api/FloatPanelParams;", "preloadHippyPage", "removeMethodObserver", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface ISquareHippyEngine {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        @Nullable
        public static Fragment createHippyFragment(@NotNull ISquareHippyEngine iSquareHippyEngine, @NotNull JSONObject params) {
            Intrinsics.checkNotNullParameter(params, "params");
            return null;
        }

        public static /* synthetic */ void openHippyPage$default(ISquareHippyEngine iSquareHippyEngine, Context context, FragmentManager fragmentManager, OpenHippyParams openHippyParams, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    z16 = false;
                }
                iSquareHippyEngine.openHippyPage(context, fragmentManager, openHippyParams, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openHippyPage");
        }

        public static void openHippyPanel(@NotNull ISquareHippyEngine iSquareHippyEngine, @Nullable Context context, @Nullable FragmentManager fragmentManager, @NotNull OpenHippyParams params, @NotNull FloatPanelParams panel) {
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(panel, "panel");
        }
    }

    void addMethodObserver(@NotNull ISquareHippyMethodObserver observer);

    @Nullable
    Fragment createHippyFragment(@NotNull JSONObject params);

    void destroyPreloadHippy(@NotNull OpenHippyParams params);

    void openHippyPage(@NotNull Context context, @Nullable FragmentManager fragmentManager, @NotNull OpenHippyParams params, boolean isPanel);

    void openHippyPanel(@Nullable Context context, @Nullable FragmentManager fragmentManager, @NotNull OpenHippyParams params, @NotNull FloatPanelParams panel);

    void preloadHippyPage(@NotNull OpenHippyParams params);

    void removeMethodObserver(@NotNull ISquareHippyMethodObserver observer);
}
