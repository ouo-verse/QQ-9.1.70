package com.tencent.libra.decode;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.libra.LoadContext;
import com.tencent.libra.h;
import com.tencent.libra.request.Option;
import com.tencent.libra.util.ImageContentType;
import com.tencent.libra.util.LibraLogUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class LibraPicDecodeTaskFactory {
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("LibraPicDecodeTaskFactory");
    public static Map<Class<? extends r01.a<?>>, r01.a<?>> sLibraDecoderCache = new ConcurrentHashMap();

    private static void appendFileType(LoadContext loadContext) {
        try {
            if (loadContext.getOption().getModel() != null) {
                loadContext.getOption().setFileType(RFWFileUtils.getFileType(loadContext.getOption().getModel().c()));
            } else {
                loadContext.getOption().setFileType(RFWFileUtils.getFileType(loadContext.getOption().getLocalPath()));
            }
        } catch (Throwable th5) {
            RFWLog.e(TAG, RFWLog.USR, "appendFileType failed", th5);
        }
    }

    private static LibraBaseDecodeTask createNormalDecoder(LoadContext loadContext, LibraRequestKey libraRequestKey) {
        if (Build.VERSION.SDK_INT >= 29 && !loadContext.getOption().isNinePatch()) {
            return new LibraImageDecoderDecodeTask(loadContext, libraRequestKey);
        }
        return new LibraBitmapFactoryDecodeTask(loadContext, libraRequestKey);
    }

    public static LibraBaseDecodeTask getDecodeTask(LoadContext loadContext, LibraRequestKey libraRequestKey, List<r01.a<?>> list) throws FileNotFoundException {
        List<Class<? extends r01.a<?>>> preferDecoder = loadContext.getOption().getPreferDecoder();
        if (preferDecoder != null) {
            Iterator<Class<? extends r01.a<?>>> it = preferDecoder.iterator();
            while (it.hasNext()) {
                r01.a<?> decoder = getDecoder(it.next());
                if (loadContext.getOption().getModel() != null) {
                    if (decoder.b(loadContext.getOption().getModel())) {
                        return new LibraExtraDecodeTask(loadContext, libraRequestKey, decoder);
                    }
                } else if (decoder.a(new File(loadContext.getOption().getLocalPath()))) {
                    return new LibraExtraDecodeTask(loadContext, libraRequestKey, decoder);
                }
            }
        }
        for (r01.a<?> aVar : list) {
            if (loadContext.getOption().getModel() != null) {
                if (aVar.b(loadContext.getOption().getModel())) {
                    return new LibraExtraDecodeTask(loadContext, libraRequestKey, aVar);
                }
            } else if (aVar.a(new File(loadContext.getOption().getLocalPath()))) {
                return new LibraExtraDecodeTask(loadContext, libraRequestKey, aVar);
            }
        }
        int decodeMode = loadContext.getOption().getDecodeMode();
        if (decodeMode != 0) {
            if (decodeMode != 1) {
                return new LibraBitmapFactoryDecodeTask(loadContext, libraRequestKey);
            }
            if (isRegionDecodeValid(loadContext.getOption(), libraRequestKey)) {
                return new LibraPicRegionDecodeTask(loadContext, libraRequestKey);
            }
            return createNormalDecoder(loadContext, libraRequestKey);
        }
        return createNormalDecoder(loadContext, libraRequestKey);
    }

    public static r01.a<?> getDecoder(Class<? extends r01.a<?>> cls) {
        r01.a<?> aVar = sLibraDecoderCache.get(cls);
        if (aVar == null) {
            try {
                r01.a<?> newInstance = cls.newInstance();
                try {
                    sLibraDecoderCache.put(cls, newInstance);
                    return newInstance;
                } catch (IllegalAccessException | InstantiationException e16) {
                    e = e16;
                    aVar = newInstance;
                    RFWLog.e(TAG, RFWLog.USR, "create decoder error" + e.getMessage());
                    return aVar;
                }
            } catch (IllegalAccessException e17) {
                e = e17;
            } catch (InstantiationException e18) {
                e = e18;
            }
        } else {
            return aVar;
        }
    }

    private static boolean isRegionDecodeValid(Option option, LibraRequestKey libraRequestKey) {
        if (libraRequestKey.getBitmapWith() > 0 && libraRequestKey.getBitmapHeight() > 0 && libraRequestKey.getRegionScaleType() != ImageView.ScaleType.MATRIX && libraRequestKey.getRegionScaleType() != ImageView.ScaleType.CENTER) {
            if (libraRequestKey.isNinePatch()) {
                return false;
            }
            BitmapFactory.Options a16 = com.tencent.libra.a.f118582b.a();
            a16.inJustDecodeBounds = true;
            try {
                InputStream a17 = h.f118788a.a(option.getModel(), new File(option.getLocalPath()));
                try {
                    BitmapFactory.decodeStream(a17, null, a16);
                    if (a17 != null) {
                        a17.close();
                    }
                } finally {
                }
            } catch (Throwable th5) {
                LibraLogUtil.INSTANCE.e(TAG, RFWLog.USR, option, "[isRegionDecodeValid] decode exception:", th5);
            }
            String str = a16.outMimeType;
            com.tencent.libra.a.f118582b.b(a16);
            if (TextUtils.equals(ImageContentType.MIME_TYPE_JPG, str) || TextUtils.equals("image/jpeg", str) || TextUtils.equals("image/png", str)) {
                return true;
            }
            return false;
        }
        LibraLogUtil.INSTANCE.i(TAG, RFWLog.USR, option, "[isRegionDecodeValid] false scaleType=", libraRequestKey.getRegionScaleType(), ",requestWidth=", Integer.valueOf(libraRequestKey.getBitmapWith()), ",requestHeight=", Integer.valueOf(libraRequestKey.getBitmapHeight()));
        return false;
    }
}
