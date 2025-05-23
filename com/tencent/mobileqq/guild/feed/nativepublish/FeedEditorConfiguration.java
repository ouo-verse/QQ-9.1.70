package com.tencent.mobileqq.guild.feed.nativepublish;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\b\u0012\b\b\u0002\u0010\u001a\u001a\u00020\b\u0012\b\b\u0002\u0010\u001d\u001a\u00020\b\u0012\b\b\u0002\u0010 \u001a\u00020\b\u0012\b\b\u0002\u0010#\u001a\u00020\b\u0012\b\b\u0002\u0010%\u001a\u00020\b\u00a2\u0006\u0004\b&\u0010'J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0004H\u00d6\u0001R\u0017\u0010\u0014\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u0017\u0010\u001a\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013R\u0017\u0010\u001d\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013R\u0017\u0010 \u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013R\u0017\u0010#\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0011\u001a\u0004\b\"\u0010\u0013R\u0017\u0010%\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/FeedEditorConfiguration;", "Landroid/os/Parcelable;", "", "toString", "", "hashCode", "", "other", "", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Z", "c", "()Z", "isSupportHashtag", "e", "isSupportAt", "f", "isSupportPlus", h.F, "isSupportTitleTip", "i", "b", "isDisableDraft", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "isDisableClickTransparentBackground", BdhLogUtil.LogTag.Tag_Conn, "g", "isSupportTitleBar", "D", "isSupportLongFeedEditor", "<init>", "(ZZZZZZZZ)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final /* data */ class FeedEditorConfiguration implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<FeedEditorConfiguration> CREATOR = new a();

    /* renamed from: C, reason: from kotlin metadata and from toString */
    private final boolean isSupportTitleBar;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    private final boolean isSupportLongFeedEditor;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSupportHashtag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSupportAt;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSupportPlus;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isSupportTitleTip;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isDisableDraft;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isDisableClickTransparentBackground;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a implements Parcelable.Creator<FeedEditorConfiguration> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final FeedEditorConfiguration createFromParcel(@NotNull Parcel parcel) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            boolean z27;
            boolean z28;
            boolean z29;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            if (parcel.readInt() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (parcel.readInt() != 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (parcel.readInt() != 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (parcel.readInt() != 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (parcel.readInt() != 0) {
                z26 = true;
            } else {
                z26 = false;
            }
            if (parcel.readInt() != 0) {
                z27 = true;
            } else {
                z27 = false;
            }
            if (parcel.readInt() != 0) {
                z28 = true;
            } else {
                z28 = false;
            }
            if (parcel.readInt() != 0) {
                z29 = true;
            } else {
                z29 = false;
            }
            return new FeedEditorConfiguration(z16, z17, z18, z19, z26, z27, z28, z29);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final FeedEditorConfiguration[] newArray(int i3) {
            return new FeedEditorConfiguration[i3];
        }
    }

    public FeedEditorConfiguration() {
        this(false, false, false, false, false, false, false, false, 255, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getIsDisableClickTransparentBackground() {
        return this.isDisableClickTransparentBackground;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getIsDisableDraft() {
        return this.isDisableDraft;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsSupportHashtag() {
        return this.isSupportHashtag;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsSupportLongFeedEditor() {
        return this.isSupportLongFeedEditor;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedEditorConfiguration)) {
            return false;
        }
        FeedEditorConfiguration feedEditorConfiguration = (FeedEditorConfiguration) other;
        if (this.isSupportHashtag == feedEditorConfiguration.isSupportHashtag && this.isSupportAt == feedEditorConfiguration.isSupportAt && this.isSupportPlus == feedEditorConfiguration.isSupportPlus && this.isSupportTitleTip == feedEditorConfiguration.isSupportTitleTip && this.isDisableDraft == feedEditorConfiguration.isDisableDraft && this.isDisableClickTransparentBackground == feedEditorConfiguration.isDisableClickTransparentBackground && this.isSupportTitleBar == feedEditorConfiguration.isSupportTitleBar && this.isSupportLongFeedEditor == feedEditorConfiguration.isSupportLongFeedEditor) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsSupportPlus() {
        return this.isSupportPlus;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsSupportTitleBar() {
        return this.isSupportTitleBar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.isSupportHashtag;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.isSupportAt;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        ?? r27 = this.isSupportPlus;
        int i19 = r27;
        if (r27 != 0) {
            i19 = 1;
        }
        int i26 = (i18 + i19) * 31;
        ?? r28 = this.isSupportTitleTip;
        int i27 = r28;
        if (r28 != 0) {
            i27 = 1;
        }
        int i28 = (i26 + i27) * 31;
        ?? r29 = this.isDisableDraft;
        int i29 = r29;
        if (r29 != 0) {
            i29 = 1;
        }
        int i36 = (i28 + i29) * 31;
        ?? r210 = this.isDisableClickTransparentBackground;
        int i37 = r210;
        if (r210 != 0) {
            i37 = 1;
        }
        int i38 = (i36 + i37) * 31;
        ?? r211 = this.isSupportTitleBar;
        int i39 = r211;
        if (r211 != 0) {
            i39 = 1;
        }
        int i46 = (i38 + i39) * 31;
        boolean z17 = this.isSupportLongFeedEditor;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i46 + i3;
    }

    @NotNull
    public String toString() {
        return "FeedEditorConfiguration(isSupportHashtag=" + this.isSupportHashtag + ", isSupportAt=" + this.isSupportAt + ", isSupportPlus=" + this.isSupportPlus + ", isSupportTitleTip=" + this.isSupportTitleTip + ", isDisableDraft=" + this.isDisableDraft + ", isDisableClickTransparentBackground=" + this.isDisableClickTransparentBackground + ", isSupportTitleBar=" + this.isSupportTitleBar + ", isSupportLongFeedEditor=" + this.isSupportLongFeedEditor + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.isSupportHashtag ? 1 : 0);
        parcel.writeInt(this.isSupportAt ? 1 : 0);
        parcel.writeInt(this.isSupportPlus ? 1 : 0);
        parcel.writeInt(this.isSupportTitleTip ? 1 : 0);
        parcel.writeInt(this.isDisableDraft ? 1 : 0);
        parcel.writeInt(this.isDisableClickTransparentBackground ? 1 : 0);
        parcel.writeInt(this.isSupportTitleBar ? 1 : 0);
        parcel.writeInt(this.isSupportLongFeedEditor ? 1 : 0);
    }

    public FeedEditorConfiguration(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28, boolean z29) {
        this.isSupportHashtag = z16;
        this.isSupportAt = z17;
        this.isSupportPlus = z18;
        this.isSupportTitleTip = z19;
        this.isDisableDraft = z26;
        this.isDisableClickTransparentBackground = z27;
        this.isSupportTitleBar = z28;
        this.isSupportLongFeedEditor = z29;
    }

    public /* synthetic */ FeedEditorConfiguration(boolean z16, boolean z17, boolean z18, boolean z19, boolean z26, boolean z27, boolean z28, boolean z29, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? true : z17, (i3 & 4) != 0 ? true : z18, (i3 & 8) != 0 ? true : z19, (i3 & 16) != 0 ? false : z26, (i3 & 32) != 0 ? false : z27, (i3 & 64) == 0 ? z28 : false, (i3 & 128) == 0 ? z29 : true);
    }
}
