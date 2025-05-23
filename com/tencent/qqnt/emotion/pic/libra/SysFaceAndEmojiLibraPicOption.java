package com.tencent.qqnt.emotion.pic.libra;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u000f\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/emotion/pic/libra/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "emoType", QQSysAndEmojiResInfo.EMO_ID, "c", "d", "picType", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "loadingDrawable", "<init>", "(IIILandroid/graphics/drawable/Drawable;)V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.qqnt.emotion.pic.libra.j, reason: from toString */
/* loaded from: classes24.dex */
public final /* data */ class SysFaceAndEmojiLibraPicOption {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int emoType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int emoId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int picType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Drawable loadingDrawable;

    public SysFaceAndEmojiLibraPicOption(int i3, int i16, int i17, @NotNull Drawable loadingDrawable) {
        Intrinsics.checkNotNullParameter(loadingDrawable, "loadingDrawable");
        this.emoType = i3;
        this.emoId = i16;
        this.picType = i17;
        this.loadingDrawable = loadingDrawable;
    }

    /* renamed from: a, reason: from getter */
    public final int getEmoId() {
        return this.emoId;
    }

    /* renamed from: b, reason: from getter */
    public final int getEmoType() {
        return this.emoType;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final Drawable getLoadingDrawable() {
        return this.loadingDrawable;
    }

    /* renamed from: d, reason: from getter */
    public final int getPicType() {
        return this.picType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SysFaceAndEmojiLibraPicOption)) {
            return false;
        }
        SysFaceAndEmojiLibraPicOption sysFaceAndEmojiLibraPicOption = (SysFaceAndEmojiLibraPicOption) other;
        if (this.emoType == sysFaceAndEmojiLibraPicOption.emoType && this.emoId == sysFaceAndEmojiLibraPicOption.emoId && this.picType == sysFaceAndEmojiLibraPicOption.picType && Intrinsics.areEqual(this.loadingDrawable, sysFaceAndEmojiLibraPicOption.loadingDrawable)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.emoType * 31) + this.emoId) * 31) + this.picType) * 31) + this.loadingDrawable.hashCode();
    }

    @NotNull
    public String toString() {
        return "SysFaceAndEmojiLibraPicOption(emoType=" + this.emoType + ", emoId=" + this.emoId + ", picType=" + this.picType + ", loadingDrawable=" + this.loadingDrawable + ")";
    }
}
