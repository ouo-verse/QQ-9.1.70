package com.tencent.videocut.render;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.wink.editor.effect.model.WinkEffectCatType;
import com.tencent.qcircle.weseevideo.model.template.movie.AIAbilityModel;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.render.builder.light.model.pag.PagEffectData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001\nBO\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010#\u001a\u00020\u0007\u0012\b\b\u0002\u0010%\u001a\u00020\u0007\u0012\b\b\u0002\u0010)\u001a\u00020\u0004\u00a2\u0006\u0004\b+\u0010,J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00168\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010#\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010%\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b%\u0010\"R\u0017\u0010)\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b\u0011\u0010(R\u0011\u0010*\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\"\u00a8\u0006."}, d2 = {"Lcom/tencent/videocut/render/p;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lorg/light/lightAssetKit/Entity;", "a", "Lorg/light/lightAssetKit/Entity;", "c", "()Lorg/light/lightAssetKit/Entity;", "entity", "", "Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "b", "Ljava/util/List;", "d", "()Ljava/util/List;", "inputSource", "Lcom/tencent/tavcut/core/render/builder/light/model/pag/PagEffectData;", "Lcom/tencent/tavcut/core/render/builder/light/model/pag/PagEffectData;", "getPagEffectData", "()Lcom/tencent/tavcut/core/render/builder/light/model/pag/PagEffectData;", "pagEffectData", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "e", "Z", "getTemporary", "()Z", "temporary", "f", "isLakFragmentEntity", "g", "I", "()I", AIAbilityModel.AI_KEY, "valid", "<init>", "(Lorg/light/lightAssetKit/Entity;Ljava/util/List;Lcom/tencent/tavcut/core/render/builder/light/model/pag/PagEffectData;Ljava/lang/String;ZZI)V", tl.h.F, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final /* data */ class p {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final p f384180i;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Entity entity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final List<InputSource> inputSource;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final PagEffectData pagEffectData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String id;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean temporary;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isLakFragmentEntity;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int effectType;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/videocut/render/p$a;", "", "Lcom/tencent/videocut/render/p;", "INVALID", "Lcom/tencent/videocut/render/p;", "a", "()Lcom/tencent/videocut/render/p;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.videocut.render.p$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final p a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return p.f384180i;
            }
            return (p) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59742);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INSTANCE = new Companion(null);
            f384180i = new p(new Entity(), null, null, "", false, false, 0, 112, null);
        }
    }

    public p(@NotNull Entity entity, @Nullable List<InputSource> list, @Nullable PagEffectData pagEffectData, @NotNull String id5, boolean z16, boolean z17, int i3) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(id5, "id");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, entity, list, pagEffectData, id5, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3));
            return;
        }
        this.entity = entity;
        this.inputSource = list;
        this.pagEffectData = pagEffectData;
        this.id = id5;
        this.temporary = z16;
        this.isLakFragmentEntity = z17;
        this.effectType = i3;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.effectType;
    }

    @NotNull
    public final Entity c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Entity) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.entity;
    }

    @Nullable
    public final List<InputSource> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.inputSource;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (this.inputSource != null) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof p)) {
            return false;
        }
        p pVar = (p) other;
        if (Intrinsics.areEqual(this.entity, pVar.entity) && Intrinsics.areEqual(this.inputSource, pVar.inputSource) && Intrinsics.areEqual(this.pagEffectData, pVar.pagEffectData) && Intrinsics.areEqual(this.id, pVar.id) && this.temporary == pVar.temporary && this.isLakFragmentEntity == pVar.isLakFragmentEntity && this.effectType == pVar.effectType) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        int hashCode2 = this.entity.hashCode() * 31;
        List<InputSource> list = this.inputSource;
        int i3 = 0;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        PagEffectData pagEffectData = this.pagEffectData;
        if (pagEffectData != null) {
            i3 = pagEffectData.hashCode();
        }
        int hashCode3 = (((i16 + i3) * 31) + this.id.hashCode()) * 31;
        boolean z16 = this.temporary;
        int i17 = 1;
        int i18 = z16;
        if (z16 != 0) {
            i18 = 1;
        }
        int i19 = (hashCode3 + i18) * 31;
        boolean z17 = this.isLakFragmentEntity;
        if (!z17) {
            i17 = z17 ? 1 : 0;
        }
        return ((i19 + i17) * 31) + this.effectType;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return "SpecialEffectRenderData(entity=" + this.entity + ", inputSource=" + this.inputSource + ", pagEffectData=" + this.pagEffectData + ", id=" + this.id + ", temporary=" + this.temporary + ", isLakFragmentEntity=" + this.isLakFragmentEntity + ", effectType=" + this.effectType + ")";
    }

    public /* synthetic */ p(Entity entity, List list, PagEffectData pagEffectData, String str, boolean z16, boolean z17, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(entity, list, pagEffectData, str, (i16 & 16) != 0 ? false : z16, (i16 & 32) != 0 ? false : z17, (i16 & 64) != 0 ? WinkEffectCatType.TypeFace.ordinal() : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, entity, list, pagEffectData, str, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
