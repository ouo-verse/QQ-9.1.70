package com.tencent.mobileqq.profilecard.vas;

import androidx.fragment.app.a;
import com.tencent.mobileqq.profilecard.template.ProfileCardTemplate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\bH\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\t\u0010\u001e\u001a\u00020\fH\u00c6\u0003JI\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020$H\u00d6\u0001J\t\u0010%\u001a\u00020&H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/profilecard/vas/VasProfileData;", "", "mCurUseStyleId", "", "mCurUseTemplateVersion", "currentTemplate", "Lcom/tencent/mobileqq/profilecard/template/ProfileCardTemplate;", "cardData", "Lcom/tencent/mobileqq/profilecard/vas/VasCardData;", "diyData", "Lcom/tencent/mobileqq/profilecard/vas/VasDiyData;", "diyTextData", "Lcom/tencent/mobileqq/profilecard/vas/VasDiyTextData;", "(JJLcom/tencent/mobileqq/profilecard/template/ProfileCardTemplate;Lcom/tencent/mobileqq/profilecard/vas/VasCardData;Lcom/tencent/mobileqq/profilecard/vas/VasDiyData;Lcom/tencent/mobileqq/profilecard/vas/VasDiyTextData;)V", "getCardData", "()Lcom/tencent/mobileqq/profilecard/vas/VasCardData;", "getCurrentTemplate", "()Lcom/tencent/mobileqq/profilecard/template/ProfileCardTemplate;", "getDiyData", "()Lcom/tencent/mobileqq/profilecard/vas/VasDiyData;", "getDiyTextData", "()Lcom/tencent/mobileqq/profilecard/vas/VasDiyTextData;", "getMCurUseStyleId", "()J", "getMCurUseTemplateVersion", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final /* data */ class VasProfileData {

    @NotNull
    private final VasCardData cardData;

    @Nullable
    private final ProfileCardTemplate currentTemplate;

    @Nullable
    private final VasDiyData diyData;

    @NotNull
    private final VasDiyTextData diyTextData;
    private final long mCurUseStyleId;
    private final long mCurUseTemplateVersion;

    public VasProfileData() {
        this(0L, 0L, null, null, null, null, 63, null);
    }

    public static /* synthetic */ VasProfileData copy$default(VasProfileData vasProfileData, long j3, long j16, ProfileCardTemplate profileCardTemplate, VasCardData vasCardData, VasDiyData vasDiyData, VasDiyTextData vasDiyTextData, int i3, Object obj) {
        long j17;
        long j18;
        ProfileCardTemplate profileCardTemplate2;
        VasCardData vasCardData2;
        VasDiyData vasDiyData2;
        VasDiyTextData vasDiyTextData2;
        if ((i3 & 1) != 0) {
            j17 = vasProfileData.mCurUseStyleId;
        } else {
            j17 = j3;
        }
        if ((i3 & 2) != 0) {
            j18 = vasProfileData.mCurUseTemplateVersion;
        } else {
            j18 = j16;
        }
        if ((i3 & 4) != 0) {
            profileCardTemplate2 = vasProfileData.currentTemplate;
        } else {
            profileCardTemplate2 = profileCardTemplate;
        }
        if ((i3 & 8) != 0) {
            vasCardData2 = vasProfileData.cardData;
        } else {
            vasCardData2 = vasCardData;
        }
        if ((i3 & 16) != 0) {
            vasDiyData2 = vasProfileData.diyData;
        } else {
            vasDiyData2 = vasDiyData;
        }
        if ((i3 & 32) != 0) {
            vasDiyTextData2 = vasProfileData.diyTextData;
        } else {
            vasDiyTextData2 = vasDiyTextData;
        }
        return vasProfileData.copy(j17, j18, profileCardTemplate2, vasCardData2, vasDiyData2, vasDiyTextData2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getMCurUseStyleId() {
        return this.mCurUseStyleId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getMCurUseTemplateVersion() {
        return this.mCurUseTemplateVersion;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final ProfileCardTemplate getCurrentTemplate() {
        return this.currentTemplate;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final VasCardData getCardData() {
        return this.cardData;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final VasDiyData getDiyData() {
        return this.diyData;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final VasDiyTextData getDiyTextData() {
        return this.diyTextData;
    }

    @NotNull
    public final VasProfileData copy(long mCurUseStyleId, long mCurUseTemplateVersion, @Nullable ProfileCardTemplate currentTemplate, @NotNull VasCardData cardData, @Nullable VasDiyData diyData, @NotNull VasDiyTextData diyTextData) {
        Intrinsics.checkNotNullParameter(cardData, "cardData");
        Intrinsics.checkNotNullParameter(diyTextData, "diyTextData");
        return new VasProfileData(mCurUseStyleId, mCurUseTemplateVersion, currentTemplate, cardData, diyData, diyTextData);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VasProfileData)) {
            return false;
        }
        VasProfileData vasProfileData = (VasProfileData) other;
        if (this.mCurUseStyleId == vasProfileData.mCurUseStyleId && this.mCurUseTemplateVersion == vasProfileData.mCurUseTemplateVersion && Intrinsics.areEqual(this.currentTemplate, vasProfileData.currentTemplate) && Intrinsics.areEqual(this.cardData, vasProfileData.cardData) && Intrinsics.areEqual(this.diyData, vasProfileData.diyData) && Intrinsics.areEqual(this.diyTextData, vasProfileData.diyTextData)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final VasCardData getCardData() {
        return this.cardData;
    }

    @Nullable
    public final ProfileCardTemplate getCurrentTemplate() {
        return this.currentTemplate;
    }

    @Nullable
    public final VasDiyData getDiyData() {
        return this.diyData;
    }

    @NotNull
    public final VasDiyTextData getDiyTextData() {
        return this.diyTextData;
    }

    public final long getMCurUseStyleId() {
        return this.mCurUseStyleId;
    }

    public final long getMCurUseTemplateVersion() {
        return this.mCurUseTemplateVersion;
    }

    public int hashCode() {
        int hashCode;
        int a16 = ((a.a(this.mCurUseStyleId) * 31) + a.a(this.mCurUseTemplateVersion)) * 31;
        ProfileCardTemplate profileCardTemplate = this.currentTemplate;
        int i3 = 0;
        if (profileCardTemplate == null) {
            hashCode = 0;
        } else {
            hashCode = profileCardTemplate.hashCode();
        }
        int hashCode2 = (((a16 + hashCode) * 31) + this.cardData.hashCode()) * 31;
        VasDiyData vasDiyData = this.diyData;
        if (vasDiyData != null) {
            i3 = vasDiyData.hashCode();
        }
        return ((hashCode2 + i3) * 31) + this.diyTextData.hashCode();
    }

    @NotNull
    public String toString() {
        return "VasProfileData(mCurUseStyleId=" + this.mCurUseStyleId + ", mCurUseTemplateVersion=" + this.mCurUseTemplateVersion + ", currentTemplate=" + this.currentTemplate + ", cardData=" + this.cardData + ", diyData=" + this.diyData + ", diyTextData=" + this.diyTextData + ")";
    }

    public VasProfileData(long j3, long j16, @Nullable ProfileCardTemplate profileCardTemplate, @NotNull VasCardData cardData, @Nullable VasDiyData vasDiyData, @NotNull VasDiyTextData diyTextData) {
        Intrinsics.checkNotNullParameter(cardData, "cardData");
        Intrinsics.checkNotNullParameter(diyTextData, "diyTextData");
        this.mCurUseStyleId = j3;
        this.mCurUseTemplateVersion = j16;
        this.currentTemplate = profileCardTemplate;
        this.cardData = cardData;
        this.diyData = vasDiyData;
        this.diyTextData = diyTextData;
    }

    public /* synthetic */ VasProfileData(long j3, long j16, ProfileCardTemplate profileCardTemplate, VasCardData vasCardData, VasDiyData vasDiyData, VasDiyTextData vasDiyTextData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) == 0 ? j16 : 0L, (i3 & 4) != 0 ? null : profileCardTemplate, (i3 & 8) != 0 ? new VasCardData(0L, 0L, null, 0L, 0, null, null, null, null, null, null, null, 4095, null) : vasCardData, (i3 & 16) == 0 ? vasDiyData : null, (i3 & 32) != 0 ? new VasDiyTextData(null, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, 1023, null) : vasDiyTextData);
    }
}
