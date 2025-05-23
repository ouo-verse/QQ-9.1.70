package com.tencent.qqnt.aio.forward;

import android.text.TextUtils;
import com.tencent.mobileqq.aio.utils.aj;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J<\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u0004*\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/forward/k;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", "", "d", "", "width", "height", "thumbMaxSize", "thumbMinSize", "", "limitSize", "Lkotlin/Pair;", "c", "b", "path", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class k {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f349976a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63483);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f349976a = new k();
        }
    }

    k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String b(PicElement picElement) {
        for (String str : aj.c(picElement)) {
            if (a(str)) {
                return str;
            }
        }
        String a16 = aj.a(picElement);
        if (a(a16)) {
            return a16;
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final Pair<Integer, Integer> c(int width, int height, int thumbMaxSize, int thumbMinSize, boolean limitSize) {
        int coerceAtMost;
        int coerceAtMost2;
        float f16;
        float f17;
        if (width >= thumbMinSize && height >= thumbMinSize) {
            if (width >= thumbMaxSize || height >= thumbMaxSize) {
                float f18 = thumbMaxSize;
                if (width > height) {
                    f16 = width;
                } else {
                    f16 = height;
                }
                float f19 = f18 / f16;
                float f26 = thumbMinSize;
                if (width > height) {
                    f17 = height;
                } else {
                    f17 = width;
                }
                float max = Math.max(f19, f26 / f17);
                width = (int) ((width * max) + 0.5f);
                height = (int) ((height * max) + 0.5f);
            }
        } else if (width < height) {
            int i3 = (int) ((height * (thumbMinSize / width)) + 0.5f);
            if (i3 > thumbMaxSize) {
                height = thumbMaxSize;
            } else {
                height = i3;
            }
            width = thumbMinSize;
        } else {
            width = (int) ((width * (thumbMinSize / height)) + 0.5f);
            if (width > thumbMaxSize) {
                width = thumbMaxSize;
            }
            height = thumbMinSize;
        }
        if (limitSize) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(width, thumbMaxSize);
            Integer valueOf = Integer.valueOf(coerceAtMost);
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(height, thumbMaxSize);
            return new Pair<>(valueOf, Integer.valueOf(coerceAtMost2));
        }
        return new Pair<>(Integer.valueOf(width), Integer.valueOf(height));
    }

    @JvmStatic
    @Nullable
    public static final String d(@NotNull PicElement picElement) {
        Intrinsics.checkNotNullParameter(picElement, "picElement");
        return f349976a.b(picElement);
    }

    public final boolean a(@Nullable String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) path)).booleanValue();
        }
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        Intrinsics.checkNotNull(path);
        if (new File(path).length() <= 0) {
            return false;
        }
        return true;
    }
}
