package okio;

import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._PathKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001.B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0000H\u0096\u0002J\u0016\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\rH\u0087\u0002\u00a2\u0006\u0002\b\"J\u0016\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0003H\u0087\u0002\u00a2\u0006\u0002\b\"J\u0016\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0000H\u0087\u0002\u00a2\u0006\u0002\b\"J\u0013\u0010#\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010$H\u0096\u0002J\b\u0010%\u001a\u00020\u001eH\u0016J\u0006\u0010&\u001a\u00020\u0000J\u000e\u0010'\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000J\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\bJ\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\bJ\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00002\b\b\u0002\u0010(\u001a\u00020\bJ\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020,H\u0007J\b\u0010-\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\n\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0011\u0010\u000b\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r8G\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00008G\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8G\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001c\u00a8\u0006/"}, d2 = {"Lokio/Path;", "", "bytes", "Lokio/ByteString;", "(Lokio/ByteString;)V", "getBytes$okio", "()Lokio/ByteString;", "isAbsolute", "", "()Z", "isRelative", "isRoot", "name", "", "()Ljava/lang/String;", "nameBytes", HippyNestedScrollComponent.PRIORITY_PARENT, "()Lokio/Path;", "root", "getRoot", SegmentKeeper.KEY_SEGMENT_LIST, "", "getSegments", "()Ljava/util/List;", "segmentsBytes", "getSegmentsBytes", "volumeLetter", "", "()Ljava/lang/Character;", "compareTo", "", "other", "div", "child", "resolve", "equals", "", "hashCode", "normalized", "relativeTo", "normalize", "toFile", "Ljava/io/File;", "toNioPath", "Ljava/nio/file/Path;", "toString", "Companion", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public final class Path implements Comparable<Path> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final String DIRECTORY_SEPARATOR;

    @NotNull
    private final ByteString bytes;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001b\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\nJ\u001b\u0010\u0005\u001a\u00020\u0006*\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\nJ\u001b\u0010\f\u001a\u00020\u0006*\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\nR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lokio/Path$Companion;", "", "()V", "DIRECTORY_SEPARATOR", "", "toOkioPath", "Lokio/Path;", "Ljava/io/File;", "normalize", "", "get", "Ljava/nio/file/Path;", "toPath", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes29.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Path get$default(Companion companion, String str, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            return companion.get(str, z16);
        }

        @JvmStatic
        @JvmName(name = "get")
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull File file) {
            Intrinsics.checkNotNullParameter(file, "<this>");
            return get$default(this, file, false, 1, (Object) null);
        }

        Companion() {
        }

        public static /* synthetic */ Path get$default(Companion companion, File file, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            return companion.get(file, z16);
        }

        @JvmStatic
        @JvmName(name = "get")
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return get$default(this, str, false, 1, (Object) null);
        }

        public static /* synthetic */ Path get$default(Companion companion, java.nio.file.Path path, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z16 = false;
            }
            return companion.get(path, z16);
        }

        @JvmStatic
        @JvmName(name = "get")
        @IgnoreJRERequirement
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull java.nio.file.Path path) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            return get$default(this, path, false, 1, (Object) null);
        }

        @JvmStatic
        @JvmName(name = "get")
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull String str, boolean z16) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return _PathKt.commonToPath(str, z16);
        }

        @JvmStatic
        @JvmName(name = "get")
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull File file, boolean z16) {
            Intrinsics.checkNotNullParameter(file, "<this>");
            String file2 = file.toString();
            Intrinsics.checkNotNullExpressionValue(file2, "toString()");
            return get(file2, z16);
        }

        @JvmStatic
        @JvmName(name = "get")
        @IgnoreJRERequirement
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull java.nio.file.Path path, boolean z16) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            return get(path.toString(), z16);
        }
    }

    static {
        String separator = File.separator;
        Intrinsics.checkNotNullExpressionValue(separator, "separator");
        DIRECTORY_SEPARATOR = separator;
    }

    public Path(@NotNull ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.bytes = bytes;
    }

    @JvmStatic
    @JvmName(name = "get")
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull File file) {
        return INSTANCE.get(file);
    }

    public static /* synthetic */ Path resolve$default(Path path, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return path.resolve(str, z16);
    }

    public boolean equals(@Nullable Object other) {
        if ((other instanceof Path) && Intrinsics.areEqual(((Path) other).getBytes(), getBytes())) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: getBytes$okio, reason: from getter */
    public final ByteString getBytes() {
        return this.bytes;
    }

    @Nullable
    public final Path getRoot() {
        int access$rootLength = _PathKt.access$rootLength(this);
        if (access$rootLength == -1) {
            return null;
        }
        return new Path(getBytes().substring(0, access$rootLength));
    }

    @NotNull
    public final List<String> getSegments() {
        int collectionSizeOrDefault;
        ArrayList arrayList = new ArrayList();
        int access$rootLength = _PathKt.access$rootLength(this);
        if (access$rootLength == -1) {
            access$rootLength = 0;
        } else if (access$rootLength < getBytes().size() && getBytes().getByte(access$rootLength) == ((byte) 92)) {
            access$rootLength++;
        }
        int size = getBytes().size();
        if (access$rootLength < size) {
            int i3 = access$rootLength;
            while (true) {
                int i16 = access$rootLength + 1;
                if (getBytes().getByte(access$rootLength) == ((byte) 47) || getBytes().getByte(access$rootLength) == ((byte) 92)) {
                    arrayList.add(getBytes().substring(i3, access$rootLength));
                    i3 = i16;
                }
                if (i16 >= size) {
                    break;
                }
                access$rootLength = i16;
            }
            access$rootLength = i3;
        }
        if (access$rootLength < getBytes().size()) {
            arrayList.add(getBytes().substring(access$rootLength, getBytes().size()));
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ByteString) it.next()).utf8());
        }
        return arrayList2;
    }

    @NotNull
    public final List<ByteString> getSegmentsBytes() {
        ArrayList arrayList = new ArrayList();
        int access$rootLength = _PathKt.access$rootLength(this);
        if (access$rootLength == -1) {
            access$rootLength = 0;
        } else if (access$rootLength < getBytes().size() && getBytes().getByte(access$rootLength) == ((byte) 92)) {
            access$rootLength++;
        }
        int size = getBytes().size();
        if (access$rootLength < size) {
            int i3 = access$rootLength;
            while (true) {
                int i16 = access$rootLength + 1;
                if (getBytes().getByte(access$rootLength) == ((byte) 47) || getBytes().getByte(access$rootLength) == ((byte) 92)) {
                    arrayList.add(getBytes().substring(i3, access$rootLength));
                    i3 = i16;
                }
                if (i16 >= size) {
                    break;
                }
                access$rootLength = i16;
            }
            access$rootLength = i3;
        }
        if (access$rootLength < getBytes().size()) {
            arrayList.add(getBytes().substring(access$rootLength, getBytes().size()));
        }
        return arrayList;
    }

    public int hashCode() {
        return getBytes().hashCode();
    }

    public final boolean isAbsolute() {
        if (_PathKt.access$rootLength(this) != -1) {
            return true;
        }
        return false;
    }

    public final boolean isRelative() {
        if (_PathKt.access$rootLength(this) == -1) {
            return true;
        }
        return false;
    }

    public final boolean isRoot() {
        if (_PathKt.access$rootLength(this) == getBytes().size()) {
            return true;
        }
        return false;
    }

    @JvmName(name = "name")
    @NotNull
    public final String name() {
        return nameBytes().utf8();
    }

    @JvmName(name = "nameBytes")
    @NotNull
    public final ByteString nameBytes() {
        int access$getIndexOfLastSlash = _PathKt.access$getIndexOfLastSlash(this);
        if (access$getIndexOfLastSlash != -1) {
            return ByteString.substring$default(getBytes(), access$getIndexOfLastSlash + 1, 0, 2, null);
        }
        if (volumeLetter() != null && getBytes().size() == 2) {
            return ByteString.EMPTY;
        }
        return getBytes();
    }

    @NotNull
    public final Path normalized() {
        return INSTANCE.get(toString(), true);
    }

    @JvmName(name = HippyNestedScrollComponent.PRIORITY_PARENT)
    @Nullable
    public final Path parent() {
        Path path;
        if (Intrinsics.areEqual(getBytes(), _PathKt.access$getDOT$p()) || Intrinsics.areEqual(getBytes(), _PathKt.access$getSLASH$p()) || Intrinsics.areEqual(getBytes(), _PathKt.access$getBACKSLASH$p()) || _PathKt.access$lastSegmentIsDotDot(this)) {
            return null;
        }
        int access$getIndexOfLastSlash = _PathKt.access$getIndexOfLastSlash(this);
        if (access$getIndexOfLastSlash == 2 && volumeLetter() != null) {
            if (getBytes().size() == 3) {
                return null;
            }
            path = new Path(ByteString.substring$default(getBytes(), 0, 3, 1, null));
        } else {
            if (access$getIndexOfLastSlash == 1 && getBytes().startsWith(_PathKt.access$getBACKSLASH$p())) {
                return null;
            }
            if (access$getIndexOfLastSlash == -1 && volumeLetter() != null) {
                if (getBytes().size() == 2) {
                    return null;
                }
                path = new Path(ByteString.substring$default(getBytes(), 0, 2, 1, null));
            } else {
                if (access$getIndexOfLastSlash == -1) {
                    return new Path(_PathKt.access$getDOT$p());
                }
                if (access$getIndexOfLastSlash == 0) {
                    path = new Path(ByteString.substring$default(getBytes(), 0, 1, 1, null));
                } else {
                    return new Path(ByteString.substring$default(getBytes(), 0, access$getIndexOfLastSlash, 1, null));
                }
            }
        }
        return path;
    }

    @NotNull
    public final Path relativeTo(@NotNull Path other) {
        boolean z16;
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual(getRoot(), other.getRoot())) {
            List<ByteString> segmentsBytes = getSegmentsBytes();
            List<ByteString> segmentsBytes2 = other.getSegmentsBytes();
            int min = Math.min(segmentsBytes.size(), segmentsBytes2.size());
            int i3 = 0;
            while (i3 < min && Intrinsics.areEqual(segmentsBytes.get(i3), segmentsBytes2.get(i3))) {
                i3++;
            }
            if (i3 == min && getBytes().size() == other.getBytes().size()) {
                return Companion.get$default(INSTANCE, ".", false, 1, (Object) null);
            }
            if (segmentsBytes2.subList(i3, segmentsBytes2.size()).indexOf(_PathKt.access$getDOT_DOT$p()) == -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                Buffer buffer = new Buffer();
                ByteString access$getSlash = _PathKt.access$getSlash(other);
                if (access$getSlash == null && (access$getSlash = _PathKt.access$getSlash(this)) == null) {
                    access$getSlash = _PathKt.access$toSlash(DIRECTORY_SEPARATOR);
                }
                int size = segmentsBytes2.size();
                if (i3 < size) {
                    int i16 = i3;
                    do {
                        i16++;
                        buffer.write(_PathKt.access$getDOT_DOT$p());
                        buffer.write(access$getSlash);
                    } while (i16 < size);
                }
                int size2 = segmentsBytes.size();
                if (i3 < size2) {
                    while (true) {
                        int i17 = i3 + 1;
                        buffer.write(segmentsBytes.get(i3));
                        buffer.write(access$getSlash);
                        if (i17 >= size2) {
                            break;
                        }
                        i3 = i17;
                    }
                }
                return _PathKt.toPath(buffer, false);
            }
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + other).toString());
        }
        throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + other).toString());
    }

    @JvmName(name = "resolve")
    @NotNull
    public final Path resolve(@NotNull Path child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, child, false);
    }

    @NotNull
    public final File toFile() {
        return new File(toString());
    }

    @IgnoreJRERequirement
    @NotNull
    public final java.nio.file.Path toNioPath() {
        java.nio.file.Path path;
        path = Paths.get(toString(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(path, "get(toString())");
        return path;
    }

    @NotNull
    public String toString() {
        return getBytes().utf8();
    }

    @JvmName(name = "volumeLetter")
    @Nullable
    public final Character volumeLetter() {
        boolean z16;
        boolean z17 = false;
        if (ByteString.indexOf$default(getBytes(), _PathKt.access$getSLASH$p(), 0, 2, (Object) null) != -1 || getBytes().size() < 2 || getBytes().getByte(1) != ((byte) 58)) {
            return null;
        }
        char c16 = (char) getBytes().getByte(0);
        if ('a' <= c16 && c16 <= 'z') {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if ('A' <= c16 && c16 <= 'Z') {
                z17 = true;
            }
            if (!z17) {
                return null;
            }
        }
        return Character.valueOf(c16);
    }

    @JvmStatic
    @JvmName(name = "get")
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull File file, boolean z16) {
        return INSTANCE.get(file, z16);
    }

    public static /* synthetic */ Path resolve$default(Path path, ByteString byteString, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return path.resolve(byteString, z16);
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull Path other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return getBytes().compareTo(other.getBytes());
    }

    @NotNull
    public final Path resolve(@NotNull Path child, boolean normalize) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, child, normalize);
    }

    @JvmStatic
    @JvmName(name = "get")
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull String str) {
        return INSTANCE.get(str);
    }

    public static /* synthetic */ Path resolve$default(Path path, Path path2, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return path.resolve(path2, z16);
    }

    @JvmName(name = "resolve")
    @NotNull
    public final Path resolve(@NotNull String child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().writeUtf8(child), false), false);
    }

    @JvmStatic
    @JvmName(name = "get")
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull String str, boolean z16) {
        return INSTANCE.get(str, z16);
    }

    @JvmStatic
    @JvmName(name = "get")
    @IgnoreJRERequirement
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull java.nio.file.Path path) {
        return INSTANCE.get(path);
    }

    @JvmName(name = "resolve")
    @NotNull
    public final Path resolve(@NotNull ByteString child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().write(child), false), false);
    }

    @JvmStatic
    @JvmName(name = "get")
    @IgnoreJRERequirement
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull java.nio.file.Path path, boolean z16) {
        return INSTANCE.get(path, z16);
    }

    @NotNull
    public final Path resolve(@NotNull String child, boolean normalize) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().writeUtf8(child), false), normalize);
    }

    @NotNull
    public final Path resolve(@NotNull ByteString child, boolean normalize) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().write(child), false), normalize);
    }
}
