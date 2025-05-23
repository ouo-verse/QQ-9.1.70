package com.tencent.mobileqq.wink.magicstudio.model;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.aigc.bean.MediaType;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b*\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u00a2\u0006\u0004\b6\u00107Jo\u0010\u0011\u001a\u00020\u00002\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\u00c6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R#\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\n\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001a\u001a\u0004\b(\u0010\u001cR\"\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u001a\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001eR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010,\u001a\u0004\b)\u0010-\"\u0004\b.\u0010/R\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010\u0010\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00100\u001a\u0004\b$\u00102\"\u0004\b5\u00104\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/model/c;", "", "", "", "infoMap", "aigcImgPath", "", "isSelected", "Lcom/tencent/mobileqq/wink/magicstudio/model/State;", "state", "qrCodeImgPath", "croppedImgPath", "Lorg/light/aigc/bean/MediaType;", "mediaType", "", "width", "height", "a", "toString", "hashCode", "other", "equals", "Ljava/util/Map;", "e", "()Ljava/util/Map;", "b", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setAigcImgPath", "(Ljava/lang/String;)V", "Z", "j", "()Z", "k", "(Z)V", "d", "Lcom/tencent/mobileqq/wink/magicstudio/model/State;", tl.h.F, "()Lcom/tencent/mobileqq/wink/magicstudio/model/State;", "g", "f", "getCroppedImgPath", "setCroppedImgPath", "Lorg/light/aigc/bean/MediaType;", "()Lorg/light/aigc/bean/MediaType;", "setMediaType", "(Lorg/light/aigc/bean/MediaType;)V", "I", "i", "()I", "setWidth", "(I)V", "setHeight", "<init>", "(Ljava/util/Map;Ljava/lang/String;ZLcom/tencent/mobileqq/wink/magicstudio/model/State;Ljava/lang/String;Ljava/lang/String;Lorg/light/aigc/bean/MediaType;II)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.magicstudio.model.c, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class GenerateInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Map<String, String> infoMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private volatile String aigcImgPath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isSelected;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final State state;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String qrCodeImgPath;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String croppedImgPath;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private MediaType mediaType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private int width;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private int height;

    public GenerateInfo(@NotNull Map<String, String> infoMap, @NotNull String aigcImgPath, boolean z16, @NotNull State state, @NotNull String qrCodeImgPath, @NotNull String croppedImgPath, @NotNull MediaType mediaType, int i3, int i16) {
        Intrinsics.checkNotNullParameter(infoMap, "infoMap");
        Intrinsics.checkNotNullParameter(aigcImgPath, "aigcImgPath");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(qrCodeImgPath, "qrCodeImgPath");
        Intrinsics.checkNotNullParameter(croppedImgPath, "croppedImgPath");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        this.infoMap = infoMap;
        this.aigcImgPath = aigcImgPath;
        this.isSelected = z16;
        this.state = state;
        this.qrCodeImgPath = qrCodeImgPath;
        this.croppedImgPath = croppedImgPath;
        this.mediaType = mediaType;
        this.width = i3;
        this.height = i16;
    }

    public static /* synthetic */ GenerateInfo b(GenerateInfo generateInfo, Map map, String str, boolean z16, State state, String str2, String str3, MediaType mediaType, int i3, int i16, int i17, Object obj) {
        Map map2;
        String str4;
        boolean z17;
        State state2;
        String str5;
        String str6;
        MediaType mediaType2;
        int i18;
        int i19;
        if ((i17 & 1) != 0) {
            map2 = generateInfo.infoMap;
        } else {
            map2 = map;
        }
        if ((i17 & 2) != 0) {
            str4 = generateInfo.aigcImgPath;
        } else {
            str4 = str;
        }
        if ((i17 & 4) != 0) {
            z17 = generateInfo.isSelected;
        } else {
            z17 = z16;
        }
        if ((i17 & 8) != 0) {
            state2 = generateInfo.state;
        } else {
            state2 = state;
        }
        if ((i17 & 16) != 0) {
            str5 = generateInfo.qrCodeImgPath;
        } else {
            str5 = str2;
        }
        if ((i17 & 32) != 0) {
            str6 = generateInfo.croppedImgPath;
        } else {
            str6 = str3;
        }
        if ((i17 & 64) != 0) {
            mediaType2 = generateInfo.mediaType;
        } else {
            mediaType2 = mediaType;
        }
        if ((i17 & 128) != 0) {
            i18 = generateInfo.width;
        } else {
            i18 = i3;
        }
        if ((i17 & 256) != 0) {
            i19 = generateInfo.height;
        } else {
            i19 = i16;
        }
        return generateInfo.a(map2, str4, z17, state2, str5, str6, mediaType2, i18, i19);
    }

    @NotNull
    public final GenerateInfo a(@NotNull Map<String, String> infoMap, @NotNull String aigcImgPath, boolean isSelected, @NotNull State state, @NotNull String qrCodeImgPath, @NotNull String croppedImgPath, @NotNull MediaType mediaType, int width, int height) {
        Intrinsics.checkNotNullParameter(infoMap, "infoMap");
        Intrinsics.checkNotNullParameter(aigcImgPath, "aigcImgPath");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(qrCodeImgPath, "qrCodeImgPath");
        Intrinsics.checkNotNullParameter(croppedImgPath, "croppedImgPath");
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        return new GenerateInfo(infoMap, aigcImgPath, isSelected, state, qrCodeImgPath, croppedImgPath, mediaType, width, height);
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getAigcImgPath() {
        return this.aigcImgPath;
    }

    /* renamed from: d, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    @NotNull
    public final Map<String, String> e() {
        return this.infoMap;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GenerateInfo)) {
            return false;
        }
        GenerateInfo generateInfo = (GenerateInfo) other;
        if (Intrinsics.areEqual(this.infoMap, generateInfo.infoMap) && Intrinsics.areEqual(this.aigcImgPath, generateInfo.aigcImgPath) && this.isSelected == generateInfo.isSelected && this.state == generateInfo.state && Intrinsics.areEqual(this.qrCodeImgPath, generateInfo.qrCodeImgPath) && Intrinsics.areEqual(this.croppedImgPath, generateInfo.croppedImgPath) && this.mediaType == generateInfo.mediaType && this.width == generateInfo.width && this.height == generateInfo.height) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final MediaType getMediaType() {
        return this.mediaType;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getQrCodeImgPath() {
        return this.qrCodeImgPath;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final State getState() {
        return this.state;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.infoMap.hashCode() * 31) + this.aigcImgPath.hashCode()) * 31;
        boolean z16 = this.isSelected;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((((((((((hashCode + i3) * 31) + this.state.hashCode()) * 31) + this.qrCodeImgPath.hashCode()) * 31) + this.croppedImgPath.hashCode()) * 31) + this.mediaType.hashCode()) * 31) + this.width) * 31) + this.height;
    }

    /* renamed from: i, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final void k(boolean z16) {
        this.isSelected = z16;
    }

    @NotNull
    public String toString() {
        return "GenerateInfo(infoMap=" + this.infoMap + ", aigcImgPath=" + this.aigcImgPath + ", isSelected=" + this.isSelected + ", state=" + this.state + ", qrCodeImgPath=" + this.qrCodeImgPath + ", croppedImgPath=" + this.croppedImgPath + ", mediaType=" + this.mediaType + ", width=" + this.width + ", height=" + this.height + ")";
    }

    public /* synthetic */ GenerateInfo(Map map, String str, boolean z16, State state, String str2, String str3, MediaType mediaType, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, (i17 & 2) != 0 ? "" : str, (i17 & 4) != 0 ? true : z16, (i17 & 8) != 0 ? State.Loading : state, (i17 & 16) != 0 ? "" : str2, (i17 & 32) == 0 ? str3 : "", (i17 & 64) != 0 ? MediaType.TypeImage : mediaType, (i17 & 128) != 0 ? 0 : i3, (i17 & 256) == 0 ? i16 : 0);
    }
}
