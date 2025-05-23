package com.tencent.mobileqq.pic.api.impl;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.incompatiblephoto.b;
import com.tencent.mobileqq.activity.photo.incompatiblephoto.c;
import com.tencent.mobileqq.config.business.AvifDownloadConfProcessor;
import com.tencent.mobileqq.data.Avif2JpgResult;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.IOriPicCompress;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.pic.compress.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.PicConvertUtil;
import com.tencent.mobileqq.transfile.bitmapcreator.ExifBitmapCreator;
import com.tencent.mobileqq.v;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* loaded from: classes16.dex */
public class PicUtilImpl implements IPicUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "PicUtilImpl";

    public PicUtilImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicUtil
    public String compressPic(Boolean bool, String str) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) bool, (Object) str);
        }
        if (bool.booleanValue()) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        CompressInfo compressInfo = new CompressInfo(str, i3);
        compressInfo.T = true;
        ((IOriPicCompress) QRoute.api(IOriPicCompress.class)).compressOriginPic(compressInfo);
        return compressInfo.H;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicUtil
    public boolean compressQuality(String str, Bitmap bitmap, int i3, String str2, CompressInfo compressInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, str, bitmap, Integer.valueOf(i3), str2, compressInfo)).booleanValue();
        }
        return g.i(str, bitmap, i3, str2, compressInfo);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicUtil
    public Avif2JpgResult convertAvif2Jpg(String str, String str2, @Nullable String str3, @Nullable ThumbWidthHeightDP thumbWidthHeightDP, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Avif2JpgResult) iPatchRedirector.redirect((short) 11, this, str, str2, str3, thumbWidthHeightDP, Integer.valueOf(i3));
        }
        return PicConvertUtil.convertAvif2Jpg(AvifDownloadConfProcessor.a().c(), str, str2, str3, thumbWidthHeightDP, i3);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicUtil
    public String generateCompatiblePic(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
        b b16 = b.b(str);
        if (b16 != null) {
            String d16 = new c(b16).d();
            if (!TextUtils.isEmpty(d16)) {
                return d16;
            }
            QLog.e(TAG, 1, "generateCompatiblePic failed!");
            return str;
        }
        return str;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicUtil
    public String generateThumbPic(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        CompressInfo compressInfo = new CompressInfo(str, 0);
        com.tencent.mobileqq.pic.compress.c.f(compressInfo);
        String str2 = compressInfo.H;
        if (str2 != null) {
            return str2;
        }
        return str;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicUtil
    public Bitmap getExifBitmap(String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bitmap) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) bitmap);
        }
        return new ExifBitmapCreator(str).creatBitmap(bitmap);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicUtil
    public int getImageType(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).intValue();
        }
        return v.a(str);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicUtil
    public ArrayList<Integer> getSliceInfos(String str) throws OutOfMemoryError {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return v.b(str);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicUtil
    public boolean isDynamicImg(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, i3)).booleanValue();
        }
        if (i3 < 2000 && i3 != 3) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicUtil
    public boolean isLongPic(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        return com.tencent.mobileqq.richmedia.dc.c.b(i3, i16);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicUtil
    public boolean isProgressiveJpeg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        return v.d(str);
    }
}
