package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.api.IEmoticonManagerService;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class SmallEmoticonInfo extends EmoticonInfo implements ISmallEmoticonInfo {
    static IPatchRedirector $redirector_ = null;
    public static final Parcelable.Creator<SmallEmoticonInfo> CREATOR;
    private static final String TAG = "SmallEmoticonInfo";
    public Emoticon emoticon;
    public int imageType;
    public boolean isAPNG;
    private Drawable mDefault;
    private ColorDrawable mEmptyDrawable;
    private Drawable mFailed;
    private int reqHeight;
    private int reqWidth;
    private String uin;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42728);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            CREATOR = new Parcelable.Creator<SmallEmoticonInfo>() { // from class: com.tencent.mobileqq.emoticonview.SmallEmoticonInfo.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SmallEmoticonInfo createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new SmallEmoticonInfo(parcel) : (SmallEmoticonInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SmallEmoticonInfo[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new SmallEmoticonInfo[i3] : (SmallEmoticonInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public SmallEmoticonInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.mEmptyDrawable = new ColorDrawable();
        this.mDefault = null;
        this.mFailed = null;
        this.reqWidth = 0;
        this.reqHeight = 0;
        this.uin = str;
        try {
            Resources resources = BaseApplication.getContext().getResources();
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

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public Drawable getBigDrawable(Context context, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, this, context, Float.valueOf(f16));
        }
        if (this.emoticon == null) {
            return null;
        }
        try {
            URL url = new URL(EmotionConstants.PROTOCOL_EMOTION_PIC, EmotionConstants.FROM_AIO, getFictionPath(this.emoticon));
            Drawable drawable = this.mFailed;
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mFailedDrawable = drawable;
            obtain.mLoadingDrawable = this.mDefault;
            obtain.mPlayGifImage = true;
            if (this.isAPNG) {
                obtain.mUseApngImage = true;
                obtain.mPlayGifImage = false;
                obtain.mMemoryCacheKeySuffix = "useAPNG";
            }
            obtain.mRequestWidth = this.reqWidth;
            obtain.mRequestHeight = this.reqHeight;
            URLDrawable drawable2 = URLDrawable.getDrawable(url, obtain);
            if (drawable2.getStatus() != 1) {
                drawable2.setTag(this.emoticon);
                drawable2.addHeader("my_uin", this.uin);
                drawable2.addHeader(ProtocolDownloaderConstants.HEADER_EMOTICON_NEED_BIG, "true");
            }
            return drawable2;
        } catch (MalformedURLException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getDrawable ,", e16);
            }
            return null;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public Drawable getDrawable(Context context, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, this, context, Float.valueOf(f16));
        }
        if (this.emoticon != null) {
            try {
                URLDrawable drawable = URLDrawable.getDrawable(new URL(EmotionConstants.PROTOCOL_EMOTION_PIC, EmotionConstants.FROM_PANEL, getFictionPath(this.emoticon)), this.mDefault, this.mFailed, false);
                drawable.setTag(this.emoticon);
                drawable.addHeader("my_uin", this.uin);
                return drawable;
            } catch (MalformedURLException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getDrawable ,", e16);
                }
                return this.mDefault;
            }
        }
        return this.mDefault;
    }

    @Override // com.tencent.mobileqq.emoticonview.ISmallEmoticonInfo
    public Emoticon getEmoticon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Emoticon) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.emoticon;
    }

    public String getFictionPath(Emoticon emoticon) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) emoticon);
        }
        if (emoticon == null) {
            return null;
        }
        return emoticon.epId + "_" + emoticon.eId;
    }

    public boolean isAioPreviewExists() {
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        Emoticon emoticon = this.emoticon;
        if (emoticon == null) {
            return false;
        }
        if (emoticon.jobType == 1) {
            a16 = com.tencent.qqnt.emotion.utils.j.f(emoticon.epId, emoticon.eId);
        } else {
            a16 = com.tencent.qqnt.emotion.utils.j.a(emoticon.epId, emoticon.eId);
        }
        if (a16 == null) {
            return false;
        }
        File file = new File(a16);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        return true;
    }

    public boolean isBigImageExists() {
        String str;
        boolean z16;
        Emoticon emoticon;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        Emoticon emoticon2 = this.emoticon;
        if (emoticon2 == null) {
            return false;
        }
        if (emoticon2.jobType != 1) {
            str = com.tencent.qqnt.emotion.utils.j.c(emoticon2.epId, emoticon2.eId);
        } else {
            str = "";
        }
        if (str != null) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                z16 = true;
                emoticon = this.emoticon;
                if (!emoticon.isSound && z16) {
                    String d16 = com.tencent.qqnt.emotion.utils.j.d(emoticon.epId, emoticon.eId);
                    if (d16 != null) {
                        File file2 = new File(d16);
                        if (file2.exists() && file2.isFile()) {
                            z17 = true;
                            if (!z16 && z17) {
                                return true;
                            }
                        }
                    }
                    z17 = false;
                    return !z16 ? false : false;
                }
                return z16;
            }
        }
        z16 = false;
        emoticon = this.emoticon;
        if (!emoticon.isSound) {
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public void send(AppRuntime appRuntime, Context context, EditText editText, Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, appRuntime, context, editText, parcelable);
            return;
        }
        if (appRuntime == null) {
            QLog.e(TAG, 2, "app is null.");
            return;
        }
        Emoticon emoticon = this.emoticon;
        if (emoticon == null) {
            QLog.e(TAG, 1, "fail to send small_emotion.");
            return;
        }
        if (!(appRuntime instanceof BaseQQAppInterface)) {
            return;
        }
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) appRuntime;
        try {
            int parseInt = Integer.parseInt(emoticon.eId);
            int parseInt2 = Integer.parseInt(this.emoticon.epId);
            QLog.i(TAG, 4, "epId=" + parseInt2 + " eId=" + parseInt);
            ((IEmoticonManagerService) baseQQAppInterface.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(String.valueOf(parseInt2), new com.tencent.qqnt.emotion.c<EmoticonPackage>(parseInt2, parseInt, editText) { // from class: com.tencent.mobileqq.emoticonview.SmallEmoticonInfo.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$eId;
                final /* synthetic */ int val$epId;
                final /* synthetic */ EditText val$input;

                {
                    this.val$epId = parseInt2;
                    this.val$eId = parseInt;
                    this.val$input = editText;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SmallEmoticonInfo.this, Integer.valueOf(parseInt2), Integer.valueOf(parseInt), editText);
                    }
                }

                @Override // com.tencent.qqnt.emotion.c
                public void postQuery(EmoticonPackage emoticonPackage) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) emoticonPackage);
                        return;
                    }
                    char[] b16 = com.tencent.qqnt.emotion.utils.a.b(this.val$epId, this.val$eId);
                    char[] cArr = {20, b16[3], b16[2], b16[1], b16[0]};
                    if (emoticonPackage != null && emoticonPackage.isAPNG == 2) {
                        cArr[1] = '\u01ff';
                    }
                    this.val$input.getEditableText().replace(this.val$input.getSelectionStart(), this.val$input.getSelectionEnd(), String.valueOf(cArr));
                    this.val$input.requestFocus();
                }
            });
        } catch (NumberFormatException unused) {
            QLog.e(TAG, 1, "fail to send small_emotion. id is not Int.");
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.ISmallEmoticonInfo
    public void setEmoticon(Emoticon emoticon) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) emoticon);
        } else {
            this.emoticon = emoticon;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.ISmallEmoticonInfo
    public void setIsAPNG(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.isAPNG = z16;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) parcel, i3);
            return;
        }
        super.writeToParcel(parcel, i3);
        parcel.writeSerializable(this.emoticon);
        parcel.writeInt(this.imageType);
        parcel.writeString(this.uin);
        parcel.writeInt(this.reqWidth);
        parcel.writeInt(this.reqHeight);
        parcel.writeByte(this.isAPNG ? (byte) 1 : (byte) 0);
    }

    protected SmallEmoticonInfo(Parcel parcel) {
        super(parcel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.mEmptyDrawable = new ColorDrawable();
        this.mDefault = null;
        this.mFailed = null;
        this.reqWidth = 0;
        this.reqHeight = 0;
        this.emoticon = (Emoticon) parcel.readSerializable();
        this.imageType = parcel.readInt();
        this.uin = parcel.readString();
        this.reqWidth = parcel.readInt();
        this.reqHeight = parcel.readInt();
        this.isAPNG = parcel.readByte() != 0;
    }
}
