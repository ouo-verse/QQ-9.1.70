package com.tencent.mobileqq.search.voicesearch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.utils.ViewUtils;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0013\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0004B'\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010)\u001a\u00020\u0002\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0006\u0010\f\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014R\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010!\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/search/voicesearch/AudioVolumeWaveView;", "Landroid/view/View;", "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "a", "", "b", "", "columnHeight", "", "f", "e", "c", "d", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "", "[I", "VOLUME_ARRAY", "", "J", "lastSliceTime", "D", "lastColumnHeight", "Landroid/graphics/Paint;", tl.h.F, "Landroid/graphics/Paint;", "paintLine", "i", "paintTracer", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "[D", "volumeColumn", BdhLogUtil.LogTag.Tag_Conn, "tracerColumn", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class AudioVolumeWaveView extends View {
    private static final double F = 0.0d;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final double[] tracerColumn;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final int[] VOLUME_ARRAY;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long lastSliceTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private double lastColumnHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Paint paintLine;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Paint paintTracer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final double[] volumeColumn;
    private static final int E = 75;
    private static final float G = ViewUtils.dpToPx(7.0f);
    private static final float H = ViewUtils.dpToPx(6.0f);
    private static final float I = ViewUtils.dpToPx(26.0f);

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AudioVolumeWaveView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int a(int volume) {
        int length = this.VOLUME_ARRAY.length - 1;
        if (length < 0) {
            return 0;
        }
        while (true) {
            int i3 = length - 1;
            if (volume > this.VOLUME_ARRAY[length]) {
                return length;
            }
            if (i3 >= 0) {
                length = i3;
            } else {
                return 0;
            }
        }
    }

    private final boolean b() {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (uptimeMillis - this.lastSliceTime < E) {
            return false;
        }
        this.lastSliceTime = uptimeMillis;
        return true;
    }

    private final void e() {
        double[] dArr = this.tracerColumn;
        double[] dArr2 = this.volumeColumn;
        dArr[0] = dArr2[0];
        dArr[1] = dArr2[1];
        dArr[2] = dArr2[2];
        dArr[3] = dArr2[3];
    }

    private final void f(double columnHeight) {
        e();
        double[] dArr = this.volumeColumn;
        dArr[0] = Math.abs(this.lastColumnHeight - dArr[1]);
        double[] dArr2 = this.volumeColumn;
        dArr2[1] = dArr2[2];
        dArr2[2] = columnHeight;
        dArr2[3] = Math.abs(this.lastColumnHeight - columnHeight);
        this.lastColumnHeight = columnHeight;
    }

    public final void c() {
        int length = this.volumeColumn.length;
        for (int i3 = 0; i3 < length; i3++) {
            double[] dArr = this.volumeColumn;
            double d16 = F;
            dArr[i3] = d16;
            this.tracerColumn[i3] = d16;
        }
    }

    public final void d(int volume) {
        if (!b()) {
            return;
        }
        f(a(volume) / 10.0d);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        double[] dArr = this.volumeColumn;
        float measuredWidth = (getMeasuredWidth() - ((dArr.length * G) + ((dArr.length - 1) * H))) / 2;
        int length = this.volumeColumn.length;
        for (int i3 = 0; i3 < length; i3++) {
            double d16 = this.tracerColumn[i3];
            float f16 = I;
            double d17 = 2;
            double d18 = ((d16 * f16) + 0.1d) / d17;
            float measuredHeight = (float) ((getMeasuredHeight() / 2) - d18);
            float measuredHeight2 = (float) ((getMeasuredHeight() / 2) + d18);
            float f17 = measuredWidth + (i3 * (G + H));
            if (canvas != null) {
                canvas.drawLine(f17, measuredHeight, f17, measuredHeight2, this.paintTracer);
            }
            double d19 = ((this.volumeColumn[i3] * f16) + 0.1d) / d17;
            float measuredHeight3 = (float) ((getMeasuredHeight() / 2) - d19);
            float measuredHeight4 = (float) ((getMeasuredHeight() / 2) + d19);
            if (canvas != null) {
                canvas.drawLine(f17, measuredHeight3, f17, measuredHeight4, this.paintLine);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AudioVolumeWaveView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AudioVolumeWaveView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AudioVolumeWaveView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.VOLUME_ARRAY = new int[]{0, 500, 1000, 1500, 2300, QzoneConfig.DEFAULT_PHOTOVIEW_PHOTO_BYTES, 5000, 7000, 10000, 15000, 20000};
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        float f16 = G;
        paint.setStrokeWidth(f16);
        paint.setColor(Color.parseColor("#0099FF"));
        this.paintLine = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        paint2.setStrokeWidth(f16);
        paint2.setColor(Color.parseColor("#73F8FF"));
        paint2.setAlpha(64);
        this.paintTracer = paint2;
        double[] dArr = new double[4];
        for (int i16 = 0; i16 < 4; i16++) {
            dArr[i16] = F;
        }
        this.volumeColumn = dArr;
        double[] dArr2 = new double[4];
        for (int i17 = 0; i17 < 4; i17++) {
            dArr2[i17] = F;
        }
        this.tracerColumn = dArr2;
    }
}
