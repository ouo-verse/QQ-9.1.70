package com.tencent.mobileqq.search.searchdetail.util;

import android.content.Context;
import android.net.Uri;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.icgame.data.login.nano.LoginBusinessData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.searchdetail.SearchDetailFragment;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.moredetail.WXMinGameMoreDetailFragment;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.af;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.studymode.api.IStudyModeApi;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tH\u0002J\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002JL\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\t2\b\b\u0002\u0010\u0016\u001a\u00020\u00022\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0017J\u0016\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/util/k;", "", "", "url", "Lcom/tencent/mobileqq/search/searchdetail/SearchDetailFragment$Companion$a;", "c", "param", "a", "searchMode", "", "userSource", "b", "default", tl.h.F, "Landroid/content/Context;", "context", "", "d", "f", "textContent", QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, "currentPageMode", "isSingle", "Lkotlin/Function0;", "searchAction", "e", "g", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f284749a = new k();

    k() {
    }

    private final String a(String param) {
        boolean isBlank;
        String replace$default;
        isBlank = StringsKt__StringsJVMKt.isBlank(param);
        if (!isBlank) {
            try {
                replace$default = StringsKt__StringsJVMKt.replace$default(param, Marker.ANY_NON_NULL_MARKER, "%2B", false, 4, (Object) null);
                String decode = URLDecoder.decode(replace$default, "UTF-8");
                Intrinsics.checkNotNullExpressionValue(decode, "{\n            URLDecoder\u2026%2B\"), \"UTF-8\")\n        }");
                return decode;
            } catch (UnsupportedEncodingException | IllegalArgumentException unused) {
                return param;
            }
        }
        return param;
    }

    private final int b(String searchMode, int userSource) {
        int h16 = h(searchMode, 0);
        if (h16 == 0) {
            if (userSource == 19) {
                return SearchDetailFragment.Companion.PageMode.MODE_VOICE_AI_SEARCH.getValue();
            }
            return SearchDetailFragment.Companion.PageMode.MODE_NORMAL.getValue();
        }
        return h16;
    }

    private final SearchDetailFragment.Companion.NetSearchPageParam c(String url) {
        String replace$default;
        boolean z16;
        boolean z17;
        String str;
        String str2;
        String str3;
        int i3;
        long j3;
        long currentTimeMillis;
        int i16 = 0;
        replace$default = StringsKt__StringsJVMKt.replace$default(url, Marker.ANY_NON_NULL_MARKER, "%2B", false, 4, (Object) null);
        Uri parse = Uri.parse(replace$default);
        String queryParameter = parse.getQueryParameter("sessionId");
        if (queryParameter != null && queryParameter.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        String str4 = "";
        if (z16) {
            String lowerCase = "sessionId".toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
            String queryParameter2 = parse.getQueryParameter(lowerCase);
            if (queryParameter2 == null) {
                queryParameter = "";
            } else {
                queryParameter = queryParameter2;
            }
        }
        String str5 = queryParameter;
        String queryParameter3 = parse.getQueryParameter("keyword");
        if (queryParameter3 == null) {
            queryParameter3 = "";
        }
        String queryParameter4 = parse.getQueryParameter("hint");
        if (queryParameter4 == null) {
            queryParameter4 = "";
        }
        String queryParameter5 = parse.getQueryParameter(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE);
        if (queryParameter5 != null && queryParameter5.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            String lowerCase2 = QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
            queryParameter5 = parse.getQueryParameter(lowerCase2);
        }
        String queryParameter6 = parse.getQueryParameter("user_source");
        String queryParameter7 = parse.getQueryParameter("tab_mask");
        String queryParameter8 = parse.getQueryParameter("hide_tab");
        if (queryParameter8 == null) {
            queryParameter8 = "";
        }
        String queryParameter9 = parse.getQueryParameter("start_search_stamp");
        String queryParameter10 = parse.getQueryParameter("func_payload");
        if (queryParameter10 == null) {
            str = "";
        } else {
            str = queryParameter10;
        }
        String queryParameter11 = parse.getQueryParameter("sug_trace_id");
        if (queryParameter11 == null) {
            str2 = "";
        } else {
            str2 = queryParameter11;
        }
        String queryParameter12 = parse.getQueryParameter("wx_search_id");
        if (queryParameter12 == null) {
            str3 = "";
        } else {
            str3 = queryParameter12;
        }
        String queryParameter13 = parse.getQueryParameter("voice_ai_mode");
        if (queryParameter13 == null) {
            queryParameter13 = "";
        }
        try {
            String a16 = a(queryParameter3);
            String a17 = a(queryParameter4);
            if (queryParameter5 != null) {
                i3 = Integer.parseInt(queryParameter5);
            } else {
                i3 = 0;
            }
            if (queryParameter6 != null) {
                str4 = queryParameter6;
            }
            int h16 = h(str4, 0);
            boolean areEqual = Intrinsics.areEqual(queryParameter8, "1");
            if (queryParameter7 != null) {
                j3 = Long.parseLong(queryParameter7);
            } else {
                j3 = 1;
            }
            long j16 = j3;
            if (queryParameter9 != null) {
                currentTimeMillis = Long.parseLong(queryParameter9);
            } else {
                currentTimeMillis = System.currentTimeMillis();
            }
            long j17 = currentTimeMillis;
            if (queryParameter6 != null) {
                i16 = Integer.parseInt(queryParameter6);
            }
            return new SearchDetailFragment.Companion.NetSearchPageParam(a16, a17, i3, h16, areEqual, j16, str5, j17, str, str2, str3, b(queryParameter13, i16));
        } catch (NumberFormatException e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str6 = "getPageParamFromUrl error url=" + url + " " + e16;
            if (str6 instanceof String) {
                bVar.a().add(str6);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QQSearch.NetDetail.SearchDetailJumpUtils", 1, (String) it.next(), null);
            }
            return null;
        }
    }

    private final int h(String searchMode, int r75) {
        try {
            return Integer.parseInt(searchMode);
        } catch (NumberFormatException e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "launch error " + e16;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QQSearch.NetDetail.SearchDetailJumpUtils", 1, (String) it.next(), null);
            }
            return r75;
        }
    }

    public final void d(@NotNull Context context, @NotNull String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        if (((IStudyModeApi) QRoute.api(IStudyModeApi.class)).isBanSearchNetInStudyMode()) {
            af afVar = af.f284993a;
            QLog.w("QS.QQSearch.NetDetail.SearchDetailJumpUtils", 1, "launchByLink can't open net search in study mode url=" + url, null);
            com.tencent.mobileqq.guild.util.qqui.g.c(0, R.string.f214315sk);
            return;
        }
        af afVar2 = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.SearchDetailJumpUtils", 1, "jump2NetSearchPage url=" + url, null);
        String queryParameter = Uri.parse(url).getQueryParameter("single");
        if (queryParameter == null) {
            queryParameter = "";
        }
        SearchDetailFragment.Companion.NetSearchPageParam c16 = c(url);
        if (c16 != null) {
            SearchDetailFragment.INSTANCE.d(context, c16, queryParameter);
        }
    }

    public final void e(@NotNull Context context, @NotNull String textContent, int querySource, int userSource, int currentPageMode, @NotNull String isSingle, @Nullable Function0<Unit> searchAction) {
        SearchDetailFragment.Companion.NetSearchPageParam netSearchPageParam;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(textContent, "textContent");
        Intrinsics.checkNotNullParameter(isSingle, "isSingle");
        SearchDetailFragment.Companion.NetSearchPageParam netSearchPageParam2 = new SearchDetailFragment.Companion.NetSearchPageParam(textContent, null, querySource, userSource, false, 0L, null, 0L, null, null, null, 0, LoginBusinessData.MiddlePlatformError, null);
        boolean c16 = ap2.a.f26672a.c();
        if (c16 && currentPageMode == SearchDetailFragment.Companion.PageMode.MODE_VOICE_AI_SEARCH.getValue()) {
            if (searchAction != null) {
                searchAction.invoke();
            }
            af afVar = af.f284993a;
            QLog.i("QS.QQSearch.NetDetail.SearchDetailJumpUtils", 1, "launchToAIModeSearchDetailPage doSearchAction currentPageMode=" + currentPageMode, null);
            return;
        }
        if (c16) {
            netSearchPageParam = netSearchPageParam2;
            netSearchPageParam.o(SearchDetailFragment.Companion.PageMode.MODE_VOICE_AI_SEARCH.getValue());
        } else {
            netSearchPageParam = netSearchPageParam2;
            SearchDetailFragment.Companion.PageMode pageMode = SearchDetailFragment.Companion.PageMode.MODE_NORMAL_AI;
            if (currentPageMode != pageMode.getValue() && currentPageMode != SearchDetailFragment.Companion.PageMode.MODE_NORMAL.getValue()) {
                netSearchPageParam.o(pageMode.getValue());
            } else {
                if (searchAction != null) {
                    searchAction.invoke();
                }
                af afVar2 = af.f284993a;
                QLog.i("QS.QQSearch.NetDetail.SearchDetailJumpUtils", 1, "launchToAIModeSearchDetailPage doSearchAction currentPageMode=" + currentPageMode, null);
                return;
            }
        }
        af afVar3 = af.f284993a;
        QLog.i("QS.QQSearch.NetDetail.SearchDetailJumpUtils", 1, "launchToAIModeSearchDetailPage params=" + netSearchPageParam, null);
        if (!SearchDetailFragment.Companion.PageMode.INSTANCE.a(netSearchPageParam.getPageMode())) {
            SearchUtils.k1(netSearchPageParam.getKeyword(), String.valueOf(netSearchPageParam.getQuerySource()), String.valueOf(netSearchPageParam.getUserSource()), String.valueOf(netSearchPageParam.getPageMode()));
        }
        SearchDetailFragment.INSTANCE.d(context, netSearchPageParam, isSingle);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x008e, code lost:
    
        if (r2 != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f(@NotNull Context context, @NotNull String url) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        boolean z16 = false;
        if (((IStudyModeApi) QRoute.api(IStudyModeApi.class)).isBanSearchNetInStudyMode()) {
            af afVar = af.f284993a;
            QLog.w("QS.QQSearch.NetDetail.SearchDetailJumpUtils", 1, "launchToAIModeSearchDetailPageByLink can't open net search in study mode url=" + url, null);
            com.tencent.mobileqq.guild.util.qqui.g.c(0, R.string.f214315sk);
            return;
        }
        String queryParameter = Uri.parse(url).getQueryParameter("PARAM_VOICE_AI_SEARCH_MODE");
        SearchDetailFragment.Companion.NetSearchPageParam c16 = c(url);
        if (c16 == null) {
            af afVar2 = af.f284993a;
            QLog.e("QS.QQSearch.NetDetail.SearchDetailJumpUtils", 1, "launchToAIModeSearchDetailPageByLink param error url=" + url, (Throwable) null);
            return;
        }
        if (queryParameter != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(queryParameter);
        }
        z16 = true;
        if (z16) {
            if (ap2.a.f26672a.c()) {
                queryParameter = String.valueOf(SearchDetailFragment.Companion.PageMode.MODE_VOICE_AI_SEARCH.getValue());
            } else {
                queryParameter = String.valueOf(SearchDetailFragment.Companion.PageMode.MODE_NORMAL_AI.getValue());
            }
            url = Uri.parse(url).buildUpon().appendQueryParameter("voice_ai_mode", queryParameter).toString();
            Intrinsics.checkNotNullExpressionValue(url, "parse(url).buildUpon()\n \u2026              .toString()");
        }
        d(context, url);
        if (!Intrinsics.areEqual(queryParameter, String.valueOf(SearchDetailFragment.Companion.PageMode.MODE_VOICE_AI_SEARCH.getValue()))) {
            SearchUtils.j1(c16.getKeyword(), url);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004c A[Catch: Exception -> 0x0083, TryCatch #0 {Exception -> 0x0083, blocks: (B:3:0x0010, B:7:0x002f, B:10:0x0039, B:12:0x0040, B:17:0x004c, B:18:0x005a, B:21:0x006e, B:24:0x0076), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(@NotNull Context context, @NotNull String url) {
        String replace$default;
        boolean z16;
        String queryParameter;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            replace$default = StringsKt__StringsJVMKt.replace$default(url, Marker.ANY_NON_NULL_MARKER, "%2B", false, 4, (Object) null);
            Uri parse = Uri.parse(replace$default);
            String queryParameter2 = parse.getQueryParameter("keyword");
            String str = "";
            if (queryParameter2 == null) {
                queryParameter2 = "";
            }
            String queryParameter3 = parse.getQueryParameter("hint");
            if (queryParameter3 == null) {
                queryParameter3 = "";
            }
            String queryParameter4 = parse.getQueryParameter(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE);
            if (queryParameter4 != null && queryParameter4.length() != 0) {
                z16 = false;
                if (z16) {
                    String lowerCase = QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE.toLowerCase();
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                    queryParameter4 = parse.getQueryParameter(lowerCase);
                }
                queryParameter = parse.getQueryParameter("user_source");
                WXMinGameMoreDetailFragment.Companion companion = WXMinGameMoreDetailFragment.INSTANCE;
                String a16 = a(queryParameter2);
                String a17 = a(queryParameter3);
                if (queryParameter4 == null) {
                    queryParameter4 = "";
                }
                int h16 = h(queryParameter4, 0);
                if (queryParameter == null) {
                    str = queryParameter;
                }
                companion.b(context, a16, a17, h16, h(str, 0), url);
            }
            z16 = true;
            if (z16) {
            }
            queryParameter = parse.getQueryParameter("user_source");
            WXMinGameMoreDetailFragment.Companion companion2 = WXMinGameMoreDetailFragment.INSTANCE;
            String a162 = a(queryParameter2);
            String a172 = a(queryParameter3);
            if (queryParameter4 == null) {
            }
            int h162 = h(queryParameter4, 0);
            if (queryParameter == null) {
            }
            companion2.b(context, a162, a172, h162, h(str, 0), url);
        } catch (Exception e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "openMinGameSearchPage error " + e16;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("QQSearch.NetDetail.SearchDetailJumpUtils", 1, (String) it.next(), null);
            }
        }
    }
}
