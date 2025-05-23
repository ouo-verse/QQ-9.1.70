package com.qzone.publish.business.model.intimate;

import com.qzone.publish.business.model.intimate.IntimateUploadImageResult;
import com.qzone.publish.business.publishqueue.intimate.b;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StImage;
import qzone.QZoneBaseMeta$StMedia;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001!B\u001f\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bH\u00c6\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bH\u00c6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u000fH\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003R$\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/qzone/publish/business/model/intimate/IntimateUploadMediaResult;", "Ljava/io/Serializable;", "Lqzone/QZoneBaseMeta$StMedia;", "toStMedia", "", "isImageResult", "Lcom/qzone/publish/business/model/intimate/IntimateUploadImageResult;", "component1", "Lcom/qzone/publish/business/model/intimate/IntimateUploadVideoResult;", "component2", "imageResult", "videoResult", "copy", "", "toString", "", "hashCode", "", "other", "equals", "Lcom/qzone/publish/business/model/intimate/IntimateUploadImageResult;", "getImageResult", "()Lcom/qzone/publish/business/model/intimate/IntimateUploadImageResult;", "setImageResult", "(Lcom/qzone/publish/business/model/intimate/IntimateUploadImageResult;)V", "Lcom/qzone/publish/business/model/intimate/IntimateUploadVideoResult;", "getVideoResult", "()Lcom/qzone/publish/business/model/intimate/IntimateUploadVideoResult;", "setVideoResult", "(Lcom/qzone/publish/business/model/intimate/IntimateUploadVideoResult;)V", "<init>", "(Lcom/qzone/publish/business/model/intimate/IntimateUploadImageResult;Lcom/qzone/publish/business/model/intimate/IntimateUploadVideoResult;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final /* data */ class IntimateUploadMediaResult implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long serialVersionUID = -2203078732665558769L;
    private IntimateUploadImageResult imageResult;
    private IntimateUploadVideoResult videoResult;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/publish/business/model/intimate/IntimateUploadMediaResult$a;", "", "Lqzone/QZoneBaseMeta$StMedia;", "stMedia", "Lcom/qzone/publish/business/model/intimate/IntimateUploadMediaResult;", "a", "", "serialVersionUID", "J", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.publish.business.model.intimate.IntimateUploadMediaResult$a, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IntimateUploadMediaResult a(QZoneBaseMeta$StMedia stMedia) {
            IntimateUploadImageResult intimateUploadImageResult;
            Intrinsics.checkNotNullParameter(stMedia, "stMedia");
            if (b.c(stMedia)) {
                IntimateUploadImageResult.Companion companion = IntimateUploadImageResult.INSTANCE;
                QZoneBaseMeta$StImage qZoneBaseMeta$StImage = stMedia.image;
                Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StImage, "stMedia.image");
                intimateUploadImageResult = companion.a(qZoneBaseMeta$StImage);
            } else {
                intimateUploadImageResult = null;
            }
            return new IntimateUploadMediaResult(intimateUploadImageResult, b.d(stMedia) ? IntimateUploadVideoResult.INSTANCE.a(stMedia) : null);
        }

        Companion() {
        }
    }

    public IntimateUploadMediaResult() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* renamed from: component1, reason: from getter */
    public final IntimateUploadImageResult getImageResult() {
        return this.imageResult;
    }

    /* renamed from: component2, reason: from getter */
    public final IntimateUploadVideoResult getVideoResult() {
        return this.videoResult;
    }

    public final IntimateUploadMediaResult copy(IntimateUploadImageResult imageResult, IntimateUploadVideoResult videoResult) {
        return new IntimateUploadMediaResult(imageResult, videoResult);
    }

    public final IntimateUploadImageResult getImageResult() {
        return this.imageResult;
    }

    public final IntimateUploadVideoResult getVideoResult() {
        return this.videoResult;
    }

    public int hashCode() {
        IntimateUploadImageResult intimateUploadImageResult = this.imageResult;
        int hashCode = (intimateUploadImageResult == null ? 0 : intimateUploadImageResult.hashCode()) * 31;
        IntimateUploadVideoResult intimateUploadVideoResult = this.videoResult;
        return hashCode + (intimateUploadVideoResult != null ? intimateUploadVideoResult.hashCode() : 0);
    }

    public final boolean isImageResult() {
        return this.imageResult != null;
    }

    public final void setImageResult(IntimateUploadImageResult intimateUploadImageResult) {
        this.imageResult = intimateUploadImageResult;
    }

    public final void setVideoResult(IntimateUploadVideoResult intimateUploadVideoResult) {
        this.videoResult = intimateUploadVideoResult;
    }

    public final QZoneBaseMeta$StMedia toStMedia() {
        QZoneBaseMeta$StMedia stMedia;
        IntimateUploadImageResult intimateUploadImageResult = this.imageResult;
        if (intimateUploadImageResult != null && (stMedia = intimateUploadImageResult.toStMedia()) != null) {
            return stMedia;
        }
        IntimateUploadVideoResult intimateUploadVideoResult = this.videoResult;
        if (intimateUploadVideoResult != null) {
            return intimateUploadVideoResult.toStMedia();
        }
        return null;
    }

    public String toString() {
        return "IntimateUploadMediaResult(imageResult=" + this.imageResult + ", videoResult=" + this.videoResult + ")";
    }

    public IntimateUploadMediaResult(IntimateUploadImageResult intimateUploadImageResult, IntimateUploadVideoResult intimateUploadVideoResult) {
        this.imageResult = intimateUploadImageResult;
        this.videoResult = intimateUploadVideoResult;
    }

    public /* synthetic */ IntimateUploadMediaResult(IntimateUploadImageResult intimateUploadImageResult, IntimateUploadVideoResult intimateUploadVideoResult, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : intimateUploadImageResult, (i3 & 2) != 0 ? null : intimateUploadVideoResult);
    }

    public static /* synthetic */ IntimateUploadMediaResult copy$default(IntimateUploadMediaResult intimateUploadMediaResult, IntimateUploadImageResult intimateUploadImageResult, IntimateUploadVideoResult intimateUploadVideoResult, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            intimateUploadImageResult = intimateUploadMediaResult.imageResult;
        }
        if ((i3 & 2) != 0) {
            intimateUploadVideoResult = intimateUploadMediaResult.videoResult;
        }
        return intimateUploadMediaResult.copy(intimateUploadImageResult, intimateUploadVideoResult);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntimateUploadMediaResult)) {
            return false;
        }
        IntimateUploadMediaResult intimateUploadMediaResult = (IntimateUploadMediaResult) other;
        return Intrinsics.areEqual(this.imageResult, intimateUploadMediaResult.imageResult) && Intrinsics.areEqual(this.videoResult, intimateUploadMediaResult.videoResult);
    }
}
