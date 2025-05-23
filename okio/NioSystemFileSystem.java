package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Path;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u0010H\u0002\u00a2\u0006\u0002\u0010\u0011\u00a8\u0006\u0012"}, d2 = {"Lokio/NioSystemFileSystem;", "Lokio/JvmSystemFileSystem;", "()V", "atomicMove", "", "source", "Lokio/Path;", "target", "createSymlink", "metadataOrNull", "Lokio/FileMetadata;", "path", "toString", "", "zeroToNull", "", "Ljava/nio/file/attribute/FileTime;", "(Ljava/nio/file/attribute/FileTime;)Ljava/lang/Long;", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
@IgnoreJRERequirement
/* loaded from: classes29.dex */
public final class NioSystemFileSystem extends JvmSystemFileSystem {
    private final Long zeroToNull(FileTime fileTime) {
        long millis;
        boolean z16;
        millis = fileTime.toMillis();
        Long valueOf = Long.valueOf(millis);
        if (valueOf.longValue() != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return null;
        }
        return valueOf;
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public void atomicMove(@NotNull Path source, @NotNull Path target) {
        String message;
        StandardCopyOption standardCopyOption;
        StandardCopyOption standardCopyOption2;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        try {
            java.nio.file.Path nioPath = source.toNioPath();
            java.nio.file.Path nioPath2 = target.toNioPath();
            standardCopyOption = StandardCopyOption.ATOMIC_MOVE;
            standardCopyOption2 = StandardCopyOption.REPLACE_EXISTING;
            Files.move(nioPath, nioPath2, standardCopyOption, standardCopyOption2);
        } catch (UnsupportedOperationException unused) {
            throw new IOException("atomic move not supported");
        } catch (NoSuchFileException e16) {
            message = e16.getMessage();
            throw new FileNotFoundException(message);
        }
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public void createSymlink(@NotNull Path source, @NotNull Path target) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        Files.createSymbolicLink(source.toNioPath(), target.toNioPath(), new FileAttribute[0]);
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    @Nullable
    public FileMetadata metadataOrNull(@NotNull Path path) {
        LinkOption linkOption;
        BasicFileAttributes readAttributes;
        boolean isSymbolicLink;
        java.nio.file.Path path2;
        boolean isRegularFile;
        boolean isDirectory;
        Path path3;
        long size;
        FileTime creationTime;
        Long zeroToNull;
        FileTime lastModifiedTime;
        Long zeroToNull2;
        FileTime lastAccessTime;
        Intrinsics.checkNotNullParameter(path, "path");
        java.nio.file.Path nioPath = path.toNioPath();
        Long l3 = null;
        try {
            linkOption = LinkOption.NOFOLLOW_LINKS;
            readAttributes = Files.readAttributes(nioPath, (Class<BasicFileAttributes>) BasicFileAttributes.class, linkOption);
            isSymbolicLink = readAttributes.isSymbolicLink();
            if (isSymbolicLink) {
                path2 = Files.readSymbolicLink(nioPath);
            } else {
                path2 = null;
            }
            isRegularFile = readAttributes.isRegularFile();
            isDirectory = readAttributes.isDirectory();
            if (path2 == null) {
                path3 = null;
            } else {
                path3 = Path.Companion.get$default(Path.INSTANCE, path2, false, 1, (Object) null);
            }
            size = readAttributes.size();
            Long valueOf = Long.valueOf(size);
            creationTime = readAttributes.creationTime();
            if (creationTime == null) {
                zeroToNull = null;
            } else {
                zeroToNull = zeroToNull(creationTime);
            }
            lastModifiedTime = readAttributes.lastModifiedTime();
            if (lastModifiedTime == null) {
                zeroToNull2 = null;
            } else {
                zeroToNull2 = zeroToNull(lastModifiedTime);
            }
            lastAccessTime = readAttributes.lastAccessTime();
            if (lastAccessTime != null) {
                l3 = zeroToNull(lastAccessTime);
            }
            return new FileMetadata(isRegularFile, isDirectory, path3, valueOf, zeroToNull, zeroToNull2, l3, null, 128, null);
        } catch (NoSuchFileException | FileSystemException unused) {
            return null;
        }
    }

    @Override // okio.JvmSystemFileSystem
    @NotNull
    public String toString() {
        return "NioSystemFileSystem";
    }
}
