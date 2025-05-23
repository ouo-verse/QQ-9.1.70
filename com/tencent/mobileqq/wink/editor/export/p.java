package com.tencent.mobileqq.wink.editor.export;

import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.model.WinkExportParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J \u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/export/p;", "", "", "mediaWidth", "mediaHeight", "", "mediaDuration", "Lcom/tencent/mobileqq/wink/model/WinkExportParams;", "winkExportParams", "Lcom/tencent/mobileqq/wink/editor/export/p$a;", "b", "", "useHD", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "winkEditDataWrapper", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final p f320241a = new p();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\u0007\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/export/p$a;", "", "", "b", "a", "", "toString", "hashCode", "other", "", "equals", "I", "originalVideoLevel", "Z", "canExport4K", "<init>", "(IZ)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.export.p$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class ExportResolutionData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private int originalVideoLevel;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean canExport4K;

        public ExportResolutionData(int i3, boolean z16) {
            this.originalVideoLevel = i3;
            this.canExport4K = z16;
        }

        /* renamed from: a, reason: from getter */
        public final int getOriginalVideoLevel() {
            return this.originalVideoLevel;
        }

        public final int b() {
            if (this.canExport4K) {
                return 500;
            }
            return this.originalVideoLevel;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ExportResolutionData)) {
                return false;
            }
            ExportResolutionData exportResolutionData = (ExportResolutionData) other;
            if (this.originalVideoLevel == exportResolutionData.originalVideoLevel && this.canExport4K == exportResolutionData.canExport4K) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3 = this.originalVideoLevel * 31;
            boolean z16 = this.canExport4K;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            return i3 + i16;
        }

        @NotNull
        public String toString() {
            return "ExportResolutionData(originalVideoLevel=" + this.originalVideoLevel + ", canExport4K=" + this.canExport4K + ")";
        }
    }

    p() {
    }

    @NotNull
    public final ExportResolutionData a(boolean useHD, @Nullable WinkEditDataWrapper winkEditDataWrapper, @NotNull WinkExportParams winkExportParams) {
        Intrinsics.checkNotNullParameter(winkExportParams, "winkExportParams");
        int i3 = 200;
        boolean z16 = false;
        if (winkExportParams.f323989d > 0) {
            if (Intrinsics.areEqual("QCIRCLE", winkExportParams.D)) {
                if (winkExportParams.f323989d == 300 && useHD) {
                    i3 = 300;
                }
                z16 = a.f320174a.c(winkEditDataWrapper);
            } else {
                i3 = winkExportParams.f323989d;
            }
        } else if (useHD) {
            i3 = 300;
        }
        return new ExportResolutionData(i3, z16);
    }

    @NotNull
    public final ExportResolutionData b(int mediaWidth, int mediaHeight, long mediaDuration, @NotNull WinkExportParams winkExportParams) {
        int f16;
        boolean z16;
        Intrinsics.checkNotNullParameter(winkExportParams, "winkExportParams");
        if (Intrinsics.areEqual("QCIRCLE", winkExportParams.D) && WinkExportUtils.I(mediaWidth, mediaHeight)) {
            z16 = a.f320174a.b(mediaWidth, mediaHeight, mediaDuration);
            f16 = 300;
        } else {
            f16 = winkExportParams.f();
            z16 = false;
        }
        return new ExportResolutionData(f16, z16);
    }
}
