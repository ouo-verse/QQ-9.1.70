package com.tencent.mobileqq.wink.editor.templatecoll;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010%\n\u0002\b\u000b\u0018\u0000 02\u00020\u0001:\u000212B\u0007\u00a2\u0006\u0004\b.\u0010/J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J(\u0010\u0010\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0014\u001a\u00020\u0004J\u0018\u0010\u0017\u001a\u00020\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0015\u001a\u00020\rJ\u0010\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018J\b\u0010\u001c\u001a\u00020\u0011H\u0016R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\"\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t0(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\"\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t0(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010*\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/templatecoll/ah;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/tencent/mobileqq/wink/editor/dr;", "tavcut", "", "O1", "Lcom/tencent/videocut/model/MediaClip;", "mediaClip", "P1", "Lcom/tencent/mobileqq/wink/editor/templatecoll/ah$b;", "N1", "Landroid/graphics/Matrix;", "cropViewMatrix", "Landroid/graphics/RectF;", "cropViewCropRect", "mediaCropRect", "T1", "", "templateId", "L1", "S1", "newMediaCropRect", "", "M1", "Lcom/tencent/mobileqq/wink/editor/templatecoll/TemplateCollClippingUIData;", "uiDraft", "R1", "Q1", "getLogTag", "i", "Ljava/lang/String;", "getTemplateId", "()Ljava/lang/String;", "setTemplateId", "(Ljava/lang/String;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/editor/dr;", "tavCutManager", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/editor/templatecoll/TemplateCollClippingUIData;", "", "D", "Ljava/util/Map;", "storedCropInfos", "E", "backupCropInfos", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class ah extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private TemplateCollClippingUIData uiDraft;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private Map<String, CropInfo> storedCropInfos = new LinkedHashMap();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private Map<String, CropInfo> backupCropInfos = new LinkedHashMap();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String templateId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private dr tavCutManager;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0013\u001a\u0004\b\u0015\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/templatecoll/ah$b;", "", "Landroid/graphics/Matrix;", "cropViewMatrix", "Landroid/graphics/RectF;", "cropViewCropRect", "mediaCropRect", "a", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/graphics/Matrix;", "c", "()Landroid/graphics/Matrix;", "b", "Landroid/graphics/RectF;", "()Landroid/graphics/RectF;", "d", "<init>", "(Landroid/graphics/Matrix;Landroid/graphics/RectF;Landroid/graphics/RectF;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.templatecoll.ah$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class CropInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Matrix cropViewMatrix;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final RectF cropViewCropRect;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final RectF mediaCropRect;

        public CropInfo() {
            this(null, null, null, 7, null);
        }

        @NotNull
        public final CropInfo a(@NotNull Matrix cropViewMatrix, @NotNull RectF cropViewCropRect, @NotNull RectF mediaCropRect) {
            Intrinsics.checkNotNullParameter(cropViewMatrix, "cropViewMatrix");
            Intrinsics.checkNotNullParameter(cropViewCropRect, "cropViewCropRect");
            Intrinsics.checkNotNullParameter(mediaCropRect, "mediaCropRect");
            return new CropInfo(cropViewMatrix, cropViewCropRect, mediaCropRect);
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final RectF getCropViewCropRect() {
            return this.cropViewCropRect;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final Matrix getCropViewMatrix() {
            return this.cropViewMatrix;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final RectF getMediaCropRect() {
            return this.mediaCropRect;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CropInfo)) {
                return false;
            }
            CropInfo cropInfo = (CropInfo) other;
            if (Intrinsics.areEqual(this.cropViewMatrix, cropInfo.cropViewMatrix) && Intrinsics.areEqual(this.cropViewCropRect, cropInfo.cropViewCropRect) && Intrinsics.areEqual(this.mediaCropRect, cropInfo.mediaCropRect)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.cropViewMatrix.hashCode() * 31) + this.cropViewCropRect.hashCode()) * 31) + this.mediaCropRect.hashCode();
        }

        @NotNull
        public String toString() {
            return "CropInfo(cropViewMatrix=" + this.cropViewMatrix + ", cropViewCropRect=" + this.cropViewCropRect + ", mediaCropRect=" + this.mediaCropRect + ")";
        }

        public CropInfo(@NotNull Matrix cropViewMatrix, @NotNull RectF cropViewCropRect, @NotNull RectF mediaCropRect) {
            Intrinsics.checkNotNullParameter(cropViewMatrix, "cropViewMatrix");
            Intrinsics.checkNotNullParameter(cropViewCropRect, "cropViewCropRect");
            Intrinsics.checkNotNullParameter(mediaCropRect, "mediaCropRect");
            this.cropViewMatrix = cropViewMatrix;
            this.cropViewCropRect = cropViewCropRect;
            this.mediaCropRect = mediaCropRect;
        }

        public /* synthetic */ CropInfo(Matrix matrix, RectF rectF, RectF rectF2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new Matrix() : matrix, (i3 & 2) != 0 ? new RectF() : rectF, (i3 & 4) != 0 ? new RectF() : rectF2);
        }
    }

    public final void L1(@Nullable String templateId) {
        this.backupCropInfos.clear();
        String str = this.templateId;
        if (str != null && !Intrinsics.areEqual(str, templateId)) {
            this.storedCropInfos.clear();
        } else {
            for (Map.Entry<String, CropInfo> entry : this.storedCropInfos.entrySet()) {
                CropInfo value = entry.getValue();
                this.backupCropInfos.put(entry.getKey(), value.a(new Matrix(value.getCropViewMatrix()), new RectF(value.getCropViewCropRect()), new RectF(value.getMediaCropRect())));
            }
        }
        this.templateId = templateId;
    }

    public final boolean M1(@Nullable MediaClip mediaClip, @NotNull RectF newMediaCropRect) {
        ResourceModel resourceModel;
        String str;
        CropInfo cropInfo;
        Intrinsics.checkNotNullParameter(newMediaCropRect, "newMediaCropRect");
        if (mediaClip != null && (resourceModel = mediaClip.resource) != null && (str = resourceModel.id) != null && (cropInfo = this.storedCropInfos.get(str)) != null) {
            RectF mediaCropRect = cropInfo.getMediaCropRect();
            if (Math.abs(mediaCropRect.left - newMediaCropRect.left) > 2.0f || Math.abs(mediaCropRect.right - newMediaCropRect.right) > 2.0f || Math.abs(mediaCropRect.top - newMediaCropRect.top) > 2.0f || Math.abs(mediaCropRect.bottom - newMediaCropRect.bottom) > 2.0f) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Nullable
    public final CropInfo N1(@Nullable MediaClip mediaClip) {
        ResourceModel resourceModel;
        String str;
        if (mediaClip != null && (resourceModel = mediaClip.resource) != null && (str = resourceModel.id) != null) {
            return this.storedCropInfos.get(str);
        }
        return null;
    }

    public final void O1(@NotNull dr tavcut) {
        Intrinsics.checkNotNullParameter(tavcut, "tavcut");
        this.tavCutManager = tavcut;
    }

    public final void P1(@Nullable MediaClip mediaClip) {
        MediaClip mediaClip2;
        List<? extends MediaClip> listOf;
        List emptyList;
        ResourceModel resourceModel;
        WinkVideoTavCut winkVideoTavCut = null;
        if (mediaClip != null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            ResourceModel resourceModel2 = mediaClip.resource;
            if (resourceModel2 != null) {
                resourceModel = resourceModel2.copy((r35 & 1) != 0 ? resourceModel2.id : null, (r35 & 2) != 0 ? resourceModel2.path : null, (r35 & 4) != 0 ? Long.valueOf(resourceModel2.scaleDuration) : null, (r35 & 8) != 0 ? Long.valueOf(resourceModel2.sourceStart) : null, (r35 & 16) != 0 ? Long.valueOf(resourceModel2.sourceDuration) : null, (r35 & 32) != 0 ? Long.valueOf(resourceModel2.selectStart) : null, (r35 & 64) != 0 ? Long.valueOf(resourceModel2.selectDuration) : null, (r35 & 128) != 0 ? resourceModel2.type : null, (r35 & 256) != 0 ? resourceModel2.size : null, (r35 & 512) != 0 ? Float.valueOf(resourceModel2.volume) : null, (r35 & 1024) != 0 ? resourceModel2.extras : null, (r35 & 2048) != 0 ? resourceModel2.picClipRect : null, (r35 & 4096) != 0 ? resourceModel2.reversePath : null, (r35 & 8192) != 0 ? resourceModel2.normalPath : null, (r35 & 16384) != 0 ? resourceModel2.isReverseMode : null, (r35 & 32768) != 0 ? Float.valueOf(resourceModel2.deblurScore) : null, (r35 & 65536) != 0 ? resourceModel2.unknownFields() : null);
            } else {
                resourceModel = null;
            }
            mediaClip2 = MediaClip.copy$default(mediaClip, resourceModel, null, null, null, null, emptyList, null, 94, null);
        } else {
            mediaClip2 = null;
        }
        if (mediaClip2 != null) {
            Object obj = this.tavCutManager;
            if (obj == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tavCutManager");
                obj = null;
            }
            if (obj instanceof WinkVideoTavCut) {
                winkVideoTavCut = (WinkVideoTavCut) obj;
            }
            if (winkVideoTavCut != null) {
                listOf = CollectionsKt__CollectionsJVMKt.listOf(mediaClip2);
                winkVideoTavCut.e0(listOf);
            }
        }
    }

    public final void Q1(@NotNull TemplateCollClippingUIData uiDraft) {
        Intrinsics.checkNotNullParameter(uiDraft, "uiDraft");
        this.uiDraft = uiDraft;
    }

    public final void R1(@Nullable TemplateCollClippingUIData uiDraft) {
        if (uiDraft != null) {
            this.storedCropInfos = uiDraft.getCropInfoMap();
        }
    }

    public final void S1() {
        this.storedCropInfos.clear();
        for (Map.Entry<String, CropInfo> entry : this.backupCropInfos.entrySet()) {
            CropInfo value = entry.getValue();
            this.storedCropInfos.put(entry.getKey(), value.a(new Matrix(value.getCropViewMatrix()), new RectF(value.getCropViewCropRect()), new RectF(value.getMediaCropRect())));
        }
    }

    public final void T1(@Nullable MediaClip mediaClip, @NotNull Matrix cropViewMatrix, @NotNull RectF cropViewCropRect, @NotNull RectF mediaCropRect) {
        ResourceModel resourceModel;
        String str;
        Intrinsics.checkNotNullParameter(cropViewMatrix, "cropViewMatrix");
        Intrinsics.checkNotNullParameter(cropViewCropRect, "cropViewCropRect");
        Intrinsics.checkNotNullParameter(mediaCropRect, "mediaCropRect");
        if (mediaClip != null && (resourceModel = mediaClip.resource) != null && (str = resourceModel.id) != null) {
            CropInfo cropInfo = new CropInfo(cropViewMatrix, cropViewCropRect, mediaCropRect);
            this.storedCropInfos.put(str, cropInfo);
            TemplateCollClippingUIData templateCollClippingUIData = this.uiDraft;
            if (templateCollClippingUIData != null) {
                templateCollClippingUIData.storeCropInfo(str, cropInfo);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkEditorTemplateCollCropViewModel";
    }
}
