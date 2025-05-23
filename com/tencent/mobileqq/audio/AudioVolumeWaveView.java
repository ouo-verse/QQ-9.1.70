package com.tencent.mobileqq.audio;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010(\u001a\u00020\f\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\fJ\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014R\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0016\u0010\u001c\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/audio/AudioVolumeWaveView;", "Landroid/view/View;", "", "columnHeight", "", "e", "", HippyControllerProps.ARRAY, "d", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "a", "b", "", "c", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paintLine", "[D", "side", "f", "middle", h.F, "volumeColumn", "i", "I", "index", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "lowVolume", BdhLogUtil.LogTag.Tag_Conn, "D", "lastColumnHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-ptt-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AudioVolumeWaveView extends View {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final float E;
    private static final float F;

    /* renamed from: C, reason: from kotlin metadata */
    private double lastColumnHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Paint paintLine;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final double[] side;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final double[] middle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final double[] volumeColumn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int index;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean lowVolume;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/audio/AudioVolumeWaveView$a;", "", "", "ARRAY_SIZE", "I", "", "DEFAULT_VOLUME", "D", "<init>", "()V", "qq-ptt-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.audio.AudioVolumeWaveView$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19412);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        INSTANCE = new Companion(null);
        E = ViewUtils.dpToPx(3.0f);
        F = ViewUtils.dpToPx(3.0f);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AudioVolumeWaveView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
    }

    private final double a(double volume) {
        boolean z16;
        double d16;
        double d17;
        if (volume < 0.15d) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.lowVolume = z16;
        if (volume < 0.15d) {
            return volume;
        }
        if (volume < 0.6d) {
            d16 = this.lastColumnHeight;
            d17 = 0.2d;
            if (volume - d16 <= 0.2d) {
                if (d16 - volume <= 0.2d) {
                    return volume;
                }
                return d16 - d17;
            }
            return d16 + d17;
        }
        if (volume < 0.8d) {
            d16 = this.lastColumnHeight;
            d17 = 0.12d;
            if (volume - d16 <= 0.12d) {
                if (d16 - volume <= 0.12d) {
                    return volume;
                }
                return d16 - d17;
            }
            return d16 + d17;
        }
        if (volume < 1.0d) {
            d16 = this.lastColumnHeight;
            d17 = 0.08d;
            if (volume - d16 <= 0.08d) {
                if (d16 - volume <= 0.08d) {
                    return volume;
                }
                return d16 - d17;
            }
            return d16 + d17;
        }
        d16 = this.lastColumnHeight;
        d17 = 0.04d;
        if (volume - d16 <= 0.04d) {
            if (d16 - volume <= 0.04d) {
                return volume;
            }
            return d16 - d17;
        }
        return d16 + d17;
    }

    private final void d(double[] array, double columnHeight) {
        array[0] = array[1];
        array[1] = array[2];
        double d16 = array[3];
        array[2] = d16;
        array[6] = array[5];
        array[5] = array[4];
        array[4] = d16;
        array[3] = columnHeight;
    }

    private final void e(double columnHeight) {
        if (this.lowVolume) {
            d(this.middle, columnHeight);
            return;
        }
        double[] dArr = this.middle;
        double d16 = dArr[2];
        dArr[0] = d16;
        dArr[6] = d16;
        double d17 = dArr[1];
        dArr[2] = d17;
        dArr[4] = d17;
        double d18 = dArr[3];
        dArr[1] = d18;
        dArr[5] = d18;
        dArr[3] = columnHeight;
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        int length = this.side.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.side[i3] = 0.05d;
        }
        int length2 = this.middle.length;
        for (int i16 = 0; i16 < length2; i16++) {
            this.middle[i16] = 0.05d;
        }
    }

    public final void c(int volume) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, volume);
            return;
        }
        this.index = (this.index + 1) % 3;
        double a16 = a(volume / 10.0d);
        this.lastColumnHeight = a16;
        double d16 = 8;
        double abs = Math.abs(Math.sin(((this.index + 1) * 3.141592653589793d) / d16) * a16);
        if (abs < 0.1d) {
            abs += 0.1d;
        }
        e(abs);
        double abs2 = Math.abs(a16 * Math.cos(((this.index + 1) * 3.141592653589793d) / d16) * 0.85d);
        if (abs2 < 0.1d) {
            abs2 += 0.1d;
        }
        d(this.side, abs2);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        System.arraycopy(this.side, 0, this.volumeColumn, 0, 7);
        System.arraycopy(this.middle, 0, this.volumeColumn, 7, 7);
        System.arraycopy(this.side, 0, this.volumeColumn, 14, 7);
        int length = this.volumeColumn.length;
        for (int i3 = 0; i3 < length; i3++) {
            double d16 = this.volumeColumn[i3];
            float measuredHeight = getMeasuredHeight();
            float f16 = E;
            float f17 = (i3 * (F + f16)) + (f16 / 2);
            double d17 = (d16 * (measuredHeight - f16)) / 2;
            float measuredHeight2 = (float) ((getMeasuredHeight() / 2) - d17);
            float measuredHeight3 = (float) ((getMeasuredHeight() / 2) + d17);
            if (canvas != null) {
                canvas.drawLine(f17, measuredHeight2, f17, measuredHeight3, this.paintLine);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AudioVolumeWaveView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ AudioVolumeWaveView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AudioVolumeWaveView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(E);
        paint.setColor(-1);
        this.paintLine = paint;
        double[] dArr = new double[7];
        for (int i16 = 0; i16 < 7; i16++) {
            dArr[i16] = 0.05d;
        }
        this.side = dArr;
        double[] dArr2 = new double[7];
        for (int i17 = 0; i17 < 7; i17++) {
            dArr2[i17] = 0.05d;
        }
        this.middle = dArr2;
        this.volumeColumn = new double[21];
    }
}
