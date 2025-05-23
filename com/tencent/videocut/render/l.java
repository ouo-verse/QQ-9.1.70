package com.tencent.videocut.render;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/videocut/render/l;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lorg/light/lightAssetKit/Entity;", "a", "Lorg/light/lightAssetKit/Entity;", "()Lorg/light/lightAssetKit/Entity;", "entity", "Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "b", "Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "()Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "inputSource", "c", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "<init>", "(Lorg/light/lightAssetKit/Entity;Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;Ljava/lang/String;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final /* data */ class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Entity entity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final InputSource inputSource;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String id;

    public l(@NotNull Entity entity, @NotNull InputSource inputSource, @NotNull String id5) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(inputSource, "inputSource");
        Intrinsics.checkNotNullParameter(id5, "id");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, entity, inputSource, id5);
            return;
        }
        this.entity = entity;
        this.inputSource = inputSource;
        this.id = id5;
    }

    @NotNull
    public final Entity a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Entity) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.entity;
    }

    @NotNull
    public final InputSource b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (InputSource) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.inputSource;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof l)) {
            return false;
        }
        l lVar = (l) other;
        if (Intrinsics.areEqual(this.entity, lVar.entity) && Intrinsics.areEqual(this.inputSource, lVar.inputSource) && Intrinsics.areEqual(this.id, lVar.id)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return (((this.entity.hashCode() * 31) + this.inputSource.hashCode()) * 31) + this.id.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "RenderData(entity=" + this.entity + ", inputSource=" + this.inputSource + ", id=" + this.id + ")";
    }

    public /* synthetic */ l(Entity entity, InputSource inputSource, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(entity, inputSource, (i3 & 4) != 0 ? "" : str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, entity, inputSource, str, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
