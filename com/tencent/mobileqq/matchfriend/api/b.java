package com.tencent.mobileqq.matchfriend.api;

import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\tB?\b\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u001a\u0010\u0013\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\t\u0010\u0012R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b\u000e\u0010\u0016\u0082\u0001\u0002\u001a\u001b\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/api/b;", "", "Lcom/tencent/mobileqq/matchfriend/api/GuideBizId;", "a", "Lcom/tencent/mobileqq/matchfriend/api/GuideBizId;", "()Lcom/tencent/mobileqq/matchfriend/api/GuideBizId;", "bizId", "", "", "b", "[Ljava/lang/String;", "d", "()[Ljava/lang/String;", "titles", "c", "e", CoverDBCacheData.URLS, "Ljava/lang/String;", "()Ljava/lang/String;", "btnTitle", "Lcom/tencent/mobileqq/matchfriend/api/c;", "Lcom/tencent/mobileqq/matchfriend/api/c;", "()Lcom/tencent/mobileqq/matchfriend/api/c;", "callback", "<init>", "(Lcom/tencent/mobileqq/matchfriend/api/GuideBizId;[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/matchfriend/api/c;)V", "Lcom/tencent/mobileqq/matchfriend/api/b$a;", "Lcom/tencent/mobileqq/matchfriend/api/b$b;", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuideBizId bizId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String[] titles;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String[] urls;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String btnTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final c callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\b\u0010#\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u001d\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010#\u001a\u0004\u0018\u00010\u001e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/api/b$a;", "Lcom/tencent/mobileqq/matchfriend/api/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/matchfriend/api/GuideBizId;", "f", "Lcom/tencent/mobileqq/matchfriend/api/GuideBizId;", "a", "()Lcom/tencent/mobileqq/matchfriend/api/GuideBizId;", "bizId", "", "g", "[Ljava/lang/String;", "d", "()[Ljava/lang/String;", "titles", h.F, "getImageUrls", "imageUrls", "i", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "btnTitle", "Lcom/tencent/mobileqq/matchfriend/api/c;", "j", "Lcom/tencent/mobileqq/matchfriend/api/c;", "c", "()Lcom/tencent/mobileqq/matchfriend/api/c;", "callback", "<init>", "(Lcom/tencent/mobileqq/matchfriend/api/GuideBizId;[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/matchfriend/api/c;)V", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final /* data */ class a extends b {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuideBizId bizId;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String[] titles;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String[] imageUrls;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String btnTitle;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final c callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull GuideBizId bizId, @NotNull String[] titles, @NotNull String[] imageUrls, @NotNull String btnTitle, @Nullable c cVar) {
            super(bizId, titles, imageUrls, btnTitle, cVar, null);
            Intrinsics.checkNotNullParameter(bizId, "bizId");
            Intrinsics.checkNotNullParameter(titles, "titles");
            Intrinsics.checkNotNullParameter(imageUrls, "imageUrls");
            Intrinsics.checkNotNullParameter(btnTitle, "btnTitle");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bizId, titles, imageUrls, btnTitle, cVar);
                return;
            }
            this.bizId = bizId;
            this.titles = titles;
            this.imageUrls = imageUrls;
            this.btnTitle = btnTitle;
            this.callback = cVar;
        }

        @Override // com.tencent.mobileqq.matchfriend.api.b
        @NotNull
        public GuideBizId a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (GuideBizId) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.bizId;
        }

        @Override // com.tencent.mobileqq.matchfriend.api.b
        @NotNull
        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.btnTitle;
        }

        @Override // com.tencent.mobileqq.matchfriend.api.b
        @Nullable
        public c c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (c) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.callback;
        }

        @Override // com.tencent.mobileqq.matchfriend.api.b
        @NotNull
        public String[] d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String[]) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.titles;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (a() == aVar.a() && Intrinsics.areEqual(d(), aVar.d()) && Intrinsics.areEqual(this.imageUrls, aVar.imageUrls) && Intrinsics.areEqual(b(), aVar.b()) && Intrinsics.areEqual(c(), aVar.c())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
            }
            int hashCode2 = ((((((a().hashCode() * 31) + Arrays.hashCode(d())) * 31) + Arrays.hashCode(this.imageUrls)) * 31) + b().hashCode()) * 31;
            if (c() == null) {
                hashCode = 0;
            } else {
                hashCode = c().hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (String) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return "GuideImageData(bizId=" + a() + ", titles=" + Arrays.toString(d()) + ", imageUrls=" + Arrays.toString(this.imageUrls) + ", btnTitle=" + b() + ", callback=" + c() + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\b\u0010#\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u001d\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010#\u001a\u0004\u0018\u00010\u001e8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/api/b$b;", "Lcom/tencent/mobileqq/matchfriend/api/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/matchfriend/api/GuideBizId;", "f", "Lcom/tencent/mobileqq/matchfriend/api/GuideBizId;", "a", "()Lcom/tencent/mobileqq/matchfriend/api/GuideBizId;", "bizId", "", "g", "[Ljava/lang/String;", "d", "()[Ljava/lang/String;", "titles", h.F, "getPagUrls", "pagUrls", "i", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "btnTitle", "Lcom/tencent/mobileqq/matchfriend/api/c;", "j", "Lcom/tencent/mobileqq/matchfriend/api/c;", "c", "()Lcom/tencent/mobileqq/matchfriend/api/c;", "callback", "<init>", "(Lcom/tencent/mobileqq/matchfriend/api/GuideBizId;[Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/matchfriend/api/c;)V", "matchfriend_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.matchfriend.api.b$b, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static final /* data */ class C8005b extends b {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuideBizId bizId;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String[] titles;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String[] pagUrls;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String btnTitle;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final c callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C8005b(@NotNull GuideBizId bizId, @NotNull String[] titles, @NotNull String[] pagUrls, @NotNull String btnTitle, @Nullable c cVar) {
            super(bizId, titles, pagUrls, btnTitle, cVar, null);
            Intrinsics.checkNotNullParameter(bizId, "bizId");
            Intrinsics.checkNotNullParameter(titles, "titles");
            Intrinsics.checkNotNullParameter(pagUrls, "pagUrls");
            Intrinsics.checkNotNullParameter(btnTitle, "btnTitle");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bizId, titles, pagUrls, btnTitle, cVar);
                return;
            }
            this.bizId = bizId;
            this.titles = titles;
            this.pagUrls = pagUrls;
            this.btnTitle = btnTitle;
            this.callback = cVar;
        }

        @Override // com.tencent.mobileqq.matchfriend.api.b
        @NotNull
        public GuideBizId a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (GuideBizId) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.bizId;
        }

        @Override // com.tencent.mobileqq.matchfriend.api.b
        @NotNull
        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.btnTitle;
        }

        @Override // com.tencent.mobileqq.matchfriend.api.b
        @Nullable
        public c c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (c) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.callback;
        }

        @Override // com.tencent.mobileqq.matchfriend.api.b
        @NotNull
        public String[] d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String[]) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.titles;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof C8005b)) {
                return false;
            }
            C8005b c8005b = (C8005b) other;
            if (a() == c8005b.a() && Intrinsics.areEqual(d(), c8005b.d()) && Intrinsics.areEqual(this.pagUrls, c8005b.pagUrls) && Intrinsics.areEqual(b(), c8005b.b()) && Intrinsics.areEqual(c(), c8005b.c())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
            }
            int hashCode2 = ((((((a().hashCode() * 31) + Arrays.hashCode(d())) * 31) + Arrays.hashCode(this.pagUrls)) * 31) + b().hashCode()) * 31;
            if (c() == null) {
                hashCode = 0;
            } else {
                hashCode = c().hashCode();
            }
            return hashCode2 + hashCode;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (String) iPatchRedirector.redirect((short) 13, (Object) this);
            }
            return "GuidePagData(bizId=" + a() + ", titles=" + Arrays.toString(d()) + ", pagUrls=" + Arrays.toString(this.pagUrls) + ", btnTitle=" + b() + ", callback=" + c() + ")";
        }
    }

    public /* synthetic */ b(GuideBizId guideBizId, String[] strArr, String[] strArr2, String str, c cVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(guideBizId, strArr, strArr2, str, cVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, this, guideBizId, strArr, strArr2, str, cVar, defaultConstructorMarker);
    }

    @NotNull
    public abstract GuideBizId a();

    @NotNull
    public abstract String b();

    @Nullable
    public abstract c c();

    @NotNull
    public abstract String[] d();

    @NotNull
    public String[] e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.urls;
    }

    b(GuideBizId guideBizId, String[] strArr, String[] strArr2, String str, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, guideBizId, strArr, strArr2, str, cVar);
            return;
        }
        this.bizId = guideBizId;
        this.titles = strArr;
        this.urls = strArr2;
        this.btnTitle = str;
        this.callback = cVar;
    }
}
