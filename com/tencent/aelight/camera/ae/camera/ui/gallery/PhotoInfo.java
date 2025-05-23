package com.tencent.aelight.camera.ae.camera.ui.gallery;

import com.gcore.abase.utils.PatternUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.ttpic.openapi.PTFaceAttr;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\tB)\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0017\u001a\u0004\b\u0011\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001d\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\f\u00a8\u0006 "}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/gallery/ac;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "e", "()Z", "g", "(Z)V", "selected", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "b", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "c", "()Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "Lcom/tencent/ttpic/openapi/PTFaceAttr;", "Lcom/tencent/ttpic/openapi/PTFaceAttr;", "()Lcom/tencent/ttpic/openapi/PTFaceAttr;", "f", "(Lcom/tencent/ttpic/openapi/PTFaceAttr;)V", "detectResult", "d", ToastView.ICON_LOADING, "<init>", "(ZLcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Lcom/tencent/ttpic/openapi/PTFaceAttr;)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.aelight.camera.ae.camera.ui.gallery.ac, reason: from toString */
/* loaded from: classes32.dex */
public final /* data */ class PhotoInfo {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final PhotoInfo f62738e = new PhotoInfo(false, null, null, 7, null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean selected;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final LocalMediaInfo info;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private PTFaceAttr detectResult;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\bR \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/gallery/ac$a;", "", "Lcom/tencent/aelight/camera/ae/camera/ui/gallery/ac;", PatternUtils.NO_MATCH, "Lcom/tencent/aelight/camera/ae/camera/ui/gallery/ac;", "a", "()Lcom/tencent/aelight/camera/ae/camera/ui/gallery/ac;", "getEMPTY$annotations", "()V", "<init>", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.aelight.camera.ae.camera.ui.gallery.ac$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PhotoInfo a() {
            return PhotoInfo.f62738e;
        }

        Companion() {
        }
    }

    public PhotoInfo() {
        this(false, null, null, 7, null);
    }

    /* renamed from: b, reason: from getter */
    public final PTFaceAttr getDetectResult() {
        return this.detectResult;
    }

    /* renamed from: c, reason: from getter */
    public final LocalMediaInfo getInfo() {
        return this.info;
    }

    public final boolean d() {
        return this.info == null;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    public final void f(PTFaceAttr pTFaceAttr) {
        this.detectResult = pTFaceAttr;
    }

    public final void g(boolean z16) {
        this.selected = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z16 = this.selected;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        LocalMediaInfo localMediaInfo = this.info;
        int hashCode = (i3 + (localMediaInfo == null ? 0 : localMediaInfo.hashCode())) * 31;
        PTFaceAttr pTFaceAttr = this.detectResult;
        return hashCode + (pTFaceAttr != null ? pTFaceAttr.hashCode() : 0);
    }

    public String toString() {
        return "PhotoInfo(selected=" + this.selected + ", info=" + this.info + ", detectResult=" + this.detectResult + ")";
    }

    public PhotoInfo(boolean z16, LocalMediaInfo localMediaInfo, PTFaceAttr pTFaceAttr) {
        this.selected = z16;
        this.info = localMediaInfo;
        this.detectResult = pTFaceAttr;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PhotoInfo)) {
            return false;
        }
        PhotoInfo photoInfo = (PhotoInfo) other;
        return this.selected == photoInfo.selected && Intrinsics.areEqual(this.info, photoInfo.info) && Intrinsics.areEqual(this.detectResult, photoInfo.detectResult);
    }

    public /* synthetic */ PhotoInfo(boolean z16, LocalMediaInfo localMediaInfo, PTFaceAttr pTFaceAttr, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? null : localMediaInfo, (i3 & 4) != 0 ? null : pTFaceAttr);
    }
}
