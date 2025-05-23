package com.tencent.mobileqq.vas.kuikly.reader;

import android.graphics.Typeface;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00070\u0006R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u000bR \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/reader/a;", "", "", "fontFamily", "Landroid/graphics/Typeface;", "b", "Lkotlin/Function1;", "", "result", "a", "", "[Ljava/lang/String;", "FONT_EXTENSIONS", "", "c", "Ljava/util/Map;", "mFontCache", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f309900a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String[] FONT_EXTENSIONS = {".ttf", ".otf"};

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Typeface> mFontCache = new HashMap();

    a() {
    }

    private final Typeface b(String fontFamily) {
        String hippyFontRootDir = HippyUtils.getHippyFontRootDir();
        for (String str : FONT_EXTENSIONS) {
            String str2 = hippyFontRootDir + fontFamily + str;
            File file = new File(str2);
            if (file.exists()) {
                QLog.i("KuiklyFontUtils", 1, "useQQFontFile file:" + file);
                return Typeface.createFromFile(str2);
            }
        }
        return null;
    }

    public final void a(@NotNull String fontFamily, @NotNull Function1<? super Typeface, Unit> result) {
        boolean z16;
        Intrinsics.checkNotNullParameter(fontFamily, "fontFamily");
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            if (fontFamily.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                result.invoke(null);
                return;
            }
            Map<String, Typeface> map = mFontCache;
            if (map.containsKey(fontFamily) && map.get(fontFamily) != null) {
                result.invoke(map.get(fontFamily));
                return;
            }
            Typeface b16 = b(fontFamily);
            if (b16 != null) {
                map.put(fontFamily, b16);
            }
            result.invoke(b16);
        } catch (Exception e16) {
            QLog.e("KuiklyFontUtils", 1, "getTypeface e:" + e16);
            result.invoke(null);
        }
    }
}
