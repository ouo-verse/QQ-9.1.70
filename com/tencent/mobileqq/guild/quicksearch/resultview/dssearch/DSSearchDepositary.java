package com.tencent.mobileqq.guild.quicksearch.resultview.dssearch;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDetailReportUtil;
import com.tencent.mobileqq.guild.aisearch.SSESearchConfig;
import com.tencent.mobileqq.guild.nt.misc.api.IUploadApi;
import com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.q;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import com.tencent.util.URLUtil;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b'\u0010(J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J \u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J \u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\u0005\u001a\u00020\u0003J\"\u0010\u0018\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00170\u00160\u00022\u0006\u0010\u0005\u001a\u00020\u0003R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0017\u0010\"\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/DSSearchDepositary;", "", "Lkotlinx/coroutines/flow/Flow;", "", "k", "searchKey", "psKey", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/q;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "url", "key", "", "value", "i", "skey", DomainData.DOMAIN_NAME, "uin", "pSKey", IPublicAccountDetailReportUtil.KEY_SEARCH, "j", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Pair;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/s;", "l", "Lcom/tencent/mobileqq/guild/aisearch/aa;", "a", "Lcom/tencent/mobileqq/guild/aisearch/aa;", "sseSearchConfig", "Lokhttp3/OkHttpClient;", "b", "Lokhttp3/OkHttpClient;", "o", "()Lokhttp3/OkHttpClient;", "client", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/ProcessState;", "c", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/ProcessState;", "processState", "<init>", "(Lcom/tencent/mobileqq/guild/aisearch/aa;)V", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class DSSearchDepositary {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SSESearchConfig sseSearchConfig;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final OkHttpClient client;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ProcessState processState;

    public DSSearchDepositary(@NotNull SSESearchConfig sseSearchConfig) {
        Intrinsics.checkNotNullParameter(sseSearchConfig, "sseSearchConfig");
        this.sseSearchConfig = sseSearchConfig;
        this.client = new OkHttpClient.Builder().connectTimeout(45000L, TimeUnit.MILLISECONDS).build();
        this.processState = ProcessState.IDLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String i(String url, String key, int value) {
        String str;
        URI uri = new URI(url);
        if (uri.getQuery() == null) {
            str = key + ContainerUtils.KEY_VALUE_DELIMITER + value;
        } else {
            str = uri.getQuery() + ContainerUtils.FIELD_DELIMITER + key + ContainerUtils.KEY_VALUE_DELIMITER + value;
        }
        String uri2 = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), str, uri.getFragment()).toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "URI(\n            uri.sch\u2026ment\n        ).toString()");
        return uri2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String j(String uin, String pSKey, String sKey) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new IUploadApi.a("uin", uin));
        arrayList.add(new IUploadApi.a("skey", sKey));
        arrayList.add(new IUploadApi.a(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_P_UIN, uin));
        arrayList.add(new IUploadApi.a("p_skey", pSKey));
        StringBuilder sb5 = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            IUploadApi.a aVar = (IUploadApi.a) it.next();
            String encodeUrl = URLUtil.encodeUrl(aVar.f230929a);
            String encodeUrl2 = URLUtil.encodeUrl(aVar.f230930b);
            sb5.append(" " + encodeUrl + ContainerUtils.KEY_VALUE_DELIMITER);
            StringBuilder sb6 = new StringBuilder();
            sb6.append(encodeUrl2);
            sb6.append(";");
            sb5.append(sb6.toString());
        }
        String sb7 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb7, "sb.toString()");
        return sb7;
    }

    private final Flow<String> k() {
        return FlowKt.callbackFlow(new DSSearchDepositary$fetchPskey$1(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int n(String skey) {
        if (TextUtils.isEmpty(skey)) {
            return 0;
        }
        int length = skey.length();
        int i3 = 5381;
        for (int i16 = 0; i16 < length; i16++) {
            i3 += (i3 << 5) + skey.charAt(i16);
        }
        return Integer.MAX_VALUE & i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String p(String searchKey) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return new ReqBody(true, com.tencent.mobileqq.perf.upload.cos.a.f258277a.a(String.valueOf(currentTimeMillis), this.sseSearchConfig.getSign()), currentTimeMillis, searchKey).toJson();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Flow<q> q(String searchKey, String psKey) {
        return FlowKt.callbackFlow(new DSSearchDepositary$startSseRequest$1(this, searchKey, psKey, null));
    }

    @NotNull
    public final Flow<Pair<q, SearchResponse>> l(@NotNull String searchKey) {
        Intrinsics.checkNotNullParameter(searchKey, "searchKey");
        return FlowKt.onEach(FlowKt.flowOn(FlowKt.scan(m(searchKey), new Pair(null, new SearchResponse(null, null, null, 0L, null, 31, null)), new DSSearchDepositary$fetchResponseResult$1(null)), Dispatchers.getUnconfined()), new DSSearchDepositary$fetchResponseResult$2(null));
    }

    @NotNull
    public final Flow<q> m(@NotNull String searchKey) {
        Intrinsics.checkNotNullParameter(searchKey, "searchKey");
        return FlowKt.flowOn(com.tencent.mobileqq.guild.base.extension.FlowKt.c(FlowKt.flatMapConcat(k(), new DSSearchDepositary$fetchResult$1(this, searchKey, null)), 45000L, new Function0<Flow<? extends q>>() { // from class: com.tencent.mobileqq.guild.quicksearch.resultview.dssearch.DSSearchDepositary$fetchResult$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Flow<? extends q> invoke() {
                return FlowKt.flowOf(new q.Failed("timeout"));
            }
        }), Dispatchers.getUnconfined());
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final OkHttpClient getClient() {
        return this.client;
    }
}
