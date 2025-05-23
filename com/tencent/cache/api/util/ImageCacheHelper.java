package com.tencent.cache.api.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.cache.core.manager.store.f;
import com.tencent.cache.core.manager.store.i;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0002J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\"\u0010\f\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\tJ:\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ8\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007J\u0010\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\u0006\u0010\u0019\u001a\u00020\u000bJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001aJ\u000e\u0010!\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u001fJ\u001e\u0010'\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010&\u001a\u00020%\u00a8\u0006*"}, d2 = {"Lcom/tencent/cache/api/util/ImageCacheHelper;", "", "", "method", "key", "value", "", "c", "b", "Lcom/tencent/cache/api/Business;", "business", "", "i", "Lcom/tencent/cache/api/PageHierarchy;", "subBusiness", "Landroid/view/View;", "view", "j", "Lcom/tencent/cache/api/util/Priority;", "priority", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "keyPrefix", DomainData.DOMAIN_NAME, "d", "e", "Landroid/graphics/Bitmap;", "f", "g", MimeHelper.IMAGE_SUBTYPE_BITMAP, "l", "Landroid/graphics/BitmapFactory$Options;", "options", "a", "", "expectedWidth", "expectedHeight", "Landroid/graphics/Bitmap$Config;", "expectedConfig", h.F, "<init>", "()V", "Library_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class ImageCacheHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ImageCacheHelper f98636a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13493);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f98636a = new ImageCacheHelper();
        }
    }

    ImageCacheHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean b(String method, String key) {
        boolean isEmpty = TextUtils.isEmpty(key);
        if (isEmpty) {
            com.tencent.cache.core.util.b.f98833f.j("ImageCacheHelper", 2, method + " fail, key:" + key);
        }
        return !isEmpty;
    }

    private final boolean c(String method, String key, Object value) {
        boolean z16;
        if (!TextUtils.isEmpty(key) && value != null) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            com.tencent.cache.core.util.b.f98833f.j("ImageCacheHelper", 2, method + " fail, key:" + key + ", value:" + value);
        }
        return !z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(@NotNull BitmapFactory.Options options) {
        float f16;
        float coerceAtLeast;
        int roundToInt;
        int roundToInt2;
        Bitmap.Config config;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) options);
            return;
        }
        Intrinsics.checkNotNullParameter(options, "options");
        boolean z16 = false;
        if (options.outWidth > 0 && options.outHeight > 0 && options.inPreferredConfig != null) {
            Intrinsics.checkNotNullParameter(options, "options");
            int i16 = options.inTargetDensity;
            if (i16 > 0 && (i3 = options.inDensity) > 0 && i16 != i3) {
                z16 = true;
            }
            if (z16) {
                f16 = i16 / options.inDensity;
            } else {
                f16 = 1.0f;
            }
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(options.inSampleSize, 1.0f);
            int ceil = (int) Math.ceil(options.outWidth / coerceAtLeast);
            int ceil2 = (int) Math.ceil(options.outHeight / coerceAtLeast);
            roundToInt = MathKt__MathJVMKt.roundToInt(ceil * f16);
            roundToInt2 = MathKt__MathJVMKt.roundToInt(ceil2 * f16);
            Pair pair = new Pair(Integer.valueOf(roundToInt), Integer.valueOf(roundToInt2));
            Intrinsics.checkNotNullParameter(options, "options");
            Bitmap.Config config2 = null;
            if (Build.VERSION.SDK_INT >= 26) {
                Bitmap.Config config3 = options.inPreferredConfig;
                config = Bitmap.Config.HARDWARE;
                if (config3 != config) {
                    config2 = options.outConfig;
                }
                if (config2 == null) {
                    options.inBitmap = i.f98786c.b(((Number) pair.getFirst()).intValue(), ((Number) pair.getSecond()).intValue(), config2);
                    return;
                }
                return;
            }
            if (config2 == null) {
                config2 = options.inPreferredConfig;
            }
            if (config2 == null) {
            }
        } else {
            com.tencent.cache.core.util.b bVar = com.tencent.cache.core.util.b.f98833f;
            StringBuilder a16 = com.tencent.cache.api.collection.c.a("addInBitmapOptions fail, outWidth:");
            a16.append(options.outWidth);
            a16.append(", ");
            a16.append("outHeight:");
            a16.append(options.outHeight);
            a16.append(", config:");
            a16.append(options.inPreferredConfig);
            bVar.j("ImageCacheHelper", 2, a16.toString());
        }
    }

    @Deprecated(message = "Priority parameter will be deleted in subsequent versions and is no longer recommended.", replaceWith = @ReplaceWith(expression = "evictAll", imports = {}))
    public final void d(@NotNull final Priority priority) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) priority);
            return;
        }
        Intrinsics.checkNotNullParameter(priority, "priority");
        com.tencent.cache.core.util.b.f98833f.e("ImageCacheHelper", "evict, " + priority, new Function0<Unit>() { // from class: com.tencent.cache.api.util.ImageCacheHelper$evict$1
            static IPatchRedirector $redirector_;

            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Priority.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                Pair<Integer, Integer> pair = i.f98784a;
                Priority priority2 = Priority.this;
                Intrinsics.checkNotNullParameter(priority2, "priority");
                com.tencent.cache.core.size.task.a.D.c(new f(priority2));
            }
        });
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            com.tencent.cache.core.util.b.f98833f.e("ImageCacheHelper", "evictAll", ImageCacheHelper$evictAll$1.INSTANCE);
        }
    }

    @Nullable
    public final Bitmap f(@Nullable final String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Bitmap) iPatchRedirector.redirect((short) 10, (Object) this, (Object) key);
        }
        if (b("getBitmapFromCache", key)) {
            Object a16 = com.tencent.cache.core.util.b.f98833f.a("ImageCacheHelper", "getBitmapFromCache, " + key, false, new Function0<Object>(key) { // from class: com.tencent.cache.api.util.ImageCacheHelper$getBitmapFromCache$item$1
                static IPatchRedirector $redirector_;
                public final /* synthetic */ String $key;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$key = key;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) key);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Object invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    com.tencent.cache.core.bitmap.cache.c<String, Object> cVar = i.f98785b;
                    String str = this.$key;
                    Intrinsics.checkNotNull(str);
                    com.tencent.cache.core.bitmap.cache.b<String, Object> c16 = cVar.c(str);
                    if (c16 != null) {
                        return c16.f98664f;
                    }
                    return null;
                }
            });
            if (a16 != null && (a16 instanceof Bitmap)) {
                return (Bitmap) a16;
            }
        }
        return null;
    }

    @Nullable
    public final Object g(@Nullable final String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return iPatchRedirector.redirect((short) 11, (Object) this, (Object) key);
        }
        if (b("getBitmapRelatedFromCache", key)) {
            return com.tencent.cache.core.util.b.f98833f.a("ImageCacheHelper", "getBitmapRelatedFromCache, " + key, false, new Function0<Object>(key) { // from class: com.tencent.cache.api.util.ImageCacheHelper$getBitmapRelatedFromCache$1
                static IPatchRedirector $redirector_;
                public final /* synthetic */ String $key;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$key = key;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) key);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final Object invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    com.tencent.cache.core.bitmap.cache.c<String, Object> cVar = i.f98785b;
                    String str = this.$key;
                    Intrinsics.checkNotNull(str);
                    com.tencent.cache.core.bitmap.cache.b<String, Object> c16 = cVar.c(str);
                    if (c16 != null) {
                        return c16.f98664f;
                    }
                    return null;
                }
            });
        }
        return null;
    }

    @NotNull
    public final Bitmap h(int expectedWidth, int expectedHeight, @NotNull Bitmap.Config expectedConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Bitmap) iPatchRedirector.redirect((short) 14, this, Integer.valueOf(expectedWidth), Integer.valueOf(expectedHeight), expectedConfig);
        }
        Intrinsics.checkNotNullParameter(expectedConfig, "expectedConfig");
        return i.f98786c.b(expectedWidth, expectedHeight, expectedConfig);
    }

    public final void i(@Nullable final String key, @Nullable final Object value, @NotNull final Business business) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, key, value, business);
            return;
        }
        Intrinsics.checkNotNullParameter(business, "business");
        if (c("putBitmapRelatedToCache", key, value)) {
            com.tencent.cache.core.util.b.f98833f.e("ImageCacheHelper", "putBitmapRelatedToCache, " + key + ", " + value, new Function0<Unit>(key, value, business) { // from class: com.tencent.cache.api.util.ImageCacheHelper$putBitmapRelatedToCache$1
                static IPatchRedirector $redirector_;
                public final /* synthetic */ Business $business;
                public final /* synthetic */ String $key;
                public final /* synthetic */ Object $value;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$key = key;
                    this.$value = value;
                    this.$business = business;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, key, value, business);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.cache.core.bitmap.cache.c<String, Object> cVar = i.f98785b;
                    String str = this.$key;
                    Intrinsics.checkNotNull(str);
                    Object obj = this.$value;
                    Intrinsics.checkNotNull(obj);
                    Business business2 = this.$business;
                    cVar.getClass();
                    Intrinsics.checkNotNullParameter(business2, "business");
                    cVar.e(str, obj, business2, null, cVar.f98669a == 1 ? Priority.Low : Priority.Normal, null);
                }
            });
        }
    }

    public final void j(@Nullable final String key, @Nullable final Object value, @NotNull final Business business, @Nullable final PageHierarchy subBusiness, @Nullable final View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, key, value, business, subBusiness, view);
            return;
        }
        Intrinsics.checkNotNullParameter(business, "business");
        if (c("putBitmapRelatedToCache", key, value)) {
            com.tencent.cache.core.util.b.f98833f.e("ImageCacheHelper", "putBitmapRelatedToCache, " + key + ", " + value, new Function0<Unit>(key, value, business, subBusiness, view) { // from class: com.tencent.cache.api.util.ImageCacheHelper$putBitmapRelatedToCache$2
                static IPatchRedirector $redirector_;
                public final /* synthetic */ Business $business;
                public final /* synthetic */ String $key;
                public final /* synthetic */ PageHierarchy $subBusiness;
                public final /* synthetic */ Object $value;
                public final /* synthetic */ View $view;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$key = key;
                    this.$value = value;
                    this.$business = business;
                    this.$subBusiness = subBusiness;
                    this.$view = view;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, key, value, business, subBusiness, view);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.cache.core.bitmap.cache.c<String, Object> cVar = i.f98785b;
                    String str = this.$key;
                    Intrinsics.checkNotNull(str);
                    Object obj = this.$value;
                    Intrinsics.checkNotNull(obj);
                    Business business2 = this.$business;
                    PageHierarchy pageHierarchy = this.$subBusiness;
                    String name = pageHierarchy != null ? pageHierarchy.name() : null;
                    View view2 = this.$view;
                    cVar.getClass();
                    Intrinsics.checkNotNullParameter(business2, "business");
                    cVar.e(str, obj, business2, name, cVar.f98669a == 1 ? Priority.Low : Priority.Normal, view2);
                }
            });
        }
    }

    @Deprecated(message = "Priority parameter will be deleted in subsequent versions and is no longer recommended.")
    public final void k(@Nullable final String key, @Nullable final Object value, @NotNull final Business business, @NotNull final Priority priority, @Nullable final View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, key, value, business, priority, view);
            return;
        }
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(priority, "priority");
        if (c("putBitmapRelatedToCache", key, value)) {
            com.tencent.cache.core.util.b.f98833f.e("ImageCacheHelper", "putBitmapRelatedToCache, " + key + ", " + value, new Function0<Unit>(key, value, business, priority, view) { // from class: com.tencent.cache.api.util.ImageCacheHelper$putBitmapRelatedToCache$3
                static IPatchRedirector $redirector_;
                public final /* synthetic */ Business $business;
                public final /* synthetic */ String $key;
                public final /* synthetic */ Priority $priority;
                public final /* synthetic */ Object $value;
                public final /* synthetic */ View $view;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$key = key;
                    this.$value = value;
                    this.$business = business;
                    this.$priority = priority;
                    this.$view = view;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, key, value, business, priority, view);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.cache.core.bitmap.cache.c<String, Object> cVar = i.f98785b;
                    String str = this.$key;
                    Intrinsics.checkNotNull(str);
                    Object obj = this.$value;
                    Intrinsics.checkNotNull(obj);
                    cVar.e(str, obj, this.$business, null, this.$priority, this.$view);
                }
            });
        }
    }

    public final void l(@NotNull Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bitmap);
        } else {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            i.f98786c.d(bitmap);
        }
    }

    public final void m(@Nullable final String key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) key);
            return;
        }
        if (b("removeFormCache", key)) {
            com.tencent.cache.core.util.b.f98833f.e("ImageCacheHelper", "removeFormCache, " + key, new Function0<Unit>(key) { // from class: com.tencent.cache.api.util.ImageCacheHelper$removeFormCache$1
                static IPatchRedirector $redirector_;
                public final /* synthetic */ String $key;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$key = key;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) key);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.cache.core.bitmap.cache.c<String, Object> cVar = i.f98785b;
                    String str = this.$key;
                    Intrinsics.checkNotNull(str);
                    int i3 = cVar.f98669a;
                    for (int i16 = 0; i16 < i3 && cVar.f98671c[i16].j(str) == null; i16++) {
                    }
                }
            });
        }
    }

    public final void n(@Nullable final String keyPrefix) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) keyPrefix);
            return;
        }
        if (b("removeFormCacheWithKeyPrefix", keyPrefix)) {
            com.tencent.cache.core.util.b.f98833f.e("ImageCacheHelper", "removeFormCacheWithKeyPrefix, " + keyPrefix, new Function0<Unit>(keyPrefix) { // from class: com.tencent.cache.api.util.ImageCacheHelper$removeFormCacheWithKeyPrefix$1
                static IPatchRedirector $redirector_;
                public final /* synthetic */ String $keyPrefix;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$keyPrefix = keyPrefix;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) keyPrefix);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    boolean startsWith$default;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.cache.core.bitmap.cache.c<String, Object> cVar = i.f98785b;
                    String str = this.$keyPrefix;
                    Intrinsics.checkNotNull(str);
                    cVar.getClass();
                    if (str instanceof String) {
                        int i3 = cVar.f98669a;
                        for (int i16 = 0; i16 < i3; i16++) {
                            Map<String, com.tencent.cache.core.bitmap.cache.b<String, Object>> map = cVar.f98671c[i16].p();
                            Intrinsics.checkNotNullExpressionValue(map, "map");
                            for (Map.Entry<String, com.tencent.cache.core.bitmap.cache.b<String, Object>> entry : map.entrySet()) {
                                String key = entry.getKey();
                                if (key instanceof String) {
                                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(key, str, false, 2, null);
                                    if (startsWith$default) {
                                        cVar.f98671c[i16].j(entry.getKey());
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
    }
}
