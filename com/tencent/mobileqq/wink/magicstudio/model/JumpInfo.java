package com.tencent.mobileqq.wink.magicstudio.model;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0017\u0012\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e\u0012\u0006\u0010(\u001a\u00020\u0007\u0012\b\b\u0002\u0010+\u001a\u00020\u0004\u0012\b\b\u0002\u0010-\u001a\u00020\u0007\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010.\u00a2\u0006\u0004\b4\u00105J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u0017\u0010\u001b\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR2\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b\u0014\u0010 \"\u0004\b!\u0010\"R\u0017\u0010(\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010+\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b&\u0010)\u001a\u0004\b\t\u0010*R\u0017\u0010-\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b,\u0010%\u001a\u0004\b$\u0010'R$\u00103\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b\u000f\u00101\"\u0004\b,\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/model/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "prompt", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "b", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "getMaterial", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "c", "getOperationalTopics", "operationalTopics", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgInfo;", "d", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgInfo;", "()Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgInfo;", "imgInfo", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/magicstudio/model/c;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "setGenerateInfos", "(Ljava/util/ArrayList;)V", "generateInfos", "f", "Z", "g", "()Z", "isImgMode", "I", "()I", "aigcCount", tl.h.F, "isCollectionStyle", "Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "i", "Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "()Lcom/tencent/mobileqq/wink/magicstudio/model/e;", "(Lcom/tencent/mobileqq/wink/magicstudio/model/e;)V", "cgiButtonInfo", "<init>", "(Ljava/lang/String;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/lang/String;Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgInfo;Ljava/util/ArrayList;ZIZLcom/tencent/mobileqq/wink/magicstudio/model/e;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.magicstudio.model.d, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class JumpInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String prompt;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MetaMaterial material;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String operationalTopics;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final MagicStudioUploadImgInfo imgInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private ArrayList<GenerateInfo> generateInfos;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isImgMode;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int aigcCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isCollectionStyle;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private MagicStudioButtonInfo cgiButtonInfo;

    public JumpInfo(@NotNull String prompt, @NotNull MetaMaterial material, @Nullable String str, @NotNull MagicStudioUploadImgInfo imgInfo, @NotNull ArrayList<GenerateInfo> generateInfos, boolean z16, int i3, boolean z17, @Nullable MagicStudioButtonInfo magicStudioButtonInfo) {
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(imgInfo, "imgInfo");
        Intrinsics.checkNotNullParameter(generateInfos, "generateInfos");
        this.prompt = prompt;
        this.material = material;
        this.operationalTopics = str;
        this.imgInfo = imgInfo;
        this.generateInfos = generateInfos;
        this.isImgMode = z16;
        this.aigcCount = i3;
        this.isCollectionStyle = z17;
        this.cgiButtonInfo = magicStudioButtonInfo;
    }

    /* renamed from: a, reason: from getter */
    public final int getAigcCount() {
        return this.aigcCount;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final MagicStudioButtonInfo getCgiButtonInfo() {
        return this.cgiButtonInfo;
    }

    @NotNull
    public final ArrayList<GenerateInfo> c() {
        return this.generateInfos;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final MagicStudioUploadImgInfo getImgInfo() {
        return this.imgInfo;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getPrompt() {
        return this.prompt;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JumpInfo)) {
            return false;
        }
        JumpInfo jumpInfo = (JumpInfo) other;
        if (Intrinsics.areEqual(this.prompt, jumpInfo.prompt) && Intrinsics.areEqual(this.material, jumpInfo.material) && Intrinsics.areEqual(this.operationalTopics, jumpInfo.operationalTopics) && Intrinsics.areEqual(this.imgInfo, jumpInfo.imgInfo) && Intrinsics.areEqual(this.generateInfos, jumpInfo.generateInfos) && this.isImgMode == jumpInfo.isImgMode && this.aigcCount == jumpInfo.aigcCount && this.isCollectionStyle == jumpInfo.isCollectionStyle && Intrinsics.areEqual(this.cgiButtonInfo, jumpInfo.cgiButtonInfo)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsCollectionStyle() {
        return this.isCollectionStyle;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getIsImgMode() {
        return this.isImgMode;
    }

    public final void h(@Nullable MagicStudioButtonInfo magicStudioButtonInfo) {
        this.cgiButtonInfo = magicStudioButtonInfo;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.prompt.hashCode() * 31) + this.material.hashCode()) * 31;
        String str = this.operationalTopics;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode3 = (((((hashCode2 + hashCode) * 31) + this.imgInfo.hashCode()) * 31) + this.generateInfos.hashCode()) * 31;
        boolean z16 = this.isImgMode;
        int i16 = 1;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        int i18 = (((hashCode3 + i17) * 31) + this.aigcCount) * 31;
        boolean z17 = this.isCollectionStyle;
        if (!z17) {
            i16 = z17 ? 1 : 0;
        }
        int i19 = (i18 + i16) * 31;
        MagicStudioButtonInfo magicStudioButtonInfo = this.cgiButtonInfo;
        if (magicStudioButtonInfo != null) {
            i3 = magicStudioButtonInfo.hashCode();
        }
        return i19 + i3;
    }

    @NotNull
    public String toString() {
        return "JumpInfo(prompt=" + this.prompt + ", material=" + this.material + ", operationalTopics=" + this.operationalTopics + ", imgInfo=" + this.imgInfo + ", generateInfos=" + this.generateInfos + ", isImgMode=" + this.isImgMode + ", aigcCount=" + this.aigcCount + ", isCollectionStyle=" + this.isCollectionStyle + ", cgiButtonInfo=" + this.cgiButtonInfo + ")";
    }

    public /* synthetic */ JumpInfo(String str, MetaMaterial metaMaterial, String str2, MagicStudioUploadImgInfo magicStudioUploadImgInfo, ArrayList arrayList, boolean z16, int i3, boolean z17, MagicStudioButtonInfo magicStudioButtonInfo, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, metaMaterial, str2, magicStudioUploadImgInfo, arrayList, z16, (i16 & 64) != 0 ? 1 : i3, (i16 & 128) != 0 ? false : z17, (i16 & 256) != 0 ? null : magicStudioButtonInfo);
    }
}
