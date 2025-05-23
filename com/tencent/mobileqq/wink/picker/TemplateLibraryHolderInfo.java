package com.tencent.mobileqq.wink.picker;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J+\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0007H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/TemplateLibraryHolderInfo;", "Ljava/io/Serializable;", "mediaInfo", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "holderTimeSlot", "", "holderHintText", "", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;FLjava/lang/String;)V", "getHolderHintText", "()Ljava/lang/String;", "getHolderTimeSlot", "()F", "getMediaInfo", "()Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "setMediaInfo", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class TemplateLibraryHolderInfo implements Serializable {

    @Nullable
    private final String holderHintText;
    private final float holderTimeSlot;

    @Nullable
    private LocalMediaInfo mediaInfo;

    public TemplateLibraryHolderInfo(@Nullable LocalMediaInfo localMediaInfo, float f16, @Nullable String str) {
        this.mediaInfo = localMediaInfo;
        this.holderTimeSlot = f16;
        this.holderHintText = str;
    }

    public static /* synthetic */ TemplateLibraryHolderInfo copy$default(TemplateLibraryHolderInfo templateLibraryHolderInfo, LocalMediaInfo localMediaInfo, float f16, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            localMediaInfo = templateLibraryHolderInfo.mediaInfo;
        }
        if ((i3 & 2) != 0) {
            f16 = templateLibraryHolderInfo.holderTimeSlot;
        }
        if ((i3 & 4) != 0) {
            str = templateLibraryHolderInfo.holderHintText;
        }
        return templateLibraryHolderInfo.copy(localMediaInfo, f16, str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final LocalMediaInfo getMediaInfo() {
        return this.mediaInfo;
    }

    /* renamed from: component2, reason: from getter */
    public final float getHolderTimeSlot() {
        return this.holderTimeSlot;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getHolderHintText() {
        return this.holderHintText;
    }

    @NotNull
    public final TemplateLibraryHolderInfo copy(@Nullable LocalMediaInfo mediaInfo, float holderTimeSlot, @Nullable String holderHintText) {
        return new TemplateLibraryHolderInfo(mediaInfo, holderTimeSlot, holderHintText);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TemplateLibraryHolderInfo)) {
            return false;
        }
        TemplateLibraryHolderInfo templateLibraryHolderInfo = (TemplateLibraryHolderInfo) other;
        if (Intrinsics.areEqual(this.mediaInfo, templateLibraryHolderInfo.mediaInfo) && Float.compare(this.holderTimeSlot, templateLibraryHolderInfo.holderTimeSlot) == 0 && Intrinsics.areEqual(this.holderHintText, templateLibraryHolderInfo.holderHintText)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String getHolderHintText() {
        return this.holderHintText;
    }

    public final float getHolderTimeSlot() {
        return this.holderTimeSlot;
    }

    @Nullable
    public final LocalMediaInfo getMediaInfo() {
        return this.mediaInfo;
    }

    public int hashCode() {
        int hashCode;
        LocalMediaInfo localMediaInfo = this.mediaInfo;
        int i3 = 0;
        if (localMediaInfo == null) {
            hashCode = 0;
        } else {
            hashCode = localMediaInfo.hashCode();
        }
        int floatToIntBits = ((hashCode * 31) + Float.floatToIntBits(this.holderTimeSlot)) * 31;
        String str = this.holderHintText;
        if (str != null) {
            i3 = str.hashCode();
        }
        return floatToIntBits + i3;
    }

    public final void setMediaInfo(@Nullable LocalMediaInfo localMediaInfo) {
        this.mediaInfo = localMediaInfo;
    }

    @NotNull
    public String toString() {
        return "TemplateLibraryHolderInfo(mediaInfo=" + this.mediaInfo + ", holderTimeSlot=" + this.holderTimeSlot + ", holderHintText=" + this.holderHintText + ")";
    }
}
