package com.tencent.mobileqq.search.api;

import android.content.Context;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.text.m;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.regex.Pattern;
import kn2.HashTagSearchLinkUniteConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019J\u001a\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH&J(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H&J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&J\b\u0010\u0017\u001a\u00020\u0016H&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/search/api/IHashTagSearchLinkApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "uin", "", "chatType", "", "switchOn", "Lkn2/a;", "uniteConfig", "Landroid/content/Context;", "context", "", "keywords", QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "userSource", "", "routeSearchLinkPage", "", SemanticAttributes.DbCassandraConsistencyLevelValues.ANY, "Lcom/tencent/mobileqq/text/m;", "grabHashTagLinkParams", "Ljava/util/regex/Pattern;", "hashtagLinkPattern", "Companion", "a", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface IHashTagSearchLinkApi extends QRouteApi {

    @JvmField
    @NotNull
    public static final String GOOD_HASHTAG_CHAR;

    @JvmField
    @NotNull
    public static final Pattern HASHTAG_LINK_PATTERN;

    /* renamed from: g, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final IHashTagSearchLinkApi f282735g;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f282736a;

    @JvmField
    public static final char FULL_WIDTH_HASHTAG = '\uff03';

    @JvmField
    public static final char HALF_WIDTH_HASHTAG = '#';

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0001R\u0017\u0010\u0006\u001a\u00020\u00058\u0006X\u0087D\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0001R\u0017\u0010\b\u001a\u00020\u00028\u0006X\u0087D\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u0001R\u0017\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0001R\u0017\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0001\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/search/api/IHashTagSearchLinkApi$a;", "", "", "FULL_WIDTH_HASHTAG", BdhLogUtil.LogTag.Tag_Conn, "", "GOOD_HASHTAG_CHAR", "Ljava/lang/String;", "HALF_WIDTH_HASHTAG", "Ljava/util/regex/Pattern;", "HASHTAG_LINK_PATTERN", "Ljava/util/regex/Pattern;", "Lcom/tencent/mobileqq/search/api/IHashTagSearchLinkApi;", "g", "Lcom/tencent/mobileqq/search/api/IHashTagSearchLinkApi;", "<init>", "()V", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.api.IHashTagSearchLinkApi$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f282736a = new Companion();

        Companion() {
        }
    }

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append('\uff03');
        sb5.append('#');
        GOOD_HASHTAG_CHAR = sb5.toString();
        QRouteApi api = QRoute.api(IHashTagSearchLinkApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IHashTagSearchLinkApi::class.java)");
        IHashTagSearchLinkApi iHashTagSearchLinkApi = (IHashTagSearchLinkApi) api;
        f282735g = iHashTagSearchLinkApi;
        HASHTAG_LINK_PATTERN = iHashTagSearchLinkApi.hashtagLinkPattern();
    }

    @NotNull
    m grabHashTagLinkParams(@Nullable Object any);

    @NotNull
    Pattern hashtagLinkPattern();

    void routeSearchLinkPage(@NotNull Context context, @NotNull String keywords, int querySource, int userSource);

    boolean switchOn(long uin, int chatType);

    @NotNull
    HashTagSearchLinkUniteConfig uniteConfig();
}
