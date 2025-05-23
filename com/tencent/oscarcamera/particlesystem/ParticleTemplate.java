package com.tencent.oscarcamera.particlesystem;

import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.text.TextUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.ttpic.util.GsonUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes22.dex */
public class ParticleTemplate {
    static IPatchRedirector $redirector_;
    public static final String ATTR_COLOR_A;
    public static final String ATTR_COLOR_B;
    public static final String ATTR_COLOR_G;
    public static final String ATTR_COLOR_R;
    public static final String ATTR_EMIT_RATE;
    public static final String ATTR_HEIGHT;
    public static final String ATTR_LIFE;
    public static final String ATTR_MAX_COUNT;
    public static final String ATTR_POS_X;
    public static final String ATTR_POS_Y;
    public static final String ATTR_POS_Z;
    public static final String ATTR_WIDTH;
    private static final String TAG;
    private String mColorA;
    private String mColorB;
    private String mColorG;
    private String mColorR;
    private double mEmitRate;
    private String mHeight;
    private String mLife;
    public int mMaxCount;
    private String mPosX;
    private String mPosY;
    private String mPosZ;
    public Sprite mSprite;
    private ParticleSystemEx mSystem;
    private String mWidth;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12915);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        TAG = ParticleTemplate.class.getSimpleName();
        ATTR_MAX_COUNT = String.format("%s", AttributeConst.MAX_COUNT);
        ATTR_EMIT_RATE = String.format("%s", AttributeConst.EMISSION_RATE);
        ATTR_WIDTH = String.format("%s", "width");
        ATTR_HEIGHT = String.format("%s", "height");
        ATTR_LIFE = String.format("%s", AttributeConst.LIFE);
        ATTR_COLOR_R = String.format("%s", AttributeConst.R);
        ATTR_COLOR_G = String.format("%s", AttributeConst.G);
        ATTR_COLOR_B = String.format("%s", AttributeConst.B);
        ATTR_COLOR_A = String.format("%s", AttributeConst.A);
        ATTR_POS_X = String.format("%s", "positionX");
        ATTR_POS_Y = String.format("%s", "positionY");
        ATTR_POS_Z = String.format("%s", AttributeConst.Z);
    }

    public ParticleTemplate(ParticleSystemEx particleSystemEx) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) particleSystemEx);
            return;
        }
        this.mWidth = "0";
        this.mHeight = "0";
        this.mLife = "0";
        this.mColorR = "0";
        this.mColorG = "0";
        this.mColorB = "0";
        this.mColorA = "0";
        this.mPosX = "0";
        this.mPosY = "0";
        this.mPosZ = "0";
        this.mSystem = particleSystemEx;
        this.mSprite = new Sprite();
    }

    private double doubleValue(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if ((jsonElement instanceof JsonPrimitive) && ((JsonPrimitive) jsonElement).isNumber()) {
            return jsonElement.getAsNumber().doubleValue();
        }
        return 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ParticleTemplate fromJson(ParticleSystemEx particleSystemEx, JsonObject jsonObject, String str) {
        ParticleTemplate particleTemplate = new ParticleTemplate(particleSystemEx);
        try {
            for (String str2 : jsonObject.keySet()) {
                JsonElement jsonElement = jsonObject.get(str2);
                if (jsonElement instanceof JsonPrimitive) {
                    if (((JsonPrimitive) jsonElement).isNumber()) {
                        initAttr(particleTemplate, str2, jsonElement.getAsNumber());
                    } else if (((JsonPrimitive) jsonElement).isString()) {
                        initAttr(particleTemplate, str2, jsonElement.getAsString());
                    }
                } else if ((jsonElement instanceof JsonObject) && TextUtils.equals(str2, "sprite")) {
                    particleTemplate.initSprite((JsonObject) jsonElement, str);
                } else if ((jsonElement instanceof JsonObject) && TextUtils.equals(str2, "audio")) {
                    particleTemplate.mSprite.audioPath = GsonUtils.getStringUnsafe((JsonObject) jsonElement, "path");
                }
            }
            return particleTemplate;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private static void initAttr(ParticleTemplate particleTemplate, String str, Object obj) {
        String str2;
        double d16;
        int i3;
        if (obj instanceof String) {
            str2 = (String) obj;
        } else if (obj instanceof Number) {
            str2 = obj.toString();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            return;
        }
        if (TextUtils.equals(ATTR_MAX_COUNT, str)) {
            if (obj instanceof Number) {
                i3 = ((Number) obj).intValue();
            } else {
                i3 = 0;
            }
            particleTemplate.mMaxCount = i3;
            if (i3 < 0) {
                particleTemplate.mMaxCount = 0;
                return;
            }
            return;
        }
        if (TextUtils.equals(ATTR_EMIT_RATE, str)) {
            if (obj instanceof Number) {
                d16 = ((Number) obj).doubleValue();
            } else {
                d16 = 0.0d;
            }
            particleTemplate.mEmitRate = d16;
            if (d16 < 0.0d) {
                particleTemplate.mEmitRate = 0.0d;
                return;
            }
            return;
        }
        if (TextUtils.equals(ATTR_WIDTH, str)) {
            particleTemplate.mWidth = str2;
            return;
        }
        if (TextUtils.equals(ATTR_HEIGHT, str)) {
            particleTemplate.mHeight = str2;
            return;
        }
        if (TextUtils.equals(ATTR_LIFE, str)) {
            particleTemplate.mLife = str2;
            return;
        }
        if (TextUtils.equals(ATTR_COLOR_R, str)) {
            particleTemplate.mColorR = str2;
            return;
        }
        if (TextUtils.equals(ATTR_COLOR_G, str)) {
            particleTemplate.mColorG = str2;
            return;
        }
        if (TextUtils.equals(ATTR_COLOR_B, str)) {
            particleTemplate.mColorB = str2;
            return;
        }
        if (TextUtils.equals(ATTR_COLOR_A, str)) {
            particleTemplate.mColorA = str2;
            return;
        }
        if (TextUtils.equals(ATTR_POS_X, str)) {
            particleTemplate.mPosX = str2;
        } else if (TextUtils.equals(ATTR_POS_Y, str)) {
            particleTemplate.mPosY = str2;
        } else if (TextUtils.equals(ATTR_POS_Z, str)) {
            particleTemplate.mPosZ = str2;
        }
    }

    private void initSprite(JsonObject jsonObject, String str) {
        InputStream open;
        this.mSprite.path = GsonUtils.optString(jsonObject, "path");
        String str2 = str + File.separator + this.mSprite.path;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        if (str2.startsWith("/")) {
            BitmapFactory.decodeFile(str2, options);
        } else {
            InputStream inputStream = null;
            try {
                try {
                    try {
                        open = this.mSystem.mContext.getAssets().open(str2);
                        try {
                            BitmapFactory.decodeStream(open, null, options);
                        } catch (IOException e16) {
                            e = e16;
                            inputStream = open;
                            e.printStackTrace();
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (options.outWidth == 0) {
                            }
                            throw new RuntimeException("tex outWith or outHeight is 0");
                        } catch (Throwable th5) {
                            th = th5;
                            inputStream = open;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (IOException e18) {
                    e = e18;
                }
                if (open != null) {
                    open.close();
                }
            } catch (IOException e19) {
                e19.printStackTrace();
            }
        }
        if (options.outWidth == 0 && options.outHeight != 0) {
            this.mSprite.frameCount = (int) doubleValue(jsonObject, "frameCount");
            this.mSprite.width = (int) doubleValue(jsonObject, "width");
            this.mSprite.height = (int) doubleValue(jsonObject, "height");
            this.mSprite.blendMode = (int) doubleValue(jsonObject, c.W);
            this.mSprite.animated = (int) doubleValue(jsonObject, "animated");
            this.mSprite.looped = (int) doubleValue(jsonObject, "looped");
            this.mSprite.frameDuration = doubleValue(jsonObject, "frameDuration");
            Sprite sprite = this.mSprite;
            preCalTexCoords(sprite, options.outWidth, options.outHeight, sprite.width, sprite.height);
            return;
        }
        throw new RuntimeException("tex outWith or outHeight is 0");
    }

    private void preCalTexCoords(Sprite sprite, int i3, int i16, int i17, int i18) {
        int i19 = i16 / i18;
        int i26 = i3 / i17;
        float f16 = (i17 * 1.0f) / i3;
        float f17 = (i18 * 1.0f) / i16;
        sprite.texCoords = new float[i19 * i26 * 12];
        int i27 = 0;
        for (int i28 = 0; i28 < i19; i28++) {
            int i29 = 0;
            while (i29 < i26) {
                PointF pointF = new PointF(i29 * f16, i28 * f17);
                PointF pointF2 = new PointF(pointF.x, pointF.y + f17);
                PointF pointF3 = new PointF(pointF.x + f16, pointF.y);
                PointF pointF4 = new PointF(pointF3.x, pointF.y + f17);
                float[] fArr = sprite.texCoords;
                int i36 = i27 + 1;
                float f18 = pointF3.x;
                fArr[i27] = f18;
                int i37 = i36 + 1;
                float f19 = pointF3.y;
                fArr[i36] = f19;
                int i38 = i37 + 1;
                fArr[i37] = pointF4.x;
                int i39 = i38 + 1;
                fArr[i38] = pointF4.y;
                int i46 = i39 + 1;
                float f26 = pointF2.x;
                fArr[i39] = f26;
                int i47 = i46 + 1;
                float f27 = pointF2.y;
                fArr[i46] = f27;
                int i48 = i47 + 1;
                fArr[i47] = f18;
                int i49 = i48 + 1;
                fArr[i48] = f19;
                int i56 = i49 + 1;
                fArr[i49] = f26;
                int i57 = i56 + 1;
                fArr[i56] = f27;
                int i58 = i57 + 1;
                fArr[i57] = pointF.x;
                fArr[i58] = pointF.y;
                i29++;
                i27 = i58 + 1;
            }
        }
    }
}
