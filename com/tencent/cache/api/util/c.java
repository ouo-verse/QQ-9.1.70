package com.tencent.cache.api.util;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import com.tencent.cache.api.f;
import com.tencent.cache.api.g;
import com.tencent.cache.core.size.graph.d;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fJ\u001e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/cache/api/util/c;", "", "Landroid/graphics/Bitmap$Config;", DownloadInfo.spKey_Config, "", "c", "target", "", "computeDeep", "computeNative", "useCache", "d", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "b", "width", "height", "a", "<init>", "()V", "Library_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final c f98640a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13510);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f98640a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int c(Bitmap.Config r36) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT >= 26) {
            config = Bitmap.Config.RGBA_F16;
            if (r36 == config) {
                return 8;
            }
        }
        int i3 = b.f98639a[r36.ordinal()];
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 2 || i3 == 3) {
            return 2;
        }
        return 4;
    }

    public static /* synthetic */ int e(c cVar, Object obj, boolean z16, boolean z17, boolean z18, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        if ((i3 & 8) != 0) {
            z18 = true;
        }
        return cVar.d(obj, z16, z17, z18);
    }

    public final int a(int width, int height, @NotNull Bitmap.Config r75) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(width), Integer.valueOf(height), r75)).intValue();
        }
        Intrinsics.checkNotNullParameter(r75, "config");
        return width * height * c(r75);
    }

    public final int b(@NotNull Bitmap r56) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) r56)).intValue();
        }
        Intrinsics.checkNotNullParameter(r56, "bitmap");
        if (r56.isRecycled()) {
            com.tencent.cache.core.util.b.f98833f.j("SizeUtil", 2, "Cannot obtain size for recycled Bitmap");
            return 0;
        }
        try {
            return r56.getAllocationByteCount();
        } catch (NullPointerException unused) {
            return r56.getRowBytes() * r56.getHeight();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0162 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int d(@NotNull Object target, boolean computeDeep, boolean computeNative, boolean useCache) {
        long j3;
        Object a16;
        int i3;
        int size;
        Object obj;
        Object obj2;
        int i16;
        Iterator it;
        boolean z16;
        Bitmap bitmap;
        int length;
        int length2;
        int length3;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, target, Boolean.valueOf(computeDeep), Boolean.valueOf(computeNative), Boolean.valueOf(useCache))).intValue();
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if ((target instanceof Boolean) || (target instanceof Byte)) {
            return 1;
        }
        if ((target instanceof Character) || (target instanceof Short)) {
            return 2;
        }
        if ((target instanceof Float) || (target instanceof Integer)) {
            return 4;
        }
        if (!(target instanceof Double) && !(target instanceof Long)) {
            if (target instanceof boolean[]) {
                length = ((boolean[]) target).length;
            } else if (target instanceof byte[]) {
                length = ((byte[]) target).length;
            } else {
                if (target instanceof char[]) {
                    length3 = ((char[]) target).length;
                } else if (target instanceof short[]) {
                    length3 = ((short[]) target).length;
                } else {
                    if (target instanceof float[]) {
                        length2 = ((float[]) target).length;
                    } else if (target instanceof int[]) {
                        length2 = ((int[]) target).length;
                    } else if (target instanceof double[]) {
                        length2 = ((double[]) target).length;
                    } else if (target instanceof long[]) {
                        length2 = ((long[]) target).length;
                    } else {
                        if (!Intrinsics.areEqual(Object.class, target.getClass())) {
                            if (target instanceof String) {
                                length = ((String) target).length();
                            } else if (!(target instanceof Reference) && !(target instanceof ReferenceQueue)) {
                                if (target instanceof Bitmap) {
                                    if (computeNative) {
                                        bitmap = (Bitmap) target;
                                    } else {
                                        return 51;
                                    }
                                } else {
                                    if (target instanceof BitmapDrawable) {
                                        if (computeNative) {
                                            BitmapDrawable bitmapDrawable = (BitmapDrawable) target;
                                            if (bitmapDrawable.getBitmap() != null) {
                                                bitmap = bitmapDrawable.getBitmap();
                                                Intrinsics.checkNotNullExpressionValue(bitmap, "target.bitmap");
                                            }
                                        }
                                        return 77;
                                    }
                                    if ((target instanceof f) && computeNative) {
                                        return ((f) target).getByteSize();
                                    }
                                    if ((target instanceof g) && computeNative) {
                                        return ((g) target).a();
                                    }
                                    if (useCache) {
                                        int i18 = com.tencent.cache.core.size.graph.b.f98791b.a(target.getClass()).f98792a;
                                        if (i18 != -1) {
                                            z16 = true;
                                        } else {
                                            z16 = false;
                                        }
                                        if (z16) {
                                            return i18;
                                        }
                                    }
                                    if (computeDeep) {
                                        if (com.tencent.cache.core.util.a.a(target)) {
                                            Intrinsics.checkNotNullParameter(target, "target");
                                            Intrinsics.checkNotNullParameter(target, "target");
                                            if (target instanceof Collection) {
                                                size = ((Collection) target).size();
                                            } else if (target instanceof Map) {
                                                size = ((Map) target).size();
                                            } else {
                                                i3 = 0;
                                                if (i3 != 0) {
                                                    if (target instanceof Collection) {
                                                        it = ((Collection) target).iterator();
                                                    } else {
                                                        if (target instanceof Map) {
                                                            it = ((Map) target).entrySet().iterator();
                                                        }
                                                        obj = null;
                                                        obj2 = obj;
                                                        if (!(obj2 instanceof Map.Entry)) {
                                                            Map.Entry entry = (Map.Entry) obj2;
                                                            Object key = entry.getKey();
                                                            if (key != null) {
                                                                i16 = e(f98640a, key, true, computeNative, false, 8, null);
                                                            } else {
                                                                i16 = 0;
                                                            }
                                                            Object value = entry.getValue();
                                                            if (value != null) {
                                                                i17 = e(f98640a, value, true, computeNative, false, 8, null);
                                                            }
                                                            return (i16 + i17) * i3;
                                                        }
                                                        if (obj2 != null) {
                                                            i17 = e(f98640a, obj2, true, computeNative, false, 8, null);
                                                        }
                                                        return i3 * i17;
                                                    }
                                                    obj = it.next();
                                                    obj2 = obj;
                                                    if (!(obj2 instanceof Map.Entry)) {
                                                    }
                                                }
                                            }
                                            i3 = size;
                                            if (i3 != 0) {
                                            }
                                        } else {
                                            d dVar = com.tencent.cache.core.size.task.c.f98825a;
                                            Intrinsics.checkNotNullParameter(target, "target");
                                            try {
                                                a16 = com.tencent.cache.core.util.b.f98833f.a("SizeCalculator", "getDeepSize, type:" + target.getClass(), true, new com.tencent.cache.core.size.task.b(useCache, target, computeNative));
                                            } catch (Throwable th5) {
                                                com.tencent.cache.core.util.b.f98833f.b("SizeCalculator", 1, "getDeepSize fail, ", th5);
                                                j3 = 0;
                                            }
                                            if (a16 != null) {
                                                j3 = ((Long) a16).longValue();
                                                return (int) j3;
                                            }
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                                        }
                                    }
                                    return 0;
                                }
                                return b(bitmap);
                            }
                        }
                        return 16;
                    }
                    length = length2 * 4;
                }
                length = length3 * 2;
            }
            return length + 16;
        }
        return 8;
    }
}
