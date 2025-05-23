package com.tencent.mobileqq.zplan.minihome;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.filament.zplan.scene.minihome.IMiniHomeLoadCallback;
import com.tencent.filament.zplan.scene.minihome.IMiniHomeMessageCallback;
import com.tencent.filament.zplan.scene.minihome.MiniHomeScene;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&J\b\u0010\u0010\u001a\u00020\u0004H&J\u001e\u0010\u0014\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\u0014\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\b\u0010\u0016\u001a\u00020\u0004H&J\u001a\u0010\u001a\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0019\u001a\u00020\u0018H&J\b\u0010\u001b\u001a\u00020\u0004H&J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0018H&J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH&J\u0018\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\"H&J \u0010'\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020&H&J\b\u0010(\u001a\u00020\u0004H&J \u0010*\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\"H&J\u0018\u0010+\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\"H&J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020&H&J\u0018\u0010.\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020&H&J\u0010\u00100\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020/H&J\u0016\u00104\u001a\u00020\u00042\f\u00103\u001a\b\u0012\u0004\u0012\u00020201H&J\u0016\u00105\u001a\u00020\u00042\f\u00103\u001a\b\u0012\u0004\u0012\u00020201H&\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/y;", "Lcom/tencent/mobileqq/zplan/minihome/z;", "", ReportConstant.COSTREPORT_PREFIX, "", "u", "", "v", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeSceneEnum;", "scene", tl.h.F, "Landroid/view/View;", "getView", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "f", "roomJsonString", "Lcom/tencent/filament/zplan/scene/minihome/IMiniHomeLoadCallback;", "callback", "c", "a", "l", "imageUrlOrPath", "", "isNightTheme", "w", "p", "night", "e", "Lcom/tencent/filament/zplan/scene/minihome/MiniHomeScene$Companion$CAMERAMODE;", "mode", "o", "slot", "Lcom/tencent/filament/zplan/scene/minihome/a;", "k", HippyTKDListViewAdapter.X, "y", "Lcom/tencent/filament/zplan/scene/minihome/IMiniHomeMessageCallback;", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "decorateJson", "i", "d", "j", "needCompleteRoomData", DomainData.DOMAIN_NAME, "Lcom/tencent/filament/zplan/scene/minihome/b;", "b", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/zplan/minihome/ac;", "callbackRef", "r", "t", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface y extends z {
    void a(@Nullable IMiniHomeLoadCallback callback);

    void b(@NotNull com.tencent.filament.zplan.scene.minihome.b callback);

    void c(@Nullable String roomJsonString, @Nullable IMiniHomeLoadCallback callback);

    void d(@NotNull String slot, @NotNull com.tencent.filament.zplan.scene.minihome.a callback);

    void e(boolean night);

    void f();

    void g(int x16, int y16, @NotNull IMiniHomeMessageCallback callback);

    @Nullable
    View getView();

    void h(@NotNull MiniHomeSceneEnum scene);

    void i(@NotNull String slot, @NotNull String decorateJson, @NotNull com.tencent.filament.zplan.scene.minihome.a callback);

    void j(@NotNull String slot, @NotNull IMiniHomeMessageCallback callback);

    void k(@NotNull String slot, @NotNull com.tencent.filament.zplan.scene.minihome.a callback);

    void l();

    void m();

    void n(boolean needCompleteRoomData, @NotNull IMiniHomeMessageCallback callback);

    void o(@NotNull MiniHomeScene.Companion.CAMERAMODE mode);

    void onTouchEvent(@NotNull MotionEvent event);

    void p();

    void r(@NotNull WeakReference<ac> callbackRef);

    @NotNull
    String s();

    void t(@NotNull WeakReference<ac> callbackRef);

    void u();

    int v();

    void w(@Nullable String imageUrlOrPath, boolean isNightTheme);
}
