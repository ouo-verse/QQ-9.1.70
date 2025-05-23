package com.tencent.qqnt.avatar.fetch;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.avatar.util.e;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import oicq.wlogin_sdk.tools.util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 12\u00020\u0001:\u0001\bBO\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001c\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\t\u001a\u00020\u0007R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001f\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001dR\u0019\u0010#\u001a\u0004\u0018\u00010\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010(R\u0017\u0010.\u001a\u00020*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b%\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/qqnt/avatar/fetch/c;", "", "", h.F, "f", "Lcom/tencent/qqnt/avatar/fetch/b;", "handler", "", "a", "b", "Lcom/tencent/qqnt/avatar/meta/b;", "Lcom/tencent/qqnt/avatar/meta/b;", "c", "()Lcom/tencent/qqnt/avatar/meta/b;", "avatarBean", "", "Lcom/tencent/qqnt/avatar/bean/a;", "Ljava/util/List;", "d", "()Ljava/util/List;", "extendsBeanList", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "e", "()Landroid/graphics/drawable/Drawable;", "loadingDrawable", "getErrorDrawable", "errorDrawable", "", "Z", "quicklyShowBase", "Lcom/tencent/qqnt/avatar/core/b;", "Lcom/tencent/qqnt/avatar/core/b;", "getLayerOrganizer", "()Lcom/tencent/qqnt/avatar/core/b;", "layerOrganizer", "", "g", "Ljava/util/Set;", "fetchHandlerSet", "Ljava/lang/String;", "key", "Lcom/tencent/qqnt/avatar/util/e;", "i", "Lcom/tencent/qqnt/avatar/util/e;", "()Lcom/tencent/qqnt/avatar/util/e;", "tracer", "<init>", "(Lcom/tencent/qqnt/avatar/meta/b;Ljava/util/List;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;ZLcom/tencent/qqnt/avatar/core/b;)V", "j", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.avatar.meta.b avatarBean;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final List<com.tencent.qqnt.avatar.bean.a> extendsBeanList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Drawable loadingDrawable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Drawable errorDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean quicklyShowBase;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.qqnt.avatar.core.b layerOrganizer;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<com.tencent.qqnt.avatar.fetch.b> fetchHandlerSet;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String key;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e tracer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/avatar/fetch/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.avatar.fetch.c$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class b<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((com.tencent.qqnt.avatar.bean.a) t16).b()), Integer.valueOf(((com.tencent.qqnt.avatar.bean.a) t17).b()));
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39482);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c(@NotNull com.tencent.qqnt.avatar.meta.b avatarBean, @Nullable List<? extends com.tencent.qqnt.avatar.bean.a> list, @Nullable Drawable drawable, @Nullable Drawable drawable2, boolean z16, @Nullable com.tencent.qqnt.avatar.core.b bVar) {
        Intrinsics.checkNotNullParameter(avatarBean, "avatarBean");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, avatarBean, list, drawable, drawable2, Boolean.valueOf(z16), bVar);
            return;
        }
        this.avatarBean = avatarBean;
        this.extendsBeanList = list;
        this.loadingDrawable = drawable;
        this.errorDrawable = drawable2;
        this.quicklyShowBase = z16;
        this.layerOrganizer = bVar;
        this.fetchHandlerSet = new LinkedHashSet();
        if (list != 0) {
            CollectionsKt___CollectionsKt.sortedWith(list, new b());
        }
        String h16 = h();
        this.key = h16;
        e eVar = new e("ResourceFetchRequest", h16);
        this.tracer = eVar;
        eVar.d("Bean", avatarBean);
    }

    private final String h() {
        StringBuilder sb5 = new StringBuilder(this.avatarBean.d());
        List<com.tencent.qqnt.avatar.bean.a> list = this.extendsBeanList;
        if (list != null) {
            for (com.tencent.qqnt.avatar.bean.a aVar : list) {
                sb5.append(util.base64_pad_url);
                sb5.append(aVar.d());
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "stringBuilder.toString()");
        return sb6;
    }

    public final void a(@NotNull com.tencent.qqnt.avatar.fetch.b handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) handler);
        } else {
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.fetchHandlerSet.add(handler);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Iterator<T> it = this.fetchHandlerSet.iterator();
        while (it.hasNext()) {
            ((com.tencent.qqnt.avatar.fetch.b) it.next()).cancel();
        }
        this.fetchHandlerSet.clear();
    }

    @NotNull
    public final com.tencent.qqnt.avatar.meta.b c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.avatar.meta.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.avatarBean;
    }

    @Nullable
    public final List<com.tencent.qqnt.avatar.bean.a> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.extendsBeanList;
    }

    @Nullable
    public final Drawable e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.loadingDrawable;
    }

    @NotNull
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.key;
    }

    @NotNull
    public final e g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (e) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.tracer;
    }

    public /* synthetic */ c(com.tencent.qqnt.avatar.meta.b bVar, List list, Drawable drawable, Drawable drawable2, boolean z16, com.tencent.qqnt.avatar.core.b bVar2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, (i3 & 2) != 0 ? new ArrayList() : list, (i3 & 4) != 0 ? null : drawable, (i3 & 8) != 0 ? null : drawable2, (i3 & 16) != 0 ? true : z16, (i3 & 32) != 0 ? null : bVar2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, bVar, list, drawable, drawable2, Boolean.valueOf(z16), bVar2, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
