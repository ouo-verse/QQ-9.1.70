package com.tencent.robot.adelie.homepage.ugc.view;

import d24.UgcAdelieAvatarTemplateData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\t\u0010\u0013R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0015\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/view/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setReferImageUrl", "(Ljava/lang/String;)V", "referImageUrl", "Ld24/l;", "b", "Ld24/l;", "()Ld24/l;", "data", "d", "modelId", "<init>", "(Ljava/lang/String;Ld24/l;Ljava/lang/String;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.robot.adelie.homepage.ugc.view.i, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class AdelieAvatarUgcTemplateMaterial {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String referImageUrl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final UgcAdelieAvatarTemplateData data;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String modelId;

    public AdelieAvatarUgcTemplateMaterial() {
        this(null, null, null, 7, null);
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final UgcAdelieAvatarTemplateData getData() {
        return this.data;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getModelId() {
        return this.modelId;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getReferImageUrl() {
        return this.referImageUrl;
    }

    public final void d(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.modelId = str;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdelieAvatarUgcTemplateMaterial)) {
            return false;
        }
        AdelieAvatarUgcTemplateMaterial adelieAvatarUgcTemplateMaterial = (AdelieAvatarUgcTemplateMaterial) other;
        if (Intrinsics.areEqual(this.referImageUrl, adelieAvatarUgcTemplateMaterial.referImageUrl) && Intrinsics.areEqual(this.data, adelieAvatarUgcTemplateMaterial.data) && Intrinsics.areEqual(this.modelId, adelieAvatarUgcTemplateMaterial.modelId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.referImageUrl.hashCode() * 31;
        UgcAdelieAvatarTemplateData ugcAdelieAvatarTemplateData = this.data;
        if (ugcAdelieAvatarTemplateData == null) {
            hashCode = 0;
        } else {
            hashCode = ugcAdelieAvatarTemplateData.hashCode();
        }
        return ((hashCode2 + hashCode) * 31) + this.modelId.hashCode();
    }

    @NotNull
    public String toString() {
        return "AdelieAvatarUgcTemplateMaterial(referImageUrl=" + this.referImageUrl + ", data=" + this.data + ", modelId=" + this.modelId + ")";
    }

    public AdelieAvatarUgcTemplateMaterial(@NotNull String referImageUrl, @Nullable UgcAdelieAvatarTemplateData ugcAdelieAvatarTemplateData, @NotNull String modelId) {
        Intrinsics.checkNotNullParameter(referImageUrl, "referImageUrl");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        this.referImageUrl = referImageUrl;
        this.data = ugcAdelieAvatarTemplateData;
        this.modelId = modelId;
    }

    public /* synthetic */ AdelieAvatarUgcTemplateMaterial(String str, UgcAdelieAvatarTemplateData ugcAdelieAvatarTemplateData, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? null : ugcAdelieAvatarTemplateData, (i3 & 4) != 0 ? "" : str2);
    }
}
