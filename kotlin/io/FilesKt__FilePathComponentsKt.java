package kotlin.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u000b\u001a\u00020\f*\u00020\bH\u0002\u00a2\u0006\u0002\b\r\u001a\u001c\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0000\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0002H\u0000\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0002*\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u0007\u001a\u00020\b*\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0013"}, d2 = {"isRooted", "", "Ljava/io/File;", "(Ljava/io/File;)Z", "root", "getRoot", "(Ljava/io/File;)Ljava/io/File;", "rootName", "", "getRootName", "(Ljava/io/File;)Ljava/lang/String;", "getRootLength", "", "getRootLength$FilesKt__FilePathComponentsKt", "subPath", "beginIndex", "endIndex", "toComponents", "Lkotlin/io/FilePathComponents;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/io/FilesKt")
/* loaded from: classes28.dex */
public class FilesKt__FilePathComponentsKt {
    @NotNull
    public static final File getRoot(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return new File(getRootName(file));
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
    
        r0 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) r8, r3, 2, false, 4, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final int getRootLength$FilesKt__FilePathComponentsKt(String str) {
        int indexOf$default;
        boolean endsWith$default;
        int indexOf$default2;
        int indexOf$default3;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, File.separatorChar, 0, false, 4, (Object) null);
        if (indexOf$default == 0) {
            if (str.length() > 1) {
                char charAt = str.charAt(1);
                char c16 = File.separatorChar;
                if (charAt == c16 && indexOf$default2 >= 0) {
                    indexOf$default3 = StringsKt__StringsKt.indexOf$default((CharSequence) str, File.separatorChar, indexOf$default2 + 1, false, 4, (Object) null);
                    if (indexOf$default3 >= 0) {
                        return indexOf$default3 + 1;
                    }
                    return str.length();
                }
            }
            return 1;
        }
        if (indexOf$default > 0 && str.charAt(indexOf$default - 1) == ':') {
            return indexOf$default + 1;
        }
        if (indexOf$default == -1) {
            endsWith$default = StringsKt__StringsKt.endsWith$default((CharSequence) str, ':', false, 2, (Object) null);
            if (endsWith$default) {
                return str.length();
            }
        }
        return 0;
    }

    @NotNull
    public static final String getRootName(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        String path2 = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "path");
        String substring = path.substring(0, getRootLength$FilesKt__FilePathComponentsKt(path2));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean isRooted(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        if (getRootLength$FilesKt__FilePathComponentsKt(path) > 0) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final File subPath(@NotNull File file, int i3, int i16) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return toComponents(file).subPath(i3, i16);
    }

    @NotNull
    public static final FilePathComponents toComponents(@NotNull File file) {
        boolean z16;
        List split$default;
        int collectionSizeOrDefault;
        List list;
        Intrinsics.checkNotNullParameter(file, "<this>");
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "path");
        int rootLength$FilesKt__FilePathComponentsKt = getRootLength$FilesKt__FilePathComponentsKt(path);
        String substring = path.substring(0, rootLength$FilesKt__FilePathComponentsKt);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        String substring2 = path.substring(rootLength$FilesKt__FilePathComponentsKt);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        if (substring2.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            list = CollectionsKt__CollectionsKt.emptyList();
        } else {
            split$default = StringsKt__StringsKt.split$default((CharSequence) substring2, new char[]{File.separatorChar}, false, 0, 6, (Object) null);
            List list2 = split$default;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(new File((String) it.next()));
            }
            list = arrayList;
        }
        return new FilePathComponents(new File(substring), list);
    }
}
