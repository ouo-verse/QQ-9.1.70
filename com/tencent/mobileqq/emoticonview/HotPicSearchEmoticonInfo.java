package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.EditText;
import androidx.annotation.Nullable;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.image.URLDrawable;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emoticonview.api.IHotPicSearchService;
import com.tencent.mobileqq.hotpic.api.IHotPicApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* loaded from: classes12.dex */
public class HotPicSearchEmoticonInfo extends EmoticonInfo implements IHotPicSearchEmoticonInfo {
    static IPatchRedirector $redirector_ = null;
    public static final Parcelable.Creator<HotPicSearchEmoticonInfo> CREATOR;
    static final long ONE_SEC = 1000;
    public static final String SEARCH_ITEM = "SearchItem";
    public static final String TAG = "HotPicSearchEmoticonInfo";
    static long lastTime;
    public static Drawable sLoadingDrawable;
    private String mLogString;
    protected int mPageType;
    protected int mReportPosition;
    public EmotionSearchItem mSearchItem;
    public String mSearchWord;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50081);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            sLoadingDrawable = new ColorDrawable(DownloadCardView.COLOR_APP_NAME_DARK);
            CREATOR = new Parcelable.Creator<HotPicSearchEmoticonInfo>() { // from class: com.tencent.mobileqq.emoticonview.HotPicSearchEmoticonInfo.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public HotPicSearchEmoticonInfo createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new HotPicSearchEmoticonInfo(parcel) : (HotPicSearchEmoticonInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public HotPicSearchEmoticonInfo[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new HotPicSearchEmoticonInfo[i3] : (HotPicSearchEmoticonInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public HotPicSearchEmoticonInfo(int i3, int i16, String str, EmotionSearchItem emotionSearchItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), str, emotionSearchItem);
            return;
        }
        this.mPageType = i3;
        this.mSearchWord = str;
        this.mSearchItem = emotionSearchItem;
        this.mReportPosition = i16;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public Drawable getBigDrawable(Context context, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, this, context, Float.valueOf(f16));
        }
        return getDrawable(context, f16);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public Drawable getDrawable(Context context, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Drawable) iPatchRedirector.redirect((short) 3, this, context, Float.valueOf(f16));
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = sLoadingDrawable;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable;
        obtain.mPlayGifImage = true;
        obtain.mExtraInfo = this.mSearchItem;
        obtain.mGifRefreshDelay = com.tencent.mobileqq.emosm.e.v();
        URL url = ((IHotPicSearchService) QRoute.api(IHotPicSearchService.class)).getURL(this.mSearchItem.url);
        if (url == null) {
            return null;
        }
        return URLDrawable.getDrawable(url, obtain);
    }

    public String getLogString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        String str = this.mLogString;
        if (str != null) {
            return str;
        }
        if (this.mSearchItem == null) {
            this.mLogString = "";
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("searchWord:");
        sb5.append(this.mSearchWord);
        sb5.append(", width:");
        sb5.append(this.mSearchItem.width);
        sb5.append(", height:");
        sb5.append(this.mSearchItem.height);
        sb5.append(", id:");
        sb5.append(this.mSearchItem.md5);
        if (this.mSearchItem.textComposeInfo != null) {
            sb5.append("_");
            sb5.append(com.tencent.mobileqq.emosm.emosearch.b.f204292a.h(this.mSearchItem.textComposeInfo));
        }
        String sb6 = sb5.toString();
        this.mLogString = sb6;
        return sb6;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    @Nullable
    public Option getOption() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Option) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        HashMap hashMap = new HashMap();
        hashMap.put(SEARCH_ITEM, this.mSearchItem);
        Option url = Option.obtain().setLocalPath(((IHotPicApi) QRoute.api(IHotPicApi.class)).getDiskFilePath(this.mSearchItem.url)).setLoadingDrawable(sLoadingDrawable).setFailDrawable(sLoadingDrawable).setExtraData(hashMap).setUrl(this.mSearchItem.url);
        com.tencent.libra.util.a aVar = com.tencent.libra.util.a.f118813a;
        aVar.p(url, false);
        aVar.r(url, false);
        return url;
    }

    @Override // com.tencent.mobileqq.emoticonview.IHotPicSearchEmoticonInfo
    public void report(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime);
            return;
        }
        ReportController.o(appRuntime, "dc00898", "", "", "0X800AE36", "0X800AE36", 0, 0, this.mReportPosition + "", "", this.mSearchItem.getEmoMd5(), "");
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public void send(AppRuntime appRuntime, Context context, EditText editText, Parcelable parcelable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appRuntime, context, editText, parcelable);
            return;
        }
        if (appRuntime == null) {
            QLog.e(TAG, 2, "app is null.");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastTime < 1000) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "send to offen,please try it later");
            }
        } else {
            lastTime = currentTimeMillis;
            ((IHotPicSearchService) QRoute.api(IHotPicSearchService.class)).send(appRuntime, context, editText, parcelable, this.mSearchItem, this.mSearchWord, this.mPageType, this.mReportPosition);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return String.format("HotPicSearchEmoticonInfo, SearchItem %s", this.mSearchItem.toString());
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) parcel, i3);
            return;
        }
        super.writeToParcel(parcel, i3);
        parcel.writeParcelable(this.mSearchItem, i3);
        parcel.writeString(this.mSearchWord);
        parcel.writeInt(this.mPageType);
        parcel.writeInt(this.mReportPosition);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HotPicSearchEmoticonInfo(Parcel parcel) {
        super(parcel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.mSearchItem = (EmotionSearchItem) parcel.readParcelable(EmotionSearchItem.class.getClassLoader());
        this.mSearchWord = parcel.readString();
        this.mPageType = parcel.readInt();
        this.mReportPosition = parcel.readInt();
    }
}
