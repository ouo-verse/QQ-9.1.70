package okhttp3.internal;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.videocodec.ffmpeg.Argument;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okhttp3.internal.io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Sink;
import okio.Source;
import org.apache.http.cookie.ClientCookie;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00b8\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u001a\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0017\u001a'\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0!\"\u00020\"\u00a2\u0006\u0002\u0010#\u001a\u001a\u0010$\u001a\u00020\u001b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0&H\u0086\b\u00f8\u0001\u0000\u001a-\u0010'\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b\u0000\u0010)2\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u0002H)0!\"\u0002H)H\u0007\u00a2\u0006\u0002\u0010+\u001a \u0010'\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b\u0000\u0010)2\f\u0010,\u001a\b\u0012\u0004\u0012\u0002H)0(\u001a-\u0010-\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b\u0000\u0010)2\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u0002H)0!\"\u0002H)H\u0007\u00a2\u0006\u0002\u0010+\u001a\u000e\u0010.\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0011\u001a1\u0010/\u001a\u0004\u0018\u0001H)\"\u0004\b\u0000\u0010)2\u0006\u00100\u001a\u00020\"2\f\u00101\u001a\b\u0012\u0004\u0012\u0002H)022\u0006\u00103\u001a\u00020\u0011\u00a2\u0006\u0002\u00104\u001a\u0016\u00105\u001a\u0002062\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u00107\u001a\u00020\u000f\u001a\"\u00108\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00112\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0&H\u0086\b\u00f8\u0001\u0000\u001a%\u00109\u001a\u00020\u001b\"\u0004\b\u0000\u0010:*\b\u0012\u0004\u0012\u0002H:0;2\u0006\u0010<\u001a\u0002H:H\u0000\u00a2\u0006\u0002\u0010=\u001a\u0015\u0010>\u001a\u00020\u0014*\u00020?2\u0006\u0010@\u001a\u00020\u0014H\u0086\u0004\u001a\u0015\u0010>\u001a\u00020\u0017*\u00020\u00142\u0006\u0010@\u001a\u00020\u0017H\u0086\u0004\u001a\u0015\u0010>\u001a\u00020\u0014*\u00020A2\u0006\u0010@\u001a\u00020\u0014H\u0086\u0004\u001a\n\u0010B\u001a\u00020C*\u00020D\u001a\r\u0010E\u001a\u00020\u001b*\u00020\"H\u0080\b\u001a\r\u0010F\u001a\u00020\u001b*\u00020\"H\u0080\b\u001a\n\u0010G\u001a\u00020\u000f*\u00020\u0011\u001a\u0012\u0010H\u001a\u00020\u000f*\u00020I2\u0006\u0010J\u001a\u00020I\u001a\n\u0010K\u001a\u00020\u001b*\u00020L\u001a\n\u0010K\u001a\u00020\u001b*\u00020M\u001a\n\u0010K\u001a\u00020\u001b*\u00020N\u001a#\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00110!*\b\u0012\u0004\u0012\u00020\u00110!2\u0006\u0010P\u001a\u00020\u0011\u00a2\u0006\u0002\u0010Q\u001a&\u0010R\u001a\u00020\u0014*\u00020\u00112\u0006\u0010S\u001a\u00020T2\b\b\u0002\u0010U\u001a\u00020\u00142\b\b\u0002\u0010V\u001a\u00020\u0014\u001a&\u0010R\u001a\u00020\u0014*\u00020\u00112\u0006\u0010W\u001a\u00020\u00112\b\b\u0002\u0010U\u001a\u00020\u00142\b\b\u0002\u0010V\u001a\u00020\u0014\u001a\u001a\u0010X\u001a\u00020\u000f*\u00020Y2\u0006\u0010Z\u001a\u00020\u00142\u0006\u0010[\u001a\u00020\u0019\u001a;\u0010\\\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b\u0000\u0010)*\b\u0012\u0004\u0012\u0002H)0]2\u0017\u0010^\u001a\u0013\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u00020\u000f0_\u00a2\u0006\u0002\b`H\u0086\b\u00f8\u0001\u0000\u001a5\u0010a\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00110!2\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010!2\u000e\u0010b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00110c\u00a2\u0006\u0002\u0010d\u001a\n\u0010e\u001a\u00020\u0017*\u00020f\u001a+\u0010g\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00110!2\u0006\u0010P\u001a\u00020\u00112\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00110c\u00a2\u0006\u0002\u0010h\u001a\n\u0010i\u001a\u00020\u0014*\u00020\u0011\u001a\u001e\u0010j\u001a\u00020\u0014*\u00020\u00112\b\b\u0002\u0010U\u001a\u00020\u00142\b\b\u0002\u0010V\u001a\u00020\u0014\u001a\u001e\u0010k\u001a\u00020\u0014*\u00020\u00112\b\b\u0002\u0010U\u001a\u00020\u00142\b\b\u0002\u0010V\u001a\u00020\u0014\u001a\u0014\u0010l\u001a\u00020\u0014*\u00020\u00112\b\b\u0002\u0010U\u001a\u00020\u0014\u001a9\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00110!*\b\u0012\u0004\u0012\u00020\u00110!2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00110!2\u000e\u0010b\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00110c\u00a2\u0006\u0002\u0010n\u001a\u0012\u0010o\u001a\u00020\u000f*\u00020p2\u0006\u0010q\u001a\u00020r\u001a\u0012\u0010s\u001a\u00020\u000f*\u00020N2\u0006\u0010t\u001a\u00020u\u001a\r\u0010v\u001a\u00020\u001b*\u00020\"H\u0086\b\u001a\r\u0010w\u001a\u00020\u001b*\u00020\"H\u0086\b\u001a\n\u0010x\u001a\u00020\u0014*\u00020T\u001a\n\u0010y\u001a\u00020\u0011*\u00020N\u001a\u0012\u0010z\u001a\u00020{*\u00020u2\u0006\u0010|\u001a\u00020{\u001a\n\u0010}\u001a\u00020\u0014*\u00020u\u001a\u0013\u0010~\u001a\u00020\u0014*\u00020\u007f2\u0007\u0010\u0080\u0001\u001a\u00020?\u001a\u001a\u0010~\u001a\u00020\u000f*\u00020Y2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010[\u001a\u00020\u0019\u001a\u0012\u0010\u0081\u0001\u001a\t\u0012\u0005\u0012\u00030\u0082\u00010(*\u00020\u0003\u001a\u0012\u0010\u0083\u0001\u001a\u00020\u0003*\t\u0012\u0005\u0012\u00030\u0082\u00010(\u001a\u000b\u0010\u0084\u0001\u001a\u00020\u0011*\u00020\u0014\u001a\u000b\u0010\u0084\u0001\u001a\u00020\u0011*\u00020\u0017\u001a\u0016\u0010\u0085\u0001\u001a\u00020\u0011*\u00020I2\t\b\u0002\u0010\u0086\u0001\u001a\u00020\u000f\u001a\u001d\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b\u0000\u0010)*\b\u0012\u0004\u0012\u0002H)0(\u001a7\u0010\u0088\u0001\u001a\u0011\u0012\u0005\u0012\u0003H\u008a\u0001\u0012\u0005\u0012\u0003H\u008b\u00010\u0089\u0001\"\u0005\b\u0000\u0010\u008a\u0001\"\u0005\b\u0001\u0010\u008b\u0001*\u0011\u0012\u0005\u0012\u0003H\u008a\u0001\u0012\u0005\u0012\u0003H\u008b\u00010\u0089\u0001\u001a\u0014\u0010\u008c\u0001\u001a\u00020\u0017*\u00020\u00112\u0007\u0010\u008d\u0001\u001a\u00020\u0017\u001a\u0016\u0010\u008e\u0001\u001a\u00020\u0014*\u0004\u0018\u00010\u00112\u0007\u0010\u008d\u0001\u001a\u00020\u0014\u001a\u001f\u0010\u008f\u0001\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010U\u001a\u00020\u00142\b\b\u0002\u0010V\u001a\u00020\u0014\u001a\u000e\u0010\u0090\u0001\u001a\u00020\u001b*\u00020\"H\u0086\b\u001a'\u0010\u0091\u0001\u001a\u00030\u0092\u0001*\b0\u0093\u0001j\u0003`\u0094\u00012\u0013\u0010\u0095\u0001\u001a\u000e\u0012\n\u0012\b0\u0093\u0001j\u0003`\u0094\u00010(\u001a\u0015\u0010\u0096\u0001\u001a\u00020\u001b*\u00030\u0097\u00012\u0007\u0010\u0098\u0001\u001a\u00020\u0014\"\u0010\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u000e\u001a\u00020\u000f8\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0010\u001a\u00020\u00118\u0000X\u0081\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0011X\u0086T\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0099\u0001"}, d2 = {"EMPTY_BYTE_ARRAY", "", "EMPTY_HEADERS", "Lokhttp3/Headers;", "EMPTY_REQUEST", "Lokhttp3/RequestBody;", "EMPTY_RESPONSE", "Lokhttp3/ResponseBody;", "UNICODE_BOMS", "Lokio/Options;", "UTC", "Ljava/util/TimeZone;", "VERIFY_AS_IP_ADDRESS", "Lkotlin/text/Regex;", "assertionsEnabled", "", "okHttpName", "", "userAgent", "checkDuration", "", "name", "duration", "", "unit", "Ljava/util/concurrent/TimeUnit;", "checkOffsetAndCount", "", "arrayLength", "offset", "count", "format", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "ignoreIoExceptions", "block", "Lkotlin/Function0;", "immutableList", "", "T", DTParamKey.REPORT_KEY_VISUAL_ELEMENTS, "([Ljava/lang/Object;)Ljava/util/List;", "list", "immutableListOf", "isSensitiveHeader", "readFieldOrNull", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "fieldType", "Ljava/lang/Class;", "fieldName", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "daemon", "threadName", "addIfAbsent", "E", "", DTConstants.TAG.ELEMENT, "(Ljava/util/List;Ljava/lang/Object;)V", "and", "", "mask", "", "asFactory", "Lokhttp3/EventListener$Factory;", "Lokhttp3/EventListener;", "assertThreadDoesntHoldLock", "assertThreadHoldsLock", "canParseAsIpAddress", "canReuseConnectionFor", "Lokhttp3/HttpUrl;", "other", "closeQuietly", "Ljava/io/Closeable;", "Ljava/net/ServerSocket;", "Ljava/net/Socket;", Argument.CONCAT, "value", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "delimiterOffset", "delimiter", "", "startIndex", "endIndex", "delimiters", ClientCookie.DISCARD_ATTR, "Lokio/Source;", "timeout", "timeUnit", "filterList", "", "predicate", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "hasIntersection", "comparator", "Ljava/util/Comparator;", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "headersContentLength", "Lokhttp3/Response;", "indexOf", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "indexOfControlOrNonAscii", "indexOfFirstNonAsciiWhitespace", "indexOfLastNonAsciiWhitespace", "indexOfNonWhitespace", "intersect", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "isCivilized", "Lokhttp3/internal/io/FileSystem;", "file", "Ljava/io/File;", "isHealthy", "source", "Lokio/BufferedSource;", "notify", "notifyAll", "parseHexDigit", "peerName", "readBomAsCharset", "Ljava/nio/charset/Charset;", "default", "readMedium", "skipAll", "Lokio/Buffer;", "b", "toHeaderList", "Lokhttp3/internal/http2/Header;", "toHeaders", "toHexString", "toHostHeader", "includeDefaultPort", "toImmutableList", "toImmutableMap", "", "K", "V", "toLongOrDefault", RemoteHandleConst.PARAM_DEFAULT_VALUE, "toNonNegativeInt", "trimSubstring", "wait", "withSuppressed", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "suppressed", "writeMedium", "Lokio/BufferedSink;", "medium", "okhttp"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Util")
/* loaded from: classes28.dex */
public final class Util {

    @JvmField
    @NotNull
    public static final byte[] EMPTY_BYTE_ARRAY;

    @JvmField
    @NotNull
    public static final Headers EMPTY_HEADERS = Headers.INSTANCE.of(new String[0]);

    @JvmField
    @NotNull
    public static final RequestBody EMPTY_REQUEST;

    @JvmField
    @NotNull
    public static final ResponseBody EMPTY_RESPONSE;
    private static final Options UNICODE_BOMS;

    @JvmField
    @NotNull
    public static final TimeZone UTC;
    private static final Regex VERIFY_AS_IP_ADDRESS;

    @JvmField
    public static final boolean assertionsEnabled;

    @JvmField
    @NotNull
    public static final String okHttpName;

    @NotNull
    public static final String userAgent = "okhttp/4.11.0-SNAPSHOT";

    static {
        String removePrefix;
        String removeSuffix;
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.INSTANCE, bArr, (MediaType) null, 1, (Object) null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.INSTANCE, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        Options.Companion companion = Options.INSTANCE;
        ByteString.Companion companion2 = ByteString.INSTANCE;
        UNICODE_BOMS = companion.of(companion2.decodeHex("efbbbf"), companion2.decodeHex("feff"), companion2.decodeHex("fffe"), companion2.decodeHex("0000ffff"), companion2.decodeHex("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Intrinsics.checkNotNull(timeZone);
        UTC = timeZone;
        VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        assertionsEnabled = false;
        String name = OkHttpClient.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "OkHttpClient::class.java.name");
        removePrefix = StringsKt__StringsKt.removePrefix(name, (CharSequence) "okhttp3.");
        removeSuffix = StringsKt__StringsKt.removeSuffix(removePrefix, (CharSequence) "Client");
        okHttpName = removeSuffix;
    }

    public static final <E> void addIfAbsent(@NotNull List<E> addIfAbsent, E e16) {
        Intrinsics.checkNotNullParameter(addIfAbsent, "$this$addIfAbsent");
        if (!addIfAbsent.contains(e16)) {
            addIfAbsent.add(e16);
        }
    }

    public static final int and(byte b16, int i3) {
        return b16 & i3;
    }

    @NotNull
    public static final EventListener.Factory asFactory(@NotNull final EventListener asFactory) {
        Intrinsics.checkNotNullParameter(asFactory, "$this$asFactory");
        return new EventListener.Factory() { // from class: okhttp3.internal.Util$asFactory$1
            @Override // okhttp3.EventListener.Factory
            @NotNull
            public final EventListener create(@NotNull Call it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return EventListener.this;
            }
        };
    }

    public static final void assertThreadDoesntHoldLock(@NotNull Object assertThreadDoesntHoldLock) {
        Intrinsics.checkNotNullParameter(assertThreadDoesntHoldLock, "$this$assertThreadDoesntHoldLock");
        if (assertionsEnabled && Thread.holdsLock(assertThreadDoesntHoldLock)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            sb5.append(currentThread.getName());
            sb5.append(" MUST NOT hold lock on ");
            sb5.append(assertThreadDoesntHoldLock);
            throw new AssertionError(sb5.toString());
        }
    }

    public static final void assertThreadHoldsLock(@NotNull Object assertThreadHoldsLock) {
        Intrinsics.checkNotNullParameter(assertThreadHoldsLock, "$this$assertThreadHoldsLock");
        if (assertionsEnabled && !Thread.holdsLock(assertThreadHoldsLock)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Thread ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            sb5.append(currentThread.getName());
            sb5.append(" MUST hold lock on ");
            sb5.append(assertThreadHoldsLock);
            throw new AssertionError(sb5.toString());
        }
    }

    public static final boolean canParseAsIpAddress(@NotNull String canParseAsIpAddress) {
        Intrinsics.checkNotNullParameter(canParseAsIpAddress, "$this$canParseAsIpAddress");
        return VERIFY_AS_IP_ADDRESS.matches(canParseAsIpAddress);
    }

    public static final boolean canReuseConnectionFor(@NotNull HttpUrl canReuseConnectionFor, @NotNull HttpUrl other) {
        Intrinsics.checkNotNullParameter(canReuseConnectionFor, "$this$canReuseConnectionFor");
        Intrinsics.checkNotNullParameter(other, "other");
        if (Intrinsics.areEqual(canReuseConnectionFor.host(), other.host()) && canReuseConnectionFor.port() == other.port() && Intrinsics.areEqual(canReuseConnectionFor.scheme(), other.scheme())) {
            return true;
        }
        return false;
    }

    public static final int checkDuration(@NotNull String name, long j3, @Nullable TimeUnit timeUnit) {
        boolean z16;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(name, "name");
        boolean z19 = true;
        if (j3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (timeUnit != null) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                long millis = timeUnit.toMillis(j3);
                if (millis <= Integer.MAX_VALUE) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    if (millis == 0 && j3 > 0) {
                        z19 = false;
                    }
                    if (z19) {
                        return (int) millis;
                    }
                    throw new IllegalArgumentException((name + " too small.").toString());
                }
                throw new IllegalArgumentException((name + " too large.").toString());
            }
            throw new IllegalStateException("unit == null".toString());
        }
        throw new IllegalStateException((name + " < 0").toString());
    }

    public static final void checkOffsetAndCount(long j3, long j16, long j17) {
        if ((j16 | j17) >= 0 && j16 <= j3 && j3 - j16 >= j17) {
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void closeQuietly(@NotNull Closeable closeQuietly) {
        Intrinsics.checkNotNullParameter(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (RuntimeException e16) {
            throw e16;
        } catch (Exception unused) {
        }
    }

    @NotNull
    public static final String[] concat(@NotNull String[] concat, @NotNull String value) {
        int lastIndex;
        Intrinsics.checkNotNullParameter(concat, "$this$concat");
        Intrinsics.checkNotNullParameter(value, "value");
        Object[] copyOf = Arrays.copyOf(concat, concat.length + 1);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        String[] strArr = (String[]) copyOf;
        lastIndex = ArraysKt___ArraysKt.getLastIndex(strArr);
        strArr[lastIndex] = value;
        return strArr;
    }

    public static final int delimiterOffset(@NotNull String delimiterOffset, @NotNull String delimiters, int i3, int i16) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(delimiterOffset, "$this$delimiterOffset");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        while (i3 < i16) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) delimiters, delimiterOffset.charAt(i3), false, 2, (Object) null);
            if (contains$default) {
                return i3;
            }
            i3++;
        }
        return i16;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = 0;
        }
        if ((i17 & 4) != 0) {
            i16 = str.length();
        }
        return delimiterOffset(str, str2, i3, i16);
    }

    public static final boolean discard(@NotNull Source discard, int i3, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(discard, "$this$discard");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        try {
            return skipAll(discard, i3, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    @NotNull
    public static final <T> List<T> filterList(@NotNull Iterable<? extends T> filterList, @NotNull Function1<? super T, Boolean> predicate) {
        List<T> emptyList;
        Intrinsics.checkNotNullParameter(filterList, "$this$filterList");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        for (T t16 : filterList) {
            if (predicate.invoke(t16).booleanValue()) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                TypeIntrinsics.asMutableList(emptyList).add(t16);
            }
        }
        return emptyList;
    }

    @NotNull
    public static final String format(@NotNull String format, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, "args");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(args, args.length);
        String format2 = String.format(locale, format, Arrays.copyOf(copyOf, copyOf.length));
        Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(locale, format, *args)");
        return format2;
    }

    public static final boolean hasIntersection(@NotNull String[] hasIntersection, @Nullable String[] strArr, @NotNull Comparator<? super String> comparator) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(hasIntersection, "$this$hasIntersection");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (hasIntersection.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && strArr != null) {
            if (strArr.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                for (String str : hasIntersection) {
                    for (String str2 : strArr) {
                        if (comparator.compare(str, str2) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static final long headersContentLength(@NotNull Response headersContentLength) {
        Intrinsics.checkNotNullParameter(headersContentLength, "$this$headersContentLength");
        String str = headersContentLength.headers().get("Content-Length");
        if (str == null) {
            return -1L;
        }
        return toLongOrDefault(str, -1L);
    }

    public static final void ignoreIoExceptions(@NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            block.invoke();
        } catch (IOException unused) {
        }
    }

    @NotNull
    public static final <T> List<T> immutableList(@NotNull List<? extends T> list) {
        List mutableList;
        Intrinsics.checkNotNullParameter(list, "list");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        List<T> unmodifiableList = Collections.unmodifiableList(mutableList);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "Collections.unmodifiableList(list.toMutableList())");
        return unmodifiableList;
    }

    @SafeVarargs
    @NotNull
    public static final <T> List<T> immutableListOf(@NotNull T... elements) {
        List listOf;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        listOf = CollectionsKt__CollectionsKt.listOf(Arrays.copyOf(objArr, objArr.length));
        List<T> unmodifiableList = Collections.unmodifiableList(listOf);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "Collections.unmodifiable\u2026istOf(*elements.clone()))");
        return unmodifiableList;
    }

    public static final int indexOf(@NotNull String[] indexOf, @NotNull String value, @NotNull Comparator<String> comparator) {
        boolean z16;
        Intrinsics.checkNotNullParameter(indexOf, "$this$indexOf");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int length = indexOf.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (comparator.compare(indexOf[i3], value) == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return i3;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(@NotNull String indexOfControlOrNonAscii) {
        Intrinsics.checkNotNullParameter(indexOfControlOrNonAscii, "$this$indexOfControlOrNonAscii");
        int length = indexOfControlOrNonAscii.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = indexOfControlOrNonAscii.charAt(i3);
            if (Intrinsics.compare((int) charAt, 31) <= 0 || Intrinsics.compare((int) charAt, 127) >= 0) {
                return i3;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(@NotNull String indexOfFirstNonAsciiWhitespace, int i3, int i16) {
        Intrinsics.checkNotNullParameter(indexOfFirstNonAsciiWhitespace, "$this$indexOfFirstNonAsciiWhitespace");
        while (i3 < i16) {
            char charAt = indexOfFirstNonAsciiWhitespace.charAt(i3);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i3;
            }
            i3++;
        }
        return i16;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = 0;
        }
        if ((i17 & 2) != 0) {
            i16 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i3, i16);
    }

    public static final int indexOfLastNonAsciiWhitespace(@NotNull String indexOfLastNonAsciiWhitespace, int i3, int i16) {
        Intrinsics.checkNotNullParameter(indexOfLastNonAsciiWhitespace, "$this$indexOfLastNonAsciiWhitespace");
        int i17 = i16 - 1;
        if (i17 >= i3) {
            while (true) {
                char charAt = indexOfLastNonAsciiWhitespace.charAt(i17);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i17 + 1;
                }
                if (i17 == i3) {
                    break;
                }
                i17--;
            }
        }
        return i3;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = 0;
        }
        if ((i17 & 2) != 0) {
            i16 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i3, i16);
    }

    public static final int indexOfNonWhitespace(@NotNull String indexOfNonWhitespace, int i3) {
        Intrinsics.checkNotNullParameter(indexOfNonWhitespace, "$this$indexOfNonWhitespace");
        int length = indexOfNonWhitespace.length();
        while (i3 < length) {
            char charAt = indexOfNonWhitespace.charAt(i3);
            if (charAt != ' ' && charAt != '\t') {
                return i3;
            }
            i3++;
        }
        return indexOfNonWhitespace.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        return indexOfNonWhitespace(str, i3);
    }

    @NotNull
    public static final String[] intersect(@NotNull String[] intersect, @NotNull String[] other, @NotNull Comparator<? super String> comparator) {
        Intrinsics.checkNotNullParameter(intersect, "$this$intersect");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : intersect) {
            int length = other.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (comparator.compare(str, other[i3]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i3++;
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final boolean isCivilized(@NotNull FileSystem isCivilized, @NotNull File file) {
        Intrinsics.checkNotNullParameter(isCivilized, "$this$isCivilized");
        Intrinsics.checkNotNullParameter(file, "file");
        Sink sink = isCivilized.sink(file);
        try {
            try {
                isCivilized.delete(file);
                CloseableKt.closeFinally(sink, null);
                return true;
            } catch (IOException unused) {
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(sink, null);
                isCivilized.delete(file);
                return false;
            }
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                CloseableKt.closeFinally(sink, th5);
                throw th6;
            }
        }
    }

    public static final boolean isHealthy(@NotNull Socket isHealthy, @NotNull BufferedSource source) {
        Intrinsics.checkNotNullParameter(isHealthy, "$this$isHealthy");
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            int soTimeout = isHealthy.getSoTimeout();
            try {
                isHealthy.setSoTimeout(1);
                boolean z16 = !source.exhausted();
                isHealthy.setSoTimeout(soTimeout);
                return z16;
            } catch (Throwable th5) {
                isHealthy.setSoTimeout(soTimeout);
                throw th5;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final boolean isSensitiveHeader(@NotNull String name) {
        boolean equals;
        boolean equals2;
        boolean equals3;
        boolean equals4;
        Intrinsics.checkNotNullParameter(name, "name");
        equals = StringsKt__StringsJVMKt.equals(name, "Authorization", true);
        if (!equals) {
            equals2 = StringsKt__StringsJVMKt.equals(name, "Cookie", true);
            if (!equals2) {
                equals3 = StringsKt__StringsJVMKt.equals(name, "Proxy-Authorization", true);
                if (!equals3) {
                    equals4 = StringsKt__StringsJVMKt.equals(name, "Set-Cookie", true);
                    if (equals4) {
                        return true;
                    }
                    return false;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public static final void notify(@NotNull Object notify) {
        Intrinsics.checkNotNullParameter(notify, "$this$notify");
        notify.notify();
    }

    public static final void notifyAll(@NotNull Object notifyAll) {
        Intrinsics.checkNotNullParameter(notifyAll, "$this$notifyAll");
        notifyAll.notifyAll();
    }

    public static final int parseHexDigit(char c16) {
        if ('0' <= c16 && '9' >= c16) {
            return c16 - '0';
        }
        char c17 = 'a';
        if ('a' > c16 || 'f' < c16) {
            c17 = EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET;
            if ('A' > c16 || 'F' < c16) {
                return -1;
            }
        }
        return (c16 - c17) + 10;
    }

    @NotNull
    public static final String peerName(@NotNull Socket peerName) {
        Intrinsics.checkNotNullParameter(peerName, "$this$peerName");
        SocketAddress remoteSocketAddress = peerName.getRemoteSocketAddress();
        if (remoteSocketAddress instanceof InetSocketAddress) {
            String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
            Intrinsics.checkNotNullExpressionValue(hostName, "address.hostName");
            return hostName;
        }
        return remoteSocketAddress.toString();
    }

    @NotNull
    public static final Charset readBomAsCharset(@NotNull BufferedSource readBomAsCharset, @NotNull Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(readBomAsCharset, "$this$readBomAsCharset");
        Intrinsics.checkNotNullParameter(charset, "default");
        int select = readBomAsCharset.select(UNICODE_BOMS);
        if (select != -1) {
            if (select != 0) {
                if (select != 1) {
                    if (select != 2) {
                        if (select != 3) {
                            if (select == 4) {
                                return Charsets.INSTANCE.UTF32_LE();
                            }
                            throw new AssertionError();
                        }
                        return Charsets.INSTANCE.UTF32_BE();
                    }
                    Charset UTF_16LE = StandardCharsets.UTF_16LE;
                    Intrinsics.checkNotNullExpressionValue(UTF_16LE, "UTF_16LE");
                    return UTF_16LE;
                }
                Charset UTF_16BE = StandardCharsets.UTF_16BE;
                Intrinsics.checkNotNullExpressionValue(UTF_16BE, "UTF_16BE");
                return UTF_16BE;
            }
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
            return UTF_8;
        }
        return charset;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003d, code lost:
    
        return r4;
     */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> T readFieldOrNull(@NotNull Object instance, @NotNull Class<T> fieldType, @NotNull String fieldName) {
        Object readFieldOrNull;
        Intrinsics.checkNotNullParameter(instance, "instance");
        Intrinsics.checkNotNullParameter(fieldType, "fieldType");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Class<?> cls = instance.getClass();
        while (true) {
            T t16 = null;
            if (!Intrinsics.areEqual(cls, Object.class)) {
                try {
                    Field field = cls.getDeclaredField(fieldName);
                    Intrinsics.checkNotNullExpressionValue(field, "field");
                    field.setAccessible(true);
                    Object obj = field.get(instance);
                    if (!fieldType.isInstance(obj)) {
                        break;
                    }
                    t16 = fieldType.cast(obj);
                    break;
                } catch (NoSuchFieldException unused) {
                    cls = cls.getSuperclass();
                    Intrinsics.checkNotNullExpressionValue(cls, "c.superclass");
                }
            } else {
                if (!(!Intrinsics.areEqual(fieldName, "delegate")) || (readFieldOrNull = readFieldOrNull(instance, Object.class, "delegate")) == null) {
                    return null;
                }
                return (T) readFieldOrNull(readFieldOrNull, fieldType, fieldName);
            }
        }
    }

    public static final int readMedium(@NotNull BufferedSource readMedium) throws IOException {
        Intrinsics.checkNotNullParameter(readMedium, "$this$readMedium");
        return and(readMedium.readByte(), 255) | (and(readMedium.readByte(), 255) << 16) | (and(readMedium.readByte(), 255) << 8);
    }

    public static final boolean skipAll(@NotNull Source skipAll, int i3, @NotNull TimeUnit timeUnit) throws IOException {
        Intrinsics.checkNotNullParameter(skipAll, "$this$skipAll");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        long nanoTime = System.nanoTime();
        long deadlineNanoTime = skipAll.getTimeout().getHasDeadline() ? skipAll.getTimeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
        skipAll.getTimeout().deadlineNanoTime(Math.min(deadlineNanoTime, timeUnit.toNanos(i3)) + nanoTime);
        try {
            Buffer buffer = new Buffer();
            while (skipAll.read(buffer, 8192L) != -1) {
                buffer.clear();
            }
            if (deadlineNanoTime == Long.MAX_VALUE) {
                skipAll.getTimeout().clearDeadline();
            } else {
                skipAll.getTimeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (deadlineNanoTime == Long.MAX_VALUE) {
                skipAll.getTimeout().clearDeadline();
            } else {
                skipAll.getTimeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            return false;
        } catch (Throwable th5) {
            if (deadlineNanoTime == Long.MAX_VALUE) {
                skipAll.getTimeout().clearDeadline();
            } else {
                skipAll.getTimeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            throw th5;
        }
    }

    @NotNull
    public static final ThreadFactory threadFactory(@NotNull final String name, final boolean z16) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new ThreadFactory() { // from class: okhttp3.internal.Util$threadFactory$1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                BaseThread baseThread = new BaseThread(runnable, name);
                baseThread.setDaemon(z16);
                return baseThread;
            }
        };
    }

    public static final void threadName(@NotNull String name, @NotNull Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(block, "block");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "currentThread");
        String name2 = currentThread.getName();
        currentThread.setName(name);
        try {
            block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            currentThread.setName(name2);
            InlineMarker.finallyEnd(1);
        }
    }

    @NotNull
    public static final List<Header> toHeaderList(@NotNull Headers toHeaderList) {
        IntRange until;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(toHeaderList, "$this$toHeaderList");
        until = RangesKt___RangesKt.until(0, toHeaderList.size());
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(until, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            arrayList.add(new Header(toHeaderList.name(nextInt), toHeaderList.value(nextInt)));
        }
        return arrayList;
    }

    @NotNull
    public static final Headers toHeaders(@NotNull List<Header> toHeaders) {
        Intrinsics.checkNotNullParameter(toHeaders, "$this$toHeaders");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : toHeaders) {
            builder.addLenient$okhttp(header.getName().utf8(), header.getValue().utf8());
        }
        return builder.build();
    }

    @NotNull
    public static final String toHexString(long j3) {
        String hexString = Long.toHexString(j3);
        Intrinsics.checkNotNullExpressionValue(hexString, "java.lang.Long.toHexString(this)");
        return hexString;
    }

    @NotNull
    public static final String toHostHeader(@NotNull HttpUrl toHostHeader, boolean z16) {
        boolean contains$default;
        String host;
        Intrinsics.checkNotNullParameter(toHostHeader, "$this$toHostHeader");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) toHostHeader.host(), (CharSequence) ":", false, 2, (Object) null);
        if (contains$default) {
            host = '[' + toHostHeader.host() + ']';
        } else {
            host = toHostHeader.host();
        }
        if (z16 || toHostHeader.port() != HttpUrl.INSTANCE.defaultPort(toHostHeader.scheme())) {
            return host + ':' + toHostHeader.port();
        }
        return host;
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return toHostHeader(httpUrl, z16);
    }

    @NotNull
    public static final <T> List<T> toImmutableList(@NotNull List<? extends T> toImmutableList) {
        List mutableList;
        Intrinsics.checkNotNullParameter(toImmutableList, "$this$toImmutableList");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) toImmutableList);
        List<T> unmodifiableList = Collections.unmodifiableList(mutableList);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    @NotNull
    public static final <K, V> Map<K, V> toImmutableMap(@NotNull Map<K, ? extends V> toImmutableMap) {
        Map<K, V> emptyMap;
        Intrinsics.checkNotNullParameter(toImmutableMap, "$this$toImmutableMap");
        if (toImmutableMap.isEmpty()) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            return emptyMap;
        }
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(toImmutableMap));
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
        return unmodifiableMap;
    }

    public static final long toLongOrDefault(@NotNull String toLongOrDefault, long j3) {
        Intrinsics.checkNotNullParameter(toLongOrDefault, "$this$toLongOrDefault");
        try {
            return Long.parseLong(toLongOrDefault);
        } catch (NumberFormatException unused) {
            return j3;
        }
    }

    public static final int toNonNegativeInt(@Nullable String str, int i3) {
        if (str != null) {
            try {
                long parseLong = Long.parseLong(str);
                if (parseLong > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (parseLong < 0) {
                    return 0;
                }
                return (int) parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        return i3;
    }

    @NotNull
    public static final String trimSubstring(@NotNull String trimSubstring, int i3, int i16) {
        Intrinsics.checkNotNullParameter(trimSubstring, "$this$trimSubstring");
        int indexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(trimSubstring, i3, i16);
        String substring = trimSubstring.substring(indexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(trimSubstring, indexOfFirstNonAsciiWhitespace, i16));
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i3, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i3 = 0;
        }
        if ((i17 & 2) != 0) {
            i16 = str.length();
        }
        return trimSubstring(str, i3, i16);
    }

    public static final void wait(@NotNull Object wait) {
        Intrinsics.checkNotNullParameter(wait, "$this$wait");
        LockMethodProxy.wait(wait);
    }

    @NotNull
    public static final Throwable withSuppressed(@NotNull Exception withSuppressed, @NotNull List<? extends Exception> suppressed) {
        Intrinsics.checkNotNullParameter(withSuppressed, "$this$withSuppressed");
        Intrinsics.checkNotNullParameter(suppressed, "suppressed");
        if (suppressed.size() > 1) {
            System.out.println(suppressed);
        }
        Iterator<? extends Exception> it = suppressed.iterator();
        while (it.hasNext()) {
            ExceptionsKt__ExceptionsKt.addSuppressed(withSuppressed, it.next());
        }
        return withSuppressed;
    }

    public static final void writeMedium(@NotNull BufferedSink writeMedium, int i3) throws IOException {
        Intrinsics.checkNotNullParameter(writeMedium, "$this$writeMedium");
        writeMedium.writeByte((i3 >>> 16) & 255);
        writeMedium.writeByte((i3 >>> 8) & 255);
        writeMedium.writeByte(i3 & 255);
    }

    public static final int and(short s16, int i3) {
        return s16 & i3;
    }

    public static final int delimiterOffset(@NotNull String delimiterOffset, char c16, int i3, int i16) {
        Intrinsics.checkNotNullParameter(delimiterOffset, "$this$delimiterOffset");
        while (i3 < i16) {
            if (delimiterOffset.charAt(i3) == c16) {
                return i3;
            }
            i3++;
        }
        return i16;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c16, int i3, int i16, int i17, Object obj) {
        if ((i17 & 2) != 0) {
            i3 = 0;
        }
        if ((i17 & 4) != 0) {
            i16 = str.length();
        }
        return delimiterOffset(str, c16, i3, i16);
    }

    @SafeVarargs
    @NotNull
    public static final <T> List<T> immutableList(@NotNull T... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        List<T> unmodifiableList = Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(objArr, objArr.length)));
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "Collections.unmodifiable\u2026sList(*elements.clone()))");
        return unmodifiableList;
    }

    @NotNull
    public static final String toHexString(int i3) {
        String hexString = Integer.toHexString(i3);
        Intrinsics.checkNotNullExpressionValue(hexString, "Integer.toHexString(this)");
        return hexString;
    }

    public static final long and(int i3, long j3) {
        return i3 & j3;
    }

    public static final void closeQuietly(@NotNull Socket closeQuietly) {
        Intrinsics.checkNotNullParameter(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (AssertionError e16) {
            throw e16;
        } catch (RuntimeException e17) {
            if (!Intrinsics.areEqual(e17.getMessage(), "bio == null")) {
                throw e17;
            }
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(@NotNull ServerSocket closeQuietly) {
        Intrinsics.checkNotNullParameter(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (RuntimeException e16) {
            throw e16;
        } catch (Exception unused) {
        }
    }

    public static final int skipAll(@NotNull Buffer skipAll, byte b16) {
        Intrinsics.checkNotNullParameter(skipAll, "$this$skipAll");
        int i3 = 0;
        while (!skipAll.exhausted() && skipAll.getByte(0L) == b16) {
            i3++;
            skipAll.readByte();
        }
        return i3;
    }
}
