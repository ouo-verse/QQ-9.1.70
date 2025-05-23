package com.tencent.mobileqq.wink.editor.openingending;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.utils.GsonUtils;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b0\b\u0086\b\u0018\u0000 Q2\u00020\u0001:\u0001RB\u0099\u0001\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001a\u001a\u00020\t\u0012$\b\u0002\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\f\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u000f\u0012\u0018\b\u0002\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\n\u001a\u00020\tH\u00c6\u0003J%\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\fH\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u000fH\u00c6\u0003J\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013H\u00c6\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003J\u009b\u0001\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0019\u001a\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\t2$\b\u0002\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\f2\b\b\u0002\u0010\u001c\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u000f2\u0018\b\u0002\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00132\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0012H\u00c6\u0001J\t\u0010!\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\"\u001a\u00020\u000fH\u00d6\u0001J\u0013\u0010%\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010#H\u00d6\u0003R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u0010\u0017\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010&\u001a\u0004\b0\u0010(\"\u0004\b1\u0010*R\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010&\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R>\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000bj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010&\u001a\u0004\b>\u0010(\"\u0004\b?\u0010*R\"\u0010\u001d\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR2\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR$\u0010\u001f\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010N\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/OpeningEndingAigcData;", "Ljava/io/Serializable;", "", "toJsonStr", "component1", "", "component2", "component3", "component4", "", "component5", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "component6", "component7", "", "component8", "Ljava/util/ArrayList;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "Lkotlin/collections/ArrayList;", "component9", "component10", "extractedVideoFramePath", "extractedVideoFrameTime", "selectedAlbumImagePath", "imageUploadUrl", "useVideoFrame", "aigcImagePathMap", "safeId", "currentStyleIndex", "styleMaterials", "templateMaterial", "copy", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getExtractedVideoFramePath", "()Ljava/lang/String;", "setExtractedVideoFramePath", "(Ljava/lang/String;)V", "J", "getExtractedVideoFrameTime", "()J", "setExtractedVideoFrameTime", "(J)V", "getSelectedAlbumImagePath", "setSelectedAlbumImagePath", "getImageUploadUrl", "setImageUploadUrl", "Z", "getUseVideoFrame", "()Z", "setUseVideoFrame", "(Z)V", "Ljava/util/HashMap;", "getAigcImagePathMap", "()Ljava/util/HashMap;", "setAigcImagePathMap", "(Ljava/util/HashMap;)V", "getSafeId", "setSafeId", "I", "getCurrentStyleIndex", "()I", "setCurrentStyleIndex", "(I)V", "Ljava/util/ArrayList;", "getStyleMaterials", "()Ljava/util/ArrayList;", "setStyleMaterials", "(Ljava/util/ArrayList;)V", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getTemplateMaterial", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "setTemplateMaterial", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "<init>", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZLjava/util/HashMap;Ljava/lang/String;ILjava/util/ArrayList;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class OpeningEndingAigcData implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private HashMap<String, String> aigcImagePathMap;
    private int currentStyleIndex;

    @NotNull
    private String extractedVideoFramePath;
    private long extractedVideoFrameTime;

    @NotNull
    private String imageUploadUrl;

    @NotNull
    private String safeId;

    @NotNull
    private String selectedAlbumImagePath;

    @NotNull
    private ArrayList<MetaMaterial> styleMaterials;

    @Nullable
    private MetaMaterial templateMaterial;
    private boolean useVideoFrame;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/openingending/OpeningEndingAigcData$a;", "", "", "jsonStr", "Lcom/tencent/mobileqq/wink/editor/openingending/OpeningEndingAigcData;", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.openingending.OpeningEndingAigcData$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final OpeningEndingAigcData a(@Nullable String jsonStr) {
            return (OpeningEndingAigcData) GsonUtils.json2Obj(jsonStr, OpeningEndingAigcData.class);
        }

        Companion() {
        }
    }

    public OpeningEndingAigcData() {
        this(null, 0L, null, null, false, null, null, 0, null, null, 1023, null);
    }

    public static /* synthetic */ OpeningEndingAigcData copy$default(OpeningEndingAigcData openingEndingAigcData, String str, long j3, String str2, String str3, boolean z16, HashMap hashMap, String str4, int i3, ArrayList arrayList, MetaMaterial metaMaterial, int i16, Object obj) {
        String str5;
        long j16;
        String str6;
        String str7;
        boolean z17;
        HashMap hashMap2;
        String str8;
        int i17;
        ArrayList arrayList2;
        MetaMaterial metaMaterial2;
        if ((i16 & 1) != 0) {
            str5 = openingEndingAigcData.extractedVideoFramePath;
        } else {
            str5 = str;
        }
        if ((i16 & 2) != 0) {
            j16 = openingEndingAigcData.extractedVideoFrameTime;
        } else {
            j16 = j3;
        }
        if ((i16 & 4) != 0) {
            str6 = openingEndingAigcData.selectedAlbumImagePath;
        } else {
            str6 = str2;
        }
        if ((i16 & 8) != 0) {
            str7 = openingEndingAigcData.imageUploadUrl;
        } else {
            str7 = str3;
        }
        if ((i16 & 16) != 0) {
            z17 = openingEndingAigcData.useVideoFrame;
        } else {
            z17 = z16;
        }
        if ((i16 & 32) != 0) {
            hashMap2 = openingEndingAigcData.aigcImagePathMap;
        } else {
            hashMap2 = hashMap;
        }
        if ((i16 & 64) != 0) {
            str8 = openingEndingAigcData.safeId;
        } else {
            str8 = str4;
        }
        if ((i16 & 128) != 0) {
            i17 = openingEndingAigcData.currentStyleIndex;
        } else {
            i17 = i3;
        }
        if ((i16 & 256) != 0) {
            arrayList2 = openingEndingAigcData.styleMaterials;
        } else {
            arrayList2 = arrayList;
        }
        if ((i16 & 512) != 0) {
            metaMaterial2 = openingEndingAigcData.templateMaterial;
        } else {
            metaMaterial2 = metaMaterial;
        }
        return openingEndingAigcData.copy(str5, j16, str6, str7, z17, hashMap2, str8, i17, arrayList2, metaMaterial2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getExtractedVideoFramePath() {
        return this.extractedVideoFramePath;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final MetaMaterial getTemplateMaterial() {
        return this.templateMaterial;
    }

    /* renamed from: component2, reason: from getter */
    public final long getExtractedVideoFrameTime() {
        return this.extractedVideoFrameTime;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getSelectedAlbumImagePath() {
        return this.selectedAlbumImagePath;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getImageUploadUrl() {
        return this.imageUploadUrl;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getUseVideoFrame() {
        return this.useVideoFrame;
    }

    @NotNull
    public final HashMap<String, String> component6() {
        return this.aigcImagePathMap;
    }

    @NotNull
    /* renamed from: component7, reason: from getter */
    public final String getSafeId() {
        return this.safeId;
    }

    /* renamed from: component8, reason: from getter */
    public final int getCurrentStyleIndex() {
        return this.currentStyleIndex;
    }

    @NotNull
    public final ArrayList<MetaMaterial> component9() {
        return this.styleMaterials;
    }

    @NotNull
    public final OpeningEndingAigcData copy(@NotNull String extractedVideoFramePath, long extractedVideoFrameTime, @NotNull String selectedAlbumImagePath, @NotNull String imageUploadUrl, boolean useVideoFrame, @NotNull HashMap<String, String> aigcImagePathMap, @NotNull String safeId, int currentStyleIndex, @NotNull ArrayList<MetaMaterial> styleMaterials, @Nullable MetaMaterial templateMaterial) {
        Intrinsics.checkNotNullParameter(extractedVideoFramePath, "extractedVideoFramePath");
        Intrinsics.checkNotNullParameter(selectedAlbumImagePath, "selectedAlbumImagePath");
        Intrinsics.checkNotNullParameter(imageUploadUrl, "imageUploadUrl");
        Intrinsics.checkNotNullParameter(aigcImagePathMap, "aigcImagePathMap");
        Intrinsics.checkNotNullParameter(safeId, "safeId");
        Intrinsics.checkNotNullParameter(styleMaterials, "styleMaterials");
        return new OpeningEndingAigcData(extractedVideoFramePath, extractedVideoFrameTime, selectedAlbumImagePath, imageUploadUrl, useVideoFrame, aigcImagePathMap, safeId, currentStyleIndex, styleMaterials, templateMaterial);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OpeningEndingAigcData)) {
            return false;
        }
        OpeningEndingAigcData openingEndingAigcData = (OpeningEndingAigcData) other;
        if (Intrinsics.areEqual(this.extractedVideoFramePath, openingEndingAigcData.extractedVideoFramePath) && this.extractedVideoFrameTime == openingEndingAigcData.extractedVideoFrameTime && Intrinsics.areEqual(this.selectedAlbumImagePath, openingEndingAigcData.selectedAlbumImagePath) && Intrinsics.areEqual(this.imageUploadUrl, openingEndingAigcData.imageUploadUrl) && this.useVideoFrame == openingEndingAigcData.useVideoFrame && Intrinsics.areEqual(this.aigcImagePathMap, openingEndingAigcData.aigcImagePathMap) && Intrinsics.areEqual(this.safeId, openingEndingAigcData.safeId) && this.currentStyleIndex == openingEndingAigcData.currentStyleIndex && Intrinsics.areEqual(this.styleMaterials, openingEndingAigcData.styleMaterials) && Intrinsics.areEqual(this.templateMaterial, openingEndingAigcData.templateMaterial)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final HashMap<String, String> getAigcImagePathMap() {
        return this.aigcImagePathMap;
    }

    public final int getCurrentStyleIndex() {
        return this.currentStyleIndex;
    }

    @NotNull
    public final String getExtractedVideoFramePath() {
        return this.extractedVideoFramePath;
    }

    public final long getExtractedVideoFrameTime() {
        return this.extractedVideoFrameTime;
    }

    @NotNull
    public final String getImageUploadUrl() {
        return this.imageUploadUrl;
    }

    @NotNull
    public final String getSafeId() {
        return this.safeId;
    }

    @NotNull
    public final String getSelectedAlbumImagePath() {
        return this.selectedAlbumImagePath;
    }

    @NotNull
    public final ArrayList<MetaMaterial> getStyleMaterials() {
        return this.styleMaterials;
    }

    @Nullable
    public final MetaMaterial getTemplateMaterial() {
        return this.templateMaterial;
    }

    public final boolean getUseVideoFrame() {
        return this.useVideoFrame;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((((this.extractedVideoFramePath.hashCode() * 31) + androidx.fragment.app.a.a(this.extractedVideoFrameTime)) * 31) + this.selectedAlbumImagePath.hashCode()) * 31) + this.imageUploadUrl.hashCode()) * 31;
        boolean z16 = this.useVideoFrame;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int hashCode3 = (((((((((hashCode2 + i3) * 31) + this.aigcImagePathMap.hashCode()) * 31) + this.safeId.hashCode()) * 31) + this.currentStyleIndex) * 31) + this.styleMaterials.hashCode()) * 31;
        MetaMaterial metaMaterial = this.templateMaterial;
        if (metaMaterial == null) {
            hashCode = 0;
        } else {
            hashCode = metaMaterial.hashCode();
        }
        return hashCode3 + hashCode;
    }

    public final void setAigcImagePathMap(@NotNull HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.aigcImagePathMap = hashMap;
    }

    public final void setCurrentStyleIndex(int i3) {
        this.currentStyleIndex = i3;
    }

    public final void setExtractedVideoFramePath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extractedVideoFramePath = str;
    }

    public final void setExtractedVideoFrameTime(long j3) {
        this.extractedVideoFrameTime = j3;
    }

    public final void setImageUploadUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.imageUploadUrl = str;
    }

    public final void setSafeId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.safeId = str;
    }

    public final void setSelectedAlbumImagePath(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.selectedAlbumImagePath = str;
    }

    public final void setStyleMaterials(@NotNull ArrayList<MetaMaterial> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.styleMaterials = arrayList;
    }

    public final void setTemplateMaterial(@Nullable MetaMaterial metaMaterial) {
        this.templateMaterial = metaMaterial;
    }

    public final void setUseVideoFrame(boolean z16) {
        this.useVideoFrame = z16;
    }

    @Nullable
    public final String toJsonStr() {
        return GsonUtils.obj2Json(this);
    }

    @NotNull
    public String toString() {
        return "OpeningEndingAigcData(extractedVideoFramePath=" + this.extractedVideoFramePath + ", extractedVideoFrameTime=" + this.extractedVideoFrameTime + ", selectedAlbumImagePath=" + this.selectedAlbumImagePath + ", imageUploadUrl=" + this.imageUploadUrl + ", useVideoFrame=" + this.useVideoFrame + ", aigcImagePathMap=" + this.aigcImagePathMap + ", safeId=" + this.safeId + ", currentStyleIndex=" + this.currentStyleIndex + ", styleMaterials=" + this.styleMaterials + ", templateMaterial=" + this.templateMaterial + ")";
    }

    public OpeningEndingAigcData(@NotNull String extractedVideoFramePath, long j3, @NotNull String selectedAlbumImagePath, @NotNull String imageUploadUrl, boolean z16, @NotNull HashMap<String, String> aigcImagePathMap, @NotNull String safeId, int i3, @NotNull ArrayList<MetaMaterial> styleMaterials, @Nullable MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(extractedVideoFramePath, "extractedVideoFramePath");
        Intrinsics.checkNotNullParameter(selectedAlbumImagePath, "selectedAlbumImagePath");
        Intrinsics.checkNotNullParameter(imageUploadUrl, "imageUploadUrl");
        Intrinsics.checkNotNullParameter(aigcImagePathMap, "aigcImagePathMap");
        Intrinsics.checkNotNullParameter(safeId, "safeId");
        Intrinsics.checkNotNullParameter(styleMaterials, "styleMaterials");
        this.extractedVideoFramePath = extractedVideoFramePath;
        this.extractedVideoFrameTime = j3;
        this.selectedAlbumImagePath = selectedAlbumImagePath;
        this.imageUploadUrl = imageUploadUrl;
        this.useVideoFrame = z16;
        this.aigcImagePathMap = aigcImagePathMap;
        this.safeId = safeId;
        this.currentStyleIndex = i3;
        this.styleMaterials = styleMaterials;
        this.templateMaterial = metaMaterial;
    }

    public /* synthetic */ OpeningEndingAigcData(String str, long j3, String str2, String str3, boolean z16, HashMap hashMap, String str4, int i3, ArrayList arrayList, MetaMaterial metaMaterial, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? 0L : j3, (i16 & 4) != 0 ? "" : str2, (i16 & 8) != 0 ? "" : str3, (i16 & 16) != 0 ? true : z16, (i16 & 32) != 0 ? new HashMap() : hashMap, (i16 & 64) == 0 ? str4 : "", (i16 & 128) != 0 ? 0 : i3, (i16 & 256) != 0 ? new ArrayList() : arrayList, (i16 & 512) != 0 ? null : metaMaterial);
    }
}
