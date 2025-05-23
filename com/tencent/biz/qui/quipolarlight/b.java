package com.tencent.biz.qui.quipolarlight;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\"\u0018\u0000 \u00112\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J \u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J(\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J@\u0010\u0011\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0002J(\u0010\u0015\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u001e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002R\"\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b\u0007\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/biz/qui/quipolarlight/b;", "", "", "f", "", "a", "t", "b", "g", "seed", "xPrimed", "yPrimed", "zPrimed", "e", "xd", "yd", "zd", "d", HippyTKDListViewAdapter.X, "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "i", "cordX", "cordY", "cordZ", "c", "I", "getSeed", "()I", "setSeed", "(I)V", UserInfo.SEX_FEMALE, "()F", h.F, "(F)V", "frequency", "<init>", "()V", "QUIPolarLight_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int seed = 1337;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float frequency = 0.01f;

    /* renamed from: c, reason: collision with root package name */
    private static final float[] f95210c = {0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f};

    private final int a(float f16) {
        int i3 = (int) f16;
        if (f16 < 0) {
            return i3 - 1;
        }
        return i3;
    }

    private final float d(int seed, int xPrimed, int yPrimed, int zPrimed, float xd5, float yd5, float zd5) {
        int e16 = e(seed, xPrimed, yPrimed, zPrimed);
        int i3 = (e16 ^ (e16 >> 15)) & 252;
        float[] fArr = f95210c;
        return (xd5 * fArr[i3]) + (yd5 * fArr[i3 | 1]) + (zd5 * fArr[i3 | 2]);
    }

    private final int e(int seed, int xPrimed, int yPrimed, int zPrimed) {
        return (((seed ^ xPrimed) ^ yPrimed) ^ zPrimed) * 668265261;
    }

    private final float f(float t16) {
        return t16 * t16 * t16 * ((t16 * ((6 * t16) - 15)) + 10);
    }

    private final float g(float a16, float b16, float t16) {
        return a16 + (t16 * (b16 - a16));
    }

    private final float i(int seed, float x16, float y16, float z16) {
        int a16 = a(x16);
        int a17 = a(y16);
        int a18 = a(z16);
        float f16 = x16 - a16;
        float f17 = y16 - a17;
        float f18 = z16 - a18;
        float f19 = 1;
        float f26 = f16 - f19;
        float f27 = f17 - f19;
        float f28 = f18 - f19;
        float f29 = f(f16);
        float f36 = f(f17);
        int i3 = a16 * 501125321;
        int i16 = a17 * 1136930381;
        int i17 = a18 * 1720413743;
        int i18 = i3 + 501125321;
        int i19 = i16 + 1136930381;
        int i26 = i17 + 1720413743;
        return g(g(g(d(seed, i3, i16, i17, f16, f17, f18), d(seed, i18, i16, i17, f26, f17, f18), f29), g(d(seed, i3, i19, i17, f16, f27, f18), d(seed, i18, i19, i17, f26, f27, f18), f29), f36), g(g(d(seed, i3, i16, i26, f16, f17, f28), d(seed, i18, i16, i26, f26, f17, f28), f29), g(d(seed, i3, i19, i26, f16, f27, f28), d(seed, i18, i19, i26, f26, f27, f28), f29), f36), f(f18)) * ((float) 0.9649214148521423d);
    }

    /* renamed from: b, reason: from getter */
    public final float getFrequency() {
        return this.frequency;
    }

    public final float c(float cordX, float cordY, float cordZ) {
        float f16 = this.frequency;
        float f17 = cordX * f16;
        float f18 = cordY * f16;
        float f19 = cordZ * f16;
        float f26 = f17 + f18;
        float f27 = ((float) (-0.211324865405187d)) * f26;
        float f28 = (float) 0.577350269189626d;
        float f29 = f19 * f28;
        return i(this.seed, f17 + (f27 - f29), (f18 + f27) - f29, f29 + (f26 * f28));
    }

    public final void h(float f16) {
        this.frequency = f16;
    }
}
