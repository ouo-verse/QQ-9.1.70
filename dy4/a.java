package dy4;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.view.b;
import com.tencent.zplan.world.view.d;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J:\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006H&J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH&J\b\u0010\u0010\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u000eH&J\b\u0010\u0012\u001a\u00020\u000eH&J\u0012\u0010\u0014\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0013H&J(\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0019H&J\b\u0010\u001c\u001a\u00020\u001bH&J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0006H&J\b\u0010\u001f\u001a\u00020\u000eH&\u00a8\u0006 "}, d2 = {"Ldy4/a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Context;", "context", "", "needEvent", TPReportKeys.PlayerStep.PLAYER_CALLBACK_OPAQUE, "useSurfaceView", "Landroid/view/View;", "b", "Lcom/tencent/zplan/world/view/b;", "listener", "", "setOnTouchEventListener", "pause", "resume", "destroy", "Lcom/tencent/zplan/world/view/d;", "setRenderListener", "", "sceneType", "", "sceneParams", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "c", "Lcom/tencent/zplan/model/a;", "d", "hasFocus", "a", "H", "zplan_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface a {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* renamed from: dy4.a$a, reason: collision with other inner class name */
    /* loaded from: classes27.dex */
    public static final class C10207a {
        public static /* synthetic */ View a(a aVar, Activity activity, Context context, boolean z16, boolean z17, boolean z18, int i3, Object obj) {
            boolean z19;
            boolean z26;
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    activity = null;
                }
                Activity activity2 = activity;
                if ((i3 & 4) != 0) {
                    z19 = false;
                } else {
                    z19 = z16;
                }
                if ((i3 & 8) != 0) {
                    z17 = true;
                }
                boolean z27 = z17;
                if ((i3 & 16) != 0) {
                    z26 = false;
                } else {
                    z26 = z18;
                }
                return aVar.b(activity2, context, z19, z27, z26);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getView");
        }
    }

    void H();

    void a(boolean hasFocus);

    @NotNull
    View b(@Nullable Activity activity, @NotNull Context context, boolean needEvent, boolean opaque, boolean useSurfaceView);

    void c(int sceneType, @Nullable String sceneParams, @Nullable IZPlanWorldStatusListener listener);

    @NotNull
    com.tencent.zplan.model.a d();

    void destroy();

    void pause();

    void resume();

    void setOnTouchEventListener(@NotNull b listener);

    void setRenderListener(@Nullable d listener);
}
