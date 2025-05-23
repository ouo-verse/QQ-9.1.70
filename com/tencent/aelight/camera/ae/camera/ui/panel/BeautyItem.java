package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.R;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b+\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BA\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\fR\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1\u00a8\u00062"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautyItem;", "", "type", "Lcom/tencent/ttpic/openapi/config/BeautyRealConfig$TYPE;", "key", "", Element.ELEMENT_NAME_MIN, "", "max", RemoteHandleConst.PARAM_DEFAULT_VALUE, "imageResId", "iconUrl", "(Ljava/lang/String;ILcom/tencent/ttpic/openapi/config/BeautyRealConfig$TYPE;Ljava/lang/String;IIIILjava/lang/String;)V", "getDefaultValue", "()I", "setDefaultValue", "(I)V", "getIconUrl", "()Ljava/lang/String;", "getImageResId", "getKey", "getMax", "getMin", "getType", "()Lcom/tencent/ttpic/openapi/config/BeautyRealConfig$TYPE;", "NONE", "RESET", "SKIN", "BASICFACE", "TOOTH_WHITEN", "FACE_FEATURE_SOFT", "FACE_FEATURE_REDCHEEK", "FACE_FEATURE_LIPS_LUT_ALPHA", "REMOVE_POUNCH", "REMOVE_WRINKLES2", "LUT_CLEAR_ALPHA", "LUT_FOUNDATION_ALPHA", "FOREHEAD", "EYE", "MOUTH_SHAPE", "FACE_THIN", "FACE_SMALLER", "NOSE", "CHEEKBONE_THIN", "AUTOTHIN_BODY", "SLIM_HEAD", "SLIM_LEG", "LONG_LEG", "SLIM_WAIST", "EYE_MAKEUP", "aelight_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public enum BeautyItem {
    NONE(BeautyRealConfig.TYPE.NONE, "\u65e0", 0, 0, 0, R.drawable.iyg, null),
    RESET(BeautyRealConfig.TYPE.EMPTY, "\u6062\u590d\u9ed8\u8ba4", 0, 0, 0, R.drawable.f159972iw1, null),
    SKIN(BeautyRealConfig.TYPE.BEAUTY, "\u78e8\u76ae", 0, 100, 60, R.drawable.msp, "https://downv6.qq.com/shadow_qqcamera/Android/res/\u78e8\u76ae.png"),
    BASICFACE(BeautyRealConfig.TYPE.FACTOR_THIN_NEW, "\u7626\u8138", 0, 100, 40, R.drawable.f160619msg, "https://downv6.qq.com/shadow_qqcamera/Android/res/\u7626\u8138.png"),
    TOOTH_WHITEN(BeautyRealConfig.TYPE.TOOTH_WHITEN, "\u767d\u7259", 0, 100, 20, R.drawable.msq, "https://downv6.qq.com/shadow_qqcamera/Android/res/\u7f8e\u7259.png"),
    FACE_FEATURE_SOFT(BeautyRealConfig.TYPE.FACE_FEATURE_SOFT, "\u7acb\u4f53", 0, 100, 40, R.drawable.msc, "https://downv6.qq.com/shadow_qqcamera/Android/res/\u7acb\u4f53.png"),
    FACE_FEATURE_REDCHEEK(BeautyRealConfig.TYPE.FACE_FEATURE_REDCHEEK, "\u816e\u7ea2", 0, 100, 20, R.drawable.mso, "https://downv6.qq.com/shadow_qqcamera/Android/res/\u816e\u7ea2.png"),
    FACE_FEATURE_LIPS_LUT_ALPHA(BeautyRealConfig.TYPE.FACE_FEATURE_LIPS_LUT_ALPHA, "\u53e3\u7ea2", 0, 100, 30, R.drawable.msk, "https://downv6.qq.com/shadow_qqcamera/Android/res/\u53e3\u7ea2.png"),
    REMOVE_POUNCH(BeautyRealConfig.TYPE.REMOVE_POUNCH, "\u9ed1\u773c\u5708", 0, 100, 50, R.drawable.msn, "https://downv6.qq.com/shadow_qqcamera/Android/res/\u9ed1\u773c\u5708.png"),
    REMOVE_WRINKLES2(BeautyRealConfig.TYPE.REMOVE_WRINKLES2, "\u6cd5\u4ee4\u7eb9", 0, 100, 30, R.drawable.msl, "https://downv6.qq.com/shadow_qqcamera/Android/res/\u6cd5\u4ee4\u7eb9.png"),
    LUT_CLEAR_ALPHA(BeautyRealConfig.TYPE.LUT_CLERA_ALPHA, "\u6e05\u6670", 0, 100, 20, R.drawable.mse, "https://downv6.qq.com/shadow_qqcamera/Android/res/\u6e05\u6670.png"),
    LUT_FOUNDATION_ALPHA(BeautyRealConfig.TYPE.LUT_FOUNDATION_ALPHA, "\u7f8e\u767d", 0, 100, 30, R.drawable.msd, "https://downv6.qq.com/shadow_qqcamera/Android/res/\u7f8e\u767d.png"),
    FOREHEAD(BeautyRealConfig.TYPE.FOREHEAD, "\u989d\u5934", -100, 100, 0, R.drawable.msi, "https://downv6.qq.com/shadow_qqcamera/Android/res/\u989d\u5934.png"),
    EYE(BeautyRealConfig.TYPE.EYE, "\u5927\u773c", 0, 100, 30, R.drawable.f160618msf, "https://downv6.qq.com/shadow_qqcamera/Android/res/\u5927\u773c.png"),
    MOUTH_SHAPE(BeautyRealConfig.TYPE.MOUTH_SHAPE, "\u5634\u5f62", -100, 100, 0, R.drawable.msj, "https://downv6.qq.com/shadow_qqcamera/Android/res/\u5634\u5f62.png"),
    FACE_THIN(BeautyRealConfig.TYPE.FACE_THIN, "\u7a84\u8138", 0, 100, 0, R.drawable.msh, "https://downv6.qq.com/shadow_qqcamera/Android/res/\u7a84\u8138.png"),
    FACE_SMALLER(BeautyRealConfig.TYPE.FACTOR_SMALL_NEW, "\u5c0f\u8138", 0, 100, 0, R.drawable.msr, "https://downv6.qq.com/shadow_qqcamera/Android/res/\u5c0f\u8138.png"),
    NOSE(BeautyRealConfig.TYPE.NOSE, "\u7626\u9f3b", 0, 100, 30, R.drawable.msm, "https://downv6.qq.com/shadow_qqcamera/Android/res/\u7626\u9f3b.png"),
    CHEEKBONE_THIN(BeautyRealConfig.TYPE.CHEEKBONE_THIN, "\u7626\u98a7\u9aa8", 0, 100, 20, R.drawable.msh, "https://downv6.qq.com/shadow_qqcamera/Android/res/\u7626\u98a7\u9aa8.png"),
    AUTOTHIN_BODY(BeautyRealConfig.TYPE.BODY_AUTOTHIN_BODY, "\u4e00\u952e\u7626\u8eab", 0, 100, 0, R.drawable.iye, "https://downv6.qq.com/shadow_qqcamera/Android/res/\u4e00\u952e\u7626\u8eab.png"),
    SLIM_HEAD(BeautyRealConfig.TYPE.BODY_SLIM_HEAD, "\u5c0f\u5934", 0, 100, 0, R.drawable.iyd, "https://downv6.qq.com/shadow_qqcamera/Android/res/\u5c0f\u5934.png"),
    SLIM_LEG(BeautyRealConfig.TYPE.BODY_SLIM_LEG, "\u7626\u817f", 0, 100, 0, R.drawable.iyb, "https://downv6.qq.com/shadow_qqcamera/Android/res/\u7626\u817f.png"),
    LONG_LEG(BeautyRealConfig.TYPE.LONG_LEG, "\u957f\u817f", 0, 100, 0, R.drawable.iya, "https://downv6.qq.com/shadow_qqcamera/Android/res/\u957f\u817f.png"),
    SLIM_WAIST(BeautyRealConfig.TYPE.SLIM_WAIST, "\u7626\u8170", 0, 100, 0, R.drawable.iyc, "https://downv6.qq.com/shadow_qqcamera/Android/res/\u7626\u8170.png"),
    EYE_MAKEUP(BeautyRealConfig.TYPE.EYE_MAKEUP, "\u773c\u5986", 0, 100, 40, R.drawable.iy8, "https://downv6.qq.com/shadow_qqcamera/camera/ae_beautify_eye_makeup.png");

    private int defaultValue;
    private final String iconUrl;
    private final int imageResId;
    private final String key;
    private final int max;
    private final int min;
    private final BeautyRealConfig.TYPE type;

    BeautyItem(BeautyRealConfig.TYPE type, String str, int i3, int i16, int i17, int i18, String str2) {
        this.type = type;
        this.key = str;
        this.min = i3;
        this.max = i16;
        this.defaultValue = i17;
        this.imageResId = i18;
        this.iconUrl = str2;
    }

    public final int getDefaultValue() {
        return this.defaultValue;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final int getImageResId() {
        return this.imageResId;
    }

    public final String getKey() {
        return this.key;
    }

    public final int getMax() {
        return this.max;
    }

    public final int getMin() {
        return this.min;
    }

    public final BeautyRealConfig.TYPE getType() {
        return this.type;
    }

    public final void setDefaultValue(int i3) {
        this.defaultValue = i3;
    }
}
