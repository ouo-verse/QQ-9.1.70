package com.tencent.cachedrawable.dynamicdrawable.api;

import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k;
import com.tencent.cachedrawable.dynamicdrawable.e;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\u0003\u0006\u0007B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/api/a;", "", "Lcom/tencent/cachedrawable/dynamicdrawable/api/a$a;", "a", "<init>", "()V", "b", "c", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes5.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f98840a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\t\b\u0000\u00a2\u0006\u0004\b;\u0010<J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0002J\u001c\u0010\u0012\u001a\u00020\u00002\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000eH\u0007J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0013J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001aJ\u0016\u0010 \u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dJ\u0016\u0010$\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!J\u0006\u0010&\u001a\u00020%R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010(R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010(R\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010*R\u0018\u0010,\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010(R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010.R\u0016\u00101\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u00100R\u0018\u00103\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u00102R\u0014\u00105\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u00104R\u0018\u00107\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u00106R\u0018\u00108\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00106R\u0016\u0010:\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010.\u00a8\u0006="}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/api/a$a;", "", "", "url", "k", "", "bid", "scid", "j", "Lcom/tencent/cachedrawable/dynamicdrawable/api/a$b;", "impl", "l", "path", "d", "Lkotlin/Function1;", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/k;", "", "block", h.F, "Lcom/tencent/cachedrawable/dynamicdrawable/api/a$c;", "g", "tag", "i", "Lcom/tencent/cachedrawable/dynamicdrawable/e;", "decoder", "c", "Lcom/tencent/cachedrawable/dynamicdrawable/c;", QDLog.TAG_DOWNLOAD, "b", "", "centerX", "centerY", "e", "", "xRegions", "yRegions", "f", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/FastDynamicDrawable;", "a", "J", "Ljava/lang/String;", "filePath", "Lcom/tencent/cachedrawable/dynamicdrawable/api/a$b;", "cacheFileLogic", "sceneTag", "", "Z", "isUse2BitmapMode", "Lcom/tencent/cachedrawable/dynamicdrawable/e;", "decoderFactory", "Lcom/tencent/cachedrawable/dynamicdrawable/c;", "downloaderFactory", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/k;", "options", "[I", "ninePatchXRegions", "ninePatchYRegions", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "disableHardWare", "<init>", "()V", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.cachedrawable.dynamicdrawable.api.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C1005a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long bid;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String scid;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String url;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String filePath;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private b cacheFileLogic;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String sceneTag;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private boolean isUse2BitmapMode;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private e decoderFactory;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private com.tencent.cachedrawable.dynamicdrawable.c downloaderFactory;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final k options;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private int[] ninePatchXRegions;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private int[] ninePatchYRegions;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private boolean disableHardWare;

        public C1005a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.scid = "";
            this.url = "";
            this.filePath = "";
            this.decoderFactory = com.tencent.cachedrawable.dynamicdrawable.business.dynamicInit.a.f98862a.a();
            this.options = new k();
        }

        @NotNull
        public final FastDynamicDrawable a() {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            String cacheFilePath;
            boolean z26;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (FastDynamicDrawable) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            boolean z27 = true;
            if (this.filePath.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                b bVar = this.cacheFileLogic;
                if (bVar == null) {
                    cacheFilePath = null;
                } else {
                    cacheFilePath = bVar.getCacheFilePath(this.url);
                }
                if (cacheFilePath != null && cacheFilePath.length() != 0) {
                    z26 = false;
                } else {
                    z26 = true;
                }
                if (!z26) {
                    this.filePath = cacheFilePath;
                } else {
                    throw new RuntimeException("\u5fc5\u987b\u4f20\u5165\u7f13\u5b58\u8def\u5f84\uff0c\u4e00\u822c\u60c5\u51b5\u4e0b\u9700\u8981\u653e\u5728\u4e1a\u52a1\u81ea\u5df1\u7684\u76ee\u5f55\u5185");
                }
            }
            String str = this.sceneTag;
            if (str != null) {
                this.options.F(str);
            }
            com.tencent.cachedrawable.dynamicdrawable.c cVar = this.downloaderFactory;
            if (cVar != null) {
                this.options.v(cVar);
            }
            this.options.G(this.isUse2BitmapMode);
            k kVar = this.options;
            com.tencent.cachedrawable.dynamicdrawable.business.toggle.a aVar = com.tencent.cachedrawable.dynamicdrawable.business.toggle.a.f98868a;
            if (!aVar.h() && !this.disableHardWare) {
                z17 = false;
            } else {
                z17 = true;
            }
            kVar.u(z17);
            int[] iArr = this.ninePatchXRegions;
            if (iArr != null) {
                this.options.z(iArr);
            }
            int[] iArr2 = this.ninePatchYRegions;
            if (iArr2 != null) {
                this.options.A(iArr2);
            }
            k kVar2 = this.options;
            if (kVar2.o() && aVar.k()) {
                z18 = true;
            } else {
                z18 = false;
            }
            kVar2.H(z18);
            k kVar3 = this.options;
            if (kVar3.p() && aVar.m()) {
                z19 = true;
            } else {
                z19 = false;
            }
            kVar3.I(z19);
            if (this.scid.length() <= 0) {
                z27 = false;
            }
            if (z27) {
                return new FastDynamicDrawable(this.bid, this.scid, this.filePath, this.decoderFactory, this.options);
            }
            return new FastDynamicDrawable(this.url, this.filePath, this.decoderFactory, this.options);
        }

        @NotNull
        public final C1005a b(@NotNull com.tencent.cachedrawable.dynamicdrawable.c downloader) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (C1005a) iPatchRedirector.redirect((short) 10, (Object) this, (Object) downloader);
            }
            Intrinsics.checkNotNullParameter(downloader, "downloader");
            this.downloaderFactory = downloader;
            return this;
        }

        @NotNull
        public final C1005a c(@NotNull e decoder) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (C1005a) iPatchRedirector.redirect((short) 9, (Object) this, (Object) decoder);
            }
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            this.decoderFactory = decoder;
            return this;
        }

        @NotNull
        public final C1005a d(@NotNull String path) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (C1005a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) path);
            }
            Intrinsics.checkNotNullParameter(path, "path");
            this.filePath = path;
            return this;
        }

        @NotNull
        public final C1005a e(int centerX, int centerY) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (C1005a) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(centerX), Integer.valueOf(centerY));
            }
            return f(new int[]{centerX, centerX + 1}, new int[]{centerY, centerY + 1});
        }

        @NotNull
        public final C1005a f(@NotNull int[] xRegions, @NotNull int[] yRegions) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (C1005a) iPatchRedirector.redirect((short) 14, (Object) this, (Object) xRegions, (Object) yRegions);
            }
            Intrinsics.checkNotNullParameter(xRegions, "xRegions");
            Intrinsics.checkNotNullParameter(yRegions, "yRegions");
            this.ninePatchXRegions = xRegions;
            this.ninePatchYRegions = yRegions;
            return this;
        }

        @NotNull
        public final C1005a g(@NotNull c block) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (C1005a) iPatchRedirector.redirect((short) 7, (Object) this, (Object) block);
            }
            Intrinsics.checkNotNullParameter(block, "block");
            block.a(this.options);
            return this;
        }

        @Deprecated(message = "\u4f7f\u7528\u4e0b\u9762\u7684\u63a5\u53e3\uff0c\u65b9\u4fbfjava\u4f7f\u7528")
        @NotNull
        public final C1005a h(@NotNull Function1<? super k, Unit> block) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (C1005a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) block);
            }
            Intrinsics.checkNotNullParameter(block, "block");
            block.invoke(this.options);
            return this;
        }

        @NotNull
        public final C1005a i(@NotNull String tag) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (C1005a) iPatchRedirector.redirect((short) 8, (Object) this, (Object) tag);
            }
            Intrinsics.checkNotNullParameter(tag, "tag");
            this.sceneTag = tag;
            return this;
        }

        @NotNull
        public final C1005a j(long bid, @NotNull String scid) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (C1005a) iPatchRedirector.redirect((short) 3, this, Long.valueOf(bid), scid);
            }
            Intrinsics.checkNotNullParameter(scid, "scid");
            this.bid = bid;
            this.scid = scid;
            return this;
        }

        @NotNull
        public final C1005a k(@NotNull String url) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (C1005a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
            }
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            return this;
        }

        @NotNull
        public final C1005a l(@NotNull b impl) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (C1005a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) impl);
            }
            Intrinsics.checkNotNullParameter(impl, "impl");
            this.cacheFileLogic = impl;
            return this;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/api/a$b;", "", "", "url", "getCacheFilePath", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes5.dex */
    public interface b {
        @NotNull
        String getCacheFilePath(@NotNull String url);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u00a6\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/cachedrawable/dynamicdrawable/api/a$c;", "", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/k;", "options", "", "a", "cachedrawable_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes5.dex */
    public interface c {
        void a(@NotNull k options);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7708);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f98840a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    @NotNull
    public static final C1005a a() {
        return new C1005a();
    }
}
