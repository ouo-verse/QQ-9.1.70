package com.tencent.filter.ttpic;

import java.util.Locale;

/* loaded from: classes6.dex */
public class HFGPUShaderFactory {
    private static String kGPUImagePassthroughFragmentShaderString = "precision highp float;\nvarying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n void main()\n {\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n }\n";
    private static String kGPUImageVertexShaderString = "precision highp float;\nattribute vec4 position;\nattribute vec2 inputTextureCoordinate;\nvarying vec2 textureCoordinate;\nuniform mat4 Projection;\nuniform mat4 Modelview; \nuniform mat4 textureMat; \nuniform mat4 tMat;\nvoid main(void)\n{\ngl_Position = Projection * Modelview *position;\nvec4 tmp = tMat*vec4(inputTextureCoordinate.x,inputTextureCoordinate.y,0.0,1.0);\ntextureCoordinate = tmp.xy;\n}\n";

    public static String gaussianFragmentShaderForBorderOfRadius(int i3, float f16) {
        if (i3 < 1) {
            return kGPUImagePassthroughFragmentShaderString;
        }
        int i16 = i3 + 1;
        float[] fArr = new float[i16];
        float f17 = 0.0f;
        for (int i17 = 0; i17 < i16; i17++) {
            double d16 = f16;
            float sqrt = (float) ((1.0d / Math.sqrt(Math.pow(d16, 2.0d) * 6.283185307179586d)) * Math.exp((-Math.pow(i17, 2.0d)) / (Math.pow(d16, 2.0d) * 2.0d)));
            fArr[i17] = sqrt;
            if (i17 == 0) {
                f17 += sqrt;
            } else {
                f17 = (float) (f17 + (sqrt * 2.0d));
            }
        }
        for (int i18 = 0; i18 < i16; i18++) {
            fArr[i18] = fArr[i18] / f17;
        }
        int min = Math.min((i3 / 2) + (i3 % 2), 100);
        float[] fArr2 = new float[min];
        for (int i19 = 0; i19 < min; i19++) {
            int i26 = i19 * 2;
            int i27 = i26 + 1;
            float f18 = fArr[i27];
            int i28 = i26 + 2;
            float f19 = fArr[i28];
            fArr2[i19] = ((f18 * i27) + (f19 * i28)) / (f18 + f19);
        }
        Locale locale = Locale.ENGLISH;
        String str = ((((((String.format(locale, "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform float horStep;\nuniform float verStep;\nvarying vec2 textureCoordinate;\nvoid main(void)\n{\nlowp vec4 sum = texture2D(inputImageTexture, textureCoordinate.xy);\n", Integer.valueOf((min * 2) + 1)) + "if (sum.a > 0.0001) {\n") + "    float ratio = 1.0;\n") + String.format(locale, "    ratio = ratio * %f;\n", Float.valueOf(fArr[0]))) + "    highp vec2 singleStepOffsetX = vec2(horStep, 0.0);\n") + "    highp vec2 singleStepOffsetY = vec2(0.0, verStep);\n") + "    highp vec2 singleStepOffsetSlash1 = singleStepOffsetX + singleStepOffsetY;\n") + "    highp vec2 singleStepOffsetSlash2 = singleStepOffsetX - singleStepOffsetY;\n";
        for (int i29 = 0; i29 < min; i29++) {
            int i36 = i29 * 2;
            float f26 = fArr[i36 + 1] + fArr[i36 + 2];
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            Locale locale2 = Locale.ENGLISH;
            sb5.append(String.format(locale2, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffsetX * %f).a * %f * 0.25;\n", Float.valueOf(fArr2[i29]), Float.valueOf(f26)));
            str = ((((((sb5.toString() + String.format(locale2, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffsetX * %f).a * %f * 0.25;\n", Float.valueOf(fArr2[i29]), Float.valueOf(f26))) + String.format(locale2, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffsetY * %f).a * %f * 0.25;\n", Float.valueOf(fArr2[i29]), Float.valueOf(f26))) + String.format(locale2, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffsetY * %f).a * %f * 0.25;\n", Float.valueOf(fArr2[i29]), Float.valueOf(f26))) + String.format(locale2, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffsetSlash1 * %f).a * %f * 0.25;\n", Float.valueOf(fArr2[i29]), Float.valueOf(f26))) + String.format(locale2, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffsetSlash1 * %f).a * %f * 0.25;\n", Float.valueOf(fArr2[i29]), Float.valueOf(f26))) + String.format(locale2, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffsetSlash2 * %f).a * %f * 0.25;\n", Float.valueOf(fArr2[i29]), Float.valueOf(f26))) + String.format(locale2, "    ratio = ratio + texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffsetSlash2 * %f).a * %f * 0.25;\n", Float.valueOf(fArr2[i29]), Float.valueOf(f26));
        }
        return ((((str + "ratio = ratio * 2.0 - 1.0;\n") + "sum = sum * ratio;\n") + "}\n") + "gl_FragColor = sum;\n") + "}\n";
    }

    public static String gaussianFragmentShaderForOptimizedBlurOfRadius(int i3, float f16, boolean z16) {
        String str;
        if (i3 < 1) {
            return kGPUImagePassthroughFragmentShaderString;
        }
        int i16 = i3 + 1;
        float[] fArr = new float[i16];
        float f17 = 0.0f;
        for (int i17 = 0; i17 < i16; i17++) {
            double d16 = f16;
            float sqrt = (float) ((1.0d / Math.sqrt(Math.pow(d16, 2.0d) * 6.283185307179586d)) * Math.exp((-Math.pow(i17, 2.0d)) / (Math.pow(d16, 2.0d) * 2.0d)));
            fArr[i17] = sqrt;
            if (i17 == 0) {
                f17 += sqrt;
            } else {
                f17 = (float) (f17 + (sqrt * 2.0d));
            }
        }
        for (int i18 = 0; i18 < i16; i18++) {
            fArr[i18] = fArr[i18] / f17;
        }
        int i19 = (i3 / 2) + (i3 % 2);
        int min = Math.min(i19, 7);
        float[] fArr2 = new float[min];
        for (int i26 = 0; i26 < min; i26++) {
            int i27 = i26 * 2;
            int i28 = i27 + 1;
            float f18 = fArr[i28];
            int i29 = i27 + 2;
            float f19 = fArr[i29];
            fArr2[i26] = ((f18 * i28) + (f19 * i29)) / (f18 + f19);
        }
        Locale locale = Locale.ENGLISH;
        String str2 = String.format(locale, "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform float horStep;\nuniform float verStep;\nvarying vec2 textureCoordinate;\nvoid main(void)\n{\nlowp vec4 sum = vec4(0.0);\n", Integer.valueOf((min * 2) + 1)) + String.format(locale, "sum += texture2D(inputImageTexture, textureCoordinate.xy) * %f;\n", Float.valueOf(fArr[0]));
        if (z16) {
            str = str2 + "highp vec2 singleStepOffset = vec2(horStep, 0.0);\n";
        } else {
            str = str2 + "highp vec2 singleStepOffset = vec2(0.0, verStep);\n";
        }
        for (int i36 = 0; i36 < min; i36++) {
            int i37 = i36 * 2;
            float f26 = fArr[i37 + 1] + fArr[i37 + 2];
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            Locale locale2 = Locale.ENGLISH;
            sb5.append(String.format(locale2, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f) * %f;\n", Float.valueOf(fArr2[i36]), Float.valueOf(f26)));
            str = sb5.toString() + String.format(locale2, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f) * %f;\n", Float.valueOf(fArr2[i36]), Float.valueOf(f26));
        }
        if (i19 > min) {
            while (min < i19) {
                int i38 = min * 2;
                int i39 = i38 + 1;
                float f27 = fArr[i39];
                int i46 = i38 + 2;
                float f28 = fArr[i46];
                float f29 = f27 + f28;
                float f36 = ((f27 * i39) + (f28 * i46)) / f29;
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str);
                Locale locale3 = Locale.ENGLISH;
                sb6.append(String.format(locale3, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f) * %f;\n", Float.valueOf(f36), Float.valueOf(f29)));
                str = sb6.toString() + String.format(locale3, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f) * %f;\n", Float.valueOf(f36), Float.valueOf(f29));
                min++;
            }
        }
        return (str + "gl_FragColor = sum;\n") + "}\n";
    }

    public static String gaussianFragmentShaderForOptimizedBlurOfRadiusOpt1(int i3, float f16, boolean z16, boolean z17) {
        String str;
        String str2;
        String str3;
        if (i3 < 1) {
            return kGPUImagePassthroughFragmentShaderString;
        }
        int i16 = i3 + 1;
        float[] fArr = new float[i16];
        float f17 = 0.0f;
        for (int i17 = 0; i17 < i16; i17++) {
            double d16 = f16;
            float sqrt = (float) ((1.0d / Math.sqrt(Math.pow(d16, 2.0d) * 6.283185307179586d)) * Math.exp((-Math.pow(i17, 2.0d)) / (Math.pow(d16, 2.0d) * 2.0d)));
            fArr[i17] = sqrt;
            if (i17 == 0) {
                f17 += sqrt;
            } else {
                f17 = (float) (f17 + (sqrt * 2.0d));
            }
        }
        for (int i18 = 0; i18 < i16; i18++) {
            fArr[i18] = fArr[i18] / f17;
        }
        int i19 = (i3 / 2) + (i3 % 2);
        int min = Math.min(i19, 7);
        float[] fArr2 = new float[min];
        for (int i26 = 0; i26 < min; i26++) {
            int i27 = i26 * 2;
            int i28 = i27 + 1;
            float f18 = fArr[i28];
            int i29 = i27 + 2;
            float f19 = fArr[i29];
            fArr2[i26] = ((f18 * i28) + (f19 * i29)) / (f18 + f19);
        }
        Locale locale = Locale.ENGLISH;
        String format = String.format(locale, "precision highp float;\nuniform sampler2D inputImageTexture;\nuniform float horStep;\nuniform float verStep;\nvarying vec2 textureCoordinate;\nvoid main(void)\n{\n vec4 color = texture2D(inputImageTexture,textureCoordinate);\nlowp float sum = 0.0;\n", Integer.valueOf((min * 2) + 1));
        if (z16) {
            str = format + String.format(locale, "sum += texture2D(inputImageTexture, textureCoordinate.xy).g * %f;\n", Float.valueOf(fArr[0]));
        } else {
            str = format + String.format(locale, "sum += texture2D(inputImageTexture, textureCoordinate.xy).a * %f;\n", Float.valueOf(fArr[0]));
        }
        if (z17) {
            str2 = str + "highp vec2 singleStepOffset = vec2(horStep, 0.0);\n";
        } else {
            str2 = str + "highp vec2 singleStepOffset = vec2(0.0, verStep);\n";
        }
        for (int i36 = 0; i36 < min; i36++) {
            int i37 = i36 * 2;
            float f26 = fArr[i37 + 1] + fArr[i37 + 2];
            if (z16) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str2);
                Locale locale2 = Locale.ENGLISH;
                sb5.append(String.format(locale2, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f).g * %f;\n", Float.valueOf(fArr2[i36]), Float.valueOf(f26)));
                str2 = sb5.toString() + String.format(locale2, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f).g * %f;\n", Float.valueOf(fArr2[i36]), Float.valueOf(f26));
            } else {
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str2);
                Locale locale3 = Locale.ENGLISH;
                sb6.append(String.format(locale3, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f).a * %f;\n", Float.valueOf(fArr2[i36]), Float.valueOf(f26)));
                str2 = sb6.toString() + String.format(locale3, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f).a * %f;\n", Float.valueOf(fArr2[i36]), Float.valueOf(f26));
            }
        }
        if (i19 > min) {
            while (min < i19) {
                int i38 = min * 2;
                int i39 = i38 + 1;
                float f27 = fArr[i39];
                int i46 = i38 + 2;
                float f28 = fArr[i46];
                float f29 = f27 + f28;
                float f36 = ((f27 * i39) + (f28 * i46)) / f29;
                if (z16) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(str2);
                    Locale locale4 = Locale.ENGLISH;
                    sb7.append(String.format(locale4, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f).g * %f;\n", Float.valueOf(f36), Float.valueOf(f29)));
                    str3 = sb7.toString() + String.format(locale4, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f).g * %f;\n", Float.valueOf(f36), Float.valueOf(f29));
                } else {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(str2);
                    Locale locale5 = Locale.ENGLISH;
                    sb8.append(String.format(locale5, "sum += texture2D(inputImageTexture, textureCoordinate.xy + singleStepOffset * %f).a * %f;\n", Float.valueOf(f36), Float.valueOf(f29)));
                    str3 = sb8.toString() + String.format(locale5, "sum += texture2D(inputImageTexture, textureCoordinate.xy - singleStepOffset * %f).a * %f;\n", Float.valueOf(f36), Float.valueOf(f29));
                }
                str2 = str3;
                min++;
            }
        }
        return ((str2 + "color.a = sum;\n") + "gl_FragColor = color;\n") + "}\n";
    }
}
