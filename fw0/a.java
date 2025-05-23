package fw0;

import android.graphics.PointF;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\b\b\u0002\u0010*\u001a\u00020)\u00a2\u0006\u0004\b+\u0010,J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\r\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016J \u0010\u000e\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0017\u0010\u0012\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0017\u0010\u001f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001eR\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lfw0/a;", "Lfw0/c;", "Landroid/graphics/PointF;", "originStart", "originEnd", "", "curStage", "", "a", "start", "end", "", "percent", "getX", "getY", UserInfo.SEX_FEMALE, "getStageHeight", "()F", "stageHeight", "b", "getStageWidth", "stageWidth", "c", "I", "CURVE_TYPE_START_LEFT", "d", "CURVE_TYPE_START_RIGHT", "e", "Landroid/graphics/PointF;", "getStageStart", "()Landroid/graphics/PointF;", "stageStart", "f", "getStageEnd", "stageEnd", "Lfw0/e;", "g", "Lfw0/e;", "getCurveUtil", "()Lfw0/e;", "curveUtil", "", "startLeft", "<init>", "(FFZ)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float stageHeight;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float stageWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int CURVE_TYPE_START_LEFT;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int CURVE_TYPE_START_RIGHT;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF stageStart = new PointF();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF stageEnd = new PointF();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e curveUtil = new e();

    public a(float f16, float f17, boolean z16) {
        this.stageHeight = f16;
        this.stageWidth = f17;
        this.CURVE_TYPE_START_RIGHT = 1;
        if (z16) {
            this.CURVE_TYPE_START_LEFT = 1;
            this.CURVE_TYPE_START_RIGHT = 0;
        } else {
            this.CURVE_TYPE_START_LEFT = 0;
            this.CURVE_TYPE_START_RIGHT = 1;
        }
    }

    private final void a(PointF originStart, PointF originEnd, int curStage) {
        int i3 = curStage % 2;
        if (i3 == this.CURVE_TYPE_START_LEFT) {
            PointF pointF = this.stageStart;
            pointF.x = originStart.x;
            float f16 = originStart.y;
            float f17 = this.stageHeight;
            pointF.y = f16 - (curStage * f17);
            PointF pointF2 = this.stageEnd;
            pointF2.x = originStart.x;
            pointF2.y = originStart.y - ((curStage + 1) * f17);
            this.curveUtil.f(true);
            return;
        }
        if (i3 == this.CURVE_TYPE_START_RIGHT) {
            PointF pointF3 = this.stageStart;
            pointF3.x = originStart.x;
            float f18 = originStart.y;
            float f19 = this.stageHeight;
            pointF3.y = f18 - (curStage * f19);
            PointF pointF4 = this.stageEnd;
            pointF4.x = originStart.x;
            pointF4.y = originStart.y - ((curStage + 1) * f19);
            this.curveUtil.f(false);
        }
    }

    @Override // fw0.c
    public float getX(@NotNull PointF start, @NotNull PointF end, float percent) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        float abs = Math.abs(end.y - start.y) * percent;
        float f16 = this.stageHeight;
        float f17 = (abs % f16) / f16;
        a(start, end, (int) (abs / f16));
        return this.curveUtil.c(this.stageStart, this.stageEnd, this.stageWidth, f17);
    }

    @Override // fw0.c
    public float getY(@NotNull PointF start, @NotNull PointF end, float percent) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        float abs = Math.abs(end.y - start.y) * percent;
        float f16 = this.stageHeight;
        float f17 = (abs % f16) / f16;
        a(start, end, (int) (abs / f16));
        return this.curveUtil.d(this.stageStart, this.stageEnd, this.stageWidth, f17);
    }
}
