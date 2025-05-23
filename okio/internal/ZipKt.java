package okio.internal;

import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt__CharJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.ws.WebSocketProtocol;
import okio.BufferedSource;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.ZipFileSystem;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017H\u0002\u001a\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0002\u00a2\u0006\u0002\u0010\u001b\u001a.\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 2\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020#0\"H\u0000\u001a\f\u0010$\u001a\u00020\u0015*\u00020%H\u0000\u001a\f\u0010&\u001a\u00020'*\u00020%H\u0002\u001a.\u0010(\u001a\u00020)*\u00020%2\u0006\u0010*\u001a\u00020\u00012\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020)0,H\u0002\u001a\u0014\u0010-\u001a\u00020.*\u00020%2\u0006\u0010/\u001a\u00020.H\u0000\u001a\u0018\u00100\u001a\u0004\u0018\u00010.*\u00020%2\b\u0010/\u001a\u0004\u0018\u00010.H\u0002\u001a\u0014\u00101\u001a\u00020'*\u00020%2\u0006\u00102\u001a\u00020'H\u0002\u001a\f\u00103\u001a\u00020)*\u00020%H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00018BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u00064"}, d2 = {"BIT_FLAG_ENCRYPTED", "", "BIT_FLAG_UNSUPPORTED_MASK", "CENTRAL_FILE_HEADER_SIGNATURE", "COMPRESSION_METHOD_DEFLATED", "COMPRESSION_METHOD_STORED", "END_OF_CENTRAL_DIRECTORY_SIGNATURE", "HEADER_ID_EXTENDED_TIMESTAMP", "HEADER_ID_ZIP64_EXTENDED_INFO", "LOCAL_FILE_HEADER_SIGNATURE", "MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE", "", "ZIP64_EOCD_RECORD_SIGNATURE", "ZIP64_LOCATOR_SIGNATURE", "hex", "", "getHex", "(I)Ljava/lang/String;", "buildIndex", "", "Lokio/Path;", "Lokio/internal/ZipEntry;", "entries", "", "dosDateTimeToEpochMillis", "date", "time", "(II)Ljava/lang/Long;", "openZip", "Lokio/ZipFileSystem;", "zipPath", "fileSystem", "Lokio/FileSystem;", "predicate", "Lkotlin/Function1;", "", "readEntry", "Lokio/BufferedSource;", "readEocdRecord", "Lokio/internal/EocdRecord;", "readExtra", "", "extraSize", "block", "Lkotlin/Function2;", "readLocalHeader", "Lokio/FileMetadata;", "basicMetadata", "readOrSkipLocalHeader", "readZip64EocdRecord", "regularRecord", "skipLocalHeader", "okio"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public final class ZipKt {
    private static final int BIT_FLAG_ENCRYPTED = 1;
    private static final int BIT_FLAG_UNSUPPORTED_MASK = 1;
    private static final int CENTRAL_FILE_HEADER_SIGNATURE = 33639248;
    public static final int COMPRESSION_METHOD_DEFLATED = 8;
    public static final int COMPRESSION_METHOD_STORED = 0;
    private static final int END_OF_CENTRAL_DIRECTORY_SIGNATURE = 101010256;
    private static final int HEADER_ID_EXTENDED_TIMESTAMP = 21589;
    private static final int HEADER_ID_ZIP64_EXTENDED_INFO = 1;
    private static final int LOCAL_FILE_HEADER_SIGNATURE = 67324752;
    private static final long MAX_ZIP_ENTRY_AND_ARCHIVE_SIZE = 4294967295L;
    private static final int ZIP64_EOCD_RECORD_SIGNATURE = 101075792;
    private static final int ZIP64_LOCATOR_SIGNATURE = 117853008;

    private static final Map<Path, ZipEntry> buildIndex(List<ZipEntry> list) {
        List<ZipEntry> sortedWith;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new Comparator() { // from class: okio.internal.ZipKt$buildIndex$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(((ZipEntry) t16).getCanonicalPath(), ((ZipEntry) t17).getCanonicalPath());
                return compareValues;
            }
        });
        for (ZipEntry zipEntry : sortedWith) {
            if (((ZipEntry) linkedHashMap.put(zipEntry.getCanonicalPath(), zipEntry)) == null) {
                while (true) {
                    Path parent = zipEntry.getCanonicalPath().parent();
                    if (parent != null) {
                        ZipEntry zipEntry2 = (ZipEntry) linkedHashMap.get(parent);
                        if (zipEntry2 != null) {
                            zipEntry2.getChildren().add(zipEntry.getCanonicalPath());
                            break;
                        }
                        ZipEntry zipEntry3 = new ZipEntry(parent, true, null, 0L, 0L, 0L, 0, null, 0L, 508, null);
                        linkedHashMap.put(parent, zipEntry3);
                        zipEntry3.getChildren().add(zipEntry.getCanonicalPath());
                        zipEntry = zipEntry3;
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private static final Long dosDateTimeToEpochMillis(int i3, int i16) {
        if (i16 == -1) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(14, 0);
        gregorianCalendar.set(((i3 >> 9) & 127) + SubAccountUgActivity.SUBACCOUNTUGACTIVITY_FINISH, ((i3 >> 5) & 15) - 1, i3 & 31, (i16 >> 11) & 31, (i16 >> 5) & 63, (i16 & 31) << 1);
        return Long.valueOf(gregorianCalendar.getTime().getTime());
    }

    private static final String getHex(int i3) {
        int checkRadix;
        checkRadix = CharsKt__CharJVMKt.checkRadix(16);
        String num = Integer.toString(i3, checkRadix);
        Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri\u2026(this, checkRadix(radix))");
        return Intrinsics.stringPlus(RelationNTPushServiceImpl.PRE_HEX_STRING, num);
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0143, code lost:
    
        if (0 < r9) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0145, code lost:
    
        r5 = r5 + 1;
        r13 = readEntry(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0156, code lost:
    
        if (r13.getOffset() >= r11.getCentralDirectoryOffset()) goto L245;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0162, code lost:
    
        if (r20.invoke(r13).booleanValue() == false) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0164, code lost:
    
        r4.add(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0169, code lost:
    
        if (r5 < r9) goto L247;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0174, code lost:
    
        throw new java.io.IOException("bad zip: local file header offset >= central directory offset");
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0175, code lost:
    
        r2 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0177, code lost:
    
        kotlin.io.CloseableKt.closeFinally(r8, null);
        r4 = new okio.ZipFileSystem(r18, r19, buildIndex(r4), r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0183, code lost:
    
        kotlin.io.CloseableKt.closeFinally(r3, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0186, code lost:
    
        return r4;
     */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ZipFileSystem openZip(@NotNull Path zipPath, @NotNull FileSystem fileSystem, @NotNull Function1<? super ZipEntry, Boolean> predicate) throws IOException {
        BufferedSource buffer;
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        FileHandle openReadOnly = fileSystem.openReadOnly(zipPath);
        long j3 = 0;
        try {
            BufferedSource buffer2 = Okio.buffer(FileHandle.source$default(openReadOnly, 0L, 1, null));
            try {
                int readIntLe = buffer2.readIntLe();
                if (readIntLe != LOCAL_FILE_HEADER_SIGNATURE) {
                    if (readIntLe == END_OF_CENTRAL_DIRECTORY_SIGNATURE) {
                        throw new IOException("unsupported zip: empty");
                    }
                    throw new IOException("not a zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(buffer2, null);
                long size = openReadOnly.size() - 22;
                if (size >= 0) {
                    long max = Math.max(size - 65536, 0L);
                    do {
                        BufferedSource buffer3 = Okio.buffer(openReadOnly.source(size));
                        try {
                            if (buffer3.readIntLe() == END_OF_CENTRAL_DIRECTORY_SIGNATURE) {
                                EocdRecord readEocdRecord = readEocdRecord(buffer3);
                                String readUtf8 = buffer3.readUtf8(readEocdRecord.getCommentByteCount());
                                buffer3.close();
                                long j16 = size - 20;
                                if (j16 > 0) {
                                    buffer2 = Okio.buffer(openReadOnly.source(j16));
                                    try {
                                        if (buffer2.readIntLe() == ZIP64_LOCATOR_SIGNATURE) {
                                            int readIntLe2 = buffer2.readIntLe();
                                            long readLongLe = buffer2.readLongLe();
                                            if (buffer2.readIntLe() == 1 && readIntLe2 == 0) {
                                                buffer = Okio.buffer(openReadOnly.source(readLongLe));
                                                try {
                                                    int readIntLe3 = buffer.readIntLe();
                                                    if (readIntLe3 == ZIP64_EOCD_RECORD_SIGNATURE) {
                                                        EocdRecord readZip64EocdRecord = readZip64EocdRecord(buffer, readEocdRecord);
                                                        Unit unit2 = Unit.INSTANCE;
                                                        CloseableKt.closeFinally(buffer, null);
                                                        readEocdRecord = readZip64EocdRecord;
                                                    } else {
                                                        throw new IOException("bad zip: expected " + getHex(ZIP64_EOCD_RECORD_SIGNATURE) + " but was " + getHex(readIntLe3));
                                                    }
                                                } finally {
                                                }
                                            } else {
                                                throw new IOException("unsupported zip: spanned");
                                            }
                                        }
                                        Unit unit3 = Unit.INSTANCE;
                                        CloseableKt.closeFinally(buffer2, null);
                                    } finally {
                                    }
                                }
                                ArrayList arrayList = new ArrayList();
                                buffer = Okio.buffer(openReadOnly.source(readEocdRecord.getCentralDirectoryOffset()));
                                try {
                                    long entryCount = readEocdRecord.getEntryCount();
                                } finally {
                                    try {
                                        throw th;
                                    } finally {
                                        CloseableKt.closeFinally(buffer, th);
                                    }
                                }
                            } else {
                                buffer3.close();
                                size--;
                            }
                        } catch (Throwable th5) {
                            buffer3.close();
                            throw th5;
                        }
                    } while (size >= max);
                    throw new IOException("not a zip: end of central directory signature not found");
                }
                throw new IOException(Intrinsics.stringPlus("not a zip: size=", Long.valueOf(openReadOnly.size())));
            } finally {
                try {
                    throw th;
                } finally {
                    CloseableKt.closeFinally(buffer2, th);
                }
            }
        } finally {
        }
    }

    public static /* synthetic */ ZipFileSystem openZip$default(Path path, FileSystem fileSystem, Function1 function1, int i3, Object obj) throws IOException {
        if ((i3 & 4) != 0) {
            function1 = new Function1<ZipEntry, Boolean>() { // from class: okio.internal.ZipKt$openZip$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull ZipEntry it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.TRUE;
                }
            };
        }
        return openZip(path, fileSystem, function1);
    }

    @NotNull
    public static final ZipEntry readEntry(@NotNull final BufferedSource bufferedSource) throws IOException {
        boolean contains$default;
        Ref.LongRef longRef;
        long j3;
        boolean endsWith$default;
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe == CENTRAL_FILE_HEADER_SIGNATURE) {
            bufferedSource.skip(4L);
            int readShortLe = bufferedSource.readShortLe() & 65535;
            if ((readShortLe & 1) == 0) {
                int readShortLe2 = bufferedSource.readShortLe() & 65535;
                Long dosDateTimeToEpochMillis = dosDateTimeToEpochMillis(bufferedSource.readShortLe() & 65535, bufferedSource.readShortLe() & 65535);
                long readIntLe2 = bufferedSource.readIntLe() & 4294967295L;
                final Ref.LongRef longRef2 = new Ref.LongRef();
                longRef2.element = bufferedSource.readIntLe() & 4294967295L;
                final Ref.LongRef longRef3 = new Ref.LongRef();
                longRef3.element = bufferedSource.readIntLe() & 4294967295L;
                int readShortLe3 = bufferedSource.readShortLe() & 65535;
                int readShortLe4 = bufferedSource.readShortLe() & 65535;
                int readShortLe5 = bufferedSource.readShortLe() & 65535;
                bufferedSource.skip(8L);
                Ref.LongRef longRef4 = new Ref.LongRef();
                longRef4.element = bufferedSource.readIntLe() & 4294967295L;
                String readUtf8 = bufferedSource.readUtf8(readShortLe3);
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) readUtf8, (char) 0, false, 2, (Object) null);
                if (!contains$default) {
                    if (longRef3.element == 4294967295L) {
                        j3 = 8 + 0;
                        longRef = longRef4;
                    } else {
                        longRef = longRef4;
                        j3 = 0;
                    }
                    if (longRef2.element == 4294967295L) {
                        j3 += 8;
                    }
                    final Ref.LongRef longRef5 = longRef;
                    if (longRef5.element == 4294967295L) {
                        j3 += 8;
                    }
                    final long j16 = j3;
                    final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                    readExtra(bufferedSource, readShortLe4, new Function2<Integer, Long, Unit>() { // from class: okio.internal.ZipKt$readEntry$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Long l3) {
                            invoke(num.intValue(), l3.longValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i3, long j17) {
                            if (i3 == 1) {
                                Ref.BooleanRef booleanRef2 = Ref.BooleanRef.this;
                                if (!booleanRef2.element) {
                                    booleanRef2.element = true;
                                    if (j17 >= j16) {
                                        Ref.LongRef longRef6 = longRef3;
                                        long j18 = longRef6.element;
                                        if (j18 == 4294967295L) {
                                            j18 = bufferedSource.readLongLe();
                                        }
                                        longRef6.element = j18;
                                        Ref.LongRef longRef7 = longRef2;
                                        longRef7.element = longRef7.element == 4294967295L ? bufferedSource.readLongLe() : 0L;
                                        Ref.LongRef longRef8 = longRef5;
                                        longRef8.element = longRef8.element == 4294967295L ? bufferedSource.readLongLe() : 0L;
                                        return;
                                    }
                                    throw new IOException("bad zip: zip64 extra too short");
                                }
                                throw new IOException("bad zip: zip64 extra repeated");
                            }
                        }
                    });
                    if (j16 > 0 && !booleanRef.element) {
                        throw new IOException("bad zip: zip64 extra required but absent");
                    }
                    String readUtf82 = bufferedSource.readUtf8(readShortLe5);
                    Path resolve = Path.Companion.get$default(Path.INSTANCE, "/", false, 1, (Object) null).resolve(readUtf8);
                    endsWith$default = StringsKt__StringsJVMKt.endsWith$default(readUtf8, "/", false, 2, null);
                    return new ZipEntry(resolve, endsWith$default, readUtf82, readIntLe2, longRef2.element, longRef3.element, readShortLe2, dosDateTimeToEpochMillis, longRef5.element);
                }
                throw new IOException("bad zip: filename contains 0x00");
            }
            throw new IOException(Intrinsics.stringPlus("unsupported zip: general purpose bit flag=", getHex(readShortLe)));
        }
        throw new IOException("bad zip: expected " + getHex(CENTRAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
    }

    private static final EocdRecord readEocdRecord(BufferedSource bufferedSource) throws IOException {
        int readShortLe = bufferedSource.readShortLe() & 65535;
        int readShortLe2 = bufferedSource.readShortLe() & 65535;
        long readShortLe3 = bufferedSource.readShortLe() & 65535;
        if (readShortLe3 == (bufferedSource.readShortLe() & 65535) && readShortLe == 0 && readShortLe2 == 0) {
            bufferedSource.skip(4L);
            return new EocdRecord(readShortLe3, 4294967295L & bufferedSource.readIntLe(), bufferedSource.readShortLe() & 65535);
        }
        throw new IOException("unsupported zip: spanned");
    }

    private static final void readExtra(BufferedSource bufferedSource, int i3, Function2<? super Integer, ? super Long, Unit> function2) {
        long j3 = i3;
        while (j3 != 0) {
            if (j3 >= 4) {
                int readShortLe = bufferedSource.readShortLe() & 65535;
                long readShortLe2 = bufferedSource.readShortLe() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                long j16 = j3 - 4;
                if (j16 >= readShortLe2) {
                    bufferedSource.require(readShortLe2);
                    long size = bufferedSource.getBuffer().size();
                    function2.invoke(Integer.valueOf(readShortLe), Long.valueOf(readShortLe2));
                    long size2 = (bufferedSource.getBuffer().size() + readShortLe2) - size;
                    if (size2 >= 0) {
                        if (size2 > 0) {
                            bufferedSource.getBuffer().skip(size2);
                        }
                        j3 = j16 - readShortLe2;
                    } else {
                        throw new IOException(Intrinsics.stringPlus("unsupported zip: too many bytes processed for ", Integer.valueOf(readShortLe)));
                    }
                } else {
                    throw new IOException("bad zip: truncated value in extra field");
                }
            } else {
                throw new IOException("bad zip: truncated header in extra field");
            }
        }
    }

    @NotNull
    public static final FileMetadata readLocalHeader(@NotNull BufferedSource bufferedSource, @NotNull FileMetadata basicMetadata) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        Intrinsics.checkNotNullParameter(basicMetadata, "basicMetadata");
        FileMetadata readOrSkipLocalHeader = readOrSkipLocalHeader(bufferedSource, basicMetadata);
        Intrinsics.checkNotNull(readOrSkipLocalHeader);
        return readOrSkipLocalHeader;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final FileMetadata readOrSkipLocalHeader(final BufferedSource bufferedSource, FileMetadata fileMetadata) {
        T t16;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (fileMetadata == null) {
            t16 = 0;
        } else {
            t16 = fileMetadata.getLastModifiedAtMillis();
        }
        objectRef.element = t16;
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        int readIntLe = bufferedSource.readIntLe();
        if (readIntLe == LOCAL_FILE_HEADER_SIGNATURE) {
            bufferedSource.skip(2L);
            int readShortLe = bufferedSource.readShortLe() & 65535;
            if ((readShortLe & 1) == 0) {
                bufferedSource.skip(18L);
                long readShortLe2 = bufferedSource.readShortLe() & WebSocketProtocol.PAYLOAD_SHORT_MAX;
                int readShortLe3 = bufferedSource.readShortLe() & 65535;
                bufferedSource.skip(readShortLe2);
                if (fileMetadata == null) {
                    bufferedSource.skip(readShortLe3);
                    return null;
                }
                readExtra(bufferedSource, readShortLe3, new Function2<Integer, Long, Unit>() { // from class: okio.internal.ZipKt$readOrSkipLocalHeader$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Long l3) {
                        invoke(num.intValue(), l3.longValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Type inference failed for: r0v13, types: [T, java.lang.Long] */
                    /* JADX WARN: Type inference failed for: r10v12, types: [T, java.lang.Long] */
                    /* JADX WARN: Type inference failed for: r11v3, types: [T, java.lang.Long] */
                    public final void invoke(int i3, long j3) {
                        if (i3 == 21589) {
                            if (j3 >= 1) {
                                int readByte = BufferedSource.this.readByte() & 255;
                                boolean z16 = (readByte & 1) == 1;
                                boolean z17 = (readByte & 2) == 2;
                                boolean z18 = (readByte & 4) == 4;
                                BufferedSource bufferedSource2 = BufferedSource.this;
                                long j16 = z16 ? 5L : 1L;
                                if (z17) {
                                    j16 += 4;
                                }
                                if (z18) {
                                    j16 += 4;
                                }
                                if (j3 < j16) {
                                    throw new IOException("bad zip: extended timestamp extra too short");
                                }
                                if (z16) {
                                    objectRef.element = Long.valueOf(bufferedSource2.readIntLe() * 1000);
                                }
                                if (z17) {
                                    objectRef2.element = Long.valueOf(BufferedSource.this.readIntLe() * 1000);
                                }
                                if (z18) {
                                    objectRef3.element = Long.valueOf(BufferedSource.this.readIntLe() * 1000);
                                    return;
                                }
                                return;
                            }
                            throw new IOException("bad zip: extended timestamp extra too short");
                        }
                    }
                });
                return new FileMetadata(fileMetadata.getIsRegularFile(), fileMetadata.getIsDirectory(), null, fileMetadata.getSize(), (Long) objectRef3.element, (Long) objectRef.element, (Long) objectRef2.element, null, 128, null);
            }
            throw new IOException(Intrinsics.stringPlus("unsupported zip: general purpose bit flag=", getHex(readShortLe)));
        }
        throw new IOException("bad zip: expected " + getHex(LOCAL_FILE_HEADER_SIGNATURE) + " but was " + getHex(readIntLe));
    }

    private static final EocdRecord readZip64EocdRecord(BufferedSource bufferedSource, EocdRecord eocdRecord) throws IOException {
        bufferedSource.skip(12L);
        int readIntLe = bufferedSource.readIntLe();
        int readIntLe2 = bufferedSource.readIntLe();
        long readLongLe = bufferedSource.readLongLe();
        if (readLongLe == bufferedSource.readLongLe() && readIntLe == 0 && readIntLe2 == 0) {
            bufferedSource.skip(8L);
            return new EocdRecord(readLongLe, bufferedSource.readLongLe(), eocdRecord.getCommentByteCount());
        }
        throw new IOException("unsupported zip: spanned");
    }

    public static final void skipLocalHeader(@NotNull BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "<this>");
        readOrSkipLocalHeader(bufferedSource, null);
    }
}
