package com.tencent.filament.zplan.avatar.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.filament.zplan.avatar.AvatarCheckResult;
import com.tencent.filament.zplan.avatar.FAssetChecker;
import com.tencent.filament.zplanservice.feature.model.FilamentUrlTemplate;
import com.tencent.filament.zplanservice.util.log.FLog;
import com.tencent.filament.zplanservice.verify.ResourceCheckAlgorithmSelect;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.zplan.common.utils.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Parcelize
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u0010\u001a\u00020\u0002J7\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00112\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0011H\u00c6\u0001J\t\u0010\u0017\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0018H\u00d6\u0001J\u0013\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0018H\u00d6\u0001J\u0019\u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0018H\u00d6\u0001R\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010$\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010-\u001a\u0004\b.\u0010/R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b0\u0010-\u001a\u0004\b1\u0010/R\u0017\u0010\u0014\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u0010/R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b4\u0010-\u001a\u0004\b4\u0010/\u00a8\u00067"}, d2 = {"Lcom/tencent/filament/zplan/avatar/model/BootResourceModel;", "Landroid/os/Parcelable;", "", ReportConstant.COSTREPORT_PREFIX, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "Lcom/tencent/filament/zplanservice/feature/model/FilamentUrlTemplate;", "urlTemplate", "Lcom/tencent/filament/zplanservice/verify/ResourceCheckAlgorithmSelect;", "algorithmSelect", "Lcom/tencent/filament/zplan/avatar/AvatarCheckResult;", "c", "b", "e", "a", "t", "", "shaderDir", "indirectLightPath", "kawaiiPath", "lutTexturePath", "f", "toString", "", "hashCode", "", "other", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", WadlProxyConsts.FLAGS, "", "writeToParcel", "d", "Z", "j", "()Z", "u", "(Z)V", "downloadFromNet", "o", "v", "useCache", "Ljava/lang/String;", DomainData.DOMAIN_NAME, "()Ljava/lang/String;", h.F, "k", "i", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "zplan-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final /* data */ class BootResourceModel implements Parcelable {
    public static final Parcelable.Creator<BootResourceModel> CREATOR = new a();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean downloadFromNet;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean useCache;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String shaderDir;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String indirectLightPath;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String kawaiiPath;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String lutTexturePath;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static class a implements Parcelable.Creator<BootResourceModel> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BootResourceModel createFromParcel(@NotNull Parcel in5) {
            Intrinsics.checkNotNullParameter(in5, "in");
            return new BootResourceModel(in5.readString(), in5.readString(), in5.readString(), in5.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final BootResourceModel[] newArray(int i3) {
            return new BootResourceModel[i3];
        }
    }

    public BootResourceModel(@Nullable String str, @Nullable String str2, @NotNull String kawaiiPath, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(kawaiiPath, "kawaiiPath");
        this.shaderDir = str;
        this.indirectLightPath = str2;
        this.kawaiiPath = kawaiiPath;
        this.lutTexturePath = str3;
    }

    private final AvatarCheckResult b(FilamentUrlTemplate urlTemplate, ResourceCheckAlgorithmSelect algorithmSelect) {
        return FAssetChecker.f105632b.a(urlTemplate.getKawaiiConfig(), urlTemplate, algorithmSelect);
    }

    private final AvatarCheckResult c(FilamentUrlTemplate urlTemplate, ResourceCheckAlgorithmSelect algorithmSelect) {
        return FAssetChecker.f105632b.a(urlTemplate.getLightResUrl(), urlTemplate, algorithmSelect);
    }

    private final AvatarCheckResult e(FilamentUrlTemplate urlTemplate, ResourceCheckAlgorithmSelect algorithmSelect) {
        return FAssetChecker.f105632b.a(urlTemplate.getLutResUrl(), urlTemplate, algorithmSelect);
    }

    public static /* synthetic */ BootResourceModel g(BootResourceModel bootResourceModel, String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = bootResourceModel.shaderDir;
        }
        if ((i3 & 2) != 0) {
            str2 = bootResourceModel.indirectLightPath;
        }
        if ((i3 & 4) != 0) {
            str3 = bootResourceModel.kawaiiPath;
        }
        if ((i3 & 8) != 0) {
            str4 = bootResourceModel.lutTexturePath;
        }
        return bootResourceModel.f(str, str2, str3, str4);
    }

    private final boolean p() {
        if (!TextUtils.isEmpty(this.indirectLightPath) && !c.f385288a.h(this.indirectLightPath)) {
            return false;
        }
        return true;
    }

    private final boolean q() {
        if (!TextUtils.isEmpty(this.kawaiiPath) && !c.f385288a.h(this.kawaiiPath)) {
            return false;
        }
        return true;
    }

    private final boolean r() {
        if (!TextUtils.isEmpty(this.lutTexturePath) && !c.f385288a.h(this.lutTexturePath)) {
            return false;
        }
        return true;
    }

    private final boolean s() {
        if (!TextUtils.isEmpty(this.shaderDir) && !c.f385288a.h(this.shaderDir)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final AvatarCheckResult a(@NotNull FilamentUrlTemplate urlTemplate, @NotNull ResourceCheckAlgorithmSelect algorithmSelect) {
        Intrinsics.checkNotNullParameter(urlTemplate, "urlTemplate");
        Intrinsics.checkNotNullParameter(algorithmSelect, "algorithmSelect");
        return c(urlTemplate, algorithmSelect).c(b(urlTemplate, algorithmSelect)).c(e(urlTemplate, algorithmSelect));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof BootResourceModel) {
                BootResourceModel bootResourceModel = (BootResourceModel) other;
                if (!Intrinsics.areEqual(this.shaderDir, bootResourceModel.shaderDir) || !Intrinsics.areEqual(this.indirectLightPath, bootResourceModel.indirectLightPath) || !Intrinsics.areEqual(this.kawaiiPath, bootResourceModel.kawaiiPath) || !Intrinsics.areEqual(this.lutTexturePath, bootResourceModel.lutTexturePath)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final BootResourceModel f(@Nullable String shaderDir, @Nullable String indirectLightPath, @NotNull String kawaiiPath, @Nullable String lutTexturePath) {
        Intrinsics.checkNotNullParameter(kawaiiPath, "kawaiiPath");
        return new BootResourceModel(shaderDir, indirectLightPath, kawaiiPath, lutTexturePath);
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        String str = this.shaderDir;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        String str2 = this.indirectLightPath;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        String str3 = this.kawaiiPath;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        String str4 = this.lutTexturePath;
        if (str4 != null) {
            i18 = str4.hashCode();
        }
        return i27 + i18;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getDownloadFromNet() {
        return this.downloadFromNet;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final String getIndirectLightPath() {
        return this.indirectLightPath;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getKawaiiPath() {
        return this.kawaiiPath;
    }

    @Nullable
    /* renamed from: m, reason: from getter */
    public final String getLutTexturePath() {
        return this.lutTexturePath;
    }

    @Nullable
    /* renamed from: n, reason: from getter */
    public final String getShaderDir() {
        return this.shaderDir;
    }

    /* renamed from: o, reason: from getter */
    public final boolean getUseCache() {
        return this.useCache;
    }

    public final boolean t() {
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        if (s() && p() && q() && r()) {
            z16 = true;
        } else {
            z16 = false;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        FLog.INSTANCE.i("BootResourceModel", "BootResourceModel check isValid=" + z16 + ", cost=" + currentTimeMillis2);
        return z16;
    }

    @NotNull
    public String toString() {
        return "BootResourceModel(shaderDir=" + this.shaderDir + ", indirectLightPath=" + this.indirectLightPath + ", kawaiiPath=" + this.kawaiiPath + ", lutTexturePath=" + this.lutTexturePath + ")";
    }

    public final void u(boolean z16) {
        this.downloadFromNet = z16;
    }

    public final void v(boolean z16) {
        this.useCache = z16;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.shaderDir);
        parcel.writeString(this.indirectLightPath);
        parcel.writeString(this.kawaiiPath);
        parcel.writeString(this.lutTexturePath);
    }
}
