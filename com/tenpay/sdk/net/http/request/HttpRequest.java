package com.tenpay.sdk.net.http.request;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qqmini.sdk.browser.BrowserPlugin;
import com.tenpay.sdk.net.core.request.NetRequest;
import com.tenpay.sdk.net.core.statistic.StatisticHandler;
import com.tenpay.sdk.net.core.statistic.StatisticInfo;
import com.tenpay.sdk.net.core.task.base.Priority;
import com.tenpay.sdk.net.http.common.HttpConst;
import com.tenpay.sdk.net.http.result.HttpResult;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.FormBody;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BY\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0002\u0010\u000eJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010&\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002R\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006'"}, d2 = {"Lcom/tenpay/sdk/net/http/request/HttpRequest;", "Lcom/tenpay/sdk/net/core/request/NetRequest;", "Lcom/tenpay/sdk/net/http/result/HttpResult;", "originUrl", "", "headerMap", "", "paramMap", "", "methodType", "Lcom/tenpay/sdk/net/http/common/HttpConst$MethodType;", "tagList", "", "", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Lcom/tenpay/sdk/net/http/common/HttpConst$MethodType;Ljava/util/List;)V", "getOriginUrl", "()Ljava/lang/String;", "requestStatistic", "Lcom/tenpay/sdk/net/core/statistic/StatisticHandler;", "getRequestStatistic", "()Lcom/tenpay/sdk/net/core/statistic/StatisticHandler;", "setRequestStatistic", "(Lcom/tenpay/sdk/net/core/statistic/StatisticHandler;)V", BrowserPlugin.KEY_REQUEST_URL, "getRequestUrl", "setRequestUrl", "(Ljava/lang/String;)V", "getTagList", "()Ljava/util/List;", "buildRequest", "Lokhttp3/Request;", "statisticInfo", "Lcom/tenpay/sdk/net/core/statistic/StatisticInfo;", "setGetRequest", "", "builder", "Lokhttp3/Request$Builder;", "setMethodType", "setPostRequest", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public class HttpRequest extends NetRequest<HttpResult> {

    @Nullable
    private final Map<String, String> headerMap;

    @NotNull
    private final HttpConst.MethodType methodType;

    @NotNull
    private final String originUrl;

    @Nullable
    private StatisticHandler requestStatistic;

    @NotNull
    private String requestUrl;

    @NotNull
    private final List<Object> tagList;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HttpConst.MethodType.values().length];
            try {
                iArr[HttpConst.MethodType.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HttpConst.MethodType.POST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ HttpRequest(String str, Map map, Map map2, HttpConst.MethodType methodType, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : map, (i3 & 4) != 0 ? null : map2, (i3 & 8) != 0 ? HttpConst.MethodType.GET : methodType, (i3 & 16) != 0 ? new ArrayList() : list);
    }

    private final void setGetRequest(Request.Builder builder) {
        boolean contains$default;
        String joinToString$default;
        builder.get();
        if (getParamMap() != null) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) this.requestUrl, '?', false, 2, (Object) null);
            if (!contains$default) {
                this.requestUrl = this.requestUrl + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
            }
            String str = this.requestUrl;
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(getParamMap().entrySet(), ContainerUtils.FIELD_DELIMITER, null, null, 0, null, new Function1<Map.Entry<String, String>, CharSequence>() { // from class: com.tenpay.sdk.net.http.request.HttpRequest$setGetRequest$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final CharSequence invoke(@NotNull Map.Entry<String, String> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ((Object) it.getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + ((Object) it.getValue());
                }
            }, 30, null);
            this.requestUrl = str + joinToString$default;
        }
    }

    private final void setMethodType(Request.Builder builder) {
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.methodType.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                setPostRequest(builder);
                return;
            }
            return;
        }
        setGetRequest(builder);
    }

    private final void setPostRequest(Request.Builder builder) {
        FormBody.Builder builder2 = new FormBody.Builder(null, 1, 0 == true ? 1 : 0);
        Map<String, String> paramMap = getParamMap();
        if (paramMap != null) {
            for (Map.Entry<String, String> entry : paramMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                builder2.add(key, value);
            }
        }
        builder.post(builder2.build());
    }

    @NotNull
    public final Request buildRequest(@NotNull StatisticInfo statisticInfo) {
        Intrinsics.checkNotNullParameter(statisticInfo, "statisticInfo");
        Request.Builder builder = new Request.Builder();
        setMethodType(builder);
        builder.url(this.requestUrl);
        Map<String, String> map = this.headerMap;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builder.header(entry.getKey(), entry.getValue());
            }
        }
        for (Object obj : this.tagList) {
            builder.tag(obj.getClass(), obj);
        }
        builder.tag(StatisticInfo.class, statisticInfo);
        return builder.build();
    }

    @NotNull
    public final String getOriginUrl() {
        return this.originUrl;
    }

    @Nullable
    public final StatisticHandler getRequestStatistic() {
        return this.requestStatistic;
    }

    @NotNull
    public final String getRequestUrl() {
        return this.requestUrl;
    }

    @NotNull
    public final List<Object> getTagList() {
        return this.tagList;
    }

    public final void setRequestStatistic(@Nullable StatisticHandler statisticHandler) {
        this.requestStatistic = statisticHandler;
    }

    public final void setRequestUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.requestUrl = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRequest(@NotNull String originUrl, @Nullable Map<String, String> map, @Nullable Map<String, String> map2, @NotNull HttpConst.MethodType methodType, @NotNull List<Object> tagList) {
        super(map2, Priority.NORMAL_PRIORITY, null, 4, null);
        Intrinsics.checkNotNullParameter(originUrl, "originUrl");
        Intrinsics.checkNotNullParameter(methodType, "methodType");
        Intrinsics.checkNotNullParameter(tagList, "tagList");
        this.originUrl = originUrl;
        this.headerMap = map;
        this.methodType = methodType;
        this.tagList = tagList;
        this.requestUrl = originUrl;
    }
}
