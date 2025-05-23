package cooperation.plugin.patch;

import com.tencent.commonsdk.zip.QZipInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00032\u00020\u0001:\u0001\u0018B\u001b\u0012\u0006\u0010\u001e\u001a\u00020\u0017\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J,\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J:\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J2\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u00112\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0004R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcooperation/plugin/patch/ZipExtractor;", "", "Lcooperation/plugin/patch/b;", "c", "", "parentPath", "filePathToExtract", "", "pathToBuffer", "i", "zipPath", "", "subPaths", tl.h.F, "filesToExtract", "", "f", "", "e", "fileToExtract", "d", "", "g", "Lcom/tencent/commonsdk/zip/QZipInputStream;", "a", "Lcom/tencent/commonsdk/zip/QZipInputStream;", "getInputStream", "()Lcom/tencent/commonsdk/zip/QZipInputStream;", "setInputStream", "(Lcom/tencent/commonsdk/zip/QZipInputStream;)V", "inputStream", "b", "Ljava/lang/String;", "tempDirectory", "<init>", "(Lcom/tencent/commonsdk/zip/QZipInputStream;Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes28.dex */
public final class ZipExtractor {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QZipInputStream inputStream;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final String tempDirectory;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J(\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0002\u00a8\u0006\f"}, d2 = {"Lcooperation/plugin/patch/ZipExtractor$a;", "", "", "", "paths", "", "c", "nestingOps", "", "d", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: cooperation.plugin.patch.ZipExtractor$a, reason: from kotlin metadata */
    /* loaded from: classes28.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<String> c(List<String> paths) {
            ArrayList arrayList = new ArrayList();
            for (int size = paths.size() - 1; size > 0; size--) {
                String str = paths.get(size);
                if (!i.f390366a.f(str) && !arrayList.contains(str)) {
                    arrayList.add(str);
                    paths.remove(size);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Map<String, List<String>> d(List<String> nestingOps) {
            HashMap hashMap = new HashMap();
            for (String str : nestingOps) {
                int h16 = i.f390366a.h(str);
                String substring = str.substring(0, h16);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                List list = (List) hashMap.get(substring);
                if (list == null) {
                    list = new ArrayList();
                }
                String substring2 = str.substring(h16);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                if (!list.contains(substring2)) {
                    list.add(substring2);
                }
                hashMap.put(substring, list);
            }
            return hashMap;
        }

        Companion() {
        }
    }

    public ZipExtractor(@NotNull QZipInputStream inputStream, @Nullable String str) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        this.inputStream = inputStream;
        this.tempDirectory = str;
    }

    private final b c() {
        b a16;
        String str = this.tempDirectory;
        if (str == null || (a16 = j.a(str)) == null) {
            return j.c(null, 1, null);
        }
        return a16;
    }

    private final void f(final String parentPath, List<String> filesToExtract, final Map<String, b> pathToBuffer) throws IOException {
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(filesToExtract);
        Companion companion = INSTANCE;
        final Map d16 = companion.d(companion.c(arrayList));
        final Set keySet = d16.keySet();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = arrayList.size();
        final Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = d16.size();
        i.f390366a.e(this.inputStream, new Function1<ZipEntry, Boolean>() { // from class: cooperation.plugin.patch.ZipExtractor$extract$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull ZipEntry zipEntry) {
                Intrinsics.checkNotNullParameter(zipEntry, "zipEntry");
                if (Ref.IntRef.this.element > 0 && arrayList.contains(zipEntry.getName())) {
                    Ref.IntRef intRef3 = Ref.IntRef.this;
                    intRef3.element--;
                    ZipExtractor zipExtractor = this;
                    String str = parentPath;
                    String name = zipEntry.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "zipEntry.name");
                    zipExtractor.i(str, name, pathToBuffer);
                } else if (intRef2.element > 0 && keySet.contains(zipEntry.getName())) {
                    Ref.IntRef intRef4 = intRef2;
                    intRef4.element--;
                    for (String str2 : keySet) {
                        ZipExtractor zipExtractor2 = this;
                        String str3 = parentPath;
                        List<String> list = d16.get(str2);
                        Intrinsics.checkNotNull(list);
                        zipExtractor2.h(str3, str2, list, pathToBuffer);
                    }
                }
                return Boolean.valueOf(Ref.IntRef.this.element > 0 || intRef2.element > 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b h(String parentPath, String zipPath, List<String> subPaths, Map<String, b> pathToBuffer) throws IOException {
        b c16 = c();
        i.f390366a.b(this.inputStream, c16);
        this.inputStream.closeEntry();
        new ZipExtractor(new QZipInputStream(c16.d()), this.tempDirectory).f(parentPath + zipPath + "/", subPaths, pathToBuffer);
        return c16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b i(String parentPath, String filePathToExtract, Map<String, b> pathToBuffer) throws IOException {
        b c16 = c();
        i.f390366a.b(this.inputStream, c16);
        this.inputStream.closeEntry();
        pathToBuffer.put(parentPath + filePathToExtract, c16);
        return c16;
    }

    @Nullable
    public final b d(@NotNull String fileToExtract) throws IOException {
        List<String> listOf;
        Intrinsics.checkNotNullParameter(fileToExtract, "fileToExtract");
        HashMap hashMap = new HashMap();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(fileToExtract);
        f("", listOf, hashMap);
        return (b) hashMap.get(fileToExtract);
    }

    @NotNull
    public final Map<String, b> e(@NotNull List<String> filesToExtract) throws IOException {
        Intrinsics.checkNotNullParameter(filesToExtract, "filesToExtract");
        HashMap hashMap = new HashMap();
        f("", filesToExtract, hashMap);
        return hashMap;
    }

    @NotNull
    public final byte[] g(@NotNull String fileToExtract) throws IOException {
        List<String> listOf;
        byte[] b16;
        Intrinsics.checkNotNullParameter(fileToExtract, "fileToExtract");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(fileToExtract);
        b bVar = e(listOf).get(fileToExtract);
        if (bVar == null || (b16 = bVar.b()) == null) {
            return new byte[0];
        }
        return b16;
    }
}
