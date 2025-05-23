package com.tencent.mobileqq.wink.editor.openingending;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.videocut.model.MediaClip;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/a;", "", "<init>", "()V", "a", "b", "c", "d", "e", "Lcom/tencent/mobileqq/wink/editor/openingending/a$a;", "Lcom/tencent/mobileqq/wink/editor/openingending/a$b;", "Lcom/tencent/mobileqq/wink/editor/openingending/a$c;", "Lcom/tencent/mobileqq/wink/editor/openingending/a$d;", "Lcom/tencent/mobileqq/wink/editor/openingending/a$e;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0011\u001a\u0004\b\n\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/a$a;", "Lcom/tencent/mobileqq/wink/editor/openingending/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "b", "()Z", IXWebBroadcastListener.STAGE_FINISHED, "c", "success", "Ljava/lang/String;", "()Ljava/lang/String;", "errMsg", "<init>", "(ZZLjava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.openingending.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class AigcTemplateGenerateResult extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean finished;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean success;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String errMsg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AigcTemplateGenerateResult(boolean z16, boolean z17, @NotNull String errMsg) {
            super(null);
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.finished = z16;
            this.success = z17;
            this.errMsg = errMsg;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getErrMsg() {
            return this.errMsg;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getFinished() {
            return this.finished;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getSuccess() {
            return this.success;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AigcTemplateGenerateResult)) {
                return false;
            }
            AigcTemplateGenerateResult aigcTemplateGenerateResult = (AigcTemplateGenerateResult) other;
            if (this.finished == aigcTemplateGenerateResult.finished && this.success == aigcTemplateGenerateResult.success && Intrinsics.areEqual(this.errMsg, aigcTemplateGenerateResult.errMsg)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            boolean z16 = this.finished;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            boolean z17 = this.success;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return ((i16 + i3) * 31) + this.errMsg.hashCode();
        }

        @NotNull
        public String toString() {
            return "AigcTemplateGenerateResult(finished=" + this.finished + ", success=" + this.success + ", errMsg=" + this.errMsg + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/a$b;", "Lcom/tencent/mobileqq/wink/editor/openingending/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/videocut/model/MediaClip;", "a", "Lcom/tencent/videocut/model/MediaClip;", "()Lcom/tencent/videocut/model/MediaClip;", "mediaClip", "<init>", "(Lcom/tencent/videocut/model/MediaClip;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.openingending.a$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class DeleteMediaClip extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final MediaClip mediaClip;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeleteMediaClip(@NotNull MediaClip mediaClip) {
            super(null);
            Intrinsics.checkNotNullParameter(mediaClip, "mediaClip");
            this.mediaClip = mediaClip;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final MediaClip getMediaClip() {
            return this.mediaClip;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof DeleteMediaClip) && Intrinsics.areEqual(this.mediaClip, ((DeleteMediaClip) other).mediaClip)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.mediaClip.hashCode();
        }

        @NotNull
        public String toString() {
            return "DeleteMediaClip(mediaClip=" + this.mediaClip + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/a$c;", "Lcom/tencent/mobileqq/wink/editor/openingending/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/videocut/model/MediaClip;", "a", "Lcom/tencent/videocut/model/MediaClip;", "()Lcom/tencent/videocut/model/MediaClip;", "selectedMediaClip", "<init>", "(Lcom/tencent/videocut/model/MediaClip;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.openingending.a$c, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class EditableOverlayClick extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final MediaClip selectedMediaClip;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EditableOverlayClick(@NotNull MediaClip selectedMediaClip) {
            super(null);
            Intrinsics.checkNotNullParameter(selectedMediaClip, "selectedMediaClip");
            this.selectedMediaClip = selectedMediaClip;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final MediaClip getSelectedMediaClip() {
            return this.selectedMediaClip;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof EditableOverlayClick) && Intrinsics.areEqual(this.selectedMediaClip, ((EditableOverlayClick) other).selectedMediaClip)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.selectedMediaClip.hashCode();
        }

        @NotNull
        public String toString() {
            return "EditableOverlayClick(selectedMediaClip=" + this.selectedMediaClip + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/a$d;", "Lcom/tencent/mobileqq/wink/editor/openingending/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Z", "()Z", "needDismiss", "<init>", "(Z)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.openingending.a$d, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class NeedDismiss extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean needDismiss;

        public NeedDismiss(boolean z16) {
            super(null);
            this.needDismiss = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getNeedDismiss() {
            return this.needDismiss;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof NeedDismiss) && this.needDismiss == ((NeedDismiss) other).needDismiss) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.needDismiss;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "NeedDismiss(needDismiss=" + this.needDismiss + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/a$e;", "Lcom/tencent/mobileqq/wink/editor/openingending/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "a", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "<init>", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.openingending.a$e, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class SelectMaterial extends a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final MetaMaterial material;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectMaterial(@NotNull MetaMaterial material) {
            super(null);
            Intrinsics.checkNotNullParameter(material, "material");
            this.material = material;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final MetaMaterial getMaterial() {
            return this.material;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof SelectMaterial) && Intrinsics.areEqual(this.material, ((SelectMaterial) other).material)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.material.hashCode();
        }

        @NotNull
        public String toString() {
            return "SelectMaterial(material=" + this.material + ")";
        }
    }

    public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    a() {
    }
}
