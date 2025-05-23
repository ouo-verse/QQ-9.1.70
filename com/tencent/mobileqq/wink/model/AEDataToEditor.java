package com.tencent.mobileqq.wink.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\nH\u00c6\u0003JE\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u00d6\u0003J\t\u0010)\u001a\u00020*H\u00d6\u0001J\t\u0010+\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/wink/model/AEDataToEditor;", "Ljava/io/Serializable;", "challengeTopic", "", "challengeRotation", "", "challengeScale", "challengePositionX", "challengePositionY", "challengeJoinsNums", "", "(Ljava/lang/String;FFFFJ)V", "getChallengeJoinsNums", "()J", "setChallengeJoinsNums", "(J)V", "getChallengePositionX", "()F", "setChallengePositionX", "(F)V", "getChallengePositionY", "setChallengePositionY", "getChallengeRotation", "setChallengeRotation", "getChallengeScale", "setChallengeScale", "getChallengeTopic", "()Ljava/lang/String;", "setChallengeTopic", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class AEDataToEditor implements Serializable {
    private long challengeJoinsNums;
    private float challengePositionX;
    private float challengePositionY;
    private float challengeRotation;
    private float challengeScale;

    @NotNull
    private String challengeTopic;

    public AEDataToEditor() {
        this(null, 0.0f, 0.0f, 0.0f, 0.0f, 0L, 63, null);
    }

    public static /* synthetic */ AEDataToEditor copy$default(AEDataToEditor aEDataToEditor, String str, float f16, float f17, float f18, float f19, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = aEDataToEditor.challengeTopic;
        }
        if ((i3 & 2) != 0) {
            f16 = aEDataToEditor.challengeRotation;
        }
        float f26 = f16;
        if ((i3 & 4) != 0) {
            f17 = aEDataToEditor.challengeScale;
        }
        float f27 = f17;
        if ((i3 & 8) != 0) {
            f18 = aEDataToEditor.challengePositionX;
        }
        float f28 = f18;
        if ((i3 & 16) != 0) {
            f19 = aEDataToEditor.challengePositionY;
        }
        float f29 = f19;
        if ((i3 & 32) != 0) {
            j3 = aEDataToEditor.challengeJoinsNums;
        }
        return aEDataToEditor.copy(str, f26, f27, f28, f29, j3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getChallengeTopic() {
        return this.challengeTopic;
    }

    /* renamed from: component2, reason: from getter */
    public final float getChallengeRotation() {
        return this.challengeRotation;
    }

    /* renamed from: component3, reason: from getter */
    public final float getChallengeScale() {
        return this.challengeScale;
    }

    /* renamed from: component4, reason: from getter */
    public final float getChallengePositionX() {
        return this.challengePositionX;
    }

    /* renamed from: component5, reason: from getter */
    public final float getChallengePositionY() {
        return this.challengePositionY;
    }

    /* renamed from: component6, reason: from getter */
    public final long getChallengeJoinsNums() {
        return this.challengeJoinsNums;
    }

    @NotNull
    public final AEDataToEditor copy(@NotNull String challengeTopic, float challengeRotation, float challengeScale, float challengePositionX, float challengePositionY, long challengeJoinsNums) {
        Intrinsics.checkNotNullParameter(challengeTopic, "challengeTopic");
        return new AEDataToEditor(challengeTopic, challengeRotation, challengeScale, challengePositionX, challengePositionY, challengeJoinsNums);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AEDataToEditor)) {
            return false;
        }
        AEDataToEditor aEDataToEditor = (AEDataToEditor) other;
        if (Intrinsics.areEqual(this.challengeTopic, aEDataToEditor.challengeTopic) && Float.compare(this.challengeRotation, aEDataToEditor.challengeRotation) == 0 && Float.compare(this.challengeScale, aEDataToEditor.challengeScale) == 0 && Float.compare(this.challengePositionX, aEDataToEditor.challengePositionX) == 0 && Float.compare(this.challengePositionY, aEDataToEditor.challengePositionY) == 0 && this.challengeJoinsNums == aEDataToEditor.challengeJoinsNums) {
            return true;
        }
        return false;
    }

    public final long getChallengeJoinsNums() {
        return this.challengeJoinsNums;
    }

    public final float getChallengePositionX() {
        return this.challengePositionX;
    }

    public final float getChallengePositionY() {
        return this.challengePositionY;
    }

    public final float getChallengeRotation() {
        return this.challengeRotation;
    }

    public final float getChallengeScale() {
        return this.challengeScale;
    }

    @NotNull
    public final String getChallengeTopic() {
        return this.challengeTopic;
    }

    public int hashCode() {
        return (((((((((this.challengeTopic.hashCode() * 31) + Float.floatToIntBits(this.challengeRotation)) * 31) + Float.floatToIntBits(this.challengeScale)) * 31) + Float.floatToIntBits(this.challengePositionX)) * 31) + Float.floatToIntBits(this.challengePositionY)) * 31) + androidx.fragment.app.a.a(this.challengeJoinsNums);
    }

    public final void setChallengeJoinsNums(long j3) {
        this.challengeJoinsNums = j3;
    }

    public final void setChallengePositionX(float f16) {
        this.challengePositionX = f16;
    }

    public final void setChallengePositionY(float f16) {
        this.challengePositionY = f16;
    }

    public final void setChallengeRotation(float f16) {
        this.challengeRotation = f16;
    }

    public final void setChallengeScale(float f16) {
        this.challengeScale = f16;
    }

    public final void setChallengeTopic(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.challengeTopic = str;
    }

    @NotNull
    public String toString() {
        return "AEDataToEditor(challengeTopic=" + this.challengeTopic + ", challengeRotation=" + this.challengeRotation + ", challengeScale=" + this.challengeScale + ", challengePositionX=" + this.challengePositionX + ", challengePositionY=" + this.challengePositionY + ", challengeJoinsNums=" + this.challengeJoinsNums + ")";
    }

    public AEDataToEditor(@NotNull String challengeTopic, float f16, float f17, float f18, float f19, long j3) {
        Intrinsics.checkNotNullParameter(challengeTopic, "challengeTopic");
        this.challengeTopic = challengeTopic;
        this.challengeRotation = f16;
        this.challengeScale = f17;
        this.challengePositionX = f18;
        this.challengePositionY = f19;
        this.challengeJoinsNums = j3;
    }

    public /* synthetic */ AEDataToEditor(String str, float f16, float f17, float f18, float f19, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0.0f : f16, (i3 & 4) != 0 ? 1.0f : f17, (i3 & 8) != 0 ? 0.1f : f18, (i3 & 16) != 0 ? 0.16f : f19, (i3 & 32) != 0 ? 0L : j3);
    }
}
