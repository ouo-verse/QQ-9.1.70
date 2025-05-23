package com.tencent.mobileqq.wink.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u0000 +2\u00020\u0001:\u0001#B?\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\t\u0012\u0006\u0010\u001e\u001a\u00020\u0019\u0012\u0006\u0010!\u001a\u00020\t\u0012\u0006\u0010$\u001a\u00020\t\u0012\u0006\u0010'\u001a\u00020\t\u00a2\u0006\u0004\b(\u0010)B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b(\u0010*J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010!\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0011\u001a\u0004\b \u0010\u0013R\u0017\u0010$\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0011\u001a\u0004\b#\u0010\u0013R\u0017\u0010'\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u0011\u001a\u0004\b&\u0010\u0013\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/wink/model/QQWinkPublishTagGuide;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getTagID", "()Ljava/lang/String;", "tagID", "e", "f", "tagName", "tagDesc", "Lcom/tencent/mobileqq/wink/model/TagType;", h.F, "Lcom/tencent/mobileqq/wink/model/TagType;", "g", "()Lcom/tencent/mobileqq/wink/model/TagType;", "tagType", "i", "c", "icon", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "buttonText", BdhLogUtil.LogTag.Tag_Conn, "b", "guideTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/wink/model/TagType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Landroid/os/Parcel;)V", "CREATOR", "qq-wink-temp-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class QQWinkPublishTagGuide implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata and from toString */
    @NotNull
    private final String guideTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tagID;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tagName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tagDesc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final TagType tagType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String icon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String buttonText;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/model/QQWinkPublishTagGuide$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/wink/model/QQWinkPublishTagGuide;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/wink/model/QQWinkPublishTagGuide;", "<init>", "()V", "qq-wink-temp-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.model.QQWinkPublishTagGuide$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion implements Parcelable.Creator<QQWinkPublishTagGuide> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QQWinkPublishTagGuide createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new QQWinkPublishTagGuide(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QQWinkPublishTagGuide[] newArray(int size) {
            return new QQWinkPublishTagGuide[size];
        }

        Companion() {
        }
    }

    public QQWinkPublishTagGuide(@NotNull String tagID, @NotNull String tagName, @NotNull String tagDesc, @NotNull TagType tagType, @NotNull String icon, @NotNull String buttonText, @NotNull String guideTitle) {
        Intrinsics.checkNotNullParameter(tagID, "tagID");
        Intrinsics.checkNotNullParameter(tagName, "tagName");
        Intrinsics.checkNotNullParameter(tagDesc, "tagDesc");
        Intrinsics.checkNotNullParameter(tagType, "tagType");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(buttonText, "buttonText");
        Intrinsics.checkNotNullParameter(guideTitle, "guideTitle");
        this.tagID = tagID;
        this.tagName = tagName;
        this.tagDesc = tagDesc;
        this.tagType = tagType;
        this.icon = icon;
        this.buttonText = buttonText;
        this.guideTitle = guideTitle;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getButtonText() {
        return this.buttonText;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGuideTitle() {
        return this.guideTitle;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getTagDesc() {
        return this.tagDesc;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQWinkPublishTagGuide)) {
            return false;
        }
        QQWinkPublishTagGuide qQWinkPublishTagGuide = (QQWinkPublishTagGuide) other;
        if (Intrinsics.areEqual(this.tagID, qQWinkPublishTagGuide.tagID) && Intrinsics.areEqual(this.tagName, qQWinkPublishTagGuide.tagName) && Intrinsics.areEqual(this.tagDesc, qQWinkPublishTagGuide.tagDesc) && this.tagType == qQWinkPublishTagGuide.tagType && Intrinsics.areEqual(this.icon, qQWinkPublishTagGuide.icon) && Intrinsics.areEqual(this.buttonText, qQWinkPublishTagGuide.buttonText) && Intrinsics.areEqual(this.guideTitle, qQWinkPublishTagGuide.guideTitle)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getTagName() {
        return this.tagName;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final TagType getTagType() {
        return this.tagType;
    }

    public int hashCode() {
        return (((((((((((this.tagID.hashCode() * 31) + this.tagName.hashCode()) * 31) + this.tagDesc.hashCode()) * 31) + this.tagType.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.buttonText.hashCode()) * 31) + this.guideTitle.hashCode();
    }

    @NotNull
    public String toString() {
        return "QQWinkPublishTagGuide(tagID=" + this.tagID + ", tagName=" + this.tagName + ", tagDesc=" + this.tagDesc + ", tagType=" + this.tagType + ", icon=" + this.icon + ", buttonText=" + this.buttonText + ", guideTitle=" + this.guideTitle + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.tagID);
        parcel.writeString(this.tagName);
        parcel.writeString(this.tagDesc);
        this.tagType.writeToParcel(parcel, flags);
        parcel.writeString(this.icon);
        parcel.writeString(this.buttonText);
        parcel.writeString(this.guideTitle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QQWinkPublishTagGuide(@NotNull Parcel parcel) {
        this(r3, r4, r5, r6, r7, r8, r11 == null ? "" : r11);
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        String str = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        String str2 = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        String str3 = readString3 == null ? "" : readString3;
        TagType createFromParcel = TagType.CREATOR.createFromParcel(parcel);
        Intrinsics.checkNotNullExpressionValue(createFromParcel, "CREATOR.createFromParcel(parcel)");
        TagType tagType = createFromParcel;
        String readString4 = parcel.readString();
        String str4 = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        String str5 = readString5 == null ? "" : readString5;
        String readString6 = parcel.readString();
    }
}
