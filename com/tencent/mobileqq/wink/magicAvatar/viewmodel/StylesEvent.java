package com.tencent.mobileqq.wink.magicAvatar.viewmodel;

import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarMaterialInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001f\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/viewmodel/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarMaterialInfo;", "a", "Ljava/util/List;", "()Ljava/util/List;", "list", "<init>", "(Ljava/util/List;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.magicAvatar.viewmodel.f, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class StylesEvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<MagicAvatarMaterialInfo> list;

    public StylesEvent(@Nullable List<MagicAvatarMaterialInfo> list) {
        this.list = list;
    }

    @Nullable
    public final List<MagicAvatarMaterialInfo> a() {
        return this.list;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof StylesEvent) && Intrinsics.areEqual(this.list, ((StylesEvent) other).list)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        List<MagicAvatarMaterialInfo> list = this.list;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "StylesEvent(list=" + this.list + ")";
    }
}
