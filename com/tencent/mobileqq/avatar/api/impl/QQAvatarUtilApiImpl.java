package com.tencent.mobileqq.avatar.api.impl;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.mobileqq.app.HeadDpcCfg;
import com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.util.j;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQAvatarUtilApiImpl implements IQQAvatarUtilApi {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "QQAvatarUtilApiImpl";

    public QQAvatarUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi
    public Bitmap genSquareFaceBmpByShape(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bitmap);
        }
        return getShapeRoundFaceBitmap(bitmap, BaseImageUtil.getFaceSquareRadius(bitmap.getWidth()), 50, 50);
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi
    public String get1080QQHeadDownLoadUrl(String str, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, this, str, Byte.valueOf(b16));
        }
        String reqDns = InnerDns.getInstance().reqDns("q.qlogo.cn", 1003);
        if (QLog.isColorLevel()) {
            QLog.i(InnerDns.TAG, 2, "get1080QQHeadDownLoadUrl.choosedIp=" + reqDns);
        }
        StringBuilder sb5 = new StringBuilder("https://");
        if (!TextUtils.isEmpty(reqDns)) {
            sb5.append(reqDns);
        } else {
            sb5.append("q.qlogo.cn");
        }
        int indexOf = str.indexOf("/", 8);
        if (indexOf > 8) {
            sb5.append(str.substring(indexOf));
            str = sb5.toString();
        }
        if ((b16 & 32) == 0) {
            if ((b16 & RegisterType.UNINIT_REF) != 0) {
                i3 = 640;
            } else if ((b16 & 8) != 0) {
                i3 = 140;
            } else if ((b16 & 4) != 0) {
                i3 = 100;
            } else {
                i3 = 40;
            }
        }
        return str + i3;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi
    public Bitmap getBitmapWithCache(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        }
        ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
        Bitmap f16 = imageCacheHelper.f(str);
        if (f16 == null) {
            f16 = j.h(BaseApplication.getContext().getResources(), i3);
        }
        if (f16 != null) {
            imageCacheHelper.i(str, f16, Business.AIO);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getBitmapWithCache, bitmap=" + f16);
        }
        return f16;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi
    public Drawable getDefaultDiscusionFaceDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Drawable) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return BaseImageUtil.getDefaultDiscusionFaceDrawable();
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi
    public Drawable getDefaultFaceDrawable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Drawable) iPatchRedirector.redirect((short) 8, (Object) this, z16);
        }
        return BaseImageUtil.getDefaultFaceDrawable(z16);
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi
    public Drawable getDefaultTroopFaceDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Drawable) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return BaseImageUtil.getDefaultTroopFaceDrawable();
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi
    public Bitmap getDrawableBitmap(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Bitmap) iPatchRedirector.redirect((short) 9, (Object) this, (Object) drawable);
        }
        return cn.d(drawable);
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi
    public String getIp(String str, boolean z16) {
        boolean z17;
        ArrayList<String> reqDnsForIpList;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, this, str, Boolean.valueOf(z16));
        }
        boolean isPreferIpv6 = HeadDpcCfg.get().isPreferIpv6();
        int activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(true);
        int i16 = 28;
        if (activeNetIpFamily == 3) {
            InnerDns innerDns = InnerDns.getInstance();
            if (isPreferIpv6) {
                i3 = 28;
            } else {
                i3 = 1;
            }
            reqDnsForIpList = innerDns.reqDnsForIpList(str, 1003, true, i3);
            if (reqDnsForIpList == null || reqDnsForIpList.size() == 0 || z16) {
                InnerDns innerDns2 = InnerDns.getInstance();
                if (isPreferIpv6) {
                    i16 = 1;
                }
                reqDnsForIpList = innerDns2.reqDnsForIpList(str, 1003, true, i16);
            }
        } else {
            if (activeNetIpFamily == 2) {
                z17 = true;
            } else {
                z17 = false;
            }
            InnerDns innerDns3 = InnerDns.getInstance();
            if (!z17) {
                i16 = 1;
            }
            reqDnsForIpList = innerDns3.reqDnsForIpList(str, 1003, true, i16);
        }
        if (reqDnsForIpList != null && reqDnsForIpList.size() > 0) {
            if (QLog.isColorLevel()) {
                QLog.i(InnerDns.TAG, 2, "getQQHeandDownLoadUrl.choosedIp = " + reqDnsForIpList.get(0));
            }
            return reqDnsForIpList.get(0);
        }
        QLog.d(InnerDns.TAG, 1, "getQQHeandDownLoadUrl() ipList is null");
        return null;
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi
    public Bitmap getRoundFaceBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmap);
        }
        return BaseImageUtil.getRoundFaceBitmap(bitmap, 50, 50);
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarUtilApi
    public Bitmap getShapeRoundFaceBitmap(Bitmap bitmap, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bitmap) iPatchRedirector.redirect((short) 5, this, bitmap, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
        float f16 = BaseApplication.getContext().getResources().getDisplayMetrics().density;
        int width = bitmap.getWidth();
        if (width > 0) {
            float f17 = width;
            float f18 = i16;
            if (f17 < f16 * f18) {
                f16 = f17 / f18;
            }
        }
        int i18 = (int) (i16 * f16);
        int i19 = (int) (i17 * f16);
        if (i3 <= 0) {
            z16 = false;
        }
        if (!z16) {
            i3 = i18;
        }
        return BaseImageUtil.getRoundedCornerBitmap(bitmap, i3, z16, i18, i19);
    }
}
