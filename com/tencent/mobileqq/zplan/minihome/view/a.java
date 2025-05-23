package com.tencent.mobileqq.zplan.minihome.view;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.filament.zplan.scene.minihome.IMiniHomeLoadCallback;
import com.tencent.filament.zplan.scene.minihome.IMiniHomeMessageCallback;
import com.tencent.filament.zplan.scene.minihome.MiniHomeScene;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.minihome.MiniHomeSceneEnum;
import com.tencent.mobileqq.zplan.minihome.ac;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&J\n\u0010\r\u001a\u0004\u0018\u00010\fH&J\b\u0010\u000e\u001a\u00020\u0002H&J\u001e\u0010\u0013\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\u0014\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\u0015\u001a\u00020\u0002H&J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H&J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u001aH&J \u0010 \u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u001fH&J\b\u0010!\u001a\u00020\u0002H&J \u0010#\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u001aH&J\u0018\u0010$\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u001aH&J\u0018\u0010%\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u001fH&J\u0018\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\u001fH&J\u0010\u0010*\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020)H&J\u0010\u0010,\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020+H&J\u0010\u0010.\u001a\u00020\u00022\u0006\u0010-\u001a\u00020&H&\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/zplan/minihome/view/a;", "", "", "resume", "pause", "release", "Lcom/tencent/mobileqq/zplan/minihome/MiniHomeSceneEnum;", "scene", tl.h.F, "Landroid/view/MotionEvent;", "event", "onTouchEvent", "Landroid/view/View;", "getView", "f", "", "roomJsonString", "Lcom/tencent/filament/zplan/scene/minihome/IMiniHomeLoadCallback;", "callback", "c", "a", "l", "Lcom/tencent/filament/zplan/scene/minihome/MiniHomeScene$Companion$CAMERAMODE;", "mode", "o", "slot", "Lcom/tencent/filament/zplan/scene/minihome/a;", "k", "", HippyTKDListViewAdapter.X, "y", "Lcom/tencent/filament/zplan/scene/minihome/IMiniHomeMessageCallback;", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "decorateJson", "i", "d", "j", "", "needCompleteRoomData", DomainData.DOMAIN_NAME, "Lcom/tencent/filament/zplan/scene/minihome/b;", "b", "Lcom/tencent/mobileqq/zplan/minihome/ac;", "p", "night", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface a {
    void a(IMiniHomeLoadCallback callback);

    void b(com.tencent.filament.zplan.scene.minihome.b callback);

    void c(String roomJsonString, IMiniHomeLoadCallback callback);

    void d(String slot, com.tencent.filament.zplan.scene.minihome.a callback);

    void e(boolean night);

    void f();

    void g(int x16, int y16, IMiniHomeMessageCallback callback);

    View getView();

    void h(MiniHomeSceneEnum scene);

    void i(String slot, String decorateJson, com.tencent.filament.zplan.scene.minihome.a callback);

    void j(String slot, IMiniHomeMessageCallback callback);

    void k(String slot, com.tencent.filament.zplan.scene.minihome.a callback);

    void l();

    void m();

    void n(boolean needCompleteRoomData, IMiniHomeMessageCallback callback);

    void o(MiniHomeScene.Companion.CAMERAMODE mode);

    void onTouchEvent(MotionEvent event);

    void p(ac callback);

    void pause();

    void release();

    void resume();
}
