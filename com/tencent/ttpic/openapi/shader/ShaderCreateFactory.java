package com.tencent.ttpic.openapi.shader;

import com.tencent.aekit.openrender.internal.Shader;
import com.tencent.filter.BaseFilter;
import com.tencent.ttpic.filter.shader.MCCommonFragmentShaderImageContent;
import com.tencent.ttpic.filter.shader.ShaderContentConstans;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ShaderCreateFactory {
    private static String FRAGMENT_SHADER_IMAGE_FILE = "precision highp float;\nvarying vec2 canvasCoordinate;\nvarying vec2 textureCoordinate;\nvarying float oneOverZ;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform int blendMode;\nuniform vec2 canvasSize;\nuniform float alpha;\nuniform vec2 displacement;\nuniform sampler2D inputImageTexture4;\nuniform int displacementEnableLut; \nuniform sampler2D inputImageTexture5;\nuniform float useDisplacementMask; \n\n vec4 blendColor(vec4 texColor, vec4 canvasColor)\n {\n     vec3 vOne = vec3(1.0, 1.0, 1.0);\n     vec3 vZero = vec3(0.0, 0.0, 0.0);\n     //revert pre multiply\n     if(texColor.a > 0.0){\n        texColor.rgb = texColor.rgb / texColor.a;\n     }\n     vec3 resultFore = texColor.rgb;\n     if (blendMode <= 1 || blendMode > 12){ //default, since used most, put on top\n\n     } else if (blendMode == 2) {  //multiply\n         resultFore = canvasColor.rgb * texColor.rgb;\n     } else if (blendMode == 3){    //screen\n         resultFore = vOne - (vOne - canvasColor.rgb) * (vOne - texColor.rgb);\n     } else if (blendMode == 4){    //overlay\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n         if (canvasColor.r >= 0.5) {\n             resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n         }\n         if (canvasColor.g >= 0.5) {\n             resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n         }\n         if (canvasColor.b >= 0.5) {\n             resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n         }\n     } else if (blendMode == 5){    //hardlight\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb;\n         if (texColor.r >= 0.5) {\n             resultFore.r = 1.0 - 2.0 * (1.0 - canvasColor.r) * (1.0 - texColor.r);\n         }\n         if (texColor.g >= 0.5) {\n             resultFore.g = 1.0 - 2.0 * (1.0 - canvasColor.g) * (1.0 - texColor.g);\n         }\n         if (texColor.b >= 0.5) {\n             resultFore.b = 1.0 - 2.0 * (1.0 - canvasColor.b) * (1.0 - texColor.b);\n         }\n     } else if (blendMode == 6){    //softlight\n         resultFore = 2.0 * canvasColor.rgb * texColor.rgb + canvasColor.rgb * canvasColor.rgb * (vOne - 2.0 * texColor.rgb);\n         if (texColor.r >= 0.5) {\n             resultFore.r = 2.0 * canvasColor.r * (1.0 - texColor.r) + (2.0 * texColor.r - 1.0) * sqrt(canvasColor.r);\n         }\n         if (texColor.g >= 0.5) {\n             resultFore.g = 2.0 * canvasColor.g * (1.0 - texColor.g) + (2.0 * texColor.g - 1.0) * sqrt(canvasColor.g);\n         }\n         if (texColor.b >= 0.5) {\n             resultFore.b = 2.0 * canvasColor.b * (1.0 - texColor.b) + (2.0 * texColor.b - 1.0) * sqrt(canvasColor.b);\n         }\n     } else if (blendMode == 7){    //divide\n         resultFore = vOne;\n         if (texColor.r > 0.0) {\n             resultFore.r = canvasColor.r / texColor.r;\n         }\n         if (texColor.g > 0.0) {\n             resultFore.g = canvasColor.g / texColor.g;\n         }\n         if (texColor.b > 0.0) {\n             resultFore.b = canvasColor.b / texColor.b;\n         }\n         resultFore = min(vOne, resultFore);\n     } else if (blendMode == 8){    //add\n         resultFore = canvasColor.rgb + texColor.rgb;\n         resultFore = min(vOne, resultFore);\n     } else if (blendMode == 9){    //substract\n         resultFore = canvasColor.rgb - texColor.rgb;\n         resultFore = max(vZero, resultFore);\n     } else if (blendMode == 10){   //diff\n         resultFore = abs(canvasColor.rgb - texColor.rgb);\n     } else if (blendMode == 11){   //darken\n         resultFore = min(canvasColor.rgb, texColor.rgb);\n     } else if (blendMode == 12){   //lighten\n         resultFore = max(canvasColor.rgb, texColor.rgb);\n     }\n     //pre multiply for glBlendFunc\n     vec4 resultColor = vec4(resultFore * texColor.a, texColor.a);\n     return resultColor;\n }\nvec4 lut(vec4 inputColor, sampler2D lutImage) {\n  highp float blueColor = inputColor.b * 63.0;\n  highp vec2 quad1; \n  quad1.y = floor(floor(blueColor) / 8.0);\n  quad1.x = floor(blueColor) - (quad1.y * 8.0);\n  highp vec2 quad2;\n  quad2.y = floor(ceil(blueColor) / 8.0);\n  quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n  highp vec2 texPos1;\n  texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.r);\n  texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.g);\n  highp vec2 texPos2;\n  texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.r);\n  texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * inputColor.g);\n  lowp vec4 newColor1 = texture2D(lutImage, texPos1);\n  lowp vec4 newColor2 = texture2D(lutImage, texPos2);\n  return vec4(mix(newColor1.rgb, newColor2.rgb, fract(blueColor)), inputColor.a);\n}\n\nvoid main(void)\n{\n    vec4 canvasColor = texture2D(inputImageTexture, canvasCoordinate);\n    vec2 offset = vec2(0.0);\n    float displacementMaskAlpha = 1.0; \n    if (useDisplacementMask > 0.5) {\n      vec4 lightnessColor = texture2D(inputImageTexture5, canvasCoordinate); \n      displacementMaskAlpha = lightnessColor.a; \n      if (displacementEnableLut == 1) {\n         lightnessColor = lut(lightnessColor, inputImageTexture4); \n      } \n      float lightness = dot(lightnessColor.rgb, vec3(0.3, 0.6, 0.1)) * 2.0 - 1.0;\n      offset = displacement * lightness; \n    }\n    vec4 texColor = texture2D(inputImageTexture2, (textureCoordinate + offset) / oneOverZ);\n    texColor.a = texColor.a * alpha;\n    gl_FragColor = mix(canvasColor, blendColor(texColor, canvasColor), displacementMaskAlpha);\n}";
    private static final String SHADER_DIR = "camera/camera_video/shader/";
    private static final String TAG = "ShaderCreateFactory";

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'CUSTOM' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class PROGRAM_TYPE {
        private static final /* synthetic */ PROGRAM_TYPE[] $VALUES;
        public static final PROGRAM_TYPE CUSTOM;
        public static final PROGRAM_TYPE STICKER_DOODLE;
        public static final PROGRAM_TYPE STICKER_NORMAL;
        public String fragmentShaderContent;
        public final String vertexShaderContent;

        static {
            String str = "";
            PROGRAM_TYPE program_type = new PROGRAM_TYPE("CUSTOM", 0, str, str) { // from class: com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE.1
                @Override // com.tencent.ttpic.openapi.shader.ShaderCreateFactory.PROGRAM_TYPE
                public Shader createShader() {
                    return null;
                }
            };
            CUSTOM = program_type;
            PROGRAM_TYPE program_type2 = new PROGRAM_TYPE("STICKER_DOODLE", 1, ShaderContentConstans.MCCOMMON_VERTEX_SHADER_DAT, MCCommonFragmentShaderImageContent.CONTENT);
            STICKER_DOODLE = program_type2;
            PROGRAM_TYPE program_type3 = new PROGRAM_TYPE("STICKER_NORMAL", 2, ShaderContentConstans.MCCOMMON_VERTEX_SHADER_DAT, ShaderCreateFactory.getFragmentShaderImageFile());
            STICKER_NORMAL = program_type3;
            $VALUES = new PROGRAM_TYPE[]{program_type, program_type2, program_type3};
        }

        public static PROGRAM_TYPE valueOf(String str) {
            return (PROGRAM_TYPE) Enum.valueOf(PROGRAM_TYPE.class, str);
        }

        public static PROGRAM_TYPE[] values() {
            return (PROGRAM_TYPE[]) $VALUES.clone();
        }

        public Shader createShader() {
            return createShaderFromStringContent();
        }

        @NotNull
        protected Shader createShaderFromStringContent() {
            return new Shader(BaseFilter.nativeDecrypt(this.vertexShaderContent), BaseFilter.nativeDecrypt(this.fragmentShaderContent));
        }

        PROGRAM_TYPE(String str, int i3, String str2, String str3) {
            this.vertexShaderContent = str2;
            this.fragmentShaderContent = str3;
        }
    }

    public static Shader createShader(PROGRAM_TYPE program_type) {
        if (program_type == null) {
            return null;
        }
        return program_type.createShader();
    }

    public static String getFragmentShaderImageFile() {
        return FRAGMENT_SHADER_IMAGE_FILE;
    }
}
