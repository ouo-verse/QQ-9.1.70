package com.tencent.mobileqq.qqguildsdk.data;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0016\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0013\u0010\fR+\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00168\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\t\u0010\u0018R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u001a\u0010\fR\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/av;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "isProhibitRedEnvelope", "b", "c", "isProhibitLink", "d", "isProhibitQrCode", "g", "isProhibiteAdvertise", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "prohibiteWords", "f", "isProhibitSuspectedRiskFeed", "isProhibitDatingFeed", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/ArrayList;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqguildsdk.data.av, reason: from toString */
/* loaded from: classes17.dex */
public final /* data */ class GProGuildSpeakRuleData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Boolean isProhibitRedEnvelope;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Boolean isProhibitLink;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Boolean isProhibitQrCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Boolean isProhibiteAdvertise;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final ArrayList<String> prohibiteWords;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Boolean isProhibitSuspectedRiskFeed;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Boolean isProhibitDatingFeed;

    public GProGuildSpeakRuleData(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable ArrayList<String> arrayList, @Nullable Boolean bool5, @Nullable Boolean bool6) {
        this.isProhibitRedEnvelope = bool;
        this.isProhibitLink = bool2;
        this.isProhibitQrCode = bool3;
        this.isProhibiteAdvertise = bool4;
        this.prohibiteWords = arrayList;
        this.isProhibitSuspectedRiskFeed = bool5;
        this.isProhibitDatingFeed = bool6;
    }

    @Nullable
    public final ArrayList<String> a() {
        return this.prohibiteWords;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Boolean getIsProhibitDatingFeed() {
        return this.isProhibitDatingFeed;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Boolean getIsProhibitLink() {
        return this.isProhibitLink;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final Boolean getIsProhibitQrCode() {
        return this.isProhibitQrCode;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final Boolean getIsProhibitRedEnvelope() {
        return this.isProhibitRedEnvelope;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GProGuildSpeakRuleData)) {
            return false;
        }
        GProGuildSpeakRuleData gProGuildSpeakRuleData = (GProGuildSpeakRuleData) other;
        if (Intrinsics.areEqual(this.isProhibitRedEnvelope, gProGuildSpeakRuleData.isProhibitRedEnvelope) && Intrinsics.areEqual(this.isProhibitLink, gProGuildSpeakRuleData.isProhibitLink) && Intrinsics.areEqual(this.isProhibitQrCode, gProGuildSpeakRuleData.isProhibitQrCode) && Intrinsics.areEqual(this.isProhibiteAdvertise, gProGuildSpeakRuleData.isProhibiteAdvertise) && Intrinsics.areEqual(this.prohibiteWords, gProGuildSpeakRuleData.prohibiteWords) && Intrinsics.areEqual(this.isProhibitSuspectedRiskFeed, gProGuildSpeakRuleData.isProhibitSuspectedRiskFeed) && Intrinsics.areEqual(this.isProhibitDatingFeed, gProGuildSpeakRuleData.isProhibitDatingFeed)) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final Boolean getIsProhibitSuspectedRiskFeed() {
        return this.isProhibitSuspectedRiskFeed;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final Boolean getIsProhibiteAdvertise() {
        return this.isProhibiteAdvertise;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        Boolean bool = this.isProhibitRedEnvelope;
        int i3 = 0;
        if (bool == null) {
            hashCode = 0;
        } else {
            hashCode = bool.hashCode();
        }
        int i16 = hashCode * 31;
        Boolean bool2 = this.isProhibitLink;
        if (bool2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = bool2.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        Boolean bool3 = this.isProhibitQrCode;
        if (bool3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = bool3.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        Boolean bool4 = this.isProhibiteAdvertise;
        if (bool4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = bool4.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        ArrayList<String> arrayList = this.prohibiteWords;
        if (arrayList == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = arrayList.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        Boolean bool5 = this.isProhibitSuspectedRiskFeed;
        if (bool5 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = bool5.hashCode();
        }
        int i27 = (i26 + hashCode6) * 31;
        Boolean bool6 = this.isProhibitDatingFeed;
        if (bool6 != null) {
            i3 = bool6.hashCode();
        }
        return i27 + i3;
    }

    @NotNull
    public String toString() {
        return "GProGuildSpeakRuleData(isProhibitRedEnvelope=" + this.isProhibitRedEnvelope + ", isProhibitLink=" + this.isProhibitLink + ", isProhibitQrCode=" + this.isProhibitQrCode + ", isProhibiteAdvertise=" + this.isProhibiteAdvertise + ", prohibiteWords=" + this.prohibiteWords + ", isProhibitSuspectedRiskFeed=" + this.isProhibitSuspectedRiskFeed + ", isProhibitDatingFeed=" + this.isProhibitDatingFeed + ')';
    }
}
