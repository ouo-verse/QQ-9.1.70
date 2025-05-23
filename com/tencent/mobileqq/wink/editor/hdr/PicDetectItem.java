package com.tencent.mobileqq.wink.editor.hdr;

import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.export.u;
import com.tencent.mobileqq.wink.editor.hdr.WinkHDRPicQualityDetectUtils;
import com.tencent.videocut.model.MediaClip;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010#\u001a\u00020\u0007\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR\"\u0010#\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001f\u001a\u0004\b\n\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/hdr/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/wink/editor/export/u;", "a", "Lcom/tencent/mobileqq/wink/editor/export/u;", "e", "()Lcom/tencent/mobileqq/wink/editor/export/u;", "winkExportViewModel", "", "Lcom/tencent/videocut/model/MediaClip;", "b", "Ljava/util/List;", "()Ljava/util/List;", "mediaClipList", "Lcom/tencent/mobileqq/wink/editor/hdr/WinkHDRPicQualityDetectUtils$a;", "c", "Lcom/tencent/mobileqq/wink/editor/hdr/WinkHDRPicQualityDetectUtils$a;", "()Lcom/tencent/mobileqq/wink/editor/hdr/WinkHDRPicQualityDetectUtils$a;", "picDetectListener", "Lcom/tencent/mobileqq/wink/editor/dr;", "d", "Lcom/tencent/mobileqq/wink/editor/dr;", "()Lcom/tencent/mobileqq/wink/editor/dr;", "videoTavCut", "Z", "()Z", "f", "(Z)V", "canceled", "<init>", "(Lcom/tencent/mobileqq/wink/editor/export/u;Ljava/util/List;Lcom/tencent/mobileqq/wink/editor/hdr/WinkHDRPicQualityDetectUtils$a;Lcom/tencent/mobileqq/wink/editor/dr;Z)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.editor.hdr.c, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class PicDetectItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final u winkExportViewModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<MediaClip> mediaClipList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final WinkHDRPicQualityDetectUtils.a picDetectListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final dr videoTavCut;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean canceled;

    /* JADX WARN: Multi-variable type inference failed */
    public PicDetectItem(@NotNull u winkExportViewModel, @Nullable List<? extends MediaClip> list, @NotNull WinkHDRPicQualityDetectUtils.a picDetectListener, @Nullable dr drVar, boolean z16) {
        Intrinsics.checkNotNullParameter(winkExportViewModel, "winkExportViewModel");
        Intrinsics.checkNotNullParameter(picDetectListener, "picDetectListener");
        this.winkExportViewModel = winkExportViewModel;
        this.mediaClipList = list;
        this.picDetectListener = picDetectListener;
        this.videoTavCut = drVar;
        this.canceled = z16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getCanceled() {
        return this.canceled;
    }

    @Nullable
    public final List<MediaClip> b() {
        return this.mediaClipList;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final WinkHDRPicQualityDetectUtils.a getPicDetectListener() {
        return this.picDetectListener;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final dr getVideoTavCut() {
        return this.videoTavCut;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final u getWinkExportViewModel() {
        return this.winkExportViewModel;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PicDetectItem)) {
            return false;
        }
        PicDetectItem picDetectItem = (PicDetectItem) other;
        if (Intrinsics.areEqual(this.winkExportViewModel, picDetectItem.winkExportViewModel) && Intrinsics.areEqual(this.mediaClipList, picDetectItem.mediaClipList) && Intrinsics.areEqual(this.picDetectListener, picDetectItem.picDetectListener) && Intrinsics.areEqual(this.videoTavCut, picDetectItem.videoTavCut) && this.canceled == picDetectItem.canceled) {
            return true;
        }
        return false;
    }

    public final void f(boolean z16) {
        this.canceled = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = this.winkExportViewModel.hashCode() * 31;
        List<MediaClip> list = this.mediaClipList;
        int i3 = 0;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        int hashCode3 = (((hashCode2 + hashCode) * 31) + this.picDetectListener.hashCode()) * 31;
        dr drVar = this.videoTavCut;
        if (drVar != null) {
            i3 = drVar.hashCode();
        }
        int i16 = (hashCode3 + i3) * 31;
        boolean z16 = this.canceled;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        return i16 + i17;
    }

    @NotNull
    public String toString() {
        return "PicDetectItem(winkExportViewModel=" + this.winkExportViewModel + ", mediaClipList=" + this.mediaClipList + ", picDetectListener=" + this.picDetectListener + ", videoTavCut=" + this.videoTavCut + ", canceled=" + this.canceled + ")";
    }

    public /* synthetic */ PicDetectItem(u uVar, List list, WinkHDRPicQualityDetectUtils.a aVar, dr drVar, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(uVar, list, aVar, (i3 & 8) != 0 ? null : drVar, (i3 & 16) != 0 ? false : z16);
    }
}
