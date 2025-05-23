package okhttp3;

import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import kotlin.text.Typography;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;
import org.java_websocket.WebSocketImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u0002IJBa\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0007\u00a2\u0006\u0002\b!J\r\u0010\u0011\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b\"J\r\u0010\u0012\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b#J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007\u00a2\u0006\u0002\b$J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0007\u00a2\u0006\u0002\b%J\r\u0010\u0016\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b&J\u0013\u0010'\u001a\u00020\u00182\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u000f\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0007\u00a2\u0006\u0002\b)J\b\u0010*\u001a\u00020\bH\u0016J\r\u0010\u0006\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b+J\u0006\u0010,\u001a\u00020-J\u0010\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0003J\r\u0010\u0005\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b/J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007\u00a2\u0006\u0002\b0J\r\u0010\u001a\u001a\u00020\bH\u0007\u00a2\u0006\u0002\b1J\r\u0010\u0007\u001a\u00020\bH\u0007\u00a2\u0006\u0002\b2J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0007\u00a2\u0006\u0002\b3J\u0010\u00104\u001a\u0004\u0018\u00010\u00032\u0006\u00105\u001a\u00020\u0003J\u000e\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\bJ\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0007\u00a2\u0006\u0002\b8J\u0010\u00109\u001a\u0004\u0018\u00010\u00032\u0006\u00107\u001a\u00020\bJ\u0016\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n2\u0006\u00105\u001a\u00020\u0003J\r\u0010 \u001a\u00020\bH\u0007\u00a2\u0006\u0002\b;J\u0006\u0010<\u001a\u00020\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u00002\u0006\u0010.\u001a\u00020\u0003J\r\u0010\u0002\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\b>J\b\u0010?\u001a\u00020\u0003H\u0016J\r\u0010@\u001a\u00020AH\u0007\u00a2\u0006\u0002\bBJ\r\u0010C\u001a\u00020DH\u0007\u00a2\u0006\u0002\b\rJ\b\u0010E\u001a\u0004\u0018\u00010\u0003J\r\u0010B\u001a\u00020AH\u0007\u00a2\u0006\u0002\bFJ\r\u0010\r\u001a\u00020DH\u0007\u00a2\u0006\u0002\bGJ\r\u0010\u0004\u001a\u00020\u0003H\u0007\u00a2\u0006\u0002\bHR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\n8G\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0016\u001a\u00020\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0010R\u0013\u0010\u0006\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0019R\u0013\u0010\u0005\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014R\u0011\u0010\u001a\u001a\u00020\b8G\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0007\u001a\u00020\b8\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00038G\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010R\u0018\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e8G\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u0011\u0010 \u001a\u00020\b8G\u00a2\u0006\u0006\u001a\u0004\b \u0010\u001bR\u0013\u0010\u0002\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u00020\u00038\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010\u00a8\u0006K"}, d2 = {"Lokhttp3/HttpUrl;", "", ZPlanPublishSource.FROM_SCHEME, "", "username", NotificationActivity.PASSWORD, "host", "port", "", "pathSegments", "", "queryNamesAndValues", "fragment", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "encodedFragment", "()Ljava/lang/String;", "encodedPassword", "encodedPath", "encodedPathSegments", "()Ljava/util/List;", "encodedQuery", "encodedUsername", "isHttps", "", "()Z", "pathSize", "()I", "query", "queryParameterNames", "", "()Ljava/util/Set;", "querySize", "-deprecated_encodedFragment", "-deprecated_encodedPassword", "-deprecated_encodedPath", "-deprecated_encodedPathSegments", "-deprecated_encodedQuery", "-deprecated_encodedUsername", "equals", "other", "-deprecated_fragment", "hashCode", "-deprecated_host", "newBuilder", "Lokhttp3/HttpUrl$Builder;", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "-deprecated_password", "-deprecated_pathSegments", "-deprecated_pathSize", "-deprecated_port", "-deprecated_query", "queryParameter", "name", "queryParameterName", "index", "-deprecated_queryParameterNames", "queryParameterValue", "queryParameterValues", "-deprecated_querySize", "redact", "resolve", "-deprecated_scheme", "toString", "toUri", "Ljava/net/URI;", LayoutAttrDefine.CLICK_URI, "toUrl", "Ljava/net/URL;", "topPrivateDomain", "-deprecated_uri", "-deprecated_url", "-deprecated_username", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public final class HttpUrl {

    @NotNull
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";

    @NotNull
    public static final String FRAGMENT_ENCODE_SET = "";

    @NotNull
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";

    @NotNull
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    @NotNull
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";

    @NotNull
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";

    @NotNull
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";

    @NotNull
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";

    @NotNull
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";

    @NotNull
    public static final String QUERY_ENCODE_SET = " \"'<>#";

    @NotNull
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    @Nullable
    private final String fragment;

    @NotNull
    private final String host;
    private final boolean isHttps;

    @NotNull
    private final String password;

    @NotNull
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;

    @NotNull
    private final String scheme;
    private final String url;

    @NotNull
    private final String username;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0017\u0018\u0000 V2\u00020\u0001:\u0001VB\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004J\u0018\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0004J\u0018\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.H\u0002J\u0018\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004J\u0006\u00102\u001a\u000203J\b\u00104\u001a\u00020\u001bH\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004J\u000e\u00105\u001a\u00020\u00002\u0006\u00105\u001a\u00020\u0004J\u0010\u00106\u001a\u00020\u00002\b\u00106\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u00107\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0004J\u0010\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\u0004H\u0002J\u0010\u0010:\u001a\u00020.2\u0006\u00109\u001a\u00020\u0004H\u0002J\u001f\u0010;\u001a\u00020\u00002\b\u0010<\u001a\u0004\u0018\u0001032\u0006\u00109\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\b=J\u000e\u0010>\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u0004J\b\u0010?\u001a\u00020@H\u0002J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bJ0\u0010A\u001a\u00020@2\u0006\u00109\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020.2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010E\u001a\u00020\u00002\b\u0010E\u001a\u0004\u0018\u00010\u0004J\r\u0010F\u001a\u00020\u0000H\u0000\u00a2\u0006\u0002\bGJ\u0010\u0010H\u001a\u00020@2\u0006\u0010I\u001a\u00020\u0004H\u0002J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010K\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0004J\u000e\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001bJ \u0010N\u001a\u00020@2\u0006\u00109\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u001bH\u0002J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0004J\u0016\u0010P\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0004J\u0018\u0010Q\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u0016\u0010R\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0004J\u0018\u0010S\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004J\b\u0010T\u001a\u00020\u0004H\u0016J\u000e\u0010U\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rX\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\rX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001a\u0010\u001a\u001a\u00020\u001bX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0004X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b\u00a8\u0006W"}, d2 = {"Lokhttp3/HttpUrl$Builder;", "", "()V", "encodedFragment", "", "getEncodedFragment$okhttp", "()Ljava/lang/String;", "setEncodedFragment$okhttp", "(Ljava/lang/String;)V", "encodedPassword", "getEncodedPassword$okhttp", "setEncodedPassword$okhttp", "encodedPathSegments", "", "getEncodedPathSegments$okhttp", "()Ljava/util/List;", "encodedQueryNamesAndValues", "getEncodedQueryNamesAndValues$okhttp", "setEncodedQueryNamesAndValues$okhttp", "(Ljava/util/List;)V", "encodedUsername", "getEncodedUsername$okhttp", "setEncodedUsername$okhttp", "host", "getHost$okhttp", "setHost$okhttp", "port", "", "getPort$okhttp", "()I", "setPort$okhttp", "(I)V", ZPlanPublishSource.FROM_SCHEME, "getScheme$okhttp", "setScheme$okhttp", "addEncodedPathSegment", "encodedPathSegment", "addEncodedPathSegments", "addEncodedQueryParameter", "encodedName", "encodedValue", "addPathSegment", "pathSegment", "addPathSegments", "pathSegments", "alreadyEncoded", "", "addQueryParameter", "name", "value", "build", "Lokhttp3/HttpUrl;", "effectivePort", "encodedPath", "encodedQuery", "fragment", "isDot", "input", "isDotDot", "parse", PM.BASE, "parse$okhttp", NotificationActivity.PASSWORD, "pop", "", "push", c.G, "limit", "addTrailingSlash", "query", "reencodeForUri", "reencodeForUri$okhttp", "removeAllCanonicalQueryParameters", "canonicalName", "removeAllEncodedQueryParameters", "removeAllQueryParameters", "removePathSegment", "index", "resolvePath", "startPos", "setEncodedPathSegment", "setEncodedQueryParameter", "setPathSegment", "setQueryParameter", "toString", "username", "Companion", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public static final class Builder {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        public static final String INVALID_HOST = "Invalid URL host";

        @Nullable
        private String encodedFragment;

        @NotNull
        private final List<String> encodedPathSegments;

        @Nullable
        private List<String> encodedQueryNamesAndValues;

        @Nullable
        private String host;

        @Nullable
        private String scheme;

        @NotNull
        private String encodedUsername = "";

        @NotNull
        private String encodedPassword = "";
        private int port = -1;

        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u001c\u0010\f\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lokhttp3/HttpUrl$Builder$Companion;", "", "()V", "INVALID_HOST", "", "parsePort", "", "input", c.G, "limit", "portColonOffset", "schemeDelimiterOffset", "slashCount", "okhttp"}, k = 1, mv = {1, 4, 2})
        /* loaded from: classes28.dex */
        public static final class Companion {
            Companion() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int parsePort(String input, int pos, int limit) {
                try {
                    int parseInt = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, input, pos, limit, "", false, false, false, false, null, 248, null));
                    if (1 > parseInt || 65535 < parseInt) {
                        return -1;
                    }
                    return parseInt;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int portColonOffset(String input, int pos, int limit) {
                while (pos < limit) {
                    char charAt = input.charAt(pos);
                    if (charAt != ':') {
                        if (charAt != '[') {
                            pos++;
                        }
                        do {
                            pos++;
                            if (pos < limit) {
                            }
                            pos++;
                        } while (input.charAt(pos) != ']');
                        pos++;
                    } else {
                        return pos;
                    }
                }
                return limit;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int schemeDelimiterOffset(String input, int pos, int limit) {
                if (limit - pos < 2) {
                    return -1;
                }
                char charAt = input.charAt(pos);
                if ((Intrinsics.compare((int) charAt, 97) < 0 || Intrinsics.compare((int) charAt, 122) > 0) && (Intrinsics.compare((int) charAt, 65) < 0 || Intrinsics.compare((int) charAt, 90) > 0)) {
                    return -1;
                }
                while (true) {
                    pos++;
                    if (pos >= limit) {
                        return -1;
                    }
                    char charAt2 = input.charAt(pos);
                    if ('a' > charAt2 || 'z' < charAt2) {
                        if ('A' > charAt2 || 'Z' < charAt2) {
                            if ('0' > charAt2 || '9' < charAt2) {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 != ':') {
                                        return -1;
                                    }
                                    return pos;
                                }
                            }
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int slashCount(String str, int i3, int i16) {
                int i17 = 0;
                while (i3 < i16) {
                    char charAt = str.charAt(i3);
                    if (charAt != '\\' && charAt != '/') {
                        break;
                    }
                    i17++;
                    i3++;
                }
                return i17;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private final int effectivePort() {
            int i3 = this.port;
            if (i3 == -1) {
                Companion companion = HttpUrl.INSTANCE;
                String str = this.scheme;
                Intrinsics.checkNotNull(str);
                return companion.defaultPort(str);
            }
            return i3;
        }

        private final boolean isDot(String input) {
            boolean equals;
            if (!Intrinsics.areEqual(input, ".")) {
                equals = StringsKt__StringsJVMKt.equals(input, "%2e", true);
                if (equals) {
                    return true;
                }
                return false;
            }
            return true;
        }

        private final boolean isDotDot(String input) {
            boolean equals;
            boolean equals2;
            boolean equals3;
            if (!Intrinsics.areEqual(input, "..")) {
                equals = StringsKt__StringsJVMKt.equals(input, "%2e.", true);
                if (!equals) {
                    equals2 = StringsKt__StringsJVMKt.equals(input, ".%2e", true);
                    if (!equals2) {
                        equals3 = StringsKt__StringsJVMKt.equals(input, "%2e%2e", true);
                        if (equals3) {
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

        private final void pop() {
            boolean z16;
            List<String> list = this.encodedPathSegments;
            if (list.remove(list.size() - 1).length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && (!this.encodedPathSegments.isEmpty())) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, "");
            } else {
                this.encodedPathSegments.add("");
            }
        }

        private final void push(String input, int pos, int limit, boolean addTrailingSlash, boolean alreadyEncoded) {
            boolean z16;
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, input, pos, limit, HttpUrl.PATH_SEGMENT_ENCODE_SET, alreadyEncoded, false, false, false, null, 240, null);
            if (isDot(canonicalize$okhttp$default)) {
                return;
            }
            if (isDotDot(canonicalize$okhttp$default)) {
                pop();
                return;
            }
            List<String> list = this.encodedPathSegments;
            if (list.get(list.size() - 1).length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, canonicalize$okhttp$default);
            } else {
                this.encodedPathSegments.add(canonicalize$okhttp$default);
            }
            if (addTrailingSlash) {
                this.encodedPathSegments.add("");
            }
        }

        private final void removeAllCanonicalQueryParameters(String canonicalName) {
            IntProgression downTo;
            IntProgression step;
            List<String> list = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list);
            downTo = RangesKt___RangesKt.downTo(list.size() - 2, 0);
            step = RangesKt___RangesKt.step(downTo, 2);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if (step2 >= 0) {
                if (first > last) {
                    return;
                }
            } else if (first < last) {
                return;
            }
            while (true) {
                List<String> list2 = this.encodedQueryNamesAndValues;
                Intrinsics.checkNotNull(list2);
                if (Intrinsics.areEqual(canonicalName, list2.get(first))) {
                    List<String> list3 = this.encodedQueryNamesAndValues;
                    Intrinsics.checkNotNull(list3);
                    list3.remove(first + 1);
                    List<String> list4 = this.encodedQueryNamesAndValues;
                    Intrinsics.checkNotNull(list4);
                    list4.remove(first);
                    List<String> list5 = this.encodedQueryNamesAndValues;
                    Intrinsics.checkNotNull(list5);
                    if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (first != last) {
                    first += step2;
                } else {
                    return;
                }
            }
        }

        private final void resolvePath(String input, int startPos, int limit) {
            boolean z16;
            if (startPos == limit) {
                return;
            }
            char charAt = input.charAt(startPos);
            if (charAt != '/' && charAt != '\\') {
                List<String> list = this.encodedPathSegments;
                list.set(list.size() - 1, "");
            } else {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                startPos++;
            }
            while (true) {
                int i3 = startPos;
                if (i3 < limit) {
                    startPos = Util.delimiterOffset(input, "/\\", i3, limit);
                    if (startPos < limit) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    push(input, i3, startPos, z16, true);
                    if (z16) {
                        startPos++;
                    }
                } else {
                    return;
                }
            }
        }

        @NotNull
        public final Builder addEncodedPathSegment(@NotNull String encodedPathSegment) {
            Intrinsics.checkNotNullParameter(encodedPathSegment, "encodedPathSegment");
            push(encodedPathSegment, 0, encodedPathSegment.length(), false, true);
            return this;
        }

        @NotNull
        public final Builder addEncodedPathSegments(@NotNull String encodedPathSegments) {
            Intrinsics.checkNotNullParameter(encodedPathSegments, "encodedPathSegments");
            return addPathSegments(encodedPathSegments, true);
        }

        @NotNull
        public final Builder addEncodedQueryParameter(@NotNull String encodedName, @Nullable String encodedValue) {
            String str;
            Intrinsics.checkNotNullParameter(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list);
            Companion companion = HttpUrl.INSTANCE;
            list.add(Companion.canonicalize$okhttp$default(companion, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list2);
            if (encodedValue != null) {
                str = Companion.canonicalize$okhttp$default(companion, encodedValue, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null);
            } else {
                str = null;
            }
            list2.add(str);
            return this;
        }

        @NotNull
        public final Builder addPathSegment(@NotNull String pathSegment) {
            Intrinsics.checkNotNullParameter(pathSegment, "pathSegment");
            push(pathSegment, 0, pathSegment.length(), false, false);
            return this;
        }

        @NotNull
        public final Builder addPathSegments(@NotNull String pathSegments) {
            Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
            return addPathSegments(pathSegments, false);
        }

        @NotNull
        public final Builder addQueryParameter(@NotNull String name, @Nullable String value) {
            String str;
            Intrinsics.checkNotNullParameter(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list);
            Companion companion = HttpUrl.INSTANCE;
            list.add(Companion.canonicalize$okhttp$default(companion, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list2);
            if (value != null) {
                str = Companion.canonicalize$okhttp$default(companion, value, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null);
            } else {
                str = null;
            }
            list2.add(str);
            return this;
        }

        @NotNull
        public final HttpUrl build() {
            int collectionSizeOrDefault;
            ArrayList arrayList;
            String str;
            int collectionSizeOrDefault2;
            String str2;
            String str3 = this.scheme;
            if (str3 != null) {
                Companion companion = HttpUrl.INSTANCE;
                String percentDecode$okhttp$default = Companion.percentDecode$okhttp$default(companion, this.encodedUsername, 0, 0, false, 7, null);
                String percentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(companion, this.encodedPassword, 0, 0, false, 7, null);
                String str4 = this.host;
                if (str4 != null) {
                    int effectivePort = effectivePort();
                    List<String> list = this.encodedPathSegments;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(Companion.percentDecode$okhttp$default(HttpUrl.INSTANCE, (String) it.next(), 0, 0, false, 7, null));
                    }
                    List<String> list2 = this.encodedQueryNamesAndValues;
                    if (list2 != null) {
                        List<String> list3 = list2;
                        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list3, 10);
                        arrayList = new ArrayList(collectionSizeOrDefault2);
                        for (String str5 : list3) {
                            if (str5 != null) {
                                str2 = Companion.percentDecode$okhttp$default(HttpUrl.INSTANCE, str5, 0, 0, true, 3, null);
                            } else {
                                str2 = null;
                            }
                            arrayList.add(str2);
                        }
                    } else {
                        arrayList = null;
                    }
                    String str6 = this.encodedFragment;
                    if (str6 != null) {
                        str = Companion.percentDecode$okhttp$default(HttpUrl.INSTANCE, str6, 0, 0, false, 7, null);
                    } else {
                        str = null;
                    }
                    return new HttpUrl(str3, percentDecode$okhttp$default, percentDecode$okhttp$default2, str4, effectivePort, arrayList2, arrayList, str, toString());
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        @NotNull
        public final Builder encodedFragment(@Nullable String encodedFragment) {
            String str;
            if (encodedFragment != null) {
                str = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, encodedFragment, 0, 0, "", true, false, false, true, null, 179, null);
            } else {
                str = null;
            }
            this.encodedFragment = str;
            return this;
        }

        @NotNull
        public final Builder encodedPassword(@NotNull String encodedPassword) {
            Intrinsics.checkNotNullParameter(encodedPassword, "encodedPassword");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, encodedPassword, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        @NotNull
        public final Builder encodedPath(@NotNull String encodedPath) {
            boolean startsWith$default;
            Intrinsics.checkNotNullParameter(encodedPath, "encodedPath");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(encodedPath, "/", false, 2, null);
            if (startsWith$default) {
                resolvePath(encodedPath, 0, encodedPath.length());
                return this;
            }
            throw new IllegalArgumentException(("unexpected encodedPath: " + encodedPath).toString());
        }

        @NotNull
        public final Builder encodedQuery(@Nullable String encodedQuery) {
            List<String> list;
            if (encodedQuery != null) {
                Companion companion = HttpUrl.INSTANCE;
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, encodedQuery, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 211, null);
                if (canonicalize$okhttp$default != null) {
                    list = companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
                    this.encodedQueryNamesAndValues = list;
                    return this;
                }
            }
            list = null;
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        @NotNull
        public final Builder encodedUsername(@NotNull String encodedUsername) {
            Intrinsics.checkNotNullParameter(encodedUsername, "encodedUsername");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, encodedUsername, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        @NotNull
        public final Builder fragment(@Nullable String fragment) {
            String str;
            if (fragment != null) {
                str = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, fragment, 0, 0, "", false, false, false, true, null, 187, null);
            } else {
                str = null;
            }
            this.encodedFragment = str;
            return this;
        }

        @Nullable
        /* renamed from: getEncodedFragment$okhttp, reason: from getter */
        public final String getEncodedFragment() {
            return this.encodedFragment;
        }

        @NotNull
        /* renamed from: getEncodedPassword$okhttp, reason: from getter */
        public final String getEncodedPassword() {
            return this.encodedPassword;
        }

        @NotNull
        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        @Nullable
        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        @NotNull
        /* renamed from: getEncodedUsername$okhttp, reason: from getter */
        public final String getEncodedUsername() {
            return this.encodedUsername;
        }

        @Nullable
        /* renamed from: getHost$okhttp, reason: from getter */
        public final String getHost() {
            return this.host;
        }

        /* renamed from: getPort$okhttp, reason: from getter */
        public final int getPort() {
            return this.port;
        }

        @Nullable
        /* renamed from: getScheme$okhttp, reason: from getter */
        public final String getScheme() {
            return this.scheme;
        }

        @NotNull
        public final Builder host(@NotNull String host) {
            Intrinsics.checkNotNullParameter(host, "host");
            String canonicalHost = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.INSTANCE, host, 0, 0, false, 7, null));
            if (canonicalHost != null) {
                this.host = canonicalHost;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + host);
        }

        @NotNull
        public final Builder parse$okhttp(@Nullable HttpUrl base, @NotNull String input) {
            String take;
            int delimiterOffset;
            char c16;
            int i3;
            int i16;
            String str;
            boolean z16;
            boolean z17;
            boolean z18;
            int i17;
            String str2;
            int i18;
            boolean z19;
            boolean z26;
            boolean startsWith;
            boolean startsWith2;
            String input2 = input;
            Intrinsics.checkNotNullParameter(input2, "input");
            int indexOfFirstNonAsciiWhitespace$default = Util.indexOfFirstNonAsciiWhitespace$default(input2, 0, 0, 3, null);
            int indexOfLastNonAsciiWhitespace$default = Util.indexOfLastNonAsciiWhitespace$default(input2, indexOfFirstNonAsciiWhitespace$default, 0, 2, null);
            Companion companion = INSTANCE;
            int schemeDelimiterOffset = companion.schemeDelimiterOffset(input2, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            String str3 = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
            boolean z27 = true;
            char c17 = '\uffff';
            if (schemeDelimiterOffset != -1) {
                startsWith = StringsKt__StringsJVMKt.startsWith(input2, "https:", indexOfFirstNonAsciiWhitespace$default, true);
                if (!startsWith) {
                    startsWith2 = StringsKt__StringsJVMKt.startsWith(input2, "http:", indexOfFirstNonAsciiWhitespace$default, true);
                    if (startsWith2) {
                        this.scheme = "http";
                        indexOfFirstNonAsciiWhitespace$default += 5;
                    } else {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Expected URL scheme 'http' or 'https' but was '");
                        String substring = input2.substring(0, schemeDelimiterOffset);
                        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                        sb5.append(substring);
                        sb5.append("'");
                        throw new IllegalArgumentException(sb5.toString());
                    }
                } else {
                    this.scheme = "https";
                    indexOfFirstNonAsciiWhitespace$default += 6;
                }
            } else if (base != null) {
                this.scheme = base.scheme();
            } else {
                if (input.length() > 6) {
                    StringBuilder sb6 = new StringBuilder();
                    take = StringsKt___StringsKt.take(input2, 6);
                    sb6.append(take);
                    sb6.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                    input2 = sb6.toString();
                }
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no scheme was found for " + input2);
            }
            int slashCount = companion.slashCount(input2, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            char c18 = '?';
            char c19 = '#';
            if (slashCount < 2 && base != null && !(!Intrinsics.areEqual(base.scheme(), this.scheme))) {
                this.encodedUsername = base.encodedUsername();
                this.encodedPassword = base.encodedPassword();
                this.host = base.host();
                this.port = base.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(base.encodedPathSegments());
                if (indexOfFirstNonAsciiWhitespace$default == indexOfLastNonAsciiWhitespace$default || input2.charAt(indexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(base.encodedQuery());
                }
                i3 = indexOfLastNonAsciiWhitespace$default;
            } else {
                int i19 = indexOfFirstNonAsciiWhitespace$default + slashCount;
                boolean z28 = false;
                boolean z29 = false;
                while (true) {
                    delimiterOffset = Util.delimiterOffset(input2, "@/\\?#", i19, indexOfLastNonAsciiWhitespace$default);
                    if (delimiterOffset != indexOfLastNonAsciiWhitespace$default) {
                        c16 = input2.charAt(delimiterOffset);
                    } else {
                        c16 = c17;
                    }
                    if (c16 == c17 || c16 == c19 || c16 == '/' || c16 == '\\' || c16 == c18) {
                        break;
                    }
                    if (c16 != '@') {
                        z18 = z27;
                        str2 = str3;
                        i17 = indexOfLastNonAsciiWhitespace$default;
                    } else {
                        if (!z28) {
                            int delimiterOffset2 = Util.delimiterOffset(input2, ':', i19, delimiterOffset);
                            Companion companion2 = HttpUrl.INSTANCE;
                            z18 = z27;
                            i17 = indexOfLastNonAsciiWhitespace$default;
                            String str4 = str3;
                            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion2, input, i19, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z29) {
                                canonicalize$okhttp$default = this.encodedUsername + "%40" + canonicalize$okhttp$default;
                            }
                            this.encodedUsername = canonicalize$okhttp$default;
                            if (delimiterOffset2 != delimiterOffset) {
                                this.encodedPassword = Companion.canonicalize$okhttp$default(companion2, input, delimiterOffset2 + 1, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z26 = z18;
                            } else {
                                z26 = z28;
                            }
                            z28 = z26;
                            str2 = str4;
                            z19 = z18;
                            i18 = delimiterOffset;
                        } else {
                            z18 = z27;
                            i17 = indexOfLastNonAsciiWhitespace$default;
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append(this.encodedPassword);
                            sb7.append("%40");
                            str2 = str3;
                            i18 = delimiterOffset;
                            sb7.append(Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, input, i19, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
                            this.encodedPassword = sb7.toString();
                            z19 = z29;
                        }
                        i19 = i18 + 1;
                        z29 = z19;
                    }
                    str3 = str2;
                    z27 = z18;
                    indexOfLastNonAsciiWhitespace$default = i17;
                    c19 = '#';
                    c18 = '?';
                    c17 = '\uffff';
                }
                boolean z36 = z27;
                String str5 = str3;
                i3 = indexOfLastNonAsciiWhitespace$default;
                Companion companion3 = INSTANCE;
                int portColonOffset = companion3.portColonOffset(input2, i19, delimiterOffset);
                int i26 = portColonOffset + 1;
                if (i26 < delimiterOffset) {
                    i16 = i19;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.INSTANCE, input, i19, portColonOffset, false, 4, null));
                    int parsePort = companion3.parsePort(input2, i26, delimiterOffset);
                    this.port = parsePort;
                    if (parsePort != -1) {
                        z17 = z36;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        str = str5;
                    } else {
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append("Invalid URL port: \"");
                        String substring2 = input2.substring(i26, delimiterOffset);
                        Intrinsics.checkNotNullExpressionValue(substring2, str5);
                        sb8.append(substring2);
                        sb8.append('\"');
                        throw new IllegalArgumentException(sb8.toString().toString());
                    }
                } else {
                    i16 = i19;
                    str = str5;
                    Companion companion4 = HttpUrl.INSTANCE;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(companion4, input, i16, portColonOffset, false, 4, null));
                    String str6 = this.scheme;
                    Intrinsics.checkNotNull(str6);
                    this.port = companion4.defaultPort(str6);
                }
                if (this.host != null) {
                    z16 = z36;
                } else {
                    z16 = false;
                }
                if (z16) {
                    indexOfFirstNonAsciiWhitespace$default = delimiterOffset;
                } else {
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append("Invalid URL host: \"");
                    String substring3 = input2.substring(i16, portColonOffset);
                    Intrinsics.checkNotNullExpressionValue(substring3, str);
                    sb9.append(substring3);
                    sb9.append('\"');
                    throw new IllegalArgumentException(sb9.toString().toString());
                }
            }
            int i27 = i3;
            int delimiterOffset3 = Util.delimiterOffset(input2, "?#", indexOfFirstNonAsciiWhitespace$default, i27);
            resolvePath(input2, indexOfFirstNonAsciiWhitespace$default, delimiterOffset3);
            if (delimiterOffset3 < i27 && input2.charAt(delimiterOffset3) == '?') {
                int delimiterOffset4 = Util.delimiterOffset(input2, '#', delimiterOffset3, i27);
                Companion companion5 = HttpUrl.INSTANCE;
                this.encodedQueryNamesAndValues = companion5.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(companion5, input, delimiterOffset3 + 1, delimiterOffset4, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 208, null));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < i27 && input2.charAt(delimiterOffset3) == '#') {
                this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, input, delimiterOffset3 + 1, i27, "", true, false, false, true, null, 176, null);
            }
            return this;
        }

        @NotNull
        public final Builder password(@NotNull String password) {
            Intrinsics.checkNotNullParameter(password, "password");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        @NotNull
        public final Builder port(int port) {
            boolean z16 = true;
            if (1 > port || 65535 < port) {
                z16 = false;
            }
            if (z16) {
                this.port = port;
                return this;
            }
            throw new IllegalArgumentException(("unexpected port: " + port).toString());
        }

        @NotNull
        public final Builder query(@Nullable String query) {
            List<String> list;
            if (query != null) {
                Companion companion = HttpUrl.INSTANCE;
                String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, query, 0, 0, HttpUrl.QUERY_ENCODE_SET, false, false, true, false, null, 219, null);
                if (canonicalize$okhttp$default != null) {
                    list = companion.toQueryNamesAndValues$okhttp(canonicalize$okhttp$default);
                    this.encodedQueryNamesAndValues = list;
                    return this;
                }
            }
            list = null;
            this.encodedQueryNamesAndValues = list;
            return this;
        }

        @NotNull
        public final Builder reencodeForUri$okhttp() {
            String str;
            String str2;
            String str3 = this.host;
            String str4 = null;
            if (str3 != null) {
                str = new Regex("[\"<>^`{|}]").replace(str3, "");
            } else {
                str = null;
            }
            this.host = str;
            int size = this.encodedPathSegments.size();
            for (int i3 = 0; i3 < size; i3++) {
                List<String> list = this.encodedPathSegments;
                list.set(i3, Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, list.get(i3), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, null, 227, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i16 = 0; i16 < size2; i16++) {
                    String str5 = list2.get(i16);
                    if (str5 != null) {
                        str2 = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, str5, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, null, 195, null);
                    } else {
                        str2 = null;
                    }
                    list2.set(i16, str2);
                }
            }
            String str6 = this.encodedFragment;
            if (str6 != null) {
                str4 = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, str6, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, null, 163, null);
            }
            this.encodedFragment = str4;
            return this;
        }

        @NotNull
        public final Builder removeAllEncodedQueryParameters(@NotNull String encodedName) {
            Intrinsics.checkNotNullParameter(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            return this;
        }

        @NotNull
        public final Builder removeAllQueryParameters(@NotNull String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            return this;
        }

        @NotNull
        public final Builder removePathSegment(int index) {
            this.encodedPathSegments.remove(index);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        @NotNull
        public final Builder scheme(@NotNull String scheme) {
            boolean equals;
            boolean equals2;
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            equals = StringsKt__StringsJVMKt.equals(scheme, "http", true);
            if (!equals) {
                equals2 = StringsKt__StringsJVMKt.equals(scheme, "https", true);
                if (equals2) {
                    this.scheme = "https";
                } else {
                    throw new IllegalArgumentException("unexpected scheme: " + scheme);
                }
            } else {
                this.scheme = "http";
            }
            return this;
        }

        public final void setEncodedFragment$okhttp(@Nullable String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.encodedPassword = str;
        }

        @NotNull
        public final Builder setEncodedPathSegment(int index, @NotNull String encodedPathSegment) {
            boolean z16;
            Intrinsics.checkNotNullParameter(encodedPathSegment, "encodedPathSegment");
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, encodedPathSegment, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, null, 243, null);
            this.encodedPathSegments.set(index, canonicalize$okhttp$default);
            if (!isDot(canonicalize$okhttp$default) && !isDotDot(canonicalize$okhttp$default)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + encodedPathSegment).toString());
        }

        public final void setEncodedQueryNamesAndValues$okhttp(@Nullable List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        @NotNull
        public final Builder setEncodedQueryParameter(@NotNull String encodedName, @Nullable String encodedValue) {
            Intrinsics.checkNotNullParameter(encodedName, "encodedName");
            removeAllEncodedQueryParameters(encodedName);
            addEncodedQueryParameter(encodedName, encodedValue);
            return this;
        }

        public final void setEncodedUsername$okhttp(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(@Nullable String str) {
            this.host = str;
        }

        @NotNull
        public final Builder setPathSegment(int index, @NotNull String pathSegment) {
            boolean z16;
            Intrinsics.checkNotNullParameter(pathSegment, "pathSegment");
            String canonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, pathSegment, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, null, 251, null);
            if (!isDot(canonicalize$okhttp$default) && !isDotDot(canonicalize$okhttp$default)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                this.encodedPathSegments.set(index, canonicalize$okhttp$default);
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + pathSegment).toString());
        }

        public final void setPort$okhttp(int i3) {
            this.port = i3;
        }

        @NotNull
        public final Builder setQueryParameter(@NotNull String name, @Nullable String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            removeAllQueryParameters(name);
            addQueryParameter(name, value);
            return this;
        }

        public final void setScheme$okhttp(@Nullable String str) {
            this.scheme = str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
        
            if (r1 != false) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0093, code lost:
        
            if (r1 != r3.defaultPort(r2)) goto L38;
         */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String toString() {
            boolean z16;
            boolean contains$default;
            boolean z17;
            StringBuilder sb5 = new StringBuilder();
            String str = this.scheme;
            if (str != null) {
                sb5.append(str);
                sb5.append(QzoneWebViewOfflinePlugin.STR_DEVIDER);
            } else {
                sb5.append("//");
            }
            boolean z18 = true;
            if (this.encodedUsername.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                if (this.encodedPassword.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            }
            sb5.append(this.encodedUsername);
            if (this.encodedPassword.length() <= 0) {
                z18 = false;
            }
            if (z18) {
                sb5.append(':');
                sb5.append(this.encodedPassword);
            }
            sb5.append('@');
            String str2 = this.host;
            if (str2 != null) {
                Intrinsics.checkNotNull(str2);
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str2, ':', false, 2, (Object) null);
                if (contains$default) {
                    sb5.append('[');
                    sb5.append(this.host);
                    sb5.append(']');
                } else {
                    sb5.append(this.host);
                }
            }
            if (this.port != -1 || this.scheme != null) {
                int effectivePort = effectivePort();
                String str3 = this.scheme;
                if (str3 != null) {
                    Companion companion = HttpUrl.INSTANCE;
                    Intrinsics.checkNotNull(str3);
                }
                sb5.append(':');
                sb5.append(effectivePort);
            }
            Companion companion2 = HttpUrl.INSTANCE;
            companion2.toPathString$okhttp(this.encodedPathSegments, sb5);
            if (this.encodedQueryNamesAndValues != null) {
                sb5.append('?');
                List<String> list = this.encodedQueryNamesAndValues;
                Intrinsics.checkNotNull(list);
                companion2.toQueryString$okhttp(list, sb5);
            }
            if (this.encodedFragment != null) {
                sb5.append('#');
                sb5.append(this.encodedFragment);
            }
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
            return sb6;
        }

        @NotNull
        public final Builder username(@NotNull String username) {
            Intrinsics.checkNotNullParameter(username, "username");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.INSTANCE, username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        private final Builder addPathSegments(String pathSegments, boolean alreadyEncoded) {
            int i3 = 0;
            do {
                int delimiterOffset = Util.delimiterOffset(pathSegments, "/\\", i3, pathSegments.length());
                push(pathSegments, i3, delimiterOffset, delimiterOffset < pathSegments.length(), alreadyEncoded);
                i3 = delimiterOffset + 1;
            } while (i3 <= pathSegments.length());
            return this;
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007\u00a2\u0006\u0002\b\u0018J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0007\u00a2\u0006\u0002\b\u0018J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\b\u0018J\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u0004H\u0007\u00a2\u0006\u0002\b\u001cJa\u0010\u001d\u001a\u00020\u0004*\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0000\u00a2\u0006\u0002\b(J\u001c\u0010)\u001a\u00020\"*\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0012H\u0002J/\u0010*\u001a\u00020\u0004*\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\"H\u0000\u00a2\u0006\u0002\b+J\u0011\u0010,\u001a\u00020\u0015*\u00020\u0004H\u0007\u00a2\u0006\u0002\b\u0014J\u0013\u0010-\u001a\u0004\u0018\u00010\u0015*\u00020\u0017H\u0007\u00a2\u0006\u0002\b\u0014J\u0013\u0010-\u001a\u0004\u0018\u00010\u0015*\u00020\u001aH\u0007\u00a2\u0006\u0002\b\u0014J\u0013\u0010-\u001a\u0004\u0018\u00010\u0015*\u00020\u0004H\u0007\u00a2\u0006\u0002\b\u001bJ#\u0010.\u001a\u00020/*\b\u0012\u0004\u0012\u00020\u0004002\n\u00101\u001a\u000602j\u0002`3H\u0000\u00a2\u0006\u0002\b4J\u0019\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000406*\u00020\u0004H\u0000\u00a2\u0006\u0002\b7J%\u00108\u001a\u00020/*\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004002\n\u00101\u001a\u000602j\u0002`3H\u0000\u00a2\u0006\u0002\b9JV\u0010:\u001a\u00020/*\u00020;2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J,\u0010=\u001a\u00020/*\u00020;2\u0006\u0010>\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0080T\u00a2\u0006\u0002\n\u0000\u00a8\u0006?"}, d2 = {"Lokhttp3/HttpUrl$Companion;", "", "()V", "FORM_ENCODE_SET", "", "FRAGMENT_ENCODE_SET", "FRAGMENT_ENCODE_SET_URI", "HEX_DIGITS", "", "PASSWORD_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET_URI", "QUERY_COMPONENT_ENCODE_SET", "QUERY_COMPONENT_ENCODE_SET_URI", "QUERY_COMPONENT_REENCODE_SET", "QUERY_ENCODE_SET", "USERNAME_ENCODE_SET", "defaultPort", "", ZPlanPublishSource.FROM_SCHEME, "get", "Lokhttp3/HttpUrl;", LayoutAttrDefine.CLICK_URI, "Ljava/net/URI;", "-deprecated_get", "url", "Ljava/net/URL;", "parse", "-deprecated_parse", "canonicalize", c.G, "limit", "encodeSet", "alreadyEncoded", "", "strict", "plusIsSpace", "unicodeAllowed", HttpMsg.CHARSET, "Ljava/nio/charset/Charset;", "canonicalize$okhttp", "isPercentEncoded", "percentDecode", "percentDecode$okhttp", "toHttpUrl", "toHttpUrlOrNull", "toPathString", "", "", "out", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "toPathString$okhttp", "toQueryNamesAndValues", "", "toQueryNamesAndValues$okhttp", "toQueryString", "toQueryString$okhttp", "writeCanonicalized", "Lokio/Buffer;", "input", "writePercentDecoded", "encoded", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public static final class Companion {
        Companion() {
        }

        public static /* synthetic */ String canonicalize$okhttp$default(Companion companion, String str, int i3, int i16, String str2, boolean z16, boolean z17, boolean z18, boolean z19, Charset charset, int i17, Object obj) {
            int i18;
            int i19;
            boolean z26;
            boolean z27;
            boolean z28;
            boolean z29;
            Charset charset2;
            if ((i17 & 1) != 0) {
                i18 = 0;
            } else {
                i18 = i3;
            }
            if ((i17 & 2) != 0) {
                i19 = str.length();
            } else {
                i19 = i16;
            }
            if ((i17 & 8) != 0) {
                z26 = false;
            } else {
                z26 = z16;
            }
            if ((i17 & 16) != 0) {
                z27 = false;
            } else {
                z27 = z17;
            }
            if ((i17 & 32) != 0) {
                z28 = false;
            } else {
                z28 = z18;
            }
            if ((i17 & 64) != 0) {
                z29 = false;
            } else {
                z29 = z19;
            }
            if ((i17 & 128) != 0) {
                charset2 = null;
            } else {
                charset2 = charset;
            }
            return companion.canonicalize$okhttp(str, i18, i19, str2, z26, z27, z28, z29, charset2);
        }

        private final boolean isPercentEncoded(String str, int i3, int i16) {
            int i17 = i3 + 2;
            if (i17 < i16 && str.charAt(i3) == '%' && Util.parseHexDigit(str.charAt(i3 + 1)) != -1 && Util.parseHexDigit(str.charAt(i17)) != -1) {
                return true;
            }
            return false;
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion companion, String str, int i3, int i16, boolean z16, int i17, Object obj) {
            if ((i17 & 1) != 0) {
                i3 = 0;
            }
            if ((i17 & 2) != 0) {
                i16 = str.length();
            }
            if ((i17 & 4) != 0) {
                z16 = false;
            }
            return companion.percentDecode$okhttp(str, i3, i16, z16);
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x0064, code lost:
        
            if (isPercentEncoded(r16, r5, r18) == false) goto L43;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void writeCanonicalized(Buffer buffer, String str, int i3, int i16, String str2, boolean z16, boolean z17, boolean z18, boolean z19, Charset charset) {
            boolean contains$default;
            String str3;
            int i17 = i3;
            Buffer buffer2 = null;
            while (i17 < i16) {
                if (str != null) {
                    int codePointAt = str.codePointAt(i17);
                    if (!z16 || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                        if (codePointAt == 43 && z18) {
                            if (z16) {
                                str3 = Marker.ANY_NON_NULL_MARKER;
                            } else {
                                str3 = "%2B";
                            }
                            buffer.writeUtf8(str3);
                        } else {
                            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || z19)) {
                                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str2, (char) codePointAt, false, 2, (Object) null);
                                if (!contains$default) {
                                    if (codePointAt == 37) {
                                        if (z16) {
                                            if (z17) {
                                            }
                                        }
                                    }
                                    buffer.writeUtf8CodePoint(codePointAt);
                                    i17 += Character.charCount(codePointAt);
                                }
                            }
                            if (buffer2 == null) {
                                buffer2 = new Buffer();
                            }
                            if (charset != null && !Intrinsics.areEqual(charset, StandardCharsets.UTF_8)) {
                                buffer2.writeString(str, i17, Character.charCount(codePointAt) + i17, charset);
                            } else {
                                buffer2.writeUtf8CodePoint(codePointAt);
                            }
                            while (!buffer2.exhausted()) {
                                int readByte = buffer2.readByte() & 255;
                                buffer.writeByte(37);
                                buffer.writeByte((int) HttpUrl.HEX_DIGITS[(readByte >> 4) & 15]);
                                buffer.writeByte((int) HttpUrl.HEX_DIGITS[readByte & 15]);
                            }
                            i17 += Character.charCount(codePointAt);
                        }
                    }
                    i17 += Character.charCount(codePointAt);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
        }

        private final void writePercentDecoded(Buffer buffer, String str, int i3, int i16, boolean z16) {
            int i17;
            while (i3 < i16) {
                if (str != null) {
                    int codePointAt = str.codePointAt(i3);
                    if (codePointAt == 37 && (i17 = i3 + 2) < i16) {
                        int parseHexDigit = Util.parseHexDigit(str.charAt(i3 + 1));
                        int parseHexDigit2 = Util.parseHexDigit(str.charAt(i17));
                        if (parseHexDigit != -1 && parseHexDigit2 != -1) {
                            buffer.writeByte((parseHexDigit << 4) + parseHexDigit2);
                            i3 = Character.charCount(codePointAt) + i17;
                        }
                        buffer.writeUtf8CodePoint(codePointAt);
                        i3 += Character.charCount(codePointAt);
                    } else {
                        if (codePointAt == 43 && z16) {
                            buffer.writeByte(32);
                            i3++;
                        }
                        buffer.writeUtf8CodePoint(codePointAt);
                        i3 += Character.charCount(codePointAt);
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            }
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrl()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrl"}))
        @JvmName(name = "-deprecated_get")
        @NotNull
        /* renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m2130deprecated_get(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return get(url);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        @JvmName(name = "-deprecated_parse")
        @Nullable
        /* renamed from: -deprecated_parse, reason: not valid java name */
        public final HttpUrl m2133deprecated_parse(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return parse(url);
        }

        @NotNull
        public final String canonicalize$okhttp(@NotNull String canonicalize, int i3, int i16, @NotNull String encodeSet, boolean z16, boolean z17, boolean z18, boolean z19, @Nullable Charset charset) {
            boolean contains$default;
            Intrinsics.checkNotNullParameter(canonicalize, "$this$canonicalize");
            Intrinsics.checkNotNullParameter(encodeSet, "encodeSet");
            int i17 = i3;
            while (i17 < i16) {
                int codePointAt = canonicalize.codePointAt(i17);
                if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || z19)) {
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) encodeSet, (char) codePointAt, false, 2, (Object) null);
                    if (!contains$default) {
                        if (codePointAt == 37) {
                            if (z16) {
                                if (z17) {
                                    if (!isPercentEncoded(canonicalize, i17, i16)) {
                                        Buffer buffer = new Buffer();
                                        buffer.writeUtf8(canonicalize, i3, i17);
                                        writeCanonicalized(buffer, canonicalize, i17, i16, encodeSet, z16, z17, z18, z19, charset);
                                        return buffer.readUtf8();
                                    }
                                    if (codePointAt == 43 || !z18) {
                                        i17 += Character.charCount(codePointAt);
                                    } else {
                                        Buffer buffer2 = new Buffer();
                                        buffer2.writeUtf8(canonicalize, i3, i17);
                                        writeCanonicalized(buffer2, canonicalize, i17, i16, encodeSet, z16, z17, z18, z19, charset);
                                        return buffer2.readUtf8();
                                    }
                                }
                            }
                        }
                        if (codePointAt == 43) {
                        }
                        i17 += Character.charCount(codePointAt);
                    }
                }
                Buffer buffer22 = new Buffer();
                buffer22.writeUtf8(canonicalize, i3, i17);
                writeCanonicalized(buffer22, canonicalize, i17, i16, encodeSet, z16, z17, z18, z19, charset);
                return buffer22.readUtf8();
            }
            String substring = canonicalize.substring(i3, i16);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            return substring;
        }

        @JvmStatic
        public final int defaultPort(@NotNull String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            int hashCode = scheme.hashCode();
            if (hashCode != 3213448) {
                if (hashCode == 99617003 && scheme.equals("https")) {
                    return WebSocketImpl.DEFAULT_WSS_PORT;
                }
            } else if (scheme.equals("http")) {
                return 80;
            }
            return -1;
        }

        @JvmStatic
        @JvmName(name = "get")
        @NotNull
        public final HttpUrl get(@NotNull String toHttpUrl) {
            Intrinsics.checkNotNullParameter(toHttpUrl, "$this$toHttpUrl");
            return new Builder().parse$okhttp(null, toHttpUrl).build();
        }

        @JvmStatic
        @JvmName(name = "parse")
        @Nullable
        public final HttpUrl parse(@NotNull String toHttpUrlOrNull) {
            Intrinsics.checkNotNullParameter(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            try {
                return get(toHttpUrlOrNull);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        @NotNull
        public final String percentDecode$okhttp(@NotNull String percentDecode, int i3, int i16, boolean z16) {
            Intrinsics.checkNotNullParameter(percentDecode, "$this$percentDecode");
            for (int i17 = i3; i17 < i16; i17++) {
                char charAt = percentDecode.charAt(i17);
                if (charAt == '%' || (charAt == '+' && z16)) {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(percentDecode, i3, i17);
                    writePercentDecoded(buffer, percentDecode, i17, i16, z16);
                    return buffer.readUtf8();
                }
            }
            String substring = percentDecode.substring(i3, i16);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            return substring;
        }

        public final void toPathString$okhttp(@NotNull List<String> toPathString, @NotNull StringBuilder out) {
            Intrinsics.checkNotNullParameter(toPathString, "$this$toPathString");
            Intrinsics.checkNotNullParameter(out, "out");
            int size = toPathString.size();
            for (int i3 = 0; i3 < size; i3++) {
                out.append('/');
                out.append(toPathString.get(i3));
            }
        }

        @NotNull
        public final List<String> toQueryNamesAndValues$okhttp(@NotNull String toQueryNamesAndValues) {
            int indexOf$default;
            int indexOf$default2;
            Intrinsics.checkNotNullParameter(toQueryNamesAndValues, "$this$toQueryNamesAndValues");
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            while (i3 <= toQueryNamesAndValues.length()) {
                indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) toQueryNamesAndValues, Typography.amp, i3, false, 4, (Object) null);
                if (indexOf$default == -1) {
                    indexOf$default = toQueryNamesAndValues.length();
                }
                int i16 = indexOf$default;
                indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) toQueryNamesAndValues, '=', i3, false, 4, (Object) null);
                if (indexOf$default2 != -1 && indexOf$default2 <= i16) {
                    String substring = toQueryNamesAndValues.substring(i3, indexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    arrayList.add(substring);
                    String substring2 = toQueryNamesAndValues.substring(indexOf$default2 + 1, i16);
                    Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    arrayList.add(substring2);
                } else {
                    String substring3 = toQueryNamesAndValues.substring(i3, i16);
                    Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    arrayList.add(substring3);
                    arrayList.add(null);
                }
                i3 = i16 + 1;
            }
            return arrayList;
        }

        public final void toQueryString$okhttp(@NotNull List<String> toQueryString, @NotNull StringBuilder out) {
            IntRange until;
            IntProgression step;
            Intrinsics.checkNotNullParameter(toQueryString, "$this$toQueryString");
            Intrinsics.checkNotNullParameter(out, "out");
            until = RangesKt___RangesKt.until(0, toQueryString.size());
            step = RangesKt___RangesKt.step(until, 2);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if (step2 >= 0) {
                if (first > last) {
                    return;
                }
            } else if (first < last) {
                return;
            }
            while (true) {
                String str = toQueryString.get(first);
                String str2 = toQueryString.get(first + 1);
                if (first > 0) {
                    out.append(Typography.amp);
                }
                out.append(str);
                if (str2 != null) {
                    out.append('=');
                    out.append(str2);
                }
                if (first != last) {
                    first += step2;
                } else {
                    return;
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        @JvmName(name = "-deprecated_get")
        @Nullable
        /* renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m2132deprecated_get(@NotNull URL url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return get(url);
        }

        @JvmStatic
        @JvmName(name = "get")
        @Nullable
        public final HttpUrl get(@NotNull URL toHttpUrlOrNull) {
            Intrinsics.checkNotNullParameter(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            String url = toHttpUrlOrNull.toString();
            Intrinsics.checkNotNullExpressionValue(url, "toString()");
            return parse(url);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "uri.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        @JvmName(name = "-deprecated_get")
        @Nullable
        /* renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m2131deprecated_get(@NotNull URI uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return get(uri);
        }

        @JvmStatic
        @JvmName(name = "get")
        @Nullable
        public final HttpUrl get(@NotNull URI toHttpUrlOrNull) {
            Intrinsics.checkNotNullParameter(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            String uri = toHttpUrlOrNull.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "toString()");
            return parse(uri);
        }
    }

    public HttpUrl(@NotNull String scheme, @NotNull String username, @NotNull String password, @NotNull String host, int i3, @NotNull List<String> pathSegments, @Nullable List<String> list, @Nullable String str, @NotNull String url) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
        Intrinsics.checkNotNullParameter(url, "url");
        this.scheme = scheme;
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = i3;
        this.pathSegments = pathSegments;
        this.queryNamesAndValues = list;
        this.fragment = str;
        this.url = url;
        this.isHttps = Intrinsics.areEqual(scheme, "https");
    }

    @JvmStatic
    public static final int defaultPort(@NotNull String str) {
        return INSTANCE.defaultPort(str);
    }

    @JvmStatic
    @JvmName(name = "get")
    @NotNull
    public static final HttpUrl get(@NotNull String str) {
        return INSTANCE.get(str);
    }

    @JvmStatic
    @JvmName(name = "parse")
    @Nullable
    public static final HttpUrl parse(@NotNull String str) {
        return INSTANCE.parse(str);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedFragment", imports = {}))
    @JvmName(name = "-deprecated_encodedFragment")
    @Nullable
    /* renamed from: -deprecated_encodedFragment, reason: not valid java name */
    public final String m2111deprecated_encodedFragment() {
        return encodedFragment();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPassword", imports = {}))
    @JvmName(name = "-deprecated_encodedPassword")
    @NotNull
    /* renamed from: -deprecated_encodedPassword, reason: not valid java name */
    public final String m2112deprecated_encodedPassword() {
        return encodedPassword();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPath", imports = {}))
    @JvmName(name = "-deprecated_encodedPath")
    @NotNull
    /* renamed from: -deprecated_encodedPath, reason: not valid java name */
    public final String m2113deprecated_encodedPath() {
        return encodedPath();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPathSegments", imports = {}))
    @JvmName(name = "-deprecated_encodedPathSegments")
    @NotNull
    /* renamed from: -deprecated_encodedPathSegments, reason: not valid java name */
    public final List<String> m2114deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedQuery", imports = {}))
    @JvmName(name = "-deprecated_encodedQuery")
    @Nullable
    /* renamed from: -deprecated_encodedQuery, reason: not valid java name */
    public final String m2115deprecated_encodedQuery() {
        return encodedQuery();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedUsername", imports = {}))
    @JvmName(name = "-deprecated_encodedUsername")
    @NotNull
    /* renamed from: -deprecated_encodedUsername, reason: not valid java name */
    public final String m2116deprecated_encodedUsername() {
        return encodedUsername();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "fragment", imports = {}))
    @JvmName(name = "-deprecated_fragment")
    @Nullable
    /* renamed from: -deprecated_fragment, reason: not valid java name and from getter */
    public final String getFragment() {
        return this.fragment;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "host", imports = {}))
    @JvmName(name = "-deprecated_host")
    @NotNull
    /* renamed from: -deprecated_host, reason: not valid java name and from getter */
    public final String getHost() {
        return this.host;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = NotificationActivity.PASSWORD, imports = {}))
    @JvmName(name = "-deprecated_password")
    @NotNull
    /* renamed from: -deprecated_password, reason: not valid java name and from getter */
    public final String getPassword() {
        return this.password;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "pathSegments", imports = {}))
    @JvmName(name = "-deprecated_pathSegments")
    @NotNull
    /* renamed from: -deprecated_pathSegments, reason: not valid java name */
    public final List<String> m2120deprecated_pathSegments() {
        return this.pathSegments;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "pathSize", imports = {}))
    @JvmName(name = "-deprecated_pathSize")
    /* renamed from: -deprecated_pathSize, reason: not valid java name */
    public final int m2121deprecated_pathSize() {
        return pathSize();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "port", imports = {}))
    @JvmName(name = "-deprecated_port")
    /* renamed from: -deprecated_port, reason: not valid java name and from getter */
    public final int getPort() {
        return this.port;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "query", imports = {}))
    @JvmName(name = "-deprecated_query")
    @Nullable
    /* renamed from: -deprecated_query, reason: not valid java name */
    public final String m2123deprecated_query() {
        return query();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "queryParameterNames", imports = {}))
    @JvmName(name = "-deprecated_queryParameterNames")
    @NotNull
    /* renamed from: -deprecated_queryParameterNames, reason: not valid java name */
    public final Set<String> m2124deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "querySize", imports = {}))
    @JvmName(name = "-deprecated_querySize")
    /* renamed from: -deprecated_querySize, reason: not valid java name */
    public final int m2125deprecated_querySize() {
        return querySize();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = ZPlanPublishSource.FROM_SCHEME, imports = {}))
    @JvmName(name = "-deprecated_scheme")
    @NotNull
    /* renamed from: -deprecated_scheme, reason: not valid java name and from getter */
    public final String getScheme() {
        return this.scheme;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to toUri()", replaceWith = @ReplaceWith(expression = "toUri()", imports = {}))
    @JvmName(name = "-deprecated_uri")
    @NotNull
    /* renamed from: -deprecated_uri, reason: not valid java name */
    public final URI m2127deprecated_uri() {
        return uri();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to toUrl()", replaceWith = @ReplaceWith(expression = "toUrl()", imports = {}))
    @JvmName(name = "-deprecated_url")
    @NotNull
    /* renamed from: -deprecated_url, reason: not valid java name */
    public final URL m2128deprecated_url() {
        return url();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "username", imports = {}))
    @JvmName(name = "-deprecated_username")
    @NotNull
    /* renamed from: -deprecated_username, reason: not valid java name and from getter */
    public final String getUsername() {
        return this.username;
    }

    @JvmName(name = "encodedFragment")
    @Nullable
    public final String encodedFragment() {
        int indexOf$default;
        if (this.fragment != null) {
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) this.url, '#', 0, false, 6, (Object) null);
            int i3 = indexOf$default + 1;
            String str = this.url;
            if (str != null) {
                String substring = str.substring(i3);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                return substring;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        return null;
    }

    @JvmName(name = "encodedPassword")
    @NotNull
    public final String encodedPassword() {
        boolean z16;
        int indexOf$default;
        int indexOf$default2;
        if (this.password.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) this.url, ':', this.scheme.length() + 3, false, 4, (Object) null);
            int i3 = indexOf$default + 1;
            indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) this.url, '@', 0, false, 6, (Object) null);
            String str = this.url;
            if (str != null) {
                String substring = str.substring(i3, indexOf$default2);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                return substring;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        return "";
    }

    @JvmName(name = "encodedPath")
    @NotNull
    public final String encodedPath() {
        int indexOf$default;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) this.url, '/', this.scheme.length() + 3, false, 4, (Object) null);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, "?#", indexOf$default, str.length());
        String str2 = this.url;
        if (str2 != null) {
            String substring = str2.substring(indexOf$default, delimiterOffset);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            return substring;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @JvmName(name = "encodedPathSegments")
    @NotNull
    public final List<String> encodedPathSegments() {
        int indexOf$default;
        indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) this.url, '/', this.scheme.length() + 3, false, 4, (Object) null);
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, "?#", indexOf$default, str.length());
        ArrayList arrayList = new ArrayList();
        while (indexOf$default < delimiterOffset) {
            int i3 = indexOf$default + 1;
            int delimiterOffset2 = Util.delimiterOffset(this.url, '/', i3, delimiterOffset);
            String str2 = this.url;
            if (str2 != null) {
                String substring = str2.substring(i3, delimiterOffset2);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                arrayList.add(substring);
                indexOf$default = delimiterOffset2;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        }
        return arrayList;
    }

    @JvmName(name = "encodedQuery")
    @Nullable
    public final String encodedQuery() {
        int indexOf$default;
        if (this.queryNamesAndValues != null) {
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) this.url, '?', 0, false, 6, (Object) null);
            int i3 = indexOf$default + 1;
            String str = this.url;
            int delimiterOffset = Util.delimiterOffset(str, '#', i3, str.length());
            String str2 = this.url;
            if (str2 != null) {
                String substring = str2.substring(i3, delimiterOffset);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                return substring;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        return null;
    }

    @JvmName(name = "encodedUsername")
    @NotNull
    public final String encodedUsername() {
        boolean z16;
        if (this.username.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        int delimiterOffset = Util.delimiterOffset(str, ":@", length, str.length());
        String str2 = this.url;
        if (str2 != null) {
            String substring = str2.substring(length, delimiterOffset);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            return substring;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public boolean equals(@Nullable Object other) {
        if ((other instanceof HttpUrl) && Intrinsics.areEqual(((HttpUrl) other).url, this.url)) {
            return true;
        }
        return false;
    }

    @JvmName(name = "fragment")
    @Nullable
    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    @JvmName(name = "host")
    @NotNull
    public final String host() {
        return this.host;
    }

    /* renamed from: isHttps, reason: from getter */
    public final boolean getIsHttps() {
        return this.isHttps;
    }

    @NotNull
    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != INSTANCE.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    @JvmName(name = NotificationActivity.PASSWORD)
    @NotNull
    public final String password() {
        return this.password;
    }

    @JvmName(name = "pathSegments")
    @NotNull
    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    @JvmName(name = "pathSize")
    public final int pathSize() {
        return this.pathSegments.size();
    }

    @JvmName(name = "port")
    public final int port() {
        return this.port;
    }

    @JvmName(name = "query")
    @Nullable
    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        INSTANCE.toQueryString$okhttp(this.queryNamesAndValues, sb5);
        return sb5.toString();
    }

    @Nullable
    public final String queryParameter(@NotNull String name) {
        IntRange until;
        IntProgression step;
        Intrinsics.checkNotNullParameter(name, "name");
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            until = RangesKt___RangesKt.until(0, list.size());
            step = RangesKt___RangesKt.step(until, 2);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if (step2 < 0 ? first >= last : first <= last) {
                while (!Intrinsics.areEqual(name, this.queryNamesAndValues.get(first))) {
                    if (first != last) {
                        first += step2;
                    }
                }
                return this.queryNamesAndValues.get(first + 1);
            }
            return null;
        }
        return null;
    }

    @NotNull
    public final String queryParameterName(int index) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            String str = list.get(index * 2);
            Intrinsics.checkNotNull(str);
            return str;
        }
        throw new IndexOutOfBoundsException();
    }

    @JvmName(name = "queryParameterNames")
    @NotNull
    public final Set<String> queryParameterNames() {
        IntRange until;
        IntProgression step;
        Set<String> emptySet;
        if (this.queryNamesAndValues == null) {
            emptySet = SetsKt__SetsKt.emptySet();
            return emptySet;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        until = RangesKt___RangesKt.until(0, this.queryNamesAndValues.size());
        step = RangesKt___RangesKt.step(until, 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if (step2 < 0 ? first >= last : first <= last) {
            while (true) {
                String str = this.queryNamesAndValues.get(first);
                Intrinsics.checkNotNull(str);
                linkedHashSet.add(str);
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        Set<String> unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "Collections.unmodifiableSet(result)");
        return unmodifiableSet;
    }

    @Nullable
    public final String queryParameterValue(int index) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((index * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    @NotNull
    public final List<String> queryParameterValues(@NotNull String name) {
        IntRange until;
        IntProgression step;
        List<String> emptyList;
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.queryNamesAndValues == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        until = RangesKt___RangesKt.until(0, this.queryNamesAndValues.size());
        step = RangesKt___RangesKt.step(until, 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if (step2 < 0 ? first >= last : first <= last) {
            while (true) {
                if (Intrinsics.areEqual(name, this.queryNamesAndValues.get(first))) {
                    arrayList.add(this.queryNamesAndValues.get(first + 1));
                }
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "Collections.unmodifiableList(result)");
        return unmodifiableList;
    }

    @JvmName(name = "querySize")
    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    @NotNull
    public final String redact() {
        Builder newBuilder = newBuilder("/...");
        Intrinsics.checkNotNull(newBuilder);
        return newBuilder.username("").password("").build().getUrl();
    }

    @Nullable
    public final HttpUrl resolve(@NotNull String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        Builder newBuilder = newBuilder(link);
        if (newBuilder != null) {
            return newBuilder.build();
        }
        return null;
    }

    @JvmName(name = ZPlanPublishSource.FROM_SCHEME)
    @NotNull
    public final String scheme() {
        return this.scheme;
    }

    @NotNull
    /* renamed from: toString, reason: from getter */
    public String getUrl() {
        return this.url;
    }

    @Nullable
    public final String topPrivateDomain() {
        if (Util.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.INSTANCE.get().getEffectiveTldPlusOne(this.host);
    }

    @JvmName(name = LayoutAttrDefine.CLICK_URI)
    @NotNull
    public final URI uri() {
        String builder = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(builder);
        } catch (URISyntaxException e16) {
            try {
                URI create = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(builder, ""));
                Intrinsics.checkNotNullExpressionValue(create, "try {\n        val stripp\u2026e) // Unexpected!\n      }");
                return create;
            } catch (Exception unused) {
                throw new RuntimeException(e16);
            }
        }
    }

    @JvmName(name = "url")
    @NotNull
    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e16) {
            throw new RuntimeException(e16);
        }
    }

    @JvmName(name = "username")
    @NotNull
    public final String username() {
        return this.username;
    }

    @JvmStatic
    @JvmName(name = "get")
    @Nullable
    public static final HttpUrl get(@NotNull URI uri) {
        return INSTANCE.get(uri);
    }

    @JvmStatic
    @JvmName(name = "get")
    @Nullable
    public static final HttpUrl get(@NotNull URL url) {
        return INSTANCE.get(url);
    }

    @Nullable
    public final Builder newBuilder(@NotNull String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        try {
            return new Builder().parse$okhttp(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
