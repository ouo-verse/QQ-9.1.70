package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.image.URLDrawable;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.VasExtensionDownloaderConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FavoriteEmoticonInfo extends BaseFavoriteEmoticonInfo {
    static IPatchRedirector $redirector_ = null;
    public static final Parcelable.Creator<FavoriteEmoticonInfo> CREATOR;
    public static final String TAG = "FavoriteEmoticonInfo";
    public String actionData;
    public String emojiMd5;
    public int jumpId;
    public String remark;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46320);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            CREATOR = new Parcelable.Creator<FavoriteEmoticonInfo>() { // from class: com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public FavoriteEmoticonInfo createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new FavoriteEmoticonInfo(parcel) : (FavoriteEmoticonInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public FavoriteEmoticonInfo[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new FavoriteEmoticonInfo[i3] : (FavoriteEmoticonInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public FavoriteEmoticonInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.emojiMd5 = "";
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseFavoriteEmoticonInfo, com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public Drawable getBigDrawable(Context context, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Drawable) iPatchRedirector.redirect((short) 6, this, context, Float.valueOf(f16));
        }
        try {
            URL url = new URL(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_DYNAMIC, this.path);
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

    /* JADX WARN: Removed duplicated region for block: B:14:0x008b A[Catch: MalformedURLException -> 0x00ad, TryCatch #2 {MalformedURLException -> 0x00ad, blocks: (B:12:0x005d, B:14:0x008b, B:16:0x0093), top: B:11:0x005d }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0093 A[Catch: MalformedURLException -> 0x00ad, TRY_LEAVE, TryCatch #2 {MalformedURLException -> 0x00ad, blocks: (B:12:0x005d, B:14:0x008b, B:16:0x0093), top: B:11:0x005d }] */
    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Drawable getDrawable(Context context, float f16) {
        Drawable drawable;
        URL url;
        LocalMediaInfo localMediaInfo;
        URLDrawable.URLDrawableOptions obtain;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, this, context, Float.valueOf(f16));
        }
        Drawable colorDrawable = new ColorDrawable();
        try {
            Resources resources = context.getResources();
            colorDrawable = resources.getDrawable(R.drawable.c0i);
            drawable = resources.getDrawable(R.drawable.o4e);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e16.getMessage());
            }
            drawable = null;
            url = new URL(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_THUMB, this.path);
            localMediaInfo = new LocalMediaInfo();
            localMediaInfo.path = this.path;
            localMediaInfo.thumbWidth = 100;
            localMediaInfo.thumbHeight = 100;
            obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = colorDrawable;
            obtain.mFailedDrawable = drawable;
            obtain.mExtraInfo = this;
            if (!TextUtils.isEmpty(this.path)) {
            }
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e17.getMessage());
            }
            drawable = null;
            url = new URL(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_THUMB, this.path);
            localMediaInfo = new LocalMediaInfo();
            localMediaInfo.path = this.path;
            localMediaInfo.thumbWidth = 100;
            localMediaInfo.thumbHeight = 100;
            obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = colorDrawable;
            obtain.mFailedDrawable = drawable;
            obtain.mExtraInfo = this;
            if (!TextUtils.isEmpty(this.path)) {
            }
        }
        try {
            url = new URL(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_THUMB, this.path);
            localMediaInfo = new LocalMediaInfo();
            localMediaInfo.path = this.path;
            localMediaInfo.thumbWidth = 100;
            localMediaInfo.thumbHeight = 100;
            obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = colorDrawable;
            obtain.mFailedDrawable = drawable;
            obtain.mExtraInfo = this;
        } catch (MalformedURLException e18) {
            e18.printStackTrace();
            QLog.e(TAG, 1, "FavoriteEmoticonInfo: MalformedURLException", e18);
        }
        if (!TextUtils.isEmpty(this.path)) {
            URLDrawable drawable2 = URLDrawable.getDrawable(url, obtain);
            drawable2.setTag(localMediaInfo);
            return drawable2;
        }
        QLog.e(TAG, 1, "FavoriteEmoticonInfo path is null! " + toString());
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseFavoriteEmoticonInfo, com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    public String getName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.remark;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    @Nullable
    public Option getOption() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Option) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return Option.obtain().setLocalPath(this.path).setLoadingDrawable(this.mEmptyDrawable).setFailDrawable(BaseApplication.getContext().getResources().getDrawable(R.drawable.o4e));
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0096 A[Catch: MalformedURLException -> 0x00b8, TryCatch #0 {MalformedURLException -> 0x00b8, blocks: (B:12:0x006a, B:14:0x0096, B:16:0x009e), top: B:11:0x006a }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009e A[Catch: MalformedURLException -> 0x00b8, TRY_LEAVE, TryCatch #0 {MalformedURLException -> 0x00b8, blocks: (B:12:0x006a, B:14:0x0096, B:16:0x009e), top: B:11:0x006a }] */
    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Drawable getZoomDrawable(Context context, float f16, int i3, int i16) {
        Drawable drawable;
        URL url;
        LocalMediaInfo localMediaInfo;
        URLDrawable.URLDrawableOptions obtain;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, this, context, Float.valueOf(f16), Integer.valueOf(i3), Integer.valueOf(i16));
        }
        Drawable colorDrawable = new ColorDrawable();
        try {
            Resources resources = context.getResources();
            colorDrawable = resources.getDrawable(R.drawable.c0i);
            drawable = resources.getDrawable(R.drawable.o4e);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e16.getMessage());
            }
            drawable = null;
            url = new URL(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_THUMB_NEW, this.path);
            localMediaInfo = new LocalMediaInfo();
            localMediaInfo.path = this.path;
            localMediaInfo.thumbWidth = i3;
            localMediaInfo.thumbHeight = i16;
            obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = colorDrawable;
            obtain.mFailedDrawable = drawable;
            obtain.mExtraInfo = this;
            if (!TextUtils.isEmpty(this.path)) {
            }
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e17.getMessage());
            }
            drawable = null;
            url = new URL(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_THUMB_NEW, this.path);
            localMediaInfo = new LocalMediaInfo();
            localMediaInfo.path = this.path;
            localMediaInfo.thumbWidth = i3;
            localMediaInfo.thumbHeight = i16;
            obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = colorDrawable;
            obtain.mFailedDrawable = drawable;
            obtain.mExtraInfo = this;
            if (!TextUtils.isEmpty(this.path)) {
            }
        }
        try {
            url = new URL(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_THUMB_NEW, this.path);
            localMediaInfo = new LocalMediaInfo();
            localMediaInfo.path = this.path;
            localMediaInfo.thumbWidth = i3;
            localMediaInfo.thumbHeight = i16;
            obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = colorDrawable;
            obtain.mFailedDrawable = drawable;
            obtain.mExtraInfo = this;
        } catch (MalformedURLException e18) {
            e18.printStackTrace();
            QLog.e(TAG, 1, "getZoomDrawable: MalformedURLException", e18);
        }
        if (!TextUtils.isEmpty(this.path)) {
            URLDrawable drawable2 = URLDrawable.getDrawable(url, obtain);
            drawable2.setTag(localMediaInfo);
            return drawable2;
        }
        QLog.e(TAG, 1, "getZoomDrawable path is null! " + toString());
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return String.format("FavoriteEmoticonInfo, path %s, url %s", this.path, this.url);
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseFavoriteEmoticonInfo, com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) parcel, i3);
            return;
        }
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.actionData);
        parcel.writeInt(this.jumpId);
        parcel.writeString(this.emojiMd5);
        parcel.writeString(this.remark);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FavoriteEmoticonInfo(Parcel parcel) {
        super(parcel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.emojiMd5 = "";
        this.actionData = parcel.readString();
        this.jumpId = parcel.readInt();
        this.emojiMd5 = parcel.readString();
        this.remark = parcel.readString();
    }

    public Drawable getBigDrawable(Context context, float f16, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Drawable) iPatchRedirector.redirect((short) 7, this, context, Float.valueOf(f16), Integer.valueOf(i3), Integer.valueOf(i16));
        }
        try {
            URL url = new URL(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_DYNAMIC, this.path);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestHeight = i3;
            obtain.mRequestWidth = i16;
            obtain.mFailedDrawable = context.getResources().getDrawable(R.drawable.o4e);
            obtain.mLoadingDrawable = this.mEmptyDrawable;
            obtain.mPlayGifImage = true;
            obtain.mGifRefreshDelay = com.tencent.mobileqq.emosm.e.v();
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
