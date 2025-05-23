package okhttp3.internal.http2;

import android.net.http.Headers;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.tencentmap.mapsdk.maps.TencentMapServiceProtocol;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lokhttp3/internal/http2/Hpack;", "", "()V", "NAME_TO_FIRST_INDEX", "", "Lokio/ByteString;", "", "getNAME_TO_FIRST_INDEX", "()Ljava/util/Map;", "PREFIX_4_BITS", "PREFIX_5_BITS", "PREFIX_6_BITS", "PREFIX_7_BITS", "SETTINGS_HEADER_TABLE_SIZE", "SETTINGS_HEADER_TABLE_SIZE_LIMIT", "STATIC_HEADER_TABLE", "", "Lokhttp3/internal/http2/Header;", "getSTATIC_HEADER_TABLE", "()[Lokhttp3/internal/http2/Header;", "[Lokhttp3/internal/http2/Header;", "checkLowercase", "name", "nameToFirstIndex", "Reader", "Writer", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public final class Hpack {

    @NotNull
    public static final Hpack INSTANCE;

    @NotNull
    private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;

    @NotNull
    private static final Header[] STATIC_HEADER_TABLE;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\nH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010!\u001a\u00020\u0005H\u0002J\u0006\u0010\"\u001a\u00020\u001cJ\u0006\u0010#\u001a\u00020\u0013J\u0010\u0010$\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0016\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0005H\u0002J\b\u0010*\u001a\u00020\u0013H\u0002J\u0010\u0010+\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010,\u001a\u00020\u0013H\u0002R\u001c\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lokhttp3/internal/http2/Hpack$Reader;", "", "source", "Lokio/Source;", "headerTableSizeSetting", "", "maxDynamicTableByteCount", "(Lokio/Source;II)V", "dynamicTable", "", "Lokhttp3/internal/http2/Header;", "[Lokhttp3/internal/http2/Header;", "dynamicTableByteCount", "headerCount", "headerList", "", "nextHeaderIndex", "Lokio/BufferedSource;", "adjustDynamicTableByteCount", "", "clearDynamicTable", "dynamicTableIndex", "index", "evictToRecoverBytes", "bytesToRecover", "getAndResetHeaderList", "", "getName", "Lokio/ByteString;", "insertIntoDynamicTable", "entry", "isStaticHeader", "", "readByte", "readByteString", "readHeaders", "readIndexedHeader", "readInt", "firstByte", "prefixMask", "readLiteralHeaderWithIncrementalIndexingIndexedName", "nameIndex", "readLiteralHeaderWithIncrementalIndexingNewName", "readLiteralHeaderWithoutIndexingIndexedName", "readLiteralHeaderWithoutIndexingNewName", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public static final class Reader {

        @JvmField
        @NotNull
        public Header[] dynamicTable;

        @JvmField
        public int dynamicTableByteCount;

        @JvmField
        public int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final BufferedSource source;

        @JvmOverloads
        public Reader(@NotNull Source source, int i3) {
            this(source, i3, 0, 4, null);
        }

        private final void adjustDynamicTableByteCount() {
            int i3 = this.maxDynamicTableByteCount;
            int i16 = this.dynamicTableByteCount;
            if (i3 < i16) {
                if (i3 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i16 - i3);
                }
            }
        }

        private final void clearDynamicTable() {
            ArraysKt___ArraysJvmKt.fill$default(this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int dynamicTableIndex(int index) {
            return this.nextHeaderIndex + 1 + index;
        }

        private final int evictToRecoverBytes(int bytesToRecover) {
            int i3;
            int i16 = 0;
            if (bytesToRecover > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i3 = this.nextHeaderIndex;
                    if (length < i3 || bytesToRecover <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    Intrinsics.checkNotNull(header);
                    int i17 = header.hpackSize;
                    bytesToRecover -= i17;
                    this.dynamicTableByteCount -= i17;
                    this.headerCount--;
                    i16++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i3 + 1, headerArr, i3 + 1 + i16, this.headerCount);
                this.nextHeaderIndex += i16;
            }
            return i16;
        }

        private final ByteString getName(int index) throws IOException {
            if (isStaticHeader(index)) {
                return Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[index].name;
            }
            int dynamicTableIndex = dynamicTableIndex(index - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    Header header = headerArr[dynamicTableIndex];
                    Intrinsics.checkNotNull(header);
                    return header.name;
                }
            }
            throw new IOException("Header index too large " + (index + 1));
        }

        private final void insertIntoDynamicTable(int index, Header entry) {
            this.headerList.add(entry);
            int i3 = entry.hpackSize;
            if (index != -1) {
                Header header = this.dynamicTable[dynamicTableIndex(index)];
                Intrinsics.checkNotNull(header);
                i3 -= header.hpackSize;
            }
            int i16 = this.maxDynamicTableByteCount;
            if (i3 > i16) {
                clearDynamicTable();
                return;
            }
            int evictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i3) - i16);
            if (index == -1) {
                int i17 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i17 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i18 = this.nextHeaderIndex;
                this.nextHeaderIndex = i18 - 1;
                this.dynamicTable[i18] = entry;
                this.headerCount++;
            } else {
                this.dynamicTable[index + dynamicTableIndex(index) + evictToRecoverBytes] = entry;
            }
            this.dynamicTableByteCount += i3;
        }

        private final boolean isStaticHeader(int index) {
            if (index >= 0 && index <= Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1) {
                return true;
            }
            return false;
        }

        private final int readByte() throws IOException {
            return Util.and(this.source.readByte(), 255);
        }

        private final void readIndexedHeader(int index) throws IOException {
            if (isStaticHeader(index)) {
                this.headerList.add(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[index]);
                return;
            }
            int dynamicTableIndex = dynamicTableIndex(index - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (dynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (dynamicTableIndex < headerArr.length) {
                    List<Header> list = this.headerList;
                    Header header = headerArr[dynamicTableIndex];
                    Intrinsics.checkNotNull(header);
                    list.add(header);
                    return;
                }
            }
            throw new IOException("Header index too large " + (index + 1));
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int nameIndex) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(nameIndex), readByteString()));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int index) throws IOException {
            this.headerList.add(new Header(getName(index), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        @NotNull
        public final List<Header> getAndResetHeaderList() {
            List<Header> list;
            list = CollectionsKt___CollectionsKt.toList(this.headerList);
            this.headerList.clear();
            return list;
        }

        /* renamed from: maxDynamicTableByteCount, reason: from getter */
        public final int getMaxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        @NotNull
        public final ByteString readByteString() throws IOException {
            boolean z16;
            int readByte = readByte();
            if ((readByte & 128) == 128) {
                z16 = true;
            } else {
                z16 = false;
            }
            long readInt = readInt(readByte, 127);
            if (z16) {
                Buffer buffer = new Buffer();
                Huffman.INSTANCE.decode(this.source, readInt, buffer);
                return buffer.readByteString();
            }
            return this.source.readByteString(readInt);
        }

        public final void readHeaders() throws IOException {
            while (!this.source.exhausted()) {
                int and = Util.and(this.source.readByte(), 255);
                if (and != 128) {
                    if ((and & 128) == 128) {
                        readIndexedHeader(readInt(and, 127) - 1);
                    } else if (and == 64) {
                        readLiteralHeaderWithIncrementalIndexingNewName();
                    } else if ((and & 64) == 64) {
                        readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(and, 63) - 1);
                    } else if ((and & 32) == 32) {
                        int readInt = readInt(and, 31);
                        this.maxDynamicTableByteCount = readInt;
                        if (readInt >= 0 && readInt <= this.headerTableSizeSetting) {
                            adjustDynamicTableByteCount();
                        } else {
                            throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                        }
                    } else if (and != 16 && and != 0) {
                        readLiteralHeaderWithoutIndexingIndexedName(readInt(and, 15) - 1);
                    } else {
                        readLiteralHeaderWithoutIndexingNewName();
                    }
                } else {
                    throw new IOException("index == 0");
                }
            }
        }

        public final int readInt(int firstByte, int prefixMask) throws IOException {
            int i3 = firstByte & prefixMask;
            if (i3 < prefixMask) {
                return i3;
            }
            int i16 = 0;
            while (true) {
                int readByte = readByte();
                if ((readByte & 128) != 0) {
                    prefixMask += (readByte & 127) << i16;
                    i16 += 7;
                } else {
                    return prefixMask + (readByte << i16);
                }
            }
        }

        @JvmOverloads
        public Reader(@NotNull Source source, int i3, int i16) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.headerTableSizeSetting = i3;
            this.maxDynamicTableByteCount = i16;
            this.headerList = new ArrayList();
            this.source = Okio.buffer(source);
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = r2.length - 1;
        }

        public /* synthetic */ Reader(Source source, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(source, i3, (i17 & 4) != 0 ? i3 : i16);
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010\u001e\u001a\u00020\u00142\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0 J\u001e\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003R\u001c\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lokhttp3/internal/http2/Hpack$Writer;", "", "headerTableSizeSetting", "", "useCompression", "", "out", "Lokio/Buffer;", "(IZLokio/Buffer;)V", "dynamicTable", "", "Lokhttp3/internal/http2/Header;", "[Lokhttp3/internal/http2/Header;", "dynamicTableByteCount", "emitDynamicTableSizeUpdate", "headerCount", "maxDynamicTableByteCount", "nextHeaderIndex", "smallestHeaderTableSizeSetting", "adjustDynamicTableByteCount", "", "clearDynamicTable", "evictToRecoverBytes", "bytesToRecover", "insertIntoDynamicTable", "entry", "resizeHeaderTable", "writeByteString", "data", "Lokio/ByteString;", "writeHeaders", "headerBlock", "", "writeInt", "value", "prefixMask", "bits", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public static final class Writer {

        @JvmField
        @NotNull
        public Header[] dynamicTable;

        @JvmField
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;

        @JvmField
        public int headerCount;

        @JvmField
        public int headerTableSizeSetting;

        @JvmField
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        @JvmOverloads
        public Writer(int i3, @NotNull Buffer buffer) {
            this(i3, false, buffer, 2, null);
        }

        private final void adjustDynamicTableByteCount() {
            int i3 = this.maxDynamicTableByteCount;
            int i16 = this.dynamicTableByteCount;
            if (i3 < i16) {
                if (i3 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i16 - i3);
                }
            }
        }

        private final void clearDynamicTable() {
            ArraysKt___ArraysJvmKt.fill$default(this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int bytesToRecover) {
            int i3;
            int i16 = 0;
            if (bytesToRecover > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i3 = this.nextHeaderIndex;
                    if (length < i3 || bytesToRecover <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    Intrinsics.checkNotNull(header);
                    bytesToRecover -= header.hpackSize;
                    int i17 = this.dynamicTableByteCount;
                    Header header2 = this.dynamicTable[length];
                    Intrinsics.checkNotNull(header2);
                    this.dynamicTableByteCount = i17 - header2.hpackSize;
                    this.headerCount--;
                    i16++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i3 + 1, headerArr, i3 + 1 + i16, this.headerCount);
                Header[] headerArr2 = this.dynamicTable;
                int i18 = this.nextHeaderIndex;
                Arrays.fill(headerArr2, i18 + 1, i18 + 1 + i16, (Object) null);
                this.nextHeaderIndex += i16;
            }
            return i16;
        }

        private final void insertIntoDynamicTable(Header entry) {
            int i3 = entry.hpackSize;
            int i16 = this.maxDynamicTableByteCount;
            if (i3 > i16) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i3) - i16);
            int i17 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i17 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i18 = this.nextHeaderIndex;
            this.nextHeaderIndex = i18 - 1;
            this.dynamicTable[i18] = entry;
            this.headerCount++;
            this.dynamicTableByteCount += i3;
        }

        public final void resizeHeaderTable(int headerTableSizeSetting) {
            this.headerTableSizeSetting = headerTableSizeSetting;
            int min = Math.min(headerTableSizeSetting, 16384);
            int i3 = this.maxDynamicTableByteCount;
            if (i3 == min) {
                return;
            }
            if (min < i3) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, min);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = min;
            adjustDynamicTableByteCount();
        }

        public final void writeByteString(@NotNull ByteString data) throws IOException {
            Intrinsics.checkNotNullParameter(data, "data");
            if (this.useCompression) {
                Huffman huffman = Huffman.INSTANCE;
                if (huffman.encodedLength(data) < data.size()) {
                    Buffer buffer = new Buffer();
                    huffman.encode(data, buffer);
                    ByteString readByteString = buffer.readByteString();
                    writeInt(readByteString.size(), 127, 128);
                    this.out.write(readByteString);
                    return;
                }
            }
            writeInt(data.size(), 127, 0);
            this.out.write(data);
        }

        public final void writeHeaders(@NotNull List<Header> headerBlock) throws IOException {
            int i3;
            int i16;
            Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
            if (this.emitDynamicTableSizeUpdate) {
                int i17 = this.smallestHeaderTableSizeSetting;
                if (i17 < this.maxDynamicTableByteCount) {
                    writeInt(i17, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                writeInt(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = headerBlock.size();
            for (int i18 = 0; i18 < size; i18++) {
                Header header = headerBlock.get(i18);
                ByteString asciiLowercase = header.name.toAsciiLowercase();
                ByteString byteString = header.value;
                Hpack hpack = Hpack.INSTANCE;
                Integer num = hpack.getNAME_TO_FIRST_INDEX().get(asciiLowercase);
                if (num != null) {
                    i16 = num.intValue() + 1;
                    if (2 <= i16 && 7 >= i16) {
                        if (Intrinsics.areEqual(hpack.getSTATIC_HEADER_TABLE()[i16 - 1].value, byteString)) {
                            i3 = i16;
                        } else if (Intrinsics.areEqual(hpack.getSTATIC_HEADER_TABLE()[i16].value, byteString)) {
                            i16++;
                            i3 = i16;
                        }
                    }
                    i3 = i16;
                    i16 = -1;
                } else {
                    i3 = -1;
                    i16 = -1;
                }
                if (i16 == -1) {
                    int i19 = this.nextHeaderIndex + 1;
                    int length = this.dynamicTable.length;
                    while (true) {
                        if (i19 >= length) {
                            break;
                        }
                        Header header2 = this.dynamicTable[i19];
                        Intrinsics.checkNotNull(header2);
                        if (Intrinsics.areEqual(header2.name, asciiLowercase)) {
                            Header header3 = this.dynamicTable[i19];
                            Intrinsics.checkNotNull(header3);
                            if (Intrinsics.areEqual(header3.value, byteString)) {
                                i16 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (i19 - this.nextHeaderIndex);
                                break;
                            } else if (i3 == -1) {
                                i3 = (i19 - this.nextHeaderIndex) + Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length;
                            }
                        }
                        i19++;
                    }
                }
                if (i16 != -1) {
                    writeInt(i16, 127, 128);
                } else if (i3 == -1) {
                    this.out.writeByte(64);
                    writeByteString(asciiLowercase);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                } else if (asciiLowercase.startsWith(Header.PSEUDO_PREFIX) && (!Intrinsics.areEqual(Header.TARGET_AUTHORITY, asciiLowercase))) {
                    writeInt(i3, 15, 0);
                    writeByteString(byteString);
                } else {
                    writeInt(i3, 63, 64);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                }
            }
        }

        public final void writeInt(int value, int prefixMask, int bits) {
            if (value < prefixMask) {
                this.out.writeByte(value | bits);
                return;
            }
            this.out.writeByte(bits | prefixMask);
            int i3 = value - prefixMask;
            while (i3 >= 128) {
                this.out.writeByte(128 | (i3 & 127));
                i3 >>>= 7;
            }
            this.out.writeByte(i3);
        }

        @JvmOverloads
        public Writer(@NotNull Buffer buffer) {
            this(0, false, buffer, 3, null);
        }

        @JvmOverloads
        public Writer(int i3, boolean z16, @NotNull Buffer out) {
            Intrinsics.checkNotNullParameter(out, "out");
            this.headerTableSizeSetting = i3;
            this.useCompression = z16;
            this.out = out;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = i3;
            this.dynamicTable = new Header[8];
            this.nextHeaderIndex = r2.length - 1;
        }

        public /* synthetic */ Writer(int i3, boolean z16, Buffer buffer, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 4096 : i3, (i16 & 2) != 0 ? true : z16, buffer);
        }
    }

    static {
        Hpack hpack = new Hpack();
        INSTANCE = hpack;
        ByteString byteString = Header.TARGET_METHOD;
        ByteString byteString2 = Header.TARGET_PATH;
        ByteString byteString3 = Header.TARGET_SCHEME;
        ByteString byteString4 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[]{new Header(Header.TARGET_AUTHORITY, ""), new Header(byteString, "GET"), new Header(byteString, "POST"), new Header(byteString2, "/"), new Header(byteString2, "/index.html"), new Header(byteString3, "http"), new Header(byteString3, "https"), new Header(byteString4, "200"), new Header(byteString4, ThemeReporter.FROM_AUTH), new Header(byteString4, ThemeReporter.FROM_INIT_THEME), new Header(byteString4, "304"), new Header(byteString4, IndividuationPlugin.Business_Pendant), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header(Headers.ACCEPT_RANGES, ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header(TencentMapServiceProtocol.SERVICE_NAME_AUTHORIZATION, ""), new Header("cache-control", ""), new Header(Headers.CONTENT_DISPOSITION, ""), new Header(Headers.CONTENT_ENCODING, ""), new Header("content-language", ""), new Header(Headers.CONTENT_LEN, ""), new Header("content-location", ""), new Header(HttpMsg.CONTENTRANGE, ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header(Headers.ETAG, ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header(MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, ""), new Header("location", ""), new Header("max-forwards", ""), new Header(Headers.PROXY_AUTHENTICATE, ""), new Header("proxy-authorization", ""), new Header(DownloaderConstant.KEY_RANGE, ""), new Header(ISchemeApi.KEY_REFERER, ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header(Headers.SET_COOKIE, ""), new Header("strict-transport-security", ""), new Header(Headers.TRANSFER_ENCODING, ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header(Headers.WWW_AUTHENTICATE, "")};
        NAME_TO_FIRST_INDEX = hpack.nameToFirstIndex();
    }

    Hpack() {
    }

    private final Map<ByteString, Integer> nameToFirstIndex() {
        Header[] headerArr = STATIC_HEADER_TABLE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(headerArr.length);
        int length = headerArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            Header[] headerArr2 = STATIC_HEADER_TABLE;
            if (!linkedHashMap.containsKey(headerArr2[i3].name)) {
                linkedHashMap.put(headerArr2[i3].name, Integer.valueOf(i3));
            }
        }
        Map<ByteString, Integer> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "Collections.unmodifiableMap(result)");
        return unmodifiableMap;
    }

    @NotNull
    public final ByteString checkLowercase(@NotNull ByteString name) throws IOException {
        Intrinsics.checkNotNullParameter(name, "name");
        int size = name.size();
        for (int i3 = 0; i3 < size; i3++) {
            byte b16 = (byte) 65;
            byte b17 = (byte) 90;
            byte b18 = name.getByte(i3);
            if (b16 <= b18 && b17 >= b18) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + name.utf8());
            }
        }
        return name;
    }

    @NotNull
    public final Map<ByteString, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    @NotNull
    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }
}
