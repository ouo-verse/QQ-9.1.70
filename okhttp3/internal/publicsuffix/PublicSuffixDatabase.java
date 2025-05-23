package okhttp3.internal.publicsuffix;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "", "()V", "listRead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "publicSuffixExceptionListBytes", "", "publicSuffixListBytes", "readCompleteLatch", "Ljava/util/concurrent/CountDownLatch;", "findMatchingRule", "", "", "domainLabels", "getEffectiveTldPlusOne", "domain", "readTheList", "", "readTheListUninterruptibly", "setListBytes", "splitDomain", "Companion", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes20.dex */
public final class PublicSuffixDatabase {
    private static final char EXCEPTION_MARKER = '!';
    private static final List<String> PREVAILING_RULE;

    @NotNull
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private static final PublicSuffixDatabase instance;
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final byte[] WILDCARD_LABEL = {(byte) 42};
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\fJ)\u0010\u000e\u001a\u0004\u0018\u00010\u0007*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lokhttp3/internal/publicsuffix/PublicSuffixDatabase$Companion;", "", "()V", "EXCEPTION_MARKER", "", "PREVAILING_RULE", "", "", "PUBLIC_SUFFIX_RESOURCE", "WILDCARD_LABEL", "", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;", "get", "binarySearch", "labels", "", "labelIndex", "", "([B[[BI)Ljava/lang/String;", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes20.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String binarySearch(byte[] bArr, byte[][] bArr2, int i3) {
            int i16;
            boolean z16;
            int and;
            int and2;
            int length = bArr.length;
            int i17 = 0;
            while (i17 < length) {
                int i18 = (i17 + length) / 2;
                while (i18 > -1 && bArr[i18] != ((byte) 10)) {
                    i18--;
                }
                int i19 = i18 + 1;
                int i26 = 1;
                while (true) {
                    i16 = i19 + i26;
                    if (bArr[i16] == ((byte) 10)) {
                        break;
                    }
                    i26++;
                }
                int i27 = i16 - i19;
                int i28 = i3;
                boolean z17 = false;
                int i29 = 0;
                int i36 = 0;
                while (true) {
                    if (z17) {
                        and = 46;
                        z16 = false;
                    } else {
                        z16 = z17;
                        and = Util.and(bArr2[i28][i29], 255);
                    }
                    and2 = and - Util.and(bArr[i19 + i36], 255);
                    if (and2 != 0) {
                        break;
                    }
                    i36++;
                    i29++;
                    if (i36 == i27) {
                        break;
                    }
                    if (bArr2[i28].length == i29) {
                        if (i28 == bArr2.length - 1) {
                            break;
                        }
                        i28++;
                        i29 = -1;
                        z17 = true;
                    } else {
                        z17 = z16;
                    }
                }
                if (and2 >= 0) {
                    if (and2 <= 0) {
                        int i37 = i27 - i36;
                        int length2 = bArr2[i28].length - i29;
                        int length3 = bArr2.length;
                        for (int i38 = i28 + 1; i38 < length3; i38++) {
                            length2 += bArr2[i38].length;
                        }
                        if (length2 >= i37) {
                            if (length2 <= i37) {
                                Charset UTF_8 = StandardCharsets.UTF_8;
                                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                                return new String(bArr, i19, i27, UTF_8);
                            }
                        }
                    }
                    i17 = i16 + 1;
                }
                length = i19 - 1;
            }
            return null;
        }

        @NotNull
        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("*");
        PREVAILING_RULE = listOf;
        instance = new PublicSuffixDatabase();
    }

    public static final /* synthetic */ byte[] access$getPublicSuffixListBytes$p(PublicSuffixDatabase publicSuffixDatabase) {
        byte[] bArr = publicSuffixDatabase.publicSuffixListBytes;
        if (bArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ea, code lost:
    
        r4 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r8, new char[]{'.'}, false, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0101, code lost:
    
        r1 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r5, new char[]{'.'}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<String> findMatchingRule(List<String> domainLabels) {
        boolean z16;
        String str;
        String str2;
        String str3;
        List<String> emptyList;
        List<String> emptyList2;
        List<String> split$default;
        if (!this.listRead.get() && this.listRead.compareAndSet(false, true)) {
            readTheListUninterruptibly();
        } else {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        if (this.publicSuffixListBytes != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            int size = domainLabels.size();
            byte[][] bArr = new byte[size];
            for (int i3 = 0; i3 < size; i3++) {
                String str4 = domainLabels.get(i3);
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                if (str4 != null) {
                    byte[] bytes = str4.getBytes(UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                    bArr[i3] = bytes;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
            int i16 = 0;
            while (true) {
                str = null;
                if (i16 < size) {
                    Companion companion = INSTANCE;
                    byte[] bArr2 = this.publicSuffixListBytes;
                    if (bArr2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                    }
                    str2 = companion.binarySearch(bArr2, bArr, i16);
                    if (str2 != null) {
                        break;
                    }
                    i16++;
                } else {
                    str2 = null;
                    break;
                }
            }
            if (size > 1) {
                byte[][] bArr3 = (byte[][]) bArr.clone();
                int length = bArr3.length - 1;
                for (int i17 = 0; i17 < length; i17++) {
                    bArr3[i17] = WILDCARD_LABEL;
                    Companion companion2 = INSTANCE;
                    byte[] bArr4 = this.publicSuffixListBytes;
                    if (bArr4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixListBytes");
                    }
                    String binarySearch = companion2.binarySearch(bArr4, bArr3, i17);
                    if (binarySearch != null) {
                        str3 = binarySearch;
                        break;
                    }
                }
            }
            str3 = null;
            if (str3 != null) {
                int i18 = size - 1;
                int i19 = 0;
                while (true) {
                    if (i19 >= i18) {
                        break;
                    }
                    Companion companion3 = INSTANCE;
                    byte[] bArr5 = this.publicSuffixExceptionListBytes;
                    if (bArr5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("publicSuffixExceptionListBytes");
                    }
                    String binarySearch2 = companion3.binarySearch(bArr5, bArr, i19);
                    if (binarySearch2 != null) {
                        str = binarySearch2;
                        break;
                    }
                    i19++;
                }
            }
            if (str != null) {
                split$default = StringsKt__StringsKt.split$default((CharSequence) (EXCEPTION_MARKER + str), new char[]{'.'}, false, 0, 6, (Object) null);
                return split$default;
            }
            if (str2 == null && str3 == null) {
                return PREVAILING_RULE;
            }
            if (str2 == null || emptyList == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            if (str3 == null || emptyList2 == null) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            }
            if (emptyList.size() <= emptyList2.size()) {
                return emptyList2;
            }
            return emptyList;
        }
        throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
    }

    private final void readTheList() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream != null) {
            BufferedSource buffer = Okio.buffer(new GzipSource(Okio.source(resourceAsStream)));
            try {
                byte[] readByteArray = buffer.readByteArray(buffer.readInt());
                byte[] readByteArray2 = buffer.readByteArray(buffer.readInt());
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(buffer, null);
                synchronized (this) {
                    Intrinsics.checkNotNull(readByteArray);
                    this.publicSuffixListBytes = readByteArray;
                    Intrinsics.checkNotNull(readByteArray2);
                    this.publicSuffixExceptionListBytes = readByteArray2;
                }
                this.readCompleteLatch.countDown();
            } finally {
            }
        }
    }

    private final void readTheListUninterruptibly() {
        boolean z16 = false;
        while (true) {
            try {
                try {
                    readTheList();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z16 = true;
                } catch (IOException e16) {
                    Platform.INSTANCE.get().log("Failed to read public suffix list", 5, e16);
                    if (z16) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th5) {
                if (z16) {
                    Thread.currentThread().interrupt();
                }
                throw th5;
            }
        }
        if (z16) {
            Thread.currentThread().interrupt();
        }
    }

    private final List<String> splitDomain(String domain) {
        List<String> split$default;
        Object last;
        List<String> dropLast;
        split$default = StringsKt__StringsKt.split$default((CharSequence) domain, new char[]{'.'}, false, 0, 6, (Object) null);
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) split$default);
        if (Intrinsics.areEqual((String) last, "")) {
            dropLast = CollectionsKt___CollectionsKt.dropLast(split$default, 1);
            return dropLast;
        }
        return split$default;
    }

    @Nullable
    public final String getEffectiveTldPlusOne(@NotNull String domain) {
        int size;
        int size2;
        Sequence asSequence;
        Sequence drop;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(domain, "domain");
        String unicodeDomain = IDN.toUnicode(domain);
        Intrinsics.checkNotNullExpressionValue(unicodeDomain, "unicodeDomain");
        List<String> splitDomain = splitDomain(unicodeDomain);
        List<String> findMatchingRule = findMatchingRule(splitDomain);
        if (splitDomain.size() == findMatchingRule.size() && findMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (findMatchingRule.get(0).charAt(0) == '!') {
            size = splitDomain.size();
            size2 = findMatchingRule.size();
        } else {
            size = splitDomain.size();
            size2 = findMatchingRule.size() + 1;
        }
        asSequence = CollectionsKt___CollectionsKt.asSequence(splitDomain(domain));
        drop = SequencesKt___SequencesKt.drop(asSequence, size - size2);
        joinToString$default = SequencesKt___SequencesKt.joinToString$default(drop, ".", null, null, 0, null, null, 62, null);
        return joinToString$default;
    }

    public final void setListBytes(@NotNull byte[] publicSuffixListBytes, @NotNull byte[] publicSuffixExceptionListBytes) {
        Intrinsics.checkNotNullParameter(publicSuffixListBytes, "publicSuffixListBytes");
        Intrinsics.checkNotNullParameter(publicSuffixExceptionListBytes, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = publicSuffixListBytes;
        this.publicSuffixExceptionListBytes = publicSuffixExceptionListBytes;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
