package com.tencent.filter.ttpic;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.aekit.openrender.UniformParam;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.TextureResParam;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.encrypt.FileEncryptUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.io.IOUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/* loaded from: classes6.dex */
public class GPUImageLookupFilter extends BaseFilter {
    public static final String LOOKUP_FRAGMENT_SHADER1 = "varying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform lowp float alpha;\nvoid main() {\nhighp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\nhighp float blueColor = textureColor.b * 63.0;\nhighp vec2 quad1; quad1.y = floor(floor(blueColor) / 8.0);\nquad1.x = floor(blueColor) - (quad1.y * 8.0);\nhighp vec2 quad2;\nquad2.y = floor(ceil(blueColor) / 8.0);\nquad2.x = ceil(blueColor) - (quad2.y * 8.0);\nhighp vec2 texPos1;\ntexPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\ntexPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\nhighp vec2 texPos2;\ntexPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\ntexPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\nlowp vec4 newColor1 = texture2D(inputImageTexture2, texPos1);\nlowp vec4 newColor2 = texture2D(inputImageTexture2, texPos2);\nlowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\nnewColor = mix(newColor, textureColor, alpha);\ngl_FragColor = vec4(newColor.rgb, textureColor.w);\n}\n";
    public static String jarPath;
    private String thisPath;

    public GPUImageLookupFilter() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap decodeBitmap(String str, boolean z16) {
        byte[] bArr;
        byte[] bArr2;
        InputStream inputStreamByName;
        try {
            if (!z16) {
                inputStreamByName = new FileInputStream(new File(str));
            } else {
                inputStreamByName = BitmapUtils.getInputStreamByName(FileUtils.getRealPath(str));
            }
            if (inputStreamByName == null) {
                LogUtils.e("BitmapUtils", "decodeBitmap  getStream " + str + " not exist");
            }
            bArr2 = FileEncryptUtils.decryptFile(inputStreamByName);
        } catch (Exception e16) {
            e = e16;
            bArr = null;
        }
        try {
            IOUtils.closeQuietly(inputStreamByName);
        } catch (Exception e17) {
            bArr = bArr2;
            e = e17;
            LogUtils.e("BitmapUtils", "decodeBitmap  getStream", e, new Object[0]);
            bArr2 = bArr;
            if (bArr2 != null) {
            }
        }
        if (bArr2 != null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        try {
            return BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length, options);
        } catch (OutOfMemoryError e18) {
            LogUtils.e("BitmapUtils", "decodeByteArray", e18, new Object[0]);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap decodeJarBitmap(String str) {
        JarFile jarFile;
        Throwable th5;
        InputStream inputStream;
        byte[] bArr;
        try {
            jarFile = new JarFile(jarPath);
        } catch (Exception e16) {
            e = e16;
            inputStream = null;
            jarFile = null;
        } catch (Throwable th6) {
            jarFile = null;
            th5 = th6;
            inputStream = null;
        }
        try {
            ZipEntry entry = jarFile.getEntry("com/tencent/view/raw/" + str);
            if (entry != null) {
                inputStream = jarFile.getInputStream(entry);
                try {
                    try {
                        bArr = FileEncryptUtils.decryptFile(inputStream);
                    } catch (Throwable th7) {
                        th5 = th7;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e17) {
                                LogUtils.e(e17);
                            }
                        }
                        if (jarFile == null) {
                            try {
                                jarFile.close();
                                throw th5;
                            } catch (Exception e18) {
                                LogUtils.e(e18);
                                throw th5;
                            }
                        }
                        throw th5;
                    }
                } catch (Exception e19) {
                    e = e19;
                    LogUtils.e(e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e26) {
                            LogUtils.e(e26);
                        }
                    }
                    if (jarFile != null) {
                        try {
                            jarFile.close();
                        } catch (Exception e27) {
                            LogUtils.e(e27);
                        }
                    }
                    bArr = null;
                    if (bArr != null) {
                    }
                }
            } else {
                inputStream = null;
                bArr = null;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e28) {
                    LogUtils.e(e28);
                }
            }
            try {
                jarFile.close();
            } catch (Exception e29) {
                LogUtils.e(e29);
            }
        } catch (Exception e36) {
            e = e36;
            inputStream = null;
        } catch (Throwable th8) {
            th5 = th8;
            inputStream = null;
            if (inputStream != null) {
            }
            if (jarFile == null) {
            }
        }
        if (bArr != null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        try {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } catch (OutOfMemoryError e37) {
            LogUtils.e("FilterDefault", "decodeByteArray", e37, new Object[0]);
            return null;
        }
    }

    private void initParams(String str) {
        addParam(new UniformParam.FloatParam(c.f123400v, 0.0f));
        if (TextUtils.isEmpty(str)) {
            addParam(new UniformParam.TextureParam("inputImageTexture2", 0, 33986));
        } else {
            addParam(new TextureResParam("inputImageTexture2", str, 33986));
        }
    }

    @Override // com.tencent.filter.BaseFilter
    public void setAdjustParam(float f16) {
        addParam(new UniformParam.FloatParam(c.f123400v, f16));
    }

    public void updateLut(String str) {
        Bitmap decodeBitmap;
        if (this.thisPath.equals(str)) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.thisPath = "";
            UniformParam andRemoveParam = getAndRemoveParam("inputImageTexture2");
            if (andRemoveParam != null) {
                andRemoveParam.clear();
                return;
            }
            return;
        }
        this.thisPath = str;
        UniformParam andRemoveParam2 = getAndRemoveParam("inputImageTexture2");
        if (andRemoveParam2 != null) {
            andRemoveParam2.clear();
        }
        if (jarPath != null) {
            decodeBitmap = decodeJarBitmap(str);
        } else if (!TextUtils.isEmpty(str) && str.startsWith("assets://")) {
            decodeBitmap = decodeBitmap(str, true);
        } else {
            decodeBitmap = decodeBitmap(str, false);
        }
        UniformParam.TextureBitmapParam textureBitmapParam = new UniformParam.TextureBitmapParam("inputImageTexture2", decodeBitmap, 33986, true);
        addParam(textureBitmapParam);
        textureBitmapParam.initialParams(getProgramIds());
    }

    public GPUImageLookupFilter(String str) {
        super("varying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform lowp float alpha;\nvoid main() {\nhighp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\nhighp float blueColor = textureColor.b * 63.0;\nhighp vec2 quad1; quad1.y = floor(floor(blueColor) / 8.0);\nquad1.x = floor(blueColor) - (quad1.y * 8.0);\nhighp vec2 quad2;\nquad2.y = floor(ceil(blueColor) / 8.0);\nquad2.x = ceil(blueColor) - (quad2.y * 8.0);\nhighp vec2 texPos1;\ntexPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\ntexPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\nhighp vec2 texPos2;\ntexPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\ntexPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\nlowp vec4 newColor1 = texture2D(inputImageTexture2, texPos1);\nlowp vec4 newColor2 = texture2D(inputImageTexture2, texPos2);\nlowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\nnewColor = mix(newColor, textureColor, alpha);\ngl_FragColor = vec4(newColor.rgb, textureColor.w);\n}\n");
        this.thisPath = "";
        initParams(str);
    }
}
