package com.tencent.localedit.fakenative.intercept;

import com.tencent.localedit.LocalEditSDK;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\bR\u001b\u0010\u000e\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/localedit/fakenative/intercept/CategoryResourceInterceptorImpl;", "Lcom/tencent/localedit/fakenative/intercept/a;", "", "offlineEnabledUrl", "i", "url", "e", "f", "Ljava/lang/String;", "currentDocsType", "Lcom/tencent/localedit/fakenative/packages/a;", "Lkotlin/Lazy;", "j", "()Lcom/tencent/localedit/fakenative/packages/a;", "packageManager", "<init>", "()V", h.F, "a", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class CategoryResourceInterceptorImpl extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String currentDocsType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy packageManager;

    public CategoryResourceInterceptorImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.localedit.fakenative.packages.a>() { // from class: com.tencent.localedit.fakenative.intercept.CategoryResourceInterceptorImpl$packageManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.localedit.fakenative.packages.a invoke() {
                return LocalEditSDK.INSTANCE.getPackageManager();
            }
        });
        this.packageManager = lazy;
    }

    private final com.tencent.localedit.fakenative.packages.a j() {
        return (com.tencent.localedit.fakenative.packages.a) this.packageManager.getValue();
    }

    @Override // com.tencent.localedit.fakenative.intercept.a
    @Nullable
    public String e(@Nullable String url) {
        w11.a aVar = w11.a.f444159a;
        if (aVar.p(url)) {
            x11.b.f446855a.d("CategoryResourceInterceptorImpl", Intrinsics.stringPlus(" Local_edit checkAndMakeResourceUrlAvailable routeUrl=", url));
            String a16 = aVar.a(url);
            if (a16 == null) {
                return null;
            }
            this.currentDocsType = com.tencent.localedit.a.b().get(aVar.h(a16));
            return a16;
        }
        return url;
    }

    @Override // com.tencent.localedit.fakenative.intercept.a
    @Nullable
    public String f(@Nullable String url) {
        return null;
    }

    @Override // com.tencent.localedit.fakenative.intercept.a
    @Nullable
    public String i(@Nullable String offlineEnabledUrl) {
        boolean z16;
        boolean z17;
        long currentTimeMillis = System.currentTimeMillis();
        String str = this.currentDocsType;
        boolean z18 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (offlineEnabledUrl != null && offlineEnabledUrl.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                if (!j().d(this.currentDocsType) && !j().j(this.currentDocsType)) {
                    x11.b.f446855a.d("CategoryResourceInterceptorImpl", "cannot find resource, currentDocsType = " + ((Object) this.currentDocsType) + " ,Url=" + ((Object) offlineEnabledUrl));
                    com.tencent.localedit.fakenative.packages.a.l(j(), this.currentDocsType, null, null, 6, null);
                    return null;
                }
                JSONObject g16 = j().g(this.currentDocsType);
                if (g16 != null && g16.optLong("expired", 0L) < currentTimeMillis) {
                    x11.b.f446855a.b("CategoryResourceInterceptorImpl", "offline package expired " + ((Object) this.currentDocsType) + ", clear expired");
                    com.tencent.localedit.fakenative.packages.a j3 = j();
                    j3.e(this.currentDocsType);
                    com.tencent.localedit.fakenative.packages.a.l(j3, this.currentDocsType, null, null, 6, null);
                    return null;
                }
                String n3 = w11.a.f444159a.n(offlineEnabledUrl);
                if (n3.length() > 0) {
                    z18 = true;
                }
                if (!z18) {
                    n3 = null;
                }
                if (n3 == null) {
                    x11.b.f446855a.b("CategoryResourceInterceptorImpl", Intrinsics.stringPlus("invalid path: ", offlineEnabledUrl));
                    return null;
                }
                String f16 = j().f(this.currentDocsType, n3);
                if (f16 == null) {
                    x11.b.f446855a.b("CategoryResourceInterceptorImpl", "no file for url " + ((Object) offlineEnabledUrl) + " within offline package " + ((Object) this.currentDocsType));
                    return null;
                }
                return f16;
            }
        }
        x11.b.f446855a.b("CategoryResourceInterceptorImpl", "currentDocsType or offlineEnabledUrl is empty");
        return null;
    }
}
