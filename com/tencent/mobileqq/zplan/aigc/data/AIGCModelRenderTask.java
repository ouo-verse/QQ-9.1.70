package com.tencent.mobileqq.zplan.aigc.data;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.aigc.render.AIGCWhiteModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010/\u001a\u00020)\u0012\b\b\u0002\u00104\u001a\u00020\u0002\u0012\b\b\u0002\u00106\u001a\u00020\u0004\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b;\u0010<J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR\u0017\u0010!\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\t\u0010 R$\u0010(\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010/\u001a\u00020)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00104\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\u001f\u001a\u0004\b1\u0010 \"\u0004\b2\u00103R\"\u00106\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b5\u0010\u000eR$\u00108\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u001f\u001a\u0004\b\u001e\u0010 \"\u0004\b7\u00103R$\u0010:\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u001f\u001a\u0004\b0\u0010 \"\u0004\b9\u00103\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/data/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "c", "()I", "setId", "(I)V", "id", "Lcom/tencent/mobileqq/zplan/aigc/render/AIGCWhiteModel;", "b", "Lcom/tencent/mobileqq/zplan/aigc/render/AIGCWhiteModel;", "d", "()Lcom/tencent/mobileqq/zplan/aigc/render/AIGCWhiteModel;", "model", "Lcom/tencent/mobileqq/zplan/aigc/data/l;", "Lcom/tencent/mobileqq/zplan/aigc/data/l;", "f", "()Lcom/tencent/mobileqq/zplan/aigc/data/l;", "patternImage", "g", "l", "patternPosType", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "color", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "i", "()Landroid/graphics/Bitmap;", DomainData.DOMAIN_NAME, "(Landroid/graphics/Bitmap;)V", "resultImage", "Lcom/tencent/mobileqq/zplan/aigc/data/TASK_STATUS;", "Lcom/tencent/mobileqq/zplan/aigc/data/TASK_STATUS;", "j", "()Lcom/tencent/mobileqq/zplan/aigc/data/TASK_STATUS;", "o", "(Lcom/tencent/mobileqq/zplan/aigc/data/TASK_STATUS;)V", "status", tl.h.F, "k", "p", "(Ljava/lang/String;)V", "ugcID", "setGridIndex", "gridIndex", "setModelItemId", "modelItemId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "previewResourceDirPath", "<init>", "(ILcom/tencent/mobileqq/zplan/aigc/render/AIGCWhiteModel;Lcom/tencent/mobileqq/zplan/aigc/data/l;ILjava/lang/String;Landroid/graphics/Bitmap;Lcom/tencent/mobileqq/zplan/aigc/data/TASK_STATUS;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.aigc.data.d, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class AIGCModelRenderTask {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final AIGCWhiteModel model;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final PatternImage patternImage;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int patternPosType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String color;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private Bitmap resultImage;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private TASK_STATUS status;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private String ugcID;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private int gridIndex;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private String modelItemId;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private String previewResourceDirPath;

    public AIGCModelRenderTask(int i3, AIGCWhiteModel model, PatternImage patternImage, int i16, String color, Bitmap bitmap, TASK_STATUS status, String ugcID, int i17, String str, String str2) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(patternImage, "patternImage");
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(ugcID, "ugcID");
        this.id = i3;
        this.model = model;
        this.patternImage = patternImage;
        this.patternPosType = i16;
        this.color = color;
        this.resultImage = bitmap;
        this.status = status;
        this.ugcID = ugcID;
        this.gridIndex = i17;
        this.modelItemId = str;
        this.previewResourceDirPath = str2;
    }

    /* renamed from: a, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* renamed from: b, reason: from getter */
    public final int getGridIndex() {
        return this.gridIndex;
    }

    /* renamed from: c, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: d, reason: from getter */
    public final AIGCWhiteModel getModel() {
        return this.model;
    }

    /* renamed from: e, reason: from getter */
    public final String getModelItemId() {
        return this.modelItemId;
    }

    /* renamed from: f, reason: from getter */
    public final PatternImage getPatternImage() {
        return this.patternImage;
    }

    /* renamed from: g, reason: from getter */
    public final int getPatternPosType() {
        return this.patternPosType;
    }

    /* renamed from: h, reason: from getter */
    public final String getPreviewResourceDirPath() {
        return this.previewResourceDirPath;
    }

    public int hashCode() {
        int hashCode = ((((((((this.id * 31) + this.model.hashCode()) * 31) + this.patternImage.hashCode()) * 31) + this.patternPosType) * 31) + this.color.hashCode()) * 31;
        Bitmap bitmap = this.resultImage;
        int hashCode2 = (((((((hashCode + (bitmap == null ? 0 : bitmap.hashCode())) * 31) + this.status.hashCode()) * 31) + this.ugcID.hashCode()) * 31) + this.gridIndex) * 31;
        String str = this.modelItemId;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.previewResourceDirPath;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final Bitmap getResultImage() {
        return this.resultImage;
    }

    /* renamed from: j, reason: from getter */
    public final TASK_STATUS getStatus() {
        return this.status;
    }

    /* renamed from: k, reason: from getter */
    public final String getUgcID() {
        return this.ugcID;
    }

    public final void l(int i3) {
        this.patternPosType = i3;
    }

    public final void m(String str) {
        this.previewResourceDirPath = str;
    }

    public final void n(Bitmap bitmap) {
        this.resultImage = bitmap;
    }

    public final void o(TASK_STATUS task_status) {
        Intrinsics.checkNotNullParameter(task_status, "<set-?>");
        this.status = task_status;
    }

    public final void p(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ugcID = str;
    }

    public String toString() {
        return "AIGCModelRenderTask(id=" + this.id + ", model=" + this.model + ", patternImage=" + this.patternImage + ", patternPosType=" + this.patternPosType + ", color=" + this.color + ", resultImage=" + this.resultImage + ", status=" + this.status + ", ugcID=" + this.ugcID + ", gridIndex=" + this.gridIndex + ", modelItemId=" + this.modelItemId + ", previewResourceDirPath=" + this.previewResourceDirPath + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AIGCModelRenderTask)) {
            return false;
        }
        AIGCModelRenderTask aIGCModelRenderTask = (AIGCModelRenderTask) other;
        return this.id == aIGCModelRenderTask.id && Intrinsics.areEqual(this.model, aIGCModelRenderTask.model) && Intrinsics.areEqual(this.patternImage, aIGCModelRenderTask.patternImage) && this.patternPosType == aIGCModelRenderTask.patternPosType && Intrinsics.areEqual(this.color, aIGCModelRenderTask.color) && Intrinsics.areEqual(this.resultImage, aIGCModelRenderTask.resultImage) && this.status == aIGCModelRenderTask.status && Intrinsics.areEqual(this.ugcID, aIGCModelRenderTask.ugcID) && this.gridIndex == aIGCModelRenderTask.gridIndex && Intrinsics.areEqual(this.modelItemId, aIGCModelRenderTask.modelItemId) && Intrinsics.areEqual(this.previewResourceDirPath, aIGCModelRenderTask.previewResourceDirPath);
    }

    public /* synthetic */ AIGCModelRenderTask(int i3, AIGCWhiteModel aIGCWhiteModel, PatternImage patternImage, int i16, String str, Bitmap bitmap, TASK_STATUS task_status, String str2, int i17, String str3, String str4, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, aIGCWhiteModel, patternImage, i16, str, (i18 & 32) != 0 ? null : bitmap, (i18 & 64) != 0 ? TASK_STATUS.TASK_STATUS_NONE : task_status, (i18 & 128) != 0 ? "000001" : str2, (i18 & 256) != 0 ? 0 : i17, (i18 & 512) != 0 ? "" : str3, (i18 & 1024) != 0 ? "" : str4);
    }
}
