package com.tencent.localedit.fakenative.packages;

import com.tencent.localedit.fakenative.core.BaseManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J;\u0010\u000e\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/localedit/fakenative/packages/a;", "Lcom/tencent/localedit/fakenative/core/BaseManager;", "", "docsType", h.F, "Lcom/tencent/localedit/fakenative/packages/ResourcePackage;", "resourcePackage", "", "i", "", "d", "Lkotlin/Function1;", "callback", "checkInnerZip", "k", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/lang/Boolean;)V", "j", "relativeFilePath", "f", "Lorg/json/JSONObject;", "g", "e", "destroy", "a", "Lcom/tencent/localedit/fakenative/packages/ResourcePackage;", "<init>", "()V", "b", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class a extends BaseManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ResourcePackage resourcePackage;

    private final String h(String docsType) {
        ResourcePackage resourcePackage = this.resourcePackage;
        if (resourcePackage == null) {
            return null;
        }
        return resourcePackage.k(docsType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void l(a aVar, String str, Function1 function1, Boolean bool, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        if ((i3 & 4) != 0) {
            bool = Boolean.FALSE;
        }
        aVar.k(str, function1, bool);
    }

    public final boolean d(@Nullable String docsType) {
        ResourcePackage resourcePackage = this.resourcePackage;
        if (resourcePackage == null) {
            return false;
        }
        return resourcePackage.f(docsType);
    }

    @Override // com.tencent.localedit.fakenative.core.BaseManager
    public void destroy() {
        this.resourcePackage = null;
    }

    public final void e(@Nullable String docsType) {
        ResourcePackage resourcePackage = this.resourcePackage;
        if (resourcePackage != null) {
            resourcePackage.g(docsType);
        }
    }

    @Nullable
    public final String f(@Nullable String docsType, @NotNull String relativeFilePath) {
        Intrinsics.checkNotNullParameter(relativeFilePath, "relativeFilePath");
        String str = ((Object) h(docsType)) + '/' + relativeFilePath;
        if (new File(str).exists()) {
            return str;
        }
        return null;
    }

    @Nullable
    public final JSONObject g(@Nullable String docsType) {
        ResourcePackage resourcePackage = this.resourcePackage;
        if (resourcePackage == null) {
            return null;
        }
        return resourcePackage.i(h(docsType));
    }

    public final void i(@NotNull ResourcePackage resourcePackage) {
        Intrinsics.checkNotNullParameter(resourcePackage, "resourcePackage");
        this.resourcePackage = resourcePackage;
    }

    public final boolean j(@Nullable String docsType) {
        ResourcePackage resourcePackage = this.resourcePackage;
        if (resourcePackage == null) {
            return false;
        }
        return resourcePackage.m(docsType);
    }

    public final void k(@Nullable String docsType, @Nullable Function1<? super Boolean, Unit> callback, @Nullable Boolean checkInnerZip) {
        ResourcePackage resourcePackage = this.resourcePackage;
        if (resourcePackage != null) {
            resourcePackage.n(docsType, callback, checkInnerZip);
        }
    }
}
