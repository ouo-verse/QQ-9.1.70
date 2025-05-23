package okio;

import com.gcore.abase.utils.PatternUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import okio.internal._ByteStringKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 ]2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001]B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0011\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0000H\u0096\u0002J,\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016J\u0015\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0010H\u0010\u00a2\u0006\u0002\b#J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0000J\u0013\u0010'\u001a\u00020%2\b\u0010\u001a\u001a\u0004\u0018\u00010(H\u0096\u0002J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\tH\u0087\u0002\u00a2\u0006\u0002\b,J\u0015\u0010,\u001a\u00020*2\u0006\u0010+\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b-J\r\u0010.\u001a\u00020\tH\u0010\u00a2\u0006\u0002\b/J\b\u0010\b\u001a\u00020\tH\u0016J\b\u00100\u001a\u00020\u0010H\u0016J\u001d\u00101\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u00102\u0006\u00102\u001a\u00020\u0000H\u0010\u00a2\u0006\u0002\b3J\u0010\u00104\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0000H\u0016J\u0010\u00105\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0000H\u0016J\u0010\u00106\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u0000H\u0016J\u001a\u00107\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u00020\tH\u0017J\u001a\u00107\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00108\u001a\u00020\tH\u0007J\r\u00109\u001a\u00020\u0004H\u0010\u00a2\u0006\u0002\b:J\u0015\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u00020\tH\u0010\u00a2\u0006\u0002\b=J\u001a\u0010>\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u00020\tH\u0017J\u001a\u0010>\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u00108\u001a\u00020\tH\u0007J\u0006\u0010?\u001a\u00020\u0000J(\u0010@\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016J(\u0010@\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0016J\u0010\u0010B\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020DH\u0002J\u0006\u0010E\u001a\u00020\u0000J\u0006\u0010F\u001a\u00020\u0000J\u0006\u0010G\u001a\u00020\u0000J\r\u0010\u000e\u001a\u00020\tH\u0007\u00a2\u0006\u0002\bHJ\u000e\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020\u0004J\u000e\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020\u0000J\u0010\u0010K\u001a\u00020\u00102\u0006\u0010L\u001a\u00020MH\u0016J\u001c\u0010N\u001a\u00020\u00002\b\b\u0002\u0010O\u001a\u00020\t2\b\b\u0002\u0010P\u001a\u00020\tH\u0017J\b\u0010Q\u001a\u00020\u0000H\u0016J\b\u0010R\u001a\u00020\u0000H\u0016J\b\u0010S\u001a\u00020\u0004H\u0016J\b\u0010T\u001a\u00020\u0010H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010U\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020WH\u0016J%\u0010U\u001a\u00020\u001c2\u0006\u0010X\u001a\u00020Y2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010 \u001a\u00020\tH\u0010\u00a2\u0006\u0002\bZJ\u0010\u0010[\u001a\u00020\u001c2\u0006\u0010V\u001a\u00020\\H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\t8G\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006^"}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "data", "", "([B)V", "getData$okio", "()[B", "hashCode", "", "getHashCode$okio", "()I", "setHashCode$okio", "(I)V", "size", "utf8", "", "getUtf8$okio", "()Ljava/lang/String;", "setUtf8$okio", "(Ljava/lang/String;)V", "asByteBuffer", "Ljava/nio/ByteBuffer;", "base64", "base64Url", "compareTo", "other", "copyInto", "", "offset", "target", "targetOffset", "byteCount", PublicAccountMessageUtilImpl.ITEM_DIGEST_NAME, "algorithm", "digest$okio", "endsWith", "", "suffix", "equals", "", "get", "", "index", "getByte", "-deprecated_getByte", "getSize", "getSize$okio", "hex", "hmac", "key", "hmac$okio", "hmacSha1", "hmacSha256", "hmacSha512", "indexOf", "fromIndex", "internalArray", "internalArray$okio", "internalGet", com.tencent.luggage.wxa.c8.c.G, "internalGet$okio", "lastIndexOf", "md5", "rangeEquals", "otherOffset", "readObject", "in", "Ljava/io/ObjectInputStream;", "sha1", "sha256", "sha512", "-deprecated_size", "startsWith", "prefix", HippyControllerProps.STRING, HttpMsg.CHARSET, "Ljava/nio/charset/Charset;", "substring", "beginIndex", "endIndex", "toAsciiLowercase", "toAsciiUppercase", "toByteArray", "toString", com.tencent.mobileqq.msf.core.auth.k.f247492f, "out", "Ljava/io/OutputStream;", "buffer", "Lokio/Buffer;", "write$okio", "writeObject", "Ljava/io/ObjectOutputStream;", "Companion", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes29.dex */
public class ByteString implements Serializable, Comparable<ByteString> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @JvmField
    @NotNull
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;

    @NotNull
    private final byte[] data;
    private transient int hashCode;

    @Nullable
    private transient String utf8;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\nJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u00a2\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0007\u00a2\u0006\u0002\b\u0016J\u0014\u0010\u0013\u001a\u00020\u00042\n\u0010\u0017\u001a\u00020\u0018\"\u00020\u0019H\u0007J%\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007\u00a2\u0006\u0002\b\u0016J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007\u00a2\u0006\u0002\b!J\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u00020\tH\u0007J\f\u0010\u000b\u001a\u00020\u0004*\u00020\tH\u0007J\u001b\u0010\"\u001a\u00020\u0004*\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007\u00a2\u0006\u0002\b\rJ\f\u0010\u0011\u001a\u00020\u0004*\u00020\tH\u0007J\u0019\u0010#\u001a\u00020\u0004*\u00020 2\u0006\u0010\u001d\u001a\u00020\u001cH\u0007\u00a2\u0006\u0002\b\u001eJ\u0011\u0010$\u001a\u00020\u0004*\u00020\u0015H\u0007\u00a2\u0006\u0002\b\u0013J%\u0010$\u001a\u00020\u0004*\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0007\u00a2\u0006\u0002\b\u0013R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lokio/ByteString$Companion;", "", "()V", PatternUtils.NO_MATCH, "Lokio/ByteString;", "serialVersionUID", "", "decodeBase64", HippyControllerProps.STRING, "", "-deprecated_decodeBase64", "decodeHex", "-deprecated_decodeHex", "encodeString", HttpMsg.CHARSET, "Ljava/nio/charset/Charset;", "-deprecated_encodeString", "encodeUtf8", "-deprecated_encodeUtf8", "of", "buffer", "Ljava/nio/ByteBuffer;", "-deprecated_of", "data", "", "", HippyControllerProps.ARRAY, "offset", "", "byteCount", com.tencent.mobileqq.msf.core.auth.k.f247491e, "inputstream", "Ljava/io/InputStream;", "-deprecated_read", "encode", "readByteString", "toByteString", "okio"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes29.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ByteString encodeString$default(Companion companion, String str, Charset charset, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                charset = Charsets.UTF_8;
            }
            return companion.encodeString(str, charset);
        }

        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i3, int i16, int i17, Object obj) {
            if ((i17 & 1) != 0) {
                i3 = 0;
            }
            if ((i17 & 2) != 0) {
                i16 = bArr.length;
            }
            return companion.of(bArr, i3, i16);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeBase64()", imports = {"okio.ByteString.Companion.decodeBase64"}))
        @JvmName(name = "-deprecated_decodeBase64")
        @Nullable
        /* renamed from: -deprecated_decodeBase64, reason: not valid java name */
        public final ByteString m2200deprecated_decodeBase64(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return decodeBase64(string);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.decodeHex()", imports = {"okio.ByteString.Companion.decodeHex"}))
        @JvmName(name = "-deprecated_decodeHex")
        @NotNull
        /* renamed from: -deprecated_decodeHex, reason: not valid java name */
        public final ByteString m2201deprecated_decodeHex(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return decodeHex(string);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encode(charset)", imports = {"okio.ByteString.Companion.encode"}))
        @JvmName(name = "-deprecated_encodeString")
        @NotNull
        /* renamed from: -deprecated_encodeString, reason: not valid java name */
        public final ByteString m2202deprecated_encodeString(@NotNull String string, @NotNull Charset charset) {
            Intrinsics.checkNotNullParameter(string, "string");
            Intrinsics.checkNotNullParameter(charset, "charset");
            return encodeString(string, charset);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.encodeUtf8()", imports = {"okio.ByteString.Companion.encodeUtf8"}))
        @JvmName(name = "-deprecated_encodeUtf8")
        @NotNull
        /* renamed from: -deprecated_encodeUtf8, reason: not valid java name */
        public final ByteString m2203deprecated_encodeUtf8(@NotNull String string) {
            Intrinsics.checkNotNullParameter(string, "string");
            return encodeUtf8(string);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "buffer.toByteString()", imports = {"okio.ByteString.Companion.toByteString"}))
        @JvmName(name = "-deprecated_of")
        @NotNull
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m2204deprecated_of(@NotNull ByteBuffer buffer) {
            Intrinsics.checkNotNullParameter(buffer, "buffer");
            return of(buffer);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "inputstream.readByteString(byteCount)", imports = {"okio.ByteString.Companion.readByteString"}))
        @JvmName(name = "-deprecated_read")
        @NotNull
        /* renamed from: -deprecated_read, reason: not valid java name */
        public final ByteString m2206deprecated_read(@NotNull InputStream inputstream, int byteCount) {
            Intrinsics.checkNotNullParameter(inputstream, "inputstream");
            return read(inputstream, byteCount);
        }

        @JvmStatic
        @Nullable
        public final ByteString decodeBase64(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            byte[] decodeBase64ToArray = _Base64Kt.decodeBase64ToArray(str);
            if (decodeBase64ToArray != null) {
                return new ByteString(decodeBase64ToArray);
            }
            return null;
        }

        @JvmStatic
        @NotNull
        public final ByteString decodeHex(@NotNull String str) {
            boolean z16;
            Intrinsics.checkNotNullParameter(str, "<this>");
            int i3 = 0;
            if (str.length() % 2 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                int i16 = length - 1;
                if (i16 >= 0) {
                    while (true) {
                        int i17 = i3 + 1;
                        int i18 = i3 * 2;
                        bArr[i3] = (byte) ((_ByteStringKt.access$decodeHexDigit(str.charAt(i18)) << 4) + _ByteStringKt.access$decodeHexDigit(str.charAt(i18 + 1)));
                        if (i17 > i16) {
                            break;
                        }
                        i3 = i17;
                    }
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected hex string: ", str).toString());
        }

        @JvmStatic
        @JvmName(name = "encodeString")
        @NotNull
        public final ByteString encodeString(@NotNull String str, @NotNull Charset charset) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            Intrinsics.checkNotNullParameter(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        @JvmStatic
        @NotNull
        public final ByteString encodeUtf8(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
            byteString.setUtf8$okio(str);
            return byteString;
        }

        @JvmStatic
        @JvmName(name = "of")
        @NotNull
        public final ByteString of(@NotNull ByteBuffer byteBuffer) {
            Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }

        @JvmStatic
        @JvmName(name = com.tencent.mobileqq.msf.core.auth.k.f247491e)
        @NotNull
        public final ByteString read(@NotNull InputStream inputStream, int i3) throws IOException {
            boolean z16;
            Intrinsics.checkNotNullParameter(inputStream, "<this>");
            int i16 = 0;
            if (i3 >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                byte[] bArr = new byte[i3];
                while (i16 < i3) {
                    int read = inputStream.read(bArr, i16, i3 - i16);
                    if (read != -1) {
                        i16 += read;
                    } else {
                        throw new EOFException();
                    }
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Integer.valueOf(i3)).toString());
        }

        Companion() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "array.toByteString(offset, byteCount)", imports = {"okio.ByteString.Companion.toByteString"}))
        @JvmName(name = "-deprecated_of")
        @NotNull
        /* renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m2205deprecated_of(@NotNull byte[] array, int offset, int byteCount) {
            Intrinsics.checkNotNullParameter(array, "array");
            return of(array, offset, byteCount);
        }

        @JvmStatic
        @NotNull
        public final ByteString of(@NotNull byte... data) {
            Intrinsics.checkNotNullParameter(data, "data");
            byte[] copyOf = Arrays.copyOf(data, data.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
            return new ByteString(copyOf);
        }

        @JvmStatic
        @JvmName(name = "of")
        @NotNull
        public final ByteString of(@NotNull byte[] bArr, int i3, int i16) {
            byte[] copyOfRange;
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            _UtilKt.checkOffsetAndCount(bArr.length, i3, i16);
            copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(bArr, i3, i16 + i3);
            return new ByteString(copyOfRange);
        }
    }

    public ByteString(@NotNull byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    public static /* synthetic */ void copyInto$default(ByteString byteString, int i3, byte[] bArr, int i16, int i17, int i18, Object obj) {
        if (obj == null) {
            if ((i18 & 1) != 0) {
                i3 = 0;
            }
            if ((i18 & 4) != 0) {
                i16 = 0;
            }
            byteString.copyInto(i3, bArr, i16, i17);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyInto");
    }

    @JvmStatic
    @Nullable
    public static final ByteString decodeBase64(@NotNull String str) {
        return INSTANCE.decodeBase64(str);
    }

    @JvmStatic
    @NotNull
    public static final ByteString decodeHex(@NotNull String str) {
        return INSTANCE.decodeHex(str);
    }

    @JvmStatic
    @JvmName(name = "encodeString")
    @NotNull
    public static final ByteString encodeString(@NotNull String str, @NotNull Charset charset) {
        return INSTANCE.encodeString(str, charset);
    }

    @JvmStatic
    @NotNull
    public static final ByteString encodeUtf8(@NotNull String str) {
        return INSTANCE.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i3, int i16, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        return byteString.indexOf(byteString2, i3);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i3, int i16, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i16 & 2) != 0) {
            i3 = _UtilKt.getDEFAULT__ByteString_size();
        }
        return byteString.lastIndexOf(byteString2, i3);
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    public static final ByteString of(@NotNull ByteBuffer byteBuffer) {
        return INSTANCE.of(byteBuffer);
    }

    @JvmStatic
    @JvmName(name = com.tencent.mobileqq.msf.core.auth.k.f247491e)
    @NotNull
    public static final ByteString read(@NotNull InputStream inputStream, int i3) throws IOException {
        return INSTANCE.read(inputStream, i3);
    }

    private final void readObject(ObjectInputStream in5) throws IOException {
        ByteString read = INSTANCE.read(in5, in5.readInt());
        Field declaredField = ByteString.class.getDeclaredField("data");
        declaredField.setAccessible(true);
        declaredField.set(this, read.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i3, int i16, int i17, Object obj) {
        if (obj == null) {
            if ((i17 & 1) != 0) {
                i3 = 0;
            }
            if ((i17 & 2) != 0) {
                i16 = _UtilKt.getDEFAULT__ByteString_size();
            }
            return byteString.substring(i3, i16);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    private final void writeObject(ObjectOutputStream out) throws IOException {
        out.writeInt(this.data.length);
        out.write(this.data);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @ReplaceWith(expression = "this[index]", imports = {}))
    @JvmName(name = "-deprecated_getByte")
    /* renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m2198deprecated_getByte(int index) {
        return getByte(index);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))
    @JvmName(name = "-deprecated_size")
    /* renamed from: -deprecated_size, reason: not valid java name */
    public final int m2199deprecated_size() {
        return size();
    }

    @NotNull
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(asReadOnlyBuffer, "wrap(data).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @NotNull
    public String base64() {
        return _Base64Kt.encodeBase64$default(getData(), null, 1, null);
    }

    @NotNull
    public String base64Url() {
        return _Base64Kt.encodeBase64(getData(), _Base64Kt.getBASE64_URL_SAFE());
    }

    public void copyInto(int offset, @NotNull byte[] target, int targetOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(target, "target");
        ArraysKt___ArraysJvmKt.copyInto(getData(), target, targetOffset, offset, byteCount + offset);
    }

    @NotNull
    public ByteString digest$okio(@NotNull String algorithm) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(getData(), 0, size());
        byte[] digestBytes = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digestBytes, "digestBytes");
        return new ByteString(digestBytes);
    }

    public final boolean endsWith(@NotNull ByteString suffix) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return rangeEquals(size() - suffix.size(), suffix, 0, suffix.size());
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ByteString) {
            ByteString byteString = (ByteString) other;
            if (byteString.size() == getData().length && byteString.rangeEquals(0, getData(), 0, getData().length)) {
                return true;
            }
        }
        return false;
    }

    @JvmName(name = "getByte")
    public final byte getByte(int index) {
        return internalGet$okio(index);
    }

    @NotNull
    /* renamed from: getData$okio, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* renamed from: getHashCode$okio, reason: from getter */
    public final int getHashCode() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData().length;
    }

    @Nullable
    /* renamed from: getUtf8$okio, reason: from getter */
    public final String getUtf8() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode = getHashCode();
        if (hashCode == 0) {
            int hashCode2 = Arrays.hashCode(getData());
            setHashCode$okio(hashCode2);
            return hashCode2;
        }
        return hashCode;
    }

    @NotNull
    public String hex() {
        String concatToString;
        char[] cArr = new char[getData().length * 2];
        byte[] data = getData();
        int length = data.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length) {
            byte b16 = data[i3];
            i3++;
            int i17 = i16 + 1;
            cArr[i16] = _ByteStringKt.getHEX_DIGIT_CHARS()[(b16 >> 4) & 15];
            i16 = i17 + 1;
            cArr[i17] = _ByteStringKt.getHEX_DIGIT_CHARS()[b16 & RegisterType.DOUBLE_HI];
        }
        concatToString = StringsKt__StringsJVMKt.concatToString(cArr);
        return concatToString;
    }

    @NotNull
    public ByteString hmac$okio(@NotNull String algorithm, @NotNull ByteString key) {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            byte[] doFinal = mac.doFinal(this.data);
            Intrinsics.checkNotNullExpressionValue(doFinal, "mac.doFinal(data)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e16) {
            throw new IllegalArgumentException(e16);
        }
    }

    @NotNull
    public ByteString hmacSha1(@NotNull ByteString key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return hmac$okio(KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA1, key);
    }

    @NotNull
    public ByteString hmacSha256(@NotNull ByteString key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return hmac$okio(KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA256, key);
    }

    @NotNull
    public ByteString hmacSha512(@NotNull ByteString key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return hmac$okio(KeyPropertiesCompact.KEY_ALGORITHM_HMAC_SHA512, key);
    }

    @JvmOverloads
    public final int indexOf(@NotNull ByteString other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return indexOf$default(this, other, 0, 2, (Object) null);
    }

    @NotNull
    public byte[] internalArray$okio() {
        return getData();
    }

    public byte internalGet$okio(int pos) {
        return getData()[pos];
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull ByteString other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return lastIndexOf$default(this, other, 0, 2, (Object) null);
    }

    @NotNull
    public final ByteString md5() {
        return digest$okio(KeyPropertiesCompact.DIGEST_MD5);
    }

    public boolean rangeEquals(int offset, @NotNull ByteString other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        return other.rangeEquals(otherOffset, getData(), offset, byteCount);
    }

    public final void setHashCode$okio(int i3) {
        this.hashCode = i3;
    }

    public final void setUtf8$okio(@Nullable String str) {
        this.utf8 = str;
    }

    @NotNull
    public final ByteString sha1() {
        return digest$okio(KeyPropertiesCompact.DIGEST_SHA1);
    }

    @NotNull
    public final ByteString sha256() {
        return digest$okio(KeyPropertiesCompact.DIGEST_SHA256);
    }

    @NotNull
    public final ByteString sha512() {
        return digest$okio(KeyPropertiesCompact.DIGEST_SHA512);
    }

    @JvmName(name = "size")
    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(@NotNull ByteString prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.size());
    }

    @NotNull
    public String string(@NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new String(this.data, charset);
    }

    @JvmOverloads
    @NotNull
    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    @NotNull
    public ByteString toAsciiLowercase() {
        byte b16;
        for (int i3 = 0; i3 < getData().length; i3++) {
            byte b17 = getData()[i3];
            byte b18 = (byte) 65;
            if (b17 >= b18 && b17 <= (b16 = (byte) 90)) {
                byte[] data = getData();
                byte[] copyOf = Arrays.copyOf(data, data.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i3] = (byte) (b17 + 32);
                for (int i16 = i3 + 1; i16 < copyOf.length; i16++) {
                    byte b19 = copyOf[i16];
                    if (b19 >= b18 && b19 <= b16) {
                        copyOf[i16] = (byte) (b19 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    @NotNull
    public ByteString toAsciiUppercase() {
        byte b16;
        for (int i3 = 0; i3 < getData().length; i3++) {
            byte b17 = getData()[i3];
            byte b18 = (byte) 97;
            if (b17 >= b18 && b17 <= (b16 = (byte) 122)) {
                byte[] data = getData();
                byte[] copyOf = Arrays.copyOf(data, data.length);
                Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i3] = (byte) (b17 - 32);
                for (int i16 = i3 + 1; i16 < copyOf.length; i16++) {
                    byte b19 = copyOf[i16];
                    if (b19 >= b18 && b19 <= b16) {
                        copyOf[i16] = (byte) (b19 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    @NotNull
    public byte[] toByteArray() {
        byte[] data = getData();
        byte[] copyOf = Arrays.copyOf(data, data.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public String toString() {
        boolean z16;
        String replace$default;
        String replace$default2;
        String replace$default3;
        boolean z17;
        ByteString byteString;
        byte[] copyOfRange;
        String str;
        boolean z18 = true;
        if (getData().length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "[size=0]";
        } else {
            int access$codePointIndexToCharIndex = _ByteStringKt.access$codePointIndexToCharIndex(getData(), 64);
            if (access$codePointIndexToCharIndex == -1) {
                if (getData().length <= 64) {
                    str = "[hex=" + hex() + ']';
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[size=");
                    sb5.append(getData().length);
                    sb5.append(" hex=");
                    int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(this, 64);
                    if (resolveDefaultParameter <= getData().length) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        if (resolveDefaultParameter + 0 < 0) {
                            z18 = false;
                        }
                        if (z18) {
                            if (resolveDefaultParameter != getData().length) {
                                copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(getData(), 0, resolveDefaultParameter);
                                byteString = new ByteString(copyOfRange);
                            } else {
                                byteString = this;
                            }
                            sb5.append(byteString.hex());
                            sb5.append("\u2026]");
                            return sb5.toString();
                        }
                        throw new IllegalArgumentException("endIndex < beginIndex".toString());
                    }
                    throw new IllegalArgumentException(("endIndex > length(" + getData().length + ')').toString());
                }
            } else {
                String utf8 = utf8();
                if (utf8 != null) {
                    String substring = utf8.substring(0, access$codePointIndexToCharIndex);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    replace$default = StringsKt__StringsJVMKt.replace$default(substring, "\\", "\\\\", false, 4, (Object) null);
                    replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "\n", RedTouch.NEWLINE_CHAR, false, 4, (Object) null);
                    replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "\r", "\\r", false, 4, (Object) null);
                    if (access$codePointIndexToCharIndex < utf8.length()) {
                        return "[size=" + getData().length + " text=" + replace$default3 + "\u2026]";
                    }
                    return "[text=" + replace$default3 + ']';
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        return str;
    }

    @NotNull
    public String utf8() {
        String utf8 = getUtf8();
        if (utf8 == null) {
            String utf8String = _JvmPlatformKt.toUtf8String(internalArray$okio());
            setUtf8$okio(utf8String);
            return utf8String;
        }
        return utf8;
    }

    public void write(@NotNull OutputStream out) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        out.write(this.data);
    }

    public void write$okio(@NotNull Buffer buffer, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        _ByteStringKt.commonWrite(this, buffer, offset, byteCount);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i3, int i16, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i16 & 2) != 0) {
            i3 = 0;
        }
        return byteString.indexOf(bArr, i3);
    }

    @JvmStatic
    @NotNull
    public static final ByteString of(@NotNull byte... bArr) {
        return INSTANCE.of(bArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0034, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        if (r0 < r1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0029, code lost:
    
        if (r7 < r8) goto L13;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int compareTo(@NotNull ByteString other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int size = size();
        int size2 = other.size();
        int min = Math.min(size, size2);
        for (int i3 = 0; i3 < min; i3++) {
            int i16 = getByte(i3) & 255;
            int i17 = other.getByte(i3) & 255;
            if (i16 == i17) {
            }
        }
        if (size == size2) {
            return 0;
        }
    }

    public final boolean endsWith(@NotNull byte[] suffix) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return rangeEquals(size() - suffix.length, suffix, 0, suffix.length);
    }

    @JvmOverloads
    public final int indexOf(@NotNull byte[] other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return indexOf$default(this, other, 0, 2, (Object) null);
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull byte[] other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return lastIndexOf$default(this, other, 0, 2, (Object) null);
    }

    public boolean rangeEquals(int offset, @NotNull byte[] other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        return offset >= 0 && offset <= getData().length - byteCount && otherOffset >= 0 && otherOffset <= other.length - byteCount && _UtilKt.arrayRangeEquals(getData(), offset, other, otherOffset, byteCount);
    }

    public final boolean startsWith(@NotNull byte[] prefix) {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.length);
    }

    @JvmOverloads
    @NotNull
    public final ByteString substring(int i3) {
        return substring$default(this, i3, 0, 2, null);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i3, int i16, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i16 & 2) != 0) {
            i3 = _UtilKt.getDEFAULT__ByteString_size();
        }
        return byteString.lastIndexOf(bArr, i3);
    }

    @JvmStatic
    @JvmName(name = "of")
    @NotNull
    public static final ByteString of(@NotNull byte[] bArr, int i3, int i16) {
        return INSTANCE.of(bArr, i3, i16);
    }

    @JvmOverloads
    public final int indexOf(@NotNull ByteString other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        return indexOf(other.internalArray$okio(), fromIndex);
    }

    @JvmOverloads
    public final int lastIndexOf(@NotNull ByteString other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        return lastIndexOf(other.internalArray$okio(), fromIndex);
    }

    @JvmOverloads
    @NotNull
    public ByteString substring(int beginIndex, int endIndex) {
        byte[] copyOfRange;
        int resolveDefaultParameter = _UtilKt.resolveDefaultParameter(this, endIndex);
        if (beginIndex >= 0) {
            if (!(resolveDefaultParameter <= getData().length)) {
                throw new IllegalArgumentException(("endIndex > length(" + getData().length + ')').toString());
            }
            if (resolveDefaultParameter - beginIndex >= 0) {
                if (beginIndex == 0 && resolveDefaultParameter == getData().length) {
                    return this;
                }
                copyOfRange = ArraysKt___ArraysJvmKt.copyOfRange(getData(), beginIndex, resolveDefaultParameter);
                return new ByteString(copyOfRange);
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException("beginIndex < 0".toString());
    }

    @JvmOverloads
    public int indexOf(@NotNull byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        int length = getData().length - other.length;
        int max = Math.max(fromIndex, 0);
        if (max <= length) {
            while (true) {
                int i3 = max + 1;
                if (_UtilKt.arrayRangeEquals(getData(), max, other, 0, other.length)) {
                    return max;
                }
                if (max == length) {
                    break;
                }
                max = i3;
            }
        }
        return -1;
    }

    @JvmOverloads
    public int lastIndexOf(@NotNull byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        int min = Math.min(_UtilKt.resolveDefaultParameter(this, fromIndex), getData().length - other.length);
        if (min >= 0) {
            while (true) {
                int i3 = min - 1;
                if (_UtilKt.arrayRangeEquals(getData(), min, other, 0, other.length)) {
                    return min;
                }
                if (i3 < 0) {
                    break;
                }
                min = i3;
            }
        }
        return -1;
    }
}
