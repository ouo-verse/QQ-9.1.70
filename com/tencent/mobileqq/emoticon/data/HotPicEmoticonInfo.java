package com.tencent.mobileqq.emoticon.data;

import android.os.Parcel;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u000f\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u000eH\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/HotPicEmoticonInfo;", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "hotPicData", "Lcom/tencent/mobileqq/hotpic/HotPicData;", "(Lcom/tencent/mobileqq/hotpic/HotPicData;)V", "getHotPicData", "()Lcom/tencent/mobileqq/hotpic/HotPicData;", "getBigImagePath", "", "getBigImageURL", "getEmoticonType", "", "getName", "getThumbImagePath", "getThumbURL", "writeToParcel", "", "dest", WadlProxyConsts.FLAGS, "Companion", "qqemoticondata-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class HotPicEmoticonInfo extends EmoticonInfo {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "HotPicEmoticonInfo";

    @Nullable
    private final HotPicData hotPicData;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/HotPicEmoticonInfo$Companion;", "", "()V", "TAG", "", "qqemoticondata-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32470);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HotPicEmoticonInfo(@Nullable HotPicData hotPicData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hotPicData);
        } else {
            this.hotPicData = hotPicData;
            this.type = 12;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    @Nullable
    public String getBigImagePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        HotPicData hotPicData = this.hotPicData;
        if (hotPicData != null) {
            return hotPicData.originalUrl;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    @Nullable
    public String getBigImageURL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        HotPicData hotPicData = this.hotPicData;
        if (hotPicData != null) {
            return hotPicData.originalUrl;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    public int getEmoticonType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.type;
    }

    @Nullable
    public final HotPicData getHotPicData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HotPicData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.hotPicData;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    @NotNull
    public String getName() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        HotPicData hotPicData = this.hotPicData;
        if (hotPicData != null) {
            str = hotPicData.name;
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    @Nullable
    public String getThumbImagePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        HotPicData hotPicData = this.hotPicData;
        if (hotPicData != null) {
            return hotPicData.iconUrl;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticon.data.IEmoticonInfo
    @Nullable
    public String getThumbURL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        HotPicData hotPicData = this.hotPicData;
        if (hotPicData != null) {
            return hotPicData.iconUrl;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.emoticonview.EmoticonInfo, com.tencent.mobileqq.emoticonview.EmotionPanelData, android.os.Parcelable
    public void writeToParcel(@Nullable Parcel dest, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) dest, flags);
            return;
        }
        super.writeToParcel(dest, flags);
        HotPicData hotPicData = this.hotPicData;
        if (hotPicData != null) {
            hotPicData.writeToParcel(dest, flags);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HotPicEmoticonInfo(@NotNull Parcel parcel) {
        this((HotPicData) parcel.readParcelable(HotPicData.class.getClassLoader()));
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
    }
}
