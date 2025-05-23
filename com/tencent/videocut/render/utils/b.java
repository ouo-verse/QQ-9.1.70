package com.tencent.videocut.render.utils;

import android.util.LruCache;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightAsset;
import org.light.lightAssetKit.LightAssetDataContext;
import org.light.lightAssetKit.LightAssetDataType;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\r\u001a\u00020\fR\"\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\"\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\"\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/videocut/render/utils/b;", "", "Lcom/tencent/videocut/render/utils/b$a;", "templateFillParams", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "b", "", "templateJsonPath", "Lorg/light/lightAssetKit/LightAssetDataContext;", "d", "Lorg/light/LightAsset;", "c", "", "a", "Landroid/util/LruCache;", "Landroid/util/LruCache;", "lightAssetDataContextCache", "lightAssetCache", "templateFillParamsCache", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f384205a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LruCache<String, LightAssetDataContext> lightAssetDataContextCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LruCache<String, LightAsset> lightAssetCache;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final LruCache<a, LAKRenderModel> templateFillParamsCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/videocut/render/utils/b$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "jsonFilePath", "", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "Ljava/util/List;", "()Ljava/util/List;", "clipAssets", "c", "Z", "()Z", "modifyClipsDuration", "<init>", "(Ljava/lang/String;Ljava/util/List;Z)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes27.dex */
    public static final /* data */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final String jsonFilePath;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<ClipSource> clipAssets;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final boolean modifyClipsDuration;

        public a(@Nullable String str, @NotNull List<ClipSource> clipAssets, boolean z16) {
            Intrinsics.checkNotNullParameter(clipAssets, "clipAssets");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, clipAssets, Boolean.valueOf(z16));
                return;
            }
            this.jsonFilePath = str;
            this.clipAssets = clipAssets;
            this.modifyClipsDuration = z16;
        }

        @NotNull
        public final List<ClipSource> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (List) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.clipAssets;
        }

        @Nullable
        public final String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.jsonFilePath;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.modifyClipsDuration;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof a)) {
                return false;
            }
            a aVar = (a) other;
            if (Intrinsics.areEqual(this.jsonFilePath, aVar.jsonFilePath) && Intrinsics.areEqual(this.clipAssets, aVar.clipAssets) && this.modifyClipsDuration == aVar.modifyClipsDuration) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            String str = this.jsonFilePath;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int hashCode2 = ((hashCode * 31) + this.clipAssets.hashCode()) * 31;
            boolean z16 = this.modifyClipsDuration;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode2 + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return "TemplateFillParams(jsonFilePath=" + this.jsonFilePath + ", clipAssets=" + this.clipAssets + ", modifyClipsDuration=" + this.modifyClipsDuration + ")";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59880);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f384205a = new b();
        lightAssetDataContextCache = new LruCache<>(8);
        lightAssetCache = new LruCache<>(8);
        templateFillParamsCache = new LruCache<>(8);
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        lightAssetDataContextCache.evictAll();
        lightAssetCache.evictAll();
        templateFillParamsCache.evictAll();
    }

    @Nullable
    public final LAKRenderModel b(@NotNull a templateFillParams) {
        boolean z16;
        String b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LAKRenderModel) iPatchRedirector.redirect((short) 2, (Object) this, (Object) templateFillParams);
        }
        Intrinsics.checkNotNullParameter(templateFillParams, "templateFillParams");
        LruCache<a, LAKRenderModel> lruCache = templateFillParamsCache;
        LAKRenderModel lAKRenderModel = lruCache.get(templateFillParams);
        if (lAKRenderModel == null) {
            String b17 = templateFillParams.b();
            if (b17 != null && b17.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                b16 = r73.a.f430927a.b();
            } else {
                b16 = templateFillParams.b();
            }
            lAKRenderModel = rd4.c.f431135f.k(b16, templateFillParams.a(), templateFillParams.c());
            if (lAKRenderModel != null) {
                lruCache.put(templateFillParams, lAKRenderModel);
            }
        }
        return lAKRenderModel;
    }

    @Nullable
    public final LightAsset c(@Nullable String templateJsonPath) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LightAsset) iPatchRedirector.redirect((short) 4, (Object) this, (Object) templateJsonPath);
        }
        if (templateJsonPath != null && templateJsonPath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        LruCache<String, LightAsset> lruCache = lightAssetCache;
        LightAsset lightAsset = lruCache.get(templateJsonPath);
        if (lightAsset == null && (lightAsset = LightAsset.Load(templateJsonPath, 0)) != null) {
            lruCache.put(templateJsonPath, lightAsset);
        }
        ms.a.a("WinkLakCache", "load LightAsset cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return lightAsset;
    }

    @Nullable
    public final LightAssetDataContext d(@Nullable String templateJsonPath) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LightAssetDataContext) iPatchRedirector.redirect((short) 3, (Object) this, (Object) templateJsonPath);
        }
        if (templateJsonPath != null && templateJsonPath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        LruCache<String, LightAssetDataContext> lruCache = lightAssetDataContextCache;
        LightAssetDataContext lightAssetDataContext = lruCache.get(templateJsonPath);
        if (lightAssetDataContext == null && (lightAssetDataContext = LightAssetDataContext.make(f384205a.c(templateJsonPath), LightAssetDataType.EntityTree)) != null) {
            lruCache.put(templateJsonPath, lightAssetDataContext);
        }
        ms.a.a("WinkLakCache", "load " + templateJsonPath + " LightAssetDataContext cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return lightAssetDataContext;
    }
}
