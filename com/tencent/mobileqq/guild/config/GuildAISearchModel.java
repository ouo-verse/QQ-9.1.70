package com.tencent.mobileqq.guild.config;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0011\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\f\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/config/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "modelType", "b", "d", "modelTitle", "c", "modelDesc", "modelShareInfo", "I", "()I", "modelShowSpeed", "f", "getModelName", "modelName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.config.d, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildAISearchModel {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String modelType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String modelTitle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String modelDesc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String modelShareInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int modelShowSpeed;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String modelName;

    public GuildAISearchModel(@NotNull String modelType, @NotNull String modelTitle, @NotNull String modelDesc, @NotNull String modelShareInfo, int i3, @NotNull String modelName) {
        Intrinsics.checkNotNullParameter(modelType, "modelType");
        Intrinsics.checkNotNullParameter(modelTitle, "modelTitle");
        Intrinsics.checkNotNullParameter(modelDesc, "modelDesc");
        Intrinsics.checkNotNullParameter(modelShareInfo, "modelShareInfo");
        Intrinsics.checkNotNullParameter(modelName, "modelName");
        this.modelType = modelType;
        this.modelTitle = modelTitle;
        this.modelDesc = modelDesc;
        this.modelShareInfo = modelShareInfo;
        this.modelShowSpeed = i3;
        this.modelName = modelName;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getModelDesc() {
        return this.modelDesc;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getModelShareInfo() {
        return this.modelShareInfo;
    }

    /* renamed from: c, reason: from getter */
    public final int getModelShowSpeed() {
        return this.modelShowSpeed;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getModelTitle() {
        return this.modelTitle;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getModelType() {
        return this.modelType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildAISearchModel)) {
            return false;
        }
        GuildAISearchModel guildAISearchModel = (GuildAISearchModel) other;
        if (Intrinsics.areEqual(this.modelType, guildAISearchModel.modelType) && Intrinsics.areEqual(this.modelTitle, guildAISearchModel.modelTitle) && Intrinsics.areEqual(this.modelDesc, guildAISearchModel.modelDesc) && Intrinsics.areEqual(this.modelShareInfo, guildAISearchModel.modelShareInfo) && this.modelShowSpeed == guildAISearchModel.modelShowSpeed && Intrinsics.areEqual(this.modelName, guildAISearchModel.modelName)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.modelType.hashCode() * 31) + this.modelTitle.hashCode()) * 31) + this.modelDesc.hashCode()) * 31) + this.modelShareInfo.hashCode()) * 31) + this.modelShowSpeed) * 31) + this.modelName.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildAISearchModel(modelType=" + this.modelType + ", modelTitle=" + this.modelTitle + ", modelDesc=" + this.modelDesc + ", modelShareInfo=" + this.modelShareInfo + ", modelShowSpeed=" + this.modelShowSpeed + ", modelName=" + this.modelName + ")";
    }

    public /* synthetic */ GuildAISearchModel(String str, String str2, String str3, String str4, int i3, String str5, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i16 & 16) != 0 ? 50 : i3, (i16 & 32) != 0 ? "" : str5);
    }
}
