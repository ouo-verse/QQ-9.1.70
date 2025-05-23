package com.tencent.tavcut.core.render.builder.light.model.pag;

import androidx.fragment.app.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\bH\u00c6\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u00c6\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\r0\nH\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J]\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n2\b\b\u0002\u0010\u000e\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010&\u001a\u00020\u0005H\u00d6\u0001J\t\u0010'\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015\u00a8\u0006("}, d2 = {"Lcom/tencent/tavcut/core/render/builder/light/model/pag/PagEffectData;", "", "filePath", "", "width", "", "height", "durationUs", "", "textLayerList", "", "Lcom/tencent/tavcut/core/render/builder/light/model/pag/TextLayerData;", "imageLayerList", "Lcom/tencent/tavcut/core/render/builder/light/model/pag/ImageLayerData;", "timeStretchMode", "(Ljava/lang/String;IIJLjava/util/List;Ljava/util/List;I)V", "getDurationUs", "()J", "getFilePath", "()Ljava/lang/String;", "getHeight", "()I", "getImageLayerList", "()Ljava/util/List;", "getTextLayerList", "getTimeStretchMode", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "lib_tavcut_debug"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes26.dex */
public final /* data */ class PagEffectData {
    private final long durationUs;

    @Nullable
    private final String filePath;
    private final int height;

    @NotNull
    private final List<ImageLayerData> imageLayerList;

    @NotNull
    private final List<TextLayerData> textLayerList;
    private final int timeStretchMode;
    private final int width;

    public PagEffectData(@Nullable String str, int i3, int i16, long j3, @NotNull List<TextLayerData> textLayerList, @NotNull List<ImageLayerData> imageLayerList, int i17) {
        Intrinsics.checkParameterIsNotNull(textLayerList, "textLayerList");
        Intrinsics.checkParameterIsNotNull(imageLayerList, "imageLayerList");
        this.filePath = str;
        this.width = i3;
        this.height = i16;
        this.durationUs = j3;
        this.textLayerList = textLayerList;
        this.imageLayerList = imageLayerList;
        this.timeStretchMode = i17;
    }

    public static /* synthetic */ PagEffectData copy$default(PagEffectData pagEffectData, String str, int i3, int i16, long j3, List list, List list2, int i17, int i18, Object obj) {
        String str2;
        int i19;
        int i26;
        long j16;
        List list3;
        List list4;
        int i27;
        if ((i18 & 1) != 0) {
            str2 = pagEffectData.filePath;
        } else {
            str2 = str;
        }
        if ((i18 & 2) != 0) {
            i19 = pagEffectData.width;
        } else {
            i19 = i3;
        }
        if ((i18 & 4) != 0) {
            i26 = pagEffectData.height;
        } else {
            i26 = i16;
        }
        if ((i18 & 8) != 0) {
            j16 = pagEffectData.durationUs;
        } else {
            j16 = j3;
        }
        if ((i18 & 16) != 0) {
            list3 = pagEffectData.textLayerList;
        } else {
            list3 = list;
        }
        if ((i18 & 32) != 0) {
            list4 = pagEffectData.imageLayerList;
        } else {
            list4 = list2;
        }
        if ((i18 & 64) != 0) {
            i27 = pagEffectData.timeStretchMode;
        } else {
            i27 = i17;
        }
        return pagEffectData.copy(str2, i19, i26, j16, list3, list4, i27);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    /* renamed from: component2, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component4, reason: from getter */
    public final long getDurationUs() {
        return this.durationUs;
    }

    @NotNull
    public final List<TextLayerData> component5() {
        return this.textLayerList;
    }

    @NotNull
    public final List<ImageLayerData> component6() {
        return this.imageLayerList;
    }

    /* renamed from: component7, reason: from getter */
    public final int getTimeStretchMode() {
        return this.timeStretchMode;
    }

    @NotNull
    public final PagEffectData copy(@Nullable String filePath, int width, int height, long durationUs, @NotNull List<TextLayerData> textLayerList, @NotNull List<ImageLayerData> imageLayerList, int timeStretchMode) {
        Intrinsics.checkParameterIsNotNull(textLayerList, "textLayerList");
        Intrinsics.checkParameterIsNotNull(imageLayerList, "imageLayerList");
        return new PagEffectData(filePath, width, height, durationUs, textLayerList, imageLayerList, timeStretchMode);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof PagEffectData) {
                PagEffectData pagEffectData = (PagEffectData) other;
                if (!Intrinsics.areEqual(this.filePath, pagEffectData.filePath) || this.width != pagEffectData.width || this.height != pagEffectData.height || this.durationUs != pagEffectData.durationUs || !Intrinsics.areEqual(this.textLayerList, pagEffectData.textLayerList) || !Intrinsics.areEqual(this.imageLayerList, pagEffectData.imageLayerList) || this.timeStretchMode != pagEffectData.timeStretchMode) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final long getDurationUs() {
        return this.durationUs;
    }

    @Nullable
    public final String getFilePath() {
        return this.filePath;
    }

    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final List<ImageLayerData> getImageLayerList() {
        return this.imageLayerList;
    }

    @NotNull
    public final List<TextLayerData> getTextLayerList() {
        return this.textLayerList;
    }

    public final int getTimeStretchMode() {
        return this.timeStretchMode;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i3;
        int i16;
        String str = this.filePath;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int a16 = ((((((i3 * 31) + this.width) * 31) + this.height) * 31) + a.a(this.durationUs)) * 31;
        List<TextLayerData> list = this.textLayerList;
        if (list != null) {
            i16 = list.hashCode();
        } else {
            i16 = 0;
        }
        int i18 = (a16 + i16) * 31;
        List<ImageLayerData> list2 = this.imageLayerList;
        if (list2 != null) {
            i17 = list2.hashCode();
        }
        return ((i18 + i17) * 31) + this.timeStretchMode;
    }

    @NotNull
    public String toString() {
        return "PagEffectData(filePath=" + this.filePath + ", width=" + this.width + ", height=" + this.height + ", durationUs=" + this.durationUs + ", textLayerList=" + this.textLayerList + ", imageLayerList=" + this.imageLayerList + ", timeStretchMode=" + this.timeStretchMode + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PagEffectData(String str, int i3, int i16, long j3, List list, List list2, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(r2, i3, i16, j3, r7, r8, i17);
        List list3;
        List list4;
        List emptyList;
        List emptyList2;
        String str2 = (i18 & 1) != 0 ? null : str;
        if ((i18 & 16) != 0) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            list3 = emptyList2;
        } else {
            list3 = list;
        }
        if ((i18 & 32) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list4 = emptyList;
        } else {
            list4 = list2;
        }
    }
}
