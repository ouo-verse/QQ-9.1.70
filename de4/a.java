package de4;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.light.Config;
import org.light.FontAsset;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0006R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lde4/a;", "", "", "fontFamily", "fontStyle", "fontPath", "", "b", "a", "", "Ljava/util/Map;", "registeredFontMap", "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f393661b = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, String> registeredFontMap = new LinkedHashMap();

    a() {
    }

    public final void a() {
        registeredFontMap.clear();
    }

    public final void b(@NotNull String fontFamily, @NotNull String fontStyle, @NotNull String fontPath) {
        Intrinsics.checkParameterIsNotNull(fontFamily, "fontFamily");
        Intrinsics.checkParameterIsNotNull(fontStyle, "fontStyle");
        Intrinsics.checkParameterIsNotNull(fontPath, "fontPath");
        String str = fontFamily + '-' + fontStyle;
        Map<String, String> map = registeredFontMap;
        if (map.containsKey(str)) {
            return;
        }
        map.put(str, fontPath);
        Config.registerFont(new FontAsset(fontFamily, fontStyle), fontPath);
    }
}
