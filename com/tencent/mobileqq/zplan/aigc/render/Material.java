package com.tencent.mobileqq.zplan.aigc.render;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\bH\u00c6\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/render/Material;", "", "name", "", "textureKey", "textureValue", "matSlotName", "matSlotId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getMatSlotId", "()I", "getMatSlotName", "()Ljava/lang/String;", "getName", "getTextureKey", "getTextureValue", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final /* data */ class Material {
    private final int matSlotId;
    private final String matSlotName;
    private final String name;
    private final String textureKey;
    private final String textureValue;

    public Material(String name, String textureKey, String textureValue, String matSlotName, int i3) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(textureKey, "textureKey");
        Intrinsics.checkNotNullParameter(textureValue, "textureValue");
        Intrinsics.checkNotNullParameter(matSlotName, "matSlotName");
        this.name = name;
        this.textureKey = textureKey;
        this.textureValue = textureValue;
        this.matSlotName = matSlotName;
        this.matSlotId = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTextureKey() {
        return this.textureKey;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTextureValue() {
        return this.textureValue;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMatSlotName() {
        return this.matSlotName;
    }

    /* renamed from: component5, reason: from getter */
    public final int getMatSlotId() {
        return this.matSlotId;
    }

    public final Material copy(String name, String textureKey, String textureValue, String matSlotName, int matSlotId) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(textureKey, "textureKey");
        Intrinsics.checkNotNullParameter(textureValue, "textureValue");
        Intrinsics.checkNotNullParameter(matSlotName, "matSlotName");
        return new Material(name, textureKey, textureValue, matSlotName, matSlotId);
    }

    public final int getMatSlotId() {
        return this.matSlotId;
    }

    public final String getMatSlotName() {
        return this.matSlotName;
    }

    public final String getName() {
        return this.name;
    }

    public final String getTextureKey() {
        return this.textureKey;
    }

    public final String getTextureValue() {
        return this.textureValue;
    }

    public int hashCode() {
        return (((((((this.name.hashCode() * 31) + this.textureKey.hashCode()) * 31) + this.textureValue.hashCode()) * 31) + this.matSlotName.hashCode()) * 31) + this.matSlotId;
    }

    public String toString() {
        return "Material(name=" + this.name + ", textureKey=" + this.textureKey + ", textureValue=" + this.textureValue + ", matSlotName=" + this.matSlotName + ", matSlotId=" + this.matSlotId + ")";
    }

    public static /* synthetic */ Material copy$default(Material material, String str, String str2, String str3, String str4, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = material.name;
        }
        if ((i16 & 2) != 0) {
            str2 = material.textureKey;
        }
        String str5 = str2;
        if ((i16 & 4) != 0) {
            str3 = material.textureValue;
        }
        String str6 = str3;
        if ((i16 & 8) != 0) {
            str4 = material.matSlotName;
        }
        String str7 = str4;
        if ((i16 & 16) != 0) {
            i3 = material.matSlotId;
        }
        return material.copy(str, str5, str6, str7, i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Material)) {
            return false;
        }
        Material material = (Material) other;
        return Intrinsics.areEqual(this.name, material.name) && Intrinsics.areEqual(this.textureKey, material.textureKey) && Intrinsics.areEqual(this.textureValue, material.textureValue) && Intrinsics.areEqual(this.matSlotName, material.matSlotName) && this.matSlotId == material.matSlotId;
    }
}
