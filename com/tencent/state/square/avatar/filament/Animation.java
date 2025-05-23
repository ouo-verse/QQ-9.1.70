package com.tencent.state.square.avatar.filament;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/square/avatar/filament/Animation;", "", "fBodyAnimtionPath", "", "fHeadAnimtionPath", "mBodyAnimtionPath", "mHeadAnimtionPath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFBodyAnimtionPath", "()Ljava/lang/String;", "setFBodyAnimtionPath", "(Ljava/lang/String;)V", "getFHeadAnimtionPath", "setFHeadAnimtionPath", "getMBodyAnimtionPath", "setMBodyAnimtionPath", "getMHeadAnimtionPath", "setMHeadAnimtionPath", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "setFullPath", "", "preFix", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class Animation {

    @SerializedName("FBodyAnimtionPath")
    private String fBodyAnimtionPath;

    @SerializedName("FHeadAnimtionPath")
    private String fHeadAnimtionPath;

    @SerializedName("MBodyAnimtionPath")
    private String mBodyAnimtionPath;

    @SerializedName("MHeadAnimtionPath")
    private String mHeadAnimtionPath;

    public Animation(String fBodyAnimtionPath, String fHeadAnimtionPath, String mBodyAnimtionPath, String mHeadAnimtionPath) {
        Intrinsics.checkNotNullParameter(fBodyAnimtionPath, "fBodyAnimtionPath");
        Intrinsics.checkNotNullParameter(fHeadAnimtionPath, "fHeadAnimtionPath");
        Intrinsics.checkNotNullParameter(mBodyAnimtionPath, "mBodyAnimtionPath");
        Intrinsics.checkNotNullParameter(mHeadAnimtionPath, "mHeadAnimtionPath");
        this.fBodyAnimtionPath = fBodyAnimtionPath;
        this.fHeadAnimtionPath = fHeadAnimtionPath;
        this.mBodyAnimtionPath = mBodyAnimtionPath;
        this.mHeadAnimtionPath = mHeadAnimtionPath;
    }

    /* renamed from: component1, reason: from getter */
    public final String getFBodyAnimtionPath() {
        return this.fBodyAnimtionPath;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFHeadAnimtionPath() {
        return this.fHeadAnimtionPath;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMBodyAnimtionPath() {
        return this.mBodyAnimtionPath;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMHeadAnimtionPath() {
        return this.mHeadAnimtionPath;
    }

    public final Animation copy(String fBodyAnimtionPath, String fHeadAnimtionPath, String mBodyAnimtionPath, String mHeadAnimtionPath) {
        Intrinsics.checkNotNullParameter(fBodyAnimtionPath, "fBodyAnimtionPath");
        Intrinsics.checkNotNullParameter(fHeadAnimtionPath, "fHeadAnimtionPath");
        Intrinsics.checkNotNullParameter(mBodyAnimtionPath, "mBodyAnimtionPath");
        Intrinsics.checkNotNullParameter(mHeadAnimtionPath, "mHeadAnimtionPath");
        return new Animation(fBodyAnimtionPath, fHeadAnimtionPath, mBodyAnimtionPath, mHeadAnimtionPath);
    }

    public final String getFBodyAnimtionPath() {
        return this.fBodyAnimtionPath;
    }

    public final String getFHeadAnimtionPath() {
        return this.fHeadAnimtionPath;
    }

    public final String getMBodyAnimtionPath() {
        return this.mBodyAnimtionPath;
    }

    public final String getMHeadAnimtionPath() {
        return this.mHeadAnimtionPath;
    }

    public int hashCode() {
        String str = this.fBodyAnimtionPath;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.fHeadAnimtionPath;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.mBodyAnimtionPath;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.mHeadAnimtionPath;
        return hashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setFBodyAnimtionPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fBodyAnimtionPath = str;
    }

    public final void setFHeadAnimtionPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fHeadAnimtionPath = str;
    }

    public final void setFullPath(String preFix) {
        Intrinsics.checkNotNullParameter(preFix, "preFix");
        this.fBodyAnimtionPath = preFix + this.fBodyAnimtionPath;
        this.fHeadAnimtionPath = preFix + this.fHeadAnimtionPath;
        this.mBodyAnimtionPath = preFix + this.mBodyAnimtionPath;
        this.mHeadAnimtionPath = preFix + this.mHeadAnimtionPath;
    }

    public final void setMBodyAnimtionPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mBodyAnimtionPath = str;
    }

    public final void setMHeadAnimtionPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mHeadAnimtionPath = str;
    }

    public String toString() {
        return "Animation(fBodyAnimtionPath=" + this.fBodyAnimtionPath + ", fHeadAnimtionPath=" + this.fHeadAnimtionPath + ", mBodyAnimtionPath=" + this.mBodyAnimtionPath + ", mHeadAnimtionPath=" + this.mHeadAnimtionPath + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Animation)) {
            return false;
        }
        Animation animation = (Animation) other;
        return Intrinsics.areEqual(this.fBodyAnimtionPath, animation.fBodyAnimtionPath) && Intrinsics.areEqual(this.fHeadAnimtionPath, animation.fHeadAnimtionPath) && Intrinsics.areEqual(this.mBodyAnimtionPath, animation.mBodyAnimtionPath) && Intrinsics.areEqual(this.mHeadAnimtionPath, animation.mHeadAnimtionPath);
    }

    public static /* synthetic */ Animation copy$default(Animation animation, String str, String str2, String str3, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = animation.fBodyAnimtionPath;
        }
        if ((i3 & 2) != 0) {
            str2 = animation.fHeadAnimtionPath;
        }
        if ((i3 & 4) != 0) {
            str3 = animation.mBodyAnimtionPath;
        }
        if ((i3 & 8) != 0) {
            str4 = animation.mHeadAnimtionPath;
        }
        return animation.copy(str, str2, str3, str4);
    }
}
