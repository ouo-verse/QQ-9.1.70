package com.tencent.qqnt.qbasealbum.urldrawable;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.io.Closeable;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.zip.Adler32;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 T2\u00020\u0001:\u0002U\"B/\u0012\u0006\u0010O\u001a\u00020N\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010P\u001a\u00020\u0004\u0012\u0006\u0010Q\u001a\u00020\u0007\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0007H\u0002J\"\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\"\u0010\u001a\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\u0016\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018J \u0010\"\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007R\u0014\u0010$\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010#R\u0014\u0010%\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010#R\u0014\u0010&\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010#R\u0018\u0010)\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010.R\u0016\u00101\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00103\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010.R\u0016\u00105\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010.R\u0016\u00107\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010.R\u0014\u00109\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010.R\u0018\u0010;\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010#R\u0018\u0010<\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010#R\u0016\u0010>\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010.R\u0016\u0010@\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010.R\u0014\u0010C\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010E\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010BR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010.R\u0016\u0010M\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010.\u00a8\u0006V"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/urldrawable/BlobCache;", "Ljava/io/Closeable;", "", "d", "", "j", "p", "", "maxEntries", "maxBytes", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", ReportConstant.COSTREPORT_PREFIX, "hashStart", "b", "", "key", "", "data", "length", tl.h.F, "Ljava/io/RandomAccessFile;", "file", "offset", "Lcom/tencent/qqnt/qbasealbum/urldrawable/BlobCache$a;", "req", "f", "l", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "close", "g", "k", "nbytes", "a", "Ljava/io/RandomAccessFile;", "mIndexFile", "mDataFile0", "mDataFile1", "Ljava/nio/channels/FileChannel;", "Ljava/nio/channels/FileChannel;", "mIndexChannel", "Ljava/nio/MappedByteBuffer;", "i", "Ljava/nio/MappedByteBuffer;", "mIndexBuffer", "I", "mMaxEntries", BdhLogUtil.LogTag.Tag_Conn, "mMaxBytes", "D", "mActiveRegion", "E", "mActiveEntries", UserInfo.SEX_FEMALE, "mActiveBytes", "G", "mVersion", "H", "mActiveDataFile", "mInactiveDataFile", "J", "mActiveHashStart", "K", "mInactiveHashStart", "L", "[B", "mIndexHeader", "M", "mBlobHeader", "Ljava/util/zip/Adler32;", "N", "Ljava/util/zip/Adler32;", "mAdler32", "P", "mSlotOffset", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "mFileOffset", "", "path", "reset", "version", "<init>", "(Ljava/lang/String;IIZI)V", BdhLogUtil.LogTag.Tag_Req, "Companion", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class BlobCache implements Closeable {
    static IPatchRedirector $redirector_;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int mMaxBytes;

    /* renamed from: D, reason: from kotlin metadata */
    private int mActiveRegion;

    /* renamed from: E, reason: from kotlin metadata */
    private int mActiveEntries;

    /* renamed from: F, reason: from kotlin metadata */
    private int mActiveBytes;

    /* renamed from: G, reason: from kotlin metadata */
    private final int mVersion;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private RandomAccessFile mActiveDataFile;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private RandomAccessFile mInactiveDataFile;

    /* renamed from: J, reason: from kotlin metadata */
    private int mActiveHashStart;

    /* renamed from: K, reason: from kotlin metadata */
    private int mInactiveHashStart;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final byte[] mIndexHeader;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final byte[] mBlobHeader;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Adler32 mAdler32;

    /* renamed from: P, reason: from kotlin metadata */
    private int mSlotOffset;

    /* renamed from: Q, reason: from kotlin metadata */
    private int mFileOffset;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RandomAccessFile mIndexFile;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RandomAccessFile mDataFile0;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RandomAccessFile mDataFile1;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FileChannel mIndexChannel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MappedByteBuffer mIndexBuffer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mMaxEntries;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0016\u0010\u0003\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u001e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tJ\u001e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fR\u0014\u0010\u0010\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0011R\u0014\u0010\u0017\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0011R\u0014\u0010\u0019\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u0014\u0010\u001a\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0011R\u0014\u0010\u001b\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0011R\u0014\u0010\u001c\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0011R\u0014\u0010\u001d\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0011R\u0014\u0010\u001e\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0011R\u0014\u0010\u001f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0011R\u0014\u0010 \u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u0011R\u0014\u0010!\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0011R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006'"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/urldrawable/BlobCache$Companion;", "", "Ljava/io/Closeable;", "c", "", "a", "(Ljava/io/Closeable;)Lkotlin/Unit;", "", "buf", "", "offset", "b", "", "value", "d", "e", "BH_CHECKSUM", "I", "BH_KEY", "BH_LENGTH", "BH_OFFSET", "BLOB_HEADER_SIZE", "DATA_HEADER_SIZE", "IH_ACTIVE_BYTES", "IH_ACTIVE_ENTRIES", "IH_ACTIVE_REGION", "IH_CHECKSUM", "IH_MAGIC", "IH_MAX_BYTES", "IH_MAX_ENTRIES", "IH_VERSION", "INDEX_HEADER_SIZE", "MAGIC_DATA_FILE", "MAGIC_INDEX_FILE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) defaultConstructorMarker);
        }

        @Nullable
        public final Unit a(@Nullable Closeable c16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Unit) iPatchRedirector.redirect((short) 2, (Object) this, (Object) c16);
            }
            if (c16 != null) {
                try {
                    c16.close();
                    return Unit.INSTANCE;
                } catch (Throwable th5) {
                    ox3.a.f("QBaseAlbum.BlobCache", new Function0<String>(th5) { // from class: com.tencent.qqnt.qbasealbum.urldrawable.BlobCache$Companion$closeSilently$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Throwable $th;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$th = th5;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) th5);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                            return "closeSilently, " + this.$th;
                        }
                    });
                    return Unit.INSTANCE;
                }
            }
            return null;
        }

        public final int b(@NotNull byte[] buf, int offset) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) buf, offset)).intValue();
            }
            Intrinsics.checkNotNullParameter(buf, "buf");
            return ((buf[offset + 3] & 255) << 24) | (buf[offset] & 255) | ((buf[offset + 1] & 255) << 8) | ((buf[offset + 2] & 255) << 16);
        }

        public final long c(@NotNull byte[] buf, int offset) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, (Object) buf, offset)).longValue();
            }
            Intrinsics.checkNotNullParameter(buf, "buf");
            long j3 = buf[offset + 7] & 255;
            for (int i3 = 6; -1 < i3; i3--) {
                j3 = (j3 << 8) | (buf[offset + i3] & 255);
            }
            return j3;
        }

        public final void d(@NotNull byte[] buf, int offset, int value) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, buf, Integer.valueOf(offset), Integer.valueOf(value));
                return;
            }
            Intrinsics.checkNotNullParameter(buf, "buf");
            for (int i3 = 0; i3 < 4; i3++) {
                buf[offset + i3] = (byte) (value & 255);
                value >>= 8;
            }
        }

        public final void e(@NotNull byte[] buf, int offset, long value) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, buf, Integer.valueOf(offset), Long.valueOf(value));
                return;
            }
            Intrinsics.checkNotNullParameter(buf, "buf");
            for (int i3 = 0; i3 < 8; i3++) {
                buf[offset + i3] = (byte) (255 & value);
                value >>= 8;
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/urldrawable/BlobCache$a;", "", "", "a", "J", "b", "()J", "e", "(J)V", "key", "", "[B", "()[B", "d", "([B)V", "buffer", "", "c", "I", "()I", "f", "(I)V", "length", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long key;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private byte[] buffer;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int length;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Nullable
        public final byte[] a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.buffer;
        }

        public final long b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
            }
            return this.key;
        }

        public final int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.length;
        }

        public final void d(@Nullable byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) bArr);
            } else {
                this.buffer = bArr;
            }
        }

        public final void e(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
            } else {
                this.key = j3;
            }
        }

        public final void f(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, i3);
            } else {
                this.length = i3;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45212);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public BlobCache(@NotNull String path, int i3, int i16, boolean z16, int i17) {
        Intrinsics.checkNotNullParameter(path, "path");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, path, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17));
            return;
        }
        this.mIndexHeader = new byte[32];
        this.mBlobHeader = new byte[20];
        this.mAdler32 = new Adler32();
        this.mIndexFile = new RandomAccessFile(path + ".idx", "rw");
        this.mDataFile0 = new RandomAccessFile(path + ".0", "rw");
        this.mDataFile1 = new RandomAccessFile(path + ".1", "rw");
        this.mVersion = i17;
        if (z16 || !j()) {
            m(i3, i16);
            if (j()) {
                return;
            }
            d();
            throw new IOException("unable to load index");
        }
    }

    private final void b(int hashStart) {
        int coerceAtMost;
        byte[] bArr = new byte[1024];
        MappedByteBuffer mappedByteBuffer = this.mIndexBuffer;
        Intrinsics.checkNotNull(mappedByteBuffer);
        mappedByteBuffer.position(hashStart);
        int i3 = this.mMaxEntries * 12;
        while (i3 > 0) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3, 1024);
            MappedByteBuffer mappedByteBuffer2 = this.mIndexBuffer;
            Intrinsics.checkNotNull(mappedByteBuffer2);
            mappedByteBuffer2.put(bArr, 0, coerceAtMost);
            i3 -= coerceAtMost;
        }
    }

    private final void d() {
        Companion companion = INSTANCE;
        companion.a(this.mIndexChannel);
        companion.a(this.mIndexFile);
        companion.a(this.mDataFile0);
        companion.a(this.mDataFile1);
    }

    private final void e() throws IOException {
        int i3 = 1 - this.mActiveRegion;
        this.mActiveRegion = i3;
        this.mActiveEntries = 0;
        this.mActiveBytes = 4;
        Companion companion = INSTANCE;
        companion.d(this.mIndexHeader, 12, i3);
        companion.d(this.mIndexHeader, 16, this.mActiveEntries);
        companion.d(this.mIndexHeader, 20, this.mActiveBytes);
        s();
        p();
        b(this.mActiveHashStart);
        r();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
    
        if (r12.length < r0) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean f(RandomAccessFile file, int offset, a req) throws IOException {
        byte[] bArr = this.mBlobHeader;
        Intrinsics.checkNotNull(file);
        long filePointer = file.getFilePointer();
        try {
            file.seek(offset);
            if (file.read(bArr) != 20) {
                return false;
            }
            Companion companion = INSTANCE;
            if (companion.c(bArr, 0) != req.b()) {
                return false;
            }
            int b16 = companion.b(bArr, 8);
            if (companion.b(bArr, 12) != offset) {
                return false;
            }
            int b17 = companion.b(bArr, 16);
            if (b17 >= 0 && b17 <= (this.mMaxBytes - offset) - 20) {
                if (req.a() != null) {
                    byte[] a16 = req.a();
                    Intrinsics.checkNotNull(a16);
                }
                req.d(new byte[b17]);
                byte[] a17 = req.a();
                req.f(b17);
                if (file.read(a17, 0, b17) != b17) {
                    return false;
                }
                if (a(a17, 0, b17) != b16) {
                    return false;
                }
                file.seek(filePointer);
                return true;
            }
            return false;
        } catch (Throwable th5) {
            try {
                ox3.a.f("QBaseAlbum.BlobCache", new Function0<String>(th5) { // from class: com.tencent.qqnt.qbasealbum.urldrawable.BlobCache$getBlob$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ Throwable $th;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$th = th5;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) th5);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                        return "getBlob failed. " + this.$th;
                    }
                });
                return false;
            } finally {
                file.seek(filePointer);
            }
        }
    }

    private final void h(long key, byte[] data, int length) throws IOException {
        byte[] bArr = this.mBlobHeader;
        int a16 = a(data, 0, length);
        Companion companion = INSTANCE;
        companion.e(bArr, 0, key);
        companion.d(bArr, 8, a16);
        companion.d(bArr, 12, this.mActiveBytes);
        companion.d(bArr, 16, length);
        RandomAccessFile randomAccessFile = this.mActiveDataFile;
        Intrinsics.checkNotNull(randomAccessFile);
        randomAccessFile.write(bArr);
        RandomAccessFile randomAccessFile2 = this.mActiveDataFile;
        Intrinsics.checkNotNull(randomAccessFile2);
        randomAccessFile2.write(data, 0, length);
        MappedByteBuffer mappedByteBuffer = this.mIndexBuffer;
        Intrinsics.checkNotNull(mappedByteBuffer);
        mappedByteBuffer.putLong(this.mSlotOffset, key);
        MappedByteBuffer mappedByteBuffer2 = this.mIndexBuffer;
        Intrinsics.checkNotNull(mappedByteBuffer2);
        mappedByteBuffer2.putInt(this.mSlotOffset + 8, this.mActiveBytes);
        int i3 = this.mActiveBytes + length + 20;
        this.mActiveBytes = i3;
        companion.d(this.mIndexHeader, 20, i3);
    }

    private final boolean j() {
        int i3;
        int i16;
        boolean z16;
        boolean z17;
        try {
            this.mIndexFile.seek(0L);
            this.mDataFile0.seek(0L);
            this.mDataFile1.seek(0L);
            byte[] bArr = this.mIndexHeader;
            if (this.mIndexFile.read(bArr) != 32) {
                return false;
            }
            Companion companion = INSTANCE;
            if (companion.b(bArr, 0) != -1289277377 || companion.b(bArr, 24) != this.mVersion) {
                return false;
            }
            this.mMaxEntries = companion.b(bArr, 4);
            this.mMaxBytes = companion.b(bArr, 8);
            this.mActiveRegion = companion.b(bArr, 12);
            this.mActiveEntries = companion.b(bArr, 16);
            this.mActiveBytes = companion.b(bArr, 20);
            if (a(bArr, 0, 28) != companion.b(bArr, 28) || (i3 = this.mMaxEntries) <= 0 || (i16 = this.mMaxBytes) <= 0) {
                return false;
            }
            int i17 = this.mActiveRegion;
            if (i17 != 0 && i17 != 1) {
                return false;
            }
            int i18 = this.mActiveEntries;
            if (i18 >= 0 && i18 <= i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return false;
            }
            int i19 = this.mActiveBytes;
            if (4 <= i19 && i19 <= i16) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17 || this.mIndexFile.length() != (this.mMaxEntries * 12 * 2) + 32) {
                return false;
            }
            byte[] bArr2 = new byte[4];
            if (this.mDataFile0.read(bArr2) != 4 || companion.b(bArr2, 0) != -1121680097 || this.mDataFile1.read(bArr2) != 4 || companion.b(bArr2, 0) != -1121680097) {
                return false;
            }
            FileChannel channel = this.mIndexFile.getChannel();
            this.mIndexChannel = channel;
            Intrinsics.checkNotNull(channel);
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0L, this.mIndexFile.length());
            this.mIndexBuffer = map;
            Intrinsics.checkNotNull(map);
            map.order(ByteOrder.LITTLE_ENDIAN);
            p();
            return true;
        } catch (IOException e16) {
            ox3.a.f("QBaseAlbum.BlobCache", new Function0<String>(e16) { // from class: com.tencent.qqnt.qbasealbum.urldrawable.BlobCache$loadIndex$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ IOException $e;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$e = e16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) e16);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "loadIndex failed. " + this.$e;
                }
            });
            return false;
        }
    }

    private final boolean l(long key, int hashStart) {
        int i3 = this.mMaxEntries;
        int i16 = (int) (key % i3);
        if (i16 < 0) {
            i16 += i3;
        }
        int i17 = i16;
        while (true) {
            int i18 = (i17 * 12) + hashStart;
            MappedByteBuffer mappedByteBuffer = this.mIndexBuffer;
            Intrinsics.checkNotNull(mappedByteBuffer);
            long j3 = mappedByteBuffer.getLong(i18);
            MappedByteBuffer mappedByteBuffer2 = this.mIndexBuffer;
            Intrinsics.checkNotNull(mappedByteBuffer2);
            int i19 = mappedByteBuffer2.getInt(i18 + 8);
            if (i19 == 0) {
                this.mSlotOffset = i18;
                return false;
            }
            if (j3 == key) {
                this.mSlotOffset = i18;
                this.mFileOffset = i19;
                return true;
            }
            i17++;
            if (i17 >= this.mMaxEntries) {
                i17 = 0;
            }
            if (i17 == i16) {
                MappedByteBuffer mappedByteBuffer3 = this.mIndexBuffer;
                Intrinsics.checkNotNull(mappedByteBuffer3);
                mappedByteBuffer3.putInt((i17 * 12) + hashStart + 8, 0);
            }
        }
    }

    private final void m(int maxEntries, int maxBytes) throws IOException {
        this.mIndexFile.setLength(0L);
        this.mIndexFile.setLength((maxEntries * 12 * 2) + 32);
        this.mIndexFile.seek(0L);
        byte[] bArr = this.mIndexHeader;
        Companion companion = INSTANCE;
        companion.d(bArr, 0, -1289277377);
        companion.d(bArr, 4, maxEntries);
        companion.d(bArr, 8, maxBytes);
        companion.d(bArr, 12, 0);
        companion.d(bArr, 16, 0);
        companion.d(bArr, 20, 4);
        companion.d(bArr, 24, this.mVersion);
        companion.d(bArr, 28, a(bArr, 0, 28));
        this.mIndexFile.write(bArr);
        this.mDataFile0.setLength(0L);
        this.mDataFile1.setLength(0L);
        this.mDataFile0.seek(0L);
        this.mDataFile1.seek(0L);
        companion.d(bArr, 0, -1121680097);
        this.mDataFile0.write(bArr, 0, 4);
        this.mDataFile1.write(bArr, 0, 4);
    }

    private final void p() throws IOException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        int i3 = this.mActiveRegion;
        if (i3 == 0) {
            randomAccessFile = this.mDataFile0;
        } else {
            randomAccessFile = this.mDataFile1;
        }
        this.mActiveDataFile = randomAccessFile;
        if (i3 == 1) {
            randomAccessFile2 = this.mDataFile0;
        } else {
            randomAccessFile2 = this.mDataFile1;
        }
        this.mInactiveDataFile = randomAccessFile2;
        Intrinsics.checkNotNull(randomAccessFile);
        randomAccessFile.setLength(this.mActiveBytes);
        RandomAccessFile randomAccessFile3 = this.mActiveDataFile;
        Intrinsics.checkNotNull(randomAccessFile3);
        randomAccessFile3.seek(this.mActiveBytes);
        this.mActiveHashStart = 32;
        this.mInactiveHashStart = 32;
        if (this.mActiveRegion == 0) {
            this.mInactiveHashStart = 32 + (this.mMaxEntries * 12);
        } else {
            this.mActiveHashStart = 32 + (this.mMaxEntries * 12);
        }
    }

    private final void q() {
        r();
        try {
            this.mDataFile0.getFD().sync();
        } catch (Throwable th5) {
            ox3.a.f("QBaseAlbum.BlobCache", new Function0<String>(th5) { // from class: com.tencent.qqnt.qbasealbum.urldrawable.BlobCache$syncAll$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Throwable $th;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$th = th5;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) th5);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "syncAll, mDataFile0, " + this.$th;
                }
            });
        }
        try {
            this.mDataFile1.getFD().sync();
        } catch (Throwable th6) {
            ox3.a.f("QBaseAlbum.BlobCache", new Function0<String>(th6) { // from class: com.tencent.qqnt.qbasealbum.urldrawable.BlobCache$syncAll$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Throwable $th;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$th = th6;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) th6);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "syncAll, mDataFile1, " + this.$th;
                }
            });
        }
    }

    private final void r() {
        try {
            MappedByteBuffer mappedByteBuffer = this.mIndexBuffer;
            Intrinsics.checkNotNull(mappedByteBuffer);
            mappedByteBuffer.force();
        } catch (Throwable th5) {
            ox3.a.f("QBaseAlbum.BlobCache", new Function0<String>(th5) { // from class: com.tencent.qqnt.qbasealbum.urldrawable.BlobCache$syncIndex$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Throwable $th;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$th = th5;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) th5);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (String) iPatchRedirector.redirect((short) 2, (Object) this);
                    }
                    return "syncIndex, " + this.$th;
                }
            });
        }
    }

    private final void s() {
        Companion companion = INSTANCE;
        byte[] bArr = this.mIndexHeader;
        companion.d(bArr, 28, a(bArr, 0, 28));
        MappedByteBuffer mappedByteBuffer = this.mIndexBuffer;
        Intrinsics.checkNotNull(mappedByteBuffer);
        mappedByteBuffer.position(0);
        MappedByteBuffer mappedByteBuffer2 = this.mIndexBuffer;
        Intrinsics.checkNotNull(mappedByteBuffer2);
        mappedByteBuffer2.put(this.mIndexHeader);
    }

    public final int a(@Nullable byte[] data, int offset, int nbytes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, this, data, Integer.valueOf(offset), Integer.valueOf(nbytes))).intValue();
        }
        this.mAdler32.reset();
        this.mAdler32.update(data, offset, nbytes);
        return (int) this.mAdler32.getValue();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            q();
            d();
        }
    }

    public final void g(long key, @NotNull byte[] data) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(key), data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        int length = data.length + 24;
        int i3 = this.mMaxBytes;
        if (length <= i3) {
            if (this.mActiveBytes + 20 + data.length > i3 || this.mActiveEntries * 2 >= this.mMaxEntries) {
                e();
            }
            if (!l(key, this.mActiveHashStart)) {
                int i16 = this.mActiveEntries + 1;
                this.mActiveEntries = i16;
                INSTANCE.d(this.mIndexHeader, 16, i16);
            }
            h(key, data, data.length);
            s();
            return;
        }
        throw new RuntimeException("blob is too large!");
    }

    public final boolean k(@NotNull a req) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) req)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(req, "req");
        if (l(req.b(), this.mActiveHashStart) && f(this.mActiveDataFile, this.mFileOffset, req)) {
            return true;
        }
        int i3 = this.mSlotOffset;
        if (l(req.b(), this.mInactiveHashStart) && f(this.mInactiveDataFile, this.mFileOffset, req)) {
            if (this.mActiveBytes + 20 + req.c() <= this.mMaxBytes && this.mActiveEntries * 2 < this.mMaxEntries) {
                this.mSlotOffset = i3;
                try {
                    h(req.b(), req.a(), req.c());
                    int i16 = this.mActiveEntries + 1;
                    this.mActiveEntries = i16;
                    INSTANCE.d(this.mIndexHeader, 16, i16);
                    s();
                } catch (Throwable unused) {
                    ox3.a.f("QBaseAlbum.BlobCache", BlobCache$lookup$1.INSTANCE);
                }
            }
            return true;
        }
        return false;
    }
}
