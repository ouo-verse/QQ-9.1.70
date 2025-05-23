package com.tencent.state.square.bubblesetting;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0002\u0010\rJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\fH\u00c6\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00c6\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010&\u001a\u00020\u0003H\u00d6\u0001J\t\u0010'\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000f\u00a8\u0006("}, d2 = {"Lcom/tencent/state/square/bubblesetting/SquareBubbleInfo;", "", "id", "", "name", "", "skinLink", "speakingBubbleUrl", "color", "Lcom/tencent/state/square/bubblesetting/SquareBubbleColor;", "arrow", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/state/square/bubblesetting/SquareBubbleColor;Ljava/lang/String;Landroid/graphics/Bitmap;)V", "getArrow", "()Ljava/lang/String;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getColor", "()Lcom/tencent/state/square/bubblesetting/SquareBubbleColor;", "getId", "()I", "getName", "getSkinLink", "getSpeakingBubbleUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class SquareBubbleInfo {
    private final String arrow;
    private Bitmap bitmap;
    private final SquareBubbleColor color;
    private final int id;
    private final String name;
    private final String skinLink;
    private final String speakingBubbleUrl;

    public SquareBubbleInfo(int i3, String name, String str, String str2, SquareBubbleColor squareBubbleColor, String str3, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = i3;
        this.name = name;
        this.skinLink = str;
        this.speakingBubbleUrl = str2;
        this.color = squareBubbleColor;
        this.arrow = str3;
        this.bitmap = bitmap;
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSkinLink() {
        return this.skinLink;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSpeakingBubbleUrl() {
        return this.speakingBubbleUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final SquareBubbleColor getColor() {
        return this.color;
    }

    /* renamed from: component6, reason: from getter */
    public final String getArrow() {
        return this.arrow;
    }

    /* renamed from: component7, reason: from getter */
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final SquareBubbleInfo copy(int id5, String name, String skinLink, String speakingBubbleUrl, SquareBubbleColor color, String arrow, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new SquareBubbleInfo(id5, name, skinLink, speakingBubbleUrl, color, arrow, bitmap);
    }

    public final String getArrow() {
        return this.arrow;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final SquareBubbleColor getColor() {
        return this.color;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSkinLink() {
        return this.skinLink;
    }

    public final String getSpeakingBubbleUrl() {
        return this.speakingBubbleUrl;
    }

    public int hashCode() {
        int i3 = this.id * 31;
        String str = this.name;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.skinLink;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.speakingBubbleUrl;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        SquareBubbleColor squareBubbleColor = this.color;
        int hashCode4 = (hashCode3 + (squareBubbleColor != null ? squareBubbleColor.hashCode() : 0)) * 31;
        String str4 = this.arrow;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Bitmap bitmap = this.bitmap;
        return hashCode5 + (bitmap != null ? bitmap.hashCode() : 0);
    }

    public final void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String toString() {
        return "SquareBubbleInfo(id=" + this.id + ", name=" + this.name + ", skinLink=" + this.skinLink + ", speakingBubbleUrl=" + this.speakingBubbleUrl + ", color=" + this.color + ", arrow=" + this.arrow + ", bitmap=" + this.bitmap + ")";
    }

    public /* synthetic */ SquareBubbleInfo(int i3, String str, String str2, String str3, SquareBubbleColor squareBubbleColor, String str4, Bitmap bitmap, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? null : str2, (i16 & 8) != 0 ? null : str3, (i16 & 16) != 0 ? null : squareBubbleColor, (i16 & 32) != 0 ? null : str4, (i16 & 64) == 0 ? bitmap : null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SquareBubbleInfo)) {
            return false;
        }
        SquareBubbleInfo squareBubbleInfo = (SquareBubbleInfo) other;
        return this.id == squareBubbleInfo.id && Intrinsics.areEqual(this.name, squareBubbleInfo.name) && Intrinsics.areEqual(this.skinLink, squareBubbleInfo.skinLink) && Intrinsics.areEqual(this.speakingBubbleUrl, squareBubbleInfo.speakingBubbleUrl) && Intrinsics.areEqual(this.color, squareBubbleInfo.color) && Intrinsics.areEqual(this.arrow, squareBubbleInfo.arrow) && Intrinsics.areEqual(this.bitmap, squareBubbleInfo.bitmap);
    }

    public static /* synthetic */ SquareBubbleInfo copy$default(SquareBubbleInfo squareBubbleInfo, int i3, String str, String str2, String str3, SquareBubbleColor squareBubbleColor, String str4, Bitmap bitmap, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = squareBubbleInfo.id;
        }
        if ((i16 & 2) != 0) {
            str = squareBubbleInfo.name;
        }
        String str5 = str;
        if ((i16 & 4) != 0) {
            str2 = squareBubbleInfo.skinLink;
        }
        String str6 = str2;
        if ((i16 & 8) != 0) {
            str3 = squareBubbleInfo.speakingBubbleUrl;
        }
        String str7 = str3;
        if ((i16 & 16) != 0) {
            squareBubbleColor = squareBubbleInfo.color;
        }
        SquareBubbleColor squareBubbleColor2 = squareBubbleColor;
        if ((i16 & 32) != 0) {
            str4 = squareBubbleInfo.arrow;
        }
        String str8 = str4;
        if ((i16 & 64) != 0) {
            bitmap = squareBubbleInfo.bitmap;
        }
        return squareBubbleInfo.copy(i3, str5, str6, str7, squareBubbleColor2, str8, bitmap);
    }
}
