package com.tencent.input.base.panelcontainer;

import android.content.res.Configuration;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH&J\"\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u0010H&J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\rH&J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\rH&J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\rH&J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0010H&J\u0018\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\rH&J\b\u0010 \u001a\u00020\u0010H&J\b\u0010!\u001a\u00020\u0010H&J\b\u0010\"\u001a\u00020\u0010H&J\b\u0010#\u001a\u00020\bH&\u00a8\u0006$"}, d2 = {"Lcom/tencent/input/base/panelcontainer/e;", "", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Lcom/tencent/mvi/runtime/strategy/b;", "strategyService", "Landroid/view/View;", "d", "", "a", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "", "isInMultiWindowMode", "onMultiWindowModeChanged", "", "panelId", "needAnim", "delayTime", "g", tl.h.F, "j", "", "source", "e", "isShowKeyboard", "keyboardHeight", "f", "heightOffset", "needInfluenceCurPanel", "k", "i", "b", "c", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public interface e {
    void a();

    int b();

    int c();

    @NotNull
    View d(@NotNull com.tencent.mvi.api.help.a createViewParams, @NotNull com.tencent.mvi.runtime.strategy.b strategyService);

    void e(@NotNull String source, boolean needAnim);

    void f(boolean isShowKeyboard, int keyboardHeight);

    void g(int panelId, boolean needAnim, int delayTime);

    void h(int panelId, boolean needAnim);

    int i();

    void j(boolean needAnim);

    void k(int heightOffset, boolean needInfluenceCurPanel);

    void onConfigurationChanged(@NotNull Configuration newConfig);

    void onDestroy();

    void onMultiWindowModeChanged(boolean isInMultiWindowMode);
}
