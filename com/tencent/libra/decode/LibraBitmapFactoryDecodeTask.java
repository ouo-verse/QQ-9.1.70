package com.tencent.libra.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.richframework.util.RFWImageUtil;
import com.tencent.libra.LoadContext;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.libra.util.LibraLogUtil;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LibraBitmapFactoryDecodeTask extends LibraBaseBitmapDecodeTask {
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("LibraBitmapFactoryDecodeTask");

    public LibraBitmapFactoryDecodeTask(LoadContext loadContext, LibraRequestKey libraRequestKey) {
        super(loadContext, libraRequestKey);
    }

    @NonNull
    private Bitmap.Config getInPreferredConfig(Option option) {
        if (option.isNinePatch()) {
            return Bitmap.Config.ARGB_8888;
        }
        if (option.getDecodeFormat() == DecodeFormat.PREFER_RGB_565) {
            return Bitmap.Config.RGB_565;
        }
        return Bitmap.Config.ARGB_8888;
    }

    private int updateSizeZoomMultiple(Option option, int i3) {
        if (option == null) {
            return i3;
        }
        if (i3 <= 0) {
            return i3;
        }
        int sizeZoomMultiple = option.getSizeZoomMultiple();
        if (sizeZoomMultiple <= 1) {
            return i3;
        }
        return sizeZoomMultiple * i3;
    }

    @Override // com.tencent.libra.decode.LibraBaseBitmapDecodeTask
    @Nullable
    protected Bitmap decodeBitmap(Option option) {
        Bitmap handleDecodeBitmap;
        com.tencent.libra.a aVar = com.tencent.libra.a.f118582b;
        BitmapFactory.Options a16 = aVar.a();
        if (option.getRequestWidth() > 0 && option.getRequestHeight() > 0) {
            decodeBitmapSize(option, a16);
            int i3 = a16.outWidth;
            int i16 = a16.outHeight;
            a16.inSampleSize = RFWImageUtil.calculateInSampleSize(i3, i16, option.getRequestWidth(), option.getRequestHeight());
            a16.inPreferredConfig = getInPreferredConfig(option);
            com.tencent.libra.util.a.f118813a.u(option, i3, i16);
            setInBitmap(option, a16, i3, i16);
            a16.inDensity = option.getInDensity();
            handleDecodeBitmap = handleDecodeBitmap(option, a16);
            if (option.isExplicitSize() && !option.isNinePatch()) {
                handleDecodeBitmap = adjustBitmap(handleDecodeBitmap, option.getRequestWidth(), option.getRequestHeight(), false);
            }
        } else {
            a16.inSampleSize = updateSizeZoomMultiple(option, 1);
            a16.inJustDecodeBounds = false;
            handleDecodeBitmap = handleDecodeBitmap(this.mOption, a16);
        }
        aVar.b(a16);
        return handleDecodeBitmap;
    }

    @Override // com.tencent.libra.task.ILibraTask
    public String getLogTag() {
        return TAG;
    }
}
