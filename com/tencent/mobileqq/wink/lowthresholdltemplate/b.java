package com.tencent.mobileqq.wink.lowthresholdltemplate;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/lowthresholdltemplate/b;", "", "<init>", "()V", "a", "b", "c", "d", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/b$a;", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/b$b;", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/b$c;", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/b$d;", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class b {

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0015\u001a\u0004\b\u000b\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/lowthresholdltemplate/b$a;", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "a", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "c", "()Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "winkEditDataWrapper", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "b", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Ljava/lang/String;", "()Ljava/lang/String;", QQWinkConstants.COVER_PATH, "<init>", "(Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/lang/String;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.lowthresholdltemplate.b$a, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class SaveShare extends b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final WinkEditDataWrapper winkEditDataWrapper;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final MetaMaterial material;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String coverPath;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SaveShare(@NotNull WinkEditDataWrapper winkEditDataWrapper, @NotNull MetaMaterial material, @Nullable String str) {
            super(null);
            Intrinsics.checkNotNullParameter(winkEditDataWrapper, "winkEditDataWrapper");
            Intrinsics.checkNotNullParameter(material, "material");
            this.winkEditDataWrapper = winkEditDataWrapper;
            this.material = material;
            this.coverPath = str;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getCoverPath() {
            return this.coverPath;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final MetaMaterial getMaterial() {
            return this.material;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final WinkEditDataWrapper getWinkEditDataWrapper() {
            return this.winkEditDataWrapper;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SaveShare)) {
                return false;
            }
            SaveShare saveShare = (SaveShare) other;
            if (Intrinsics.areEqual(this.winkEditDataWrapper, saveShare.winkEditDataWrapper) && Intrinsics.areEqual(this.material, saveShare.material) && Intrinsics.areEqual(this.coverPath, saveShare.coverPath)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.winkEditDataWrapper.hashCode() * 31) + this.material.hashCode()) * 31;
            String str = this.coverPath;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            return "SaveShare(winkEditDataWrapper=" + this.winkEditDataWrapper + ", material=" + this.material + ", coverPath=" + this.coverPath + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/lowthresholdltemplate/b$b;", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/b;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.lowthresholdltemplate.b$b, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C9054b extends b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C9054b f323440a = new C9054b();

        C9054b() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/lowthresholdltemplate/b$c;", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/b;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final c f323441a = new c();

        c() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/wink/lowthresholdltemplate/b$d;", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/b;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d extends b {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public static final d f323442a = new d();

        d() {
            super(null);
        }
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    b() {
    }
}
