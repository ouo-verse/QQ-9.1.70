package ij;

import android.graphics.Bitmap;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020\u001a\u0012\b\u0010%\u001a\u0004\u0018\u00010\"\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010+\u001a\u00020\u0007\u00a2\u0006\u0004\b,\u0010-J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\fR\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010!\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b \u0010\u001eR\u0019\u0010%\u001a\u0004\u0018\u00010\"8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010#\u001a\u0004\b\u000e\u0010$R\u0019\u0010'\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b&\u0010\n\u001a\u0004\b\u001b\u0010\fR\u0017\u0010+\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b\t\u0010*\u00a8\u0006."}, d2 = {"Lij/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "spaceId", "b", "I", "g", "()I", "spaceType", "Landroid/graphics/Bitmap;", "c", "Landroid/graphics/Bitmap;", "d", "()Landroid/graphics/Bitmap;", "previewBitmap", "filePath", "", "e", UserInfo.SEX_FEMALE, "getWidth", "()F", "width", "getHeight", "height", "Landroid/view/View;", "Landroid/view/View;", "()Landroid/view/View;", "bottomView", tl.h.F, "resignLink", "i", "Z", "()Z", "autoSyncQZone", "<init>", "(Ljava/lang/String;ILandroid/graphics/Bitmap;Ljava/lang/String;FFLandroid/view/View;Ljava/lang/String;Z)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ij.d, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class QZIntimatePicSharePreviewBean {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String spaceId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int spaceType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final Bitmap previewBitmap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String filePath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final float width;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final float height;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final View bottomView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final String resignLink;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean autoSyncQZone;

    public QZIntimatePicSharePreviewBean(String spaceId, int i3, Bitmap previewBitmap, String str, float f16, float f17, View view, String str2, boolean z16) {
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Intrinsics.checkNotNullParameter(previewBitmap, "previewBitmap");
        this.spaceId = spaceId;
        this.spaceType = i3;
        this.previewBitmap = previewBitmap;
        this.filePath = str;
        this.width = f16;
        this.height = f17;
        this.bottomView = view;
        this.resignLink = str2;
        this.autoSyncQZone = z16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getAutoSyncQZone() {
        return this.autoSyncQZone;
    }

    /* renamed from: b, reason: from getter */
    public final View getBottomView() {
        return this.bottomView;
    }

    /* renamed from: c, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: d, reason: from getter */
    public final Bitmap getPreviewBitmap() {
        return this.previewBitmap;
    }

    /* renamed from: e, reason: from getter */
    public final String getResignLink() {
        return this.resignLink;
    }

    /* renamed from: f, reason: from getter */
    public final String getSpaceId() {
        return this.spaceId;
    }

    /* renamed from: g, reason: from getter */
    public final int getSpaceType() {
        return this.spaceType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.spaceId.hashCode() * 31) + this.spaceType) * 31) + this.previewBitmap.hashCode()) * 31;
        String str = this.filePath;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Float.floatToIntBits(this.width)) * 31) + Float.floatToIntBits(this.height)) * 31;
        View view = this.bottomView;
        int hashCode3 = (hashCode2 + (view == null ? 0 : view.hashCode())) * 31;
        String str2 = this.resignLink;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z16 = this.autoSyncQZone;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode4 + i3;
    }

    public String toString() {
        return "QZIntimatePicSharePreviewBean(spaceId=" + this.spaceId + ", spaceType=" + this.spaceType + ", previewBitmap=" + this.previewBitmap + ", filePath=" + this.filePath + ", width=" + this.width + ", height=" + this.height + ", bottomView=" + this.bottomView + ", resignLink=" + this.resignLink + ", autoSyncQZone=" + this.autoSyncQZone + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QZIntimatePicSharePreviewBean)) {
            return false;
        }
        QZIntimatePicSharePreviewBean qZIntimatePicSharePreviewBean = (QZIntimatePicSharePreviewBean) other;
        return Intrinsics.areEqual(this.spaceId, qZIntimatePicSharePreviewBean.spaceId) && this.spaceType == qZIntimatePicSharePreviewBean.spaceType && Intrinsics.areEqual(this.previewBitmap, qZIntimatePicSharePreviewBean.previewBitmap) && Intrinsics.areEqual(this.filePath, qZIntimatePicSharePreviewBean.filePath) && Float.compare(this.width, qZIntimatePicSharePreviewBean.width) == 0 && Float.compare(this.height, qZIntimatePicSharePreviewBean.height) == 0 && Intrinsics.areEqual(this.bottomView, qZIntimatePicSharePreviewBean.bottomView) && Intrinsics.areEqual(this.resignLink, qZIntimatePicSharePreviewBean.resignLink) && this.autoSyncQZone == qZIntimatePicSharePreviewBean.autoSyncQZone;
    }
}
