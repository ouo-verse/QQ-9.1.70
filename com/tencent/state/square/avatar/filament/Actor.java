package com.tencent.state.square.avatar.filament;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003JQ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u000e\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020 J\u000e\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020 J.\u0010%\u001a\u00020\u00032\u0006\u0010#\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010\u00032\b\u0010'\u001a\u0004\u0018\u00010\u00032\b\u0010(\u001a\u0004\u0018\u00010\u0003H\u0002J\t\u0010)\u001a\u00020*H\u00d6\u0001J\u000e\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0003J\t\u0010.\u001a\u00020\u0003H\u00d6\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r\u00a8\u0006/"}, d2 = {"Lcom/tencent/state/square/avatar/filament/Actor;", "", "extraActorMeshPath", "", "extraActorAnimationPath", "fExtraActorMeshPath", "fExtraActorAnimationPath", "mExtraActorMeshPath", "mExtraActorAnimationPath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getExtraActorAnimationPath", "()Ljava/lang/String;", "setExtraActorAnimationPath", "(Ljava/lang/String;)V", "getExtraActorMeshPath", "setExtraActorMeshPath", "getFExtraActorAnimationPath", "setFExtraActorAnimationPath", "getFExtraActorMeshPath", "setFExtraActorMeshPath", "getMExtraActorAnimationPath", "setMExtraActorAnimationPath", "getMExtraActorMeshPath", "setMExtraActorMeshPath", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "getAnimationPath", "isMale", "getMeshPath", "getPath", "malePath", "femalePath", "defaultPath", "hashCode", "", "setFullPath", "", "preFix", "toString", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final /* data */ class Actor {

    @SerializedName("ExtraActorAnimationPath")
    private String extraActorAnimationPath;

    @SerializedName("ExtraActorMeshPath")
    private String extraActorMeshPath;

    @SerializedName("FExtraActorAnimationPath")
    private String fExtraActorAnimationPath;

    @SerializedName("FExtraActorMeshPath")
    private String fExtraActorMeshPath;

    @SerializedName("MExtraActorAnimationPath")
    private String mExtraActorAnimationPath;

    @SerializedName("MExtraActorMeshPath")
    private String mExtraActorMeshPath;

    public Actor(String str, String str2, String str3, String str4, String str5, String str6) {
        this.extraActorMeshPath = str;
        this.extraActorAnimationPath = str2;
        this.fExtraActorMeshPath = str3;
        this.fExtraActorAnimationPath = str4;
        this.mExtraActorMeshPath = str5;
        this.mExtraActorAnimationPath = str6;
    }

    private final String getPath(boolean isMale, String malePath, String femalePath, String defaultPath) {
        if (isMale) {
            if (malePath == null) {
                malePath = defaultPath;
            }
            if (malePath != null) {
                femalePath = malePath;
            }
            return femalePath != null ? femalePath : "";
        }
        if (femalePath == null) {
            femalePath = defaultPath;
        }
        if (femalePath != null) {
            malePath = femalePath;
        }
        return malePath != null ? malePath : "";
    }

    /* renamed from: component1, reason: from getter */
    public final String getExtraActorMeshPath() {
        return this.extraActorMeshPath;
    }

    /* renamed from: component2, reason: from getter */
    public final String getExtraActorAnimationPath() {
        return this.extraActorAnimationPath;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFExtraActorMeshPath() {
        return this.fExtraActorMeshPath;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFExtraActorAnimationPath() {
        return this.fExtraActorAnimationPath;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMExtraActorMeshPath() {
        return this.mExtraActorMeshPath;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMExtraActorAnimationPath() {
        return this.mExtraActorAnimationPath;
    }

    public final Actor copy(String extraActorMeshPath, String extraActorAnimationPath, String fExtraActorMeshPath, String fExtraActorAnimationPath, String mExtraActorMeshPath, String mExtraActorAnimationPath) {
        return new Actor(extraActorMeshPath, extraActorAnimationPath, fExtraActorMeshPath, fExtraActorAnimationPath, mExtraActorMeshPath, mExtraActorAnimationPath);
    }

    public final String getAnimationPath(boolean isMale) {
        return getPath(isMale, this.mExtraActorAnimationPath, this.fExtraActorAnimationPath, this.extraActorAnimationPath);
    }

    public final String getExtraActorAnimationPath() {
        return this.extraActorAnimationPath;
    }

    public final String getExtraActorMeshPath() {
        return this.extraActorMeshPath;
    }

    public final String getFExtraActorAnimationPath() {
        return this.fExtraActorAnimationPath;
    }

    public final String getFExtraActorMeshPath() {
        return this.fExtraActorMeshPath;
    }

    public final String getMExtraActorAnimationPath() {
        return this.mExtraActorAnimationPath;
    }

    public final String getMExtraActorMeshPath() {
        return this.mExtraActorMeshPath;
    }

    public final String getMeshPath(boolean isMale) {
        return getPath(isMale, this.mExtraActorMeshPath, this.fExtraActorMeshPath, this.extraActorMeshPath);
    }

    public int hashCode() {
        String str = this.extraActorMeshPath;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.extraActorAnimationPath;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.fExtraActorMeshPath;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.fExtraActorAnimationPath;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.mExtraActorMeshPath;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.mExtraActorAnimationPath;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public final void setExtraActorAnimationPath(String str) {
        this.extraActorAnimationPath = str;
    }

    public final void setExtraActorMeshPath(String str) {
        this.extraActorMeshPath = str;
    }

    public final void setFExtraActorAnimationPath(String str) {
        this.fExtraActorAnimationPath = str;
    }

    public final void setFExtraActorMeshPath(String str) {
        this.fExtraActorMeshPath = str;
    }

    public final void setFullPath(final String preFix) {
        Intrinsics.checkNotNullParameter(preFix, "preFix");
        Function1<String, String> function1 = new Function1<String, String>() { // from class: com.tencent.state.square.avatar.filament.Actor$setFullPath$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String str) {
                if (str == null) {
                    return null;
                }
                return preFix + str;
            }
        };
        this.extraActorMeshPath = function1.invoke(this.extraActorMeshPath);
        this.extraActorAnimationPath = function1.invoke(this.extraActorAnimationPath);
        this.fExtraActorMeshPath = function1.invoke(this.fExtraActorMeshPath);
        this.fExtraActorAnimationPath = function1.invoke(this.fExtraActorAnimationPath);
        this.mExtraActorMeshPath = function1.invoke(this.mExtraActorMeshPath);
        this.mExtraActorAnimationPath = function1.invoke(this.mExtraActorAnimationPath);
    }

    public final void setMExtraActorAnimationPath(String str) {
        this.mExtraActorAnimationPath = str;
    }

    public final void setMExtraActorMeshPath(String str) {
        this.mExtraActorMeshPath = str;
    }

    public String toString() {
        return "Actor(extraActorMeshPath=" + this.extraActorMeshPath + ", extraActorAnimationPath=" + this.extraActorAnimationPath + ", fExtraActorMeshPath=" + this.fExtraActorMeshPath + ", fExtraActorAnimationPath=" + this.fExtraActorAnimationPath + ", mExtraActorMeshPath=" + this.mExtraActorMeshPath + ", mExtraActorAnimationPath=" + this.mExtraActorAnimationPath + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Actor)) {
            return false;
        }
        Actor actor = (Actor) other;
        return Intrinsics.areEqual(this.extraActorMeshPath, actor.extraActorMeshPath) && Intrinsics.areEqual(this.extraActorAnimationPath, actor.extraActorAnimationPath) && Intrinsics.areEqual(this.fExtraActorMeshPath, actor.fExtraActorMeshPath) && Intrinsics.areEqual(this.fExtraActorAnimationPath, actor.fExtraActorAnimationPath) && Intrinsics.areEqual(this.mExtraActorMeshPath, actor.mExtraActorMeshPath) && Intrinsics.areEqual(this.mExtraActorAnimationPath, actor.mExtraActorAnimationPath);
    }

    public static /* synthetic */ Actor copy$default(Actor actor, String str, String str2, String str3, String str4, String str5, String str6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = actor.extraActorMeshPath;
        }
        if ((i3 & 2) != 0) {
            str2 = actor.extraActorAnimationPath;
        }
        String str7 = str2;
        if ((i3 & 4) != 0) {
            str3 = actor.fExtraActorMeshPath;
        }
        String str8 = str3;
        if ((i3 & 8) != 0) {
            str4 = actor.fExtraActorAnimationPath;
        }
        String str9 = str4;
        if ((i3 & 16) != 0) {
            str5 = actor.mExtraActorMeshPath;
        }
        String str10 = str5;
        if ((i3 & 32) != 0) {
            str6 = actor.mExtraActorAnimationPath;
        }
        return actor.copy(str, str7, str8, str9, str10, str6);
    }
}
