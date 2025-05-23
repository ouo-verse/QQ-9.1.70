package com.tencent.mobileqq.wink.h5native;

import com.tencent.videocut.utils.GsonUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0017\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u00c6\u0003J\u001b\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u00c6\u0001J\t\u0010\b\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001f\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PreloadAiPaintResRequest", "", "", "", "component1", "materialID", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PreloadAiPaintResRequest;", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/List;", "getMaterialID", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "Companion", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$PreloadAiPaintResRequest, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class PreloadAiPaintResRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private final List<String> materialID;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PreloadAiPaintResRequest$Companion;", "", "()V", "fromJsonStr", "Lcom/tencent/mobileqq/wink/h5native/WinkAiPaintNativeModel$PreloadAiPaintResRequest;", "jsonStr", "", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.wink.h5native.WinkAiPaintNativeModel$PreloadAiPaintResRequest$Companion, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final PreloadAiPaintResRequest fromJsonStr(@NotNull String jsonStr) {
            Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
            return (PreloadAiPaintResRequest) GsonUtils.f384219b.a(jsonStr, PreloadAiPaintResRequest.class);
        }

        Companion() {
        }
    }

    public PreloadAiPaintResRequest(@Nullable List<String> list) {
        this.materialID = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PreloadAiPaintResRequest copy$default(PreloadAiPaintResRequest preloadAiPaintResRequest, List list, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = preloadAiPaintResRequest.materialID;
        }
        return preloadAiPaintResRequest.copy(list);
    }

    @Nullable
    public final List<String> component1() {
        return this.materialID;
    }

    @NotNull
    public final PreloadAiPaintResRequest copy(@Nullable List<String> materialID) {
        return new PreloadAiPaintResRequest(materialID);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof PreloadAiPaintResRequest) && Intrinsics.areEqual(this.materialID, ((PreloadAiPaintResRequest) other).materialID)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final List<String> getMaterialID() {
        return this.materialID;
    }

    public int hashCode() {
        List<String> list = this.materialID;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "PreloadAiPaintResRequest(materialID=" + this.materialID + ")";
    }
}
