package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.EditText;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.adapter.api.IMarketFaceApi;
import com.tencent.qqnt.emotion.api.IEmoticonManagerService;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes12.dex */
public class PicEmoticonInfo extends EmoticonInfo implements IFavoriteEmoticonInfo, IPicEmoticonInfo {
    static IPatchRedirector $redirector_ = null;
    public static final Parcelable.Creator<PicEmoticonInfo> CREATOR;
    private static final String TAG = "PicEmoticonInfo";
    public Emoticon emoticon;
    public int imageType;
    public boolean isAPNG;
    public boolean isDownLoad;
    public Drawable mDefault;
    private ColorDrawable mEmptyDrawable;
    public Drawable mFailed;
    public Drawable mFiveInchDefault;
    public Drawable mFiveInchFailed;
    public int reqHeight;
    public int reqWidth;
    public String roamingType;
    public String uin;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40814);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 65)) {
            redirector.redirect((short) 65);
        } else {
            CREATOR = new Parcelable.Creator<PicEmoticonInfo>() { // from class: com.tencent.mobileqq.emoticonview.PicEmoticonInfo.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public PicEmoticonInfo createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new PicEmoticonInfo(parcel) : (PicEmoticonInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public PicEmoticonInfo[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new PicEmoticonInfo[i3] : (PicEmoticonInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public PicEmoticonInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.isDownLoad = false;
        this.reqWidth = 0;
        this.reqHeight = 0;
        this.mDefault = null;
        this.mFailed = null;
        this.mEmptyDrawable = new ColorDrawable();
        this.mFiveInchDefault = null;
        this.mFiveInchFailed = null;
        this.isAPNG = false;
        this.uin = str;
        if (this.mDefault == null || this.mFailed == null) {
            try {
                Resources resources = MobileQQ.sMobileQQ.getResources();
                this.mDefault = resources.getDrawable(R.drawable.c0i);
                this.mFailed = resources.getDrawable(R.drawable.fnn);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, e16.getMessage());
                }
            } catch (OutOfMemoryError e17) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, e17.getMessage());
                }
            }
        }
    }

    static boolean isNormalFileAndExist(String str) {
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            return true;
        }
        return false;
    }

    private void modifyDrawableByScreenSize(PicEmoticonInfo picEmoticonInfo, Emoticon emoticon) {
        if (emoticon.extensionWidth != 0 && emoticon.extensionHeight != 0) {
            if (picEmoticonInfo.mFiveInchDefault == null || picEmoticonInfo.mFiveInchFailed == null) {
                try {
                    Resources resources = BaseApplication.getContext().getResources();
                    picEmoticonInfo.mFiveInchDefault = resources.getDrawable(R.drawable.fnm);
                    picEmoticonInfo.mFiveInchFailed = resources.getDrawable(R.drawable.fnn);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, e16.getMessage());
                    }
                } catch (OutOfMemoryError e17) {
                    if (QLog.isColorLevel()) {
                        QLog.e(TAG, 2, e17.getMessage());
                    }
                }
            }
            picEmoticonInfo.mDefault = picEmoticonInfo.mFiveInchDefault;
            picEmoticonInfo.mFailed = picEmoticonInfo.mFiveInchFailed;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Integer) iPatchRedirector.redirect((short) 49, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public int emoExtHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this)).intValue();
        }
        Emoticon emoticon = this.emoticon;
        if (emoticon != null) {
            return emoticon.extensionHeight;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public int emoExtWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, (Object) this)).intValue();
        }
        Emoticon emoticon = this.emoticon;
        if (emoticon != null) {
            return emoticon.extensionWidth;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public int emoHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Integer) iPatchRedirector.redirect((short) 36, (Object) this)).intValue();
        }
        Emoticon emoticon = this.emoticon;
        if (emoticon != null) {
            return emoticon.height;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public int emoWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        Emoticon emoticon = this.emoticon;
        if (emoticon != null) {
            return emoticon.width;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public String getAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            return (String) iPatchRedirector.redirect((short) 60, (Object) this);
        }
        return null;
    }

    public String getAioPreviewPathIfExists() {
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        Emoticon emoticon = this.emoticon;
        if (emoticon == null) {
            return null;
        }
        if (emoticon.jobType == 1) {
            a16 = com.tencent.qqnt.emotion.utils.j.f(emoticon.epId, emoticon.eId);
        } else {
            a16 = com.tencent.qqnt.emotion.utils.j.a(emoticon.epId, emoticon.eId);
        }
        if (!isNormalFileAndExist(a16)) {
            return null;
        }
        return a16;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    public String getBigImagePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return (String) iPatchRedirector.redirect((short) 57, (Object) this);
        }
        Emoticon emoticon = this.emoticon;
        String a16 = com.tencent.qqnt.emotion.utils.j.a(emoticon.epId, emoticon.eId);
        if (cq.n(a16)) {
            return a16;
        }
        Emoticon emoticon2 = this.emoticon;
        String c16 = com.tencent.qqnt.emotion.utils.j.c(emoticon2.epId, emoticon2.eId);
        if (!cq.n(c16)) {
            QLog.i(TAG, 1, "getBigImagePath, image path not exists, path is " + c16);
            return null;
        }
        String str = c16 + ".dec";
        if (cq.n(str)) {
            return str;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            try {
                fileOutputStream.write(com.tencent.qqnt.emotion.utils.a.c(c16));
                fileOutputStream.close();
                new File(str).deleteOnExit();
                fileOutputStream.close();
                return str;
            } catch (Throwable th5) {
                try {
                    fileOutputStream.close();
                } catch (Throwable th6) {
                    th5.addSuppressed(th6);
                }
                throw th5;
            }
        } catch (IOException e16) {
            QLog.i(TAG, 1, "getBigImagePath, io exception, " + e16);
            return null;
        } catch (OutOfMemoryError e17) {
            QLog.i(TAG, 1, "getBigImagePath, out of memory, " + e17);
            return null;
        }
    }

    public String getBigImagePathIfExists() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        Emoticon emoticon = this.emoticon;
        if (emoticon == null || emoticon.jobType == 1) {
            return null;
        }
        String c16 = com.tencent.qqnt.emotion.utils.j.c(emoticon.epId, emoticon.eId);
        if (!isNormalFileAndExist(c16)) {
            return null;
        }
        Emoticon emoticon2 = this.emoticon;
        if (emoticon2.isSound && !isNormalFileAndExist(com.tencent.qqnt.emotion.utils.j.d(emoticon2.epId, emoticon2.eId))) {
            return null;
        }
        return c16;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    public String getBigImageURL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return (String) iPatchRedirector.redirect((short) 59, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public Drawable getDefault() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (Drawable) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.mDefault;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public Drawable getDrawable(Context context, float f16) {
        URL panelImageURL;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Drawable) iPatchRedirector.redirect((short) 10, this, context, Float.valueOf(f16));
        }
        if (this.emoticon != null && (panelImageURL = getPanelImageURL()) != null) {
            ColorDrawable colorDrawable = this.mEmptyDrawable;
            Drawable drawable = this.mFailed;
            if (drawable == null) {
                drawable = colorDrawable;
            }
            URLDrawable drawable2 = URLDrawable.getDrawable(panelImageURL, (Drawable) colorDrawable, drawable, false);
            drawable2.setTag(this.emoticon);
            drawable2.addHeader("my_uin", this.uin);
            return drawable2;
        }
        return this.mDefault;
    }

    @Override // com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public String getEid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (String) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        Emoticon emoticon = this.emoticon;
        if (emoticon != null) {
            return emoticon.eId;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public int getEmoId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Integer) iPatchRedirector.redirect((short) 48, (Object) this)).intValue();
        }
        return this.emoId;
    }

    @Override // com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public int getEmoType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Integer) iPatchRedirector.redirect((short) 45, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public Emoticon getEmoticon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Emoticon) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.emoticon;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    public int getEmoticonType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            return ((Integer) iPatchRedirector.redirect((short) 54, (Object) this)).intValue();
        }
        return this.type;
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public String getEpid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return (String) iPatchRedirector.redirect((short) 39, (Object) this);
        }
        Emoticon emoticon = this.emoticon;
        if (emoticon != null) {
            return emoticon.epId;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public Drawable getFailed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Drawable) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this.mFailed;
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public Drawable getFiveInchDefault() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (Drawable) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.mFiveInchDefault;
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public Drawable getFiveInchFailed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Drawable) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.mFiveInchFailed;
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public int getImageJobType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Integer) iPatchRedirector.redirect((short) 41, (Object) this)).intValue();
        }
        Emoticon emoticon = this.emoticon;
        if (emoticon != null) {
            return emoticon.jobType;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public int getImageType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        return this.imageType;
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public URLDrawable getLoadingDrawable(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 26)) ? getLoadingDrawable(str, z16, false, null) : (URLDrawable) iPatchRedirector.redirect((short) 26, this, str, Boolean.valueOf(z16));
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return (String) iPatchRedirector.redirect((short) 55, (Object) this);
        }
        return this.emoticon.name;
    }

    public URL getPanelImageURL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (URL) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        try {
            return new URL(EmotionConstants.PROTOCOL_EMOTION_PIC, EmotionConstants.FROM_PANEL, com.tencent.qqnt.emotion.constant.e.a(this.emoticon));
        } catch (MalformedURLException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getDrawable ,", e16);
                return null;
            }
            return null;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public String getPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (String) iPatchRedirector.redirect((short) 47, (Object) this);
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> URLDrawable getPicEmoticonAioPreviewDrawable(T t16) {
        PicEmoticonInfo picEmoticonInfo;
        Emoticon emoticon;
        URL url;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 53, (Object) this, (Object) t16);
        }
        URLDrawable uRLDrawable = null;
        if (t16 == 0 || (emoticon = (picEmoticonInfo = (PicEmoticonInfo) t16).emoticon) == null) {
            return null;
        }
        String a16 = com.tencent.qqnt.emotion.utils.j.a(emoticon.epId, emoticon.eId);
        if (a16 != null) {
            try {
                url = new URL(EmotionConstants.PROTOCOL_EMOTION_PIC, EmotionConstants.FROM_AIO, com.tencent.qqnt.emotion.constant.e.a(emoticon));
            } catch (MalformedURLException e16) {
                e16.printStackTrace();
                url = null;
            }
            if (url != null) {
                modifyDrawableByScreenSize(picEmoticonInfo, emoticon);
                uRLDrawable = URLDrawable.getDrawable(url, picEmoticonInfo.mDefault, picEmoticonInfo.mFailed, false);
                if (uRLDrawable.getStatus() != 1) {
                    uRLDrawable.setTag(emoticon);
                    uRLDrawable.addHeader("my_uin", picEmoticonInfo.uin);
                    if (cq.n(a16)) {
                        try {
                            uRLDrawable.downloadImediatly();
                        } catch (OutOfMemoryError unused) {
                            if (QLog.isColorLevel()) {
                                QLog.e(TAG, 2, "getBigDrawable oom,drawableID=" + picEmoticonInfo.drawableId);
                            }
                        }
                    }
                }
            }
        }
        return uRLDrawable;
    }

    public <T, K> URLDrawable getPicEmoticonLoadingDrawable(K k3, String str, boolean z16, boolean z17, T t16) {
        URL url;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 51, this, k3, str, Boolean.valueOf(z16), Boolean.valueOf(z17), t16);
        }
        if (k3 == 0) {
            return null;
        }
        PicEmoticonInfo picEmoticonInfo = (PicEmoticonInfo) k3;
        Emoticon emoticon = picEmoticonInfo.emoticon;
        boolean z19 = picEmoticonInfo.isAPNG;
        Drawable drawable = picEmoticonInfo.mDefault;
        Drawable drawable2 = picEmoticonInfo.mFailed;
        if (emoticon == null) {
            return null;
        }
        try {
            url = new URL(EmotionConstants.PROTOCOL_EMOTION_PIC, str, com.tencent.qqnt.emotion.constant.e.a(emoticon));
        } catch (MalformedURLException unused) {
            url = null;
        }
        if (url == null) {
            return null;
        }
        modifyDrawableByScreenSize(picEmoticonInfo, emoticon);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        BaseQQAppInterface baseQQAppInterface = waitAppRuntime instanceof BaseQQAppInterface ? (BaseQQAppInterface) waitAppRuntime : null;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = drawable2;
        obtain.mLoadingDrawable = drawable;
        obtain.mPlayGifImage = true;
        obtain.mGifRefreshDelay = 0;
        EmoticonPackage syncFindEmoticonPackageInCache = baseQQAppInterface != null ? ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageInCache(emoticon.epId, 0) : null;
        if ((syncFindEmoticonPackageInCache != null && syncFindEmoticonPackageInCache.isAPNG == 2) || z19 || emoticon.isAPNG) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getBigDrawable: APNG so loaded use apng image");
            }
            obtain.mUseApngImage = true;
            obtain.mPlayGifImage = false;
            obtain.mMemoryCacheKeySuffix = "useAPNG";
            z18 = true;
        }
        obtain.mRequestWidth = emoticon.extensionWidth;
        obtain.mRequestHeight = emoticon.extensionHeight;
        URLDrawable drawable3 = URLDrawable.getDrawable(url, obtain);
        if (drawable3.getStatus() != 1) {
            drawable3.setTag(emoticon);
            drawable3.addHeader("my_uin", picEmoticonInfo.uin);
            drawable3.addHeader(ProtocolDownloaderConstants.HEADER_EMOTICON_TYPE, String.valueOf(picEmoticonInfo.imageType));
            if (z17) {
                drawable3.addHeader("2g_use_gif", "true");
            } else {
                drawable3.addHeader("2g_use_gif", "false");
            }
            if (drawable3.getStatus() == 2 || drawable3.getStatus() == 3) {
                drawable3.restartDownload();
            }
        } else {
            tryApng(baseQQAppInterface, emoticon, url, syncFindEmoticonPackageInCache, z18, drawable3);
        }
        return drawable3;
    }

    @Override // com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public String getResID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            return (String) iPatchRedirector.redirect((short) 62, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public String getRoamingType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (String) iPatchRedirector.redirect((short) 46, (Object) this);
        }
        return this.roamingType;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    public String getThumbImagePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return (String) iPatchRedirector.redirect((short) 56, (Object) this);
        }
        Emoticon emoticon = this.emoticon;
        return com.tencent.qqnt.emotion.utils.j.f(emoticon.epId, emoticon.eId);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    public String getThumbURL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (String) iPatchRedirector.redirect((short) 58, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            return ((Integer) iPatchRedirector.redirect((short) 64, (Object) this)).intValue();
        }
        return this.type;
    }

    @Override // com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (String) iPatchRedirector.redirect((short) 61, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public int getVoiceLength() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public int getWaveBackgroundColor() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        Emoticon emoticon = this.emoticon;
        if (emoticon != null && emoticon.backColor != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = IPicEmoticonInfo.DEFAULT_AUDIO_WAVE_BACKGROUND_COLOR;
        if (z16) {
            try {
                return Color.parseColor(emoticon.backColor);
            } catch (Exception e16) {
                QLog.e(TAG, 2, e16, new Object[0]);
                return i3;
            }
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public int getWaveForegroundColor() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        Emoticon emoticon = this.emoticon;
        if (emoticon != null && emoticon.volumeColor != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = IPicEmoticonInfo.DEFAULT_AUDIO_WAVE_FOREGROUND_COLOR;
        if (z16) {
            try {
                return Color.parseColor(emoticon.volumeColor);
            } catch (Exception e16) {
                QLog.e(TAG, 2, e16, new Object[0]);
                return i3;
            }
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public int[] getWaveformArray() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (int[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        Emoticon emoticon = this.emoticon;
        if (emoticon != null && emoticon.parseSoundPrintString() != null && !this.emoticon.parseSoundPrintString().isEmpty()) {
            int[] iArr = new int[this.emoticon.parseSoundPrintString().size()];
            for (int i3 = 0; i3 < this.emoticon.parseSoundPrintString().size(); i3++) {
                iArr[i3] = this.emoticon.parseSoundPrintString().get(i3).intValue();
            }
            return iArr;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public Drawable getZoomDrawable(Context context, float f16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Drawable) iPatchRedirector.redirect((short) 13, this, context, Float.valueOf(f16), Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return getDrawable(context, f16);
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public boolean isAPNG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        return this.isAPNG;
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public boolean isAioPreviewExists() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (getAioPreviewPathIfExists() != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public boolean isBigImageExists() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (getBigImagePathIfExists() != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public boolean isChecked() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return ((Boolean) iPatchRedirector.redirect((short) 43, (Object) this)).booleanValue();
        }
        return this.isChecked;
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public boolean isNewSoundType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        Emoticon emoticon = this.emoticon;
        if (emoticon != null && emoticon.parseSoundPrintString() != null && !this.emoticon.parseSoundPrintString().isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public boolean isSound() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        Emoticon emoticon = this.emoticon;
        if (emoticon != null && emoticon.isSound) {
            return true;
        }
        return false;
    }

    public void send(AppRuntime appRuntime, Context context, EditText editText, Parcelable parcelable, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 31)) {
            send(appRuntime, context, editText, parcelable, z16, 0);
        } else {
            iPatchRedirector.redirect((short) 31, this, appRuntime, context, editText, parcelable, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public void sendFromGuild(AppRuntime appRuntime, Context context, Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, appRuntime, context, parcelable);
        } else {
            ((IMarketFaceApi) QRoute.api(IMarketFaceApi.class)).sendFromGuild(appRuntime, context, parcelable, this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public void setEmoticon(Emoticon emoticon) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) emoticon);
        } else {
            this.emoticon = emoticon;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public void setIsChecked(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, z16);
        } else {
            this.isChecked = z16;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public void setPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            iPatchRedirector.redirect((short) 63, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public void setStickerInfo(StickerInfo stickerInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) stickerInfo);
        } else {
            this.stickerInfo = stickerInfo;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (String) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        Emoticon emoticon = this.emoticon;
        if (emoticon != null) {
            return String.format("PicEmoticonInfo, name %s, eId %s, epId %s", emoticon.name, emoticon.eId, emoticon.epId);
        }
        return "PicEmoticonInfo TYPE_BIG_EMOTICON and no emoticon";
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) parcel, i3);
            return;
        }
        super.writeToParcel(parcel, i3);
        parcel.writeSerializable(this.emoticon);
        parcel.writeByte(this.isDownLoad ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.reqWidth);
        parcel.writeInt(this.reqHeight);
        parcel.writeInt(this.imageType);
        parcel.writeString(this.uin);
        parcel.writeByte(this.isAPNG ? (byte) 1 : (byte) 0);
        parcel.writeString(this.roamingType);
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public URLDrawable getAioPreviewDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) ? getPicEmoticonAioPreviewDrawable(this) : (URLDrawable) iPatchRedirector.redirect((short) 19, (Object) this);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public URLDrawable getBigDrawable(Context context, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? getLoadingDrawable(EmotionConstants.FROM_AIO, true) : (URLDrawable) iPatchRedirector.redirect((short) 14, this, context, Float.valueOf(f16));
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public URLDrawable getLoadingDrawable(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 27)) ? getLoadingDrawable(str, true) : (URLDrawable) iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public void send(AppRuntime appRuntime, Context context, EditText editText, Parcelable parcelable, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 32)) {
            ((IMarketFaceApi) QRoute.api(IMarketFaceApi.class)).send(appRuntime, context, editText, parcelable, z16, i3, this);
        } else {
            iPatchRedirector.redirect((short) 32, this, appRuntime, context, editText, parcelable, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public <T> URLDrawable getLoadingDrawable(String str, boolean z16, boolean z17, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 29)) ? getPicEmoticonLoadingDrawable(this, str, z16, z17, t16) : (URLDrawable) iPatchRedirector.redirect((short) 29, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17), t16);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public void send(AppRuntime appRuntime, Context context, EditText editText, Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, appRuntime, context, editText, parcelable);
        } else {
            Serializable serializable = this.stickerInfo;
            ((IMarketFaceApi) QRoute.api(IMarketFaceApi.class)).send(appRuntime, context, parcelable, this.emoticon, serializable instanceof StickerInfo ? (StickerInfo) serializable : null);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.IPicEmoticonInfo
    public <T> URLDrawable getLoadingDrawable(String str, boolean z16, boolean z17, T t16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 30)) ? getPicEmoticonLoadingDrawable(this, str, z16, z17, t16, i3, i16) : (URLDrawable) iPatchRedirector.redirect((short) 30, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17), t16, Integer.valueOf(i3), Integer.valueOf(i16));
    }

    protected PicEmoticonInfo(Parcel parcel) {
        super(parcel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.isDownLoad = false;
        this.reqWidth = 0;
        this.reqHeight = 0;
        this.mDefault = null;
        this.mFailed = null;
        this.mEmptyDrawable = new ColorDrawable();
        this.mFiveInchDefault = null;
        this.mFiveInchFailed = null;
        this.isAPNG = false;
        this.emoticon = (Emoticon) parcel.readSerializable();
        this.isDownLoad = parcel.readByte() != 0;
        this.reqWidth = parcel.readInt();
        this.reqHeight = parcel.readInt();
        this.imageType = parcel.readInt();
        this.uin = parcel.readString();
        this.isAPNG = parcel.readByte() != 0;
        this.roamingType = parcel.readString();
    }

    public <T, K> URLDrawable getPicEmoticonLoadingDrawable(K k3, String str, boolean z16, boolean z17, T t16, int i3, int i16) {
        URL url;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z18 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 52, this, k3, str, Boolean.valueOf(z16), Boolean.valueOf(z17), t16, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (k3 == 0) {
            return null;
        }
        PicEmoticonInfo picEmoticonInfo = (PicEmoticonInfo) k3;
        Emoticon emoticon = picEmoticonInfo.emoticon;
        boolean z19 = picEmoticonInfo.isAPNG;
        if (emoticon == null) {
            return null;
        }
        try {
            url = new URL(EmotionConstants.PROTOCOL_EMOTION_PIC, str, com.tencent.qqnt.emotion.constant.e.a(emoticon));
        } catch (MalformedURLException e16) {
            QLog.e(TAG, 1, "market face getLoadingDrawable", e16);
            url = null;
        }
        if (url == null) {
            return null;
        }
        modifyDrawableByScreenSize(picEmoticonInfo, emoticon);
        Drawable drawable = picEmoticonInfo.mFailed;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        BaseQQAppInterface baseQQAppInterface = waitAppRuntime instanceof BaseQQAppInterface ? (BaseQQAppInterface) waitAppRuntime : null;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = picEmoticonInfo.mDefault;
        obtain.mPlayGifImage = true;
        obtain.mGifRefreshDelay = 0;
        EmoticonPackage syncFindEmoticonPackageInCache = baseQQAppInterface != null ? ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageInCache(emoticon.epId, 0) : null;
        if ((syncFindEmoticonPackageInCache != null && syncFindEmoticonPackageInCache.isAPNG == 2) || z19 || emoticon.isAPNG) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getBigDrawable: APNG so loaded use apng image");
            }
            obtain.mUseApngImage = true;
            obtain.mPlayGifImage = false;
            obtain.mMemoryCacheKeySuffix = "useAPNG";
            z18 = true;
        }
        obtain.mRequestWidth = picEmoticonInfo.reqWidth;
        obtain.mRequestHeight = picEmoticonInfo.reqHeight;
        URLDrawable drawable2 = URLDrawable.getDrawable(url, obtain);
        if (drawable2.getStatus() != 1) {
            drawable2.setTag(emoticon);
            drawable2.addHeader("my_uin", picEmoticonInfo.uin);
            drawable2.addHeader(ProtocolDownloaderConstants.HEADER_EMOTICON_TYPE, String.valueOf(picEmoticonInfo.imageType));
            if (z17) {
                drawable2.addHeader("2g_use_gif", "true");
            } else {
                drawable2.addHeader("2g_use_gif", "false");
            }
            if (drawable2.getStatus() == 2 || drawable2.getStatus() == 3) {
                drawable2.restartDownload();
            }
        } else {
            tryApng(baseQQAppInterface, emoticon, url, syncFindEmoticonPackageInCache, z18, drawable2);
        }
        return drawable2;
    }

    private void tryApng(BaseQQAppInterface baseQQAppInterface, Emoticon emoticon, URL url, EmoticonPackage emoticonPackage, boolean z16, URLDrawable uRLDrawable) {
    }
}
