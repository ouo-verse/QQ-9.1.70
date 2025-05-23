package com.tencent.mobileqq.wink.picker;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.wink.picker.utils.PhotoListLogicPreDealDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001b\u0012\b\b\u0002\u0010 \u001a\u00020\u0004\u0012\b\b\u0002\u0010$\u001a\u00020\u0007\u0012\b\b\u0002\u0010)\u001a\u00020%\u00a2\u0006\u0004\b*\u0010+J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001a\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u0010\u0010\u0017R\u0017\u0010\u001f\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u0019\u0010\u001eR\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\n\u0010\u0017R\u0017\u0010$\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#R\u0017\u0010)\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b\u001c\u0010(\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", "a", "Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", "c", "()Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;", "mediaPickerScene", "Lcom/tencent/mobileqq/wink/picker/MediaProcessStateType;", "b", "Lcom/tencent/mobileqq/wink/picker/MediaProcessStateType;", "f", "()Lcom/tencent/mobileqq/wink/picker/MediaProcessStateType;", "type", "I", "getToCompressedMediaNum", "()I", "toCompressedMediaNum", "d", "itemIndex", "", "e", UserInfo.SEX_FEMALE, "()F", "progress", "errorMsgResId", "g", "Z", "()Z", "useVideoTemplate", "Lcom/tencent/mobileqq/wink/picker/utils/PhotoListLogicPreDealDialog$PreDealStep;", tl.h.F, "Lcom/tencent/mobileqq/wink/picker/utils/PhotoListLogicPreDealDialog$PreDealStep;", "()Lcom/tencent/mobileqq/wink/picker/utils/PhotoListLogicPreDealDialog$PreDealStep;", "step", "<init>", "(Lcom/tencent/mobileqq/wink/picker/MediaPickerScene;Lcom/tencent/mobileqq/wink/picker/MediaProcessStateType;IIFIZLcom/tencent/mobileqq/wink/picker/utils/PhotoListLogicPreDealDialog$PreDealStep;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.picker.c, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class MediaProcessState {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MediaPickerScene mediaPickerScene;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MediaProcessStateType type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int toCompressedMediaNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int itemIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final float progress;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int errorMsgResId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean useVideoTemplate;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final PhotoListLogicPreDealDialog.PreDealStep step;

    public MediaProcessState(@NotNull MediaPickerScene mediaPickerScene, @NotNull MediaProcessStateType type, int i3, int i16, float f16, int i17, boolean z16, @NotNull PhotoListLogicPreDealDialog.PreDealStep step) {
        Intrinsics.checkNotNullParameter(mediaPickerScene, "mediaPickerScene");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(step, "step");
        this.mediaPickerScene = mediaPickerScene;
        this.type = type;
        this.toCompressedMediaNum = i3;
        this.itemIndex = i16;
        this.progress = f16;
        this.errorMsgResId = i17;
        this.useVideoTemplate = z16;
        this.step = step;
    }

    /* renamed from: a, reason: from getter */
    public final int getErrorMsgResId() {
        return this.errorMsgResId;
    }

    /* renamed from: b, reason: from getter */
    public final int getItemIndex() {
        return this.itemIndex;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final MediaPickerScene getMediaPickerScene() {
        return this.mediaPickerScene;
    }

    /* renamed from: d, reason: from getter */
    public final float getProgress() {
        return this.progress;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final PhotoListLogicPreDealDialog.PreDealStep getStep() {
        return this.step;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaProcessState)) {
            return false;
        }
        MediaProcessState mediaProcessState = (MediaProcessState) other;
        if (this.mediaPickerScene == mediaProcessState.mediaPickerScene && this.type == mediaProcessState.type && this.toCompressedMediaNum == mediaProcessState.toCompressedMediaNum && this.itemIndex == mediaProcessState.itemIndex && Float.compare(this.progress, mediaProcessState.progress) == 0 && this.errorMsgResId == mediaProcessState.errorMsgResId && this.useVideoTemplate == mediaProcessState.useVideoTemplate && this.step == mediaProcessState.step) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final MediaProcessStateType getType() {
        return this.type;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getUseVideoTemplate() {
        return this.useVideoTemplate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((this.mediaPickerScene.hashCode() * 31) + this.type.hashCode()) * 31) + this.toCompressedMediaNum) * 31) + this.itemIndex) * 31) + Float.floatToIntBits(this.progress)) * 31) + this.errorMsgResId) * 31;
        boolean z16 = this.useVideoTemplate;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.step.hashCode();
    }

    @NotNull
    public String toString() {
        return "MediaProcessState(mediaPickerScene=" + this.mediaPickerScene + ", type=" + this.type + ", toCompressedMediaNum=" + this.toCompressedMediaNum + ", itemIndex=" + this.itemIndex + ", progress=" + this.progress + ", errorMsgResId=" + this.errorMsgResId + ", useVideoTemplate=" + this.useVideoTemplate + ", step=" + this.step + ")";
    }

    public /* synthetic */ MediaProcessState(MediaPickerScene mediaPickerScene, MediaProcessStateType mediaProcessStateType, int i3, int i16, float f16, int i17, boolean z16, PhotoListLogicPreDealDialog.PreDealStep preDealStep, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(mediaPickerScene, mediaProcessStateType, (i18 & 4) != 0 ? 0 : i3, (i18 & 8) != 0 ? 0 : i16, (i18 & 16) != 0 ? 0.0f : f16, (i18 & 32) != 0 ? 0 : i17, (i18 & 64) != 0 ? false : z16, (i18 & 128) != 0 ? PhotoListLogicPreDealDialog.PreDealStep.STEP_EXTRACT : preDealStep);
    }
}
