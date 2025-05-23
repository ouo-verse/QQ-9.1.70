package fm2;

import android.view.MotionEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import fm2.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\f\u001a\u00020\t\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0016"}, d2 = {"Lfm2/b;", "Lcom/tencent/ttpic/openapi/filter/GLGestureListener;", "", "onGetPriority", "Landroid/view/MotionEvent;", "event", "", "isRecording", "onTouchEvent", "Lfm2/e$b;", "a", "Lfm2/e$b;", "gestureListener", "", "b", UserInfo.SEX_FEMALE, "mBaseY", "c", "mMinLimitY", "<init>", "(Lfm2/e$b;)V", "d", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b implements GLGestureListener {

    /* renamed from: e, reason: collision with root package name */
    private static final int f399850e = Math.max(20, (int) (12 * ViewUtils.getDensity()));

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e.b gestureListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float mBaseY;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float mMinLimitY;

    public b(@NotNull e.b gestureListener) {
        Intrinsics.checkNotNullParameter(gestureListener, "gestureListener");
        this.gestureListener = gestureListener;
    }

    @Override // com.tencent.ttpic.openapi.filter.GLGestureListener
    public int onGetPriority() {
        return 0;
    }

    @Override // com.tencent.ttpic.openapi.filter.GLGestureListener
    public boolean onTouchEvent(@NotNull MotionEvent event, boolean isRecording) {
        Intrinsics.checkNotNullParameter(event, "event");
        int pointerCount = event.getPointerCount();
        int action = event.getAction() & 255;
        if (pointerCount == 1 && isRecording) {
            if (action != 0) {
                if (action == 2) {
                    float y16 = event.getY();
                    float f16 = this.mMinLimitY;
                    if (y16 >= f16) {
                        this.mBaseY = f16;
                        return false;
                    }
                    this.gestureListener.a((this.mBaseY - event.getY()) / f399850e);
                    this.mBaseY = event.getY();
                }
            } else {
                this.mBaseY = this.mMinLimitY;
            }
        }
        return false;
    }
}
