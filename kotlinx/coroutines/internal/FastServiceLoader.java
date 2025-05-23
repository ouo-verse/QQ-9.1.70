package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J!\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\u0004H\u0082\bJ1\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\bH\u0002\u00a2\u0006\u0002\u0010\u0010J*\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0012\"\u0004\b\u0000\u0010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0012H\u0000\u00a2\u0006\u0002\b\u0014J/\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0012\"\u0004\b\u0000\u0010\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\b2\u0006\u0010\r\u001a\u00020\u000eH\u0000\u00a2\u0006\u0002\b\u0016J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J,\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e*\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u0002H\u001e0!H\u0082\b\u00a2\u0006\u0002\u0010\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lkotlinx/coroutines/internal/FastServiceLoader;", "", "()V", "PREFIX", "", "createInstanceOf", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "baseClass", "Ljava/lang/Class;", "serviceClass", "getProviderInstance", ExifInterface.LATITUDE_SOUTH, "name", "loader", "Ljava/lang/ClassLoader;", "service", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "load", "", "loadMainDispatcherFactory", "loadMainDispatcherFactory$kotlinx_coroutines_core", "loadProviders", "loadProviders$kotlinx_coroutines_core", "parse", "url", "Ljava/net/URL;", "parseFile", "r", "Ljava/io/BufferedReader;", TransFileControllerImpl.VALUE_USE_PRE_CONN, BdhLogUtil.LogTag.Tag_Req, "Ljava/util/jar/JarFile;", "block", "Lkotlin/Function1;", "(Ljava/util/jar/JarFile;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class FastServiceLoader {

    @NotNull
    public static final FastServiceLoader INSTANCE = new FastServiceLoader();

    @NotNull
    private static final String PREFIX = "META-INF/services/";

    FastServiceLoader() {
    }

    private final MainDispatcherFactory createInstanceOf(Class<MainDispatcherFactory> baseClass, String serviceClass) {
        try {
            return baseClass.cast(Class.forName(serviceClass, true, baseClass.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    private final <S> S getProviderInstance(String name, ClassLoader loader, Class<S> service) {
        Class<?> cls = Class.forName(name, false, loader);
        if (service.isAssignableFrom(cls)) {
            return service.cast(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + service + ", but found " + cls).toString());
    }

    private final <S> List<S> load(Class<S> service, ClassLoader loader) {
        List<S> list;
        try {
            return loadProviders$kotlinx_coroutines_core(service, loader);
        } catch (Throwable unused) {
            list = CollectionsKt___CollectionsKt.toList(ServiceLoader.load(service, loader));
            return list;
        }
    }

    private final List<String> parse(URL url) {
        boolean startsWith$default;
        BufferedReader bufferedReader;
        String substringAfter$default;
        String substringBefore$default;
        String substringAfter$default2;
        String url2 = url.toString();
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url2, HttpMsg.FILE_JAR, false, 2, null);
        if (startsWith$default) {
            substringAfter$default = StringsKt__StringsKt.substringAfter$default(url2, "jar:file:", (String) null, 2, (Object) null);
            substringBefore$default = StringsKt__StringsKt.substringBefore$default(substringAfter$default, '!', (String) null, 2, (Object) null);
            substringAfter$default2 = StringsKt__StringsKt.substringAfter$default(url2, "!/", (String) null, 2, (Object) null);
            JarFile jarFile = new JarFile(substringBefore$default, false);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(substringAfter$default2)), "UTF-8"));
                try {
                    List<String> parseFile = INSTANCE.parseFile(bufferedReader);
                    CloseableKt.closeFinally(bufferedReader, null);
                    jarFile.close();
                    return parseFile;
                } finally {
                }
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    try {
                        jarFile.close();
                        throw th6;
                    } catch (Throwable th7) {
                        ExceptionsKt__ExceptionsKt.addSuppressed(th5, th7);
                        throw th5;
                    }
                }
            }
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            try {
                List<String> parseFile2 = INSTANCE.parseFile(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
                return parseFile2;
            } catch (Throwable th8) {
                try {
                    throw th8;
                } finally {
                }
            }
        }
    }

    private final List<String> parseFile(BufferedReader r16) {
        List<String> list;
        String substringBefore$default;
        CharSequence trim;
        boolean z16;
        boolean z17;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = r16.readLine();
            if (readLine == null) {
                list = CollectionsKt___CollectionsKt.toList(linkedHashSet);
                return list;
            }
            substringBefore$default = StringsKt__StringsKt.substringBefore$default(readLine, "#", (String) null, 2, (Object) null);
            if (substringBefore$default != null) {
                trim = StringsKt__StringsKt.trim((CharSequence) substringBefore$default);
                String obj = trim.toString();
                boolean z18 = false;
                int i3 = 0;
                while (true) {
                    if (i3 < obj.length()) {
                        char charAt = obj.charAt(i3);
                        if (charAt != '.' && !Character.isJavaIdentifierPart(charAt)) {
                            z17 = false;
                        } else {
                            z17 = true;
                        }
                        if (!z17) {
                            z16 = false;
                            break;
                        }
                        i3++;
                    } else {
                        z16 = true;
                        break;
                    }
                }
                if (z16) {
                    if (obj.length() > 0) {
                        z18 = true;
                    }
                    if (z18) {
                        linkedHashSet.add(obj);
                    }
                } else {
                    throw new IllegalArgumentException(Intrinsics.stringPlus("Illegal service provider class name: ", obj).toString());
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
    }

    private final <R> R use(JarFile jarFile, Function1<? super JarFile, ? extends R> function1) {
        try {
            R invoke = function1.invoke(jarFile);
            InlineMarker.finallyStart(1);
            jarFile.close();
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                InlineMarker.finallyStart(1);
                try {
                    jarFile.close();
                    InlineMarker.finallyEnd(1);
                    throw th6;
                } catch (Throwable th7) {
                    ExceptionsKt__ExceptionsKt.addSuppressed(th5, th7);
                    throw th5;
                }
            }
        }
    }

    @NotNull
    public final List<MainDispatcherFactory> loadMainDispatcherFactory$kotlinx_coroutines_core() {
        MainDispatcherFactory mainDispatcherFactory;
        if (!FastServiceLoaderKt.getANDROID_DETECTED()) {
            return load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            MainDispatcherFactory mainDispatcherFactory2 = null;
            try {
                mainDispatcherFactory = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                mainDispatcherFactory = null;
            }
            if (mainDispatcherFactory != null) {
                arrayList.add(mainDispatcherFactory);
            }
            try {
                mainDispatcherFactory2 = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (mainDispatcherFactory2 != null) {
                arrayList.add(mainDispatcherFactory2);
                return arrayList;
            }
            return arrayList;
        } catch (Throwable unused3) {
            return load(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
    }

    @NotNull
    public final <S> List<S> loadProviders$kotlinx_coroutines_core(@NotNull Class<S> service, @NotNull ClassLoader loader) {
        Set set;
        int collectionSizeOrDefault;
        ArrayList list = Collections.list(loader.getResources(Intrinsics.stringPlus(PREFIX, service.getName())));
        Intrinsics.checkNotNullExpressionValue(list, "java.util.Collections.list(this)");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, INSTANCE.parse((URL) it.next()));
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList);
        if (!set.isEmpty()) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(set, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it5 = set.iterator();
            while (it5.hasNext()) {
                arrayList2.add(INSTANCE.getProviderInstance((String) it5.next(), loader, service));
            }
            return arrayList2;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }
}
