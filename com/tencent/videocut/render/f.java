package com.tencent.videocut.render;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001\nB5\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006!"}, d2 = {"Lcom/tencent/videocut/render/f;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lorg/light/lightAssetKit/Entity;", "a", "Lorg/light/lightAssetKit/Entity;", "b", "()Lorg/light/lightAssetKit/Entity;", "entity", "", "Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "Ljava/util/List;", "c", "()Ljava/util/List;", "inputSourceList", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "d", "Z", "getFragment", "()Z", "fragment", "<init>", "(Lorg/light/lightAssetKit/Entity;Ljava/util/List;Ljava/lang/String;Z)V", "e", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final /* data */ class f {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final f f384142f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Entity entity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final List<InputSource> inputSourceList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String id;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean fragment;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/videocut/render/f$a;", "", "Lcom/tencent/videocut/render/f;", "INVALID", "Lcom/tencent/videocut/render/f;", "a", "()Lcom/tencent/videocut/render/f;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.videocut.render.f$a, reason: from kotlin metadata */
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
        public final f a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return f.f384142f;
            }
            return (f) iPatchRedirector.redirect((short) 2, (Object) this);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59664);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
            f384142f = new f(new Entity(), null, null, false, 14, null);
        }
    }

    public f(@NotNull Entity entity, @Nullable List<InputSource> list, @NotNull String id5, boolean z16) {
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(id5, "id");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, entity, list, id5, Boolean.valueOf(z16));
            return;
        }
        this.entity = entity;
        this.inputSourceList = list;
        this.id = id5;
        this.fragment = z16;
    }

    @NotNull
    public final Entity b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Entity) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.entity;
    }

    @Nullable
    public final List<InputSource> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.inputSourceList;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof f)) {
            return false;
        }
        f fVar = (f) other;
        if (Intrinsics.areEqual(this.entity, fVar.entity) && Intrinsics.areEqual(this.inputSourceList, fVar.inputSourceList) && Intrinsics.areEqual(this.id, fVar.id) && this.fragment == fVar.fragment) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        int hashCode2 = this.entity.hashCode() * 31;
        List<InputSource> list = this.inputSourceList;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        int hashCode3 = (((hashCode2 + hashCode) * 31) + this.id.hashCode()) * 31;
        boolean z16 = this.fragment;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode3 + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return "FilterRenderData(entity=" + this.entity + ", inputSourceList=" + this.inputSourceList + ", id=" + this.id + ", fragment=" + this.fragment + ")";
    }

    public /* synthetic */ f(Entity entity, List list, String str, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(entity, (i3 & 2) != 0 ? null : list, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, entity, list, str, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
