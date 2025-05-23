package a84;

import android.graphics.Bitmap;
import android.view.Surface;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.zootopia.scene.data.SceneInfo;
import com.tencent.sqshow.zootopia.avatar.AvatarEngineType;
import com.tencent.sqshow.zootopia.nativeui.ue.aa;
import com.tencent.zplan.engine.ZPlanEngineStatusUpdateListener;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.view.d;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import od3.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0002H&J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000eH&J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0010H&J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H&J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0015H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0018H&J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0006H&J\b\u0010!\u001a\u00020 H&J\b\u0010#\u001a\u00020\"H&J\b\u0010$\u001a\u00020\bH\u0016J\b\u0010%\u001a\u00020\u0004H&\u00a8\u0006&"}, d2 = {"La84/a;", "Lod3/c;", "Lcom/tencent/zplan/engine/ZPlanEngineStatusUpdateListener;", "Lcom/tencent/zplan/world/view/d;", "Lcom/tencent/mobileqq/zootopia/scene/data/c;", "params", "", "needWaitEngineInit", "", "Q2", "Landroid/view/View;", "p4", "listener", "B6", "Lpd3/a;", "Qf", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "W7", "Lcom/tencent/sqshow/zootopia/nativeui/data/d;", ParseCommon.CONTAINER, "e9", "Lod3/a;", "scene", "gh", "Landroid/graphics/Bitmap;", "v4", "Lb94/a;", "m8", "Lcom/tencent/sqshow/zootopia/scene/component/d;", "observer", "q0", "isEngineReady", "", "J7", "Lcom/tencent/sqshow/zootopia/avatar/AvatarEngineType;", "g0", "N0", "I9", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public interface a extends c, ZPlanEngineStatusUpdateListener, d {
    void B6(ZPlanEngineStatusUpdateListener listener);

    SceneInfo I9();

    int J7();

    void N0();

    void Q2(SceneInfo params, boolean needWaitEngineInit);

    void Qf(pd3.a listener);

    void W7(IZPlanWorldStatusListener listener);

    void e9(com.tencent.sqshow.zootopia.nativeui.data.d container);

    AvatarEngineType g0();

    void gh(od3.a scene);

    boolean isEngineReady();

    b94.a m8();

    View p4();

    void q0(com.tencent.sqshow.zootopia.scene.component.d observer);

    Bitmap v4();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: a84.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static final class C0021a {
        public static void a(a aVar, com.tencent.sqshow.zootopia.scene.component.d observer) {
            Intrinsics.checkNotNullParameter(observer, "observer");
        }

        public static void b(a aVar) {
            ZPlanEngineStatusUpdateListener.a.a(aVar);
        }

        @Deprecated(message = "\u8bf7\u4f7f\u7528world\u7684FirstFrame\u72b6\u6001\u56de\u8c03")
        public static void c(a aVar) {
            ZPlanEngineStatusUpdateListener.a.b(aVar);
        }

        public static void d(a aVar, boolean z16) {
            ZPlanEngineStatusUpdateListener.a.c(aVar, z16);
        }

        public static void e(a aVar) {
            ZPlanEngineStatusUpdateListener.a.d(aVar);
        }

        public static void f(a aVar) {
            ZPlanEngineStatusUpdateListener.a.e(aVar);
        }

        public static void g(a aVar) {
            ZPlanEngineStatusUpdateListener.a.f(aVar);
        }

        public static void h(a aVar) {
            ZPlanEngineStatusUpdateListener.a.g(aVar);
        }

        public static b94.a k(a aVar) {
            return aa.f371327d;
        }

        public static void l(a aVar, int i3, String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
            ZPlanEngineStatusUpdateListener.a.h(aVar, i3, errorMessage);
        }

        public static void m(a aVar, Surface surface, int i3, int i16) {
            d.a.a(aVar, surface, i3, i16);
        }

        public static void n(a aVar, Surface surface, int i3, int i16) {
            d.a.b(aVar, surface, i3, i16);
        }

        public static void o(a aVar, Surface surface) {
            d.a.c(aVar, surface);
        }

        public static void p(a aVar, boolean z16) {
            ZPlanEngineStatusUpdateListener.a.i(aVar, z16);
        }

        public static /* synthetic */ void i(a aVar, SceneInfo sceneInfo, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                aVar.Q2(sceneInfo, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enterAvatarScene");
        }

        public static void j(a aVar) {
        }
    }
}
