package okio.internal;

import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import okio.BufferedSink;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0080@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\nH\u0000\u001a\u001c\u0010\u0013\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0016\u001a\u00020\n*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0003*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"collectRecursively", "", "Lkotlin/sequences/SequenceScope;", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "stack", "Lkotlin/collections/ArrayDeque;", "path", "followSymlinks", "", "postorder", "(Lkotlin/sequences/SequenceScope;Lokio/FileSystem;Lkotlin/collections/ArrayDeque;Lokio/Path;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commonCopy", "source", "target", "commonCreateDirectories", QzoneZipCacheHelper.DIR, "mustCreate", "commonDeleteRecursively", "fileOrDirectory", "mustExist", "commonExists", "commonListRecursively", "Lkotlin/sequences/Sequence;", "commonMetadata", "Lokio/FileMetadata;", "symlinkTarget", "okio"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public final class _FileSystemKt {
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00db, code lost:
    
        if (r0 != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00dd, code lost:
    
        if (r14 != 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00df, code lost:
    
        r6.addLast(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e6, code lost:
    
        r13 = r12;
        r12 = r11;
        r11 = r6;
        r6 = r1;
        r1 = r0;
        r0 = r2;
        r2 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x012a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x012b, code lost:
    
        r11 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object collectRecursively(@NotNull SequenceScope<? super Path> sequenceScope, @NotNull FileSystem fileSystem, @NotNull ArrayDeque<Path> arrayDeque, @NotNull Path path, boolean z16, boolean z17, @NotNull Continuation<? super Unit> continuation) {
        _FileSystemKt$collectRecursively$1 _filesystemkt_collectrecursively_1;
        Object coroutine_suspended;
        int i3;
        FileSystem fileSystem2;
        ArrayDeque<Path> arrayDeque2;
        boolean z18;
        SequenceScope<? super Path> sequenceScope2;
        boolean z19;
        FileSystem fileSystem3;
        List<Path> listOrNull;
        Path path2 = path;
        boolean z26 = z17;
        if (continuation instanceof _FileSystemKt$collectRecursively$1) {
            _filesystemkt_collectrecursively_1 = (_FileSystemKt$collectRecursively$1) continuation;
            int i16 = _filesystemkt_collectrecursively_1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                _filesystemkt_collectrecursively_1.label = i16 - Integer.MIN_VALUE;
                Object obj = _filesystemkt_collectrecursively_1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = _filesystemkt_collectrecursively_1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (z26) {
                        fileSystem2 = fileSystem;
                        arrayDeque2 = arrayDeque;
                        z18 = z16;
                    } else {
                        _filesystemkt_collectrecursively_1.L$0 = sequenceScope;
                        fileSystem2 = fileSystem;
                        _filesystemkt_collectrecursively_1.L$1 = fileSystem2;
                        arrayDeque2 = arrayDeque;
                        _filesystemkt_collectrecursively_1.L$2 = arrayDeque2;
                        _filesystemkt_collectrecursively_1.L$3 = path2;
                        z18 = z16;
                        _filesystemkt_collectrecursively_1.Z$0 = z18;
                        _filesystemkt_collectrecursively_1.Z$1 = z26;
                        _filesystemkt_collectrecursively_1.label = 1;
                        if (sequenceScope.yield(path2, _filesystemkt_collectrecursively_1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    sequenceScope2 = sequenceScope;
                    z19 = z18;
                    fileSystem3 = fileSystem2;
                } else {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        boolean z27 = _filesystemkt_collectrecursively_1.Z$1;
                        boolean z28 = _filesystemkt_collectrecursively_1.Z$0;
                        Iterator<Path> it = (Iterator) _filesystemkt_collectrecursively_1.L$4;
                        Path path3 = (Path) _filesystemkt_collectrecursively_1.L$3;
                        ArrayDeque<Path> arrayDeque3 = (ArrayDeque) _filesystemkt_collectrecursively_1.L$2;
                        FileSystem fileSystem4 = (FileSystem) _filesystemkt_collectrecursively_1.L$1;
                        SequenceScope<? super Path> sequenceScope3 = (SequenceScope) _filesystemkt_collectrecursively_1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            while (it.hasNext()) {
                                Path next = it.next();
                                boolean z29 = z27;
                                _filesystemkt_collectrecursively_1.L$0 = sequenceScope3;
                                _filesystemkt_collectrecursively_1.L$1 = fileSystem4;
                                _filesystemkt_collectrecursively_1.L$2 = arrayDeque3;
                                _filesystemkt_collectrecursively_1.L$3 = path3;
                                _filesystemkt_collectrecursively_1.L$4 = it;
                                _filesystemkt_collectrecursively_1.Z$0 = z28;
                                _filesystemkt_collectrecursively_1.Z$1 = z27;
                                _filesystemkt_collectrecursively_1.label = 2;
                                if (collectRecursively(sequenceScope3, fileSystem4, arrayDeque3, next, z28, z29, _filesystemkt_collectrecursively_1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            arrayDeque3.removeLast();
                            z26 = z27;
                            path2 = path3;
                            sequenceScope2 = sequenceScope3;
                            if (!z26) {
                                return Unit.INSTANCE;
                            }
                            _filesystemkt_collectrecursively_1.L$0 = null;
                            _filesystemkt_collectrecursively_1.L$1 = null;
                            _filesystemkt_collectrecursively_1.L$2 = null;
                            _filesystemkt_collectrecursively_1.L$3 = null;
                            _filesystemkt_collectrecursively_1.L$4 = null;
                            _filesystemkt_collectrecursively_1.label = 3;
                            if (sequenceScope2.yield(path2, _filesystemkt_collectrecursively_1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        } catch (Throwable th5) {
                            th = th5;
                            arrayDeque3.removeLast();
                            throw th;
                        }
                    }
                    boolean z36 = _filesystemkt_collectrecursively_1.Z$1;
                    boolean z37 = _filesystemkt_collectrecursively_1.Z$0;
                    Path path4 = (Path) _filesystemkt_collectrecursively_1.L$3;
                    arrayDeque2 = (ArrayDeque) _filesystemkt_collectrecursively_1.L$2;
                    fileSystem3 = (FileSystem) _filesystemkt_collectrecursively_1.L$1;
                    sequenceScope2 = (SequenceScope) _filesystemkt_collectrecursively_1.L$0;
                    ResultKt.throwOnFailure(obj);
                    z26 = z36;
                    z19 = z37;
                    path2 = path4;
                }
                listOrNull = fileSystem3.listOrNull(path2);
                if (listOrNull == null) {
                    listOrNull = CollectionsKt__CollectionsKt.emptyList();
                }
                if (!listOrNull.isEmpty()) {
                    Path path5 = path2;
                    int i17 = 0;
                    while (true) {
                        if (z19 && arrayDeque2.contains(path5)) {
                            throw new IOException(Intrinsics.stringPlus("symlink cycle at ", path2));
                        }
                        Path symlinkTarget = symlinkTarget(fileSystem3, path5);
                        if (symlinkTarget == null) {
                            break;
                        }
                        i17++;
                        path5 = symlinkTarget;
                    }
                }
                if (!z26) {
                }
            }
        }
        _filesystemkt_collectrecursively_1 = new _FileSystemKt$collectRecursively$1(continuation);
        Object obj2 = _filesystemkt_collectrecursively_1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = _filesystemkt_collectrecursively_1.label;
        if (i3 != 0) {
        }
        listOrNull = fileSystem3.listOrNull(path2);
        if (listOrNull == null) {
        }
        if (!listOrNull.isEmpty()) {
        }
        if (!z26) {
        }
    }

    public static final void commonCopy(@NotNull FileSystem fileSystem, @NotNull Path source, @NotNull Path target) throws IOException {
        Long l3;
        Long l16;
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        Source source2 = fileSystem.source(source);
        Throwable th5 = null;
        try {
            BufferedSink buffer = Okio.buffer(fileSystem.sink(target));
            try {
                l16 = Long.valueOf(buffer.writeAll(source2));
                th = null;
            } catch (Throwable th6) {
                th = th6;
                l16 = null;
            }
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (Throwable th7) {
                    if (th != null) {
                        ExceptionsKt__ExceptionsKt.addSuppressed(th, th7);
                    } else {
                        th = th7;
                    }
                }
            }
        } catch (Throwable th8) {
            th5 = th8;
            l3 = null;
        }
        if (th == null) {
            Intrinsics.checkNotNull(l16);
            l3 = Long.valueOf(l16.longValue());
            if (source2 != null) {
                try {
                    source2.close();
                } catch (Throwable th9) {
                    if (th5 != null) {
                        ExceptionsKt__ExceptionsKt.addSuppressed(th5, th9);
                    } else {
                        th5 = th9;
                    }
                }
            }
            if (th5 == null) {
                Intrinsics.checkNotNull(l3);
                return;
            }
            throw th5;
        }
        throw th;
    }

    public static final void commonCreateDirectories(@NotNull FileSystem fileSystem, @NotNull Path dir, boolean z16) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        ArrayDeque arrayDeque = new ArrayDeque();
        for (Path path = dir; path != null && !fileSystem.exists(path); path = path.parent()) {
            arrayDeque.addFirst(path);
        }
        if (z16 && arrayDeque.isEmpty()) {
            throw new IOException(dir + " already exist.");
        }
        Iterator<E> it = arrayDeque.iterator();
        while (it.hasNext()) {
            fileSystem.createDirectory((Path) it.next());
        }
    }

    public static final void commonDeleteRecursively(@NotNull FileSystem fileSystem, @NotNull Path fileOrDirectory, boolean z16) throws IOException {
        Sequence sequence;
        boolean z17;
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(fileOrDirectory, "fileOrDirectory");
        sequence = SequencesKt__SequenceBuilderKt.sequence(new _FileSystemKt$commonDeleteRecursively$sequence$1(fileSystem, fileOrDirectory, null));
        Iterator it = sequence.iterator();
        while (it.hasNext()) {
            Path path = (Path) it.next();
            if (z16 && !it.hasNext()) {
                z17 = true;
            } else {
                z17 = false;
            }
            fileSystem.delete(path, z17);
        }
    }

    public static final boolean commonExists(@NotNull FileSystem fileSystem, @NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        if (fileSystem.metadataOrNull(path) != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final Sequence<Path> commonListRecursively(@NotNull FileSystem fileSystem, @NotNull Path dir, boolean z16) throws IOException {
        Sequence<Path> sequence;
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        sequence = SequencesKt__SequenceBuilderKt.sequence(new _FileSystemKt$commonListRecursively$1(dir, fileSystem, z16, null));
        return sequence;
    }

    @NotNull
    public static final FileMetadata commonMetadata(@NotNull FileSystem fileSystem, @NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata metadataOrNull = fileSystem.metadataOrNull(path);
        if (metadataOrNull != null) {
            return metadataOrNull;
        }
        throw new FileNotFoundException(Intrinsics.stringPlus("no such file: ", path));
    }

    @Nullable
    public static final Path symlinkTarget(@NotNull FileSystem fileSystem, @NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        Path symlinkTarget = fileSystem.metadata(path).getSymlinkTarget();
        if (symlinkTarget == null) {
            return null;
        }
        Path parent = path.parent();
        Intrinsics.checkNotNull(parent);
        return parent.resolve(symlinkTarget);
    }
}
