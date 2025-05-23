package com.tencent.troopguild.dialog.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.image.HippyTKDGifImageViewController;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b \u0018\u0000 (2\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b%\u0010&B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b%\u0010'J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0017\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR$\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR$\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\"\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\u0011\u0010\"\"\u0004\b \u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/troopguild/dialog/data/TroopUpdateGuideDialogUIData;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", "title", "e", "a", "f", "buttonText", "getFootText", "g", "footText", h.F, "c", "k", "imageUrl", "i", "b", "j", HippyTKDGifImageViewController.PROPS_GIFURL, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "()I", "(I)V", "isUsed", "<init>", "()V", "(Landroid/os/Parcel;)V", "CREATOR", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class TroopUpdateGuideDialogUIData implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String title;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String buttonText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String footText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String imageUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String gifUrl;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int isUsed;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/troopguild/dialog/data/TroopUpdateGuideDialogUIData$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/troopguild/dialog/data/TroopUpdateGuideDialogUIData;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/troopguild/dialog/data/TroopUpdateGuideDialogUIData;", "<init>", "()V", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.troopguild.dialog.data.TroopUpdateGuideDialogUIData$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion implements Parcelable.Creator<TroopUpdateGuideDialogUIData> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TroopUpdateGuideDialogUIData createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new TroopUpdateGuideDialogUIData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TroopUpdateGuideDialogUIData[] newArray(int size) {
            return new TroopUpdateGuideDialogUIData[size];
        }

        Companion() {
        }
    }

    public TroopUpdateGuideDialogUIData() {
        this.title = "QQ\u7fa4\u9650\u91cf\u5185\u6d4b\u529f\u80fd";
        this.buttonText = "\u5f00\u542f\u5168\u65b0\u4f53\u9a8c";
        this.footText = "\u5173\u95ed\u540e\u53ef\u5728\u3010\u7fa4\u8bbe\u7f6e-\u7fa4\u5347\u7ea7\u3011\u67e5\u770b";
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getButtonText() {
        return this.buttonText;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getGifUrl() {
        return this.gifUrl;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final int getIsUsed() {
        return this.isUsed;
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.buttonText = str;
    }

    public final void g(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.footText = str;
    }

    public final void j(@Nullable String str) {
        this.gifUrl = str;
    }

    public final void k(@Nullable String str) {
        this.imageUrl = str;
    }

    public final void l(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final void m(int i3) {
        this.isUsed = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.buttonText);
        parcel.writeString(this.footText);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.gifUrl);
        parcel.writeInt(this.isUsed);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TroopUpdateGuideDialogUIData(@NotNull Parcel parcel) {
        this();
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String readString = parcel.readString();
        this.title = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.buttonText = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.footText = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        this.imageUrl = readString4 == null ? "" : readString4;
        String readString5 = parcel.readString();
        this.gifUrl = readString5 != null ? readString5 : "";
        this.isUsed = parcel.readInt();
    }
}
