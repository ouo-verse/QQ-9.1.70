package com.tencent.mobileqq.pic.api.impl;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.ac;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.f;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class PicFlashImpl implements IPicFlash {
    static IPatchRedirector $redirector_;
    public final DownloadParams.DecodeHandler flashPicDecodeHandler;
    public Drawable mReadedDrawable;

    /* loaded from: classes16.dex */
    class a implements DownloadParams.DecodeHandler {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PicFlashImpl.this);
            }
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) downloadParams, (Object) bitmap);
            }
            if (bitmap != null && downloadParams != null) {
                float density = PicFlashImpl.this.getDensity();
                int i3 = (int) ((downloadParams.reqWidth / density) + 0.5f);
                int i16 = (int) ((downloadParams.reqHeight / density) + 0.5f);
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if ("chatthumb".equals(downloadParams.url.getProtocol())) {
                    i3 = 130;
                    i16 = 102;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.HOTCHAT, 2, "downloadParams.reqWidth:" + downloadParams.reqWidth + ",downloadParams.reqHeight:" + downloadParams.reqHeight + ",reqWidth:" + i3 + ",reqHeight:" + i16 + ",isMutable:" + bitmap.isMutable());
                }
                float f16 = i3 / width;
                float f17 = i16 / height;
                Matrix matrix = new Matrix();
                matrix.postScale(f16, f17);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.HOTCHAT, 2, "scaleW:" + f16 + "scaleH:" + f17 + ",resizeBmp w:" + createBitmap.getWidth() + ",h:" + createBitmap.getHeight());
                }
                int width2 = createBitmap.getWidth() / 8;
                if (width2 == 0) {
                    width2 = 16;
                }
                Bitmap mosaicBitmap = PicFlashImpl.this.getMosaicBitmap(createBitmap, width2);
                bitmap.recycle();
                return mosaicBitmap;
            }
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.HOTCHAT, 2, "FLASH_PIC_MOSAIC_DECODE, bitmap is null");
                return null;
            }
            return null;
        }
    }

    public PicFlashImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.flashPicDecodeHandler = new a();
        }
    }

    static void dimBlock(int[] iArr, int i3, int i16, int i17, int i18, int i19) {
        int i26 = (i3 + i17) - 1;
        int i27 = (i17 + i16) - 1;
        if (i26 > i18) {
            i26 = i18;
        }
        if (i27 <= i19) {
            i19 = i27;
        }
        int i28 = iArr[(((((((i19 - i16) + 1) / 2) + i16) - 1) * i18) + ((((i26 - i3) + 1) / 2) + i3)) - 1];
        while (i16 <= i19) {
            int i29 = (i16 - 1) * i18;
            for (int i36 = i3; i36 <= i26; i36++) {
                iArr[(i29 + i36) - 1] = i28;
            }
            i16++;
        }
    }

    public float getDensity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, (Object) this)).floatValue();
        }
        return BaseApplication.getContext().getResources().getDisplayMetrics().density;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicFlash
    public DownloadParams.DecodeHandler getFlashPicDecodeHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (DownloadParams.DecodeHandler) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.flashPicDecodeHandler;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicFlash
    public Drawable getFlashPicReadedDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Drawable) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (this.mReadedDrawable == null) {
            try {
                Resources resources = BaseApplication.getContext().getResources();
                this.mReadedDrawable = new f(resources.getColor(R.color.a0h), Utils.n(130.0f, resources), Utils.n(102.0f, resources), (int) ((resources.getDisplayMetrics().densityDpi / 160) * 8.0f));
            } catch (OutOfMemoryError unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("PicFlashImpl", 2, "getReadedDrawable OOM");
                }
            }
        }
        return this.mReadedDrawable;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicFlash
    public Bitmap getMosaicBitmap(Bitmap bitmap, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Bitmap) iPatchRedirector.redirect((short) 9, (Object) this, (Object) bitmap, i3);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        float f16 = i3;
        int ceil = (int) Math.ceil(height / f16);
        int ceil2 = (int) Math.ceil(width / f16);
        for (int i16 = 0; i16 < ceil; i16++) {
            int i17 = 0;
            while (i17 < ceil2) {
                int i18 = height;
                dimBlock(iArr, (i17 * i3) + 1, (i16 * i3) + 1, i3, width, i18);
                i17++;
                iArr = iArr;
                height = i18;
            }
        }
        int i19 = height;
        bitmap.recycle();
        Bitmap createBitmap = Bitmap.createBitmap(width, i19, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, i19);
        Canvas canvas = new Canvas();
        canvas.setBitmap(createBitmap);
        canvas.drawARGB(89, 0, 0, 0);
        return createBitmap;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicFlash
    public boolean isFlashPicMsg(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return ac.c(messageRecord);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicFlash
    public boolean isFlashPicMsgReaded(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return ac.d(messageRecord);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicFlash
    public void setFlashPicFlag(MessageRecord messageRecord, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, messageRecord, Boolean.valueOf(z16));
        } else {
            ac.e(messageRecord, z16);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicFlash
    public void setFlashPicMsgReaded(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) messageRecord);
        } else {
            ac.f(messageRecord);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicFlash
    public boolean showFlashPicOption(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) str)).booleanValue();
        }
        return ac.g(i3, str);
    }
}
