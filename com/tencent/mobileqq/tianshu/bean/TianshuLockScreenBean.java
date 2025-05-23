package com.tencent.mobileqq.tianshu.bean;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0013\b\u0086\b\u0018\u0000 82\u00020\u0001:\u0001#Bg\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\t\u0012\b\u0010%\u001a\u0004\u0018\u00010 \u0012\u0006\u0010+\u001a\u00020&\u0012\u0006\u0010/\u001a\u00020\u000e\u0012\b\u00102\u001a\u0004\u0018\u00010\t\u0012\b\u00104\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b5\u00106B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b5\u00107J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013R\u0019\u0010%\u001a\u0004\u0018\u00010 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010+\u001a\u00020&8\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010/\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b!\u0010.R\u0019\u00102\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b0\u0010\u0011\u001a\u0004\b1\u0010\u0013R\u0019\u00104\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b3\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/tianshu/bean/TianshuLockScreenBean;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "backgroundUrl", "e", "l", AppConstants.Key.KEY_QZONE_VIDEO_URL, "f", "k", "titleText", h.F, "contentText", "i", "b", "actionText", "Landroid/content/Intent;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Intent;", "a", "()Landroid/content/Intent;", "actionIntent", "", BdhLogUtil.LogTag.Tag_Conn, "J", "g", "()J", "duration", "D", "Z", "()Z", "isLoop", "E", "j", "leftIcon", UserInfo.SEX_FEMALE, "bgTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;JZLjava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "tianshu-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final /* data */ class TianshuLockScreenBean implements Parcelable {
    static IPatchRedirector $redirector_;

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private final long duration;

    /* renamed from: D, reason: from kotlin metadata */
    private final boolean isLoop;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final String leftIcon;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private final String bgTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String backgroundUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String videoUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String titleText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String contentText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String actionText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Intent actionIntent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/tianshu/bean/TianshuLockScreenBean$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/tianshu/bean/TianshuLockScreenBean;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/tianshu/bean/TianshuLockScreenBean;", "<init>", "()V", "tianshu-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.tianshu.bean.TianshuLockScreenBean$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion implements Parcelable.Creator<TianshuLockScreenBean> {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TianshuLockScreenBean createFromParcel(@NotNull Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TianshuLockScreenBean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TianshuLockScreenBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TianshuLockScreenBean[] newArray(int size) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (TianshuLockScreenBean[]) iPatchRedirector.redirect((short) 3, (Object) this, size);
            }
            return new TianshuLockScreenBean[size];
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34073);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TianshuLockScreenBean(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Intent intent, long j3, boolean z16, @Nullable String str6, @Nullable String str7) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4, str5, intent, Long.valueOf(j3), Boolean.valueOf(z16), str6, str7);
            return;
        }
        this.backgroundUrl = str;
        this.videoUrl = str2;
        this.titleText = str3;
        this.contentText = str4;
        this.actionText = str5;
        this.actionIntent = intent;
        this.duration = j3;
        this.isLoop = z16;
        this.leftIcon = str6;
        this.bgTitle = str7;
    }

    @Nullable
    public final Intent a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Intent) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.actionIntent;
    }

    @Nullable
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.actionText;
    }

    @Nullable
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.backgroundUrl;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return 0;
    }

    @Nullable
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.bgTitle;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof TianshuLockScreenBean)) {
            return false;
        }
        TianshuLockScreenBean tianshuLockScreenBean = (TianshuLockScreenBean) other;
        if (Intrinsics.areEqual(this.backgroundUrl, tianshuLockScreenBean.backgroundUrl) && Intrinsics.areEqual(this.videoUrl, tianshuLockScreenBean.videoUrl) && Intrinsics.areEqual(this.titleText, tianshuLockScreenBean.titleText) && Intrinsics.areEqual(this.contentText, tianshuLockScreenBean.contentText) && Intrinsics.areEqual(this.actionText, tianshuLockScreenBean.actionText) && Intrinsics.areEqual(this.actionIntent, tianshuLockScreenBean.actionIntent) && this.duration == tianshuLockScreenBean.duration && this.isLoop == tianshuLockScreenBean.isLoop && Intrinsics.areEqual(this.leftIcon, tianshuLockScreenBean.leftIcon) && Intrinsics.areEqual(this.bgTitle, tianshuLockScreenBean.bgTitle)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.contentText;
    }

    public final long g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Long) iPatchRedirector.redirect((short) 8, (Object) this)).longValue();
        }
        return this.duration;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this)).intValue();
        }
        String str = this.backgroundUrl;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.videoUrl;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.titleText;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str4 = this.contentText;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str5 = this.actionText;
        if (str5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str5.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        Intent intent = this.actionIntent;
        if (intent == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = intent.hashCode();
        }
        int a16 = (((i26 + hashCode6) * 31) + androidx.fragment.app.a.a(this.duration)) * 31;
        boolean z16 = this.isLoop;
        int i27 = z16;
        if (z16 != 0) {
            i27 = 1;
        }
        int i28 = (a16 + i27) * 31;
        String str6 = this.leftIcon;
        if (str6 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = str6.hashCode();
        }
        int i29 = (i28 + hashCode7) * 31;
        String str7 = this.bgTitle;
        if (str7 != null) {
            i3 = str7.hashCode();
        }
        return i29 + i3;
    }

    @Nullable
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.leftIcon;
    }

    @Nullable
    public final String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.titleText;
    }

    @Nullable
    public final String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.videoUrl;
    }

    public final boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return this.isLoop;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return "TianshuLockScreenBean(backgroundUrl=" + this.backgroundUrl + ", videoUrl=" + this.videoUrl + ", titleText=" + this.titleText + ", contentText=" + this.contentText + ", actionText=" + this.actionText + ", actionIntent=" + this.actionIntent + ", duration=" + this.duration + ", isLoop=" + this.isLoop + ", leftIcon=" + this.leftIcon + ", bgTitle=" + this.bgTitle + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) parcel, flags);
            return;
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.backgroundUrl);
        parcel.writeString(this.videoUrl);
        parcel.writeString(this.titleText);
        parcel.writeString(this.contentText);
        parcel.writeString(this.actionText);
        parcel.writeParcelable(this.actionIntent, flags);
        parcel.writeLong(this.duration);
        parcel.writeInt(this.isLoop ? 1 : 0);
        parcel.writeString(this.leftIcon);
        parcel.writeString(this.bgTitle);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TianshuLockScreenBean(@NotNull Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readLong(), parcel.readInt() == 1, parcel.readString(), parcel.readString());
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return;
        }
        iPatchRedirector.redirect((short) 12, (Object) this, (Object) parcel);
    }
}
