package fg3;

import android.graphics.Bitmap;
import com.tencent.autotemplate.extra.PreDetect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qshadow.AIFacePtaData$ZplanFaceStyle;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u0000 \u000b2\u00020\u0001:\u0001\tBI\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010.\u001a\u00020\u0003\u00a2\u0006\u0004\b/\u00100J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\"\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010$\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R$\u0010+\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010.\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0011\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015\u00a8\u00061"}, d2 = {"Lfg3/l;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "I", "g", "()I", "o", "(I)V", "type", "b", "Z", tl.h.F, "()Z", "l", "(Z)V", "isSelected", "Lqshadow/AIFacePtaData$ZplanFaceStyle;", "c", "Lqshadow/AIFacePtaData$ZplanFaceStyle;", "e", "()Lqshadow/AIFacePtaData$ZplanFaceStyle;", "k", "(Lqshadow/AIFacePtaData$ZplanFaceStyle;)V", PreDetect.FACE_DETECT, "d", "Ljava/lang/String;", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "data", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "f", "()Landroid/graphics/Bitmap;", DomainData.DOMAIN_NAME, "(Landroid/graphics/Bitmap;)V", "thumbnailBitmap", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isSelectedReport", "<init>", "(IZLqshadow/AIFacePtaData$ZplanFaceStyle;Ljava/lang/String;Landroid/graphics/Bitmap;Z)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: fg3.l, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class FaceItemData {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: h, reason: collision with root package name */
    private static final int f398610h = 1;

    /* renamed from: i, reason: collision with root package name */
    private static final int f398611i = 2;

    /* renamed from: j, reason: collision with root package name */
    private static final int f398612j = 3;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isSelected;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private AIFacePtaData$ZplanFaceStyle face;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String data;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private Bitmap thumbnailBitmap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isSelectedReport;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00048\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u001a\u0010\u000b\u001a\u00020\u00048\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lfg3/l$a;", "", "Lfg3/l;", "a", "", "LOADING", "I", "c", "()I", "ADD", "b", "PICTURE", "d", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: fg3.l$a, reason: from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FaceItemData a() {
            FaceItemData faceItemData = new FaceItemData(0, false, null, null, null, false, 63, null);
            faceItemData.o(FaceItemData.INSTANCE.b());
            return faceItemData;
        }

        public final int b() {
            return FaceItemData.f398611i;
        }

        public final int c() {
            return FaceItemData.f398610h;
        }

        public final int d() {
            return FaceItemData.f398612j;
        }

        Companion() {
        }
    }

    public FaceItemData() {
        this(0, false, null, null, null, false, 63, null);
    }

    /* renamed from: d, reason: from getter */
    public final String getData() {
        return this.data;
    }

    /* renamed from: e, reason: from getter */
    public final AIFacePtaData$ZplanFaceStyle getFace() {
        return this.face;
    }

    /* renamed from: f, reason: from getter */
    public final Bitmap getThumbnailBitmap() {
        return this.thumbnailBitmap;
    }

    /* renamed from: g, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public int hashCode() {
        int a16 = ((this.type * 31) + k.a(this.isSelected)) * 31;
        AIFacePtaData$ZplanFaceStyle aIFacePtaData$ZplanFaceStyle = this.face;
        int hashCode = (a16 + (aIFacePtaData$ZplanFaceStyle != null ? aIFacePtaData$ZplanFaceStyle.hashCode() : 0)) * 31;
        String str = this.data;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsSelectedReport() {
        return this.isSelectedReport;
    }

    public final void j(String str) {
        this.data = str;
    }

    public final void k(AIFacePtaData$ZplanFaceStyle aIFacePtaData$ZplanFaceStyle) {
        this.face = aIFacePtaData$ZplanFaceStyle;
    }

    public final void l(boolean z16) {
        this.isSelected = z16;
    }

    public final void m(boolean z16) {
        this.isSelectedReport = z16;
    }

    public final void n(Bitmap bitmap) {
        this.thumbnailBitmap = bitmap;
    }

    public final void o(int i3) {
        this.type = i3;
    }

    public String toString() {
        return "FaceItemData(type=" + this.type + ", isSelected=" + this.isSelected + ", face=" + this.face + ", data=" + this.data + ", thumbnailBitmap=" + this.thumbnailBitmap + ", isSelectedReport=" + this.isSelectedReport + ")";
    }

    public FaceItemData(int i3, boolean z16, AIFacePtaData$ZplanFaceStyle aIFacePtaData$ZplanFaceStyle, String str, Bitmap bitmap, boolean z17) {
        this.type = i3;
        this.isSelected = z16;
        this.face = aIFacePtaData$ZplanFaceStyle;
        this.data = str;
        this.thumbnailBitmap = bitmap;
        this.isSelectedReport = z17;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(FaceItemData.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.mobileqq.zplan.cc.view.FaceItemData");
        FaceItemData faceItemData = (FaceItemData) other;
        if (this.type != faceItemData.type || this.isSelected != faceItemData.isSelected || !Intrinsics.areEqual(this.face, faceItemData.face)) {
            return false;
        }
        String str = this.data;
        if (str != null) {
            String str2 = faceItemData.data;
            if (str2 == null || Intrinsics.areEqual(str, str2)) {
                return false;
            }
        } else if (faceItemData.data != null) {
            return false;
        }
        return true;
    }

    public /* synthetic */ FaceItemData(int i3, boolean z16, AIFacePtaData$ZplanFaceStyle aIFacePtaData$ZplanFaceStyle, String str, Bitmap bitmap, boolean z17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 1 : i3, (i16 & 2) != 0 ? false : z16, (i16 & 4) != 0 ? null : aIFacePtaData$ZplanFaceStyle, (i16 & 8) != 0 ? null : str, (i16 & 16) == 0 ? bitmap : null, (i16 & 32) == 0 ? z17 : false);
    }
}
