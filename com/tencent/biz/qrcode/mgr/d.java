package com.tencent.biz.qrcode.mgr;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b \u0010!J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0006\u0010\t\u001a\u00020\u0003R\"\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b\u0010\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/biz/qrcode/mgr/d;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "I", "e", "()I", "setStyle", "(I)V", "style", "b", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setShortChain", "(Ljava/lang/String;)V", "shortChain", "c", "setFilePath", "filePath", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", MimeHelper.IMAGE_SUBTYPE_BITMAP, "<init>", "(ILjava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final /* data */ class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int style;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String shortChain;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String filePath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap bitmap;

    public d(int i3, @NotNull String shortChain, @NotNull String filePath, @Nullable Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(shortChain, "shortChain");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.style = i3;
        this.shortChain = shortChain;
        this.filePath = filePath;
        this.bitmap = bitmap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        if (r4.bitmap != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        if (r4.shortChain.length() > 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0053, code lost:
    
        if (r4.bitmap == null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        int i3 = this.style;
        boolean z26 = true;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    return false;
                }
                if (this.shortChain.length() > 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    if (this.filePath.length() > 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (z19) {
                    }
                }
                z26 = false;
            }
        } else {
            if (this.shortChain.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (this.filePath.length() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                }
            }
            z26 = false;
        }
        return z26;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getShortChain() {
        return this.shortChain;
    }

    /* renamed from: e, reason: from getter */
    public final int getStyle() {
        return this.style;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        int i3;
        int i16;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(d.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.biz.qrcode.mgr.QRCodeData");
        d dVar = (d) other;
        if (this.style == dVar.style && Intrinsics.areEqual(this.shortChain, dVar.shortChain) && Intrinsics.areEqual(this.filePath, dVar.filePath)) {
            Bitmap bitmap = this.bitmap;
            if (bitmap != null) {
                i3 = bitmap.hashCode();
            } else {
                i3 = 0;
            }
            Bitmap bitmap2 = dVar.bitmap;
            if (bitmap2 != null) {
                i16 = bitmap2.hashCode();
            } else {
                i16 = 0;
            }
            if (i3 == i16) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int hashCode = ((((this.style * 31) + this.shortChain.hashCode()) * 31) + this.filePath.hashCode()) * 31;
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            i3 = bitmap.hashCode();
        } else {
            i3 = 0;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        int i3;
        int i16 = this.style;
        String str = this.shortChain;
        String str2 = this.filePath;
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            i3 = bitmap.hashCode();
        } else {
            i3 = 0;
        }
        return "{style = " + i16 + ", shortChain = " + str + ", filePath = " + str2 + ", bitmap = " + i3 + "}";
    }

    public /* synthetic */ d(int i3, String str, String str2, Bitmap bitmap, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? "" : str, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? null : bitmap);
    }
}
