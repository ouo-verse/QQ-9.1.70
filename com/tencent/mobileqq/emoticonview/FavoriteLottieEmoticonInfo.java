package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.VasExtensionDownloaderConstant;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FavoriteLottieEmoticonInfo extends FavoriteEmoticonInfo {
    static IPatchRedirector $redirector_ = null;
    public static final Parcelable.Creator<FavoriteLottieEmoticonInfo> CREATOR;
    private static final String TAG = "FavoriteEmoticonInfo";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46879);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            CREATOR = new Parcelable.Creator<FavoriteLottieEmoticonInfo>() { // from class: com.tencent.mobileqq.emoticonview.FavoriteLottieEmoticonInfo.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public FavoriteLottieEmoticonInfo createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new FavoriteLottieEmoticonInfo(parcel) : (FavoriteLottieEmoticonInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public FavoriteLottieEmoticonInfo[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new FavoriteLottieEmoticonInfo[i3] : (FavoriteLottieEmoticonInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public FavoriteLottieEmoticonInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo, com.tencent.mobileqq.emoticonview.EmoticonInfo
    public Drawable getBigDrawable(Context context, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, this, context, Float.valueOf(f16));
        }
        try {
            URL url = new URL(VasExtensionDownloaderConstant.PROTOCOL_VAS_EXTENSION, VasExtensionDownloaderConstant.BUSINESS_FAVORITE_PANEL_DYNAMIC, QQSysAndEmojiResMgr.getInstance().getFullResPath(4, Integer.parseInt(getEid())));
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mFailedDrawable = context.getResources().getDrawable(R.drawable.o4e);
            obtain.mLoadingDrawable = this.mEmptyDrawable;
            obtain.mPlayGifImage = true;
            obtain.mUseApngImage = true;
            obtain.mGifRefreshDelay = com.tencent.mobileqq.emosm.e.v();
            URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
            if (QLog.isColorLevel()) {
                QLog.d("FavoriteEmoticonInfo", 2, "d: width = " + drawable.getIntrinsicWidth() + ";height = " + drawable.getIntrinsicHeight() + ";options:width = " + obtain.mRequestWidth + ";options:height = " + obtain.mRequestHeight);
            }
            return drawable;
        } catch (Throwable th5) {
            QLog.e("FavoriteEmoticonInfo", 1, "[getBigDrawable] error. stack=", th5);
            return null;
        }
    }

    public FavoriteLottieEmoticonInfo(Parcel parcel) {
        super(parcel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
    }
}
