package com.tencent.mobileqq.wink.sdk;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import z93.b;
import z93.c;
import z93.d;
import z93.e;
import z93.f;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\u0003B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/sdk/Wink;", "", "Lcom/tencent/mobileqq/wink/sdk/a;", "a", "Lcom/tencent/mobileqq/wink/sdk/a;", "apiContainer", "<init>", "()V", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class Wink {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f326307c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private static Wink f326308d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Lazy<aa3.a> f326309e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a apiContainer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)JL\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u0010\u001a\u00020\u0002J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006J\b\u0010\u0013\u001a\u0004\u0018\u00010\bJ\b\u0010\u0014\u001a\u0004\u0018\u00010\fJ\b\u0010\u0015\u001a\u0004\u0018\u00010\nR\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/wink/sdk/Wink$a;", "", "Lz93/f;", "winkThreadApi", "Lz93/a;", "winkEditorApi", "Lz93/b;", "winkNavigateApi", "Lz93/d;", "winkReportApi", "Lz93/c;", "winkQualityReportApi", "Lz93/e;", "winkResourceApi", "", "d", "i", "a", "e", "g", h.F, "f", "Laa3/a;", "defaultThreadApiImpl$delegate", "Lkotlin/Lazy;", "b", "()Laa3/a;", "defaultThreadApiImpl", "", "<set-?>", "initialized", "Z", "c", "()Z", "", "TAG", "Ljava/lang/String;", "Lcom/tencent/mobileqq/wink/sdk/Wink;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/wink/sdk/Wink;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.sdk.Wink$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final aa3.a b() {
            return (aa3.a) Wink.f326309e.getValue();
        }

        @Nullable
        public final z93.a a() {
            a aVar;
            Wink wink = Wink.f326308d;
            if (wink != null && (aVar = wink.apiContainer) != null) {
                return aVar.getWinkEditorApi();
            }
            return null;
        }

        public final boolean c() {
            return Wink.f326307c;
        }

        public final void d(@NotNull f winkThreadApi, @Nullable z93.a winkEditorApi, @Nullable b winkNavigateApi, @Nullable d winkReportApi, @Nullable c winkQualityReportApi, @Nullable e winkResourceApi) {
            Intrinsics.checkNotNullParameter(winkThreadApi, "winkThreadApi");
            if (c()) {
                return;
            }
            w53.b.f("Wink-SDK", "init");
            Wink.f326307c = true;
            Wink.f326308d = new Wink(null);
            Wink wink = Wink.f326308d;
            if (wink != null) {
                wink.apiContainer = new a(winkThreadApi, winkEditorApi, winkNavigateApi, winkReportApi, winkQualityReportApi, winkResourceApi);
            }
        }

        @Nullable
        public final b e() {
            a aVar;
            Wink wink = Wink.f326308d;
            if (wink != null && (aVar = wink.apiContainer) != null) {
                return aVar.getWinkNavigateApi();
            }
            return null;
        }

        @Nullable
        public final c f() {
            a aVar;
            Wink wink = Wink.f326308d;
            if (wink != null && (aVar = wink.apiContainer) != null) {
                return aVar.getWinkQualityReportApi();
            }
            return null;
        }

        @Nullable
        public final d g() {
            a aVar;
            Wink wink = Wink.f326308d;
            if (wink != null && (aVar = wink.apiContainer) != null) {
                return aVar.getWinkReportApi();
            }
            return null;
        }

        @Nullable
        public final e h() {
            a aVar;
            Wink wink = Wink.f326308d;
            if (wink != null && (aVar = wink.apiContainer) != null) {
                return aVar.getWinkResourceApi();
            }
            return null;
        }

        @NotNull
        public final f i() {
            a aVar;
            f winkThreadApi;
            Wink wink = Wink.f326308d;
            if (wink == null || (aVar = wink.apiContainer) == null || (winkThreadApi = aVar.getWinkThreadApi()) == null) {
                return b();
            }
            return winkThreadApi;
        }

        Companion() {
        }
    }

    static {
        Lazy<aa3.a> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<aa3.a>() { // from class: com.tencent.mobileqq.wink.sdk.Wink$Companion$defaultThreadApiImpl$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final aa3.a invoke() {
                return new aa3.a();
            }
        });
        f326309e = lazy;
    }

    public /* synthetic */ Wink(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    Wink() {
    }
}
