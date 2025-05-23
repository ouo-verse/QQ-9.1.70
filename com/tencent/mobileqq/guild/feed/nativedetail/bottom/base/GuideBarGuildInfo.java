package com.tencent.mobileqq.guild.feed.nativedetail.bottom.base;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b*\u0010+JL\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002H\u00c6\u0001\u00a2\u0006\u0004\b\t\u0010\nJ\t\u0010\u000b\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003J\t\u0010\u0011\u001a\u00020\fH\u00d6\u0001J\u0019\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\fH\u00d6\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0018\u001a\u0004\b(\u0010\u001a\"\u0004\b)\u0010\u001c\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/base/GuideBarGuildInfo;", "Landroid/os/Parcelable;", "", "guildId", "guildName", "guildIcon", "", "isMember", "recommendTag", "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/base/GuideBarGuildInfo;", "toString", "", "hashCode", "", "other", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "f", "l", "c", "k", h.F, "Ljava/lang/Boolean;", "j", "()Ljava/lang/Boolean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/Boolean;)V", "i", "g", DomainData.DOMAIN_NAME, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class GuideBarGuildInfo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<GuideBarGuildInfo> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String guildId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String guildName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String guildIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Boolean isMember;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String recommendTag;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a implements Parcelable.Creator<GuideBarGuildInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final GuideBarGuildInfo createFromParcel(@NotNull Parcel parcel) {
            boolean z16;
            Boolean valueOf;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                if (parcel.readInt() != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                valueOf = Boolean.valueOf(z16);
            }
            return new GuideBarGuildInfo(readString, readString2, readString3, valueOf, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final GuideBarGuildInfo[] newArray(int i3) {
            return new GuideBarGuildInfo[i3];
        }
    }

    public GuideBarGuildInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ GuideBarGuildInfo b(GuideBarGuildInfo guideBarGuildInfo, String str, String str2, String str3, Boolean bool, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = guideBarGuildInfo.guildId;
        }
        if ((i3 & 2) != 0) {
            str2 = guideBarGuildInfo.guildName;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            str3 = guideBarGuildInfo.guildIcon;
        }
        String str6 = str3;
        if ((i3 & 8) != 0) {
            bool = guideBarGuildInfo.isMember;
        }
        Boolean bool2 = bool;
        if ((i3 & 16) != 0) {
            str4 = guideBarGuildInfo.recommendTag;
        }
        return guideBarGuildInfo.a(str, str5, str6, bool2, str4);
    }

    @NotNull
    public final GuideBarGuildInfo a(@Nullable String guildId, @Nullable String guildName, @Nullable String guildIcon, @Nullable Boolean isMember, @Nullable String recommendTag) {
        return new GuideBarGuildInfo(guildId, guildName, guildIcon, isMember, recommendTag);
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getGuildIcon() {
        return this.guildIcon;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuideBarGuildInfo)) {
            return false;
        }
        GuideBarGuildInfo guideBarGuildInfo = (GuideBarGuildInfo) other;
        if (Intrinsics.areEqual(this.guildId, guideBarGuildInfo.guildId) && Intrinsics.areEqual(this.guildName, guideBarGuildInfo.guildName) && Intrinsics.areEqual(this.guildIcon, guideBarGuildInfo.guildIcon) && Intrinsics.areEqual(this.isMember, guideBarGuildInfo.isMember) && Intrinsics.areEqual(this.recommendTag, guideBarGuildInfo.recommendTag)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final String getRecommendTag() {
        return this.recommendTag;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        String str = this.guildId;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        String str2 = this.guildName;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str3 = this.guildIcon;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        Boolean bool = this.isMember;
        if (bool == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = bool.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str4 = this.recommendTag;
        if (str4 != null) {
            i3 = str4.hashCode();
        }
        return i19 + i3;
    }

    @Nullable
    /* renamed from: j, reason: from getter */
    public final Boolean getIsMember() {
        return this.isMember;
    }

    public final void k(@Nullable String str) {
        this.guildIcon = str;
    }

    public final void l(@Nullable String str) {
        this.guildName = str;
    }

    public final void m(@Nullable Boolean bool) {
        this.isMember = bool;
    }

    public final void n(@Nullable String str) {
        this.recommendTag = str;
    }

    @NotNull
    public String toString() {
        return "GuideBarGuildInfo(guildId=" + this.guildId + ", guildName=" + this.guildName + ", guildIcon=" + this.guildIcon + ", isMember=" + this.isMember + ", recommendTag=" + this.recommendTag + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        int i3;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.guildId);
        parcel.writeString(this.guildName);
        parcel.writeString(this.guildIcon);
        Boolean bool = this.isMember;
        if (bool == null) {
            i3 = 0;
        } else {
            parcel.writeInt(1);
            i3 = bool.booleanValue();
        }
        parcel.writeInt(i3);
        parcel.writeString(this.recommendTag);
    }

    public GuideBarGuildInfo(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Boolean bool, @Nullable String str4) {
        this.guildId = str;
        this.guildName = str2;
        this.guildIcon = str3;
        this.isMember = bool;
        this.recommendTag = str4;
    }

    public /* synthetic */ GuideBarGuildInfo(String str, String str2, String str3, Boolean bool, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? null : str3, (i3 & 8) != 0 ? null : bool, (i3 & 16) != 0 ? null : str4);
    }
}
