package com.tencent.sharpP;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageConsts;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.libra.util.ImageContentType;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.sharpP.SharpPDecoderWrapper;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes25.dex */
public class SharpPUtils {
    static IPatchRedirector $redirector_ = null;
    public static final String SHARPP_POSTFIX = "sharpp";
    public static final byte[] SHARPP_PRECODE;
    public static final String TAG = "SharpPUtils";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17046);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            SHARPP_PRECODE = new byte[]{83, 72, 65, 82, 80, 80};
        }
    }

    public SharpPUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void checkNotSharppCacheFileIfNessary(File file, String str) {
        if (file != null && !TextUtils.isEmpty(str) && isSharpP(file) && !isSharpP(str)) {
            ImageKey obtain = ImageKey.obtain();
            try {
                obtain.filePath = file.getAbsolutePath();
                obtain.url = str;
                if (file.exists() && isSharpP(file)) {
                    ImageLoader.getInstance().removeImageFile(obtain.url);
                    ImageManagerEnv.getLogger().e(TAG, "The url is not sharpp but the file is sharpp. delete the sharpp file and download the new file. filename:" + file.getName());
                    if (file.exists()) {
                        ImageManagerLog.w(TAG, "delete sharpp file cache failed. filename:" + file.getName());
                    }
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public static Bitmap decodeSharpP(String str) {
        if (str != null && str.length() != 0) {
            SharpPDecoderHelper sharpPDecoderHelper = new SharpPDecoderHelper(str);
            if (sharpPDecoderHelper.parseHeader() != 0) {
                return null;
            }
            SharpPDecoderWrapper.SharpPFeatureWrapper featureInfo = sharpPDecoderHelper.getFeatureInfo();
            return sharpPDecoderHelper.decodeSharpP(featureInfo.getWidth(), featureInfo.getHeight(), Bitmap.Config.ARGB_8888);
        }
        ImageManagerEnv.getLogger().e(TAG, "------decodeSharpP:path is null");
        return null;
    }

    public static Bitmap decodeSharppPro(String str) {
        if (str != null && str.length() != 0) {
            SharpPDecoderHelper sharpPDecoderHelper = new SharpPDecoderHelper(str);
            if (sharpPDecoderHelper.parseHeader() != 0) {
                return null;
            }
            SharpPDecoderWrapper.SharpPFeatureWrapper featureInfo = sharpPDecoderHelper.getFeatureInfo();
            if (isJpg(sharpPDecoderHelper.getMimeType())) {
                return sharpPDecoderHelper.decodeSharpP2JPG(featureInfo.getWidth(), featureInfo.getHeight(), Bitmap.Config.RGB_565);
            }
            return sharpPDecoderHelper.decodeSharpP2PNG(featureInfo.getWidth(), featureInfo.getHeight(), Bitmap.Config.ARGB_8888);
        }
        ImageManagerEnv.getLogger().e(TAG, "------decodeSharppPro:path is null");
        return null;
    }

    public static void deleteSharppCacheFileIfNessary(File file, String str) {
        if (file != null && !TextUtils.isEmpty(str)) {
            ImageKey obtain = ImageKey.obtain();
            try {
                obtain.filePath = file.getAbsolutePath();
                obtain.url = str;
                if (file.exists() && !ImageManagerEnv.g().isSupportSharpp() && isSharpP(file)) {
                    ImageManagerEnv.g().reportImageDecodingRes(ImageConsts.IMAGE_TYPE_SHARPP, str, file.length(), false, 0L, 5);
                    ImageLoader.getInstance().removeImageFile(obtain.url);
                    ImageManagerEnv.getLogger().e(TAG, "sharpp is not supported,delete sharpp file cache. filename:" + file.getName());
                    if (file.exists()) {
                        ImageManagerLog.w(TAG, "delete sharpp file cache failed. filename:" + file.getName());
                    }
                }
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    public static Map<String, String> getArguments(String str) {
        HashMap hashMap = new HashMap();
        try {
            for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split != null && split.length == 2) {
                    hashMap.put(split[0], URLDecoder.decode(split[1]));
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return hashMap;
    }

    public static Map<String, String> getArgumentsFromURL(String str) {
        Map<String, String> map;
        int indexOf;
        if (str != null && -1 != (indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER))) {
            map = getArguments(str.substring(indexOf + 1));
        } else {
            map = null;
        }
        if (map == null) {
            return new HashMap();
        }
        return map;
    }

    public static String getWebpUrl(String str) {
        if (isSharpP(str)) {
            return str.replace("t=6", "t=5");
        }
        return str;
    }

    public static boolean isJpg(String str) {
        if (!TextUtils.isEmpty(str)) {
            return ImageContentType.MIME_TYPE_JPG.equals(str);
        }
        return false;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x0025 -> B:14:0x0053). Please report as a decompilation issue!!! */
    public static boolean isSharpP(File file) {
        if (file != null) {
            BufferedInputStream bufferedInputStream = null;
            BufferedInputStream bufferedInputStream2 = null;
            BufferedInputStream bufferedInputStream3 = null;
            bufferedInputStream = null;
            try {
            } catch (IOException e16) {
                e16.printStackTrace();
                bufferedInputStream = bufferedInputStream;
            }
            try {
                try {
                    BufferedInputStream bufferedInputStream4 = new BufferedInputStream(new FileInputStream(file), 10);
                    try {
                        byte[] bArr = new byte[6];
                        r0 = bufferedInputStream4.read(bArr, 0, 6) != -1 ? Arrays.equals(bArr, SHARPP_PRECODE) : false;
                        bufferedInputStream4.close();
                        bufferedInputStream = bArr;
                    } catch (FileNotFoundException e17) {
                        e = e17;
                        bufferedInputStream2 = bufferedInputStream4;
                        e.printStackTrace();
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                            bufferedInputStream = bufferedInputStream2;
                        }
                        return r0;
                    } catch (IOException e18) {
                        e = e18;
                        bufferedInputStream3 = bufferedInputStream4;
                        e.printStackTrace();
                        bufferedInputStream = bufferedInputStream3;
                        if (bufferedInputStream3 != null) {
                            bufferedInputStream3.close();
                            bufferedInputStream = bufferedInputStream3;
                        }
                        return r0;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = bufferedInputStream4;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e26) {
                    e = e26;
                } catch (IOException e27) {
                    e = e27;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return r0;
    }

    public static boolean isSharpP(String str) {
        if (str != null && str.length() != 0) {
            String str2 = getArgumentsFromURL(str).get("t");
            return (str2 != null && str2.equals("6")) || (str2 == null && str.lastIndexOf("&t=6#sce") > 0);
        }
        ImageManagerEnv.getLogger().e(TAG, "------isSharpP:url is null");
        return false;
    }
}
