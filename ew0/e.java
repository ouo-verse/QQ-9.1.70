package ew0;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u001a\b&\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0019\u00a2\u0006\u0004\bN\u0010OJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0017\u0010\t\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010%\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\n\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010(R\"\u00101\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00105\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010,\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R\"\u0010=\u001a\u0002068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010@\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010,\u001a\u0004\b \u0010.\"\u0004\b?\u00100R\"\u0010C\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010,\u001a\u0004\b\u000e\u0010.\"\u0004\bB\u00100R\"\u0010F\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010,\u001a\u0004\b\u0014\u0010.\"\u0004\bE\u00100R\"\u0010I\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bG\u0010,\u001a\u0004\b\u001a\u0010.\"\u0004\bH\u00100R\"\u0010M\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010\u0015\u001a\u0004\bK\u0010\u0017\"\u0004\bL\u0010(\u00a8\u0006P"}, d2 = {"Lew0/e;", "", "", "a", "g", "Landroid/graphics/PointF;", "Landroid/graphics/PointF;", "getStartPos", "()Landroid/graphics/PointF;", "startPos", "b", "getEndPos", "endPos", "Lfw0/c;", "c", "Lfw0/c;", "getLikePathProvider", "()Lfw0/c;", "likePathProvider", "", "d", "J", "getDuration", "()J", "duration", "Landroid/view/animation/Interpolator;", "e", "Landroid/view/animation/Interpolator;", "getInterpolator", "()Landroid/view/animation/Interpolator;", "interpolator", "", "f", "Z", "()Z", "setAlive", "(Z)V", "alive", "getCurrent", "setCurrent", "(J)V", "current", "", h.F, UserInfo.SEX_FEMALE, "getBeginScale", "()F", "setBeginScale", "(F)V", "beginScale", "i", "getShowDuration", "setShowDuration", "showDuration", "", "j", "I", "getMinDuration", "()I", "setMinDuration", "(I)V", "minDuration", "k", "setCurrentAlpha", "currentAlpha", "l", "setCurScale", "curScale", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setCurX", "curX", DomainData.DOMAIN_NAME, "setCurY", "curY", "o", "getBeginTime", "setBeginTime", "beginTime", "<init>", "(Landroid/graphics/PointF;Landroid/graphics/PointF;Lfw0/c;JLandroid/view/animation/Interpolator;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF startPos;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PointF endPos;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final fw0.c likePathProvider;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long duration;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Interpolator interpolator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean alive;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private long current;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float beginScale;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float showDuration;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int minDuration;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private float currentAlpha;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private float curScale;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float curX;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private float curY;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private long beginTime;

    public e(@NotNull PointF startPos, @NotNull PointF endPos, @NotNull fw0.c likePathProvider, long j3, @NotNull Interpolator interpolator) {
        Intrinsics.checkNotNullParameter(startPos, "startPos");
        Intrinsics.checkNotNullParameter(endPos, "endPos");
        Intrinsics.checkNotNullParameter(likePathProvider, "likePathProvider");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        this.startPos = startPos;
        this.endPos = endPos;
        this.likePathProvider = likePathProvider;
        this.duration = j3;
        this.interpolator = interpolator;
        this.beginScale = 0.7f;
        this.showDuration = 200.0f;
        this.minDuration = 32;
        this.curScale = 0.7f;
        this.curX = startPos.x;
        this.curY = startPos.y;
    }

    public final void a() {
        this.beginTime = System.currentTimeMillis();
        this.alive = true;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getAlive() {
        return this.alive;
    }

    /* renamed from: c, reason: from getter */
    public final float getCurScale() {
        return this.curScale;
    }

    /* renamed from: d, reason: from getter */
    public final float getCurX() {
        return this.curX;
    }

    /* renamed from: e, reason: from getter */
    public final float getCurY() {
        return this.curY;
    }

    /* renamed from: f, reason: from getter */
    public final float getCurrentAlpha() {
        return this.currentAlpha;
    }

    public final void g() {
        float f16;
        long currentTimeMillis = System.currentTimeMillis() - this.beginTime;
        this.current = currentTimeMillis;
        long j3 = this.duration;
        if (currentTimeMillis < j3) {
            f16 = this.interpolator.getInterpolation(((float) currentTimeMillis) / ((float) j3));
        } else {
            this.alive = false;
            f16 = 1.0f;
        }
        this.curX = this.likePathProvider.getX(this.startPos, this.endPos, f16);
        this.curY = this.likePathProvider.getY(this.startPos, this.endPos, f16);
        long j16 = this.current;
        float f17 = (float) j16;
        float f18 = this.showDuration;
        if (f17 < f18) {
            float f19 = ((float) j16) / f18;
            this.currentAlpha = f19;
            float f26 = this.beginScale;
            this.curScale = f26 + ((1.0f - f26) * f19);
            return;
        }
        long j17 = this.duration;
        if (((float) (j17 - j16)) < f18) {
            this.currentAlpha = ((float) (j17 - j16)) / f18;
            this.curScale = 1.0f;
        } else {
            this.currentAlpha = 1.0f;
            this.curScale = 1.0f;
        }
    }
}
