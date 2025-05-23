package fm2;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\n\u0011B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lfm2/e;", "Lcom/tencent/ttpic/openapi/filter/GLGestureListener;", "", "onGetPriority", "Landroid/view/MotionEvent;", "event", "", "isRecorder", "onTouchEvent", "Landroid/view/ScaleGestureDetector;", "a", "Landroid/view/ScaleGestureDetector;", "zoomGesture", "Lfm2/e$b;", "glZoomGestureListener", "<init>", "(Lfm2/e$b;)V", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class e implements GLGestureListener {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ScaleGestureDetector zoomGesture;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lfm2/e$a;", "Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;", "Landroid/view/ScaleGestureDetector;", "scaleGestureDetector", "", "onScale", "Lfm2/e$b;", "d", "Lfm2/e$b;", "zoomListener", "<init>", "(Lfm2/e$b;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class a extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final b zoomListener;

        public a(@NotNull b zoomListener) {
            Intrinsics.checkNotNullParameter(zoomListener, "zoomListener");
            this.zoomListener = zoomListener;
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(@Nullable ScaleGestureDetector scaleGestureDetector) {
            if (scaleGestureDetector != null) {
                this.zoomListener.a((scaleGestureDetector.getScaleFactor() - 1) * 30);
            }
            return true;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lfm2/e$b;", "", "", "increaseZoomValue", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public interface b {
        void a(float increaseZoomValue);
    }

    public e(@NotNull b glZoomGestureListener) {
        Intrinsics.checkNotNullParameter(glZoomGestureListener, "glZoomGestureListener");
        this.zoomGesture = new ScaleGestureDetector(BaseApplication.getContext(), new a(glZoomGestureListener));
    }

    @Override // com.tencent.ttpic.openapi.filter.GLGestureListener
    public int onGetPriority() {
        return 0;
    }

    @Override // com.tencent.ttpic.openapi.filter.GLGestureListener
    public boolean onTouchEvent(@Nullable MotionEvent event, boolean isRecorder) {
        return this.zoomGesture.onTouchEvent(event);
    }
}
