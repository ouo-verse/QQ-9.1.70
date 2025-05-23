package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.emoticonview.api.ICameraEmoticonSenderService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.VasExtensionDownloaderConstant;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class CameraEmoticonInfo extends BaseFavoriteEmoticonInfo {
    static IPatchRedirector $redirector_ = null;
    public static final Parcelable.Creator<CameraEmoticonInfo> CREATOR;
    public static final String TAG = "CameraEmoticonInfo";
    public String contextKey;
    private ColorDrawable mEmptyDrawable;
    public String templateId;
    public String thumbPath;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44535);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            CREATOR = new Parcelable.Creator<CameraEmoticonInfo>() { // from class: com.tencent.mobileqq.emoticonview.CameraEmoticonInfo.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public CameraEmoticonInfo createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new CameraEmoticonInfo(parcel) : (CameraEmoticonInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public CameraEmoticonInfo[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new CameraEmoticonInfo[i3] : (CameraEmoticonInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public CameraEmoticonInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.mEmptyDrawable = new ColorDrawable();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseFavoriteEmoticonInfo, com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseFavoriteEmoticonInfo, com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public String getAction() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public Drawable getBigDrawable(Context context, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Drawable) iPatchRedirector.redirect((short) 7, this, context, Float.valueOf(f16));
        }
        try {
            URL url = new URL(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, VasExtensionDownloaderConstant.BUSINESS_CAMERA_EMO_PANEL_DYNAMIC, this.path);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            int i3 = (int) (f16 * 100.0f);
            obtain.mRequestHeight = i3;
            obtain.mRequestWidth = i3;
            obtain.mFailedDrawable = context.getResources().getDrawable(R.drawable.o4e);
            obtain.mLoadingDrawable = this.mEmptyDrawable;
            obtain.mPlayGifImage = true;
            URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "d: width = " + drawable.getIntrinsicWidth() + ";height = " + drawable.getIntrinsicHeight() + ";options:width = " + obtain.mRequestWidth + ";options:height = " + obtain.mRequestHeight);
            }
            return drawable;
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00b1 A[Catch: MalformedURLException -> 0x00d3, TryCatch #4 {MalformedURLException -> 0x00d3, blocks: (B:19:0x0089, B:21:0x00b1, B:23:0x00b9), top: B:18:0x0089 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b9 A[Catch: MalformedURLException -> 0x00d3, TRY_LEAVE, TryCatch #4 {MalformedURLException -> 0x00d3, blocks: (B:19:0x0089, B:21:0x00b1, B:23:0x00b9), top: B:18:0x0089 }] */
    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Drawable getDrawable(Context context, float f16) {
        Drawable drawable;
        Drawable drawable2;
        URL url;
        LocalMediaInfo localMediaInfo;
        URLDrawable.URLDrawableOptions obtain;
        Resources resources;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, this, context, Float.valueOf(f16));
        }
        String str = this.path;
        if ((this.roamingType.equals("needUpload") || this.roamingType.equals("failed")) && (TextUtils.isEmpty(str) || !new File(str).exists())) {
            str = this.thumbPath;
        }
        try {
            resources = context.getResources();
            drawable = resources.getDrawable(R.drawable.c0i);
        } catch (Exception e16) {
            e = e16;
            drawable = null;
        } catch (OutOfMemoryError e17) {
            e = e17;
            drawable = null;
        }
        try {
            drawable2 = resources.getDrawable(R.drawable.o4e);
        } catch (Exception e18) {
            e = e18;
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e.getMessage());
            }
            drawable2 = null;
            url = new URL(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, VasExtensionDownloaderConstant.BUSINESS_CAMERA_EMO_PANEL_THUMB, str);
            localMediaInfo = new LocalMediaInfo();
            localMediaInfo.path = str;
            localMediaInfo.thumbWidth = 100;
            localMediaInfo.thumbHeight = 100;
            obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable2;
            obtain.mExtraInfo = this;
            if (!TextUtils.isEmpty(str)) {
            }
        } catch (OutOfMemoryError e19) {
            e = e19;
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e.getMessage());
            }
            drawable2 = null;
            url = new URL(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, VasExtensionDownloaderConstant.BUSINESS_CAMERA_EMO_PANEL_THUMB, str);
            localMediaInfo = new LocalMediaInfo();
            localMediaInfo.path = str;
            localMediaInfo.thumbWidth = 100;
            localMediaInfo.thumbHeight = 100;
            obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable2;
            obtain.mExtraInfo = this;
            if (!TextUtils.isEmpty(str)) {
            }
        }
        try {
            url = new URL(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, VasExtensionDownloaderConstant.BUSINESS_CAMERA_EMO_PANEL_THUMB, str);
            localMediaInfo = new LocalMediaInfo();
            localMediaInfo.path = str;
            localMediaInfo.thumbWidth = 100;
            localMediaInfo.thumbHeight = 100;
            obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable2;
            obtain.mExtraInfo = this;
        } catch (MalformedURLException e26) {
            e26.printStackTrace();
            QLog.e(TAG, 1, "CameraEmoticonInfo: MalformedURLException", e26);
        }
        if (!TextUtils.isEmpty(str)) {
            URLDrawable drawable3 = URLDrawable.getDrawable(url, obtain);
            drawable3.setTag(localMediaInfo);
            return drawable3;
        }
        QLog.e(TAG, 1, "CameraEmoticonInfo path is null! " + toString());
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseFavoriteEmoticonInfo, com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public String getEid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseFavoriteEmoticonInfo, com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public int getEmoId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        return this.emoId;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseFavoriteEmoticonInfo, com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public int getEmoType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return 2;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseFavoriteEmoticonInfo, com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public String getPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.path;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseFavoriteEmoticonInfo, com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public String getResID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseFavoriteEmoticonInfo, com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public String getRoamingType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.roamingType;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseFavoriteEmoticonInfo, com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public String getUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (String) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public Drawable getZoomDrawable(Context context, float f16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Drawable) iPatchRedirector.redirect((short) 6, this, context, Float.valueOf(f16), Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return getDrawable(context, f16);
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseFavoriteEmoticonInfo, com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public boolean isChecked() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.isChecked;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public void send(AppRuntime appRuntime, Context context, EditText editText, Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, appRuntime, context, editText, parcelable);
        } else {
            ((ICameraEmoticonSenderService) QRoute.api(ICameraEmoticonSenderService.class)).send(this, appRuntime, context, editText, parcelable);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseFavoriteEmoticonInfo, com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public void setIsChecked(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.isChecked = z16;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseFavoriteEmoticonInfo, com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo
    public void setPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return String.format("CameraEmoticonInfo, path %s, url %s, contextKey %s", this.path, this.url, this.contextKey);
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseFavoriteEmoticonInfo, com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.contextKey);
        parcel.writeString(this.thumbPath);
        parcel.writeString(this.templateId);
    }

    protected CameraEmoticonInfo(Parcel parcel) {
        super(parcel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.mEmptyDrawable = new ColorDrawable();
        this.contextKey = parcel.readString();
        this.thumbPath = parcel.readString();
        this.templateId = parcel.readString();
    }

    public Drawable getBigDrawable(Context context, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Drawable) iPatchRedirector.redirect((short) 8, this, context, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        try {
            URL url = new URL(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, VasExtensionDownloaderConstant.BUSINESS_CAMERA_EMO_PANEL_DYNAMIC, this.path);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestHeight = i3;
            obtain.mRequestWidth = i16;
            obtain.mFailedDrawable = context.getResources().getDrawable(R.drawable.o4e);
            obtain.mLoadingDrawable = this.mEmptyDrawable;
            obtain.mPlayGifImage = true;
            URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "d: width = " + drawable.getIntrinsicWidth() + ";height = " + drawable.getIntrinsicHeight() + ";options:width = " + obtain.mRequestWidth + ";options:height = " + obtain.mRequestHeight);
            }
            return drawable;
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            return null;
        }
    }
}
