package com.tencent.mobileqq.wink.magicAvatar.model;

import androidx.annotation.Keep;
import com.tencent.ttpic.openapi.filter.LightConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001`\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarPicAndStyles;", "", "()V", "gender", "", "getGender", "()Ljava/lang/String;", "setGender", "(Ljava/lang/String;)V", "glass", "", "getGlass", "()Z", "setGlass", "(Z)V", "materials", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarMaterialInfo;", "Lkotlin/collections/ArrayList;", "getMaterials", "()Ljava/util/ArrayList;", "setMaterials", "(Ljava/util/ArrayList;)V", "toString", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class MagicAvatarPicAndStyles {

    @NotNull
    private String gender = LightConstants.MALE;
    private boolean glass;

    @Nullable
    private ArrayList<MagicAvatarMaterialInfo> materials;

    @NotNull
    public final String getGender() {
        return this.gender;
    }

    public final boolean getGlass() {
        return this.glass;
    }

    @Nullable
    public final ArrayList<MagicAvatarMaterialInfo> getMaterials() {
        return this.materials;
    }

    public final void setGender(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.gender = str;
    }

    public final void setGlass(boolean z16) {
        this.glass = z16;
    }

    public final void setMaterials(@Nullable ArrayList<MagicAvatarMaterialInfo> arrayList) {
        this.materials = arrayList;
    }

    @NotNull
    public String toString() {
        return "MagicAvatarPicAndStyles(materials=" + this.materials + ", glass=" + this.glass + ", gender='" + this.gender + "')";
    }
}
