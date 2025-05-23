package d01;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\tBW\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011R\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\t\u0010\u001e\u00a8\u0006#"}, d2 = {"Ld01/x;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "g", "()I", "type", "b", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "layerName", "c", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "layerIndex", "f", "text", "imageFilePath", "imageFileAsset", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", "imageBitmap", "<init>", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;)V", tl.h.F, "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: d01.x, reason: from toString */
/* loaded from: classes7.dex */
public final /* data */ class PAGReplaceItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String layerName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Integer layerIndex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String text;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String imageFilePath;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String imageFileAsset;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Bitmap imageBitmap;

    public PAGReplaceItem(int i3, @Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Bitmap bitmap) {
        this.type = i3;
        this.layerName = str;
        this.layerIndex = num;
        this.text = str2;
        this.imageFilePath = str3;
        this.imageFileAsset = str4;
        this.imageBitmap = bitmap;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Bitmap getImageBitmap() {
        return this.imageBitmap;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getImageFileAsset() {
        return this.imageFileAsset;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getImageFilePath() {
        return this.imageFilePath;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final Integer getLayerIndex() {
        return this.layerIndex;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final String getLayerName() {
        return this.layerName;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof PAGReplaceItem) {
                PAGReplaceItem pAGReplaceItem = (PAGReplaceItem) other;
                if (this.type != pAGReplaceItem.type || !Intrinsics.areEqual(this.layerName, pAGReplaceItem.layerName) || !Intrinsics.areEqual(this.layerIndex, pAGReplaceItem.layerIndex) || !Intrinsics.areEqual(this.text, pAGReplaceItem.text) || !Intrinsics.areEqual(this.imageFilePath, pAGReplaceItem.imageFilePath) || !Intrinsics.areEqual(this.imageFileAsset, pAGReplaceItem.imageFileAsset) || !Intrinsics.areEqual(this.imageBitmap, pAGReplaceItem.imageBitmap)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: g, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26 = this.type * 31;
        String str = this.layerName;
        int i27 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i28 = (i26 + i3) * 31;
        Integer num = this.layerIndex;
        if (num != null) {
            i16 = num.hashCode();
        } else {
            i16 = 0;
        }
        int i29 = (i28 + i16) * 31;
        String str2 = this.text;
        if (str2 != null) {
            i17 = str2.hashCode();
        } else {
            i17 = 0;
        }
        int i36 = (i29 + i17) * 31;
        String str3 = this.imageFilePath;
        if (str3 != null) {
            i18 = str3.hashCode();
        } else {
            i18 = 0;
        }
        int i37 = (i36 + i18) * 31;
        String str4 = this.imageFileAsset;
        if (str4 != null) {
            i19 = str4.hashCode();
        } else {
            i19 = 0;
        }
        int i38 = (i37 + i19) * 31;
        Bitmap bitmap = this.imageBitmap;
        if (bitmap != null) {
            i27 = bitmap.hashCode();
        }
        return i38 + i27;
    }

    @NotNull
    public String toString() {
        return "PAGReplaceItem(type=" + this.type + ", layerName=" + this.layerName + ", layerIndex=" + this.layerIndex + ", text=" + this.text + ", imageFilePath=" + this.imageFilePath + ", imageFileAsset=" + this.imageFileAsset + ", imageBitmap=" + this.imageBitmap + ")";
    }

    public /* synthetic */ PAGReplaceItem(int i3, String str, Integer num, String str2, String str3, String str4, Bitmap bitmap, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? null : str, (i16 & 4) != 0 ? null : num, (i16 & 8) != 0 ? null : str2, (i16 & 16) != 0 ? null : str3, (i16 & 32) != 0 ? null : str4, (i16 & 64) == 0 ? bitmap : null);
    }
}
