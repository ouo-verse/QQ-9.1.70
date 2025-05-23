package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class BuiltInsResourceLoader {
    @Nullable
    public final InputStream loadResource(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        ClassLoader classLoader = BuiltInsResourceLoader.class.getClassLoader();
        if (classLoader == null) {
            return ClassLoader.getSystemResourceAsStream(path);
        }
        URL resource = classLoader.getResource(path);
        if (resource == null) {
            return null;
        }
        URLConnection openConnection = resource.openConnection();
        openConnection.setUseCaches(false);
        return openConnection.getInputStream();
    }
}
