package com.tencent.filter;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GLSLRender {
    static IPatchRedirector $redirector_ = null;
    public static final int FILTER_2D_CURVE = 7;
    public static final int FILTER_ALPHAREVERT = 49;
    public static final int FILTER_ALPHA_ADJUST = 3;
    public static final int FILTER_ALPHA_ADJUST_REAL = 4;
    public static final int FILTER_BACKGROUNDTEXUL_SHADER = 93;
    public static final int FILTER_BEAUTY_SMOOTH_NEW = 137;
    public static final int FILTER_BEAUTY_WHITEN_NEW = 138;
    public static final int FILTER_BILATERALFILTER2_NEW = 70;
    public static final int FILTER_BILATERALFILTER_NEW = 71;
    public static final int FILTER_CHANNELSTRECH2_SHADER = 113;
    public static final int FILTER_CHANNELSTRECH3_SHADER = 114;
    public static final int FILTER_CHANNEL_SATURATION = 31;
    public static final int FILTER_CHANNEL_SHARPEN_FR = 33;
    public static final int FILTER_CHANNEL_STRECH = 30;
    public static final int FILTER_COLORPENCIL = 10;
    public static final int FILTER_DAMPING_GAUSS_H_FRAG = 48;
    public static final int FILTER_DARKCORNER_CURVE = 8;
    public static final int FILTER_DIRECTIONFILTERP = 72;
    public static final int FILTER_DOF_SHADER = 52;
    public static final int FILTER_EGL_IMAGE = 9;
    public static final int FILTER_FACE_ALPHABLENDCROSS_SHADER = 102;
    public static final int FILTER_FACE_ALPHABLEND_SHADER = 101;
    public static final int FILTER_FACE_ATTACHCROSS_EX_SHADER = 103;
    public static final int FILTER_FACE_LENSFLARE_SHADER = 100;
    public static final int FILTER_FACE_RGB2YCBCR_SHADER = 1;
    public static final int FILTER_FACE_YCBCR2RGB_SHADER = 2;
    public static final int FILTER_FENNEN_BEAUTY = 26;
    public static final int FILTER_FLARES = 14;
    public static final int FILTER_FLOWBASEDBL = 73;
    public static final int FILTER_FLOWBASEDBLFORPOSTER = 84;
    public static final int FILTER_FLOWBASEDBLUR = 74;
    public static final int FILTER_FLOWBASEDBLURFORPOSTER = 86;
    public static final int FILTER_FLOWBASEDBLURFORPOSTER_Tegra = 87;
    public static final int FILTER_FLOWBASEDDOG = 75;
    public static final int FILTER_FLOWBASEDDOGFOREDGE = 76;
    public static final int FILTER_FLOWBASEDDOGFORPOSTER = 85;
    public static final int FILTER_FRAME_SHADER = 50;
    public static final int FILTER_GAUSSBLURH = 77;
    public static final int FILTER_GAUSSBLURV = 78;
    public static final int FILTER_GAUSSBLUR_H = 69;
    public static final int FILTER_GAUSSBLUR_V = 68;
    public static final int FILTER_GAUSS_INNER_H_FRAG = 46;
    public static final int FILTER_GAUSS_INNER_V_FRAG = 47;
    public static final int FILTER_GLOWCENTER_BEAUTY = 19;
    public static final int FILTER_GPULEVELS1_SHADER = 125;
    public static final int FILTER_GPULEVELSEX_SHADER = 122;
    public static final int FILTER_GPULEVELS_SHADER = 109;
    public static final int FILTER_GRAYFILTERP = 79;
    public static final int FILTER_GRAYFORMANGA_SHADER = 89;
    public static final int FILTER_HARDLIGHTBLEND2_SHADER = 134;
    public static final int FILTER_HARDLIGHTBLEND_SHADER = 62;
    public static final int FILTER_HIGHTLIGHT_SHADOW_SHADER = 111;
    public static final int FILTER_HIPASS_BEAUTY = 17;
    public static final int FILTER_HISTOGRAMS_STRCTCH = 32;
    public static final int FILTER_HONGRUN_BEAUTYP2 = 42;
    public static final int FILTER_HORIZONTAL_BEAUTY = 15;
    public static final int FILTER_HSVADJUSTER2_SHADER = 108;
    public static final int FILTER_HSVADJUSTER_SHADER = 60;
    public static final int FILTER_HSVNCHANNEL_SHARPEN_SHADER = 112;
    public static final int FILTER_HSVTORGB = 29;
    public static final int FILTER_INPUT2_SHADER = 126;
    public static final int FILTER_LAB2RGB_SHADER = 124;
    public static final int FILTER_LIEYANHONGCHUN_BEAUTY = 23;
    public static final int FILTER_LUMINOSITY_BLEND_SHADER = 110;
    public static final int FILTER_MANGAFORSAVE_SHADER = 95;
    public static final int FILTER_MANGA_SHADER = 92;
    public static final int FILTER_MARK = 66;
    public static final int FILTER_MEIFU_BEAUTY = 25;
    public static final int FILTER_MIC_CURE_NEW_SHADER = 54;
    public static final int FILTER_MIC_CURE_SHADER = 97;
    public static final int FILTER_MIXEDGEFILTEREDIT = 80;
    public static final int FILTER_MIXEDGENOSTAGE = 81;
    public static final int FILTER_NEW_SKETCH = 67;
    public static final int FILTER_NIGHT_BOKEH = 27;
    public static final int FILTER_NIGHT_BOKEH_EX = 39;
    public static final int FILTER_NIGHT_RGBSTRETCH = 88;
    public static final int FILTER_NONMAXSUPRESS_SHADER = 90;
    public static final int FILTER_NONMAXSUPRESS_SHADER_LOWDEVICE = 96;
    public static final int FILTER_OVERLAP_BEAUTY = 18;
    public static final int FILTER_OVERLAY_BLEND2_SHADER = 115;
    public static final int FILTER_QINXINMEIBAI_BEAUTY = 20;
    public static final int FILTER_RGB2LAB_SHADER = 123;
    public static final int FILTER_RGB2YUV_SHADER = 44;
    public static final int FILTER_RGBTOHSV = 28;
    public static final int FILTER_SELECTIVECOLOR_SHADER = 98;
    public static final int FILTER_SHADER_AUTOLEVEL_HIS = 65;
    public static final int FILTER_SHADER_BEAUTY = 12;
    public static final int FILTER_SHADER_BEAUTY_HIPASS_REAL = 121;
    public static final int FILTER_SHADER_BEAUTY_HORIZONTAL_REAL = 119;
    public static final int FILTER_SHADER_BEAUTY_VERTICAL_REAL = 120;
    public static final int FILTER_SHADER_CHANNEL_MIXER = 58;
    public static final int FILTER_SHADER_COLORBURN_BLEND = 128;
    public static final int FILTER_SHADER_COLOR_BALANCE = 57;
    public static final int FILTER_SHADER_COLOR_TEMP = 55;
    public static final int FILTER_SHADER_DARKEN_BLEND = 63;
    public static final int FILTER_SHADER_EXPOSURE = 64;
    public static final int FILTER_SHADER_HSVCOLOR_0 = 129;
    public static final int FILTER_SHADER_HSVCOLOR_1 = 130;
    public static final int FILTER_SHADER_HSVCOLOR_2 = 131;
    public static final int FILTER_SHADER_HSVCOLOR_3 = 132;
    public static final int FILTER_SHADER_HSVCOLOR_ALL = 133;
    public static final int FILTER_SHADER_MIC_CURE_MASK = 107;
    public static final int FILTER_SHADER_MULTIPLY_BLEND = 59;
    public static final int FILTER_SHADER_MULTIPLY_BLEND_3 = 127;
    public static final int FILTER_SHADER_MULTIPLY_BLEND_4 = 135;
    public static final int FILTER_SHADER_MULTIPLY_BLEND_RSS = 117;
    public static final int FILTER_SHADER_NONE = 0;
    public static final int FILTER_SHADER_SCREEN_BLEND = 56;
    public static final int FILTER_SHADER_SCREEN_BLEND_OLD = 118;
    public static final int FILTER_SHADER_SELECTIVECOLOR = 106;
    public static final int FILTER_SHADER_VIVID_LIGHT_BLEND = 136;
    public static final int FILTER_SHADER_YUV = 11;
    public static final int FILTER_SHADER_YUV420P = 105;
    public static final int FILTER_SHENDUMEIBAI_BEAUTY = 22;
    public static final int FILTER_SHENDUMEIBAI_BEAUTY_SHUIYIN = 43;
    public static final int FILTER_SOBELBLUR_SHADER = 91;
    public static final int FILTER_SOBELFORMANGA_SHADER = 94;
    public static final int FILTER_SOFTLIGHTBLEND2_SHADER = 116;
    public static final int FILTER_SOFTLIGHTBLEND_SHADER = 61;
    public static final int FILTER_SPRING_MORPH_SHADER = 104;
    public static final int FILTER_STRUCTTENSORFILTER = 82;
    public static final int FILTER_STRUCTTENSORFORPOSTER = 83;
    public static final int FILTER_TEXTREPET_SHADER = 51;
    public static final int FILTER_TIANMEIKEREN_BEAUTY = 21;
    public static final int FILTER_TIANMEIKEREN_BEAUTYP2 = 40;
    public static final int FILTER_TIANSHENLIZHI_BEAUTY = 24;
    public static final int FILTER_TILT_TOUCH_CIRCLE_NEW = 34;
    public static final int FILTER_TILT_TOUCH_ECLIPSE_NEW = 35;
    public static final int FILTER_TILT_TOUCH_GAUSS = 37;
    public static final int FILTER_TILT_TOUCH_LINE_NEW = 36;
    public static final int FILTER_TILT_TOUCH_MASK = 38;
    public static final int FILTER_TILT_TOUCH_MASK2 = 53;
    public static final int FILTER_TONEADJUST_SHADER = 99;
    public static final int FILTER_VERTICAL_BEAUTY = 16;
    public static final int FILTER_VIBRANCE = 13;
    public static final int FILTER_YANGGUANG_BEAUTYP2 = 41;
    public static final int FILTER_YUV2RGB_SHADER = 45;
    public static final int GL_TEXTURE_2D = 3553;
    public static final int GL_TEXTURE_EXTERNAL_OES_ENUM = 36197;
    public static final int SHARE_SHADER_FILM_1 = 5;
    public static final int SHARE_SHADER_FILM_2 = 6;
    public static final int VERTEXT_DAMPING_GAUSS_H = 5;
    public static final int VERTEXT_FRAMEORIGIN_SHADER = 7;
    public static final int VERTEXT_FRAMESTRETCH_SHADER = 8;
    public static final int VERTEXT_FRAME_SHADER = 6;
    public static final int VERTEXT_GAUSS_INNER_H = 3;
    public static final int VERTEXT_GAUSS_INNER_V = 4;
    public static final int VERTEXT_GRAYFORMANGA_SHADER = 9;
    public static final int VERTEXT_HSVCHANNELSHARPEN_SHADER = 13;
    public static final int VERTEXT_LENSFLARE_SHADER = 12;
    public static final int VERTEXT_SHADER_DEFAULT = 1;
    public static final int VERTEXT_SHADER_JNI = 0;
    public static final int VERTEXT_SHADER_SHARPEN = 2;
    public static final int VERTEXT_SOBELBLUR_SHADER = 11;
    public static final int VERTEXT_SOBELFORMANGA_SHADER = 10;

    public GLSLRender() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static native long nativeAllocBuffer(int i3);

    public static native void nativeBeginUseEglImage(int i3, int i16, int i17);

    public static native void nativeCalHistogramFromGPU(long j3, long j16, int i3, int i16, int i17, int i18, float f16, float f17, int i19, int i26, float f18, float f19);

    public static native int nativeCheckMagicEngine(int i3, int i16);

    public static native int nativeCopyPixelToBitmap(Bitmap bitmap);

    public static native int nativeCopyPixelToBitmapWithShare(Bitmap bitmap, int i3, int i16);

    public static native void nativeCopyTexturToDataWithShare(int i3, byte[] bArr, int i16, int i17, int i18);

    public static native QImage nativeCopyTexture(int i3, int i16);

    public static native void nativeCopyTexture2(QImage qImage);

    public static native QImage nativeCopyTextureWithShare(int i3, int i16, int i17, int i18);

    public static native int nativeDeinitMagicEngine(int i3);

    public static native void nativeEndUseEglImage(int i3, int i16, int i17);

    public static native void nativeFreeBuffer(long j3);

    public static native int nativeInitMagicEngine(int i3, int i16);

    public static native void nativePickJepgToTexture(QImage qImage, int i3, int i16, int i17, int i18, int i19, int[] iArr);

    public static native void nativePreprocessJepg(QImage qImage, int[] iArr);

    public static native void nativePreviewData(byte[] bArr, int i3, int i16, int i17);

    public static native void nativePreviewYuvData(byte[] bArr, int i3, int i16, int i17);

    public static native void nativePushBitmapFromTexture(Bitmap bitmap, int i3);

    public static native void nativePushDataFromTexture(byte[] bArr, int i3, int i16, int i17);

    public static native void nativePushJepgFromTexture(QImage qImage, int i3, int i16, int i17, int i18, int i19);

    public static native int nativeRenderPixelToBitmap(Bitmap bitmap, int i3, int i16);

    public static native int nativeSnap(Bitmap bitmap);

    public static native void nativeTextCure(int[] iArr, int i3);

    public static native void nativeTextImage(QImage qImage, int i3);

    public static native void nativeToRGBData(byte[] bArr, int i3, int i16);

    public static native void nativeUpdateScaleBitmap(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, int i3, int i16);
}
